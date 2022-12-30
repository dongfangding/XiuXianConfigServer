package com.ddf.game.xiuxian.core.repository;

import com.ddf.game.xiuxian.api.consts.RedisKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>统计仓储</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/30 13:45
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
public class StatisticsRepository {

    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 增加广告点击次数
     *
     * @param imei
     * @return
     */
    public Long increaseAdClickTimes(String imei) {
        if (StringUtils.isBlank(imei)) {
            return 0L;
        }
        return stringRedisTemplate.opsForHash().increment(RedisKey.AD_CLICK_TIMES, imei, 1);
    }
}
