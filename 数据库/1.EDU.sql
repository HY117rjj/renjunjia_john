prompt PL/SQL Developer Export User Objects for user YCYL@11.0.0.160:1521/YCYL
prompt Created by Administrator on 2024��4��17��
set define off
spool EDU.log

prompt
prompt Creating table EDU_CASE
prompt =======================
prompt
create table YCYL.EDU_CASE
(
  id           NUMBER(32) not null,
  idcard       VARCHAR2(18),
  name         VARCHAR2(40),
  case_content VARCHAR2(500),
  record_time  TIMESTAMP(6)
)
;
comment on table YCYL.EDU_CASE
  is '���������ð����������ݱ�';
comment on column YCYL.EDU_CASE.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_CASE.idcard
  is '��ʦ���֤��';
comment on column YCYL.EDU_CASE.name
  is '��ʦ����';
comment on column YCYL.EDU_CASE.case_content
  is '����������������';
comment on column YCYL.EDU_CASE.record_time
  is '����ʱ��';
alter table YCYL.EDU_CASE
  add constraint PK_EDU_CASE primary key (ID);

prompt
prompt Creating table EDU_CASE_MESSAGE
prompt ===============================
prompt
create table YCYL.EDU_CASE_MESSAGE
(
  id              NUMBER(32) not null,
  serial_number   NUMBER(32),
  idcard          VARCHAR2(18),
  name            VARCHAR2(40),
  case_content    VARCHAR2(500),
  messager_name   VARCHAR2(40),
  message_content VARCHAR2(500),
  record_time     TIMESTAMP(6)
)
;
comment on table YCYL.EDU_CASE_MESSAGE
  is '���������ð��������������ݱ�';
comment on column YCYL.EDU_CASE_MESSAGE.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_CASE_MESSAGE.serial_number
  is '�ܱ���ˮ�Ź��������������ݱ�EDU_CASE  ID';
comment on column YCYL.EDU_CASE_MESSAGE.idcard
  is '��ʦ���֤��';
comment on column YCYL.EDU_CASE_MESSAGE.name
  is '��ʦ����';
comment on column YCYL.EDU_CASE_MESSAGE.case_content
  is '����������������';
comment on column YCYL.EDU_CASE_MESSAGE.messager_name
  is '������';
comment on column YCYL.EDU_CASE_MESSAGE.message_content
  is '��������';
comment on column YCYL.EDU_CASE_MESSAGE.record_time
  is '����ʱ��';
alter table YCYL.EDU_CASE_MESSAGE
  add constraint PK_EDU_CASE_MESSAGE primary key (ID);

prompt
prompt Creating table EDU_COURSEWARE
prompt =============================
prompt
create table YCYL.EDU_COURSEWARE
(
  id               NUMBER not null,
  serial_number    NUMBER not null,
  idcard           VARCHAR2(18) not null,
  name             VARCHAR2(40),
  subject          VARCHAR2(10),
  major            VARCHAR2(255),
  icd              VARCHAR2(255),
  title            VARCHAR2(200),
  summary          VARCHAR2(255),
  nature           VARCHAR2(10),
  teaching_time    TIMESTAMP(6),
  duration         NUMBER(3),
  charge           NUMBER(10,2),
  on_demand_charge NUMBER(10,2),
  address_link     VARCHAR2(255),
  teaching_time_   VARCHAR2(20),
  form             VARCHAR2(20),
  text             CLOB,
  health_care      VARCHAR2(20),
  cover_image      VARCHAR2(255),
  attachment_link  VARCHAR2(255),
  sticky_posts     CHAR(1),
  release          VARCHAR2(10),
  drug             VARCHAR2(20),
  content_type     VARCHAR2(10),
  presentation     VARCHAR2(10),
  stoped_flag      CHAR(1) default 0
)
;
comment on table YCYL.EDU_COURSEWARE
  is '������ѵ--�㲥�ڿ������ݱ�';
