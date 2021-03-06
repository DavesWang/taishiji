package cn.pojo;

import java.util.ArrayList;
import java.util.List;

public class CourseBatchExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
    public CourseBatchExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
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

        public Criteria andBatchidIsNull() {
            addCriterion("BatchId is null");
            return (Criteria) this;
        }

        public Criteria andBatchidIsNotNull() {
            addCriterion("BatchId is not null");
            return (Criteria) this;
        }

        public Criteria andBatchidEqualTo(Integer value) {
            addCriterion("BatchId =", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidNotEqualTo(Integer value) {
            addCriterion("BatchId <>", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidGreaterThan(Integer value) {
            addCriterion("BatchId >", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidGreaterThanOrEqualTo(Integer value) {
            addCriterion("BatchId >=", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidLessThan(Integer value) {
            addCriterion("BatchId <", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidLessThanOrEqualTo(Integer value) {
            addCriterion("BatchId <=", value, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidIn(List<Integer> values) {
            addCriterion("BatchId in", values, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidNotIn(List<Integer> values) {
            addCriterion("BatchId not in", values, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidBetween(Integer value1, Integer value2) {
            addCriterion("BatchId between", value1, value2, "batchid");
            return (Criteria) this;
        }

        public Criteria andBatchidNotBetween(Integer value1, Integer value2) {
            addCriterion("BatchId not between", value1, value2, "batchid");
            return (Criteria) this;
        }

        public Criteria andCourseresoureidIsNull() {
            addCriterion("CourseResoureId is null");
            return (Criteria) this;
        }

        public Criteria andCourseresoureidIsNotNull() {
            addCriterion("CourseResoureId is not null");
            return (Criteria) this;
        }

        public Criteria andCourseresoureidEqualTo(Integer value) {
            addCriterion("CourseResoureId =", value, "courseresoureid");
            return (Criteria) this;
        }

        public Criteria andCourseresoureidNotEqualTo(Integer value) {
            addCriterion("CourseResoureId <>", value, "courseresoureid");
            return (Criteria) this;
        }

        public Criteria andCourseresoureidGreaterThan(Integer value) {
            addCriterion("CourseResoureId >", value, "courseresoureid");
            return (Criteria) this;
        }

        public Criteria andCourseresoureidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CourseResoureId >=", value, "courseresoureid");
            return (Criteria) this;
        }

        public Criteria andCourseresoureidLessThan(Integer value) {
            addCriterion("CourseResoureId <", value, "courseresoureid");
            return (Criteria) this;
        }

        public Criteria andCourseresoureidLessThanOrEqualTo(Integer value) {
            addCriterion("CourseResoureId <=", value, "courseresoureid");
            return (Criteria) this;
        }

        public Criteria andCourseresoureidIn(List<Integer> values) {
            addCriterion("CourseResoureId in", values, "courseresoureid");
            return (Criteria) this;
        }

        public Criteria andCourseresoureidNotIn(List<Integer> values) {
            addCriterion("CourseResoureId not in", values, "courseresoureid");
            return (Criteria) this;
        }

        public Criteria andCourseresoureidBetween(Integer value1, Integer value2) {
            addCriterion("CourseResoureId between", value1, value2, "courseresoureid");
            return (Criteria) this;
        }

        public Criteria andCourseresoureidNotBetween(Integer value1, Integer value2) {
            addCriterion("CourseResoureId not between", value1, value2, "courseresoureid");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table courseresourebatch
     *
     * @mbg.generated do_not_delete_during_merge Thu Aug 01 18:52:52 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table courseresourebatch
     *
     * @mbg.generated Thu Aug 01 18:52:52 CST 2019
     */
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