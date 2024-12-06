package Personaggi;

public class Guaritore extends ClasseBasePersonaggio{
    private Integer mana;
    private Integer potereCurativo;
    private String strumentoDiCura;

    public Guaritore(String nome, Integer puntiVita, Integer mana, Integer potereCurativo, String strumentoDiCura) {
        super(nome, puntiVita);
        this.mana = mana;
        this.potereCurativo = potereCurativo;
        this.strumentoDiCura = strumentoDiCura;
    }

    public void ricaricaMana() {
        mana += 10;
        System.out.println(getNome() + " ha ricaricato il suo mana. Ora il valore è di " + getMana() + ".");
    }

    private boolean useMana(int costoMana) {
        if(mana >= costoMana) {
            mana -= costoMana;
            return true;
        } else {
            System.out.println("Impossibile curare. Ricaricare i mana.");
            return false;
        }
    }

    public void curaAlleato(ClasseBasePersonaggio alleato) {

        if(alleato.getPuntiVita() == 100) {
            System.out.println(alleato.getNome() + " ha gia il massimo dei punti vita.");
            return;
        }

        int moltiplicatore = switch (getStrumentoDiCura()) {
            case "Erbe Medicinali" -> 1;
            case "Pozione" -> 2;
            case "Bastone" -> 3;
            default -> throw new IllegalStateException("Lo strumento di cura indicato non esiste.");
        };

        int costoMana = switch (getStrumentoDiCura()) {
            case "Erbe Medicinali" -> 5;
            case "Pozione" -> 10;
            case "Bastone" -> 15;
            default -> throw new IllegalStateException("Lo strumento di cura indicato non esiste.");
        };

        int cura = getPotereCurativo() * moltiplicatore;

        if(useMana(costoMana)) {
            alleato.setPuntiVita(alleato.getPuntiVita() + cura);
            System.out.println(getNome() + " ha curato " + alleato.getNome() + "!");
            System.out.println("+".repeat(cura));
        }
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Integer getPotereCurativo() {
        return potereCurativo;
    }

    public void setPotereCurativo(Integer potereCurativo) {
        this.potereCurativo = potereCurativo;
    }

    public String getStrumentoDiCura() {
        return strumentoDiCura;
    }

    public void setStrumentoDiCura(String strumentoDiCura) {
        this.strumentoDiCura = strumentoDiCura;
    }

    @Override
    public String toString() {
        return "Guaritore{" + super.toString() +
                "mana=" + mana +
                ", potereCurativo=" + potereCurativo +
                ", strumentoDiCura='" + strumentoDiCura + '\'' +
                "} ";
    }
}
