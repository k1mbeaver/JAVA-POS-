import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class POS_EnterProcess extends JFrame {
	JTextField tf = new JTextField(30);
	JButton[] SBtn = new JButton[2];
	String[] Str = {"입고처리","뒤로가기"};
	String [] ColName = {"이름","수량","가격"};
	String [][] Data ;
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);
	
	class Screen extends JPanel{
		Screen(){
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("맑은고딕", Font.BOLD, 15));
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
		setTitle("판매 처리");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 안정적인 종료를 위함
		setResizable(false); // 정해진 사이즈에서 변경 X
		setBounds(400, 100, 1000, 600); // 프레임의 위치와 크기
		setVisible(true);
		StrBtn sbtn = new StrBtn();
		Screen sc = new Screen();
		
		sc.setSize(500, 450);
		sc.setLocation(250, 0);
		add(sc);

		sbtn.setSize(400, 70);
		sbtn.setLocation(300, 480);
		add(sbtn);
		
		// 입고 처리
		SBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
			//뒤로 가기
		SBtn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new POS_MainMenu();
			}
		});

	}
}

// 1. 현재 재고 상황 ->(한 상품 더블 클릭 시) -> 해당 상품 입고 처리 안내문