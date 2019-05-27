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

/*
window.getContentPane().removeAll();
window.add(что-то там);
window.revalidate();
*/

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class OLangGUI extends JFrame {

    public static int numVariables = 0;

    Font font = new Font("Century Gothic", Font.BOLD, 14);

    //окно приложения
    static JFrame frame = getFrame();

    //для работы с текстом
    static JPanel mainPanel = new JPanel();                                         //простая панель для группировки элементов
    static JTextArea textArea = new JTextArea(15, 10);               //поле с текстом
    static JScrollPane inputScrollPane = new JScrollPane(textArea);
    static JTextArea outputTextArea = new JTextArea(5, 10);         //поле с текстом
    static JScrollPane outputScrollPane = new JScrollPane(outputTextArea);
    static JTextArea varTextArea = new JTextArea(5, 5);         //поле с текстом
    static JScrollPane varScrollPane = new JScrollPane(varTextArea);

    //для пользовательского ввода
    static JPanel inputDataPanel = new JPanel();
    static JTextField inputText = new JTextField(10);         //поле с текстом

    //кнпоки
    static JPanel buttonPanel = new JPanel();
    static JButton runButton = new JButton("RUN");
    static JButton compileButton = new JButton("COMPILE");
    static JButton showCodeButton = new JButton("ShowCode");

    //загрузка и сохранение данных
    static JPanel dataPanel = new JPanel();
    static JButton saveButton = new JButton("SAVE");
    static JButton loadButton = new JButton("LOAD");
    static JTextField fileNameText = new JTextField(10);

    static JFrame getFrame() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 900);
        frame.setLocation(500, 200);
        frame.setTitle("O Debug");
        return frame;
    }

    public static void createGUI() {

        Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Border panelBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
        Font font = new Font("Century Gothic", Font.BOLD, 14);

        //------------------------------------------------------------------

        //MainPanel

        mainPanel.setBorder(BorderFactory.createTitledBorder("*** MAIN WINDOW ***"));
        mainPanel.setBackground(Color.GRAY);
        mainPanel.setFont(font);
        mainPanel.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.SOUTH);

        //Текстовые поля

        textArea.setLineWrap(true);
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SHIFT + KeyEvent.VK_F1) {
                    //TODO: запустить дебагер
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        varTextArea.setEditable(false);

        inputScrollPane.setBorder(BorderFactory.createTitledBorder("program text"));
        outputScrollPane.setBorder(BorderFactory.createTitledBorder("output"));
        varScrollPane.setBorder(BorderFactory.createTitledBorder("var"));
        mainPanel.add(inputScrollPane, BorderLayout.NORTH);
        mainPanel.add(outputScrollPane, BorderLayout.SOUTH);
        mainPanel.add(varScrollPane);

        //------------------------------------------------------------------

        //ButtonPanel

        buttonPanel.setBorder(BorderFactory.createTitledBorder("*** ACTIONS ***"));
        buttonPanel.setBackground(Color.white);
        buttonPanel.setFont(font);
        buttonPanel.setLayout(new GridLayout());
        frame.add(buttonPanel, BorderLayout.NORTH);

        //Кнопки

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OVM.Run();
            }
        });
        compileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                O.Init();       //инициализируем компилятор языка О
                Pars.Compile();   //компиляция
            }
        });
        showCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OVM.ShowCode();
            }
        });

        buttonPanel.add(runButton);
        buttonPanel.add(compileButton);
        buttonPanel.add(showCodeButton);

        //------------------------------------------------------------------

        //InputPanel

        inputDataPanel.setBorder(BorderFactory.createTitledBorder("*** INPUT STREAM ***"));
        inputDataPanel.setBackground(Color.GRAY);
        inputDataPanel.setFont(font);
        inputDataPanel.setLayout(new BorderLayout());
        frame.add(inputDataPanel);

        //Окно текстового ввода

        inputText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: входной поток информации
            }
        });

        inputDataPanel.add(inputText);

        //------------------------------------------------------------------

        //SaveAndLoadFilePanel

        dataPanel.setBorder(BorderFactory.createTitledBorder("*** LOAD/SAVE ***"));
        dataPanel.setBackground(Color.GRAY);
        dataPanel.setFont(font);
        dataPanel.setLayout(new GridLayout());
        frame.add(dataPanel);


        //Кнопки
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO сохранить изменения программы в файле
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO загрузить текстовый файл в главное окно
            }
        });

        dataPanel.add(saveButton);
        dataPanel.add(loadButton);
        dataPanel.add(fileNameText);

        //------------------------------------------------------------------

        //frame.pack();
        frame.revalidate(); //перерисовка и перепроверка

    }

    public static void outputTextProgram() {
        for (int i = 0; i < Text.textFile.size(); i++) {
            textArea.append(Text.textFile.get(i) + "\n");
        }
    }

    public static void outputInform(String info) {
        OLangGUI.outputTextArea.append(info);
        outputTextArea.revalidate();
        textArea.repaint(); //перерисовка и перепроверка
    }

    public static void inputInform() {
        System.exit(0);
    }

    /*
    public void setActions() {
        loadData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\filein.txt")));
                    textArea.setText("");
                    String line;
                    while ((line = in.readLine()) != null) {
                        textArea.append(line);
                        textArea.append("\n");
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
        saveData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PrintWriter out = new PrintWriter( new FileOutputStream("D:\\filein.txt"),true);
                    out.print(textArea.getText());
                    out.close();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
*/
}