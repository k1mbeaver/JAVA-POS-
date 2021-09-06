import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class POS_MainMenu extends JFrame
{	
	Container mycontainer;
	JButton button_lise[] = new JButton[6]; // �޴� ���� ��ư
	String str_list[] = {"��� ����", "�Ǹ� ó��", "�԰� ó��", "���� ����", "�ٹ��ڰ���", "����"}; // ��ư ���� ����
	JPanel TimePanel = new JPanel();
	JPanel ButtonPanel = new JPanel();

	public POS_MainMenu() {
		setTitle("POS Program");
		setResizable(false); // ������ ������� ���� X
		setBounds(400, 100, 1000, 600); // �������� ��ġ�� ũ��`
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���Ḧ ����
		mycontainer = getContentPane();
		mycontainer.setLayout(new GridLayout(2, 1));
		setMyLabel();
		setButton();
		mycontainer.add(TimePanel);
		mycontainer.add(ButtonPanel);
		setVisible(true); // ���̰�
	}
	
	void setButton()
	{
		ButtonPanel.setLayout(new GridLayout(1, 6));
		for (int nIndex = 0; nIndex < 6; nIndex++)
		{
			button_lise[nIndex] = new JButton(str_list[nIndex]);
			
			if(nIndex == 0) // ��� ����
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
			
			else if(nIndex == 1) // �Ǹ� ó��
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
			
			else if(nIndex == 2) // �԰� ó��
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
			
			else if(nIndex == 3) // ���� ����
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
			
			else if(nIndex == 4) // �ٹ��� ����
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
			
			else if(nIndex == 5) // ����
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
