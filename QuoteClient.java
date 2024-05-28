/**
 * Armando Sanchez & Everardo Camarena
 * CECS 326 FALL 2023
 * This program connects the client to a server on port 6017 and it displays a quote.
 */
 
import java.net.*;
import java.io.*;

public class QuoteClient
{
	public static void main(String[] args){
		try{
		Socket sock = new Socket ("localhost", 6017) ; //makes a server and names it sock
		while(true){ //always runs unless break is used

		InputStreamReader in = new InputStreamReader(sock.getInputStream()); //reads bytes from the client(socket)
		BufferedReader bf = new BufferedReader(in); //dreads from inputs stream

		String str = bf.readLine(); //saves each line to string str
		System.out.println("Server: " + str); //prints the data and adds server in front
		
		/* close the socket and resume */
		sock.close();
	}
}
		catch (IOException ioe) { //throws and ioexception if it detects an error
		System.err.println(ioe);
		}
	}
}