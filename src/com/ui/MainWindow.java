package com.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.dal.IExcelReader;
import com.models.HblLine;

public class MainWindow extends JFrame {
	
	private IExcelReader excelReader;
	public MainWindow
	(IExcelReader excelReader
			){
		this.excelReader=excelReader;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0, 0, 600, 200);
		this.setTitle("KEWILL HBL Line Update 1.0");
		this.add(getPanel());
		
		this.setVisible(true);
	}
	private JPanel panel;
	public JPanel getPanel() {
		panel=new JPanel();
		panel.setBounds(0, 0, 400, 200);
		
		this.add(getExcelFileLabel());
		this.add(getFileTextBox());
		
		this.add(getBrowseButton());
		this.add(getAutomateButton());
		return panel;
	}
	private JLabel excelFileLabel;
	private JTextField fileTextBox;
	private JButton browseButton,automateButton;
	private JFileChooser fileBrowser;
	public JFileChooser getFileBrowser() {
		fileBrowser=new JFileChooser();
		FileFilter filter=new FileNameExtensionFilter("Excel", "xls","xlsx","xlsb");
		fileBrowser.setFileFilter(filter);
		int i=fileBrowser.showOpenDialog(this.panel);
		if (i==JFileChooser.APPROVE_OPTION) {
			fileTextBox.setText(fileBrowser.getSelectedFile().getPath());
		}
		return fileBrowser;
	}

	public JLabel getExcelFileLabel() {
		excelFileLabel=new JLabel("File");
		excelFileLabel.setBounds(100, 20, 60, 30);
		
		return excelFileLabel;
	}
	
	public JTextField getFileTextBox() {
	fileTextBox=new JTextField();
	fileTextBox.setBounds(excelFileLabel.getX()+excelFileLabel.getWidth()+10, excelFileLabel.getY(), 200, 30);
	
		return fileTextBox;
	}
	
	public JButton getBrowseButton() {
		browseButton=new JButton();
		
		browseButton.setBounds(fileTextBox.getX()+fileTextBox.getWidth()+10, fileTextBox.getY(), 100, 30);
		browseButton.setText("Browse");
		browseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println("I have been clicked");
				getFileBrowser();
				
			}
		});
		return browseButton;
	}

	public JButton getAutomateButton() {
	automateButton=new JButton();
	automateButton.setBounds(fileTextBox.getX(), fileTextBox.getY()+fileTextBox.getHeight()+40, fileTextBox.getWidth(), fileTextBox.getHeight());
	automateButton.setText("Automate");
	automateButton.addActionListener(onAutomateButtonClick());
		return automateButton;
	}

	private ActionListener onAutomateButtonClick() {
		// TODO Auto-generated method stub
		ActionListener actionListener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Clicked");
				String fileName=fileTextBox.getText();
			LinkedList<HblLine>lines=excelReader.GetHblData(fileName);
			
			}
		};
		return actionListener;
	}
	
	
	

}
