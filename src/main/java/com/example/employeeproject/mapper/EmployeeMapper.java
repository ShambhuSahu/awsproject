package com.example.employeeproject.mapper;

import com.example.employeeproject.entity.EmployeeEntity;
import com.example.employeeproject.model.EmployeeRequest;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeRequest entityToModel(EmployeeEntity employeeEntity) ;
    EmployeeEntity modelToEntity(EmployeeRequest employeeRequest);

    List<EmployeeRequest> entityToModelList(List<EmployeeEntity> employeeEntity);


}
