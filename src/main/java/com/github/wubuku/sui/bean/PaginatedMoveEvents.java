package com.github.wubuku.sui.bean;

import java.util.List;

/**
 * @param <F> the type of 'fields' of MoveEvent.
 */
public class PaginatedMoveEvents<F> extends Page<SuiEventEnvelopeForMoveEvent<F>, EventId> {
    public PaginatedMoveEvents() {
    }

    public PaginatedMoveEvents(List<SuiEventEnvelopeForMoveEvent<F>> data, EventId nextCursor) {
        super(data, nextCursor);
    }
}
