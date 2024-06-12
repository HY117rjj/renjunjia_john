prompt PL/SQL Developer Export User Objects for user YCYL@11.0.0.160:1521/YCYL
prompt Created by Administrator on 2024年4月17日
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
  is '互联网课堂案例分析数据表';
comment on column YCYL.EDU_CASE.id
  is '系统流水号';
comment on column YCYL.EDU_CASE.idcard
  is '教师身份证号';
comment on column YCYL.EDU_CASE.name
  is '教师姓名';
comment on column YCYL.EDU_CASE.case_content
  is '案例分析任务内容';
comment on column YCYL.EDU_CASE.record_time
  is '案例时间';
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
  is '互联网课堂案例分析讨论数据表';
comment on column YCYL.EDU_CASE_MESSAGE.id
  is '系统流水号';
comment on column YCYL.EDU_CASE_MESSAGE.serial_number
  is '总表流水号关联案例分析数据表：EDU_CASE  ID';
comment on column YCYL.EDU_CASE_MESSAGE.idcard
  is '教师身份证号';
comment on column YCYL.EDU_CASE_MESSAGE.name
  is '教师姓名';
comment on column YCYL.EDU_CASE_MESSAGE.case_content
  is '案例分析任务内容';
comment on column YCYL.EDU_CASE_MESSAGE.messager_name
  is '讨论人';
comment on column YCYL.EDU_CASE_MESSAGE.message_content
  is '讨论内容';
comment on column YCYL.EDU_CASE_MESSAGE.record_time
  is '讨论时间';
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
  is '教育培训--点播授课题数据表';
comment on column YCYL.EDU_COURSEWARE.id
  is '系统流水号';
comment on column YCYL.EDU_COURSEWARE.serial_number
  is '总表流水号';
comment on column YCYL.EDU_COURSEWARE.idcard
  is '教师身份证号';
comment on column YCYL.EDU_COURSEWARE.name
  is '教师姓名';
comment on column YCYL.EDU_COURSEWARE.subject
  is '专业学科 高等学校本科、专科专业名称代码字典表：STDEDUCATIONALMAJOR_ SUBS(1,2)=10；医学';
comment on column YCYL.EDU_COURSEWARE.major
  is '诊疗科目 医疗机构诊疗科目字典表：
STDCONSULTATIONSUBJECT_
 多选，存编码';
comment on column YCYL.EDU_COURSEWARE.icd
  is '疾病分类 国际疾病分类字典表：
STDDISEASE_
选择字典表中属性=类目 多选，存编码';
comment on column YCYL.EDU_COURSEWARE.title
  is '题目';
comment on column YCYL.EDU_COURSEWARE.summary
  is '内容提要';
comment on column YCYL.EDU_COURSEWARE.nature
  is '课程类型 课程类型字典表：STD_EDU_NATURE';
comment on column YCYL.EDU_COURSEWARE.teaching_time
  is '授课时间';
comment on column YCYL.EDU_COURSEWARE.duration
  is '授课时长（分钟）';
comment on column YCYL.EDU_COURSEWARE.charge
  is '授课费';
comment on column YCYL.EDU_COURSEWARE.on_demand_charge
  is '点播费';
comment on column YCYL.EDU_COURSEWARE.address_link
  is '课件地址链接 mp4';
comment on column YCYL.EDU_COURSEWARE.teaching_time_
  is '授课时间 H5 Local';
comment on column YCYL.EDU_COURSEWARE.form
  is '呈现形式 课程呈现形式字典表：
STD_EDU_FORM
';
comment on column YCYL.EDU_COURSEWARE.text
  is '文本格式课件';
comment on column YCYL.EDU_COURSEWARE.health_care
  is '健康教育分组 健康教育年龄分组字典表：STD_EDU_HEALTHCARE';
comment on column YCYL.EDU_COURSEWARE.cover_image
  is '封面 jpg png';
comment on column YCYL.EDU_COURSEWARE.attachment_link
  is '附件地址链接 doc pdf ppt';
comment on column YCYL.EDU_COURSEWARE.sticky_posts
  is '置顶 0置顶 1或空不置顶';
comment on column YCYL.EDU_COURSEWARE.release
  is '发布对象 课程发布对象字典表：
STD_EDU_RELEASE
0无限制 1健康科普 2临床专业';
comment on column YCYL.EDU_COURSEWARE.drug
  is '药品分类 国际疾病分类字典表：
