package com.correo.UI;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.correo.Handler.Handler;


public class FramePrincipal extends JFrame {
	 
    private Handler handler;

	public FramePrincipal(Handler handler) {
        super("TP Correo");
        this.handler = handler;
        initUI();
    }
 
    private void initUI() {
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menuBar = new PrincipalMenuBar(handler);
		setJMenuBar(menuBar);
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