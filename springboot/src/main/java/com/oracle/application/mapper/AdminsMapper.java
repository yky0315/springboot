package com.oracle.application.mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oracle.application.entity.Admins;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yky
 * @since 2020-12-11
 */
@Mapper
public interface AdminsMapper extends BaseMapper<Admins> {

    public IPage<Admins> selectPage(Page page);
}
