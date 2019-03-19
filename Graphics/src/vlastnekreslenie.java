import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class vlastnekreslenie extends JFrame implements AdjustmentListener,
        ActionListener, MouseListener, MouseMotionListener {

    private JButton farba;
    private JScrollBar scroll;
    private Graphics g;
    private boolean kresli;
    private int xp;
    private int yp;
    private int x;
    private int y;

    public vlastnekreslenie() {
        // TODO Auto-generated constructor stub

        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        BufferedImage im = new BufferedImage(600, 600,
                BufferedImage.TYPE_INT_RGB);
        g = im.getGraphics();
        JLabel lab = new JLabel(new ImageIcon(im));
        add(lab);
        setLayout(new GridBagLayout());

        farba = new JButton("FARBA");
        scroll = new JScrollBar(JScrollBar.VERTICAL, 1, 1, 1, 10);
        scroll.setPreferredSize(new Dimension(20, 200));
        scroll.addAdjustmentListener(this);
        add(farba);
        add(scroll);

        farba.addActionListener(this);

        lab.addMouseListener(this);
        lab.addMouseMotionListener(this);
        setVisible(true);

    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        // TODO Auto-generated method stub

        int h = e.getValue();
        ((Graphics2D) g).setStroke(new BasicStroke(h));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == farba) {

            Color farbapera = JColorChooser.showDialog(this, "VyberFarbu",
                    Color.YELLOW);

            if (farbapera != null) {
                g.setColor(farbapera);
            }
        }
    }

    public void mouseDragged (MouseEvent e) {
        // TODO Auto-generated method stub


        if(kresli){

            x=e.getX();
            y=e.getY();
            g.drawLine(xp, yp, x, y);
            xp=x;
            yp=y;
            repaint();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub


        kresli=true;
        xp=e.getX();
        yp=e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

        kresli=false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub


    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}