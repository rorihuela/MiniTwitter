//Reuben Orihuela
//11/6/17
//OOP Proj 2
import java.util.ArrayList;

import javax.swing.DefaultListModel;
//Class used to get Percentage of Positive tweets posted.
public class Positive implements Visitor {

	private int numPositive = 0;
	private int numWords = 0;

	String[] positiveWordsList = { "happy", "fantastic", "positive", "good", "great", "awesome", "amazing", "fantastic",
			"beautiful", "nice", "cute" };

	ArrayList<String> words = new ArrayList<>();

	//Counts number of words in the tweets
	public void visit(User a) {
		if (a instanceof Client) {
			DefaultListModel<String> news = ((Client) a).getNewsfeed();
			for (Object b : news.toArray()) {
				String[] buffer = ((String) b).split(" ");
				for (String t : buffer) {
					words.add(t.toLowerCase());
				}
			}
		}
		numWords = words.size();
		addPositiveCount();
	}

	//Compares words in the array list to those in the positive word list.
	private void addPositiveCount() {
		for (String positive : positiveWordsList) {
			if (words.contains(positive)) {
				words.remove(positive);
				numPositive++;
			}

		}
	}
	
	public int getPercentage() {
		if (numWords > 0)
			return numPositive*100/numWords;
		PopUp a = new PopUp();
		a.infoBox("Unable to retreive percentage", "Error");
		return 0;
		
	}

}