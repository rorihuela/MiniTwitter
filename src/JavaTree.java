import java.util.HashMap;
import java.util.Map;
import javax.swing.tree.DefaultTreeModel;

public class JavaTree implements Host {
	private DefaultTreeModel tree;
	private Map<String, User> data;
	private User root;

	public JavaTree() {
		root = new UserGroup("Root");
		this.data = new HashMap<String, User>();
		this.tree = new DefaultTreeModel(root);
	}

	public User getTreeRoot() {
		return root;
	}

	public void invite(Visitor a) {
		for (Map.Entry<String, User> b : data.entrySet()) {
			a.visit(b.getValue());
		}
	}

	public DefaultTreeModel getModel() {
		return tree;
	}

	public boolean addNode(User parent, User child) {
		if (contains(child.getID())) {
			System.out.println("Error, no duplicate allowed");
			return false;
		}
		if (parent instanceof Client) {
			System.out.println("Error, not added");
			return false;
		}
		data.put(child.getID(), child);
		tree.insertNodeInto(child, parent, parent.getChildCount());
		return true;
	}

	public boolean contains(String identification) {
		return data.containsKey(identification);
	}

	public User getUser(String ID) {
		if (contains(ID)) {
			return data.get(ID);
		}
		return null;
	}

}