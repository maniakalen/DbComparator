package geo.peter.ui;

import javax.swing.*;

/**
 * Created by peter.georgiev on 02/11/2016.
 */
public class GuiHelper {

    public static void loading(JFrame root)
    {
        JPanel loading = new JPanel();
        loading.add(new JLabel("Loading..."));
        root.getContentPane().removeAll();
        root.getContentPane().add(loading);
        root.invalidate();
        root.pack();
    }
}
