package net.lab1024.smartadmin.redis;

/**
 * @Description TODO
 * @Author LZN
 * @Date 2020/9/2114:51
 **/
public interface RedisService {
    void set(String key,String value);
    /**
     * 获取数据
     */
    String get(String key);
    /**
     * 设置超期时间
     */
    boolean expire(String key, long expire);
    /**
     * 删除数据
     */
    void remove(String key);
    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);

}
