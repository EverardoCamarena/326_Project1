
/**
 * Armando Sanchez & Everardo Camarena
 * CECS 326 FALL 2023
 * This program connects the client to a server on port 6017 and it displays a quote.
 */
 
import java.net.*;
import java.io.*;

public class QuoteServer
{

  public static void main(String[] args) {
    try {
    ServerSocket sock = new ServerSocket(6017); //port 17
    System.out.println("listening..."); // verifying that that server is active

    /* now listen for connections */
    while (true) {
    Socket client = sock.accept();
      System.out.println("connected"); // prints a message once the client connects
    PrintWriter pout = new PrintWriter(client.getOutputStream(), true); 

    /* write the quote to the socket */
    pout.println(Quote().toString());

    /* close the socket and resume */
    sock.close();
    /* listening for connections */ 
    client. close();
    }
  }
    catch (IOException ioe) { //throws an exception
    System.err.println(ioe);
    }
  }

  public static String Quote(){ //function that contains the quote
   return "\"If you're not first, you're last\"";
  }
}


