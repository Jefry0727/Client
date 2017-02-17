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
import co.edu.eam.dto.RegistrarDTO;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
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
	
	private RegistrarDTO regis;

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
		lblNewLabel.setBounds(10, 34, 119, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(10, 64, 62, 19);
		getContentPane().add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(135, 33, 119, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(135, 63, 119, 19);
		getContentPane().add(txtPass);
		txtPass.setColumns(10);
		
		
		
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		btnRegistrar.setBounds(34, 106, 89, 23);
		getContentPane().add(btnRegistrar);
		
		JButton btnIniciarSesin = new JButton("Iniciar Sesión");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = txtUsuario.getText();
				
				String pass = txtPass.getText();
				
				regis = new RegistrarDTO(user, pass);
				Client c = new Client();
				c.ini(regis);
				
			}
		});
		btnIniciarSesin.setBounds(139, 106, 115, 19);
		getContentPane().add(btnIniciarSesin);
	}
}
