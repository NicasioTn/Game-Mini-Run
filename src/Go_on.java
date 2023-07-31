import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Go_on {
	public static void main(String[] args) {
		MyFrame run = new MyFrame();
		run.setVisible(true);
	}
}
class MyFrame extends JFrame implements ActionListener{
	
	int chk = 0;

	Count count = new Count();
	
	JButton start;
	JButton reset;
	
	JLabel Unit1,Unit1_1,Unit1_2;
	JLabel Unit2,Unit2_1,Unit2_2;
	JLabel Unit3,Unit3_1,Unit3_2;
	JLabel Time,Time1,Time2,Time3;
	JLabel Txt1,Txt2,Txt3,Txt4;
	JLabel Winner;
	
	JPanel content;
	
	CheckPoint runUnit1, runUnit1_1,runUnit1_2;
	CheckPoint runUnit2,runUnit2_1,runUnit2_2;
	CheckPoint runUnit3,runUnit3_1,runUnit3_2;
	
	CheckPoint all[];
	
	MyWatchThread thread;
	boolean flagTime = false;
	
	public MyFrame() {
		
		setTitle("Program Mini Game Run");
		setSize(1285, 715);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		content = new JPanel();
		content.setBackground(new Color(182, 67, 41));
		content.setLayout(null);
		setContentPane(content);
		
		start = new JButton("Start/Stop");
		start.setBounds(20, 5, 100, 30);
		start.setFocusable(false);
		start.setBackground(Color.yellow.brighter());
		content.add(start);
		
		reset = new JButton("Reset");
		reset.setBounds(140, 5, 100, 30);
		reset.setFocusable(false);
		reset.setBackground(Color.red.brighter());
		reset.addActionListener(this);
		content.add(reset);
		
		Time = new JLabel("00:00:000");
		Time.setBounds(300,5,100,30);
		content.add(Time);
		
		Time1 = new JLabel("TEAM A");
		Time1.setBounds(450,5,100,30);
		content.add(Time1);
		
		Time2 = new JLabel("TEAM B");
		Time2.setBounds(650,5,100,30);
		content.add(Time2);
		
		Time3 = new JLabel("TEAM C");
		Time3.setBounds(850,5,100,30);
		content.add(Time3);
		
		Winner = new JLabel("Winner");
		Winner.setBounds(1050,5,100,30);
		content.add(Winner);
		
		Txt1 = new JLabel("");
		Txt1.setBounds(445,40,100,30);
		content.add(Txt1);
		
		Txt2 = new JLabel("");
		Txt2.setBounds(645,40,100,30);
		content.add(Txt2);
		
		Txt3 = new JLabel("");
		Txt3.setBounds(845,40,100,30);
		content.add(Txt3);
		
		Txt4 = new JLabel("");
		Txt4.setBounds(1045,40,100,30);
		content.add(Txt4);

		JPanel bar = new JPanel();
		bar.setBackground(new Color(0,0,0));
		bar.setBounds(0, 0, 1270, 80);
		bar.setLayout(null);
		content.add(bar);
		
		JLabel image = new JLabel();
        image.setBounds(0, 80, 1280, 600);
        image.setIcon(new ImageIcon(MyFrame.class.getResource("bk.png")));
        content.add(image);
        
        //len1------------------------------------
        Unit1 = new JLabel();     
        Unit1_1 = new JLabel();  
        Unit1_2 = new JLabel();       
        
        //len2------------------------------------
        Unit2 = new JLabel();
        Unit2_1 = new JLabel();
        Unit2_2 = new JLabel();

        //len3------------------------------------
        Unit3 = new JLabel();
        Unit3_1 = new JLabel();
        Unit3_2 = new JLabel();
        
        reset();
        
        image.add(Unit1); 
        image.add(Unit1_1); 
        image.add(Unit1_2); 
        image.add(Unit2); 
        image.add(Unit2_1); 
        image.add(Unit2_2); 
        image.add(Unit3); 
        image.add(Unit3_1); 
        image.add(Unit3_2); 
        //--------------------------------------------------------------------------------------------
        start.addActionListener(this) ;
        
 
        
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == start)
		{
			for (int i = 0; i < all.length; i++) {
				if(all[i].isFlag_start_stop()) {
					all[i].setFlag_start_stop(false);
					this.thread.setFlag(false);
					//this.flagTime = false;
				}
				else {
					all[i].setFlag_start_stop(true);
					this.thread.setFlag(true);
			      	//this.flagTime = true;
				}  	
			}
			if(chk == 0) {
				runUnit1.setFlag(true);
				runUnit2.setFlag(true);
				runUnit3.setFlag(true);
				chk++;
				this.thread.start();
		      	this.thread.setFlag(true);
		      	//this.flagTime = true;
			}
		}
		if(e.getSource() == reset)
		{
			for(int i = 0; i < all.length; i++) {
				all[i].setFlag_start_stop(false);

			}
			Time.setText("00:00:000");
			thread.setFlag(false);
			Txt1.setText("");
			Txt2.setText("");
			Txt3.setText("");
			Txt4.setText("");
			count.setCount(0);
			reset();
			chk = 0;
		}
		
	}
	
	void reset()
	{ 
			thread = new MyWatchThread(Time);
			
	        Unit1.setBounds(790, 550, 50, 33);
	        Unit1.setIcon(new ImageIcon(MyFrame.class.getResource("CAT1-R.gif")));
	        Unit1_1.setBounds(1180, 10, 44, 40);
	        Unit1_1.setIcon(new ImageIcon(MyFrame.class.getResource("CAT2-L.gif")));
	        Unit1_2.setBounds(10, 370, 40, 40);
	        Unit1_2.setIcon(new ImageIcon(MyFrame.class.getResource("CAT3-R.gif")));
	        
	        runUnit1_2 = new CheckPoint(Unit1_2,"CAT3-R.gif","CAT3-L.gif",thread,Txt3,Txt4,count);
	        runUnit1_2.getChackPoint(1220, 10, 10, 550);        
	        runUnit1_1 = new CheckPoint(Unit1_1,"CAT2-R.gif","CAT2-L.gif",thread,Txt3,Txt4,count);
	        runUnit1_1.getChackPoint(1220, 10, 10, 550);          
	        runUnit1 = new CheckPoint(Unit1,"CAT1-R.gif","CAT1-L.gif",thread,Txt3,Txt4,count);
	        runUnit1.getChackPoint(1220, 10, 10, 550);        
	        
	        runUnit1.setChkPoint(runUnit1_1, runUnit1,false);
	        runUnit1_1.setChkPoint(runUnit1_2, runUnit1,false);
	        runUnit1_2.setChkPoint(runUnit1, runUnit1_1,true);
	        
	        runUnit1.setTeamName("TEAM C");
	       
	        runUnit1.start();
	        runUnit1_1.start();
	        runUnit1_2.start();
	        
	        Unit2.setBounds(690, 500, 40, 40);
	        Unit2.setIcon(new ImageIcon(MyFrame.class.getResource("RUN1-R.gif")));  
	        Unit2_1.setBounds(1080, 60, 40, 40);
	        Unit2_1.setIcon(new ImageIcon(MyFrame.class.getResource("RUN2-L.gif"))); 	       
	        Unit2_2.setBounds(60, 280, 40, 40);
	        Unit2_2.setIcon(new ImageIcon(MyFrame.class.getResource("RUN3-R.gif")));
	        
	        runUnit2 = new CheckPoint(Unit2,"RUN1-R.gif","RUN1-L.gif",thread,Txt2,Txt4,count);
	        runUnit2.getChackPoint(1170, 60, 60, 500);
	        runUnit2_1 = new CheckPoint(Unit2_1,"RUN2-R.gif","RUN2-L.gif",thread,Txt2,Txt4,count);
	        runUnit2_1.getChackPoint(1170, 60, 60, 500);
	        runUnit2_2 = new CheckPoint(Unit2_2,"RUN3-R.gif","RUN3-L.gif",thread,Txt2,Txt4,count);
	        runUnit2_2.getChackPoint(1170, 60, 60, 500);
	        
	        runUnit2.setChkPoint(runUnit2_1, runUnit2, false);
	        runUnit2_1.setChkPoint(runUnit2_2, runUnit2, false);
	        runUnit2_2.setChkPoint(runUnit2, runUnit2_1, true);
	        
	        runUnit2.setTeamName("TEAM B");
	        
	        runUnit2.start();
	        runUnit2_1.start();
	        runUnit2_2.start();
	        
	        Unit3.setBounds(590, 440, 40, 40);
	        Unit3.setIcon(new ImageIcon(MyFrame.class.getResource("CAT2-R.gif")));        
	        Unit3_1.setBounds(960, 120, 40, 40);
	        Unit3_1.setIcon(new ImageIcon(MyFrame.class.getResource("CAT2-R.gif")));	       
	        Unit3_2.setBounds(120, 170, 40, 40);
	        Unit3_2.setIcon(new ImageIcon(MyFrame.class.getResource("CAT2-R.gif")));
	       
	        runUnit3 = new CheckPoint(Unit3,"CAT2-L.gif","CAT2-R.gif",thread,Txt1,Txt4,count);
	        runUnit3.getChackPoint(1110, 120, 120, 440);
	        runUnit3_1 = new CheckPoint(Unit3_1,"CAT2-L.gif","CAT2-R.gif",thread,Txt1,Txt4,count);
	        runUnit3_1.getChackPoint(1110, 120, 120, 440);
	        runUnit3_2 = new CheckPoint(Unit3_2,"CAT2-L.gif","CAT2-R.gif",thread,Txt1,Txt4,count);
	        runUnit3_2.getChackPoint(1110, 120, 120, 440);
	        
	        runUnit3.setChkPoint(runUnit3_1, runUnit3, false);
	        runUnit3_1.setChkPoint(runUnit3_2, runUnit3, false);
	        runUnit3_2.setChkPoint(runUnit3, runUnit3_1, true);
	        
	        runUnit3.setTeamName("TEAM A");
	        
	        runUnit3.start();
	        runUnit3_1.start();
	        runUnit3_2.start();
	        
	        CheckPoint all[] = {runUnit1,runUnit1_1,runUnit1_2,runUnit2,runUnit2_1,runUnit2_2,runUnit3,runUnit3_1,runUnit3_2};
	        this.all = all;
	        
	  
	}
           
}
class CheckPoint extends Thread{
	
