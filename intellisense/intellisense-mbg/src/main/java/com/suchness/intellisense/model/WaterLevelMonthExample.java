package com.suchness.intellisense.model;

import java.util.ArrayList;
import java.util.List;

public class WaterLevelMonthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaterLevelMonthExample() {
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

        public Criteria andStationidIsNull() {
            addCriterion("stationId is null");
            return (Criteria) this;
        }

        public Criteria andStationidIsNotNull() {
            addCriterion("stationId is not null");
            return (Criteria) this;
        }

        public Criteria andStationidEqualTo(String value) {
            addCriterion("stationId =", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotEqualTo(String value) {
            addCriterion("stationId <>", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidGreaterThan(String value) {
            addCriterion("stationId >", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidGreaterThanOrEqualTo(String value) {
            addCriterion("stationId >=", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidLessThan(String value) {
            addCriterion("stationId <", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidLessThanOrEqualTo(String value) {
            addCriterion("stationId <=", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidLike(String value) {
            addCriterion("stationId like", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotLike(String value) {
            addCriterion("stationId not like", value, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidIn(List<String> values) {
            addCriterion("stationId in", values, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotIn(List<String> values) {
            addCriterion("stationId not in", values, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidBetween(String value1, String value2) {
            addCriterion("stationId between", value1, value2, "stationid");
            return (Criteria) this;
        }

        public Criteria andStationidNotBetween(String value1, String value2) {
            addCriterion("stationId not between", value1, value2, "stationid");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(String value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(String value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(String value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(String value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(String value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(String value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLike(String value) {
            addCriterion("date like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotLike(String value) {
            addCriterion("date not like", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<String> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<String> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(String value1, String value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(String value1, String value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andOneIsNull() {
            addCriterion("one is null");
            return (Criteria) this;
        }

        public Criteria andOneIsNotNull() {
            addCriterion("one is not null");
            return (Criteria) this;
        }

        public Criteria andOneEqualTo(Double value) {
            addCriterion("one =", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneNotEqualTo(Double value) {
            addCriterion("one <>", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneGreaterThan(Double value) {
            addCriterion("one >", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneGreaterThanOrEqualTo(Double value) {
            addCriterion("one >=", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneLessThan(Double value) {
            addCriterion("one <", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneLessThanOrEqualTo(Double value) {
            addCriterion("one <=", value, "one");
            return (Criteria) this;
        }

        public Criteria andOneIn(List<Double> values) {
            addCriterion("one in", values, "one");
            return (Criteria) this;
        }

        public Criteria andOneNotIn(List<Double> values) {
            addCriterion("one not in", values, "one");
            return (Criteria) this;
        }

        public Criteria andOneBetween(Double value1, Double value2) {
            addCriterion("one between", value1, value2, "one");
            return (Criteria) this;
        }

        public Criteria andOneNotBetween(Double value1, Double value2) {
            addCriterion("one not between", value1, value2, "one");
            return (Criteria) this;
        }

        public Criteria andTwoIsNull() {
            addCriterion("two is null");
            return (Criteria) this;
        }

        public Criteria andTwoIsNotNull() {
            addCriterion("two is not null");
            return (Criteria) this;
        }

        public Criteria andTwoEqualTo(Double value) {
            addCriterion("two =", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoNotEqualTo(Double value) {
            addCriterion("two <>", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoGreaterThan(Double value) {
            addCriterion("two >", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoGreaterThanOrEqualTo(Double value) {
            addCriterion("two >=", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoLessThan(Double value) {
            addCriterion("two <", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoLessThanOrEqualTo(Double value) {
            addCriterion("two <=", value, "two");
            return (Criteria) this;
        }

        public Criteria andTwoIn(List<Double> values) {
            addCriterion("two in", values, "two");
            return (Criteria) this;
        }

        public Criteria andTwoNotIn(List<Double> values) {
            addCriterion("two not in", values, "two");
            return (Criteria) this;
        }

        public Criteria andTwoBetween(Double value1, Double value2) {
            addCriterion("two between", value1, value2, "two");
            return (Criteria) this;
        }

        public Criteria andTwoNotBetween(Double value1, Double value2) {
            addCriterion("two not between", value1, value2, "two");
            return (Criteria) this;
        }

        public Criteria andThreeIsNull() {
            addCriterion("three is null");
            return (Criteria) this;
        }

        public Criteria andThreeIsNotNull() {
            addCriterion("three is not null");
            return (Criteria) this;
        }

        public Criteria andThreeEqualTo(Double value) {
            addCriterion("three =", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeNotEqualTo(Double value) {
            addCriterion("three <>", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeGreaterThan(Double value) {
            addCriterion("three >", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeGreaterThanOrEqualTo(Double value) {
            addCriterion("three >=", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeLessThan(Double value) {
            addCriterion("three <", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeLessThanOrEqualTo(Double value) {
            addCriterion("three <=", value, "three");
            return (Criteria) this;
        }

        public Criteria andThreeIn(List<Double> values) {
            addCriterion("three in", values, "three");
            return (Criteria) this;
        }

        public Criteria andThreeNotIn(List<Double> values) {
            addCriterion("three not in", values, "three");
            return (Criteria) this;
        }

        public Criteria andThreeBetween(Double value1, Double value2) {
            addCriterion("three between", value1, value2, "three");
            return (Criteria) this;
        }

        public Criteria andThreeNotBetween(Double value1, Double value2) {
            addCriterion("three not between", value1, value2, "three");
            return (Criteria) this;
        }

        public Criteria andFourIsNull() {
            addCriterion("four is null");
            return (Criteria) this;
        }

        public Criteria andFourIsNotNull() {
            addCriterion("four is not null");
            return (Criteria) this;
        }

        public Criteria andFourEqualTo(Double value) {
            addCriterion("four =", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourNotEqualTo(Double value) {
            addCriterion("four <>", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourGreaterThan(Double value) {
            addCriterion("four >", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourGreaterThanOrEqualTo(Double value) {
            addCriterion("four >=", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourLessThan(Double value) {
            addCriterion("four <", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourLessThanOrEqualTo(Double value) {
            addCriterion("four <=", value, "four");
            return (Criteria) this;
        }

        public Criteria andFourIn(List<Double> values) {
            addCriterion("four in", values, "four");
            return (Criteria) this;
        }

        public Criteria andFourNotIn(List<Double> values) {
            addCriterion("four not in", values, "four");
            return (Criteria) this;
        }

        public Criteria andFourBetween(Double value1, Double value2) {
            addCriterion("four between", value1, value2, "four");
            return (Criteria) this;
        }

        public Criteria andFourNotBetween(Double value1, Double value2) {
            addCriterion("four not between", value1, value2, "four");
            return (Criteria) this;
        }

        public Criteria andFiveIsNull() {
            addCriterion("five is null");
            return (Criteria) this;
        }

        public Criteria andFiveIsNotNull() {
            addCriterion("five is not null");
            return (Criteria) this;
        }

        public Criteria andFiveEqualTo(Double value) {
            addCriterion("five =", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveNotEqualTo(Double value) {
            addCriterion("five <>", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveGreaterThan(Double value) {
            addCriterion("five >", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveGreaterThanOrEqualTo(Double value) {
            addCriterion("five >=", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveLessThan(Double value) {
            addCriterion("five <", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveLessThanOrEqualTo(Double value) {
            addCriterion("five <=", value, "five");
            return (Criteria) this;
        }

        public Criteria andFiveIn(List<Double> values) {
            addCriterion("five in", values, "five");
            return (Criteria) this;
        }

        public Criteria andFiveNotIn(List<Double> values) {
            addCriterion("five not in", values, "five");
            return (Criteria) this;
        }

        public Criteria andFiveBetween(Double value1, Double value2) {
            addCriterion("five between", value1, value2, "five");
            return (Criteria) this;
        }

        public Criteria andFiveNotBetween(Double value1, Double value2) {
            addCriterion("five not between", value1, value2, "five");
            return (Criteria) this;
        }

        public Criteria andSixIsNull() {
            addCriterion("six is null");
            return (Criteria) this;
        }

        public Criteria andSixIsNotNull() {
            addCriterion("six is not null");
            return (Criteria) this;
        }

        public Criteria andSixEqualTo(Double value) {
            addCriterion("six =", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixNotEqualTo(Double value) {
            addCriterion("six <>", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixGreaterThan(Double value) {
            addCriterion("six >", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixGreaterThanOrEqualTo(Double value) {
            addCriterion("six >=", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixLessThan(Double value) {
            addCriterion("six <", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixLessThanOrEqualTo(Double value) {
            addCriterion("six <=", value, "six");
            return (Criteria) this;
        }

        public Criteria andSixIn(List<Double> values) {
            addCriterion("six in", values, "six");
            return (Criteria) this;
        }

        public Criteria andSixNotIn(List<Double> values) {
            addCriterion("six not in", values, "six");
            return (Criteria) this;
        }

        public Criteria andSixBetween(Double value1, Double value2) {
            addCriterion("six between", value1, value2, "six");
            return (Criteria) this;
        }

        public Criteria andSixNotBetween(Double value1, Double value2) {
            addCriterion("six not between", value1, value2, "six");
            return (Criteria) this;
        }

        public Criteria andSevenIsNull() {
            addCriterion("seven is null");
            return (Criteria) this;
        }

        public Criteria andSevenIsNotNull() {
            addCriterion("seven is not null");
            return (Criteria) this;
        }

        public Criteria andSevenEqualTo(Double value) {
            addCriterion("seven =", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenNotEqualTo(Double value) {
            addCriterion("seven <>", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenGreaterThan(Double value) {
            addCriterion("seven >", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenGreaterThanOrEqualTo(Double value) {
            addCriterion("seven >=", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenLessThan(Double value) {
            addCriterion("seven <", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenLessThanOrEqualTo(Double value) {
            addCriterion("seven <=", value, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenIn(List<Double> values) {
            addCriterion("seven in", values, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenNotIn(List<Double> values) {
            addCriterion("seven not in", values, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenBetween(Double value1, Double value2) {
            addCriterion("seven between", value1, value2, "seven");
            return (Criteria) this;
        }

        public Criteria andSevenNotBetween(Double value1, Double value2) {
            addCriterion("seven not between", value1, value2, "seven");
            return (Criteria) this;
        }

        public Criteria andEightIsNull() {
            addCriterion("eight is null");
            return (Criteria) this;
        }

        public Criteria andEightIsNotNull() {
            addCriterion("eight is not null");
            return (Criteria) this;
        }

        public Criteria andEightEqualTo(Double value) {
            addCriterion("eight =", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightNotEqualTo(Double value) {
            addCriterion("eight <>", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightGreaterThan(Double value) {
            addCriterion("eight >", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightGreaterThanOrEqualTo(Double value) {
            addCriterion("eight >=", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightLessThan(Double value) {
            addCriterion("eight <", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightLessThanOrEqualTo(Double value) {
            addCriterion("eight <=", value, "eight");
            return (Criteria) this;
        }

        public Criteria andEightIn(List<Double> values) {
            addCriterion("eight in", values, "eight");
            return (Criteria) this;
        }

        public Criteria andEightNotIn(List<Double> values) {
            addCriterion("eight not in", values, "eight");
            return (Criteria) this;
        }

        public Criteria andEightBetween(Double value1, Double value2) {
            addCriterion("eight between", value1, value2, "eight");
            return (Criteria) this;
        }

        public Criteria andEightNotBetween(Double value1, Double value2) {
            addCriterion("eight not between", value1, value2, "eight");
            return (Criteria) this;
        }

        public Criteria andNineIsNull() {
            addCriterion("nine is null");
            return (Criteria) this;
        }

        public Criteria andNineIsNotNull() {
            addCriterion("nine is not null");
            return (Criteria) this;
        }

        public Criteria andNineEqualTo(Double value) {
            addCriterion("nine =", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineNotEqualTo(Double value) {
            addCriterion("nine <>", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineGreaterThan(Double value) {
            addCriterion("nine >", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineGreaterThanOrEqualTo(Double value) {
            addCriterion("nine >=", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineLessThan(Double value) {
            addCriterion("nine <", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineLessThanOrEqualTo(Double value) {
            addCriterion("nine <=", value, "nine");
            return (Criteria) this;
        }

        public Criteria andNineIn(List<Double> values) {
            addCriterion("nine in", values, "nine");
            return (Criteria) this;
        }

        public Criteria andNineNotIn(List<Double> values) {
            addCriterion("nine not in", values, "nine");
            return (Criteria) this;
        }

        public Criteria andNineBetween(Double value1, Double value2) {
            addCriterion("nine between", value1, value2, "nine");
            return (Criteria) this;
        }

        public Criteria andNineNotBetween(Double value1, Double value2) {
            addCriterion("nine not between", value1, value2, "nine");
            return (Criteria) this;
        }

        public Criteria andTenIsNull() {
            addCriterion("ten is null");
            return (Criteria) this;
        }

        public Criteria andTenIsNotNull() {
            addCriterion("ten is not null");
            return (Criteria) this;
        }

        public Criteria andTenEqualTo(Double value) {
            addCriterion("ten =", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotEqualTo(Double value) {
            addCriterion("ten <>", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenGreaterThan(Double value) {
            addCriterion("ten >", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenGreaterThanOrEqualTo(Double value) {
            addCriterion("ten >=", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenLessThan(Double value) {
            addCriterion("ten <", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenLessThanOrEqualTo(Double value) {
            addCriterion("ten <=", value, "ten");
            return (Criteria) this;
        }

        public Criteria andTenIn(List<Double> values) {
            addCriterion("ten in", values, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotIn(List<Double> values) {
            addCriterion("ten not in", values, "ten");
            return (Criteria) this;
        }

        public Criteria andTenBetween(Double value1, Double value2) {
            addCriterion("ten between", value1, value2, "ten");
            return (Criteria) this;
        }

        public Criteria andTenNotBetween(Double value1, Double value2) {
            addCriterion("ten not between", value1, value2, "ten");
            return (Criteria) this;
        }

        public Criteria andElevenIsNull() {
            addCriterion("eleven is null");
            return (Criteria) this;
        }

        public Criteria andElevenIsNotNull() {
            addCriterion("eleven is not null");
            return (Criteria) this;
        }

        public Criteria andElevenEqualTo(Double value) {
            addCriterion("eleven =", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenNotEqualTo(Double value) {
            addCriterion("eleven <>", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenGreaterThan(Double value) {
            addCriterion("eleven >", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenGreaterThanOrEqualTo(Double value) {
            addCriterion("eleven >=", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenLessThan(Double value) {
            addCriterion("eleven <", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenLessThanOrEqualTo(Double value) {
            addCriterion("eleven <=", value, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenIn(List<Double> values) {
            addCriterion("eleven in", values, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenNotIn(List<Double> values) {
            addCriterion("eleven not in", values, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenBetween(Double value1, Double value2) {
            addCriterion("eleven between", value1, value2, "eleven");
            return (Criteria) this;
        }

        public Criteria andElevenNotBetween(Double value1, Double value2) {
            addCriterion("eleven not between", value1, value2, "eleven");
            return (Criteria) this;
        }

        public Criteria andTwelveIsNull() {
            addCriterion("twelve is null");
            return (Criteria) this;
        }

        public Criteria andTwelveIsNotNull() {
            addCriterion("twelve is not null");
            return (Criteria) this;
        }

        public Criteria andTwelveEqualTo(Double value) {
            addCriterion("twelve =", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveNotEqualTo(Double value) {
            addCriterion("twelve <>", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveGreaterThan(Double value) {
            addCriterion("twelve >", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveGreaterThanOrEqualTo(Double value) {
            addCriterion("twelve >=", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveLessThan(Double value) {
            addCriterion("twelve <", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveLessThanOrEqualTo(Double value) {
            addCriterion("twelve <=", value, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveIn(List<Double> values) {
            addCriterion("twelve in", values, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveNotIn(List<Double> values) {
            addCriterion("twelve not in", values, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveBetween(Double value1, Double value2) {
            addCriterion("twelve between", value1, value2, "twelve");
            return (Criteria) this;
        }

        public Criteria andTwelveNotBetween(Double value1, Double value2) {
            addCriterion("twelve not between", value1, value2, "twelve");
            return (Criteria) this;
        }

        public Criteria andThirteenIsNull() {
            addCriterion("thirteen is null");
            return (Criteria) this;
        }

        public Criteria andThirteenIsNotNull() {
            addCriterion("thirteen is not null");
            return (Criteria) this;
        }

        public Criteria andThirteenEqualTo(Double value) {
            addCriterion("thirteen =", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenNotEqualTo(Double value) {
            addCriterion("thirteen <>", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenGreaterThan(Double value) {
            addCriterion("thirteen >", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenGreaterThanOrEqualTo(Double value) {
            addCriterion("thirteen >=", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenLessThan(Double value) {
            addCriterion("thirteen <", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenLessThanOrEqualTo(Double value) {
            addCriterion("thirteen <=", value, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenIn(List<Double> values) {
            addCriterion("thirteen in", values, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenNotIn(List<Double> values) {
            addCriterion("thirteen not in", values, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenBetween(Double value1, Double value2) {
            addCriterion("thirteen between", value1, value2, "thirteen");
            return (Criteria) this;
        }

        public Criteria andThirteenNotBetween(Double value1, Double value2) {
            addCriterion("thirteen not between", value1, value2, "thirteen");
            return (Criteria) this;
        }

        public Criteria andFourteenIsNull() {
            addCriterion("fourteen is null");
            return (Criteria) this;
        }

        public Criteria andFourteenIsNotNull() {
            addCriterion("fourteen is not null");
            return (Criteria) this;
        }

        public Criteria andFourteenEqualTo(Double value) {
            addCriterion("fourteen =", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenNotEqualTo(Double value) {
            addCriterion("fourteen <>", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenGreaterThan(Double value) {
            addCriterion("fourteen >", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenGreaterThanOrEqualTo(Double value) {
            addCriterion("fourteen >=", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenLessThan(Double value) {
            addCriterion("fourteen <", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenLessThanOrEqualTo(Double value) {
            addCriterion("fourteen <=", value, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenIn(List<Double> values) {
            addCriterion("fourteen in", values, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenNotIn(List<Double> values) {
            addCriterion("fourteen not in", values, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenBetween(Double value1, Double value2) {
            addCriterion("fourteen between", value1, value2, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFourteenNotBetween(Double value1, Double value2) {
            addCriterion("fourteen not between", value1, value2, "fourteen");
            return (Criteria) this;
        }

        public Criteria andFifteenIsNull() {
            addCriterion("fifteen is null");
            return (Criteria) this;
        }

        public Criteria andFifteenIsNotNull() {
            addCriterion("fifteen is not null");
            return (Criteria) this;
        }

        public Criteria andFifteenEqualTo(Double value) {
            addCriterion("fifteen =", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenNotEqualTo(Double value) {
            addCriterion("fifteen <>", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenGreaterThan(Double value) {
            addCriterion("fifteen >", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenGreaterThanOrEqualTo(Double value) {
            addCriterion("fifteen >=", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenLessThan(Double value) {
            addCriterion("fifteen <", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenLessThanOrEqualTo(Double value) {
            addCriterion("fifteen <=", value, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenIn(List<Double> values) {
            addCriterion("fifteen in", values, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenNotIn(List<Double> values) {
            addCriterion("fifteen not in", values, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenBetween(Double value1, Double value2) {
            addCriterion("fifteen between", value1, value2, "fifteen");
            return (Criteria) this;
        }

        public Criteria andFifteenNotBetween(Double value1, Double value2) {
            addCriterion("fifteen not between", value1, value2, "fifteen");
            return (Criteria) this;
        }

        public Criteria andSixteenIsNull() {
            addCriterion("sixteen is null");
            return (Criteria) this;
        }

        public Criteria andSixteenIsNotNull() {
            addCriterion("sixteen is not null");
            return (Criteria) this;
        }

        public Criteria andSixteenEqualTo(Double value) {
            addCriterion("sixteen =", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenNotEqualTo(Double value) {
            addCriterion("sixteen <>", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenGreaterThan(Double value) {
            addCriterion("sixteen >", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenGreaterThanOrEqualTo(Double value) {
            addCriterion("sixteen >=", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenLessThan(Double value) {
            addCriterion("sixteen <", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenLessThanOrEqualTo(Double value) {
            addCriterion("sixteen <=", value, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenIn(List<Double> values) {
            addCriterion("sixteen in", values, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenNotIn(List<Double> values) {
            addCriterion("sixteen not in", values, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenBetween(Double value1, Double value2) {
            addCriterion("sixteen between", value1, value2, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSixteenNotBetween(Double value1, Double value2) {
            addCriterion("sixteen not between", value1, value2, "sixteen");
            return (Criteria) this;
        }

        public Criteria andSeventeenIsNull() {
            addCriterion("seventeen is null");
            return (Criteria) this;
        }

        public Criteria andSeventeenIsNotNull() {
            addCriterion("seventeen is not null");
            return (Criteria) this;
        }

        public Criteria andSeventeenEqualTo(Double value) {
            addCriterion("seventeen =", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenNotEqualTo(Double value) {
            addCriterion("seventeen <>", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenGreaterThan(Double value) {
            addCriterion("seventeen >", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenGreaterThanOrEqualTo(Double value) {
            addCriterion("seventeen >=", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenLessThan(Double value) {
            addCriterion("seventeen <", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenLessThanOrEqualTo(Double value) {
            addCriterion("seventeen <=", value, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenIn(List<Double> values) {
            addCriterion("seventeen in", values, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenNotIn(List<Double> values) {
            addCriterion("seventeen not in", values, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenBetween(Double value1, Double value2) {
            addCriterion("seventeen between", value1, value2, "seventeen");
            return (Criteria) this;
        }

        public Criteria andSeventeenNotBetween(Double value1, Double value2) {
            addCriterion("seventeen not between", value1, value2, "seventeen");
            return (Criteria) this;
        }

        public Criteria andEighteenIsNull() {
            addCriterion("eighteen is null");
            return (Criteria) this;
        }

        public Criteria andEighteenIsNotNull() {
            addCriterion("eighteen is not null");
            return (Criteria) this;
        }

        public Criteria andEighteenEqualTo(Double value) {
            addCriterion("eighteen =", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenNotEqualTo(Double value) {
            addCriterion("eighteen <>", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenGreaterThan(Double value) {
            addCriterion("eighteen >", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenGreaterThanOrEqualTo(Double value) {
            addCriterion("eighteen >=", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenLessThan(Double value) {
            addCriterion("eighteen <", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenLessThanOrEqualTo(Double value) {
            addCriterion("eighteen <=", value, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenIn(List<Double> values) {
            addCriterion("eighteen in", values, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenNotIn(List<Double> values) {
            addCriterion("eighteen not in", values, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenBetween(Double value1, Double value2) {
            addCriterion("eighteen between", value1, value2, "eighteen");
            return (Criteria) this;
        }

        public Criteria andEighteenNotBetween(Double value1, Double value2) {
            addCriterion("eighteen not between", value1, value2, "eighteen");
            return (Criteria) this;
        }

        public Criteria andNineteenIsNull() {
            addCriterion("nineteen is null");
            return (Criteria) this;
        }

        public Criteria andNineteenIsNotNull() {
            addCriterion("nineteen is not null");
            return (Criteria) this;
        }

        public Criteria andNineteenEqualTo(Double value) {
            addCriterion("nineteen =", value, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenNotEqualTo(Double value) {
            addCriterion("nineteen <>", value, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenGreaterThan(Double value) {
            addCriterion("nineteen >", value, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenGreaterThanOrEqualTo(Double value) {
            addCriterion("nineteen >=", value, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenLessThan(Double value) {
            addCriterion("nineteen <", value, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenLessThanOrEqualTo(Double value) {
            addCriterion("nineteen <=", value, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenIn(List<Double> values) {
            addCriterion("nineteen in", values, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenNotIn(List<Double> values) {
            addCriterion("nineteen not in", values, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenBetween(Double value1, Double value2) {
            addCriterion("nineteen between", value1, value2, "nineteen");
            return (Criteria) this;
        }

        public Criteria andNineteenNotBetween(Double value1, Double value2) {
            addCriterion("nineteen not between", value1, value2, "nineteen");
            return (Criteria) this;
        }

        public Criteria andTwentyIsNull() {
            addCriterion("twenty is null");
            return (Criteria) this;
        }

        public Criteria andTwentyIsNotNull() {
            addCriterion("twenty is not null");
            return (Criteria) this;
        }

        public Criteria andTwentyEqualTo(Double value) {
            addCriterion("twenty =", value, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyNotEqualTo(Double value) {
            addCriterion("twenty <>", value, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyGreaterThan(Double value) {
            addCriterion("twenty >", value, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyGreaterThanOrEqualTo(Double value) {
            addCriterion("twenty >=", value, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyLessThan(Double value) {
            addCriterion("twenty <", value, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyLessThanOrEqualTo(Double value) {
            addCriterion("twenty <=", value, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyIn(List<Double> values) {
            addCriterion("twenty in", values, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyNotIn(List<Double> values) {
            addCriterion("twenty not in", values, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyBetween(Double value1, Double value2) {
            addCriterion("twenty between", value1, value2, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyNotBetween(Double value1, Double value2) {
            addCriterion("twenty not between", value1, value2, "twenty");
            return (Criteria) this;
        }

        public Criteria andTwentyOneIsNull() {
            addCriterion("twenty_one is null");
            return (Criteria) this;
        }

        public Criteria andTwentyOneIsNotNull() {
            addCriterion("twenty_one is not null");
            return (Criteria) this;
        }

        public Criteria andTwentyOneEqualTo(Double value) {
            addCriterion("twenty_one =", value, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneNotEqualTo(Double value) {
            addCriterion("twenty_one <>", value, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneGreaterThan(Double value) {
            addCriterion("twenty_one >", value, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneGreaterThanOrEqualTo(Double value) {
            addCriterion("twenty_one >=", value, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneLessThan(Double value) {
            addCriterion("twenty_one <", value, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneLessThanOrEqualTo(Double value) {
            addCriterion("twenty_one <=", value, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneIn(List<Double> values) {
            addCriterion("twenty_one in", values, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneNotIn(List<Double> values) {
            addCriterion("twenty_one not in", values, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneBetween(Double value1, Double value2) {
            addCriterion("twenty_one between", value1, value2, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyOneNotBetween(Double value1, Double value2) {
            addCriterion("twenty_one not between", value1, value2, "twentyOne");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoIsNull() {
            addCriterion("twenty_two is null");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoIsNotNull() {
            addCriterion("twenty_two is not null");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoEqualTo(Double value) {
            addCriterion("twenty_two =", value, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoNotEqualTo(Double value) {
            addCriterion("twenty_two <>", value, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoGreaterThan(Double value) {
            addCriterion("twenty_two >", value, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoGreaterThanOrEqualTo(Double value) {
            addCriterion("twenty_two >=", value, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoLessThan(Double value) {
            addCriterion("twenty_two <", value, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoLessThanOrEqualTo(Double value) {
            addCriterion("twenty_two <=", value, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoIn(List<Double> values) {
            addCriterion("twenty_two in", values, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoNotIn(List<Double> values) {
            addCriterion("twenty_two not in", values, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoBetween(Double value1, Double value2) {
            addCriterion("twenty_two between", value1, value2, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyTwoNotBetween(Double value1, Double value2) {
            addCriterion("twenty_two not between", value1, value2, "twentyTwo");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeIsNull() {
            addCriterion("twenty_three is null");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeIsNotNull() {
            addCriterion("twenty_three is not null");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeEqualTo(Double value) {
            addCriterion("twenty_three =", value, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeNotEqualTo(Double value) {
            addCriterion("twenty_three <>", value, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeGreaterThan(Double value) {
            addCriterion("twenty_three >", value, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeGreaterThanOrEqualTo(Double value) {
            addCriterion("twenty_three >=", value, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeLessThan(Double value) {
            addCriterion("twenty_three <", value, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeLessThanOrEqualTo(Double value) {
            addCriterion("twenty_three <=", value, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeIn(List<Double> values) {
            addCriterion("twenty_three in", values, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeNotIn(List<Double> values) {
            addCriterion("twenty_three not in", values, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeBetween(Double value1, Double value2) {
            addCriterion("twenty_three between", value1, value2, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyThreeNotBetween(Double value1, Double value2) {
            addCriterion("twenty_three not between", value1, value2, "twentyThree");
            return (Criteria) this;
        }

        public Criteria andTwentyFourIsNull() {
            addCriterion("twenty_four is null");
            return (Criteria) this;
        }

        public Criteria andTwentyFourIsNotNull() {
            addCriterion("twenty_four is not null");
            return (Criteria) this;
        }

        public Criteria andTwentyFourEqualTo(Double value) {
            addCriterion("twenty_four =", value, "twentyFour");
            return (Criteria) this;
        }

        public Criteria andTwentyFourNotEqualTo(Double value) {
            addCriterion("twenty_four <>", value, "twentyFour");
            return (Criteria) this;
        }

        public Criteria andTwentyFourGreaterThan(Double value) {
            addCriterion("twenty_four >", value, "twentyFour");
            return (Criteria) this;
        }

        public Criteria andTwentyFourGreaterThanOrEqualTo(Double value) {
            addCriterion("twenty_four >=", value, "twentyFour");
            return (Criteria) this;
        }

        public Criteria andTwentyFourLessThan(Double value) {
            addCriterion("twenty_four <", value, "twentyFour");
            return (Criteria) this;
        }

        public Criteria andTwentyFourLessThanOrEqualTo(Double value) {
            addCriterion("twenty_four <=", value, "twentyFour");
            return (Criteria) this;
        }

        public Criteria andTwentyFourIn(List<Double> values) {
            addCriterion("twenty_four in", values, "twentyFour");
            return (Criteria) this;
        }

        public Criteria andTwentyFourNotIn(List<Double> values) {
            addCriterion("twenty_four not in", values, "twentyFour");
            return (Criteria) this;
        }

        public Criteria andTwentyFourBetween(Double value1, Double value2) {
            addCriterion("twenty_four between", value1, value2, "twentyFour");
            return (Criteria) this;
        }

        public Criteria andTwentyFourNotBetween(Double value1, Double value2) {
            addCriterion("twenty_four not between", value1, value2, "twentyFour");
            return (Criteria) this;
        }

        public Criteria andTwentyFiveIsNull() {
            addCriterion("twenty_five is null");
            return (Criteria) this;
        }

        public Criteria andTwentyFiveIsNotNull() {
            addCriterion("twenty_five is not null");
            return (Criteria) this;
        }

        public Criteria andTwentyFiveEqualTo(Double value) {
            addCriterion("twenty_five =", value, "twentyFive");
            return (Criteria) this;
        }

        public Criteria andTwentyFiveNotEqualTo(Double value) {
            addCriterion("twenty_five <>", value, "twentyFive");
            return (Criteria) this;
        }

        public Criteria andTwentyFiveGreaterThan(Double value) {
            addCriterion("twenty_five >", value, "twentyFive");
            return (Criteria) this;
        }

        public Criteria andTwentyFiveGreaterThanOrEqualTo(Double value) {
            addCriterion("twenty_five >=", value, "twentyFive");
            return (Criteria) this;
        }

        public Criteria andTwentyFiveLessThan(Double value) {
            addCriterion("twenty_five <", value, "twentyFive");
            return (Criteria) this;
        }

        public Criteria andTwentyFiveLessThanOrEqualTo(Double value) {
            addCriterion("twenty_five <=", value, "twentyFive");
            return (Criteria) this;
        }

        public Criteria andTwentyFiveIn(List<Double> values) {
            addCriterion("twenty_five in", values, "twentyFive");
            return (Criteria) this;
        }

        public Criteria andTwentyFiveNotIn(List<Double> values) {
            addCriterion("twenty_five not in", values, "twentyFive");
            return (Criteria) this;
        }

        public Criteria andTwentyFiveBetween(Double value1, Double value2) {
            addCriterion("twenty_five between", value1, value2, "twentyFive");
            return (Criteria) this;
        }

        public Criteria andTwentyFiveNotBetween(Double value1, Double value2) {
            addCriterion("twenty_five not between", value1, value2, "twentyFive");
            return (Criteria) this;
        }

        public Criteria andTwentySixIsNull() {
            addCriterion("twenty_six is null");
            return (Criteria) this;
        }

        public Criteria andTwentySixIsNotNull() {
            addCriterion("twenty_six is not null");
            return (Criteria) this;
        }

        public Criteria andTwentySixEqualTo(Double value) {
            addCriterion("twenty_six =", value, "twentySix");
            return (Criteria) this;
        }

        public Criteria andTwentySixNotEqualTo(Double value) {
            addCriterion("twenty_six <>", value, "twentySix");
            return (Criteria) this;
        }

        public Criteria andTwentySixGreaterThan(Double value) {
            addCriterion("twenty_six >", value, "twentySix");
            return (Criteria) this;
        }

        public Criteria andTwentySixGreaterThanOrEqualTo(Double value) {
            addCriterion("twenty_six >=", value, "twentySix");
            return (Criteria) this;
        }

        public Criteria andTwentySixLessThan(Double value) {
            addCriterion("twenty_six <", value, "twentySix");
            return (Criteria) this;
        }

        public Criteria andTwentySixLessThanOrEqualTo(Double value) {
            addCriterion("twenty_six <=", value, "twentySix");
            return (Criteria) this;
        }

        public Criteria andTwentySixIn(List<Double> values) {
            addCriterion("twenty_six in", values, "twentySix");
            return (Criteria) this;
        }

        public Criteria andTwentySixNotIn(List<Double> values) {
            addCriterion("twenty_six not in", values, "twentySix");
            return (Criteria) this;
        }

        public Criteria andTwentySixBetween(Double value1, Double value2) {
            addCriterion("twenty_six between", value1, value2, "twentySix");
            return (Criteria) this;
        }

        public Criteria andTwentySixNotBetween(Double value1, Double value2) {
            addCriterion("twenty_six not between", value1, value2, "twentySix");
            return (Criteria) this;
        }

        public Criteria andTwentySevenIsNull() {
            addCriterion("twenty_seven is null");
            return (Criteria) this;
        }

        public Criteria andTwentySevenIsNotNull() {
            addCriterion("twenty_seven is not null");
            return (Criteria) this;
        }

        public Criteria andTwentySevenEqualTo(Double value) {
            addCriterion("twenty_seven =", value, "twentySeven");
            return (Criteria) this;
        }

        public Criteria andTwentySevenNotEqualTo(Double value) {
            addCriterion("twenty_seven <>", value, "twentySeven");
            return (Criteria) this;
        }

        public Criteria andTwentySevenGreaterThan(Double value) {
            addCriterion("twenty_seven >", value, "twentySeven");
            return (Criteria) this;
        }

        public Criteria andTwentySevenGreaterThanOrEqualTo(Double value) {
            addCriterion("twenty_seven >=", value, "twentySeven");
            return (Criteria) this;
        }

        public Criteria andTwentySevenLessThan(Double value) {
            addCriterion("twenty_seven <", value, "twentySeven");
            return (Criteria) this;
        }

        public Criteria andTwentySevenLessThanOrEqualTo(Double value) {
            addCriterion("twenty_seven <=", value, "twentySeven");
            return (Criteria) this;
        }

        public Criteria andTwentySevenIn(List<Double> values) {
            addCriterion("twenty_seven in", values, "twentySeven");
            return (Criteria) this;
        }

        public Criteria andTwentySevenNotIn(List<Double> values) {
            addCriterion("twenty_seven not in", values, "twentySeven");
            return (Criteria) this;
        }

        public Criteria andTwentySevenBetween(Double value1, Double value2) {
            addCriterion("twenty_seven between", value1, value2, "twentySeven");
            return (Criteria) this;
        }

        public Criteria andTwentySevenNotBetween(Double value1, Double value2) {
            addCriterion("twenty_seven not between", value1, value2, "twentySeven");
            return (Criteria) this;
        }

        public Criteria andTwentyEightIsNull() {
            addCriterion("twenty_eight is null");
            return (Criteria) this;
        }

        public Criteria andTwentyEightIsNotNull() {
            addCriterion("twenty_eight is not null");
            return (Criteria) this;
        }

        public Criteria andTwentyEightEqualTo(Double value) {
            addCriterion("twenty_eight =", value, "twentyEight");
            return (Criteria) this;
        }

        public Criteria andTwentyEightNotEqualTo(Double value) {
            addCriterion("twenty_eight <>", value, "twentyEight");
            return (Criteria) this;
        }

        public Criteria andTwentyEightGreaterThan(Double value) {
            addCriterion("twenty_eight >", value, "twentyEight");
            return (Criteria) this;
        }

        public Criteria andTwentyEightGreaterThanOrEqualTo(Double value) {
            addCriterion("twenty_eight >=", value, "twentyEight");
            return (Criteria) this;
        }

        public Criteria andTwentyEightLessThan(Double value) {
            addCriterion("twenty_eight <", value, "twentyEight");
            return (Criteria) this;
        }

        public Criteria andTwentyEightLessThanOrEqualTo(Double value) {
            addCriterion("twenty_eight <=", value, "twentyEight");
            return (Criteria) this;
        }

        public Criteria andTwentyEightIn(List<Double> values) {
            addCriterion("twenty_eight in", values, "twentyEight");
            return (Criteria) this;
        }

        public Criteria andTwentyEightNotIn(List<Double> values) {
            addCriterion("twenty_eight not in", values, "twentyEight");
            return (Criteria) this;
        }

        public Criteria andTwentyEightBetween(Double value1, Double value2) {
            addCriterion("twenty_eight between", value1, value2, "twentyEight");
            return (Criteria) this;
        }

        public Criteria andTwentyEightNotBetween(Double value1, Double value2) {
            addCriterion("twenty_eight not between", value1, value2, "twentyEight");
            return (Criteria) this;
        }

        public Criteria andTwentyNineIsNull() {
            addCriterion("twenty_nine is null");
            return (Criteria) this;
        }

        public Criteria andTwentyNineIsNotNull() {
            addCriterion("twenty_nine is not null");
            return (Criteria) this;
        }

        public Criteria andTwentyNineEqualTo(Double value) {
            addCriterion("twenty_nine =", value, "twentyNine");
            return (Criteria) this;
        }

        public Criteria andTwentyNineNotEqualTo(Double value) {
            addCriterion("twenty_nine <>", value, "twentyNine");
            return (Criteria) this;
        }

        public Criteria andTwentyNineGreaterThan(Double value) {
            addCriterion("twenty_nine >", value, "twentyNine");
            return (Criteria) this;
        }

        public Criteria andTwentyNineGreaterThanOrEqualTo(Double value) {
            addCriterion("twenty_nine >=", value, "twentyNine");
            return (Criteria) this;
        }

        public Criteria andTwentyNineLessThan(Double value) {
            addCriterion("twenty_nine <", value, "twentyNine");
            return (Criteria) this;
        }

        public Criteria andTwentyNineLessThanOrEqualTo(Double value) {
            addCriterion("twenty_nine <=", value, "twentyNine");
            return (Criteria) this;
        }

        public Criteria andTwentyNineIn(List<Double> values) {
            addCriterion("twenty_nine in", values, "twentyNine");
            return (Criteria) this;
        }

        public Criteria andTwentyNineNotIn(List<Double> values) {
            addCriterion("twenty_nine not in", values, "twentyNine");
            return (Criteria) this;
        }

        public Criteria andTwentyNineBetween(Double value1, Double value2) {
            addCriterion("twenty_nine between", value1, value2, "twentyNine");
            return (Criteria) this;
        }

        public Criteria andTwentyNineNotBetween(Double value1, Double value2) {
            addCriterion("twenty_nine not between", value1, value2, "twentyNine");
            return (Criteria) this;
        }

        public Criteria andThirtyIsNull() {
            addCriterion("thirty is null");
            return (Criteria) this;
        }

        public Criteria andThirtyIsNotNull() {
            addCriterion("thirty is not null");
            return (Criteria) this;
        }

        public Criteria andThirtyEqualTo(Double value) {
            addCriterion("thirty =", value, "thirty");
            return (Criteria) this;
        }

        public Criteria andThirtyNotEqualTo(Double value) {
            addCriterion("thirty <>", value, "thirty");
            return (Criteria) this;
        }

        public Criteria andThirtyGreaterThan(Double value) {
            addCriterion("thirty >", value, "thirty");
            return (Criteria) this;
        }

        public Criteria andThirtyGreaterThanOrEqualTo(Double value) {
            addCriterion("thirty >=", value, "thirty");
            return (Criteria) this;
        }

        public Criteria andThirtyLessThan(Double value) {
            addCriterion("thirty <", value, "thirty");
            return (Criteria) this;
        }

        public Criteria andThirtyLessThanOrEqualTo(Double value) {
            addCriterion("thirty <=", value, "thirty");
            return (Criteria) this;
        }

        public Criteria andThirtyIn(List<Double> values) {
            addCriterion("thirty in", values, "thirty");
            return (Criteria) this;
        }

        public Criteria andThirtyNotIn(List<Double> values) {
            addCriterion("thirty not in", values, "thirty");
            return (Criteria) this;
        }

        public Criteria andThirtyBetween(Double value1, Double value2) {
            addCriterion("thirty between", value1, value2, "thirty");
            return (Criteria) this;
        }

        public Criteria andThirtyNotBetween(Double value1, Double value2) {
            addCriterion("thirty not between", value1, value2, "thirty");
            return (Criteria) this;
        }

        public Criteria andThirtyOneIsNull() {
            addCriterion("thirty_one is null");
            return (Criteria) this;
        }

        public Criteria andThirtyOneIsNotNull() {
            addCriterion("thirty_one is not null");
            return (Criteria) this;
        }

        public Criteria andThirtyOneEqualTo(Double value) {
            addCriterion("thirty_one =", value, "thirtyOne");
            return (Criteria) this;
        }

        public Criteria andThirtyOneNotEqualTo(Double value) {
            addCriterion("thirty_one <>", value, "thirtyOne");
            return (Criteria) this;
        }

        public Criteria andThirtyOneGreaterThan(Double value) {
            addCriterion("thirty_one >", value, "thirtyOne");
            return (Criteria) this;
        }

        public Criteria andThirtyOneGreaterThanOrEqualTo(Double value) {
            addCriterion("thirty_one >=", value, "thirtyOne");
            return (Criteria) this;
        }

        public Criteria andThirtyOneLessThan(Double value) {
            addCriterion("thirty_one <", value, "thirtyOne");
            return (Criteria) this;
        }

        public Criteria andThirtyOneLessThanOrEqualTo(Double value) {
            addCriterion("thirty_one <=", value, "thirtyOne");
            return (Criteria) this;
        }

        public Criteria andThirtyOneIn(List<Double> values) {
            addCriterion("thirty_one in", values, "thirtyOne");
            return (Criteria) this;
        }

        public Criteria andThirtyOneNotIn(List<Double> values) {
            addCriterion("thirty_one not in", values, "thirtyOne");
            return (Criteria) this;
        }

        public Criteria andThirtyOneBetween(Double value1, Double value2) {
            addCriterion("thirty_one between", value1, value2, "thirtyOne");
            return (Criteria) this;
        }

        public Criteria andThirtyOneNotBetween(Double value1, Double value2) {
            addCriterion("thirty_one not between", value1, value2, "thirtyOne");
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