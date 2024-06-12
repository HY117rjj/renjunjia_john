prompt PL/SQL Developer Export Tables for user YCYL@11.0.0.160:1521/YCYL
prompt Created by Administrator on 2024Äê4ÔÂ17ÈÕ
set feedback off
set define off

prompt Creating HIBERNATE_UNIQUE_KEY...
create table HIBERNATE_UNIQUE_KEY
(
  next_hi NUMBER(10)
)
tablespace YCYL
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Loading HIBERNATE_UNIQUE_KEY...
insert into HIBERNATE_UNIQUE_KEY (next_hi)
values (55229);
commit;
prompt 1 records loaded

set feedback on
set define on
prompt Done
