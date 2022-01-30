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
public class Istoric extends JFrame {
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
    public Istoric(String user) {
        setBackground(new Color(255, 255, 204));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 737, 584);
        setTitle("Istoric al comenzilor");
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Istoric Comenzi");
        lblNewLabel.setFont(new Font("Baskerville Old Face", Font.BOLD, 40));
        lblNewLabel.setForeground(new Color(29, 60, 69));
        lblNewLabel.setBounds(239, 70, 272, 55);
        contentPane.add(lblNewLabel);
        
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectp3","root","");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM mealorders WHERE username=?");
			ps.setString(1, user);
			ResultSet rs = (ResultSet) ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			StringBuilder orders = new StringBuilder();
			while (rs.next()) {
			        orders.append(" -Comanda:\n");
			        String meals=rs.getString(2);
			        int countPui = ( meals.split("1", -1).length ) - 1;
			        int countSomon = ( meals.split("2", -1).length ) - 1;
			        int countPorc = ( meals.split("3", -1).length ) - 1;
			        int countLinte = ( meals.split("4", -1).length ) - 1;
			        int countVita = ( meals.split("5", -1).length ) - 1;
			        int countMus = ( meals.split("6", -1).length ) - 1;
			        double total = 4.59*countPui + 6.63*countSomon + 4.73*countPorc + 5.99*countLinte + 6.56*countVita + 5.32*countMus;
			        if(countPui != 0) {
			        	orders.append("    Piept de pui cu legume: ");
			        	if(countPui==1)
			        		orders.append("1 portie\n");
			        	else
			        		orders.append(countPui).append(" portii\n");
			        }
			        if(countSomon != 0) {
			        	orders.append("    Somon cu cartofi dulci: ");
			        	if(countSomon==1)
			        		orders.append("1 portie\n");
			        	else
			        		orders.append(countSomon).append(" portii\n");
			        }
			        if(countPorc != 0) {
			        	orders.append("    Cotlet de porc cu orez: ");
			        	if(countPorc==1)
			        		orders.append("1 portie\n");
			        	else
			        		orders.append(countPorc).append(" portii\n");
			        }
			        if(countLinte != 0) {
			        	orders.append("    Salata de linte cu feta: ");
			        	if(countLinte==1)
			        		orders.append("1 portie\n");
			        	else
			        		orders.append(countLinte).append(" portii\n");
			        }
			        if(countVita != 0) {
			        	orders.append("    Vita teriaky cu broccoli: ");
			        	if(countVita==1)
			        		orders.append("1 portie\n");
			        	else
			        		orders.append(countVita).append(" portii\n");
			        }
			        if(countMus != 0) {
			        	orders.append("    Mus de ciocolata proteic: ");
			        	if(countMus==1)
			        		orders.append("1 portie\n");
			        	else
			        		orders.append(countMus).append(" portii\n");
			        }
			        orders.append(" Total: ").append(total).append("$");
			        orders.append("\n Data comenzii: ").append(rs.getString(3)).append("\n\n\n");
			}
			String allOrders = orders.toString();
			
			JTextArea ta = new JTextArea(allOrders, 500, 600);
			ta.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
			ta.setLineWrap(true);
			JScrollPane ordersList = new JScrollPane(ta);
			ordersList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			ordersList.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
			ordersList.setBounds(120, 150, 500, 330);
			ordersList.setBackground(new Color(250, 250, 250));
		    contentPane.add(ordersList);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
            
        
        
        JButton cancel = new JButton("Înapoi");
        cancel.setBackground(new Color(255, 110, 110));
        cancel.setForeground(new Color(29, 60, 69));
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    dispose();
                    Restaurant b1=new Restaurant(user);
                    b1.setVisible(true);
                }catch(Exception el) {
                    System.out.println(el);
                }
            }
        });
        cancel.setFont(new Font("Baskerville Old Face", Font.PLAIN, 22));
        cancel.setBounds(30, 15, 100, 30);
        contentPane.add(cancel);
    }
}
