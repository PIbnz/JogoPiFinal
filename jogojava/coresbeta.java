package jogojava;
import java.awt.Color;
import java.io.IOException;
import java.util.Random;
import java. util.Scanner;


public class coresbeta {
    
    private static boolean enterPressed = false;
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
public static void Logo() {
    String[] titulo = {
        "                                         ,---,              ,---,                        ,--.'|               \r\n",
        "             .---.   ,---.    __  ,-.  ,---.'|            ,---.'|         ,--,           |  | :               \r\n",
        "            /. ./|  '   ,'\\ ,' ,'/ /|  |   | :            |   | :       ,'_ /|           :  : '    .--.--.    \r\n",
        "         .-'-. ' | /   /   |'  | |' |  |   | |            |   | |  .--. |  | :    ,---.  |  ' |   /  /    '   \r\n",
        "        /___/ \\: |.   ; ,. :|  |   ,',--.__| |          ,--.__| |,'_ /| :  . |   /     \\ '  | |  |  :  /`./   \r\n",
        "     .-'.. '   ' .'   | |: :'  :  / /   ,'   |         /   ,'   ||  ' | |  . .  /    /  ||  | :  |  :  ;_     \r\n",
        "    /___/ \\:     ''   | .; :|  | ' .   '  /  |        .   '  /  ||  | ' |  | | .    ' / |'  : |__ \\  \\    `.  \r\n",
        "    .   \\  ' .\\   |   :    |;  : | '   ; |:  |        '   ; |:  |:  | : ;  ; | '   ;   /||  | '.'| `----.   \\ \r\n",
        "     \\   \\   ' \\ | \\   \\  / |  , ; |   | '/  '        |   | '/  ''  :  `--'   \\'   |  / |;  :    ;/  /`--'  / \r\n",
        "      \\   \\  |--\"   `----'   ---'  |   :    :|        |   :    :|:  ,      .-./|   :    ||  ,   /'--'.     /  \r\n",
        "       \\   \\ |                      \\   \\  /           \\   \\  /   `--`----'     \\   \\  /  ---`-'   `--'---'   \r\n",
        "        '---\"                        `----'             `----'                   `----'                       ",
        "        \n",
        "    \n",
        "   \n",
        "    \n",
        "                                  [selecione ENTER para continuar]\n"        };
    int quantidadeC = titulo.length;

    // Gera um degradê de cores
    String[] colors = degradelogo("#FF1493", "#FFFF00", quantidadeC);

    // Imprime o logo linha por linha com o degradê de cores
    for (int i = 0; i < quantidadeC; i++) {
        System.out.print(colors[i] + titulo[i]);
        try {
            Thread.sleep(150); // Aguarda 150 milissegundos entre cada linha
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Número de quadros na animação
    int frameMenu = 100000; // Reduzi o número de quadros para fins de teste
    // Tempo de atraso entre cada quadro em milissegundos
    int delay = 100;

    // Cria e inicia uma nova thread para a animação de mudança de cores
    Thread animacao= new Thread(() -> {
        for (int frame = 0; frame < frameMenu; frame++) {
            // Move o cursor para cima para sobrescrever as linhas
            System.out.print("\u001B[" + quantidadeC + "A");
            // Desenha o logo com o degradê
            for (int i = 0; i < quantidadeC; i++) {
                // Calcula o índice de cor para cada linha, deslocado pelo quadro atual
                int colorIndex = (i + frame) % quantidadeC;
                // Imprime a linha do logo com a cor correspondente
                System.out.print(colors[colorIndex] + titulo[i]);
            }

            // Aguarda um curto período de tempo antes de desenhar o próximo quadro
            try {
                // Verifica se o Enter foi pressionado para interromper o Thread.sleep(delay)
                for (int i = 0; i < delay / 10; i++) {
                    if (enterPressed) {
                        enterPressed = false; // Reinicia a flag
                        return; // Sai do loop e interrompe a execução do thread
                    }
                    Thread.sleep(10); // Aguarda 10 milissegundos antes de verificar novamente
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Reseta a cor após a animação
        System.out.println("\u001B[0m");
    });
    animacao.start(); // Inicia a thread de animação

    // Aguarda até que o usuário pressione Enter
    aguardarEnter();

    // Aguarda a thread de animação terminar
    try {
        animacao.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // Apresenta o menu após o Enter
    
}

// Função para gerar o degradê de cores
public static String[] degradelogo(String color1, String color2, int quanti) {
    String[] degrade = new String[quanti];

    Color comecotColor = Color.decode(color1); // Transforma a cor inicial de string para Color
    Color fimColor = Color.decode(color2); // Transforma a cor final de string para Color

    // Calcula o incremento de cor para cada etapa
    float corR = (float) (fimColor.getRed() - comecotColor.getRed()) / quanti;
    float corG = (float) (fimColor.getGreen() - comecotColor.getGreen()) / quanti;
    float corB = (float) (fimColor.getBlue() - comecotColor.getBlue()) / quanti;

    // Gera as cores intermediárias para o degradê
    for (int i = 0; i < quanti; i++) {
        int r = comecotColor.getRed() + Math.round(corR * i);
        int g = comecotColor.getGreen() + Math.round(corG * i);
        int b = comecotColor.getBlue() + Math.round(corB * i);

        degrade[i] = "\u001B[38;2;" + r + ";" + g + ";" + b + "m"; // Define a cor no formato ANSI
    }

    return degrade;
}

// Função para aguardar que o usuário pressione Enter
public static void aguardarEnter() {
    scanner = new Scanner(System.in);
    
    scanner.nextLine(); // Aguarda até que o usuário pressione Enter
    // Define a flag para indicar que o Enter foi pressionado
    enterPressed = true;
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
 public static void telaDeVitoria() {
    sombeta.somVitoria1();
        String[] titulo =  {
            "                                                                \n",
            "               \\                  ╔══════════════════════════════╗                 /                \n",
            "                 ╔════════════════════════════════════════════════════════════════╗                 \n",   
            "   ╔═════════════╩════════════════╝                              ╚════════════════╩═════════════╗   \n",
            "  ╔╣                                                                                            ╠╗  \n",
            "  ║║                             PARABÉNS, VOCÊ JOGOU BEM E GANHOU!                             ║║  \n",
            "  ║║                         ─────────────────────────────────────────                          ║║  \n",               
            "  ║║                                     OBRIGADO POR JOGAR!                                    ║║  \n",
            "  ║║                                                                                            ║║  \n",                       
            "  ║║                            VOCÊS QUEREM JOGAR NOVAMENTE? (S/N)                             ║║  \n",
            "  ╚╣                                                                                            ╠╝  \n",
            "   ╚═════════════╦════════════════╗                              ╔════════════════╦═════════════╝   \n",
            "                 ╚════════════════════════════════════════════════════════════════╝                 \n",
            "               /                  ╚══════════════════════════════╝                  \\                 \n",
            "    \n",
            "    \n",
            "     \n",
            "    \n",
            "                             selecione S OU N e de ENTER para continuar..."
           
           
          
          
        };
          
        int quantidadeC = titulo.length;      
        String[] colors = ganahdor("#7F00FF", "#FF0000", quantidadeC);       
        for (int i = 0; i < quantidadeC; i++) {
            System.out.print(colors[i] + titulo[i]);
            try {
                Thread.sleep(150); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
     int frameMenu =100; 
    int delay = 100;

       
        Thread animacao= new Thread(() -> {
            for (int frame = 0; frame < frameMenu; frame++) {
                
                System.out.print("\u001B[" + quantidadeC + "A");
              
                for (int i = 0; i < quantidadeC; i++) {
                    
                    int colorIndex = (i + frame) % quantidadeC;
                  
                    System.out.print(colors[colorIndex] + titulo[i]);
                }            
                try {
                  
                    for (int i = 0; i < delay / 10; i++) {
                        if (enterPressed) {
                            enterPressed = false; 
                            return; 
                        }
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Reseta a cor após a animação
            System.out.println("\u001B[0m");
        });
        animacao.start(); // Inicia a thread de animação

        // Aguarda até que o usuário pressione Enter
        aguardarEnter();

        // Aguarda a thread de animação terminar
        try {
            animacao.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Apresenta o menu após o Enter
        
    }

    // Função para gerar o degradê de cores
    public static String[] ganahdor(String color1, String color2, int quanti) {
        String[] degrade = new String[quanti];

        Color comecotColor = Color.decode(color1);
        Color fimColor = Color.decode(color2); 

        // Calcula o incremento de cor para cada etapa
        float corR = (float) (fimColor.getRed() - comecotColor.getRed()) / quanti;
        float corG = (float) (fimColor.getGreen() - comecotColor.getGreen()) / quanti;
        float corB = (float) (fimColor.getBlue() - comecotColor.getBlue()) / quanti;

        // Gera as cores intermediárias para o degradê
        for (int i = 0; i < quanti; i++) {
            int r = comecotColor.getRed() + Math.round(corR * i);
            int g = comecotColor.getGreen() + Math.round(corG * i);
            int b = comecotColor.getBlue() + Math.round(corB * i);

            degrade[i] = "\u001B[38;2;" + r + ";" + g + ";" + b + "m"; 
        }

        return degrade;
    }
    public static void nomeGanhador(String nome) {
        String[][] alphabet = {
            // A
            {
                "  █████╗  ",
                " ██╔══██╗ ",
                " ███████║ ",
                " ██╔══██║ ",
                " ██║  ██║ ",
                " ╚═╝  ╚═╝ "
            },
            // B
            {
                " ██████╗  ",
                " ██╔══██╗ ",
                " ██████╔╝ ",
                " ██╔══██╗ ",
                " ██████╔╝ ",
                " ╚═════╝  "
            },
            // C
            {
                "  ██████╗ ",
                " ██╔════╝ ",
                " ██║      ",
                " ██║      ",
                " ╚██████╗ ",
                "  ╚═════╝ "
            },
            // D
            {
                " ██████╗  ",
                " ██╔══██╗ ",
                " ██║  ██║ ",
                " ██║  ██║ ",
                " ██████╔╝ ",
                " ╚═════╝  "
            },
            // E
            {
                " ███████╗ ",
                " ██╔════╝ ",
                " ███████╗ ",
                " ██╔════╝ ",
                " ███████╗ ",
                " ╚══════╝ "
            },
            // F
            {
                " ███████╗ ",
                " ██╔════╝ ",
                " ███████╗ ",
                " ██╔════╝ ",
                " ██║      ",
                " ╚═╝      "
            },
            // G
            {
                "  ██████╗ ",
                " ██╔════╝ ",
                " ██║  ███╗",
                " ██║   ██║",
                " ╚██████╔╝",
                "  ╚═════╝ "
            },
            // H
            {
                " ██╗  ██╗ ",
                " ██║  ██║ ",
                " ███████║ ",
                " ██╔══██║ ",
                " ██║  ██║ ",
                " ╚═╝  ╚═╝ " 
            },
            // I
            {
                " ██╗ ",
                " ██║ ",
                " ██║ ",
                " ██║ ",
                " ██║ ",
                " ╚═╝ "
            },
            // J
            {
                "     ██╗",
                "     ██║",
                "     ██║",
                "██   ██║",
                "╚█████╔╝",
                " ╚════╝ "
            },
            // K
            {
                "██╗  ██╗",
                "██║ ██╔╝",
                "█████╔╝ ",
                "██╔═██╗ ",
                "██║  ██╗",
                "╚═╝  ╚═╝"
            },
            // L
            {
                " ██╗      ",
                " ██║      ",
                " ██║      ",
                " ██║      ",
                " ███████╗ ",
                " ╚══════╝ "
            },
            // M
            {
                "███╗   ███╗ ",
                "████╗ ████║ ",
                "██╔████╔██║ ",
                "██║╚██╔╝██║ ",
                "██║ ╚═╝ ██║ ",
                "╚═╝     ╚═╝ "
            },
            // N
            {
                "███╗   ██╗",
                "████╗  ██║",
                "██╔██╗ ██║",
                "██║╚██╗██║",
                "██║ ╚████║",
                "╚═╝  ╚═══╝"
            },
            // O
            {
                " ██████╗  ",
                "██╔═══██╗ ",
                "██║   ██║ ",
                "██║   ██║ ",
                "╚██████╔╝ ",
                " ╚═════╝  "
            },
            // P
            {
                " ██████╗  ",
                " ██╔══██╗ ",
                " ██████╔╝ ",
                " ██╔═══╝  ",
                " ██║      ",
                " ╚═╝      "
            },
            // Q
            {
                "  ██████╗ ",
                " ██╔═══██╗",
                " ██║   ██║",
                " ██║▄▄ ██║",
                " ╚██████╔╝",
                "  ╚══▀▀═╝ "
            },
            // R
            {
                " ██████╗  ",
                " ██╔══██╗ ",
                " ██████╔╝ ",
                " ██╔══██╗ ",
                " ██║  ██║ ",
                " ╚═╝  ╚═╝ "
            },
            // S
            {
                " ███████╗ ",
                " ██╔════╝ ",
                " ███████╗ ",
                " ╚════██║ ",
                " ███████║ ",
                " ╚══════╝ "
            },
            // T
            {
                "████████╗ ",
                "╚══██╔══╝ ",
                "   ██║    ",
                "   ██║    ",
                "   ██║    ",
                "   ╚═╝    "
            },
            // U
            {
                "██╗  ██╗  ",
                "██║  ██║  ",
                "██║  ██║  ",
                "██║  ██║  ",
                " █████╔╝  ",
                "  ╚═══╝   "
            },
            // V
            {
                "██╗   ██╗ ",
                "██║   ██║ ",
                "██║   ██║ ",
                "╚██╗ ██╔╝ ",
                " ╚████╔╝  ",
                "  ╚═══╝   "
            },
            // W
            {
                "██╗    ██╗",
                "██║    ██║",
                "██║ █╗ ██║",
                "██║███╗██║",
                "╚███╔███╔╝",
                " ╚══╝╚══╝ "
            },
            // X
            {
                " ██╗  ██╗ ",
                " ╚██╗██╔╝ ",
                "  ╚███╔╝  ",
                "  ██╔██╗  ",
                " ██╔╝ ██╗ ",
                " ╚═╝  ╚═╝ "
            },
            // Y
            {
                " ██╗   ██╗",
                " ╚██╗ ██╔╝",
                "  ╚████╔╝ ",
                "   ╚██╔╝  ",
                "    ██║   ",
                "    ╚═╝   "
            },
            // Z
            {
                "███████╗ ",
                "╚══███╔╝ ",
                "  ███╔╝  ",
                " ███╔╝   ",
                "███████╗ ",
                "╚══════╝ "
            },
            // Espaço
            {
                " ",
                " ",
                " ",
                " ",
                " ",
                " "
            }
        };

        nome = nome.toUpperCase();

        
        int alturaLetra = alphabet[0].length;
        int larguraLetra = alphabet[0][0].length();
        int larguraNome = nome.length() * larguraLetra + (nome.length() - 1); 
        int larguraRetangulo = larguraNome + 4; 
        int alturaRetangulo = alturaLetra + 2; 

       
        String[][] tabela = new String[alturaRetangulo][larguraRetangulo];

        
        for (int i = 0; i < alturaRetangulo; i++) {
            for (int j = 0; j < larguraRetangulo; j++) {
                if (i == 0 && j == 0) {
                    tabela[i][j] = "╔";
                } else if (i == 0 && j == larguraRetangulo - 1) {
                    tabela[i][j] = "╗";
                } else if (i == alturaRetangulo - 1 && j == 0) {
                    tabela[i][j] = "╚";
                } else if (i == alturaRetangulo - 1 && j == larguraRetangulo - 1) {
                    tabela[i][j] = "╝";
                } else if (i == 0 || i == alturaRetangulo - 1) {
                    tabela[i][j] = "═";
                } else if (j == 0 || j == larguraRetangulo - 1) {
                    tabela[i][j] = "║";
                } else {
                    tabela[i][j] = " ";
                }
            }
        }

        
        letras(tabela, nome, 1, 2, alphabet);

        
        int quantidadeC = tabela.length;
        String[] colors = vitoriaFim("#7F00FF", "#FF0000", quantidadeC);

       
        for (int i = 0; i < quantidadeC; i++) {
            System.out.print(colors[i]);
            for (int j = 0; j < tabela[i].length; j++) {
                System.out.print(tabela[i][j]);
            }
            System.out.println();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
        }
        
        
        System.out.println("\u001B[0m");
    }

    public static void letras(String[][] tabela, String nome, int linha, int coluna, String[][] alphabet) {
        nome = nome.toUpperCase();

        for (int i = 0; i < 6; i++) { 
            for (int j = 0; j < nome.length(); j++) {
                char letra = nome.charAt(j);
                if (letra >= 'A' && letra <= 'Z') {
                    String linhaASCII = alphabet[letra - 'A'][i];
                    for (int l = 0; l < linhaASCII.length(); l++) {
                        tabela[linha + i][coluna + j * (linhaASCII.length() + 1) + l] = String.valueOf(linhaASCII.charAt(l));
                    }
                }
            }
        }
    }

    // Função para gerar o degradê de cores
    public static String[] vitoriaFim(String color1, String color2, int quanti) {
        String[] degrade = new String[quanti];

        Color comecotColor = Color.decode(color1); 
        Color fimColor = Color.decode(color2);

        // Calcula o incremento de cor para cada etapa
        float corR = (float) (fimColor.getRed() - comecotColor.getRed()) / quanti;
        float corG = (float) (fimColor.getGreen() - comecotColor.getGreen()) / quanti;
        float corB = (float) (fimColor.getBlue() - comecotColor.getBlue()) / quanti;

        for (int i = 0; i < quanti; i++) {
            int r = comecotColor.getRed() + Math.round(corR * i);
            int g = comecotColor.getGreen() + Math.round(corG * i);
            int b = comecotColor.getBlue() + Math.round(corB * i);

            degrade[i] = "\u001B[38;2;" + r + ";" + g + ";" + b + "m"; 
        }

        return degrade;
    }

   
    
    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime();
            }
        } catch (final InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }





}
