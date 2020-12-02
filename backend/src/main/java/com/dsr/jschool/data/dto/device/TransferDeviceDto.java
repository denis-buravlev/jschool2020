package com.dsr.jschool.data.dto.device;

public class TransferDeviceDto {

    private Long toUser;

    public Long getToUser() {
        return toUser;
    }

    public void setToUser(Long toUser) {
        this.toUser = toUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransferDeviceDto that = (TransferDeviceDto) o;

        return toUser != null ? toUser.equals(that.toUser) : that.toUser == null;
    }

    @Override
    public int hashCode() {
        return toUser != null ? toUser.hashCode() : 0;
    }
}
