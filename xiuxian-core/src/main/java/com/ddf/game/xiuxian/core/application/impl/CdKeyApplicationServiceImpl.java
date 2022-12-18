package com.ddf.game.xiuxian.core.application.impl;

import com.ddf.boot.common.api.exception.BusinessException;
import com.ddf.boot.common.api.util.DateUtils;
import com.ddf.boot.common.core.util.PreconditionUtil;
import com.ddf.game.xiuxian.api.enume.CdKeyEnum;
import com.ddf.game.xiuxian.api.enume.XiuXianExceptionCode;
import com.ddf.game.xiuxian.api.response.cdkey.CdKeyCheckResponse;
import com.ddf.game.xiuxian.core.application.CdKeyApplicationService;
import com.ddf.game.xiuxian.core.entity.CdKeyConfig;
import com.ddf.game.xiuxian.core.entity.CdKeyHistory;
import com.ddf.game.xiuxian.core.repository.CdKeyRepository;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>cd key应用层</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/18 15:24
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class CdKeyApplicationServiceImpl implements CdKeyApplicationService {

    private final CdKeyRepository cdKeyRepository;

    @Override
    public CdKeyCheckResponse check(Long playerId, String cdKey) {
        final CdKeyConfig cdKeyConfig = cdKeyRepository.getByCdKey(cdKey);
        PreconditionUtil.checkArgument(Objects.nonNull(cdKeyConfig), XiuXianExceptionCode.CD_KEY_ERROR);

        final Long currentTimeSeconds = DateUtils.currentTimeSeconds();
        if (Objects.equals(CdKeyEnum.DURING_EVERYONE.name(), cdKeyConfig.getCdKeyType())) {
            if (currentTimeSeconds > cdKeyConfig.getExpiredTime()) {
                throw new BusinessException(XiuXianExceptionCode.CD_KEY_EXPIRED);
            }
        } else if (Objects.equals(CdKeyEnum.FOREVER_ONCE.name(), cdKeyConfig.getCdKeyType())) {
            if (!cdKeyRepository.usedOnceCdKey(cdKey)) {
                throw new BusinessException(XiuXianExceptionCode.CD_KEY_USED);
            }
        }
        try {
            final CdKeyHistory history = new CdKeyHistory();
            history.setPlayerId(playerId);
            history.setCdKey(cdKey);
            history.setCdKeyType(cdKeyConfig.getCdKeyType());
            history.setCtime(currentTimeSeconds);
            cdKeyRepository.insertCdKeyHistory(history);
        } catch (Exception e) {
            throw new BusinessException(XiuXianExceptionCode.CD_KEY_REPEAT_DRAW);
        }
        return CdKeyCheckResponse.builder()
                .cdKey(cdKey)
                .cdKeyType(cdKeyConfig.getCdKeyType())
                .cdKeyValue(cdKeyConfig.getCdKeyValue())
                .expiredTime(cdKeyConfig.getExpiredTime())
                .build();
    }
}
