package com.github.wubuku.sui.utils;

import com.github.wubuku.sui.bean.EventNotification;
import com.github.wubuku.sui.bean.SuiEventFilter;
import io.reactivex.Flowable;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthSubscribe;
import org.web3j.protocol.websocket.events.Notification;

import java.util.Collections;

public class SuiEventSubscriber {

    public static final String SUBSCRIBE_EVENT_METHOD = "sui_subscribeEvent";
    public static final String UNSUBSCRIBE_EVENT_METHOD = "sui_unsubscribeEvent";

    private final Web3jService web3jService;

    public SuiEventSubscriber(Web3jService web3jService) {
        this.web3jService = web3jService;
    }

    public Flowable<EventNotification> eventNotificationFlowable(SuiEventFilter eventFilter) {
        return web3jService.subscribe(
                new Request<>(
                        SUBSCRIBE_EVENT_METHOD,
                        Collections.singletonList(eventFilter),
                        web3jService,
                        EthSubscribe.class),
                UNSUBSCRIBE_EVENT_METHOD,
                EventNotification.class);
    }

    public <T extends Notification<?>> Flowable<T> eventNotificationFlowable(SuiEventFilter eventFilter, Class<T> responseType) {
        return web3jService.subscribe(
                new Request<>(
                        SUBSCRIBE_EVENT_METHOD,
                        Collections.singletonList(eventFilter),
                        web3jService,
                        EthSubscribe.class),
                UNSUBSCRIBE_EVENT_METHOD,
                responseType);
    }


}
