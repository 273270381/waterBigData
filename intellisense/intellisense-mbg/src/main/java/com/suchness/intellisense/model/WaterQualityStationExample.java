package com.suchness.intellisense.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WaterQualityStationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaterQualityStationExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNull() {
            addCriterion("station_id is null");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNotNull() {
            addCriterion("station_id is not null");
            return (Criteria) this;
        }

        public Criteria andStationIdEqualTo(Integer value) {
            addCriterion("station_id =", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotEqualTo(Integer value) {
            addCriterion("station_id <>", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThan(Integer value) {
            addCriterion("station_id >", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("station_id >=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThan(Integer value) {
            addCriterion("station_id <", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThanOrEqualTo(Integer value) {
            addCriterion("station_id <=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdIn(List<Integer> values) {
            addCriterion("station_id in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotIn(List<Integer> values) {
            addCriterion("station_id not in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdBetween(Integer value1, Integer value2) {
            addCriterion("station_id between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("station_id not between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andValleyIdIsNull() {
            addCriterion("valley_id is null");
            return (Criteria) this;
        }

        public Criteria andValleyIdIsNotNull() {
            addCriterion("valley_id is not null");
            return (Criteria) this;
        }

        public Criteria andValleyIdEqualTo(Integer value) {
            addCriterion("valley_id =", value, "valleyId");
            return (Criteria) this;
        }

        public Criteria andValleyIdNotEqualTo(Integer value) {
            addCriterion("valley_id <>", value, "valleyId");
            return (Criteria) this;
        }

        public Criteria andValleyIdGreaterThan(Integer value) {
            addCriterion("valley_id >", value, "valleyId");
            return (Criteria) this;
        }

        public Criteria andValleyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("valley_id >=", value, "valleyId");
            return (Criteria) this;
        }

        public Criteria andValleyIdLessThan(Integer value) {
            addCriterion("valley_id <", value, "valleyId");
            return (Criteria) this;
        }

        public Criteria andValleyIdLessThanOrEqualTo(Integer value) {
            addCriterion("valley_id <=", value, "valleyId");
            return (Criteria) this;
        }

        public Criteria andValleyIdIn(List<Integer> values) {
            addCriterion("valley_id in", values, "valleyId");
            return (Criteria) this;
        }

        public Criteria andValleyIdNotIn(List<Integer> values) {
            addCriterion("valley_id not in", values, "valleyId");
            return (Criteria) this;
        }

        public Criteria andValleyIdBetween(Integer value1, Integer value2) {
            addCriterion("valley_id between", value1, value2, "valleyId");
            return (Criteria) this;
        }

        public Criteria andValleyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("valley_id not between", value1, value2, "valleyId");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andStationTypeIdIsNull() {
            addCriterion("station_type_id is null");
            return (Criteria) this;
        }

        public Criteria andStationTypeIdIsNotNull() {
            addCriterion("station_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andStationTypeIdEqualTo(Integer value) {
            addCriterion("station_type_id =", value, "stationTypeId");
            return (Criteria) this;
        }

        public Criteria andStationTypeIdNotEqualTo(Integer value) {
            addCriterion("station_type_id <>", value, "stationTypeId");
            return (Criteria) this;
        }

        public Criteria andStationTypeIdGreaterThan(Integer value) {
            addCriterion("station_type_id >", value, "stationTypeId");
            return (Criteria) this;
        }

        public Criteria andStationTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("station_type_id >=", value, "stationTypeId");
            return (Criteria) this;
        }

        public Criteria andStationTypeIdLessThan(Integer value) {
            addCriterion("station_type_id <", value, "stationTypeId");
            return (Criteria) this;
        }

        public Criteria andStationTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("station_type_id <=", value, "stationTypeId");
            return (Criteria) this;
        }

        public Criteria andStationTypeIdIn(List<Integer> values) {
            addCriterion("station_type_id in", values, "stationTypeId");
            return (Criteria) this;
        }

        public Criteria andStationTypeIdNotIn(List<Integer> values) {
            addCriterion("station_type_id not in", values, "stationTypeId");
            return (Criteria) this;
        }

        public Criteria andStationTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("station_type_id between", value1, value2, "stationTypeId");
            return (Criteria) this;
        }

        public Criteria andStationTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("station_type_id not between", value1, value2, "stationTypeId");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLeverIdIsNull() {
            addCriterion("lever_id is null");
            return (Criteria) this;
        }

        public Criteria andLeverIdIsNotNull() {
            addCriterion("lever_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeverIdEqualTo(Integer value) {
            addCriterion("lever_id =", value, "leverId");
            return (Criteria) this;
        }

        public Criteria andLeverIdNotEqualTo(Integer value) {
            addCriterion("lever_id <>", value, "leverId");
            return (Criteria) this;
        }

        public Criteria andLeverIdGreaterThan(Integer value) {
            addCriterion("lever_id >", value, "leverId");
            return (Criteria) this;
        }

        public Criteria andLeverIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lever_id >=", value, "leverId");
            return (Criteria) this;
        }

        public Criteria andLeverIdLessThan(Integer value) {
            addCriterion("lever_id <", value, "leverId");
            return (Criteria) this;
        }

        public Criteria andLeverIdLessThanOrEqualTo(Integer value) {
            addCriterion("lever_id <=", value, "leverId");
            return (Criteria) this;
        }

        public Criteria andLeverIdIn(List<Integer> values) {
            addCriterion("lever_id in", values, "leverId");
            return (Criteria) this;
        }

        public Criteria andLeverIdNotIn(List<Integer> values) {
            addCriterion("lever_id not in", values, "leverId");
            return (Criteria) this;
        }

        public Criteria andLeverIdBetween(Integer value1, Integer value2) {
            addCriterion("lever_id between", value1, value2, "leverId");
            return (Criteria) this;
        }

        public Criteria andLeverIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lever_id not between", value1, value2, "leverId");
            return (Criteria) this;
        }

        public Criteria andConnectedIsNull() {
            addCriterion("connected is null");
            return (Criteria) this;
        }

        public Criteria andConnectedIsNotNull() {
            addCriterion("connected is not null");
            return (Criteria) this;
        }

        public Criteria andConnectedEqualTo(String value) {
            addCriterion("connected =", value, "connected");
            return (Criteria) this;
        }

        public Criteria andConnectedNotEqualTo(String value) {
            addCriterion("connected <>", value, "connected");
            return (Criteria) this;
        }

        public Criteria andConnectedGreaterThan(String value) {
            addCriterion("connected >", value, "connected");
            return (Criteria) this;
        }

        public Criteria andConnectedGreaterThanOrEqualTo(String value) {
            addCriterion("connected >=", value, "connected");
            return (Criteria) this;
        }

        public Criteria andConnectedLessThan(String value) {
            addCriterion("connected <", value, "connected");
            return (Criteria) this;
        }

        public Criteria andConnectedLessThanOrEqualTo(String value) {
            addCriterion("connected <=", value, "connected");
            return (Criteria) this;
        }

        public Criteria andConnectedLike(String value) {
            addCriterion("connected like", value, "connected");
            return (Criteria) this;
        }

        public Criteria andConnectedNotLike(String value) {
            addCriterion("connected not like", value, "connected");
            return (Criteria) this;
        }

        public Criteria andConnectedIn(List<String> values) {
            addCriterion("connected in", values, "connected");
            return (Criteria) this;
        }

        public Criteria andConnectedNotIn(List<String> values) {
            addCriterion("connected not in", values, "connected");
            return (Criteria) this;
        }

        public Criteria andConnectedBetween(String value1, String value2) {
            addCriterion("connected between", value1, value2, "connected");
            return (Criteria) this;
        }

        public Criteria andConnectedNotBetween(String value1, String value2) {
            addCriterion("connected not between", value1, value2, "connected");
            return (Criteria) this;
        }

        public Criteria andMonitorTimeIsNull() {
            addCriterion("monitor_time is null");
            return (Criteria) this;
        }

        public Criteria andMonitorTimeIsNotNull() {
            addCriterion("monitor_time is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorTimeEqualTo(Date value) {
            addCriterion("monitor_time =", value, "monitorTime");
            return (Criteria) this;
        }

        public Criteria andMonitorTimeNotEqualTo(Date value) {
            addCriterion("monitor_time <>", value, "monitorTime");
            return (Criteria) this;
        }

        public Criteria andMonitorTimeGreaterThan(Date value) {
            addCriterion("monitor_time >", value, "monitorTime");
            return (Criteria) this;
        }

        public Criteria andMonitorTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("monitor_time >=", value, "monitorTime");
            return (Criteria) this;
        }

        public Criteria andMonitorTimeLessThan(Date value) {
            addCriterion("monitor_time <", value, "monitorTime");
            return (Criteria) this;
        }

        public Criteria andMonitorTimeLessThanOrEqualTo(Date value) {
            addCriterion("monitor_time <=", value, "monitorTime");
            return (Criteria) this;
        }

        public Criteria andMonitorTimeIn(List<Date> values) {
            addCriterion("monitor_time in", values, "monitorTime");
            return (Criteria) this;
        }

        public Criteria andMonitorTimeNotIn(List<Date> values) {
            addCriterion("monitor_time not in", values, "monitorTime");
            return (Criteria) this;
        }

        public Criteria andMonitorTimeBetween(Date value1, Date value2) {
            addCriterion("monitor_time between", value1, value2, "monitorTime");
            return (Criteria) this;
        }

        public Criteria andMonitorTimeNotBetween(Date value1, Date value2) {
            addCriterion("monitor_time not between", value1, value2, "monitorTime");
            return (Criteria) this;
        }

        public Criteria andKmno4IsNull() {
            addCriterion("kmno4 is null");
            return (Criteria) this;
        }

        public Criteria andKmno4IsNotNull() {
            addCriterion("kmno4 is not null");
            return (Criteria) this;
        }

        public Criteria andKmno4EqualTo(Float value) {
            addCriterion("kmno4 =", value, "kmno4");
            return (Criteria) this;
        }

        public Criteria andKmno4NotEqualTo(Float value) {
            addCriterion("kmno4 <>", value, "kmno4");
            return (Criteria) this;
        }

        public Criteria andKmno4GreaterThan(Float value) {
            addCriterion("kmno4 >", value, "kmno4");
            return (Criteria) this;
        }

        public Criteria andKmno4GreaterThanOrEqualTo(Float value) {
            addCriterion("kmno4 >=", value, "kmno4");
            return (Criteria) this;
        }

        public Criteria andKmno4LessThan(Float value) {
            addCriterion("kmno4 <", value, "kmno4");
            return (Criteria) this;
        }

        public Criteria andKmno4LessThanOrEqualTo(Float value) {
            addCriterion("kmno4 <=", value, "kmno4");
            return (Criteria) this;
        }

        public Criteria andKmno4In(List<Float> values) {
            addCriterion("kmno4 in", values, "kmno4");
            return (Criteria) this;
        }

        public Criteria andKmno4NotIn(List<Float> values) {
            addCriterion("kmno4 not in", values, "kmno4");
            return (Criteria) this;
        }

        public Criteria andKmno4Between(Float value1, Float value2) {
            addCriterion("kmno4 between", value1, value2, "kmno4");
            return (Criteria) this;
        }

        public Criteria andKmno4NotBetween(Float value1, Float value2) {
            addCriterion("kmno4 not between", value1, value2, "kmno4");
            return (Criteria) this;
        }

        public Criteria andP4IsNull() {
            addCriterion("p4 is null");
            return (Criteria) this;
        }

        public Criteria andP4IsNotNull() {
            addCriterion("p4 is not null");
            return (Criteria) this;
        }

        public Criteria andP4EqualTo(Float value) {
            addCriterion("p4 =", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4NotEqualTo(Float value) {
            addCriterion("p4 <>", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4GreaterThan(Float value) {
            addCriterion("p4 >", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4GreaterThanOrEqualTo(Float value) {
            addCriterion("p4 >=", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4LessThan(Float value) {
            addCriterion("p4 <", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4LessThanOrEqualTo(Float value) {
            addCriterion("p4 <=", value, "p4");
            return (Criteria) this;
        }

        public Criteria andP4In(List<Float> values) {
            addCriterion("p4 in", values, "p4");
            return (Criteria) this;
        }

        public Criteria andP4NotIn(List<Float> values) {
            addCriterion("p4 not in", values, "p4");
            return (Criteria) this;
        }

        public Criteria andP4Between(Float value1, Float value2) {
            addCriterion("p4 between", value1, value2, "p4");
            return (Criteria) this;
        }

        public Criteria andP4NotBetween(Float value1, Float value2) {
            addCriterion("p4 not between", value1, value2, "p4");
            return (Criteria) this;
        }

        public Criteria andNh4IsNull() {
            addCriterion("nh4 is null");
            return (Criteria) this;
        }

        public Criteria andNh4IsNotNull() {
            addCriterion("nh4 is not null");
            return (Criteria) this;
        }

        public Criteria andNh4EqualTo(Float value) {
            addCriterion("nh4 =", value, "nh4");
            return (Criteria) this;
        }

        public Criteria andNh4NotEqualTo(Float value) {
            addCriterion("nh4 <>", value, "nh4");
            return (Criteria) this;
        }

        public Criteria andNh4GreaterThan(Float value) {
            addCriterion("nh4 >", value, "nh4");
            return (Criteria) this;
        }

        public Criteria andNh4GreaterThanOrEqualTo(Float value) {
            addCriterion("nh4 >=", value, "nh4");
            return (Criteria) this;
        }

        public Criteria andNh4LessThan(Float value) {
            addCriterion("nh4 <", value, "nh4");
            return (Criteria) this;
        }

        public Criteria andNh4LessThanOrEqualTo(Float value) {
            addCriterion("nh4 <=", value, "nh4");
            return (Criteria) this;
        }

        public Criteria andNh4In(List<Float> values) {
            addCriterion("nh4 in", values, "nh4");
            return (Criteria) this;
        }

        public Criteria andNh4NotIn(List<Float> values) {
            addCriterion("nh4 not in", values, "nh4");
            return (Criteria) this;
        }

        public Criteria andNh4Between(Float value1, Float value2) {
            addCriterion("nh4 between", value1, value2, "nh4");
            return (Criteria) this;
        }

        public Criteria andNh4NotBetween(Float value1, Float value2) {
            addCriterion("nh4 not between", value1, value2, "nh4");
            return (Criteria) this;
        }

        public Criteria andWaterTemperatureIsNull() {
            addCriterion("water_temperature is null");
            return (Criteria) this;
        }

        public Criteria andWaterTemperatureIsNotNull() {
            addCriterion("water_temperature is not null");
            return (Criteria) this;
        }

        public Criteria andWaterTemperatureEqualTo(Float value) {
            addCriterion("water_temperature =", value, "waterTemperature");
            return (Criteria) this;
        }

        public Criteria andWaterTemperatureNotEqualTo(Float value) {
            addCriterion("water_temperature <>", value, "waterTemperature");
            return (Criteria) this;
        }

        public Criteria andWaterTemperatureGreaterThan(Float value) {
            addCriterion("water_temperature >", value, "waterTemperature");
            return (Criteria) this;
        }

        public Criteria andWaterTemperatureGreaterThanOrEqualTo(Float value) {
            addCriterion("water_temperature >=", value, "waterTemperature");
            return (Criteria) this;
        }

        public Criteria andWaterTemperatureLessThan(Float value) {
            addCriterion("water_temperature <", value, "waterTemperature");
            return (Criteria) this;
        }

        public Criteria andWaterTemperatureLessThanOrEqualTo(Float value) {
            addCriterion("water_temperature <=", value, "waterTemperature");
            return (Criteria) this;
        }

        public Criteria andWaterTemperatureIn(List<Float> values) {
            addCriterion("water_temperature in", values, "waterTemperature");
            return (Criteria) this;
        }

        public Criteria andWaterTemperatureNotIn(List<Float> values) {
            addCriterion("water_temperature not in", values, "waterTemperature");
            return (Criteria) this;
        }

        public Criteria andWaterTemperatureBetween(Float value1, Float value2) {
            addCriterion("water_temperature between", value1, value2, "waterTemperature");
            return (Criteria) this;
        }

        public Criteria andWaterTemperatureNotBetween(Float value1, Float value2) {
            addCriterion("water_temperature not between", value1, value2, "waterTemperature");
            return (Criteria) this;
        }

        public Criteria andPhIsNull() {
            addCriterion("ph is null");
            return (Criteria) this;
        }

        public Criteria andPhIsNotNull() {
            addCriterion("ph is not null");
            return (Criteria) this;
        }

        public Criteria andPhEqualTo(Float value) {
            addCriterion("ph =", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotEqualTo(Float value) {
            addCriterion("ph <>", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhGreaterThan(Float value) {
            addCriterion("ph >", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhGreaterThanOrEqualTo(Float value) {
            addCriterion("ph >=", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLessThan(Float value) {
            addCriterion("ph <", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLessThanOrEqualTo(Float value) {
            addCriterion("ph <=", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhIn(List<Float> values) {
            addCriterion("ph in", values, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotIn(List<Float> values) {
            addCriterion("ph not in", values, "ph");
            return (Criteria) this;
        }

        public Criteria andPhBetween(Float value1, Float value2) {
            addCriterion("ph between", value1, value2, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotBetween(Float value1, Float value2) {
            addCriterion("ph not between", value1, value2, "ph");
            return (Criteria) this;
        }

        public Criteria andDissolvedOxygenIsNull() {
            addCriterion("dissolved_oxygen is null");
            return (Criteria) this;
        }

        public Criteria andDissolvedOxygenIsNotNull() {
            addCriterion("dissolved_oxygen is not null");
            return (Criteria) this;
        }

        public Criteria andDissolvedOxygenEqualTo(Float value) {
            addCriterion("dissolved_oxygen =", value, "dissolvedOxygen");
            return (Criteria) this;
        }

        public Criteria andDissolvedOxygenNotEqualTo(Float value) {
            addCriterion("dissolved_oxygen <>", value, "dissolvedOxygen");
            return (Criteria) this;
        }

        public Criteria andDissolvedOxygenGreaterThan(Float value) {
            addCriterion("dissolved_oxygen >", value, "dissolvedOxygen");
            return (Criteria) this;
        }

        public Criteria andDissolvedOxygenGreaterThanOrEqualTo(Float value) {
            addCriterion("dissolved_oxygen >=", value, "dissolvedOxygen");
            return (Criteria) this;
        }

        public Criteria andDissolvedOxygenLessThan(Float value) {
            addCriterion("dissolved_oxygen <", value, "dissolvedOxygen");
            return (Criteria) this;
        }

        public Criteria andDissolvedOxygenLessThanOrEqualTo(Float value) {
            addCriterion("dissolved_oxygen <=", value, "dissolvedOxygen");
            return (Criteria) this;
        }

        public Criteria andDissolvedOxygenIn(List<Float> values) {
            addCriterion("dissolved_oxygen in", values, "dissolvedOxygen");
            return (Criteria) this;
        }

        public Criteria andDissolvedOxygenNotIn(List<Float> values) {
            addCriterion("dissolved_oxygen not in", values, "dissolvedOxygen");
            return (Criteria) this;
        }

        public Criteria andDissolvedOxygenBetween(Float value1, Float value2) {
            addCriterion("dissolved_oxygen between", value1, value2, "dissolvedOxygen");
            return (Criteria) this;
        }

        public Criteria andDissolvedOxygenNotBetween(Float value1, Float value2) {
            addCriterion("dissolved_oxygen not between", value1, value2, "dissolvedOxygen");
            return (Criteria) this;
        }

        public Criteria andRedoxPotentialIsNull() {
            addCriterion("redox_potential is null");
            return (Criteria) this;
        }

        public Criteria andRedoxPotentialIsNotNull() {
            addCriterion("redox_potential is not null");
            return (Criteria) this;
        }

        public Criteria andRedoxPotentialEqualTo(Float value) {
            addCriterion("redox_potential =", value, "redoxPotential");
            return (Criteria) this;
        }

        public Criteria andRedoxPotentialNotEqualTo(Float value) {
            addCriterion("redox_potential <>", value, "redoxPotential");
            return (Criteria) this;
        }

        public Criteria andRedoxPotentialGreaterThan(Float value) {
            addCriterion("redox_potential >", value, "redoxPotential");
            return (Criteria) this;
        }

        public Criteria andRedoxPotentialGreaterThanOrEqualTo(Float value) {
            addCriterion("redox_potential >=", value, "redoxPotential");
            return (Criteria) this;
        }

        public Criteria andRedoxPotentialLessThan(Float value) {
            addCriterion("redox_potential <", value, "redoxPotential");
            return (Criteria) this;
        }

        public Criteria andRedoxPotentialLessThanOrEqualTo(Float value) {
            addCriterion("redox_potential <=", value, "redoxPotential");
            return (Criteria) this;
        }

        public Criteria andRedoxPotentialIn(List<Float> values) {
            addCriterion("redox_potential in", values, "redoxPotential");
            return (Criteria) this;
        }

        public Criteria andRedoxPotentialNotIn(List<Float> values) {
            addCriterion("redox_potential not in", values, "redoxPotential");
            return (Criteria) this;
        }

        public Criteria andRedoxPotentialBetween(Float value1, Float value2) {
            addCriterion("redox_potential between", value1, value2, "redoxPotential");
            return (Criteria) this;
        }

        public Criteria andRedoxPotentialNotBetween(Float value1, Float value2) {
            addCriterion("redox_potential not between", value1, value2, "redoxPotential");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
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