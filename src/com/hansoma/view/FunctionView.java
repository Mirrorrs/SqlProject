package com.hansoma.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FunctionView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FunctionView window = new FunctionView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FunctionView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 455, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton button_1 = new JButton("信息录入与更改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsertView();
			}
		});
		button_1.setBounds(95, 62, 235, 87);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("信息查询");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegiView();
			}
		});
		button_2.setBounds(95, 203, 235, 87);
		frame.getContentPane().add(button_2);
	}
}
