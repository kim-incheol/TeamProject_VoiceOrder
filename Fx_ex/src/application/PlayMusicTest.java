package application;

import application.Find_file;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.util.Duration;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;

public class PlayMusicTest extends JFrame{
	
	static int i=0;
	static DefaultListModel demoList = new DefaultListModel(); //�˻�
    static JList searchlist1 = new JList(demoList); //�˻�
	static JLabel music_singer;
	static JLabel music_name;
	static JButton now_play;
	static JSlider sound_controler = new JSlider(JSlider.VERTICAL, 0, 100, 50);   //0 ����,  100����, ��� ���� ��������
	
	static boolean adjust;
	static boolean list_bool=false;  //��ũ�� ����Ʈ Ŭ�� ���� ��?
	
	static String[] songArr= {"������༭����-��","����Ҹ��鸮��-��", 
			"���õ������³ʿ���-��ũ��(MAKTUB)","���帶��-Ȳ�ο�","���̹�����-������,���μ�"};           //������༭����-��//����Ҹ��鸮��-��//���̹�����-������,���μ�
	static ArrayList<Media> media_AL = new ArrayList<>();
	static Media m;
	static MediaPlayer player;     //�̰� ������ thread .play .stop ���� ���
	static boolean playtype=true;
	static boolean ccc=true;

	static JLabel l = new JLabel();
	static JSlider s = new JSlider();
	static Timer t;
	static Timer t_2;
	static JLabel play_main;


	static boolean btn_status_FlowMusic_B=true;            //true����    //false ����
	static int index;//���� ���� �뷡�� �ε������� �� �� ����

	static boolean btn_status_oneway_B = true;         //�Ѱ�/����

	static ArrayList<Integer> Add_before_song = new ArrayList<>();   //������������ �Ҹ��� �޽��϶�  

	//�뷡 �߰�
	void setSong(String[] songArr) {
		//      int index;   //�뷡 ��ġ �ľ�      ���߿� �ε��� �ʿ��� �� ���
		for(int i=0;i<songArr.length;i++) {
			m =  new Media("file:/c:/musics/"+songArr[i]+".mp3");   // �뷡�������� �̵�� ���� 
			media_AL.add(m);         // media arrayList�� �̵�� ����
		}
		//		for(int i=0;i<songArr.length;i++)
		//			System.out.println(media_AL.get(i));
	}
	
//	   void setSong() {
//		     ArrayList <String> folderPath = new ArrayList<>();
//		     folderPath = Find_file.jFileChooserUtil();
//		      for(int i=0;i<folderPath.size();i++) {
//		         m =  new Media("file:"+folderPath.get(i));   // �뷡�������� �̵�� ���� 
//		         media_AL.add(m);         // media arrayList�� �̵�� ����
//		      }
//		   }
	//
	
	
	
	         

	//�뷡�� ��ġ �ε��� ��ȯ
	int getSongIndex(String songName) {
		for(int i=0;i<songArr.length;i++) {
			if(songArr[i].contains(songName)) {
				return i;
			}
		}
		return -1;
	}
	
	//
	ImageIcon[] setImageIcons(String[] music) {
	    ImageIcon[] music_images = new ImageIcon[100];
	    for(int i=0; i<music.length; i++) {
	       music_images[i]=new ImageIcon("music_images/"+music[i].replace(" ", "")+".jpg");
	    }
	    return music_images;
	 }
	//


	// ���� �̸����� �˻�, �뷡���� ��ȯ
	int[] getSong(String singerName) {
		int cnt=0;
		int[] indexArr = new int[100];
		for(int i=0; i<songArr.length; i++) {
			if(songArr[i].contains(singerName)) {
				indexArr[cnt]=i;
				cnt++;
			}
		}
		return indexArr;
	}



	//	//���� ��� �� �Ͻ�����
	//	void playMusic(Media m1) {
	//
	//		if(playtype==true&&ccc==true) {
	//			player= new MediaPlayer(m1);
	//			t_start();
	//			t.start();
	//			mouseL();
	//
	//		}
	//
	//		if(playtype==true) {
	//			player.play();
	//			playtype=!playtype;
	//		}
	//		else {
	//			player.pause();
	//			ccc=false;
	//			playtype=!playtype;
	//		}
	//
	//	}

	//���� ���/�Ͻ����� ����,����
	void playMusic(Media m1) {


		if(playtype==true&&ccc==true) {
			player= new MediaPlayer(m1);
			t_start();
			t.start();
			mouseL();

		}

		if(playtype==true) {
			player.play();
			playtype=!playtype;
		}
		else {
			player.pause();
			ccc=false;
			playtype=!playtype;
		}

	}



