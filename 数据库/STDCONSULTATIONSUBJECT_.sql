-- Create table
create table STDCONSULTATIONSUBJECT_
(
  id              NUMBER(19) not null,
  accode_         VARCHAR2(32),
  attributes_     VARCHAR2(255),
  code_           VARCHAR2(32),
  comment_        VARCHAR2(255),
  flag_           NUMBER(10),
  indexcode_      VARCHAR2(64),
  isleaf_         NUMBER(10),
  level_          NUMBER(10),
  name_           VARCHAR2(255),
  nameen_         VARCHAR2(255),
  names_          VARCHAR2(32),
  namesen_        VARCHAR2(32),
  parent_         VARCHAR2(255),
  parentid_       NUMBER(19),
  seqno_          VARCHAR2(255),
  statcode_       VARCHAR2(32),
  med             VARCHAR2(10),
  rfrcode_        VARCHAR2(32),
  rfrcode_seconde VARCHAR2(32),
  rfrcode_third   VARCHAR2(32),
  rfrcode_fourth  VARCHAR2(32),
  rfrcode_fifth   VARCHAR2(32),
  rfrcode_sixth   VARCHAR2(32),
  rfrcode_seventh VARCHAR2(32),
  rfrcode_eighth  VARCHAR2(32),
  rfrcode_ninth   VARCHAR2(32),
  sn_code_id_     VARCHAR2(32)
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
-- Add comments to the table 
comment on table STDCONSULTATIONSUBJECT_
  is 'ҽ�ƻ������ƿ�Ŀ';
-- Add comments to the columns 
comment on column STDCONSULTATIONSUBJECT_.rfrcode_
  is '��������';
comment on column STDCONSULTATIONSUBJECT_.rfrcode_seconde
  is 'ת������-2';
comment on column STDCONSULTATIONSUBJECT_.rfrcode_third
  is 'ת������-3';
comment on column STDCONSULTATIONSUBJECT_.rfrcode_fourth
  is 'ת������-4';
comment on column STDCONSULTATIONSUBJECT_.rfrcode_fifth
  is 'ת������-5';
comment on column STDCONSULTATIONSUBJECT_.rfrcode_sixth
  is 'ת������-6';
comment on column STDCONSULTATIONSUBJECT_.rfrcode_seventh
  is 'ת������-7';
comment on column STDCONSULTATIONSUBJECT_.rfrcode_eighth
  is 'ת������-8';
comment on column STDCONSULTATIONSUBJECT_.rfrcode_ninth
  is 'ת������-9';
comment on column STDCONSULTATIONSUBJECT_.sn_code_id_
  is '˳�ܿ���ID';
-- Create/Recreate primary, unique and foreign key constraints 
alter table STDCONSULTATIONSUBJECT_
  add primary key (ID)
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
