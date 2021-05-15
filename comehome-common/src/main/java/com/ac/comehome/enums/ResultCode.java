package com.ac.comehome.enums;

/**
 * @desc 系统错误提示  200-->Success  7000-->Fail
 * @author 帅气的二峰
 * @date 2020-03-23
 */
public enum ResultCode {



    //普通的(common) 7000
    COMMON_ERROR("Fail!",7000),
    COMMON_PARAMS_INVALID("提交参数不合法",7001),
    COMMON_EMPTY_CONDITION_RESULT("没有找到符合条件的数据",7000),


    //关于file，io 7100
    FILE_IO_ERROR("io通用错误",7100),
    FILE_NOT_FOUND("文件未找到",7101),
    FILE_DATA_NULL("文档中不存在有效数据",7102),
    FILE_DATA_FORMAT_INVALID("文档中的数据格式非法",7103),

    //uploading 7200
    UPLOAD_FILE_FORMAT_ERROR("上传的文件格式错误",7200),
    UPLOAD_FILE_SIZE_MAX("上传的文件大小超出限制",7201),
    UPLOAD_FILE_NOT_EXIST("文件不存在",7202),

    //sql 7300
    SQL_ERROR("mysql通用错误",7300),
    SQL_INSERT_FAIL("增加失败",7301),
    SQL_DELETE_FAIL("删除失败",7302),
    SQL_UPDATE_FAIL("修改失败",7303),
    SQL_ID_NOT_EXIST("主键不能为空",7304),

    //login 7400
    NO_LOGIN("用户未登录",7400),
    WRONG_ACCOUNT_OR_PWD("账号或密码错误",7401),
    WRONG_ACCOUNT_PWD("账号密码错误",7402),
    ADMIN_ONLY("只有管理员账号才有操作权限",7403),
    WRONG_ACCOUNT_NO_OPENID("用户未注册",7405),
    WRONG_ACCOUNT_YES_OPENID("用户已注册",7406),
    WRONG_ACCOUNT_OPENID("用户注册失败",7407),



    //form-register 7500
    INVALID_PWD("密码格式错误",7500),
    INVALID_NAME("账号格式错误",7501),
    INVALID_EMAIL("邮箱格式错误",7502),
    INVALID_VSCODE("验证码输入错误",7503),
    INVALID_PARAMS("填写的字段不合法",7504),

    //map 7600
    NO_GET_MAP("无法获取地图",7600),

    //7700
    WRONG_EQUIPMENT_BIND("绑定失败",7700),

    SYSTEM_EXCEPTION("系统异常",7999),

    SUCCESS("Success!",6000);
    public final String message;
    public final int code;
    ResultCode(String message, int code) {
        this.message = message;
        this.code = code;
    }


    public Integer code() {
        return code;
    }

    public String message() {
        return message;
    }
}
