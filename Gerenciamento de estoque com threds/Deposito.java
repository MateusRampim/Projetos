
// Impressão de múltiplas threads em diferentes intervalos.
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import javax.swing.*;

// Fig. 23.6: Buffer. java
// Interface Buffer especifica métodos chamados por Producer e Consumer.

/**
 * Escreva uma descrição da classe Deposito aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Deposito
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int estoque;

    /**
     * Construtor para objetos da classe Deposito
     */
    public Deposito()
    {
        // inicializa variáveis de instância
        estoque = 0;
    }

    /**
     * Um exemplo de um método - substitua este comentário pelo seu próprio
     * 
     * @param  y   um exemplo de um parâmetro de método
     * @return     a soma de x e y 
     */
    public void Colocar(int y)
    {
        // escreva seu código aqui
        estoque+=y;
    }

    public void Colocar()
    {
        // escreva seu código aqui
        estoque+=1;
    }

    public void Retirar()
    {
        // escreva seu código aqui
        estoque-=1;
    }

    public void Retirar(int y)
    {

        estoque-=y;
    }

    public int get()
    {

        return estoque;
    }

    public static void main(){
        Deposito dep = new Deposito();
        dep.Colocar(10);
        JFrame frame = new JFrame("ESTOQUE");
        frame.setSize(300, 200);
        JPanel painel = new JPanel();
        JLabel estoque = new JLabel(String.format("ESTOQUE: %d", dep.get()));
        frame.add(estoque);
        frame.setVisible(true);
        ExecutorService app = Executors.newFixedThreadPool(2);
        app.execute(new Produtor(dep,estoque));
        app.execute(new Consumidor(dep,estoque));

    }
}
