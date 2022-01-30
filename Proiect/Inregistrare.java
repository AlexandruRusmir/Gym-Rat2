package Proiect;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.sql.Connection;

public class Inregistrare extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JTextField telefon;
    private JTextField adresa;
    private JTextField parola;
    private JTextField repParola;
    private JTextField email;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Inregistrare frame = new Inregistrare();
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
    public Inregistrare() {
        setBackground(new Color(255, 255, 204));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 737, 584);
        setTitle("Crearea unui cont");
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Înregistrare");
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 40));
        lblNewLabel.setBounds(249, 60, 272, 55);
        lblNewLabel.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nume utilizator:");
        lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        lblNewLabel_1.setBounds(28, 120, 214, 40);
        lblNewLabel_1.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel_1);

        username = new JTextField();
        username.setBackground(new Color(250, 250, 250));
        username.setBounds(28, 161, 262, 29);
        username.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
        username.setForeground(new Color(29, 60, 69));
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Numar de telefon:");
        lblNewLabel_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(404, 120, 214, 40);
        lblNewLabel_1_1.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel_1_1);

        telefon = new JTextField();
        telefon.setColumns(10);
        telefon.setBackground(new Color(250, 250, 250));
        telefon.setBounds(404, 161, 262, 29);
        telefon.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
        telefon.setForeground(new Color(29, 60, 69));
        contentPane.add(telefon);

        JLabel lblNewLabel_1_1_1 = new JLabel("Adresa:");
        lblNewLabel_1_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        lblNewLabel_1_1_1.setBounds(28, 201, 214, 40);
        lblNewLabel_1_1_1.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel_1_1_1);

        adresa = new JTextField();
        adresa.setColumns(10);
        adresa.setBounds(28, 242, 262, 29);
        adresa.setBackground(new Color(250, 250, 250));
        adresa.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
        adresa.setForeground(new Color(29, 60, 69));
        contentPane.add(adresa);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Parola:");
        lblNewLabel_1_1_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        lblNewLabel_1_1_1_1.setBounds(28, 282, 214, 40);
        lblNewLabel_1_1_1_1.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel_1_1_1_1);

        parola = new JPasswordField();
        parola.setColumns(10);
        parola.setBounds(28, 323, 262, 29);
        parola.setBackground(new Color(250, 250, 250));
        parola.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
        parola.setForeground(new Color(29, 60, 69));
        contentPane.add(parola);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Repetare parola:");
        lblNewLabel_1_1_1_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        lblNewLabel_1_1_1_1_1.setBounds(404, 282, 214, 40);
        lblNewLabel_1_1_1_1_1.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel_1_1_1_1_1);

        repParola = new JPasswordField();
        repParola.setColumns(10);
        repParola.setBackground(new Color(250, 250, 250));
        repParola.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
        repParola.setForeground(new Color(29, 60, 69));
        repParola.setBounds(404, 323, 272, 29);
        contentPane.add(repParola);

        JButton creare = new JButton("Înregistrare");
        creare.setBackground(new Color(255, 153, 51));
        creare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	try {
					int ok=0;
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectp3","root","");
					      String query = "SELECT username FROM users"; 
					      PreparedStatement ps = conn.prepareStatement(query);
					      ResultSet rs = (ResultSet) ps.executeQuery();
					      int k=0;
					      while (rs.next())
					      {
					          if(username.getText().equals(rs.getString("username")))
					        	  k=1;
					      }       
					     if(k==1){
					    	 JOptionPane.showMessageDialog(contentPane,"Acest username este deja folosit! Alegeti altul, va rugam!");
					    	 ok=1;
					     	}
					    else if(username.getText().length()==0){
						JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati numele de utilizator!");
						ok=1;
						}
						
					else if(telefon.getText().length()==0){
						JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati numarul dumneavoastra de telefon!");
						ok=1;
						}
					else if (!(telefon.getText().matches("[0-9]+"))){
						JOptionPane.showMessageDialog(contentPane,"Numarul de telefon trebuie sa contina doar cifre!");
						ok=1;
						}
					else if(adresa.getText().length()==0){
						JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati adresa dumneavoastra!");
						ok=1;
						}
					else
					if(email.getText().length()==0){
						JOptionPane.showMessageDialog(contentPane,"Trebuie sa introduceti email-ul dumneavoastra!");
						ok=1;
						}
					else if(parola.getText().length()==0){
						JOptionPane.showMessageDialog(contentPane,"Trebuie sa introduceti parola!");
						ok=1;
						}
					else if(repParola.getText().length()==0){
						JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati casuta de repetare parola!");
						ok=1;
						}
					else if(parola.getText().equals(repParola.getText()))
							ok=0;
					
					else if(parola.getText()!=repParola.getText()){
						JOptionPane.showMessageDialog(contentPane,"Cele 2 parola nu coincid. Mai incercati!");
						ok=1;
						}
					
				if(ok==0){
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectp3","root","");
					ps=conn.prepareStatement("insert into users(username,phone,adress,email,password) values(?,?,?,?,?);");
					ps.setString(1, username.getText());
					ps.setString(2, telefon.getText());
					ps.setString(3, adresa.getText());
					ps.setString(4, email.getText());
					ps.setString(5, parola.getText());
					int x=ps.executeUpdate();
					
					if(x>0) {
						JOptionPane.showMessageDialog(contentPane,"Cont creat cu succes!");
						dispose();
						Autentificare b1=new Autentificare();
						b1.setVisible(true);
						}
					else
						JOptionPane.showMessageDialog(contentPane,"Contul nu a fost creat!");
					}	
				}catch(Exception el) {
					System.out.println(el);
				}
			}
        });
        creare.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
        creare.setBounds(245, 421, 200, 50);
        contentPane.add(creare);

        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Email:");
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        lblNewLabel_1_1_1_1_1_1.setBounds(404, 201, 214, 40);
        lblNewLabel_1_1_1_1_1_1.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel_1_1_1_1_1_1);

        email = new JTextField();
        email.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
        email.setForeground(new Color(29, 60, 69));
        email.setBackground(new Color(250, 250, 250));
        email.setColumns(10);
        email.setBounds(404, 242, 262, 29);
        contentPane.add(email);

        JButton cancel = new JButton("Înapoi");
        cancel.setBackground(new Color(255, 110, 110));
        cancel.setForeground(new Color(29, 60, 69));
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    dispose();
                    Main b1=new Main();
                    b1.setVisible(true);
                }catch(Exception el) {
                    System.out.println(el);
                }
            }
        });
        cancel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        cancel.setBounds(40, 30, 100, 35);
        contentPane.add(cancel);
    }
}