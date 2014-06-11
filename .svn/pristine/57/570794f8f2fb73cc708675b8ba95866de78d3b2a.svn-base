drop table if exists T_AUTH_CARD;

drop table if exists T_BLOB_FILES;

drop table if exists T_BOX_INFO;

drop table if exists T_CABINET;

drop table if exists T_COURIER_GROUP;

drop table if exists T_DICTIONARY_TYPE;

drop table if exists T_DISTRICT_RELA;

drop table if exists T_EXPRESS_COMPANY;

drop table if exists T_FEE_PROOF;

drop table if exists T_FLAG_DICTIONARY;

drop table if exists T_GB_DISTRICT;

drop table if exists T_INTF;

drop table if exists T_ISSUED_AGENCY;

drop table if exists T_LEASE_ALIASES;

drop table if exists T_LEASE_BOX_RELA;

drop table if exists T_LOCATION;

drop table if exists T_MODULE;

drop table if exists T_OPERATION_LOG;

drop table if exists T_PERIPHERAL;

drop table if exists T_P_CLIENT;

drop table if exists T_P_COURIER;

drop table if exists T_P_SYS;

drop table if exists T_ROLE;

drop table if exists T_ROLE_MODULE;

drop table if exists T_SNAP_VERIFY_CODE;

drop table if exists T_SS_TYPE_EXTERIOR;

drop table if exists T_STORAGESTATION;

drop table if exists T_STORAGESTATION_DELIVERY_G;

drop table if exists T_STORAGESTATION_EXTERIOR;

drop table if exists T_STORAGESTATION_GROUP;

drop table if exists T_STORAGESTATION_INTF_LOG;

drop table if exists T_STORAGESTATION_MATAIN_LOG;

drop table if exists T_STORAGESTATION_MODEL;

drop table if exists T_STORAGESTATION_PERIPHERAL;

drop table if exists T_STORAGESTATION_TYPE;

drop table if exists T_SYSUSER_STORAGESTATION;

drop table if exists T_TRANSACTION;

drop table if exists T_TRANS_ACTION_DETAIL;

drop table if exists T_USER;

drop table if exists T_USER_ROLE;

drop table if exists T_VOCHER;

drop table if exists T_SS_BOXNUM_LOG;


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
   ISSUED_AGENCY        varchar(16),
   CARD_STATUS          int,
   primary key (CARD_ID)
)ENGINE=InnoDB ;

alter table T_AUTH_CARD comment '用户使用的卡的信息，像快递员开箱使用的卡，系统用户维护人员开箱使用的卡等信息';

/*==============================================================*/
/* Table: T_BLOB_FILES                                          */
/*==============================================================*/
create table T_BLOB_FILES
(
   FILE_ID              varchar(16) not null,
   FILE_NAME            varchar(64),
   FILE_SUFFIX          varchar(8),
   FILE_TYPE            varchar(32),
   FILE_CONTENTS        longblob,
   FILE_SIZE            decimal(3),
   primary key (FILE_ID)
)ENGINE=InnoDB ;

alter table T_BLOB_FILES comment '存放所有的附件信息，包括图片，文件等';

/*==============================================================*/
/* Table: T_BOX_INFO                                            */
/*==============================================================*/
create table T_BOX_INFO
(
   BOX_ID               varchar(16) not null,
   CABINET_ID           varchar(16),
   SS_ID                varchar(16),
   BOX_CODE             varchar(32),
   BOX_INDEX            varchar(16) comment '物箱端序号',
   ASSET_SN             varchar(64),
   SIZE                 int,
   LOAD_STATUS          int,
   RUN_STATUS           int,
   primary key (BOX_ID)
)ENGINE=InnoDB ;

alter table T_BOX_INFO comment '每个存储小箱子信息';

/*==============================================================*/
/* Table: T_CABINET                                             */
/*==============================================================*/
create table T_CABINET
(
   CABINET_ID           varchar(16) not null,
   SS_ID                varchar(16),
   CABINET_CODE         varchar(32),
   CABINET_INDEX        varchar(16),
   CABINET_TYPE         int,
   CABINET_MODEL        varchar(16),
   ASSET_SN             varchar(64),
   CABINET_WIDTH        int,
   CABINET_HEIGHT       int,
   BOX_NUMBER           int,
   CABINET_STATUS       int,
   primary key (CABINET_ID)
)ENGINE=InnoDB ;

