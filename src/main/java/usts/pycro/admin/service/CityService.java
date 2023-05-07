package usts.pycro.admin.service;

import usts.pycro.admin.bean.City;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-07 1:40 PM
 */

public interface CityService {

    City getById(Long id);

    void saveCity(City city);
}
