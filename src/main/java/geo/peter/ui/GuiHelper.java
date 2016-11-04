package geo.peter.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by peter.georgiev on 02/11/2016.
 */
public class GuiHelper {

    public static void loading(JFrame root)
    {
        JPanel loading = new JPanel();
        loading.add(new JLabel("Loading..."));
        GuiHelper.replaceFrame(root, loading);
    }

    public static void replaceFrame(JFrame root, JPanel with)
    {
        root.getContentPane().removeAll();
        root.getContentPane().add(with);
        root.invalidate();
        root.pack();
        GuiHelper.resetLocationCenter(root);
    }

    public static void resetLocationCenter(JFrame root)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        root.setLocation(dim.width/2-root.getSize().width/2, dim.height/2-root.getSize().height/2);
    }
}