comment on column YCYL.EDU_COURSEWARE.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_COURSEWARE.serial_number
  is '�ܱ���ˮ��';
comment on column YCYL.EDU_COURSEWARE.idcard
  is '��ʦ���֤��';
comment on column YCYL.EDU_COURSEWARE.name
  is '��ʦ����';
comment on column YCYL.EDU_COURSEWARE.subject
  is 'רҵѧ�� �ߵ�ѧУ���ơ�ר��רҵ���ƴ����ֵ��STDEDUCATIONALMAJOR_ SUBS(1,2)=10��ҽѧ';
comment on column YCYL.EDU_COURSEWARE.major
  is '���ƿ�Ŀ ҽ�ƻ������ƿ�Ŀ�ֵ��
STDCONSULTATIONSUBJECT_
 ��ѡ�������';
comment on column YCYL.EDU_COURSEWARE.icd
  is '�������� ���ʼ��������ֵ��
STDDISEASE_
ѡ���ֵ��������=��Ŀ ��ѡ�������';
comment on column YCYL.EDU_COURSEWARE.title
  is '��Ŀ';
comment on column YCYL.EDU_COURSEWARE.summary
  is '������Ҫ';
comment on column YCYL.EDU_COURSEWARE.nature
  is '�γ����� �γ������ֵ��STD_EDU_NATURE';
comment on column YCYL.EDU_COURSEWARE.teaching_time
  is '�ڿ�ʱ��';
comment on column YCYL.EDU_COURSEWARE.duration
  is '�ڿ�ʱ�������ӣ�';
comment on column YCYL.EDU_COURSEWARE.charge
  is '�ڿη�';
comment on column YCYL.EDU_COURSEWARE.on_demand_charge
  is '�㲥��';
comment on column YCYL.EDU_COURSEWARE.address_link
  is '�μ���ַ���� mp4';
comment on column YCYL.EDU_COURSEWARE.teaching_time_
  is '�ڿ�ʱ�� H5 Local';
comment on column YCYL.EDU_COURSEWARE.form
  is '������ʽ �γ̳�����ʽ�ֵ��
STD_EDU_FORM
';
comment on column YCYL.EDU_COURSEWARE.text
  is '�ı���ʽ�μ�';
comment on column YCYL.EDU_COURSEWARE.health_care
  is '������������ ����������������ֵ��STD_EDU_HEALTHCARE';
comment on column YCYL.EDU_COURSEWARE.cover_image
  is '���� jpg png';
comment on column YCYL.EDU_COURSEWARE.attachment_link
  is '������ַ���� doc pdf ppt';
comment on column YCYL.EDU_COURSEWARE.sticky_posts
  is '�ö� 0�ö� 1��ղ��ö�';
comment on column YCYL.EDU_COURSEWARE.release
  is '�������� �γ̷��������ֵ��
STD_EDU_RELEASE
0������ 1�������� 2�ٴ�רҵ';
comment on column YCYL.EDU_COURSEWARE.drug
  is 'ҩƷ���� ���ʼ��������ֵ��
STD_DRUG
ѡ���ֵ��������=3  �����';
comment on column YCYL.EDU_COURSEWARE.content_type
  is '���������ֵ��:';
comment on column YCYL.EDU_COURSEWARE.presentation
  is '���ַ�ʽ td_basic_Presentation';
comment on column YCYL.EDU_COURSEWARE.stoped_flag
  is 'ɾ�����';
alter table YCYL.EDU_COURSEWARE
  add constraint PK_EDU_COURSEWARE_ID primary key (ID);

