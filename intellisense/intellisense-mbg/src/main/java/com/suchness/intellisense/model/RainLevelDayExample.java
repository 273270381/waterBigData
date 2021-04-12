package com.suchness.intellisense.model;

import java.util.ArrayList;
import java.util.List;

public class RainLevelDayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RainLevelDayExample() {
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

        public Criteria andStationIdIsNull() {
            addCriterion("station_id is null");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNotNull() {
            addCriterion("station_id is not null");
            return (Criteria) this;
        }

        public Criteria andStationIdEqualTo(String value) {
            addCriterion("station_id =", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotEqualTo(String value) {
            addCriterion("station_id <>", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThan(String value) {
            addCriterion("station_id >", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThanOrEqualTo(String value) {
            addCriterion("station_id >=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThan(String value) {
            addCriterion("station_id <", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThanOrEqualTo(String value) {
            addCriterion("station_id <=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLike(String value) {
            addCriterion("station_id like", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotLike(String value) {
            addCriterion("station_id not like", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdIn(List<String> values) {
            addCriterion("station_id in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotIn(List<String> values) {
            addCriterion("station_id not in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdBetween(String value1, String value2) {
            addCriterion("station_id between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotBetween(String value1, String value2) {
            addCriterion("station_id not between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andDayIsNull() {
            addCriterion("day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(String value) {
            addCriterion("day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(String value) {
            addCriterion("day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(String value) {
            addCriterion("day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(String value) {
            addCriterion("day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(String value) {
            addCriterion("day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(String value) {
            addCriterion("day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLike(String value) {
            addCriterion("day like", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotLike(String value) {
            addCriterion("day not like", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<String> values) {
            addCriterion("day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<String> values) {
            addCriterion("day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(String value1, String value2) {
            addCriterion("day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(String value1, String value2) {
            addCriterion("day not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andZeroHourIsNull() {
            addCriterion("zero_hour is null");
            return (Criteria) this;
        }

        public Criteria andZeroHourIsNotNull() {
            addCriterion("zero_hour is not null");
            return (Criteria) this;
        }

        public Criteria andZeroHourEqualTo(Double value) {
            addCriterion("zero_hour =", value, "zeroHour");
            return (Criteria) this;
        }

        public Criteria andZeroHourNotEqualTo(Double value) {
            addCriterion("zero_hour <>", value, "zeroHour");
            return (Criteria) this;
        }

        public Criteria andZeroHourGreaterThan(Double value) {
            addCriterion("zero_hour >", value, "zeroHour");
            return (Criteria) this;
        }

        public Criteria andZeroHourGreaterThanOrEqualTo(Double value) {
            addCriterion("zero_hour >=", value, "zeroHour");
            return (Criteria) this;
        }

        public Criteria andZeroHourLessThan(Double value) {
            addCriterion("zero_hour <", value, "zeroHour");
            return (Criteria) this;
        }

        public Criteria andZeroHourLessThanOrEqualTo(Double value) {
            addCriterion("zero_hour <=", value, "zeroHour");
            return (Criteria) this;
        }

        public Criteria andZeroHourIn(List<Double> values) {
            addCriterion("zero_hour in", values, "zeroHour");
            return (Criteria) this;
        }

        public Criteria andZeroHourNotIn(List<Double> values) {
            addCriterion("zero_hour not in", values, "zeroHour");
            return (Criteria) this;
        }

        public Criteria andZeroHourBetween(Double value1, Double value2) {
            addCriterion("zero_hour between", value1, value2, "zeroHour");
            return (Criteria) this;
        }

        public Criteria andZeroHourNotBetween(Double value1, Double value2) {
            addCriterion("zero_hour not between", value1, value2, "zeroHour");
            return (Criteria) this;
        }

        public Criteria andFirstHourIsNull() {
            addCriterion("first_hour is null");
            return (Criteria) this;
        }

        public Criteria andFirstHourIsNotNull() {
            addCriterion("first_hour is not null");
            return (Criteria) this;
        }

        public Criteria andFirstHourEqualTo(Double value) {
            addCriterion("first_hour =", value, "firstHour");
            return (Criteria) this;
        }

        public Criteria andFirstHourNotEqualTo(Double value) {
            addCriterion("first_hour <>", value, "firstHour");
            return (Criteria) this;
        }

        public Criteria andFirstHourGreaterThan(Double value) {
            addCriterion("first_hour >", value, "firstHour");
            return (Criteria) this;
        }

        public Criteria andFirstHourGreaterThanOrEqualTo(Double value) {
            addCriterion("first_hour >=", value, "firstHour");
            return (Criteria) this;
        }

        public Criteria andFirstHourLessThan(Double value) {
            addCriterion("first_hour <", value, "firstHour");
            return (Criteria) this;
        }

        public Criteria andFirstHourLessThanOrEqualTo(Double value) {
            addCriterion("first_hour <=", value, "firstHour");
            return (Criteria) this;
        }

        public Criteria andFirstHourIn(List<Double> values) {
            addCriterion("first_hour in", values, "firstHour");
            return (Criteria) this;
        }

        public Criteria andFirstHourNotIn(List<Double> values) {
            addCriterion("first_hour not in", values, "firstHour");
            return (Criteria) this;
        }

        public Criteria andFirstHourBetween(Double value1, Double value2) {
            addCriterion("first_hour between", value1, value2, "firstHour");
            return (Criteria) this;
        }

        public Criteria andFirstHourNotBetween(Double value1, Double value2) {
            addCriterion("first_hour not between", value1, value2, "firstHour");
            return (Criteria) this;
        }

        public Criteria andSecondHourIsNull() {
            addCriterion("second_hour is null");
            return (Criteria) this;
        }

        public Criteria andSecondHourIsNotNull() {
            addCriterion("second_hour is not null");
            return (Criteria) this;
        }

        public Criteria andSecondHourEqualTo(Double value) {
            addCriterion("second_hour =", value, "secondHour");
            return (Criteria) this;
        }

        public Criteria andSecondHourNotEqualTo(Double value) {
            addCriterion("second_hour <>", value, "secondHour");
            return (Criteria) this;
        }

        public Criteria andSecondHourGreaterThan(Double value) {
            addCriterion("second_hour >", value, "secondHour");
            return (Criteria) this;
        }

        public Criteria andSecondHourGreaterThanOrEqualTo(Double value) {
            addCriterion("second_hour >=", value, "secondHour");
            return (Criteria) this;
        }

        public Criteria andSecondHourLessThan(Double value) {
            addCriterion("second_hour <", value, "secondHour");
            return (Criteria) this;
        }

        public Criteria andSecondHourLessThanOrEqualTo(Double value) {
            addCriterion("second_hour <=", value, "secondHour");
            return (Criteria) this;
        }

        public Criteria andSecondHourIn(List<Double> values) {
            addCriterion("second_hour in", values, "secondHour");
            return (Criteria) this;
        }

        public Criteria andSecondHourNotIn(List<Double> values) {
            addCriterion("second_hour not in", values, "secondHour");
            return (Criteria) this;
        }

        public Criteria andSecondHourBetween(Double value1, Double value2) {
            addCriterion("second_hour between", value1, value2, "secondHour");
            return (Criteria) this;
        }

        public Criteria andSecondHourNotBetween(Double value1, Double value2) {
            addCriterion("second_hour not between", value1, value2, "secondHour");
            return (Criteria) this;
        }

        public Criteria andThirdHourIsNull() {
            addCriterion("third_hour is null");
            return (Criteria) this;
        }

        public Criteria andThirdHourIsNotNull() {
            addCriterion("third_hour is not null");
            return (Criteria) this;
        }

        public Criteria andThirdHourEqualTo(Double value) {
            addCriterion("third_hour =", value, "thirdHour");
            return (Criteria) this;
        }

        public Criteria andThirdHourNotEqualTo(Double value) {
            addCriterion("third_hour <>", value, "thirdHour");
            return (Criteria) this;
        }

        public Criteria andThirdHourGreaterThan(Double value) {
            addCriterion("third_hour >", value, "thirdHour");
            return (Criteria) this;
        }

        public Criteria andThirdHourGreaterThanOrEqualTo(Double value) {
            addCriterion("third_hour >=", value, "thirdHour");
            return (Criteria) this;
        }

        public Criteria andThirdHourLessThan(Double value) {
            addCriterion("third_hour <", value, "thirdHour");
            return (Criteria) this;
        }

        public Criteria andThirdHourLessThanOrEqualTo(Double value) {
            addCriterion("third_hour <=", value, "thirdHour");
            return (Criteria) this;
        }

        public Criteria andThirdHourIn(List<Double> values) {
            addCriterion("third_hour in", values, "thirdHour");
            return (Criteria) this;
        }

        public Criteria andThirdHourNotIn(List<Double> values) {
            addCriterion("third_hour not in", values, "thirdHour");
            return (Criteria) this;
        }

        public Criteria andThirdHourBetween(Double value1, Double value2) {
            addCriterion("third_hour between", value1, value2, "thirdHour");
            return (Criteria) this;
        }

        public Criteria andThirdHourNotBetween(Double value1, Double value2) {
            addCriterion("third_hour not between", value1, value2, "thirdHour");
            return (Criteria) this;
        }

        public Criteria andFourthHourIsNull() {
            addCriterion("fourth_hour is null");
            return (Criteria) this;
        }

        public Criteria andFourthHourIsNotNull() {
            addCriterion("fourth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andFourthHourEqualTo(Double value) {
            addCriterion("fourth_hour =", value, "fourthHour");
            return (Criteria) this;
        }

        public Criteria andFourthHourNotEqualTo(Double value) {
            addCriterion("fourth_hour <>", value, "fourthHour");
            return (Criteria) this;
        }

        public Criteria andFourthHourGreaterThan(Double value) {
            addCriterion("fourth_hour >", value, "fourthHour");
            return (Criteria) this;
        }

        public Criteria andFourthHourGreaterThanOrEqualTo(Double value) {
            addCriterion("fourth_hour >=", value, "fourthHour");
            return (Criteria) this;
        }

        public Criteria andFourthHourLessThan(Double value) {
            addCriterion("fourth_hour <", value, "fourthHour");
            return (Criteria) this;
        }

        public Criteria andFourthHourLessThanOrEqualTo(Double value) {
            addCriterion("fourth_hour <=", value, "fourthHour");
            return (Criteria) this;
        }

        public Criteria andFourthHourIn(List<Double> values) {
            addCriterion("fourth_hour in", values, "fourthHour");
            return (Criteria) this;
        }

        public Criteria andFourthHourNotIn(List<Double> values) {
            addCriterion("fourth_hour not in", values, "fourthHour");
            return (Criteria) this;
        }

        public Criteria andFourthHourBetween(Double value1, Double value2) {
            addCriterion("fourth_hour between", value1, value2, "fourthHour");
            return (Criteria) this;
        }

        public Criteria andFourthHourNotBetween(Double value1, Double value2) {
            addCriterion("fourth_hour not between", value1, value2, "fourthHour");
            return (Criteria) this;
        }

        public Criteria andFifthHourIsNull() {
            addCriterion("fifth_hour is null");
            return (Criteria) this;
        }

        public Criteria andFifthHourIsNotNull() {
            addCriterion("fifth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andFifthHourEqualTo(Double value) {
            addCriterion("fifth_hour =", value, "fifthHour");
            return (Criteria) this;
        }

        public Criteria andFifthHourNotEqualTo(Double value) {
            addCriterion("fifth_hour <>", value, "fifthHour");
            return (Criteria) this;
        }

        public Criteria andFifthHourGreaterThan(Double value) {
            addCriterion("fifth_hour >", value, "fifthHour");
            return (Criteria) this;
        }

        public Criteria andFifthHourGreaterThanOrEqualTo(Double value) {
            addCriterion("fifth_hour >=", value, "fifthHour");
            return (Criteria) this;
        }

        public Criteria andFifthHourLessThan(Double value) {
            addCriterion("fifth_hour <", value, "fifthHour");
            return (Criteria) this;
        }

        public Criteria andFifthHourLessThanOrEqualTo(Double value) {
            addCriterion("fifth_hour <=", value, "fifthHour");
            return (Criteria) this;
        }

        public Criteria andFifthHourIn(List<Double> values) {
            addCriterion("fifth_hour in", values, "fifthHour");
            return (Criteria) this;
        }

        public Criteria andFifthHourNotIn(List<Double> values) {
            addCriterion("fifth_hour not in", values, "fifthHour");
            return (Criteria) this;
        }

        public Criteria andFifthHourBetween(Double value1, Double value2) {
            addCriterion("fifth_hour between", value1, value2, "fifthHour");
            return (Criteria) this;
        }

        public Criteria andFifthHourNotBetween(Double value1, Double value2) {
            addCriterion("fifth_hour not between", value1, value2, "fifthHour");
            return (Criteria) this;
        }

        public Criteria andSixthHourIsNull() {
            addCriterion("sixth_hour is null");
            return (Criteria) this;
        }

        public Criteria andSixthHourIsNotNull() {
            addCriterion("sixth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andSixthHourEqualTo(Double value) {
            addCriterion("sixth_hour =", value, "sixthHour");
            return (Criteria) this;
        }

        public Criteria andSixthHourNotEqualTo(Double value) {
            addCriterion("sixth_hour <>", value, "sixthHour");
            return (Criteria) this;
        }

        public Criteria andSixthHourGreaterThan(Double value) {
            addCriterion("sixth_hour >", value, "sixthHour");
            return (Criteria) this;
        }

        public Criteria andSixthHourGreaterThanOrEqualTo(Double value) {
            addCriterion("sixth_hour >=", value, "sixthHour");
            return (Criteria) this;
        }

        public Criteria andSixthHourLessThan(Double value) {
            addCriterion("sixth_hour <", value, "sixthHour");
            return (Criteria) this;
        }

        public Criteria andSixthHourLessThanOrEqualTo(Double value) {
            addCriterion("sixth_hour <=", value, "sixthHour");
            return (Criteria) this;
        }

        public Criteria andSixthHourIn(List<Double> values) {
            addCriterion("sixth_hour in", values, "sixthHour");
            return (Criteria) this;
        }

        public Criteria andSixthHourNotIn(List<Double> values) {
            addCriterion("sixth_hour not in", values, "sixthHour");
            return (Criteria) this;
        }

        public Criteria andSixthHourBetween(Double value1, Double value2) {
            addCriterion("sixth_hour between", value1, value2, "sixthHour");
            return (Criteria) this;
        }

        public Criteria andSixthHourNotBetween(Double value1, Double value2) {
            addCriterion("sixth_hour not between", value1, value2, "sixthHour");
            return (Criteria) this;
        }

        public Criteria andSeventhHourIsNull() {
            addCriterion("seventh_hour is null");
            return (Criteria) this;
        }

        public Criteria andSeventhHourIsNotNull() {
            addCriterion("seventh_hour is not null");
            return (Criteria) this;
        }

        public Criteria andSeventhHourEqualTo(Double value) {
            addCriterion("seventh_hour =", value, "seventhHour");
            return (Criteria) this;
        }

        public Criteria andSeventhHourNotEqualTo(Double value) {
            addCriterion("seventh_hour <>", value, "seventhHour");
            return (Criteria) this;
        }

        public Criteria andSeventhHourGreaterThan(Double value) {
            addCriterion("seventh_hour >", value, "seventhHour");
            return (Criteria) this;
        }

        public Criteria andSeventhHourGreaterThanOrEqualTo(Double value) {
            addCriterion("seventh_hour >=", value, "seventhHour");
            return (Criteria) this;
        }

        public Criteria andSeventhHourLessThan(Double value) {
            addCriterion("seventh_hour <", value, "seventhHour");
            return (Criteria) this;
        }

        public Criteria andSeventhHourLessThanOrEqualTo(Double value) {
            addCriterion("seventh_hour <=", value, "seventhHour");
            return (Criteria) this;
        }

        public Criteria andSeventhHourIn(List<Double> values) {
            addCriterion("seventh_hour in", values, "seventhHour");
            return (Criteria) this;
        }

        public Criteria andSeventhHourNotIn(List<Double> values) {
            addCriterion("seventh_hour not in", values, "seventhHour");
            return (Criteria) this;
        }

        public Criteria andSeventhHourBetween(Double value1, Double value2) {
            addCriterion("seventh_hour between", value1, value2, "seventhHour");
            return (Criteria) this;
        }

        public Criteria andSeventhHourNotBetween(Double value1, Double value2) {
            addCriterion("seventh_hour not between", value1, value2, "seventhHour");
            return (Criteria) this;
        }

        public Criteria andEighthHourIsNull() {
            addCriterion("eighth_hour is null");
            return (Criteria) this;
        }

        public Criteria andEighthHourIsNotNull() {
            addCriterion("eighth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andEighthHourEqualTo(Double value) {
            addCriterion("eighth_hour =", value, "eighthHour");
            return (Criteria) this;
        }

        public Criteria andEighthHourNotEqualTo(Double value) {
            addCriterion("eighth_hour <>", value, "eighthHour");
            return (Criteria) this;
        }

        public Criteria andEighthHourGreaterThan(Double value) {
            addCriterion("eighth_hour >", value, "eighthHour");
            return (Criteria) this;
        }

        public Criteria andEighthHourGreaterThanOrEqualTo(Double value) {
            addCriterion("eighth_hour >=", value, "eighthHour");
            return (Criteria) this;
        }

        public Criteria andEighthHourLessThan(Double value) {
            addCriterion("eighth_hour <", value, "eighthHour");
            return (Criteria) this;
        }

        public Criteria andEighthHourLessThanOrEqualTo(Double value) {
            addCriterion("eighth_hour <=", value, "eighthHour");
            return (Criteria) this;
        }

        public Criteria andEighthHourIn(List<Double> values) {
            addCriterion("eighth_hour in", values, "eighthHour");
            return (Criteria) this;
        }

        public Criteria andEighthHourNotIn(List<Double> values) {
            addCriterion("eighth_hour not in", values, "eighthHour");
            return (Criteria) this;
        }

        public Criteria andEighthHourBetween(Double value1, Double value2) {
            addCriterion("eighth_hour between", value1, value2, "eighthHour");
            return (Criteria) this;
        }

        public Criteria andEighthHourNotBetween(Double value1, Double value2) {
            addCriterion("eighth_hour not between", value1, value2, "eighthHour");
            return (Criteria) this;
        }

        public Criteria andNinthHourIsNull() {
            addCriterion("ninth_hour is null");
            return (Criteria) this;
        }

        public Criteria andNinthHourIsNotNull() {
            addCriterion("ninth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andNinthHourEqualTo(Double value) {
            addCriterion("ninth_hour =", value, "ninthHour");
            return (Criteria) this;
        }

        public Criteria andNinthHourNotEqualTo(Double value) {
            addCriterion("ninth_hour <>", value, "ninthHour");
            return (Criteria) this;
        }

        public Criteria andNinthHourGreaterThan(Double value) {
            addCriterion("ninth_hour >", value, "ninthHour");
            return (Criteria) this;
        }

        public Criteria andNinthHourGreaterThanOrEqualTo(Double value) {
            addCriterion("ninth_hour >=", value, "ninthHour");
            return (Criteria) this;
        }

        public Criteria andNinthHourLessThan(Double value) {
            addCriterion("ninth_hour <", value, "ninthHour");
            return (Criteria) this;
        }

        public Criteria andNinthHourLessThanOrEqualTo(Double value) {
            addCriterion("ninth_hour <=", value, "ninthHour");
            return (Criteria) this;
        }

        public Criteria andNinthHourIn(List<Double> values) {
            addCriterion("ninth_hour in", values, "ninthHour");
            return (Criteria) this;
        }

        public Criteria andNinthHourNotIn(List<Double> values) {
            addCriterion("ninth_hour not in", values, "ninthHour");
            return (Criteria) this;
        }

        public Criteria andNinthHourBetween(Double value1, Double value2) {
            addCriterion("ninth_hour between", value1, value2, "ninthHour");
            return (Criteria) this;
        }

        public Criteria andNinthHourNotBetween(Double value1, Double value2) {
            addCriterion("ninth_hour not between", value1, value2, "ninthHour");
            return (Criteria) this;
        }

        public Criteria andTenthHourIsNull() {
            addCriterion("tenth_hour is null");
            return (Criteria) this;
        }

        public Criteria andTenthHourIsNotNull() {
            addCriterion("tenth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andTenthHourEqualTo(Double value) {
            addCriterion("tenth_hour =", value, "tenthHour");
            return (Criteria) this;
        }

        public Criteria andTenthHourNotEqualTo(Double value) {
            addCriterion("tenth_hour <>", value, "tenthHour");
            return (Criteria) this;
        }

        public Criteria andTenthHourGreaterThan(Double value) {
            addCriterion("tenth_hour >", value, "tenthHour");
            return (Criteria) this;
        }

        public Criteria andTenthHourGreaterThanOrEqualTo(Double value) {
            addCriterion("tenth_hour >=", value, "tenthHour");
            return (Criteria) this;
        }

        public Criteria andTenthHourLessThan(Double value) {
            addCriterion("tenth_hour <", value, "tenthHour");
            return (Criteria) this;
        }

        public Criteria andTenthHourLessThanOrEqualTo(Double value) {
            addCriterion("tenth_hour <=", value, "tenthHour");
            return (Criteria) this;
        }

        public Criteria andTenthHourIn(List<Double> values) {
            addCriterion("tenth_hour in", values, "tenthHour");
            return (Criteria) this;
        }

        public Criteria andTenthHourNotIn(List<Double> values) {
            addCriterion("tenth_hour not in", values, "tenthHour");
            return (Criteria) this;
        }

        public Criteria andTenthHourBetween(Double value1, Double value2) {
            addCriterion("tenth_hour between", value1, value2, "tenthHour");
            return (Criteria) this;
        }

        public Criteria andTenthHourNotBetween(Double value1, Double value2) {
            addCriterion("tenth_hour not between", value1, value2, "tenthHour");
            return (Criteria) this;
        }

        public Criteria andEleventhHourIsNull() {
            addCriterion("eleventh_hour is null");
            return (Criteria) this;
        }

        public Criteria andEleventhHourIsNotNull() {
            addCriterion("eleventh_hour is not null");
            return (Criteria) this;
        }

        public Criteria andEleventhHourEqualTo(Double value) {
            addCriterion("eleventh_hour =", value, "eleventhHour");
            return (Criteria) this;
        }

        public Criteria andEleventhHourNotEqualTo(Double value) {
            addCriterion("eleventh_hour <>", value, "eleventhHour");
            return (Criteria) this;
        }

        public Criteria andEleventhHourGreaterThan(Double value) {
            addCriterion("eleventh_hour >", value, "eleventhHour");
            return (Criteria) this;
        }

        public Criteria andEleventhHourGreaterThanOrEqualTo(Double value) {
            addCriterion("eleventh_hour >=", value, "eleventhHour");
            return (Criteria) this;
        }

        public Criteria andEleventhHourLessThan(Double value) {
            addCriterion("eleventh_hour <", value, "eleventhHour");
            return (Criteria) this;
        }

        public Criteria andEleventhHourLessThanOrEqualTo(Double value) {
            addCriterion("eleventh_hour <=", value, "eleventhHour");
            return (Criteria) this;
        }

        public Criteria andEleventhHourIn(List<Double> values) {
            addCriterion("eleventh_hour in", values, "eleventhHour");
            return (Criteria) this;
        }

        public Criteria andEleventhHourNotIn(List<Double> values) {
            addCriterion("eleventh_hour not in", values, "eleventhHour");
            return (Criteria) this;
        }

        public Criteria andEleventhHourBetween(Double value1, Double value2) {
            addCriterion("eleventh_hour between", value1, value2, "eleventhHour");
            return (Criteria) this;
        }

        public Criteria andEleventhHourNotBetween(Double value1, Double value2) {
            addCriterion("eleventh_hour not between", value1, value2, "eleventhHour");
            return (Criteria) this;
        }

        public Criteria andTwelfthHourIsNull() {
            addCriterion("twelfth_hour is null");
            return (Criteria) this;
        }

        public Criteria andTwelfthHourIsNotNull() {
            addCriterion("twelfth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andTwelfthHourEqualTo(Double value) {
            addCriterion("twelfth_hour =", value, "twelfthHour");
            return (Criteria) this;
        }

        public Criteria andTwelfthHourNotEqualTo(Double value) {
            addCriterion("twelfth_hour <>", value, "twelfthHour");
            return (Criteria) this;
        }

        public Criteria andTwelfthHourGreaterThan(Double value) {
            addCriterion("twelfth_hour >", value, "twelfthHour");
            return (Criteria) this;
        }

        public Criteria andTwelfthHourGreaterThanOrEqualTo(Double value) {
            addCriterion("twelfth_hour >=", value, "twelfthHour");
            return (Criteria) this;
        }

        public Criteria andTwelfthHourLessThan(Double value) {
            addCriterion("twelfth_hour <", value, "twelfthHour");
            return (Criteria) this;
        }

        public Criteria andTwelfthHourLessThanOrEqualTo(Double value) {
            addCriterion("twelfth_hour <=", value, "twelfthHour");
            return (Criteria) this;
        }

        public Criteria andTwelfthHourIn(List<Double> values) {
            addCriterion("twelfth_hour in", values, "twelfthHour");
            return (Criteria) this;
        }

        public Criteria andTwelfthHourNotIn(List<Double> values) {
            addCriterion("twelfth_hour not in", values, "twelfthHour");
            return (Criteria) this;
        }

        public Criteria andTwelfthHourBetween(Double value1, Double value2) {
            addCriterion("twelfth_hour between", value1, value2, "twelfthHour");
            return (Criteria) this;
        }

        public Criteria andTwelfthHourNotBetween(Double value1, Double value2) {
            addCriterion("twelfth_hour not between", value1, value2, "twelfthHour");
            return (Criteria) this;
        }

        public Criteria andThirteenthHourIsNull() {
            addCriterion("thirteenth_hour is null");
            return (Criteria) this;
        }

        public Criteria andThirteenthHourIsNotNull() {
            addCriterion("thirteenth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andThirteenthHourEqualTo(Double value) {
            addCriterion("thirteenth_hour =", value, "thirteenthHour");
            return (Criteria) this;
        }

        public Criteria andThirteenthHourNotEqualTo(Double value) {
            addCriterion("thirteenth_hour <>", value, "thirteenthHour");
            return (Criteria) this;
        }

        public Criteria andThirteenthHourGreaterThan(Double value) {
            addCriterion("thirteenth_hour >", value, "thirteenthHour");
            return (Criteria) this;
        }

        public Criteria andThirteenthHourGreaterThanOrEqualTo(Double value) {
            addCriterion("thirteenth_hour >=", value, "thirteenthHour");
            return (Criteria) this;
        }

        public Criteria andThirteenthHourLessThan(Double value) {
            addCriterion("thirteenth_hour <", value, "thirteenthHour");
            return (Criteria) this;
        }

        public Criteria andThirteenthHourLessThanOrEqualTo(Double value) {
            addCriterion("thirteenth_hour <=", value, "thirteenthHour");
            return (Criteria) this;
        }

        public Criteria andThirteenthHourIn(List<Double> values) {
            addCriterion("thirteenth_hour in", values, "thirteenthHour");
            return (Criteria) this;
        }

        public Criteria andThirteenthHourNotIn(List<Double> values) {
            addCriterion("thirteenth_hour not in", values, "thirteenthHour");
            return (Criteria) this;
        }

        public Criteria andThirteenthHourBetween(Double value1, Double value2) {
            addCriterion("thirteenth_hour between", value1, value2, "thirteenthHour");
            return (Criteria) this;
        }

        public Criteria andThirteenthHourNotBetween(Double value1, Double value2) {
            addCriterion("thirteenth_hour not between", value1, value2, "thirteenthHour");
            return (Criteria) this;
        }

        public Criteria andFourteenthHourIsNull() {
            addCriterion("fourteenth_hour is null");
            return (Criteria) this;
        }

        public Criteria andFourteenthHourIsNotNull() {
            addCriterion("fourteenth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andFourteenthHourEqualTo(Double value) {
            addCriterion("fourteenth_hour =", value, "fourteenthHour");
            return (Criteria) this;
        }

        public Criteria andFourteenthHourNotEqualTo(Double value) {
            addCriterion("fourteenth_hour <>", value, "fourteenthHour");
            return (Criteria) this;
        }

        public Criteria andFourteenthHourGreaterThan(Double value) {
            addCriterion("fourteenth_hour >", value, "fourteenthHour");
            return (Criteria) this;
        }

        public Criteria andFourteenthHourGreaterThanOrEqualTo(Double value) {
            addCriterion("fourteenth_hour >=", value, "fourteenthHour");
            return (Criteria) this;
        }

        public Criteria andFourteenthHourLessThan(Double value) {
            addCriterion("fourteenth_hour <", value, "fourteenthHour");
            return (Criteria) this;
        }

        public Criteria andFourteenthHourLessThanOrEqualTo(Double value) {
            addCriterion("fourteenth_hour <=", value, "fourteenthHour");
            return (Criteria) this;
        }

        public Criteria andFourteenthHourIn(List<Double> values) {
            addCriterion("fourteenth_hour in", values, "fourteenthHour");
            return (Criteria) this;
        }

        public Criteria andFourteenthHourNotIn(List<Double> values) {
            addCriterion("fourteenth_hour not in", values, "fourteenthHour");
            return (Criteria) this;
        }

        public Criteria andFourteenthHourBetween(Double value1, Double value2) {
            addCriterion("fourteenth_hour between", value1, value2, "fourteenthHour");
            return (Criteria) this;
        }

        public Criteria andFourteenthHourNotBetween(Double value1, Double value2) {
            addCriterion("fourteenth_hour not between", value1, value2, "fourteenthHour");
            return (Criteria) this;
        }

        public Criteria andFifteenthHourIsNull() {
            addCriterion("fifteenth_hour is null");
            return (Criteria) this;
        }

        public Criteria andFifteenthHourIsNotNull() {
            addCriterion("fifteenth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andFifteenthHourEqualTo(Double value) {
            addCriterion("fifteenth_hour =", value, "fifteenthHour");
            return (Criteria) this;
        }

        public Criteria andFifteenthHourNotEqualTo(Double value) {
            addCriterion("fifteenth_hour <>", value, "fifteenthHour");
            return (Criteria) this;
        }

        public Criteria andFifteenthHourGreaterThan(Double value) {
            addCriterion("fifteenth_hour >", value, "fifteenthHour");
            return (Criteria) this;
        }

        public Criteria andFifteenthHourGreaterThanOrEqualTo(Double value) {
            addCriterion("fifteenth_hour >=", value, "fifteenthHour");
            return (Criteria) this;
        }

        public Criteria andFifteenthHourLessThan(Double value) {
            addCriterion("fifteenth_hour <", value, "fifteenthHour");
            return (Criteria) this;
        }

        public Criteria andFifteenthHourLessThanOrEqualTo(Double value) {
            addCriterion("fifteenth_hour <=", value, "fifteenthHour");
            return (Criteria) this;
        }

        public Criteria andFifteenthHourIn(List<Double> values) {
            addCriterion("fifteenth_hour in", values, "fifteenthHour");
            return (Criteria) this;
        }

        public Criteria andFifteenthHourNotIn(List<Double> values) {
            addCriterion("fifteenth_hour not in", values, "fifteenthHour");
            return (Criteria) this;
        }

        public Criteria andFifteenthHourBetween(Double value1, Double value2) {
            addCriterion("fifteenth_hour between", value1, value2, "fifteenthHour");
            return (Criteria) this;
        }

        public Criteria andFifteenthHourNotBetween(Double value1, Double value2) {
            addCriterion("fifteenth_hour not between", value1, value2, "fifteenthHour");
            return (Criteria) this;
        }

        public Criteria andSixteenthHourIsNull() {
            addCriterion("sixteenth_hour is null");
            return (Criteria) this;
        }

        public Criteria andSixteenthHourIsNotNull() {
            addCriterion("sixteenth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andSixteenthHourEqualTo(Double value) {
            addCriterion("sixteenth_hour =", value, "sixteenthHour");
            return (Criteria) this;
        }

        public Criteria andSixteenthHourNotEqualTo(Double value) {
            addCriterion("sixteenth_hour <>", value, "sixteenthHour");
            return (Criteria) this;
        }

        public Criteria andSixteenthHourGreaterThan(Double value) {
            addCriterion("sixteenth_hour >", value, "sixteenthHour");
            return (Criteria) this;
        }

        public Criteria andSixteenthHourGreaterThanOrEqualTo(Double value) {
            addCriterion("sixteenth_hour >=", value, "sixteenthHour");
            return (Criteria) this;
        }

        public Criteria andSixteenthHourLessThan(Double value) {
            addCriterion("sixteenth_hour <", value, "sixteenthHour");
            return (Criteria) this;
        }

        public Criteria andSixteenthHourLessThanOrEqualTo(Double value) {
            addCriterion("sixteenth_hour <=", value, "sixteenthHour");
            return (Criteria) this;
        }

        public Criteria andSixteenthHourIn(List<Double> values) {
            addCriterion("sixteenth_hour in", values, "sixteenthHour");
            return (Criteria) this;
        }

        public Criteria andSixteenthHourNotIn(List<Double> values) {
            addCriterion("sixteenth_hour not in", values, "sixteenthHour");
            return (Criteria) this;
        }

        public Criteria andSixteenthHourBetween(Double value1, Double value2) {
            addCriterion("sixteenth_hour between", value1, value2, "sixteenthHour");
            return (Criteria) this;
        }

        public Criteria andSixteenthHourNotBetween(Double value1, Double value2) {
            addCriterion("sixteenth_hour not between", value1, value2, "sixteenthHour");
            return (Criteria) this;
        }

        public Criteria andSeventeenthHourIsNull() {
            addCriterion("seventeenth_hour is null");
            return (Criteria) this;
        }

        public Criteria andSeventeenthHourIsNotNull() {
            addCriterion("seventeenth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andSeventeenthHourEqualTo(Double value) {
            addCriterion("seventeenth_hour =", value, "seventeenthHour");
            return (Criteria) this;
        }

        public Criteria andSeventeenthHourNotEqualTo(Double value) {
            addCriterion("seventeenth_hour <>", value, "seventeenthHour");
            return (Criteria) this;
        }

        public Criteria andSeventeenthHourGreaterThan(Double value) {
            addCriterion("seventeenth_hour >", value, "seventeenthHour");
            return (Criteria) this;
        }

        public Criteria andSeventeenthHourGreaterThanOrEqualTo(Double value) {
            addCriterion("seventeenth_hour >=", value, "seventeenthHour");
            return (Criteria) this;
        }

        public Criteria andSeventeenthHourLessThan(Double value) {
            addCriterion("seventeenth_hour <", value, "seventeenthHour");
            return (Criteria) this;
        }

        public Criteria andSeventeenthHourLessThanOrEqualTo(Double value) {
            addCriterion("seventeenth_hour <=", value, "seventeenthHour");
            return (Criteria) this;
        }

        public Criteria andSeventeenthHourIn(List<Double> values) {
            addCriterion("seventeenth_hour in", values, "seventeenthHour");
            return (Criteria) this;
        }

        public Criteria andSeventeenthHourNotIn(List<Double> values) {
            addCriterion("seventeenth_hour not in", values, "seventeenthHour");
            return (Criteria) this;
        }

        public Criteria andSeventeenthHourBetween(Double value1, Double value2) {
            addCriterion("seventeenth_hour between", value1, value2, "seventeenthHour");
            return (Criteria) this;
        }

        public Criteria andSeventeenthHourNotBetween(Double value1, Double value2) {
            addCriterion("seventeenth_hour not between", value1, value2, "seventeenthHour");
            return (Criteria) this;
        }

        public Criteria andEighteenthHourIsNull() {
            addCriterion("eighteenth_hour is null");
            return (Criteria) this;
        }

        public Criteria andEighteenthHourIsNotNull() {
            addCriterion("eighteenth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andEighteenthHourEqualTo(Double value) {
            addCriterion("eighteenth_hour =", value, "eighteenthHour");
            return (Criteria) this;
        }

        public Criteria andEighteenthHourNotEqualTo(Double value) {
            addCriterion("eighteenth_hour <>", value, "eighteenthHour");
            return (Criteria) this;
        }

        public Criteria andEighteenthHourGreaterThan(Double value) {
            addCriterion("eighteenth_hour >", value, "eighteenthHour");
            return (Criteria) this;
        }

        public Criteria andEighteenthHourGreaterThanOrEqualTo(Double value) {
            addCriterion("eighteenth_hour >=", value, "eighteenthHour");
            return (Criteria) this;
        }

        public Criteria andEighteenthHourLessThan(Double value) {
            addCriterion("eighteenth_hour <", value, "eighteenthHour");
            return (Criteria) this;
        }

        public Criteria andEighteenthHourLessThanOrEqualTo(Double value) {
            addCriterion("eighteenth_hour <=", value, "eighteenthHour");
            return (Criteria) this;
        }

        public Criteria andEighteenthHourIn(List<Double> values) {
            addCriterion("eighteenth_hour in", values, "eighteenthHour");
            return (Criteria) this;
        }

        public Criteria andEighteenthHourNotIn(List<Double> values) {
            addCriterion("eighteenth_hour not in", values, "eighteenthHour");
            return (Criteria) this;
        }

        public Criteria andEighteenthHourBetween(Double value1, Double value2) {
            addCriterion("eighteenth_hour between", value1, value2, "eighteenthHour");
            return (Criteria) this;
        }

        public Criteria andEighteenthHourNotBetween(Double value1, Double value2) {
            addCriterion("eighteenth_hour not between", value1, value2, "eighteenthHour");
            return (Criteria) this;
        }

        public Criteria andNineteenthHourIsNull() {
            addCriterion("nineteenth_hour is null");
            return (Criteria) this;
        }

        public Criteria andNineteenthHourIsNotNull() {
            addCriterion("nineteenth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andNineteenthHourEqualTo(Double value) {
            addCriterion("nineteenth_hour =", value, "nineteenthHour");
            return (Criteria) this;
        }

        public Criteria andNineteenthHourNotEqualTo(Double value) {
            addCriterion("nineteenth_hour <>", value, "nineteenthHour");
            return (Criteria) this;
        }

        public Criteria andNineteenthHourGreaterThan(Double value) {
            addCriterion("nineteenth_hour >", value, "nineteenthHour");
            return (Criteria) this;
        }

        public Criteria andNineteenthHourGreaterThanOrEqualTo(Double value) {
            addCriterion("nineteenth_hour >=", value, "nineteenthHour");
            return (Criteria) this;
        }

        public Criteria andNineteenthHourLessThan(Double value) {
            addCriterion("nineteenth_hour <", value, "nineteenthHour");
            return (Criteria) this;
        }

        public Criteria andNineteenthHourLessThanOrEqualTo(Double value) {
            addCriterion("nineteenth_hour <=", value, "nineteenthHour");
            return (Criteria) this;
        }

        public Criteria andNineteenthHourIn(List<Double> values) {
            addCriterion("nineteenth_hour in", values, "nineteenthHour");
            return (Criteria) this;
        }

        public Criteria andNineteenthHourNotIn(List<Double> values) {
            addCriterion("nineteenth_hour not in", values, "nineteenthHour");
            return (Criteria) this;
        }

        public Criteria andNineteenthHourBetween(Double value1, Double value2) {
            addCriterion("nineteenth_hour between", value1, value2, "nineteenthHour");
            return (Criteria) this;
        }

        public Criteria andNineteenthHourNotBetween(Double value1, Double value2) {
            addCriterion("nineteenth_hour not between", value1, value2, "nineteenthHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethHourIsNull() {
            addCriterion("twentieth_hour is null");
            return (Criteria) this;
        }

        public Criteria andTwentiethHourIsNotNull() {
            addCriterion("twentieth_hour is not null");
            return (Criteria) this;
        }

        public Criteria andTwentiethHourEqualTo(Double value) {
            addCriterion("twentieth_hour =", value, "twentiethHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethHourNotEqualTo(Double value) {
            addCriterion("twentieth_hour <>", value, "twentiethHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethHourGreaterThan(Double value) {
            addCriterion("twentieth_hour >", value, "twentiethHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethHourGreaterThanOrEqualTo(Double value) {
            addCriterion("twentieth_hour >=", value, "twentiethHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethHourLessThan(Double value) {
            addCriterion("twentieth_hour <", value, "twentiethHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethHourLessThanOrEqualTo(Double value) {
            addCriterion("twentieth_hour <=", value, "twentiethHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethHourIn(List<Double> values) {
            addCriterion("twentieth_hour in", values, "twentiethHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethHourNotIn(List<Double> values) {
            addCriterion("twentieth_hour not in", values, "twentiethHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethHourBetween(Double value1, Double value2) {
            addCriterion("twentieth_hour between", value1, value2, "twentiethHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethHourNotBetween(Double value1, Double value2) {
            addCriterion("twentieth_hour not between", value1, value2, "twentiethHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethFirstHourIsNull() {
            addCriterion("twentieth_first_hour is null");
            return (Criteria) this;
        }

        public Criteria andTwentiethFirstHourIsNotNull() {
            addCriterion("twentieth_first_hour is not null");
            return (Criteria) this;
        }

        public Criteria andTwentiethFirstHourEqualTo(Double value) {
            addCriterion("twentieth_first_hour =", value, "twentiethFirstHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethFirstHourNotEqualTo(Double value) {
            addCriterion("twentieth_first_hour <>", value, "twentiethFirstHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethFirstHourGreaterThan(Double value) {
            addCriterion("twentieth_first_hour >", value, "twentiethFirstHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethFirstHourGreaterThanOrEqualTo(Double value) {
            addCriterion("twentieth_first_hour >=", value, "twentiethFirstHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethFirstHourLessThan(Double value) {
            addCriterion("twentieth_first_hour <", value, "twentiethFirstHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethFirstHourLessThanOrEqualTo(Double value) {
            addCriterion("twentieth_first_hour <=", value, "twentiethFirstHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethFirstHourIn(List<Double> values) {
            addCriterion("twentieth_first_hour in", values, "twentiethFirstHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethFirstHourNotIn(List<Double> values) {
            addCriterion("twentieth_first_hour not in", values, "twentiethFirstHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethFirstHourBetween(Double value1, Double value2) {
            addCriterion("twentieth_first_hour between", value1, value2, "twentiethFirstHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethFirstHourNotBetween(Double value1, Double value2) {
            addCriterion("twentieth_first_hour not between", value1, value2, "twentiethFirstHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethTwoHourIsNull() {
            addCriterion("twentieth_two_hour is null");
            return (Criteria) this;
        }

        public Criteria andTwentiethTwoHourIsNotNull() {
            addCriterion("twentieth_two_hour is not null");
            return (Criteria) this;
        }

        public Criteria andTwentiethTwoHourEqualTo(Double value) {
            addCriterion("twentieth_two_hour =", value, "twentiethTwoHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethTwoHourNotEqualTo(Double value) {
            addCriterion("twentieth_two_hour <>", value, "twentiethTwoHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethTwoHourGreaterThan(Double value) {
            addCriterion("twentieth_two_hour >", value, "twentiethTwoHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethTwoHourGreaterThanOrEqualTo(Double value) {
            addCriterion("twentieth_two_hour >=", value, "twentiethTwoHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethTwoHourLessThan(Double value) {
            addCriterion("twentieth_two_hour <", value, "twentiethTwoHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethTwoHourLessThanOrEqualTo(Double value) {
            addCriterion("twentieth_two_hour <=", value, "twentiethTwoHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethTwoHourIn(List<Double> values) {
            addCriterion("twentieth_two_hour in", values, "twentiethTwoHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethTwoHourNotIn(List<Double> values) {
            addCriterion("twentieth_two_hour not in", values, "twentiethTwoHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethTwoHourBetween(Double value1, Double value2) {
            addCriterion("twentieth_two_hour between", value1, value2, "twentiethTwoHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethTwoHourNotBetween(Double value1, Double value2) {
            addCriterion("twentieth_two_hour not between", value1, value2, "twentiethTwoHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethThreeHourIsNull() {
            addCriterion("twentieth_three_hour is null");
            return (Criteria) this;
        }

        public Criteria andTwentiethThreeHourIsNotNull() {
            addCriterion("twentieth_three_hour is not null");
            return (Criteria) this;
        }

        public Criteria andTwentiethThreeHourEqualTo(Double value) {
            addCriterion("twentieth_three_hour =", value, "twentiethThreeHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethThreeHourNotEqualTo(Double value) {
            addCriterion("twentieth_three_hour <>", value, "twentiethThreeHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethThreeHourGreaterThan(Double value) {
            addCriterion("twentieth_three_hour >", value, "twentiethThreeHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethThreeHourGreaterThanOrEqualTo(Double value) {
            addCriterion("twentieth_three_hour >=", value, "twentiethThreeHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethThreeHourLessThan(Double value) {
            addCriterion("twentieth_three_hour <", value, "twentiethThreeHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethThreeHourLessThanOrEqualTo(Double value) {
            addCriterion("twentieth_three_hour <=", value, "twentiethThreeHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethThreeHourIn(List<Double> values) {
            addCriterion("twentieth_three_hour in", values, "twentiethThreeHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethThreeHourNotIn(List<Double> values) {
            addCriterion("twentieth_three_hour not in", values, "twentiethThreeHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethThreeHourBetween(Double value1, Double value2) {
            addCriterion("twentieth_three_hour between", value1, value2, "twentiethThreeHour");
            return (Criteria) this;
        }

        public Criteria andTwentiethThreeHourNotBetween(Double value1, Double value2) {
            addCriterion("twentieth_three_hour not between", value1, value2, "twentiethThreeHour");
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