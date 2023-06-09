package com.et.toolset.tools.SimpleTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
@SuppressWarnings("unused")
public class Server {
    ServerSocket ss;
    Socket socket;
    public Server(int portOpening) throws IOException {
        ss=new ServerSocket(portOpening);
        socket=ss.accept();
    }
    public String getLine() throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return bf.readLine();
    }
    public void send(String msg) throws IOException {
        PrintWriter out=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        out.println(msg);
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
    @Override
    public String toString(){
        return "Port:"+ socket.getLocalPort();
    }

}
