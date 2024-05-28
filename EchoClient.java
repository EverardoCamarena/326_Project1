/**
 * Armando Sanchez & Everardo Camarena
 * CECS 326 FALL 2023
 * This program connects the client to a server on port 6007 and it displays echos back 
 * to the client. 
 */
import java.net.*;
import java.io.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("localhost", 6007); //looks for the port 6007 in my local connection

            while (true) {
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // reads user input data
                System.out.println("Type something or Type END to quit: "); //types instructions to user
                String str = bf.readLine(); //stores the data the user inputted in the string str

                PrintWriter pout = new PrintWriter(sock.getOutputStream(), true); //send data to server
                pout.println(str); // prints the data sent

                if (str.equalsIgnoreCase("END")) { //if the data equals END. the program runs the loop
                    sock.close(); // Closes the socket when "END" is entered
                }

                BufferedReader a = new BufferedReader(new InputStreamReader(sock.getInputStream())); //reads data from the server
                System.out.println("Server: " + a.readLine()); //print data from the server and adds server in front of it
            }
        } catch (IOException ioe) { //throws an IOException if it detects that it is not connecting
            System.err.println(ioe);
        }
    }
}
