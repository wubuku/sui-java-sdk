package com.github.wubuku.sui.bean;

import org.web3j.protocol.websocket.events.Notification;

/**
 * @param <F> the type of 'fields' of MoveEvent.
 */
public class MoveEventNotification<F> extends Notification<SuiMoveEventEnvelope<F>> {

}
