package jogojava;

import javax.sound.sampled.*;
import java.io.File;

public class sombeta {
    private static Clip clip;

    public static void main(String[] args) {
        // Main method para teste, não é necessário usar aqui
    }

public static class GerenciadorSom {
        private static Clip clipMenu;
        private static boolean somMenuTocando = false;

        public static void iniciarSomMenu() {
            if (!somMenuTocando) {
                try {
                    Thread.sleep(1560);
                    File file = new File("sons/domJogoInicio.wav");
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
    public static class somJogoPartida {
        private static Clip clipMenu;
        private static boolean somMenuTocando = false;

        public static void iniciarMuisca() {
            if (!somMenuTocando) {
                try {
                    
                    File file = new File("sons/somdojogoD.wav");
                    clipMenu = AudioSystem.getClip();
                    clipMenu.open(AudioSystem.getAudioInputStream(file));
                    clipMenu.loop(Clip.LOOP_CONTINUOUSLY);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                somMenuTocando = true;
            }
        }

        public static void pararSomPartida() {
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
   
   
   
    public static  void toqueintre() {
        // Stop any current sound before playing a new one
        try {
            File file = new File("sons/intre.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
           
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static  void toquedeintre() {
        // Stop any current sound before playing a new one
        try {
            File file = new File("sons/intre1.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
           
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static  void toqueErro() {
        // Stop any current sound before playing a new one
        try {
            File file = new File("sons/erro1.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
            
           
           
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static  void acertoJogada() {
        // Stop any current sound before playing a new one
        try {
            File file = new File("sons/acertojogada.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
           
           
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static  void maisOuMenosJogada() {
        // Stop any current sound before playing a new one
        try {
            File file = new File("sons/toque.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
            
           
           
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static  void somVitoria1() {
        // Stop any current sound before playing a new one
        try {
            File file = new File("sons/somvitoria1.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
          
           
           
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static  void somVitoria() {
        // Stop any current sound before playing a new one
        try {
            File file = new File("sons/somVitoria2.wav");
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
            
           
           
            
        } catch (Exception ex) {
            ex.printStackTrace();
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