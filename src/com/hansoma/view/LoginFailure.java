package com.hansoma.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginFailure {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				try {
//					LoginFailure window = new LoginFailure();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
				new LoginFailure();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFailure() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 355, 257);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblLoginFailure = new JLabel("Login Failure!");
		lblLoginFailure.setFont(new Font("黑体", Font.PLAIN, 24));
		lblLoginFailure.setBounds(89, 30, 182, 69);
		frame.getContentPane().add(lblLoginFailure);
		
		JButton btnNewButton = new JButton("Try again");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(99, 118, 144, 52);
		frame.getContentPane().add(btnNewButton);
	}

}
