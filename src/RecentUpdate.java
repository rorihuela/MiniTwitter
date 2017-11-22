
public class RecentUpdate implements Visitor {
//Iterates through all clients and returns the ID of the client with the highest update time.
	Client a;
	long highest = 0;

	public void visit(User b) {
		if (b instanceof Client) {
			if (((Client) b).getUpdateTime() > highest) {
				highest = ((Client) b).getUpdateTime();
				this.a = (Client) b;

			}
		}
	}

	public String getRecent() {
		return a.getID();
	}

}
