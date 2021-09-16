import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.*;

public class ProductManagement_ProductRegister extends JFrame 
{
	// Connection�� �����ͺ��̽��� �����ϴ� ��ü�̴�.
	Connection conn = null;
	// ResultSet : ������ �������� ���� �޴� ��ü
	ResultSet rs = null;
	Statement st = null; // �׳� �������°�
	// PreparedStatement�� �������� ?�� ����ؼ� �߰��� ?�� ������ �Ҵ��� �ټ� �ֵ��� �ϴ� ��ü
	PreparedStatement ps = null; // ?�־ ����ִ°�
	String usePos;
	String showProducts;
	JTextField MyName;
	JTextField MyNumber;
	JTextField MyPrice;
	JTextField MyStock;
	JButton[] SBtn = new JButton[2];
	String[] Str = {"����","�ڷΰ���"};
	int count =1;
	
	class MainScreen extends JPanel
	{
		MainScreen()
		{
			try {
				String user = "root";
				String pw = "rlatmddnr48!";
				String url = "jdbc:mysql://127.0.0.1/?useSSL=false&user=root&password=rlatmddnr48!";

				// jdbc drive�� ����ϴ� ����
				// class.forName�� ȣ���ϸ� Driver�� �ڱ��ڽ��� �ʱ�ȭ�Ͽ� DriverManager�� ����Ѵ�.
				// ��, �����ڰ� ���� �������� �ʴ� static ��ü���� �˾Ƽ� DriverManager�� ��ϵǴ� ���̴�.
				// �׷��� Class.forName()�� ȣ���ϰ� ���� � ���ڷε� �������� �ʰ� �ٷ� getConnection()�� ȣ���ص� ����̹��� ã������.
				
				// Driver Class�� �ε��ϸ� ��ü�� �����ǰ�, DriverManager�� ��ϵȴ�.
				Class.forName("com.mysql.cj.jdbc.Driver");
				// connection���� db�� ���� (��ü ����)
				conn = DriverManager.getConnection(url, user, pw);
				st = conn.createStatement();
				usePos = "use POS";
				st.executeUpdate(usePos);
				
				showProducts = "select * from products";
				rs = st.executeQuery(showProducts);

			} catch (ClassNotFoundException cnfe) {
				System.out.println("DB ����̹� �ε� ���� :" + cnfe.toString());
			} catch (SQLException sqle) {
				System.out.println("DB ���ӽ��� : " + sqle.toString());
			} catch (Exception e) {
				System.out.println("Unkonwn error");
				e.printStackTrace();
			}
			
			setLayout(new GridLayout(4,1));
			JPanel ProductName = new JPanel();
			JPanel ProductPrice = new JPanel();
			JPanel ProductIndex = new JPanel();
			JPanel ProductNumber = new JPanel();
			MyName = new JTextField(20);
			MyNumber = new JTextField(20);
			MyPrice = new JTextField(20);
			MyStock = new JTextField(20);
			ProductName.add(new JLabel("�̸�"));
			ProductName.add(MyName);
			ProductNumber.add(new JLabel("��ȣ"));
			ProductNumber.add(MyNumber);
			ProductPrice.add(new JLabel("����"));
			ProductPrice.add(MyPrice);
			ProductIndex.add(new JLabel("���"));
			ProductIndex.add(MyStock);
			
			add(ProductName);
			add(ProductNumber);
			add(ProductPrice);
			add(ProductIndex);
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
	
	public ProductManagement_ProductRegister()
	{
		setTitle("��� ����");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���Ḧ ����
		setResizable(false); // ������ ������� ���� X
		setBounds(400, 100, 1000, 600); // �������� ��ġ�� ũ��
		setVisible(true);
		MainScreen mbtn = new MainScreen();
		SelectButton sc = new SelectButton();

		// �Է�â
		mbtn.setSize(700, 450);
		mbtn.setLocation(150, 20);
		add(mbtn);
		
		sc.setSize(400, 70);
		sc.setLocation(300, 480);
		add(sc);
		// ����
		SBtn[0].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				insertData(MyName.getText(), MyNumber.getText(), MyPrice.getText(), MyStock.getText());
				new POS_MainMenu();
			}
		});
		
		// �ڷΰ���
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
	
	public void insertData(String strName, String strNumber, String nPrice, String nStock) {
		try {
			String sql = "INSERT INTO products(strName, strNumber, nPrice, nStock) values(?, ?, ?, ?)";
			// PrparedStatment��ü ����, ���ڷ� sql���� �־���
			ps = conn.prepareStatement(sql);
			ps.setString(1, strName);
			ps.setString(2, strNumber);
			ps.setInt(3, Integer.parseInt(nPrice));
			ps.setInt(4, Integer.parseInt(nStock));
			// executeUpdate : insert, delete, update�� ���� ���� �޾ƿ��� �ʴ� ������ ����
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}