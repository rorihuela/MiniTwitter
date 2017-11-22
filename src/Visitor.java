//Reuben Orihuela
//11/6/17
//OOP project 2
//Interface used to implement the visitor pattern
//Used by Groups; Messages; NumOfMessages; NumOfUsers; Positive
public interface Visitor {
    public void visit(User u);
}