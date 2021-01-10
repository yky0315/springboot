package com.oracle.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPronameIsNull() {
            addCriterion("proname is null");
            return (Criteria) this;
        }

        public Criteria andPronameIsNotNull() {
            addCriterion("proname is not null");
            return (Criteria) this;
        }

        public Criteria andPronameEqualTo(String value) {
            addCriterion("proname =", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotEqualTo(String value) {
            addCriterion("proname <>", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameGreaterThan(String value) {
            addCriterion("proname >", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameGreaterThanOrEqualTo(String value) {
            addCriterion("proname >=", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLessThan(String value) {
            addCriterion("proname <", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLessThanOrEqualTo(String value) {
            addCriterion("proname <=", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameLike(String value) {
            addCriterion("proname like", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotLike(String value) {
            addCriterion("proname not like", value, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameIn(List<String> values) {
            addCriterion("proname in", values, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotIn(List<String> values) {
            addCriterion("proname not in", values, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameBetween(String value1, String value2) {
            addCriterion("proname between", value1, value2, "proname");
            return (Criteria) this;
        }

        public Criteria andPronameNotBetween(String value1, String value2) {
            addCriterion("proname not between", value1, value2, "proname");
            return (Criteria) this;
        }

        public Criteria andProsnIsNull() {
            addCriterion("prosn is null");
            return (Criteria) this;
        }

        public Criteria andProsnIsNotNull() {
            addCriterion("prosn is not null");
            return (Criteria) this;
        }

        public Criteria andProsnEqualTo(String value) {
            addCriterion("prosn =", value, "prosn");
            return (Criteria) this;
        }

        public Criteria andProsnNotEqualTo(String value) {
            addCriterion("prosn <>", value, "prosn");
            return (Criteria) this;
        }

        public Criteria andProsnGreaterThan(String value) {
            addCriterion("prosn >", value, "prosn");
            return (Criteria) this;
        }

        public Criteria andProsnGreaterThanOrEqualTo(String value) {
            addCriterion("prosn >=", value, "prosn");
            return (Criteria) this;
        }

        public Criteria andProsnLessThan(String value) {
            addCriterion("prosn <", value, "prosn");
            return (Criteria) this;
        }

        public Criteria andProsnLessThanOrEqualTo(String value) {
            addCriterion("prosn <=", value, "prosn");
            return (Criteria) this;
        }

        public Criteria andProsnLike(String value) {
            addCriterion("prosn like", value, "prosn");
            return (Criteria) this;
        }

        public Criteria andProsnNotLike(String value) {
            addCriterion("prosn not like", value, "prosn");
            return (Criteria) this;
        }

        public Criteria andProsnIn(List<String> values) {
            addCriterion("prosn in", values, "prosn");
            return (Criteria) this;
        }

        public Criteria andProsnNotIn(List<String> values) {
            addCriterion("prosn not in", values, "prosn");
            return (Criteria) this;
        }

        public Criteria andProsnBetween(String value1, String value2) {
            addCriterion("prosn between", value1, value2, "prosn");
            return (Criteria) this;
        }

        public Criteria andProsnNotBetween(String value1, String value2) {
            addCriterion("prosn not between", value1, value2, "prosn");
            return (Criteria) this;
        }

        public Criteria andPropriceIsNull() {
            addCriterion("proprice is null");
            return (Criteria) this;
        }

        public Criteria andPropriceIsNotNull() {
            addCriterion("proprice is not null");
            return (Criteria) this;
        }

        public Criteria andPropriceEqualTo(BigDecimal value) {
            addCriterion("proprice =", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceNotEqualTo(BigDecimal value) {
            addCriterion("proprice <>", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceGreaterThan(BigDecimal value) {
            addCriterion("proprice >", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("proprice >=", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceLessThan(BigDecimal value) {
            addCriterion("proprice <", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("proprice <=", value, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceIn(List<BigDecimal> values) {
            addCriterion("proprice in", values, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceNotIn(List<BigDecimal> values) {
            addCriterion("proprice not in", values, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("proprice between", value1, value2, "proprice");
            return (Criteria) this;
        }

        public Criteria andPropriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("proprice not between", value1, value2, "proprice");
            return (Criteria) this;
        }

        public Criteria andPronumIsNull() {
            addCriterion("pronum is null");
            return (Criteria) this;
        }

        public Criteria andPronumIsNotNull() {
            addCriterion("pronum is not null");
            return (Criteria) this;
        }

        public Criteria andPronumEqualTo(Integer value) {
            addCriterion("pronum =", value, "pronum");
            return (Criteria) this;
        }

        public Criteria andPronumNotEqualTo(Integer value) {
            addCriterion("pronum <>", value, "pronum");
            return (Criteria) this;
        }

        public Criteria andPronumGreaterThan(Integer value) {
            addCriterion("pronum >", value, "pronum");
            return (Criteria) this;
        }

        public Criteria andPronumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pronum >=", value, "pronum");
            return (Criteria) this;
        }

        public Criteria andPronumLessThan(Integer value) {
            addCriterion("pronum <", value, "pronum");
            return (Criteria) this;
        }

        public Criteria andPronumLessThanOrEqualTo(Integer value) {
            addCriterion("pronum <=", value, "pronum");
            return (Criteria) this;
        }

        public Criteria andPronumIn(List<Integer> values) {
            addCriterion("pronum in", values, "pronum");
            return (Criteria) this;
        }

        public Criteria andPronumNotIn(List<Integer> values) {
            addCriterion("pronum not in", values, "pronum");
            return (Criteria) this;
        }

        public Criteria andPronumBetween(Integer value1, Integer value2) {
            addCriterion("pronum between", value1, value2, "pronum");
            return (Criteria) this;
        }

        public Criteria andPronumNotBetween(Integer value1, Integer value2) {
            addCriterion("pronum not between", value1, value2, "pronum");
            return (Criteria) this;
        }

        public Criteria andProimgIsNull() {
            addCriterion("proimg is null");
            return (Criteria) this;
        }

        public Criteria andProimgIsNotNull() {
            addCriterion("proimg is not null");
            return (Criteria) this;
        }

        public Criteria andProimgEqualTo(String value) {
            addCriterion("proimg =", value, "proimg");
            return (Criteria) this;
        }

        public Criteria andProimgNotEqualTo(String value) {
            addCriterion("proimg <>", value, "proimg");
            return (Criteria) this;
        }

        public Criteria andProimgGreaterThan(String value) {
            addCriterion("proimg >", value, "proimg");
            return (Criteria) this;
        }

        public Criteria andProimgGreaterThanOrEqualTo(String value) {
            addCriterion("proimg >=", value, "proimg");
            return (Criteria) this;
        }

        public Criteria andProimgLessThan(String value) {
            addCriterion("proimg <", value, "proimg");
            return (Criteria) this;
        }

        public Criteria andProimgLessThanOrEqualTo(String value) {
            addCriterion("proimg <=", value, "proimg");
            return (Criteria) this;
        }

        public Criteria andProimgLike(String value) {
            addCriterion("proimg like", value, "proimg");
            return (Criteria) this;
        }

        public Criteria andProimgNotLike(String value) {
            addCriterion("proimg not like", value, "proimg");
            return (Criteria) this;
        }

        public Criteria andProimgIn(List<String> values) {
            addCriterion("proimg in", values, "proimg");
            return (Criteria) this;
        }

        public Criteria andProimgNotIn(List<String> values) {
            addCriterion("proimg not in", values, "proimg");
            return (Criteria) this;
        }

        public Criteria andProimgBetween(String value1, String value2) {
            addCriterion("proimg between", value1, value2, "proimg");
            return (Criteria) this;
        }

        public Criteria andProimgNotBetween(String value1, String value2) {
            addCriterion("proimg not between", value1, value2, "proimg");
            return (Criteria) this;
        }

        public Criteria andProfullnameIsNull() {
            addCriterion("profullname is null");
            return (Criteria) this;
        }

        public Criteria andProfullnameIsNotNull() {
            addCriterion("profullname is not null");
            return (Criteria) this;
        }

        public Criteria andProfullnameEqualTo(String value) {
            addCriterion("profullname =", value, "profullname");
            return (Criteria) this;
        }

        public Criteria andProfullnameNotEqualTo(String value) {
            addCriterion("profullname <>", value, "profullname");
            return (Criteria) this;
        }

        public Criteria andProfullnameGreaterThan(String value) {
            addCriterion("profullname >", value, "profullname");
            return (Criteria) this;
        }

        public Criteria andProfullnameGreaterThanOrEqualTo(String value) {
            addCriterion("profullname >=", value, "profullname");
            return (Criteria) this;
        }

        public Criteria andProfullnameLessThan(String value) {
            addCriterion("profullname <", value, "profullname");
            return (Criteria) this;
        }

        public Criteria andProfullnameLessThanOrEqualTo(String value) {
            addCriterion("profullname <=", value, "profullname");
            return (Criteria) this;
        }

        public Criteria andProfullnameLike(String value) {
            addCriterion("profullname like", value, "profullname");
            return (Criteria) this;
        }

        public Criteria andProfullnameNotLike(String value) {
            addCriterion("profullname not like", value, "profullname");
            return (Criteria) this;
        }

        public Criteria andProfullnameIn(List<String> values) {
            addCriterion("profullname in", values, "profullname");
            return (Criteria) this;
        }

        public Criteria andProfullnameNotIn(List<String> values) {
            addCriterion("profullname not in", values, "profullname");
            return (Criteria) this;
        }

        public Criteria andProfullnameBetween(String value1, String value2) {
            addCriterion("profullname between", value1, value2, "profullname");
            return (Criteria) this;
        }

        public Criteria andProfullnameNotBetween(String value1, String value2) {
            addCriterion("profullname not between", value1, value2, "profullname");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createdate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createdate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createdate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createdate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createdate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createdate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createdate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createdate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createdate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createdate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}