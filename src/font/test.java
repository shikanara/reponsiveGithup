package font;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

public class test extends JFrame {
	private String version = "1.1.0";
	private Color forColor = new Color(0x222222);
	private static JFrame frmChatapp;
	private String nameExp, trText, username, serverIP = null;
	private Socket sock;
	private BufferedReader reader;
	private PrintWriter writer;
	private ArrayList<String> userList = new ArrayList<>();
	private ArrayList<File> fileList = new ArrayList<>();
	private Boolean isConnected = false, repeats = true, erepeats = false, placeOnce = true, soundOn = false;
	private SimpleAttributeSet right = new SimpleAttributeSet();
	private File file;
	private JLayeredPane lPaneEmo = new JLayeredPane();
	private JTextField usernameField;
	private JTextArea onlineUsersArea, inputTextArea;
	private JTextPane chatPane, datePane, namePane;
	private StyledDocument doc, doc1, doc2;
	private JButton connectButton;
	private JLabel lblNewLabel_1, lblConnectingToServer;
	private ActionListener connectLis, disconnectLis;
	private ChatEmoticons emo = new ChatEmoticons();
	JScrollPane scrollPane;
	JLabel panelInput;

	public static void main(String[] args) {
		new test();
	}

	public test() {
		
		// inputTextArea
		scrollPane = new JScrollPane();
		inputTextArea = new JTextArea();
		inputTextArea.setForeground(forColor);
		scrollPane.setViewportView(inputTextArea);
		inputTextArea.setBorder(null);
		inputTextArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		inputTextArea.setLineWrap(true);
		inputTextArea.setColumns(10);
		InputMap input = inputTextArea.getInputMap();
		ActionMap actions = inputTextArea.getActionMap();

		// EmoButton
		JLabel emoButton = new JLabel("");
		emoButton.setBounds(338, 0, 31, 42);
		panelInput = new JLabel();
		panelInput.add(emoButton);
		emoButton.setVerticalAlignment(SwingConstants.TOP);
		emoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (lPaneEmo.isVisible()) {
					lPaneEmo.setVisible(false);
				} else {
					lPaneEmo.setVisible(true);
					lPaneEmo.requestFocus();
				}
			}
		});
		emoButton.setHorizontalAlignment(SwingConstants.CENTER);
		emoButton.setIcon(emo.smiley);

		// iconback
		JLabel iconback = new JLabel("");
		iconback.setBounds(0, 0, 178, 160);
		iconback.setIcon(new ImageIcon(getClass().getResource("/image/icons/emoback.png")));
		lPaneEmo.add(iconback, JLayeredPane.MODAL_LAYER);
		
		add(scrollPane,BorderLayout.WEST);
		add(emoButton,BorderLayout.EAST);
		setSize(new Dimension(300, 300));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(true);
		pack();
		setVisible(true);
	}
}