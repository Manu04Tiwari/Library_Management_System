import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Library {
    private JFrame frame;
    private JTextField titleField;
    private JTextField authorField;
    private DefaultListModel<String> listModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Library window = new Library();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public class Book {
        private String title;
        private String author;
    
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    
        public String getTitle() {
            return title;
        }
    
        public void setTitle(String title) {
            this.title = title;
        }
    
        public String getAuthor() {
            return author;
        }
    
        public void setAuthor(String author) {
            this.author = author;
        }
    }
    
    public Library() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("Title");
        frame.getContentPane().add(titleLabel);

        titleField = new JTextField();
        frame.getContentPane().add(titleField);
        titleField.setColumns(10);

        JLabel authorLabel = new JLabel("Author");
        frame.getContentPane().add(authorLabel);

        authorField = new JTextField();
        frame.getContentPane().add(authorField);
        authorField.setColumns(10);

        JButton btnAddBook = new JButton("Add Book");
        frame.getContentPane().add(btnAddBook);

        listModel = new DefaultListModel<>();
        JList<String> bookList = new JList<>(listModel);
        frame.getContentPane().add(bookList);

        btnAddBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                listModel.addElement("Title: " + title + ", Author: " + author);
                titleField.setText("");
                authorField.setText("");
            }
        });
    }
}
