import javax.swing.tree.DefaultTreeCellRenderer;

import java.awt.Component;

import javax.swing.Icon;
public class TreeStructure extends DefaultTreeCellRenderer {
Icon leaf;
Icon nonLeaf;

public TreeStructure (Icon leaf, Icon nonleaf) {
	this.leaf = leaf;
	this.nonLeaf =  nonleaf;
}

public Component getTreeCellComponent(javax.swing.JTree tree, 
		Object value, boolean sel, boolean expanded, boolean isleaf, int row, boolean hasFocus  ) {
	super.getTreeCellRendererComponent(tree, value, sel, expanded, isleaf, row, hasFocus);
if (value instanceof User) {
	setIcon (leaf);
}
	else {
		setIcon (nonLeaf);
	}
	return this;
}
}
	