package com.baselibrary.jetpack.livedata;

import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

/**
 *1、定义单例类
 *2、定义HashMap：key是事件名称，value是LiveData。
 *3、订阅事件：通过key从HashMap中获取到LiveData，然后调用LiveData的Observe方法订阅事件
 *4、发布事件：通过key从HashMap中获取到LiveData，然后调用LiveData的setValue活postValue方法发布事件；
 */
public final class LiveDataBus2 {

    private final Map<String, MutableLiveData<Object>> bus;

    private LiveDataBus2() {
        bus = new HashMap<>();
    }

    private static class SingletonHolder {
        private static final LiveDataBus2 DATA_BUS = new LiveDataBus2();
    }

    public static LiveDataBus2 get() {
        return SingletonHolder.DATA_BUS;
    }

    public <T> MutableLiveData<T> getChannel(String target, Class<T> type) {
        if (!bus.containsKey(target)) {
            bus.put(target, new MutableLiveData<>());
        }
        return (MutableLiveData<T>) bus.get(target);
    }

    public MutableLiveData<Object> getChannel(String target) {
        return getChannel(target, Object.class);
    }
}