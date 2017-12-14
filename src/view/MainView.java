package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.text.DefaultCaret;

import com.github.sarxos.webcam.Webcam;

import controller.AuthorController;
import controller.ChatEmoticons;
import controller.GuideController;
import controller.MainViewController;
import controller.WebcamVideo;

@SuppressWarnings("serial")
public class MainView extends JFrame implements WindowListener, ActionListener, KeyListener {
	private JMenuBar menuBar;
	private JMenu file, infor;
	private JMenuItem fresh, exit, guide, inforAuthor;
	GuideController guideController;
	AuthorController authorController;
	JTextArea chatArea, chatReiceiArea;
	MainViewController mViewControll;
	JScrollPane scrollChat, scrollReceipt;
	Webcam webcam;
	JTextField textIP, textPort;
	JLabel lblImage, lblIP, lblPort;
//	 WebcamVideo webVideo = new WebcamVideo();
	JPanel pnlSouth, pnlSouthParent, pnlVideo, pnlEast, pnlWebcam, pnlTmp, pnlNorth, pnlCenter;
	JButton btnOpenWC, btnPause, bntCloseWC, btnMinium, btnMicrohone, btnConnect;
	public Image image;
	ArrayList<JInternalFrame> listInternalFrame;
	String chat;
	int count, counts, countss = 1;
	WebcamVideo webVideo;
	JLayeredPane lPaneEmo = new JLayeredPane();
	ChatEmoticons emo = new ChatEmoticons();

	public MainView() throws Exception {
		super();
		mViewControll = new MainViewController(this);
		webVideo = new WebcamVideo(this);
		view();
	}

	public JTextArea getChatArea() {
		return chatArea;
	}

	public void setChatArea(JTextArea chatArea) {
		this.chatArea = chatArea;
	}

	public JTextArea getChatReiceiArea() {
		System.out.println(chatReiceiArea == null ? "null" : "0");
		return chatReiceiArea;
	}

	public void setChatReiceiArea(JTextArea chatReiceiArea) {
		this.chatReiceiArea = chatReiceiArea;
	}

	public String getChat() {
		return chat;
	}

	public void setChat(String chat) {
		this.chat = chat;
	}

	// view tổng
	public void view() throws Exception {
		// JDialog.setDefaultLookAndFeelDecorated(true); //sử dụng màu mè hoa lá hẹ cho
		// swing
		// Tạo hình nền
		BufferedImage myImage = ImageIO.read(getClass().getResource("/image/spot.jpg"));
		setContentPane(new JLabel(new ImageIcon(myImage)));
		setLayout(new BorderLayout());
		// Tạo Menubar
		menuBar();
		// Thêm các jpanel
		add(north(), BorderLayout.NORTH);

		JSplitPane jsplitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, center(), east());
		jsplitpane.setResizeWeight(1.0);
		jsplitpane.setBackground(new Color(255, 255, 255, 50));
		jsplitpane.setOpaque(false);
		add(jsplitpane, BorderLayout.CENTER);

		setTitle("Video call center");
		// icon video call
		Image imgAvatar1 = ImageIO.read(getClass().getResource("/image/videocall.png"));
		setIconImage(imgAvatar1);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setResizable(true);
		getContentPane().setBackground(null);

		setExtendedState(JFrame.MAXIMIZED_BOTH); // full size
		// setUndecorated(true);//excute with title bar (không cho phép thu nhỏ phóng to
		// và tắt)
		pack();
		setVisible(true);
		this.addWindowListener(this);
		// sự kiện thoát game
		mViewControll.login();
		mViewControll.chatServer();
		pack();

