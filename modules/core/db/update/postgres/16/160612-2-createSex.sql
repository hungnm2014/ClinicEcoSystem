create unique index IDX_CES_SEX_UNIQ_SEX_ID on CES_SEX (SEX_ID) where DELETE_TS is null ;
create unique index IDX_CES_SEX_UNIQ_SEX_NAME on CES_SEX (SEX_NAME) where DELETE_TS is null ;
