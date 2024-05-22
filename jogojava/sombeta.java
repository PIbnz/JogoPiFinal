package jogojava;

import javax.sound.sampled.*;
import java.io.File;

public class sombeta {
    private static Clip clip;

    public static void main(String[] args) {
        // Main method para teste, não é necessário usar aqui
    }

    public static  void som() {
        pararSom();
        try {
            
            File file = new File("sons/espera.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.loop(2);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
    }
    
    public static  void som1() {
       
        try {
            File file = new File("sons/espe2.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.stop();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static  void toqueSom() {
        // Stop any current sound before playing a new one
        try {
            File file = new File("sons/clik.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
           
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void erroSom() {
        pararSom();
        try {
            File file = new File("sons/erro.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void toque1Som() {
        pararSom();
        try {
            File file = new File("sons/sele.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static  void sominicio() {
       
        try {
            File file = new File("sons/play.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static  void somjogo() {
       
        try {
            File file = new File("sons/somdojogoD.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
   
    public static class GerenciadorSom {
        private static Clip clipMenu;
        private static boolean somMenuTocando = false;

        public static void iniciarSomMenu() {
            if (!somMenuTocando) {
                try {
                    Thread.sleep(1560);
                    File file = new File("sons/espera.wav");
                    clipMenu = AudioSystem.getClip();
                    clipMenu.open(AudioSystem.getAudioInputStream(file));
                    clipMenu.loop(Clip.LOOP_CONTINUOUSLY);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                somMenuTocando = true;
            }
        }

        public static void pararSomMenu() {
            if (somMenuTocando) {
                if (clipMenu != null) {
                    clipMenu.stop();
                    clipMenu.flush();
                    clipMenu.close();
                }
                somMenuTocando = false;
            }
        }
    }
    public static void pararSom() {
        if (clip != null) {
            clip.stop();
            clip.flush();
            clip.close();
           
        }
    }
}