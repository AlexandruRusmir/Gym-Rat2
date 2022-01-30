package Proiect;

import java.awt.BorderLayout;
import java.util.Date;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  

import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Restaurant extends JFrame {
    private JPanel contentPane;
    public static String username;
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
    public Restaurant(String user) {
        setBackground(new Color(255, 255, 204));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 737, 584);
        setTitle("Plaseaza o comanda");
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Oferta Gym Rat");
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 40));
        lblNewLabel.setForeground(new Color(29, 60, 69));
        lblNewLabel.setBounds(239, 70, 272, 55);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Piept de pui cu legume (4.59$)");
        lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        lblNewLabel_1.setForeground(new Color(29, 60, 69));
        lblNewLabel_1.setBounds(28, 120, 290, 40);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Numar portii:");
        lblNewLabel_2.setFont(new Font("Baskerville Old Face", Font.ITALIC, 20));
        lblNewLabel_2.setForeground(new Color(29, 60, 69));
        lblNewLabel_2.setBounds(28, 161, 150, 40);
        contentPane.add(lblNewLabel_2);

        SpinnerModel model = new SpinnerNumberModel(0, 0, 10, 1);
        JSpinner pui = new JSpinner(model);
        pui.setBackground(new Color(250, 250, 250));
        pui.setForeground(new Color(29, 60, 69));
        pui.setBounds(170, 161, 60, 40);
        pui.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
        contentPane.add(pui);



        JLabel lblNewLabel_1_1 = new JLabel("Somon cu cartofi dulci (6.63$)");
        lblNewLabel_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        lblNewLabel_1_1.setForeground(new Color(29, 60, 69));
        lblNewLabel_1_1.setBounds(404, 120, 290, 40);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Numar portii:");
        lblNewLabel_1_2.setFont(new Font("Baskerville Old Face", Font.ITALIC, 20));
        lblNewLabel_1_2.setForeground(new Color(29, 60, 69));
        lblNewLabel_1_2.setBounds(404, 161, 150, 40);
        contentPane.add(lblNewLabel_1_2);

        SpinnerModel model1 = new SpinnerNumberModel(0, 0, 10, 1);
        JSpinner somon = new JSpinner(model1);
        somon.setBackground(new Color(250, 250, 250));
        somon.setForeground(new Color(29, 60, 69));
        somon.setBounds(560, 161, 60, 40);
        somon.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
        contentPane.add(somon);



        JLabel lblNewLabel_1_1_1 = new JLabel("Cotlet de porc cu orez (4.73$)");
        lblNewLabel_1_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        lblNewLabel_1_1_1.setForeground(new Color(29, 60, 69));
        lblNewLabel_1_1_1.setBounds(28, 201, 290, 40);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("Numar portii:");
        lblNewLabel_1_1_2.setFont(new Font("Baskerville Old Face", Font.ITALIC, 20));
        lblNewLabel_1_1_2.setBounds(28, 242, 150, 40);
        lblNewLabel_1_1_2.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel_1_1_2);

        SpinnerModel model2 = new SpinnerNumberModel(0, 0, 10, 1);
        JSpinner porc = new JSpinner(model2);
        porc.setBackground(new Color(250, 250, 250));
        porc.setForeground(new Color(29, 60, 69));
        porc.setBounds(170, 242, 60, 40);
        porc.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
        contentPane.add(porc);


        JLabel lblNewLabel_1_1_1_1 = new JLabel("Vita teriaky cu broccoli (6.56$)");
        lblNewLabel_1_1_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        lblNewLabel_1_1_1_1.setBounds(28, 282, 290, 40);
        lblNewLabel_1_1_1_1.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_1_1_1_2 = new JLabel("Numar portii:");
        lblNewLabel_1_1_1_2.setFont(new Font("Baskerville Old Face", Font.ITALIC, 20));
        lblNewLabel_1_1_1_2.setBounds(28, 323, 150, 40);
        lblNewLabel_1_1_1_2.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel_1_1_1_2);

        SpinnerModel model3 = new SpinnerNumberModel(0, 0, 10, 1);
        JSpinner vita = new JSpinner(model3);
        vita.setBackground(new Color(250, 250, 250));
        vita.setForeground(new Color(29, 60, 69));
        vita.setBounds(170, 323, 60, 40);
        vita.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
        contentPane.add(vita);


        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Mus de ciocolata proteic (5.32$)");
        lblNewLabel_1_1_1_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        lblNewLabel_1_1_1_1_1.setBounds(404, 282, 320, 40);
        lblNewLabel_1_1_1_1_1.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel_1_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Numar portii:");
        lblNewLabel_1_1_1_1_2.setFont(new Font("Baskerville Old Face", Font.ITALIC, 20));
        lblNewLabel_1_1_1_1_2.setBounds(404, 323, 150, 40);
        lblNewLabel_1_1_1_1_2.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel_1_1_1_1_2);

        SpinnerModel model4 = new SpinnerNumberModel(0, 0, 10, 1);
        JSpinner mus = new JSpinner(model4);
        mus.setBackground(new Color(250, 250, 250));
        mus.setForeground(new Color(29, 60, 69));
        mus.setBounds(560, 323, 60, 40);
        mus.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
        contentPane.add(mus);
        
        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Salata de linte cu feta (5.99$)");
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
        lblNewLabel_1_1_1_1_1_1.setBounds(404, 201, 310, 40);
        lblNewLabel_1_1_1_1_1_1.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel_1_1_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Numar portii:");
        lblNewLabel_1_1_1_1_1_2.setFont(new Font("Baskerville Old Face", Font.ITALIC, 20));
        lblNewLabel_1_1_1_1_1_2.setBounds(404, 242, 150, 40);
        lblNewLabel_1_1_1_1_1_2.setForeground(new Color(29, 60, 69));
        contentPane.add(lblNewLabel_1_1_1_1_1_2);

        SpinnerModel model5 = new SpinnerNumberModel(0, 0, 10, 1);
        JSpinner linte = new JSpinner(model5);
        linte.setBackground(new Color(250, 250, 250));
        linte.setBounds(560, 242, 60, 40);
        linte.setFont(new Font("Baskerville Old Face", Font.PLAIN, 17));
        linte.setForeground(new Color(29, 60, 69));
        contentPane.add(linte);
        
        JButton trimite = new JButton("Trimite comanda!");
        trimite.setBackground(new Color(255, 153, 51));
        trimite.setForeground(new Color(29, 60, 69));
        trimite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	username=user;
            	Integer numarPui = (Integer) pui.getValue();
            	Integer numarSomon =  (Integer) somon.getValue();
            	Integer numarPorc =  (Integer) porc.getValue();
            	Integer numarVita =  (Integer) vita.getValue();
            	Integer numarMus =  (Integer) mus.getValue();
            	Integer numarLinte =  (Integer) linte.getValue();
            	if(numarPui==0 && numarPui==0 && numarPorc==0 && numarVita==0 && numarMus==0 && numarLinte==0) {
            		JOptionPane.showMessageDialog(contentPane,"Trebuie sa alegeti minim un fel mancare pentru a trimite o comanda!");
                    dispose();
                    Restaurant b4=new Restaurant(username);
                    b4.setVisible(true);
            	}
            	else {
            		try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectp3","root","");
						
						StringBuilder order = new StringBuilder();
						for(int i=0; i<numarPui; i++)
							order.append("1");
						for(int i=0; i<numarSomon; i++)
							order.append("2");
						for(int i=0; i<numarPorc; i++)
							order.append("3");
						for(int i=0; i<numarLinte; i++)
							order.append("4");
						for(int i=0; i<numarVita; i++)
							order.append("5");
						for(int i=0; i<numarMus; i++)
							order.append("6");
						String finalOrder = order.toString();
						
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
						LocalDateTime now = LocalDateTime.now();
						String dateStr = dtf.format(now);
					    
					    PreparedStatement ps=conn.prepareStatement("insert into mealorders(username,meal_order,date) values(?,?,?);");
						ps.setString(1, username);
						ps.setString(2, finalOrder);
						ps.setString(3, dateStr);
						int x=ps.executeUpdate();
						
						if(x>0) 
							JOptionPane.showMessageDialog(contentPane,"Comanda a fost trimisa!");
							
						else
							JOptionPane.showMessageDialog(contentPane,"Eroare la trimiterea comenzii!");
							
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					
	                
	                dispose();
	                Restaurant b4=new Restaurant(username);
	                b4.setVisible(true);
            	}
            }
        });
        trimite.setFont(new Font("Baskerville Old Face", Font.PLAIN, 28));
        trimite.setBounds(239, 421, 250, 50);
        contentPane.add(trimite);

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
        cancel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
        cancel.setBounds(30, 15, 100, 30);
        contentPane.add(cancel);
        
        JButton istoric = new JButton("Istoric comenzi");
        istoric.setBackground(new Color(255, 255, 150));
        istoric.setForeground(new Color(29, 60, 69));
        istoric.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    dispose();
                    Istoric window=new Istoric(user);
                    window.setVisible(true);
                }catch(Exception el) {
                    System.out.println(el);
                }
            }
        });
        istoric.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
        istoric.setBounds(510, 15, 200, 30);
        contentPane.add(istoric);
    }
}