alter table T_CABINET comment '每个物箱中的柜子信息，主要包含柜子的型号，状态等';

/*==============================================================*/
/* Table: T_COURIER_GROUP                                       */
/*==============================================================*/
create table T_COURIER_GROUP
(
   GROUP_ID             varchar(16) not null,
   GROUP_NAME           varchar(200),
   EXCO_ID              varchar(16) not null,
   DISTRICT_ID          varchar(16) not null,
   PICK_CONTACTOR_M     varchar(16),
   primary key (GROUP_ID)
)ENGINE=InnoDB ;

alter table T_COURIER_GROUP comment '快递员分组';

/*==============================================================*/
/* Table: T_DICTIONARY_TYPE                                     */
/*==============================================================*/
create table T_DICTIONARY_TYPE
(
   TYPE_ID              varchar(8) not null,
   TYPE_NAME            varchar(125),
   primary key (TYPE_ID)
)ENGINE=InnoDB ;

alter table T_DICTIONARY_TYPE comment '字典表中的记录类型，标示该字典记录是交易类型还是箱子状态等等';

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
)ENGINE=InnoDB ;

alter table T_DISTRICT_RELA comment '地域表中的所有上下级关系，包括越级上下级关系';

/*==============================================================*/
/* Table: T_EXPRESS_COMPANY                                     */
/*==============================================================*/
create table T_EXPRESS_COMPANY
(
   EXCO_ID              varchar(16) not null,
   EXCO_NAME            varchar(200),
   CONTACTOR_NAME       varchar(32),
   CONTACT_PHONE        varchar(16),
   CONTACT_ADD          varchar(255),
   SERVICE_STATUS       int,
   CONTRACT_NO          varchar(50),
   VALID_DATE           datetime,
   primary key (EXCO_ID)
)ENGINE=InnoDB ;

alter table T_EXPRESS_COMPANY comment '快递公司信息';

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
   PAY_METHODS          int,
   AMOUNT               numeric(2),
   VOUCHER_ID           varchar(16),
   VOUCHER_TOTAL        int,
   BOX_FEE_ID           varchar(16),
   primary key (FEE_ID)
)ENGINE=InnoDB ;

alter table T_FEE_PROOF comment '每笔交易明细可能涉及到的支付信息';

/*==============================================================*/
/* Table: T_FLAG_DICTIONARY                                     */
/*==============================================================*/
create table T_FLAG_DICTIONARY
(
   CODE                 int not null,
   NAME                 varchar(32),
   TYPE_ID              varchar(8) not null,
   DESCRIPTION          varchar(512),
   STATUS               int,
   primary key (CODE, TYPE_ID)
)ENGINE=InnoDB ;

alter table T_FLAG_DICTIONARY comment '所有类型状态的字典表，比如交易类型，箱子状态，物箱状态等等';

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
)ENGINE=InnoDB ;

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
)ENGINE=InnoDB ;

alter table T_INTF comment '接口类型信息';

/*==============================================================*/
/* Table: T_ISSUED_AGENCY                                       */
/*==============================================================*/
create table T_ISSUED_AGENCY
(
   AGENCY_ID            varchar(16) not null,
   AGENCY_CODE          varchar(16),
   AGENCY_NAME          varchar(255),
   AGENCY_DESC          varchar(1024),
   primary key (AGENCY_ID)
)ENGINE=InnoDB ;

/*==============================================================*/
/* Table: T_LEASE_ALIASES                                       */
/*==============================================================*/
create table T_LEASE_ALIASES
(
   ALIASES_ID           varchar(16) not null,
   ALIASES_NAME         varchar(32),
   USER_ID              varchar(16) not null,
   SS_ID                varchar(16) not null,
   LEASE_BOX_NUM        int,
   ALIASES_LEVEL        int,
   primary key (ALIASES_ID)
)ENGINE=InnoDB ;

/*==============================================================*/
/* Table: T_LEASE_BOX_RELA                                      */
/*==============================================================*/
create table T_LEASE_BOX_RELA
(
   ALIASES_ID           varchar(16) not null,
   BOX_ID               varchar(16) not null,
   primary key (ALIASES_ID, BOX_ID)
)ENGINE=InnoDB ;

