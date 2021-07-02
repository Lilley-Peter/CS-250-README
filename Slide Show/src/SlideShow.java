/*
 * Peter Lilley
 * SNHU
 * 7/1/2021
 * CS-250
 */
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		//Changed the title to incorporate "Detox and Wellness Travel" this is now the new directive of the Product owner
		setTitle("Top 5 Destinations SlideShow for Detox and Wellness Travel");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Arizona.jpg") + "'</body></html>";
			//Photo Author: Tobi 87
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Costa_Rica.jpg") + "'</body></html>";
			//Photo Author: Pigment-Ink
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Quebec.jpg") + "'</body></html>";
			//Photo Author: Wilfridor
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Isreal.jpg") + "'</body></html>";
			//Photo Author: Greg Schechter
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Cabo San Luca.jpg") + "'</body></html>";
			//Photo Author: DestinationFearFan
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 Hilton Sedona Resort At Bell Rock, Arizona.</font> <br>Spectacular canyon views and hiking.</body></html>";
			//Changed the picture and description to fit the new requests from the product owner
		} else if (i==2){
			text = "<html><body>#2 Cala Luna Boutiqu, Costa Rica.</font> <br> A wellness experience in a Tropical Paradise!</body></html>";
			//Changed the picture and description to fit the new requests from the product owner
		} else if (i==3){
			text = "<html><body>#3 Spa Eastman, Quebec, Canada. </font> <br> A nortic spa infumous for its natural health benifits and stress releif.</body></html>";
			//Changed the picture and description to fit the new requests from the product owner
		} else if (i==4){
			text = "<html><body>#4 Isotel Dead Sea Resort & Spa, Israel. </font> <br> With the lowest elevations on Earth it is one of salties bodies of water giving it renowned healing powers.</body></html>";
			//Changed the picture and description to fit the new requests from the product owner
		} else if (i==5){
			text = "<html><body>#5 Cabo San Lucas, Mexico. </font> <br> Home to a tranqual spa that will open your soul, body, and mind.</body></html>";
			//Changed the picture and description to fit the new requests from the product owner
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}