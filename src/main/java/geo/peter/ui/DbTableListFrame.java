package geo.peter.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by peter.georgiev on 03/11/2016.
 */
public class DbTableListFrame extends JPanel
{
    public DbTableListBlock left;
    public DbTableListBlock right;

    public JFrame parent;
    public DbTableListFrame(JFrame frame)
    {
        super();
        this.parent = frame;
        this.build();
    }

    private void build()
    {
        this.left = new DbTableListBlock();
        this.right = new DbTableListBlock();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(950, 655));

        JPanel block = new JPanel();
        block.setLayout(new BoxLayout(block, BoxLayout.X_AXIS));

        block.add(this.left);
        block.add(this.right);
        /*BoundedRangeModel scrollModel = this.left.scroll.getVerticalScrollBar().getModel();
        this.right.scroll.getVerticalScrollBar().setModel( scrollModel );*/
        this.add(block);
    }
}
