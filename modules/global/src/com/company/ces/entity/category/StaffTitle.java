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
@NamePattern("%s|title_name")
@Table(name = "CES_STAFF_TITLE")
@Entity(name = "ces$StaffTitle")
public class StaffTitle extends StandardEntity {
    private static final long serialVersionUID = 4515995721861069183L;

    @Column(name = "TITLE_ID", nullable = false, unique = true)
    protected Integer title_id;

    @Column(name = "TITLE_NAME", nullable = false, unique = true, length = 200)
    protected String title_name;

    public void setTitle_id(Integer title_id) {
        this.title_id = title_id;
    }

    public Integer getTitle_id() {
        return title_id;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public String getTitle_name() {
        return title_name;
    }


}