import com.et.toolset.tools.deamon.Deamon;
import com.et.toolset.tools.deamon.RunMethod;
import com.et.toolset.tools.logger.LevelNotMatchException;
import com.et.toolset.tools.logger.Logger;
import com.et.toolset.tools.logger.RepeatedLoggerDeclarationException;

public class Test {
    public static void main(String []args) throws RepeatedLoggerDeclarationException, LevelNotMatchException, InterruptedException {
        Logger logger=new Logger(Logger.Levels.DEBUG,null);
        Deamon.runDeamon(RunMethod.CONSOLE);
        Deamon.runDeamon(RunMethod.GUI);
        while (true){
            logger.debug("%s","Hello World");
            Thread.sleep(10000);
        }
    }
}
