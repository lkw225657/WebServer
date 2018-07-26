package net.transino.lms.modules.ext.ws.server.notify;

import jodd.vtor.constraint.MaxLength;
import jodd.vtor.constraint.NotBlank;
import jodd.vtor.constraint.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author lee
 * @since 5.0
 */
@Getter
@Setter
@ToString
public class ElecBillStatus {
    /**
     *交易流水号
     */
    @NotNull(message = "交易流水号是必输项!")
    @NotBlank(message = "交易流水号是必输项!")
    @MaxLength(value = 32, message = "交易流水号允许的最大长度为32!")
    private String elecBatchId;

    /**
     *电票票据id
     */
    @NotNull(message = "电票票据id是必输项!")
    @NotBlank(message = "电票票据id是必输项!")
    @MaxLength(value = 64, message = "电票票据id允许的最大长度为64!")
    private String elecId;

    /**
     *票据号
     */
    @NotNull(message = "票据号是必输项!")
    @NotBlank(message = "票据号是必输项!")
    @MaxLength(value = 64, message = "票据号允许的最大长度为64!")
    private String accepNo;

    /**
     *业务模式
     */
    @NotNull(message = "业务模式是必输项!")
    @NotBlank(message = "业务模式是必输项!")
    @MaxLength(value = 1, message = "业务模式允许的最大长度为1!")
    private String tradeType;

    /**
     *状态
     */
    @NotNull(message = "状态是必输项!")
    @NotBlank(message = "状态是必输项!")
    @MaxLength(value = 1, message = "状态允许的最大长度为1!")
    private String elecStatus;
}