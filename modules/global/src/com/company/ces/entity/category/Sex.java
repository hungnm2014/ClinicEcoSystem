/*
 * Copyright (c) 2016 ces
 */
package com.company.ces.entity.category;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

/**
 * @author HenryKhanhHoang
 */
@NamePattern("%s|sex_name")
@Table(name = "CES_SEX")
@Entity(name = "ces$Sex")
public class Sex extends StandardEntity {
    private static final long serialVersionUID = -3148936443407871722L;

    @Column(name = "SEX_ID", nullable = false, unique = true)
    protected Integer sex_id;

    @Column(name = "SEX_NAME", nullable = false, unique = true, length = 10)
    protected String sex_name;

    public void setSex_id(Integer sex_id) {
        this.sex_id = sex_id;
    }

    public Integer getSex_id() {
        return sex_id;
    }

    public void setSex_name(String sex_name) {
        this.sex_name = sex_name;
    }

    public String getSex_name() {
        return sex_name;
    }


}