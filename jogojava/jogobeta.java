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
    public static String[] palavraSingle = new String[1];

    public static void main(String[] args) throws Exception {
        tocar = new Thread(() -> sombeta. GerenciadorSom.iniciarSomMenu()); // Inicialização do Thread
        tocar.start();
       
       
       
        Menu();
        
        
    
    }
    
    
    

    public static void Menu(){
         
        
         apagar();

        
        coresbeta.Logo();
       sombeta.toquedeintre();
        
        
 
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
       opções();

      
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

         String[] nomes = new String[jogadoresPresentes];
         String[] stringChute = new String[jogadoresPresentes];

         Nomes(nomes);
         dificuldade(nomes);
         Jogadas(stringChute, palavraSingle, nomes);
        

    }

    public static void Multiplayer(){
        
        JogadoresPresentes();

         String[] palavras = new String[jogadoresPresentes];
         String[] nomes = new String[jogadoresPresentes];
         String[] stringChute = new String[jogadoresPresentes];

        Nomes(nomes);
        Palvras(palavras,nomes);

       
        embaralhar(palavras);
      
        Jogadas(stringChute, palavras, nomes);
        
        

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
                "║             Jogador %d, qual o seu nome?            ║\n" +
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
    
        String[] pa ={"  ╔════════════════════════════════════════════════════════════╗ \n",
                      " ╔╝                                                            ╚╗\n",
                      " ║               Vamos escolher as palavras agora               ║\n",
                      " ╚╗                                                            ╔╝\n",
                      "  ╚════════════════════════════════════════════════════════════╝ \n"};
        coresbeta.coresDegrade(pa);
      
        for(int cont = 0;cont<jogadoresPresentes;cont++){
            String text1 = String.format(
                "              ╔════════════════════════════════════════════════════════════╗\n" +
                "             ╔╝                                                            ╚╗\n" +
                "             ║                     %s escolha uma palavra                   ║\n" +
                "             ╚╗                                                            ╔╝\n" +
                "              ╚════════════════════════════════════════════════════════════╝\n" ,nomes[cont]
            );
             
            coresbeta.coresDegradeText(text1);
            palavras[cont] = miau.next();
            sombeta.toque1Som();
            apagar();
          
        }
         
       
        
    }
   
    
    public static void music(){
         
       
    }
    public static void Jogadas(String[] Chute,String[] palavrasO,String[] nomes){
        sombeta.GerenciadorSom.pararSomMenu();
        tocar = new Thread(() -> sombeta.somjogo() ); // Inicialização do Thread
        tocar.start();
        
        String tentativa = "";
        boolean venceu = false;
        int primJ = 0;
        for(int cont = 0;cont<jogadoresPresentes;cont++){
            inicializandoStringsChute(jogadoresPresentes,palavrasO , Chute, cont);
        }
        do{
            for(int cont = 0;cont<jogadoresPresentes;cont++){
            

                if(primJ<jogadoresPresentes){
                    align(Chute[cont]);
                }else{
                    System.out.println(Chute[cont]);
                }
                
                String texte = String.format(
                    "              ╔════════════════════════════════════════════════════════════╗\n" +
                    "             ╔╝                                                            ╚╗\n" +
                    "             ║                     [%s , de um chute]                        ║\n" +
                    "             ╚╗                                                            ╔╝\n" +
                    "              ╚════════════════════════════════════════════════════════════╝\n" ,nomes[cont]
                );
                  coresbeta.coresDegradeText(texte);
                do{
                tentativa = miau.next();
                if(tentativa.length() != Chute[cont].length()){
                    String texte1 = String.format(
                        "              ╔════════════════════════════════════════════════════════════╗\n" +
                        "             ╔╝                                                            ╚╗\n" +
                        "             ║          Porfavor, insira uma palavra com %d letras           ║\n" +
                        "             ╚╗                                                            ╔╝\n" +
                        "              ╚════════════════════════════════════════════════════════════╝\n" ,palavrasO[cont].length()
                    );
                    coresbeta.coresDegradeText(texte1);
                }
                }while(tentativa.length() != Chute[cont].length());
                
                atualizandoChuteFinal(palavrasO, tentativa, Chute, cont);
                
                exibirTentativa(palavrasO, tentativa, cont);
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
    
        public static void exibirTentativa(String[] orig, String tent, int jogadorDaVez) {
            for (int i = 0; i < orig[jogadorDaVez].length(); i++) {
                if (orig[jogadorDaVez].charAt(i) == tent.charAt(i)) {
                    escrever(tent.charAt(i), "verde");
                    sombeta.acertoJogada();
                }
                else if (orig[jogadorDaVez].contains(""+tent.charAt(i))){
                    escrever(tent.charAt(i), "amarelo");
                    sombeta.maisOuMenosJogada();
                }else{
                    escrever(tent.charAt(i), "cinza");
                    sombeta.erroSom();
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

        public static void dificuldade(String[] nomes){

            int dificuldade = 0;

            System.out.println("Agora "+nomes[0]+" ,escolha a dificuldade");
            System.out.println("");
            System.out.println("1 - Facil");
            System.out.println("2 - Medio");
            System.out.println("3 - Dificil");
            System.out.println("4 - Muito dificil");
            System.out.println("0 - Voltar para o menu");

            do{
            dificuldade = miau.nextInt();
            if(dificuldade>4 || dificuldade<0){
                System.out.println("Valor não reconhecido, insira um valor valido");
            }    
            }while(dificuldade>4 || dificuldade<0);

            switch (dificuldade) {
                case 0:
                    Menu();
                    break;
            
                default:
                    BancoDePalavras(dificuldade);
                    break;
            }
        }

        public static void BancoDePalavras(int dificuldade){

            int palavra = mew.nextInt(30);

            
            String[] facil = new String[] {"bola","paz","não","mito","viés","rude","vil","sob","mal","ira","alvo","pose","ágil","tese","hera","azul","réu","mim","frio","dor","eis","voz","voga","arte","asco","rito","tela","jus","asa","rir"};
            String[] medio = new String[] {"assim","sobre","poder","moral","desde","justo","quiçá","inato","sonho","anexo","fútil","casal", "genro","ardil","coser","genro","sendo","xibiu","comun","denso","mesmo","vulgo","jeito","todos", "louco","apraz","cunho","pifio","certo","visar"};
            String[] dificil = new String[] {"empatia","exceção","inferir","hostil","legado","anseio","adorno","infame","aferir","astuto","solene","sucesso","emergir", "trivial", "deboche", "ensejo", "formal", "outrem", "dispor", "parcial", "piedade","conciso","padecer","eficaz","alçada", "modesto", "bizarro","mulher","desejo","buscar"};
            String[] muitodificil = new String[] {"genocida","prudente","iminente","deferido","abstrato","invasivo","reiterar","talarico","devaneio","relativo","conserto","fomentar","analogia","ativista","destarte","alicerce","despeito","proceder","portanto","primazia","sucumbir","consiste","demagogo","distinto","epifania","resoluto","problema","maestria","obetivo","insípido"};

            if(dificuldade == 1){
            palavraSingle[0] = facil[palavra];
            }else if(dificuldade == 2){
            palavraSingle[0] = medio[palavra];
            }else if(dificuldade == 3){
            palavraSingle[0] = dificil[palavra];    
            }else{
            palavraSingle[0] = muitodificil[palavra];    
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
        public static void aguardarEnter() {
            System.out.println("Pressione Enter para continuar...");
            
            miau.nextLine();
            sombeta.toquedeintre(); // Aguarda até que o usuário pressione Enter
        }
       
    
       
        //final alinhamento
    


    }
        


    

