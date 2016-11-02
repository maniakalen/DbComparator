package geo.peter.code;

import geo.peter.ui.DbConnectFrame;
import geo.peter.ui.DbConnectionBlock;
import geo.peter.ui.GuiHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 * Created by peter.georgiev on 02/11/2016.
 */
public class CompareAction implements ActionListener {
    private DbConnectFrame frame;

    public CompareAction(DbConnectFrame frame)
    {
        super();
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame root = this.frame.parent;
        GuiHelper.loading(root);

    }
}
