package com.ddf.game.xiuxian.core.application;

import com.ddf.game.xiuxian.api.response.cdkey.CdKeyCheckResponse;

/**
 * <p>cd key应用层</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/18 15:16
 */
public interface CdKeyApplicationService {

    /**
     * 校验cd key
     *
     * @param playerId
     * @param cdKey
     * @return
     */
    CdKeyCheckResponse check(Long playerId, String cdKey);
}
