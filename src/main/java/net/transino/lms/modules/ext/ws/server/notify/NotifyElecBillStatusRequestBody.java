package net.transino.lms.modules.ext.ws.server.notify;

import jodd.vtor.constraint.Length;
import jodd.vtor.constraint.MaxLength;
import jodd.vtor.constraint.NotBlank;
import jodd.vtor.constraint.NotNull;
import lombok.Getter;
import lombok.Setter;
import net.transino.lms.modules.ext.ws.DefaultWsBody;
import net.transino.lms.modules.ext.ws.server.constraint.RegexMatch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 * @since 5.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class NotifyElecBillStatusRequestBody extends DefaultWsBody<ElecBillStatus> {
    NotifyElecBillStatusRequestBody() {
        this.rows = new ArrayList<>();
    }

    @XmlElementWrapper(name = "DETAIL")
    @XmlElement(name = "ROW")
    private List<ElecBillStatus> rows;

    /**
     * 交易流水号
     */
    @NotNull(message = "交易流水号是必输项!")
    @NotBlank(message = "交易流水号是必输项!")
    @MaxLength(value = 32, message = "交易流水号允许的最大长度为32!")
    private String elecBatchId;
    /**
     * 交易申请日期
     */
    @NotNull(message = "交易申请日期是必输项!")
    @NotBlank(message = "交易申请日期是必输项!")
    @Length(min = 10, max = 10, message = "交易申请日期长度为10位，格式为YYYY-MM-DD！")
    @RegexMatch(value = "^[1-3]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$", message = "交易申请日期范围不正确！")
    private String appDate;

    /**
     * 票据总张数
     */
    @NotNull(message = "票据总张数是必输项!")
    @RegexMatch(value = "^\\d{1,3}$", message = "票据总张数范围不正确！")
    private Integer elecCount;

    /**
     * 票据总金额
     */
    @NotNull(message = "票据总金额是必输项!")
    @RegexMatch(value = "^(\\d{1,15}\\.\\d{1,2})|((-)?\\d{1,15}\\.\\d{1,2})$", message = "票据总金额范围不正确！")
    private Double elecSum;
}