package usts.pycro.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import usts.pycro.admin.bean.User;
import usts.pycro.admin.mapper.UserMapper;
import usts.pycro.admin.service.UserService;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-07 3:35 PM
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
