package com.ddf.game.xiuxian.api.request.notice;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
* <p>通告修改请求类</p >
*
* @author Snowball
* @version 1.0
* @date 2022/12/17 23:04
*/
@Data
public class NoticeCommand implements Serializable {
    private Long id;

    /**
    * 标题
    */
    @NotBlank(message = "标题不能为空")
    @Size(max = 64, message = "标题长度超限")
    private String title;

    /**
    * 公告详细内容
    */
    @NotBlank(message = "公告详细内容为空")
    @Size(max = 64, message = "公告详细内容超限")
    private String content;

    /**
    * 是否有效
    */
    @NotNull(message = "是否有效")
    private Boolean activeFlag;

    /**
    * 生效时间
    */
    private Long effectiveTime;

}
