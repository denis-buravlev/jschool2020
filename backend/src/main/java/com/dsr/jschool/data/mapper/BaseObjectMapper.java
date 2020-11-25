package com.dsr.jschool.data.mapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseObjectMapper<IN, OUT> implements ObjectMapper<IN, OUT> {
    @Override
    public List<OUT> convertList(List<IN> objList) {
        return objList.stream().map(this::convert).collect(Collectors.toList());
    }
}
