import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class ProductManagement_ProductDelete extends JFrame 
{
	JButton[] SBtn = new JButton[3];
	String[] Str = {"삭제하기", "뒤로가기"};
	String [] ColName = {"이름","번호","가격", "재고"};
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
	
	class SubScreen extends JPanel
	{
		SubScreen()
		{
			setLayout(new GridLayout(3,1));
			JPanel ProductName = new JPanel();
			JPanel ProductNumber = new JPanel();
			JPanel ProductSearch = new JPanel();

			ProductName.add(new JLabel("이름"));
			ProductName.add(new JTextField(20));
			ProductNumber.add(new JLabel("번호"));
			ProductNumber.add(new JTextField(20));
			ProductSearch.add(new JButton("검색"));
			
			add(ProductName);
			add(ProductNumber);
			add(ProductSearch);
		}
	}
	
	class SelectButton extends JPanel
	{
		SelectButton(){
			setLayout(new GridLayout(1, 2));
			
			for(int i = 0; i < 2; i++) 
			{
				SBtn[i]= new JButton(Str[i]);
				add(SBtn[i]);
			}
		}
	}
	
	public ProductManagement_ProductDelete()
	{
		setTitle("재고 관리");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안정적인 종료를 위함
		setResizable(false); // 정해진 사이즈에서 변경 X
		setBounds(400, 100, 1000, 600); // 프레임의 위치와 크기
		setVisible(true);
		MainScreen mbtn = new MainScreen();
		SubScreen sbtn = new SubScreen();
		SelectButton sc = new SelectButton();
		
		sbtn.setSize(500, 450);
		sbtn.setLocation(500, 30);
		add(sbtn);
		
		mbtn.setSize(500, 450);
		mbtn.setLocation(15, 0);
		add(mbtn);
		
		sc.setSize(400, 70);
		sc.setLocation(300, 480);
		add(sc);
		// 삭제하기
		SBtn[0].addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				new POS_MainMenu();
			}
		});
		
			//뒤로가기
		SBtn[1].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				new POS_ProductManagement();
			}
		});
	}
}