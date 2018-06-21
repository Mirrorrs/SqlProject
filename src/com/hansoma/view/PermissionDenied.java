package com.hansoma.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PermissionDenied {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			new PermissionDenied();
		}

	/**
	 * Create the application.
	 */
	public PermissionDenied() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblPermissioinDenied = new JLabel("Permissioin Denied!");
		lblPermissioinDenied.setForeground(Color.RED);
		lblPermissioinDenied.setFont(new Font("黑体", Font.BOLD, 35));
		lblPermissioinDenied.setBounds(28, 30, 404, 90);
		frame.getContentPane().add(lblPermissioinDenied);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 23));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(167, 153, 84, 50);
		frame.getContentPane().add(btnNewButton);
	}

}
