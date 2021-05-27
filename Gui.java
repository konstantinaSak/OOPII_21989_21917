
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class Gui {
	
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		JFrame f = new JFrame("Preferences"); 
		JPanel p = new JPanel(new GridLayout(7, 8, 10, 10) );
		
		//p.setLayout(new FlowLayout()); 
		
		JLabel label1 = new JLabel("1. Cafe"); 
		JButton a1 = new JButton("0");
		JButton a2 = new JButton("5");
		JButton a3 = new JButton("10");
		p.add(label1);
		p.add(a1);
		p.add(a2);
		p.add(a3);
		
		JLabel label2 = new JLabel("2. Sea"); 
		JButton b1 = new JButton("0");
		JButton b2 = new JButton("5");
		JButton b3 = new JButton("10");
		p.add(label2);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		
		JLabel label3 = new JLabel("3. Museums"); 
		JButton c1 = new JButton("0");
		JButton c2 = new JButton("5");
		JButton c3 = new JButton("10");
		p.add(label3);
		p.add(c1);
		p.add(c2);
		p.add(c3);
		
		JLabel label4 = new JLabel("4. Restaurant"); 
		JButton d1 = new JButton("0");
		JButton d2 = new JButton("5");
		JButton d3 = new JButton("10");
		p.add(label4);
		p.add(d1);
		p.add(d2);
		p.add(d3);
		JLabel label5 = new JLabel("5. Stadium"); 
		JButton e1 = new JButton("0");
		JButton e2 = new JButton("5");
		JButton e3 = new JButton("10");
		p.add(label5);
		p.add(e1);
		p.add(e2);
		p.add(e3);
		JLabel label6 = new JLabel("6. Mountain"); 
		JButton f1 = new JButton("0");
		JButton f2 = new JButton("5");
		JButton f3 = new JButton("10");
		p.add(label6);
		p.add(f1);
		p.add(f2);
		p.add(f3);
		
		JLabel label7 = new JLabel("7. Airplane"); 
		JButton g1 = new JButton("0");
		JButton g2 = new JButton("5");
		JButton g3 = new JButton("10");
		p.add(label7);
		p.add(g1);
		p.add(g2);
		p.add(g3);
		JLabel label8 = new JLabel("8. Desert"); 
		JButton h1 = new JButton("0");
		JButton h2 = new JButton("5");
		JButton h3 = new JButton("10");
		p.add(label8);
		p.add(h1);
		p.add(h2);
		p.add(h3);
		JLabel label9 = new JLabel("9. Sights"); 
		JButton i1 = new JButton("0");
		JButton i2 = new JButton("5");
		JButton i3 = new JButton("10");
		p.add(label9);
		p.add(i1);
		p.add(i2);
		p.add(i3);
		JLabel label10 = new JLabel("10. Camping"); 
		JButton j1 = new JButton("0");
		JButton j2 = new JButton("5");
		JButton j3 = new JButton("10");
		p.add(label10);
		p.add(j1);
		p.add(j2);
		p.add(j3);
		
		JLabel label11 = new JLabel("Insert"); 
		JLabel label12 = new JLabel("your"); 
		JLabel label13 = new JLabel("lotitube"); 
		p.add(label11);
		p.add(label12);
		p.add(label13);
		JTextArea ta= new JTextArea();
		ta.append("");
		p.add(ta);
		
		JLabel label14 = new JLabel("insert"); 
		JLabel label15 = new JLabel("your");
		JLabel label16= new JLabel("latitube"); 
		p.add(label14);
		p.add(label15);
		p.add(label16);
		JTextArea ta2= new JTextArea();
		ta2.append(""); 
     	p.add(ta2);
		
     	JLabel label17 = new JLabel("insert"); 
		JLabel label18 = new JLabel("your");
		JLabel label19= new JLabel("age"); 
		p.add(label17);
		p.add(label18);
		p.add(label19);
		JTextArea ta3= new JTextArea();
		ta3.append(""); 
     	p.add(ta3);
     	
     	JLabel label20 = new JLabel("insert"); 
		JLabel label21 = new JLabel("the");
		JLabel label22= new JLabel("timestamp"); 
		p.add(label20);
		p.add(label21);
		p.add(label22);
		JTextArea ta4= new JTextArea();
		ta4.append(""); 
     	p.add(ta4);
		
		f.setContentPane(p);
		
		
		
		
		
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Closing the frame, it also close the application.
		
		//f.setBounds(120,120,300,300);	//Moves and resizes this component. The new location of the top-left corner is specified by x and y, and the new size is specified by width and height.
		f.setLocation(50, 100);
		f.setSize(800, 400);
		f.isActive();		
		f.setVisible(true);
		
		String[] Names = {"Name of the City", "lat", "lon", "Cafe", "Sea", "Museums", "Restoraunt", "Stadium", "Mountain", "Airplane", "Desert", "Sights", "Camping"};
		Object [][] Data = {{"Rome", "37,9795", "82,5367",  "1","5","8","9","3","3","6","5","1","0"},
				{"Athens", "26,5467", "21,9786", "1","5","8","9","3","3","9","8","6","1"},
				{"Corfu", "78,5435", "15,7868", "5","1","3","5","9","10","6","0","8","0"},
				{"Berlin", "27,2567" , "39,7699", "5","1","9","6","3","5","7","5","10","0"},
				{"Paris", "21,1789", "15,367", "5","2","7","5","3","3","0","5","8","1"},
				{"Thessoloniki", "67,3678", "25,1567", "5","1","8","5","6","3","7","5","9","0"},
		};
		
			JFrame fr = new JFrame("Data");
			//JPanel panel = new JPanel();
			DefaultTableModel dtm = new DefaultTableModel(Data,Names);
			JTable table = new JTable(dtm);
			JScrollPane scroll = new JScrollPane();
			scroll.getViewport().add(table);
			fr.getContentPane().add(scroll);
			fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Closing the frame, it also close the application.
			
			
			fr.setLocation(50, 100);
			fr.setSize(800, 400);
			fr.isActive();		
			fr.setVisible(true);
			
			String [] Trav = {"Name", "age", "timestamp", "visit"};
			Object[][] Data2 = {{"1st", "25", "13,2789", "athens"}, {"2nd", "18", "27,9878", "corfu"}, 
					{"3rd", "27", "30,5678", "rome"}};
			
			
			JFrame fr2 = new JFrame("Sort");
			//JPanel panel = new JPanel();
			DefaultTableModel dtm2 = new DefaultTableModel(Data2, Trav);
			JTable table2 = new JTable(dtm2);
			JScrollPane scroll2 = new JScrollPane();
			scroll2.getViewport().add(table2);
			fr2.getContentPane().add(scroll2);
			fr2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Closing the frame, it also close the application.
			
			
			fr2.setLocation(50, 100);
			fr2.setSize(800, 400);
			fr2.isActive();		
			fr2.setVisible(true);
			}		
		



	}


