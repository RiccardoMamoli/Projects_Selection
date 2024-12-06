package Personaggi;

public abstract class ClasseBasePersonaggio {
    private String nome;
    private Integer puntiVita;

    public ClasseBasePersonaggio(String nome, Integer puntiVita) {
        this.nome = nome;
        this.puntiVita = puntiVita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPuntiVita() {
        return puntiVita;
    }

    public void setPuntiVita(Integer puntiVita) {
        this.puntiVita = Math.max(puntiVita,0);
        if(puntiVita == 0) {
            System.out.println(getNome() + " è morto!");
        }
    }

    @Override
    public String toString() {
        return "ClasseBasePersonaggio{" +
                "nome='" + nome + '\'' +
                ", puntiVita=" + puntiVita +
                '}';
    }
}

