package Personaggi;

public class Goblin extends ClasseBasePersonaggio implements Scontro {
    private int puntiForza;

    public Goblin(String nome, Integer puntiVita, Integer puntiForza) {
        super(nome, puntiVita);
        this.puntiForza = puntiForza;
    }

    public int getPuntiForza() {
        return puntiForza;
    }

    public void setPuntiForza(int puntiForza) {
        this.puntiForza = puntiForza;
    }

    @Override
    public String toString() {
        return "Goblin{" + super.toString() +
                "puntiForza=" + puntiForza +
                "} ";
    }

    @Override
    public void combatti(ClasseBasePersonaggio avversario) {
        System.out.println(avversario.getNome() + " viene attacato da " + getNome());
        avversario.setPuntiVita(avversario.getPuntiVita() - getPuntiForza());
    }
}
