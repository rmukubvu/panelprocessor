package za.amakosi.panelprocessor.application.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import za.amakosi.panelprocessor.application.dto.RegisterInfo;

@Mapper
public interface RegisterInfoMapper {
    RegisterInfoMapper INSTANCE = Mappers.getMapper(RegisterInfoMapper.class);

    RegisterInfo fromDomain(za.amakosi.panelprocessor.domain.aggregate.panel.model.RegisterInfo model);
}
