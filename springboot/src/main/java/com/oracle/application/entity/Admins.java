package com.oracle.application.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * <p>
 * 
 * </p>
 *
 * @author yky
 * @since 2020-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Admins对象", description="")
public class Admins implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String loginname;

    private String pwd;

    private LocalDateTime logindate;

    private Integer failcount;
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") //转换时间格式
    private LocalDateTime lockexpiredate;

    private Integer status;


}
