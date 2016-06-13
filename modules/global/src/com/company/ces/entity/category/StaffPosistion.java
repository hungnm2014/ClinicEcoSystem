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
@NamePattern("%s|pos_name")
@Table(name = "CES_STAFF_POSISTION")
@Entity(name = "ces$StaffPosistion")
public class StaffPosistion extends StandardEntity {
    private static final long serialVersionUID = -4785248757153136491L;

    @Column(name = "POS_ID", nullable = false, unique = true)
    protected Integer pos_id;

    @Column(name = "POS_NAME", nullable = false, unique = true, length = 200)
    protected String pos_name;

    public void setPos_id(Integer pos_id) {
        this.pos_id = pos_id;
    }

    public Integer getPos_id() {
        return pos_id;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }

    public String getPos_name() {
        return pos_name;
    }


}