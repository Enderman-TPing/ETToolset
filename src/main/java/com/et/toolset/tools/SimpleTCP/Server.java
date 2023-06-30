package com.et.toolset.tools.SimpleTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
@SuppressWarnings("unused")
public class Server {
    private ServerSocket ss;
    private Socket socket;
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
    @Override
    public String toString(){
        return "Port:"+ socket.getLocalPort();
    }

}
