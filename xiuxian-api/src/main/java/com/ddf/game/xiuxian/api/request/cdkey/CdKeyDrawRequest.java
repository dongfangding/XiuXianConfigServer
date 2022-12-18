package com.ddf.game.xiuxian.api.request.cdkey;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>cd key 兑换请求</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/18 15:59
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CdKeyDrawRequest implements Serializable {

    private static final long serialVersionUID = 1516322558409231083L;

    /**
     * 兑换码
     */
    @NotBlank(message = "兑换码不能为空")
    private String cdKey;
}
