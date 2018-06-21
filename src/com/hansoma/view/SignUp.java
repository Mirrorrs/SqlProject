package com.hansoma.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.hansoma.model.Users;
import com.hansoma.util.DBUtil;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignUp {

	private JFrame frame;
	private JTextField Username;
	private JPasswordField passwordField;
	private String username;
	private String password;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SignUp();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblSignUp = new JLabel("Sign UP");
		lblSignUp.setFont(new Font("黑体", Font.BOLD, 40));
		lblSignUp.setBounds(125, 13, 189, 79);
		frame.getContentPane().add(lblSignUp);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		lblUsername.setBounds(30, 98, 76, 35);
		frame.getContentPane().add(lblUsername);
		
		JLabel label = new JLabel("Password:");
		label.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		label.setBounds(34, 146, 72, 18);
		frame.getContentPane().add(label);
		
		Username = new JTextField();
		Username.setBounds(120, 105, 248, 24);
		frame.getContentPane().add(Username);
		Username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 145, 248, 24);
		frame.getContentPane().add(passwordField);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username = Username.getText();
				password = String.valueOf(passwordField.getPassword());
//				System.out.println(username);
//				System.out.println(password);
				if(!username.equals("") && !password.equals("")) {
					List<Users> rs = null;
					rs = DBUtil.getData("users");
					int nextId = rs.get(rs.size()-1).getId() + 1;
					if(DBUtil.insertIntoTable("users",nextId,username,password)) {
						//System.out.println("Insert success.");
						new SignupSucc();
					}else {
						new SignupFailure();
					}
				}else {
					new SignupFailure();
				}
			}
		});
		btnOk.setBackground(Color.GREEN);
		btnOk.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnOk.setBounds(121, 200, 76, 35);
		frame.getContentPane().add(btnOk);
		
		JButton button = new JButton("Quit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		button.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		button.setBackground(Color.RED);
		button.setBounds(253, 200, 76, 35);
		frame.getContentPane().add(button);
	
		
	}
}
