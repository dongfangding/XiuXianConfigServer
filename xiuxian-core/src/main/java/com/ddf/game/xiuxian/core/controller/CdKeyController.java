package com.ddf.game.xiuxian.core.controller;

import com.ddf.boot.common.api.model.common.response.response.ResponseData;
import com.ddf.boot.common.authentication.util.UserContextUtil;
import com.ddf.game.xiuxian.api.request.cdkey.CdKeyDrawRequest;
import com.ddf.game.xiuxian.api.response.cdkey.CdKeyCheckResponse;
import com.ddf.game.xiuxian.core.application.CdKeyApplicationService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>cd key控制器</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/18 15:57
 */
@RestController
@RequestMapping("/cdKey")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class CdKeyController {

    private final CdKeyApplicationService cdKeyApplicationService;

    /**
     * 兑换cd key
     *
     * @param request
     * @return
     */
    @PostMapping("draw")
    public ResponseData<CdKeyCheckResponse> draw(@RequestBody @Valid CdKeyDrawRequest request) {
        return ResponseData.success(cdKeyApplicationService.check(UserContextUtil.getLongUserId(),
                request.getCdKey()));
    }
}
