/*
 * Copyright (c) 2016 ces
 */
package com.company.ces.entity.category;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.Group;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;

/**
 * @author HenryKhanhHoang
 */
@NamePattern("%s %s|department,sex")
@Table(name = "CES_STAFF")
@Entity(name = "ces$Staff")
public class Staff extends StandardEntity {
    private static final long serialVersionUID = -1372420670302250729L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DEPARTMENT_ID")
    protected Group department;

    @Column(name = "FULLNAME", nullable = false, length = 150)
    protected String fullname;

    @Column(name = "LICENSE_ID", unique = true, length = 20)
    protected String licenseId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_OF_BIRTH")
    protected Date dateofbirth;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SEX_ID")
    protected Sex sex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TITLE_ID")
    protected StaffTitle title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSISTION_ID")
    protected StaffPosistion posistion;

    @Column(name = "ADDRESS", length = 200)
    protected String address;

    @Column(name = "WORK_PHONE", length = 11)
    protected String workphone;

    @Column(name = "HOME_PHONE", length = 11)
    protected String homephone;

    @Column(name = "DEGREE", length = 100)
    protected String degree;

    @Column(name = "EMAIL", length = 100)
    protected String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMAGE_FILE_ID")
    protected FileDescriptor imageFileId;

    public void setImageFileId(FileDescriptor imageFileId) {
        this.imageFileId = imageFileId;
    }

    public FileDescriptor getImageFileId() {
        return imageFileId;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }


    public void setTitle(StaffTitle title) {
        this.title = title;
    }

    public StaffTitle getTitle() {
        return title;
    }

    public void setPosistion(StaffPosistion posistion) {
        this.posistion = posistion;
    }

    public StaffPosistion getPosistion() {
        return posistion;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    public String getHomephone() {
        return homephone;
    }


    public void setDepartment(Group department) {
        this.department = department;
    }

    public Group getDepartment() {
        return department;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Sex getSex() {
        return sex;
    }


}