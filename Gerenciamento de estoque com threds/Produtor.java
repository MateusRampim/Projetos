import java.util.Random;
import javax.swing.*;
/**
 * Escreva uma descrição da classe Produtor aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Produtor implements Runnable
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private JLabel frame;
    private Deposito dep;
    private static Random rand= new Random();
    /**
     * Construtor para objetos da classe Produtor
     */
    public Produtor(Deposito dep, JLabel frame)
    {
        this.dep = dep;
        this.frame = frame;
    }

    public void run(){
        int add;
        for(int i = 1;i<= 10;i++){
            try{
                Thread.sleep(rand.nextInt(3000));
                add = rand.nextInt(40);
                dep.Colocar(add);
                frame.setText(String.format("Produzido: %d \n ESTOQUE: %d",add, dep.get()));

            }
            catch(InterruptedException exp){
                exp.printStackTrace();
            }

        }
    }

}
