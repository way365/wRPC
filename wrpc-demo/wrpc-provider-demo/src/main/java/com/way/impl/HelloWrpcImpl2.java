package com.way.impl;


import com.way.HelloWrpc2;

public class HelloWrpcImpl2 implements HelloWrpc2 {
    @Override
    public String sayHi(String msg) {
        return "hi consumer:" + msg;
    }
}
