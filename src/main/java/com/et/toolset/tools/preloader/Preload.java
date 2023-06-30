package com.et.toolset.tools.preloader;

import com.et.toolset.tools.deamon.Deamon;
import com.et.toolset.tools.deamon.RunMethod;
import com.et.toolset.tools.logger.Logger;
import com.et.toolset.tools.logger.RepeatedLoggerDeclarationException;

import java.lang.reflect.InvocationTargetException;

import static com.et.toolset.tools.preloader.PreloaderFinder._class;

public class Preload {
    protected static void preload(Logger.Levels level,String fileOutput, RunMethod runMethod) {
        if(level==null){
            Deamon.runDeamon(runMethod);
        }else if(runMethod==null){
            try {
                Logger logger=new Logger(level,fileOutput);
            } catch (RepeatedLoggerDeclarationException e) {
                throw new RuntimeException(e);
            }
        }else{
            try {
                Logger logger=new Logger(level,fileOutput);
            } catch (RepeatedLoggerDeclarationException e) {
                throw new RuntimeException(e);
            }
            Deamon.runDeamon(runMethod);
        }


    }
}
