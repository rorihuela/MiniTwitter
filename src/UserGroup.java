import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

//Part Of Composite Design Pattern
public class UserGroup extends User {
	//Added long data type with to save creation time
	private String identification;
	private ArrayList<Client> groupUser = new ArrayList<>();
	private long creationTime;
	
	public String getID() {
		return identification;
	}
	
	public void setID(String id) {
		this.identification = id;
	}
	
	public String toString() {
		return this.getID();
	}

	public UserGroup(String id) {
		setID(id);
	}

	public void addUsers(String id) {
		Client a = new Client(id);
		groupUser.add(a);
		a.addGroup(this);

	}

	//New methods implemented
	public void setCreationTime(){
		this.creationTime = System.currentTimeMillis();
	}
	public long getCreationTime() {
		
		return creationTime;

	}
	public String format(long a){
		return (new SimpleDateFormat("hh:mm:ss:SSS")).format(a);

		
	}

}