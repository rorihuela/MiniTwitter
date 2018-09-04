
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

@SuppressWarnings("serial")
public class AdminGui extends JFrame {
	private static AdminGui instance;

	// Signleton design
	public static AdminGui getInstance() {
		if (instance == null) {
			instance = new AdminGui();
		}
		return instance;
	}

	private JTree tree;

	public JTree getTree() {
		return tree;
	}

	private JButton verify;
	private JButton addGroup;
	private JButton addUser;
	private JButton seeUserPanel;
	private JButton seeNumUser;
	private JButton seeNumGroup;
	private JButton seeNumMessage;
	private JButton seePercentage;
	private JButton seeRecent;
	private JPanel panel;
	private JPanel treePanel;
	private JPanel userPanel;
	private JPanel groupPanel;
	private JTextField groupID;
	private JTextField userID;
	private JavaTree JavaTree;

	public JavaTree getJavaTree() {
		return JavaTree;
	}

	private PopUp popUp = new PopUp();

	public JButton getNoDuplicates() {
		return verify;
	}

	public JButton getAddGroup() {
		return addGroup;
	}

	public JButton getAddUser() {
		return addUser;
	}

	public JButton getSeeUserPanel() {
		return seeUserPanel;
	}

	public JButton getSeeNumUser() {
		return seeNumUser;
	}

	public JButton getSeeNumGroup() {
		return seeNumGroup;
	}

	public JButton getSeeNumMessage() {
		return seeNumMessage;
	}

	public JButton getSeePercentage() {
		return seePercentage;
	}

	public JButton getmostRecent() {
		return seeRecent;
	}

	public JPanel getGroupPanel() {
		return groupPanel;
	}

	public JTextField getGroupID() {
		return groupID;
	}

	public JTextField getUserID() {
		return userID;
	}

	private AdminGui() {
		createPanel();
		treeImplement();
		createButtons();
		createTextArea();
		this.setVisible(true);
	}

	private void createTextArea() {
		userPanel = new JPanel();
		userPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "User ID",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		userPanel.setBounds(300, 130, 230, 70);
		panel.add(userPanel);
		userPanel.setLayout(null);
		userID = new JTextField();
		userID.setBounds(10, 15, 210, 50);
		userPanel.add(userID);
		groupPanel = new JPanel();
		groupPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Group ID",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		groupPanel.setBounds(300, 30, 230, 70);
		panel.add(groupPanel);
		groupPanel.setLayout(null);
		groupID = new JTextField();
		groupID.setBounds(10, 15, 210, 50);
		groupPanel.add(groupID);

	}

