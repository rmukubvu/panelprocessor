package za.amakosi.panelprocessor.application.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import za.amakosi.panelprocessor.domain.aggregate.panel.model.PanelRequestMessage;

@Mapper
public interface PanelRequestMessageMapper {

    PanelRequestMessageMapper INSTANCE = Mappers.getMapper(PanelRequestMessageMapper.class);

    PanelRequestMessage toDomain(za.amakosi.panelprocessor.application.dto.PanelRequestMessage model);
}
