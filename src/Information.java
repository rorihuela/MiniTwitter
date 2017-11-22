//Reuben Orihuela
//11/6/17
//OOP Project 2
//Works with observer design to update info
public interface Information {

	public void setObserver (Observer a);
	
	public void contactObserver();
	
	public String getUpdate (Observer a);
}