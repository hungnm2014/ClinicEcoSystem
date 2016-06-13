alter table CES_STAFF add constraint FK_CES_STAFF_IMAGE_FILE_ID foreign key (IMAGE_FILE_ID) references SYS_FILE(ID);
create index IDX_CES_STAFF_IMAGE_FILE on CES_STAFF (IMAGE_FILE_ID);
