package controller;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.awt.Image;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.PlaceholderController.GhostText;

import model.UserModel;
import view.MainView;

public class MainViewController {
	JTextField user, pass;
	UserModel listUser;
	static final int PORT = 7;
	static final String IP = "127.0.0.1";
	PrintWriter out;
	BufferedReader in, inSystem;
	String line;
	Socket socket;
	MainView mainView;
	Calendar cal;
	SimpleDateFormat sdf;
	String userName;
	PlaceholderController placeholder;
	GhostText ghostText;
	ChatEmoticons emo = new ChatEmoticons();

	public MainViewController(MainView main) {
		this.mainView = main;
		userName = new String();
		placeholder=new PlaceholderController();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// phương thức bắt sự kiện đóng ứng dụng
	// có tắt hay không nếu có thì tắt chương trình nếu không thì thôi
	public void windowsClosing() {
		String[] buttons = { "Có", "Không" };
		ImageIcon icon = new ImageIcon(getClass().getResource("/image/cry1.gif"));

		int quit = JOptionPane.showOptionDialog(null, "Bạn chắc chắn muốn đóng Video call chứ?", "Đóng ứng dụng",
				JOptionPane.INFORMATION_MESSAGE, 0, icon, buttons, null);

		System.out.println(quit);
		if (quit == 0) {
			System.exit(0);
		} else {
			// e.getWindow().dispose();
		}

	}

	// là phương thức tạo ra client chat, truyền dữ liệu chat lên server
	// với caht là kiểu dữ liệu string
	public void chatServer() throws IOException, IOException {
		socket = new Socket(IP, PORT);
		out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		ghostText = new GhostText(mainView.getChatArea(),"  Nhập tin nhắn ...");
		while (in.read() != -1) {
			cal = Calendar.getInstance();
			sdf = new SimpleDateFormat("HH:mm:ss");
//			StyleConstants.setForeground(null, SystemColor.textHighlight);
			mainView.getChatReiceiArea().append(
					"[" + sdf.format(cal.getTime()) + "] "+ in.readLine().trim() + "\n");// append
			// ghi đoạn chat mà server gửi về
			//set lại text cho khung nhập chat là rỗng
			mainView.getChatArea().setText(null);
			//Tạo chữ nhập tin nhắn và bắt sự kiện click mouse
			ghostText = new GhostText(mainView.getChatArea(),"  Nhập tin nhắn ...");
//			mainView.getChatArea().setForeground(Color.GRAY);

		}

	}

	public void chat(String chat) throws IOException {
		if (chat != null) {
			// gửi đoạn chat lên server
			out.println(getUserName()+ ": " +chat.trim());

		} else {

		}

	}

	// phương thức kiểm tra user có tồn tại trong databse ko
	// trả về true nếu có tồn tại
	public boolean checkUser(String user, String pass) {
		listUser = new UserModel();
		boolean check = false;

		for (int i = 0; i < listUser.listUser().size(); i++) {
			if (listUser.listUser().get(i).getUser().equalsIgnoreCase(user)
					&& listUser.listUser().get(i).getPass().equals(pass)) {
				check = true;
				break;
			} else {
				check = false;
			}
		}
		return check;
	}

	// là phương thức đăng nhập tạo ra joptionpane chứa các thông tin yêu cầu đăng
	// nhập
	// nếu đăng nhập thành công sẻ báo đăng nhập thành công
	// nếu sai thì báo sai và đăng nhập lại
	// mặc định đã được setText tài khoản có trong database
	public void login() throws IOException {
		user = new JTextField(5);
		pass = new JPasswordField(5);
		user.setText("Shika");
		pass.setText("luan");
		Object[] message = { "Tên người dùng:", user, "Mật khấu:", pass };
		String[] button = { "Đăng nhập" };
		ImageIcon iconError = new ImageIcon(getClass().getResource("/image/cry1.gif"));
		ImageIcon iconSuccess = new ImageIcon(getClass().getResource("/image/hello1.gif"));
		// videocall.png
		ImageIcon iconLogin = new ImageIcon(getClass().getResource("/image/hello1.gif"));

		int option = JOptionPane.showOptionDialog(null, message, "Nhập thông tin", JOptionPane.INFORMATION_MESSAGE, 0,
				iconLogin, button, button[0]);
		System.out.println(option);

		if (option == JOptionPane.CLOSED_OPTION) {
			String[] buttons = { "Biết rồi" };
			JOptionPane.showOptionDialog(null, "Bạn chưa nhập thông tin!", "Lỗi đăng nhập!",
					JOptionPane.INFORMATION_MESSAGE, 0, iconError, buttons, buttons[0]);
			login();
		}
		if (option == JOptionPane.OK_OPTION) {
			if (user.getText().equals("") || user.getText().equals(null) || pass.getText().equals("")
					|| pass.getText().equals(null)) {
				String[] buttons = { "Biết rồi" };
				JOptionPane.showOptionDialog(null, "Bạn chưa nhập thông tin!", "Lỗi đăng nhập!",
						JOptionPane.ERROR_MESSAGE, 0, iconError, buttons, buttons[0]);
				login();
			} else {
				if (checkUser(user.getText(), pass.getText())) {
					String[] buttons = { "Biết rồi" };
					JOptionPane.showOptionDialog(null, "Đăng nhập thành công!", "Đăng nhập!",
							JOptionPane.INFORMATION_MESSAGE, 0, iconSuccess, buttons, buttons[0]);
					// System.out.println("Đăng nhập thành công!");
					setUserName(user.getText());
				} else {
					String[] buttons = { "Biết rồi" };
					JOptionPane.showOptionDialog(null, "Nhập sai user hoặc password!", "Lỗi đăng nhập!",
							JOptionPane.INFORMATION_MESSAGE, 0, iconError, buttons, buttons[0]);
					System.out.println("Lỗi");
					login();
				}

			}
		}
	}

	// là phương thức làm mới frame trong trường hợp đơi các user khác đăng nhập vào
	// và kết nối tới server
	// hiện tại chức năng mới dự kiến nên chưa hoàn thiện
	public void refeshFrame() {
		String[] buttons = { "Có", "Không" };
		ImageIcon icon = new ImageIcon(getClass().getResource("/image/hello1.gif"));

		int quit = JOptionPane.showOptionDialog(null, "Bạn chắc chắn muốn đóng Video call chứ?", "Đóng ứng dụng",
				JOptionPane.INFORMATION_MESSAGE, 0, icon, buttons, null);

		System.out.println(quit);
		if (quit == 0) {
			// System.exit(0);
		} else {
			// e.getWindow().dispose();
		}

	}

	// chức năng tamm dừng webcam chưa làm đc gì hết
	public void pause(String img, JButton btnPause) throws IOException {
		Image imgg = ImageIO.read(getClass().getResource(img));
		// anh run
		Image newimg = imgg.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
		// xet size va che do hien thi anh
		btnPause.setIcon(new ImageIcon(newimg));

	}

	// tiếp tục webcam cũng chưa làm gì hết
	public void play(String img, JButton btnPlay) throws IOException {
		Image imgg = ImageIO.read(getClass().getResource(img));
		// anh run
		Image newimg = imgg.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
		// xet size va che do hien thi anh
		btnPlay.setIcon(new ImageIcon(newimg));
	}

	// phương thức thu nhỏ cái webcam để màn hình chat rộng hơn
	public void minium(JPanel pnlTmp, boolean set) {
		pnlTmp.setVisible(set);
	}

	// phương thức tạo ra cái button microphone
	public void microphone(String img, JButton btnMicrophone) throws IOException {
		Image imgg = ImageIO.read(getClass().getResource(img));
		// anh run
		Image newimg = imgg.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
		// xet size va che do hien thi anh
		btnMicrophone.setIcon(new ImageIcon(newimg));

	}

	public static void main(String[] args) throws IOException {
		// new MainViewController().connectVideoCam("");
	}

}
