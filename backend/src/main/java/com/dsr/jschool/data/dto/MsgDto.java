package com.dsr.jschool.data.dto;

import java.util.Objects;

public class MsgDto {

    private String msg;

    public MsgDto(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsgDto msgDto = (MsgDto) o;
        return Objects.equals(msg, msgDto.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msg);
    }
}
