package net.lab1024.smartadmin.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.system.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description TODO
 * @Author LZN
 * @Date 2020/9/21 15:17
 **/
@RestController
@RequestMapping("/ums")
@Api(tags = "UmsMemberController",description = "获取验证码")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    public ResponseDTO getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }
//    @RequestMapping(value = "/createMap",method = RequestMethod.GET)
//    public ResponseDTO createMap(String className){
//        Map<Integer,Integer> map = memberService.createMap(className);
//        return ResponseDTO.succData(map);
//    }

}