	String teamName = "";
	JLabel Unit;
	JLabel score,win;
	int runSpeed;
	Count count;
	boolean winner = true;
	
	CheckPoint UnitChk;
	CheckPoint UnitCng;
	
	MyWatchThread thread;
	
	private boolean flag = false,
					back = false, 
					is = false,
					flag_start_stop = false;
					
				
	
	int x1 = 0, x3 = 0;
	int y2 = 0, y4 =0;
	
	int chkX = 0, chkY = 0;
	
	int endX = 0, endY = 0;
	
	String pic1,pic2;
	public CheckPoint(JLabel Unit,String pic1,String pic2,MyWatchThread thread,JLabel score,JLabel win,Count count) {
		this.Unit = Unit;
		this.score = score;
		this.win = win;
		this.count = count;
		
		endX = Unit.getX();
		endY = Unit.getY();
		
		this.pic1 = pic1; 
		this.pic2 = pic2;
		this.thread = thread;
	}

	@Override
	public void run() {
		int x = Unit.getX();
		int y = Unit.getY();
		runSpeed = (int)(Math.random()*15+1);
		for(;;) {
			try { Thread.sleep(1); } catch (InterruptedException e) {}
			for(;flag;) {
				try { Thread.sleep(runSpeed); } catch (InterruptedException e) {}
				if(flag_start_stop == false) {
					continue;
				}
				Unit.setLocation(x, y);
				if(back== false) {
					if(x == x1) {
						y-=2;
						Unit.setIcon(new ImageIcon(MyFrame.class.getResource(pic2)));
					}
					if(y == y4) {
						x+=2;
					}
					if(y == y2) {
						x-=2;
					}
					if(x == x3) {
						y+=2;
						Unit.setIcon(new ImageIcon(MyFrame.class.getResource(pic1)));
					}
					if(x == chkX && y == chkY) {
						if(is) {
							runSpeed = (int)(Math.random()*15+1);
							back = true;
							Unit.setIcon(new ImageIcon(MyFrame.class.getResource(pic2)));
						}
						else {
							flag = false;
							UnitChk.setFlag(true);
							back = true;
							runSpeed = (int)(Math.random()*15+1);
						}	
					}
				}
				else {
					if(x == x1) {
						y+=2;
						Unit.setIcon(new ImageIcon(MyFrame.class.getResource(pic2)));
					}
					if(y == y4) {
						x-=2;
					}
					if(y == y2) {
						x+=2;
					}
					if(x == x3) {
						Unit.setIcon(new ImageIcon(MyFrame.class.getResource(pic1)));
						y-=2;
					}
					if(x == endX && y == endY) {
						if(UnitCng == this) {
							flag = false;
							String Time = thread.getTime().getText();
							score.setText(Time);
							count.setCount(count.getCount() + 1);
							if(count.getCount() == 1) {
								count.setWinner(teamName);
							}
							if(count.getCount() == 3) {
								win.setText(count.getWinner());
								thread.setFlag(false);
							}
						}		
						else {
							flag = false;
							UnitCng.getUnit().setIcon(new ImageIcon(MyFrame.class.getResource(UnitCng.getPic1())));
							UnitCng.setFlag(true);
							runSpeed = (int)(Math.random()*15+1);
						}
					}
				}
			}
		}
	}
	void getChackPoint(int x1,int y2,int x3,int y4) {
		this.x1 = x1;
		this.y2 = y2;
		this.x3 = x3;
		this.y4 = y4;
	}
	boolean isFlag() {
		return flag;
	}
	void setFlag(boolean flag) {
		this.flag = flag;
	}
	JLabel getUnit() {
		return Unit;
	}
	
