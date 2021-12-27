package za.amakosi.panelprocessor.application.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import za.amakosi.panelprocessor.application.dto.ResponseMessage;
import za.amakosi.panelprocessor.domain.aggregate.panel.model.PanelRequestMessage;

@Mapper
public interface ResponseMessageMapper {

    ResponseMessageMapper INSTANCE = Mappers.getMapper(ResponseMessageMapper.class);

    default ResponseMessage fromDomain(za.amakosi.panelprocessor.domain.aggregate.panel.model.ResponseMessage model) {
        return ResponseMessage.builder()
                .label(model.getLabel())
                .value(model.getValue())
                .unitOfMeasure(model.getUnitOfMeasure())
                .valueText(model.getValueText())
                .build();
    }
}
