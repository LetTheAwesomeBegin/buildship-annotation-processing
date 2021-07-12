package com.pattycake.example.core;

import com.pattycake.example.api.NewBuilding;
import com.pattycake.example.api.OldBuilding;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BuildingMapper {
  NewBuilding map(OldBuilding source);
}