prompt
prompt Creating table EDU_COURSEWARE_MESSAGE
prompt =====================================
prompt
create table YCYL.EDU_COURSEWARE_MESSAGE
(
  id              NUMBER(32) not null,
  serial_number   NUMBER(32),
  organization_id VARCHAR2(40),
  organization    VARCHAR2(100),
  messager_name   VARCHAR2(40),
  messager_tele   VARCHAR2(40),
  message_content VARCHAR2(500),
  record_time     TIMESTAMP(6),
  courseware      VARCHAR2(100)
)
;
comment on table YCYL.EDU_COURSEWARE_MESSAGE
  is '�����������������ݱ�';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.serial_number
  is '�ܱ���ˮ�Ź����㲥�ڿα�edu_courseware  ID';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.organization_id
  is 'ԤԼ��֯��������';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.organization
  is 'ԤԼ��֯��������';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.messager_name
  is '������';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.messager_tele
  is '��������ϵ�绰���ֻ���';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.message_content
  is '������Ϣ����';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.record_time
  is '����ʱ��';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.courseware
  is '�ܱ���ˮ�Ź����㲥�ڿα�edu_courseware ��Ŀ';
alter table YCYL.EDU_COURSEWARE_MESSAGE
  add constraint PK_EDU_COURSEWARE_MESSAGE primary key (ID);

prompt
prompt Creating table EDU_LECTURE
prompt ==========================
prompt
create table YCYL.EDU_LECTURE
(
  id              NUMBER not null,
  organization_id VARCHAR2(10) not null,
  organization    VARCHAR2(100),
  idcard          VARCHAR2(18) not null,
  name            VARCHAR2(40),
  subject         VARCHAR2(10),
  major           VARCHAR2(10),
  icd             VARCHAR2(10),
  title           VARCHAR2(200),
  summary         VARCHAR2(255),
  nature          VARCHAR2(10),
  modality        VARCHAR2(10),
  teaching_time   TIMESTAMP(6),
  duration        NUMBER(3),
  charge          NUMBER(10,2),
  serial_number   NUMBER,
  teaching_time_  VARCHAR2(20)
)
;
comment on table YCYL.EDU_LECTURE
  is '������ѵ--��ʦ���ڿ����ݱ�';
comment on column YCYL.EDU_LECTURE.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_LECTURE.organization_id
  is '��֯��������';
comment on column YCYL.EDU_LECTURE.organization
  is '��֯��������';
comment on column YCYL.EDU_LECTURE.idcard
  is '�ڿν�ʦ���֤��';
comment on column YCYL.EDU_LECTURE.name
  is '�ڿν�ʦ �����ڿ���Ա���ݱ�EDU_TEACHER';
comment on column YCYL.EDU_LECTURE.subject
  is 'רҵѧ�� �ߵ�ѧУ���ơ�ר��רҵ���ƴ����ֵ��STDEDUCATIONALMAJOR_	SUBS(1,2)=10��ҽѧ';
comment on column YCYL.EDU_LECTURE.major
  is '���ƿ�Ŀ ҽ�ƻ������ƿ�Ŀ�ֵ��
STDCONSULTATIONSUBJECT_	��ѡ�������
';
comment on column YCYL.EDU_LECTURE.icd
  is '�������� ���ʼ��������ֵ��
STDDISEASE_	ѡ���ֵ��������=��Ŀ
';
comment on column YCYL.EDU_LECTURE.title
  is '��Ŀ';
comment on column YCYL.EDU_LECTURE.summary
  is '������Ҫ';
comment on column YCYL.EDU_LECTURE.nature
  is '�γ����� �γ������ֵ��STD_EDU_NATURE';
comment on column YCYL.EDU_LECTURE.modality
  is '�ڿ���ʽ �ڿ���ʽ�ֵ��STD_EDU_MODALITY';
comment on column YCYL.EDU_LECTURE.teaching_time
  is '�ڿ�ʱ��';
comment on column YCYL.EDU_LECTURE.duration
  is '�ڿ�ʱ�������ӣ�';
comment on column YCYL.EDU_LECTURE.charge
  is '�ڿη�';
comment on column YCYL.EDU_LECTURE.serial_number
  is '�ܱ���ˮ�� ����EDU_TEACHER��';
comment on column YCYL.EDU_LECTURE.teaching_time_
  is '�ڿ�ʱ�� H5 Local';
