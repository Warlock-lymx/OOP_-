package com.huawei.classroom.student.h60;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ChatServer extends Thread {
	/**
	 * 初始化 ， 根据情况适当抛出异常
	 * @param port
	 * @param passwordFilename 所有用户的用户名 口令
	 */
	private final ServerSocket server;
	private final Map<String, String> passwd;
	public static List<Socket> clients = new ArrayList<>();

	public ChatServer (int port, String passwordFilename) throws IOException {
		server = new ServerSocket(port);
		passwd = readLines(passwordFilename);
	}

	public Map<String, String> readLines(String filename) throws IOException {
		String line;
		Map<String, String> result = new HashMap<>();
		Reader reader= new FileReader(filename);
		LineNumberReader lineReader = new LineNumberReader(reader);

		while (true) {
			line = lineReader.readLine();
			if (line == null) {
				break;
			}
			if (line.trim().length() == 0 || line.startsWith("#")) {
				continue;
			}
			String[] lineContent = line.split("\t");
			result.put(lineContent[0], lineContent[1]);
		}
		return result;
	}

	/**
	 *  根据情况适当抛出异常
	 * 开始监听
	 */
	@Override
	public void run() {
		while (true) {
			Socket socket = null;
			try {
				socket = server.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			clients.add(socket);
			new ServerThread(socket, passwd).start();
		}
	}

	public void startListen( ) {
		this.start();
	}

}