/*==============================================================*/
/* Table: T_LOCATION                                            */
/*==============================================================*/
create table T_LOCATION
(
   LOCATION_ID          varchar(16) not null,
   LOCATION_CODE        varchar(10),
   LOCATION_ABB         varchar(50),
   ADDRESS              varchar(1000),
   DISTRICT_ID          varchar(16) not null,
   primary key (LOCATION_ID)
)ENGINE=InnoDB ;

alter table T_LOCATION comment '物箱确切地点标示，如浦东新区的某某学校地址，某某超市地址等';

/*==============================================================*/
/* Table: T_MODULE                                              */
/*==============================================================*/
create table T_MODULE
(
   MODULE_ID            varchar(16) not null,
   MODULE_CODE          varchar(64),
   PARENT_M_ID          varchar(16),
   MODULE_NAME          varchar(100),
   MODULE_LINK          varchar(128),
   MODULE_DESC          varchar(512),
   MODULE_LEVEL         int,
   SHOW_SEQ             int,
   MODULE_TYPE          int,
   CREATE_TIME          datetime,
   CREATOR              varchar(16),
   ENABLE_TIME          datetime,
   STATUS               int,
   primary key (MODULE_ID)
)ENGINE=InnoDB ;

alter table T_MODULE comment '存储所有模块信息，比如功能模块菜单，按钮等，涉及到权限控制的';

/*==============================================================*/
/* Table: T_OPERATION_LOG                                       */
/*==============================================================*/
create table T_OPERATION_LOG
(
   LOG_ID               varchar(16) not null,
   SYS_PLAT_TYPE        int,
   OPERATION_USER_ID    varchar(16),
   OPERATION_TYPE       int,
   SS_ID                varchar(16),
   BOX_ID               varchar(16),
   OPERATION_CONTENT    longtext,
   OPERATION_RESULT     longtext,
   OPERATION_TIME       datetime,
   primary key (LOG_ID)
)ENGINE=InnoDB ;

/*==============================================================*/
/* Table: T_PERIPHERAL                                          */
/*==============================================================*/
create table T_PERIPHERAL
(
   PERIPHERAL_ID        varchar(16) not null,
   PERIPHERAL_CODE      varchar(32),
   PERIPHERAL_ABB_NAME  varchar(20),
   ASSET_SN             varchar(64),
   TYPE                 int,
   VERSION              varchar(16),
   START_TIME           datetime,
   STOP_TIME            datetime,
   STATUS               int,
   MEMO                 varchar(1000),
   primary key (PERIPHERAL_ID)
)ENGINE=InnoDB ;

alter table T_PERIPHERAL comment '外围设备信息，如警报器，摄像头，显示器，投币机等信息';

/*==============================================================*/
/* Table: T_P_CLIENT                                            */
/*==============================================================*/
create table T_P_CLIENT
(
   USER_ID              varchar(16) not null,
   REGISTER_TYPE        int,
   OVERAGE              numeric(2),
   primary key (USER_ID)
)ENGINE=InnoDB ;

alter table T_P_CLIENT comment '注册用户信息，包括注册方式，余额';

/*==============================================================*/
/* Table: T_P_COURIER                                           */
/*==============================================================*/
create table T_P_COURIER
(
   USER_ID              varchar(16) not null,
   GROUP_ID             varchar(16),
   EXCO_ID              varchar(16) not null,
   COURIER_STATUS       int,
   LOCALE_ID            varchar(16),
   SNAPSHOT_PIC_ID      varchar(16),
   PAPERWORK_PIC1_ID    varchar(16),
   PAPERWORK_PIC2_ID    varchar(16),
   primary key (USER_ID)
)ENGINE=InnoDB ;

alter table T_P_COURIER comment '存放快递人员的专属信息，如快递公司信息等。';

/*==============================================================*/
/* Table: T_P_SYS                                               */
/*==============================================================*/
create table T_P_SYS
(
   USER_ID              varchar(16) not null,
   ORG_DESC             varchar(125),
   DEPT_DESC            varchar(125),
   primary key (USER_ID)
)ENGINE=InnoDB ;

alter table T_P_SYS comment '包括系统操作人员和物箱维护人员';

