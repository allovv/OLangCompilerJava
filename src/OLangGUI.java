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

    public static int numVariables = 0;

    Font font = new Font("Century Gothic", Font.BOLD, 14);

    //окно приложения
    static JFrame frame = getFrame();

    //простая панель для группировки элементов
    static JPanel mainPanel = new JPanel();
    static JPanel additionalPanel = new JPanel();

    //для работы с текстом
    static  JTextArea textArea = new JTextArea(10, 10);         //поле с текстом
    static  JScrollPane inputScrollPane = new JScrollPane(textArea);

    static  JTextArea outputTextArea = new JTextArea(20, 10);         //поле с текстом
    static  JScrollPane outputScrollPane = new JScrollPane(outputTextArea);

    //для пользовательского ввода
    static  JTextField inputText = new JTextField(10);         //поле с текстом

    //кнпока
    static JButton runButton = new JButton("RUN");


    public static void createGUI() {
        Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Font font = new Font("Century Gothic", Font.BOLD, 14);

        mainPanel.setBorder(BorderFactory.createTitledBorder("MainWindow"));
        mainPanel.setBackground(Color.GRAY);
        mainPanel.setFont(font);
        mainPanel.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.NORTH);

        textArea.setLineWrap(true);

        inputScrollPane.setBorder(BorderFactory.createTitledBorder("INPUT"));
        outputScrollPane.setBorder(BorderFactory.createTitledBorder("OUTPUT"));
        mainPanel.add(inputScrollPane, BorderLayout.NORTH);
        mainPanel.add(outputScrollPane, BorderLayout.SOUTH);

        //*****************************************************

        additionalPanel.setBorder(BorderFactory.createTitledBorder("AdditionalWindow"));
        additionalPanel.setBackground(Color.GRAY);
        additionalPanel.setFont(font);
        additionalPanel.setLayout(new BorderLayout());
        frame.add(additionalPanel, BorderLayout.SOUTH);

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RunProgramm();
            }
        });
        additionalPanel.add(runButton, BorderLayout.NORTH);
        additionalPanel.add(inputText, BorderLayout.SOUTH);
        //frame.pack();
        frame.revalidate(); //перерисовка и перепроверка

    }

    public static void outputTextProgram() {
        for (int i = 0; i < Text.textFile.size(); i++) {
            textArea.append(Text.textFile.get(i) + "\n");
        }
    }

    public static void exitProgram() {
        System.exit(0);
    }

    public static void RunProgramm() {
        O.Init();         //инициализация
        Pars.Compile(); //компиляция
        OVM.ShowCode();
        //OVM.Run();
        O.Done();         //завершение
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
}