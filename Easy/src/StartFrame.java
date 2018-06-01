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
    	image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Start.jpg"));
        contentPanel = new JPanel();
        
        // 2.設置要顯示之資訊與元件
        Start = new JButton("Start");
        Start.setBounds(100,100,100,50);//start botton 位置大小
        contentPanel.add(Start);
        Start.addActionListener(this);
        Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              StartFrame.this.dispose();
            }
          });
        
        Scores = new JButton("Scores");
        Scores.setBounds(100,200,100,50);
        contentPanel.add(Scores);
        Scores.addActionListener(this);
    	Rule = new JButton("Rule");
    	Rule.setBounds(100,300,100,50);
    	contentPanel.add(Rule);
    	Rule.addActionListener(this);
    	Exit = new JButton("Exit");
    	Exit.setBounds(100,400,100,50);
    	contentPanel.add(Exit);
    	Exit.addActionListener(this);
        contentPanel.setLayout(null);
        contentPanel.setOpaque(false);
        // 3.設置背景圖panel之設定與加入contentPanel
        bgPanel.setImage(image);
        bgPanel.setLayout(new java.awt.BorderLayout());
        bgPanel.add(contentPanel, BorderLayout.CENTER);
        // 4.設置frame之基本設定
        this.setTitle("小莉歐遊戲");
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
		
	}
}