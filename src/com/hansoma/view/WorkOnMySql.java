package com.hansoma.view;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.hansoma.model.Users;
import com.hansoma.util.DBUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;
import java.awt.Color;
import java.awt.Font;

public class WorkOnMySql extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 定义组件
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	private JButton btnShow;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textId;
	private JLabel lblId;
	private JButton next;

	// 构造方法
	public WorkOnMySql() {
		// 窗体的相关属性的定义
		super("Existed Users");
		this.setSize(523, 566);
		getContentPane().setLayout(null);
		this.setLocation(100, 50);
		// 创建组件
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(10, 50, 459, 283);
		this.btnShow = new JButton("Refresh");
		btnShow.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		btnShow.setBackground(Color.WHITE);
		this.btnShow.setBounds(66, 7, 182, 30);
		// 给按钮注册监听
		this.btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				btnShow_ActionPerformed(ae);
			}
		});
		// 将组件加入到窗体中
		getContentPane().add(this.scpDemo);
		getContentPane().add(this.btnShow);
		
		textUsername = new JTextField();
		textUsername.setBounds(10, 367, 200, 24);
		getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Username = textUsername.getText();
				String Password = textPassword.getText();
				List<Users> rs = null;
				rs = DBUtil.getData("users");
				int nextId = rs.get(rs.size()-1).getId() + 1;
				DBUtil.insertIntoTable("users", nextId, Username, Password);
				
			}
		});
		btnInsert.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnInsert.setBackground(Color.WHITE);
		btnInsert.setBounds(286, 367, 86, 68);
		getContentPane().add(btnInsert);
		
		textPassword = new JTextField();
		textPassword.setBounds(10, 411, 200, 24);
		getContentPane().add(textPassword);
		textPassword.setColumns(10);
		
		textId = new JTextField();
		textId.setBounds(10, 467, 200, 24);
		getContentPane().add(textId);
		textId.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String Id = textId.getText();
				if(!Id.equals("0")) {
					DBUtil.deleteFromTable("users", Id);
				}else {
					new PermissionDenied();
				}
			}
		});
		btnDelete.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(286, 465, 86, 24);
		getContentPane().add(btnDelete);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblUsername.setBounds(10, 346, 72, 18);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblPassword.setBounds(10, 392, 72, 18);
		getContentPane().add(lblPassword);
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblId.setBounds(10, 448, 72, 18);
		getContentPane().add(lblId);
		
		// 显示窗体
		this.setVisible(true);
	}

	// 点击按钮时的事件处理
	public void btnShow_ActionPerformed(ActionEvent ae) {
		// 以下是连接数据源和显示数据的具体处理方法，请注意下
		try {
			// 获得连接
			Connection conn = DBUtil.con();
			// 建立查询条件
			String sql = "select * from users";
			PreparedStatement pstm = conn.prepareStatement(sql);
			// 执行查询
			ResultSet rs = pstm.executeQuery();
			// 计算有多少条记录
			int count = 0;
			while (rs.next()) {
				count++;
			}
			rs = pstm.executeQuery();
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			Object[][] info = new Object[count][4];
			count = 0;
			while (rs.next()) {
				info[count][0] = Integer.valueOf(rs.getInt("id"));
				info[count][1] = rs.getString("username");
				info[count][2] = rs.getString("password");
				count++;
			}
			// 定义表头
			String[] title = { "ID", "Username", "Password" };
			// 创建JTable
			this.tabDemo = new JTable(info, title);
			// 显示表头
			this.jth = this.tabDemo.getTableHeader();
			this.scpDemo.setViewportView(tabDemo);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		try
	    {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.generalNoTranslucencyShadow;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	    }
	    catch(Exception e)
	    {
	        System.out.println(e);
	    }
		new WorkOnMySql(); 
	}
}