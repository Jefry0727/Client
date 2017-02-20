package co.edu.eam.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.edu.eam.client.Client;
import co.edu.eam.dto.RegistrarDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtPassword;
	
	private RegistrarDTO regis;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Registro frame = new Registro();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setBounds(32, 24, 117, 14);
		contentPane.add(lblNombreDeUsuario);

		txtUserName = new JTextField();
		txtUserName.setBounds(169, 21, 131, 20);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(32, 66, 78, 17);
		contentPane.add(lblContrasea);

		txtPassword = new JTextField();
		txtPassword.setBounds(169, 64, 131, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String user = txtUserName.getText();

				String pass = txtPassword.getText();

				regis = new RegistrarDTO(user, pass);
				Client c = new Client(regis);
				new Thread(c).start();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println( c.getResp()+" algo");
				
				/**
				 * para castear un Boolean
				 */
				boolean obj = Boolean.valueOf(c.getResp().toString());
				
				
				if(obj){
					
					JOptionPane.showMessageDialog(null,  "Se ha registrado Correctamente");
					
				}else{
					
					JOptionPane.showMessageDialog(null,  "El usuario no se puede registrar");
					
				}
				

			}
		});
		btnGuardar.setBounds(225, 112, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Principal ppl = new Principal();
				ppl.setVisible(true);
				Registro.this.dispose();
				
			}
		});
		btnVolver.setBounds(73, 112, 89, 23);
		contentPane.add(btnVolver);
	}
}