/*==============================================================*/
/* Table: T_ROLE                                                */
/*==============================================================*/
create table T_ROLE
(
   ROLE_ID              varchar(16) not null,
   ROLE_NAME            varchar(100),
   ROLE_TYPE            int,
   ROLE_DESC            varchar(512),
   CREATE_TIME          datetime,
   CREATOR              varchar(16),
   LAST_UPDATE_TIME     datetime,
   LAST_UPDATE_USER     varchar(16),
   STATUS               int,
   primary key (ROLE_ID)
)ENGINE=InnoDB ;

alter table T_ROLE comment '存储所有角色信息';

/*==============================================================*/
/* Table: T_ROLE_MODULE                                         */
/*==============================================================*/
create table T_ROLE_MODULE
(
   ROLE_ID              varchar(16) not null,
   MODULE_ID            varchar(16) not null,
   primary key (MODULE_ID, ROLE_ID)
)ENGINE=InnoDB ;

alter table T_ROLE_MODULE comment '存储角色和模块之间的关系，多对多';

/*==============================================================*/
/* Table: T_SNAP_VERIFY_CODE                                    */
/*==============================================================*/
create table T_SNAP_VERIFY_CODE
(
   ID                   varchar(16) not null,
   MOBILE_NUMBER        varchar(16),
   VERIFY_CODE          varchar(6),
   TAKE_EFFECT_TIME     datetime,
   EFFECTIVE_LEN        int,
   primary key (ID)
)ENGINE=InnoDB ;

alter table T_SNAP_VERIFY_CODE comment '用于存储临时发送至手机的校验码';

/*==============================================================*/
/* Table: T_SS_TYPE_EXTERIOR                                    */
/*==============================================================*/
create table T_SS_TYPE_EXTERIOR
(
   TYPE_ID              varchar(16) not null,
   EXTERIOR_ID          varchar(16) not null,
   primary key (TYPE_ID, EXTERIOR_ID)
)ENGINE=InnoDB ;

alter table T_SS_TYPE_EXTERIOR comment '物箱的类型外观关联中间表';

/*==============================================================*/
/* Table: T_STORAGESTATION                                      */
/*==============================================================*/
create table T_STORAGESTATION
(
   SS_ID                varchar(16) not null,
   SS_NAME              varchar(32),
   SS_CODE              varchar(32),
   SS_INDEX             varchar(16),
   ASSET_SN             varchar(64),
   DATA_CARD            varchar(16),
   IP_ADD               varchar(16),
   PORT                 varchar(8),
   LINK_TYPE            int,
   GROUP_ID             varchar(16),
   SS_TYPE              varchar(16),
   MODEL_ID             varchar(16) not null,
   CONTROL_CABINET_LOCATION int,
   SS_ADDRESS           varchar(1000),
   POI_ID               varchar(16),
   LONGITUDE            decimal(10,6),
   LATITUDE             decimal(10,6),
   AVAILABLE_BOX_NUM    int,
   RUN_STATUS           int,
   INSTALL_DATE         datetime,
   primary key (SS_ID)
)ENGINE=InnoDB ;

alter table T_STORAGESTATION comment '物箱信息';

/*==============================================================*/
/* Table: T_STORAGESTATION_DELIVERY_G                           */
/*==============================================================*/
create table T_STORAGESTATION_DELIVERY_G
(
   SS_ID                varchar(16) not null,
   GROUP_ID             varchar(16) not null,
   EXE_PERMISSION       int not null,
   primary key (SS_ID, GROUP_ID, EXE_PERMISSION)
)ENGINE=InnoDB ;

alter table T_STORAGESTATION_DELIVERY_G comment '关联快递员组合物箱之间的关系。此表存放的关系用于可派件快递员，可取件快递员组直接和物箱关联，不走这张中间表';

/*==============================================================*/
/* Table: T_STORAGESTATION_EXTERIOR                             */
/*==============================================================*/
create table T_STORAGESTATION_EXTERIOR
(
   EXTERIOR_ID          varchar(16) not null,
   EXTERIOR_NAME        varchar(64),
   EXTERIOR_CODE        varchar(16),
   EXTERIOR_TYPE        int,
   EXTERIOR_DESC        varchar(512),
   primary key (EXTERIOR_ID)
)ENGINE=InnoDB ;

alter table T_STORAGESTATION_EXTERIOR comment '物箱的外观类型，比如XX广告版，XX面板图片，XX规格等信息';

