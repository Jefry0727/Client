/**
 * 
 */
package co.edu.eam.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.eam.client.Client;
import co.edu.eam.dto.LoginDTO;
import co.edu.eam.dto.RegistrarDTO;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @17/02/2017
 * @version 
 */
public class Principal extends JFrame {
	private JTextField txtUsuario;
	private JTextField txtPass;
	
	private LoginDTO login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 193);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de Usuario");
		lblNewLabel.setBounds(29, 34, 119, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(29, 64, 70, 18);
		getContentPane().add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(158, 33, 119, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(158, 63, 119, 19);
		getContentPane().add(txtPass);
		txtPass.setColumns(10);
		
		
		
		
		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registro reg = new Registro();
				reg.setVisible(true);
				Principal.this.dispose();
				
				
				
			}
		});
		btnRegistrar.setBounds(34, 106, 102, 23);
		getContentPane().add(btnRegistrar);
		
		JButton btnIniciarSesin = new JButton("Iniciar Sesión");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = txtUsuario.getText();
				
				String pass = txtPass.getText();
				
				login = new LoginDTO(user, pass);
				Client c = new Client(login);
				
				Thread t =  new Thread(c,"hilo");
				t.setPriority(Thread.MAX_PRIORITY);
				t.start();
				 
				 try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				/**
				 * para castear un Boolean
				 */
				boolean obj = Boolean.valueOf(c.getResp().toString());
				
				System.out.println(obj + " respuesta");
				
				if(obj){
					
					Messenger msj = new Messenger();
					
					msj.setVisible(true);
					
					Principal.this.dispose();
				}else{
					
					JOptionPane.showMessageDialog(null, "Usuario y Contraseña invalidos");
					
				}
				
				
			}
		});
		btnIniciarSesin.setBounds(158, 106, 119, 23);
		getContentPane().add(btnIniciarSesin);
	}
}
