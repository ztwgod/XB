drop table if exists T_AUTH_CARD;

drop table if exists T_BOX_INFO;

drop table if exists T_CABINET;

drop table if exists T_COURIER_INFO;

drop table if exists T_DISTRICT_RELA;

drop table if exists T_FEE_PROOF;

drop table if exists T_GB_DISTRICT;

drop table if exists T_INTF;

drop table if exists T_MAINTAINER;

drop table if exists T_OPEN_BOX_PWD;

drop table if exists T_PERIPHERAL;

drop table if exists T_STORAGESTATION;

drop table if exists T_STORAGESTATION_INTF_LOG;

drop table if exists T_STORAGESTATION_MATAIN_LOG;

drop table if exists T_TRANSACTION;

drop table if exists T_TRANS_ACTION_DETAIL;

/*==============================================================*/
/* Table: T_AUTH_CARD                                           */
/*==============================================================*/
create table T_AUTH_CARD
(
   CARD_ID              varchar(16) not null,
   CARD_CODE            varchar(16),
   USER_ID              varchar(16),
   CARD_PWD             varchar(16),
   DESCRIPTION          varchar(512),
   CARD_TYPE            int,
   EXPIRATION_DATE      datetime,
   ISSUED_AGENCY        varchar(125),
   CARD_STATUS          int,
   primary key (CARD_ID)
);

/*==============================================================*/
/* Table: T_BOX_INFO                                            */
/*==============================================================*/
create table T_BOX_INFO
(
   BOX_CODE             varchar(16) not null,
   CABINET_CODE         varchar(16),
   BOX_SEQ              varchar(16) comment '物箱端序号',
   ASSET_SN             varchar(64),
   BOX_TYPE             int,
   LOAD_STATUS          int,
   RUN_STATUS           int,
   primary key (BOX_CODE)
);

alter table T_BOX_INFO comment '每个存储小箱子信息';

/*==============================================================*/
/* Table: T_CABINET                                             */
/*==============================================================*/
create table T_CABINET
(
   SS_CODE              varchar(16),
   CABINET_CODE         varchar(16) not null,
   CABINET_SEQ          varchar(16),
   CABINET_MODEL        varchar(16),
   ASSET_SN             varchar(64),
   CABINET_WIDTH        int,
   CABINET_HEIGHT       int,
   BOX_NUMBER           int,
   CABINET_STATUS       int,
   primary key (CABINET_CODE)
);

alter table T_CABINET comment '每个物箱中的柜子信息，主要包含柜子的型号，状态等';

/*==============================================================*/
/* Table: T_COURIER_INFO                                        */
/*==============================================================*/
create table T_COURIER_INFO
(
   COURIER_ID           varchar(16) not null,
   COURIER_NAME         varchar(32),
   MOBILE_PHONE         varchar(16),
   EXCO_NAME            varchar(200),
   EMAIL                varchar(125),
   STATUS               int,
   primary key (COURIER_ID)
);

/*==============================================================*/
/* Table: T_DISTRICT_RELA                                       */
/*==============================================================*/
create table T_DISTRICT_RELA
(
   DISTRICT_ID          varchar(16) not null,
   PARENT_D_ID          varchar(16) not null,
   DISTRICT_LEVEL       int,
   PARENT_D_LEVEL       int,
   primary key (DISTRICT_ID, PARENT_D_ID)
);

alter table T_DISTRICT_RELA comment '地域表中的所有上下级关系，包括越级上下级关系';

/*==============================================================*/
/* Table: T_FEE_PROOF                                           */
/*==============================================================*/
create table T_FEE_PROOF
(
   FEE_ID               varchar(16) not null,
   TRANS_ID             varchar(16) not null,
   TRANS_ACTION_ID      varchar(16) not null,
   PAY_TYPE             int,
   PAY_DESC             varchar(512),
   NEED_PAY_PRICE       numeric(2),
   PAY_METHODS          int,
   AMOUNT               numeric(2),
   VOUCHER_ID           varchar(16),
   VOUCHER_TOTAL        int,
   primary key (FEE_ID)
);

alter table T_FEE_PROOF comment '每笔交易明细可能涉及到的支付信息';

/*==============================================================*/
/* Table: T_GB_DISTRICT                                         */
/*==============================================================*/
create table T_GB_DISTRICT
(
   DISTRICT_ID          varchar(16) not null,
   DISTRICT_NAME        varchar(100),
   DISTRICT_STATUS      int,
   PARENT_D_ID          varchar(16),
   primary key (DISTRICT_ID)
);

