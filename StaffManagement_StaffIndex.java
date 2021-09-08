import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class StaffManagement_StaffIndex extends JFrame 
{
	JTextField tf = new JTextField(30);
	JButton[] SBtn = new JButton[2];
	String[] Str = {"뒤로가기"};
	String [] ColName = {"이름", "나이", "성별", "시간대"};
	String [][] Data;
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);
	
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
	
	
	class SelectButton extends JPanel
	{
		SelectButton()
		{
			setLayout(new GridLayout(1, 2));
			
			SBtn[0]= new JButton(Str[0]);
			add(SBtn[0]);
		}
	}
	
	public StaffManagement_StaffIndex() 
	{
		setTitle("근무자 관리");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안정적인 종료를 위함
		setResizable(false); // 정해진 사이즈에서 변경 X
		setBounds(400, 100, 1000, 600); // 프레임의 위치와 크기
		setVisible(true);
		MainScreen mbtn = new MainScreen();
		SelectButton sc = new SelectButton();
		
		mbtn.setSize(1000, 450);
		mbtn.setLocation(15, 0);
		add(mbtn);
		
		sc.setSize(400, 70);
		sc.setLocation(315, 480);
		add(sc);
		//세부사항
		SBtn[0].addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				new POS_StaffManagement();
			}
		});
	}
}