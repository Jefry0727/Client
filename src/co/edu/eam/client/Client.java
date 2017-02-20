package co.edu.eam.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import co.edu.eam.dto.RegistrarDTO;

public class Client {

	public void ini(Object obj) {
		// TODO Auto-generated method stub
		// for (int i = 0; i < 100; i++) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				Socket con;
				try {
					con = new Socket("localhost", 45000);

					ObjectOutputStream salida = new ObjectOutputStream(con.getOutputStream());

					ObjectInputStream entrada = new ObjectInputStream(con.getInputStream());

					salida.writeObject(obj);

					Object resp = entrada.readObject();

					System.out.println(resp);

				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();
		

	}

}
