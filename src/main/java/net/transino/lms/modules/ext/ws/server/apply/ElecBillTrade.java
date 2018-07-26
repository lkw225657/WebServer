package net.transino.lms.modules.ext.ws.server.apply;

import jodd.vtor.constraint.Length;
import jodd.vtor.constraint.MaxLength;
import jodd.vtor.constraint.NotBlank;
import jodd.vtor.constraint.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.transino.lms.modules.ext.ws.server.constraint.RegexMatch;

/**
 * @author lee
 * @since 5.0
 */
@Getter
@Setter
@ToString
public class ElecBillTrade {
    /**
     *交易流水号
     */
    @NotNull(message = "交易流水号是必输项!", profiles = {"5000"})
    @NotBlank(message = "交易流水号是必输项!", profiles = {"5000"})
    @MaxLength(value = 32, message = "交易流水号允许的最大长度为32!", profiles = {"5000"})
    private String elecBatchId;

    /**
     *电票票据id
     */
    @NotNull(message = "电票票据id是必输项!", profiles = {"5000"})
    @NotBlank(message = "电票票据id是必输项!", profiles = {"5000"})
    @MaxLength(value = 64, message = "电票票据id允许的最大长度为64!", profiles = {"5000"})
    private String elecId;

    /**
     *票号
     */
    @NotNull(message = "票号是必输项!", profiles = {"5206","5204"})
    @NotBlank(message = "票号是必输项!", profiles = {"5206","5204"})
    @MaxLength(value = 64, message = "票号允许的最大长度为64!", profiles = {"5000"})
    private String accepNo;

    /**
     *票据介质类型
     */
    @NotNull(message = "票据介质类型是必输项!", profiles = {"5206","5205"})
    @NotBlank(message = "票据介质类型是必输项!", profiles = {"5206","5205"})
    @MaxLength(value = 1, message = "票据介质类型允许的最大长度为1!", profiles = {"5000"})
    @RegexMatch(value = "1|2", message = "票据介质类型范围不正确！", profiles = {"5000"})
    private String accepDielType;

    /**
     *财务公司票据
     */
    @NotNull(message = "财务公司票据是必输项!", profiles = {"5206","5205"})
    @NotBlank(message = "财务公司票据是必输项!", profiles = {"5206","5205"})
    @MaxLength(value = 1, message = "财务公司票据允许的最大长度为1!", profiles = {"5000"})
    @RegexMatch(value = "1|2", message = "财务公司票据范围不正确！", profiles = {"5000"})
    private String bown;

    /**
     *币种
     */
    @NotNull(message = "币种是必输项!", profiles = {"5000"})
    @NotBlank(message = "币种是必输项!", profiles = {"5000"})
    @MaxLength(value = 3, message = "币种允许的最大长度为3!", profiles = {"5000"})
    private String accepCurrType;

    /**
     *票面金额
     */
    @NotNull(message = "票面金额是必输项!", profiles = {"5000"})
    @RegexMatch(value = "^(\\d{1,15}\\.\\d{1,2})|((-)?\\d{1,15}\\.\\d{1,2})$", message = "票面金额范围不正确！", profiles = {"5000"})
    private Double accepAmount;

    /**
     *承兑日期
     */
    @NotNull(message = "承兑日期是必输项!", profiles = {"5000"})
    @Length(min = 10, max = 10, message = "承兑日期长度为10位，格式为YYYY-MM-DD！", profiles = {"5000"})
    @RegexMatch(value = "^[1-3]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$", message = "承兑日期范围不正确！", profiles = {"5000"})
    private String issueDate;

    /**
     *到期日
     */
    @NotNull(message = "到期日是必输项!", profiles = {"5000"})
    @Length(min = 10, max = 10, message = "到期日长度为10位，格式为YYYY-MM-DD！", profiles = {"5000"})
    @RegexMatch(value = "^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$", message = "到期日范围不正确！", profiles = {"5000"})
    private String dueDate;

    /**
     *付款行行号
     */
    @NotNull(message = "付款行行号是必输项!", profiles = {"5205"})
    @NotBlank(message = "付款行行号是必输项!", profiles = {"5205"})
    @MaxLength(value = 64, message = "付款行行号允许的最大长度为64!", profiles = {"5000"})
    private String draweeNo;

    /**
     *付款行全称
     */
    @NotNull(message = "付款行全称是必输项!", profiles = {"5206","5205"})
    @NotBlank(message = "付款行全称是必输项!", profiles = {"5206","5205"})
    @MaxLength(value = 100, message = "付款行全称允许的最大长度为100!", profiles = {"5000"})
    private String draweeName;

