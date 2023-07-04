package com.github.ettoolset.tools.SimpleTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
@SuppressWarnings("unused")
/**This class is not actually safe to be used cuz it is not tested. I do not have a server (shrug)
 * @author Enderman-Teleporting
 */
public class Server {
    private ServerSocket ss;
    private Socket socket;

    /**
     * Constructor for creating a Server instance
     * @author Enderman-Teleporting
     * @param portOpening (int) -> The port number
     * @throws IOException -> Thrown if an I/O error occurs
     */
    public Server(int portOpening) throws IOException {
        ss=new ServerSocket(portOpening);
        socket=ss.accept();
    }
    /**
     * Read a whole line of message from the client
     * @author Enderman-Teleporting
     * @return A String read from client
     * @throws IOException -> Thrown if an I/O error occurs
     */
    public String getLine() throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return bf.readLine();
    }

    /**
     * Send a specific message to the client
     * @author Enderman-Teleporting
     * @param msg (String) -> The message to send
     * @throws IOException -> Thrown if an I/O error occurs
     */
    public void send(String msg) throws IOException {
        PrintWriter out=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        out.println(msg);
    }

    /**
     * Read all bytes from the client
     * @author Enderman-Teleporting
     * @return A byte array of bytes read from client
     * @throws IOException -> Thrown if an I/O error occurs
     */
    public byte[] getAll() throws IOException {
        InputStream in=socket.getInputStream();
        return in.readAllBytes();

    }
    /**
     * Read all bytes from the client and transform them into String
     * @author Enderman-Teleporting
     * @return A transformed String
     * @throws IOException -> Thrown if an I/O error occurs
     */
    public String getAllAsString() throws IOException {
        byte[] bytes=getAll();
        return new String(bytes);
    }

    /**
     * Send a file to the client
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
     * Read a whole file from the client
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
    @Override
    public String toString(){
        return "Port:"+ socket.getLocalPort();
    }

}
