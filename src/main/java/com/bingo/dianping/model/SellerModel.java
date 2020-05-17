package com.bingo.dianping.model;

import java.math.BigDecimal;
import java.util.Date;

public class SellerModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seller.id
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seller.name
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seller.created
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    private Date created;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seller.modified
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    private Date modified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seller.remark_score
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    private BigDecimal remarkScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column seller.disabled_flag
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    private Integer disabledFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column seller.id
     *
     * @return the value of seller.id
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column seller.id
     *
     * @param id the value for seller.id
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column seller.name
     *
     * @return the value of seller.name
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column seller.name
     *
     * @param name the value for seller.name
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column seller.created
     *
     * @return the value of seller.created
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column seller.created
     *
     * @param created the value for seller.created
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column seller.modified
     *
     * @return the value of seller.modified
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    public Date getModified() {
        return modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column seller.modified
     *
     * @param modified the value for seller.modified
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column seller.remark_score
     *
     * @return the value of seller.remark_score
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    public BigDecimal getRemarkScore() {
        return remarkScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column seller.remark_score
     *
     * @param remarkScore the value for seller.remark_score
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    public void setRemarkScore(BigDecimal remarkScore) {
        this.remarkScore = remarkScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column seller.disabled_flag
     *
     * @return the value of seller.disabled_flag
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    public Integer getDisabledFlag() {
        return disabledFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column seller.disabled_flag
     *
     * @param disabledFlag the value for seller.disabled_flag
     *
     * @mbg.generated Sun May 17 18:28:23 CST 2020
     */
    public void setDisabledFlag(Integer disabledFlag) {
        this.disabledFlag = disabledFlag;
    }
}