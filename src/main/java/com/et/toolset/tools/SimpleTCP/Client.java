package com.et.toolset.tools.SimpleTCP;

import java.io.*;
import java.net.Socket;

@SuppressWarnings("unused")
public class Client {
    private Socket socket;

    public Client(String ip,int port) throws IOException {
        socket=new Socket(ip,port);
    }
    public String getIP(){
        return socket.getInetAddress().getHostAddress();
    }
    public int getPort(){
        return socket.getPort();
    }
    @Override
    public String toString(){
        return "IP:"+getIP()+"\tPort:"+getPort();
    }
    public void send(String msg) throws IOException {
        PrintWriter out=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        out.println(msg);
    }

    public String getLine() throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return in.readLine();
    }
    public String getAll() throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder k= new StringBuilder();
        for (int b=-1;(b=in.read())!=-1;){
            k.append(b);
        }
        return k.toString();

    }

    public void sendFile(File file) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(file));
        PrintWriter out=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        for(int b=-1;(b=br.read())!=-1;){
            out.write(b);
        }
        br.close();
    }
    public File getFile(String dest) throws IOException {
        File file=new File(dest);
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
        bw.write(getAll());
        bw.flush();
        bw.close();
        return file;
    }


}
