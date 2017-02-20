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

public class Client implements Runnable {
	
	private Object obj;// = new Object();
	private Object resp;
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	

	/**
	 * @param obj
	 */
	public Client(Object obj) {
		super();
		this.obj = obj;
	}
	
	
	/**
	 * 
	 */
	public Client() {
		super();
	}
	
	
		@Override
		public void run() {
    	
				Socket con;
				
				try {
					con = new Socket("localhost", 45000);

					salida = new ObjectOutputStream(con.getOutputStream());

					entrada = new ObjectInputStream(con.getInputStream());

					salida.writeObject(obj);							

					this.resp = entrada.readObject();

					System.out.println(resp + "cliente");

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


		/**
		 * @return the obj
		 */
		public Object getObj() {
			return obj;
		}


		/**
		 * @param obj the obj to set
		 */
		public void setObj(Object obj) {
			this.obj = obj;
		}


		/**
		 * @return the resp
		 */
		public Object getResp() {
			
			return this.resp;
		}


		/**
		 * @param resp the resp to set
		 */
		public void setResp(Object resp) {
			this.resp = resp;
		}


		/**
		 * @return the salida
		 */
		public ObjectOutputStream getSalida() {
			return salida;
		}


		/**
		 * @param salida the salida to set
		 */
		public void setSalida(ObjectOutputStream salida) {
			this.salida = salida;
		}


		/**
		 * @return the entrada
		 */
		public ObjectInputStream getEntrada() {
			return entrada;
		}


		/**
		 * @param entrada the entrada to set
		 */
		public void setEntrada(ObjectInputStream entrada) {
			this.entrada = entrada;
		}
		
		

	}







