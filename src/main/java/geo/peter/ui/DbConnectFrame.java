package geo.peter.ui;

import geo.peter.code.CompareAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by peter.georgiev on 02/11/2016.
 */
public class DbConnectFrame extends JPanel {

    public DbConnectionBlock leftBlock;
    public DbConnectionBlock rightBlock;

    public JFrame parent;
    public DbConnectFrame(JFrame parent)
    {
        super();
        this.parent = parent;
        this.build();
    }

    private void build()
    {
        this.leftBlock = new DbConnectionBlock();
        this.rightBlock = new DbConnectionBlock();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(450, 155));

        JPanel block = new JPanel();
        block.setLayout(new BoxLayout(block, BoxLayout.X_AXIS));

        block.add(this.leftBlock);
        block.add(this.rightBlock);

        this.add(block);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));

        JButton compare = new JButton("Compare");
        compare.addActionListener(new CompareAction(this));
        compare.setAlignmentX(Component.RIGHT_ALIGNMENT);
        buttons.add(compare);

        this.add(buttons);
    }
}
