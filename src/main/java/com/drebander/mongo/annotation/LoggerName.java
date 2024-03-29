package com.drebander.mongo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface LoggerName {
    String value();

    /**
     * 当日志正常返回的内容
     *
     * @return
     */
    String yes();

    /**
     * 日志异常返回的日志的内容
     *
     * @return
     */
    String no();
}
