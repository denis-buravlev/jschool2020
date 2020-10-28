package com.dsr.jschool.data.repository;

import com.dsr.jschool.data.entity.Device;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DeviceRepository extends PagingAndSortingRepository<Device, Long> {

    List<Device> findByName(String name);

    @Query("select d from Device d where d.id = :id")
    Device findByIdCustom(Long id);
}
