package com.suchness.intellisense.model;

import java.util.ArrayList;
import java.util.List;

public class RiversExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RiversExample() {
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

        public Criteria andRivernameIsNull() {
            addCriterion("riverName is null");
            return (Criteria) this;
        }

        public Criteria andRivernameIsNotNull() {
            addCriterion("riverName is not null");
            return (Criteria) this;
        }

        public Criteria andRivernameEqualTo(String value) {
            addCriterion("riverName =", value, "rivername");
            return (Criteria) this;
        }

        public Criteria andRivernameNotEqualTo(String value) {
            addCriterion("riverName <>", value, "rivername");
            return (Criteria) this;
        }

        public Criteria andRivernameGreaterThan(String value) {
            addCriterion("riverName >", value, "rivername");
            return (Criteria) this;
        }

        public Criteria andRivernameGreaterThanOrEqualTo(String value) {
            addCriterion("riverName >=", value, "rivername");
            return (Criteria) this;
        }

        public Criteria andRivernameLessThan(String value) {
            addCriterion("riverName <", value, "rivername");
            return (Criteria) this;
        }

        public Criteria andRivernameLessThanOrEqualTo(String value) {
            addCriterion("riverName <=", value, "rivername");
            return (Criteria) this;
        }

        public Criteria andRivernameLike(String value) {
            addCriterion("riverName like", value, "rivername");
            return (Criteria) this;
        }

        public Criteria andRivernameNotLike(String value) {
            addCriterion("riverName not like", value, "rivername");
            return (Criteria) this;
        }

        public Criteria andRivernameIn(List<String> values) {
            addCriterion("riverName in", values, "rivername");
            return (Criteria) this;
        }

        public Criteria andRivernameNotIn(List<String> values) {
            addCriterion("riverName not in", values, "rivername");
            return (Criteria) this;
        }

        public Criteria andRivernameBetween(String value1, String value2) {
            addCriterion("riverName between", value1, value2, "rivername");
            return (Criteria) this;
        }

        public Criteria andRivernameNotBetween(String value1, String value2) {
            addCriterion("riverName not between", value1, value2, "rivername");
            return (Criteria) this;
        }

        public Criteria andNameIdIsNull() {
            addCriterion("name_id is null");
            return (Criteria) this;
        }

        public Criteria andNameIdIsNotNull() {
            addCriterion("name_id is not null");
            return (Criteria) this;
        }

