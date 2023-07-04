package io.github.ettoolset.tools.logger;

public class LoggerNotDeclaredException extends Exception {
    public LoggerNotDeclaredException(){}
    public LoggerNotDeclaredException(String message){
        super(message);
    }
    public LoggerNotDeclaredException(String message, Throwable cause){
        super(message,cause);
    }
    public LoggerNotDeclaredException(Throwable cause){
        super(cause);
    }
}
