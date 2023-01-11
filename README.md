# Sui Java SDK

This is a [Sui](https://sui.io) Java SDK. 

## How to use

### Maven

Add the following dependency to the project's `pom.xml` file.

```xml
<dependency>
    <groupId>com.github.wubuku</groupId>
    <artifactId>sui-java-sdk</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

Add the following code to maven's `settings.xml` file.

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <servers>
        <server>
            <id>sui-java-sdk-github</id>
            <username>sui-java-sdk-bot</username>
            <password>&#103;hp_3WHxC5s37YYb3KO3Y3Sn7qMv1K2rCy28tWLk</password>
        </server>
    </servers>
</settings>
```

## Examples

### Encode then execute a transaction

```java
public class SuiJsonRpcClientTests {
    static final String SUI_COIN_TYPE = "0x2::sui::SUI";
    
    @Test
    void testExecuteMoveCall_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        String signerAddress = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        TransactionBytes encodeResult = encodeATestMoveCallTransaction(client, signerAddress);
        System.out.println(encodeResult);
        String txBytes = encodeResult.getTxBytes();
        String publicKeyBase64 = "zSg6kZMFM5h7HSQp2xsEU9A+WxiNACmKS7ZBX2y/QU4=";
        String sigScheme = SignatureScheme.ED25519;
        String privateKeyHex = "";//todo fill in the private key here
        SuiExecuteTransactionResponse response = executeTransaction(client, txBytes,
                publicKeyBase64, sigScheme, HexUtils.hexToByteArray(privateKeyHex));
        System.out.println(response);
    }

    private SuiExecuteTransactionResponse executeTransaction(SuiJsonRpcClient client,
                                                             String txBytes,
                                                             String publicKeyBase64, String sigScheme,
                                                             byte[] privateKey) {
        byte[] signature = TransactionUtils.ed25519SignTransactionBytes(privateKey, txBytes);
        String signatureBase64 = Base64.getEncoder().encodeToString(signature);
        String requestType = ExecuteTransactionRequestType.WAIT_FOR_EFFECTS_CERT;

        SuiExecuteTransactionResponse response = client.executeTransaction(
                txBytes,
                sigScheme, signatureBase64,
                publicKeyBase64,
                requestType
        );
        return response;
    }

    private TransactionBytes encodeATestMoveCallTransaction(SuiJsonRpcClient client, String signerAddress) {
        String packageObjectId = "0x2";
        String module = "devnet_nft";
        String function = "mint";
        String[] typeArguments = new String[0];
        SuiJsonValue[] arguments = new SuiJsonValue[]{
                new SuiJsonValue.String_("Test NFT"),
                new SuiJsonValue.String_("..."),
                new SuiJsonValue.String_("http://test.org/test-nft.png")
        };
        long gasBudget = 1000000;
        String gasPayment = selectGasPayment(client, signerAddress, gasBudget);
        TransactionBytes result = client.moveCall(signerAddress,
                packageObjectId, module, function,
                typeArguments, arguments,
                gasPayment, gasBudget, null);
        return result;
    }

    /**
     * Select a gas payment object.
     *
     * @return the gas payment object id
     */
    private String selectGasPayment(SuiJsonRpcClient client, String owner, long gasBudget) {
        CoinPage coinPage = client.getCoins(owner, SUI_COIN_TYPE, null, 100);
        for (Coin c : coinPage.getData()) {
            if (c.getBalance().compareTo(BigInteger.valueOf(gasBudget)) >= 0) {
                return c.getCoinObjectId();
            }
        }
        throw new RuntimeException("No enough gas payment");
    }
}
```

### More examples

See unit tests in directory `src/test/java/com/github/wubuku/sui`.
