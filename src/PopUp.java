//Reuben Orihuela
//11/6/17
//OOP Project 2
import javax.swing.JOptionPane;

public class PopUp {
	public void infoBox(int i, String titleBar) {
		JOptionPane.showMessageDialog(null, i, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);

	}

		public void infoBox(long i, String titleBar) {
			JOptionPane.showMessageDialog(null, i, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);

		}

	public void infoBox(String string, String titleBar) {
		JOptionPane.showMessageDialog(null, string, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);

	}
}