alter table YCYL.EDU_LECTURE
  add constraint PK_EDU_LECTURE_ID primary key (ID);

prompt
prompt Creating table EDU_LECTURE_APPOINTMENT
prompt ======================================
prompt
create table YCYL.EDU_LECTURE_APPOINTMENT
(
  id                 NUMBER not null,
  serial_number      NUMBER not null,
  organization_id    VARCHAR2(10) not null,
  organization       VARCHAR2(100),
  appointment_name   VARCHAR2(40),
  appointment_tele   VARCHAR2(20),
  watch              CHAR(1) not null,
  appointment_time   TIMESTAMP(6),
  ratification_time  TIMESTAMP(6),
  appointment_time_  VARCHAR2(20),
  ratification_time_ VARCHAR2(20),
  appointment_idcard CHAR(18)
)
;
comment on table YCYL.EDU_LECTURE_APPOINTMENT
  is '������ѵ--ԤԼ�ڿ����ݱ�';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.serial_number
  is '�ܱ���ˮ�� ������ʦ���ڿ����ݱ�EDU_LECTURE  ID';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.organization_id
  is 'ԤԼ��֯��������';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.organization
  is 'ԤԼ��֯��������';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.appointment_name
  is 'ԤԼ��';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.appointment_tele
  is 'ԤԼ����ϵ�绰���ֻ���';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.watch
  is '��Ħ 1-����0-�ܾ�';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.appointment_time
  is 'ԤԼ�ڿ�ʱ��';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.ratification_time
  is 'ȷ���ڿ�ʱ�� ������Աȷ��';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.appointment_idcard
  is 'ԤԼ�����֤��';
alter table YCYL.EDU_LECTURE_APPOINTMENT
  add constraint PK_EDU_LECTURE_APPOINTMENT_ID primary key (ID);

prompt
prompt Creating table EDU_LECTURE_AUTONOMY
prompt ===================================
prompt
create table YCYL.EDU_LECTURE_AUTONOMY
(
  id                   NUMBER not null,
  idcard               VARCHAR2(18) not null,
  name                 VARCHAR2(40) not null,
  appointment_title    VARCHAR2(100) not null,
  summary              VARCHAR2(255) not null,
  appointment_modality VARCHAR2(10) not null,
  appointment_duration NUMBER(3) not null,
  appointment_charge   NUMBER(10,2) not null,
  organization_id      VARCHAR2(10) not null,
  organization         VARCHAR2(100) not null,
  appointment_name     VARCHAR2(40) not null,
  appointment_tele     VARCHAR2(20) not null,
  watch                CHAR(1) not null,
  ratification_time    TIMESTAMP(6) not null,
  ratification_charge  NUMBER(10,2) not null,
  ratification_time_   VARCHAR2(20)
)
;
comment on table YCYL.EDU_LECTURE_AUTONOMY
  is '������ѵ--����ѡ��ԤԼ�ڿ����ݱ�';
comment on column YCYL.EDU_LECTURE_AUTONOMY.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_LECTURE_AUTONOMY.idcard
  is '�ڿν�ʦ���֤�� �����ڿ���Ա���ݱ�EDU_TEACHER';
comment on column YCYL.EDU_LECTURE_AUTONOMY.name
  is '�ڿν�ʦ';
comment on column YCYL.EDU_LECTURE_AUTONOMY.appointment_title
  is '��Ŀ';
comment on column YCYL.EDU_LECTURE_AUTONOMY.summary
  is '�ڿ�����Ҫ��';
comment on column YCYL.EDU_LECTURE_AUTONOMY.appointment_modality
  is '�ڿ���ʽ �ڿ���ʽ�ֵ��STD_EDU_MODALITY';
comment on column YCYL.EDU_LECTURE_AUTONOMY.appointment_duration
  is '���ڿ�ʱ��';
comment on column YCYL.EDU_LECTURE_AUTONOMY.appointment_charge
  is '��֧���η�';
