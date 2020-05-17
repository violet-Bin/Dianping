package com.bingo.dianping.model;

import java.util.Date;

public class CategoryModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.id
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.created
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    private Date created;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.modified
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    private Date modified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.name
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.icon_url
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    private String iconUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.sort
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    private Integer sort;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.id
     *
     * @return the value of category.id
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.id
     *
     * @param id the value for category.id
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.created
     *
     * @return the value of category.created
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.created
     *
     * @param created the value for category.created
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.modified
     *
     * @return the value of category.modified
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    public Date getModified() {
        return modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.modified
     *
     * @param modified the value for category.modified
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.name
     *
     * @return the value of category.name
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.name
     *
     * @param name the value for category.name
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.icon_url
     *
     * @return the value of category.icon_url
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.icon_url
     *
     * @param iconUrl the value for category.icon_url
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.sort
     *
     * @return the value of category.sort
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.sort
     *
     * @param sort the value for category.sort
     *
     * @mbg.generated Sun May 17 22:00:24 CST 2020
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}