    /**
     *付款行地址
     */
    @MaxLength(value = 100, message = "付款行地址允许的最大长度为100!", profiles = {"5000"})
    private String draweeAddress;

    /**
     *出票人证件类型
     */
    @MaxLength(value = 2, message = "出票人证件类型允许的最大长度为2!", profiles = {"5000"})
    private String drawerIdType;

    /**
     *出票人证件号码
     */
    @MaxLength(value = 20, message = "出票人证件号码允许的最大长度为20!", profiles = {"5000"})
    private String drawerIdNo;

    /**
     *出票人客户号
     */
    @MaxLength(value = 11, message = "出票人客户号允许的最大长度为11!", profiles = {"5000"})
    private String drawerCusId;

    /**
     *出票人姓名
     */
    @NotNull(message = "出票人姓名是必输项!", profiles = {"5206","5205"})
    @NotBlank(message = "出票人姓名是必输项!", profiles = {"5206","5205"})
    @MaxLength(value = 100, message = "出票人姓名允许的最大长度为100!", profiles = {"5000"})
    private String drawerName;

    /**
     *出票人账号
     */
    @NotNull(message = "出票人账号是必输项!", profiles = {"5206","5205"})
    @NotBlank(message = "出票人账号是必输项!", profiles = {"5206","5205"})
    @MaxLength(value = 64, message = "出票人账号允许的最大长度为64!", profiles = {"5000"})
    private String drawerAccount;

    /**
     *收款（出质）银行号
     */
    @NotNull(message = "收款（出质）银行号是必输项!", profiles = {"5204"})
    @NotBlank(message = "收款（出质）银行号是必输项!", profiles = {"5204"})
    @MaxLength(value = 64, message = "收款（出质）银行号允许的最大长度为64!", profiles = {"5000"})
    private String payeeBankNo;

    /**
     *收款（出质）银行名
     */
    @NotNull(message = "收款（出质）银行名是必输项!", profiles = {"5000"})
    @NotBlank(message = "收款（出质）银行名是必输项!", profiles = {"5000"})
    @MaxLength(value = 100, message = "收款（出质）银行名允许的最大长度为100!", profiles = {"5000"})
    private String payeeBankName;

    /**
     *收款行地址
     */
    @MaxLength(value = 1024, message = "收款行地址允许的最大长度为1024!", profiles = {"5000"})
    private String payeeBankAddress;

    /**
     *收票人证件类型
     */
    @MaxLength(value = 2, message = "收票人证件类型允许的最大长度为2!", profiles = {"5000"})
    private String payeeIdType;

    /**
     *收票人证件号码
     */
    @MaxLength(value = 20, message = "收票人证件号码允许的最大长度为20!", profiles = {"5000"})
    private String payeeIdNo;

    /**
     *收票人客户号
     */
    @MaxLength(value = 11, message = "收票人客户号允许的最大长度为11!", profiles = {"5000"})
    private String payeeCusId;

    /**
     *收票（出质）人姓名
     */
    @NotNull(message = "收票（出质）人姓名是必输项!", profiles = {"5000"})
    @NotBlank(message = "收票（出质）人姓名是必输项!", profiles = {"5000"})
    @MaxLength(value = 100, message = "收票（出质）人姓名允许的最大长度为100!", profiles = {"5000"})
    private String payeeName;

    /**
     *收票人账号
     */
    @NotNull(message = "收票人账号是必输项!", profiles = {"5206","5205"})
    @NotBlank(message = "收票人账号是必输项!", profiles = {"5206","5205"})
    @MaxLength(value = 64, message = "收票人账号允许的最大长度为64!", profiles = {"5000"})
    private String payeeAccount;

    /**
     *业务模式
     */
    @NotNull(message = "业务模式是必输项!", profiles = {"5000"})
    @NotBlank(message = "业务模式是必输项!", profiles = {"5000"})
    @MaxLength(value = 1, message = "业务模式允许的最大长度为1!", profiles = {"5000"})
    private String tradeType;

    /**
     *申请日期
     */
    @NotNull(message = "申请日期是必输项!", profiles = {"5205","5204"})
    @Length(min = 10, max = 10, message = "申请日期长度为10位，格式为YYYY-MM-DD！", profiles = {"5205","5204"})
    @RegexMatch(value = "^[1-3]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$", message = "申请日期范围不正确！", profiles = {"5000"})
    private String appDate;

    /**
     *出质人账号
     */
    @NotNull(message = "出质人账号是必输项!", profiles = {"5204"})
    @NotBlank(message = "出质人账号是必输项!", profiles = {"5204"})
    @MaxLength(value = 64, message = "出质人账号允许的最大长度为64!", profiles = {"5000"})
    private String payeeAccounts;
}