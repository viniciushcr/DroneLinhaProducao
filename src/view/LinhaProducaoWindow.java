package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LinhaProducaoWindow extends JFrame {

	private JPanel contentPane;
	private static LinhaProducaoWindow linhaProducaoWindow;
	private JTextField textHelice;
	private JTextField textBateria;
	private JTextField textFrame;
	private JTextField textPlacaControladora;
	private JTextField textMotor;
	private JTextField textDroneMontado;
	private JTextField legendaOF;
	private JTextField legendaON;
	private JTextField textCaixa;
	private JTextField textDronesHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LinhaProducaoWindow frame = new LinhaProducaoWindow();
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
	public LinhaProducaoWindow() {
		setType(Type.UTILITY);
		setTitle("Dados Linha Produ\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1051, 730);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHelice = new JLabel("Helice");
		lblHelice.setIcon(new ImageIcon(LinhaProducaoWindow.class.getResource("/images/helice.png")));
		lblHelice.setBounds(10, 10, 225, 225);
		contentPane.add(lblHelice);
		
		JLabel lblPlacaControladora = new JLabel("Placa Controladora");
		lblPlacaControladora.setIcon(new ImageIcon(LinhaProducaoWindow.class.getResource("/images/placaControladora.png")));
		lblPlacaControladora.setBounds(10, 350, 225, 225);
		contentPane.add(lblPlacaControladora);
		
		JLabel lblFrames = new JLabel("Frame");
		lblFrames.setIcon(new ImageIcon(LinhaProducaoWindow.class.getResource("/images/frame.png")));
		lblFrames.setBounds(482, 10, 225, 225);
		contentPane.add(lblFrames);
		
		JLabel lblBateria = new JLabel("Bateria");
		lblBateria.setIcon(new ImageIcon(LinhaProducaoWindow.class.getResource("/images/bateria.png")));
		lblBateria.setBounds(245, 10, 225, 225);
		contentPane.add(lblBateria);
		
		JLabel lblMotor = new JLabel("Motor");
		lblMotor.setIcon(new ImageIcon(LinhaProducaoWindow.class.getResource("/images/motor.png")));
		lblMotor.setBounds(247, 350, 225, 225);
		contentPane.add(lblMotor);
		
		JLabel lblDroneCompleto = new JLabel("Drone");
		lblDroneCompleto.setIcon(new ImageIcon(LinhaProducaoWindow.class.getResource("/images/droneMontado.png")));
		lblDroneCompleto.setBounds(482, 350, 225, 225);
		contentPane.add(lblDroneCompleto);
		
		textHelice = new JTextField();
		textHelice.setBackground(Color.RED);
		textHelice.setEditable(false);
		textHelice.setBounds(20, 248, 70, 70);
		contentPane.add(textHelice);
		textHelice.setColumns(10);
		
		textBateria = new JTextField();
		textBateria.setBackground(Color.RED);
		textBateria.setEditable(false);
		textBateria.setColumns(10);
		textBateria.setBounds(255, 248, 70, 70);
		contentPane.add(textBateria);
		
		textFrame = new JTextField();
		textFrame.setBackground(Color.RED);
		textFrame.setEditable(false);
		textFrame.setColumns(10);
		textFrame.setBounds(492, 248, 70, 70);
		contentPane.add(textFrame);
		
		textPlacaControladora = new JTextField();
		textPlacaControladora.setBackground(Color.RED);
		textPlacaControladora.setEditable(false);
		textPlacaControladora.setColumns(10);
		textPlacaControladora.setBounds(20, 588, 70, 70);
		contentPane.add(textPlacaControladora);
		
		textMotor = new JTextField();
		textMotor.setBackground(Color.RED);
		textMotor.setEditable(false);
		textMotor.setColumns(10);
		textMotor.setBounds(257, 588, 70, 70);
		contentPane.add(textMotor);
		
		textDroneMontado = new JTextField();
		textDroneMontado.setBackground(Color.WHITE);
		textDroneMontado.setEditable(false);
		textDroneMontado.setColumns(10);
		textDroneMontado.setBounds(492, 588, 70, 70);
		contentPane.add(textDroneMontado);
		
		JLabel lblProduzido = new JLabel("PRODUZIDO(S)");
		lblProduzido.setFont(new Font("Arial", Font.PLAIN, 17));
		lblProduzido.setBounds(102, 248, 134, 70);
		contentPane.add(lblProduzido);
		
		JLabel label = new JLabel("PRODUZIDO(S)");
		label.setFont(new Font("Arial", Font.PLAIN, 17));
		label.setBounds(337, 248, 134, 70);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("PRODUZIDO(S)");
		label_1.setFont(new Font("Arial", Font.PLAIN, 17));
		label_1.setBounds(573, 248, 134, 70);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("PRODUZIDO(S)");
		label_2.setFont(new Font("Arial", Font.PLAIN, 17));
		label_2.setBounds(101, 588, 134, 70);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("PRODUZIDO(S)");
		label_3.setFont(new Font("Arial", Font.PLAIN, 17));
		label_3.setBounds(336, 588, 134, 70);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("PRODUZIDO(S)");
		label_4.setFont(new Font("Arial", Font.PLAIN, 17));
		label_4.setBounds(573, 588, 134, 70);
		contentPane.add(label_4);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinhaProducaoWindow.getLinhaProducaoWindow().setVisible(false);
			}
		});
		btnVoltar.setBounds(807, 611, 157, 59);
		contentPane.add(btnVoltar);
		
		legendaOF = new JTextField();
		legendaOF.setBackground(Color.RED);
		legendaOF.setEditable(false);
		legendaOF.setColumns(10);
		legendaOF.setBounds(755, 528, 70, 70);
		contentPane.add(legendaOF);
		
		legendaON = new JTextField();
		legendaON.setBackground(Color.GREEN);
		legendaON.setEditable(false);
		legendaON.setColumns(10);
		legendaON.setBounds(755, 454, 70, 70);
		contentPane.add(legendaON);
		
		JLabel lblOff = new JLabel("PARADA - OFF");
		lblOff.setFont(new Font("Arial", Font.PLAIN, 17));
		lblOff.setBounds(837, 528, 157, 70);
		contentPane.add(lblOff);
		
		JLabel lblOn = new JLabel("PRODUZINDO - ON");
		lblOn.setFont(new Font("Arial", Font.PLAIN, 17));
		lblOn.setBounds(837, 453, 172, 70);
		contentPane.add(lblOn);
		
		JLabel label_5 = new JLabel("Frame");
		label_5.setIcon(new ImageIcon(LinhaProducaoWindow.class.getResource("/images/caixa.png")));
		label_5.setBounds(769, 10, 225, 225);
		contentPane.add(label_5);
		
		textCaixa = new JTextField();
		textCaixa.setEditable(false);
		textCaixa.setColumns(10);
		textCaixa.setBackground(Color.WHITE);
		textCaixa.setBounds(779, 248, 70, 70);
		contentPane.add(textCaixa);
		
		JLabel lblCaixasC = new JLabel("CAIXA(S) C/ 8");
		lblCaixasC.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCaixasC.setBounds(860, 248, 134, 70);
		contentPane.add(lblCaixasC);
		
		JLabel lblLegenda = new JLabel("LEGENDA - LINHA PRODU\u00C7\u00C3O:");
		lblLegenda.setFont(new Font("Arial", Font.PLAIN, 17));
		lblLegenda.setBounds(755, 412, 266, 52);
		contentPane.add(lblLegenda);
		
		textDronesHora = new JTextField();
		textDronesHora.setEditable(false);
		textDronesHora.setColumns(10);
		textDronesHora.setBackground(Color.WHITE);
		textDronesHora.setBounds(779, 329, 70, 70);
		contentPane.add(textDronesHora);
		
		JLabel lblDroneshora = new JLabel("DRONES / HORA");
		lblDroneshora.setFont(new Font("Arial", Font.PLAIN, 17));
		lblDroneshora.setBounds(860, 331, 134, 70);
		contentPane.add(lblDroneshora);
	}
	
	
	public static LinhaProducaoWindow getLinhaProducaoWindow() {
		if(linhaProducaoWindow == null) {
			linhaProducaoWindow = new LinhaProducaoWindow();
		}
		return linhaProducaoWindow;
	}
}
