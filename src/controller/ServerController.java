package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerController extends Thread {
	String ip = "172.0.0.1";
	Socket socket;
	PrintWriter out;
	BufferedReader in;
	String line = "";
	ArrayList<Socket> arrSocket;

	public ServerController(Socket s, ArrayList<Socket> arrSocket) throws IOException {
		this.socket = s;
		this.arrSocket = arrSocket;

	}

	@Override
	public void run() {
		// super.run();
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			// out.println("Welcome " + socket.getInetAddress());
			while (true) {

				if ((line = in.readLine()) != null) {
					for (Socket socket : arrSocket) {
						out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
						out.println(" " + line);
					}
				} else {

				}

			}
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public static void main(String[] args) throws IOException {
		int PORT = 7;
		ArrayList<Socket> arr = new ArrayList<>();
		// vì nhiều client sẻ kết nối lên cho server, nên cần tạo một mảng để chứa các
		// client đó
		// và sẻ nhận một tin nhắn từ một client và gửi đi cho tất cả client khác
		// vậy server là chung và thực hiện cho nhiều client
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(PORT);
		while (true) {
			Socket socc = ss.accept();
			arr.add(socc);
			ServerController s = new ServerController(socc, arr);
			s.start();
		}
	}

}
