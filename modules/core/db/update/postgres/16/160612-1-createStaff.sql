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
    --
    primary key (ID)
);
