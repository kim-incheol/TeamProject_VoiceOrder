package application;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import application.PlayMusicTest;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;



public class Media_test5 extends JFrame{
   // ������ ����
   JFrame frame1 = new JFrame();
      JFrame frame2 = new JFrame();
      JFrame frame3 = new JFrame();
      JFrame frame4 = new JFrame();
      
      private JTextField searchText;
      
      // ��ư ����
      JButton title;
      JButton p_list_title;
      JButton find_music;
    JButton start_music;
    JButton pause_music;
    JButton stop_music;
    JButton front_music;
    JButton back_music;
    JButton p_all;
    JButton p_mylist;
    
    JButton shuffle_music;
    JButton replay_music;
    JButton back_frame;
    
    // �󺧻���
    JLabel now_music_play;
    JLabel play_main;
    
    
    // �̹��� ����
    ImageIcon find_music_img = new ImageIcon("image/find_music.png");
    ImageIcon play_main_img = new ImageIcon(new ImageIcon("image/test.jpg").getImage().getScaledInstance(350, 320, Image.SCALE_DEFAULT));
    ImageIcon start_music_img = new ImageIcon("image/start.png");
    ImageIcon stop_music_img = new ImageIcon("image/stop.png");
    ImageIcon front_music_img = new ImageIcon("image/front.png");
    ImageIcon back_music_img = new ImageIcon("image/back.png");
    ImageIcon shuffle_on_music_img = new ImageIcon("image/shuffle_on.png");
    ImageIcon shuffle_off_music_img = new ImageIcon("image/shuffle_off.png");
    ImageIcon replay_music_img = new ImageIcon("image/replay.png");
    ImageIcon back_frame_img = new ImageIcon("image/back_frame.png");
    ImageIcon once_play_img = new ImageIcon("image/once_play.png");
    ImageIcon pause_music_img = new ImageIcon("image/pause.png");
    
    
    String[] songArr = {"�������� �� ��� ���� �׶���-�Ź�","�״��� ��-�¿�","���õ� ������ �ʿ���-��ũ��","�� ���� ���� �ֳ���-������","���� ������-���������μ�","�ϼҽ�-���Ͽ�",
            "���帶��-Ȳ�ο�","������༭ ����-��","�� ���� �״�-û��","����� ������ �־��ٸ�-������","ICY-ITZY","2002-AnneMarie","���� ����� �����-10cm","����-���ٴϿ�",
            "�����ϰ� ���ؼ� ��-�質��","�λ�-��θ���","Speechless-Naomi Scott","�����Ƶ� ������-���","����� �ľ��ٰ� ���ص� ��-�յ���Ű��","���� �͵��� ���� ��-��ź�ҳ��",
            "Snapping-û��","bad guy-Billie Eilish","Another Day-�յ���Ű����ġ","We don't talk together-������","UN Village-����","I HOPE-���ٴϿ�",
            "Color-���ٴϿ�","�õ� �ɿ� ���� �ֵ�-������","Horizon-���ٴϿ�","����� ������ �츮 �������-þ","BAND-â��(ChANGMO),HashSwan,ASHISLAND,��ȿ��","�ʿ��� ���ߴ� �� ������ ����-�ٺ�ġ",
            "Intro-���ٴϿ�","Senorita-Camila Cabello,Shawn Mendes","�ʸ� �ʸ� �ʸ�-�����","�� �Ⱥ�-�̿�","�� ������ ������-����","What a life-����&����","Love Shot-EXO",
            "����-�⸮����","���-�¿�","�׶��� ���Ҿ�-���̽�","�뷡�濡��-�����","�־� ����ϰ�-����&����","��� ��, ��� ����-��Ŵ","�����ϴ� ���ε��� ����-�ܳ���","FANCY-TWICE(Ʈ���̽�)","BOOM-NCT DREAM","�θ��� ��-����&����",
            "Tempo-EXO","Goodbye-��ȿ��","�ʸ� ����-��Ŵ","Paris In The Rain-Lauv","��Ƽ����-�⸮����","���-�������ƽ�","A Whole New World-Mena Massoud, Naomi Scott","����-��ź�ҳ��",
            "�޶�޶�-ITZY","�ҿ���-��ź�ҳ��","IDOL-��ź�ҳ��","���� ��-�����ī��","���-â��(ChANGMO),HashSwan,ASHISLAND,��ȿ��,Leellamarz,The Quiett","����, ��- �����������","Make it Right-��ź�ҳ��",
            "����� �� ����-����","��ž��-���ö���","Dionysus-��ź�ҳ��","U GOT IT-����","���� 12��-û��","�� Call Me-����","�����-����ģ��","���� �԰� ����-���","���� �� �ܷο� ������-�質��",
            "Believer-Imagine Dragons","�����귯-�������ƽ�","Way Back Home-��","��-��Ŵ","������-���座��","Stay Up-����","��-����&����","���� ����-������","�ѷ��ڽ���-����&����","�̺��Ϸ� ���� ��-���Ѻ�",
            "Kill This Love-BLACKPINK","��������-�⸮����","��-����,����","����� �� �����-NCTDREAM","�̻��̻�-ũ���Ľ�","STRONGER-NCT DREAM","����� �� �˾�-��Ŵ","UhOh-(����)���̵�","119-NCT DREAM","�ȳ�-����","������ ��� �뷡-���̽�(Kassy)",
            "�� ���� ����-�����������","Best Friend-NCT DREAM","Betcha-����","������-�����(BewhY)","180��-��","comethru-Jeremy Zucker"};
    

    
    ImageIcon[] music_images = { new ImageIcon("music_images/�������䳻��糯���׶���-�Ź�.jpg"),new ImageIcon("music_images/�״��½�-�¿�.jpg"),
            new ImageIcon("music_images/���õ������³ʿ���-��ũ��.jpg"),new ImageIcon("music_images/�����������ֳ���-������.jpg"),new ImageIcon("music_images/���̹�����-���������μ�.jpg"),
            new ImageIcon("music_images/�ϼҽ�-���Ͽ�.jpg"),new ImageIcon("music_images/���帶��-Ȳ�ο�.jpg"),new ImageIcon("music_images/������༭����-��.jpg"),
            new ImageIcon("music_images/�׳����״�-û��.jpg"),new ImageIcon("music_images/������������־��ٸ�-������.jpg")};

	
	

   
   Media_test5(){

	   
	   
      for(int i=0;i<music_images.length;i++) {
         music_images[i].getImage().getScaledInstance(350, 320, Image.SCALE_DEFAULT);
      }
        //@@@@@ ù ��° ȭ��(Main) ������ @@@@@
         frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame1.setLayout(null);
         
         // ��ư ����
         title = new JButton("Media_Player");
         
         title.addActionListener(new ActionButtonHandler1());
         title.setFont(new Font("Serif",Font.BOLD,25));
         
         // ��ư����, ��ư���, ��ư�Ӽ�
         find_music = new JButton(find_music_img);
         find_music.setBackground(Color. white);
         find_music.addActionListener(new ActionButtonHandler5());
         
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
         //@@@@@ ù ��° ȭ��(Main) ������ @@@@@
         
        
         
         
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
         
         now_music_play = new JLabel();
         now_music_play.setFont(new Font("Serif",Font.BOLD,15));
         now_music_play.setBounds(0, 450, 200, 50);
         
         p_list_title = new JButton("������");
         p_list_title.addActionListener(new ActionButtonHandler2());
         p_list_title.setFont(new Font("Serif",Font.BOLD,20));
         JList scrollList2 = new JList(songArr);
         scrollList2.addListSelectionListener(new JListHandler2(now_music_play));
         
         // ��ư����, ��ư���, ��ư�Ӽ�
         find_music = new JButton(find_music_img);
         find_music.addActionListener(new ActionButtonHandler5());
         
         start_music = new JButton(start_music_img);
         start_music.addActionListener(new ActionButtonHandler_sp());
         start_music.setBounds(100, 503, 100, 60);
         start_music.setBackground(Color. white);
         
         stop_music = new JButton(stop_music_img);
         stop_music.setBounds(200, 503, 100, 60);
         stop_music.setBackground(Color. white);
        
         front_music = new JButton(front_music_img);
         front_music.setBounds(300, 503, 100, 60);
         front_music.setBackground(Color. white);
         
         back_music = new JButton(back_music_img);
         back_music.setBounds(0, 503, 100, 60);
         back_music.setBackground(Color. white);
          
         
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
         frame2.add(stop_music);
         frame2.add(front_music);
         frame2.add(back_music);
         frame2.add(time);
         frame2.add(now_music_play);
         frame2.add(l_panel1);
         frame2.add(l_panel2);
         frame2.add(l_panel3);
         frame2.setSize(400,600);
//       frame2.setVisible(true);
         //@@@@@ �� ��° ȭ��(PlayList) ������ @@@@@
         
         
         
         //@@@@@ �� ��° ȭ��(Play) ������ @@@@@ 
         frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame3.setLayout(null);      
         
         // �� ����
         JLabel music_name = new JLabel("�뷡 ����");
         music_name.setFont(new Font("Serif",Font.BOLD,20));
         music_name.setHorizontalAlignment(JLabel.CENTER);
         
         JLabel music_singer = new JLabel("���� �̸�");
         music_singer.setFont(new Font("Serif",Font.BOLD,10));
         music_singer.setHorizontalAlignment(JLabel.CENTER);

         
         play_main=new JLabel();
         play_main.setIcon(music_images[0]);
         play_main.setBounds(20, 50, 350, 320);
         
         JLabel play_lyrics = new JLabel("�׸����� �� ��" + " " + "�������� �� ��");   // �뷡����
         play_lyrics.setBounds(100, 370, 200, 50);
         
         // �����̴��� ����
         JSlider p_slider3 = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);   //0 ����,  100����, ��� ���� ��������
         p_slider3.setPaintLabels(true);
         p_slider3.setPaintTicks(true);
         p_slider3.setPaintTrack(true);
         p_slider3.setMajorTickSpacing(50);   // ū ����
         p_slider3.setMinorTickSpacing(10);   // ���� ����
         p_slider3.setBounds(100, 450, 200, 50);
         
