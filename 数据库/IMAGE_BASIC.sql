-- Create table
create table IMAGE_BASIC
(
  id                NUMBER(18) not null,
  title             VARCHAR2(255),
  title_ip          VARCHAR2(255),
  title_path        VARCHAR2(255),
  upload_time       TIMESTAMP(6),
  system            VARCHAR2(10),
  presentation_mode VARCHAR2(10),
  hospital          VARCHAR2(32),
  start_time        DATE,
  end_time          DATE,
  stopedflag_       CHAR(1),
  remarks           VARCHAR2(100)
)
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
-- Add comments to the table 
comment on table IMAGE_BASIC
  is '图片信息基本数据表';
-- Add comments to the columns 
comment on column IMAGE_BASIC.id
  is '系统流水号';
comment on column IMAGE_BASIC.title
  is '图片标题';
comment on column IMAGE_BASIC.title_ip
  is '链接地址';
comment on column IMAGE_BASIC.title_path
  is '图片存储路径';
comment on column IMAGE_BASIC.upload_time
  is '上传时间';
comment on column IMAGE_BASIC.system
  is '应用系统 字典表：
STD_IMAGE_SYSTEM
';
comment on column IMAGE_BASIC.presentation_mode
  is '呈现方式 字典表：
STD_IMAGE_MODE
';
comment on column IMAGE_BASIC.hospital
  is '医疗机构 医疗机构数据表：
STDHOSPITAL_
 IF PRESENTATION_MODE=''医疗机构''';
comment on column IMAGE_BASIC.start_time
  is '呈现起始时间';
comment on column IMAGE_BASIC.end_time
  is '呈现截止时间';
comment on column IMAGE_BASIC.stopedflag_
  is '停用标识';
comment on column IMAGE_BASIC.remarks
  is '备注';
-- Create/Recreate primary, unique and foreign key constraints 
alter table IMAGE_BASIC
  add constraint PK_IMAGE_BASIC_ID primary key (ID)
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