alter table T_GB_DISTRICT comment '国家行政地域表，与国家的行政区划一致，省、县、乡（镇、市、区）';

/*==============================================================*/
/* Table: T_INTF                                                */
/*==============================================================*/
create table T_INTF
(
   INTF_ID              varchar(16) not null,
   INTF_URL             varchar(255),
   INTF_NAME            varchar(50),
   UPDOWN               int,
   primary key (INTF_ID)
);

alter table T_INTF comment '接口类型信息';

/*==============================================================*/
/* Table: T_MAINTAINER                                          */
/*==============================================================*/
create table T_MAINTAINER
(
   MAINTAINER_ID        varchar(16) not null,
   MAINTAINER_NAME      varchar(32),
   MOBILE_PHONE         varchar(16),
   EMAIL                varchar(125),
   STATUS               int,
   AUTHORITY_TYPE       int,
   OPEN_BOX_RUN_STATUS  int,
   primary key (MAINTAINER_ID)
);

/*==============================================================*/
/* Table: T_OPEN_BOX_PWD                                        */
/*==============================================================*/
create table T_OPEN_BOX_PWD
(
   PWD_TYPE             int not null,
   MOBILE_PHONE         varchar(16),
   PWD                  varchar(16),
   BOX_CODE             varchar(16) not null,
   primary key (PWD_TYPE, BOX_CODE)
);

alter table T_OPEN_BOX_PWD comment '通过密码类型、手机号、密码即可锁定到箱子ID';

/*==============================================================*/
/* Table: T_PERIPHERAL                                          */
/*==============================================================*/
create table T_PERIPHERAL
(
   PERIPHERAL_CODE      varchar(16) not null,
   PERIPHERAL_ABB_NAME  varchar(20),
   SS_CODE              varchar(16),
   ASSET_SN             varchar(64),
   TYPE                 int,
   VERSION              varchar(16),
   START_TIME           timestamp,
   STOP_TIME            timestamp,
   RUN_STATUS           int,
   STATUS               int,
   MEMO                 varchar(1000),
   primary key (PERIPHERAL_CODE)
);

alter table T_PERIPHERAL comment '外围设备信息，如警报器，摄像头，显示器，投币机等信息';

/*==============================================================*/
/* Table: T_STORAGESTATION                                      */
/*==============================================================*/
create table T_STORAGESTATION
(
   SS_NAME              varchar(32),
   SS_CODE              varchar(16) not null comment '全局唯一Code',
   SS_SEQ               varchar(16) comment '物箱编号，物箱Code的组成部分',
   SS_TYPE              varchar(512),
   MODEL_ID             varchar(16) not null,
   ASSET_SN             varchar(64),
   RUN_STATUS           int,
   DATA_CARD            varchar(16),
   IP_ADD               varchar(16),
   PORT                 varchar(8),
   LINK_TYPE            int,
   LONGITUDE            decimal(10,6),
   LATITUDE             decimal(10,6),
   CONTROL_CABINET_LOCATION varchar(255),
   AVAILABLE_BOX_NUM    int,
   INSTALL_DATE         datetime,
   primary key (SS_CODE)
);

alter table T_STORAGESTATION comment '物箱信息';

/*==============================================================*/
/* Table: T_STORAGESTATION_INTF_LOG                             */
/*==============================================================*/
create table T_STORAGESTATION_INTF_LOG
(
   LOG_ID               varchar(16) not null,
   LOG_TIME             timestamp,
   SS_CODE              varchar(16),
   INTF_ID              varchar(16),
   MSG_CONTENT          varchar(2000),
   primary key (LOG_ID)
);

alter table T_STORAGESTATION_INTF_LOG comment '每个关于物箱的接口操作信息都均保存至此表';

/*==============================================================*/
/* Table: T_STORAGESTATION_MATAIN_LOG                           */
/*==============================================================*/
create table T_STORAGESTATION_MATAIN_LOG
(
   MATAIN_ID            varchar(16) not null,
   MATAIN_TYPE          int,
   MAINTAINER_ID        varchar(16) not null,
   ASSIGN_TIME          datetime,
   COMPLETE_TIME        datetime,
   COMPLETE_RESULT      varchar(1024),
   MATAIN_STATUS        int,
   MEMO                 varchar(2000),
   primary key (MATAIN_ID)
);

alter table T_STORAGESTATION_MATAIN_LOG comment '维护人员维护物箱的记录';

