package za.amakosi.panelprocessor.domain.aggregate.auth.mapper;

import org.mapstruct.Mapper;
import za.amakosi.panelprocessor.infrastructure.user.model.User;


import static org.mapstruct.factory.Mappers.getMapper;


@Mapper
public interface UserMapper {

    UserMapper INSTANCE = getMapper(UserMapper.class);

    User fromDomain(za.amakosi.panelprocessor.domain.aggregate.auth.model.User user);

    za.amakosi.panelprocessor.domain.aggregate.auth.model.User toDomain(User user);
}
