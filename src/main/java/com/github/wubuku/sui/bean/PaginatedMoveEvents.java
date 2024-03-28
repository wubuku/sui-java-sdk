package com.github.wubuku.sui.bean;

import java.util.List;

/**
 * @param <F> the type of 'fields' of MoveEvent.
 */
public class PaginatedMoveEvents<F> extends Page<SuiMoveEventEnvelope<F>, EventId> {
    public PaginatedMoveEvents() {
    }

    public PaginatedMoveEvents(List<SuiMoveEventEnvelope<F>> data, EventId nextCursor) {
        super(data, nextCursor);
    }

    @Override
    public String toString() {
        return "PaginatedMoveEvents{" +
                "data=" + getData() +
                ", nextCursor=" + getNextCursor() +
                ", hasNextPage=" + getHasNextPage() +
                '}';
    }
}
