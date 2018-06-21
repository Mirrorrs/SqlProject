package com.hansoma.view;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.hansoma.dao.impl.THDAOIMPL;
import com.hansoma.model.Users;
import com.hansoma.model.TH;
import com.hansoma.util.DBUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Font;

public class RegiView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 定义组件
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	private JButton btnShow;
	private JButton next;
	private JTextField textFieldName;
	private JTextField textFieldOwner;
	private JTextField textFieldType;
	private JTable table;

	// 构造方法
	public RegiView() {
		// 窗体的相关属性的定义
		super("RegView");
		this.setSize(1084, 732);
		getContentPane().setLayout(null);
		this.setLocation(100, 50);
		// 创建组件
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(14, 27, 1038, 330);
		this.btnShow = new JButton("Refresh");
		btnShow.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		btnShow.setBackground(Color.WHITE);
		this.btnShow.setBounds(439, 370, 182, 37);
		// 给按钮注册监听
		this.btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				btnShow_ActionPerformed(ae);
			}
		});
		// 将组件加入到窗体中
		getContentPane().add(this.scpDemo);
		getContentPane().add(this.btnShow);
		
		JLabel label1 = new JLabel("");
		label1.setBounds(221, 484, 796, 18);
		getContentPane().add(label1);
		
		JLabel label2 = new JLabel("");
		label2.setBounds(221, 515, 796, 18);
		getContentPane().add(label2);
		
		JLabel label3 = new JLabel("");
		label3.setBounds(221, 546, 796, 18);
		getContentPane().add(label3);
		
		JLabel label4 = new JLabel("");
		label4.setBounds(221, 574, 796, 18);
		getContentPane().add(label4);
		
		JLabel label5 = new JLabel("");
		label5.setBounds(221, 605, 796, 18);
		getContentPane().add(label5);
		
		List<JLabel> ResultsInLabel = new ArrayList();
		ResultsInLabel.add(label1);
		ResultsInLabel.add(label2);
		ResultsInLabel.add(label3);
		ResultsInLabel.add(label4);
		ResultsInLabel.add(label5);
		
		
		
		JButton button = new JButton("Check");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String Name = textFieldName.getText();
					String Owner = textFieldOwner.getText();
					String Type = textFieldType.getText();
					THDAOIMPL impl = new THDAOIMPL();
					List<TH> rs = impl.thSelect();
					
					List<String> LabelResult = new ArrayList();
					
					if(!Name.equals("")) {
						
						for (int i=0; i<rs.size(); i++) {
							if (rs.get(i).getName().equals(Name)) {
								String baseResult = "Result about Name " + Name + ": ";
								baseResult += "Type: " + rs.get(i).getType() + ",";
								baseResult += "Owner: " + rs.get(i).getOwner() + ",";
								baseResult += "Storage Changes: " + rs.get(i).getStorage() + " ";
								baseResult += "@ " + rs.get(i).getDate() + " ." + "\n";
								LabelResult.add(baseResult);
								textFieldName.setText("");
								textFieldOwner.setText("");
								textFieldType.setText("");
							}
						}
						for (int i=0; i<(LabelResult.size()<5?LabelResult.size():5); i++)
							ResultsInLabel.get(i).setText(LabelResult.get(i));	
					}
					
					if(!Owner.equals("")) {
						
						for (int i=0; i<rs.size(); i++) {
							if (rs.get(i).getOwner().equals(Owner)) {
								String baseResult = "Result about Owner " + Owner + ": ";
								baseResult += "Type: " + rs.get(i).getType() + ",";
								baseResult += "Name: " + rs.get(i).getName() + ",";
								baseResult += "Storage Changes: " + rs.get(i).getStorage() + " ";
								baseResult += "@ " + rs.get(i).getDate() + " ." + "\n";
								LabelResult.add(baseResult);
								textFieldName.setText("");
								textFieldOwner.setText("");
								textFieldType.setText("");
							}
						}
						for (int i=0; i<(LabelResult.size()<5?LabelResult.size():5); i++)
							ResultsInLabel.get(i).setText(LabelResult.get(i));	
					}
					
					if(!Type.equals("")) {
						
						for (int i=0; i<rs.size(); i++) {
							if (rs.get(i).getType().equals(Type)) {
								String baseResult = "Result about Type " + Type + ": ";
								baseResult += "Owner: " + rs.get(i).getOwner() + ",";
								baseResult += "Name: " + rs.get(i).getName() + ",";
								baseResult += "Storage Changes: " + rs.get(i).getStorage() + " ";
								baseResult += "@ " + rs.get(i).getDate() + " ." + "\n";
								LabelResult.add(baseResult);
								textFieldName.setText("");
								textFieldOwner.setText("");
								textFieldType.setText("");
							}
						}
						for (int i=0; i<(LabelResult.size()<5?LabelResult.size():5); i++)
							ResultsInLabel.get(i).setText(LabelResult.get(i));	
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		button.setBounds(45, 629, 113, 27);
		getContentPane().add(button);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(75, 481, 113, 24);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(14, 484, 50, 18);
		getContentPane().add(lblName);
		
		JLabel lblOwner = new JLabel("Owner:");
		lblOwner.setBounds(14, 530, 50, 18);
		getContentPane().add(lblOwner);
		
		textFieldOwner = new JTextField();
		textFieldOwner.setBounds(75, 527, 113, 24);
		getContentPane().add(textFieldOwner);
		textFieldOwner.setColumns(10);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(14, 574, 50, 18);
		getContentPane().add(lblType);
		
		textFieldType = new JTextField();
		textFieldType.setBounds(75, 571, 113, 24);
		getContentPane().add(textFieldType);
		textFieldType.setColumns(10);
		
		JLabel lblLastRegistrations = new JLabel("Last 5 registrations");
		lblLastRegistrations.setFont(new Font("黑体", Font.PLAIN, 18));
		lblLastRegistrations.setBounds(442, 440, 268, 18);
		getContentPane().add(lblLastRegistrations);
		
		
		
		
		
		
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
			String sql = "select * from REG";
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
			Object[][] info = new Object[count][7];
			count = 0;
			while (rs.next()) {
				info[count][0] = Integer.valueOf(rs.getInt("ID"));
				info[count][1] = rs.getString("Name");
				info[count][2] = Integer.valueOf(rs.getInt("Storage"));
				info[count][3] = Integer.valueOf(rs.getString("Price"));
				info[count][4] = rs.getString("Owner");
				info[count][5] = rs.getString("Date");
				info[count][6] = rs.getString("Type");
				count++;
			}
			// 定义表头
			String[] title = { "ID", "Name","Storage", "Price", "Owner", "Date", "Type" };
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
		new RegiView(); 
	}
}