		// setEnabled(false);

	}

	public JInternalFrame createInteralFrame(String userName, String src) throws IOException {

		JInternalFrame mboxFrame = new JInternalFrame(userName, true, true, true, true);
		JLabel lblUserVideo = new JLabel("User");
		JButton btn = new JButton();
		JPanel pnlButton = new JPanel(new FlowLayout());
		Image imgg = ImageIO.read(getClass().getResource(src));
		mboxFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		mboxFrame.addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent e) {
				String[] buttons = { "Có", "Không" };
				ImageIcon icon = new ImageIcon(getClass().getResource("/image/telephone.png"));

				int quit = JOptionPane.showOptionDialog(null, "Bạn chắc chắn muốn đóng User này chứ?", "Đóng User",
						JOptionPane.INFORMATION_MESSAGE, 0, icon, buttons, null);

				System.out.println(quit);
				if (quit == 0) {
					mboxFrame.dispose();
				} else {
					// e.getWindow().dispose();
				}

			}
		});
		JButton btnPrint = addButton(btn, "Print Screen", "/image/play.png");
		JButton btnVolume = addButton(btn, "Print Screen", "/image/muted.png");

		pnlButton.add(btnPrint);
		pnlButton.add(btnVolume);

		// xet size va che do hien thi anh
		lblUserVideo.setIcon(new ImageIcon(imgg));

		mboxFrame.add(lblUserVideo, BorderLayout.CENTER);
		mboxFrame.add(pnlButton, BorderLayout.SOUTH);
		mboxFrame.setSize(320, 320);
		mboxFrame.setLocation(10, 10);
		mboxFrame.setVisible(true);

		return mboxFrame;

	}

	// khung center
	public JDesktopPane center() throws IOException {
		JDesktopPane dtp = new JDesktopPane();
		dtp.setBackground(new Color(255, 255, 255, 50));
		dtp.setOpaque(false);

		listInternalFrame = new ArrayList<>();
		listInternalFrame.add(createInteralFrame("User 1", "/image/wide.jpg"));
		listInternalFrame.add(createInteralFrame("User 2", "/image/wide.jpg"));
		listInternalFrame.add(createInteralFrame("User 3", "/image/wide.jpg"));

		for (int i = 0; i < listInternalFrame.size(); i++) {
			dtp.add(listInternalFrame.get(i));
		}

		return dtp;
	}

	public JPanel north() throws IOException {
		JButton button = new JButton();
		pnlNorth = new JPanel(new FlowLayout());
		pnlNorth.setBorder(new TitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Connect Server",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null,
				java.awt.Color.BLUE)));

		lblIP = new JLabel("IP: ");
		textIP = new JTextField(15);
		lblPort = new JLabel("Port: ");
		textPort = new JTextField(15);
		btnConnect = addButton(button, "Connect Server", "/image/open.png");
		btnConnect.addActionListener(this);

		pnlNorth.add(lblIP);
		pnlNorth.add(textIP);
		pnlNorth.add(lblPort);
		pnlNorth.add(textPort);
		pnlNorth.add(btnConnect);
		pnlNorth.setBackground(new Color(255, 255, 255, 150));
		pnlNorth.setOpaque(false);
		return pnlNorth;

	}

	// menuBar
	public void menuBar() {
		menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		// đổi màu cho cái background menuBar
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		file = new JMenu("Tệp");
		file.setIcon(new ImageIcon(getClass().getResource("/image/file.png")));
		file.setMnemonic(KeyEvent.VK_T);

		fresh = new JMenuItem("Làm mới");
		fresh.setMnemonic(KeyEvent.VK_L);
		fresh.setIcon(new ImageIcon(getClass().getResource("/image/new.png")));
		file.add(fresh);

		exit = new JMenuItem("Thoát");
		exit.setMnemonic(KeyEvent.VK_T);
		exit.setIcon(new ImageIcon(getClass().getResource("/image/shutdown.png")));
		file.add(exit);

		infor = new JMenu("Thông tin");
		infor.setIcon(new ImageIcon(getClass().getResource("/image/question.png")));
		infor.setMnemonic(KeyEvent.VK_O);

		guide = new JMenuItem("Hướng dẫn");
		guide.setMnemonic(KeyEvent.VK_H);
		guide.setIcon(new ImageIcon(getClass().getResource("/image/description.png")));
		infor.add(guide);

		inforAuthor = new JMenuItem("Thông tin Tác Giả");
		inforAuthor.setMnemonic(KeyEvent.VK_T);
		inforAuthor.setIcon(new ImageIcon(getClass().getResource("/image/info.png")));
		infor.add(inforAuthor);

		menuBar.add(file);
		menuBar.add(infor);

		fresh.addActionListener(this);
		guide.addActionListener(this);
		inforAuthor.addActionListener(this);
		exit.addActionListener(this);
		setJMenuBar(menuBar);

	}

	// Khung chat
	public JPanel east() throws IOException, Exception {

		pnlEast = new JPanel(new BorderLayout());
		pnlEast.setBackground(new Color(255, 255, 255, 50));
		pnlEast.setMaximumSize(new Dimension(350, HEIGHT));
		pnlEast.setMinimumSize(new Dimension(260, HEIGHT));
		pnlEast.setOpaque(false);

		pnlEast.setBorder(new TitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khung trò chuyện",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, null,
				java.awt.Color.decode("#fbfbfb"))));

		Calendar c = Calendar.getInstance();

		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		Font font = new Font("Tahoma", Font.BOLD, 11);
		JTextPane t = new JTextPane();
		chatReiceiArea = new JTextArea(10, 30);
		chatReiceiArea.setFont(font);

		Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);

		chatReiceiArea.setText("Hôm nay: thứ " + dayOfWeek++ + ": " + day + "-" + month + "-" + year + "\n\n");

		DefaultCaret caret = (DefaultCaret) chatReiceiArea.getCaret(); // tự động auto xem dòng tin nhắn ở cuối
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		chatReiceiArea.setWrapStyleWord(true);// dùng cho 1 từ, nều từ đó dài quá khuôn khổ sẻ tự xuống dòng tiện verler
		chatReiceiArea.setLineWrap(true);// nếu đoạn văn bản quá dài thì area sẻ tự động xuống dòng
		// chatReiceiArea.setBackground( new Color(255, 255, 255, 0) );
		chatReiceiArea.setEditable(false);// không thể chỉnh sửa dòng văn bản
		// chatReiceiArea.setOpaque(false); // background of parent will be painted
		// first
		Image imgg = ImageIO.read(getClass().getResource("/image/smiling.png"));
		// anh run
		Image newimg = imgg.getScaledInstance(18, 18, java.awt.Image.SCALE_SMOOTH);

		scrollReceipt = new JScrollPane(chatReiceiArea);
		scrollReceipt.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		chatArea = new JTextArea(4, 30);
		chatArea.setFont(font);
		// chatArea.setFont(helvetica);
		chatArea.setEditable(true); // set textArea non-editable
		chatArea.setWrapStyleWord(true);// dùng cho 1 từ
		chatArea.setLineWrap(true);// nếu đoạn văn bản quá dài thì area sẻ tự động xuống dòng
		scrollChat = new JScrollPane(chatArea);
		scrollChat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		JPanel pnlIcon_File = new JPanel(new BorderLayout());
		JButton button = new JButton();
		JButton bntIcon = addButton(button, "Icon", "/image/smiling.png");
		JButton bntFile = addButton(button, "Icon", "/image/paperclip.png");
		
		JLayeredPane lPaneChat = new JLayeredPane();
		lPaneChat.setBounds(0, 0, 594, 249);
		lPaneEmo.setBackground(Color.red);
		lPaneEmo.setBounds(10, 10, 178, 160);
		lPaneEmo.setVisible(false);
		lPaneChat.add(lPaneEmo,JLayeredPane.POPUP_LAYER);
		lPaneEmo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				lPaneEmo.setVisible(false);
			}
		});
		bntIcon.setVerticalAlignment(SwingConstants.TOP);
		bntIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("click me");
				t.insertIcon(new ImageIcon(imgg));
				if(lPaneEmo.isVisible()){
					lPaneEmo.setVisible(false);
				}else{
					lPaneEmo.setVisible(true);
					lPaneEmo.requestFocus();
				}
			}
		});
		bntIcon.setHorizontalAlignment(SwingConstants.CENTER);
		add(lPaneChat,BorderLayout.SOUTH);
		
		
		
		pnlIcon_File.add(bntIcon, BorderLayout.CENTER);
		pnlIcon_File.add(bntFile, BorderLayout.SOUTH);
		
