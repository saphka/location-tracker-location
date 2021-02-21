package org.saphka.locationtracker.dao;

import org.saphka.locationtracker.dao.jooq.tables.records.LocationRecord;
import reactor.core.publisher.Flux;

public interface LocationsRepository {

    Flux<LocationRecord> getLocationsByReceiver(Integer receiverId);

}
