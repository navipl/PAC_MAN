/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import java.awt.Component;
import javax.swing.JLabel;
import visao.Fase_1;

/**
 *
 * @author Ivan
 */
public class Movimento {
    Fase_1 fase = new Fase_1();
            
    
    /*No mapa existem varias esquinas em que os fantasmas devem decidir qual direção tomar,
    esta função define em que posição no mapa o fantasma esta e marca o ponto que ele pasou
    com a variavel DIR para definir no loop se ele continua em sua trilha ou se esta trilha sofre auteração*/
    public int controleDirecional(JLabel label) {
        int dir = 0;
        //Ponto em que o direcional recebe o valor 0
        if (label.getX() == 30 && label.getY() == 30) {
            dir = 0;
        } else if (label.getX() == 270 && label.getY() == 30) {
            dir = 0;
        } else if (label.getX() == 510 && label.getY() == 30) {
            dir = 0;
        } else if (label.getX() == 750 && label.getY() == 30) {
            dir = 0;
        } else if (label.getX() == 590 && label.getY() == 130) {
            dir = 0;
        } else if (label.getX() == 430 && label.getY() == 110) {
            dir = 0;
        } else if (label.getX() == 350 && label.getY() == 110) {
            dir = 0;
        } else if (label.getX() == 190 && label.getY() == 130) {
            dir = 0;
        } else if (label.getX() == 30 && label.getY() == 210) {
            dir = 0;
        } else if (label.getX() == 270 && label.getY() == 190) {
            dir = 0;
        } else if (label.getX() == 510 && label.getY() == 190) {
            dir = 0;
        } else if (label.getX() == 750 && label.getY() == 210) {
            dir = 0;
        } else if (label.getX() == 430 && label.getY() == 270) {
            dir = 0;
        } else if (label.getX() == 350 && label.getY() == 270) {
            dir = 0;
        } else if (label.getX() == 270 && label.getY() == 330) {
            dir = 0;
        } else if (label.getX() == 390 && label.getY() == 330) {
            dir = 0;
        } else if (label.getX() == 510 && label.getY() == 330) {
            dir = 0;
        } else if (label.getX() == 350 && label.getY() == 390) {
            dir = 0;
        } else if (label.getX() == 90 && label.getY() == 450) {
            dir = 0;
        } else if (label.getX() == 270 && label.getY() == 450) {
            dir = 0;
        } else if (label.getX() == 430 && label.getY() == 470) {
            dir = 0;
        } else if (label.getX() == 510 && label.getY() == 450) {
            dir = 0;
        } else if (label.getX() == 690 && label.getY() == 450) {
            dir = 0;
        } else if (label.getX() == 750 && label.getY() == 550) {
            dir = 0;
        } else if (label.getX() == 590 && label.getY() == 550) {
            dir = 0;
        } else if (label.getX() == 450 && label.getY() == 550) {
            dir = 0;
        } else if (label.getX() == 330 && label.getY() == 550) {
            dir = 0;
        } else if (label.getX() == 190 && label.getY() == 500) {
            dir = 0;
        } else if (label.getX() == 30 && label.getY() == 550) {
            dir = 0;
        } 
        //Ponto em que o direcional recebe o valor 1 
        if (label.getX() == 190 && label.getY() == 30) {
            dir = 1;
        }
        else if (label.getX() == 350 && label.getY() == 30) {
            dir = 1;
        }
        else if (label.getX() == 400 && label.getY() == 30) {
            dir = 1;
        }
        else if (label.getX() == 590 && label.getY() == 30) {
            dir = 1;
        }
        else if (label.getX() == 30 && label.getY() == 130) {
            dir = 1;
        }
        else if (label.getX() == 270 && label.getY() == 110) {
            dir = 1;
        }
        else if (label.getX() == 510 && label.getY() == 110) {
            dir = 1;
        }
        else if (label.getX() == 750 && label.getY() == 130) {
            dir = 1;
        }
        else if (label.getX() == 190 && label.getY() == 210) {
            dir = 1;
        }
        else if (label.getX() == 350 && label.getY() == 190) {
            dir = 1;
        }
        else if (label.getX() == 430 && label.getY() == 190) {
            dir = 1;
        }
        else if (label.getX() == 590 && label.getY() == 210) {
            dir = 1;
        }
        else if (label.getX() == 270 && label.getY() == 270) {
            dir = 1;
        }
        else if (label.getX() == 390 && label.getY() == 270) {
            dir = 1;
        }
        else if (label.getX() == 510 && label.getY() == 270) {
            dir = 1;
        }
        else if (label.getX() == 330 && label.getY() == 330) {
            dir = 1;
        }
        else if (label.getX() == 450 && label.getY() == 330) {
            dir = 1;
        }
        else if (label.getX() == 770 && label.getY() == 330) {//obsssssssssssssssssssssssssssssssssssssss
            dir = 1;
        }
        else if (label.getX() == 270 && label.getY() == 390) {
            dir = 1;
        }
        else if (label.getX() == 510 && label.getY() == 390) {
            dir = 1;
        }
        else if (label.getX() == 30 && label.getY() == 450) {
            dir = 1;
        }
        else if (label.getX() == 190 && label.getY() == 450) {
            dir = 1;
        }
        else if (label.getX() == 350 && label.getY() == 470) {
            dir = 1;
        }
        else if (label.getX() == 590 && label.getY() == 450) {
            dir = 1;
        }
        else if (label.getX() == 750 && label.getY() == 450) {
            dir = 1;
        }
        else if (label.getX() == 90 && label.getY() == 550) {
            dir = 1;
        }
        else if (label.getX() == 270 && label.getY() == 550) {
            dir = 1;
        }
        else if (label.getX() == 430 && label.getY() == 550) {
            dir = 1;
        }
        else if (label.getX() == 510 && label.getY() == 550) {
            dir = 1;
        }
        else if (label.getX() == 690 && label.getY() == 550) {
            dir = 1;
        }
        else if (label.getX() == 330 && label.getY() == 630) {
            dir = 1;
        }
        else if (label.getX() == 750 && label.getY() == 630) {
            dir = 1;
        }
        
        //Ponto em que o direcional recebe o valor 2
        if (label.getX() == 190 && label.getY() == 330) {
            dir = 2;
        }
        else if (label.getX() == 590 && label.getY() == 330) {
            dir = 2;
        }
        else if (label.getX() == 30 && label.getY() == 630) {
            dir = 2;
        }
        else if (label.getX() == 450 && label.getY() == 630) {
            dir = 2;
        }

        return dir;
    }
    
