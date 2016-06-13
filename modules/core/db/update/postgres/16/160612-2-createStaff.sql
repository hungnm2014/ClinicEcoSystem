alter table CES_STAFF add constraint FK_CES_STAFF_DEPARTMENT_ID foreign key (DEPARTMENT_ID) references SEC_GROUP(ID);
alter table CES_STAFF add constraint FK_CES_STAFF_SEX_ID foreign key (SEX_ID) references CES_SEX(ID);
create unique index IDX_CES_STAFF_UNIQ_LICENSE_ID on CES_STAFF (LICENSE_ID) where DELETE_TS is null ;
create unique index IDX_CES_STAFF_UNIQ_DEPARTMENT_ID on CES_STAFF (DEPARTMENT_ID) where DELETE_TS is null ;
create index IDX_CES_STAFF_DEPARTMENT on CES_STAFF (DEPARTMENT_ID);
