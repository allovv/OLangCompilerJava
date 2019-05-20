//Графический интерфейс "O Debug"

import javax.swing.*;
import java.awt.*;

public class OLangGUI extends JFrame {
    private JPanel panel;
    private JLabel label;

    public void initLabel ()
    {
        label = new JLabel();
        label.setFont(new Font("Serif", Font.PLAIN, 25));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);
        //label.setIcon(new ImageIcon(getImage("bomb")));

        /*
        label1 = new JLabel();
        label1.setText(COMPLEXITY);
        label1.setFont(new Font("Serif", Font.PLAIN, 25));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setOpaque(true);
        label1.setBackground(Color.LIGHT_GRAY);
        */

        add(label, BorderLayout.NORTH);
        //add(label1, BorderLayout.SOUTH);

    }

    public void  initPanel()
    {
        panel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
            }
        };

        panel.setPreferredSize (new Dimension(400, 400)); //размер панели
        add (panel); //добавленеи панели
    }

    public void initFrame ()
    {
        /*Следующий блок - создание стандартного фрейма*/
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //закрытие программы
        setTitle("Сапёр"); //заголовок
        setResizable(false); //произвольное изменение размера окна
        setVisible(true); //чтобы форму стало видно
        pack();   //изменение размера формы (устанавливает минимально возможный размер)
        setLocationRelativeTo(null); //заголовок по центру
        //setIconImage(getImage("icon")); //установка иконки программы
        Font font = new Font("Verdana", Font.PLAIN, 11);
        pack();   //изменение размера формы (устанавливает минимально возможный размер)
    }
}