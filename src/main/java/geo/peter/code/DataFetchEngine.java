package geo.peter.code;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by peter.georgiev on 03/11/2016.
 */
public interface DataFetchEngine
{
    public ResultSet run() throws SQLException;
    public DataFetchEngine setConnection(Connection c);
}
