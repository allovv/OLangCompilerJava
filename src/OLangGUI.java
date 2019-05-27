//Графический интерфейс "O Debug"

/*
Библиотека Java Swing

контейнеры верхнего уровня
    – JApplet - главное окно апплета;

    – JFrame - окно приложения;

    – JDialog - диалог приложения.

    – JColorChooser - диалог выбора цвета;

    – JFileChooser - диалог выбора файлов и директорий;

    – FileDialog - диалог выбора файлов и директорий (awt компонент).

простые контейнеры
    – JPanel - простая панель для группировки элементов, включая вложенные панели;

    – JToolBar - панель инструментов (обычно это кнопки);

    – JScroolPane - панель прокрутки, позволяющая прокручивать содержимое дочернего элемента;

    – JDesktopPane - контейнер для создания виртуального рабочего стола или приложений на основе MDI (multiple-document interface);

    – JEditorPane, JTextPane - контейнеры для отображения сложного документа как HTML или RTF;

    – JTabbedPane - контейнер для управления закладками;

    – JSplitPane - контейнер, разделяющий два элемента и позволяющий пользователю изменять их размер.
 */


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OLangGUI extends JFrame {

    static int numVariables = 0;

    Font font = new Font("Century Gothic", Font.BOLD, 14);

    //окно приложения
    static JFrame frame = getFrame();

    //простая панель для группировки элементов
    static JPanel panel = new JPanel();

    //просто какой-либо текст.
    static JLabel label = new JLabel("THIS IS ODebugger");

    //для работы с текстом
    static  JTextArea textArea = new JTextArea(20, 10);         //поле с текстом
    static  JScrollPane inputScrollPane = new JScrollPane(textArea);

    static  JTextArea outputTextArea = new JTextArea(10, 10);         //поле с текстом
    static  JScrollPane outputScrollPane = new JScrollPane(outputTextArea);

    //кнпока
    static JButton runButton = new JButton("RUN");


    public static void createGUI() {
        Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Font font = new Font("Century Gothic", Font.BOLD, 14);

        panel.setBorder(BorderFactory.createTitledBorder("MainWindow"));
        panel.setBackground(Color.GRAY);
        panel.setFont(font);
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        //panel.add(new JTextField(10));

        //panel.add(label);
        textArea.setLineWrap(true);

        inputScrollPane.setBorder(BorderFactory.createTitledBorder("INPUT"));
        outputScrollPane.setBorder(BorderFactory.createTitledBorder("OUTPUT"));
        panel.add(inputScrollPane, BorderLayout.NORTH);
        panel.add(outputScrollPane, BorderLayout.SOUTH);

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RunProgramm();
            }
        });
        panel.add(runButton);

        //frame.pack();
        frame.revalidate(); //перерисовка и перепроверка

    }

    public static void outputTextProgramm() {
        for (int i = 0; i < Text.textFile.size(); i++) {
            textArea.append(Text.textFile.get(i) + "\n");
        }
    }

    public static void outputProgrammRunInformation() {
        for (int i = 0; i < Text.textFile.size(); i++) {
            textArea.append(Text.textFile.get(i) + "\n");
        }
    }

    public static void RunProgramm() {
        OVM.Run();
    }

    static JFrame getFrame() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLocation(500, 200);
        frame.setTitle("O Debug");
        return frame;
    }



    public static void createDebugGUI(String name) {
        //const

        Dimension labelSize = new Dimension(500, 500);
        Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Font font = new Font("Century Gothic", Font.BOLD, 14);

        //-------------------------------------------
        //MainPanel

        JPanel mainPanel = new JPanel();
        //mainPanel.setLayout(new BorderLayout());

        //-------------------------------------------
        //AddPanel

        JPanel addPanel = new JPanel(new FlowLayout());
        addPanel.setBorder(BorderFactory.createTitledBorder("Code"));

        JLabel labelFirst = new JLabel("Left");
        labelFirst.setVerticalAlignment(JLabel.CENTER);
        labelFirst.setHorizontalAlignment(JLabel.RIGHT);
        labelFirst.setBorder(solidBorder);
        labelFirst.setBackground(Color.LIGHT_GRAY);
        labelFirst.setFont(font);
        addPanel.add(labelFirst);

        JLabel labelSecond = new JLabel("Center");
        labelSecond.setVerticalAlignment(JLabel.CENTER);
        labelSecond.setHorizontalAlignment(JLabel.CENTER);
        labelSecond.setPreferredSize(labelSize);
        labelSecond.setBorder(solidBorder);
        labelSecond.setFont(font);
        //labelSecond.setForeground(Color.GREEN);
        labelSecond.setBackground(Color.LIGHT_GRAY);
        addPanel.add(labelSecond);

        mainPanel.add(addPanel, BorderLayout.NORTH);

        //-------------------------------------------
        //TextPanel

        JPanel textPanel = new JPanel();

        JScrollPane scrollPanel = new JScrollPane();
        JTextArea textArea = new JTextArea();

        textArea.add(scrollPanel);
        textArea.setPreferredSize(new Dimension(300, 300));
        textArea.setBorder(BorderFactory.createTitledBorder("Var"));
        textArea.setBackground(Color.black);

        String text = "This is variables";

        textArea.setText(text);
        textArea.setFont(font);


        JLabel textLabel = new JLabel();
        textLabel.setText(text);
        textLabel.setFont(font);
        textPanel.add(textLabel, BorderLayout.SOUTH);

        mainPanel.add(textPanel, BorderLayout.SOUTH);

        //-------------------------------------------
        //Most important: Frame
        //Напрямую в окне элементы управления не размещаются. Для этого служит
        //панель содержимого, занимающая все пространство окна.
        //getContentPane().add();


        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setPreferredSize(new Dimension(1500, 1000));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.GRAY);
        frame.setVisible(true);
    }
}