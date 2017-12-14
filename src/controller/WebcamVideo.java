package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.sarxos.webcam.Webcam;

import view.MainView;

public class WebcamVideo extends Thread {
	Webcam webcam;
	JLabel lblImage,lblUserVideo;
	MainView main;
	
	public WebcamVideo(MainView main) {
		this.main=main;
	}
	
	public JInternalFrame createNewUser(String userName,String srcImage ) {
		//resizable, closable, maximizable, iconfileables
		JInternalFrame user1 = new JInternalFrame(userName, true, true, true,true);
		JPanel pnlUser = new JPanel();
		lblUserVideo= new JLabel("User");
		JPanel pnlControll = new JPanel(new FlowLayout());
		
		pnlUser.add(lblUserVideo);
		lblUserVideo.setIcon(new ImageIcon(srcImage));
		user1.add(pnlUser,BorderLayout.CENTER);
		user1.setSize(320, 280);
		user1.setMaximumSize(new Dimension(177, 144));
		user1.moveToFront();
		user1.setVisible(true);
		
		return user1;
	}

	public void createWebcam(Webcam webcam, JLabel lblImage) throws IOException {
		this.webcam = webcam;
		this.lblImage = lblImage;

	}
	
	public void resumeWebcam(Webcam webcam) throws IOException {
		this.webcam = webcam;

	}

	@Override
	public void run() {
		try {
			while (true) {
				Image imageVideo = webcam.getImage();
				
				if(imageVideo!=null) {
					lblImage.setIcon(new ImageIcon(imageVideo));
					main.image=imageVideo;
					Thread.sleep(50);
					
				}else {
					System.out.println("Mất kết nối!");
					break;
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
