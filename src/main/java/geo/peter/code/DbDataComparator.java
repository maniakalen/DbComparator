package geo.peter.code;

import com.mysql.cj.jdbc.Driver;
import geo.peter.ui.DbConnectionBlock;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

/**
 * Created by peter.georgiev on 02/11/2016.
 */
public class DbDataComparator extends SwingWorker<Void, Vector> {
    private DbConnectionBlock block;
    private DataFetchEngine engine;
    private DefaultTableModel tableModel;
    public DbDataComparator(DbConnectionBlock block, DataFetchEngine engine, DefaultTableModel model)
    {
        super();
        this.block = block;
        this.engine = engine;
        this.tableModel = model;
    }

    @Override
    protected Void doInBackground() throws Exception {
        try {
            String url = "jdbc:mysql://" + block.host.getText() + ":3306/" + block.db.getText();
            Class.forName("com.mysql.cj.jdbc.Driver");
            String pass = block.pass.getText();
            if (pass.equals("")) {
                pass = null;
            }
            Connection con = DriverManager.getConnection(url, block.user.getText(), pass);
            ResultSet result = engine.setConnection(con).run();
            Vector<String> v;
            while (result.next()) {
                v = new Vector<>();
                v.add(result.getString(3));
                publish(v);
            }
        } catch (Exception ex) {
            this.cancel(true);
        }
        return null;
    }
    @Override
    protected void process(List<Vector> chunks) {
        for (Vector v : chunks) {
            this.tableModel.addRow(v);
        }
    }
}
