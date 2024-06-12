prompt PL/SQL Developer Export Tables for user YCYL@11.0.0.160:1521/YCYL
prompt Created by Administrator on 2024��4��10��
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
  is '������ѵ--�γ̳�����ʽ';
comment on column STD_EDU_FORM_.id
  is '���к�';
comment on column STD_EDU_FORM_.parentid_
  is '����ID';
comment on column STD_EDU_FORM_.attributues_
  is '�ֵ�����';
comment on column STD_EDU_FORM_.code_
  is '����';
comment on column STD_EDU_FORM_.indexcode_
  is '������';
comment on column STD_EDU_FORM_.name_
  is '��������';
comment on column STD_EDU_FORM_.shortname_
  is '���ļ��';
comment on column STD_EDU_FORM_.nameen_
  is 'Ӣ������';
comment on column STD_EDU_FORM_.stopedflag_
  is 'ͣ�ñ�ʶ';
comment on column STD_EDU_FORM_.comment_
  is '˵��';
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
  is '������ѵ-���������������';
comment on column STD_EDU_HEALTHCARE_.id
  is '���к�';
comment on column STD_EDU_HEALTHCARE_.parentid_
  is '����ID';
comment on column STD_EDU_HEALTHCARE_.attributues_
  is '�ֵ�����';
comment on column STD_EDU_HEALTHCARE_.code_
  is '����';
comment on column STD_EDU_HEALTHCARE_.indexcode_
  is '������';
comment on column STD_EDU_HEALTHCARE_.name_
  is '��������';
comment on column STD_EDU_HEALTHCARE_.shortname_
  is '���ļ��';
comment on column STD_EDU_HEALTHCARE_.nameen_
  is 'Ӣ������';
comment on column STD_EDU_HEALTHCARE_.stopedflag_
  is 'ͣ�ñ�ʶ';
comment on column STD_EDU_HEALTHCARE_.comment_
  is '˵��';
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
  is '������ѵ--�ڿ���ʽ';
comment on column STD_EDU_MODALITY_.id
  is '���к�';
comment on column STD_EDU_MODALITY_.parentid_
  is '����ID';
comment on column STD_EDU_MODALITY_.attributues_
  is '�ֵ�����';
comment on column STD_EDU_MODALITY_.code_
  is '����';
comment on column STD_EDU_MODALITY_.indexcode_
  is '������';
comment on column STD_EDU_MODALITY_.name_
  is '��������';
comment on column STD_EDU_MODALITY_.shortname_
  is '���ļ��';
comment on column STD_EDU_MODALITY_.nameen_
  is 'Ӣ������';
comment on column STD_EDU_MODALITY_.stopedflag_
  is 'ͣ�ñ�ʶ';
comment on column STD_EDU_MODALITY_.comment_
  is '˵��';
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
  is '������ѵ--�γ�����';
comment on column STD_EDU_NATURE_.id
  is '���к�';
comment on column STD_EDU_NATURE_.parentid_
  is '����ID';
comment on column STD_EDU_NATURE_.attributues_
  is '�ֵ�����';
comment on column STD_EDU_NATURE_.code_
  is '����';
comment on column STD_EDU_NATURE_.indexcode_
  is '������';
comment on column STD_EDU_NATURE_.name_
  is '��������';
comment on column STD_EDU_NATURE_.shortname_
  is '���ļ��';
comment on column STD_EDU_NATURE_.nameen_
  is 'Ӣ������';
comment on column STD_EDU_NATURE_.stopedflag_
  is 'ͣ�ñ�ʶ';
comment on column STD_EDU_NATURE_.comment_
  is '˵��';
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
  is '������ѵ-�γ̷�������';
comment on column STD_EDU_RELEASE_.id
  is '���к�';
comment on column STD_EDU_RELEASE_.parentid_
  is '����ID';
comment on column STD_EDU_RELEASE_.attributues_
  is '�ֵ�����';
comment on column STD_EDU_RELEASE_.code_
  is '����';
comment on column STD_EDU_RELEASE_.indexcode_
  is '������';
comment on column STD_EDU_RELEASE_.name_
  is '��������';
comment on column STD_EDU_RELEASE_.shortname_
  is '���ļ��';
comment on column STD_EDU_RELEASE_.nameen_
  is 'Ӣ������';
comment on column STD_EDU_RELEASE_.stopedflag_
  is 'ͣ�ñ�ʶ';
comment on column STD_EDU_RELEASE_.comment_
  is '˵��';
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
values (1, null, null, '1', null, '����Ƶ��ʽ', null, null, null, null);
insert into STD_EDU_FORM_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (2, null, null, '2', null, '���ĸ�ʽ', null, null, null, null);
commit;
prompt 2 records loaded
prompt Loading STD_EDU_HEALTHCARE_...
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (1, null, null, '1', null, '����ڣ�0-1�꣩', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (2, null, null, '2', null, 'Ӥ���ڣ�1-2�꣩', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (3, null, null, '3', null, '�׶��ڣ�2-6�꣩', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (4, null, null, '4', null, '�����ڣ�6-12�꣩', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (5, null, null, '5', null, '�ഺ�ڣ�12-18�꣩', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (6, null, null, '6', null, '�����ڣ�18-30�꣩', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (7, null, null, '7', null, '�����ڣ�30-50�꣩', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (8, null, null, '8', null, '�����ڣ���50�꣩', null, null, null, null);
insert into STD_EDU_HEALTHCARE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (9, null, null, '9', null, '����', null, null, null, null);
commit;
prompt 9 records loaded
prompt Loading STD_EDU_MODALITY_...
insert into STD_EDU_MODALITY_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (1, null, null, '1', null, '�㲥��ʽ', null, null, null, null);
insert into STD_EDU_MODALITY_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (2, null, null, '2', null, '������ʽ', null, null, null, null);
insert into STD_EDU_MODALITY_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (3, null, null, '3', null, '������ʽ', null, null, null, null);
insert into STD_EDU_MODALITY_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (4, null, null, '4', null, '�����ʽ', null, null, null, null);
commit;
prompt 4 records loaded
prompt Loading STD_EDU_NATURE_...
insert into STD_EDU_NATURE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (1, null, null, '0', null, '��Ƶ�㲥', null, null, null, null);
insert into STD_EDU_NATURE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (2, null, null, '1', null, '��������', null, null, null, null);
insert into STD_EDU_NATURE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (3, null, null, '2', null, 'רҵ����', null, null, null, null);
commit;
prompt 3 records loaded
prompt Loading STD_EDU_RELEASE_...
insert into STD_EDU_RELEASE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (0, null, null, '0', null, '������', null, null, null, null);
insert into STD_EDU_RELEASE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (1, null, null, '1', null, '��������', null, null, null, null);
insert into STD_EDU_RELEASE_ (id, parentid_, attributues_, code_, indexcode_, name_, shortname_, nameen_, stopedflag_, comment_)
values (2, null, null, '2', null, '�ٴ�רҵ', null, null, null, null);
commit;
prompt 3 records loaded

set feedback on
set define on
prompt Done
