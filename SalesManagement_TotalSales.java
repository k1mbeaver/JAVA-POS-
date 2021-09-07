import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class SalesManagement_TotalSales extends JFrame 
{
	JTextField tf = new JTextField(30);
	JButton[] SBtn = new JButton[2];
	String[] Str = {"세부사항","뒤로가기"};
	String [] ColName = {"번호","결제방법","가격"};
	String [] ColName2 = {"제품", "가격"};
	String [][] Data;
	String [][] Data2;
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);
	DefaultTableModel model2 = new DefaultTableModel(Data2,ColName2);
	JTable table2 = new JTable(model2);
	
	class MainScreen extends JPanel
	{
		MainScreen()
		{
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("맑은고딕", Font.BOLD, 15));
			add(new JScrollPane(table));
		}
	}
	
	class SubScreen extends JPanel
	{
		SubScreen()
		{
				DefaultTableModel m2 = (DefaultTableModel)table2.getModel();
				table2.setRowHeight(50);
				table2.getTableHeader().setFont(new Font("맑은고딕", Font.BOLD, 15));
				add(new JScrollPane(table2));		
		}
	}
	
	class SelectButton extends JPanel{
		SelectButton(){
			setLayout(new GridLayout(1, 2));
			
			for(int i = 0; i < 2; i++) {
				SBtn[i]= new JButton(Str[i]);
				add(SBtn[i]);
			}
		}
	}
	
	public SalesManagement_TotalSales() {
		setTitle("매출 관리");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안정적인 종료를 위함
		setResizable(false); // 정해진 사이즈에서 변경 X
		setBounds(400, 100, 1000, 600); // 프레임의 위치와 크기
		setVisible(true);
		MainScreen mbtn = new MainScreen();
		SubScreen sbtn = new SubScreen();
		SelectButton sc = new SelectButton();
		
		//금액란
		tf.setSize(450, 70);
		tf.setLocation(50, 480);
		add(tf);
		
		sbtn.setSize(500, 450);
		sbtn.setLocation(500, 0);
		add(sbtn);
		
		mbtn.setSize(500, 450);
		mbtn.setLocation(15, 0);
		add(mbtn);
		
		sc.setSize(400, 70);
		sc.setLocation(530, 480);
		add(sc);
		//세부사항
		SBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new POS_MainMenu();
			}
		});
		
			//뒤로가기
		SBtn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new POS_MainMenu();
			}
		});
	}
}
// 1. 총 판매금액, 2. 인수인계