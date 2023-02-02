package com.ddf.game.xiuxian.core.config;

import com.ddf.boot.common.api.exception.BusinessException;
import com.ddf.boot.common.authentication.interfaces.UserClaimService;
import com.ddf.boot.common.authentication.model.UserClaim;
import com.ddf.boot.common.core.util.WebUtil;
import com.ddf.game.xiuxian.api.enume.PlayerStatusEnum;
import com.ddf.game.xiuxian.api.enume.XiuXianExceptionCode;
import com.ddf.game.xiuxian.core.entity.PlayerInfo;
import com.ddf.game.xiuxian.core.repository.PlayerRepository;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>认证模块用户认证接口</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/05/26 23:06
 */
@Service
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class UserClaimServiceImpl implements UserClaimService {

    private final PlayerRepository playerRepository;

    @Override
    public void storeRequest(HttpServletRequest request, String host) {

    }

    @Override
    public UserClaim getStoreUserInfo(UserClaim userClaim) {
        final PlayerInfo playerInfo = playerRepository.getById(Long.parseLong(userClaim.getUserId()));
        if (Objects.isNull(playerInfo)) {
            throw new BusinessException(XiuXianExceptionCode.ACCOUNT_NOT_EXISTS);
        }
        if (Objects.equals(PlayerStatusEnum.BLACK.name(), playerInfo.getStatus())) {
            throw new BusinessException(XiuXianExceptionCode.ACCOUNT_IN_BLACK);
        }
        userClaim.setUserId(playerInfo.getId().toString());
        userClaim.setUsername(playerInfo.getNickname());
        userClaim.setCredit(WebUtil.getUserAgent());
        return userClaim;
    }
}
