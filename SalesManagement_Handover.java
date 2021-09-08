import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class SalesManagement_Handover extends JFrame 
{
	JTextField tf = new JTextField(30);
	JButton[] SBtn = new JButton[2];
	String[] Str = {"저장","뒤로가기"};
	int count =1;
	
	class MainScreen extends JPanel
	{
		MainScreen()
		{
			setLayout(new GridLayout(8,1));
			JPanel FiftyThousandPanel = new JPanel();
			JPanel TenThousandPanel = new JPanel();
			JPanel FiveThousandPanel = new JPanel();
			JPanel OneThousandPanel = new JPanel();
			JPanel FiveHundredPanel = new JPanel();
			JPanel OneHundredPanel = new JPanel();
			JPanel FiftyPanel = new JPanel();
			JPanel tenPanel = new JPanel();
			FiftyThousandPanel.add(new JLabel("50000원"));
			FiftyThousandPanel.add(new JTextField(20));
			TenThousandPanel.add(new JLabel("10000원"));
			TenThousandPanel.add(new JTextField(20));
			FiveThousandPanel.add(new JLabel("5000원"));
			FiveThousandPanel.add(new JTextField(20));
			OneThousandPanel.add(new JLabel("1000원"));
			OneThousandPanel.add(new JTextField(20));
			FiveHundredPanel.add(new JLabel("500원"));
			FiveHundredPanel.add(new JTextField(20));
			OneHundredPanel.add(new JLabel("100원"));
			OneHundredPanel.add(new JTextField(20));
			FiftyPanel.add(new JLabel("50원"));
			FiftyPanel.add(new JTextField(20));
			tenPanel.add(new JLabel("10원"));
			tenPanel.add(new JTextField(20));
			
			add(FiftyThousandPanel);
			add(TenThousandPanel);
			add(FiveThousandPanel);
			add(OneThousandPanel);
			add(FiveHundredPanel);
			add(OneHundredPanel);
			add(FiftyPanel);
			add(tenPanel);
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
	
	public SalesManagement_Handover()
	{
		setTitle("매출 관리");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안정적인 종료를 위함
		setResizable(false); // 정해진 사이즈에서 변경 X
		setBounds(400, 100, 1000, 600); // 프레임의 위치와 크기
		setVisible(true);
		MainScreen mbtn = new MainScreen();
		SelectButton sc = new SelectButton();
		
		//금액란
		tf.setSize(450, 70);
		tf.setLocation(50, 480);
		add(tf);
		
		// 입력창
		mbtn.setSize(700, 450);
		mbtn.setLocation(150, 20);
		add(mbtn);
		
		sc.setSize(400, 70);
		sc.setLocation(530, 480);
		add(sc);
		//저장
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
				new POS_SalesManagement();
			}
		});
	}
}
// 1. 총 판매금액, 2. 인수인계