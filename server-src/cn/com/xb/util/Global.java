package cn.com.xb.util;

public final class Global {
	
	/**
	 * 常量工具类
	 * @author Mine
	 *setRegisterType
	 */
	
	public static final int PAGE_SIZE = 8; //分页时每页显示的记录数
	
	public static final int REGISTER_TYPE_1 = 1; //管理员添加
	public static final int REGISTER_TYPE_2 = 2; //用户通过Web网页注册
	public static final int REGISTER_TYPE_3 = 3; //用户通过手机注册
	public static final int REGISTER_TYPE_4 = 4; //系统注册（如同步交易信息时，系统无此用户时添加）
	
	public static final int USER_TYPE_1 = 1; //普通注册用户
	public static final int USER_TYPE_2 = 2; //快递员
	public static final int USER_TYPE_3 = 3; //系统维护人员
	
	public static final int USER_STATUS_WJH = 1; //未激活
	public static final int USER_STATUS_JH = 2; //激活
	public static final int USER_STATUS_JY = 3; //禁用
	public static final int USER_STATUS_WX = 4; //无效
	
	// 交易订单类型
	public static final int TRANS_TYPE_1 = 1;	// 用户寄件
	public static final int TRANS_TYPE_2 = 2;	// 快递员投件
	public static final int TRANS_TYPE_3 = 3;	// 用户寄存
	
	// 交易动作类型
	public static final int TRANS_ACTION_TYPE_1 = 1;	// 寄件人成功存件
	public static final int TRANS_ACTION_TYPE_2 = 2;	// 快递员成功取件
	public static final int TRANS_ACTION_TYPE_3 = 3;	// 快递员成功投件
	public static final int TRANS_ACTION_TYPE_4 = 4;	// 收件人成功取件
	public static final int TRANS_ACTION_TYPE_5 = 5;	// 寄存人成功寄件
	public static final int TRANS_ACTION_TYPE_6 = 6;	// 寄存人成功取件
	public static final int TRANS_ACTION_TYPE_7 = 7;	// 寄件人寄件无空箱
	public static final int TRANS_ACTION_TYPE_8 = 8;	// 快递员投件无空箱
	public static final int TRANS_ACTION_TYPE_9 = 9;	// 寄存人存件无空箱
	public static final int TRANS_ACTION_TYPE_10 = 10;	// 快递员投件退件
	public static final int TRANS_ACTION_TYPE_11 = 11;	// 寄存人寄件退件
	
	
	public static final String ROLE_ID_NM = "141b5744cc728976"; //匿名用户角色ID
	public static final String ROLE_ID_ZCYH = "141bb27b81935887"; //注册用户角色
	