         // ��ư����, ��ư���, ��ư�Ӽ�
         pause_music = new JButton(pause_music_img);
         pause_music.addActionListener(new ActionButtonHandler_sp());
         pause_music.setBounds(100, 503, 100, 60);
         pause_music.setBackground(Color. white);
         
         stop_music = new JButton(stop_music_img);
         stop_music.setBounds(200, 503, 100, 60);
         stop_music.setBackground(Color. white);
        
         front_music = new JButton(front_music_img);
         front_music.setBounds(300, 503, 100, 60);
         front_music.setBackground(Color. white);
         
         back_music = new JButton(back_music_img);
         back_music.setBounds(0, 503, 100, 60);
         back_music.setBackground(Color. white);
         
         shuffle_music = new JButton(shuffle_on_music_img);
         shuffle_music.addActionListener(new ActionButtonHandler_shuffle_onoff());
         shuffle_music.setBounds(310, 450, 40, 40);
         shuffle_music.setBackground(Color. white);
         
         replay_music = new JButton(replay_music_img);
         replay_music.addActionListener(new ActionButtonHandler_or());
         replay_music.setBounds(50, 450, 40, 40);
         replay_music.setBackground(Color. white);
         
         back_frame = new JButton(back_frame_img);
         back_frame.addActionListener(new ActionButtonHandler3());
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
         frame3.add(stop_music);
         frame3.add(front_music);
         
