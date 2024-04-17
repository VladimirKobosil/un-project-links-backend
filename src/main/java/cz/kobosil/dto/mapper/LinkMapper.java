package cz.kobosil.dto.mapper;

import cz.kobosil.dto.LinkDTO;
import cz.kobosil.entity.LinkEntity;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LinkMapper {


    LinkDTO toDTO(LinkEntity source);


    LinkEntity toEntity(LinkDTO source);


    LinkEntity updateEntity(LinkDTO source, @MappingTarget LinkEntity target);


}