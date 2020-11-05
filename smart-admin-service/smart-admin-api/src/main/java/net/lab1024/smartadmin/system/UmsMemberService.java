package net.lab1024.smartadmin.system;

import net.lab1024.smartadmin.common.CommonResult.CommonResult;
import net.lab1024.smartadmin.common.domain.ResponseDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Description TODO
 * @Author LZN
 * @Date 2020/9/2114:32
 **/
public interface UmsMemberService {
    /**
     * 生成验证码
     */
    ResponseDTO generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);

    Map<Integer,Integer> createMap(String className) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
