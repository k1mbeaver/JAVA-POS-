import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class POS_MainMenu extends JFrame
{	
	Container mycontainer;
	JButton button_lise[] = new JButton[6]; // 메뉴 선택 버튼
	String str_list[] = {"재고 관리", "판매 처리", "입고 처리", "매출 관리", "근무자관리", "종료"}; // 버튼 내용 종류
	JPanel TimePanel = new JPanel();
	JPanel ButtonPanel = new JPanel();

	public POS_MainMenu() {
		setTitle("POS Program");
		setResizable(false); // 정해진 사이즈에서 변경 X
		setBounds(400, 100, 1000, 600); // 프레임의 위치와 크기`
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안정적인 종료를 위함
		mycontainer = getContentPane();
		mycontainer.setLayout(new GridLayout(2, 1));
		setMyLabel();
		setButton();
		mycontainer.add(TimePanel);
		mycontainer.add(ButtonPanel);
		setVisible(true); // 보이게
	}
	
	void setButton()
	{
		ButtonPanel.setLayout(new GridLayout(1, 6));
		for (int nIndex = 0; nIndex < 6; nIndex++)
		{
			button_lise[nIndex] = new JButton(str_list[nIndex]);
			
			if(nIndex == 0) // 재고 관리
			{
				JButton mybutton = button_lise[nIndex];
				mybutton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);
						new POS_ProductManagement();
					}
				});
			}
			
			else if(nIndex == 1) // 판매 처리
			{
				JButton mybutton = button_lise[nIndex];
				mybutton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);
						new POS_SellProcess();
					}
				});
			}
			
			else if(nIndex == 2) // 입고 처리
			{
				JButton mybutton = button_lise[nIndex];
				mybutton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);
						new POS_EnterProcess();
					}
				});
			}
			
			else if(nIndex == 3) // 매출 관리
			{
				JButton mybutton = button_lise[nIndex];
				mybutton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);
						new POS_SalesManagement();
					}
				});
			}
			
			else if(nIndex == 4) // 근무자 관리
			{
				JButton mybutton = button_lise[nIndex];
				mybutton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						setVisible(false);
						new POS_StaffManagement();
					}
				});
			}
			
			else if(nIndex == 5) // 종료
			{
				
			}
			
			ButtonPanel.add(button_lise[nIndex]);
		}
	}
	
	void setMyLabel()
	{
		TimePanel.setLayout(new FlowLayout());
		TimePanel.setBackground(Color.black);
		TimePanel.add(new JLabel("POS Program"));
	}
}
