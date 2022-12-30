package com.ddf.game.xiuxian.core.controller;

import com.ddf.boot.common.authentication.util.UserContextUtil;
import com.ddf.game.xiuxian.core.repository.StatisticsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>统计控制器</p >
 *
 * @author Snowball
 * @version 1.0
 * @date 2022/12/30 13:49
 */
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
@RestController
@RequestMapping("statistics")
public class StatisticsController {

    private final StatisticsRepository statisticsRepository;

    /**
     * 广告点击
     */
    @PostMapping("adClick")
    public void adClick() {
        statisticsRepository.increaseAdClickTimes(UserContextUtil.getRequestHeader().getImei());
    }
}
