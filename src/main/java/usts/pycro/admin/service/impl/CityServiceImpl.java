package usts.pycro.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.pycro.admin.bean.City;
import usts.pycro.admin.mapper.CityMapper;
import usts.pycro.admin.service.CityService;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-07 1:40 PM
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;

    public City getById(Long id) {
        return cityMapper.getById(id);
    }

    public void saveCity(City city) {
        cityMapper.insert(city);
    }
}