comment on column YCYL.EDU_LECTURE_AUTONOMY.organization_id
  is 'ԤԼ��֯��������';
comment on column YCYL.EDU_LECTURE_AUTONOMY.organization
  is 'ԤԼ��֯��������';
comment on column YCYL.EDU_LECTURE_AUTONOMY.appointment_name
  is 'ԤԼ��';
comment on column YCYL.EDU_LECTURE_AUTONOMY.appointment_tele
  is 'ԤԼ����ϵ�绰���ֻ���';
comment on column YCYL.EDU_LECTURE_AUTONOMY.watch
  is '��Ħ 1-����0-�ܾ�';
comment on column YCYL.EDU_LECTURE_AUTONOMY.ratification_time
  is 'ȷ���ڿ�ʱ��';
comment on column YCYL.EDU_LECTURE_AUTONOMY.ratification_charge
  is 'ȷ�����η� ������Աȷ��';
alter table YCYL.EDU_LECTURE_AUTONOMY
  add constraint PK_EDU_LECTURE_AUTONOMY_ID primary key (ID);

prompt
prompt Creating table EDU_LOG
prompt ======================
prompt
create table YCYL.EDU_LOG
(
  id          NUMBER not null,
  idcard      VARCHAR2(18),
  user_name   VARCHAR2(90),
  name        VARCHAR2(40),
  content     VARCHAR2(500),
  sim_manager VARCHAR2(10),
  record_time TIMESTAMP(6)
)
;
comment on table YCYL.EDU_LOG
  is '������ѵ--��־�ļ����ݱ�';
comment on column YCYL.EDU_LOG.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_LOG.idcard
  is '���֤��';
comment on column YCYL.EDU_LOG.user_name
  is '�û���';
comment on column YCYL.EDU_LOG.name
  is '����';
comment on column YCYL.EDU_LOG.content
  is '��������';
comment on column YCYL.EDU_LOG.sim_manager
  is 'Aϵͳ����Ա B��ȫ���ܹ���Ա C��ȫ�����Ա';
comment on column YCYL.EDU_LOG.record_time
  is '��¼ʱ��';
alter table YCYL.EDU_LOG
  add constraint PK_EDU_LOG_ID primary key (ID);

prompt
prompt Creating table EDU_NETWORK_FLOW
prompt ===============================
prompt
create table YCYL.EDU_NETWORK_FLOW
(
  id   NUMBER not null,
  ip   VARCHAR2(50),
  time TIMESTAMP(6)
)
;
comment on table YCYL.EDU_NETWORK_FLOW
  is 'ֱ����������';
comment on column YCYL.EDU_NETWORK_FLOW.ip
  is 'IP��ַ';
comment on column YCYL.EDU_NETWORK_FLOW.time
  is '����ʱ��';
alter table YCYL.EDU_NETWORK_FLOW
  add constraint PK_EDU_NETWORK_FLOW primary key (ID);

prompt
prompt Creating table EDU_NOTICE
prompt =========================
prompt
create table YCYL.EDU_NOTICE
(
  id             NUMBER not null,
  title          VARCHAR2(200),
  content3       VARCHAR2(4000),
  notice_time    TIMESTAMP(6),
  promulgator    VARCHAR2(20),
  content        CLOB,
  teaching_time  TIMESTAMP(6),
  teaching_time_ VARCHAR2(20)
)
;
comment on table YCYL.EDU_NOTICE
  is '������ѵ--��ѧ֪ͨ���ݱ�';
comment on column YCYL.EDU_NOTICE.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_NOTICE.title
  is '֪ͨ����';
comment on column YCYL.EDU_NOTICE.content3
  is '֪ͨ����';
comment on column YCYL.EDU_NOTICE.notice_time
  is '֪ͨʱ��';
comment on column YCYL.EDU_NOTICE.promulgator
  is '�������û���';
comment on column YCYL.EDU_NOTICE.content
  is '֪ͨ����';
