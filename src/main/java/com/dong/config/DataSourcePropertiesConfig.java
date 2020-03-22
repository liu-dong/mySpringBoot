package com.dong.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 数据源属性配置
 *
 * @author LD
 *
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DataSourcePropertiesConfig {
    //基本属性
    private String driverClassName;//驱动名称
    private String url;//数据库地址
    private String username;//用户名
    private String password;//密码
    //连接池属性
    private int initialSize;//初始化大小
    private int minIdle;//最小连接数
    private int maxActive = 100;//最大连接数
    private long maxWait;//获取连接等待超时
    private long timeBetweenEvictionRunsMillis;//间隔多久进行一次检测，检测需要关闭的空闲连接
    private long minEvictableIdleTimeMillis;//一个连接在池中最小生存的时间
    private String validationQuery;//
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    private String filters;//filter 配置监控统计拦截的过滤器，去掉后监控界面SQL无法进行统计，wall用于防火墙

}
