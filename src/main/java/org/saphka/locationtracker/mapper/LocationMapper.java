package org.saphka.locationtracker.mapper;

import org.mapstruct.Mapper;
import org.saphka.locationtracker.api.model.LocationDTO;
import org.saphka.locationtracker.dao.jooq.tables.records.LocationRecord;

@Mapper
public interface LocationMapper extends BaseMapper<LocationRecord, LocationDTO>{

}
