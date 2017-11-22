//Reuben Orihuela
//11.6.17
//OOP project 2

//Opens a userview window when user is selected in the Jtree
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UserView extends JFrame {
	private static Client currentClient; 
	private JavaTree treeImplement;
	private javax.swing.JTree treeImplements;
	private PopUp window = new PopUp();
	private JTextArea id;
	private JTextArea tweet; 
	private JList<Information> followingsList;
	private JList<String> newsFeedList;
	private JButton follow; 
	private JButton addTweet;
	private DefaultListModel<Information> modelFollowings;
	private JPanel following;
	private JPanel tweetPanel;
	private JPanel idPanel;
	private JPanel newsFeedPanel;
	private JPanel contentPane;
	private	ClientHandler handler=new ClientHandler();

	//Constructors start
	public UserView(Client node, JavaTree JTree) {
		this.currentClient=node;
		this.treeImplement=JTree;
		currentClient.getNewsfeed();
		this.modelFollowings=currentClient.getFollowing();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initializeWindow();
		showFollowing();
		showNewsFeed();
		createTweetPanel();
		createIDPanel();
		createButtons();
		this.setVisible(true);

	}
	public UserView(Client node, JTree tree) {
		this.currentClient=node;
		this.treeImplements=tree;
		currentClient.getNewsfeed();
		this.modelFollowings=currentClient.getFollowing();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initializeWindow();
		showFollowing();
		showNewsFeed();
		createTweetPanel();
		createIDPanel();
		createButtons();
		this.setVisible(true);
	}
	//Constructors end
	private void initializeWindow(){
		
		setTitle(currentClient.getID()+"'s "+"Feed");
		setBounds(100, 100, 477, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private void showFollowing(){
		following = new JPanel();
		following.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Following:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		following.setBounds(0, 56, 469, 119);
		contentPane.add(following);
		following.setLayout(null);
		followingsList=new JList<Information>((ListModel<Information>) modelFollowings);
		JScrollPane scrollPane = new JScrollPane(followingsList);
		scrollPane.setBounds(10, 16, 449, 92);
		following.add(scrollPane);
	}
	private void showNewsFeed(){
		newsFeedPanel = new JPanel();
		newsFeedPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "News Feed", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		newsFeedPanel.setBounds(0, 235, 465, 170);
		contentPane.add(newsFeedPanel);
		newsFeedPanel.setLayout(null);
		newsFeedList=new JList<String>((ListModel<String>) currentClient.getNewsfeed());
		JScrollPane scrollPane_1 = new JScrollPane(newsFeedList);
		scrollPane_1.setBounds(10, 21, 445, 139);
		newsFeedPanel.add(scrollPane_1);
	}
	private void createTweetPanel(){
		tweetPanel = new JPanel();
		tweetPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Message", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tweetPanel.setBounds(10, 179, 290, 59);
		contentPane.add(tweetPanel);
		tweetPanel.setLayout(null);
		tweet = new JTextArea();
		tweet.setBounds(6, 16, 274, 32);
		tweetPanel.add(tweet);
	}
	private void createIDPanel(){

		idPanel = new JPanel();
		idPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Client ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		idPanel.setBounds(0, 0, 290, 59);
		contentPane.add(idPanel);
		idPanel.setLayout(null);

		id = new JTextArea();
		id.setBounds(6, 16, 274, 36);
		idPanel.add(id);
	}
	
	private void createButtons(){
	
		addTweet = new JButton("Post Tweet");
		addTweet.setBounds(322, 188, 125, 36);
		addTweet.addActionListener((ActionListener) handler);
		getContentPane().add(addTweet);


		follow = new JButton("Follow Client");
		follow.setBounds(322, 10, 125, 35);
		follow.addActionListener(handler);
		getContentPane().add(follow);
	}
	

	public boolean alreadyFollowingClient(User user) {
		DefaultListModel<Information> array= currentClient.getFollowing();
		for(Object check:array.toArray()){
			if(check.equals(user))
				return true;
		}
		 return false;
	}
	public boolean followingOwn(User user) {
		return false;
	}
	public void follow(Client userToFollow) {
		this.currentClient.follow((Client) userToFollow);
	}
	public void tweet(String msg) {
		this.currentClient.postTweet(msg);
	}
	private class ClientHandler implements ActionListener{
		PopUp p = new PopUp();


		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==follow){
				String ClientId=id.getText().trim();
				User node=null;
				
				if(treeImplement.getUser(ClientId)!=null){
					node=treeImplement.getUser(ClientId);
				}
				else {
					window.infoBox("User not found!","ERROR!");
					return;
				}
				if(alreadyFollowingClient(node)){
					window.infoBox("Already following user", "ERROR!");
					return;
				}
				else if(!(node instanceof Client)){
					window.infoBox("Operation not supported. Only follow Individual Clients can be followed!","ERROR!");
				}
				else{
					follow((Client)node);
				}
			}
			
			if(e.getSource()==addTweet){
				String msg=tweet.getText().trim();
				tweet(msg);
				UserView.currentClient.setUpdateTime();
				p.infoBox(UserView.currentClient.format(UserView.currentClient.getUpdateTime()), "Time Updated");
			}
		}
		
	}

}