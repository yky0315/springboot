package com.oracle.pojo;
import lombok.Data;
import java.math.BigDecimal;
@Data
public class Cart {

    private Integer proId;
    private String proName;
    private String proFullName;
    private Integer pronum;
    private BigDecimal proPrice;
    private String proImg;
}
