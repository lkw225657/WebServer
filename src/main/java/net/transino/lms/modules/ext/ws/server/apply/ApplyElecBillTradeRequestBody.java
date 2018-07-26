package net.transino.lms.modules.ext.ws.server.apply;

import jodd.vtor.constraint.Length;
import jodd.vtor.constraint.MaxLength;
import jodd.vtor.constraint.NotBlank;
import jodd.vtor.constraint.NotNull;
import lombok.Getter;
import lombok.Setter;
import net.transino.lms.modules.ext.ws.DefaultWsBody;
import net.transino.lms.modules.ext.ws.server.constraint.RegexMatch;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 * @since 5.0
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class ApplyElecBillTradeRequestBody extends DefaultWsBody<ElecBillTrade> {
    ApplyElecBillTradeRequestBody() {
        this.rows = new ArrayList<>();
    }

    @XmlElementWrapper(name = "DETAIL")
    @XmlElement(name = "ROW")
    protected List<ElecBillTrade> rows;
    /**
     * 交易流水号
     */
    @NotNull(message = "交易流水号是必输项!", profiles = {"5000"})
    @NotBlank(message = "交易流水号是必输项!", profiles = {"5000"})
    @MaxLength(value = 32, message = "交易流水号允许的最大长度为32!", profiles = {"5000"})
    private String elecBatchId;
    /**
     * 交易申请日期
     */
    @NotNull(message = "交易申请日期是必输项!", profiles = {"5000"})
    @Length(min = 10, max = 10, message = "交易申请日期长度为10位，格式为YYYY-MM-DD！", profiles = {"5000"})
    @RegexMatch(value = "^[1-3]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$", message = "交易申请日期范围不正确！", profiles = {"5000"})
    private String appDate;

    /**
     * 票据总张数
     */
    @NotNull(message = "票据总张数是必输项!", profiles = {"5206","5205"})
    @RegexMatch(value = "^\\d{1,3}$", message = "票据总张数范围不正确！", profiles = {"5000"})
    private Integer elecCount;

    /**
     * 票据总金额
     */
    @NotNull(message = "票据总金额是必输项!", profiles = {"5206","5205"})
    @RegexMatch(value = "^(\\d{1,15}\\.\\d{1,2})|((-)?\\d{1,15}\\.\\d{1,2})$", message = "票据总金额范围不正确！", profiles = {"5000"})
    private Double elecSum;

    /**
     * 贴现率
     */
    @NotNull(message = "贴现率是必输项!", profiles = {"5206"})
    @RegexMatch(value = "^\\d{1,8}\\.\\d{1,5}$", message = "贴现率范围不正确！", profiles = {"5000"})
    private Double discIr;

    /**
     * 贴现到期日期
     */
    @NotNull(message = "贴现到期日期是必输项!", profiles = {"5206"})
    @Length(min = 10, max = 10, message = "贴现到期日期长度为10位，格式为YYYY-MM-DD！", profiles = {"5206"})
    @RegexMatch(value = "^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$", message = "贴现到期日期范围不正确！", profiles = {"5000"})
    private String dueDate = "9999-12-31";

    /**
     * 在途天数
     */
    @RegexMatch(value = "^\\d{1,5}$", message = "在途天数范围不正确！", profiles = {"5000"})
    private int inWayDays = 0;
}