STD_DRUG
选择字典表中属性=3  存编码';
comment on column YCYL.EDU_COURSEWARE.content_type
  is '内容类型字典表:';
comment on column YCYL.EDU_COURSEWARE.presentation
  is '呈现方式 td_basic_Presentation';
comment on column YCYL.EDU_COURSEWARE.stoped_flag
  is '删除标记';
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
  is '互联网课堂留言数据表';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.id
  is '系统流水号';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.serial_number
  is '总表流水号关联点播授课表：edu_courseware  ID';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.organization_id
  is '预约组织机构代码';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.organization
  is '预约组织机构名称';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.messager_name
  is '留言人';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.messager_tele
  is '留言人联系电话（手机）';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.message_content
  is '留言消息内容';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.record_time
  is '留言时间';
comment on column YCYL.EDU_COURSEWARE_MESSAGE.courseware
  is '总表流水号关联点播授课表：edu_courseware 题目';
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
  is '教育培训--教师拟授课数据表';
comment on column YCYL.EDU_LECTURE.id
  is '系统流水号';
comment on column YCYL.EDU_LECTURE.organization_id
  is '组织机构代码';
comment on column YCYL.EDU_LECTURE.organization
  is '组织机构名称';
comment on column YCYL.EDU_LECTURE.idcard
  is '授课教师身份证号';
comment on column YCYL.EDU_LECTURE.name
  is '授课教师 关联授课人员数据表：EDU_TEACHER';
comment on column YCYL.EDU_LECTURE.subject
  is '专业学科 高等学校本科、专科专业名称代码字典表：STDEDUCATIONALMAJOR_	SUBS(1,2)=10；医学';
comment on column YCYL.EDU_LECTURE.major
  is '诊疗科目 医疗机构诊疗科目字典表：
STDCONSULTATIONSUBJECT_	多选，存编码
';
comment on column YCYL.EDU_LECTURE.icd
  is '疾病分类 国际疾病分类字典表：
STDDISEASE_	选择字典表中属性=类目
';
comment on column YCYL.EDU_LECTURE.title
  is '题目';
comment on column YCYL.EDU_LECTURE.summary
  is '内容提要';
comment on column YCYL.EDU_LECTURE.nature
  is '课程类型 课程类型字典表：STD_EDU_NATURE';
comment on column YCYL.EDU_LECTURE.modality
  is '授课形式 授课形式字典表：STD_EDU_MODALITY';
comment on column YCYL.EDU_LECTURE.teaching_time
  is '授课时间';
comment on column YCYL.EDU_LECTURE.duration
  is '授课时长（分钟）';
comment on column YCYL.EDU_LECTURE.charge
  is '授课费';
comment on column YCYL.EDU_LECTURE.serial_number
  is '总表流水号 关联EDU_TEACHER表';
comment on column YCYL.EDU_LECTURE.teaching_time_
  is '授课时间 H5 Local';
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
  is '教育培训--预约授课数据表';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.id
  is '系统流水号';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.serial_number
  is '总表流水号 关联教师拟授课数据表：EDU_LECTURE  ID';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.organization_id
  is '预约组织机构代码';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.organization
  is '预约组织机构名称';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.appointment_name
  is '预约人';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.appointment_tele
  is '预约人联系电话（手机）';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.watch
  is '观摩 1-允许；0-拒绝';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.appointment_time
  is '预约授课时间';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.ratification_time
  is '确定授课时间 管理人员确定';
comment on column YCYL.EDU_LECTURE_APPOINTMENT.appointment_idcard
  is '预约人身份证号';
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
  is '教育培训--自主选题预约授课数据表';
comment on column YCYL.EDU_LECTURE_AUTONOMY.id
  is '系统流水号';
comment on column YCYL.EDU_LECTURE_AUTONOMY.idcard
  is '授课教师身份证号 关联授课人员数据表：EDU_TEACHER';
comment on column YCYL.EDU_LECTURE_AUTONOMY.name
  is '授课教师';
comment on column YCYL.EDU_LECTURE_AUTONOMY.appointment_title
  is '题目';
comment on column YCYL.EDU_LECTURE_AUTONOMY.summary
  is '授课内容要求';
comment on column YCYL.EDU_LECTURE_AUTONOMY.appointment_modality
  is '授课形式 授课形式字典表：STD_EDU_MODALITY';
comment on column YCYL.EDU_LECTURE_AUTONOMY.appointment_duration
  is '拟授课时长';