	private void createPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Twitter");
		setBounds(100, 100, 760, 710);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
	}

	private void treeImplement() {

		treePanel = new JPanel();
		treePanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tree View",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		treePanel.setBounds(0, 10, 250, 670);
		panel.add(treePanel);
		treePanel.setLayout(null);
		JavaTree = new JavaTree();
		tree = new JTree(JavaTree.getModel());
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setBounds(0, 0, 235, 680);
		JScrollPane scrollPane = new JScrollPane(tree);
		scrollPane.setBounds(10, 21, 231, 638);
		treePanel.add(scrollPane);

		Icon leafIcon = UIManager.getIcon("FileView.fileIcon");
		Icon nonLeafIcon = UIManager.getIcon("FileView.directoryIcon");
		tree.setCellRenderer(new TreeStructure(leafIcon, nonLeafIcon));
	}

	private void createButtons() {

		addUser = new JButton("Add User");
		Handler handler = new Handler();
		addUser.addActionListener((ActionListener) handler);
		addUser.setBounds(540, 135, 170, 70);
		panel.add(addUser);

		addGroup = new JButton("Add Group");
		addGroup.addActionListener((ActionListener) handler);
		addGroup.setBounds(540, 34, 170, 70);
		panel.add(addGroup);

		seeUserPanel = new JButton("Open Twitter User data View");
		seeUserPanel.addActionListener((ActionListener) handler);
		seeUserPanel.setBounds(300, 245, 384, 70);
		panel.add(seeUserPanel);

		verify = new JButton("Verify No Duplicates");
		verify.addActionListener((ActionListener) handler);
		verify.setBounds(300, 380, 170, 70);
		panel.add(verify);

		seeRecent = new JButton("Last Updated User");
		seeRecent.addActionListener((ActionListener) handler);
		seeRecent.setBounds(540, 380, 170, 70);
		panel.add(seeRecent);

		seeNumUser = new JButton("Show User Total");
		seeNumUser.addActionListener((ActionListener) handler);
		seeNumUser.setBounds(300, 460, 170, 70);
		panel.add(seeNumUser);

		seeNumGroup = new JButton("Show Group Total");
		seeNumGroup.addActionListener(handler);
		seeNumGroup.setBounds(540, 540, 170, 70);
		panel.add(seeNumGroup);

		seeNumMessage = new JButton("Show Messages Total");
		seeNumMessage.addActionListener(handler);
		seeNumMessage.setBounds(300, 540, 170, 70);
		panel.add(seeNumMessage);

		seePercentage = new JButton("Show Positive Percentage");
		seePercentage.addActionListener(handler);
		seePercentage.setBounds(540, 460, 170, 70);
		panel.add(seePercentage);
	}

	public void setIcon() {
		tree.setCellRenderer(new DefaultTreeCellRenderer() {
			private Icon groupIcon = UIManager.getIcon("FileView.directoryIcon");
			private Icon userIcon = UIManager.getIcon("FileView.fileIcon");

			public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
					boolean isLeaf, int row, boolean focused) {
				Component c = super.getTreeCellRendererComponent(tree, value, selected, expanded, isLeaf, row, focused);
				if (isLeaf)
					setIcon(userIcon);
				else
					setIcon(groupIcon);
				return c;
			}
		});
	}

	public void OpenUserView(User user) {
		User node = getUser(this.tree);
		if (!(node instanceof User)) {
			popUp.infoBox("Operation not supported! No user view for groups!", "ERROR!");
			return;
		} else {
			new UserView((Client) node, JavaTree);
		}
	}

	public User getUser(JTree tree) {
		TreePath parentPath = tree.getSelectionPath();
		User selectedNode = null;
		if (parentPath == null) {
			selectedNode = (User) JavaTree.getModel().getRoot();
		} else {
			selectedNode = (User) (parentPath.getLastPathComponent());
		}
		return selectedNode;
	}

	private class Handler implements ActionListener {
		PopUp p = new PopUp();

		public void actionPerformed(ActionEvent e) {
			//New methods implemented for creating user and usergroup, now creates pop up with time created.
			User selectedNode = getUser(AdminGui.getInstance().getTree());

			if (e.getSource() == getAddGroup()) {
				String groupId = groupID.getText().trim();
				User newUserGroup = new UserGroup(groupId);
				if (groupId.isEmpty())
					return;
				if (JavaTree.addNode(selectedNode, newUserGroup)) {
					tree.scrollPathToVisible(new TreePath(newUserGroup.getPath()));
					newUserGroup.setCreationTime();
					p.infoBox(newUserGroup.format(newUserGroup.getCreationTime()), "Time Created");
				} else {
					return;
				}
			} else if (e.getSource() == getAddUser()) {
				String userId = userID.getText().trim();
				User newUser = new Client(userId);
				selectedNode = getUser(tree);
				if (userId.isEmpty())
					return;
				if (JavaTree.addNode(selectedNode, newUser)) {
					tree.scrollPathToVisible(new TreePath(newUser.getPath()));
					newUser.setCreationTime();
					p.infoBox(newUser.format(newUser.getCreationTime()), "Time Created");
				} else {
					return;
				}
			}

			else if (e.getSource() == AdminGui.getInstance().getSeeUserPanel()) {
				OpenUserView(selectedNode);
			} else {
				PopUp p = new PopUp();
				if (e.getSource() == AdminGui.getInstance().getSeeNumGroup()) {
					NumOfGroups numGroup = new NumOfGroups();
					JavaTree.invite(numGroup);
					p.infoBox(numGroup.GetNumOfGroups(), "Number of Groups");

				} else if (e.getSource() == AdminGui.getInstance().getSeeNumMessage()) {

					Messages messages = new Messages();
					JavaTree.invite(messages);
					p.infoBox(messages.getNumOfMessages(), "Number of Messages");

				} else if (e.getSource() == AdminGui.getInstance().getSeeNumUser()) {
					NumOfUsers userCount = new NumOfUsers();
					JavaTree.invite(userCount);
					p.infoBox(userCount.getNum(), "Number of Users");

				} else if (e.getSource() == AdminGui.getInstance().getSeePercentage()) {
					Positive words = new Positive();
					JavaTree.invite(words);
					p.infoBox(words.getPercentage() , "Percent of Positive Words");
				} else if (e.getSource() == AdminGui.getInstance().getNoDuplicates()) {
					//Simply prints our no duplicates, because there is a duplicate checker that was implemented previously
					p.infoBox("Currently no duplicates", "No Duplicate Verification");
				} else if (e.getSource() == AdminGui.getInstance().getmostRecent()) {
					RecentUpdate recent = new RecentUpdate();
					JavaTree.invite(recent);
					p.infoBox(recent.getRecent(), "Most Recent Update");

				}

			}

		}
	}
}