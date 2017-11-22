//Reuben Orihuela
//11/6/17
//OOP project 2
//Used for the button in the gui
public class NumOfUsers implements Visitor {
	int count = 0;

	public void visit(User a) {
		if (a instanceof Client) {
			count++;
		}
	}

	public int getNum() {
		return count;
	}
}