	//////////////////////////
	static void mouseL() {
		s.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {

				t.stop();               
			}

			public void mouseReleased(MouseEvent e) {

				int k = (int)player.getTotalDuration().toSeconds();
				player.seek(Duration.seconds( k*s.getValue()/100));
				t.start();

			}});
	}
	///////////////////////////
	static void t_start() {
	    ImageIcon[] music_images = { new ImageIcon("music_images/������༭����-��.jpg"),new ImageIcon("music_images/����Ҹ��鸮��-��.jpg"),
	               new ImageIcon("music_images/���õ������³ʿ���-��ũ��.jpg"),new ImageIcon("music_images/���帶��-Ȳ�ο�.jpg"),new ImageIcon("music_images/���̹�����-���������μ�.jpg"),
	               };
	    
		t = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {            

				Duration d1 = player.getCurrentTime();
				Duration d2 = player.getTotalDuration();         

				String time1 = String.format("%d:%02d%n", (int)d1.toMinutes(), (int)d1.toSeconds()%60 );
				String time2 = String.format("%d:%02d%n", (int)d2.toMinutes(), (int)d2.toSeconds()%60 );

				l.setText(  time1+ " / " + time2 );

				s.setValue( (int)( 100*(d1.toSeconds()/d2.toSeconds()) ) );                 

				if(((int)d1.toSeconds()==(int)d2.toSeconds())&&(int)d1.toSeconds()!=0) {
					System.out.println("asdsa");
					//�Ҹ��� ������ ���� ����������� ����������� ������ �߰� �� �ڵ� �߰�
					if(btn_status_FlowMusic_B==true) {
						if(btn_status_oneway_B==true) {
							player.stop();
							index++;
							if(index==songArr.length) {
								//							System.out.println(songArr.length);
								//							System.out.println(index);
								index=0;
							}
							player = new MediaPlayer(media_AL.get(index));
							player.play();
							now_play.setText(songArr[index]);
			                   String[] musicdata = musicData(songArr[index]);
			                   music_name.setText(musicdata[0]);
			                      music_singer.setText(musicdata[1]);
			                      play_main.setIcon(music_images[index]);
							
						}
						else {
//							player.stop();
//							player = new MediaPlayer(media_AL.get(index));
//							player.play();
							player.stop();
							player.seek(Duration.seconds(0));
							player.play();
							now_play.setText(songArr[index]);
							 String[] musicdata = musicData(songArr[index]);
			                   music_name.setText(musicdata[0]);
			                      music_singer.setText(musicdata[1]);
			                      play_main.setIcon(music_images[index]);
			                      
						}
					}

					if(btn_status_FlowMusic_B==false) {
						if(btn_status_oneway_B==true) {
							PlayMusicTest ran_p = new PlayMusicTest();   //�������������� ����
							int index_ran=ran_p.ran_indexValue();

							Add_before_song.add(index_ran);
							for(int i=0;i<Add_before_song.size();i++) {
								System.out.println(Add_before_song.get(i)+" ");
							}

							player.stop();
							player = new MediaPlayer(media_AL.get(index_ran));
							player.play();
							now_play.setText(songArr[index_ran]);
							 String[] musicdata = musicData(songArr[index_ran]);
			                   music_name.setText(musicdata[0]);
			                      music_singer.setText(musicdata[1]);
			                      play_main.setIcon(music_images[index_ran]);
						}
						else {
							player.stop();
							//seek�߰��ؾߵǴ��� �ٽ� ����!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
							player.play();
							now_play.setText(songArr[index]);
							 String[] musicdata = musicData(songArr[index]);
			                   music_name.setText(musicdata[0]);
			                      music_singer.setText(musicdata[1]);
			                      play_main.setIcon(music_images[index]);
						}
					}
					//					return;
				}
			}
		});


	}

	//////////////////////////
	//���� �ε��� �� ��ȯ

	int ran_indexValue() {
		int ran=songArr.length;
		//		System.out.println(songArr.length);
		int random=(int)(Math.random()*ran);
		//		System.out.println(random);
		return random;
	}
	//�ߺ������ϱ�!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	///////////////////////////////////


	//���������Լ� ���
	
	///
	
	// �뷡����� ���� �и�   [0]:�뷡����, [1]:����
	   static String[] musicData(String song) {
	      String[] musicdata = song.split("-");
	      return musicdata;
	   }
	
	//



	public static void main(String[] args) {

		JFXPanel panel = new JFXPanel();
		JFrame f = new JFrame("����������");
		
		JButton btn = new JButton("����/�Ͻ�����");
		btn.setBounds(10, 300, 80, 30);

//		JButton btn_next = new JButton(">");
//		btn_next.setBounds(120, 300, 80, 30);
//		f.add(btn_next);

		JButton btn_before = new JButton("<");
		btn_before.setBounds(220, 300, 80, 30);
		f.add(btn_before);

		JButton btn_status_FlowMusic = new JButton("����/����");
		btn_status_FlowMusic.setBounds(310, 300, 80, 30);
		f.add(btn_status_FlowMusic);

		JButton btn_status_oneway = new JButton("��ü/�Ѱ�");   //�ݺ�����  true=������� false=>�Ѱ�ݺ�
		btn_status_oneway.setBounds(400, 300, 80, 30);
		f.add(btn_status_oneway);

		f.add(btn);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		//
		//        JLabel l = new JLabel(); Ŭ����������
		l.setBounds(20,10,350,40);
		l.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(l);    

		//        JSlider s = new JSlider(); Ŭ����������
		s.setBounds(20,60,350,40);     
		f.add(s);    
		//
		f.setSize(500,500);
		f.setVisible(false);
		//////////////////////////////////////////////////////////////
		
		JFrame frame1 = new JFrame();
	      JFrame frame2 = new JFrame();
	      JFrame frame3 = new JFrame();
	      JFrame frame4 = new JFrame();
	      JTextField searchText;
	      
		JButton title;
		JButton find_music;
	      JButton p_list_title;
	      JButton start_music;
	      //JButton stop_music;
	      JButton stop_music_f2;
	      JButton front_music;
	      JButton front_music_f2;
	      JButton back_music;
	      JButton back_music_f2;
	      JButton p_all;
	      JButton p_mylist;
	      JButton pause_music;
	      JButton shuffle_music;
	      JButton replay_music;
	      JButton back_frame;
	    JLabel now_music_play;
//	    JLabel play_main;
	    
		ImageIcon find_music_img = new ImageIcon("image/find_music.png");
		ImageIcon start_music_img = new ImageIcon("image/start.png");
		ImageIcon stop_music_img = new ImageIcon("image/stop.png");
		 ImageIcon front_music_img = new ImageIcon("image/front.png");
		 ImageIcon back_music_img = new ImageIcon("image/back.png");
		 ImageIcon pause_music_img = new ImageIcon("image/pause.png");
		 ImageIcon shuffle_on_music_img = new ImageIcon("image/shuffle_on.png");
		 ImageIcon replay_music_img = new ImageIcon("image/replay.png");
		    ImageIcon back_frame_img = new ImageIcon("image/back_frame.png");
		    ImageIcon shuffle_off_music_img = new ImageIcon("image/shuffle_off.png");
		    ImageIcon once_play_img = new ImageIcon("image/once_play.png");
		    //music_images/���̹�����-���������μ�.jpg
		    //music_images/����Ҹ��鸮��-��.jpg
		    //music_images/������༭����-��.jpg
		    ImageIcon[] music_images = { new ImageIcon("music_images/������༭����-��.jpg"),new ImageIcon("music_images/����Ҹ��鸮��-��.jpg"),
		               new ImageIcon("music_images/���õ������³ʿ���-��ũ��.jpg"),new ImageIcon("music_images/���帶��-Ȳ�ο�.jpg"),new ImageIcon("music_images/���̹�����-���������μ�.jpg"),
		               };
//		    
//		ImageIcon[] music_images = { new ImageIcon("music_images/�������䳻��糯���׶���-�Ź�.jpg"),new ImageIcon("music_images/�״��½�-�¿�.jpg"),
//	            new ImageIcon("music_images/���õ������³ʿ���-��ũ��.jpg"),new ImageIcon("music_images/�����������ֳ���-������.jpg"),new ImageIcon("music_images/���̹�����-���������μ�.jpg"),
//	            new ImageIcon("music_images/�ϼҽ�-���Ͽ�.jpg"),new ImageIcon("music_images/���帶��-Ȳ�ο�.jpg"),new ImageIcon("music_images/������༭����-��.jpg"),
//	            new ImageIcon("music_images/�׳����״�-û��.jpg"),new ImageIcon("music_images/������������־��ٸ�-������.jpg")};

		
		for(int i=0;i<music_images.length;i++) {
	         music_images[i].getImage().getScaledInstance(350, 320, Image.SCALE_DEFAULT);
	      }
	        //@@@@@ ù ��° ȭ��(Main) ������ @@@@@
	         frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         frame1.setLayout(null);
	         
	         // ��ư ����
	         title = new JButton("Media_Player");
	         
//	         title.addActionListener(new ActionButtonHandler1());
	         title.setFont(new Font("Serif",Font.BOLD,25));
	         
	         // ��ư����, ��ư���, ��ư�Ӽ�
	         find_music = new JButton(find_music_img);
	         find_music.setBackground(Color. white);
//	         find_music.addActionListener(new ActionButtonHandler5());
	         
	         // JLabel ����
	         JLabel music_chart_title = new JLabel("Music_Chart");
	         music_chart_title.setFont(new Font("Serif",Font.BOLD,20));
	         
	         // JList ����
	         JList scrollList1 = new JList(songArr);
	         
	         // �г� ����, m_panel(main_panel)
	         JPanel m_panel1 = new JPanel();
	         m_panel1.setLayout(new GridLayout(1,2,10,10));   
	         m_panel1.setBounds(0, 0, 400, 60);
	         JPanel m_panel2 = new JPanel();
	         m_panel2.setBounds(100, 60, 200, 40);
	         JPanel m_panel3 = new JPanel();
	         m_panel3.setLayout(new GridLayout(1,1));
	         m_panel3.setBounds(40, 120, 300, 350);
	         
	         // �г� �߰�
	         m_panel1.add(title);
	         m_panel1.add(find_music);
	         m_panel2.add(music_chart_title);
	         m_panel3.add(new JScrollPane(scrollList1));
	         
	         frame1.add(m_panel1);
	         frame1.add(m_panel2);
	         frame1.add(m_panel3);
	         frame1.setSize(400,600);
	         frame1.setVisible(true);
	         
	         
	         //////////////////////////////�г�2
	         //@@@@@ �� ��° ȭ��(PlayList) ������ @@@@@
	         frame2.setLayout(null);
	         frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         
	         // ���� �ð� ǥ��
	         SimpleDateFormat format1 = new SimpleDateFormat ("HH:mm");   
	         Date time1 = new Date();   
	         String time2 = format1.format(time1);
	         
	         JLabel time = new JLabel(time2);
	         time.setFont(time.getFont().deriveFont(25.0f));
	         time.setHorizontalAlignment(JLabel.CENTER);
	         time.setBounds(0, 0, 110, 60);
	         
	         
//	         now_music_play = new JLabel();
//	         now_music_play.setFont(new Font("Serif",Font.BOLD,15));
	         now_play = new JButton(" ");
	         now_play.setBounds(0, 450, 200, 50);
	         Color b= new Color(220,220,220);
	         now_play.setBackground(b);
//	         now_music_play.setBounds(0, 450, 200, 50);
	         
	         p_list_title = new JButton("������");

	         p_list_title.setFont(new Font("Serif",Font.BOLD,20));
	         JList scrollList2 = new JList(songArr);
	         

	         
	         // ��ư����, ��ư���, ��ư�Ӽ�
	         find_music = new JButton(find_music_img);
	         
	         start_music = new JButton(start_music_img);
//	         start_music.addActionListener(new ActionButtonHandler_sp());
	         start_music.setBounds(100, 503, 200, 60);
	         start_music.setBackground(Color. white);
	         
//	         stop_music_f2 = new JButton(stop_music_img);
//	         stop_music_f2.setBounds(200, 503, 100, 60);
//	         stop_music_f2.setBackground(Color. white);
	        
	         front_music_f2 = new JButton(front_music_img);
	         front_music_f2.setBounds(300, 503, 100, 60);
	         front_music_f2.setBackground(Color. white);
	         
	         back_music_f2 = new JButton(back_music_img);
	         back_music_f2.setBounds(0, 503, 100, 60);
	         back_music_f2.setBackground(Color. white);
	          
	         
	         p_all = new JButton("��");// ��(100)�������� ����ϱ�
	         p_mylist = new JButton("�÷��̸���Ʈ");
	         
	         // �гλ���(list_panel), �г� ����, �г��߰�
	         JPanel l_panel1 = new JPanel();
	         l_panel1.setBounds(110, 0, 280, 60);
	         JPanel l_panel2 = new JPanel();
	         l_panel2.setBounds(0, 60, 110, 80);
	         JPanel l_panel3 = new JPanel();
	         l_panel3.setBounds(110, 70, 280, 300);
	         
	         l_panel1.setLayout(new GridLayout(1,3));     
	         l_panel2.setLayout(new GridLayout(2,1));
	         l_panel3.setLayout(new GridLayout(1,1));         
	         
	         
	         l_panel1.add(p_list_title);
	         l_panel1.add(find_music);
	         
	         l_panel2.add(p_all);
	         l_panel2.add(p_mylist);
	         
	         l_panel3.add(new JScrollPane(scrollList2));
	         
	         frame2.add(start_music);
//	         frame2.add(stop_music_f2);
	         frame2.add(front_music_f2);
	         frame2.add(back_music_f2);
	         frame2.add(time);
//	         frame2.add(now_music_play);
	         frame2.add(now_play);
	         frame2.add(l_panel1);
	         frame2.add(l_panel2);
	         frame2.add(l_panel3);
	         frame2.setSize(400,600);
//	       frame2.setVisible(true);
		
		////////////////
	         frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         frame3.setLayout(null);      
	         
	         // �� ����
	         music_name = new JLabel("�뷡 ����");
	         music_name.setFont(new Font("Serif",Font.BOLD,20));
	         music_name.setHorizontalAlignment(JLabel.CENTER);
	         
	         music_singer = new JLabel("���� �̸�");
	         music_singer.setFont(new Font("Serif",Font.BOLD,10));
	         music_singer.setHorizontalAlignment(JLabel.CENTER);
	         
	         
	         play_main=new JLabel();
	         play_main.setIcon(music_images[0]);
	         play_main.setBounds(20, 50, 350, 320);
	         
//	         JLabel play_lyrics = new JLabel("�׸����� �� ��" + " " + "�������� �� ��");   // �뷡����
//	         play_lyrics.setBounds(100, 370, 200, 50);
	         
	         //����
	         sound_controler.setPaintLabels(true);
	         sound_controler.setPaintTicks(true);
	         sound_controler.setPaintTrack(true);
	         sound_controler.setMajorTickSpacing(50);   // ū ����
	         sound_controler.setMinorTickSpacing(10);   // ���� ����
	         sound_controler.setBounds(310, 380, 50, 60);
	         frame3.add(sound_controler);

	         
	         s.setBounds(100,450,200,50);     
	 		 frame3.add(s);  
	 		 l.setBounds(160, 440, 70, 10);
	 		 frame3.add(l);
	         
	         // ��ư����, ��ư���, ��ư�Ӽ�
	         pause_music = new JButton(pause_music_img);
	         pause_music.setBounds(100, 503, 200, 60);
	         pause_music.setBackground(Color. white);
	         
	         //stop_music = new JButton(stop_music_img);
	        // stop_music.setBounds(200, 503, 100, 60);
	         //stop_music.setBackground(Color. white);
	        
	         front_music = new JButton(front_music_img);
	         front_music.setBounds(300, 503, 100, 60);
	         front_music.setBackground(Color. white);
	         
	         
	         back_music = new JButton(back_music_img);
	         back_music.setBounds(0, 503, 100, 60);
	         back_music.setBackground(Color. white);
	         
	         shuffle_music = new JButton(shuffle_on_music_img);
	         shuffle_music.setBounds(310, 450, 40, 40);
	         shuffle_music.setBackground(Color. white);
	         
	         replay_music = new JButton(replay_music_img);
	         replay_music.setBounds(50, 450, 40, 40);
	         replay_music.setBackground(Color. white);
	         
	         back_frame = new JButton(back_frame_img);
//	         back_frame.addActionListener(new ActionButtonHandler3());
	         back_frame.setBounds(0, 0, 40, 40);
	         back_frame.setBackground(Color. white);
	         
	         
	         // �гλ���(play_panel), �гμ���, �г��߰�
	         JPanel p_panel1 = new JPanel();
	         JPanel p_panel2 = new JPanel();
	         JPanel p_panel3 = new JPanel();
	         
	         p_panel1.setLayout(new GridLayout(2,1));
	         p_panel1.setBounds(0, 0, 400, 50);
	         p_panel2.setLayout(null);
	         p_panel3.setLayout(null); 
	         
	         p_panel1.add(music_name);
	         p_panel1.add(music_singer);
	         
	         frame3.add(back_music);
	         frame3.add(pause_music);
	         //frame3.add(stop_music);
	         frame3.add(front_music);
	         
	         frame3.add(back_frame);
	         frame3.add(p_panel1);
	         frame3.add(play_main);
//	         frame3.add(play_lyrics);
	         frame3.add(shuffle_music);            
	         frame3.add(replay_music);
//	       frame3.add(p_panel4);
	         frame3.setSize(400,600);
	         frame3.setVisible(false);
		
		////////////////////////////////////////////////
	         
	         frame4.setDefaultCloseOperation(EXIT_ON_CLOSE);
	         frame4.setLayout(null);
	         
	         SimpleDateFormat format2 = new SimpleDateFormat ("HH:mm");   
	        Date time3 = new Date();   
	        String time4 = format2.format(time3);
	         
	         JLabel time5 = new JLabel(time4);
	         time5.setFont(time.getFont().deriveFont(25.0f));
	         time5.setHorizontalAlignment(JLabel.CENTER);
	         time5.setBounds(0, 0, 110, 60);
	         
	       
	 
	         JLabel searchmusic =new JLabel("�˻�� �Է����ּ���.");
	         searchmusic.setFont(new Font("Serif",Font.BOLD,15));
	         searchmusic.setBounds(100,100,200,30);
	        
	         searchText=new JTextField(20);
	         searchText.setBounds(60,160,220,30);
	         
	   
	         JButton p_list_title2 = new JButton("������");
//	         p_list_title2.addActionListener(new ActionButtonHandler1());
	         p_list_title2.setFont(new Font("Serif",Font.BOLD,20));
	         JList searchlist=new JList();
	         
	         JButton title2 = new JButton("Main");
//	         title2.addActionListener(new ActionButtonHandler2());
	         title2.setFont(new Font("Serif",Font.BOLD,20));
	         
	         JPanel sl_panel =new JPanel(); // �˻����â
	         sl_panel.setBounds(60,200,280,300);
	       
	         
	         JButton searchButton=new JButton("�˻�");
	         searchButton.setFont(new Font("Serif",Font.BOLD,8));
	         searchButton.setBounds(290,160,50,30);

	         searchButton.addActionListener(new ActionListener() {
	              
	               @Override
	                public void actionPerformed(ActionEvent e) {
	                   String musicText= searchText.getText();
	                   searchButton.setText("�˻�");
	                   if(musicText.length()==0 ) {
	                      JOptionPane.showMessageDialog(null, "�˻�� �Է����� �ʾҽ��ϴ�. �ٽ� �Է����ּ���. ",
	                            musicText, JOptionPane.DEFAULT_OPTION);
	                      return;
	                      }
	                   //int count_list =0;
	                   int cnt = -1;
	                   int cntshow=0;
	                   for(int i=0;i<songArr.length;i++) {
	                     if((songArr[i]).contains(musicText)) {
	                        if(cntshow<=0) {
	                        JOptionPane.showMessageDialog(null, "�뷡�� ã�ҽ��ϴ�. ");
	                        cntshow++;
	                        }
	                        
	                        //demoList.clear();
	                        demoList.add(0, songArr[i]);
	                        //count_list++;
	                        searchText.setText("");
	                        cnt ++;
	                        System.out.println(songArr[i]);
	                        
	                     }   
	                   
	                   }
	                     if(cnt < 0) {
	                        
	                        demoList.clear();
	                        searchText.setText("");
	                        JOptionPane.showMessageDialog(null, "�˻��� �뷡�� �����ϴ�.");
	                        
	                     }
	                }   
	                  
	            });

	         JPanel s_panel = new JPanel();  // �ð�, ������, main ��ư
	         s_panel.setBounds(110, 0, 280, 60);
	         
	         s_panel.setLayout(new GridLayout(1,3));
	         sl_panel.setLayout(new GridLayout(1,1));
	         
	         s_panel.add(p_list_title2);
	         s_panel.add(title2);
	         sl_panel.add(new JScrollPane(searchlist1));
	   
	         
	         frame4.add(time5);
	         frame4.add(s_panel);
	         frame4.add(sl_panel);
	         frame4.add(searchmusic);
	         frame4.add(searchText);
	         frame4.add(searchButton);
	         frame4.setSize(400,600);
	         frame4.setVisible(false);
	         
	         /////////@@@ �� ��° ȭ��(Search) ������///////////////////////////////////////////////////////////////////////////////////// 
	   
		
		
		
		
		
		
		//////////////////////////////////////////////////////////////////
		
		
		
		PlayMusicTest pt =  new PlayMusicTest();


		pt.setSong(pt.songArr);



		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				index = pt.getSongIndex("����Ҹ�");//"���帶��"��� �κ��� ���������� �ٲ�� �ؾ���//�뷡 Ŭ�� �Ǿ��� �� �� �뷡�� ����ǰ�
				System.out.println(media_AL.get(index));
				pt.playMusic(media_AL.get(index));

			}
		});





