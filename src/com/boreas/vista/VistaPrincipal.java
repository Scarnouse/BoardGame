package com.boreas.vista;

//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.Box;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.boreas.controlador.Controlador;

import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class VistaPrincipal {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JMenuItem mntmAbrir;
	private JPanel panelIzquierdo;
	private JTable tabla;

	
	public VistaPrincipal(){
		initialize();
		Controlador controlador = new Controlador(this);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menu = new JMenuBar();
		frame.setJMenuBar(menu);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menu.add(mnArchivo);
		
		mntmAbrir = new JMenuItem("Abrir");
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mnArchivo.add(mntmCerrar);
		
		JPanel panelTitulo = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(panelTitulo, BorderLayout.SOUTH);
		
		JLabel lblBarraTitulo = new JLabel("texto");
		lblBarraTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		panelTitulo.add(lblBarraTitulo);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation(300);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		
		JPanel panelDerecho = new JPanel();
		splitPane.setRightComponent(panelDerecho);
		
		JEditorPane imagen = new JEditorPane();
		
		Box verticalBox = Box.createVerticalBox();
		
		Box verticalBox_1 = Box.createVerticalBox();
		
		Box horizontalBox = Box.createHorizontalBox();
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		
		JPanel panel = new JPanel();
		
		JButton btnGuardar = new JButton("Guardar");
		
		JButton btnNuevo = new JButton("Nuevo");
		
		GroupLayout gl_panelDerecho = new GroupLayout(panelDerecho);
		gl_panelDerecho.setHorizontalGroup(
			gl_panelDerecho.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelDerecho.createSequentialGroup()
					.addGap(304)
					.addComponent(verticalBox, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(184, Short.MAX_VALUE))
				.addGroup(gl_panelDerecho.createSequentialGroup()
					.addContainerGap()
					.addComponent(horizontalBox, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(imagen, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_1, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
					.addGap(7))
				.addGroup(gl_panelDerecho.createSequentialGroup()
					.addGap(76)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
					.addGap(71))
				.addGroup(Alignment.LEADING, gl_panelDerecho.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGuardar)
					.addPreferredGap(ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
					.addComponent(btnNuevo)
					.addContainerGap())
				.addGroup(gl_panelDerecho.createSequentialGroup()
					.addGap(241)
					.addComponent(verticalBox_1, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
					.addGap(229))
		);
		gl_panelDerecho.setVerticalGroup(
			gl_panelDerecho.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDerecho.createSequentialGroup()
					.addGroup(gl_panelDerecho.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDerecho.createSequentialGroup()
							.addContainerGap()
							.addComponent(verticalBox, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
							.addComponent(imagen, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDerecho.createSequentialGroup()
							.addGap(81)
							.addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDerecho.createSequentialGroup()
							.addGap(83)
							.addComponent(horizontalBox_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(verticalBox_1, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
					.addGap(8)
					.addGroup(gl_panelDerecho.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar)
						.addComponent(btnNuevo))
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		
		JLabel lblAo = new JLabel("Año");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblMax = new JLabel("max");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblMin = new JLabel("min");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblJugadores = new JLabel("Jugadores");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblRanking = new JLabel("Ranking");
		
		JLabel lblRating = new JLabel("Rating");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblTiempoDeJuego = new JLabel("Tiempo de Juego");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblRanking)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblRating)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblJugadores)
									.addGap(18)
									.addComponent(lblMin)
									.addGap(4)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addGap(24))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblTiempoDeJuego)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblMax)
									.addGap(4)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_6, 0, 0, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblAo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMin)
								.addComponent(lblJugadores)))
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblMax)))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTiempoDeJuego)
							.addGap(18)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRanking))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRating)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_1.add(horizontalGlue_1);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox_1.add(verticalGlue);
		panelDerecho.setLayout(gl_panelDerecho);
		
		panelIzquierdo = new JPanel();
		splitPane.setLeftComponent(panelIzquierdo);
		
		tabla = new JTable();
		panelIzquierdo.add(tabla);
		GroupLayout gl_panelIzquierdo = new GroupLayout(panelIzquierdo);
		gl_panelIzquierdo.setHorizontalGroup(
			gl_panelIzquierdo.createParallelGroup(Alignment.LEADING)
				.addComponent(tabla, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
		);
		gl_panelIzquierdo.setVerticalGroup(
			gl_panelIzquierdo.createParallelGroup(Alignment.LEADING)
				.addComponent(tabla, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
		);
		panelIzquierdo.setLayout(gl_panelIzquierdo);
		
		JScrollPane scrollPane = new JScrollPane();
		panelIzquierdo.add(scrollPane);
		scrollPane.add(tabla);
		

	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public JMenuItem getMntmAbrir() {
		return mntmAbrir;
	}
	
	public JTable getTabla() {
		return tabla;
	}
	
	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}
}
