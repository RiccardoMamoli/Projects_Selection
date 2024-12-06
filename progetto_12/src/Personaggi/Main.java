package Personaggi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ciao! Creiamo i personaggi. Partiamo dal tuo primo guerriero.");
        System.out.println("Come si chiama?");
        String nameGuerriero1 = sc.nextLine();
        System.out.println("Quanti punti vita ha?");
        int puntiVita1 = sc.nextInt();
        System.out.println("Quanti punti forza ha?");
        int puntiForza1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Che arma usa?");
        String tipoArma1 = sc.nextLine();

        Guerriero guerriero = new Guerriero(nameGuerriero1, puntiVita1, puntiForza1, tipoArma1);
        System.out.println(" ");
        System.out.println("Ottimo! Creiamo il secondo guerriero.");
        System.out.println("Come si chiama?");
        String nameGuerriero2 = sc.nextLine();
        System.out.println("Quanti punti vita ha?");
        int puntiVita2 = sc.nextInt();
        System.out.println("Quanti punti forza ha?");
        int puntiForza2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Che arma usa?");
        String tipoArma2 = sc.nextLine();

        Guerriero guerriero2 = new Guerriero(nameGuerriero2, puntiVita2, puntiForza2,tipoArma2);
        System.out.println(" ");
        System.out.println("Eccellente! Creiamo un mago ora!");
        System.out.println("Come si chiama?");
        String nameMago = sc.nextLine();
        System.out.println("Quanti punti vita ha?");
        int puntiVitaMago = sc.nextInt();
        System.out.println("Quanti punti intelligenza ha?");
        int puntiIntelligenzaMago = sc.nextInt();
        System.out.println("Quanti punti mana ha?");
        int puntiMana = sc.nextInt();
        System.out.println("Qual'è il suo incantesimo primario?");
        String incantesrimoPrimario = sc.nextLine();
        sc.nextLine();
        System.out.println("Qual'è il suo incantesimo secondario?");
        String incantesrimoSecondario = sc.nextLine();

        Mago mago = new Mago(nameMago, puntiVitaMago, puntiIntelligenzaMago,puntiMana,incantesrimoPrimario, incantesrimoSecondario);
        System.out.println(" ");
        System.out.println("Benissimo! Creiamo ora due guaritori!");
        System.out.println("Come si chiama il primo?");
        String nameGuaritore1 = sc.nextLine();
        System.out.println("Quanti punti vita ha?");
        int puntiGuaritore1 = sc.nextInt();
        System.out.println("Quanti punti mana ha?");
        int puntiManaGuaritore1 = sc.nextInt();
        System.out.println("Quanto è alto il suo potere curativo?");
        int potereCurativo1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Qual'è il suo strumento di cura? Puoi scegliere tra Pozione, Erbe Medicinali, Bastone Curativo.");
        String strumentoDiCura1 = sc.nextLine();

        Guaritore guaritore = new Guaritore(nameGuaritore1, puntiGuaritore1, puntiManaGuaritore1, potereCurativo1, strumentoDiCura1);

        System.out.println(" ");
        System.out.println("Ed infine il secondo guaritore!");
        System.out.println("Come si chiama?");
        String nameGuaritore2 = sc.nextLine();
        System.out.println("Quanti punti vita ha?");
        int puntiGuaritore2 = sc.nextInt();
        System.out.println("Quanti punti mana ha?");
        int puntiManaGuaritore2 = sc.nextInt();
        System.out.println("Quanto è alto il suo potere curativo?");
        int potereCurativo2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Qual'è il suo strumento di cura? Puoi scegliere tra Pozione, Erbe Medicinali, Bastone Curativo.");
        String strumentoDiCura2 = sc.nextLine();

        Guaritore guaritore2 = new Guaritore(nameGuaritore2, puntiGuaritore2, puntiManaGuaritore2, potereCurativo2, strumentoDiCura2);


        Goblin goblin = new Goblin("Gollum", 100, 10);
        Goblin smeagle = new Goblin("Smeagle", 100, 15);

        ClasseBasePersonaggio[] personaggio = {guerriero, guerriero2, mago, guaritore, guaritore2, goblin, smeagle};



        while (true) {
            System.out.println(" ");
            System.out.println("Oh no, ci sono due goblin sul nostro cammino! Dobbiamo difenderci.");
            System.out.println(" ");
            System.out.println("Scegli il tuo personaggio: ");
            System.out.println("1)" + personaggio[0].getNome());
            System.out.println("2)" + personaggio[1].getNome());
            System.out.println("3)" + personaggio[2].getNome());
            System.out.println("4)" + personaggio[3].getNome());
            System.out.println("5)" + personaggio[4].getNome());



            int selezione = sc.nextInt();
            sc.nextLine();

            switch (selezione) {
                case 1: case 2:
                    System.out.println("Ottima scelta! Cosa vuoi far fare al tuo personaggio?");
                    System.out.println(" ");
                    System.out.println("1) Incrementa la forza.");
                    System.out.println("2) Diminuisci la forza.");
                    System.out.println("3) Attacca.");
                    System.out.println("4) Cambia personaggio.");

                    int azionePersonaggio1; // da dichiarare fuori altrimenti non sa come accederci
                    do {
        azionePersonaggio1 = sc.nextInt();// devo riassegnare qui per far si che si aggiorni
                        Guerriero guerrieroScelto = (Guerriero)personaggio[selezione - 1]; // [selezione - 1] cosi da poter aver sempre l'indice corretto
        switch (azionePersonaggio1) {
            case 1:
                    guerrieroScelto.prendiPozione();
                break;

            case 2:
                    guerrieroScelto.malus();
                break;

            case 3:
                System.out.println(" ");
                System.out.println("Chi vuoi attaccare?");
                System.out.println(" ");
                System.out.println("1) Gollum");
                System.out.println("2) Smeagle");

                int selezioneNemico = sc.nextInt();

                if (selezioneNemico == 1) {
                    guerrieroScelto.combatti(goblin);
                } else {;
                   guerrieroScelto.combatti(smeagle);
                }
                break;


        }

    } while (azionePersonaggio1 !=4);
                    break;

                case 3:
                    System.out.println(" ");
                    System.out.println("Ah, un mago! Cosa vuoi far fare al tuo personaggio?");
                    System.out.println(" ");
                    System.out.println("1) Ricarica il mana.");
                    System.out.println("2) Attacca.");
                    System.out.println("3) Cambia personaggio.");

                    int azionePersonaggio2;
                    do {
                        azionePersonaggio2 = sc.nextInt();
                        Mago magoScelto = (Mago)personaggio[selezione - 1];
                        switch (azionePersonaggio2) {
                            case 1:
                                    magoScelto.ricaricaMana();
                                break;

                            case 2:
                                System.out.println(" ");
                                System.out.println("Chi vuoi attaccare?");
                                System.out.println(" ");
                                System.out.println("1) Gollum");
                                System.out.println("2) Smeagle");

                                int selezioneNemico = sc.nextInt();

                                if (selezioneNemico == 1) {
                                    magoScelto.combatti(goblin);
                                } else {;
                                    magoScelto.combatti(smeagle);
                                }
                                break;
                        }

                    } while (azionePersonaggio2 !=3);
                    break;

                case 4: case 5:
                    System.out.println(" ");
                    System.out.println("Molto bene! Cosa vuoi far fare al tuo personaggio?");
                    System.out.println(" ");
                    System.out.println("1) Ricarica il mana.");
                    System.out.println("2) Cura alleato.");
                    System.out.println("3) Cambia personaggio.");

                    int azionePersonaggio3;
                    do {
                        azionePersonaggio3 = sc.nextInt();
                        Guaritore guaritoreScelto = (Guaritore) personaggio[selezione - 1];
                        switch (azionePersonaggio3) {
                            case 1:
                                    guaritoreScelto.ricaricaMana();
                                break;

                            case 2:
                                System.out.println(" ");
                                System.out.println("Chi vuoi curare?");
                                System.out.println(" ");
                                System.out.println("1) Aragor");
                                System.out.println("2) Silente");

                                int selezioneAlleato = sc.nextInt();

                                if (selezioneAlleato == 1) {
                                    guaritoreScelto.curaAlleato(guerriero);
                                } else {;
                                  guaritoreScelto.curaAlleato(mago);
                                }
                                break;
                        }

                    } while (azionePersonaggio3 !=3);
                    break;



        }











    }
}}