comment on column YCYL.EDU_NOTICE.teaching_time
  is '���ڿ�ʱ��';
comment on column YCYL.EDU_NOTICE.teaching_time_
  is '���ڿ�ʱ��';
alter table YCYL.EDU_NOTICE
  add constraint PK_EDU_NOTICE_ID primary key (ID);

prompt
prompt Creating table EDU_NOTICE_2
prompt ===========================
prompt
create table YCYL.EDU_NOTICE_2
(
  id          NUMBER not null,
  title       VARCHAR2(100),
  content     VARCHAR2(4000),
  notice_time TIMESTAMP(6),
  promulgator VARCHAR2(20)
)
;
comment on table YCYL.EDU_NOTICE_2
  is '������ѵ--��ѧ֪ͨ���ݱ�';
comment on column YCYL.EDU_NOTICE_2.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_NOTICE_2.title
  is '֪ͨ����';
comment on column YCYL.EDU_NOTICE_2.content
  is '֪ͨ����';
comment on column YCYL.EDU_NOTICE_2.notice_time
  is '֪ͨʱ��';
comment on column YCYL.EDU_NOTICE_2.promulgator
  is '�������û���';
alter table YCYL.EDU_NOTICE_2
  add constraint PK_EDU_NOTICE_2_ID primary key (ID);

prompt
prompt Creating table EDU_PROCESS
prompt ==========================
prompt
create table YCYL.EDU_PROCESS
(
  id                 NUMBER(32) not null,
  system_user_name   VARCHAR2(18),
  system_name        VARCHAR2(40),
  security_user_name VARCHAR2(18),
  security_name      VARCHAR2(40),
  content            VARCHAR2(500),
  conclusion         VARCHAR2(40),
  record_time        TIMESTAMP(6)
)
;
comment on table YCYL.EDU_PROCESS
  is '���������������������ݱ�';
comment on column YCYL.EDU_PROCESS.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_PROCESS.system_user_name
  is '���뷽�û���';
comment on column YCYL.EDU_PROCESS.system_name
  is '���뷽����';
comment on column YCYL.EDU_PROCESS.security_user_name
  is '��ȫ���ܷ��û���';
comment on column YCYL.EDU_PROCESS.security_name
  is '��ȫ���ܷ�����';
comment on column YCYL.EDU_PROCESS.content
  is '��������';
comment on column YCYL.EDU_PROCESS.conclusion
  is '�������� �ܾ�/ͬ��';
comment on column YCYL.EDU_PROCESS.record_time
  is '��¼ʱ��';
alter table YCYL.EDU_PROCESS
  add constraint PK_EDU_PROCESS primary key (ID);

prompt
prompt Creating table EDU_PROJECT
prompt ==========================
prompt
create table YCYL.EDU_PROJECT
(
  id              NUMBER not null,
  edu_id          VARCHAR2(10) not null,
  edu_designation VARCHAR2(100),
  summary         VARCHAR2(255),
  courseware      VARCHAR2(255),
  credit_hour     NUMBER(3)
)
;
comment on table YCYL.EDU_PROJECT
  is '������ѵ--������Ŀ���ݱ�';
comment on column YCYL.EDU_PROJECT.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_PROJECT.edu_id
  is '��Ŀ���';
comment on column YCYL.EDU_PROJECT.edu_designation
  is '��Ŀ����';
comment on column YCYL.EDU_PROJECT.summary
  is '������Ҫ ר���ڿ������ݱ�EDU_COURSEWARE';
comment on column YCYL.EDU_PROJECT.courseware
  is '�μ�';
comment on column YCYL.EDU_PROJECT.credit_hour
  is 'ѧ��';
alter table YCYL.EDU_PROJECT
  add constraint PK_EDU_PROJECT_ID primary key (ID);

