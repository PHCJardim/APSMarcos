import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class JogoModel {
	private int fase;
    private long duracao;
    private int erros;

    JogoModel(int f, long dur, int err){
        setFase(f);
        setDuracao(dur);
        setErros(err);
    }

    int getFase(){
        return fase;
    }

    long getDuracao(){
        return duracao;
    }

    int getErros(){
        return erros;
    }

    void setFase(int f){
        fase = f;
    }

    void setDuracao(long dur){
        duracao = dur;
    }

    void setErros(int err){
        erros = err;
    }
    
}
