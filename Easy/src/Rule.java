package pp;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Rule extends JFrame{
	StartPanel rulePanel;
	Image rulebg = null;
	public Rule(){
		rulePanel = new StartPanel();
		rulebg = Toolkit.getDefaultToolkit().getImage("Rule.jpeg");
		
		rulePanel.setImage(rulebg);
		rulePanel.setLayout(new java.awt.BorderLayout());
		//rulePanel.add(contentPanel, BorderLayout.CENTER);
		
		this.setTitle("遊戲規則");
        this.setLayout(new java.awt.BorderLayout());
        this.add(rulePanel, BorderLayout.CENTER);
        this.setMinimumSize(new java.awt.Dimension(400, 600));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        this.setVisible(true);
	}
}