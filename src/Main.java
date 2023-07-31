//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JPanel;
//
//public class Main {
//	public static void main(String[] args) {
//		MyFrame run = new MyFrame();
//		run.setVisible(true);
//	}
//}
//class MyFrame extends JFrame implements ActionListener{
//	
//	int chk = 0;
//	
//	JButton start;
//	JButton reset;
//	
//	JLabel Unit1,Unit1_1,Unit1_2;
//	JLabel Unit2,Unit2_1,Unit2_2;
//	JLabel Unit3,Unit3_1,Unit3_2;
//	
//	JPanel content;
//	
//	CheckPoint runUnit1, runUnit1_1,runUnit1_2;
//	CheckPoint runUnit2,runUnit2_1,runUnit2_2;
//	CheckPoint runUnit3,runUnit3_1,runUnit3_2;
//	
//	CheckPoint all[];
//	
//	public MyFrame() {
//		setTitle("Program Mini Game Run");
//		setSize(1280, 720);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		content = new JPanel();
//		content.setBackground(new Color(182, 67, 41));
//		content.setLayout(null);
//		setContentPane(content);
//		
//		start = new JButton("Start/Stop");
//		start.setBounds(20, 20, 100, 30);
//		start.setFocusable(false);
//		start.setBackground(Color.yellow.brighter());
//		content.add(start);
//		
//		reset = new JButton("Reset");
//		reset.setBounds(140, 20, 100, 30);
//		reset.setFocusable(false);
//		reset.setBackground(Color.red.brighter());
//		reset.addActionListener(this);
//		content.add(reset);
//		
//		
//		JPanel bar = new JPanel();
//		bar.setBackground(new Color(255, 255, 255));
//		bar.setBounds(0, 0, 1280, 80);
//		bar.setLayout(null);
//		content.add(bar);
//		
//		JLabel image = new JLabel();
//        image.setBounds(0, 80, 1280, 600);
//        image.setIcon(new ImageIcon(MyFrame.class.getResource("bk.png")));
//        content.add(image);
//        
//        //len1------------------------------------
//        Unit1 = new JLabel();
//        Unit1.setBounds(790, 630, 40, 40);
//        Unit1.setIcon(new ImageIcon(MyFrame.class.getResource("pikachu.gif")));
//        content.add(Unit1);
//          
//        Unit1_1 = new JLabel();
//        Unit1_1.setBounds(1180, 90, 40, 40);
//        Unit1_1.setIcon(new ImageIcon(MyFrame.class.getResource("TX1.gif")));
//        content.add(Unit1_1);
//        
//        Unit1_2 = new JLabel();
//        Unit1_2.setBounds(20, 450, 40, 40);
//        Unit1_2.setIcon(new ImageIcon(MyFrame.class.getResource("blue.gif")));
//        content.add(Unit1_2);
//        
//        runUnit1_2 = new CheckPoint(Unit1_2,"blue.gif","blue2.gif");
//        runUnit1_2.getChackPoint(1220, 630, 1220, 90, 20, 90, 630);
//        
//        runUnit1_1 = new CheckPoint(Unit1_1,"TX.gif","TX1.gif");
//        runUnit1_1.getChackPoint(1220, 630, 1220, 90, 20, 90, 630);
//        
//        runUnit1 = new CheckPoint(Unit1,"pikachu.gif","pikachu2.gif");
//        runUnit1.getChackPoint(1220, 630, 1220, 90, 20, 90, 630);
//        
//        runUnit1.setChkPoint(runUnit1_1, runUnit1,false);
//        runUnit1_1.setChkPoint(runUnit1_2, runUnit1,false);
//        runUnit1_2.setChkPoint(runUnit1, runUnit1_1,true);
//        
//        runUnit1.start();
//        runUnit1_1.start();
//        runUnit1_2.start();
//        
//        //len2------------------------------------
//        Unit2 = new JLabel();
//        Unit2.setBounds(690, 570, 40, 40);
//        Unit2.setIcon(new ImageIcon(MyFrame.class.getResource("cat2.gif")));  
//        content.add(Unit2);
//        Unit2_1 = new JLabel();
//        Unit2_1.setBounds(1080, 150, 40, 40);
//        Unit2_1.setIcon(new ImageIcon(MyFrame.class.getResource("cat.gif"))); 
//        content.add(Unit2_1);
//        Unit2_2 = new JLabel();
//        Unit2_2.setBounds(80, 360, 40, 40);
//        Unit2_2.setIcon(new ImageIcon(MyFrame.class.getResource("cat2.gif")));
//        content.add(Unit2_2);
//        
//        runUnit2 = new CheckPoint(Unit2,"cat2.gif","cat.gif");
//        runUnit2.getChackPoint(1160, 570, 1160, 150, 80, 150, 570);
//        runUnit2_1 = new CheckPoint(Unit2_1,"cat2.gif","cat.gif");
//        runUnit2_1.getChackPoint(1160, 570, 1160, 150, 80, 150, 570);
//        runUnit2_2 = new CheckPoint(Unit2_2,"cat2.gif","cat.gif");
//        runUnit2_2.getChackPoint(1160, 570, 1160, 150, 80, 150, 570);
//        
//        runUnit2.setChkPoint(runUnit2_1, runUnit2, false);
//        runUnit2_1.setChkPoint(runUnit2_2, runUnit2, false);
//        runUnit2_2.setChkPoint(runUnit2, runUnit2_1, true);
//        
//        runUnit2.start();
//        runUnit2_1.start();
//        runUnit2_2.start();
//        
//        //len3------------------------------------
//        Unit3 = new JLabel();
//        Unit3.setBounds(590, 510, 40, 40);
//        Unit3.setIcon(new ImageIcon(MyFrame.class.getResource("blue.gif")));
//        content.add(Unit3);
//        Unit3_1 = new JLabel();
//        Unit3_1.setBounds(960, 210, 40, 40);
//        Unit3_1.setIcon(new ImageIcon(MyFrame.class.getResource("blue2.gif")));
//        content.add(Unit3_1);
//        Unit3_2 = new JLabel();
//        Unit3_2.setBounds(140, 250, 40, 40);
//        Unit3_2.setIcon(new ImageIcon(MyFrame.class.getResource("blue.gif")));
//        content.add(Unit3_2);
//        
//        runUnit3 = new CheckPoint(Unit3,"blue.gif","blue2.gif");
//        runUnit3.getChackPoint(1100, 510, 1100, 210, 140, 210, 510);
//        runUnit3_1 = new CheckPoint(Unit3_1,"blue.gif","blue2.gif");
//        runUnit3_1.getChackPoint(1100, 510, 1100, 210, 140, 210, 510);
//        runUnit3_2 = new CheckPoint(Unit3_2,"blue.gif","blue2.gif");
//        runUnit3_2.getChackPoint(1100, 510, 1100, 210, 140, 210, 510);
//        
//        runUnit3.setChkPoint(runUnit3_1, runUnit3, false);
//        runUnit3_1.setChkPoint(runUnit3_2, runUnit3, false);
//        runUnit3_2.setChkPoint(runUnit3, runUnit3_1, true);
//        
//        runUnit3.start();
//        runUnit3_1.start();
//        runUnit3_2.start();
//        
//        //--------------------------------------------------------------------------------------------
//        
//        CheckPoint all[] = {runUnit1,runUnit1_1,runUnit1_2,runUnit2,runUnit2_1,runUnit2_2,runUnit3,runUnit3_1,runUnit3_2};
//        this.all = all;  
//        start.addActionListener(this);
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		if(e.getSource() == start)
//		{
//			for (int i = 0; i < all.length; i++) {
//				if(all[i].isFlag_start_stop()) {
//					all[i].setFlag_start_stop(false);
//				}
//				else {
//					all[i].setFlag_start_stop(true);
//				}
//			}
//			if(chk == 0) {
//				runUnit1.setFlag(true);
//				runUnit2.setFlag(true);
//				runUnit3.setFlag(true);
//				chk++;
//			}
//		}
//		if(e.getSource() == reset)
//		{
//			for(int i = 0; i < all.length; i++) {
//				all[i].setFlag_start_stop(false);
//			}
//			reset();
//			chk = 0;
//		}
//	}
//	void reset()
//	{ 
//			
//	        Unit1.setBounds(790, 630, 40, 40);
//	        Unit1.setIcon(new ImageIcon(MyFrame.class.getResource("pikachu.gif")));
//	        
//	        Unit1_1.setBounds(1180, 90, 40, 40);
//	        Unit1_1.setIcon(new ImageIcon(MyFrame.class.getResource("TX1.gif")));
//
//	        Unit1_2.setBounds(20, 450, 40, 40);
//	        Unit1_2.setIcon(new ImageIcon(MyFrame.class.getResource("blue.gif")));
//	        
//	        runUnit1_2 = new CheckPoint(Unit1_2,"blue.gif","blue2.gif");
//	        runUnit1_2.getChackPoint(1220, 630, 1220, 90, 20, 90, 630);
//	        
//	        runUnit1_1 = new CheckPoint(Unit1_1,"TX.gif","TX1.gif");
//	        runUnit1_1.getChackPoint(1220, 630, 1220, 90, 20, 90, 630);
//	       
//	        runUnit1 = new CheckPoint(Unit1,"pikachu.gif","pikachu2.gif");
//	        runUnit1.getChackPoint(1220, 630, 1220, 90, 20, 90, 630);
//	        
//	        runUnit1.setChkPoint(runUnit1_1, runUnit1,false);
//	        runUnit1_1.setChkPoint(runUnit1_2, runUnit1,false);
//	        runUnit1_2.setChkPoint(runUnit1, runUnit1_1,true);
//	       
//	        runUnit1.start();
//	        runUnit1_1.start();
//	        runUnit1_2.start();
//	        
//	        Unit2.setBounds(690, 570, 40, 40);
//	        Unit2.setIcon(new ImageIcon(MyFrame.class.getResource("cat2.gif")));  
//	       
//	        Unit2_1.setBounds(1080, 150, 40, 40);
//	        Unit2_1.setIcon(new ImageIcon(MyFrame.class.getResource("cat.gif"))); 
//	       
//	        Unit2_2.setBounds(80, 360, 40, 40);
//	        Unit2_2.setIcon(new ImageIcon(MyFrame.class.getResource("cat2.gif")));
//	        
//	        runUnit2 = new CheckPoint(Unit2,"cat2.gif","cat.gif");
//	        runUnit2.getChackPoint(1160, 570, 1160, 150, 80, 150, 570);
//	        runUnit2_1 = new CheckPoint(Unit2_1,"cat2.gif","cat.gif");
//	        runUnit2_1.getChackPoint(1160, 570, 1160, 150, 80, 150, 570);
//	        runUnit2_2 = new CheckPoint(Unit2_2,"cat2.gif","cat.gif");
//	        runUnit2_2.getChackPoint(1160, 570, 1160, 150, 80, 150, 570);
//	        runUnit2.setChkPoint(runUnit2_1, runUnit2, false);
//	        runUnit2_1.setChkPoint(runUnit2_2, runUnit2, false);
//	        runUnit2_2.setChkPoint(runUnit2, runUnit2_1, true);
//	        
//	        runUnit2.start();
//	        runUnit2_1.start();
//	        runUnit2_2.start();
//	        
//	        Unit3.setBounds(590, 510, 40, 40);
//	        Unit3.setIcon(new ImageIcon(MyFrame.class.getResource("blue.gif")));
//	        
//	        Unit3_1.setBounds(960, 210, 40, 40);
//	        Unit3_1.setIcon(new ImageIcon(MyFrame.class.getResource("blue2.gif")));
//	       
//	        Unit3_2.setBounds(140, 250, 40, 40);
//	        Unit3_2.setIcon(new ImageIcon(MyFrame.class.getResource("blue.gif")));
//	       
//	        runUnit3 = new CheckPoint(Unit3,"blue.gif","blue2.gif");
//	        runUnit3.getChackPoint(1100, 510, 1100, 210, 140, 210, 510);
//	        runUnit3_1 = new CheckPoint(Unit3_1,"blue.gif","blue2.gif");
//	        runUnit3_1.getChackPoint(1100, 510, 1100, 210, 140, 210, 510);
//	        runUnit3_2 = new CheckPoint(Unit3_2,"blue.gif","blue2.gif");
//	        runUnit3_2.getChackPoint(1100, 510, 1100, 210, 140, 210, 510);
//	        runUnit3.setChkPoint(runUnit3_1, runUnit3, false);
//	        runUnit3_1.setChkPoint(runUnit3_2, runUnit3, false);
//	        runUnit3_2.setChkPoint(runUnit3, runUnit3_1, true);
//	        
//	        runUnit3.start();
//	        runUnit3_1.start();
//	        runUnit3_2.start();
//	        
//	        CheckPoint all[] = {runUnit1,runUnit1_1,runUnit1_2,runUnit2,runUnit2_1,runUnit2_2,runUnit3,runUnit3_1,runUnit3_2};
//	        this.all = all;
//	}
//}
//class CheckPoint extends Thread{
//	
//	JLabel Unit;
//	int runSpeed;
//	
//	CheckPoint UnitChk;
//	CheckPoint UnitCng;
//	
//	private boolean flag = false,
//					back = false, 
//					is = false,
//					flag_start_stop = false;
//	
//	int x1 = 0, x2 = 0, x3 = 0;
//	int y1 = 0, y2 = 0, y3 = 0, y4 =0;
//	
//	int chkX = 0, chkY = 0;
//	
//	int endX = 0, endY = 0;
//	
//	String pic1,pic2;
//	public CheckPoint(JLabel Unit,String pic1,String pic2) {
//		this.Unit = Unit;
//		
//		endX = Unit.getX();
//		endY = Unit.getY();
//		
//		this.pic1 = pic1; 
//		this.pic2 = pic2;
//	}
//
//	@Override
//	public void run() {
//		int x = Unit.getX();
//		int y = Unit.getY();
//		runSpeed = (int)(Math.random()*10+1);
//		for(;;) {
//			try { Thread.sleep(1); } catch (InterruptedException e) {}
//			for(;flag;) {
//				try { Thread.sleep(runSpeed); } catch (InterruptedException e) {}
//				if(flag_start_stop == false) {
//					continue;
//				}
//				Unit.setLocation(x, y);
//				//try { Thread.sleep(runSpeed); } catch (InterruptedException e) {}
//				if(back== false) {
//					if(x == x1) {
//						y-=2;
//						Unit.setIcon(new ImageIcon(MyFrame.class.getResource(pic2)));
//					}
//					if(y == y4) {
//						x+=2;
//					}
//					if(y == y2) {
//						x-=2;
//					}
//					if(x == x3) {
//						y+=2;
//						Unit.setIcon(new ImageIcon(MyFrame.class.getResource(pic1)));
//					}
//					if(x == chkX && y == chkY) {
//						if(is) {
//							runSpeed = (int)(Math.random()*10+1);
//							back = true;
//							Unit.setIcon(new ImageIcon(MyFrame.class.getResource(pic2)));
//						}
//						else {
//							flag = false;
//							UnitChk.setFlag(true);
//							back = true;
//							runSpeed = (int)(Math.random()*10+1);
//						}	
//					}
//				}
//				else {
//					if(x == x1) {
//						y+=2;
//						Unit.setIcon(new ImageIcon(MyFrame.class.getResource(pic2)));
//					}
//					if(y == y4) {
//						x-=2;
//					}
//					if(y == y2) {
//						x+=2;
//					}
//					if(x == x3) {
//						Unit.setIcon(new ImageIcon(MyFrame.class.getResource(pic1)));
//						y-=2;
//					}
//					if(x == endX && y == endY) {
//						if(UnitCng == this) {
//							flag = false;
//						}
//						else {
//							flag = false;
//							UnitCng.getUnit().setIcon(new ImageIcon(MyFrame.class.getResource(UnitCng.getPic1())));
//							UnitCng.setFlag(true);
//							runSpeed = (int)(Math.random()*10+1);
//						}
//					}
//				}
//			}
//		}
//	}
//	void getChackPoint(int x1,int y1,int x2,int y2,int x3,int y3,int y4) {
//		this.x1 = x1;
//		this.y1 = y1;
//		this.x2 = x2;
//		this.y2 = y2;
//		this.x3 = x3;
//		this.y3 = y3;
//		this.y4 = y4;
//	}
//	boolean isFlag() {
//		return flag;
//	}
//	void setFlag(boolean flag) {
//		this.flag = flag;
//	}
//	JLabel getUnit() {
//		return Unit;
//	}
//	
//	void setChkPoint(CheckPoint UnitChk,CheckPoint UnitCng,boolean is) {
//		
//		this.UnitChk = UnitChk;
//		this.UnitCng = UnitCng;
//		this.is = is;
//		chkX = UnitChk.getUnit().getX();
//		chkY = UnitChk.getUnit().getY();
//	}
//
//	String getPic1() {
//		return pic1;
//	}
//
//	boolean isFlag_start_stop() {
//		return flag_start_stop;
//	}
//
//	void setFlag_start_stop(boolean flag_start_stop) {
//		this.flag_start_stop = flag_start_stop;
//	}
//}
