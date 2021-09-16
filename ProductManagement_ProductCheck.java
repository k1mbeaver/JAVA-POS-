import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

public class ProductManagement_ProductCheck extends JFrame 
{
	// Connection은 데이터베이스와 연결하는 객체이다.
	Connection conn = null;
	// ResultSet : 실행한 쿼리문의 값을 받는 객체
	ResultSet rs = null;
	Statement st = null; // 그냥 가져오는거
	// PreparedStatement는 쿼리문에 ?를 사용해서 추가로 ?에 변수를 할당해 줄수 있도록 하는 객체
	PreparedStatement ps = null; // ?넣어서 집어넣는거
	String usePos;
	String showProducts;
	JButton[] SBtn = new JButton[1];
	String[] Str = {"뒤로가기"};
	String [] ColName = {"이름","번호","가격", "재고"};
	String [][] Data;
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);
	
	class MainScreen extends JPanel
	{
		MainScreen()
		{
			try {
				String user = "root";
				String pw = "rlatmddnr48!";
				String url = "jdbc:mysql://127.0.0.1/?useSSL=false&user=root&password=rlatmddnr48!";

				// jdbc drive를 등록하는 과정
				// class.forName을 호출하면 Driver가 자기자신을 초기화하여 DriverManager에 등록한다.
				// 즉, 개발자가 따로 관리하지 않는 static 객체들이 알아서 DriverManager에 등록되는 것이다.
				// 그래서 Class.forName()을 호출하고 나서 어떤 인자로도 전달하지 않고 바로 getConnection()을 호출해도 드라이버가 찾아진다.
				
				// Driver Class를 로딩하면 객체가 생성되고, DriverManager에 등록된다.
				Class.forName("com.mysql.cj.jdbc.Driver");
				// connection으로 db와 연결 (객체 생성)
				conn = DriverManager.getConnection(url, user, pw);
				st = conn.createStatement();
				usePos = "use POS";
				st.executeUpdate(usePos);
				
				showProducts = "select * from products";
				rs = st.executeQuery(showProducts);
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				table.setRowHeight(50);
				table.getTableHeader().setFont(new Font("맑은고딕", Font.BOLD, 15));
				add(new JScrollPane(table));
				while(rs.next())
				{
					m.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)});
				}

			} catch (ClassNotFoundException cnfe) {
				System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
			} catch (SQLException sqle) {
				System.out.println("DB 접속실패 : " + sqle.toString());
			} catch (Exception e) {
				System.out.println("Unkonwn error");
				e.printStackTrace();
			}
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
	
	class SelectButton extends JPanel{
		SelectButton(){
			setLayout(new GridLayout());

			SBtn[0]= new JButton(Str[0]);
			add(SBtn[0]);

		}
	}
	
	public ProductManagement_ProductCheck() {
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
		// 뒤로 가기
		SBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new POS_ProductManagement();
			}
		});

	}
}