package com.way;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author way
 * @create 2024-12-16 19:51
 */

@Slf4j
public class WrpcBootstrap {

    // WrpcBootstrap是个单例，我们希望每个应用程序只有一个实例
    private static WrpcBootstrap wrpcBootstrap = new WrpcBootstrap();

    private WrpcBootstrap() {
        // 构造启动引导程序，时需要做一些什么初始化的事
    }

    public static WrpcBootstrap getInstance() {
        return wrpcBootstrap;
    }

    /**
     * 用来定义当前应用的名字
     * @param appName 应用的名字
     * @return this当前实例
     */
    public WrpcBootstrap application(String appName) {
        return this;
    }

    /**
     * 用来配置一个注册中心
     * @param registryConfig 注册中心
     * @return this当前实例
     */
    public WrpcBootstrap registry(RegistryConfig registryConfig) {
        return this;
    }

    /**
     * 配置当前暴露的服务使用的协议
     * @param protocolConfig 协议的封装
     * @return this当前实例
     */
    public WrpcBootstrap protocol(ProtocolConfig protocolConfig) {
        if(log.isDebugEnabled()){
            log.debug("当前工程使用了：{}协议进行序列化",protocolConfig.toString());
        }
        return this;
    }


    /**
     * ---------------------------服务提供方的相关api---------------------------------
     */

    /**
     * 发布服务，将接口-》实现，注册到服务中心
     * @param service 封装的需要发布的服务
     * @return this当前实例
     */
    public WrpcBootstrap publish(ServiceConfig<?> service) {
        if(log.isDebugEnabled()){
            log.debug("服务{}，已经被注册",service.getInterface().getName());
        }
        return this;
    }

    /**
     * 批量发布
     * @param services 封装的需要发布的服务集合
     * @return this当前实例
     */
    public WrpcBootstrap publish(List<?> services) {
        return this;
    }

    /**
     * 启动netty服务
     */
    public void start() {

    }


    /**
     * ---------------------------服务调用方的相关api---------------------------------
     */
    public WrpcBootstrap reference(ReferenceConfig<?> reference) {

        // 在这个方法里我们是否可以拿到相关的配置项-注册中心
        // 配置reference，将来调用get方法时，方便生成代理对象
        return this;

    }
}