package com.et.toolset.tools.preloader;

import com.et.toolset.tools.deamon.Deamon;
import com.et.toolset.tools.deamon.RunMethod;
import com.et.toolset.tools.logger.Logger;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface UsePreloader {
    Logger.Levels loggerLevel() default Logger.Levels.INFO;
    String loggerFileOutput() default "";
    RunMethod deamonRunMethod() default RunMethod.CONSOLE;



}