//		bntIcon.setIcon(emo.smiley);


		pnlWebcam = new JPanel(new BorderLayout());
		pnlWebcam.add(scrollChat, BorderLayout.CENTER);
		pnlWebcam.add(pnlIcon_File, BorderLayout.EAST);
		pnlWebcam.add(south(), BorderLayout.SOUTH);

		pnlEast.add(pnlWebcam, BorderLayout.SOUTH);
		pnlEast.add(scrollReceipt, BorderLayout.CENTER);

		chatArea.addKeyListener(this);
//		bntIcon.addActionListener(this);

		return pnlEast;

	}

	// chứa các thành phần ở phía nam của frame
	public JPanel south() throws IOException {
		JButton button = new JButton();
		// javax.swing.border.Border NORMAL_BORDER =
		// BorderFactory.createLineBorder(Color.BLACK, 4);
		// javax.swing.border.Border ROLLOVER_BORDER =
		// BorderFactory.createLineBorder(Color.RED, 4);
		// button.setBorder(NORMAL_BORDER);
		pnlSouth = new JPanel(new BorderLayout());// gom tất cả thành phần và ép nó về phía dưới của frame tổng
		pnlSouthParent = new JPanel(new BorderLayout());// đưa pnlSouth về phía đông
		pnlSouth.setBorder(new TitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Webcam của bạn",
				javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, null,
				java.awt.Color.decode("#FF0301"))));

		// khai báo đối tưởng webcam với time out mặc định.s
