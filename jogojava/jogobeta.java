package jogojava;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class jogobeta{
    static Scanner miau = new Scanner(System.in);
    static Random mew = new Random();
    
    public static int jogadoresPresentes = 1;
    public static int globalWidth = 45;
    public static Thread tocar; // Declaração do Thread, mas sem inicialização
    
    public static void main(String[] args) throws Exception {
        tocar = new Thread(() -> sombeta. GerenciadorSom.iniciarSomMenu()); // Inicialização do Thread
        tocar.start();
       
       ;
       
        Menu();
        
        opções();
      
      
    }
    
    
    

    public static void Menu(){
         
        
         apagar();

         String[]bem ={"B","e","m", " v","i","n","d","o", " a","o",".",".",".\n"};      
         for(int num=0; num<13;num++){
            System.out.print(bem[num]);
            try {
                Thread.sleep(150); // Aguarda 150 milissegundos entre cada quadro
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         }
        coresbeta.Logo();

        
        
 
        String[] menu = {"                                  ╔══════════════════════════════╗                                  \n",
                         "                 ╔════════════════════════════════════════════════════════════════╗                 \n",   
                         "   ╔═════════════╩════════════════╝                              ╚════════════════╩═════════════╗   \n",
                         "  ╔╣                                                                                            ╠╗  \n",
                         "  ║║                                       Menu de Opções                                       ║║  \n",
                         "  ║║                                                                                            ║║  \n",
                         "  ║║                 ┌──────────────────────────────────────────────────────────┐               ║║  \n",
                         " ╔╣╝                 │  1. SinglePlayer                                         │               ╚╠╗ \n",
                         " ║║                  │                                                          │                ║║ \n",
                         " ║║                  │  2. Multiplayer                                          │                ║║  \n",
                         " ║║                  │                                                          │                ║║  \n",
                         " ║║                  │  3. Regras                                               │                ║║  \n",
                         " ║║                  │                                                          │                ║║  \n",             
                         " ╚╣╗                 │  0. Sair                                                 │               ╔╠╝ \n",
                         "  ║║                 └──────────────────────────────────────────────────────────┘               ║║  \n",
                         "  ║║                                                                                            ║║  \n",                       
                         "  ║║                                                                                            ║║  \n",
                         "  ╚╣                                                                                            ╠╝  \n",
                         "   ╚═════════════╦════════════════╗                              ╔════════════════╦═════════════╝   \n",
                         "                 ╚════════════════════════════════════════════════════════════════╝                 \n",
                         "                                  ╚══════════════════════════════╝                                  \n",
                            "                         selecione um numero e de ENTER para continuar..."
        };

        coresbeta.coresDegrade(menu);
       

      
    }
    public static void opções() {
       
        int opções = miau.nextInt();
        sombeta.toqueSom();
        apagar();
        telaCarregar();
        apagar();
        switch (opções) {
            case 1:
               
                SinglePlayer();
                break;
            case 2:
           
              Multiplayer();
                break;
            case 3:
                Regras();
                break;
            case 0:
                System.out.println("Muito obrigado por jogar até da proxima vez");
                break;
            default:
            System.out.println("Comando não reconhecido voltando ao menu");
                Menu();
                break;
        }
        
    }

    public static void SinglePlayer(){
        
        

    }

    public static void Multiplayer(){
        
        JogadoresPresentes();
         String[] palavras = new String[jogadoresPresentes];
         String[] nomes = new String[jogadoresPresentes];
         String[] stringChute = new String[jogadoresPresentes];
         int[] vencer = new int[jogadoresPresentes];
        Nomes(nomes);
        Palvras(palavras,nomes);
        sombeta.GerenciadorSom.pararSomMenu();
        sombeta.sominicio();
        embaralhar(palavras);
      
        Jogadas(stringChute, palavras, nomes,vencer);
        
        
        System.out.println();

    }
   
    public static int JogadoresPresentes(){
        apagar();
        
        String[] infom = {"╔═════════════════════════════════════════════════════════════════╗\n"+
                            "║                                                                 ║\n"+
                            "║           Informe o total de jogadores que vão jogar            ║\n"+
                            "║                                                                 ║\n"+
                            "╠═════════════════════════════════════════════════════════════════╣\n"+
                            "║   De 2 a 8 jogadores                                            ║\n"+
                            "╚═════════════════════════════════════════════════════════════════╝\n"};
             coresbeta.coresDegrade(infom);
        do{
            jogadoresPresentes = miau.nextInt();
            if(jogadoresPresentes>8){
                sombeta.erroSom();
                String[] regras = {"╔═════════════════════════════════════════════════════╗\n",
                                    "║                                                     ║\n",
                                    "║                O limite de jogares é 8              ║\n",
                                    "║                                                     ║\n",
                                    "╚═════════════════════════════════════════════════════╝\n"};
                coresbeta.corvermelho(regras);
            }else if(jogadoresPresentes<2){
                sombeta.erroSom();
                String[] regras = { "╔═════════════════════════════════════════════════════╗\n",
                                    "║                                                     ║\n",
                                    "║          Pelo menos 2 jogadores devem jogar         ║\n",
                                    "║                                                     ║\n",
                                    "╚═════════════════════════════════════════════════════╝\n"};
               coresbeta.corvermelho(regras);                    
            }
        }while(jogadoresPresentes<2 || jogadoresPresentes>8);
        apagar();
        return jogadoresPresentes;

    }

    public static void Regras(){
        int voltar;
        String[] regras = {
            "╔══════════════════════════════════════════════════════════════════╗\n",
            "║                            Regras                                ║\n",
            "╠══════════════════════════════════════════════════════════════════╣\n",
            "║  Single Player:                                                  ║\n",
            "║  - O modo single player consiste em você tentar acertar          ║\n",
            "║    palavras chutando a letra e a sua posição equivalente         ║\n",
            "║    na palavra.                                                   ║\n",
            "║                                                                  ║\n",
            "║  Multiplayer:                                                    ║\n",
            "║  - O modo Multiplayer consiste em uma batalha entre 2 ou mais    ║\n",
            "║    jogadores onde os mesmos colocam palavras a serem acertadas   ║\n",
            "║    por seus adversários.                                         ║\n",
            "╠══════════════════════════════════════════════════════════════════╣\n",
            "║   Voltar ao menu, digite 0                                       ║\n",
            "╚══════════════════════════════════════════════════════════════════╝\n"
          };
     coresbeta.coresDegrade(regras);
        do{
            voltar = miau.nextInt();
            if(voltar!=0){
                sombeta.erroSom();
                String[] info = {"╔═════════════════════════════════════════════════════╗\n",
                                 "║                                                     ║\n",
                                 "║      Por favor informar o numero '0' para sair      ║\n",
                                 "║                                                     ║\n",
                                 "╚═════════════════════════════════════════════════════╝\n"};
                coresbeta.corvermelho(info);
                
            }
        }while(voltar!=0);
        sombeta.toqueSom();
        Menu();
    }

    
    
    
    /**
     * 
     */
   

   
    public static void telaCarregar(){
        int total = 50; // o tamanho que vai ser a tela de carregamento
      
        System.out.println("Carregando:");

        // Loop for para simular o carregamento
        for (int i = 0; i <= total; i++) {
           
            int porcentagem=0;
            // Limpa a linha anterior da barra de progresso
            System.out.print("\r");

            // Constrói a barra de progresso
            System.out.print("[");
            for (int j = 0; j < total; j++) {
                if (j < i) {
                    System.out.print("/");
                    porcentagem++; // Calcula a porcentagem de progresso
                } else {
                    System.out.print(" ");
                }
            }
           

            // Pausa para simular o carregamento
            try {
                Thread.sleep(50); // Pausa de 100 milissegundos (0,1 segundo)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("] " + porcentagem*2 + "%");
        }

        System.out.println("\nCarregamento completo!");
    }

    public static void Nomes(String[] nomes){
        sombeta.toque1Som();
        String[] info = {"╔═════════════════════════════════════════════════════╗\n",
                         "║                                                     ║\n",
                         "║          Agora vamos para as introduções            ║\n",
                         "║                                                     ║\n",
                         "╚═════════════════════════════════════════════════════╝"};
        coresbeta.coresDegrade(info);
        int conti = 1;
        for(int cont = 0;cont<jogadoresPresentes;cont++){
            String text = String.format(
                "╔═════════════════════════════════════════════════════╗\n" +
                "║                                                     ║\n" +
                "║             Jogador %d, qual o seu nome?             ║\n" +
                "║                                                     ║\n" +
                "╚═════════════════════════════════════════════════════╝\n", conti
            );
           coresbeta.coresDegradeText(text);
            nomes[cont] = miau.next();
            sombeta.toque1Som();
            conti++;
        }
        apagar();
    }

    
    public static void Palvras(String[] palavras,String[] nomes){
    
       
        System.out.println("Vamos escolher as palavras agora");
        for(int cont = 0;cont<jogadoresPresentes;cont++){
            System.out.printf("%s escolha uma palavra\n",nomes[cont]);
            palavras[cont] = miau.next();
            apagar();
          
        }
         
       
        
    }
   
    
    public static void music(){
         
       
    }
    public static void Jogadas(String[] Chute,String[] palavrasO,String[] nomes,int[] vencer){

        
        
       
        sombeta.somjogo();
       
        String tentativa = "";
        boolean venceu = false;
        int primJ = 0;
        do{
            for(int cont = 0;cont<jogadoresPresentes;cont++){
            
                
                inicializandoStringsChute(jogadoresPresentes,palavrasO , Chute, cont);

                if(primJ<2){
                    System.out.println(Chute[cont]);
                }
                
                System.out.printf("%s , de um chute\n",nomes[cont]);
                do{
                tentativa = miau.next();
                if(tentativa.length() != Chute[cont].length()){
                    System.out.printf("Porfavor, insira uma palavra com %d letras\n",palavrasO[cont].length());
                }
                }while(tentativa.length() != Chute[cont].length());
                
                atualizandoChuteFinal(palavrasO, tentativa, Chute, cont);
                
                exibirTentativa(palavrasO, tentativa, cont,vencer);
                System.out.println();
                
                venceu = VerVenc(palavrasO, tentativa, cont);
                if(venceu == true){
                    break;
                }
                primJ++;
            }
            
        } while(!venceu);
        
    }


    public static void embaralhar(String[] vetor){
        String[] verificação = Arrays.copyOfRange(vetor,0,jogadoresPresentes);
        for(int cont = 0;cont<jogadoresPresentes;cont++){
            do{
            int mudar = mew.nextInt(jogadoresPresentes);
            String aux = vetor[mudar];
            vetor[mudar] = vetor[cont];
            vetor[cont] = aux;
            }while(Ver(vetor, verificação, cont));
        }
            
        }

        public static boolean Ver(String[] ar1, String[] ar2,int pos){
            boolean igual = false;
            for(int cont = 0; cont<jogadoresPresentes;cont++){
                if(ar1[cont] == ar2[cont]){
                    igual = true;
                }
            }
            return igual;
        }

        public static boolean VerVenc(String[] orig, String tent, int jogadorDaVez){
            return orig[jogadorDaVez].equalsIgnoreCase(tent);
           
        }
  
        public static void inicializandoStringsChute(int jogadoresPresentes,String[] stringOrig, String[] stringChuteFinal, int jogadorDaVez){
            for (int i = 0; i < jogadoresPresentes; i++) {
                stringChuteFinal[i] = "";       
                for (int j = 0; j < stringOrig[jogadorDaVez].length(); j++){
                    stringChuteFinal[i] += "_";
                }     
            }
        }
        
        public static void atualizandoChuteFinal(String[] orig, String tent, String[] stringChuteFinal, int jogadorDaVez) {
            for (int i = 0; i < orig[jogadorDaVez].length(); i++) {
                if (orig[jogadorDaVez].charAt(i) == tent.charAt(i)) {
                    stringChuteFinal[jogadorDaVez] = substituirCharacter(stringChuteFinal[jogadorDaVez], i, tent.charAt(i));
                }
            }
        }
    
        public static void exibirTentativa(String[] orig, String tent, int jogadorDaVez,int[] vencer) {
            for (int i = 0; i < orig[jogadorDaVez].length(); i++) {
                if (orig[jogadorDaVez].charAt(i) == tent.charAt(i)) {
                    escrever(tent.charAt(i), "verde");
                }
                else if (orig[jogadorDaVez].contains(""+tent.charAt(i))){
                    escrever(tent.charAt(i), "amarelo");
                }else{
                    escrever(tent.charAt(i), "cinza");
                }
                if(i == (orig[jogadorDaVez].length())){
                }
            }
        }
    
        public static void escrever(char letra, String cor) {
            if (cor.equals("verde")) {
                System.out.printf("\u001b[32;1m" + letra + "\u001b[0m");
            }else if (cor.equals("amarelo")){
                System.out.printf("\u001b[33;1m" + letra + "\u001b[0m");
            }else{
                System.out.print("\u001b[0m" + "_");
            }
        }
    
        public static String substituirCharacter (String str, int index, char ch){
            str = str.substring(0, index) + ch
                  + str.substring(index + 1);
            return str;
        }
        public static void apagar(){
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        //começo alinhamento

        public static void align(String text) {
            align(text, "center", true, "");
        }
    
    
        public static void align(String text, String alignment) {
            align(text, alignment, true, "");
        }
    
    
        public static void align(String text, String alignment, boolean ln, String color) {
            int width = globalWidth;
            switch (alignment) {
                case "center" -> width *= 1;
                case "right" -> width *= 1.2;
                case "left" -> width *= 0;
                default -> width *= 1;
            }
            String space = " ";
            String transformText = space.repeat((alignment != "left") ? width - text.length() / 2 : width / 2) + text;
    
            if (ln == true)
                System.out.println(transformText);
            else
                System.out.print(transformText);
    
        }
       
    
       
        //final alinhamento
    


    }
        


    

