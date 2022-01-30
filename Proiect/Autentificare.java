package Proiect;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Autentificare extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JTextField parola;
    public static String usernamee;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Autentificare frame = new Autentificare();
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
    public Autentificare() {
        setBackground(new Color(255, 255, 204));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 470);
        setTitle("Autentificare in cont");
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Autentificare");
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 50));
        lblNewLabel.setForeground(new Color(29, 60, 69));
        lblNewLabel.setBounds(135, 65, 310, 67);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nume utilizator:");
        lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        lblNewLabel_1.setBounds(149, 137, 202, 30);
        lblNewLabel_1.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel_1);

        username = new JTextField();
        username.setBackground(new Color(250, 250, 250));
        username.setBounds(149, 178, 242, 30);
        username.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
        username.setForeground(new Color(29, 60, 69));
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Parola:");
        lblNewLabel_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        lblNewLabel_1_1.setForeground(new Color(29, 60, 69));
        lblNewLabel_1_1.setBounds(149, 219, 202, 30);
        contentPane.add(lblNewLabel_1_1);

        parola = new JPasswordField();
        parola.setColumns(10);
        parola.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
        parola.setForeground(new Color(29, 60, 69));
        parola.setBackground(new Color(250, 250, 250));
        parola.setBounds(149, 257, 242, 30);
        contentPane.add(parola);

        JButton inregistrare = new JButton("Autentificare");
        inregistrare.setBackground(new Color(255, 153, 51));
        inregistrare.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        inregistrare.setForeground(new Color(29, 60, 69));
        inregistrare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
					
					int ok=0;
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectp3","root","");
					      String query = "SELECT username,password FROM users"; 
					      PreparedStatement ps = conn.prepareStatement(query);
					      ResultSet rs = (ResultSet) ps.executeQuery();
					      int ku=0;
					      int kp=0;
					      while (rs.next())
					      {
					          if(username.getText().equals(rs.getString("username")))
					        	  ku=1;
					          if(parola.getText().equals(rs.getString("password")))
					        	  kp=1;
					      }       
				
				if(username.getText().length()==0){
					JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati numele de utilizator!");
						ok=1;
						}
				else if(parola.getText().length()==0){
						JOptionPane.showMessageDialog(contentPane,"Trebuie sa completati parola!");
						ok=1;
						}
				else if(ku==0){
							JOptionPane.showMessageDialog(contentPane,"Acest nume de utilizator nu exista!");
						    ok=1;
						    }
					else if(kp==0){
								JOptionPane.showMessageDialog(contentPane,"Parola incorecta!");
							    ok=1;
							    }
				
					
				if(ok==0)
					{
					dispose();
					Restaurant b4=new Restaurant(username.getText());
					b4.setVisible(true);
					
					}
				}catch(Exception el) {
					System.out.println(el);
				}
			}
            
        });
        inregistrare.setFont(new Font("Baskerville Old Face", Font.PLAIN, 30));
        inregistrare.setBounds(175, 333, 190, 40);
        contentPane.add(inregistrare);

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
        cancel.setBounds(25, 15, 100, 27);
        contentPane.add(cancel);
    }
}
