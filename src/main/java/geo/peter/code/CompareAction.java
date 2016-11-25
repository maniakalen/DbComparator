package geo.peter.code;

import geo.peter.ui.DbConnectFrame;
import geo.peter.ui.DbConnectionBlock;
import geo.peter.ui.DbTableListFrame;
import geo.peter.ui.GuiHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by peter.georgiev on 02/11/2016.
 */
public class CompareAction implements ActionListener, DbDataTaskListener {
    private DbConnectFrame frame;
    private DbDataFetcher f1;
    private DbDataFetcher f2;
    private DbDataComparator comparator;

    public CompareAction(DbConnectFrame frame)
    {
        super();
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame root = this.frame.parent;
        try {

            this.validateConnectionData((this.frame.leftBlock));
            this.validateConnectionData((this.frame.rightBlock));
            GuiHelper.loading(root);
            DbTableListFrame tbList = new DbTableListFrame(root);
            comparator = new DbDataComparator(tbList.left.model, tbList.right.model);
            f1 = new DbDataFetcher(this.frame.leftBlock, new TableListDataFetch(), tbList.left.model, this);
            f2 = new DbDataFetcher(this.frame.rightBlock, new TableListDataFetch(), tbList.right.model, this);
            f1.execute();
            f2.execute();
            GuiHelper.replaceFrame(root, tbList);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(root, "Failed to fetch data");
            GuiHelper.replaceFrame(root, this.frame);
        }
    }

    private void validateConnectionData(DbConnectionBlock block) throws Exception
    {
        if (block.host.getText().equals("")) {
            throw new Exception("Host not set");
        }
        if (block.user.getText().equals("")) {
            throw new Exception("User not set");
        }
        if (block.db.getText().equals("")) {
            throw new Exception("Database not set");
        }
    }

    @Override
    public void fireSwingTaskDone() {
        if (f1.isDone() && f2.isDone() && comparator != null) {
            comparator.execute();
        }
    }
}
