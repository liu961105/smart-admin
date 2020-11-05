package net.lab1024.smartadmin.system.impl;

import net.lab1024.smartadmin.common.CommonResult.CommonResult;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.redis.RedisService;
import net.lab1024.smartadmin.system.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Random;

/**
 * @Description TODO
 * @Authou LZN
 * @Date 2020/7/13 10:54
 **/
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public ResponseDTO generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return ResponseDTO.succData(sb.toString());

    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success("chengg");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }

    @Override
    public Map<Integer, Integer> createMap(String className) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName(className);
        Constructor constructor = clazz.getConstructor();
        return (Map<Integer, Integer>) constructor.newInstance();
    }
}