/*==============================================================*/
/* Table: T_TRANSACTION                                         */
/*==============================================================*/
create table T_TRANSACTION
(
   TRANS_ID             varchar(16) not null,
   TRANS_TYPE           int,
   CREATE_TIME          timestamp,
   LAST_MODIFY_TIME     timestamp,
   CLOSE_TIME           timestamp,
   BOX_CODE             varchar(16),
   SUPPLIER_ID          varchar(16),
   EXPRESS_DELIVERY_ID  varchar(16),
   EXPRESS_CODE         varchar(16),
   EXPRESS_DESC         varchar(125),
   STORAGE_TIME         int,
   PAST_DUE_TIME        int,
   PICKUP_PWD           varchar(16),
   SIZE_TYPE            int,
   IS_STANDARDS_COMPLIANT int,
   NOT_STANDARDS_COMPLIANT_CAUSE varchar(125),
   COURIER_ID           varchar(16),
   SENDER_NAME          varchar(32),
   SENDER_PHONE         varchar(16),
   SENDER_ADDRESS       varchar(512),
   SENDER_EMAIL         varchar(125),
   ADDRESSEE_NAME       varchar(32),
   ADDRESSEE_PHONE      varchar(16),
   ADDRESSEE_ADDRESS    varchar(512),
   ADDRESSEE_EMAIL      varchar(125),
   primary key (TRANS_ID)
);

alter table T_TRANSACTION comment '每个箱子的每笔交易信息记录';

/*==============================================================*/
/* Table: T_TRANS_ACTION_DETAIL                                 */
/*==============================================================*/
create table T_TRANS_ACTION_DETAIL
(
   TRANS_ACTION_ID      varchar(16) not null,
   TRANS_ID             varchar(16) not null,
   TRANS_ACTION_TYPE    int,
   ACTION_TIME          timestamp,
   ACTIONER_PHONE       varchar(16),
   primary key (TRANS_ACTION_ID)
);

alter table T_TRANS_ACTION_DETAIL comment '每笔交易的操作明细记录';

alter table T_AUTH_CARD add constraint FK_Reference_4 foreign key (USER_ID)
      references T_COURIER_INFO (COURIER_ID) on delete restrict on update restrict;

alter table T_AUTH_CARD add constraint FK_Reference_5 foreign key (USER_ID)
      references T_MAINTAINER (MAINTAINER_ID) on delete restrict on update restrict;

alter table T_BOX_INFO add constraint FK_Reference_3 foreign key (CABINET_CODE)
      references T_CABINET (CABINET_CODE) on delete restrict on update restrict;

alter table T_CABINET add constraint FK_Reference_2 foreign key (SS_CODE)
      references T_STORAGESTATION (SS_CODE) on delete restrict on update restrict;

alter table T_DISTRICT_RELA add constraint FK_REFERENCE_44 foreign key (DISTRICT_ID)
      references T_GB_DISTRICT (DISTRICT_ID) on delete restrict on update restrict;

alter table T_DISTRICT_RELA add constraint FK_REFERENCE_45 foreign key (PARENT_D_ID)
      references T_GB_DISTRICT (DISTRICT_ID) on delete restrict on update restrict;

alter table T_FEE_PROOF add constraint FK_Reference_10 foreign key (TRANS_ACTION_ID)
      references T_TRANS_ACTION_DETAIL (TRANS_ACTION_ID) on delete restrict on update restrict;

alter table T_FEE_PROOF add constraint FK_Reference_11 foreign key (TRANS_ID)
      references T_TRANSACTION (TRANS_ID) on delete restrict on update restrict;

alter table T_OPEN_BOX_PWD add constraint FK_Reference_6 foreign key (BOX_CODE)
      references T_BOX_INFO (BOX_CODE) on delete restrict on update restrict;

alter table T_PERIPHERAL add constraint FK_Reference_1 foreign key (SS_CODE)
      references T_STORAGESTATION (SS_CODE) on delete restrict on update restrict;

alter table T_STORAGESTATION_INTF_LOG add constraint FK_REFERENCE_26 foreign key (INTF_ID)
      references T_INTF (INTF_ID) on delete restrict on update restrict;

alter table T_STORAGESTATION_INTF_LOG add constraint FK_Reference_8 foreign key (SS_CODE)
      references T_STORAGESTATION (SS_CODE) on delete restrict on update restrict;

alter table T_STORAGESTATION_MATAIN_LOG add constraint FK_Reference_14 foreign key (MAINTAINER_ID)
      references T_MAINTAINER (MAINTAINER_ID) on delete restrict on update restrict;

alter table T_TRANS_ACTION_DETAIL add constraint FK_Reference_9 foreign key (TRANS_ID)
      references T_TRANSACTION (TRANS_ID) on delete restrict on update restrict;