/*==============================================================*/
/* Table: T_STORAGESTATION_GROUP                                */
/*==============================================================*/
create table T_STORAGESTATION_GROUP
(
   GROUP_ID             varchar(16) not null,
   GROUP_ABB            varchar(50),
   GROUP_CODE           varchar(12),
   GROUP_DESC           varchar(512),
   LOCATION_ID          varchar(16) not null,
   AVAILABLE_BOX_NUM    int,
   SEAT_DESC            varchar(125),
   LONGITUDE            decimal(10,6),
   LATITUDE             decimal(10,6),
   primary key (GROUP_ID)
)ENGINE=InnoDB ;

alter table T_STORAGESTATION_GROUP comment '物箱组信息，主要是将某一区域的物箱组在一起，比如某某大学图书馆一楼，某某超市前门等';

/*==============================================================*/
/* Table: T_STORAGESTATION_INTF_LOG                             */
/*==============================================================*/
create table T_STORAGESTATION_INTF_LOG
(
   LOG_ID               varchar(16) not null,
   LOG_TIME             datetime,
   SS_ID                varchar(16),
   INTF_ID              varchar(16),
   MSG_CONTENT          longtext,
   primary key (LOG_ID)
)ENGINE=InnoDB ;

alter table T_STORAGESTATION_INTF_LOG comment '每个关于物箱的接口操作信息都均保存至此表';

/*==============================================================*/
/* Table: T_STORAGESTATION_MATAIN_LOG                           */
/*==============================================================*/
create table T_STORAGESTATION_MATAIN_LOG
(
   MATAIN_ID            varchar(16) not null,
   MATAIN_TYPE          int,
   USER_ID              varchar(16) not null,
   ASSIGN_TIME          datetime,
   COMPLETE_TIME        datetime,
   COMPLETE_RESULT      varchar(1024),
   MATAIN_STATUS        int,
   MEMO                 varchar(2000),
   SS_ID                varchar(16) not null,
   primary key (MATAIN_ID)
)ENGINE=InnoDB ;

alter table T_STORAGESTATION_MATAIN_LOG comment '维护人员维护物箱的记录';

/*==============================================================*/
/* Table: T_STORAGESTATION_MODEL                                */
/*==============================================================*/
create table T_STORAGESTATION_MODEL
(
   MODEL_ID             varchar(16) not null,
   MODEL_ABB            varchar(20),
   MODEL_FULL_CODE      varchar(100),
   primary key (MODEL_ID)
)ENGINE=InnoDB ;

/*==============================================================*/
/* Table: T_STORAGESTATION_PERIPHERAL                           */
/*==============================================================*/
create table T_STORAGESTATION_PERIPHERAL
(
   SS_ID                varchar(16) not null,
   PERIPHERAL_ID        varchar(16) not null,
   RUN_STATUS           INT,
   primary key (PERIPHERAL_ID, SS_ID)
)ENGINE=InnoDB ;

alter table T_STORAGESTATION_PERIPHERAL comment '物箱和外围设备的关联表信息，此信息包含状态，这个状态标示每个物箱上的该外围设备状态';

/*==============================================================*/
/* Table: T_STORAGESTATION_TYPE                                 */
/*==============================================================*/
create table T_STORAGESTATION_TYPE
(
   TYPE_ID              varchar(16) not null,
   TYPE_NAME            varchar(64),
   TYPE_CODE            varchar(16),
   TYPE_DESC            varchar(512),
   primary key (TYPE_ID)
)ENGINE=InnoDB ;

alter table T_STORAGESTATION_TYPE comment '物箱类型表，主要是物箱的外观信息';

/*==============================================================*/
/* Table: T_SYSUSER_STORAGESTATION                              */
/*==============================================================*/
create table T_SYSUSER_STORAGESTATION
(
   SS_ID                varchar(16) not null,
   USER_ID              varchar(16) not null,
   AUTHORITY_TYPE       int,
   OPEN_BOX_RUN_STATUS  int,
   primary key (SS_ID, USER_ID)
)ENGINE=InnoDB ;

alter table T_SYSUSER_STORAGESTATION comment '物箱维护人员和物箱之间的关系';

