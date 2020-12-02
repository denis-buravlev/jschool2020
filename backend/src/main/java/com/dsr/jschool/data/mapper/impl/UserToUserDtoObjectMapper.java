package com.dsr.jschool.data.mapper.impl;

import com.dsr.jschool.data.dto.UserDto;
import com.dsr.jschool.data.entity.User;
import com.dsr.jschool.data.mapper.BaseObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoObjectMapper extends BaseObjectMapper<User, UserDto> {
    @Override
    public UserDto convert(User obj) {
        var result = new UserDto();
        result.setId(obj.getId());
        result.setName(obj.getName());
        return result;
    }

    @Override
    public Class<User> getInClass() {
        return User.class;
    }

    @Override
    public Class<UserDto> getOutClass() {
        return UserDto.class;
    }
}
