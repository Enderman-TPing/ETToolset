package com.github.ettoolset.tools.deamon;

/**
 * A class to start a deamon thread for main
 * @author Enderman-Teleporting
 */
public class Deamon {
    /**
     * This is the function where you can start the deamon process
     * @author Enderman-Teleporting
     * @param rm (RunMethod)-> The run method of the daemon thread. Choice offered: RunMethod.GUI, RunMethod.CONSOLE
     */
    public static void runDeamon(RunMethod rm){
        Thread deamon;
        switch (rm) {
            case GUI -> {
                GUIRunner gr = new GUIRunner();
                deamon = new Thread(gr);
                deamon.setDaemon(true);
                deamon.start();
            }
            case CONSOLE -> {
                ConsoleRunner cr = new ConsoleRunner();
                deamon = new Thread(cr);
                deamon.setDaemon(true);
                deamon.start();
            }
        }
    }
}
