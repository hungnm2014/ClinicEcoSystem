alter table CES_STAFF add constraint FK_CES_STAFF_TITLE_ID foreign key (TITLE_ID) references CES_STAFF_TITLE(ID);
create index IDX_CES_STAFF_TITLE on CES_STAFF (TITLE_ID);
