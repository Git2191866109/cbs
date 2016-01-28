package com.bs.plugins.thirdparty.umpay.constants;

/**
 * User: zhangqh6
 * Date: 2015/12/28 13:55:55
 */
public class IParam {

    public class PUB {
        public static final String SERVICE = "service";
        public static final String SIGN_TYPE = "sign_type";
        public static final String SIGN = "sign";
        public static final String MER_ID = "mer_id";
        public static final String VERSION = "version";
        public static final String CHARSET = "charset";
        public static final String RES_FORMAT = "res_format";
        public static final String RET_URL = "ret_url";
        public static final String NOTIFY_URL = "notify_url";
        public static final String APPLY_NOTIFY_FLAG = "apply_notify_flag";
        public static final String SOURCE_V = "sourceV";
    }

    public class CUST {
        public static final String IDENTITY_TYPE = "identity_type";
        public static final String IDENTITY_CODE = "identity_code";
        public static final String MER_CUST_ID = "mer_cust_id";
        public static final String MER_CUST_NAME = "mer_cust_name";
        public static final String MOBILE_ID = "mobile_id";
        public static final String EMAIL = "email";
    }

    public class ORDER {
        public static final String ORDER_ID = "order_id";
        public static final String MER_DATE = "mer_date";
        public static final String USER_ID = "user_id";
        public static final String ACCOUNT_ID = "account_id";
        public static final String AMOUNT = "amount";
        /*订单有效期*/
        public static final String EXPIRE_TIME = "expire_time";
    }

    public class PROJECT {
        /*标的号(必填)*/
        public static final String PROJECT_ID = "project_id";
        /*标的名称(必填)*/
        public static final String PROJECT_NAME = "project_name";
        /*标的金额(必填)*/
        public static final String PROJECT_AMOUNT = "project_amount";
        /*标的有效期*/
        public static final String PROJECT_EXPIRE_DATE = "project_expire_date";
        /*融资人-托管用户号(必填)*/
        public static final String LOAN_USER_ID = "loan_user_id";
        /*融资人-托管账户号*/
        public static final String LOAN_ACCOUNT_ID = "loan_account_id";
        /*融资人-托管账户类型*/
        public static final String LOAN_ACC_TYPE = "loan_acc_type";
        /*担保人-托管用户号*/
        public static final String WARRANTY_USER_ID = "warranty_user_id";
        /*担保人-托管账户号*/
        public static final String WARRANTY_ACCOUNT_ID = "warranty_account_id";
        /*使用人-托管用户号*/
        public static final String RECEIVE_USER_ID = "receive_user_id";
        /*使用人-托管账户号*/
        public static final String RECEIVE_ACCOUNT_ID = "receive_account_id";
        /*使用人-托管账户类型*/
        public static final String RECEIVE_ACC_TYPE = "receive_acc_type";

        /*更新类型-01：更新标的；02：标的融资人；03：标的代偿方；04：标的资金使用方；每次操作只能选择一种更新类型*/
        public static final String CHANGE_TYPE = "change_type";
        /*关系人操作类型【change_type！=01有效】-0-新增；1-注销*/
        public static final String OPTION_TYPE = "option_type";
        /*标的状态【change_type=01有效】0：开标、1：投标中、2：还款中、3：已还款、4：结束*/
        public static final String PROJECT_STATE = "project_state";
        
        /*业务类型     转入：01投标、02债权购买、03还款*/
        public static final String SERV_TYPE = "serv_type";
        /*转账方向  01标的转入（对应serv_type标的转入类型）*/
        public static final String TRANS_ACTION = "trans_action";
        /*转账方类型   01投资者02融资人03 P2P平台04担保方05资金使用方*/
        public static final String PARTIC_TYPE = "partic_type";
        /*转账方账户类型  01对私（个人用户）02对公（企业用户）*/
        public static final String PARTIC_ACC_TYPE = "partic_acc_type";
        /*转账方用户号 个 人用户：联动开立的用户号 企业用户：联动开立的商户号*/
        public static final String PARTIC_USER_ID = "partic_user_id";
        /*转账方账户号  联动开立的账户号，商户可以不传递，如果传递必须和开户时返回的保持一致，如果未返回则忽略此字段*/
        public static final String PARTIC_ACCOUNT_ID = "partic_account_id";
       

    }



}