comment on column YCYL.EDU_LECTURE_AUTONOMY.appointment_charge
  is '拟支讲课费';
comment on column YCYL.EDU_LECTURE_AUTONOMY.organization_id
  is '预约组织机构代码';
comment on column YCYL.EDU_LECTURE_AUTONOMY.organization
  is '预约组织机构名称';
comment on column YCYL.EDU_LECTURE_AUTONOMY.appointment_name
  is '预约人';
comment on column YCYL.EDU_LECTURE_AUTONOMY.appointment_tele
  is '预约人联系电话（手机）';
comment on column YCYL.EDU_LECTURE_AUTONOMY.watch
  is '观摩 1-允许；0-拒绝';
comment on column YCYL.EDU_LECTURE_AUTONOMY.ratification_time
  is '确定授课时间';
comment on column YCYL.EDU_LECTURE_AUTONOMY.ratification_charge
  is '确定讲课费 管理人员确定';
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
  is '教育培训--日志文件数据表';
comment on column YCYL.EDU_LOG.id
  is '系统流水号';
comment on column YCYL.EDU_LOG.idcard
  is '身份证号';
comment on column YCYL.EDU_LOG.user_name
  is '用户名';
comment on column YCYL.EDU_LOG.name
  is '姓名';
comment on column YCYL.EDU_LOG.content
  is '操作内容';
comment on column YCYL.EDU_LOG.sim_manager
  is 'A系统管理员 B安全保密管理员 C安全审计人员';
comment on column YCYL.EDU_LOG.record_time
  is '记录时间';
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
  is '直播网络流量';
comment on column YCYL.EDU_NETWORK_FLOW.ip
  is 'IP地址';
comment on column YCYL.EDU_NETWORK_FLOW.time
  is '访问时间';
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
  is '教育培训--教学通知数据表';
comment on column YCYL.EDU_NOTICE.id
  is '系统流水号';
comment on column YCYL.EDU_NOTICE.title
  is '通知标题';
comment on column YCYL.EDU_NOTICE.content3
  is '通知内容';
comment on column YCYL.EDU_NOTICE.notice_time
  is '通知时间';
comment on column YCYL.EDU_NOTICE.promulgator
  is '发布者用户名';
comment on column YCYL.EDU_NOTICE.content
  is '通知内容';
comment on column YCYL.EDU_NOTICE.teaching_time
  is '拟授课时间';
comment on column YCYL.EDU_NOTICE.teaching_time_
  is '拟授课时间';
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
  is '教育培训--教学通知数据表';
comment on column YCYL.EDU_NOTICE_2.id
  is '系统流水号';
comment on column YCYL.EDU_NOTICE_2.title
  is '通知标题';
comment on column YCYL.EDU_NOTICE_2.content
  is '通知内容';
comment on column YCYL.EDU_NOTICE_2.notice_time
  is '通知时间';
comment on column YCYL.EDU_NOTICE_2.promulgator
  is '发布者用户名';
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
  is '互联网课堂流程审批数据表';
comment on column YCYL.EDU_PROCESS.id
  is '系统流水号';
comment on column YCYL.EDU_PROCESS.system_user_name
  is '申请方用户名';
comment on column YCYL.EDU_PROCESS.system_name
  is '申请方姓名';
comment on column YCYL.EDU_PROCESS.security_user_name
  is '安全保密方用户名';
comment on column YCYL.EDU_PROCESS.security_name
  is '安全保密方姓名';
comment on column YCYL.EDU_PROCESS.content
  is '申请内容';
comment on column YCYL.EDU_PROCESS.conclusion
  is '审批结论 拒绝/同意';
comment on column YCYL.EDU_PROCESS.record_time
  is '记录时间';
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
  is '教育培训--教育项目数据表';
comment on column YCYL.EDU_PROJECT.id
  is '系统流水号';
comment on column YCYL.EDU_PROJECT.edu_id
  is '项目编号';
comment on column YCYL.EDU_PROJECT.edu_designation
  is '项目名称';
comment on column YCYL.EDU_PROJECT.summary
  is '内容提要 专题授课题数据表：EDU_COURSEWARE';
comment on column YCYL.EDU_PROJECT.courseware
  is '课件';
comment on column YCYL.EDU_PROJECT.credit_hour
  is '学分';
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
  is '教育培训--学员管理数据表';
