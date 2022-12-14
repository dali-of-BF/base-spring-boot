package com.fang.controller;

import com.fang.common.utils.ResultUtil;
import com.fang.constants.ApiPathConstants;
import com.fang.service.userAgent.UserAgentService;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author FPH
 * @since 2022年11月18日11:39:50
 */
@RestController
@Slf4j
@RequestMapping(ApiPathConstants.USER_AGENT)
@RequiredArgsConstructor
@Api(tags = "浏览器解析")
public class UserAgentController {

    private final UserAgentService userAgentService;

    @GetMapping("/get-agent")
    @ApiOperation("获取用户Agent")
    public ResponseEntity<String> getAgent(HttpServletRequest request){
        return ResultUtil.success(userAgentService.getAgent(request));
    }

    @GetMapping("/get-browser")
    @ApiOperation("获取浏览器对象")
    public ResponseEntity<Browser> getBrowserDetail(HttpServletRequest request){
        return ResultUtil.success(userAgentService.getBrowserDetail(request));
    }

    @GetMapping("/get-operation-system")
    @ApiOperation("获取操作系统对象")
    public ResponseEntity<OperatingSystem> getOperationSystem(HttpServletRequest request){
        return ResultUtil.success(userAgentService.getOperationSystem(request));
    }
}
