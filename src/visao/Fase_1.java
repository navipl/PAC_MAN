/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Ivan
 */
public class Fase_1 extends javax.swing.JFrame {

    //variavel da posição X que será atualizada ao clicar na respectiva tecla direcional
    int posMnchX = 390;
    //variavel da posição Y que será atualizada ao clicar na respectiva tecla direcional
    int posMnchY = 390;

    //variavel da posição X que será atualizada ao clicar na respectiva tecla direcional
    int posRestosX = 40;
    //variavel da posição Y que será atualizada ao clicar na respectiva tecla direcional
    int posRestosY = 40;

    //variavel que determina qual resto do vetor esta sendo add no mapa
    int contResto = 0;
    //variavel que determina a pontuação do jogador
    int pontuacao = 0;

    int vida = 3;

    //Imagens usadas nas varias possições do personagem
    ImageIcon munchEsquerda = new ImageIcon(getClass().getResource("../img/munchlax_esquerda.png"));
    ImageIcon munchDireita = new ImageIcon(getClass().getResource("../img/munchlax_direita.png"));
    ImageIcon munchParadoEsquerda = new ImageIcon(getClass().getResource("../img/munchlax_parado.png"));
    ImageIcon munchCostasAndando = new ImageIcon(getClass().getResource("../img/munchlax_costas.png"));
    ImageIcon munchCostasParado = new ImageIcon(getClass().getResource("../img/munchlax_costas_parado.png"));
    ImageIcon munchParadoDireita = new ImageIcon(getClass().getResource("../img/munchlax_parado_direita.png"));

    //Imagens das frutas
    ImageIcon imgRestos = new ImageIcon(getClass().getResource("../img/restos.png"));
    ImageIcon imgDrasi = new ImageIcon(getClass().getResource("../img/drasi.png"));
    ImageIcon imgZreza = new ImageIcon(getClass().getResource("../img/zreza.png"));

    //Imagens das Paredes 
    ImageIcon arbusto100x40D = new ImageIcon(getClass().getResource("../img/arbusto_100x40D.png"));
    ImageIcon arbusto100x40E = new ImageIcon(getClass().getResource("../img/arbusto_100x40E.png"));
    ImageIcon arbusto120x40 = new ImageIcon(getClass().getResource("../img/arbusto_120x40.png"));
    ImageIcon arbusto120x407 = new ImageIcon(getClass().getResource("../img/arbusto_120x407.png"));
    ImageIcon arbusto120x40L = new ImageIcon(getClass().getResource("../img/arbusto_120x40L.png"));
    ImageIcon arbusto120x60 = new ImageIcon(getClass().getResource("../img/arbusto_120x60.png"));
    ImageIcon arbusto180x80D = new ImageIcon(getClass().getResource("../img/arbusto_180x80D.png"));
    ImageIcon arbusto180x80E = new ImageIcon(getClass().getResource("../img/arbusto_180x80E.png"));
    ImageIcon arbusto200x40 = new ImageIcon(getClass().getResource("../img/arbusto_200x40.png"));
    ImageIcon arbusto260x40D = new ImageIcon(getClass().getResource("../img/arbusto_260x40D.png"));
    ImageIcon arbusto260x40E = new ImageIcon(getClass().getResource("../img/arbusto_260x40E.png"));
    ImageIcon arbusto40x100A = new ImageIcon(getClass().getResource("../img/arbusto_40x100A.png"));
    ImageIcon arbusto40x100U = new ImageIcon(getClass().getResource("../img/arbusto_40x100U.png"));
    ImageIcon arbusto40x120A = new ImageIcon(getClass().getResource("../img/arbusto_40x120A.png"));
    ImageIcon arbusto40x260D = new ImageIcon(getClass().getResource("../img/arbusto_40x260D.png"));
    ImageIcon arbusto40x260E = new ImageIcon(getClass().getResource("../img/arbusto_40x260E.png"));
    ImageIcon arbusto40x40 = new ImageIcon(getClass().getResource("../img/arbusto_40x40.png"));
    ImageIcon arbusto40x80 = new ImageIcon(getClass().getResource("../img/arbusto_40x80.png"));
    ImageIcon arbusto60x60 = new ImageIcon(getClass().getResource("../img/arbusto_60x60.png"));
    ImageIcon arbusto80x40 = new ImageIcon(getClass().getResource("../img/arbusto_80x40.png"));
    ImageIcon arbusto80x60D = new ImageIcon(getClass().getResource("../img/arbusto_80x60D.png"));
    ImageIcon arbusto80x60E = new ImageIcon(getClass().getResource("../img/arbusto_80x60E.png"));
    ImageIcon arbusto200x80 = new ImageIcon(getClass().getResource("../img/arbusto_200x80.png"));
    ImageIcon linhaPorta = new ImageIcon(getClass().getResource("../img/linha.png"));

    //Imagens do Fundo
    ImageIcon floresta = new ImageIcon(getClass().getResource("../img/floresta.png"));

    //variavel para controlar a posse do personagem quando estiver parado
    int posseMunch;

    JLabel jLabelRestos[] = new JLabel[367];
    JLabel jLabelBlocos[] = new JLabel[33];
    JLabel jLabelDrasi[] = new JLabel[4];
    JLabel jLabelFundo = new JLabel();
    JLabel jLabelZreza = new JLabel();
    JLabel jLabelVidas[] = new JLabel[3];
    public JLabel jLabelLinhaFa = new JLabel();

    //Construtor do jogo
    public Fase_1() {
        initComponents();
        blocos();
        drasi();
        restos();
        zreza();
        vida();
        new Fantasma().start();
        new Fantasma2().start();
        new Fantasma3().start();
        new Fantasma4().start();
        teclado();
        fundo();

    }

    //Clase que gera o movimento do teclado para o personagem principal
    public void teclado() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                /*Tecla Precionada*/

                //Movimento para esquerda
                if (e.getKeyCode() == 37) {
                    jLabelMunch.setIcon(munchEsquerda);
                    posseMunch = 1;//Controlar aparencia do personagem parado

                    //Faz o personagem aparece do lado oposto no fim do labirinto
                    posMnchX = posEsquerda(jLabelMunch, posMnchX);
                }

                //Movimento para cima
                if (e.getKeyCode() == 38) {
                    jLabelMunch.setIcon(munchCostasAndando);
                    posseMunch = 2;//Controlar aparencia do personagem parado

                    posMnchY = posCima(jLabelMunch, posMnchY);

                } //Movimento para direita 
                else if (e.getKeyCode() == 39) {
                    jLabelMunch.setIcon(munchDireita);
                    posseMunch = 3;//Controlar aparencia do personagem parado

                    //Faz o personagem aparece do lado oposto no fim do labirinto
                    posMnchX = posDireita(jLabelMunch, posMnchX);

                } //Movimento para baixo 
                else if (e.getKeyCode() == 40) {
                    jLabelMunch.setIcon(munchEsquerda);
                    posseMunch = 4;//Controlar aparencia do personagem parado

                    posMnchY = posBaixo(jLabelMunch, posMnchY);
                }

                //Atualiza a possição do personagem no fim das comparações
                jLabelMunch.setBounds(posMnchX, posMnchY, jLabelMunch.getWidth(), jLabelMunch.getHeight());
                jLabelMunchBoca.setBounds(posMnchX + 10, posMnchY + 10, jLabelMunchBoca.getWidth(), jLabelMunchBoca.getHeight());

                //For que identifica posição do Munchilex e do resto referido para ocultar o resto e acumular os pontos
                for (int i = 0; i < 367; i++) {
                    if ((jLabelMunchBoca.getX() == jLabelRestos[i].getX()) && (jLabelMunchBoca.getY() == jLabelRestos[i].getY())) {
                        pontuacao += 10;
                        jLabelpontoJogo.setText(Integer.toString(pontuacao));
                        remove(jLabelRestos[i]);
                        jLabelRestos[i].setBounds(0, 0, 0, 0);
                    }
                }

