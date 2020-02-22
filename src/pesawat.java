import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class pesawat extends JFrame{
    
    
    AudioClip soundTrack;
    AudioClip sound;
    
    int x=290;
    int xa=0;
    int y=500;
    int ya=0;
    
    int musuhxa = 0;
    int musuhx =0;
    int musuhu=100;
    int musuha = -80;
    
    int tembakan = -910;
    int tembakana = -20;
   
    int tembakanposisi=290;
    int tembakanposisix=0;
    
    private BufferedImage backgroundgambar;
    private BufferedImage pesawat_luar_angkasa;
    private BufferedImage musuh_ufo;
    
    boolean kanankiri;
    
    
    int kena_tembak=0;
    int nilai =0;
    boolean kena;
    public pesawat(){
        setSize(600,600);
        setTitle("Pesawat");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
       
        soundTrack=Applet.newAudioClip(getClass().getResource("backsound.wav"));
        soundTrack.loop();
        
          try{
            backgroundgambar = ImageIO.read(getClass().getResource("/back.jpg"));
            pesawat_luar_angkasa = ImageIO.read(getClass().getResource("/pesawat.png"));
            musuh_ufo = ImageIO.read(getClass().getResource("/ufo.png"));
         }catch(IOException ex){
            ex.printStackTrace();
        }
        
        
         addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
                
            }public void keyReleased(KeyEvent e){
                xa= 0;
                ya=0;
                tembakana=0;
                
               if(e.getKeyCode() == KeyEvent.VK_SPACE){
              tembakanposisi=x;
              tembakan=430;
              tembakana=-30; 
                sound=Applet.newAudioClip(getClass().getResource("laser5.wav"));
                sound.play();
                }
            }public void keyPressed(KeyEvent e){
            if(e.getKeyCode()==KeyEvent.VK_LEFT){
                xa=-10;
                tembakanposisix-=10;
              
                
            }if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                xa=+10;
                tembakanposisix+=10;
           
            }if(e.getKeyCode() == KeyEvent.VK_R){
               tembakan=x;
               tembakanposisi=y;
            }
            
            } 
           
         });
                 }
    
    public void paint(Graphics ea){
        //background
        ea.setColor(Color.black);
        ea.drawImage(backgroundgambar,0,0,this.getWidth(),this.getHeight(),null); 
        
        //musuh
        ea.setColor(Color.white);
        ea.drawImage(musuh_ufo,musuhx, musuhu, 60,60,null);
        
         //tembakan
        ea.setColor(Color.red);
        ea.fillOval(tembakanposisi, tembakan, 10, 10);
               
    
        
        //pesawat
        ea.setColor(Color.white);
        ea.drawImage(pesawat_luar_angkasa,x, y, 80, 80,null);
   
    
        ea.setColor(Color.white);
        ea.fillRect(0, 0, 60, 80);
        
        ea.setFont(new Font("Calibri",Font.BOLD,24)); 
        ea.setColor(Color.red);
        ea.drawString(""+nilai, 25, 70);
        
    }
    
    public void nilai(){
        if(nilai==50){
            JOptionPane.showMessageDialog(null,"You Win");
        }
    }
  
    public void gerak(){
    if(kanankiri==true){
             musuhx += 5;
             if(musuhx >= 500){
                 kanankiri=false;
             }
         }else {
         musuhx -= 5;
         if(musuhx <=0){
             kanankiri=true;
         }
         }
    }
    
   
   
    
    
    public void pindah(){
        
       
        
        
    if(x+xa > 0 && x+xa < this.getWidth()-10){
            x = x + xa;           
    }if(y+ya > 0 && y+ya < this.getHeight()-10){
        y = y + ya;
    }
    if(tembakan+tembakana>0&&tembakan+tembakana<this.getWidth()-10)
        {
            tembakan=tembakan+tembakana;
           
        }
    }
    
    public void ea(){
      if((x == musuhx)&&(tembakanposisi==musuhx)){
          nilai = nilai + 10;
          musuhx = musuha;
               
      }
    }
    
    public static void main(String[] args) {
        pesawat a = new pesawat();
        a.setVisible(true);
        
        
        
        
    while(true){
            a.pindah();
            a.repaint();
            a.gerak();
            a.pindah();
            a.nilai();
            //a.kena_tembakan();
            a.ea();
           
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                
            
            }
    }
    }
    }
    
    

   
