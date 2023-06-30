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
    public byte[] getAll() throws IOException {
        InputStream in=socket.getInputStream();
        return in.readAllBytes();

    }

    public String getAllAsString() throws IOException {
        byte[] bytes=getAll();
        return new String(bytes);
    }
    public void sendFile(File file) throws IOException {
        InputStream in =new FileInputStream(file);
        byte[] data=new byte[(int)file.length()];
        in.read(data);
        OutputStream out=socket.getOutputStream();
        out.write(data);
        out.flush();
        in.close();
        out.close();


    }
    public File getFile(String dest) throws IOException {
        File file=new File(dest);
        InputStream in=socket.getInputStream();
        byte[] buffer=in.readAllBytes();
        FileOutputStream data=new FileOutputStream(file);
        data.write(buffer);
        data.flush();
        in.close();
        data.close();

        return file;
    }

}