    public int posEsquerda(JLabel labelEsq, int posX) {
        //Bloqueiam as paredes dos movimentos a esquerda
        if (labelEsq.getX() == -10) {
            posX = 770;
        }else if (parede(labelEsq, fase.jLabelLinhaFa) == true) {//Entrada da casa do fantasma
            posX = labelEsq.getX();
        }else if (parede(labelEsq, fase.jLabelparedeFa2) == true) {//Paredes casa do fantasma
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeFa10) == true) {//Paredes casa do fantasma
            posX = labelEsq.getX();
            
        } else if (parede(labelEsq, fase.jLabelparedeLa6) == true) {//Paredes laterais
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeLa2) == true) {//Paredes laterais
            posX = labelEsq.getX();
            
        } else if (parede(labelEsq, fase.jLabelparedeIv1) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv4) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv7) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv11) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv24) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv30) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv31) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv13) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv16) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv5) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv38) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv35) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv21) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv15) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv48) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv52) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv77) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv53) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv55) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv58) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv66) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv67) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv61) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv71) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv87) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv83) == true) {
            posX = labelEsq.getX();
        } else if (parede(labelEsq, fase.jLabelparedeIv89) == true) {
            posX = labelEsq.getX();
        } 
        //Movimento para a Esquerda casso não hajá paredes 
        else {
            posX -= 20;
        }

        return posX;
    }

    public int posCima(JLabel labelCim, int posY) {
        //Bloqueiam as paredes dos movimentos para cima
        if (parede(labelCim, fase.jLabelparedeFa1) == true) {//Paredes casa do fantasma
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeFa6) == true) {//Paredes casa do fantasma
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeFa7) == true) {//Paredes casa do fantasma
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv68) == true) {//Paredes laterais
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv84) == true) {//Paredes laterais
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeLa5) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv34) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv39) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv40) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv43) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv3) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv2) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv8) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv22) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv12) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv33) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv28) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv19) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv14) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv27) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv10) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv6) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv17) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv46) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv50) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv76) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv56) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv59) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv63) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv74) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv70) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv88) == true) {
            posY = labelCim.getY();
        } else if (parede(labelCim, fase.jLabelparedeIv80) == true) {
            posY = labelCim.getY();
        } 

        //Movimento para Cima casso não hajá paredes 
        else {
            posY -= 20;
        }

        return posY;

    }

    public int posDireita(JLabel labelDir, int posX) {
        //Bloqueiam as paredes dos movimentos a direita
        if (labelDir.getX() == 790) {
            posX = 10;
        }else if (parede(labelDir, fase.jLabelLinhaFa) == true) {//Entrada da casa do fantasma
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeFa4) == true) {//Paredes casa do fantasma
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeFa9) == true) {//Paredes casa do fantasma
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeLa4) == true) {//Paredes laterais
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeLa1) == true) {//Paredes laterais
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv44) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv41) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv16) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv5) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv13) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv29) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv31) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv11) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv18) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv4) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv20) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv9) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv25) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv1) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv47) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv51) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv53) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv57) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv58) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv65) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv73) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv72) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv61) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv83) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv86) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv89) == true) {
            posX = labelDir.getX();
        } else if (parede(labelDir, fase.jLabelparedeIv81) == true) {
            posX = labelDir.getX();
        } 
        
        //Movimento para a Direita casso não hajá paredes 
        else {
            posX += 20;
        }

        return posX;

    }

    public int posBaixo(JLabel labelBai, int posY) {
        //Bloqueia a casa dos fantasma para o personagem principal
        if (parede(labelBai, fase.jLabelLinhaFa) == true) {
            posY = labelBai.getY();
        }

        //bloqueia as paredes dos movimentos para baixo
        else if (parede(labelBai, fase.jLabelparedeFa5) == true) {//Paredes casa do fantasma
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeFa3) == true) {//Paredes casa do fantasma
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeFa8) == true) {//Paredes casa do fantasma
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeLa3) == true) {//Paredes laterais
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv36) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv37) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv42) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv45) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv3) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv2) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv8) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv12) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv23) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv32) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv14) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv26) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv10) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv17) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv6) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv46) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv50) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv75) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv56) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv54) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv69) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv64) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv78) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv62) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv85) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv82) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv88) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv79) == true) {
            posY = labelBai.getY();
        } else if (parede(labelBai, fase.jLabelparedeIv60) == true) {
            posY = labelBai.getY();
        } 

        //Movimento para Baixo casso não hajá paredes 
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
    
}
