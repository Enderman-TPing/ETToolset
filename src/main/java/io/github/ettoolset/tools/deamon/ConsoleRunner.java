package io.github.ettoolset.tools.deamon;

import io.github.ettoolset.tools.logger.Logger;

import java.lang.management.ManagementFactory;


public class ConsoleRunner implements Runnable{
    @Override
    public void run(){
        try{
            Logger logger=Logger.getDeclaredLogger();
            while (true){
                Runtime runtime=Runtime.getRuntime();
                String heap= ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().toString();
                String nonHeap=ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage().toString();
                int tc=ManagementFactory.getThreadMXBean().getThreadCount();
                int deamonTC=ManagementFactory.getThreadMXBean().getDaemonThreadCount();
                String sArch=ManagementFactory.getOperatingSystemMXBean().getArch();
                String sVersion=ManagementFactory.getOperatingSystemMXBean().getVersion();
                String sName=ManagementFactory.getOperatingSystemMXBean().getName();
                long total=runtime.totalMemory();
                long max=runtime.maxMemory();
                long free=runtime.freeMemory();
                long used=max-free;
                String str1="System Arch: "+sArch+"\n";
                String str2="System Version: "+sVersion+"\n";
                String str3="System Name:"+sName+"\n";
                String str4 = "Total Memory: " + total+"\n";
                String str5="Max Memory: " + max+"\n";
                String str6="Free Memory: " + free+"\n";
                String str7="Used Memory: " + used+"\n";
                String str8="Heap Space: " +heap+"\n";
                String str9="Non Heap Space: "+nonHeap+"\n";
                String str10="Thread Count: "+tc+"\n";
                String str11="Deamon Thread Count: "+deamonTC+"\n";
                logger.info(str1+str2+str3+str4+str5+str6+str7+str8+str9+str10+str11);
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }catch (Exception exception){
            while (true){
                Runtime runtime=Runtime.getRuntime();
                String heap= ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().toString();
                String nonHeap=ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage().toString();
                int tc=ManagementFactory.getThreadMXBean().getThreadCount();
                int deamonTC=ManagementFactory.getThreadMXBean().getDaemonThreadCount();
                String sArch=ManagementFactory.getOperatingSystemMXBean().getArch();
                String sVersion=ManagementFactory.getOperatingSystemMXBean().getVersion();
                String sName=ManagementFactory.getOperatingSystemMXBean().getName();
                long total=runtime.totalMemory();
                long max=runtime.maxMemory();
                long free=runtime.freeMemory();
                long used=max-free;
                String str1="System Arch: "+sArch+"\n";
                String str2="System Version: "+sVersion+"\n";
                String str3="System Name:"+sName+"\n";
                String str4 = "Total Memory: " + total+"\n";
                String str5="Max Memory: " + max+"\n";
                String str6="Free Memory: " + free+"\n";
                String str7="Used Memory: " + used+"\n";
                String str8="Heap Space: " +heap+"\n";
                String str9="Non Heap Space: "+nonHeap+"\n";
                String str10="Thread Count: "+tc+"\n";
                String str11="Deamon Thread Count: "+deamonTC+"\n";
                System.out.println(str1+str2+str3+str4+str5+str6+str7+str8+str9+str10+str11);
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }



    }
}
