
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

/*
 * 選單視窗
 */
public class StartFrame extends JFrame implements ActionListener
{
	Frame frame;
	StartPanel bgPanel = null;
    JPanel contentPanel = null;
    JLabel label = null;
    Image image = null;
	private JButton Start;
	private JButton Scores;
	private JButton Rule;
	private JButton Exit;
	boolean close=false;
	
    public StartFrame(){
    	super();
        // 1.生成元件
    	bgPanel = new StartPanel();
    	//請參考java swing 
    	//獲取默認工具包
    	image = Toolkit.getDefaultToolkit().getImage("Start.jpg");
    	contentPanel = new JPanel();
        ImageIcon icon = new ImageIcon("button.png"); 
        icon.setImage(icon.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
        
        // 2.設置要顯示之資訊與元件
        Start = new JButton("Start",icon);
        Start.setBounds(775,100,80,80);//start botton 位置大小
        Start.setOpaque(false);
        Start.setVerticalTextPosition(JButton.CENTER);
        Start.setHorizontalTextPosition(JButton.CENTER);  
        //Start.setBorder(null);
        Start.setContentAreaFilled(false);
        //Start.setSize(Start.getPreferredSize());
        contentPanel.add(Start);
        Start.addActionListener(this);
        Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              StartFrame.this.dispose();
            }
          });
        
        Scores = new JButton("Scores");
        Scores.setBounds(775,200,100,50);
        contentPanel.add(Scores);
        Scores.addActionListener(this);
    	Rule = new JButton("Rule");
    	Rule.setBounds(775,300,100,50);
    	contentPanel.add(Rule);
    	Rule.addActionListener(this);
    	Exit = new JButton("Exit");
    	Exit.setBounds(775,400,100,50);
    	contentPanel.add(Exit);
    	Exit.addActionListener(this);
    	//不要borderlayout
        contentPanel.setLayout(null);
        //透明化
        contentPanel.setOpaque(false);
        // 3.設置背景圖panel之設定與加入contentPanel
        bgPanel.setImage(image);
        bgPanel.setLayout(new java.awt.BorderLayout());
        bgPanel.add(contentPanel, BorderLayout.CENTER);
        // 4.設置frame之基本設定
        this.setTitle("Little Planet");
        this.setLayout(new java.awt.BorderLayout());
        this.add(bgPanel, BorderLayout.CENTER);
        this.setMinimumSize(new java.awt.Dimension(1000, 600));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
          
    }

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==Start) {
			try {
				frame = new Frame();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			frame.initFrame();
		}
		if(e.getSource()==Scores) {
			
		}
		if(e.getSource()==Rule) {
			new Rule();
		}
		if(e.getSource()==Exit) {
			dispose();
		}
	}
}