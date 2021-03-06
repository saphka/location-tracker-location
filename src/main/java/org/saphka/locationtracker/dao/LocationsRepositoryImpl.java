package org.saphka.locationtracker.dao;

import org.jooq.DSLContext;
import org.saphka.locationtracker.dao.jooq.Tables;
import org.saphka.locationtracker.dao.jooq.tables.records.LocationRecord;
import org.saphka.locationtracker.dao.util.AsyncHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class LocationsRepositoryImpl implements LocationsRepository {

    private final DSLContext dslContext;
    private final AsyncHelper async;

    @Autowired
    public LocationsRepositoryImpl(DSLContext dslContext, AsyncHelper async) {
        this.dslContext = dslContext;
        this.async = async;
    }

    @Override
    public Flux<LocationRecord> getLocationsByReceiver(Integer receiverId) {
        return async.fromArray(() -> dslContext
                .selectFrom(Tables.LOCATION)
                .where(Tables.LOCATION.RECEIVER_ID.eq(receiverId))
                .fetchArray());
    }


}
