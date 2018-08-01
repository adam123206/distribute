
package com.adam.map.test.myThreadPool.lifeCycle;

@FunctionalInterface
public interface Task<T>{

	T call();
}
