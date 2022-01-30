package Proiect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
public class Main extends JFrame{

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(true);
                    	    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Main() {
        setAlwaysOnTop(true);
        setBackground(new Color(255, 255, 204));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 576, 424);
        setTitle("Pagina principala");
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel(" Gym Rat");
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 51));
        lblNewLabel.setBounds(125, 42, 310, 73);
        lblNewLabel.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel);
        
        JLabel imagine = new JLabel("");
        imagine.setHorizontalAlignment(SwingConstants.CENTER);
        imagine.setIcon(new ImageIcon("D:\\Files\\Proiect\\src\\Proiect\\pic.jpg"));
        imagine.setBounds(340, 27, 100, 102);
        contentPane.add(imagine);
        
        JLabel saying = new JLabel("Food made for athletes, according to athletes...");
        saying.setFont(new Font("Baskerville Old Face", Font.ITALIC, 20));
        saying.setBounds(115, 150, 380, 73);
        saying.setForeground(new Color(29, 60, 69));
        contentPane.add(saying);
        
        JButton inregistrare = new JButton("Autentificare");
        inregistrare.setBackground(new Color(255, 153, 51));
        inregistrare.setForeground(new Color(29, 60, 69));
        inregistrare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    dispose();
                    Autentificare b3=new Autentificare();
                    b3.setVisible(true);
                }catch(Exception el) {
                    System.out.println(el);
                }
            }
        });
        inregistrare.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        inregistrare.setBounds(174, 250, 180, 36);
        contentPane.add(inregistrare);

        JButton creareCont = new JButton("Înregistrare");
        creareCont.setBackground(new Color(255, 153, 51));
        creareCont.setForeground(new Color(29, 60, 69));
        creareCont.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    dispose();
                    Inregistrare b2=new Inregistrare();
                    b2.setVisible(true);
                }catch(Exception el) {
                    System.out.println(el);
                }
            }
        });
        creareCont.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
        creareCont.setBounds(174, 320, 180, 36);
        contentPane.add(creareCont);
        
    }
}
