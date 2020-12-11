package com.fanhehe.user.business.doll.wave.controller;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import com.fanhehe.user.business.user.pojo.model.User;
import com.fanhehe.user.common.result.IResult;
import com.fanhehe.user.business.doll.wave.pojo.cond.WaveCond;
import com.fanhehe.user.business.doll.wave.pojo.result.WaveResult;
import com.fanhehe.user.business.doll.wave.service.WaveService;
import com.fanhehe.user.common.user.IUser;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 14:46
 */
@RestController("/wave")
public class WaveController {

    @Autowired
    private WaveService waveService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private List<DataSource> dataSourceList;

    /**
     * 周期成成电波接口
     * @return 周期成成电波接口
     */
    @RequestMapping("makeElectricWaveCycle")
    public IResult<WaveResult> makeElectricWaveCycle(WaveCond cond) {
        return waveService.makeElectricWaveCycle(() -> 1L, cond);
    }

    @RequestMapping("test")
    public IResult<WaveResult> test(WaveCond cond) {

        int i = 0;

        dataSourceList.size();
        HintManager.getInstance().setMasterRouteOnly();

        return waveService.makeElectricWaveCycle(() -> null, cond);
    }
}