//		btn_next.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				//				btn_next_B=!btn_next_B;
//
//				if(btn_status_FlowMusic_B==true) {     //�����϶�
//					player.stop();
//					index++;
//					if(index==songArr.length) {
//						//						System.out.println(songArr.length);
//						//						System.out.println(index);
//						index=0;
//					}
//					player = new MediaPlayer(media_AL.get(index));
//					player.play();
//				}
//				if(btn_status_FlowMusic_B==false) {
//					int index_ran=pt.ran_indexValue();
//					//					System.out.println(index_ran+"??");
//					Add_before_song.add(index_ran);   //����������� ������ �����س�������
////					for(int i=1;i<Add_before_song.size();i++) {
////						System.out.print(Add_before_song.get(i)+"!!! ");
////					}
//					player.stop();
//					player = new MediaPlayer(media_AL.get(index_ran));
//					player.play();
//				}
//
//			}
//		});

		btn_before.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(btn_status_FlowMusic_B==true) {
					player.stop();
					index--;
					if(index==-1) {
						System.out.println(index);
						index=songArr.length-1;
					}
					player = new MediaPlayer(media_AL.get(index));
					player.play();

				}
				else {
					try {
						Add_before_song.remove(Add_before_song.size()-1);
						player.stop();
						player = new MediaPlayer(media_AL.get(Add_before_song.size()-1));
						player.play();
					}catch (IndexOutOfBoundsException r) {
						int index_ran=pt.ran_indexValue();
						player.stop();
						player = new MediaPlayer(media_AL.get(index_ran));
						player.play();
					}
				}
			}
		});

		btn_status_FlowMusic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//				System.out.println(btn_status_FlowMusic_B);
				btn_status_FlowMusic_B=!btn_status_FlowMusic_B;
				if(btn_status_FlowMusic_B==false) {
					Add_before_song.add(index);
					System.out.println(index+"first");
				}
				if(btn_status_FlowMusic_B==true) {
					Add_before_song.clear();
				}

			}
		});

		btn_status_oneway.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btn_status_oneway_B=!btn_status_oneway_B;

			}
		});
		
		
		
		////////////////////////////////////////////
		
		title.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
		         frame2.setVisible(true);
		         frame3.setVisible(false);
		         frame4.setVisible(false);
				
			}
		});
		
		find_music.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		          frame1.setVisible(false);
		            frame2.setVisible(false);
		            frame3.setVisible(false);
		            frame4.setVisible(true);
				
			}
		});
		
		 p_list_title.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		         frame1.setVisible(true);
		         frame2.setVisible(false);
		         frame3.setVisible(false);
		         frame4.setVisible(false);
				
			}
		});
		 find_music.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	            frame1.setVisible(false);
	            frame2.setVisible(false);
	            frame3.setVisible(false);
	            frame4.setVisible(true);
	            demoList.clear(); //�˻��ϰ� �ٽ� �������� �˻����â �����ϰ�.
			}
		});
		 
		 start_music.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 if(player==null) {
				 index = pt.getSongIndex("����Ҹ�");//"���帶��"��� �κ��� ���������� �ٲ�� �ؾ���//�뷡 Ŭ�� �Ǿ��� �� �� �뷡�� ����ǰ�
					System.out.println(media_AL.get(index));
					pt.playMusic(media_AL.get(index));
					now_play.setText(songArr[index]);
				 }
				 else {
					 pt.playMusic(media_AL.get(index));
				 }
