package com.hansoma.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginSuccess {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try
	    {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
			UIManager.put("RootPane.setupButtonVisible", false);
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        System.out.println(e);
	    }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginSuccess();
			}
				
		});
	}

	/**
	 * Create the application.
	 */
	public LoginSuccess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 342, 302);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblLoginSuccess = new JLabel("Login Success!");
		lblLoginSuccess.setFont(new Font("黑体", Font.BOLD, 26));
		lblLoginSuccess.setBounds(55, 34, 221, 62);
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
		button.setBounds(104, 136, 88, 43);
		frame.getContentPane().add(button);
	}
}
