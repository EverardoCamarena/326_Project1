/**
 * Armando Sanchez & Everardo Camarena
 * CECS 326 FALL 2023
 * This program connects the client to a server on port 6007 and it displays echos back 
 * to the client. 
 */
import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(6007); // starts server in port 6007
            System.out.println("Waiting..."); //prints waiting while it waits for the connection to be accepted(used to troubleshoot)

            while (true) { //infinite loop
                Socket client = sock.accept(); //accepts an incoming connection and names it client
                System.out.println("Connected"); //prints connected when it accepts the connects (used to troubleshoot)

                BufferedReader bf = new BufferedReader(new InputStreamReader(client.getInputStream())); //reads data from client
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true); //send data back to client 

                String str; //declaring a string "str" to use in the loop

                while ((str = bf.readLine()) != null) { // reads the data from client and stops while it is empty
                    System.out.println("Client: " + str); //prints the data from client and adds client in front of it
                    pout.println(str.replace("client", "server")); //replaces the word client with server and it gets send back to client

                    if (str.equalsIgnoreCase("END")) { //condition to see if the data read is equal to END, if it is then it runs whatever is inside
                        client.close(); // Closes the client socket when "END" is received
                         sock.close();// closes the socket when "END" is received
                    }
                }
            }
        } catch (IOException ioe) { //throws an IOException if it detects that it is not connecting
            System.err.println(ioe);
        }
    }
}