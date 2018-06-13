
import java.awt.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	public static void main(String[] args) {

		Timer t = new Timer();
		TimerTask tt = new TimerTask() {
			private int count = 10;

			public void run() {

				JLabel jl = new JLabel(String.valueOf(this.count));
				jl.setFont(new Font("", Font.BOLD, 42));
				JFrame f = new JFrame();
				JPanel pl2 = new JPanel();
				f.setVisible(true);
				f.setSize(new Dimension(300, 300));
				f.setLocation(470, 200);
				f.add(jl);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				f.dispose();
				this.count--;

				if (count == -1) {
					System.out.println("計時器停止了");
					t.cancel();
				}
			}
		};
		t.schedule(tt, 0, 1);

	}

}
