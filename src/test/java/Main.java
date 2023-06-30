import com.et.toolset.tools.deamon.RunMethod;
import com.et.toolset.tools.logger.Logger;
import com.et.toolset.tools.logger.LoggerNotDeclaredException;
import com.et.toolset.tools.preloader.PreloaderFinder;
import com.et.toolset.tools.preloader.UsePreloader;

import static com.et.toolset.tools.deamon.Deamon.runDeamon;

@UsePreloader(loggerLevel=Logger.Levels.SEVERE,loggerFileOutput="",deamonRunMethod = RunMethod.CONSOLE)
public class Main {
    public static void main(String[] args) {
        while(true){
            for(String arg : args){
                try {
                    Logger.getDeclaredLogger().info("hi");
                } catch (LoggerNotDeclaredException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
