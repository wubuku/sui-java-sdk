package com.github.wubuku.sui.tests;

public class ContractConstants {
    public static final String PRODUCT_MODULE_PRODUCT_ID_GENERATOR = "product::ProductIdGenerator";
    public static final String ORDER_V2_MODULE_ORDER_ID_TABLE = "order_v2::OrderIdTable";
    public static final String DOMAIN_NAME_MODULE_DOMAIN_NAME_ID_TABLE = "domain_name::DomainNameIdTable";
    public static final String DAY_SUMMARY_MODULE_DAY_SUMMARY_ID_TABLE = "day_summary::DaySummaryIdTable";

    public static String[] getIdGeneratorDataObjectTypes(String packageId) {
        return new String[]{
                packageId + "::" + PRODUCT_MODULE_PRODUCT_ID_GENERATOR,
                packageId + "::" + ORDER_V2_MODULE_ORDER_ID_TABLE,
                packageId + "::" + DOMAIN_NAME_MODULE_DOMAIN_NAME_ID_TABLE,
                packageId + "::" + DAY_SUMMARY_MODULE_DAY_SUMMARY_ID_TABLE,
        };
    }
}
