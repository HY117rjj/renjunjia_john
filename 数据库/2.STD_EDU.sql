prompt PL/SQL Developer Export Tables for user YCYL@11.0.0.160:1521/YCYL
prompt Created by Administrator on 2024年4月10日
set feedback off
set define off

prompt Creating STD_EDU_FORM_...
create table STD_EDU_FORM_
(
  id           NUMBER(19) not null,
  parentid_    NUMBER(19),
  attributues_ VARCHAR2(10),
  code_        VARCHAR2(10),
  indexcode_   VARCHAR2(50),
  name_        VARCHAR2(100),
  shortname_   VARCHAR2(100),
  nameen_      VARCHAR2(100),
  stopedflag_  CHAR(1),
  comment_     VARCHAR2(255)
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
comment on table STD_EDU_FORM_
  is '教育培训--课程呈现形式';
comment on column STD_EDU_FORM_.id
  is '序列号';
comment on column STD_EDU_FORM_.parentid_
  is '父类ID';
comment on column STD_EDU_FORM_.attributues_
  is '字典属性';
comment on column STD_EDU_FORM_.code_
  is '编码';
comment on column STD_EDU_FORM_.indexcode_
  is '检索码';
comment on column STD_EDU_FORM_.name_
  is '中文名称';
comment on column STD_EDU_FORM_.shortname_
  is '中文简称';
comment on column STD_EDU_FORM_.nameen_
  is '英文名称';
comment on column STD_EDU_FORM_.stopedflag_
  is '停用标识';
comment on column STD_EDU_FORM_.comment_
  is '说明';
alter table STD_EDU_FORM_
  add constraint PK_STD_EDU_FORM primary key (ID)
  using index 
  tablespace YCYL
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating STD_EDU_HEALTHCARE_...
create table STD_EDU_HEALTHCARE_
(
  id           NUMBER(19) not null,
  parentid_    NUMBER(19),
  attributues_ VARCHAR2(10),
  code_        VARCHAR2(10),
  indexcode_   VARCHAR2(50),
  name_        VARCHAR2(100),
  shortname_   VARCHAR2(100),
  nameen_      VARCHAR2(100),
  stopedflag_  CHAR(1),
  comment_     VARCHAR2(255)
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
comment on table STD_EDU_HEALTHCARE_
  is '教育培训-健康教育年龄分组';
comment on column STD_EDU_HEALTHCARE_.id
  is '序列号';
comment on column STD_EDU_HEALTHCARE_.parentid_
  is '父类ID';
comment on column STD_EDU_HEALTHCARE_.attributues_
  is '字典属性';
comment on column STD_EDU_HEALTHCARE_.code_
  is '编码';
comment on column STD_EDU_HEALTHCARE_.indexcode_
  is '检索码';
comment on column STD_EDU_HEALTHCARE_.name_
  is '中文名称';
comment on column STD_EDU_HEALTHCARE_.shortname_
  is '中文简称';
comment on column STD_EDU_HEALTHCARE_.nameen_
  is '英文名称';
comment on column STD_EDU_HEALTHCARE_.stopedflag_
  is '停用标识';
comment on column STD_EDU_HEALTHCARE_.comment_
  is '说明';
alter table STD_EDU_HEALTHCARE_
  add constraint PK_STD_EDU_HEALTHCARE primary key (ID)
  using index 
  tablespace YCYL
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating STD_EDU_MODALITY_...
create table STD_EDU_MODALITY_
(
  id           NUMBER(19) not null,
  parentid_    NUMBER(19),
  attributues_ VARCHAR2(10),
  code_        VARCHAR2(10),
  indexcode_   VARCHAR2(50),
  name_        VARCHAR2(100),
  shortname_   VARCHAR2(100),
  nameen_      VARCHAR2(100),
  stopedflag_  CHAR(1),
  comment_     VARCHAR2(255)
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
comment on table STD_EDU_MODALITY_
  is '教育培训--授课形式';
comment on column STD_EDU_MODALITY_.id
  is '序列号';
comment on column STD_EDU_MODALITY_.parentid_
  is '父类ID';
comment on column STD_EDU_MODALITY_.attributues_
  is '字典属性';
comment on column STD_EDU_MODALITY_.code_
  is '编码';
comment on column STD_EDU_MODALITY_.indexcode_
  is '检索码';
comment on column STD_EDU_MODALITY_.name_
  is '中文名称';
comment on column STD_EDU_MODALITY_.shortname_
  is '中文简称';
comment on column STD_EDU_MODALITY_.nameen_
  is '英文名称';
comment on column STD_EDU_MODALITY_.stopedflag_
  is '停用标识';
comment on column STD_EDU_MODALITY_.comment_
  is '说明';
alter table STD_EDU_MODALITY_
  add constraint PK_SSTD_EDU_MODALITY primary key (ID)
  using index 
  tablespace YCYL
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating STD_EDU_NATURE_...
create table STD_EDU_NATURE_
(
  id           NUMBER(19) not null,
  parentid_    NUMBER(19),
  attributues_ VARCHAR2(10),
  code_        VARCHAR2(10),
  indexcode_   VARCHAR2(50),
  name_        VARCHAR2(100),
  shortname_   VARCHAR2(100),
  nameen_      VARCHAR2(100),
  stopedflag_  CHAR(1),
  comment_     VARCHAR2(255)
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
comment on table STD_EDU_NATURE_
  is '教育培训--课程类型';
comment on column STD_EDU_NATURE_.id
  is '序列号';
comment on column STD_EDU_NATURE_.parentid_
  is '父类ID';
comment on column STD_EDU_NATURE_.attributues_
  is '字典属性';
comment on column STD_EDU_NATURE_.code_
  is '编码';
comment on column STD_EDU_NATURE_.indexcode_
  is '检索码';
comment on column STD_EDU_NATURE_.name_
  is '中文名称';
comment on column STD_EDU_NATURE_.shortname_
  is '中文简称';
comment on column STD_EDU_NATURE_.nameen_
  is '英文名称';
comment on column STD_EDU_NATURE_.stopedflag_
  is '停用标识';
comment on column STD_EDU_NATURE_.comment_
  is '说明';
alter table STD_EDU_NATURE_
  add constraint PK_STD_EDU_NATURE primary key (ID)
  using index 
  tablespace YCYL
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating STD_EDU_RELEASE_...
create table STD_EDU_RELEASE_
(
  id           NUMBER(19) not null,
  parentid_    NUMBER(19),
  attributues_ VARCHAR2(10),
  code_        VARCHAR2(10),
  indexcode_   VARCHAR2(50),
  name_        VARCHAR2(100),
  shortname_   VARCHAR2(100),
  nameen_      VARCHAR2(100),
  stopedflag_  CHAR(1),
  comment_     VARCHAR2(255)
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
comment on table STD_EDU_RELEASE_
  is '教育培训-课程发布对象';
comment on column STD_EDU_RELEASE_.id
  is '序列号';
comment on column STD_EDU_RELEASE_.parentid_
  is '父类ID';
comment on column STD_EDU_RELEASE_.attributues_
  is '字典属性';
comment on column STD_EDU_RELEASE_.code_
  is '编码';
comment on column STD_EDU_RELEASE_.indexcode_
  is '检索码';
comment on column STD_EDU_RELEASE_.name_
  is '中文名称';
comment on column STD_EDU_RELEASE_.shortname_
  is '中文简称';
comment on column STD_EDU_RELEASE_.nameen_
  is '英文名称';
comment on column STD_EDU_RELEASE_.stopedflag_
  is '停用标识';
comment on column STD_EDU_RELEASE_.comment_
  is '说明';
alter table STD_EDU_RELEASE_
  add constraint PK_STD_EDU_RELEASE primary key (ID)
  using index 
  tablespace YCYL
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Loading STD_EDU_FORM_...
insert into STD_EDU_FORM_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (1, null, null, '1', null, '视音频格式', null, null, null, null);
insert into STD_EDU_FORM_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (2, null, null, '2', null, '本文格式', null, null, null, null);
commit;
prompt 2 records loaded
prompt Loading STD_EDU_HEALTHCARE_...
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (1, null, null, '1', null, '乳儿期（0-1岁）', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (2, null, null, '2', null, '婴儿期（1-2岁）', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (3, null, null, '3', null, '幼儿期（2-6岁）', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (4, null, null, '4', null, '少年期（6-12岁）', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (5, null, null, '5', null, '青春期（12-18岁）', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (6, null, null, '6', null, '青年期（18-30岁）', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (7, null, null, '7', null, '中年期（30-50岁）', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (8, null, null, '8', null, '老年期（＞50岁）', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (9, null, null, '9', null, '其他', null, null, null, null);
commit;
prompt 9 records loaded
prompt Loading STD_EDU_MODALITY_...
insert into STD_EDU_MODALITY_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (1, null, null, '1', null, '点播形式', null, null, null, null);
insert into STD_EDU_MODALITY_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (2, null, null, '2', null, '讲授形式', null, null, null, null);
insert into STD_EDU_MODALITY_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (3, null, null, '3', null, '交互形式', null, null, null, null);
insert into STD_EDU_MODALITY_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (4, null, null, '4', null, '针对形式', null, null, null, null);
commit;
prompt 4 records loaded
prompt Loading STD_EDU_NATURE_...
insert into STD_EDU_NATURE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (1, null, null, '0', null, '视频点播', null, null, null, null);
insert into STD_EDU_NATURE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (2, null, null, '1', null, '健康教育', null, null, null, null);
insert into STD_EDU_NATURE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (3, null, null, '2', null, '专业讲座', null, null, null, null);
commit;
prompt 3 records loaded
prompt Loading STD_EDU_RELEASE_...
insert into STD_EDU_RELEASE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (0, null, null, '0', null, '无限制', null, null, null, null);
insert into STD_EDU_RELEASE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (1, null, null, '1', null, '健康科普', null, null, null, null);
insert into STD_EDU_RELEASE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (2, null, null, '2', null, '临床专业', null, null, null, null);
commit;
prompt 3 records loaded

set feedback on
set define on
prompt Done
