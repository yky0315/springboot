package com.oracle.service.serviceImpl;
import com.oracle.mapper.UsersMapper;
import com.oracle.pojo.Users;
import com.oracle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public Users findUser(String loginname, String pwd) {
      return    usersMapper.findUser(loginname, pwd);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class,readOnly = false)
    @Override
    public void addUser(Users users) {
        usersMapper.insertSelective(users);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class,readOnly = false)
    public void updateUserStatus(String loginname) {
        usersMapper.updateUserStatus(loginname);
    }
}
