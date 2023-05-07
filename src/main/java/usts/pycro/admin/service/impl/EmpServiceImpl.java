package usts.pycro.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.pycro.admin.bean.Employee;
import usts.pycro.admin.mapper.EmpMapper;
import usts.pycro.admin.service.EmpService;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-07 1:04 PM
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    public Employee getEmpById(Long id){
        return empMapper.getEmpById(id);
    }
}
