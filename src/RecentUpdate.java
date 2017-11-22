
public class RecentUpdate implements Visitor {

	Client a;
long highest = 0;
	public void visit(User b) {
			if (((Client) b).getUpdateTime()> highest){
				this.a = (Client) b;
			
		}
	}
	
	public String getRecent(){
		return a.getID();
	}

}