prompt
prompt Creating table EDU_STUDENT
prompt ==========================
prompt
create table YCYL.EDU_STUDENT
(
  id              NUMBER not null,
  edu_id          VARCHAR2(10),
  edu_designation VARCHAR2(100),
  name            VARCHAR2(40),
  technology      VARCHAR2(10),
  user_name       VARCHAR2(90),
  user_pass       VARCHAR2(50),
  idcard          VARCHAR2(18),
  credit_hour     NUMBER(3),
  admin           CHAR(1) default 0,
  state           CHAR(1) default 1,
  phone           VARCHAR2(20),
  sim_manager     VARCHAR2(10),
  role            VARCHAR2(10)
)
;
comment on table YCYL.EDU_STUDENT
  is '������ѵ--ѧԱ�������ݱ�';
comment on column YCYL.EDU_STUDENT.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_STUDENT.edu_id
  is '��Ŀ���';
comment on column YCYL.EDU_STUDENT.edu_designation
  is '��Ŀ����';
comment on column YCYL.EDU_STUDENT.name
  is 'ѧԱ����';
comment on column YCYL.EDU_STUDENT.technology
  is 'ѧԱְ�� �����ֵ��: STDPOSTTECHNOLOGY_';
comment on column YCYL.EDU_STUDENT.user_name
  is '�û���';
comment on column YCYL.EDU_STUDENT.user_pass
  is '����';
comment on column YCYL.EDU_STUDENT.idcard
  is 'ѧԱ���֤��';
comment on column YCYL.EDU_STUDENT.credit_hour
  is 'ѧ��';
comment on column YCYL.EDU_STUDENT.admin
  is '����Ա';
comment on column YCYL.EDU_STUDENT.state
  is '״̬ 1��Ч 0��Ч';
comment on column YCYL.EDU_STUDENT.sim_manager
  is 'Aϵͳ����Ա B��ȫ���ܹ���Ա C��ȫ�����Ա';
comment on column YCYL.EDU_STUDENT.role
  is 'role1 �½� role2 �޸� role3 ɾ��';
alter table YCYL.EDU_STUDENT
  add constraint PK_EDU_STUDENT_ID primary key (ID);

prompt
prompt Creating table EDU_STUDENT_DETAILS
prompt ==================================
prompt
create table YCYL.EDU_STUDENT_DETAILS
(
  id            NUMBER not null,
  serial_number NUMBER not null,
  courseware    VARCHAR2(10),
  idcard        VARCHAR2(18),
  name          VARCHAR2(40),
  sign_time     TIMESTAMP(6),
  eligibility   CHAR(1),
  sign_time_    VARCHAR2(20)
)
;
comment on table YCYL.EDU_STUDENT_DETAILS
  is '������ѵ--ѧԱѧϰ��ϸ���ݱ�';
comment on column YCYL.EDU_STUDENT_DETAILS.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_STUDENT_DETAILS.serial_number
  is '�ܱ���ˮ�� ����ѧԱ�������ݱ�EDU_STUDENT  ID';
comment on column YCYL.EDU_STUDENT_DETAILS.courseware
  is '�μ� ר���ڿ������ݱ�EDU_COURSEWARE';
comment on column YCYL.EDU_STUDENT_DETAILS.idcard
  is 'ѧԱ���֤��';
comment on column YCYL.EDU_STUDENT_DETAILS.name
  is 'ѧԱ����';
comment on column YCYL.EDU_STUDENT_DETAILS.sign_time
  is 'ǩ��ʱ��';
comment on column YCYL.EDU_STUDENT_DETAILS.eligibility
  is '�ϸ� 0-��1-��';
alter table YCYL.EDU_STUDENT_DETAILS
  add constraint PK_EDU_STUDENT_DETAILS_ID primary key (ID);

prompt
prompt Creating table EDU_TEACHER
prompt ==========================
prompt
create table YCYL.EDU_TEACHER
(
  id            NUMBER not null,
  idcard        VARCHAR2(18) not null,
  name          VARCHAR2(40),
  teaching_sign CHAR(1),
  subject       VARCHAR2(10),
  major         VARCHAR2(255),
  basic_charge  NUMBER(10,2),
  research      VARCHAR2(1000)
)
;
comment on table YCYL.EDU_TEACHER
  is '������ѵ--�ڿ���Ա���ݱ�';