         frame3.add(back_frame);
         frame3.add(p_panel1);
         frame3.add(play_main);
         frame3.add(play_lyrics);
         frame3.add(shuffle_music);
         frame3.add(p_slider3);
         frame3.add(replay_music);
//       frame3.add(p_panel4);
         frame3.setSize(400,600);
         frame3.setVisible(false);
         //@@@@@ �� ��° ȭ��(Play) ������ @@@@@  //////////////////////////////////////////////////////////////////////////////////////
         
         
         /////////@@@ �� ��° ȭ��(Search) ������//////////////////////////////////////////////////////////////////////////////////////////
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
         p_list_title2.addActionListener(new ActionButtonHandler1());
         p_list_title2.setFont(new Font("Serif",Font.BOLD,20));
         JList searchlist=new JList();
         
         JButton title2 = new JButton("Main");
         title2.addActionListener(new ActionButtonHandler2());
         title2.setFont(new Font("Serif",Font.BOLD,20));
         
         JPanel sl_panel =new JPanel(); // �˻����â
         sl_panel.setBounds(60,200,280,300);
         DefaultListModel demoList = new DefaultListModel();
         JList searchlist1 = new JList(demoList);
         
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
                for(int i=0;i<songArr.length;i++) {
                  if(searchText.getText().equals(songArr[i])) {
                     JOptionPane.showMessageDialog(null, "�뷡�� ã�ҽ��ϴ�. ");
                     demoList.clear();
                     demoList.add(0, songArr[i]);
                     //count_list++;
                     searchText.setText("");
                     cnt ++;
                     //System.out.println(music[i]);
                     
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
   }
   
   class ActionButtonHandler_shuffle_onoff implements ActionListener{
      
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         JButton btn=(JButton) e.getSource();   
            if(btn.getIcon().equals(shuffle_on_music_img)) {
               btn.setIcon(shuffle_off_music_img);             
            }
            else { 
               btn.setIcon(shuffle_on_music_img);
            }
      }
   }
   


