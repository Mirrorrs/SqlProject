package com.hansoma.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginSuccAdmin {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginSuccAdmin();
			}
				
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public LoginSuccAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 321, 321);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblLoginSuccess = new JLabel("Login Success!");
		lblLoginSuccess.setFont(new Font("黑体", Font.BOLD, 26));
		lblLoginSuccess.setBounds(48, 29, 218, 62);
		frame.getContentPane().add(lblLoginSuccess);
		
		JButton button = new JButton("OK");
		button.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		button.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FunctionView();
				frame.dispose();
			}
		});
		button.setBounds(102, 131, 88, 43);
		frame.getContentPane().add(button);
		
		JButton btnWorkOnMysql = new JButton("work on mysql here");
		btnWorkOnMysql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new WorkOnMySql();
			}
		});
		btnWorkOnMysql.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 15));
		btnWorkOnMysql.setBackground(Color.WHITE);
		btnWorkOnMysql.setBounds(25, 213, 252, 27);
		frame.getContentPane().add(btnWorkOnMysql);
	}
}
