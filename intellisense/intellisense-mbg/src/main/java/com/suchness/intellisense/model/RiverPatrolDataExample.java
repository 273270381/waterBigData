package com.suchness.intellisense.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RiverPatrolDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiverPatrolDataExample() {
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

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andMileageIsNull() {
            addCriterion("mileage is null");
            return (Criteria) this;
        }

        public Criteria andMileageIsNotNull() {
            addCriterion("mileage is not null");
            return (Criteria) this;
        }

        public Criteria andMileageEqualTo(String value) {
            addCriterion("mileage =", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotEqualTo(String value) {
            addCriterion("mileage <>", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageGreaterThan(String value) {
            addCriterion("mileage >", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageGreaterThanOrEqualTo(String value) {
            addCriterion("mileage >=", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageLessThan(String value) {
            addCriterion("mileage <", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageLessThanOrEqualTo(String value) {
            addCriterion("mileage <=", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageLike(String value) {
            addCriterion("mileage like", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotLike(String value) {
            addCriterion("mileage not like", value, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageIn(List<String> values) {
            addCriterion("mileage in", values, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotIn(List<String> values) {
            addCriterion("mileage not in", values, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageBetween(String value1, String value2) {
            addCriterion("mileage between", value1, value2, "mileage");
            return (Criteria) this;
        }

        public Criteria andMileageNotBetween(String value1, String value2) {
            addCriterion("mileage not between", value1, value2, "mileage");
            return (Criteria) this;
        }

        public Criteria andProblemIsNull() {
            addCriterion("problem is null");
            return (Criteria) this;
        }

        public Criteria andProblemIsNotNull() {
            addCriterion("problem is not null");
            return (Criteria) this;
        }

        public Criteria andProblemEqualTo(Integer value) {
            addCriterion("problem =", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemNotEqualTo(Integer value) {
            addCriterion("problem <>", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemGreaterThan(Integer value) {
            addCriterion("problem >", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemGreaterThanOrEqualTo(Integer value) {
            addCriterion("problem >=", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemLessThan(Integer value) {
            addCriterion("problem <", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemLessThanOrEqualTo(Integer value) {
            addCriterion("problem <=", value, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemIn(List<Integer> values) {
            addCriterion("problem in", values, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemNotIn(List<Integer> values) {
            addCriterion("problem not in", values, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemBetween(Integer value1, Integer value2) {
            addCriterion("problem between", value1, value2, "problem");
            return (Criteria) this;
        }

        public Criteria andProblemNotBetween(Integer value1, Integer value2) {
            addCriterion("problem not between", value1, value2, "problem");
            return (Criteria) this;
        }

        public Criteria andRiverTrackIdIsNull() {
            addCriterion("river_track_id is null");
            return (Criteria) this;
        }

        public Criteria andRiverTrackIdIsNotNull() {
            addCriterion("river_track_id is not null");
            return (Criteria) this;
        }

        public Criteria andRiverTrackIdEqualTo(Integer value) {
            addCriterion("river_track_id =", value, "riverTrackId");
            return (Criteria) this;
        }

        public Criteria andRiverTrackIdNotEqualTo(Integer value) {
            addCriterion("river_track_id <>", value, "riverTrackId");
            return (Criteria) this;
        }

        public Criteria andRiverTrackIdGreaterThan(Integer value) {
            addCriterion("river_track_id >", value, "riverTrackId");
            return (Criteria) this;
        }

        public Criteria andRiverTrackIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("river_track_id >=", value, "riverTrackId");
            return (Criteria) this;
        }

        public Criteria andRiverTrackIdLessThan(Integer value) {
            addCriterion("river_track_id <", value, "riverTrackId");
            return (Criteria) this;
        }

        public Criteria andRiverTrackIdLessThanOrEqualTo(Integer value) {
            addCriterion("river_track_id <=", value, "riverTrackId");
            return (Criteria) this;
        }

        public Criteria andRiverTrackIdIn(List<Integer> values) {
            addCriterion("river_track_id in", values, "riverTrackId");
            return (Criteria) this;
        }

        public Criteria andRiverTrackIdNotIn(List<Integer> values) {
            addCriterion("river_track_id not in", values, "riverTrackId");
            return (Criteria) this;
        }

        public Criteria andRiverTrackIdBetween(Integer value1, Integer value2) {
            addCriterion("river_track_id between", value1, value2, "riverTrackId");
            return (Criteria) this;
        }

        public Criteria andRiverTrackIdNotBetween(Integer value1, Integer value2) {
            addCriterion("river_track_id not between", value1, value2, "riverTrackId");
            return (Criteria) this;
        }

        public Criteria andRiverIdIsNull() {
            addCriterion("river_id is null");
            return (Criteria) this;
        }

        public Criteria andRiverIdIsNotNull() {
            addCriterion("river_id is not null");
            return (Criteria) this;
        }

        public Criteria andRiverIdEqualTo(Integer value) {
            addCriterion("river_id =", value, "riverId");
            return (Criteria) this;
        }

        public Criteria andRiverIdNotEqualTo(Integer value) {
            addCriterion("river_id <>", value, "riverId");
            return (Criteria) this;
        }

        public Criteria andRiverIdGreaterThan(Integer value) {
            addCriterion("river_id >", value, "riverId");
            return (Criteria) this;
        }

        public Criteria andRiverIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("river_id >=", value, "riverId");
            return (Criteria) this;
        }

        public Criteria andRiverIdLessThan(Integer value) {
            addCriterion("river_id <", value, "riverId");
            return (Criteria) this;
        }

        public Criteria andRiverIdLessThanOrEqualTo(Integer value) {
            addCriterion("river_id <=", value, "riverId");
            return (Criteria) this;
        }

        public Criteria andRiverIdIn(List<Integer> values) {
            addCriterion("river_id in", values, "riverId");
            return (Criteria) this;
        }

        public Criteria andRiverIdNotIn(List<Integer> values) {
            addCriterion("river_id not in", values, "riverId");
            return (Criteria) this;
        }

        public Criteria andRiverIdBetween(Integer value1, Integer value2) {
            addCriterion("river_id between", value1, value2, "riverId");
            return (Criteria) this;
        }

        public Criteria andRiverIdNotBetween(Integer value1, Integer value2) {
            addCriterion("river_id not between", value1, value2, "riverId");
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

        public Criteria andRiverAreaIdIsNull() {
            addCriterion("river_area_id is null");
            return (Criteria) this;
        }

        public Criteria andRiverAreaIdIsNotNull() {
            addCriterion("river_area_id is not null");
            return (Criteria) this;
        }

        public Criteria andRiverAreaIdEqualTo(Integer value) {
            addCriterion("river_area_id =", value, "riverAreaId");
            return (Criteria) this;
        }

        public Criteria andRiverAreaIdNotEqualTo(Integer value) {
            addCriterion("river_area_id <>", value, "riverAreaId");
            return (Criteria) this;
        }

        public Criteria andRiverAreaIdGreaterThan(Integer value) {
            addCriterion("river_area_id >", value, "riverAreaId");
            return (Criteria) this;
        }

        public Criteria andRiverAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("river_area_id >=", value, "riverAreaId");
            return (Criteria) this;
        }

        public Criteria andRiverAreaIdLessThan(Integer value) {
            addCriterion("river_area_id <", value, "riverAreaId");
            return (Criteria) this;
        }

        public Criteria andRiverAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("river_area_id <=", value, "riverAreaId");
            return (Criteria) this;
        }

        public Criteria andRiverAreaIdIn(List<Integer> values) {
            addCriterion("river_area_id in", values, "riverAreaId");
            return (Criteria) this;
        }

        public Criteria andRiverAreaIdNotIn(List<Integer> values) {
            addCriterion("river_area_id not in", values, "riverAreaId");
            return (Criteria) this;
        }

        public Criteria andRiverAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("river_area_id between", value1, value2, "riverAreaId");
            return (Criteria) this;
        }

        public Criteria andRiverAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("river_area_id not between", value1, value2, "riverAreaId");
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