	public static final String DICTIONARY_TYPE_TRANS_TYPE 				= "1";	// 交易类型
	public static final String DICTIONARY_TYPE_PAY_METHODS 				= "2";	// 付款方式
	public static final String DICTIONARY_TYPE_TRANS_ACTION_TYPE 		= "3";	// 交易动作类型
	public static final String DICTIONARY_TYPE_BOX_SIZE 				= "4";	// 箱子尺寸类型
	public static final String DICTIONARY_TYPE_BOX_LOAD_STATUS 			= "5";	// 箱子存货状态
	public static final String DICTIONARY_TYPE_BOX_RUN_STATUS 			= "6";	// 箱子运行状态
	public static final String DICTIONARY_TYPE_CABINET_STATUS 			= "7";	// 柜子状态
	public static final String DICTIONARY_TYPE_SS_RUN_STATUS 			= "8";	// 物箱运行状态
	public static final String DICTIONARY_TYPE_PERIPHERAL_TYPE 			= "9";	// 外围设备类型
	public static final String DICTIONARY_TYPE_PERIPHERAL_STATUS 		= "10";	// 外围设备状态
	public static final String DICTIONARY_TYPE_SS_PERIPHERAL_RUN_STATUS = "11";	// 对应物箱的外围设备运行状态
	public static final String DICTIONARY_TYPE_SS_EXTERIOR_TYPE 		= "12";	// 物箱外观类型
	public static final String DICTIONARY_TYPE_INTF_UPDOWN 				= "13";	// 传输接口上行下行
	public static final String DICTIONARY_TYPE_EXE_TO_SS_PERMISSION 	= "14";	// 快递员组对物箱可执行权限类型
	public static final String DICTIONARY_TYPE_EXP_COM_SERVICE_STATUS 	= "15";	// 快递公司服务状态
	public static final String DICTIONARY_TYPE_SS_MATAIN_STATUS 		= "17";	// 物箱维护记录进行状态
	public static final String DICTIONARY_TYPE_SS_MATAIN_TYPE 			= "18";	// 物箱维护类型
	public static final String DICTIONARY_TYPE_USER_GENDER 				= "19";	// 用户性别
	public static final String DICTIONARY_TYPE_USER_PAPERWORK_TYPE 		= "20";	// 证件类型
	public static final String DICTIONARY_TYPE_USER_STATUS 				= "21";	// 用户状态
	public static final String DICTIONARY_TYPE_USER_CARD_TYPE 			= "22";	// 用户卡片类型
	public static final String DICTIONARY_TYPE_USER_CARD_STATUS 		= "23";	// 用户卡片状态
	public static final String DICTIONARY_TYPE_USER_REGISTER_TYPE 		= "24";	// 注册人员注册方式
	public static final String DICTIONARY_TYPE_COURIER_STATUS 			= "25";	// 快递人员状态
	public static final String DICTIONARY_TYPE_VOCHER_STATUS 			= "26";	// 优惠劵状态
	public static final String DICTIONARY_TYPE_ROLE_STATUS 				= "27";	// 角色状态
	public static final String DICTIONARY_TYPE_MODULE_TYPE 				= "28";	// 模块类型
	public static final String DICTIONARY_TYPE_MODULE_STATUS 			= "29";	// 模块状态
	public static final String DICTIONARY_TYPE_ALIASES_LEVEL 			= "30";	// 定制物箱别名级别
	public static final String DICTIONARY_TYPE_USER_TYPE 				= "31";	// 用户类型
	public static final String DICTIONARY_TYPE_ZONE_TYPE				= "32"; // 行政区域状态
	public static final String DICTIONARY_TYPE_IPLINK_TYPE				= "33"; // IP链路类型
	public static final String DICTIONARY_TYPE_ROLE_TYPE				= "34"; // 角色类型
	public static final String DICTIONARY_TYPE_TRANS_PAY_TYPE			= "35"; // 交易支付款项类别
	public static final String DICTIONARY_TYPE_AUTHORITY_TYPE			= "36"; // 维护权限类型
	public static final String DICTIONARY_TYPE_TRANS_ORDER_TYPE			= "37"; // 订单状态
	public static final String DICTIONARY_TYPE_SYS_PLAT_TYPE			= "38"; // 操作日志平台
	public static final String DICTIONARY_TYPE_OPERATION_TYPE			= "39"; // 操作日志操作类型
	

	public static final String GB_DISTRICT_TREE_ROOT			= "000000";		// 区域代码，根级别
	
	public static final int BOX_SIZE_XXL = 1; //超大
	public static final int BOX_SIZE_XL = 2; //大
	public static final int BOX_SIZE_L = 3; //中
	public static final int BOX_SIZE_M = 4; //小
	public static final int BOX_SIZE_S = 5; //超小
	
	public static final int BOX_LOADSTATUS_IDLE = 1; //空闲
	public static final int BOX_LOADSTATUS_OCCU = 2; //占用
	public static final int BOX_LOADSTATUS_OCCU_TIMEOUT = 3; //占用超时
	public static final int BOX_LOADSTATUS_OCCU_EXT = 4; //占用超期
	
	public static final String TEMP_PATH 	= "uploadFiles/temp/";
	public static final String SNAP_PATH 	= "uploadFiles/snapshotPic/";
	public static final String PAPER_PATH 	= "uploadFiles/paperworkPic/";
	
	public static final int ROLE_TYPE_PORTAL = 1;	//普通用户
	public static final int ROLE_TYPE_PLAT = 2;//系统管理
	
	public static final String MODULE_ID_PLAT = "2";	// 平台模块ID
	public static final String MODULE_ID_PORTAL = "3";	// 门户模块ID
	
	//public static final int BOX_GUI_RESPONSE_UNTREAT = 0;//未处理
	//public static final int BOX_GUI_RESPONSE_SUCCESS = 1;//成功
	//public static final int BOX_GUI_RESPONSE_FAIL = 2;//失败
	
	public static final int RECIPIENT = 1; //取件/收件
	public static final int SENDPIECES = 2; //派件
	
	public static final int BOX_GUI_RESPONSETYPE_SYN = 1; //请求类型 ：同步
	public static final int BOX_GUI_OPENBOX = 2; //请求类型：开箱
	public static final int BOX_GUI_SETSYSTEMUSER = 3; //设置维护员
	public static final int BOX_GUI_RECIPIENTCOURIER = 4; //设置收件快递员组
	public static final int BOX_GUI_CASTPARTS = 5; //设置投件快递员组 
	public static final int BOX_GUI_BOXSTATUS = 6; //查询物箱状态
	public static final int BOX_GUI_PERIPHERAL = 7; //查询外围设备
	public static final int BOX_GUI_BOXINFO = 8; //查询箱子信息
	
	public static final int ALIASESLEVEL_1 = 1;//定制级别一级 无租用箱子
	public static final int ALIASESLEVEL_2 = 2;//定制级别二级 租用箱子