//				 a1=true;
//                 indext_test_copy=index_test;
					
				// TODO Auto-generated method stub
		         JButton btn=(JButton) e.getSource();   
		            if(btn.getIcon().equals(start_music_img)) {
		               btn.setIcon(pause_music_img);
		               start_music.setIcon(pause_music_img);
		               pause_music.setIcon(pause_music_img);  //���ذ��
		            }
		            else { 
		               btn.setIcon(start_music_img);
		               start_music.setIcon(start_music_img);
		               pause_music.setIcon(start_music_img);
		            }
				
			}
		});
		 
		 
		 //!!����
		 scrollList2.addListSelectionListener(new ListSelectionListener() {
			 
        	 ArrayList<String> musiclist = new ArrayList<String>();
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				adjust = e.getValueIsAdjusting();
                if(!adjust) {
                	JList list = (JList)e.getSource();
                    String str = (String)list.getSelectedValue();
                    int index_test = list.getSelectedIndex();
                    
                    String[] musicdata = musicData(str);

//	                   now_music_play.setText(""+str);
                    now_play.setText(""+str);
	                   str = str.replaceAll(" ", "");
	                   play_main.setIcon(music_images[index_test]);//�̵�������
	                   musiclist.add(str);
	                   

	                   music_name.setText(musicdata[0]);
	                      music_singer.setText(musicdata[1]);
	                      
	                   pause_music.setIcon(pause_music_img);
	                   start_music.setIcon(pause_music_img);
	                   frame1.setVisible(false);
	                   frame2.setVisible(false);
	                   frame3.setVisible(true);
	                   
	                   list_bool=true;
	                   index=index_test;
	                   if(player!=null) {
	                	   System.out.println("NEED");
	                	   
	                   if(start_music.getIcon()==start_music_img) {
	                   pt.playMusic(media_AL.get(index));
	                   player.stop();
	                   player = new MediaPlayer(media_AL.get(index_test));
						player.play();     //���������� �÷��� �ѹ� ��Ų�Ŷ� �Ȱ��� ������ֱ�
	                   }
	                   else {
	                	     player.stop();
	  	                   player = new MediaPlayer(media_AL.get(index_test));
	  						player.play();     //���������� �÷��� �ѹ� ��Ų�Ŷ� �Ȱ��� ������ֱ�
	                   }
	                   
	                   }
	                   else {
	                	   pt.playMusic(media_AL.get(index));
	                   }
	                  
	                   
	                   System.out.println(index_test+"ASD");
	                }
			}
		});
		 
		 pause_music.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pt.playMusic(media_AL.get(index));
				// TODO Auto-generated method stub
		         JButton btn=(JButton) e.getSource();   
		            if(btn.getIcon().equals(start_music_img)) {
		               btn.setIcon(pause_music_img);
		               start_music.setIcon(pause_music_img);
		               pause_music.setIcon(pause_music_img);
		            }
		            else { 
		               btn.setIcon(start_music_img);
		               start_music.setIcon(start_music_img);
		               pause_music.setIcon(start_music_img);
		            } 
				
			}
		});
		 
		 shuffle_music.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btn_status_FlowMusic_B=!btn_status_FlowMusic_B;
				System.out.println(btn_status_FlowMusic_B);
				if(btn_status_FlowMusic_B==false) {
					Add_before_song.add(index);
					System.out.println(index+"first");
				}
				if(btn_status_FlowMusic_B==true) {
					Add_before_song.clear();
				}
				// TODO Auto-generated method stub
		        JButton btn=(JButton) e.getSource();   
	            if(btn.getIcon().equals(shuffle_on_music_img)) {
	               btn.setIcon(shuffle_off_music_img);             
	            }
	            else { 
	               btn.setIcon(shuffle_on_music_img);
	            }
			}
		});
		 
		 replay_music.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

					btn_status_oneway_B=!btn_status_oneway_B;

				// TODO Auto-generated method stub
		         JButton btn=(JButton) e.getSource();   
		            if(btn.getIcon().equals(replay_music_img)) {
		               btn.setIcon(once_play_img);
		            }
		            else { 
		               btn.setIcon(replay_music_img);
		            }
				
			}
		});
		 
		 back_frame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  frame1.setVisible(false);
			         frame2.setVisible(true);
			         frame3.setVisible(false);
			         frame4.setVisible(false);
				
			}
		});
		 
		 p_list_title2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		         frame1.setVisible(false);
		         frame2.setVisible(true);
		         frame3.setVisible(false);
		         frame4.setVisible(false);
			}
		});
		 title2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		         frame1.setVisible(true);
		         frame2.setVisible(false);
		         frame3.setVisible(false);
		         frame4.setVisible(false);
			}
		});
		 
		 front_music.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(btn_status_FlowMusic_B==true) {     //�����϶�
					player.stop();
					index++;
					if(index==songArr.length) {
						//						System.out.println(songArr.length);
						//						System.out.println(index);
						index=0;
					}
					player = new MediaPlayer(media_AL.get(index));
					player.play();
					now_play.setText(songArr[index]);
					
	                   String[] musicdata = musicData(songArr[index]);
	                   music_name.setText(musicdata[0]);
	                      music_singer.setText(musicdata[1]);
	                      play_main.setIcon(music_images[index]);//�̵�������
	                      
				}
				if(btn_status_FlowMusic_B==false) {
					int index_ran=pt.ran_indexValue();
					//					System.out.println(index_ran+"??");
					Add_before_song.add(index_ran);   //����������� ������ �����س�������

					player.stop();
					player = new MediaPlayer(media_AL.get(index_ran));
					player.play();
					System.out.print((Add_before_song.get(i))+"!!! ");
					i++;
					now_play.setText(songArr[index_ran]);
					
	                   String[] musicdata = musicData(songArr[index_ran]);
	                   music_name.setText(musicdata[0]);
	                      music_singer.setText(musicdata[1]);
	                      play_main.setIcon(music_images[index_ran]);//�̵�������
				}
				
			}
		});
		 
		 back_music.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btn_status_FlowMusic_B==true) {
					player.stop();
					index--;
					if(index==-1) {
						System.out.println(index);
						index=songArr.length-1;
					}
					player = new MediaPlayer(media_AL.get(index));
					player.play();
					now_play.setText(songArr[index]);
					
	                   String[] musicdata = musicData(songArr[index]);
	                   music_name.setText(musicdata[0]);
	                      music_singer.setText(musicdata[1]);
	                      play_main.setIcon(music_images[index]);//�̵�������
				}
				else {
					try {
						System.out.println("1111111111111");
						player.stop();
						System.out.println("dd"+(Add_before_song.size()-2));
						System.out.println(Add_before_song.get(Add_before_song.size()-2));
//						Add_before_song.get(Add_before_song.size()-2)
						player = new MediaPlayer(media_AL.get(Add_before_song.get(Add_before_song.size()-2)));
						player.play();
						Add_before_song.remove((Add_before_song.size()-1));
						index=(Add_before_song.get(Add_before_song.size()-1));
						now_play.setText(songArr[index]);
		                   String[] musicdata = musicData(songArr[index]);
		                   music_name.setText(musicdata[0]);
		                      music_singer.setText(musicdata[1]);
		                      play_main.setIcon(music_images[index]);//�̵�������
					}
					catch (IndexOutOfBoundsException r) {
						System.out.println("22222222222");
						int index_ran=pt.ran_indexValue();
						player.stop();
						player = new MediaPlayer(media_AL.get(index_ran));
						player.play();
						now_play.setText(songArr[index_ran]);
		                   String[] musicdata = musicData(songArr[index_ran]);
		                   music_name.setText(musicdata[0]);
		                      music_singer.setText(musicdata[1]);
		                      play_main.setIcon(music_images[index_ran]);//�̵�������
					}
				}
			}
		});
		 
		 
		 //list_bool ��ũ�Ѹ���Ʈ�� Ŭ�� ���� ��
		 front_music_f2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(btn_status_FlowMusic_B==true) {     //�����϶�
					if(list_bool==true) {
					player.stop();
					index++;
					if(index==songArr.length) {
						//						System.out.println(songArr.length);
						//						System.out.println(index);
						index=0;
					}
					player = new MediaPlayer(media_AL.get(index));
					player.play();
					now_play.setText(songArr[index]);
	                   String[] musicdata = musicData(songArr[index]);
	                   music_name.setText(musicdata[0]);
	                      music_singer.setText(musicdata[1]);
	                      play_main.setIcon(music_images[index]);//�̵�������
					}
					else {
						player.stop();
						index++;
						if(index==songArr.length) {
							//						System.out.println(songArr.length);
							//						System.out.println(index);
							index=0;
						}
						player = new MediaPlayer(media_AL.get(index));
						player.play();
						now_play.setText(songArr[index]);
		                   String[] musicdata = musicData(songArr[index]);
		                   music_name.setText(musicdata[0]);
		                      music_singer.setText(musicdata[1]);
		                      play_main.setIcon(music_images[index]);//�̵�������
						
					}
				}
				if(btn_status_FlowMusic_B==false) {
					int index_ran=pt.ran_indexValue();
					//					System.out.println(index_ran+"??");
					Add_before_song.add(index_ran);   //����������� ������ �����س�������
					for(int i=0;i<Add_before_song.size();i++) {
						System.out.print(Add_before_song.get(i)+"!!! ");
					}
					player.stop();
					player = new MediaPlayer(media_AL.get(index_ran));
					player.play();
					now_play.setText(songArr[index_ran]);
	                   String[] musicdata = musicData(songArr[index_ran]);
	                   music_name.setText(musicdata[0]);
	                      music_singer.setText(musicdata[1]);
	                      play_main.setIcon(music_images[index_ran]);
				}
				
			}
		});
		 
		 
		 back_music_f2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btn_status_FlowMusic_B==true) {
					player.stop();
					index--;
					if(index==-1) {
						System.out.println(index);
						index=songArr.length-1;
					}
					player = new MediaPlayer(media_AL.get(index));
					player.play();
					now_play.setText(songArr[index]);
	                   String[] musicdata = musicData(songArr[index]);
	                   music_name.setText(musicdata[0]);
	                      music_singer.setText(musicdata[1]);
	                      play_main.setIcon(music_images[index]);

				}
				else {
					try {
						Add_before_song.remove(Add_before_song.size()-1);
						player.stop();
						player = new MediaPlayer(media_AL.get(Add_before_song.size()-1));
						player.play();
						index=Add_before_song.size()-1;
						now_play.setText(songArr[index]);
		                   String[] musicdata = musicData(songArr[index]);
		                   music_name.setText(musicdata[0]);
		                      music_singer.setText(musicdata[1]);
		                      play_main.setIcon(music_images[index]);//�̵�������
					}catch (IndexOutOfBoundsException r) {
						int index_ran=pt.ran_indexValue();
						player.stop();
						player = new MediaPlayer(media_AL.get(index_ran));
						player.play();
						now_play.setText(songArr[index_ran]);
		                   String[] musicdata = musicData(songArr[index_ran]);
		                   music_name.setText(musicdata[0]);
		                      music_singer.setText(musicdata[1]);
		                      play_main.setIcon(music_images[index_ran]);//�̵�������
					}
				}
			}
		});
		 
		 
