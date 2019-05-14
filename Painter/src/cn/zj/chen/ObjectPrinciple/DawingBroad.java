package cn.zj.chen.ObjectPrinciple;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DawingBroad implements ItemListener{

	private JFrame frame;
	private Canvas canvas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DawingBroad window = new DawingBroad();
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
	public DawingBroad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = new Canvas();
		frame.getContentPane().add(canvas, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		

		JRadioButton rdbtnLine = new JRadioButton("Line");           //按钮 Line
		rdbtnLine.setSelected(true);
		rdbtnLine.addItemListener(this);
		toolBar.add(rdbtnLine);
		
		JRadioButton rdbtnRectangle = new JRadioButton("Rectangle"); //按钮 Rectangle
		rdbtnRectangle.setSelected(true);
		rdbtnRectangle.addItemListener(this);
		toolBar.add(rdbtnRectangle);
		
		ButtonGroup bg=new ButtonGroup();//选项组
		bg.add(rdbtnLine);
		bg.add(rdbtnRectangle);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.clear();
			}
		});
		toolBar.add(btnClear);
		
		

		
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		JRadioButton rdb;
		JButton jb;
		rdb=(JRadioButton) e.getSource();
		if(rdb.isSelected())
		{
			if(rdb.getText()=="Line"){
			    canvas.setTodoAction(0);
				System.out.println(0);
			}
			else if(rdb.getText()=="Rectangle"){
				canvas.setTodoAction(1);
				System.out.println(1);
			}
				
		}
	}

}
