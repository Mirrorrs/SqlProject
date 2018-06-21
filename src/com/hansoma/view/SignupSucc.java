package com.hansoma.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SignupSucc {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SignupSucc();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignupSucc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 339, 256);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblSignUpSuccess = new JLabel("Sign Up Success");
		lblSignUpSuccess.setFont(new Font("黑体", Font.BOLD, 24));
		lblSignUpSuccess.setBounds(56, 27, 200, 78);
		frame.getContentPane().add(lblSignUpSuccess);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(Color.LIGHT_GRAY);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnOk.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		btnOk.setBounds(97, 118, 113, 41);
		frame.getContentPane().add(btnOk);
	}
}
