package Personaggi;

public class Guerriero extends ClasseBasePersonaggio implements Scontro {
    private Integer forza;
    private String tipoArma;

    public Guerriero (String nome, Integer puntiVita, Integer forza, String tipoArma) {
        super(nome, puntiVita);
        this.forza = forza;
        this.tipoArma = tipoArma;
    }


    public void prendiPozione() {
      forza += 10;
      System.out.println(getNome() + " ha preso una pozione! Ora la sua forza è a " + forza + ". Cos'altro vuoi far fare al tuo personaggio?");
    }

    public void malus() {
        if(forza > 0) {
            forza -= 10;
            System.out.println(getNome() + " è indebolito! La sua forza ora è scesa a " + forza + ". Cos'altro vuoi far fare al tuo personaggio?");
        } else {
            System.out.println(getNome() + " non ha piu punti forza.");
        }


    }



    public Integer getForza() {
        return forza;
    }

    public void setForza(Integer forza) {
        this.forza = forza;
    }

    public String getTipoArma() {
        return tipoArma;
    }

    public void setTipoArma(String tipoArma) {
        this.tipoArma = tipoArma;
    }

    @Override
    public void combatti(ClasseBasePersonaggio avversario) {
        System.out.println(getNome() + " attacca " + avversario.getNome() + "! ");
        for (int i = 0; i < forza; i++) {
            System.out.println(getTipoArma() + " " + "-".repeat(forza));
        }
        avversario.setPuntiVita(avversario.getPuntiVita() - forza);
        System.out.println("I punti vita di " + avversario.getNome() + " sono ora " + avversario.getPuntiVita());
    }

    @Override
    public String toString() {
        return "Guerriero{" + super.toString() +
                "forza=" + forza +
                ", tipoArma='" + tipoArma + '\'' +
                "} ";
    }
}
