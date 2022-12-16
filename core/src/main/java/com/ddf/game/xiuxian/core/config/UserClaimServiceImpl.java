package com.ddf.game.xiuxian.core.config;

import com.ddf.boot.common.authentication.interfaces.UserClaimService;
import com.ddf.boot.common.authentication.model.UserClaim;
import com.ddf.boot.common.core.util.WebUtil;
import com.ddf.game.xiuxian.core.entity.PlayerInfo;
import com.ddf.game.xiuxian.core.repository.PlayerRepository;
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
        userClaim.setUserId(playerInfo.getId().toString());
        userClaim.setUsername(playerInfo.getNickname());
        userClaim.setCredit(WebUtil.getUserAgent());
        return userClaim;
    }
}
