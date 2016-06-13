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
);