comment on column YCYL.EDU_TEACHER.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_TEACHER.idcard
  is '��ʦ���֤��';
comment on column YCYL.EDU_TEACHER.name
  is '��ʦ����';
comment on column YCYL.EDU_TEACHER.teaching_sign
  is '�ڿ�';
comment on column YCYL.EDU_TEACHER.subject
  is 'רҵѧ�� �ߵ�ѧУ���ơ�ר��רҵ���ƴ����ֵ��STDEDUCATIONALMAJOR_ SUBS(1,2)=10��ҽѧ';
comment on column YCYL.EDU_TEACHER.major
  is '���ƿ�Ŀ ҽ�ƻ������ƿ�Ŀ�ֵ��
STDCONSULTATIONSUBJECT_
 ��ѡ�������';
comment on column YCYL.EDU_TEACHER.basic_charge
  is '�����ڿη�';
comment on column YCYL.EDU_TEACHER.research
  is '�ڿμ��о�����';
alter table YCYL.EDU_TEACHER
  add constraint PK_EDU_TEACHER_ID primary key (ID);

prompt
prompt Creating table EDU_USER
prompt =======================
prompt
create table YCYL.EDU_USER
(
  id         NUMBER not null,
  idcard     VARCHAR2(18) not null,
  name       VARCHAR2(40),
  sign_time  TIMESTAMP(6),
  charge     NUMBER(10,2),
  sign_time_ VARCHAR2(20)
)
;
comment on table YCYL.EDU_USER
  is '������ѵ--�ο����ݱ�';
comment on column YCYL.EDU_USER.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_USER.idcard
  is 'ѧԱ���֤��';
comment on column YCYL.EDU_USER.name
  is 'ѧԱ����';
comment on column YCYL.EDU_USER.sign_time
  is 'ע��ʱ��';
comment on column YCYL.EDU_USER.charge
  is 'ѧ�����';
alter table YCYL.EDU_USER
  add constraint PK_EDU_USER_ID primary key (ID);

prompt
prompt Creating table EDU_USER_DETAILS
prompt ===============================
prompt
create table YCYL.EDU_USER_DETAILS
(
  id            NUMBER not null,
  serial_number NUMBER not null,
  idcard        VARCHAR2(18),
  name          VARCHAR2(40),
  courseware    VARCHAR2(10),
  sign_time     TIMESTAMP(6),
  charge        NUMBER(10,2),
  complete      CHAR(1),
  sign_time_    VARCHAR2(20)
)
;
comment on table YCYL.EDU_USER_DETAILS
  is '������ѵ--�ο�ѧϰ��ϸ���ݱ�';
comment on column YCYL.EDU_USER_DETAILS.id
  is 'ϵͳ��ˮ��';
comment on column YCYL.EDU_USER_DETAILS.serial_number
  is '�ܱ���ˮ�� ����ѧԱ�������ݱ�EDU_STUDENT  ID';
comment on column YCYL.EDU_USER_DETAILS.idcard
  is 'ѧԱ���֤��';
comment on column YCYL.EDU_USER_DETAILS.name
  is 'ѧԱ����';
comment on column YCYL.EDU_USER_DETAILS.courseware
  is '�μ� ר���ڿ������ݱ�EDU_COURSEWARE';
comment on column YCYL.EDU_USER_DETAILS.sign_time
  is '�㲥ʱ��';
comment on column YCYL.EDU_USER_DETAILS.charge
  is '�㲥��';
comment on column YCYL.EDU_USER_DETAILS.complete
  is '���� 0-��1-��';
alter table YCYL.EDU_USER_DETAILS
  add constraint PK_EDU_USER_DETAILS_ID primary key (ID);


prompt Done
spool off
set define on
