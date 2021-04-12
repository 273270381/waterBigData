package com.suchness.intellisense.model;

import java.util.ArrayList;
import java.util.List;

public class WaterQualityDataYearExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaterQualityDataYearExample() {
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

        public Criteria andSiteIdIsNull() {
            addCriterion("site_id is null");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNotNull() {
            addCriterion("site_id is not null");
            return (Criteria) this;
        }

        public Criteria andSiteIdEqualTo(Integer value) {
            addCriterion("site_id =", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotEqualTo(Integer value) {
            addCriterion("site_id <>", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThan(Integer value) {
            addCriterion("site_id >", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("site_id >=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThan(Integer value) {
            addCriterion("site_id <", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThanOrEqualTo(Integer value) {
            addCriterion("site_id <=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdIn(List<Integer> values) {
            addCriterion("site_id in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotIn(List<Integer> values) {
            addCriterion("site_id not in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdBetween(Integer value1, Integer value2) {
            addCriterion("site_id between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("site_id not between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNull() {
            addCriterion("date_time is null");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNotNull() {
            addCriterion("date_time is not null");
            return (Criteria) this;
        }

        public Criteria andDateTimeEqualTo(String value) {
            addCriterion("date_time =", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotEqualTo(String value) {
            addCriterion("date_time <>", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThan(String value) {
            addCriterion("date_time >", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("date_time >=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThan(String value) {
            addCriterion("date_time <", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThanOrEqualTo(String value) {
            addCriterion("date_time <=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLike(String value) {
            addCriterion("date_time like", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotLike(String value) {
            addCriterion("date_time not like", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeIn(List<String> values) {
            addCriterion("date_time in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotIn(List<String> values) {
            addCriterion("date_time not in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeBetween(String value1, String value2) {
            addCriterion("date_time between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotBetween(String value1, String value2) {
            addCriterion("date_time not between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andW01019RtdIsNull() {
            addCriterion("w01019_Rtd is null");
            return (Criteria) this;
        }

        public Criteria andW01019RtdIsNotNull() {
            addCriterion("w01019_Rtd is not null");
            return (Criteria) this;
        }

        public Criteria andW01019RtdEqualTo(Float value) {
            addCriterion("w01019_Rtd =", value, "w01019Rtd");
            return (Criteria) this;
        }

        public Criteria andW01019RtdNotEqualTo(Float value) {
            addCriterion("w01019_Rtd <>", value, "w01019Rtd");
            return (Criteria) this;
        }

        public Criteria andW01019RtdGreaterThan(Float value) {
            addCriterion("w01019_Rtd >", value, "w01019Rtd");
            return (Criteria) this;
        }

        public Criteria andW01019RtdGreaterThanOrEqualTo(Float value) {
            addCriterion("w01019_Rtd >=", value, "w01019Rtd");
            return (Criteria) this;
        }

        public Criteria andW01019RtdLessThan(Float value) {
            addCriterion("w01019_Rtd <", value, "w01019Rtd");
            return (Criteria) this;
        }

        public Criteria andW01019RtdLessThanOrEqualTo(Float value) {
            addCriterion("w01019_Rtd <=", value, "w01019Rtd");
            return (Criteria) this;
        }

        public Criteria andW01019RtdIn(List<Float> values) {
            addCriterion("w01019_Rtd in", values, "w01019Rtd");
            return (Criteria) this;
        }

        public Criteria andW01019RtdNotIn(List<Float> values) {
            addCriterion("w01019_Rtd not in", values, "w01019Rtd");
            return (Criteria) this;
        }

        public Criteria andW01019RtdBetween(Float value1, Float value2) {
            addCriterion("w01019_Rtd between", value1, value2, "w01019Rtd");
            return (Criteria) this;
        }

        public Criteria andW01019RtdNotBetween(Float value1, Float value2) {
            addCriterion("w01019_Rtd not between", value1, value2, "w01019Rtd");
            return (Criteria) this;
        }

        public Criteria andW01019FlagIsNull() {
            addCriterion("w01019_Flag is null");
            return (Criteria) this;
        }

        public Criteria andW01019FlagIsNotNull() {
            addCriterion("w01019_Flag is not null");
            return (Criteria) this;
        }

        public Criteria andW01019FlagEqualTo(String value) {
            addCriterion("w01019_Flag =", value, "w01019Flag");
            return (Criteria) this;
        }

        public Criteria andW01019FlagNotEqualTo(String value) {
            addCriterion("w01019_Flag <>", value, "w01019Flag");
            return (Criteria) this;
        }

        public Criteria andW01019FlagGreaterThan(String value) {
            addCriterion("w01019_Flag >", value, "w01019Flag");
            return (Criteria) this;
        }

        public Criteria andW01019FlagGreaterThanOrEqualTo(String value) {
            addCriterion("w01019_Flag >=", value, "w01019Flag");
            return (Criteria) this;
        }

        public Criteria andW01019FlagLessThan(String value) {
            addCriterion("w01019_Flag <", value, "w01019Flag");
            return (Criteria) this;
        }

        public Criteria andW01019FlagLessThanOrEqualTo(String value) {
            addCriterion("w01019_Flag <=", value, "w01019Flag");
            return (Criteria) this;
        }

        public Criteria andW01019FlagLike(String value) {
            addCriterion("w01019_Flag like", value, "w01019Flag");
            return (Criteria) this;
        }

        public Criteria andW01019FlagNotLike(String value) {
            addCriterion("w01019_Flag not like", value, "w01019Flag");
            return (Criteria) this;
        }

        public Criteria andW01019FlagIn(List<String> values) {
            addCriterion("w01019_Flag in", values, "w01019Flag");
            return (Criteria) this;
        }

        public Criteria andW01019FlagNotIn(List<String> values) {
            addCriterion("w01019_Flag not in", values, "w01019Flag");
            return (Criteria) this;
        }

        public Criteria andW01019FlagBetween(String value1, String value2) {
            addCriterion("w01019_Flag between", value1, value2, "w01019Flag");
            return (Criteria) this;
        }

        public Criteria andW01019FlagNotBetween(String value1, String value2) {
            addCriterion("w01019_Flag not between", value1, value2, "w01019Flag");
            return (Criteria) this;
        }

        public Criteria andW21011RtdIsNull() {
            addCriterion("w21011_Rtd is null");
            return (Criteria) this;
        }

        public Criteria andW21011RtdIsNotNull() {
            addCriterion("w21011_Rtd is not null");
            return (Criteria) this;
        }

        public Criteria andW21011RtdEqualTo(Float value) {
            addCriterion("w21011_Rtd =", value, "w21011Rtd");
            return (Criteria) this;
        }

        public Criteria andW21011RtdNotEqualTo(Float value) {
            addCriterion("w21011_Rtd <>", value, "w21011Rtd");
            return (Criteria) this;
        }

        public Criteria andW21011RtdGreaterThan(Float value) {
            addCriterion("w21011_Rtd >", value, "w21011Rtd");
            return (Criteria) this;
        }

        public Criteria andW21011RtdGreaterThanOrEqualTo(Float value) {
            addCriterion("w21011_Rtd >=", value, "w21011Rtd");
            return (Criteria) this;
        }

        public Criteria andW21011RtdLessThan(Float value) {
            addCriterion("w21011_Rtd <", value, "w21011Rtd");
            return (Criteria) this;
        }

        public Criteria andW21011RtdLessThanOrEqualTo(Float value) {
            addCriterion("w21011_Rtd <=", value, "w21011Rtd");
            return (Criteria) this;
        }

        public Criteria andW21011RtdIn(List<Float> values) {
            addCriterion("w21011_Rtd in", values, "w21011Rtd");
            return (Criteria) this;
        }

        public Criteria andW21011RtdNotIn(List<Float> values) {
            addCriterion("w21011_Rtd not in", values, "w21011Rtd");
            return (Criteria) this;
        }

        public Criteria andW21011RtdBetween(Float value1, Float value2) {
            addCriterion("w21011_Rtd between", value1, value2, "w21011Rtd");
            return (Criteria) this;
        }

        public Criteria andW21011RtdNotBetween(Float value1, Float value2) {
            addCriterion("w21011_Rtd not between", value1, value2, "w21011Rtd");
            return (Criteria) this;
        }

        public Criteria andW21011FlagIsNull() {
            addCriterion("w21011_Flag is null");
            return (Criteria) this;
        }

        public Criteria andW21011FlagIsNotNull() {
            addCriterion("w21011_Flag is not null");
            return (Criteria) this;
        }

        public Criteria andW21011FlagEqualTo(String value) {
            addCriterion("w21011_Flag =", value, "w21011Flag");
            return (Criteria) this;
        }

        public Criteria andW21011FlagNotEqualTo(String value) {
            addCriterion("w21011_Flag <>", value, "w21011Flag");
            return (Criteria) this;
        }

        public Criteria andW21011FlagGreaterThan(String value) {
            addCriterion("w21011_Flag >", value, "w21011Flag");
            return (Criteria) this;
        }

        public Criteria andW21011FlagGreaterThanOrEqualTo(String value) {
            addCriterion("w21011_Flag >=", value, "w21011Flag");
            return (Criteria) this;
        }

        public Criteria andW21011FlagLessThan(String value) {
            addCriterion("w21011_Flag <", value, "w21011Flag");
            return (Criteria) this;
        }

        public Criteria andW21011FlagLessThanOrEqualTo(String value) {
            addCriterion("w21011_Flag <=", value, "w21011Flag");
            return (Criteria) this;
        }

        public Criteria andW21011FlagLike(String value) {
            addCriterion("w21011_Flag like", value, "w21011Flag");
            return (Criteria) this;
        }

        public Criteria andW21011FlagNotLike(String value) {
            addCriterion("w21011_Flag not like", value, "w21011Flag");
            return (Criteria) this;
        }

        public Criteria andW21011FlagIn(List<String> values) {
            addCriterion("w21011_Flag in", values, "w21011Flag");
            return (Criteria) this;
        }

        public Criteria andW21011FlagNotIn(List<String> values) {
            addCriterion("w21011_Flag not in", values, "w21011Flag");
            return (Criteria) this;
        }

        public Criteria andW21011FlagBetween(String value1, String value2) {
            addCriterion("w21011_Flag between", value1, value2, "w21011Flag");
            return (Criteria) this;
        }

        public Criteria andW21011FlagNotBetween(String value1, String value2) {
            addCriterion("w21011_Flag not between", value1, value2, "w21011Flag");
            return (Criteria) this;
        }

        public Criteria andW21003RtdIsNull() {
            addCriterion("w21003_Rtd is null");
            return (Criteria) this;
        }

        public Criteria andW21003RtdIsNotNull() {
            addCriterion("w21003_Rtd is not null");
            return (Criteria) this;
        }

        public Criteria andW21003RtdEqualTo(Float value) {
            addCriterion("w21003_Rtd =", value, "w21003Rtd");
            return (Criteria) this;
        }

        public Criteria andW21003RtdNotEqualTo(Float value) {
            addCriterion("w21003_Rtd <>", value, "w21003Rtd");
            return (Criteria) this;
        }

        public Criteria andW21003RtdGreaterThan(Float value) {
            addCriterion("w21003_Rtd >", value, "w21003Rtd");
            return (Criteria) this;
        }

        public Criteria andW21003RtdGreaterThanOrEqualTo(Float value) {
            addCriterion("w21003_Rtd >=", value, "w21003Rtd");
            return (Criteria) this;
        }

        public Criteria andW21003RtdLessThan(Float value) {
            addCriterion("w21003_Rtd <", value, "w21003Rtd");
            return (Criteria) this;
        }

        public Criteria andW21003RtdLessThanOrEqualTo(Float value) {
            addCriterion("w21003_Rtd <=", value, "w21003Rtd");
            return (Criteria) this;
        }

        public Criteria andW21003RtdIn(List<Float> values) {
            addCriterion("w21003_Rtd in", values, "w21003Rtd");
            return (Criteria) this;
        }

        public Criteria andW21003RtdNotIn(List<Float> values) {
            addCriterion("w21003_Rtd not in", values, "w21003Rtd");
            return (Criteria) this;
        }

        public Criteria andW21003RtdBetween(Float value1, Float value2) {
            addCriterion("w21003_Rtd between", value1, value2, "w21003Rtd");
            return (Criteria) this;
        }

        public Criteria andW21003RtdNotBetween(Float value1, Float value2) {
            addCriterion("w21003_Rtd not between", value1, value2, "w21003Rtd");
            return (Criteria) this;
        }

        public Criteria andW21003FlagIsNull() {
            addCriterion("w21003_Flag is null");
            return (Criteria) this;
        }

        public Criteria andW21003FlagIsNotNull() {
            addCriterion("w21003_Flag is not null");
            return (Criteria) this;
        }

        public Criteria andW21003FlagEqualTo(String value) {
            addCriterion("w21003_Flag =", value, "w21003Flag");
            return (Criteria) this;
        }

        public Criteria andW21003FlagNotEqualTo(String value) {
            addCriterion("w21003_Flag <>", value, "w21003Flag");
            return (Criteria) this;
        }

        public Criteria andW21003FlagGreaterThan(String value) {
            addCriterion("w21003_Flag >", value, "w21003Flag");
            return (Criteria) this;
        }

        public Criteria andW21003FlagGreaterThanOrEqualTo(String value) {
            addCriterion("w21003_Flag >=", value, "w21003Flag");
            return (Criteria) this;
        }

        public Criteria andW21003FlagLessThan(String value) {
            addCriterion("w21003_Flag <", value, "w21003Flag");
            return (Criteria) this;
        }

        public Criteria andW21003FlagLessThanOrEqualTo(String value) {
            addCriterion("w21003_Flag <=", value, "w21003Flag");
            return (Criteria) this;
        }

        public Criteria andW21003FlagLike(String value) {
            addCriterion("w21003_Flag like", value, "w21003Flag");
            return (Criteria) this;
        }

        public Criteria andW21003FlagNotLike(String value) {
            addCriterion("w21003_Flag not like", value, "w21003Flag");
            return (Criteria) this;
        }

        public Criteria andW21003FlagIn(List<String> values) {
            addCriterion("w21003_Flag in", values, "w21003Flag");
            return (Criteria) this;
        }

        public Criteria andW21003FlagNotIn(List<String> values) {
            addCriterion("w21003_Flag not in", values, "w21003Flag");
            return (Criteria) this;
        }

        public Criteria andW21003FlagBetween(String value1, String value2) {
            addCriterion("w21003_Flag between", value1, value2, "w21003Flag");
            return (Criteria) this;
        }

        public Criteria andW21003FlagNotBetween(String value1, String value2) {
            addCriterion("w21003_Flag not between", value1, value2, "w21003Flag");
            return (Criteria) this;
        }

        public Criteria andW01010RtdIsNull() {
            addCriterion("w01010_Rtd is null");
            return (Criteria) this;
        }

        public Criteria andW01010RtdIsNotNull() {
            addCriterion("w01010_Rtd is not null");
            return (Criteria) this;
        }

        public Criteria andW01010RtdEqualTo(Float value) {
            addCriterion("w01010_Rtd =", value, "w01010Rtd");
            return (Criteria) this;
        }

        public Criteria andW01010RtdNotEqualTo(Float value) {
            addCriterion("w01010_Rtd <>", value, "w01010Rtd");
            return (Criteria) this;
        }

        public Criteria andW01010RtdGreaterThan(Float value) {
            addCriterion("w01010_Rtd >", value, "w01010Rtd");
            return (Criteria) this;
        }

        public Criteria andW01010RtdGreaterThanOrEqualTo(Float value) {
            addCriterion("w01010_Rtd >=", value, "w01010Rtd");
            return (Criteria) this;
        }

        public Criteria andW01010RtdLessThan(Float value) {
            addCriterion("w01010_Rtd <", value, "w01010Rtd");
            return (Criteria) this;
        }

        public Criteria andW01010RtdLessThanOrEqualTo(Float value) {
            addCriterion("w01010_Rtd <=", value, "w01010Rtd");
            return (Criteria) this;
        }

        public Criteria andW01010RtdIn(List<Float> values) {
            addCriterion("w01010_Rtd in", values, "w01010Rtd");
            return (Criteria) this;
        }

        public Criteria andW01010RtdNotIn(List<Float> values) {
            addCriterion("w01010_Rtd not in", values, "w01010Rtd");
            return (Criteria) this;
        }

        public Criteria andW01010RtdBetween(Float value1, Float value2) {
            addCriterion("w01010_Rtd between", value1, value2, "w01010Rtd");
            return (Criteria) this;
        }

        public Criteria andW01010RtdNotBetween(Float value1, Float value2) {
            addCriterion("w01010_Rtd not between", value1, value2, "w01010Rtd");
            return (Criteria) this;
        }

        public Criteria andW01010FlagIsNull() {
            addCriterion("w01010_Flag is null");
            return (Criteria) this;
        }

        public Criteria andW01010FlagIsNotNull() {
            addCriterion("w01010_Flag is not null");
            return (Criteria) this;
        }

        public Criteria andW01010FlagEqualTo(String value) {
            addCriterion("w01010_Flag =", value, "w01010Flag");
            return (Criteria) this;
        }

        public Criteria andW01010FlagNotEqualTo(String value) {
            addCriterion("w01010_Flag <>", value, "w01010Flag");
            return (Criteria) this;
        }

        public Criteria andW01010FlagGreaterThan(String value) {
            addCriterion("w01010_Flag >", value, "w01010Flag");
            return (Criteria) this;
        }

        public Criteria andW01010FlagGreaterThanOrEqualTo(String value) {
            addCriterion("w01010_Flag >=", value, "w01010Flag");
            return (Criteria) this;
        }

        public Criteria andW01010FlagLessThan(String value) {
            addCriterion("w01010_Flag <", value, "w01010Flag");
            return (Criteria) this;
        }

        public Criteria andW01010FlagLessThanOrEqualTo(String value) {
            addCriterion("w01010_Flag <=", value, "w01010Flag");
            return (Criteria) this;
        }

        public Criteria andW01010FlagLike(String value) {
            addCriterion("w01010_Flag like", value, "w01010Flag");
            return (Criteria) this;
        }

        public Criteria andW01010FlagNotLike(String value) {
            addCriterion("w01010_Flag not like", value, "w01010Flag");
            return (Criteria) this;
        }

        public Criteria andW01010FlagIn(List<String> values) {
            addCriterion("w01010_Flag in", values, "w01010Flag");
            return (Criteria) this;
        }

        public Criteria andW01010FlagNotIn(List<String> values) {
            addCriterion("w01010_Flag not in", values, "w01010Flag");
            return (Criteria) this;
        }

        public Criteria andW01010FlagBetween(String value1, String value2) {
            addCriterion("w01010_Flag between", value1, value2, "w01010Flag");
            return (Criteria) this;
        }

        public Criteria andW01010FlagNotBetween(String value1, String value2) {
            addCriterion("w01010_Flag not between", value1, value2, "w01010Flag");
            return (Criteria) this;
        }

        public Criteria andW01001RtdIsNull() {
            addCriterion("w01001_Rtd is null");
            return (Criteria) this;
        }

        public Criteria andW01001RtdIsNotNull() {
            addCriterion("w01001_Rtd is not null");
            return (Criteria) this;
        }

        public Criteria andW01001RtdEqualTo(Float value) {
            addCriterion("w01001_Rtd =", value, "w01001Rtd");
            return (Criteria) this;
        }

        public Criteria andW01001RtdNotEqualTo(Float value) {
            addCriterion("w01001_Rtd <>", value, "w01001Rtd");
            return (Criteria) this;
        }

        public Criteria andW01001RtdGreaterThan(Float value) {
            addCriterion("w01001_Rtd >", value, "w01001Rtd");
            return (Criteria) this;
        }

        public Criteria andW01001RtdGreaterThanOrEqualTo(Float value) {
            addCriterion("w01001_Rtd >=", value, "w01001Rtd");
            return (Criteria) this;
        }

        public Criteria andW01001RtdLessThan(Float value) {
            addCriterion("w01001_Rtd <", value, "w01001Rtd");
            return (Criteria) this;
        }

        public Criteria andW01001RtdLessThanOrEqualTo(Float value) {
            addCriterion("w01001_Rtd <=", value, "w01001Rtd");
            return (Criteria) this;
        }

        public Criteria andW01001RtdIn(List<Float> values) {
            addCriterion("w01001_Rtd in", values, "w01001Rtd");
            return (Criteria) this;
        }

        public Criteria andW01001RtdNotIn(List<Float> values) {
            addCriterion("w01001_Rtd not in", values, "w01001Rtd");
            return (Criteria) this;
        }

        public Criteria andW01001RtdBetween(Float value1, Float value2) {
            addCriterion("w01001_Rtd between", value1, value2, "w01001Rtd");
            return (Criteria) this;
        }

        public Criteria andW01001RtdNotBetween(Float value1, Float value2) {
            addCriterion("w01001_Rtd not between", value1, value2, "w01001Rtd");
            return (Criteria) this;
        }

        public Criteria andW01001FlagIsNull() {
            addCriterion("w01001_Flag is null");
            return (Criteria) this;
        }

        public Criteria andW01001FlagIsNotNull() {
            addCriterion("w01001_Flag is not null");
            return (Criteria) this;
        }

        public Criteria andW01001FlagEqualTo(String value) {
            addCriterion("w01001_Flag =", value, "w01001Flag");
            return (Criteria) this;
        }

        public Criteria andW01001FlagNotEqualTo(String value) {
            addCriterion("w01001_Flag <>", value, "w01001Flag");
            return (Criteria) this;
        }

        public Criteria andW01001FlagGreaterThan(String value) {
            addCriterion("w01001_Flag >", value, "w01001Flag");
            return (Criteria) this;
        }

        public Criteria andW01001FlagGreaterThanOrEqualTo(String value) {
            addCriterion("w01001_Flag >=", value, "w01001Flag");
            return (Criteria) this;
        }

        public Criteria andW01001FlagLessThan(String value) {
            addCriterion("w01001_Flag <", value, "w01001Flag");
            return (Criteria) this;
        }

        public Criteria andW01001FlagLessThanOrEqualTo(String value) {
            addCriterion("w01001_Flag <=", value, "w01001Flag");
            return (Criteria) this;
        }

        public Criteria andW01001FlagLike(String value) {
            addCriterion("w01001_Flag like", value, "w01001Flag");
            return (Criteria) this;
        }

        public Criteria andW01001FlagNotLike(String value) {
            addCriterion("w01001_Flag not like", value, "w01001Flag");
            return (Criteria) this;
        }

        public Criteria andW01001FlagIn(List<String> values) {
            addCriterion("w01001_Flag in", values, "w01001Flag");
            return (Criteria) this;
        }

        public Criteria andW01001FlagNotIn(List<String> values) {
            addCriterion("w01001_Flag not in", values, "w01001Flag");
            return (Criteria) this;
        }

        public Criteria andW01001FlagBetween(String value1, String value2) {
            addCriterion("w01001_Flag between", value1, value2, "w01001Flag");
            return (Criteria) this;
        }

        public Criteria andW01001FlagNotBetween(String value1, String value2) {
            addCriterion("w01001_Flag not between", value1, value2, "w01001Flag");
            return (Criteria) this;
        }

        public Criteria andW01009RtdIsNull() {
            addCriterion("w01009_Rtd is null");
            return (Criteria) this;
        }

        public Criteria andW01009RtdIsNotNull() {
            addCriterion("w01009_Rtd is not null");
            return (Criteria) this;
        }

        public Criteria andW01009RtdEqualTo(Float value) {
            addCriterion("w01009_Rtd =", value, "w01009Rtd");
            return (Criteria) this;
        }

        public Criteria andW01009RtdNotEqualTo(Float value) {
            addCriterion("w01009_Rtd <>", value, "w01009Rtd");
            return (Criteria) this;
        }

        public Criteria andW01009RtdGreaterThan(Float value) {
            addCriterion("w01009_Rtd >", value, "w01009Rtd");
            return (Criteria) this;
        }

        public Criteria andW01009RtdGreaterThanOrEqualTo(Float value) {
            addCriterion("w01009_Rtd >=", value, "w01009Rtd");
            return (Criteria) this;
        }

        public Criteria andW01009RtdLessThan(Float value) {
            addCriterion("w01009_Rtd <", value, "w01009Rtd");
            return (Criteria) this;
        }

        public Criteria andW01009RtdLessThanOrEqualTo(Float value) {
            addCriterion("w01009_Rtd <=", value, "w01009Rtd");
            return (Criteria) this;
        }

        public Criteria andW01009RtdIn(List<Float> values) {
            addCriterion("w01009_Rtd in", values, "w01009Rtd");
            return (Criteria) this;
        }

        public Criteria andW01009RtdNotIn(List<Float> values) {
            addCriterion("w01009_Rtd not in", values, "w01009Rtd");
            return (Criteria) this;
        }

        public Criteria andW01009RtdBetween(Float value1, Float value2) {
            addCriterion("w01009_Rtd between", value1, value2, "w01009Rtd");
            return (Criteria) this;
        }

        public Criteria andW01009RtdNotBetween(Float value1, Float value2) {
            addCriterion("w01009_Rtd not between", value1, value2, "w01009Rtd");
            return (Criteria) this;
        }

        public Criteria andW01009FlagIsNull() {
            addCriterion("w01009_Flag is null");
            return (Criteria) this;
        }

        public Criteria andW01009FlagIsNotNull() {
            addCriterion("w01009_Flag is not null");
            return (Criteria) this;
        }

        public Criteria andW01009FlagEqualTo(String value) {
            addCriterion("w01009_Flag =", value, "w01009Flag");
            return (Criteria) this;
        }

        public Criteria andW01009FlagNotEqualTo(String value) {
            addCriterion("w01009_Flag <>", value, "w01009Flag");
            return (Criteria) this;
        }

        public Criteria andW01009FlagGreaterThan(String value) {
            addCriterion("w01009_Flag >", value, "w01009Flag");
            return (Criteria) this;
        }

        public Criteria andW01009FlagGreaterThanOrEqualTo(String value) {
            addCriterion("w01009_Flag >=", value, "w01009Flag");
            return (Criteria) this;
        }

        public Criteria andW01009FlagLessThan(String value) {
            addCriterion("w01009_Flag <", value, "w01009Flag");
            return (Criteria) this;
        }

        public Criteria andW01009FlagLessThanOrEqualTo(String value) {
            addCriterion("w01009_Flag <=", value, "w01009Flag");
            return (Criteria) this;
        }

        public Criteria andW01009FlagLike(String value) {
            addCriterion("w01009_Flag like", value, "w01009Flag");
            return (Criteria) this;
        }

        public Criteria andW01009FlagNotLike(String value) {
            addCriterion("w01009_Flag not like", value, "w01009Flag");
            return (Criteria) this;
        }

        public Criteria andW01009FlagIn(List<String> values) {
            addCriterion("w01009_Flag in", values, "w01009Flag");
            return (Criteria) this;
        }

        public Criteria andW01009FlagNotIn(List<String> values) {
            addCriterion("w01009_Flag not in", values, "w01009Flag");
            return (Criteria) this;
        }

        public Criteria andW01009FlagBetween(String value1, String value2) {
            addCriterion("w01009_Flag between", value1, value2, "w01009Flag");
            return (Criteria) this;
        }

        public Criteria andW01009FlagNotBetween(String value1, String value2) {
            addCriterion("w01009_Flag not between", value1, value2, "w01009Flag");
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