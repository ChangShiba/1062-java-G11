
	import java.awt.*;
	import javax.swing.*;
	import java.awt.event.*;

public class Gameover extends JFrame{

	    private JLabel name = new JLabel("ID");
	    private JTextField jname = new JTextField();
	    private JButton yes ;
	    private ButtonHandler hbtHandler = new ButtonHandler();  //處理按鈕事件 
	    
	    StartPanel rulePanel;
		Image rulebg = null;
		
		String filename;
		MP3 gameover_mp3;
		
	    public Gameover()
	    {
	        
	        Container c = getContentPane(); 
	        c.setLayout(null);
	        
	        JLabel Image = new JLabel(new ImageIcon("src/Resource/go.gif"));
	        Image.setBounds(0, 150 , 400, 200);    //设置 图片的横坐标、纵坐标、宽、高
	        c.add(Image); 
	        
	        //設定Jlb_ID大小位置及顯示字型
	    	name.setLocation(60,340);
	    	name.setSize(50,50);
	    	name.setFont(new Font("Gotham",Font.BOLD,30));
	    	name.setForeground(Color.white);
	        c.add(name);
	        
	        //設定帳號輸入框大小位置及顯示字型
	        jname.setLocation(110,340);
	        jname.setSize(210,50);
	        jname.setPreferredSize (new Dimension (60, 30));
	        jname.setBackground (new Color(36,58,81));
	    	jname.setFont(new Font("Gotham",Font.BOLD,25));
	        jname.setForeground(Color.white);
	        c.add(jname);
	        
	        
	        yes = new JButton("Yes");
	        yes.setOpaque(false);
	        yes.setFont(new Font("Gotham",Font.BOLD ,20) ) ;
	        yes.setForeground(Color.white);
	        yes.setContentAreaFilled(false);
	        yes.setLocation(150,400);
	        yes.setSize(100,30);
	        yes.addActionListener(hbtHandler);
	        c.add(yes);
	        
	        
	      
	         
	         rulePanel = new StartPanel();
	 		rulebg = Toolkit.getDefaultToolkit().getImage("src/Resource/gameover.jpeg");
	 		
	 		rulePanel.setImage(rulebg);
	 		rulePanel.setLayout(new java.awt.BorderLayout());
	 		//rulePanel.add(contentPanel, BorderLayout.CENTER);
	 		
	 		this.setTitle("GAME OVER");
	         this.setLayout(new java.awt.BorderLayout());
	         this.add(rulePanel, BorderLayout.CENTER);
	         this.setMinimumSize(new java.awt.Dimension(400, 600));
	         this.setResizable(false);
	         this.setLocationRelativeTo(null);
	         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	         this.setVisible(true);
	         
	         Thread gameAudio = new Thread() {
		         public void run() {
		        	 filename = "src/Resource/Game Over.mp3";
		        	 gameover_mp3 = new MP3(filename);
		        	 gameover_mp3.setLoop(true);
		        	 gameover_mp3.play();
		        	
		         }
		      };
		      gameAudio.start(); 
		     
	    } 
	    
	    private class ButtonHandler implements ActionListener 
	    {
	        public void actionPerformed(ActionEvent evtE) 
	        {
	            if(evtE.getSource() == yes)
	            {
	            	gameover_mp3.stop();
	                String pw = jname.getText();
	                System.out.println(""+pw.toString());
	                System.out.println("yes");
	                dispose();
	            }
	        }
	    }
	    
	    public static void main(String [] args)
	    {
	    	Gameover pw = new Gameover();
	    }
	}


