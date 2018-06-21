package com.hansoma.view;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.hansoma.dao.impl.HWXXDAOIMPL;
import com.hansoma.dao.impl.THDAOIMPL;
import com.hansoma.model.HWXX;
import com.hansoma.util.DBUtil;
import com.hansoma.util.GetNowTime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;
import java.awt.Color;
import java.awt.Font;

public class InsertView extends JFrame {
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
	private JLabel lblId;
	private JTextField textFieldID;
	private JLabel lblName;
	private JTextField textFieldName;
	private JLabel lblStorage;
	private JTextField textFieldStorage;
	private JLabel lblPrice;
	private JTextField textFieldPrice;
	private JLabel lblOwner;
	private JTextField textFieldOwner;
	private JLabel lblIndate;
	private JTextField textFieldInDate;
	private JLabel lblOutdate;
	private JTextField textFieldOutDate;
	private JButton btnNewButton;
	private JLabel label;
	private JLabel lblid;
	private JTextField textFieldIDUpdate;
	private JTextField textFieldStorageUpdate;
	private JTextField textFieldPriceUpdate;
	private JButton btnNewButton_1;
	private JTextField textFieldIndateUpdate;
	private JTextField textFieldOutdateUpdate;
	private JTextField textFieldIDOut;
	private JTextField textFieldStorageOut;
	private JTextField textFieldOutdateOut;
	private JButton btnOut;
	private JButton btnGetTime;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JLabel labelPrevStorage;
	private JButton btnNewButton_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField textFieldIDIn;
	private JTextField textFieldStorageIn;
	private JTextField textFieldIndateIn;
	private JButton button_4;
	private JButton button_5;
	private JLabel label_5;
	private JLabel labelAttentionIn;
	private JButton button_6;