                //For que identifica posição do Munchilex e do drasi referido para ocultar o drasi e exucultar a ação desejada
                for (int i = 0; i < 4; i++) {
                    if ((jLabelMunchBoca.getX() == jLabelDrasi[i].getX()) && (jLabelMunchBoca.getY() == jLabelDrasi[i].getY())) {
                        pontuacao += 100;
                        jLabelpontoJogo.setText(Integer.toString(pontuacao));
                        remove(jLabelDrasi[i]);
                        jLabelDrasi[i].setBounds(0, 0, 0, 0);
                    }
                }
                if (jLabelduskull.getX() == jLabelMunch.getX() & jLabelduskull.getY() == jLabelMunch.getX()) {
                    vida -= 1;
                    jLabelVidas[vida].setBounds(0, 0, 0, 0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {//Tecla não Precionada
                //determina a pose do personagem parado
                switch (posseMunch) {
                    case 1:
                        jLabelMunch.setIcon(munchParadoEsquerda);
                        break;

                    case 2:
                        jLabelMunch.setIcon(munchCostasParado);
                        break;

                    case 3:
                        jLabelMunch.setIcon(munchParadoDireita);
                        break;

                    case 4:
                        jLabelMunch.setIcon(munchParadoEsquerda);
                        break;
                }
            }
        });
    }

    //Metodo que posiciona os restos(maçã) no mapa
    public void restos() {
        for (int i = 0; i < 367; i++) {
            jLabelRestos[i] = new JLabel();
            jLabelRestos[i].setIcon(imgRestos);
        }

        for (int i = 40; i < 641; i = i + 20) {//Este For vai incrementar o valor de Y na possição do "resto"
            for (int j = 40; j < 761; j = j + 20) {//Este For vai incrementar o valor de X na possição do "resto"

                for (int l = 0; l < 4; l++) {//Este for vai pasar pelo Vetor que esta recebendo a Drasi(fruta fantasma
                    while (parede(jLabelRestos[contResto], jLabelDrasi[l]) == true) {//Enquanto o resto estiver encostando em uma drasi sua possição de X-j vai mudar
                        j += 20;
                        jLabelRestos[contResto].setBounds(j, i, 20, 20);
                    }
                }

                for (int k = 0; k < 33; k++) {//Este For vai percorrer o vetor dos blocos de parede
                    jLabelRestos[contResto].setBounds(j, i, 20, 20);
                    while (parede(jLabelRestos[contResto], jLabelBlocos[k]) == true) {//Enquanto o esto estiver encostando na parede do vetor expecificado o X-j vai mudar de posição
                        j += 20;
                        jLabelRestos[contResto].setBounds(j, i, 20, 20);
                    }
                }
                while (parede(jLabelRestos[contResto], jLabelMunch) == true) {//Enquanto o reto estiver encostando no Munchilex o X-j vai mudar de posição
                    j += 20;
                    jLabelRestos[contResto].setBounds(j, i, 20, 20);
                }

                if (j <= 760) {//Se depois das verificações o valor de X-j for medor que 760 que é a posição final de cada linha o resto será adicionado no mapa
                    add(jLabelRestos[contResto]);
                    contResto += 1;//Define qual resto do vetor será usado
                }
            }
        }
    }

    //Metodo que posiciona as Drasis(fruta fantasma) no mapa
    public void drasi() {
        for (int i = 0; i < 4; i++) {
            jLabelDrasi[i] = new JLabel();
        }
        //Como cada Drasi tem uma posição especifica foi precisso determinar manualmente a localisação de cada uma
        jLabelDrasi[0].setIcon(imgDrasi);
        jLabelDrasi[0].setBounds(40, 80, 20, 20);
        add(jLabelDrasi[0]);

        jLabelDrasi[1].setIcon(imgDrasi);
        jLabelDrasi[1].setBounds(760, 80, 20, 20);
        add(jLabelDrasi[1]);

        jLabelDrasi[2].setIcon(imgDrasi);
        jLabelDrasi[2].setBounds(100, 520, 20, 20);
        add(jLabelDrasi[2]);

        jLabelDrasi[3].setIcon(imgDrasi);
        jLabelDrasi[3].setBounds(700, 520, 20, 20);
        add(jLabelDrasi[3]);
    }

    //Metodo que posiciona o blocos de paredes no mapa
    public void blocos() {

        for (int i = 0; i < 33; i++) {
            jLabelBlocos[i] = new JLabel();
        }

        //Como cada Drasi tem uma posição especifica foi precisso determinar manualmente a localisação de cada uma
        jLabelBlocos[0].setIcon(arbusto120x60);
        jLabelBlocos[0].setBounds(70, 70, 120, 60);
        add(jLabelBlocos[0]);

        jLabelBlocos[1].setIcon(arbusto120x60);
        jLabelBlocos[1].setBounds(630, 70, 120, 60);
        add(jLabelBlocos[1]);

        jLabelBlocos[2].setIcon(arbusto120x40);
        jLabelBlocos[2].setBounds(70, 170, 120, 40);
        add(jLabelBlocos[2]);

        jLabelBlocos[3].setIcon(arbusto120x40);
        jLabelBlocos[3].setBounds(630, 170, 120, 40);
        add(jLabelBlocos[3]);

        jLabelBlocos[4].setIcon(arbusto40x260D);
        jLabelBlocos[4].setBounds(230, 70, 40, 260);
        add(jLabelBlocos[4]);

        jLabelBlocos[5].setIcon(arbusto40x260E);
        jLabelBlocos[5].setBounds(550, 70, 40, 260);
        add(jLabelBlocos[5]);

        jLabelBlocos[6].setIcon(arbusto100x40D);
        jLabelBlocos[6].setBounds(250, 230, 100, 40);
        add(jLabelBlocos[6]);

        jLabelBlocos[7].setIcon(arbusto100x40E);
        jLabelBlocos[7].setBounds(470, 230, 120, 40);
        add(jLabelBlocos[7]);

        jLabelBlocos[8].setIcon(arbusto40x40);
        jLabelBlocos[8].setBounds(310, 70, 40, 40);
        add(jLabelBlocos[8]);

        jLabelBlocos[9].setIcon(arbusto40x40);
        jLabelBlocos[9].setBounds(470, 70, 40, 40);
        add(jLabelBlocos[9]);

        jLabelBlocos[10].setIcon(arbusto40x100U);
        jLabelBlocos[10].setBounds(390, 10, 40, 100);
        add(jLabelBlocos[10]);

        jLabelBlocos[11].setIcon(arbusto200x40);
        jLabelBlocos[11].setBounds(310, 150, 200, 40);
        add(jLabelBlocos[11]);

        jLabelBlocos[12].setIcon(arbusto40x100U);
        jLabelBlocos[12].setBounds(390, 170, 40, 100);
        add(jLabelBlocos[12]);

        jLabelBlocos[13].setIcon(arbusto180x80E);
        jLabelBlocos[13].setBounds(10, 250, 180, 80);
        add(jLabelBlocos[13]);

        jLabelBlocos[14].setIcon(arbusto180x80D);
        jLabelBlocos[14].setBounds(630, 250, 180, 80);
        add(jLabelBlocos[14]);

        jLabelBlocos[15].setIcon(arbusto180x80E);
        jLabelBlocos[15].setBounds(10, 370, 180, 80);
        add(jLabelBlocos[15]);

        jLabelBlocos[16].setIcon(arbusto180x80D);
        jLabelBlocos[16].setBounds(630, 370, 180, 80);
        add(jLabelBlocos[16]);

        jLabelBlocos[17].setIcon(arbusto40x80);
        jLabelBlocos[17].setBounds(230, 370, 40, 80);
        add(jLabelBlocos[17]);

        jLabelBlocos[18].setIcon(arbusto40x80);
        jLabelBlocos[18].setBounds(550, 370, 40, 80);
        add(jLabelBlocos[18]);

        jLabelBlocos[19].setIcon(arbusto80x60D);
        jLabelBlocos[19].setBounds(10, 490, 80, 60);
        add(jLabelBlocos[19]);

        jLabelBlocos[20].setIcon(arbusto80x60E);
        jLabelBlocos[20].setBounds(730, 490, 80, 60);
        add(jLabelBlocos[20]);

        jLabelBlocos[21].setIcon(arbusto60x60);
        jLabelBlocos[21].setBounds(130, 490, 60, 60);
        add(jLabelBlocos[21]);

        jLabelBlocos[22].setIcon(arbusto60x60);
        jLabelBlocos[22].setBounds(630, 490, 60, 60);
        add(jLabelBlocos[22]);

        jLabelBlocos[23].setIcon(arbusto260x40D);
        jLabelBlocos[23].setBounds(70, 590, 260, 40);
        add(jLabelBlocos[23]);

        jLabelBlocos[24].setIcon(arbusto260x40E);
        jLabelBlocos[24].setBounds(490, 590, 260, 40);
        add(jLabelBlocos[24]);

        jLabelBlocos[25].setIcon(arbusto120x40L);
        jLabelBlocos[25].setBounds(310, 510, 120, 40);
        add(jLabelBlocos[25]);

        jLabelBlocos[26].setIcon(arbusto120x407);
        jLabelBlocos[26].setBounds(390, 430, 120, 40);
        add(jLabelBlocos[26]);

        jLabelBlocos[27].setIcon(arbusto40x100A);
        jLabelBlocos[27].setBounds(310, 430, 40, 100);
        add(jLabelBlocos[27]);

        jLabelBlocos[28].setIcon(arbusto40x100U);
        jLabelBlocos[28].setBounds(470, 450, 40, 100);
        add(jLabelBlocos[28]);

        jLabelBlocos[29].setIcon(arbusto40x120A);
        jLabelBlocos[29].setBounds(230, 490, 40, 120);
        add(jLabelBlocos[29]);

        jLabelBlocos[30].setIcon(arbusto40x120A);
        jLabelBlocos[30].setBounds(550, 490, 40, 120);
        add(jLabelBlocos[30]);

        jLabelBlocos[31].setIcon(arbusto80x40);
        jLabelBlocos[31].setBounds(370, 590, 80, 40);
        add(jLabelBlocos[31]);

        //Bloco referente a casa dos fantasmas
        jLabelBlocos[32].setIcon(arbusto200x80);
        jLabelBlocos[32].setBounds(310, 310, 200, 80);
        add(jLabelBlocos[32]);

        jLabelLinhaFa = new JLabel();
        jLabelLinhaFa.setIcon(linhaPorta);
        jLabelLinhaFa.setBounds(370, 317, 80, 5);
        add(jLabelLinhaFa);
    }

    //Metodo que posiciona o plano de fundo no mapa
    public void fundo() {
        jLabelFundo.setIcon(floresta);
        jLabelFundo.setBounds(0, 0, 1020, 720);
        add(jLabelFundo);
    }

    public void vida() {
        int posEncremento = 0;
        for (int i = 0; i < 3; i++) {
            jLabelVidas[i] = new JLabel();
            jLabelVidas[i].setIcon(munchEsquerda);
            jLabelVidas[i].setBounds(840, 440 + posEncremento, 40, 40);
            add(jLabelVidas[i]);
            posEncremento += 40;
        }

    }

    /*Metodo que define o tempo de espera de um objeto*/
 /* public class fantasmas extends Thread{
        public void run() {
            while (true) {                
                try {
                Thread.sleep(300);
            } catch (Exception ex) {}
                if (jLabelduskull.getX() < jLabelMunch.getX()) {
                     jLabelduskull.setBounds(jLabelduskull.getX()+20 , jLabelduskull.getY(), 40, 40);
                }
                
                else if (jLabelduskull.getX() > jLabelMunch.getX()) {
                     jLabelduskull.setBounds(jLabelduskull.getX()-20 , jLabelduskull.getY(), 40, 40);
                }
                
                else if (jLabelduskull.getY() < jLabelMunch.getY()) {
                     jLabelduskull.setBounds(jLabelduskull.getX() , jLabelduskull.getY() + 20, 40, 40);
                }
                
                else if (jLabelduskull.getY() > jLabelMunch.getY()) {
                     jLabelduskull.setBounds(jLabelduskull.getY(), jLabelduskull.getY() - 20, 40, 40);
                }
                
                
               
            }
            
        }
    }*/
    //Metodo para exibir Zreza(Cereja)
    public void zreza() {
        jLabelZreza = new JLabel();
        jLabelZreza.setIcon(imgZreza);
        jLabelZreza.setBounds(0, 0, 0, 0);
        add(jLabelZreza);

    }

    /*Pesquisar como aplicar essa fonte que foi criada
    public void font( int tamanhpo) {
        try{
            InputStream fontStream = getClass().getResourceAsStream("../fontes/pokemonDPPt.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            font = font.deriveFont(Font.PLAIN, tamanhpo);
            fontStream.close();
            
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }*/
 /*No mapa existem varias esquinas em que os fantasmas devem decidir qual direção tomar,
    esta função define em que posição no mapa o fantasma esta e marca o ponto que ele pasou
    com a variavel DIR para definir no loop se ele continua em sua trilha ou se esta trilha sofre auteração*/
    public int controleDirecional(JLabel label, int dir) {
        //Ponto em que o direcional recebe o valor 0
        if (label.getX() == 30 && label.getY() == 30) {
            dir = 0;
        } else if (label.getX() == 270 & label.getY() == 30) {
            dir = 0;
        } else if (label.getX() == 510 & label.getY() == 30) {
            dir = 0;
        } else if (label.getX() == 750 & label.getY() == 30) {
            dir = 0;
        } else if (label.getX() == 590 & label.getY() == 130) {
            dir = 0;
        } else if (label.getX() == 430 & label.getY() == 110) {
            dir = 0;
        } else if (label.getX() == 350 & label.getY() == 110) {
            dir = 0;
        } else if (label.getX() == 190 & label.getY() == 130) {
            dir = 0;
        } else if (label.getX() == 30 & label.getY() == 210) {
            dir = 0;
        } else if (label.getX() == 270 & label.getY() == 190) {
            dir = 0;
        } else if (label.getX() == 510 & label.getY() == 190) {
            dir = 0;
        } else if (label.getX() == 750 & label.getY() == 210) {
            dir = 0;
        } else if (label.getX() == 430 & label.getY() == 270) {
            dir = 0;
        } else if (label.getX() == 350 & label.getY() == 270) {
            dir = 0;
        } else if (label.getX() == 270 & label.getY() == 330) {
            dir = 0;
        } else if (label.getX() == 390 & label.getY() == 330) {
            dir = 0;
        } else if (label.getX() == 510 & label.getY() == 330) {
            dir = 0;
        } else if (label.getX() == 350 & label.getY() == 390) {
            dir = 0;
        } else if (label.getX() == 90 & label.getY() == 450) {
            dir = 0;
        } else if (label.getX() == 270 & label.getY() == 450) {
            dir = 0;
        } else if (label.getX() == 430 & label.getY() == 470) {
            dir = 0;
        } else if (label.getX() == 510 & label.getY() == 450) {
            dir = 0;
        } else if (label.getX() == 690 & label.getY() == 450) {
            dir = 0;
        } else if (label.getX() == 750 & label.getY() == 550) {
            dir = 0;
        } else if (label.getX() == 590 & label.getY() == 550) {
            dir = 0;
        } else if (label.getX() == 450 & label.getY() == 550) {
            dir = 0;
        } else if (label.getX() == 330 & label.getY() == 550) {
            dir = 0;
        } else if (label.getX() == 190 & label.getY() == 500) {
            dir = 0;
        } else if (label.getX() == 30 & label.getY() == 550) {
            dir = 0;
        }
        //Ponto em que o direcional recebe o valor 1 
        if (label.getX() == 190 & label.getY() == 30) {
            dir = 1;
        } else if (label.getX() == 350 & label.getY() == 30) {
            dir = 1;
        } else if (label.getX() == 400 & label.getY() == 30) {
            dir = 1;
        } else if (label.getX() == 590 & label.getY() == 30) {
            dir = 1;
        } else if (label.getX() == 30 & label.getY() == 130) {
            dir = 1;
        } else if (label.getX() == 270 & label.getY() == 110) {
            dir = 1;
        } else if (label.getX() == 510 & label.getY() == 110) {
            dir = 1;
        } else if (label.getX() == 750 & label.getY() == 130) {
            dir = 1;
        } else if (label.getX() == 190 & label.getY() == 210) {
            dir = 1;
        } else if (label.getX() == 350 & label.getY() == 190) {
            dir = 1;
        } else if (label.getX() == 430 & label.getY() == 190) {
            dir = 1;
        } else if (label.getX() == 590 & label.getY() == 210) {
            dir = 1;
        } else if (label.getX() == 270 & label.getY() == 270) {
            dir = 1;
        } else if (label.getX() == 390 & label.getY() == 270) {
            dir = 1;
        } else if (label.getX() == 510 & label.getY() == 270) {
            dir = 1;
        } else if (label.getX() == 330 & label.getY() == 330) {
            dir = 1;
        } else if (label.getX() == 450 & label.getY() == 330) {
            dir = 1;
        } else if (label.getX() == 770 & label.getY() == 330) {//obsssssssssssssssssssssssssssssssssssssss
            dir = 1;
        } else if (label.getX() == 270 & label.getY() == 390) {
            dir = 1;
        } else if (label.getX() == 510 & label.getY() == 390) {
            dir = 1;
        } else if (label.getX() == 30 & label.getY() == 450) {
            dir = 1;
        } else if (label.getX() == 190 & label.getY() == 450) {
            dir = 1;
        } else if (label.getX() == 350 & label.getY() == 470) {
            dir = 1;
        } else if (label.getX() == 590 & label.getY() == 450) {
            dir = 1;
        } else if (label.getX() == 750 & label.getY() == 450) {
            dir = 1;
        } else if (label.getX() == 90 & label.getY() == 550) {
            dir = 1;
        } else if (label.getX() == 270 & label.getY() == 550) {
            dir = 1;
        } else if (label.getX() == 430 & label.getY() == 550) {
            dir = 1;
        } else if (label.getX() == 510 & label.getY() == 550) {
            dir = 1;
        } else if (label.getX() == 690 & label.getY() == 550) {
            dir = 1;
        } else if (label.getX() == 330 & label.getY() == 630) {
            dir = 1;
        } else if (label.getX() == 750 & label.getY() == 630) {
            dir = 1;
        }

        //Ponto em que o direcional recebe o valor 2
        if (label.getX() == 190 & label.getY() == 330) {
            dir = 2;
        } else if (label.getX() == 590 & label.getY() == 330) {
            dir = 2;
        } else if (label.getX() == 30 & label.getY() == 630) {
            dir = 2;
        } else if (label.getX() == 450 & label.getY() == 630) {
            dir = 2;
        }

        return dir;
    }
