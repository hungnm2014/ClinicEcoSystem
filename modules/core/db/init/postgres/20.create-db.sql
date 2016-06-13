-- begin CES_STAFF_POSISTION
create unique index IDX_CES_STAFF_POSISTION_UNIQ_POS_ID on CES_STAFF_POSISTION (POS_ID) where DELETE_TS is null ^
create unique index IDX_CES_STAFF_POSISTION_UNIQ_POS_NAME on CES_STAFF_POSISTION (POS_NAME) where DELETE_TS is null ^
-- end CES_STAFF_POSISTION
-- begin CES_STAFF_TITLE
create unique index IDX_CES_STAFF_TITLE_UNIQ_TITLE_ID on CES_STAFF_TITLE (TITLE_ID) where DELETE_TS is null ^
create unique index IDX_CES_STAFF_TITLE_UNIQ_TITLE_NAME on CES_STAFF_TITLE (TITLE_NAME) where DELETE_TS is null ^
-- end CES_STAFF_TITLE
-- begin CES_SEX
create unique index IDX_CES_SEX_UNIQ_SEX_ID on CES_SEX (SEX_ID) where DELETE_TS is null ^
create unique index IDX_CES_SEX_UNIQ_SEX_NAME on CES_SEX (SEX_NAME) where DELETE_TS is null ^
-- end CES_SEX
-- begin CES_STAFF
alter table CES_STAFF add constraint FK_CES_STAFF_DEPARTMENT_ID foreign key (DEPARTMENT_ID) references SEC_GROUP(ID)^
alter table CES_STAFF add constraint FK_CES_STAFF_SEX_ID foreign key (SEX_ID) references CES_SEX(ID)^
alter table CES_STAFF add constraint FK_CES_STAFF_TITLE_ID foreign key (TITLE_ID) references CES_STAFF_TITLE(ID)^
alter table CES_STAFF add constraint FK_CES_STAFF_POSISTION_ID foreign key (POSISTION_ID) references CES_STAFF_POSISTION(ID)^
alter table CES_STAFF add constraint FK_CES_STAFF_IMAGE_FILE_ID foreign key (IMAGE_FILE_ID) references SYS_FILE(ID)^
create unique index IDX_CES_STAFF_UNIQ_LICENSE_ID on CES_STAFF (LICENSE_ID) where DELETE_TS is null ^
create index IDX_CES_STAFF_TITLE on CES_STAFF (TITLE_ID)^
create index IDX_CES_STAFF_SEX on CES_STAFF (SEX_ID)^
create index IDX_CES_STAFF_DEPARTMENT on CES_STAFF (DEPARTMENT_ID)^
create index IDX_CES_STAFF_IMAGE_FILE on CES_STAFF (IMAGE_FILE_ID)^
create index IDX_CES_STAFF_POSISTION on CES_STAFF (POSISTION_ID)^
-- end CES_STAFF
