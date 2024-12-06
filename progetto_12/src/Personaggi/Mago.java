package Personaggi;

import java.util.Random;

public class Mago extends ClasseBasePersonaggio implements Scontro {
    private Integer puntiIntelligenza;
    private Integer mana;
    private String incantesimoPrimario;
    private String incantesimoSecondario;

    public Mago(String nome, Integer puntiVita, Integer puntiIntelligenza, Integer mana, String incantesimoPrimario, String incantesimoSecondario) {
        super(nome, puntiVita);
        this.puntiIntelligenza = puntiIntelligenza;
        this.mana = mana;
        this.incantesimoPrimario = incantesimoPrimario;
        this.incantesimoSecondario = incantesimoSecondario;
    }

    public void ricaricaMana() {
        mana += 15;
        System.out.println( getNome() + " ha ricaricato il suo mana. Ora il valore è di " + getMana() + ". Cos'altro vuoi far fare al tuo personaggio?");
    }

    private boolean usaMana(int costoMana) {
        if (costoMana <= mana) {
            mana -= costoMana;
            return true;
        } else {
          System.out.println("Impossbile utilizzare l'incantesimo, mana insufficente. Ricaricare prima.");
          return false;
        }
    }

    @Override
    public void combatti(ClasseBasePersonaggio avversario) {
        Random random = new Random();
        String inc = random.nextBoolean() ? incantesimoPrimario : incantesimoSecondario; // random + next boolean genera un risultato randomico tra true o false
        int costo = inc.equals(incantesimoPrimario) ? 10 : 5;
        if (usaMana(costo)) {
            System.out.println(getNome() + " utilizza " + inc + " contro " + avversario.getNome() + ".");
            System.out.println(inc + " " + "*".repeat(getPuntiIntelligenza()) + "-".repeat(getPuntiIntelligenza()));
            avversario.setPuntiVita(avversario.getPuntiVita() - getPuntiIntelligenza());
            System.out.println(avversario.getNome() + " ha " + avversario.getPuntiVita() + " punti vita rimanenti.");
        }
    }

    public Integer getPuntiIntelligenza() {
        return puntiIntelligenza;
    }

    public void setPuntiIntelligenza(Integer puntiIntelligenza) {
        this.puntiIntelligenza = puntiIntelligenza;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public String getIncantesimoPrimario() {
        return incantesimoPrimario;
    }

    public void setIncantesimoPrimario(String incantesimoPrimario) {
        this.incantesimoPrimario = incantesimoPrimario;
    }

    public String getIncantesimoSecondario() {
        return incantesimoSecondario;
    }

    public void setIncantesimoSecondario(String incantesimoSecondario) {
        this.incantesimoSecondario = incantesimoSecondario;
    }

    @Override
    public String toString() {
        return "Mago{" + super.toString() +
                "puntiIntelligenza=" + puntiIntelligenza +
                ", mana=" + mana +
                ", incantesimoPrimario='" + incantesimoPrimario + '\'' +
                ", incantesimoSecondario='" + incantesimoSecondario + '\'' +
                "} ";
    }
}
