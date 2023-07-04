package io.github.ettoolset.tools.SimpleTCP;

import java.io.*;
import java.net.Socket;

@SuppressWarnings("unused")
/**This class is not actually safe to be used cuz it is not tested. I do not have a server (shrug)
 * @author Enderman-Teleporting
 */
public class Client {
    private Socket socket;

    /**
     * Constructor for creating a Client instance
     * @author Enderman-Teleporting
     * @param ip (String)->The IP address of the instance
     * @param port (int)->The port of the instance
     * @throws IOException
     */
    public Client(String ip,int port) throws IOException {
        socket=new Socket(ip,port);
    }

    /**
     * Get the current IP address of the instance
     * @author Enderman-Teleporting
     * @return The IP address of the instance
     */
    public String getIP(){
        return socket.getInetAddress().getHostAddress();
    }

    /**
     * Get the current port of the instance
     * @author Enderman-Teleporting
     * @return The port of the instance
     */
    public int getPort(){
        return socket.getPort();
    }


    @Override
    public String toString(){
        return "IP:"+getIP()+"\tPort:"+getPort();
    }

    /**
     * Send a specific message to the server
     * @author Enderman-Teleporting
     * @param msg (String) -> The message to send
     * @throws IOException -> Thrown if an I/O error occurs
     */
    public void send(String msg) throws IOException {
        PrintWriter out=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        out.println(msg);
    }

    /**
     * Read a whole line of message from the server
     * @author Enderman-Teleporting
     * @return A String read from server
     * @throws IOException -> Thrown if an I/O error occurs
     */
    public String getLine() throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return in.readLine();
    }

    /**
     * Read all bytes from the server
     * @author Enderman-Teleporting
     * @return A byte array of bytes read from server
     * @throws IOException -> Thrown if an I/O error occurs
     */
    public byte[] getAll() throws IOException {
        InputStream in=socket.getInputStream();
        return in.readAllBytes();

    }

    /**
     * Read all bytes from the server and transform them into String
     * @author Enderman-Teleporting
     * @return A transformed String
     * @throws IOException -> Thrown if an I/O error occurs
     */
    public String getAllAsString() throws IOException {
        byte[] bytes=getAll();
        return new String(bytes);
    }

    /**
     * Send a file to the server
     * @author Enderman-Teleporting
     * @param file (File) -> A File that you want to send
     * @throws IOException -> Thrown if an I/O error occurs
     */
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

    /**
     * Read a whole file from the server
     * @author Enderman-Teleporting
     * @param dest (String) -> The path where you want to store the file
     * @return The stored file
     * @throws IOException -> Thrown if an I/O error occurs
     */
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