/*==============================================================*/
/* Table: T_TRANSACTION                                         */
/*==============================================================*/
create table T_TRANSACTION
(
   TRANS_ID             varchar(16) not null,
   TRANS_CODE           varchar(16),
   USER_ID              varchar(16),
   SUPPLIER_ID          varchar(16),
   COURIER_ID           varchar(16),
   EXPRESS_DELIVERY_ID  varchar(16),
   EXPRESS_CODE         varchar(16),
   EXPRESS_DESC         varchar(125),
   TOTAL_AMOUNT         numeric(2),
   STORAGE_TIME         int,
   PAST_DUE_TIME        int,
   PICKUP_PWD           varchar(16),
   SIZE_TYPE            int,
   IS_STANDARDS_COMPLIANT int,
   NOT_STANDARDS_COMPLIANT_CAUSE varchar(125),
   SENDER_ID            varchar(16),
   ADDRESSEE_ID         varchar(16),
   TRANS_TYPE           int,
   TRANS_STATUS         int,
   CREATE_TIME          datetime,
   LAST_MODIFY_TIME     datetime,
   CLOSE_TIME           datetime,
   BOX_ID               varchar(16) not null,
   BOX_TRANS_ID         varchar(16),
   primary key (TRANS_ID)
)ENGINE=InnoDB ;

alter table T_TRANSACTION comment '每个箱子的每笔交易信息记录';

/*==============================================================*/
/* Table: T_TRANS_ACTION_DETAIL                                 */
/*==============================================================*/
create table T_TRANS_ACTION_DETAIL
(
   TRANS_ACTION_ID      varchar(16) not null,
   TRANS_ID             varchar(16) not null,
   TRANS_ACTION_TYPE    int,
   ACTION_TIME          datetime,
   ACTIONER             varchar(16),
   BOX_ACTION_ID        varchar(16),
   primary key (TRANS_ACTION_ID)
)ENGINE=InnoDB ;

alter table T_TRANS_ACTION_DETAIL comment '每笔交易的操作明细记录';

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
create table T_USER
(
   USER_ID              varchar(16) not null,
   USER_ACCOUNT         varchar(20),
   PASSWORD             varchar(32),
   USER_TYPE            int,
   USER_NAME            varchar(32),
   GENDER               int,
   PAPERWORK_TYPE       int,
   PAPERWORK_NUM        varchar(50),
   MOBILE_NUMBER        varchar(16) not null,
   EMAIL                varchar(125),
   QQ                   varchar(16),
   WB                   varchar(512),
   WEIXIN               varchar(125),
   HOUSEHOLD_REGISTER_ADDRESS varchar(1000),
   HABITUAL_RESIDENCE   varchar(1000),
   ZIP_CODE             varchar(6),
   CREATE_TIME          datetime,
   LAST_LOGIN_TIME      datetime,
   STATUS               int,
   primary key (USER_ID)
)ENGINE=InnoDB ;

alter table T_USER comment '用户信息表，主要存储用户登录信息，快递员、注册用户、以及系统人员都有对应用户信息。';

/*==============================================================*/
/* Table: T_USER_ROLE                                           */
/*==============================================================*/
create table T_USER_ROLE
(
   USER_ID              varchar(16) not null,
   ROLE_ID              varchar(16) not null,
   primary key (ROLE_ID, USER_ID)
)ENGINE=InnoDB ;

alter table T_USER_ROLE comment '存储用户和角色之间的关系，多对多';

/*==============================================================*/
/* Table: T_VOCHER                                              */
/*==============================================================*/
create table T_VOCHER
(
   VOUCHER_ID           varchar(16) not null,
   USER_ID              varchar(16),
   ACCOUNT              decimal(10,2),
   TOTAL                int,
   USED_TOTAL           int,
   VALID_DATE           datetime,
   STATUS               int,
   primary key (VOUCHER_ID)
)ENGINE=InnoDB ;

alter table T_VOCHER comment '注册用户对应的优惠劵';


/*==============================================================*/
/* Table: T_SS_BOXNUM_LOG                                       */
/*==============================================================*/
create table T_SS_BOXNUM_LOG
(
   RECORD_ID            varchar(16) not null,
   SS_ID                varchar(16),
   TOTAL_NUM            int,
   FAULT_NUM            int,
   OCCUPATION_NUM       int,
   EMPTY_NUM            int,
   RECORD_TIME          datetime,
   primary key (RECORD_ID)
);
