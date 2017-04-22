import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
 
public class gui extends JPanel{
	private JButton jcomp1;
	private JButton jcomp2;
	private JButton jcomp3;
	private JButton jcomp4;
	private JButton jcomp5;
	private JButton jcomp7;
	private JButton step4;
	//private JButton btn5;
	Object[][] obj;
	Object[][] obj2;
	Object[][] obj3;
	Object[][] obj4;
	Object[] columnobj;
	JComboBox[][] jcb;
	// Step 1
	private JLabel jcomp6;
	private JTextArea jcomp8;
	private JButton jcomp9;
	private JButton checkformat;
	private JScrollPane jcomp10;
	private JTextArea jcomp11;
	private JTextArea jcomp19_3;
	private JTextArea jcomp19_4;	
	private JScrollPane scrollPane;
	private JButton btnCompButton;
	private JLabel complabel;
	
	// Step 2
	private JLabel s1lab1;
	private JLabel s1lab2;
	private JLabel s1lab3;
	private JLabel jcomp191;
	private JLabel jcomp19_1;
	private JLabel jcomp19_2;
	private JButton proceed2;
	private JLabel timerlabel;
	private JLabel timertext;
	private JLabel timerlabel2;
	private JLabel timertext2;
	private JButton oklabel;
	private JScrollPane scrollPanepanel ;
	//private JScrollPane scrollPane2;
	//private JTable table;
	private JPanel panel;
	//Step 2-1
	private JTable table2;
	private JLabel loop;
	private JLabel loop2_1;
	private JScrollPane scrollPane3;
	private JButton okbutton;
	private JButton proceed21 ;
	// Step 2-2
	private JLabel loop2_2;
	private JButton proceed3;
	private JLabel scenariotime;
	private JLabel scenariono; 
	private JTable table3;
	private JScrollPane scrollPane4;
	// Step 3
	private JLabel loop2;
	//Step  4
	private JScrollPane scrollPanepanel2;
	private JPanel panel2;
	private JButton proceed4;
	//Step 5
	private JLabel step4title;
	private JPanel step4panel;
	private JScrollPane step4scrollPanepanel;
	//Other
	private int Step4Total = 0;
	private int atomiccomp[] = {0,0};
	private File file;
	private JTextArea jcomp12;
	static int cout=0;
	static String sg[]=new String[1000];
	String pc[]=new String[1000];
	int count=0;
	int countcol=0;
	long scenariogentime;
	long usecasegentime;
	String sloop[]=new String[100];
	int cloop=0;
	String gnrits[]=new String[1000];
	int cout11=0;
	private JButton jcomp19;
	static String scen[]=new String[1000];
	static int csc=0;
	String vst[][]=new String[100][3];
	File f ;
	Node startNode;
	ArrayList<Table1> table1array ;
	ArrayList<Table2> table2array ;
	ArrayList<Integer> table3array;
	ArrayList<ArrayList<String>> doorarray = new ArrayList<ArrayList<String>>();
	
