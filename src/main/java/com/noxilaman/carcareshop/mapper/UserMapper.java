package com.noxilaman.carcareshop.mapper;

import com.noxilaman.carcareshop.entity.User;
import com.noxilaman.carcareshop.model.MUserRes;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Named("toMUserRes")
    MUserRes toMUserRes(User user);

    //MUserRes toMUserRes(User user);

    @IterableMapping(qualifiedByName = "toMUserRes")
    @Named("mapListToMUserRes")
    Iterable<MUserRes> mapListToMUserRes(Iterable<User> users);

}
