package com.hansoma.view;

import com.hansoma.model.Users;
import com.hansoma.util.DBUtil;
import com.hansoma.view.LoginSuccess;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class LoginUI {

	private JFrame frmLogin;
	private JPasswordField textPassword;
	private JTextField textUsername;
	public String username = null;
	public String password = null;
	
	public String defaultUsername = "admin";
	public String defaultPassword = "admin"; 
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
				try {
					LoginUI window = new LoginUI();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginUI() {
		Login();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	//Is the userName and password legal?
	private boolean isLegal(String userName,String password) {
		List<Users> rs = null;
		rs = DBUtil.getData("users");
		for(int i = 0;i < rs.size();i ++) {
			if(userName.equals(rs.get(i).getUserName())) {
				if(password.equals(rs.get(i).getPassword())) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	
	//Login Now
	private void Login() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setEnabled(false);
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.setBounds(100, 100, 592, 557);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
	
		
		//username field
		textUsername = new JTextField("admin");
		textUsername.setBackground(new Color(204, 255, 255));
		textUsername.setBounds(214, 156, 192, 24);
		frmLogin.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		//password field
		textPassword = new JPasswordField("admin");
		textPassword.setBackground(new Color(204, 255, 255));
		textPassword.setBounds(214, 222, 192, 24);
		frmLogin.getContentPane().add(textPassword);
		
		//JLable for username and password
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
		lblUsername.setBounds(113, 157, 87, 18);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 16));
		lblNewLabel.setBounds(123, 221, 77, 23);
		frmLogin.getContentPane().add(lblNewLabel);
		
		//Buttons
		//login
		JButton btnLogin = new JButton("Sign in");
		btnLogin.setBackground(Color.GREEN);
		btnLogin.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username = textUsername.getText();
				password = String.valueOf(textPassword.getPassword());
				if(!username.equals("admin")) {
					if(isLegal(username,password)) {
						frmLogin.setVisible(false);
						new LoginSuccess();
					}else {
						new LoginFailure();
					}
				}else if(username.equals("admin")) {
					frmLogin.setVisible(false);
					new LoginSuccAdmin();
				}

			}
		});
		btnLogin.setBounds(156, 301, 87, 39);
		frmLogin.getContentPane().add(btnLogin);
		
		//quit
		JButton btnNewButton = new JButton("Quit");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(347, 303, 88, 35);
		frmLogin.getContentPane().add(btnNewButton);
		
		JLabel lblLoginNow = new JLabel("Login Now");
		lblLoginNow.setFont(new Font("黑体", Font.BOLD, 38));
		lblLoginNow.setBounds(176, 47, 203, 68);
		frmLogin.getContentPane().add(lblLoginNow);
		
		JButton btnSignUpHere = new JButton("Sign up here");
		btnSignUpHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SignUp();
			}
		});
		btnSignUpHere.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 15));
		btnSignUpHere.setBackground(Color.WHITE);
		btnSignUpHere.setBounds(231, 375, 129, 24);
		frmLogin.getContentPane().add(btnSignUpHere);
		
		

	}
}