comment on column YCYL.EDU_STUDENT.id
  is '系统流水号';
comment on column YCYL.EDU_STUDENT.edu_id
  is '项目编号';
comment on column YCYL.EDU_STUDENT.edu_designation
  is '项目名称';
comment on column YCYL.EDU_STUDENT.name
  is '学员姓名';
comment on column YCYL.EDU_STUDENT.technology
  is '学员职称 关联字典表: STDPOSTTECHNOLOGY_';
comment on column YCYL.EDU_STUDENT.user_name
  is '用户名';
comment on column YCYL.EDU_STUDENT.user_pass
  is '密码';
comment on column YCYL.EDU_STUDENT.idcard
  is '学员身份证号';
comment on column YCYL.EDU_STUDENT.credit_hour
  is '学分';
comment on column YCYL.EDU_STUDENT.admin
  is '管理员';
comment on column YCYL.EDU_STUDENT.state
  is '状态 1有效 0无效';
comment on column YCYL.EDU_STUDENT.sim_manager
  is 'A系统管理员 B安全保密管理员 C安全审计人员';
comment on column YCYL.EDU_STUDENT.role
  is 'role1 新建 role2 修改 role3 删除';
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
  is '教育培训--学员学习明细数据表';
comment on column YCYL.EDU_STUDENT_DETAILS.id
  is '系统流水号';
comment on column YCYL.EDU_STUDENT_DETAILS.serial_number
  is '总表流水号 关联学员管理数据表：EDU_STUDENT  ID';
comment on column YCYL.EDU_STUDENT_DETAILS.courseware
  is '课件 专题授课题数据表：EDU_COURSEWARE';
comment on column YCYL.EDU_STUDENT_DETAILS.idcard
  is '学员身份证号';
comment on column YCYL.EDU_STUDENT_DETAILS.name
  is '学员姓名';
comment on column YCYL.EDU_STUDENT_DETAILS.sign_time
  is '签到时间';
comment on column YCYL.EDU_STUDENT_DETAILS.eligibility
  is '合格 0-否；1-是';
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
  is '教育培训--授课人员数据表';
comment on column YCYL.EDU_TEACHER.id
  is '系统流水号';
comment on column YCYL.EDU_TEACHER.idcard
  is '教师身份证号';
comment on column YCYL.EDU_TEACHER.name
  is '教师姓名';
comment on column YCYL.EDU_TEACHER.teaching_sign
  is '授课';
comment on column YCYL.EDU_TEACHER.subject
  is '专业学科 高等学校本科、专科专业名称代码字典表：STDEDUCATIONALMAJOR_ SUBS(1,2)=10；医学';
comment on column YCYL.EDU_TEACHER.major
  is '诊疗科目 医疗机构诊疗科目字典表：
STDCONSULTATIONSUBJECT_
 多选，存编码';
comment on column YCYL.EDU_TEACHER.basic_charge
  is '基础授课费';
comment on column YCYL.EDU_TEACHER.research
  is '授课及研究方向';
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
  is '教育培训--游客数据表';
comment on column YCYL.EDU_USER.id
  is '系统流水号';
comment on column YCYL.EDU_USER.idcard
  is '学员身份证号';
comment on column YCYL.EDU_USER.name
  is '学员姓名';
comment on column YCYL.EDU_USER.sign_time
  is '注册时间';
comment on column YCYL.EDU_USER.charge
  is '学费余额';
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
  is '教育培训--游客学习明细数据表';
comment on column YCYL.EDU_USER_DETAILS.id
  is '系统流水号';
comment on column YCYL.EDU_USER_DETAILS.serial_number
  is '总表流水号 关联学员管理数据表：EDU_STUDENT  ID';
comment on column YCYL.EDU_USER_DETAILS.idcard
  is '学员身份证号';
comment on column YCYL.EDU_USER_DETAILS.name
  is '学员姓名';
comment on column YCYL.EDU_USER_DETAILS.courseware
  is '课件 专题授课题数据表：EDU_COURSEWARE';
comment on column YCYL.EDU_USER_DETAILS.sign_time
  is '点播时间';
comment on column YCYL.EDU_USER_DETAILS.charge
  is '点播费';
comment on column YCYL.EDU_USER_DETAILS.complete
  is '结束 0-否；1-是';
alter table YCYL.EDU_USER_DETAILS
  add constraint PK_EDU_USER_DETAILS_ID primary key (ID);


prompt Done
spool off
set define on
