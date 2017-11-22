//Reuben Orihuela
//11/6/17
//OOp project 2
import javax.swing.tree.DefaultMutableTreeNode;

//Abstract class used for composite design pattern
@SuppressWarnings("serial")
public abstract class User extends DefaultMutableTreeNode  {
 //Treat users and groups as similar objects for a leaf-tree relationship
    public abstract String getID();
    public abstract void setID(String id);
    public abstract String toString();
    public abstract void setCreationTime();
    public abstract long getCreationTime();
    public abstract String format(long a);


    
}