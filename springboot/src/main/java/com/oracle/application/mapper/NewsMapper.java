package com.oracle.application.mapper;

import com.oracle.application.entity.News;
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
public interface NewsMapper extends BaseMapper<News> {

}
