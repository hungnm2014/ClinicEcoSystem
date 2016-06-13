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
);
