package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Controller;
import Model.Animal;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.JList;


public class Frame extends JFrame {

	private JPanel contentPane;
	private JComboBox animalType;
	private JTextField type;
	private JTextField weight;
	private JTextField gps;
	private JTextField bloodPresure;
	private JTextField spots;
	private JPanel InfoPanel;
	private JPanel adicionalInfopanel;
	private JPanel submitPanel;
	private JPanel penguinPanel;
	private JPanel walrusPanel;
	private JPanel seaLionPanel;
	private static Controller controller;
	private JComboBox dentalCondition;
	private JComboBox sex;
	private JTextPane errorMessage;
	private JTextPane reportInfo;
	private String reportInfoMessage ="";
	private JPanel report;
	private JLabel label;
	private JList<String> list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
					controller = new Controller();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel form = new JPanel();
		contentPane.add(form, "name_1327495822002");
		form.setLayout(null);
		
		JLabel lblType = new JLabel("Select the type:");
		lblType.setBounds(188, 73, 109, 16);
		form.add(lblType);
		
		animalType = new JComboBox();
		animalType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionalInfopanel.setVisible(true);
				InfoPanel.setVisible(true);
				submitPanel.setVisible(true);
				reportInfo.setVisible(true);
				switch(animalType.getSelectedIndex()){
					case 0: penguinPanel.setVisible(true);
							seaLionPanel.setVisible(false);
							walrusPanel.setVisible(false);
					        break;
					case 1: seaLionPanel.setVisible(true);
							penguinPanel.setVisible(false);
							walrusPanel.setVisible(false);
							break;
					case 2: walrusPanel.setVisible(true);
							penguinPanel.setVisible(false);
							seaLionPanel.setVisible(false);
						    break;       
				};
			}
		});
		
		label = new JLabel("Antarctic Wildlife Research");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		label.setBounds(0, 0, 684, 42);
		form.add(label);
		animalType.setModel(new DefaultComboBoxModel(new String[] {"Penguin", "Sea Lion", "Walrus"}));
		animalType.setBounds(293, 69, 145, 27);
		form.add(animalType);
		
		InfoPanel = new JPanel();
		InfoPanel.setVisible(false);
		InfoPanel.setBounds(38, 106, 290, 135);
		form.add(InfoPanel);
		InfoPanel.setLayout(null);
		
		JLabel lblSpecie = new JLabel("Type the specie:");
		lblSpecie.setBounds(6, 5, 110, 16);
		InfoPanel.add(lblSpecie);
		
		type = new JTextField();
		type.setBounds(128, 0, 156, 26);
		InfoPanel.add(type);
		type.setColumns(10);
		
		JLabel lblSex = new JLabel("Select the sex:");
		lblSex.setBounds(6, 75, 103, 16);
		InfoPanel.add(lblSex);
		
		sex = new JComboBox();
		sex.setModel(new DefaultComboBoxModel(new String[] {"", "Masculine", "Feminine"}));
		sex.setBounds(128, 71, 156, 27);
		InfoPanel.add(sex);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setBounds(6, 38, 61, 16);
		InfoPanel.add(lblWeight);
		
		weight = new JTextField();
		weight.setBounds(62, 33, 222, 26);
		InfoPanel.add(weight);
		weight.setColumns(10);
		
		JLabel lblGps = new JLabel("GPS Coordinates:");
		lblGps.setBounds(6, 108, 110, 16);
		InfoPanel.add(lblGps);
		
		gps = new JTextField();
		gps.setBounds(128, 103, 156, 26);
		InfoPanel.add(gps);
		gps.setColumns(10);
		
		adicionalInfopanel = new JPanel();
		adicionalInfopanel.setVisible(false);
		adicionalInfopanel.setBounds(38, 253, 290, 32);
		form.add(adicionalInfopanel);
		adicionalInfopanel.setLayout(new CardLayout(0, 0));
		
		penguinPanel = new JPanel();
		penguinPanel.setVisible(false);
		adicionalInfopanel.add(penguinPanel, "name_3372088596933");
		penguinPanel.setLayout(null);
		
		JLabel lblBloodPresure = new JLabel("Blood Presure:");
		lblBloodPresure.setBounds(6, 0, 109, 16);
		penguinPanel.add(lblBloodPresure);
		
		bloodPresure = new JTextField();
		bloodPresure.setBounds(133, -5, 154, 26);
		penguinPanel.add(bloodPresure);
		bloodPresure.setColumns(10);
		
		walrusPanel = new JPanel();
		walrusPanel.setVisible(false);
		adicionalInfopanel.add(walrusPanel, "name_3406884775337");
		walrusPanel.setLayout(null);
		
		JLabel lblDentalCondition = new JLabel("Dental Condition:");
		lblDentalCondition.setBounds(0, 0, 111, 16);
		walrusPanel.add(lblDentalCondition);
		
		dentalCondition = new JComboBox();
		dentalCondition.setBounds(121, 0, 168, 27);
		walrusPanel.add(dentalCondition);
		dentalCondition.setModel(new DefaultComboBoxModel(new String[] {"", "Good", "Average", "Poor"}));
		
		seaLionPanel = new JPanel();
		seaLionPanel.setVisible(false);
		adicionalInfopanel.add(seaLionPanel, "name_3475559757631");
		seaLionPanel.setLayout(null);
		
		JLabel lblSpots = new JLabel("Spots:");
		lblSpots.setBounds(0, 0, 61, 16);
		seaLionPanel.add(lblSpots);
		
		spots = new JTextField();
		spots.setBounds(126, -5, 159, 26);
		seaLionPanel.add(spots);
		spots.setColumns(10);
		
		submitPanel = new JPanel();
		submitPanel.setVisible(false);
		submitPanel.setBounds(188, 354, 324, 54);
		form.add(submitPanel);
		submitPanel.setLayout(null);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorMessage.setVisible(false);
				boolean errorfound = false;
				String message = "";
				String animalTypeName = (String) animalType.getSelectedItem();
				String animalSpecieName = type.getText();
				String animalSexValue = (String) sex.getSelectedItem();
				String animalWeightValue = (String) weight.getText(); 
				String animalGpsValue = gps.getText();
				String validation = "";
				
				String[] validator = controller.validadeMainInfo(animalTypeName, animalSpecieName, animalSexValue, animalWeightValue, animalGpsValue);
				
				for(String validatorMessage: validator){
					if(validatorMessage !="0"){
						message+=validatorMessage +"\n";
						errorfound = true;
					}
				}
				switch(animalType.getSelectedIndex()){
				 	case 0: validation = controller.validatePenguinAditionalInfo(bloodPresure.getText());
					        break;
					case 1: validation = controller.validateSeaLionAditionalInfo(spots.getText());
							break;
					case 2: validation = controller.validateWalrusAditionalInfo((String) dentalCondition.getSelectedItem());
						    break;       
				};
					
				if(validation != "0"){
					errorfound = true;
					message+=validation;
				}
				if(errorfound){
					errorMessage.setVisible(true);
					errorMessage.setText(message);
				}else{
					switch(animalType.getSelectedIndex()){
				 	case 0: Animal penguin;
						try {
							penguin = controller.createPenguin(animalTypeName,animalSpecieName,animalSexValue,animalWeightValue,animalGpsValue, bloodPresure.getText());
							reportInfoMessage += "Animal: " + penguin.getType() + " - Added Successfuly!\n";
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case 1: Animal seaLion;
						try {
							seaLion = controller.createSeaLion(animalTypeName,animalSpecieName,animalSexValue,animalWeightValue,animalGpsValue,spots.getText());
							reportInfoMessage += "Animal: " + seaLion.getType() + " - Added Successfuly!\n";
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							break;
					case 2: Animal walrus;
						try {
							walrus = controller.createWalrus(animalTypeName,animalSpecieName,animalSexValue,animalWeightValue,animalGpsValue,(String) dentalCondition.getSelectedItem() );
							reportInfoMessage += "Animal: " + walrus.getType() + " - Added Successfuly!\n";
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							break;       
					};
					reportInfo.setText(reportInfoMessage);
					clearForm();
				}
				
		
			}
		});
		btnSubmit.setBounds(35, 0, 109, 47);
		submitPanel.add(btnSubmit);
		
		JButton btnReport = new JButton("Print Report");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 report.remove(list);
				 String[] messages = controller.showReport().split("end ");
				 DefaultListModel<String> List = new DefaultListModel<String>();
				 for(String message: messages){
					 List.addElement(message);
				 }
				 list = new JList<String>(List);
				 list.setBounds(61, 99, 547, 229);
				 report.add(list);
				
	
				form.setVisible(false);
				report.setVisible(true);
				
			}
		});
		btnReport.setBounds(156, 0, 109, 47);
		submitPanel.add(btnReport);
		
		errorMessage = new JTextPane();
		errorMessage.setFont(new Font("Lucida Grande", Font.BOLD, 9));
		errorMessage.setForeground(Color.RED);
		errorMessage.setBackground(SystemColor.window);
		errorMessage.setVisible(false);
		errorMessage.setBounds(38, 290, 619, 61);
		form.add(errorMessage);
		
		reportInfo = new JTextPane();
		reportInfo.setVisible(false);
		reportInfo.setForeground(Color.WHITE);
		reportInfo.setBackground(Color.GRAY);
		reportInfo.setBounds(341, 106, 324, 180);
		form.add(reportInfo);
		
		report = new JPanel();
		contentPane.add(report, "name_17242775491617");
		report.setLayout(null);
		
		JLabel lblAtAnAntarctic = new JLabel("Antarctic Wildlife Research");
		lblAtAnAntarctic.setBounds(124, 5, 448, 42);
		report.add(lblAtAnAntarctic);
		lblAtAnAntarctic.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtAnAntarctic.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		
		JLabel lblReport = new JLabel("Report");
		lblReport.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblReport.setBounds(124, 63, 61, 16);
		report.add(lblReport);
		
		JButton btnBack = new JButton("Back to Form");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				form.setVisible(true);
				report.setVisible(false);
			}
		});
		btnBack.setBounds(251, 340, 198, 68);
		report.add(btnBack);
		
	     list = new JList();
		 list.setBounds(61, 99, 547, 229);
		 report.add(list);
		
		
		
		
	}
	private void clearForm(){
		type.setText("");;
		sex.setSelectedIndex(0);;
		weight.setText("");; 
		gps.setText("");
		bloodPresure.setText("");
		spots.setText("");
		dentalCondition.setSelectedIndex(0);
	}
}
