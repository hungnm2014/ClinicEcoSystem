-- begin CES_STAFF_POSISTION
create table CES_STAFF_POSISTION (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    POS_ID integer not null,
    POS_NAME varchar(200) not null,
    --
    primary key (ID)
)^
-- end CES_STAFF_POSISTION
-- begin CES_STAFF_TITLE
create table CES_STAFF_TITLE (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TITLE_ID integer not null,
    TITLE_NAME varchar(200) not null,
    --
    primary key (ID)
)^
-- end CES_STAFF_TITLE
-- begin CES_SEX
create table CES_SEX (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SEX_ID integer not null,
    SEX_NAME varchar(10) not null,
    --
    primary key (ID)
)^
-- end CES_SEX
-- begin CES_STAFF
create table CES_STAFF (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DEPARTMENT_ID uuid not null,
    FULLNAME varchar(150) not null,
    LICENSE_ID varchar(20),
    DATE_OF_BIRTH timestamp,
    SEX_ID uuid not null,
    TITLE_ID uuid,
    POSISTION_ID uuid,
    ADDRESS varchar(200),
    WORK_PHONE varchar(11),
    HOME_PHONE varchar(11),
    DEGREE varchar(100),
    EMAIL varchar(100),
    IMAGE_FILE_ID uuid,
    --
    primary key (ID)
)^
-- end CES_STAFF
