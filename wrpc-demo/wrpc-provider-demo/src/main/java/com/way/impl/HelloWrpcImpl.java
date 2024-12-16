package com.way.impl;


import com.way.HelloWrpc;

public class HelloWrpcImpl implements HelloWrpc {
    @Override
    public String sayHi(String msg) {
        return "hi consumer:" + msg;
    }
}
