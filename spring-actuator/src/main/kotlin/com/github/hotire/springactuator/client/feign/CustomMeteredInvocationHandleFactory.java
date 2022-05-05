package com.github.hotire.springactuator.client.feign;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import feign.InvocationHandlerFactory;
import feign.Target;

/**
 * @see  feign.Client
 * @see  feign.InvocationHandlerFactory
 * @see  feign.micrometer.MeteredInvocationHandleFactory
 */
public class CustomMeteredInvocationHandleFactory implements InvocationHandlerFactory {
    @Override
    public InvocationHandler create(Target target, Map<Method, MethodHandler> dispatch) {
        return null;
    }
}