//		Webcam webcam = Webcam.getDefault();
//		for (Dimension dimension : webcam.getViewSizes()) {
//			System.out.println(dimension.toString());
//
//		}
//		 hoặc setView với card mà web hỗ trợ, ở đây dùng đại VGA mặc định 640*480, nhà
//		 nghèo :)
//		webcam.setViewSize(new Dimension(176, 144));
//		 Mở webcam
//		webcam.open();
		// Tạo khung giao diện
		

		pnlVideo = new JPanel(new BorderLayout());// Cần một panel tổng
		pnlTmp = new JPanel(new FlowLayout());
		pnlTmp.setVisible(false);
		JPanel pnlGroupBnt = new JPanel(new FlowLayout());
		lblImage = new JLabel();// là đối tượng chứa khủng ảnh của webcam khi dùng thred
		// set title màu mè cho đẹp thôi

		btnOpenWC = addButton(button, "Mở Webcam", "/image/open.png");// tạo một button để capture nếu ko cần thì cũng
																		// ok
		btnPause = addButton(button, "Tạm dừng Webcam", "/image/pause.png");
		btnPause.setEnabled(false);
		btnMinium = addButton(button, "Thu nhỏ", "/image/down.png");
		btnMinium.setEnabled(false);
		btnMicrohone = addButton(button, "Microphone", "/image/muted.png");
		btnMicrohone.setEnabled(false);

		btnPause.addActionListener(this);
		btnMinium.addActionListener(this);
		btnMicrohone.addActionListener(this);

		// action
		btnOpenWC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					webVideo.createWebcam(webcam, lblImage);
					webVideo.start();
					pnlTmp.setVisible(true);
					btnPause.setEnabled(true);
					btnMinium.setEnabled(true);
					btnMicrohone.setEnabled(true);
					btnOpenWC.setEnabled(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// btnPause = addButton(new JButton(""), "Tạm ngừng Webcam", "");
		pnlTmp.add(lblImage);
		pnlVideo.add(pnlTmp, BorderLayout.CENTER);
		pnlGroupBnt.add(btnOpenWC);
		pnlGroupBnt.add(btnPause);
		pnlGroupBnt.add(btnMinium);
		pnlGroupBnt.add(btnMicrohone);

		pnlVideo.add(pnlGroupBnt, BorderLayout.SOUTH);

		pnlSouthParent.add(pnlVideo, BorderLayout.CENTER);
		pnlSouth.add(pnlSouthParent, BorderLayout.SOUTH);
		pnlVideo.setBackground(new Color(255, 255, 255, 0));
		pnlSouthParent.setBackground(new Color(255, 255, 255, 0));
		pnlSouth.setBackground(new Color(255, 255, 255, 0));
		return pnlSouth;

	}

	/* Phương thức thêm một button vào component */
	public JButton addButton(JButton button, String textTooltip, String img) throws IOException {
		button = new JButton();
		button.setPreferredSize(new Dimension(40, 25));// size button
		button.setToolTipText(textTooltip);
		// button.setContentAreaFilled(false);// ko hien background cua button
		Image imgg = ImageIO.read(getClass().getResource(img));
		// anh run
		Image newimg = imgg.getScaledInstance(18, 18, java.awt.Image.SCALE_SMOOTH);
		// xet size va che do hien thi anh
		button.setIcon(new ImageIcon(newimg));
		return button;
	}

	public static void main(String[] args) throws Exception {
		new MainView();
	}

	// sự kiện các button
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {// sự kiện exit
			mViewControll.windowsClosing();
		}
		if (e.getSource() == fresh) {// fresh lại ứng dụng
			mViewControll.refeshFrame();
		}
		if (e.getSource() == guide) {// hướng dẫn sử dụng
			guideController = new GuideController();
		}
		if (e.getSource() == inforAuthor) {// thông tin tác giả
			authorController = new AuthorController();
		}
		if (e.getSource() == btnConnect) {// butto kết nối đến server
//			 add(webVideo.createNewUser("User 1", "/image/wide.png"));

		}
		if (e.getSource() == btnPause) {
			if (count % 2 == 0) {
				count++;
				try {
					mViewControll.play("/image/pause.png", btnPause);
					// webVideo.resumeWebcam(webcam);
					// webVideo.resume();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				count++;
				try {
					// webVideo.stop();
					// webVideo.resume();
					// webVideo.createWebcam(webcam, lblImage);
					mViewControll.pause("/image/play.png", btnPause);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if (e.getSource() == btnMinium) {

			if (counts % 2 == 0) {
				counts++;
				mViewControll.minium(pnlTmp, false);

			} else {
				counts++;
				mViewControll.minium(pnlTmp, true);
			}
		}
		if (e.getSource() == btnMicrohone) {
			if (countss % 2 == 0) {
				countss++;
				try {
					mViewControll.microphone("/image/muted.png", btnMicrohone);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {
				countss++;
				try {
					mViewControll.microphone("/image/microphone.png", btnMicrohone);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		mViewControll.windowsClosing();

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		try {
			if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isShiftDown()) {
			} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				setChat( chatArea.getText());// lấy dòng chat của client
				mViewControll.chat(getChat());// gửi qua cho controller và controller tiến hành
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