//		 stop_music.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(pause_music.getIcon()!=start_music_img){
//				player.seek(Duration.seconds(0));
//				pt.playMusic(media_AL.get(index));
//				pause_music.setIcon(start_music_img);
//				}
//			}
//		});
		 
		 
//		 stop_music_f2.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(list_bool==true) {
//					start_music.setIcon(start_music_img);
//				player.seek(Duration.seconds(0));
//				pt.playMusic(media_AL.get(index));
//				}
//				else if(start_music.getIcon()!=start_music_img){
//					start_music.setIcon(start_music_img);
//					player.seek(Duration.seconds(0));
//					pt.playMusic(media_AL.get(index));
//				}
//					
//			}
//		});
		 
		 now_play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  frame1.setVisible(false);
			         frame2.setVisible(false);
			         frame3.setVisible(true);
			         frame4.setVisible(false);
				
			}
		});
		 
		 sound_controler.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				player.setVolume((double)sound_controler.getValue()/180);
				
			}
		});
		 
		 searchlist1.addListSelectionListener(new ListSelectionListener() {
			 ArrayList<String> musiclist = new ArrayList<String>();
				@Override
				public void valueChanged(ListSelectionEvent e) {
					
					adjust = e.getValueIsAdjusting();
	                if(!adjust) {
	                	JList list = (JList)e.getSource();
	                    String str = (String)list.getSelectedValue();
	                    int index_test = list.getSelectedIndex();
	                    
	                    String[] musicdata = musicData(str);

//		                   now_music_play.setText(""+str);
	                    	now_play.setText(""+str);
		                   str = str.replaceAll(" ", "");
		                   play_main.setIcon(music_images[index_test]);//�̵�������
		                   musiclist.add(str);
		                   

		                   music_name.setText(musicdata[0]);
		                      music_singer.setText(musicdata[1]);
		                      
		                   pause_music.setIcon(pause_music_img);
		                   start_music.setIcon(pause_music_img);
		                   frame1.setVisible(false);
		                   frame2.setVisible(false);
		                   frame3.setVisible(true);
		                   
		                   list_bool=true;
		                   index=index_test;
		                   if(player!=null) {
		                	   System.out.println("NEED");
		                   if(start_music.getIcon()==start_music_img) {
		                   pt.playMusic(media_AL.get(index));
		                   player.stop();
		                   player = new MediaPlayer(media_AL.get(index_test));
							player.play();     //���������� �÷��� �ѹ� ��Ų�Ŷ� �Ȱ��� ������ֱ�
		                   }
		                   else {
		                	     player.stop();
		  	                   player = new MediaPlayer(media_AL.get(index_test));
		  						player.play();     //���������� �÷��� �ѹ� ��Ų�Ŷ� �Ȱ��� ������ֱ�
		                   }
		                   
		                   }
		                   else {
		                	   pt.playMusic(media_AL.get(index));
		                   }
		                  
		                   
		                   System.out.println(index_test+"ASD");
		                }
				}
			});
		 
		 
		 
		 