	// 构造方法
	public InsertView() {
		// 窗体的相关属性的定义
		super("Main Frame");
		this.setSize(1151, 777);
		getContentPane().setLayout(null);
		this.setLocation(100, 50);
		// 创建组件
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(10, 50, 1096, 250);
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
		
		lblId = new JLabel("ID");
		lblId.setBounds(10, 365, 72, 18);
		getContentPane().add(lblId);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(10, 396, 86, 24);
		getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		lblName = new JLabel("Name");
		lblName.setBounds(110, 365, 72, 18);
		getContentPane().add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(110, 396, 123, 24);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		lblStorage = new JLabel("Storage");
		lblStorage.setBounds(248, 365, 72, 18);
		getContentPane().add(lblStorage);
		
		textFieldStorage = new JTextField();
		textFieldStorage.setBounds(247, 396, 86, 24);
		getContentPane().add(textFieldStorage);
		textFieldStorage.setColumns(10);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(350, 365, 72, 18);
		getContentPane().add(lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(347, 396, 86, 24);
		getContentPane().add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		lblOwner = new JLabel("Owner");
		lblOwner.setBounds(448, 365, 72, 18);
		getContentPane().add(lblOwner);
		
		textFieldOwner = new JTextField();
		textFieldOwner.setBounds(447, 396, 109, 24);
		getContentPane().add(textFieldOwner);
		textFieldOwner.setColumns(10);
		
		lblIndate = new JLabel("InDate");
		lblIndate.setBounds(574, 365, 72, 18);
		getContentPane().add(lblIndate);
		
		textFieldInDate = new JTextField();
		textFieldInDate.setBounds(570, 396, 175, 24);
		getContentPane().add(textFieldInDate);
		textFieldInDate.setColumns(10);
		
		lblOutdate = new JLabel("OutDate");
		lblOutdate.setBounds(765, 365, 72, 18);
		getContentPane().add(lblOutdate);
		
		textFieldOutDate = new JTextField();
		textFieldOutDate.setBounds(759, 396, 182, 24);
		getContentPane().add(textFieldOutDate);
		textFieldOutDate.setColumns(10);
		
		// 插入操作
		btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int ID = Integer.valueOf(textFieldID.getText());
					String Name = textFieldName.getText();
					int Storage = Integer.valueOf(textFieldStorage.getText());
					int Price = Integer.valueOf(textFieldPrice.getText());
					String owner = textFieldOwner.getText();
					String InDate = textFieldInDate.getText();
					String OutDate = textFieldOutDate.getText();
					if(OutDate.equals("")) 
						OutDate = null;
					HWXXDAOIMPL impl = new HWXXDAOIMPL();
					impl.hwxxInsert(ID, Name, Storage, Price, owner, InDate, OutDate);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnNewButton.setBounds(999, 395, 95, 27);
		getContentPane().add(btnNewButton);
		
		label = new JLabel("更新数据");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(10, 448, 109, 36);
		getContentPane().add(label);
		
		lblid = new JLabel("注意！ 必填项为ID。");
		lblid.setForeground(Color.RED);
		lblid.setBounds(110, 459, 147, 18);
		getContentPane().add(lblid);
		
		textFieldIDUpdate = new JTextField("1");
		textFieldIDUpdate.setBounds(10, 497, 86, 24);
		getContentPane().add(textFieldIDUpdate);
		textFieldIDUpdate.setColumns(10);
		
		textFieldStorageUpdate = new JTextField("10");
		textFieldStorageUpdate.setBounds(248, 497, 85, 24);
		getContentPane().add(textFieldStorageUpdate);
		textFieldStorageUpdate.setColumns(10);
		
		textFieldPriceUpdate = new JTextField("12");
		textFieldPriceUpdate.setBounds(347, 497, 86, 24);
		getContentPane().add(textFieldPriceUpdate);
		textFieldPriceUpdate.setColumns(10);
		
		textFieldIndateUpdate = new JTextField();
		textFieldIndateUpdate.setBounds(570, 497, 175, 24);
		getContentPane().add(textFieldIndateUpdate);
		textFieldIndateUpdate.setColumns(10);
		
		textFieldOutdateUpdate = new JTextField();
		textFieldOutdateUpdate.setBounds(759, 497, 182, 24);
		getContentPane().add(textFieldOutdateUpdate);
		textFieldOutdateUpdate.setColumns(10);
		
		
		
		
		
		// 更新操作
		btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ID = Integer.valueOf(textFieldIDUpdate.getText());
					
					String sStorage = textFieldStorageUpdate.getText();
					int Storage = -1;
					if (!sStorage.equals("")) {Storage = Integer.valueOf(sStorage);}
					
					String sPrice = textFieldPriceUpdate.getText();
					int Price = -1;
					if (!sPrice.equals("")) {Price = Integer.valueOf(sPrice);}
					
					String Indate = textFieldIndateUpdate.getText();
					
					String Outdate = textFieldOutdateUpdate.getText();

					HWXXDAOIMPL impl = new HWXXDAOIMPL();
					if(textFieldIDUpdate.getText().equals("")) { 
						JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
					} else {
						if (Storage != -1) {impl.hwxxUpdateStorage(ID, Storage);}
						if (Price != -1) {impl.hwxxUpdatePrice(ID, Price);}
						if (!Indate.equals("")) {impl.hwxxUpdateIndate(ID, Indate);}
						if (!Outdate.equals("")) {impl.hwxxUpdateOutdate(ID, Outdate);}
					}
				}catch (Exception e1) {
					//JOptionPane.showMessageDialog(null, "数据操作错误", "错误", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(999, 496, 95, 27);
		getContentPane().add(btnNewButton_1);
		
		JLabel label_1 = new JLabel("提货");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(10, 551, 72, 18);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("注意！ 必填项为ID。");
		label_2.setForeground(Color.RED);
		label_2.setBounds(149, 553, 147, 18);
		getContentPane().add(label_2);
		
		textFieldIDOut = new JTextField("1");
		textFieldIDOut.setBounds(10, 589, 86, 24);
		getContentPane().add(textFieldIDOut);
		textFieldIDOut.setColumns(10);
		
		textFieldStorageOut = new JTextField();
		textFieldStorageOut.setBounds(248, 589, 86, 24);
		getContentPane().add(textFieldStorageOut);
		textFieldStorageOut.setColumns(10);
		
		textFieldOutdateOut = new JTextField();
		textFieldOutdateOut.setBounds(759, 589, 182, 24);
		getContentPane().add(textFieldOutdateOut);
		textFieldOutdateOut.setColumns(10);
		
		// 确认提货
		btnOut = new JButton("Confirm");
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 更新库存, 提货时间并将信息存入表REG
				int selectedId = Integer.valueOf(textFieldIDOut.getText()); // 需要提货的货物的id
				// 获取当前该货物的数量
				int pos = -1; // pos用于记录id在查询结果集中的位置
				HWXXDAOIMPL impl = new HWXXDAOIMPL();
				List<HWXX> h= impl.hwxxSelect();
				for (int i=0; i<h.size(); i++)
					if(h.get(i).getId() == selectedId)
						pos = i;
				int prevStorage = h.get(pos).getStorage();
				// 需要提货的数量
				int outStorage = Integer.valueOf(textFieldStorageOut.getText());
				
				// 获取需要插入表REG的其他信息
				int ID = h.get(pos).getId();
				int Price = h.get(pos).getPrice();
				String Name = h.get(pos).getName();
				String Owner = h.get(pos).getOwner();
				String Date = textFieldOutdateOut.getText();
				String Type = "Out";
				// 插入REG表, 登记出货信息
				THDAOIMPL impl2 = new THDAOIMPL();
				impl2.thInsert(ID, Name, outStorage, Price, Owner, Date, Type);
				
				// 更新HWXX表
				int recentStorage = prevStorage - outStorage;
				impl.hwxxUpdateOutdate(ID, Date);
				impl.hwxxUpdateStorage(ID, recentStorage);
				}
		});
		btnOut.setBounds(999, 588, 95, 27);
		getContentPane().add(btnOut);
		
		btnGetTime = new JButton("Now");
		btnGetTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nowTime = GetNowTime.getTime();
				textFieldInDate.setText(nowTime);
			}
		});
		btnGetTime.setBounds(668, 361, 72, 27);
		getContentPane().add(btnGetTime);
		
		button = new JButton("Now");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nowTime = GetNowTime.getTime();
				textFieldOutDate.setText(nowTime);
			}
		});
		button.setBounds(864, 361, 72, 27);
		getContentPane().add(button);
		
		button_1 = new JButton("Now");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nowTime = GetNowTime.getTime();
				textFieldIndateUpdate.setText(nowTime);
			}
		});
		button_1.setBounds(668, 459, 72, 27);
		getContentPane().add(button_1);
		
		button_2 = new JButton("Now");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nowTime = GetNowTime.getTime();
				textFieldOutdateUpdate.setText(nowTime);
			}
		});
		button_2.setBounds(864, 459, 72, 27);
		getContentPane().add(button_2);
		
		button_3 = new JButton("Now");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nowTime = GetNowTime.getTime();
				textFieldOutdateOut.setText(nowTime);
			}
		});
		button_3.setBounds(864, 549, 72, 27);
		getContentPane().add(button_3);
		
		labelPrevStorage = new JLabel();
		labelPrevStorage.setForeground(Color.RED);
		labelPrevStorage.setBounds(350, 583, 296, 30);
		getContentPane().add(labelPrevStorage);
		
		btnNewButton_2 = new JButton("Check");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedId = Integer.valueOf(textFieldIDOut.getText()); // 需要提货的货物的id
				// 获取当前该货物的数量
				int pos = -1; // pos用于记录id在查询结果集中的位置
				HWXXDAOIMPL impl = new HWXXDAOIMPL();
				List<HWXX> h= impl.hwxxSelect();
				for (int i=0; i<h.size(); i++)
					if(h.get(i).getId() == selectedId)
						pos = i;
				int prevStorage = h.get(pos).getStorage();
				String Attention = "当前库存量为" + Integer.valueOf(prevStorage) +", 注意不要超出范围.";
				labelPrevStorage.setText(Attention);
			}
		});
		btnNewButton_2.setBounds(51, 549, 78, 27);
		getContentPane().add(btnNewButton_2);
		
		label_3 = new JLabel("增加记录");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(10, 328, 72, 24);
		getContentPane().add(label_3);
		
		label_4 = new JLabel("添货");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		label_4.setBounds(10, 626, 72, 30);
		getContentPane().add(label_4);
		
		textFieldIDIn = new JTextField("1");
		textFieldIDIn.setBounds(10, 669, 86, 24);
		getContentPane().add(textFieldIDIn);
		textFieldIDIn.setColumns(10);
		
		textFieldStorageIn = new JTextField();
		textFieldStorageIn.setBounds(248, 669, 86, 24);
		getContentPane().add(textFieldStorageIn);
		textFieldStorageIn.setColumns(10);
		
		textFieldIndateIn = new JTextField();
		textFieldIndateIn.setBounds(570, 669, 175, 24);
		getContentPane().add(textFieldIndateIn);
		textFieldIndateIn.setColumns(10);
		
		button_4 = new JButton("Confirm");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 更新库存, 提货时间并将信息存入表REG
				int selectedId = Integer.valueOf(textFieldIDOut.getText()); // 需要提货的货物的id
				// 获取当前该货物的数量
				int pos = -1; // pos用于记录id在查询结果集中的位置
				HWXXDAOIMPL impl = new HWXXDAOIMPL();
				List<HWXX> h= impl.hwxxSelect();
				for (int i=0; i<h.size(); i++)
					if(h.get(i).getId() == selectedId)
						pos = i;
				int prevStorage = h.get(pos).getStorage();
				int Price = h.get(pos).getPrice();
				String Owner = h.get(pos).getOwner();
				String Type = "In";
				// 需要添货的数量
				int inStorage = Integer.valueOf(textFieldStorageIn.getText());
				
				// 获取需要的其他信息
				int ID = h.get(pos).getId();
				String Date = textFieldIndateIn.getText();
				String Name = h.get(pos).getName();
				// 插入REG表
				THDAOIMPL impl2 = new THDAOIMPL();
				impl2.thInsert(ID, Name, inStorage, Price, Owner, Date, Type);
				// 更新HWXX表
				int recentStorage = prevStorage + inStorage;
				impl.hwxxUpdateIndate(ID, Date);
				impl.hwxxUpdateStorage(ID, recentStorage);
			}
		});
		button_4.setBounds(999, 668, 95, 27);
		getContentPane().add(button_4);
		
		button_5 = new JButton("Check");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedId = Integer.valueOf(textFieldIDIn.getText()); // 需要提货的货物的id
				// 获取当前该货物的数量
				int pos = -1; // pos用于记录id在查询结果集中的位置
				HWXXDAOIMPL impl = new HWXXDAOIMPL();
				List<HWXX> h= impl.hwxxSelect();
				for (int i=0; i<h.size(); i++)
					if(h.get(i).getId() == selectedId)
						pos = i;
				int prevStorage = h.get(pos).getStorage();
				String Attention = "当前库存量为" + Integer.valueOf(prevStorage) +".";
				labelAttentionIn.setText(Attention);
			}
		});
		button_5.setBounds(51, 630, 78, 27);
		getContentPane().add(button_5);
		
		label_5 = new JLabel("注意！ 必填项为ID。");
		label_5.setForeground(Color.RED);
		label_5.setBounds(149, 634, 147, 18);
		getContentPane().add(label_5);
		
		labelAttentionIn = new JLabel();
		labelAttentionIn.setForeground(Color.RED);
		labelAttentionIn.setBounds(350, 663, 203, 30);
		getContentPane().add(labelAttentionIn);
		
		button_6 = new JButton("Now");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nowTime = GetNowTime.getTime();
				textFieldIndateIn.setText(nowTime);
			}
		});
		button_6.setBounds(668, 630, 72, 27);
		getContentPane().add(button_6);
		
		
		
		// 显示窗体
		this.setVisible(true);
	}

	// 点击按钮时的事件处理
	public void btnShow_ActionPerformed(ActionEvent ae) {
		// 以下是连接数据源和显示数据的具体处理方法
		try {
			// 获得连接
			Connection conn = DBUtil.con();
			// 建立查询条件
			String sql = "select * from HWXX";
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
			Object[][] info = new Object[count][8];
			count = 0;
			while (rs.next()) {
				info[count][0] = Integer.valueOf(rs.getInt("ID"));
				info[count][1] = rs.getString("Name");
				info[count][2] = Integer.valueOf(rs.getInt("Storage"));
				info[count][3] = Integer.valueOf(rs.getInt("Price"));
				info[count][4] = rs.getString("Owner");
				info[count][5] = rs.getDate("InDate");
				info[count][6] = rs.getDate("OutDate");
				count++;
			}
			// 定义表头
			String[] title = { "ID", "Name", "Storage", "Price", "Owner", "InDate", "OutDate" };
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
		new InsertView(); 
	}
}