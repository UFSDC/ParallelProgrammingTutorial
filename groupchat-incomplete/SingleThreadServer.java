import java.net.*;
import java.io.*;
import java.util.*;

class SingleThreadServer {
	
	ArrayList<ChatClient> clients = new ArrayList<ChatClient>();

	/*
		Available networking methods:
		startListen()
		waitForNewClient()
		client.waitForNextMessage()
	*/

	void runServer() throws Exception {

	}
	

	// Beware! Networking stuff!
	ServerSocket server;
	static int portNum;

	public static void main(String[] args) {
		try {
			portNum = Integer.parseInt(args[0]);
			new SingleThreadServer().runServer();
		} catch (Exception e) {
			System.err.println("Something went wrong!");
			System.err.println(e.toString());
		}
	}
	
	void startListen() throws Exception {
		System.out.println("Listening on port " + portNum + "...");
		server = new ServerSocket(portNum);
	}

	ChatClient waitForNewClient() throws Exception {
		Socket client = server.accept();
		Scanner input = new Scanner(client.getInputStream());
		String name = input.nextLine();
		return new ChatClient(name, input);
	}

	class ChatClient {
		String name;
		Scanner input;
		
		ChatClient(String name, Scanner input) {
			this.name = name;
			this.input = input;
		}

		String waitForNextMessage() throws Exception {
			return input.nextLine();
		}
	}
}

