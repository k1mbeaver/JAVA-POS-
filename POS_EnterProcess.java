import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class POS_EnterProcess extends JFrame {
	JTextField tf = new JTextField(30);
	JButton[] SBtn = new JButton[2];
	String[] Str = {"�԰�ó��","�ڷΰ���"};
	String [] ColName = {"�̸�","����","����"};
	String [][] Data ;
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);
	
	class Screen extends JPanel{
		Screen(){
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("�������", Font.BOLD, 15));
			add(new JScrollPane(table));
		}
	}	
	
	class StrBtn extends JPanel{
		StrBtn(){
			setLayout(new GridLayout(1, 2));
			
			for(int i = 0; i < 2; i++) {
				SBtn[i]= new JButton(Str[i]);
				add(SBtn[i]);
			}
		}
	}
	
	public POS_EnterProcess() {
		setTitle("�Ǹ� ó��");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���Ḧ ����
		setResizable(false); // ������ ������� ���� X
		setBounds(400, 100, 1000, 600); // �������� ��ġ�� ũ��
		setVisible(true);
		StrBtn sbtn = new StrBtn();
		Screen sc = new Screen();
		
		sc.setSize(500, 450);
		sc.setLocation(250, 0);
		add(sc);

		sbtn.setSize(400, 70);
		sbtn.setLocation(300, 480);
		add(sbtn);
		
		// �԰� ó��
		SBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
			//�ڷ� ����
		SBtn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new POS_MainMenu();
			}
		});

	}
}

// 1. ���� ��� ��Ȳ ->(�� ��ǰ ���� Ŭ�� ��) -> �ش� ��ǰ �԰� ó�� �ȳ���