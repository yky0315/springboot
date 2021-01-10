package com.oracle.application.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    private LocalDateTime lockexpiredate;

    private Integer status;


}
