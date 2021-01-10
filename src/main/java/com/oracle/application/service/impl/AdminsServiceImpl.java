package com.oracle.application.service.impl;

import com.oracle.application.entity.Admins;
import com.oracle.application.mapper.AdminsMapper;
import com.oracle.application.service.IAdminsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yky
 * @since 2020-12-11
 */
@Service
public class AdminsServiceImpl extends ServiceImpl<AdminsMapper, Admins> implements IAdminsService {

}
