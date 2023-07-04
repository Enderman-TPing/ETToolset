package io.github.ettoolset.tools.deamon;

import javax.swing.*;
import java.awt.*;
import java.lang.management.ManagementFactory;

public class GUIRunner implements Runnable{

    @Override
    public void run() {
        JFrame frame=new JFrame();
        frame.setResizable(false);
        frame.setLayout(new GridLayout(11,1));
        frame.setSize(780,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel jp1=new JPanel();
        JLabel label1=new JLabel();
        jp1.add(label1);
        frame.add(jp1);
        JPanel jp2=new JPanel();
        JLabel label2=new JLabel();
        jp2.add(label2);
        frame.add(jp2);
        JPanel jp3=new JPanel();
        JLabel label3=new JLabel();
        jp3.add(label3);
        frame.add(jp3);
        JLabel label4=new JLabel();
        JPanel jp4=new JPanel();
        jp4.add(label4);
        frame.add(jp4);
        JLabel label5=new JLabel();
        JPanel jp5=new JPanel();
        jp5.add(label5);
        frame.add(jp5);
        JPanel jp6=new JPanel();
        JLabel label6=new JLabel();
        jp6.add(label6);
        frame.add(jp6);
        JLabel label7=new JLabel();
        JPanel jp7=new JPanel();
        jp7.add(label7);
        frame.add(jp7);
        JPanel jp8=new JPanel();
        JLabel label8=new JLabel();
        jp8.add(label8);
        frame.add(jp8);
        JPanel jp9=new JPanel();
        JLabel label9=new JLabel();
        jp9.add(label9);
        frame.add(jp9);
        JPanel jp10=new JPanel();
        JLabel label10=new JLabel();
        jp10.add(label10);
        frame.add(jp10);
        JLabel label11=new JLabel();
        JPanel jp11=new JPanel();
        jp11.add(label11);
        frame.add(jp11);

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
            label1.setText(str1);
            label2.setText(str2);
            label3.setText(str3);
            label4.setText(str4);
            label5.setText(str5);
            label6.setText(str6);
            label7.setText(str7);
            label8.setText(str8);
            label9.setText(str9);
            label10.setText(str10);
            label11.setText(str11);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
