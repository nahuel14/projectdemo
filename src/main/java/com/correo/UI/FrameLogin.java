package com.correo.UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameLogin extends JFrame {

	public FrameLogin() {
		super("Login");
        initUI();
	}
	
	private void initUI() {
		setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void cambiarPanel (JPanel panel) {
    	getContentPane().removeAll();
    	getContentPane().add(panel);
    	getContentPane().validate();
    }
    
    public JFrame getFrame() {
    	return this;
    } 

}
