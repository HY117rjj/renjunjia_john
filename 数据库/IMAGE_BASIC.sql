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
  is 'ͼƬ��Ϣ�������ݱ�';
-- Add comments to the columns 
comment on column IMAGE_BASIC.id
  is 'ϵͳ��ˮ��';
comment on column IMAGE_BASIC.title
  is 'ͼƬ����';
comment on column IMAGE_BASIC.title_ip
  is '���ӵ�ַ';
comment on column IMAGE_BASIC.title_path
  is 'ͼƬ�洢·��';
comment on column IMAGE_BASIC.upload_time
  is '�ϴ�ʱ��';
comment on column IMAGE_BASIC.system
  is 'Ӧ��ϵͳ �ֵ��
STD_IMAGE_SYSTEM
';
comment on column IMAGE_BASIC.presentation_mode
  is '���ַ�ʽ �ֵ��
STD_IMAGE_MODE
';
comment on column IMAGE_BASIC.hospital
  is 'ҽ�ƻ��� ҽ�ƻ������ݱ�
STDHOSPITAL_
 IF PRESENTATION_MODE=''ҽ�ƻ���''';
comment on column IMAGE_BASIC.start_time
  is '������ʼʱ��';
comment on column IMAGE_BASIC.end_time
  is '���ֽ�ֹʱ��';
comment on column IMAGE_BASIC.stopedflag_
  is 'ͣ�ñ�ʶ';
comment on column IMAGE_BASIC.remarks
  is '��ע';
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
