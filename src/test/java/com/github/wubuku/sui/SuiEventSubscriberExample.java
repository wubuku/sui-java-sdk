package com.github.wubuku.sui;

import com.github.wubuku.sui.bean.EventType;
import com.github.wubuku.sui.bean.MoveEventNotification;
import com.github.wubuku.sui.bean.SuiEventFilter;
import com.github.wubuku.sui.utils.SuiEventSubscriber;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import org.web3j.protocol.websocket.WebSocketService;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class SuiEventSubscriberExample {

    public static void main(String[] args) throws IOException {
//        SuiEventFilter eventFilter = new SuiEventFilter.All(new SuiEventFilter[]{
//               new SuiEventFilter.EventType(EventType.MOVE_EVENT),
//                new SuiEventFilter.Package("0x2"),
//                new SuiEventFilter.Module("devnet_nft")
//        });
        SuiEventFilter eventFilter = new SuiEventFilter.MoveEventType("0x2::devnet_nft::MintNFTEvent");

        //String serverUrl = "ws://localhost:9000";
        String serverUrl = "wss://fullnode.devnet.sui.io";
        WebSocketService service = new WebSocketService(serverUrl, false);
        AtomicReference<Boolean> isClosed = new AtomicReference<>(false);

        //service.connect();
        service.connect(
                (s) -> {
                },
                (e) -> {
                    System.out.println("error: " + e);
                },
                () -> {
                    System.out.println("close");
                    isClosed.set(true);
                });

        SuiEventSubscriber subscriber = new SuiEventSubscriber(service);

        Flowable<MintNFTEventNotification> moveEventNotificationFlowable
                = subscriber.subscribe(eventFilter, MintNFTEventNotification.class);

        Disposable disposable = moveEventNotificationFlowable
//                .timeout(10, TimeUnit.SECONDS)
//                .doOnError(e -> {
//                    System.out.println("error: " + e);
//                })
                .subscribe(n -> {
                    if (n.getParams() != null && n.getParams().getResult() != null) {
                        System.out.println(n.getParams().getResult().toString());
                    } else {
                        System.out.println(n);
                    }
                });

        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isClosed.get()) {
                disposable.dispose();
                break;
            }
        }

//        for (MintNFTEventNotification notification : moveEventNotificationFlowable.blockingIterable()) {
//            if (notification.getParams() != null && notification.getParams().getResult() != null) {
//                System.out.println(notification.getParams().getResult().toString());
//            } else {
//                System.out.println(notification);
//            }
//        }

        System.out.println("done");
    }

    public static class MintNFTEventNotification extends MoveEventNotification<JsonRpcTests.MintNFTEvent> {

    }

}
