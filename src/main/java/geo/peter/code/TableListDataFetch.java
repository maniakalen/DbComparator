package geo.peter.code;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by peter.georgiev on 03/11/2016.
 */
public class TableListDataFetch implements DataFetchEngine
{
    private Connection c;
    @Override
    public ResultSet run() throws SQLException
    {
        DatabaseMetaData md = this.c.getMetaData();
        return md.getTables(this.c.getCatalog(), null, "%", null);
    }

    @Override
    public DataFetchEngine setConnection(Connection c)
    {
        this.c = c;
        return this;
    }
}
