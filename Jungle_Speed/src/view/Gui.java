package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import model.Main;
import model.Player;

public class Gui extends View {

	private JPanel panel;


	/**
	 * Create the application.
	 */
	
	public Gui( Player model,Controller controller) {
		super(model, controller);
		initialize();
	}

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setLayout(null);
		this.setBounds(0, 0, 680, 680);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Jungle Speed");
		
		
		panel = new JPanel();
		panel.setLayout(null);
		//frame.getContentPane().add(panel, BorderLayout.NORTH);
		this.setContentPane(panel);
		
		JButton button = new JButton();
		//button.setName("");
		button.setBounds(290, 290, 100, 100);
		button.setName("totem");
		panel.add(button);
		Gui.addListener(this,button);
	
	}
	/**
	 * 
	 * @param gui
	 * @param panel
	 */
	 public  static void addListener(Gui gui,JButton button) {
		 button.addMouseListener(new MouseAdapter() {
			
			 public void mousePressed(MouseEvent e) {
				 gui.getModel().pickTotem(Main.g);
				 
				 
				 Main.print("totem pris");
			 }  
			 
		 });
		 
	 }

}