   // ���ǽ��ۿ��� ���� ��ư���� ����
   class ActionButtonHandler_sp implements ActionListener{
      
      @Override
      public void actionPerformed(ActionEvent e) {
//    	  index = getSongIndex("����Ҹ�");//"���帶��"��� �κ��� ���������� �ٲ�� �ؾ���//�뷡 Ŭ�� �Ǿ��� �� �� �뷡�� ����ǰ�
//			System.out.println(media_AL.get(index));
//			playMusic1(media_AL.get(index));
			
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
   }
   
   // �� �� ������� ��ü��� ��ư���� ����
   class ActionButtonHandler_or implements ActionListener{
      
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         JButton btn=(JButton) e.getSource();   
            if(btn.getIcon().equals(replay_music_img)) {
               btn.setIcon(once_play_img);
            }
            else { 
               btn.setIcon(replay_music_img);
            }
      }
   }
   
   // ���� ���ý� �������ȭ������ ��ȯ
   class JListHandler2 implements ListSelectionListener{
      
      JLabel label;
      ArrayList<String> musiclist = new ArrayList<String>();
      
      JListHandler2(JLabel label){
         this.label=label;
      }
      
      @Override
      public void valueChanged(ListSelectionEvent e) {
         // TODO Auto-generated method stub
         
         boolean adjust = e.getValueIsAdjusting();
         if(!adjust) {
            JList list = (JList)e.getSource();
            String str = (String)list.getSelectedValue();
            int index_test = list.getSelectedIndex();
            label.setText(""+str);
            str = str.replaceAll(" ", "");
            play_main.setIcon(music_images[index_test]);
            musiclist.add(str);
            frame1.setVisible(false);
            frame2.setVisible(false);
            frame3.setVisible(true);
            
            System.out.println(index_test);
         }
         
         
         
      }   
   }
   
   // ������ ��ȯ
   class ActionButtonHandler1 implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         frame1.setVisible(false);
         frame2.setVisible(true);
         frame3.setVisible(false);
         frame4.setVisible(false);
      }
   }
   
   class ActionButtonHandler2 implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         frame1.setVisible(true);
         frame2.setVisible(false);
         frame3.setVisible(false);
         frame4.setVisible(false);
      }
   }
   
   class ActionButtonHandler3 implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         frame1.setVisible(false);
         frame2.setVisible(true);
         frame3.setVisible(false);
         frame4.setVisible(false);
         
      }
   }
   
   class ActionButtonHandler4 implements ActionListener{  

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         frame1.setVisible(false);
         frame2.setVisible(true);
         frame3.setVisible(false);
         frame4.setVisible(false);
      }
   }
   
   class ActionButtonHandler5 implements ActionListener{  //�˻�

         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            frame1.setVisible(false);
            frame2.setVisible(false);
            frame3.setVisible(false);
            frame4.setVisible(true);
         }
      }
   
   public static void main(String[] args) {
      new Media_test5();
   }
}
