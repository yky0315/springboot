package com.oracle.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements Serializable {
    private Integer id;

    private String proname;

    private String prosn;

    private BigDecimal proprice;

    private Integer pronum;

    private String proimg;

    private String profullname;

    private String unit;

    private Date createdate;

    private Integer status;

    private String desc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname == null ? null : proname.trim();
    }

    public String getProsn() {
        return prosn;
    }

    public void setProsn(String prosn) {
        this.prosn = prosn == null ? null : prosn.trim();
    }

    public BigDecimal getProprice() {
        return proprice;
    }

    public void setProprice(BigDecimal proprice) {
        this.proprice = proprice;
    }

    public Integer getPronum() {
        return pronum;
    }

    public void setPronum(Integer pronum) {
        this.pronum = pronum;
    }

    public String getProimg() {
        return proimg;
    }

    public void setProimg(String proimg) {
        this.proimg = proimg == null ? null : proimg.trim();
    }

    public String getProfullname() {
        return profullname;
    }

    public void setProfullname(String profullname) {
        this.profullname = profullname == null ? null : profullname.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Product other = (Product) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProname() == null ? other.getProname() == null : this.getProname().equals(other.getProname()))
            && (this.getProsn() == null ? other.getProsn() == null : this.getProsn().equals(other.getProsn()))
            && (this.getProprice() == null ? other.getProprice() == null : this.getProprice().equals(other.getProprice()))
            && (this.getPronum() == null ? other.getPronum() == null : this.getPronum().equals(other.getPronum()))
            && (this.getProimg() == null ? other.getProimg() == null : this.getProimg().equals(other.getProimg()))
            && (this.getProfullname() == null ? other.getProfullname() == null : this.getProfullname().equals(other.getProfullname()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProname() == null) ? 0 : getProname().hashCode());
        result = prime * result + ((getProsn() == null) ? 0 : getProsn().hashCode());
        result = prime * result + ((getProprice() == null) ? 0 : getProprice().hashCode());
        result = prime * result + ((getPronum() == null) ? 0 : getPronum().hashCode());
        result = prime * result + ((getProimg() == null) ? 0 : getProimg().hashCode());
        result = prime * result + ((getProfullname() == null) ? 0 : getProfullname().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", proname=").append(proname);
        sb.append(", prosn=").append(prosn);
        sb.append(", proprice=").append(proprice);
        sb.append(", pronum=").append(pronum);
        sb.append(", proimg=").append(proimg);
        sb.append(", profullname=").append(profullname);
        sb.append(", unit=").append(unit);
        sb.append(", createdate=").append(createdate);
        sb.append(", status=").append(status);
        sb.append(", desc=").append(desc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}