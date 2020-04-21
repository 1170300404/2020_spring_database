package gui_database;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mysql.Connect;

public class gui{

	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_7;
	private static JTextField textField_8;
	private static JTextField textField_5;
	private static JTextArea textArea;
	private static JTextArea textArea_1;
	private static JTable table;
	private static JScrollPane scrollPane;
	private static JComboBox<String> comboBox;
	private static String sql = "select * from student";
	
	public static void main(String[] args) {
		Connect connect = new Connect("jin", "jfy3344520");
		
		JFrame frame = new JFrame();
		frame.setTitle("\u5B66\u751F\u4FE1\u606F\u67E5\u8BE2");
		frame.setVisible(true);
		frame.setSize(536, 514);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JCheckBox checkBox = new JCheckBox("\u5B66\u53F7");
		checkBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkBox.isSelected() && textField_2.getText().length()>0) {
					sql_add("sid", textField_2.getText());
					showSql();
				}
				else {
					sql_remove("sid");
					showSql();
				}
			}
		});
		checkBox.setBounds(18, 20, 57, 27);
		checkBox.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.getContentPane().add(checkBox);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(checkBox.isSelected() && textField_2.getText().length()>0) {
					sql_remove("sid");
					sql_add("sid", textField_2.getText());
					showSql();
				}
				else {
					sql_remove("sid");
					showSql();
				}
			}
		});
		textField_2.setBounds(81, 20, 117, 27);
		textField_2.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JCheckBox checkBox_1 = new JCheckBox("\u59D3\u540D");
		checkBox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkBox_1.isSelected() && textField_3.getText().length()>0) {
					sql_add("sname", textField_3.getText());
					showSql();
				}
				else {
					sql_remove("sname");
					showSql();
				}
			}
		});
		checkBox_1.setBounds(18, 58, 57, 27);
		checkBox_1.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.getContentPane().add(checkBox_1);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(checkBox_1.isSelected() && textField_3.getText().length()>0) {
					sql_remove("sname");
					sql_add("sname", textField_3.getText());
					showSql();
				}
				else {
					sql_remove("sname");
					showSql();
				}
			}
		});
		textField_3.setBounds(81, 57, 117, 28);
		textField_3.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_3.setColumns(10);
		frame.getContentPane().add(textField_3);
		
		JCheckBox checkBox_1_1 = new JCheckBox("\u5E74\u9F84\u81EA");
		checkBox_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkBox_1_1.isSelected()) {
					sql_add_age(textField_4.getText(), textField_5.getText());
					showSql();
				}
				else {
					sql_remove("sage");
					showSql();
				}
			}
		});
		checkBox_1_1.setBounds(18, 97, 73, 27);
		checkBox_1_1.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.getContentPane().add(checkBox_1_1);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(checkBox_1_1.isSelected()) {
					sql_remove("sage");
					sql_add_age(textField_4.getText(), textField_5.getText());
					showSql();
				}
				else {
					sql_remove("sage");
					showSql();
				}
			}
		});
		textField_4.setBounds(91, 97, 37, 27);
		textField_4.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_4.setColumns(10);
		frame.getContentPane().add(textField_4);
		
		JLabel label = new JLabel("\u5230");
		label.setBounds(138, 97, 20, 27);
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.getContentPane().add(label);
		label.setVisible(true);
		
		JCheckBox checkBox_1_2 = new JCheckBox("\u6027\u522B");
		checkBox_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkBox_1_2.isSelected()) {
					sql_add("ssex", comboBox.getSelectedItem().toString());
					showSql();
				}
				else {
					sql_remove("ssex");
					showSql();
				}
			}
		});
		checkBox_1_2.setBounds(18, 136, 99, 27);
		checkBox_1_2.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.getContentPane().add(checkBox_1_2);
		
		JCheckBox checkBox_1_3 = new JCheckBox("\u73ED\u7EA7");
		checkBox_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkBox_1_3.isSelected() && textField_7.getText().length()>0) {
					sql_add("sclass", textField_7.getText());
					showSql();
				}
				else {
					sql_remove("sclass");
					showSql();
				}
			}
		});
		checkBox_1_3.setBounds(220, 21, 57, 27);
		checkBox_1_3.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.getContentPane().add(checkBox_1_3);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(checkBox_1_3.isSelected() && textField_7.getText().length()>0) {
					sql_remove("sclass");
					sql_add("sclass", textField_7.getText());
					showSql();
				}
				else {
					sql_remove("sclass");
					showSql();
				}
			}
		});
		textField_7.setBounds(283, 20, 117, 28);
		textField_7.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_7.setColumns(10);
		frame.getContentPane().add(textField_7);
		
		JCheckBox checkBox_1_4 = new JCheckBox("\u7CFB\u522B");
		checkBox_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkBox_1_4.isSelected() && textField_8.getText().length()>0) {
					sql_add("sdept", textField_8.getText());
					showSql();
				}
				else {
					sql_remove("sdept");
					showSql();
				}
			}
		});
		checkBox_1_4.setBounds(220, 59, 57, 27);
		checkBox_1_4.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.getContentPane().add(checkBox_1_4);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(checkBox_1_4.isSelected() && textField_8.getText().length()>0) {
					sql_remove("sdept");
					sql_add("sdept", textField_8.getText());
					showSql();
				}
				else {
					sql_remove("sdept");
					showSql();
				}
			}
		});
		textField_8.setBounds(283, 59, 117, 27);
		textField_8.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_8.setColumns(10);
		frame.getContentPane().add(textField_8);
		
		JCheckBox checkBox_1_5 = new JCheckBox("\u5730\u5740");
		checkBox_1_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(checkBox_1_5.isSelected() && textArea.getText().length()>0) {
					sql_add("saddr", textArea.getText());
					showSql();
				}
				else {
					sql_remove("saddr");
					showSql();
				}
			}
		});
		checkBox_1_5.setBounds(220, 98, 58, 27);
		checkBox_1_5.setFont(new Font("宋体", Font.PLAIN, 16));
		frame.getContentPane().add(checkBox_1_5);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[][] result = connect.query(sql);
				showResult(result);
			}
		});
		button.setBounds(421, 21, 90, 143);
		button.setFont(new Font("黑体", Font.PLAIN, 20));
		frame.getContentPane().add(button);
		
		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			@Override
      public void actionPerformed(ActionEvent e) {
				if(checkBox_1_2.isSelected()) {
					sql_remove("ssex");
					sql_add("ssex", comboBox.getSelectedItem().toString());
					showSql();
				}
				else {
					sql_remove("ssex");
					showSql();
				}
			}
		});
		comboBox.setBounds(81, 134, 117, 27);
		comboBox.setFont(new Font("宋体", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"\u7537", "\u5973"}));
		frame.getContentPane().add(comboBox);
		
		textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(checkBox_1_5.isSelected() && textArea.getText().length()>0) {
					sql_remove("saddr");
					sql_add("saddr", textArea.getText());
					showSql();
				}
				else {
					sql_remove("saddr");
					showSql();
				}
			}
		});
		textArea.setBounds(283, 99, 117, 63);
		textArea.setFont(new Font("宋体", Font.PLAIN, 16));
		textArea.setLineWrap(true);
		frame.getContentPane().add(textArea);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(checkBox_1_1.isSelected()) {
					sql_remove("sage");
					sql_add_age(textField_4.getText(), textField_5.getText());
					showSql();
				}
				else {
					sql_remove("sage");
					showSql();
				}
			}
		});
		textField_5.setBounds(161, 97, 37, 27);
		textField_5.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_5.setColumns(10);
		frame.getContentPane().add(textField_5);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 278, 497, 190);
		frame.getContentPane().add(scrollPane);
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		textArea_1.setEditable(false);
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(14, 183, 497, 80);
		textArea_1.setVisible(true);
		frame.getContentPane().add(textArea_1);
		
		showSql();
	}
	
	public static void showResult(String[][] result) {
		String[] titles = new String[] {"Sid", "Sname", "Sage", "Ssex", "Sclass", "Sdept", "Saddr"};
		table = new JTable();
		table.setModel(new DefaultTableModel(result, titles) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			@Override
      public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setFont(new Font("宋体", Font.PLAIN, 13));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
	}
	
	public static void showSql() {
		textArea_1.setText(sql);
	}
	
	public static void sql_add(String tag, String text) {
		String regex = "^.*where.*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(sql);
		if(matcher.find()) {
			regex = "^.*[%_].*$";
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(text);
			if(matcher.find()) {
				sql = sql + " and " + tag + " like '" + text + "'";
			} else {
				sql = sql + " and " + tag + " = '" + text + "'";				
			}
		}
		else {
			regex = "^.*[%_].*$";
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(text);
			if(matcher.find()) {
				sql = sql + " where " + tag + " like '" + text + "'";
			} else {
				sql = sql + " where " + tag + " = '" + text + "'";				
			}
		}
	}
	
	public static void sql_remove(String tag) {
		if(tag.equalsIgnoreCase("sage")) {
			String regex = "^(.*where.*)\\s" + tag + ".*?and(.*)$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(sql);
			if(matcher.find()) {
		        sql = matcher.group(1) + matcher.group(2);
			}
			else {
				regex = "^(.*where.*)\\sand\\s" + tag + ".*$";
				pattern = Pattern.compile(regex);
				matcher = pattern.matcher(sql);
				if(matcher.find()) {
					sql = matcher.group(1);
				}
				else {
					regex = "^(.*)\\swhere\\s" + tag + ".*$";
					pattern = Pattern.compile(regex);
					matcher = pattern.matcher(sql);
					if(matcher.find()) {
						sql = matcher.group(1);
					}
				}
			}
		}
		String regex = "^(.*where.*)\\s" + tag + ".*?and(.*)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(sql);
		if(matcher.find()) {
	        sql = matcher.group(1) + matcher.group(2);
		}
		else {
			regex = "^(.*where.*)\\sand\\s" + tag + ".*$";
			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(sql);
			if(matcher.find()) {
				sql = matcher.group(1);
			}
			else {
				regex = "^(.*)\\swhere\\s" + tag + ".*$";
				pattern = Pattern.compile(regex);
				matcher = pattern.matcher(sql);
				if(matcher.find()) {
					sql = matcher.group(1);
				}
			}
		}
	}
	
	public static void sql_add_age(String age1, String age2) {
		String tag = "sage";
		String regex = "^.*where.*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(sql);
		if(matcher.find()) {
			if(age1.length()>0 && age2.length()>0) {
				sql = sql + " and " + tag + " >= " + age1 + " and " + tag + " <= " + age2;								
			}
			else if(age1.length()>0 && age2.length()==0) {
				sql = sql + " and " + tag + " >= " + age1;	
			}
			else if(age1.length()==0 && age2.length()>0) {
				sql = sql + " and " + tag + " <= " + age2;	
			}
		}
		else {
			if(age1.length()>0 && age2.length()>0) {
				sql = sql + " where " + tag + " >= " + age1 + " and " + tag + " <= " + age2;								
			}
			else if(age1.length()>0 && age2.length()==0) {
				sql = sql + " where " + tag + " >= " + age1;	
			}
			else if(age1.length()==0 && age2.length()>0) {
				sql = sql + " where " + tag + " <= " + age2;	
			}			
		}
	}
	
}