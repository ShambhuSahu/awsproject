package com.example.employeeproject.service;

import com.example.employeeproject.entity.EmployeeEntity;
import com.example.employeeproject.mapper.EmployeeMapper;
import com.example.employeeproject.model.EmployeeRequest;
import com.example.employeeproject.model.EmployeeResponse;
import com.example.employeeproject.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }


    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {

        EmployeeEntity employeeEntity=employeeMapper.modelToEntity(employeeRequest);
        employeeRepository.save(employeeEntity);

        EmployeeResponse employeeResponse=new EmployeeResponse();
        employeeResponse.setEmployeeId(employeeEntity.getEmployeeId());

        return employeeResponse;
    }

    public EmployeeRequest getAllEmployee(Long employeeId) {

        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);
        EmployeeRequest employeeRequest=employeeMapper.entityToModel(employeeEntity.get());
        return employeeRequest;
    }

    public List<EmployeeRequest> getAllEmployees() {

        List<EmployeeEntity> employeeEntityList=employeeRepository.findAll();
        List<EmployeeRequest> employeeRequestList=employeeMapper.entityToModelList(employeeEntityList);
        return employeeRequestList;

    }

    public   EmployeeResponse updateEmployee(Long employeeId, EmployeeRequest employeeRequest) {

        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);
       // employeeEntity.get().setFirstName(employeeRequest.getFirstName());

   //     employeeEntity=Optional.of(employeeMapper.modelToEntity(employeeRequest));
//        EmployeeEntity newEmployeeEntity=employeeMapper.modelToEntity(employeeRequest);
//        newEmployeeEntity.setEmployeeId(employeeEntity.get().getEmployeeId());

//        employeeRepository.save(newEmployeeEntity);
//
//        EmployeeRequest employeeRequest1=employeeMapper.entityToModel(newEmployeeEntity);
//        return employeeRequest1;
//
//       employeeRepository.save(employeeEntity.get());
//       return employeeRequest;

        EmployeeEntity newEmployeeEntity=employeeMapper.modelToEntity(employeeRequest);
        newEmployeeEntity.setEmployeeId(employeeEntity.get().getEmployeeId());

        employeeRepository.save(newEmployeeEntity);

        EmployeeResponse employeeResponse=new EmployeeResponse();

        employeeResponse.setEmployeeId(employeeEntity.get().getEmployeeId());

        return employeeResponse;

    }
}
