import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ProductManagement_ProductRegister extends JFrame
{
	Container mycontainer;
	JButton button_lise[] = new JButton[2];
	String str_list[] = {"뒤로 가기", "등록"};
	JPanel ButtonPanel = new JPanel();
	JPanel RegisterPanel = new JPanel();
	
	public ProductManagement_ProductRegister() 
	{
		setTitle("재고 관리");
		setResizable(false); // 정해진 사이즈에서 변경 X
		setBounds(400, 100, 1000, 600); // 프레임의 위치와 크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안정적인 종료를 위함
		mycontainer = getContentPane();
		mycontainer.setLayout(new GridLayout(2, 1));
		setButton();
		setRegisterPanel();
		mycontainer.add(RegisterPanel);
		mycontainer.add(ButtonPanel);
		setVisible(true);
	}

	void setButton()
	{
		ButtonPanel.setLayout(new FlowLayout());
		for (int nIndex = 0; nIndex < 2; nIndex++)
		{
			button_lise[nIndex] = new JButton(str_list[nIndex]);
			
			if(nIndex == 0) // 뒤로 가기
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
			/*
			else if(nIndex == 1) // 등록
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
			*/
			ButtonPanel.add(button_lise[nIndex]);
		}
	}

	void setRegisterPanel()
	{
		RegisterPanel.setLayout(new GridLayout(4,1));
		JPanel NamePanel = new JPanel();
		JPanel NumberPanel = new JPanel();
		JPanel PricePanel = new JPanel();
		JPanel ProductPanel = new JPanel();
		NamePanel.add(new JLabel("이름 "));
		NamePanel.add(new JTextField(20));
		NumberPanel.add(new JLabel("번호 "));
		NumberPanel.add(new JTextField(20));
		PricePanel.add(new JLabel("가격 "));
		PricePanel.add(new JTextField(20));
		ProductPanel.add(new JLabel("재고 "));
		ProductPanel.add(new JTextField(20));
		RegisterPanel.add(NamePanel);
		RegisterPanel.add(NumberPanel);
		RegisterPanel.add(PricePanel);
		RegisterPanel.add(ProductPanel);
	}
	

}