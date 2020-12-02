package com.dsr.jschool.data.dto.device;

import com.dsr.jschool.data.dto.UserDto;

public class DeviceDto {

    public DeviceDto() {
    }

    public DeviceDto(Long id, String name, String description, UserDto owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;

    }

    private Long id;
    private String name;
    private String description;
    private UserDto owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDto getOwner() {
        return owner;
    }

    public void setOwner(UserDto owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceDto deviceDto = (DeviceDto) o;

        if (id != null ? !id.equals(deviceDto.id) : deviceDto.id != null) return false;
        if (name != null ? !name.equals(deviceDto.name) : deviceDto.name != null) return false;
        if (description != null ? !description.equals(deviceDto.description) : deviceDto.description != null)
            return false;
        return owner != null ? owner.equals(deviceDto.owner) : deviceDto.owner == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }
}