	//JTextArea table2text = new JTextArea();
	ArrayList<Integer> whileSet;
	ArrayList<Integer> relation = new ArrayList<Integer>();
	ArrayList<Integer> tlpkount = new ArrayList<Integer>();
	ArrayList<String> scenarioList = new ArrayList<String>();
	ArrayList<String> scenarioListA = new ArrayList<String>();
	//ArrayList<String> atomicList1 = new ArrayList<String>();
	ArrayList<ArrayList<String>> atomicList = new ArrayList<ArrayList<String>>();
	//ArrayList<String> compoList1 = new ArrayList<String>();
	ArrayList<ArrayList<String>> compoList = new ArrayList<ArrayList<String>>();
	LineFile l1 = new LineFile();
	//String test11= JOptionPane.showInputDialog("Enter directory containing files");
	//File folder = new File(test11);
	//File[] listOfFiles = folder.listFiles();
	//JComboBox[][] jcb=new JComboBox[1000][listOfFiles.length];
	//private JTextArea jcomp13=new JTextArea();
	//private JTextArea jcomp14=new JTextArea();
	//private JTextArea jcomp15=new JTextArea();   
	public gui(){
	    jcomp2 = new JButton ("Step-I");
	    jcomp3 = new JButton ("Step-II-a");
	    jcomp4 = new JButton ("Step-II-b");
	    jcomp5 = new JButton ("Step-III");
	    step4 = new JButton("Step-IV");
	    //btn5 = new JButton("Step-V");
	    jcomp1 = new JButton ("Home");
	    jcomp7 = new JButton ("Browse");
	    jcomp6 = new JLabel ("Select Use-Case Description File");
	    jcomp8 = new JTextArea();
	    jcomp10 = new JScrollPane(jcomp8);
	    jcomp9 = new JButton("Proceed");
	    jcomp11=new JTextArea();
	    jcomp12=new JTextArea();
	    scrollPane = new JScrollPane(jcomp8);
	    jcomp19=new JButton("Proceed to 1.b");
	    checkformat = new JButton("Check Format");
	    setPreferredSize (new Dimension (1000, 700));
	    setLayout (null);

	    add (jcomp1);
	    add (jcomp2);
	    add (jcomp3);
	    add (jcomp4);
	    add (jcomp5);
	    add (step4);
	    //add(btn5);

	    jcomp1.setBounds (0, 10, 100, 25);
	    jcomp2.setBounds (125, 10, 100, 25);
	    jcomp3.setBounds (250, 10, 100, 25);
	    jcomp4.setBounds (375, 10, 100, 25);
	    jcomp5.setBounds (500, 10, 100, 25);
	    step4.setBounds(625, 10, 100, 25);
	    //btn5.setBounds(625, 10, 100, 25);
	    
	    jcomp1.setBackground(Color.green);
	    jcomp2.setEnabled(false);
	    jcomp3.setEnabled(false);
	    jcomp4.setEnabled(false);
	    jcomp5.setEnabled(false);
	    step4.setEnabled(false);
	    //btn5.setEnabled(false);
	    add (checkformat);
	    //jcomp1.setBackground(new Color(59, 89, 182));
		add (jcomp6);
	    add (jcomp7);
	    add (scrollPane);
	    add (jcomp9);
	    add (jcomp10);
	    add (jcomp11);
	    add (jcomp12);
	    jcomp6.setBounds (0, 50, 250, 25);
	    jcomp7.setBounds(470, 50, 100, 25);
	    checkformat.setBounds(600, 50, 200, 25);
	    
	    jcomp7.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	JFileChooser chooser = new JFileChooser();	
	            chooser.setCurrentDirectory(new java.io.File("."));
	            chooser.setDialogTitle("Select Use-Case Description File to process");
	            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	            chooser.setAcceptAllFileFilterUsed(false);

	            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	            	jcomp11.setText(chooser.getSelectedFile().getName());
	            	jcomp8.setText("");
	                f= chooser.getSelectedFile();
	                l1.makeLines(f);
	                l1.dispLines(f, jcomp8);
	            } else {
	                //System.out.println("No Selection ");
	            }
	        }
	    });
	    btnCompButton = new JButton("Browse");
	    btnCompButton.setEnabled(false);
	    checkformat.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	    		    try {
	    		    	jcomp8.append("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	    		    	
	    		    	l1.errorCheck(jcomp8);
	    		    	btnCompButton.setEnabled(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
	    		  } 
	    		} );	
	    scrollPane.setBounds(0, 100, 800, 300);
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    jcomp9.setBounds(700, 670, 100, 25);
	    jcomp9.setEnabled(false);
	    jcomp11.setBounds(250, 50, 200, 25);
	    jcomp12.setBounds(0, 450, 800, 200);
	    /*jcomp2.setEnabled(false);
	    jcomp3.setEnabled(false);
	    jcomp4.setEnabled(false);
	    jcomp5.setEnabled(false);*/
	    jcomp19_3=new JTextArea();
	    jcomp19_3.setBounds(550,75,80,20);
	    jcomp19_4=new JTextArea();
		jcomp19_4.setBounds(550,100,80,20);
		complabel = new JLabel("Select Component Files");
		btnCompButton.setBounds(650, 400, 100, 25);
		complabel.setBounds(500, 400, 150, 25);
		add(btnCompButton);
		add(complabel);
		JTextPane OkTxt = new JTextPane();
		btnCompButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            JFileChooser chooser = new JFileChooser();
	            chooser.setCurrentDirectory(new java.io.File("."));
	            chooser.setDialogTitle("Select Component Folder to process");
	            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	            chooser.setAcceptAllFileFilterUsed(false);
	            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
	            {
	            	jcomp12.append("Selected Components\n");
	                //System.out.println("getCurrentDirectory(): "+ chooser.getSelectedFile());
	                listFilesForFolder(chooser.getSelectedFile(),jcomp12, OkTxt, jcomp9);
	            }
	           else 
	           	{
	                //System.out.println("No Selection ");
	            }
	        }
	    });
		jcomp9.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
	       {
	        	//tabbedPane.setSelectedComponent(Step1);
	        	//thread.start();
	        	startCode();
	        	obj = new Object[table1array.size()][3];
	        	//System.out.println("thisherr\n");
	        	obj = convertTable1Array();
	        	for(int i=0;i<table1array.size();i++){
	        		//System.out.println(obj[i][0].toString()+"hello");
	        	}
	        	selectionButtonPressed3();
	        	//table_1.set = new JTable(obj, columnNames);
	       }
		});
		
	    jcomp1.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	    		    go1();
	    		  } 
	    		} );
	    jcomp2.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	    		    try {
	    		    	go3();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
	    		  } 
	    		} );
	    jcomp3.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	    		    try {
	    		    	go4();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
	    		  } 
	    		} );
	    jcomp4.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	    		    try {
	    		    	go5();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
	    		  } 
	    		} );
	    jcomp5.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	    		    try {
	    		    	go6();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
	    		  } 
	    		} );
	    step4.addActionListener(new ActionListener() { 
	    	public void actionPerformed(ActionEvent e) { 
    		    try {
    		    	go7();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
    		  } 
    		} );
}
	public void go1(){
		removeAll();
		revalidate();
		repaint();
		add (jcomp1);
	    add (jcomp2);
	    add (jcomp3);
	    add (jcomp4);
	    add (jcomp5);
	    add (step4);
		//jcomp1.setBackground(new Color(59, 89, 182));
		add (jcomp6);
	    add (jcomp7);
	    add (scrollPane);
	    add (jcomp9);
	    add (jcomp10);
	    add (jcomp11);
	    add (jcomp12);
	    add(checkformat);
		add(btnCompButton);
		add(complabel); 
		
	}
	public void go3(){
		removeAll();
		revalidate();
		repaint();
		add (jcomp1);
	    add (jcomp2);
	    add (jcomp3);
	    add (jcomp4);
	    add (jcomp5);
	    add (step4);
		add(s1lab1);
		add(s1lab2);
		add(jcomp191);
		add(jcomp19_1);
		add(jcomp19_2);
		add(s1lab3);
		add(scrollPanepanel);
		add(proceed2);
		add(timerlabel);
		add(timertext);
		add(timerlabel2);
		add(timertext2);
		add(oklabel);
	} 
	public void go4(){
		removeAll();
		revalidate();
		repaint();
		add (jcomp1);
	    add (jcomp2);
	    add (jcomp3);
	    add (jcomp4);
	    add (jcomp5);
	    add (step4);
	    add(loop);
		add(loop2_1);
		add(proceed21);
		add(okbutton);
		add(scrollPane3);
		okbutton.setEnabled(false);
		proceed21.setEnabled(false);
	}
	public void go5(){
		removeAll();
		revalidate();
		repaint();
		add (jcomp1);
	    add (jcomp2);
	    add (jcomp3);
	    add (jcomp4);
	    add (jcomp5);
	    add (step4);
		add(loop);
		add(loop2_2);
		add(scrollPane4);
		add(scenariono);
		add(scenariotime);
		add(proceed3);
		
	}
	public void go6(){
		removeAll();
		revalidate();
		repaint();
		add (jcomp1);
	    add (jcomp2);
	    add (jcomp3);
	    add (jcomp4);
	    add (jcomp5);
	    add (step4);
	    add(loop2);
	    add(scrollPanepanel2);
	    add(proceed4);
	}
	public void go7(){
		removeAll();
		revalidate();
		repaint();
		add (jcomp1);
	    add (jcomp2);
	    add (jcomp3);
	    add (jcomp4);
	    add (jcomp5);
	    add (step4);
	    add(step4title);
	    add(step4scrollPanepanel);
		
	}
	public void selectionButtonPressed7(){
		removeAll();
		revalidate();
		repaint();
		add (jcomp1);
	    add (jcomp2);
	    add (jcomp3);
	    add (jcomp4);
	    add (jcomp5);
	    add (step4);
	    step4.setEnabled(true);
	    jcomp1.setBackground(null);
		jcomp2.setBackground(null);
		jcomp3.setBackground(null);
		jcomp4.setBackground(null);
		jcomp5.setBackground(null);
		step4.setBackground(Color.green);
		//private JLabel step4title;
		//private JPanel step4panel;
		//private JScrollPane step4scrollPanepanel;
		step4title = new JLabel("Atomic and Composite states");
		step4title.setBounds(300, 50, 500, 25);
		add(step4title);
		step4panel= new JPanel();
		step4panel.setLayout(new GridLayout(Step4Total+100,1));
		int k = atomicList.size();
		////System.out.println("qwereeeeeeee");
		for(int j=0;j<k;j++){
			JLabel scenario = new JLabel("Scenario No: "+ (j+1));
			step4panel.add(scenario);
			JLabel atomic = new JLabel("Atomic States");
			step4panel.add(atomic);
			for(int i=0;i<atomicList.get(j).size();i++){
				JLabel atomic2 = new JLabel((i+1)+"."+atomicList.get(j).get(i));
				step4panel.add(atomic2);
			}
			JLabel compo = new JLabel("Composite States");
			step4panel.add(compo);
			for(int i=0;i<compoList.get(j).size();i++){
				JLabel compo2 = new JLabel((i+1)+"."+compoList.get(j).get(i));
				step4panel.add(compo2);
			}
		}
	    step4scrollPanepanel = new JScrollPane(step4panel);
	    step4scrollPanepanel.setBounds(50,100,900,600);
	    step4scrollPanepanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    step4scrollPanepanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    add(step4scrollPanepanel);
	}
	public void selectionButtonPressed6(){
		removeAll();
		revalidate();
		repaint();
		int height = 100;
		add (jcomp1);
	    add (jcomp2);
	    add (jcomp3);
	    add (jcomp4);
	    add (jcomp5);
	    add (step4);
	    proceed3.setEnabled(false);
	    jcomp5.setEnabled(true);
	    jcomp1.setBackground(null);
		jcomp2.setBackground(null);
		jcomp3.setBackground(null);
		jcomp4.setBackground(null);
		jcomp5.setBackground(Color.green);
        loop2 = new JLabel("Mapping States to Use Case Action Graph and Generating Hazard States");
		loop2.setBounds(300, 50, 500, 25);
		proceed4= new JButton("Proceed");
		proceed4.setBounds(800, 50, 100, 25);
		add(proceed4);
		add(loop2);
		//Object CompName[] = columnobj;
		Object[] columnNames2 = new Object[countcol+3];
		columnNames2[0]="Line No.";
		for (int i=0; i< countcol; i++){
			columnNames2[i+1] = columnobj[i];
		}
		columnNames2[countcol+1]="Atomic Hazard State";
		columnNames2[countcol+2]="Composite Hazard State";
	    //Object[] columnNames2 = {"Action No.","X","Y","Hazard State"};
	    int len, len2, i;
	    len = scenarioList.size();
	    panel2= new JPanel();
	    panel2.setLayout(new GridLayout(len,1));
	    scrollPanepanel2 = new JScrollPane(panel2);
	    scrollPanepanel2.setBounds(50,height,900,600);
	    scrollPanepanel2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanepanel2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    for(i = 0; i < len; i++)
	    {
	    	////System.out.println("$$$: "+scenarioList.get(i));
	    	StringTokenizer strg = new StringTokenizer(scenarioList.get(i), ",");
	    	StringTokenizer strgtemp = new StringTokenizer(scenarioListA.get(i), ",");
	    	len2 = scenarioList.get(i).length();
	    	//System.out.println(strg.countTokens());
		    obj4 = convertTable4Array(strg, strgtemp, len2, table3array, columnobj, countcol,atomiccomp);
		    Object[][] data = obj4;
		    JTable table3 = new JTable(data,columnNames2){
	            
	            //Implement table cell tool tips.
	            public String getToolTipText(MouseEvent e) {
	                String tip = null;
	                java.awt.Point p = e.getPoint();
	                int rowIndex = rowAtPoint(p);
	                int colIndex = columnAtPoint(p);
	                int realColumnIndex = convertColumnIndexToModel(colIndex);
	                tip =  getValueAt(rowIndex, colIndex).toString();
	                return tip;
	            }
		    };
		    JScrollPane scrollPane5 = new JScrollPane(table3);
			scrollPane5.setBounds(50,height,900,200);
			scrollPane5.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	        scrollPane5.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        scrollPane5.setBorder(BorderFactory.createTitledBorder ("Scenrario No:"+(i+1)+"\n No. of atomic states-"+ atomiccomp[0] +"\n No. of composite states-"+ atomiccomp[1]));
			panel2.add(scrollPane5);
			height += 200;
	    }
	    add(scrollPanepanel2);
	    proceed4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
	       {
				//table2text.setText(table2.getModel().getValueAt(0,3).toString());
				
	        	//System.out.println("Here!!!!!!!!");
				selectionButtonPressed7();
	        	//table_1.set = new JTable(obj, columnNames);
	       }
		});
	}
	public void selectionButtonPressed5(){
		removeAll();
		revalidate();
		repaint();
		add (jcomp1);
	    add (jcomp2);
	    add (jcomp3);
	    add (jcomp4);
	    add (jcomp5);
	    add (step4);
	    okbutton.setEnabled(false);
		proceed21.setEnabled(false);
	    jcomp4.setEnabled(true);
	    jcomp1.setBackground(null);
		jcomp2.setBackground(null);
		jcomp3.setBackground(null);
		jcomp4.setBackground(Color.green);
		jcomp5.setBackground(null);
		
	    JTextArea jcomp13=new JTextArea();
		JTextArea jcomp14=new JTextArea();
		JTextArea jcomp15=new JTextArea();
		jcomp15.setEditable(false);
		JScrollPane j1=new JScrollPane(jcomp13);
		JScrollPane j2=new JScrollPane(jcomp14);
		JScrollPane j3=new JScrollPane(jcomp15);
		j1.setBounds(50, 80, 80, 40);
	    j1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    j1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    j2.setBounds(130, 80, 150, 40);
	    j2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    j2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    j3.setBounds(280, 80, 400, 40);
	    j3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    j3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    
		loop2_2 = new JLabel("Step II(b): Scenario Action Sequence");
		loop2_2.setBounds(310, 100, 300, 25);
		add(loop);
		add(loop2_2);
	    Object[] columnNames = {"S.no","Scenarios (Line no.)"};
	    obj3 = convertTable3Array();
	    
		Object[][] data = obj3;
		table3 = new JTable(data,columnNames){
            
            //Implement table cell tool tips.
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);
                int realColumnIndex = convertColumnIndexToModel(colIndex);
                tip =  getValueAt(rowIndex, colIndex).toString();
                return tip;
            }
	    };
		scrollPane4 = new JScrollPane(table3);
		scrollPane4.setBounds(50,150,900,400);
		scrollPane4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane4);
		scenariono = new JLabel();
		scenariono.setText("No of Scenarios: " + scenarioList.size());
		scenariono.setBounds(100, 550, 150, 25);
		add(scenariono);
		scenariotime = new JLabel();
		scenariotime.setText("Time taken to generate scenarios " + scenariogentime + " milliseconds");
		scenariotime.setBounds(100, 600, 350, 25);
		add(scenariotime);
		proceed3 = new JButton("Proceed");
		proceed3.setBounds(700, 650, 100, 25);
		proceed3.setEnabled(true);
		add(proceed3);
	    proceed3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
	       {
				//table2text.setText(table2.getModel().getValueAt(0,3).toString());
				
	        	//System.out.println("Here!!!!!!!!");
				selectionButtonPressed6();
	        	//table_1.set = new JTable(obj, columnNames);
	       }
		});
	}
	public void selectionButtonPressed4(){
		removeAll();
		revalidate();
		repaint();
		add (jcomp1);
	    add (jcomp2);
	    add (jcomp3);
	    add (jcomp4);
	    add (jcomp5);
	    add (step4);
	    oklabel.setEnabled(false);
		proceed2.setEnabled(false);
	    jcomp3.setEnabled(true);
	    jcomp1.setBackground(null);
		jcomp2.setBackground(null);
		jcomp3.setBackground(Color.green);
		jcomp4.setBackground(null);
		jcomp5.setBackground(null);
		//btn5.setBackground(null);
	   // add(jcomp19_3);
	   // add(jcomp19_4);
	    jcomp1.setBackground(null);
		//jcomp2.setBackground(new Color(59, 89, 182));
		JTextArea jcomp13=new JTextArea();
		JTextArea jcomp14=new JTextArea();
		JTextArea jcomp15=new JTextArea();
		jcomp15.setEditable(false);
		JScrollPane j1=new JScrollPane(jcomp13);
		JScrollPane j2=new JScrollPane(jcomp14);
		JScrollPane j3=new JScrollPane(jcomp15);
		j1.setBounds(50, 80, 80, 40);
	    j1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    j1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    j2.setBounds(130, 80, 150, 40);
	    j2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    j2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    j3.setBounds(280, 80, 400, 40);
	    j3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    j3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//JTextArea jcomp19_3=new JTextArea();
		//JTextArea jcomp19_4=new JTextArea();
		jcomp19_4.setBounds(550,100,80,20);	
		loop = new JLabel("Generate Use Case Scenarios");
		loop2_1 = new JLabel("Step II(a): Loop Input");
		loop.setBounds(300, 50, 250, 25);
		loop2_1.setBounds(310, 100, 150, 25);
		add(loop);
		add(loop2_1);
		Object[] columnNames = {"S No.",
		        "Loop Action",
		        "Loop Line No.",
		        "Action No.",
		        "No. of times loop to repeat"};
		obj2 = convertTable2Array();
		Object[][] data = obj2;
		table2 = new JTable(data,columnNames){
            
            //Implement table cell tool tips.
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);
                int realColumnIndex = convertColumnIndexToModel(colIndex);
                tip =  getValueAt(rowIndex, colIndex).toString();
                return tip;
            }
	    };
		scrollPane3 = new JScrollPane(table2);
		scrollPane3.setBounds(10,150,900,300);
		//add(scrollPane);
		scrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		okbutton = new JButton("OK");
		okbutton.setBounds(300,600,100,25);
		okbutton.setForeground(Color.red);
		jcomp19.setBounds(300,75,80,30);
		//jcomp19_3.setBounds(550,75,80,20);
		//jcomp19_4.setBounds(550,100,80,20);	
		proceed21 = new JButton("Proceed");
		proceed21.setBounds(700, 650, 100, 25);
		proceed21.setEnabled(false);
		
		add(proceed21);
		add(okbutton);
		//add(jcomp19);
		//add(jcomp19_4);
	    add(scrollPane3);
	    okbutton.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) {    
	    		  okbutton.setForeground(Color.green);
	    		  proceed21.setEnabled(true);
	    		  } 
	    		} );
	    proceed21.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
	       {
				ArrayList<Integer> lpkount = new ArrayList<Integer>(); 
				for(int i = 0; i < whileSet.size(); i++)
		        {
		            lpkount.add(Integer.parseInt(table2.getModel().getValueAt(i,4).toString()));
		        }
				createUseCaseGraph2(l1.getLines(),whileSet,lpkount);
				generateScenarios2(startNode,lpkount,whileSet);
				
				//System.out.println("DOne till here");
	        	selectionButtonPressed5();
	        	//table_1.set = new JTable(obj, columnNames);
	       }
		});
	}
	
                
	public void selectionButtonPressed3(){
		removeAll();
		revalidate();
		repaint();
		add (jcomp1);
	    add (jcomp2);
	    add (jcomp3);
	    add (jcomp4);
	    add (jcomp5);
	    add (step4);
	    jcomp7.setEnabled(false);
		btnCompButton.setEnabled(false);
		checkformat.setEnabled(false);
		jcomp9.setEnabled(false);
		
	    jcomp2.setEnabled(true);
	    
		jcomp1.setBackground(null);
		jcomp2.setBackground(Color.green);
		jcomp3.setBackground(null);
		jcomp4.setBackground(null);
		jcomp5.setBackground(null);
		
	    s1lab1 = new JLabel("Generate Use Case Action State Mapping Graph");
	    add(s1lab1);
	    s1lab1.setBounds(220, 50, 500, 30);
	    jcomp1.setBackground(null);
		//jcomp2.setBackground(new Color(59, 89, 182));
		JTextArea jcomp13=new JTextArea();
		JTextArea jcomp14=new JTextArea();
		JTextArea jcomp15=new JTextArea();
		jcomp15.setEditable(false);
		JScrollPane j1=new JScrollPane(jcomp13);
		JScrollPane j2=new JScrollPane(jcomp14);
		JScrollPane j3=new JScrollPane(jcomp15);
		j1.setBounds(50, 80, 80, 40);
	    j1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    j1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    j2.setBounds(130, 80, 150, 40);
	    j2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    j2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    j3.setBounds(280, 80, 400, 40);
	    j3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    j3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    s1lab2 = new JLabel("STEP I(a): Generate Use-Case Action Graph");
	    add(s1lab2);
	    s1lab2.setBounds(250,75,500,30);
	    jcomp191=new JLabel("Building Use Case Action Graph:");
		jcomp19_1=new JLabel("Use Case Action Graph Build");
		jcomp19_2=new JLabel("Time taken to build : " + usecasegentime + " milliseconds");
		jcomp191.setBounds(300,100,200,20);
		jcomp19_1.setBounds(300,125,300,20);
		jcomp19_2.setBounds(300,150,300,20);
		add(jcomp191);
		add(jcomp19_1);
		add(jcomp19_2);
		s1lab3 = new JLabel("STEP I(b): Map Use-Case Actions to Component state");
	    add(s1lab3);
	    s1lab3.setBounds(250,175,500,30);														//Shift beyond this
	    //Object[] columnNames = {"Action No","Line No","Action Name"};
	    
	    //Object[][] data = obj;
	    /*table = new JTable(data,columnNames){
            
            //Implement table cell tool tips.
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);
                int realColumnIndex = convertColumnIndexToModel(colIndex);
                tip =  getValueAt(rowIndex, colIndex).toString();
                return tip;
            }
	    };*/
	    
	    //TableColumn sportColumn = table.getColumnModel().getColumn(3);
	   // TableColumn sportColumn2 = table.getColumnModel().getColumn(4);
	    //System.out.println(doorarray.get(0)+"shakalakaboomboom");
	    jcb=new JComboBox[doorarray.size()][1000];
	    //System.out.println("FINE"+doorarray.size());
	    //System.out.println(doorarray.get(0).size());
	    //JPanel panel = new JPanel();
	    
	    //panel.setLayout(new BorderLayout());
	    //JScrollPane scrollPanepanel = new JScrollPane(panel);
	    //scrollPanepanel.setBounds(10,200,800,400);
	    //scrollPanepanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollPanepanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    panel = new JPanel();
	    panel.setLayout(null);
	    panel.setPreferredSize(new Dimension(columnobj.length*100+400,table1array.size()*16+100));
	    scrollPanepanel = new JScrollPane(panel);
	    scrollPanepanel.setBounds(10,200,900,400);
	    scrollPanepanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanepanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    for (int i=0;i<doorarray.size();i++){
	    	 for (int j=0;j<table1array.size();j++){
	    		 jcb[i][j] = new JComboBox();
	    		 //System.out.println(doorarray.get(i).get(0)+"here$$"+j);
	    		 for(int k=0;k<doorarray.get(i).size();k++){
	    			 jcb[i][j].addItem(doorarray.get(i).get(k));
	    			}
	    		 final int j12=j;
	    		 final int i12=i;
	    		 jcb[i][j].addActionListener(new ActionListener() { 
			    	  public void actionPerformed(ActionEvent e) { 
			    		   for (int l=j12;l<table1array.size();l++){
			    			   jcb[i12][l].setSelectedIndex(jcb[i12][j12].getSelectedIndex());
			    		   }  
			    		  } 
			    		} );
	    		 //jcb[i][j].setBounds(510+100*i,220+16*j,100,16); //with table
	    		 jcb[i][j].setBounds(310+100*i,16+16*j,100,16);
	    		 //jcb[i][j].setBounds(450+100*i,20+16*j,100,table.getRowHeight());
	    		 //panel.add(jcb[i][j]);
	    		 panel.add(jcb[i][j]);
	    	 }
	    	 
	    }
	    //Action No.
	    for (int i=0;i<table1array.size();i++){
	    	JTextField j =new JTextField(table1array.get(i).getActiono());
		    j.setToolTipText(table1array.get(i).getActiono());
	    	j.setBounds(10,16+16*i,100,16);
	    	//j.setBounds(470+100*i,4,100,25);
	    	//panel.add(j);
	    	panel.add(j);
	    }
	    //Line No.
	    for (int i=0;i<table1array.size();i++){
	    	JTextField j =new JTextField(obj[i][1].toString());
	    	j.setToolTipText(obj[i][1].toString());
	    	j.setBounds(110,16+16*i,100,16);
	    	//j.setBounds(470+100*i,4,100,25);
	    	//panel.add(j);
	    	panel.add(j);
	    }
	    //Action Name
	    for (int i=0;i<table1array.size();i++){
	    	JTextField j =new JTextField(table1array.get(i).getActioname());
	    	 j.setToolTipText(table1array.get(i).getActioname());
	    	j.setBounds(210,16+16*i,100,16);
	    	//j.setBounds(470+100*i,4,100,25);
	    	//panel.add(j);
	    	panel.add(j);
	    }
	    //Labels
	    JLabel labelano = new JLabel("Action No.");
	    JLabel labellno = new JLabel("Line No.");
	    JLabel labelaname = new JLabel("Action Name");
	    labelano.setBounds(10, 0, 100, 16);
	    labellno.setBounds(110, 0, 100, 16);
	    labelaname.setBounds(210, 0, 100, 16);
	    panel.add(labelano);
	    panel.add(labellno);
	    panel.add(labelaname);
	    for (int i=0;i<countcol;i++){
	    	JLabel j =new JLabel(columnobj[i].toString());
	    	j.setBounds(330+100*i,0,100,16);
	    	//j.setBounds(470+100*i,4,100,25);
	    	//panel.add(j);
	    	panel.add(j);
	    }
	    add(scrollPanepanel);
	    //scrollPane2 = new JScrollPane(table);
	    
	    //scrollPane2.setBounds(10,200,500,400);
	    
	    //add(scrollPane2);
	    //panel.add(scrollPane2,BorderLayout.WEST);
	    //this.add(scrollPanepanel);
	    
	    //comboBox.setSelectedIndex(0);
	    //add(table, BorderLayout.CENTER);
	    timerlabel = new JLabel("Timer");
	    timertext = new JLabel();
	    timerlabel2 = new JLabel("Time taken");
	    timertext2 = new JLabel();
	    oklabel = new JButton("OK");
	    //oklabel.setBackground(Color.RED);
	    oklabel.setForeground(Color.RED);
	    JLabel jcomp199=new JLabel("Master Action Sequence Table");
		timerlabel.setBounds(800, 20, 40, 30);
		timerlabel2.setBounds(10, 600, 80, 30);
		oklabel.setBounds(460,630,70,20);
		jcomp199.setBounds(350,80,800,15);
		timertext.setBounds(840,20,150,30);
		timertext2.setBounds(100,600,150,30);
		proceed2 = new JButton("Proceed");
		//timertext.setEnabled(false);
		proceed2.setBounds(700, 650, 100, 25);
		proceed2.setEnabled(false);
		add(proceed2);
		add(timerlabel);
		add(timertext);
		add(timerlabel2);
		add(timertext2);
		add(oklabel);
		//add(jcomp199);
		
		
	    Thread thread = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            long start = System.currentTimeMillis();
	            while(true){
	                    long now=System.currentTimeMillis()-start;
	                    timertext.setText(Long.toString(now)+" milliseconds");
	                    //repaint();
	                }  
	      
	            }
	     
		});
	    thread.start();
	    oklabel.addActionListener(new ActionListener() { 
	    	  public void actionPerformed(ActionEvent e) { 
	    		    thread.stop();
	    		    oklabel.setForeground(Color.green);
	    		    proceed2.setEnabled(true);
	    		    timertext2.setText(timertext.getText());
	    		  } 
	    		} );
	    proceed2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
	       {
	    
	        	selectionButtonPressed4();
	        	//table_1.set = new JTable(obj, columnNames);
	       }
		});
	    //add(j7);
	    //add(j8);
	    //jcomp16.append((aname[count-1]));
		//jcomp17.append((line2.replace("null", "")));
		//jcomp18.append((((pc[count-1].replace("null", ""))).replace(",,",",")).replace("-,",""));
		//jcomp24.append(vst[cloud++-1][2]);
		//linecount++;
		//line2=in1.readLine();
	
	//add(jcomp19);
	//jcomp19.setBounds(1050,650,150 , 25);
	/*jcomp19.addActionListener(new ActionListener() { 
    	  public void actionPerformed(ActionEvent e) { 
    		    try {
					selectionButtonPressed4();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
    		  } 
    		} );
}catch(Exception e){}*/
}

	
	   
	    
	    public static void main (String[] args){
	    	JFrame frame = new JFrame("SOFTWARE FAULT TREE ANALYSIS OF USE CASES");
	    	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	    	gui b=new gui();
	    	JScrollPane scrollPane = new JScrollPane(b);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        frame.add(scrollPane);
	        frame.pack();
	        frame.setVisible (true);
	    	}
	    public void listFilesForFolder(File folder, JTextArea textArea_2, JTextPane okTxt, JButton btnProceed) 
		{
	    	columnobj = new Object[10];
	    	countcol=0;
		    for (final File fileEntry : folder.listFiles()) 
		    {
		        if (fileEntry.isDirectory()) 
		        {
		        	listFilesForFolder(fileEntry,textArea_2,okTxt, btnProceed);
		        } 
		        else 
		        {
		        	textArea_2.append("Component Name: "+fileEntry.getName().substring(0, fileEntry.getName().lastIndexOf("."))+" : ");
		        	dispFileContents(fileEntry.getAbsoluteFile(), textArea_2);
		        }
		    }
		    okTxt.setText("OK");
		    okTxt.setForeground(Color.green);
		    btnProceed.setEnabled(true);
		}
	    public void dispFileContents(File file, JTextArea textArea)
		{	
	    	
	    	columnobj[countcol] = file.getName().substring(0, file.getName().lastIndexOf("."));
	    	countcol++;
			 try 
			 {
				 BufferedReader br = new BufferedReader(new FileReader (file));
				 String         line = null;
				 textArea.append("		States : ");
				 try {
					 ArrayList<String> l = new ArrayList<String>();
					while ((line = br.readLine()) != null)
					    {
					        textArea.append(line+",");
					        l.add(line);
					    }
					doorarray.add(l);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			          
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 textArea.append("\n");
			 
		}
	    public void startCode()
		{
			//Scanner sc = new Scanner(System.in);
	        whileSet = new ArrayList<Integer>();
	        //ArrayList<Integer> lpkount = new ArrayList<Integer>();
	        LineFile l1 = new LineFile();
	        int i;
	        l1.makeLines(f);
	        Flow flow = new Flow();
	        startNode = createUseCaseGraph(l1.getLines(), whileSet);
	        //System.out.println(table1array.get(0).getActioname());
	        //System.out.println(table2array.get(0).getLineaction()+"hurray");
	     }
	    public Object[][] convertTable1Array(){
			int len = table1array.size();
			Object[][] obj = new Object[len][5];
			int i=0;
			for (i=0;i<len;i++){
				//System.out.printf(table1array.get(i).getActiono());
				obj[i][0]= table1array.get(i).getActiono();
				obj[i][1]= table1array.get(i).getLineno();
				obj[i][2]= table1array.get(i).getActioname();
				obj[i][3]= null;
				obj[i][4]= null;
			}
			return obj;
		}
	    public Object[][] convertTable2Array(){
			int len = table2array.size();
			Object[][] obj = new Object[len][5];
			int i=0;
			for (i=0;i<len;i++){
				//System.out.println(table2array.get(i).getLineno());
				obj[i][0]= table2array.get(i).getSno();
				obj[i][1]= table2array.get(i).getLineaction();
				obj[i][2]= table2array.get(i).getLineno();
				obj[i][3]= table2array.get(i).getActionno();
				obj[i][4]= null;
			}
			return obj;
		}
	    public Object[][] convertTable3Array(){
			int len = scenarioList.size();
			Object[][] obj = new Object[len][2];
			int i=0;
			for (i=0;i<len;i++){
				//System.out.println(scenarioList.get(i));
				//System.out.println(scenarioListA.get(i)+"lol");
				obj[i][0]="Scenario no. "+(i+1)+":";
				obj[i][1]=scenarioListA.get(i);
			}
			return obj;
		}
	    /*public Object[][] convertTable4Array(StringTokenizer strg, StringTokenizer strgtemp, int slen, ArrayList<Integer> ln, Object CompName[], int countcol)
	    {
	    	int len = strg.countTokens();
	    	Object[][] obj = new Object[len][countcol+2];
	    	Object objtemp;
			int i=0;
			int g = 0;
			int x;
			String sg ="";
			String str="";
			String tempstr="";
			String[] prev = new String[doorarray.size()];
			i=0;
			int k = -1, z = -1;
			while(strg.hasMoreTokens())
			{
				int j =0;
				obj[i][0]=strgtemp.nextToken();
				objtemp = strg.nextToken();
				if(objtemp.toString().contains("("))
				{
					int index;
					//System.out.println("With Bracket:"+objtemp.toString());
					index = objtemp.toString().indexOf("(");
					sg = objtemp.toString().substring(0, index);
				}
				else
				{
					sg = objtemp.toString();
				}
				for(g = 0; g < ln.size(); g++)
				{
					if(Integer.parseInt(sg) == ln.get(g))
					{
						k = ln.get(g)-1;
						break;
					}
				}
				if(z != -1)
				{
					while(j < prev.length)
					{
						//System.out.println((String)("^^^^-> "+jcb[j][z].getSelectedItem().toString()));
						prev[j] = (String)(jcb[j][z].getSelectedItem());
						j++;
					}
				}
				for(x = 0; x < countcol; x++)
				{
					obj[i][x+1]= jcb[x][k].getSelectedItem();
					if(z != -1)
					{
						if(!(prev[x].equalsIgnoreCase(obj[i][x+1].toString())))
						{
							tempstr = CompName[x].toString() + " = " +obj[i][x+1].toString();
							StringTokenizer s = new StringTokenizer(str,",");
							str = tempstr+","+str;
							while(s.hasMoreTokens())
							{
								str = str+","+s.nextToken()+" ^ "+tempstr;
							}
						}
					}
				}
				//System.out.println("Str is: "+str+"val of x: "+(x+1));
				obj[i][countcol+1]= str;
				z = k;
				i++;
			}
			return obj;
		}**/
	    
	    public Object[][] convertTable4Array(StringTokenizer strg, StringTokenizer strgtemp, int slen, ArrayList<Integer> ln, Object CompName[], int countcol , int[] atomiccomp)
	    {
	    	int len = strgtemp.countTokens();
	    	Object[][] obj = new Object[len][countcol+3];
	    	Object objtemp;
			int g = 0;
			int x;
			int i = 0;
			int NoAtomic = 0, NoComposite = 0;
			String str="";
			String yu[] = new String[countcol];
			String gh = "";
			String tempstr1="";
			String tempstr2="";
			String prev2 = "";
	    	Integer sg;
	    	String prev = new String();
	    	String p[] = new String[countcol];
	    	ArrayList<String> atomicList1 = new ArrayList<String>();
	    	ArrayList<String> compoList1 = new ArrayList<String>();
	    	String statetemp = new String();
	    	ArrayList<ArrayList<Integer>> changestate = new ArrayList<ArrayList<Integer>>();
    	    for (int k=0;k<doorarray.size();k++){
    	    	ArrayList<Integer> demo = new ArrayList<Integer>();
    	    	prev = (String)(jcb[k][0].getSelectedItem());
  	    	    for (int j=0;j<table1array.size();j++){
  	    		  if ((String)(jcb[k][j].getSelectedItem())!=prev){
  	    			  demo.add(table1array.get(j).getLineno());
  	    			  prev = (String)(jcb[k][j].getSelectedItem());
  	    		  }
  	    	    }
  	    	    changestate.add(demo);
    	    }
    	    String[] prevarray = new String[doorarray.size()];
    	    String[] statearray = new String[doorarray.size()];
    	    for (int k=0 ; k<doorarray.size();k++){
    	    	prevarray[k] = (String)(jcb[0][0].getSelectedItem());
    	    	statearray=prevarray;
    	    }
	    	while(strgtemp.hasMoreTokens()){
	    		 objtemp = strgtemp.nextToken();
	    		 obj[i][0]=objtemp;
	    		 if(objtemp.toString().contains("("))
 				 {
 					int index = objtemp.toString().indexOf("(");
 					sg = Integer.parseInt(objtemp.toString().substring(0, index));
 				 }
 				 else if (objtemp.toString().contains("-"))
 				 {
 					int index = objtemp.toString().indexOf("-");
 					sg = Integer.parseInt(objtemp.toString().substring(0, index));
 					
 				 }
 				 else {
 					sg = Integer.parseInt(objtemp.toString());
 				 }
	    		 for (int k=0;k<changestate.size();k++){
    				 if (changestate.get(k).contains(sg)){
    					 	 String curr = (String)(jcb[k][sg-1].getSelectedItem());
    					 	 if (objtemp.toString().contains("-")){
    					 		int index = objtemp.toString().indexOf("-");
    					 		curr = curr + objtemp.toString().substring(index);
    					 	 }
	    					 obj[i][k+1] = curr;
	    					 prevarray[k] = curr;
	    					 statearray[k] = curr;
	    					// //System.out.print("Elsa Jean"+k+"lol"+sg);
    				 }
    				 else{
    					 obj[i][k+1] = statearray[k];
    				 }
	    		 }
	    		 i++;
		    		 
	    	}
	    	for (int k=0;k<len;k++){
	    		for (int j=1;j<countcol+1;j++){
	    			////System.out.print("jhand"+obj[k][j]);
	    		}
	    	}			
	    	for(i = 0; i < len; i++)
			{
				prev2 = str;
				obj[i][countcol+1] = "";
	    		for(int j = 1; j <= countcol; j++)
				{
					if(i != 0)
					{
						p[j-1] = yu[j-1];
						yu[j-1] = obj[i][j].toString();
						if(!(p[j-1].equalsIgnoreCase(yu[j-1])))
						{
							tempstr1 = CompName[j-1].toString() + " != " +yu[j-1];
							obj[i][countcol+1] = tempstr1+" , "+obj[i][countcol+1];
							NoAtomic++;
							tempstr2 = CompName[j-1].toString() + " = " +yu[j-1];
							atomicList1.add(tempstr2);
							////System.out.println("i: "+i+"j: "+j+"prev"+p[j-1]+"yu "+yu[j-1]+"tempstr1 "+tempstr1+"tempstr2 "+tempstr2);
							StringTokenizer s = new StringTokenizer(str,",");
							str = tempstr1+","+str;
							while(s.hasMoreTokens())
							{
								String t, newe;
								t = s.nextToken();
								newe = str+","+t+" ^ ";
								////System.out.print("Look here..prev2: "+prev2);
								str = newe+tempstr1;
								str = newe+tempstr2;
								compoList1.add(str);
								NoComposite +=2;
								////System.out.println(" str: "+str);
								////System.out.println("^^Str is: "+t);
							}
						}
					}
					else
					{
						yu[j-1] = obj[i][j].toString();
						obj[i][countcol+1] = "";
					}
					////System.out.println("YU IS: "+yu[j-1]);
				}
				if(prev2.equalsIgnoreCase(str))
				{
					////System.out.println("EVER HERE?");
					obj[i][countcol+2]= "";
				}
				else
				{
					////System.out.println("Hwing");
					////System.out.println("Str is: "+str);
					obj[i][countcol+2]= str;
				}
			}
	    	NoComposite += NoAtomic;//INSERT HERE
	    	
	    	for(int ck = 0; ck < atomicList1.size(); ck++)
	    	{
	    		//System.out.println(atomicList1.get(ck));
	    	}
	    	/**
	    	//System.out.println("**********************");
	    	for(int ck = 0; ck < compoList.size(); ck++)
	    	{
	    		//System.out.println(compoList.get(ck));
	    	}
	    	*/
	    	atomicList.add(atomicList1);
	    	//System.out.println("size!!!! "+atomicList.get(0).size());
	    	//System.out.println("size!!!! "+atomicList.get(0).get(0));
	    	compoList.add(compoList1);
	    	//atomicList1.clear();
	    	//compoList1.clear();
	    	//System.out.println("size!!!! "+atomicList.get(0).size());
	    	//System.out.println("size!!!! "+atomicList.get(0).get(0));
	    	atomiccomp[0]= NoAtomic;
	    	atomiccomp[1]= NoComposite;
	    	Step4Total = Step4Total+NoAtomic+NoComposite;
	    	//System.out.println("ALEXANDRA DADDARIO "+(NoAtomic)+"&&"+(NoComposite));
			return obj;
		}
	    
	    public Node createUseCaseGraph(ArrayList<Line> linf, ArrayList<Integer> whileSet) {
            long start = System.currentTimeMillis();
            Node startNode = new Node(0,"Start",0);
            Node endNode = new Node(1000,"Start",20);
            endNode.setTrue_part(null);
            Node currentNode = startNode;
            Iterator<Line> li = linf.iterator();
            Stack<Node> ifstack = new Stack<Node>();
            Stack<Node> whilestack = new Stack<Node>();
            Stack<Node> lastvisitstack = new Stack<Node>();
            Table1 table1;
            Table2 table2;
            table1array = new ArrayList<Table1>();
            table2array = new ArrayList<Table2>();
            table3array = new ArrayList<Integer>();
            while (li.hasNext()){
                Line ln = li.next();
                if (ln.getLine_descrip().startsWith("IF")) {
                    Node n = new Node(ln.getLineno(),ln.getLine_descrip(),2);
                    ifstack.push(n);
                    currentNode.setTrue_part(n);
                    currentNode = n;
                    table1= new Table1(ln.getLineno(),"IF",1);
                    table1array.add(table1);
                    table3array.add(ln.getLineno());
                }
                else if (ln.getLine_descrip().startsWith("ELSE")) {
                    Node n = new Node(ln.getLineno(),ln.getLine_descrip(),3);
                    if (!ifstack.isEmpty()){
                        ifstack.pop().setElse_part(n);
                        table1= new Table1(ln.getLineno(),"ELSE",0);
                        table1array.add(table1);
                    }
                   
                    else {
                        //System.out.print("Error1");
                    }
                    lastvisitstack.push(currentNode);
                    currentNode = n;
                }
                else if (ln.getLine_descrip().startsWith("ENDIF")) {
                    Node n = new Node(ln.getLineno(),ln.getLine_descrip(),4);
                    currentNode.setTrue_part(n);
                    if (!lastvisitstack.isEmpty()){
                    lastvisitstack.pop().setTrue_part(n);
                    table1= new Table1(ln.getLineno(),"ENDIF",0);
                    table1array.add(table1);
                    }
                    else {
                        //System.out.print("Error2");
                    }
                    currentNode = n;
                }
              
                else if (ln.getLine_descrip().startsWith("WHILE")) {
                    Node n = new Node(ln.getLineno(),ln.getLine_descrip(),5);
                    whilestack.push(n);
                    currentNode.setTrue_part(n);
                    currentNode = n;
                    whileSet.add(ln.getLineno());
                    //System.out.printf("here while \n");
                    table1= new Table1(ln.getLineno(),"WHILE",1);
                    table1array.add(table1);
                    table2 = new Table2(ln.getLineno(),table1.getActiono(),ln.getLine_descrip());
                    table2array.add(table2);
                    table3array.add(ln.getLineno());
                }
                else if (ln.getLine_descrip().startsWith("ENDWHILE")) {
                    Node n = new Node(ln.getLineno(),ln.getLine_descrip(),6);
                    if (!whilestack.isEmpty()){
                        Node w =whilestack.pop();
                        w.setElse_part(n);
                        currentNode.setTrue_part(w);
                        currentNode = n;
                        table1= new Table1(ln.getLineno(),"ENDWHILE",0);
                        table1array.add(table1);
                    }
                    else {
                        //System.out.print("Error4");
                    }
                 
                }
                else if (ln.getLine_descrip().startsWith("END")) {
                    if (whilestack.isEmpty() && ifstack.isEmpty()){
                        Node n = new Node(ln.getLineno(),ln.getLine_descrip(),7);
                        currentNode.setTrue_part(n);
                        currentNode = n;
                        n.setTrue_part(endNode);
                        table1= new Table1(ln.getLineno(),"END",1);
                        table1array.add(table1);
                        table3array.add(ln.getLineno());
                    }
                    else {
                        //System.out.print("Error5");
                    }
                }
                else if (ln.getLine_descrip().startsWith("EXIT")) {
                    if (currentNode.getType()==5){
                        currentNode.setElse_part(endNode);
                    }
                    else if (currentNode.getType()==3){
                        currentNode.setElse_part(endNode);
                    }
                    else {
                        currentNode.setTrue_part(endNode);
                    }
                    table1= new Table1(ln.getLineno(),"EXIT",1);
                    table1array.add(table1);
                }
                else {
                    Node n = new Node(ln.getLineno(),ln.getLine_descrip(),1);
                    currentNode.setTrue_part(n);
                    currentNode = n;
                    table1= new Table1(ln.getLineno(),ln.getLine_descrip(),1);
                    ////System.out.println(table1.getActioname());
                    table1array.add(table1);
                    table3array.add(ln.getLineno());
                    //System.out.println(table1array.get(0).getActioname()+"here");
                }
            }
            /*Iterator<String> itr = whileSet.iterator();
            while(itr.hasNext())
            {
                //System.out.println(itr.next());
            }**/
            long end = System.currentTimeMillis();
            ////System.out.println(end);
            usecasegentime=end-start;
            ////System.out.println(scenariogentime);
            //System.out.println("1THIS-> "+startNode);
            for( int i=0; i<whileSet.size();i++){
            	relation.add(-1);
            	tlpkount.add(-1);
            }
            return startNode;
        }
	    
	    public Node createUseCaseGraph2(ArrayList<Line> linf, ArrayList<Integer> whileSet, ArrayList<Integer> lpkount)
        {
            long start = System.currentTimeMillis();
            Node startNode = new Node(0,"Start",0);
            Node endNode = new Node(1000,"Start",20);
            endNode.setTrue_part(null);
            whileSet.clear();
            Node currentNode = startNode;
            Iterator<Line> li = linf.iterator();
            Stack<Node> ifstack = new Stack<Node>();
            Stack<Node> whilestack = new Stack<Node>();
            Stack<Node> lastvisitstack = new Stack<Node>();
            Table1 table1;
            Table2 table2;
            table1array = new ArrayList<Table1>();
            table2array = new ArrayList<Table2>();
            table3array = new ArrayList<Integer>();
            //System.out.println("SHATIMAN");
            while (li.hasNext()){
                Line ln = li.next();
                if (ln.getLine_descrip().startsWith("IF")) {
                    Node n = new Node(ln.getLineno(),ln.getLine_descrip(),2);
                    ifstack.push(n);
                    currentNode.setTrue_part(n);
                    currentNode = n;
                    table1= new Table1(ln.getLineno(),"IF",1);
                    table1array.add(table1);
                    table3array.add(ln.getLineno());
                }
                else if (ln.getLine_descrip().startsWith("ELSE")) {
                    Node n = new Node(ln.getLineno(),ln.getLine_descrip(),3);
                    if (!ifstack.isEmpty()){
                        ifstack.pop().setElse_part(n);
                        table1= new Table1(ln.getLineno(),"ELSE",0);
                        table1array.add(table1);
                    }
                  
                    else {
                        //System.out.print("Error1");
                    }
                    lastvisitstack.push(currentNode);
                    currentNode = n;
                }
                else if (ln.getLine_descrip().startsWith("ENDIF")) {
                    Node n = new Node(ln.getLineno(),ln.getLine_descrip(),4);
                    currentNode.setTrue_part(n);
                    if (!lastvisitstack.isEmpty()){
                    lastvisitstack.pop().setTrue_part(n);
                    table1= new Table1(ln.getLineno(),"ENDIF",0);
                    table1array.add(table1);
                    }
                    else {
                        //System.out.print("Error2");
                    }
                    currentNode = n;
                }
             
                else if (ln.getLine_descrip().startsWith("WHILE")) {
                    Node n = new Node(ln.getLineno(),ln.getLine_descrip(),5);
                    whileSet.add(ln.getLineno());
                    //System.out.println("%%%%%%%%: "+whileSet.indexOf(ln.getLineno()+1));
                    if(!whilestack.isEmpty())
                    {
                        ////System.out.println("Order lpkount: "+whileSet.indexOf(ln.getLineno()+1)+" &&** "+(lpkount.get(whileSet.indexOf(ln.getLineno()+1)))*lpkount.get(whileSet.indexOf(whilestack.peek().getNode_no())));
                        //lpkount.set(whileSet.indexOf(ln.getLineno()+1), (lpkount.get(whileSet.indexOf(ln.getLineno()+1)))*lpkount.get(whileSet.indexOf(whilestack.peek().getNode_no())));
                        relation.set(whileSet.indexOf(ln.getLineno()), whileSet.indexOf(whilestack.peek().getNode_no()));
                        tlpkount.set(whileSet.indexOf(ln.getLineno()), lpkount.get(whileSet.indexOf(ln.getLineno())));
                    }
                    //System.out.println("Relation: "+relation.get(whileSet.indexOf(ln.getLineno())));
                    //System.out.println("LP: "+lpkount.get(whileSet.indexOf(ln.getLineno())));
                   
                    whilestack.push(n);
                    currentNode.setTrue_part(n);
                    currentNode = n;
                    //System.out.printf("here while \n");
                    table1= new Table1(ln.getLineno(),"WHILE",1);
                    table1array.add(table1);
                    table2 = new Table2(ln.getLineno()+1,table1.getActiono(),ln.getLine_descrip());
                    table2array.add(table2);
                    table3array.add(ln.getLineno());
                }
                else if (ln.getLine_descrip().startsWith("ENDWHILE")) {
                    Node n = new Node(ln.getLineno(),ln.getLine_descrip(),6);
                    if (!whilestack.isEmpty()){
                        Node w =whilestack.pop();
                        w.setElse_part(n);
                        currentNode.setTrue_part(w);
                        currentNode = n;
                        table1= new Table1(ln.getLineno(),"ENDWHILE",0);
                        table1array.add(table1);
                    }
                    else {
                        //System.out.print("Error4");
                    }
                
                }
                else if (ln.getLine_descrip().startsWith("END")) {
                    if (whilestack.isEmpty() && ifstack.isEmpty()){
                        Node n = new Node(ln.getLineno(),ln.getLine_descrip(),7);
                        currentNode.setTrue_part(n);
                        currentNode = n;
                        n.setTrue_part(endNode);
                        table1= new Table1(ln.getLineno(),"END",1);
                        table1array.add(table1);
                        table3array.add(ln.getLineno());
                    }
                    else {
                        //System.out.print("Error5");
                    }
                }
                else if (ln.getLine_descrip().startsWith("EXIT")) {
                    if (currentNode.getType()==5){
                        currentNode.setElse_part(endNode);
                    }
                    else if (currentNode.getType()==3){
                        currentNode.setElse_part(endNode);
                    }
                    else {
                        currentNode.setTrue_part(endNode);
                    }
                    table1= new Table1(ln.getLineno(),"EXIT",1);
                    table1array.add(table1);
                }
                else {
                    Node n = new Node(ln.getLineno(),ln.getLine_descrip(),1);
                    currentNode.setTrue_part(n);
                    currentNode = n;
                    table1= new Table1(ln.getLineno(),ln.getLine_descrip(),1);
                    ////System.out.println(table1.getActioname());
                    table1array.add(table1);
                    table3array.add(ln.getLineno());
                    //System.out.println(table1array.get(0).getActioname()+"here");
                }
            }
            /*Iterator<String> itr = whileSet.iterator();
            while(itr.hasNext())
            {
                //System.out.println(itr.next());
            }**/
            long end = System.currentTimeMillis();
            ////System.out.println(end);
            usecasegentime=end-start;
            ////System.out.println(scenariogentime);
            //System.out.println("1THIS-> "+startNode);
            return startNode;
        }
	    
	    public void generateScenarios2(Node startNode, ArrayList<Integer> lpkount, ArrayList<Integer> whileSet)
        {
            long start = System.currentTimeMillis();
            ////System.out.println(start);
            String scenario = "";
            String scenarioA = "";
            int temp2 = -1;
            Node cNode = startNode.getTrue_part();
            Stack<Node> newStack = new Stack<Node>();
            Stack<String> scenarioStack = new Stack<String>();
            //ArrayList<String> scenarioList = new ArrayList<String>();
            Stack<Integer> iflist = new Stack<Integer>();
            Stack<Integer> indexlist = new Stack<Integer>();
            int flag = 0;
            String hyphen="";
            ArrayList<Integer> lpkount2 = new ArrayList<Integer>();
            for (int j=0;j<lpkount.size();j++){
            	lpkount2.add(lpkount.get(j));
            }
            while(true)
            {
                switch(cNode.getType())
                {
                    case 1: scenario = scenario+ cNode.getNode_no()+",";
                    		if (flag==1){
                    			int i=temp2;
                    			Integer hyp = lpkount2.get(i)-lpkount.get(i);
                    			hyphen = "-"+hyp.toString() ;		
                    		}
                            scenarioA = scenarioA+cNode.getNode_no()+hyphen+",";
                            hyphen="";
                            cNode = cNode.getTrue_part();
                            break;
                    case 2: scenarioStack.push(scenario + cNode.getNode_no() +"(F),");
		                    if (flag==1){
		                    	int i=temp2;
		            			Integer hyp = lpkount2.get(i)-lpkount.get(i);
		            			hyphen = "-"+hyp.toString() ;		
		                    }
                            if (temp2!=-1){
                                iflist.push(lpkount.get(temp2));
                                indexlist.push(temp2);
                            }
                            scenario = scenario+ cNode.getNode_no()+"(T),";
                            scenarioA = scenarioA+cNode.getNode_no()+"(T)"+hyphen+",";
                            hyphen="";
                            newStack.push(cNode);
                            cNode = cNode.getTrue_part();
                            break;
                    case 5:  
                    		flag = 1;
                            int i = whileSet.indexOf(cNode.getNode_no());
                            temp2 = i;
                            //System.out.println(i+"hulaahulaa"+cNode.getNode_no()+"lula"+lpkount.get(i));
                            if(newStack.search(cNode) == -1)            //Node not there
                            {
                                scenarioStack.push(scenario + cNode.getNode_no() +"(F),");
                                newStack.push(cNode);
                                scenario = scenario+ cNode.getNode_no()+"(T),";
                                int i1=temp2;
                                Integer hyp = lpkount2.get(i1)-lpkount.get(i1)+1;
                    			hyphen = "-"+hyp.toString() ;
                                scenarioA = scenarioA+ cNode.getNode_no()+"(T)"+hyphen+",";
                                hyphen="";
                                cNode = cNode.getTrue_part();
                                lpkount.set(i, (lpkount.get(i)-1));
                            }
                            else if(lpkount.get(i) > 0)
                            {
                                scenario = scenario+ cNode.getNode_no()+"(T),";
                                int i1=temp2;
                                Integer hyp = lpkount2.get(i1)-lpkount.get(i1)+1;
                    			hyphen = "-"+hyp.toString() ;
                                scenarioA = scenarioA+cNode.getNode_no()+"(T)"+hyphen+",";
                                hyphen="";
                                cNode = cNode.getTrue_part();
                                lpkount.set(i, (lpkount.get(i)-1));
                            }
                            else
                            {
                            	if (relation.get(whileSet.indexOf(cNode.getNode_no()))!=-1){
                            		int prev=relation.get(whileSet.indexOf(cNode.getNode_no()));
                            		while(prev!=-1){
                            			if (lpkount.get(prev)>0){
                            				lpkount.set(i, (tlpkount.get(i)));
                            				//System.out.println("Mugambo"+lpkount.get(i));
                            				break;
                            			}
                            			else{
                            				prev=relation.get(prev);
                            			}
                            		}
                            	}
                                scenario = scenario+ cNode.getNode_no()+"(F),";
                                int i1=temp2;
                                Integer hyp = lpkount2.get(i1)-lpkount.get(i1)+1;
                    			hyphen = "-"+hyp.toString() ;
                                scenarioA = scenarioA+cNode.getNode_no()+"(F)"+hyphen+",";
                                hyphen="";
                                cNode = cNode.getElse_part();
                                
                                      
                            }
                            break;
                    case 3: cNode = cNode.getTrue_part();
                    		break;
                    case 4: cNode = cNode.getTrue_part();
            				break;
                    case 6: cNode = cNode.getTrue_part();
                    		flag=0;
                            break;
                    case 7: scenarioList.add(scenario);
                            scenarioListA.add(scenarioA);
                            if(scenarioStack.isEmpty()){
                                long end = System.currentTimeMillis();
                                ////System.out.println(end);
                                scenariogentime=end-start;
                                ////System.out.println(scenariogentime);
                                return ;
                            }
                            else
                            {
                                scenario = scenarioStack.pop();
                                Node temp = newStack.pop();
                                cNode = temp.getElse_part();
                                if(!indexlist.isEmpty())
                                    lpkount.set(indexlist.pop(), iflist.pop());
                              
                            }
                }
            }
           
        }
	}