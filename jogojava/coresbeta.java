package jogojava;
import java.awt.Color;
import java.util.Random;
import java. util.Scanner;
public class coresbeta {
    

    static Random mew = new Random();
    static Scanner scanner =new Scanner(System.in);

    public static void main(String[] args) {

}
public static void coresDegrade(String[] titulo) {
                         
    int quantidadeC = titulo.length;
    int aleatorio = mew.nextInt(1,6);
    String[] colors =new String[titulo.length];
    switch (aleatorio) {
        case 1:
            colors = generateGradient("#FFA500", "#4B0082", quantidadeC);
            break;
        case 2:
            colors = generateGradient("#00ffa7", "#4B0082", quantidadeC);
            break;
        case 3:
            colors = generateGradient("#33CCFF", "#4B0082", quantidadeC);
            break;
        case 4:
            colors = generateGradient("#FF1493", "#4B0082", quantidadeC);
            break;
        case 5:
            colors = generateGradient("#FFA500", "#00FF00", quantidadeC);
            break;
        default:
            colors = generateGradient("#FF1493", "#FFFF00", quantidadeC);
            break;
    }
    for (int i = 0; i < quantidadeC ; i++) {
        System.out.print(colors[i] + titulo[i]);
        // Aguarda 200 milissegundos entre cada quadro
        try {
            Thread.sleep(150); // Aguarda 100 milissegundos entre cada quadro
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    

    // Resetar a cor 
    System.out.println("\u001B[0m");
}

// Função para gerar um degradê entre duas cores em um determinado número de etapas
public static String[] generateGradient(String color1, String color2, int quanti) {
    String[] degrade = new String[quanti];

    Color comecotColor = Color.decode(color1);// Color.decode tranfoema o "#FFA500" em cor no java
    Color fimColor = Color.decode(color2);

    // Calcula o incremento de cor para cada etapa
    float corR = (float) (fimColor.getRed() - comecotColor.getRed()) / quanti;
    float corG = (float) (fimColor.getGreen() - comecotColor.getGreen()) / quanti;
    float corB = (float) (fimColor.getBlue() - comecotColor.getBlue()) /quanti;

    // Gera as cores intermediárias, fazendo o degrade das cores
    for (int i = 0; i < quanti; i++) {
        int r = comecotColor.getRed() + Math.round(corR * i);
        int g = comecotColor.getGreen() + Math.round(corG * i);
        int b = comecotColor.getBlue() + Math.round(corB * i);

        degrade[i] = "\u001B[38;2;" + r + ";" + g + ";" + b + "m";//mistura as cores r g b fomanod cada cor de degrade
    }

    return degrade;
}
public static void Logo(){
    String[] titulo ={ "                                     ,---,              ,---,                        ,--.'|               \r\n",
             "         .---.   ,---.    __  ,-.  ,---.'|            ,---.'|         ,--,           |  | :               \r\n",
             "        /. ./|  '   ,'\\ ,' ,'/ /|  |   | :            |   | :       ,'_ /|           :  : '    .--.--.    \r\n",
             "     .-'-. ' | /   /   |'  | |' |  |   | |            |   | |  .--. |  | :    ,---.  |  ' |   /  /    '   \r\n",
             "    /___/ \\: |.   ; ,. :|  |   ,',--.__| |          ,--.__| |,'_ /| :  . |   /     \\ '  | |  |  :  /`./   \r\n",
             " .-'.. '   ' .'   | |: :'  :  / /   ,'   |         /   ,'   ||  ' | |  . .  /    /  ||  | :  |  :  ;_     \r\n",
             "/___/ \\:     ''   | .; :|  | ' .   '  /  |        .   '  /  ||  | ' |  | | .    ' / |'  : |__ \\  \\    `.  \r\n",
             ".   \\  ' .\\   |   :    |;  : | '   ; |:  |        '   ; |:  |:  | : ;  ; | '   ;   /||  | '.'| `----.   \\ \r\n",
             " \\   \\   ' \\ | \\   \\  / |  , ; |   | '/  '        |   | '/  ''  :  `--'   \\'   |  / |;  :    ;/  /`--'  / \r\n",
             "  \\   \\  |--\"   `----'   ---'  |   :    :|        |   :    :|:  ,      .-./|   :    ||  ,   /'--'.     /  \r\n",
             "   \\   \\ |                      \\   \\  /           \\   \\  /   `--`----'     \\   \\  /  ---`-'   `--'---'   \r\n",
             "    '---\"                        `----'             `----'                   `----'                       "};
    int quantidadeC = titulo.length;

    int aleatorio = mew.nextInt(1,6);
    String[] colors =new String[titulo.length];
    switch (aleatorio) {
        case 1:
            colors = generateGradient("#FFA500", "#4B0082", quantidadeC);
            break;
        case 2:
            colors = generateGradient("#00ffa7", "#4B0082", quantidadeC);
            break;
        case 3:
            colors = generateGradient("#33CCFF", "#4B0082", quantidadeC);
            break;
        case 4:
            colors = generateGradient("#FF1493", "#4B0082", quantidadeC);
            break;
        case 5:
            colors = generateGradient("#FFA500", "#00FF00", quantidadeC);
            break;
        default:
            colors = generateGradient("#FF1493", "#FFFF00", quantidadeC);
            break;
    }
    for (int i = 0; i < quantidadeC ; i++) {
        System.out.print(colors[i] + titulo[i]);
        // Aguarda 200 milissegundos entre cada quadro
        try {
            Thread.sleep(150); // Aguarda 100 milissegundos entre cada quadro
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    

    // Resetar a cor 
    System.out.println("\u001B[0m");
    
}

public static String[] degradelogo(String color1, String color2, int quanti) {
    String[] degrade = new String[quanti];

    Color comecotColor = Color.decode(color1);// Color.decode tranfoema o "#FFA500" em cor no java
    Color fimColor = Color.decode(color2);

    // Calcula o incremento de cor para cada etapa
    float corR = (float) (fimColor.getRed() - comecotColor.getRed()) / quanti;
    float corG = (float) (fimColor.getGreen() - comecotColor.getGreen()) / quanti;
    float corB = (float) (fimColor.getBlue() - comecotColor.getBlue()) /quanti;

    // Gera as cores intermediárias, fazendo o degrade das cores
    for (int i = 0; i < quanti; i++) {
        int r = comecotColor.getRed() + Math.round(corR * i);
        int g = comecotColor.getGreen() + Math.round(corG * i);
        int b = comecotColor.getBlue() + Math.round(corB * i);

        degrade[i] = "\u001B[38;2;" + r + ";" + g + ";" + b + "m";//mistura as cores r g b fomanod cada cor de degrade
    }

    return degrade;
}
public static void corvermelho(String[] titulo) {
                         
    int quantidadeC = titulo.length;
  
    String[] colors =new String[titulo.length];
   
    // Cores de degradê, color 1 e onde a cor começa e o color2 e onde a cor termina
     colors = generateGradient("#FF2400", "#FF0000", quantidadeC );
    
      

    for (int i = 0; i < quantidadeC ; i++) {
        System.out.print(colors[i] + titulo[i]);
        // Aguarda 200 milissegundos entre cada quadro
      
    }
    

    // Resetar a cor 
    System.out.println("\u001B[0m");
}

// Função para gerar um degradê entre duas cores em um determinado número de etapas
public static String[] cdegrade(String color1, String color2, int quanti) {
    String[] degrade = new String[quanti];

    Color comecotColor = Color.decode(color1);// Color.decode tranfoema o "#FFA500" em cor no java
    Color fimColor = Color.decode(color2);

    // Calcula o incremento de cor para cada etapa
    float corR = (float) (fimColor.getRed() - comecotColor.getRed()) / quanti;
    float corG = (float) (fimColor.getGreen() - comecotColor.getGreen()) / quanti;
    float corB = (float) (fimColor.getBlue() - comecotColor.getBlue()) /quanti;

    // Gera as cores intermediárias, fazendo o degrade das cores
    for (int i = 0; i < quanti; i++) {
        int r = comecotColor.getRed() + Math.round(corR * i);
        int g = comecotColor.getGreen() + Math.round(corG * i);
        int b = comecotColor.getBlue() + Math.round(corB * i);

        degrade[i] = "\u001B[38;2;" + r + ";" + g + ";" + b + "m";//mistura as cores r g b fomanod cada cor de degrade
    }

    return degrade;
}
//aqui e o degrade dos printf 
public static void coresDegradeText(String text) {
                         
    int quantidadeC = text.length();
    int aleatorio = mew.nextInt(1, 6);
    String[] colors;

    // Seleção das cores para o degradê
    switch (aleatorio) {
        case 1:
            colors = generateGradient("#FFA500", "#4B0082", quantidadeC);
            break;
        case 2:
            colors = generateGradient("#00ffa7", "#4B0082", quantidadeC);
            break;
        case 3:
            colors = generateGradient("#33CCFF", "#4B0082", quantidadeC);
            break;
        case 4:
            colors = generateGradient("#FF1493", "#4B0082", quantidadeC);
            break;
        case 5:
            colors = generateGradient("#FFA500", "#00FF00", quantidadeC);
            break;
        default:
            colors = generateGradient("#FF1493", "#FFFF00", quantidadeC);
            break;
    }

    // Imprimir o texto com degradê
    for (int i = 0; i < quantidadeC; i++) {
        char c = text.charAt(i);
        if (c != '\n' && c != ' ') {
            System.out.print(colors[i % colors.length] + c + "\u001B[0m");
        } else {
            System.out.print(c);
        }
    }
    System.out.print("\u001B[0m"); // Resetar a cor
}


// Função para gerar um degradê entre duas cores em um determinado número de etapas
public static String[] textDegrade(String color1, String color2, int quanti) {
    String[] degrade = new String[quanti];

    Color comecotColor = Color.decode(color1);// Color.decode tranfoema o "#FFA500" em cor no java
    Color fimColor = Color.decode(color2);

    // Calcula o incremento de cor para cada etapa
    float corR = (float) (fimColor.getRed() - comecotColor.getRed()) / quanti;
    float corG = (float) (fimColor.getGreen() - comecotColor.getGreen()) / quanti;
    float corB = (float) (fimColor.getBlue() - comecotColor.getBlue()) /quanti;

    // Gera as cores intermediárias, fazendo o degrade das cores
    for (int i = 0; i < quanti; i++) {
        int r = comecotColor.getRed() + Math.round(corR * i);
        int g = comecotColor.getGreen() + Math.round(corG * i);
        int b = comecotColor.getBlue() + Math.round(corB * i);

        degrade[i] = "\u001B[38;2;" + r + ";" + g + ";" + b + "m";//mistura as cores r g b fomanod cada cor de degrade
    }

    return degrade;
}



}
