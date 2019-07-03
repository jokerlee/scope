package com.github.phantomthief.scope;

/**
 * @author lijie <lijie02@kuaishou.com>
 * Created on 2019-07-03
 */
interface ScopeThreadLocal<T> {

    T get();

    void set(T value);

}
