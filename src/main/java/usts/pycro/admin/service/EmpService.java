package usts.pycro.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.pycro.admin.bean.Employee;
import usts.pycro.admin.mapper.EmpMapper;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-07 1:04 PM
 */

public interface EmpService {
     Employee getEmpById(Long id);
}