	void setChkPoint(CheckPoint UnitChk,CheckPoint UnitCng,boolean is) {
		
		this.UnitChk = UnitChk;
		this.UnitCng = UnitCng;
		this.is = is;
		chkX = UnitChk.getUnit().getX();
		chkY = UnitChk.getUnit().getY();
	}

	String getPic1() {
		return pic1;
	}

	boolean isFlag_start_stop() {
		return flag_start_stop;
	}

	void setFlag_start_stop(boolean flag_start_stop) {
		this.flag_start_stop = flag_start_stop;
	}

	void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
class MyWatchThread extends Thread {

	JLabel Time;
	private boolean flag = false;
	DecimalFormat hms = new DecimalFormat("00");
	DecimalFormat ms = new DecimalFormat("000");

	public MyWatchThread(JLabel label) {
		this.Time = label;
	}

	@Override
	public void run() {
		int m=0,s=0,ms=0;
		for(;;) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {}
			for(;flag;) {
				try {			
					ms++;
					if(ms == 1000) {
						s++;
						ms = 0;
					}
					if(s == 60) {
						m++;
						s = 0;
					}
					Time.setText(hms.format(m)+":"+hms.format(s)+":"+this.ms.format(ms));
					Thread.sleep(1);
				} catch (InterruptedException e) {}
			}
		}
	}

	boolean isFlag() {
		return flag;
	}

	void setFlag(boolean flag) {
		this.flag = flag;
	}

	JLabel getTime() {
		return Time;
	}
}
class Count {
	private String winner = "";
	private int count = 0;

	int getCount() {
		return count;
	}

	void setCount(int count) {
		this.count = count;
	}

	String getWinner() {
		return winner;
	}

	void setWinner(String winner) {
		this.winner = winner;
	}
}