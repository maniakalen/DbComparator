package geo.peter.code;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by peter.georgiev on 25/11/2016.
 */
public class DbDataComparator extends SwingWorker<Integer, HashMap<Integer, DefaultTableModel>> {
    private TableListDataModel m1;
    private TableListDataModel m2;
    public DbDataComparator(TableListDataModel model1, TableListDataModel model2) {
        super();
        m1 = model1;
        m2 = model2;
    }

    @Override
    protected Integer doInBackground() throws Exception {
        int c1 = m1.getRowCount();
        int c2 = m2.getRowCount();
        outer: for (int i = 0; i < c1; i++) {
            for (int j = 0; j < c2; j++) {
                if (m1.getValueAt(i,0).equals(m2.getValueAt(j,0))) {
                    continue outer;
                }
            }
            m1.setRowColor(i, Color.GREEN);
            HashMap<Integer, DefaultTableModel> map = new HashMap<>();
            map.put(i, m1);
            publish(map);
        }
        outer2: for (int i = 0; i < c2; i++) {
             for (int j = 0; j < c1; j++) {
                if (m2.getValueAt(i,0).equals(m1.getValueAt(j,0))) {
                    continue outer2;
                }
            }
            m2.setRowColor(i, Color.GREEN);
            HashMap<Integer, DefaultTableModel> map = new HashMap<>();
            map.put(i, m2);
            publish(map);
        }
        return 0;
    }

    @Override
    protected void process(List<HashMap<Integer, DefaultTableModel>> chunks) {

        for (HashMap m : chunks) {
            Set keys = m.keySet();
            for (Object i : keys.toArray()) {
                Integer ii = (Integer)i;
                DefaultTableModel model = (DefaultTableModel)m.get(ii);
                model.fireTableRowsUpdated(ii,ii);
            }
        }
    }
}
