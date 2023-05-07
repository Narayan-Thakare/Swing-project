import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

import com.mysql.cj.xdevapi.Statement;
public class Project1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		JFrame frame =new JFrame("STUDENT INFO");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDB1","root","abc123");

	JLabel roll=new JLabel("ACC NO. :");
	roll.setBounds(117,50,150,47);
	roll.setFont(new Font("Algerian",Font.BOLD,18));
	JTextField tx1=new JTextField();
	tx1.setBounds(200,50,150,45);
	tx1.setFont(new Font("Book Antiqua",Font.BOLD,18));
	///////////////////////////////////
	
	JLabel name=new JLabel("NAME  :");
	name.setBounds(117,100,150,46);
	name.setFont(new Font("Algerian",Font.BOLD,18));
	
	JTextField tx2=new JTextField();
	tx2.setBounds(200,100,150,45);
	tx2.setFont(new Font("Book Antiqua",Font.BOLD,18));	
	////////////////////////////////////	
		
	JLabel adress=new JLabel("ADRESS :");
	adress.setBounds(117,150,150,46);
	adress.setFont(new Font("Algerian",Font.BOLD,18));
		
	JTextField tx3=new JTextField();
	tx3.setBounds(200,150,150,45);
	tx3.setFont(new Font("Book Antiqua",Font.BOLD,18));
	
	////////////////////////////////////////
		
		
		JButton show=new JButton("SHOW INFO");
		show.setBounds(180,200,200,40);
	   show.setFont(new Font("Algerian",Font.BOLD,18));
		JLabel sho=new JLabel();
		sho.setBounds(180,250,200,46);
		 sho.setFont(new Font("Algerian",Font.BOLD,18));
		
		
		////////////////////////////////////
		
			  
			
	  show.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			int a=0;
			int roll=Integer.parseInt(tx1.getText());
			
			String name=tx2.getText();
			String adress=tx3.getText();
			
			sho.setText("INFO:"+roll+" "+name+" "+adress);
			
			
//			info.setText("ROLL AND NAME = "+n+" "+t);
			PreparedStatement stmt;
			try {
				stmt = con.prepareStatement("INSERT INTO StudentDB1.Swing VALUES(?,?,?)");
				stmt.setInt(1, roll);
				stmt.setString(2, name);
				stmt.setString(3, adress);
				
				a = stmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(a>0)
			{
				System.out.println("data inserted successfully!\n\n");
			}
			else
			{
				System.out.println("data is not inserted :(");
			}
		}}); 
	  
		JLabel delete=new JLabel(" Delete ROLL :");
		delete.setBounds(117,350,150,47);
		
		JTextField tx4=new JTextField();
		tx4.setBounds(200,350,150,45);
		
		
		JButton del=new JButton("Confirm deleted");
		del.setBounds(180,400,200,40);
		
		JLabel del1=new JLabel();
		del1.setBounds(180,450,200,46);
		
		
		 del.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
				
					int a=0;
					int roll=Integer.parseInt(tx4.getText());
					
										
					del1.setText("INFO:"+roll);
					
					
//					info.setText("ROLL AND NAME = "+n+" "+t);
					PreparedStatement stmt;
					try {
						 stmt = con.prepareStatement("DELETE FROM StudentDB1.swing WHERE roll  = ?");
						System.out.println("\nStatement created");
							stmt.setInt(1, roll);
						
						a = stmt.executeUpdate();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					if(a>0)
					{
						System.out.println("data deleted successfully!\n\n");
					}
					else
					{
						System.out.println("data is not inserted :(");
					}
				}}); 

			JLabel update=new JLabel(" Upadate roll :");
			update.setBounds(100,550,150,47);
			
			JTextField tx5=new JTextField();
			tx5.setBounds(200,550,150,45);
			
			JLabel name1=new JLabel(" NAME :");
			name1.setBounds(117,600,150,47);
			
			JTextField tx6=new JTextField();
			tx6.setBounds(200,600,150,45);

			JLabel adress1=new JLabel(" adress :");
			adress1.setBounds(117,650,150,47);
			
			JTextField tx7=new JTextField();
			tx7.setBounds(200,650,150,45);

			
			JButton up=new JButton("Confirm update");
			up.setBounds(180,700,200,40);
			
		JLabel up1=new JLabel();
			up1.setBounds(180,750,200,46);
			
			
			 up.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
					
						int a=0;
						int roll=Integer.parseInt(tx5.getText());
						String name1=tx6.getText();
						String adress1=tx7.getText();
											
						up1.setText("INFO:"+roll+" "+name1+" "+adress1 );
						
					
						PreparedStatement stmt;
						try {
//							stmt = con.prepareStatement("INSERT INTO StudentDB1.Swing VALUES(?,?,?)");
//							stmt.setInt(1, roll);
//							stmt.setString(2, name1);
//							stmt.setString(3, adress1);

							stmt = con.prepareStatement("UPDATE StudentDB1.swing SET name=?, address=? WHERE roll = ?");
							System.out.println("\nStatement created");
							stmt.setString(1, name1);
							stmt.setString(2, adress1);
							stmt.setInt(3, roll);
							
							a = stmt.executeUpdate();
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						if(a>0)
						{
							System.out.println("data updated successfully!\n\n");
						}
						else
						{
							System.out.println("data is not update:(");
						}
					}}); 
			 
		  
			 
			 
			 
			 JFrame frame2 = new JFrame("Student Management System");
				
				frame2.getContentPane().setLayout(null);

				DefaultListModel model = new DefaultListModel();
				java.sql.Statement stmt = null;

				try {
				stmt =  con.createStatement();
				String sql = "SELECT * FROM  StudentDB1.swing";

				ResultSet rs =  stmt.executeQuery(sql);

				while((rs!=null) && (rs.next()))
				            {
				model.addElement(rs.getInt("roll") + " - " + rs.getString("name")+ " - " + rs.getString("address"));
				            }

				//rs.close();

				} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage());
				e.printStackTrace();
				}

				
				
				final JLabel lblResult = new JLabel("Result:");
				lblResult.setHorizontalAlignment(SwingConstants.CENTER);
				lblResult.setBounds(180,750,200,70);
				frame.getContentPane().add(lblResult);
				   
				   // Scroll Pane
				   JScrollPane scrollPane = new JScrollPane();
				   
				   final JList list = new JList(model);
				   list.addMouseListener(new MouseAdapter() {
				       public void mouseClicked(MouseEvent evt) {
				           lblResult.setText(list.getSelectedValue().toString());
				       }
				   });
				   scrollPane.setViewportView(list);
				   scrollPane.setBounds(180,800,200,70);
				   frame.getContentPane().add(scrollPane);
				   frame.setSize(1100, 400);
				
				   
	    frame.add(tx1);
	    frame.add(tx2);
	    frame.add(tx3); 
	    frame.add(tx4);
	    frame.add(tx6);
	    frame.add(tx7);
	    frame.add(name1); 
	    frame.add(adress1);
	    frame.add(tx5);
	    frame.add(update);
	    frame.add(up); 
	    frame.add(up1); 
	    frame.add(delete); 
	    frame.add(del); 
	    frame.add(del1); 
		frame.add(roll);
		frame.add(name);
		frame.add(adress);
		frame.add(show);
		frame.add(sho);
		frame.setSize(500,1200);
		frame.setLayout(null);
		frame.setVisible(true);

	}

}
