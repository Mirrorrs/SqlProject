package com.hansoma.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupFailure {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SignupFailure();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignupFailure() {
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
		
		JLabel lblSignUpFailure = new JLabel("Sign Up Failure");
		lblSignUpFailure.setForeground(Color.RED);
		lblSignUpFailure.setFont(new Font("黑体", Font.BOLD, 24));
		lblSignUpFailure.setBounds(59, 13, 235, 88);
		frame.getContentPane().add(lblSignUpFailure);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnOk.setBackground(Color.LIGHT_GRAY);
		btnOk.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		btnOk.setBounds(107, 136, 113, 37);
		frame.getContentPane().add(btnOk);
	}

}