        public Criteria andNameIdEqualTo(String value) {
            addCriterion("name_id =", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdNotEqualTo(String value) {
            addCriterion("name_id <>", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdGreaterThan(String value) {
            addCriterion("name_id >", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdGreaterThanOrEqualTo(String value) {
            addCriterion("name_id >=", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdLessThan(String value) {
            addCriterion("name_id <", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdLessThanOrEqualTo(String value) {
            addCriterion("name_id <=", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdLike(String value) {
            addCriterion("name_id like", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdNotLike(String value) {
            addCriterion("name_id not like", value, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdIn(List<String> values) {
            addCriterion("name_id in", values, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdNotIn(List<String> values) {
            addCriterion("name_id not in", values, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdBetween(String value1, String value2) {
            addCriterion("name_id between", value1, value2, "nameId");
            return (Criteria) this;
        }

        public Criteria andNameIdNotBetween(String value1, String value2) {
            addCriterion("name_id not between", value1, value2, "nameId");
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

        public Criteria andLengthIsNull() {
            addCriterion("length is null");
            return (Criteria) this;
        }

        public Criteria andLengthIsNotNull() {
            addCriterion("length is not null");
            return (Criteria) this;
        }

        public Criteria andLengthEqualTo(Double value) {
            addCriterion("length =", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotEqualTo(Double value) {
            addCriterion("length <>", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThan(Double value) {
            addCriterion("length >", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThanOrEqualTo(Double value) {
            addCriterion("length >=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThan(Double value) {
            addCriterion("length <", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThanOrEqualTo(Double value) {
            addCriterion("length <=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthIn(List<Double> values) {
            addCriterion("length in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotIn(List<Double> values) {
            addCriterion("length not in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthBetween(Double value1, Double value2) {
            addCriterion("length between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotBetween(Double value1, Double value2) {
            addCriterion("length not between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andValleyacreageIsNull() {
            addCriterion("valleyAcreage is null");
            return (Criteria) this;
        }

        public Criteria andValleyacreageIsNotNull() {
            addCriterion("valleyAcreage is not null");
            return (Criteria) this;
        }

        public Criteria andValleyacreageEqualTo(Double value) {
            addCriterion("valleyAcreage =", value, "valleyacreage");
            return (Criteria) this;
        }

        public Criteria andValleyacreageNotEqualTo(Double value) {
            addCriterion("valleyAcreage <>", value, "valleyacreage");
            return (Criteria) this;
        }

        public Criteria andValleyacreageGreaterThan(Double value) {
            addCriterion("valleyAcreage >", value, "valleyacreage");
            return (Criteria) this;
        }

        public Criteria andValleyacreageGreaterThanOrEqualTo(Double value) {
            addCriterion("valleyAcreage >=", value, "valleyacreage");
            return (Criteria) this;
        }

        public Criteria andValleyacreageLessThan(Double value) {
            addCriterion("valleyAcreage <", value, "valleyacreage");
            return (Criteria) this;
        }

        public Criteria andValleyacreageLessThanOrEqualTo(Double value) {
            addCriterion("valleyAcreage <=", value, "valleyacreage");
            return (Criteria) this;
        }

        public Criteria andValleyacreageIn(List<Double> values) {
            addCriterion("valleyAcreage in", values, "valleyacreage");
            return (Criteria) this;
        }

        public Criteria andValleyacreageNotIn(List<Double> values) {
            addCriterion("valleyAcreage not in", values, "valleyacreage");
            return (Criteria) this;
        }

        public Criteria andValleyacreageBetween(Double value1, Double value2) {
            addCriterion("valleyAcreage between", value1, value2, "valleyacreage");
            return (Criteria) this;
        }

        public Criteria andValleyacreageNotBetween(Double value1, Double value2) {
            addCriterion("valleyAcreage not between", value1, value2, "valleyacreage");
            return (Criteria) this;
        }

        public Criteria andWateracreageIsNull() {
            addCriterion("waterAcreage is null");
            return (Criteria) this;
        }

        public Criteria andWateracreageIsNotNull() {
            addCriterion("waterAcreage is not null");
            return (Criteria) this;
        }

        public Criteria andWateracreageEqualTo(Double value) {
            addCriterion("waterAcreage =", value, "wateracreage");
            return (Criteria) this;
        }

        public Criteria andWateracreageNotEqualTo(Double value) {
            addCriterion("waterAcreage <>", value, "wateracreage");
            return (Criteria) this;
        }

        public Criteria andWateracreageGreaterThan(Double value) {
            addCriterion("waterAcreage >", value, "wateracreage");
            return (Criteria) this;
        }

        public Criteria andWateracreageGreaterThanOrEqualTo(Double value) {
            addCriterion("waterAcreage >=", value, "wateracreage");
            return (Criteria) this;
        }

        public Criteria andWateracreageLessThan(Double value) {
            addCriterion("waterAcreage <", value, "wateracreage");
            return (Criteria) this;
        }

        public Criteria andWateracreageLessThanOrEqualTo(Double value) {
            addCriterion("waterAcreage <=", value, "wateracreage");
            return (Criteria) this;
        }

        public Criteria andWateracreageIn(List<Double> values) {
            addCriterion("waterAcreage in", values, "wateracreage");
            return (Criteria) this;
        }

        public Criteria andWateracreageNotIn(List<Double> values) {
            addCriterion("waterAcreage not in", values, "wateracreage");
            return (Criteria) this;
        }

        public Criteria andWateracreageBetween(Double value1, Double value2) {
            addCriterion("waterAcreage between", value1, value2, "wateracreage");
            return (Criteria) this;
        }

        public Criteria andWateracreageNotBetween(Double value1, Double value2) {
            addCriterion("waterAcreage not between", value1, value2, "wateracreage");
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