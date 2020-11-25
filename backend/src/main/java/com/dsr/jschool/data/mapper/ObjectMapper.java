package com.dsr.jschool.data.mapper;

import java.util.List;

public interface ObjectMapper<IN, OUT> {

    OUT convert(IN obj);
    List<OUT> convertList(List<IN> objList);

    Class<IN> getInClass();
    Class<OUT> getOutClass();
}
