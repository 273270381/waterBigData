package com.suchness.intellisense.model;

import java.util.ArrayList;
import java.util.List;

public class WaterLevelYearExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaterLevelYearExample() {
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