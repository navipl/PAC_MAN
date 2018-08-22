/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Random;
import javax.swing.JLabel;
import visao.Fase_1;

/**
 *
 * @author Ivan
 */
public class Fantasma extends Thread{
    Fase_1 fase = new Fase_1();
    Movimento mov = new Movimento();


    //Metodo que gera o movimento do DUSKULL
  
        


        public void run() {
            int duskX = 370;//variavel que define a poosição X do personagem
            int duskY = 330;//variavel que define a poosição Y do personagem
            int sort = new Random().nextInt(2);//variavel que sorteia para qual direção o personagem vai andar

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
                            duskX = mov.posEsquerda(fase.jLabelduskull, duskX);
                          
                            break;

                        case 1:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            duskX = mov.posDireita(fase.jLabelduskull, duskX);
                           
                            break;
                    }
                    //Esta condicional define se o personagem modou de posição, caso não ele sorteia uma nova direção
                    if (fase.jLabelduskull.getX() == duskX && fase.jLabelduskull.getY() == duskY) {
                        sort = new Random().nextInt(2);
                    } else {
                        try {
                            Thread.sleep(100); // Tempo de espera antes do proximo passo
                        } catch (Exception ex) {
                        }
   
                    }
                    //Inicio do metodo para verificar as direções que o personagem pode tomar
                   
                        duskControle = mov.controleDirecional(fase.jLabelduskull);
                    //A possição do personagem é atualizada
                    fase.jLabelduskull.setBounds(duskX, duskY, fase.jLabelduskull.getWidth(), fase.jLabelduskull.getHeight());
                }

                duskAnt = duskControle;
                sort = new Random().nextInt(4);

                //A partir deste loop o personagem pode asumir qualquer direção
                while (duskControle == duskAnt) {
                    switch (sort) {

                        case 0:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                           duskX = mov.posEsquerda(fase.jLabelduskull, duskX);
                            
                            break;

                        case 1:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                           duskX = mov.posDireita(fase.jLabelduskull, duskX);
                            
                            break;

                        case 2:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            duskY = mov.posCima(fase.jLabelduskull, duskY);
                            
                            break;

                        case 3:
                            //Esta função determina se tem uma parede no caminho ou ele pode seguir em frente
                            duskY =  mov.posBaixo(fase.jLabelduskull, duskY);
                            
                            break;
                    }
                    //Esta condicional define se o personagem modou de posição, caso não ele sorteia uma nova direção
                    if (fase.jLabelduskull.getX() == duskX && fase.jLabelduskull.getY() == duskY) {
                        sort = new Random().nextInt(4);
                    } else {
                        try {
                            Thread.sleep(300);// Tempo de espera antes do proximo passo
                        } catch (Exception ex) {
                        }   
                        //Inicio do metodo para verificar as direções que o personagem pode tomar
                        duskControle = mov.controleDirecional(fase.jLabelduskull);
                    }
                  
                    
                    //A possição do personagem é atualizada
                    fase.jLabelduskull.setBounds(duskX, duskY, fase.jLabelduskull.getWidth(), fase.jLabelduskull.getHeight());
                    
                }

            }

        }
    
    
}
