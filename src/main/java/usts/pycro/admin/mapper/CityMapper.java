package usts.pycro.admin.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.ResponseBody;
import usts.pycro.admin.bean.City;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-07 1:38 PM
 */
//@Mapper
public interface CityMapper {
    @Select("select * from `city` where id=#{id}")
    City getById(Long id);

    @Insert("insert into city(`name`, `state`, `country`) values (#{name}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(City city);
}
