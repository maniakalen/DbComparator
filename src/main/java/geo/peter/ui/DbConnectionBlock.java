package geo.peter.ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by peter.georgiev on 02/11/2016.
 */
public class DbConnectionBlock extends JPanel {

    public JTextField host;
    public JTextField user;
    public JTextField pass;
    public JTextField db;

    public DbConnectionBlock()
    {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.build();

        TitledBorder border = new TitledBorder(
                new LineBorder(Color.black),
                "Db connection options",
                TitledBorder.CENTER,
                TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        this.setBorder(border);
    }

    private void build()
    {
        this.host = new JTextField();
        this.add(this.buildBlock("Host", this.host));

        this.user = new JTextField();
        this.add(this.buildBlock("User", this.user));

        this.pass = new JPasswordField();
        this.add(this.buildBlock("Pass", this.pass));

        this.db = new JTextField();
        this.add(this.buildBlock("Schema", this.db));
    }
    private JPanel buildBlock(String label, JTextField field)
    {
        JPanel blockPanel = new JPanel();
        blockPanel.setLayout(new BoxLayout(blockPanel, BoxLayout.X_AXIS));
        field.setAlignmentX(Component.RIGHT_ALIGNMENT);

        Dimension size = new Dimension(150, 25);
        field.setPreferredSize(size);
        field.setSize(size);
        field.setMaximumSize(size);

        JLabel lbl = new JLabel(label);
        lbl.setAlignmentX(Component.RIGHT_ALIGNMENT);
        blockPanel.add(Box.createHorizontalGlue());
        blockPanel.add(lbl);
        blockPanel.add(Box.createRigidArea(new Dimension(5,0)));
        blockPanel.add(field);

        return blockPanel;
    }
}