//		 scrollList2.addListSelectionListener(new ListSelectionListener() {
//			 
//        	 ArrayList<String> musiclist = new ArrayList<String>();
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				
//				adjust = e.getValueIsAdjusting();
//                if(!adjust) {
//                	JList list = (JList)e.getSource();
//                    String str = (String)list.getSelectedValue();
//                    int index_test = list.getSelectedIndex();
//                    
//                    String[] musicdata = musicData(str);
//
////	                   now_music_play.setText(""+str);
//                    now_play.setText(""+str);
//	                   str = str.replaceAll(" ", "");
//	                   play_main.setIcon(music_images[index_test]);//�̵�������
//	                   musiclist.add(str);
//	                   
//
//	                   music_name.setText(musicdata[0]);
//	                      music_singer.setText(musicdata[1]);
//	                      
//	                   pause_music.setIcon(pause_music_img);
//	                   frame1.setVisible(false);
//	                   frame2.setVisible(false);
//	                   frame3.setVisible(true);
//	                   
//	                   list_bool=true;
//	                   index=index_test;
//	                   if(player!=null) {
//	                	   System.out.println("NEED");
//	                	   
//	                   if(start_music.getIcon()==start_music_img) {
//	                   pt.playMusic(media_AL.get(index));
//	                   player.stop();
//	                   player = new MediaPlayer(media_AL.get(index_test));
//						player.play();     //���������� �÷��� �ѹ� ��Ų�Ŷ� �Ȱ��� ������ֱ�
//	                   }
//	                   else {
//	                	     player.stop();
//	  	                   player = new MediaPlayer(media_AL.get(index_test));
//	  						player.play();     //���������� �÷��� �ѹ� ��Ų�Ŷ� �Ȱ��� ������ֱ�
//	                   }
//	                   
//	                   }
//	                   else {
//	                	   pt.playMusic(media_AL.get(index));
//	                   }
//	                  
//	                   
//	                   System.out.println(index_test+"ASD");
//	                }
//			}
//		});
	}

}