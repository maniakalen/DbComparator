package geo.peter.code;

import geo.peter.ui.DbConnectionBlock;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by peter.georgiev on 02/11/2016.
 */
public class TableListComparator extends SwingWorker<Connection, Integer> {
    private DbConnectionBlock block;
    public TableListComparator(DbConnectionBlock block)
    {
        super();
        this.block = block;
    }

    @Override
    protected Connection doInBackground() throws Exception {

        String url = "jdbc:mysql://" + block.host.getText() + ":3306/" + block.db.getText();
        Connection con = DriverManager.getConnection(url, block.user.getText(), block.pass.getText());

        return con;
    }
}
