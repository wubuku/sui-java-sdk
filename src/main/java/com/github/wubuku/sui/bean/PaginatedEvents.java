package com.github.wubuku.sui.bean;

import java.util.List;

public class PaginatedEvents extends Page<SuiEventEnvelope, EventId> {
    public PaginatedEvents() {
    }

    public PaginatedEvents(List<SuiEventEnvelope> data, EventId nextCursor) {
        super(data, nextCursor);
    }
}