//função que verifica bloqueios a esquerda e encrmente 20px referente a um paso
    public int posEsquerda(JLabel labelEsq, int posX) {
        //Bloqueiam as paredes dos movimentos a esquerda
        if (labelEsq.getX() == -10) {
            posX = 770;
        } else if (parede(labelEsq, jLabelLinhaFa) == true) {//Entrada da casa do fantasma
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeFa2) == true) {//Paredes casa do fantasma
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeFa10) == true) {//Paredes casa do fantasma
            posX = labelEsq.getX();

        } else if (parede(labelEsq, jLabelparedeLa6) == true) {//Paredes laterais
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeLa2) == true) {//Paredes laterais
            posX = labelEsq.getX();

        } else if (parede(labelEsq, jLabelparedeIv1) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv4) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv7) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv11) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv24) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv30) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv31) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv13) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv16) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv5) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv38) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv35) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv21) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv15) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv48) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv52) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv77) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv53) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv55) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv58) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv66) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv67) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv61) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv71) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv87) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv83) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, jLabelparedeIv89) == true) {
            posX = labelEsq.getX();
        } //Movimento para a Esquerda casso não hajá paredes 
        else {
            posX -= 20;
        }

        return posX;
    }

    public int posCima(JLabel labelCim, int posY) {
        //Bloqueiam as paredes dos movimentos para cima
        if (parede(labelCim, jLabelparedeFa1) == true) {//Paredes casa do fantasma
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeFa6) == true) {//Paredes casa do fantasma
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeFa7) == true) {//Paredes casa do fantasma
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv68) == true) {//Paredes laterais
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv84) == true) {//Paredes laterais
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeLa5) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv34) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv39) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv40) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv43) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv3) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv2) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv8) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv22) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv12) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv33) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv28) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv19) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv14) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv27) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv10) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv6) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv17) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv46) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv50) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv76) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv56) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv59) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv63) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv74) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv70) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv88) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, jLabelparedeIv80) == true) {
            posY = labelCim.getY();
        } //Movimento para Cima casso não hajá paredes 
        else {
            posY -= 20;
        }

        return posY;

    }

    public int posDireita(JLabel labelDir, int posX) {
        //Bloqueiam as paredes dos movimentos a direita
        if (labelDir.getX() == 790) {
            posX = 10;
        } else if (parede(labelDir, jLabelLinhaFa) == true) {//Entrada da casa do fantasma
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeFa4) == true) {//Paredes casa do fantasma
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeFa9) == true) {//Paredes casa do fantasma
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeLa4) == true) {//Paredes laterais
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeLa1) == true) {//Paredes laterais
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv44) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv41) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv16) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv5) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv13) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv29) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv31) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv11) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv18) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv4) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv20) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv9) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv25) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv1) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv47) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv51) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv53) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv57) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv58) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv65) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv73) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv72) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv61) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv83) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv86) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv89) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, jLabelparedeIv81) == true) {
            posX = labelDir.getX();
        } //Movimento para a Direita casso não hajá paredes 
        else {
            posX += 20;
        }

        return posX;

    }

    public int posBaixo(JLabel labelBai, int posY) {
        //Bloqueia a casa dos fantasma para o personagem principal
        if (parede(labelBai, jLabelLinhaFa) == true) {
            posY = labelBai.getY();
        } //bloqueia as paredes dos movimentos para baixo
        else if (parede(labelBai, jLabelparedeFa5) == true) {//Paredes casa do fantasma
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeFa3) == true) {//Paredes casa do fantasma
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeFa8) == true) {//Paredes casa do fantasma
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeLa3) == true) {//Paredes laterais
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv36) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv37) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv42) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv45) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv3) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv2) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv8) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv12) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv23) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv32) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv14) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv26) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv10) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv17) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv6) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv46) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv50) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv75) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv56) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv54) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv69) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv64) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv78) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv62) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv85) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv82) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv88) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv79) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, jLabelparedeIv60) == true) {
            posY = labelBai.getY();
        } //Movimento para Baixo casso não hajá paredes 
        else {
            posY += 20;
        }

        return posY;

    }

    //Classe que determina colisão entre dois objetos do jogo
    public boolean parede(Component a, Component b) {
        int aX = a.getX();
        int aY = a.getY();
        int ladoDireitoA = aX + a.getWidth();
        int ladoEsquerdoA = aX;
        int ladoBaixoA = aY + a.getHeight();
        int ladoCimaA = aY;

        int bX = b.getX();
        int bY = b.getY();
        int ladoDireitoB = bX + b.getWidth();
        int ladoEsquerdoB = bX;
        int ladoBaixoB = bY + b.getHeight();
        int ladoCimaB = bY;

        boolean bateu = false;

        boolean cDireita = false;
        boolean cCima = false;
        boolean cBaixo = false;
        boolean cEsquerda = false;

        if (ladoDireitoA >= ladoEsquerdoB) {
            cDireita = true;
            
        }
        if (ladoCimaA <= ladoBaixoB) {
            cCima = true;
            
        }
        if (ladoBaixoA >= ladoCimaB) {
            cBaixo = true;
            
        }
        if (ladoEsquerdoA <= ladoDireitoB) {
            cEsquerda = true;
            
        }
        if (cDireita && cEsquerda && cBaixo && cCima) {
            bateu = true;
        }

        return bateu;

    }

   public class Fantasma extends Thread {

        //Metodo que gera o movimento do DUSKULL
        public void run() {
            int duskX = jLabelduskull.getX();//variavel que define a poosição X do personagem
            int duskY = jLabelduskull.getY();//variavel que define a poosição Y do personagem
            int sort = new Random().nextInt(2);//variavel que sorteia para qual direção o personagem vai andar
            int xAnt;
            int yAnt;

            /*Variavel muito importante, esta relacionada a Função controleDirecional ela vai identificar
            finalizar o loop de movimento e garantir que ele inicie novamente com uma direção diferente*/
            int duskControle = 4;

            /*Variavel muito importante, esta relacionada a Função controleDirecional ela vai receber o valor que o 
            duskControle tinha antes de entrar no loop, enquanto elas forem iguais o loop continua, caso segem diferentes
            o loop finaliza uma nova direção é recebida*/
            int duskAnt = 0;

            //Esse loop é infinito, ele vai garantir que o personagem continue em movimento
            while (true) {

                //Esse é o loop inicial, onde os personegem só podem ir para a esquerda e deireita
                while (duskControle == 4) {
                    //este condicional define qual numero foi sorteado para manter o encremento para a direita ou esquerda
                    switch (sort) {
                        case 0:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente 
                            duskX = posEsquerda(jLabelduskull, duskX);

                            break;

                        case 1:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            duskX = posDireita(jLabelduskull, duskX);

                            break;
                    }

                    //Esta condicional define se o personagem modou de posição, caso não ele sorteia uma nova direção
                    if (jLabelduskull.getX() == duskX && jLabelduskull.getY() == duskY) {
                        sort = new Random().nextInt(2);
                    } else {
                        try {
                            Thread.sleep(100); // Tempo de espera antes do proximo passo
                        } catch (Exception ex) {
                        }

                    }
                    //Inicio do metodo para verificar as direções que o personagem pode tomar

                    duskControle = controleDirecional(jLabelduskull, duskControle);

                    //A possição do personagem é atualizada
                    jLabelduskull.setBounds(duskX, duskY, jLabelduskull.getWidth(), jLabelduskull.getHeight());
                }

                duskAnt = duskControle;
                sort = new Random().nextInt(4);
                int i = sort;

                //A partir deste loop o personagem pode asumir qualquer direção
                while (duskControle == duskAnt) {
                    //xAnt = jLabelduskull.getX();
                    //yAnt = jLabelduskull.getY();
                    switch (sort) {

                        case 0:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            duskX = posEsquerda(jLabelduskull, duskX);

                            break;

                        case 1:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            duskX = posDireita(jLabelduskull, duskX);

                            break;

                        case 2:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            duskY = posCima(jLabelduskull, duskY);

                            break;

                        case 3:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            duskY = posBaixo(jLabelduskull, duskY);

                            break;
                    }

                    //Esta condicional define se o personagem modou de posição, caso não ele sorteia uma nova direção
                    if (jLabelduskull.getX() == duskX & jLabelduskull.getY() == duskY) {
                        sort = new Random().nextInt(4);
                    } //if (jLabelduskull.getX() == xAnt & jLabelduskull.getY() == yAnt) {
                    //   sort = new Random().nextInt(4);   
                    // }
                    else {
                        try {
                            Thread.sleep(300);// Tempo de espera antes do proximo passo
                        } catch (Exception ex) {
                        }

                    }

                    //A possição do personagem é atualizada
                    jLabelduskull.setBounds(duskX, duskY, jLabelduskull.getWidth(), jLabelduskull.getHeight());
                    //System.out.println(sort + "-" + duskControle + "=" + duskAnt + "-" + jLabelduskull.getX() + "-" + jLabelduskull.getY());

                    if (jLabelduskull.getX() == jLabelMunch.getX() & jLabelduskull.getY() == jLabelMunch.getX()) {
                        vida -= 1;
                        jLabelVidas[vida].setBounds(0, 0, 0, 0);
                    }

                    //Inicio do metodo para verificar as direções que o personagem pode tomar
                    duskControle = controleDirecional(jLabelduskull, duskControle);

                }

            }

        }

    }

    public class Fantasma2 extends Thread {

        //Metodo que gera o movimento do DUSKULL
        public void run() {
            int gastX = jLabelgastly.getX();//variavel que define a poosição X do personagem
            int gastY = jLabelgastly.getY();//variavel que define a poosição Y do personagem
            int sort = new Random().nextInt(2);//variavel que sorteia para qual direção o personagem vai andar
            int xAnt;
            int yAnt;

            /*Variavel muito importante, esta relacionada a Função controleDirecional ela vai identificar
            finalizar o loop de movimento e garantir que ele inicie novamente com uma direção diferente*/
            int gastkControle = 4;

            /*Variavel muito importante, esta relacionada a Função controleDirecional ela vai receber o valor que o 
            duskControle tinha antes de entrar no loop, enquanto elas forem iguais o loop continua, caso segem diferentes
            o loop finaliza uma nova direção é recebida*/
            int gastkAnt = 0;

            //Esse loop é infinito, ele vai garantir que o personagem continue em movimento
            while (true) {

                //Esse é o loop inicial, onde os personegem só podem ir para a esquerda e deireita
                while (gastkControle == 4) {
                    //este condicional define qual numero foi sorteado para manter o encremento para a direita ou esquerda
                    switch (sort) {
                        case 0:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente 
                            gastX = posEsquerda(jLabelgastly, gastX);

                            break;

                        case 1:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            gastX = posDireita(jLabelgastly, gastX);

                            break;
                    }

                    //Esta condicional define se o personagem modou de posição, caso não ele sorteia uma nova direção
                    if (jLabelgastly.getX() == gastX && jLabelgastly.getY() == gastY) {
                        sort = new Random().nextInt(2);
                    } else {
                        try {
                            Thread.sleep(100); // Tempo de espera antes do proximo passo
                        } catch (Exception ex) {
                        }

                    }
                    //Inicio do metodo para verificar as direções que o personagem pode tomar

                    gastkControle = controleDirecional(jLabelgastly, gastkControle);

                    //A possição do personagem é atualizada
                    jLabelgastly.setBounds(gastX, gastY, jLabelgastly.getWidth(), jLabelgastly.getHeight());
                }

                gastkAnt = gastkControle;
                sort = new Random().nextInt(4);
                int i = sort;

                //A partir deste loop o personagem pode asumir qualquer direção
                while (gastkControle == gastkAnt) {
                    //xAnt = jLabelduskull.getX();
                    //yAnt = jLabelduskull.getY();
                    switch (sort) {

                        case 0:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            gastX = posEsquerda(jLabelgastly, gastX);

                            break;

                        case 1:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            gastX = posDireita(jLabelgastly, gastX);

                            break;

                        case 2:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            gastY = posCima(jLabelgastly, gastY);

                            break;

                        case 3:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            gastY = posBaixo(jLabelgastly, gastY);

                            break;
                    }

                    //Esta condicional define se o personagem modou de posição, caso não ele sorteia uma nova direção
                    if (jLabelgastly.getX() == gastX & jLabelgastly.getY() == gastY) {
                        sort = new Random().nextInt(4);
                    } //if (jLabelduskull.getX() == xAnt & jLabelduskull.getY() == yAnt) {
                    //   sort = new Random().nextInt(4);   
                    // }
                    else {
                        try {
                            Thread.sleep(300);// Tempo de espera antes do proximo passo
                        } catch (Exception ex) {
                        }

                    }

                    //A possição do personagem é atualizada
                    jLabelgastly.setBounds(gastX, gastY, jLabelgastly.getWidth(), jLabelgastly.getHeight());
                    //System.out.println(sort + "-" + duskControle + "=" + duskAnt + "-" + jLabelduskull.getX() + "-" + jLabelduskull.getY());

                    if (jLabelgastly.getX() == jLabelMunch.getX() & jLabelgastly.getY() == jLabelMunch.getX()) {
                        vida -= 1;
                        jLabelVidas[vida].setBounds(0, 0, 0, 0);
                    }

                    //Inicio do metodo para verificar as direções que o personagem pode tomar
                    gastkControle = controleDirecional(jLabelduskull, gastkControle);

                }

            }

        }

    }

    public class Fantasma3 extends Thread {

        //Metodo que gera o movimento do DUSKULL
        public void run() {
            int misdX = jLabelmisdreavus.getX();//variavel que define a poosição X do personagem
            int misdY = jLabelmisdreavus.getY();//variavel que define a poosição Y do personagem
            int sort = new Random().nextInt(2);//variavel que sorteia para qual direção o personagem vai andar
            int xAnt;
            int yAnt;

            /*Variavel muito importante, esta relacionada a Função controleDirecional ela vai identificar
            finalizar o loop de movimento e garantir que ele inicie novamente com uma direção diferente*/
            int misdControle = 4;

            /*Variavel muito importante, esta relacionada a Função controleDirecional ela vai receber o valor que o 
            duskControle tinha antes de entrar no loop, enquanto elas forem iguais o loop continua, caso segem diferentes
            o loop finaliza uma nova direção é recebida*/
            int misdAnt = 0;

            //Esse loop é infinito, ele vai garantir que o personagem continue em movimento
            while (true) {

                //Esse é o loop inicial, onde os personegem só podem ir para a esquerda e deireita
                while (misdControle == 4) {
                    //este condicional define qual numero foi sorteado para manter o encremento para a direita ou esquerda
                    switch (sort) {
                        case 0:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente 
                            misdX = posEsquerda(jLabelmisdreavus, misdX);

                            break;

                        case 1:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            misdX = posDireita(jLabelmisdreavus, misdX);

                            break;
                    }

                    //Esta condicional define se o personagem modou de posição, caso não ele sorteia uma nova direção
                    if (jLabelmisdreavus.getX() == misdX && jLabelmisdreavus.getY() == misdY) {
                        sort = new Random().nextInt(2);
                    } else {
                        try {
                            Thread.sleep(100); // Tempo de espera antes do proximo passo
                        } catch (Exception ex) {
                        }

                    }
                    //Inicio do metodo para verificar as direções que o personagem pode tomar

                    misdControle = controleDirecional(jLabelmisdreavus, misdControle);

                    //A possição do personagem é atualizada
                    jLabelmisdreavus.setBounds(misdX, misdY, jLabelmisdreavus.getWidth(), jLabelmisdreavus.getHeight());
                }

                misdAnt = misdControle;
                sort = new Random().nextInt(4);
                int i = sort;

                //A partir deste loop o personagem pode asumir qualquer direção
                while (misdControle == misdAnt) {
                    //xAnt = jLabelduskull.getX();
                    //yAnt = jLabelduskull.getY();
                    switch (sort) {

                        case 0:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            misdX = posEsquerda(jLabelmisdreavus, misdX);

                            break;

                        case 1:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            misdX = posDireita(jLabelmisdreavus, misdX);

                            break;

                        case 2:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            misdY = posCima(jLabelmisdreavus, misdY);

                            break;

                        case 3:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            misdY = posBaixo(jLabelmisdreavus, misdY);

                            break;
                    }

                    //Esta condicional define se o personagem modou de posição, caso não ele sorteia uma nova direção
                    if (jLabelmisdreavus.getX() == misdX & jLabelmisdreavus.getY() == misdY) {
                        sort = new Random().nextInt(4);
                    } //if (jLabelduskull.getX() == xAnt & jLabelduskull.getY() == yAnt) {
                    //   sort = new Random().nextInt(4);   
                    // }
                    else {
                        try {
                            Thread.sleep(300);// Tempo de espera antes do proximo passo
                        } catch (Exception ex) {
                        }

                    }

                    //A possição do personagem é atualizada
                    jLabelmisdreavus.setBounds(misdX, misdY, jLabelmisdreavus.getWidth(), jLabelmisdreavus.getHeight());
                    //System.out.println(sort + "-" + duskControle + "=" + duskAnt + "-" + jLabelduskull.getX() + "-" + jLabelduskull.getY());

                    if (jLabelmisdreavus.getX() == jLabelMunch.getX() & jLabelmisdreavus.getY() == jLabelMunch.getX()) {
                        vida -= 1;
                        jLabelVidas[vida].setBounds(0, 0, 0, 0);
                    }

                    //Inicio do metodo para verificar as direções que o personagem pode tomar
                    misdControle = controleDirecional(jLabelmisdreavus, misdControle);

                }

            }

        }

    }

    public class Fantasma4 extends Thread {

        //Metodo que gera o movimento do DUSKULL
        public void run() {
            int shupX = jLabelshuppet.getX();//variavel que define a poosição X do personagem
            int shupY = jLabelshuppet.getY();//variavel que define a poosição Y do personagem
            int sort = new Random().nextInt(2);//variavel que sorteia para qual direção o personagem vai andar
            int xAnt;
            int yAnt;

            /*Variavel muito importante, esta relacionada a Função controleDirecional ela vai identificar
            finalizar o loop de movimento e garantir que ele inicie novamente com uma direção diferente*/
            int shupControle = 4;

            /*Variavel muito importante, esta relacionada a Função controleDirecional ela vai receber o valor que o 
            duskControle tinha antes de entrar no loop, enquanto elas forem iguais o loop continua, caso segem diferentes
            o loop finaliza uma nova direção é recebida*/
            int shupAnt = 0;

            //Esse loop é infinito, ele vai garantir que o personagem continue em movimento
            while (true) {

                //Esse é o loop inicial, onde os personegem só podem ir para a esquerda e deireita
                while (shupControle == 4) {
                    //este condicional define qual numero foi sorteado para manter o encremento para a direita ou esquerda
                    switch (sort) {
                        case 0:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente 
                            shupX = posEsquerda(jLabelshuppet, shupX);

                            break;

                        case 1:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            shupX = posDireita(jLabelshuppet, shupX);

                            break;
                    }

                    //Esta condicional define se o personagem modou de posição, caso não ele sorteia uma nova direção
                    if (jLabelshuppet.getX() == shupX && jLabelshuppet.getY() == shupY) {
                        sort = new Random().nextInt(2);
                    } else {
                        try {
                            Thread.sleep(100); // Tempo de espera antes do proximo passo
                        } catch (Exception ex) {
                        }

                    }
                    //Inicio do metodo para verificar as direções que o personagem pode tomar

                    shupControle = controleDirecional(jLabelshuppet, shupControle);

                    //A possição do personagem é atualizada
                    jLabelshuppet.setBounds(shupX, shupY, jLabelshuppet.getWidth(), jLabelshuppet.getHeight());
                }

                shupAnt = shupControle;
                sort = new Random().nextInt(4);
                int i = sort;

                //A partir deste loop o personagem pode asumir qualquer direção
                while (shupControle == shupAnt) {
                    //xAnt = jLabelduskull.getX();
                    //yAnt = jLabelduskull.getY();
                    switch (sort) {

                        case 0:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            shupX = posEsquerda(jLabelshuppet, shupX);

                            break;

                        case 1:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            shupX = posDireita(jLabelshuppet, shupX);

                            break;

                        case 2:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            shupY = posCima(jLabelshuppet, shupY);

                            break;

                        case 3:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            shupY = posBaixo(jLabelshuppet, shupY);

                            break;
                    }

                    //Esta condicional define se o personagem modou de posição, caso não ele sorteia uma nova direção
                    if (jLabelshuppet.getX() == shupX & jLabelshuppet.getY() == shupY) {
                        sort = new Random().nextInt(4);
                    } //if (jLabelduskull.getX() == xAnt & jLabelduskull.getY() == yAnt) {
                    //   sort = new Random().nextInt(4);   
                    // }
                    else {
                        try {
                            Thread.sleep(300);// Tempo de espera antes do proximo passo
                        } catch (Exception ex) {
                        }

                    }

                    //A possição do personagem é atualizada
                    jLabelshuppet.setBounds(shupX, shupY, jLabelshuppet.getWidth(), jLabelshuppet.getHeight());
                    //System.out.println(sort + "-" + duskControle + "=" + duskAnt + "-" + jLabelduskull.getX() + "-" + jLabelduskull.getY());

                    if (jLabelshuppet.getX() == jLabelMunch.getX() & jLabelshuppet.getY() == jLabelMunch.getX()) {
                        vida -= 1;
                        jLabelVidas[vida].setBounds(0, 0, 0, 0);
                    }

                    //Inicio do metodo para verificar as direções que o personagem pode tomar
                    shupControle = controleDirecional(jLabelshuppet, shupControle);

                }

            }

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelparedeLa1 = new javax.swing.JLabel();
        jLabelparedeLa2 = new javax.swing.JLabel();
        jLabelparedeLa3 = new javax.swing.JLabel();
        jLabelparedeLa4 = new javax.swing.JLabel();
        jLabelparedeLa5 = new javax.swing.JLabel();
        jLabelparedeLa6 = new javax.swing.JLabel();
        jLabelparedeFa1 = new javax.swing.JLabel();
        jLabelparedeFa2 = new javax.swing.JLabel();
        jLabelparedeFa3 = new javax.swing.JLabel();
        jLabelparedeFa4 = new javax.swing.JLabel();
        jLabelparedeFa5 = new javax.swing.JLabel();
        jLabelparedeFa6 = new javax.swing.JLabel();
        jLabelparedeFa7 = new javax.swing.JLabel();
        jLabelparedeFa8 = new javax.swing.JLabel();
        jLabelparedeFa9 = new javax.swing.JLabel();
        jLabelparedeFa10 = new javax.swing.JLabel();
        jLabelparedeIv1 = new javax.swing.JLabel();
        jLabelparedeIv2 = new javax.swing.JLabel();
        jLabelparedeIv3 = new javax.swing.JLabel();
        jLabelparedeIv4 = new javax.swing.JLabel();
        jLabelparedeIv5 = new javax.swing.JLabel();
        jLabelparedeIv6 = new javax.swing.JLabel();
        jLabelparedeIv7 = new javax.swing.JLabel();
        jLabelparedeIv8 = new javax.swing.JLabel();
        jLabelparedeIv9 = new javax.swing.JLabel();
        jLabelparedeIv10 = new javax.swing.JLabel();
        jLabelparedeIv11 = new javax.swing.JLabel();
        jLabelparedeIv12 = new javax.swing.JLabel();
        jLabelparedeIv13 = new javax.swing.JLabel();
        jLabelparedeIv14 = new javax.swing.JLabel();
        jLabelparedeIv15 = new javax.swing.JLabel();
        jLabelparedeIv16 = new javax.swing.JLabel();
        jLabelparedeIv17 = new javax.swing.JLabel();
        jLabelparedeIv18 = new javax.swing.JLabel();
        jLabelparedeIv19 = new javax.swing.JLabel();
        jLabelparedeIv20 = new javax.swing.JLabel();
        jLabelparedeIv21 = new javax.swing.JLabel();
        jLabelparedeIv22 = new javax.swing.JLabel();
        jLabelparedeIv23 = new javax.swing.JLabel();
        jLabelparedeIv24 = new javax.swing.JLabel();
        jLabelparedeIv25 = new javax.swing.JLabel();
        jLabelparedeIv26 = new javax.swing.JLabel();
        jLabelparedeIv27 = new javax.swing.JLabel();
        jLabelparedeIv28 = new javax.swing.JLabel();
        jLabelparedeIv29 = new javax.swing.JLabel();
        jLabelparedeIv30 = new javax.swing.JLabel();
        jLabelparedeIv31 = new javax.swing.JLabel();
        jLabelparedeIv32 = new javax.swing.JLabel();
        jLabelparedeIv33 = new javax.swing.JLabel();
        jLabelparedeIv34 = new javax.swing.JLabel();
        jLabelparedeIv35 = new javax.swing.JLabel();
        jLabelparedeIv36 = new javax.swing.JLabel();
        jLabelparedeIv37 = new javax.swing.JLabel();
        jLabelparedeIv38 = new javax.swing.JLabel();
        jLabelparedeIv39 = new javax.swing.JLabel();
        jLabelparedeIv40 = new javax.swing.JLabel();
        jLabelparedeIv41 = new javax.swing.JLabel();
        jLabelparedeIv42 = new javax.swing.JLabel();
        jLabelparedeIv43 = new javax.swing.JLabel();
        jLabelparedeIv44 = new javax.swing.JLabel();
        jLabelparedeIv45 = new javax.swing.JLabel();
        jLabelparedeIv46 = new javax.swing.JLabel();
        jLabelparedeIv47 = new javax.swing.JLabel();
        jLabelparedeIv48 = new javax.swing.JLabel();
        jLabelparedeIv50 = new javax.swing.JLabel();
        jLabelparedeIv51 = new javax.swing.JLabel();
        jLabelparedeIv52 = new javax.swing.JLabel();
        jLabelparedeIv53 = new javax.swing.JLabel();
        jLabelparedeIv54 = new javax.swing.JLabel();
        jLabelparedeIv55 = new javax.swing.JLabel();
        jLabelparedeIv56 = new javax.swing.JLabel();
        jLabelparedeIv57 = new javax.swing.JLabel();
        jLabelparedeIv58 = new javax.swing.JLabel();
        jLabelparedeIv59 = new javax.swing.JLabel();
        jLabelparedeIv60 = new javax.swing.JLabel();
        jLabelparedeIv61 = new javax.swing.JLabel();
        jLabelparedeIv62 = new javax.swing.JLabel();
        jLabelparedeIv63 = new javax.swing.JLabel();
        jLabelparedeIv64 = new javax.swing.JLabel();
        jLabelparedeIv65 = new javax.swing.JLabel();
        jLabelparedeIv66 = new javax.swing.JLabel();
        jLabelparedeIv67 = new javax.swing.JLabel();
        jLabelparedeIv68 = new javax.swing.JLabel();
        jLabelparedeIv69 = new javax.swing.JLabel();
        jLabelparedeIv70 = new javax.swing.JLabel();
        jLabelparedeIv71 = new javax.swing.JLabel();
        jLabelparedeIv72 = new javax.swing.JLabel();
        jLabelparedeIv73 = new javax.swing.JLabel();
        jLabelparedeIv74 = new javax.swing.JLabel();
        jLabelparedeIv75 = new javax.swing.JLabel();
        jLabelparedeIv76 = new javax.swing.JLabel();
        jLabelparedeIv77 = new javax.swing.JLabel();
        jLabelparedeIv78 = new javax.swing.JLabel();
        jLabelparedeIv79 = new javax.swing.JLabel();
        jLabelparedeIv80 = new javax.swing.JLabel();
        jLabelparedeIv81 = new javax.swing.JLabel();
        jLabelparedeIv82 = new javax.swing.JLabel();
        jLabelparedeIv83 = new javax.swing.JLabel();
        jLabelparedeIv84 = new javax.swing.JLabel();
        jLabelparedeIv85 = new javax.swing.JLabel();
        jLabelparedeIv86 = new javax.swing.JLabel();
        jLabelparedeIv87 = new javax.swing.JLabel();
        jLabelparedeIv88 = new javax.swing.JLabel();
        jLabelparedeIv89 = new javax.swing.JLabel();
        jLabeljogador = new javax.swing.JLabel();
        jLabelrecord = new javax.swing.JLabel();
        jLabelpontoMax = new javax.swing.JLabel();
        jLabelpontoJogo = new javax.swing.JLabel();
        jLabelgastly = new javax.swing.JLabel();
        jLabelshuppet = new javax.swing.JLabel();
        jLabelduskull = new javax.swing.JLabel();
        jLabelmisdreavus = new javax.swing.JLabel();
        jLabelMunch = new javax.swing.JLabel();
        jLabelMunchBoca = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelparedeLa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arbusto_V260.png"))); // NOI18N
        getContentPane().add(jLabelparedeLa1);
        jLabelparedeLa1.setBounds(790, 10, 20, 260);

        jLabelparedeLa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arbusto_V260M.png"))); // NOI18N
        getContentPane().add(jLabelparedeLa2);
        jLabelparedeLa2.setBounds(10, 430, 20, 260);

        jLabelparedeLa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arbusto_H800R.png"))); // NOI18N
        getContentPane().add(jLabelparedeLa3);
        jLabelparedeLa3.setBounds(10, 670, 800, 20);

        jLabelparedeLa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arbusto_V260M.png"))); // NOI18N
        getContentPane().add(jLabelparedeLa4);
        jLabelparedeLa4.setBounds(790, 430, 20, 260);

        jLabelparedeLa5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arbusto_H800.png"))); // NOI18N
        getContentPane().add(jLabelparedeLa5);
        jLabelparedeLa5.setBounds(10, 10, 800, 20);

        jLabelparedeLa6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arbusto_V260.png"))); // NOI18N
        getContentPane().add(jLabelparedeLa6);
        jLabelparedeLa6.setBounds(10, 10, 20, 260);
        getContentPane().add(jLabelparedeFa1);
        jLabelparedeFa1.setBounds(320, 380, 180, 10);
        getContentPane().add(jLabelparedeFa2);
        jLabelparedeFa2.setBounds(500, 320, 10, 60);
        getContentPane().add(jLabelparedeFa3);
        jLabelparedeFa3.setBounds(440, 310, 60, 10);
        getContentPane().add(jLabelparedeFa4);
        jLabelparedeFa4.setBounds(310, 320, 10, 60);
        getContentPane().add(jLabelparedeFa5);
        jLabelparedeFa5.setBounds(320, 310, 60, 10);
        getContentPane().add(jLabelparedeFa6);
        jLabelparedeFa6.setBounds(320, 320, 60, 10);
        getContentPane().add(jLabelparedeFa7);
        jLabelparedeFa7.setBounds(440, 320, 60, 10);
        getContentPane().add(jLabelparedeFa8);
        jLabelparedeFa8.setBounds(320, 370, 180, 10);
        getContentPane().add(jLabelparedeFa9);
        jLabelparedeFa9.setBounds(490, 320, 10, 60);
        getContentPane().add(jLabelparedeFa10);
        jLabelparedeFa10.setBounds(320, 320, 10, 60);
        getContentPane().add(jLabelparedeIv1);
        jLabelparedeIv1.setBounds(70, 80, 120, 40);
        getContentPane().add(jLabelparedeIv2);
        jLabelparedeIv2.setBounds(80, 70, 100, 60);
        getContentPane().add(jLabelparedeIv3);
        jLabelparedeIv3.setBounds(80, 170, 100, 40);
        getContentPane().add(jLabelparedeIv4);
        jLabelparedeIv4.setBounds(70, 180, 120, 20);
        getContentPane().add(jLabelparedeIv5);
        jLabelparedeIv5.setBounds(630, 180, 120, 20);
        getContentPane().add(jLabelparedeIv6);
        jLabelparedeIv6.setBounds(640, 170, 100, 40);
        getContentPane().add(jLabelparedeIv7);
        jLabelparedeIv7.setBounds(250, 80, 20, 240);
        getContentPane().add(jLabelparedeIv8);
        jLabelparedeIv8.setBounds(240, 70, 20, 260);
        getContentPane().add(jLabelparedeIv9);
        jLabelparedeIv9.setBounds(550, 80, 20, 240);
        getContentPane().add(jLabelparedeIv10);
        jLabelparedeIv10.setBounds(560, 70, 20, 260);
        getContentPane().add(jLabelparedeIv11);
        jLabelparedeIv11.setBounds(310, 80, 40, 20);
        getContentPane().add(jLabelparedeIv12);
        jLabelparedeIv12.setBounds(320, 70, 20, 40);
        getContentPane().add(jLabelparedeIv13);
        jLabelparedeIv13.setBounds(470, 80, 40, 20);
        getContentPane().add(jLabelparedeIv14);
        jLabelparedeIv14.setBounds(480, 70, 20, 40);
        getContentPane().add(jLabelparedeIv15);
        jLabelparedeIv15.setBounds(570, 80, 20, 240);
        getContentPane().add(jLabelparedeIv16);
        jLabelparedeIv16.setBounds(630, 80, 120, 40);
        getContentPane().add(jLabelparedeIv17);
        jLabelparedeIv17.setBounds(640, 70, 100, 60);
        getContentPane().add(jLabelparedeIv18);
        jLabelparedeIv18.setBounds(230, 80, 20, 240);
        getContentPane().add(jLabelparedeIv19);
        jLabelparedeIv19.setBounds(400, 10, 20, 100);
        getContentPane().add(jLabelparedeIv20);
        jLabelparedeIv20.setBounds(390, 20, 20, 80);
        getContentPane().add(jLabelparedeIv21);
        jLabelparedeIv21.setBounds(410, 20, 20, 80);
        getContentPane().add(jLabelparedeIv22);
        jLabelparedeIv22.setBounds(260, 250, 80, 20);
        getContentPane().add(jLabelparedeIv23);
        jLabelparedeIv23.setBounds(260, 230, 80, 20);
        getContentPane().add(jLabelparedeIv24);
        jLabelparedeIv24.setBounds(250, 240, 100, 20);
        getContentPane().add(jLabelparedeIv25);
        jLabelparedeIv25.setBounds(470, 240, 100, 20);
        getContentPane().add(jLabelparedeIv26);
        jLabelparedeIv26.setBounds(480, 230, 80, 20);
        getContentPane().add(jLabelparedeIv27);
        jLabelparedeIv27.setBounds(480, 250, 80, 20);
        getContentPane().add(jLabelparedeIv28);
        jLabelparedeIv28.setBounds(400, 170, 20, 100);
        getContentPane().add(jLabelparedeIv29);
        jLabelparedeIv29.setBounds(390, 180, 20, 80);
        getContentPane().add(jLabelparedeIv30);
        jLabelparedeIv30.setBounds(410, 180, 20, 80);
        getContentPane().add(jLabelparedeIv31);
        jLabelparedeIv31.setBounds(310, 160, 200, 20);
        getContentPane().add(jLabelparedeIv32);
        jLabelparedeIv32.setBounds(320, 150, 180, 20);
        getContentPane().add(jLabelparedeIv33);
        jLabelparedeIv33.setBounds(320, 170, 180, 20);

        jLabelparedeIv34.setToolTipText("");
        getContentPane().add(jLabelparedeIv34);
        jLabelparedeIv34.setBounds(10, 310, 170, 20);
        getContentPane().add(jLabelparedeIv35);
        jLabelparedeIv35.setBounds(10, 260, 180, 60);

        jLabelparedeIv36.setToolTipText("");
        getContentPane().add(jLabelparedeIv36);
        jLabelparedeIv36.setBounds(10, 250, 170, 20);

        jLabelparedeIv37.setToolTipText("");
        getContentPane().add(jLabelparedeIv37);
        jLabelparedeIv37.setBounds(10, 370, 170, 20);
        getContentPane().add(jLabelparedeIv38);
        jLabelparedeIv38.setBounds(10, 380, 180, 60);

        jLabelparedeIv39.setToolTipText("");
        getContentPane().add(jLabelparedeIv39);
        jLabelparedeIv39.setBounds(10, 430, 170, 20);

        jLabelparedeIv40.setToolTipText("");
        getContentPane().add(jLabelparedeIv40);
        jLabelparedeIv40.setBounds(640, 310, 170, 20);
        getContentPane().add(jLabelparedeIv41);
        jLabelparedeIv41.setBounds(630, 260, 180, 60);

        jLabelparedeIv42.setToolTipText("");
        getContentPane().add(jLabelparedeIv42);
        jLabelparedeIv42.setBounds(640, 250, 170, 20);

        jLabelparedeIv43.setToolTipText("");
        getContentPane().add(jLabelparedeIv43);
        jLabelparedeIv43.setBounds(640, 430, 170, 20);
        getContentPane().add(jLabelparedeIv44);
        jLabelparedeIv44.setBounds(630, 380, 180, 60);

        jLabelparedeIv45.setToolTipText("");
        getContentPane().add(jLabelparedeIv45);
        jLabelparedeIv45.setBounds(640, 370, 170, 20);

        jLabelparedeIv46.setToolTipText("");
        getContentPane().add(jLabelparedeIv46);
        jLabelparedeIv46.setBounds(560, 370, 20, 80);

        jLabelparedeIv47.setToolTipText("");
        getContentPane().add(jLabelparedeIv47);
        jLabelparedeIv47.setBounds(550, 380, 20, 60);

        jLabelparedeIv48.setToolTipText("");
        getContentPane().add(jLabelparedeIv48);
        jLabelparedeIv48.setBounds(570, 380, 20, 60);

        jLabelparedeIv50.setToolTipText("");
        getContentPane().add(jLabelparedeIv50);
        jLabelparedeIv50.setBounds(240, 370, 20, 80);

        jLabelparedeIv51.setToolTipText("");
        getContentPane().add(jLabelparedeIv51);
        jLabelparedeIv51.setBounds(230, 380, 20, 60);

        jLabelparedeIv52.setToolTipText("");
        getContentPane().add(jLabelparedeIv52);
        jLabelparedeIv52.setBounds(250, 380, 20, 60);

        jLabelparedeIv53.setToolTipText("");
        getContentPane().add(jLabelparedeIv53);
        jLabelparedeIv53.setBounds(130, 500, 60, 40);

        jLabelparedeIv54.setToolTipText("");
        getContentPane().add(jLabelparedeIv54);
        jLabelparedeIv54.setBounds(240, 490, 20, 120);

        jLabelparedeIv55.setToolTipText("");
        getContentPane().add(jLabelparedeIv55);
        jLabelparedeIv55.setBounds(250, 510, 20, 100);

        jLabelparedeIv56.setToolTipText("");
        getContentPane().add(jLabelparedeIv56);
        jLabelparedeIv56.setBounds(140, 490, 40, 60);

        jLabelparedeIv57.setToolTipText("");
        getContentPane().add(jLabelparedeIv57);
        jLabelparedeIv57.setBounds(230, 500, 20, 110);

        jLabelparedeIv58.setToolTipText("");
        getContentPane().add(jLabelparedeIv58);
        jLabelparedeIv58.setBounds(70, 600, 260, 20);

        jLabelparedeIv59.setToolTipText("");
        getContentPane().add(jLabelparedeIv59);
        jLabelparedeIv59.setBounds(80, 610, 240, 20);

        jLabelparedeIv60.setToolTipText("");
        getContentPane().add(jLabelparedeIv60);
        jLabelparedeIv60.setBounds(80, 590, 240, 20);

        jLabelparedeIv61.setToolTipText("");
        getContentPane().add(jLabelparedeIv61);
        jLabelparedeIv61.setBounds(370, 600, 80, 20);

        jLabelparedeIv62.setToolTipText("");
        getContentPane().add(jLabelparedeIv62);
        jLabelparedeIv62.setBounds(380, 590, 60, 20);

        jLabelparedeIv63.setToolTipText("");
        getContentPane().add(jLabelparedeIv63);
        jLabelparedeIv63.setBounds(380, 610, 60, 20);

        jLabelparedeIv64.setToolTipText("");
        getContentPane().add(jLabelparedeIv64);
        jLabelparedeIv64.setBounds(320, 430, 20, 100);

        jLabelparedeIv65.setToolTipText("");
        getContentPane().add(jLabelparedeIv65);
        jLabelparedeIv65.setBounds(310, 440, 20, 100);

        jLabelparedeIv66.setToolTipText("");
        getContentPane().add(jLabelparedeIv66);
        jLabelparedeIv66.setBounds(330, 440, 20, 100);

        jLabelparedeIv67.setToolTipText("");
        getContentPane().add(jLabelparedeIv67);
        jLabelparedeIv67.setBounds(310, 520, 120, 20);

        jLabelparedeIv68.setToolTipText("");
        getContentPane().add(jLabelparedeIv68);
        jLabelparedeIv68.setBounds(320, 530, 100, 20);

        jLabelparedeIv69.setToolTipText("");
        getContentPane().add(jLabelparedeIv69);
        jLabelparedeIv69.setBounds(330, 510, 90, 20);

        jLabelparedeIv70.setToolTipText("");
        getContentPane().add(jLabelparedeIv70);
        jLabelparedeIv70.setBounds(480, 450, 20, 100);

        jLabelparedeIv71.setToolTipText("");
        getContentPane().add(jLabelparedeIv71);
        jLabelparedeIv71.setBounds(490, 440, 20, 100);

        jLabelparedeIv72.setToolTipText("");
        getContentPane().add(jLabelparedeIv72);
        jLabelparedeIv72.setBounds(470, 450, 20, 90);

        jLabelparedeIv73.setToolTipText("");
        getContentPane().add(jLabelparedeIv73);
        jLabelparedeIv73.setBounds(390, 440, 110, 20);

        jLabelparedeIv74.setToolTipText("");
        getContentPane().add(jLabelparedeIv74);
        jLabelparedeIv74.setBounds(400, 450, 80, 20);

        jLabelparedeIv75.setToolTipText("");
        getContentPane().add(jLabelparedeIv75);
        jLabelparedeIv75.setBounds(10, 490, 70, 20);

        jLabelparedeIv76.setToolTipText("");
        getContentPane().add(jLabelparedeIv76);
        jLabelparedeIv76.setBounds(10, 530, 70, 20);

        jLabelparedeIv77.setToolTipText("");
        getContentPane().add(jLabelparedeIv77);
        jLabelparedeIv77.setBounds(10, 500, 80, 40);

        jLabelparedeIv78.setToolTipText("");
        getContentPane().add(jLabelparedeIv78);
        jLabelparedeIv78.setBounds(400, 430, 100, 20);

        jLabelparedeIv79.setToolTipText("");
        getContentPane().add(jLabelparedeIv79);
        jLabelparedeIv79.setBounds(740, 490, 70, 20);

        jLabelparedeIv80.setToolTipText("");
        getContentPane().add(jLabelparedeIv80);
        jLabelparedeIv80.setBounds(740, 530, 70, 20);

        jLabelparedeIv81.setToolTipText("");
        getContentPane().add(jLabelparedeIv81);
        jLabelparedeIv81.setBounds(730, 500, 80, 40);

        jLabelparedeIv82.setToolTipText("");
        getContentPane().add(jLabelparedeIv82);
        jLabelparedeIv82.setBounds(500, 590, 240, 20);

        jLabelparedeIv83.setToolTipText("");
        getContentPane().add(jLabelparedeIv83);
        jLabelparedeIv83.setBounds(490, 600, 260, 20);

        jLabelparedeIv84.setToolTipText("");
        getContentPane().add(jLabelparedeIv84);
        jLabelparedeIv84.setBounds(500, 610, 240, 20);

        jLabelparedeIv85.setToolTipText("");
        getContentPane().add(jLabelparedeIv85);
        jLabelparedeIv85.setBounds(560, 490, 20, 120);

        jLabelparedeIv86.setToolTipText("");
        getContentPane().add(jLabelparedeIv86);
        jLabelparedeIv86.setBounds(550, 500, 20, 100);

        jLabelparedeIv87.setToolTipText("");
        getContentPane().add(jLabelparedeIv87);
        jLabelparedeIv87.setBounds(570, 500, 20, 100);

        jLabelparedeIv88.setToolTipText("");
        getContentPane().add(jLabelparedeIv88);
        jLabelparedeIv88.setBounds(640, 490, 40, 60);

        jLabelparedeIv89.setToolTipText("");
        getContentPane().add(jLabelparedeIv89);
        jLabelparedeIv89.setBounds(630, 500, 60, 40);

        jLabeljogador.setFont(new java.awt.Font("Pokemon DPPt", 1, 40)); // NOI18N
        jLabeljogador.setText("1UP");
        getContentPane().add(jLabeljogador);
        jLabeljogador.setBounds(820, 30, 90, 40);

        jLabelrecord.setFont(new java.awt.Font("Pokemon DPPt", 1, 40)); // NOI18N
        jLabelrecord.setText("<html>\nHIGH </br>SCORE\n</html>");
        getContentPane().add(jLabelrecord);
        jLabelrecord.setBounds(820, 130, 130, 80);

        jLabelpontoMax.setFont(new java.awt.Font("Pokemon DPPt", 0, 30)); // NOI18N
        jLabelpontoMax.setText("0");
        getContentPane().add(jLabelpontoMax);
        jLabelpontoMax.setBounds(820, 210, 100, 30);

        jLabelpontoJogo.setFont(new java.awt.Font("Pokemon DPPt", 0, 30)); // NOI18N
        jLabelpontoJogo.setText("0");
        getContentPane().add(jLabelpontoJogo);
        jLabelpontoJogo.setBounds(820, 70, 100, 30);

        jLabelgastly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gastly_esquerda.png"))); // NOI18N
        getContentPane().add(jLabelgastly);
        jLabelgastly.setBounds(330, 330, 40, 40);

        jLabelshuppet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/shuppet_esquerda.png"))); // NOI18N
        getContentPane().add(jLabelshuppet);
        jLabelshuppet.setBounds(410, 330, 40, 40);

        jLabelduskull.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/duskull_esquerda.png"))); // NOI18N
        getContentPane().add(jLabelduskull);
        jLabelduskull.setBounds(370, 330, 40, 40);

        jLabelmisdreavus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/misdreavus_esquerda.png"))); // NOI18N
        getContentPane().add(jLabelmisdreavus);
        jLabelmisdreavus.setBounds(450, 330, 40, 40);

        jLabelMunch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/munchlax_parado.png"))); // NOI18N
        getContentPane().add(jLabelMunch);
        jLabelMunch.setBounds(390, 390, 40, 40);

        jLabelMunchBoca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/restos.png"))); // NOI18N
        getContentPane().add(jLabelMunchBoca);
        jLabelMunchBoca.setBounds(400, 400, 20, 20);

        setSize(new java.awt.Dimension(935, 735));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fase_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fase_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fase_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fase_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Fase_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLabelMunch;
    public javax.swing.JLabel jLabelMunchBoca;
    public javax.swing.JLabel jLabelduskull;
    public javax.swing.JLabel jLabelgastly;
    public javax.swing.JLabel jLabeljogador;
    public javax.swing.JLabel jLabelmisdreavus;
    public javax.swing.JLabel jLabelparedeFa1;
    public javax.swing.JLabel jLabelparedeFa10;
    public javax.swing.JLabel jLabelparedeFa2;
    public javax.swing.JLabel jLabelparedeFa3;
    public javax.swing.JLabel jLabelparedeFa4;
    public javax.swing.JLabel jLabelparedeFa5;
    public javax.swing.JLabel jLabelparedeFa6;
    public javax.swing.JLabel jLabelparedeFa7;
    public javax.swing.JLabel jLabelparedeFa8;
    public javax.swing.JLabel jLabelparedeFa9;
    public javax.swing.JLabel jLabelparedeIv1;
    public javax.swing.JLabel jLabelparedeIv10;
    public javax.swing.JLabel jLabelparedeIv11;
    public javax.swing.JLabel jLabelparedeIv12;
    public javax.swing.JLabel jLabelparedeIv13;
    public javax.swing.JLabel jLabelparedeIv14;
    public javax.swing.JLabel jLabelparedeIv15;
    public javax.swing.JLabel jLabelparedeIv16;
    public javax.swing.JLabel jLabelparedeIv17;
    public javax.swing.JLabel jLabelparedeIv18;
    public javax.swing.JLabel jLabelparedeIv19;
    public javax.swing.JLabel jLabelparedeIv2;
    public javax.swing.JLabel jLabelparedeIv20;
    public javax.swing.JLabel jLabelparedeIv21;
    public javax.swing.JLabel jLabelparedeIv22;
    public javax.swing.JLabel jLabelparedeIv23;
    public javax.swing.JLabel jLabelparedeIv24;
    public javax.swing.JLabel jLabelparedeIv25;
    public javax.swing.JLabel jLabelparedeIv26;
    public javax.swing.JLabel jLabelparedeIv27;
    public javax.swing.JLabel jLabelparedeIv28;
    public javax.swing.JLabel jLabelparedeIv29;
    public javax.swing.JLabel jLabelparedeIv3;
    public javax.swing.JLabel jLabelparedeIv30;
    public javax.swing.JLabel jLabelparedeIv31;
    public javax.swing.JLabel jLabelparedeIv32;
    public javax.swing.JLabel jLabelparedeIv33;
    public javax.swing.JLabel jLabelparedeIv34;
    public javax.swing.JLabel jLabelparedeIv35;
    public javax.swing.JLabel jLabelparedeIv36;
    public javax.swing.JLabel jLabelparedeIv37;
    public javax.swing.JLabel jLabelparedeIv38;
    public javax.swing.JLabel jLabelparedeIv39;
    public javax.swing.JLabel jLabelparedeIv4;
    public javax.swing.JLabel jLabelparedeIv40;
    public javax.swing.JLabel jLabelparedeIv41;
    public javax.swing.JLabel jLabelparedeIv42;
    public javax.swing.JLabel jLabelparedeIv43;
    public javax.swing.JLabel jLabelparedeIv44;
    public javax.swing.JLabel jLabelparedeIv45;
    public javax.swing.JLabel jLabelparedeIv46;
    public javax.swing.JLabel jLabelparedeIv47;
    public javax.swing.JLabel jLabelparedeIv48;
    public javax.swing.JLabel jLabelparedeIv5;
    public javax.swing.JLabel jLabelparedeIv50;
    public javax.swing.JLabel jLabelparedeIv51;
    public javax.swing.JLabel jLabelparedeIv52;
    public javax.swing.JLabel jLabelparedeIv53;
    public javax.swing.JLabel jLabelparedeIv54;
    public javax.swing.JLabel jLabelparedeIv55;
    public javax.swing.JLabel jLabelparedeIv56;
    public javax.swing.JLabel jLabelparedeIv57;
    public javax.swing.JLabel jLabelparedeIv58;
    public javax.swing.JLabel jLabelparedeIv59;
    public javax.swing.JLabel jLabelparedeIv6;
    public javax.swing.JLabel jLabelparedeIv60;
    public javax.swing.JLabel jLabelparedeIv61;
    public javax.swing.JLabel jLabelparedeIv62;
    public javax.swing.JLabel jLabelparedeIv63;
    public javax.swing.JLabel jLabelparedeIv64;
    public javax.swing.JLabel jLabelparedeIv65;
    public javax.swing.JLabel jLabelparedeIv66;
    public javax.swing.JLabel jLabelparedeIv67;
    public javax.swing.JLabel jLabelparedeIv68;
    public javax.swing.JLabel jLabelparedeIv69;
    public javax.swing.JLabel jLabelparedeIv7;
    public javax.swing.JLabel jLabelparedeIv70;
    public javax.swing.JLabel jLabelparedeIv71;
    public javax.swing.JLabel jLabelparedeIv72;
    public javax.swing.JLabel jLabelparedeIv73;
    public javax.swing.JLabel jLabelparedeIv74;
    public javax.swing.JLabel jLabelparedeIv75;
    public javax.swing.JLabel jLabelparedeIv76;
    public javax.swing.JLabel jLabelparedeIv77;
    public javax.swing.JLabel jLabelparedeIv78;
    public javax.swing.JLabel jLabelparedeIv79;
    public javax.swing.JLabel jLabelparedeIv8;
    public javax.swing.JLabel jLabelparedeIv80;
    public javax.swing.JLabel jLabelparedeIv81;
    public javax.swing.JLabel jLabelparedeIv82;
    public javax.swing.JLabel jLabelparedeIv83;
    public javax.swing.JLabel jLabelparedeIv84;
    public javax.swing.JLabel jLabelparedeIv85;
    public javax.swing.JLabel jLabelparedeIv86;
    public javax.swing.JLabel jLabelparedeIv87;
    public javax.swing.JLabel jLabelparedeIv88;
    public javax.swing.JLabel jLabelparedeIv89;
    public javax.swing.JLabel jLabelparedeIv9;
    public javax.swing.JLabel jLabelparedeLa1;
    public javax.swing.JLabel jLabelparedeLa2;
    public javax.swing.JLabel jLabelparedeLa3;
    public javax.swing.JLabel jLabelparedeLa4;
    public javax.swing.JLabel jLabelparedeLa5;
    public javax.swing.JLabel jLabelparedeLa6;
    public javax.swing.JLabel jLabelpontoJogo;
    public javax.swing.JLabel jLabelpontoMax;
    public javax.swing.JLabel jLabelrecord;
    public javax.swing.JLabel jLabelshuppet;
    // End of variables declaration//GEN-END:variables
}
