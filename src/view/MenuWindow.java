package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.FabricaDrone;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MenuWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuWindow frame = new MenuWindow();
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
	public MenuWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("logo");
		lblLogo.setIcon(new ImageIcon(MenuWindow.class.getResource("/images/logo.jpg")));
		lblLogo.setBounds(12, 13, 250, 250);
		contentPane.add(lblLogo);
		
		JLabel lblNomeEmpresa = new JLabel("DRONE");
		lblNomeEmpresa.setFont(new Font("Wide Latin", Font.BOLD, 60));
		lblNomeEmpresa.setBounds(286, 0, 463, 250);
		contentPane.add(lblNomeEmpresa);
		
		JButton btnStart = new JButton("");
		btnStart.setBackground(Color.LIGHT_GRAY);
		btnStart.setIcon(new ImageIcon(MenuWindow.class.getResource("/images/telaDados.png")));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LinhaProducaoWindow.getLinhaProducaoWindow().setVisible(true);
				FabricaDrone.getFabricaDrone();

			}
		});
		btnStart.setFont(new Font("Arial", Font.PLAIN, 30));
		btnStart.setBounds(316, 338, 199, 142);
		contentPane.add(btnStart);
		
		JLabel lblDji = new JLabel("DJI");
		lblDji.setFont(new Font("Wide Latin", Font.BOLD, 60));
		lblDji.setBounds(577, 159, 227, 91);
		contentPane.add(lblDji);
	}
}
