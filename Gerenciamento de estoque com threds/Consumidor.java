import java.util.Random;
import javax.swing.*;

/**
 * Escreva uma descrição da classe Consumidor aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Consumidor implements Runnable
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private Deposito dep;
    private static Random rand= new Random();
    private JLabel frame;

    /**
     * Construtor para objetos da classe Consumidor
     */
    public Consumidor(Deposito dep,JLabel frame){
        this.dep = dep;
        this.frame = frame;
    }

    public void run(){
        int add;
        for(int i = 1;i<= 10;i++){
            try{
                Thread.sleep(rand.nextInt(3000));
                add = rand.nextInt(dep.get());

                dep.Retirar(add);
                frame.setText(String.format("Retirando: %d \n ESTOQUE: %d",add, dep.get()));
            }
            catch(InterruptedException exp){
                exp.printStackTrace();
            }

        }
    }
}
