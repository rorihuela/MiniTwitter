//Reuben Orihuela
//11/7/17
//OOP Project 2
//Used for button in GUI
public class Messages implements Visitor{
	int numOfMessages= 0;
	public void visit (User a) {
		if (a instanceof Client) {
			numOfMessages += ((Client)a).getNewsfeed().size();
		}
	}
	
	public int getNumOfMessages() {
		return numOfMessages;
	}
}