	// 交易订单状态
	public static final int TRANS_ORDER_STATUS_FINISH				= 1;	// 完成
	public static final int TRANS_ORDER_STATUS_PUT_INTO_BOX			= 2;	// 已投入物箱
	public static final int TRANS_ORDER_STATUS_REVOKE				= 3;	// 撤回
	public static final int TRANS_ORDER_STATUS_ASSIGNED_COURIERS	= 4;	// 已分配快递员
	public static final int TRANS_ORDER_STATUS_FAILED				= 5;	// 失败（如：没有空箱）
	
	/**
	 * 物箱、平台接口代码
	 */
	public static final String XB_001 = "1"; //物箱信息注册同步
	public static final String XB_002 = "2"; //上传同步交易信息
	public static final String XB_003 = "3"; //发送开箱请求至物箱
	public static final String XB_004 = "4";// 开箱逾期信息发送
	public static final String XB_005 = "5";//通知平台已开启的箱子信息
	public static final String XB_006 = "6";// 平台计算快递费用
	public static final String XB_007 = "7";//同步箱子状态
	public static final String XB_008 = "8"; //更新快递员信息
	public static final String XB_009 = "9"; //更新维护人员信息
	public static final String XB_010 = "10";//发送寄存请求
	public static final String XB_011 = "11"; //通知箱子5秒后打开
	
	public static final String XB_012 = "12"; //APP登陆
	public static final String XB_013 = "13"; //APP请求开箱
	public static final String XB_014 = "14"; //APP请求开箱结果反馈接口
	public static final String XB_015 = "15"; //APP获取交易列表

	public static final String XB_GUI = "000000";	//GUI缺省
	public static final String XB_APP = "000001";	//APP缺省
	
	/**
	 * 同步状态 1,注册成功；2,失败、配置错误；3,失败、系统忙；4,失败、操作维护；5,同步成功；6,失败；7,拒绝同步
	 */
	public static final int SYN_1 = 1;  //1,注册成功
	public static final int SYN_2 = 2; //2,失败、配置错误
	public static final int SYN_3 = 3; //3,失败、系统忙
	public static final int SYN_4 = 4; //4,失败、操作维护
	public static final int SYN_5 = 5; //5,同步成功
	public static final int SYN_6 = 6; //6,失败
	public static final int SYN_7 = 7; //7,拒绝同步
	
	/**
	 * 同步类型  1，注册、新建；2，注册、故障恢复；3，注册、重启；4，注册、其他原因；5，同步、周期；6，同步、派件；7，同步、取件；8，同步、故障
	 */
	public static final int SYN_TYPE_1 = 1;
	public static final int SYN_TYPE_2 = 2;
	public static final int SYN_TYPE_3 = 3;
	public static final int SYN_TYPE_4 = 4;
	
	public static final int SYN_TYPE_5 = 5;
	public static final int SYN_TYPE_6 = 6;
	public static final int SYN_TYPE_7 = 7;
	public static final int SYN_TYPE_8 = 8;
	
	/**
	 * 接口返回状态
	 */
	public static final int XB_INTER_FAIL = 0;//失败
	public static final int XB_INTER_SUCCESS = 1; //成功
	
	
	/*
	 * 交易信息同步类型
	 * 1，成功：寄件人寄件；2，成功：快递员取件；3，成功：快递员投件；4，成功：收件人收件；5，成功：寄存人寄件；6，成功：寄存人取件；7，无空箱：寄件人寄件；8，无空箱：快递员投件；9，无空箱：寄存；10，退件：快递员投件；11，退件：寄存人寄件
	 */
	public static final int SYN_TRANS_ACTION_TYPE_1 	= 1;
	public static final int SYN_TRANS_ACTION_TYPE_2 	= 2;
	public static final int SYN_TRANS_ACTION_TYPE_3 	= 3;
	public static final int SYN_TRANS_ACTION_TYPE_4 	= 4;
	public static final int SYN_TRANS_ACTION_TYPE_5 	= 5;
	public static final int SYN_TRANS_ACTION_TYPE_6 	= 6;
	public static final int SYN_TRANS_ACTION_TYPE_7 	= 7;
	public static final int SYN_TRANS_ACTION_TYPE_8 	= 8;
	public static final int SYN_TRANS_ACTION_TYPE_9 	= 9;
	public static final int SYN_TRANS_ACTION_TYPE_10 	= 10;
	public static final int SYN_TRANS_ACTION_TYPE_11 	= 11;
	
	
	public static final String SYNC_OP_USER_ID = "000000";	// 同步操作用户ID（假定ID）
	
	
	public static final int INTF_UP		= 1;	// 接口传输、上行
	public static final int INTF_DOWN 	= 2;	// 接口传输、下行
}
