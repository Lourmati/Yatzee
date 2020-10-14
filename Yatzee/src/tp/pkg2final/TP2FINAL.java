/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.pkg2final;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Oussama Lourhmati
 * Programme Java (pour le jeu Yatzee solitaire)
 */
public class TP2FINAL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int bonus = 0;//Déclaration des variables et des tableaux dont j'aurai besoin.
        int[] tabScore = new int[9];
        int choix = 0, jeuChoisi = 0, totalYatzee = 0, totalCarre = 0,
                totalSuite = 0;
        String reponse = "";
        int[] tabDes = new int[5];
        boolean[] tabResultats = new boolean[8];//Tableau pour enregistrer mes 9 résultats (tableau de 8, vu que ca commence a 0).

        affichageMenu();//Affichage du menu avec les règles du jeu, et pour demander a l'utilisateur s'il veut jouer.
        reponse = lire();//Lecture de la réponse de l'utilisateur (oui ou Oui)

        if (reponse.equals("oui") || reponse.equals("Oui")) {//Si il répond oui ou Oui, le programme du jeu va se lancer.

            while (tabResultats != rempli()) {//Tant que le tableau résultat n'est pas rempli, le jeu va continuer.
                tabDes = lancer();//Brassage des dés, au hasard.
                calculYatzee(tabDes);//Vérifier s'il y a un Yatzee, caculer le Yatzee et afficher la valeur du Yatzee
                calculCarre(tabDes);//Vérifier s'il y a un Carre, calculer le Carre et afficher la valeur du Carre.
                calculSuite(tabDes);//Vérifier s'il y a une Suite, calculer la Suite et afficher la valeur de la Suite.
                calculTotal(tabDes);//Vérifier s'il y a les totals, calculer les totals et afficher leurs valeurs respectives.

                for (int i = 2; i <= 3; i++) {//Rebrassage des dés (commence a la 2ieme fois pour finir a la 3ieme fois, i=2; i<=3)

                    System.out.print("\nEntrez les numéros de dés que vous\n"
                            + "souhaitez rebrasser (0 pour terminer)");//Demander a l'utilisateur les dés a rebrasser.

                    for (int i2 = 1; i2 <= tabDes.length; i2++) {
                        choix = lireChoix();//Lecture du choix de l'utilisateur
                        if (choix == 0) {//Si le choix est 0, tout de suite arreter le rebrassage.
                            break;
                        }
                        if (choix != 0) {//Si le choix !=0, on va passer a la méthode relancer.
                            relancer(choix, tabDes);
                        }

                    }
                    System.out.println("\nRésultat du lancer des dés - Tour "//Affichage des résultats pour le rebrassage.
                            + i
                            + "\ndé # 1 = " + tabDes[0]
                            + "\ndé # 2 = " + tabDes[1]
                            + "\ndé # 3 = " + tabDes[2]
                            + "\ndé # 4 = " + tabDes[3]
                            + "\ndé # 5 = " + tabDes[4]);

                    totalYatzee = calculYatzee(tabDes);//Je sauvegarde ici mes totals pour afin que je puisse les utiliser apres dans l'affichage de la partie.
                    totalCarre = calculCarre(tabDes);
                    totalSuite = calculSuite(tabDes);
                    tabScore = calculTotal(tabDes);

                }
                System.out.println("\nEntrez le chiffre du jeu choisi (1-9)\n"//Je demande quel jeux il veut garder.
                        + "\n====================================");
                jeuChoisi = lireChoix();//Lecture du choix de l'utilisateur

                System.out.println("\nPoints obtenus a date dans la partie");//Affichage des points.
                //Si le jeu choisi correspond a la section concernée, il y aura l'affichage des points et une sauvegarde dans le tableau
                //résultat afin de ne pas perdre les résultats.
                if (jeuChoisi == 1) {//Je n'ai pas utilisé de méthode ici, car il y a beaucoup de valeurs retournés dans le main dont j'ai besoin pour l'affichage.
                    System.out.println("1 - Yatzee = " + totalYatzee);
                    tabResultats[0] = true;
                } else {
                    totalYatzee = 0;
                    System.out.println("1 - Yatzee = " + totalYatzee);

                }
                //J'ai mis des espaces pour que ca soit un peu + clair.
                if (jeuChoisi == 2) {
                    System.out.println("2 - Carre = " + totalCarre);
                    tabResultats[1] = true;
                } else {
                    totalCarre = 0;
                    System.out.println("2 - Carre = " + totalCarre);

                }

                if (jeuChoisi == 3) {
                    System.out.println("3 - Suite = " + totalSuite);
                    tabResultats[2] = true;
                } else {
                    totalSuite = 0;
                    System.out.println("3 - Suite = " + totalSuite);

                }
                if (jeuChoisi == 4) {
                    System.out.println("4 - Total des 6 = " + tabScore[3]);
                    tabResultats[3] = true;
                } else {
                    tabScore[3] = 0;
                    System.out.println("4 - Total des 6 = " + tabScore[3]);

                }
                if (jeuChoisi == 5) {
                    System.out.println("5 - Total des 5 = " + tabScore[4]);
                    tabResultats[4] = true;
                } else {
                    tabScore[4] = 0;
                    System.out.println("5 - Total des 5 = " + tabScore[4]);

                }
                if (jeuChoisi == 6) {
                    System.out.println("6 - Total des 4 = " + tabScore[5]);
                    tabResultats[5] = true;
                } else {
                    tabScore[5] = 0;
                    System.out.println("6 - Total des 4 = " + tabScore[5]);

                }
                if (jeuChoisi == 7) {
                    System.out.println("7 - Total des 3 = " + tabScore[6]);
                    tabResultats[6] = true;
                } else {
                    tabScore[6] = 0;
                    System.out.println("7 - Total des 3 = " + tabScore[6]);

                }
                if (jeuChoisi == 8) {
                    System.out.println("8 - Total des 2 = " + tabScore[7]);
                    tabResultats[7] = true;
                } else {
                    tabScore[7] = 0;
                    System.out.println("8 - Total des 2 = " + tabScore[7]);

                }

                if (jeuChoisi == 9) {
                    System.out.println("9 - Total des 1 = " + tabScore[8]);
                    tabResultats[8] = true;
                } else {
                    tabScore[8] = 0;
                    System.out.println("9 - Total des 1 = " + tabScore[8]);

                }

                int totalUn = 0;//Nouvelle variable pour le total des points de la section 1.
                totalUn = tabScore[3] + tabScore[4] + tabScore[5] + tabScore[6]
                        + tabScore[7] + tabScore[8];
                if (totalUn >= 63) {//Si le total de la Section 1 est supérieur a 63, 25 points bonus sont accordés.
                    bonus = 25;
                    System.out.println("Bonus = " + bonus);
                } else {
                    System.out.println("Bonus = " + bonus);
                }

                int totalFinal = totalUn + totalYatzee + totalCarre
                        + totalSuite + bonus;// Nouvelle variable totalFinal, qui est la somme de tout les totals du jeu.
                System.out.println("Total des points = " + totalFinal);
            }
        }
    }

    private static String lire() {//Méthode pour lire String (la réponse).
        Scanner r = new Scanner(System.in);
        String reponse;
        reponse = r.nextLine();
        return reponse;
    }

    private static int lireChoix() {// Méthode pour lire le choix de l'utilisateur.
        Scanner r = new Scanner(System.in);
        int choix;
        choix = r.nextInt();
        return choix;
    }

    private static int[] lancer() {//Méthode pour le premier lancer des dés.
        int[] tab = new int[5];
        Random rand = new Random();//Utilisation du Random rand, pour brasser les dés au hasard.
        for (int i = 0; i < tab.length; i++) {
            tab[i] = rand.nextInt(6) + 1;
        }
        System.out.println("\nRésultat du lancer des dés - Tour 1"//Mini affichage des dés apres le premier lancer.
                + "\ndé # 1 = " + tab[0]
                + "\ndé # 2 = " + tab[1]
                + "\ndé # 3 = " + tab[2]
                + "\ndé # 4 = " + tab[3]
                + "\ndé # 5 = " + tab[4]);
        return tab;
    }

    private static int[] relancer(int choix, int[] tab) {//Méthode pour relancer les dés (2 et 3ieme fois).
        Random rand = new Random();
        if (choix >= 1 && choix <= 5) {
            tab[choix - 1] = rand.nextInt(6) + 1;//On fait tab[choix -1], car le tableau commence a 0 par défaut.
        } else {
            System.out.println("Entrez un nombre valide");
        }
        return tab;//On retourne le tableau.
    }

    private static int calculYatzee(int[] tabDes) {//La méthode pour la vérification, le calcul et l'affichage du Yatzee.
        System.out.println("\nPoints obtenus par les dés");
        int totalYatzee = 0;
        int compteur = 0;
        for (int i = 0; i < tabDes.length; i++) {
            if (tabDes[i] == tabDes[1]) {
                compteur++;
            }
            if (compteur == 5) {
                totalYatzee = 50;
            } else {
                totalYatzee = 0;
            }
        }
        System.out.println("1 - Yatzee = " + totalYatzee);
        return totalYatzee;//On retourne le total du yatzee afin qu'on puisse l'utiliser et le sauvegarder par la suite.
    }

    private static int calculCarre(int[] tabDes) {//La méthode pour la vérification, le calcul et l'affichage du Carre.
        int i, totalCarre = 0;
        int[] tabScore = new int[9];//Une nouveau tableauScore pour avoir le total a la fin.
        int[] tabX = new int[6];
        for (i = 0; i < tabDes.length; i++) {//Une boucle for pour rester dans la longueur du tableau.
            switch (tabDes[i]) {//J'ai utilisé un switch ici, a la place de plusieurs if.
                case 1:
                    tabX[0] += 1;
                    break;
                case 2:
                    tabX[1] += 1;
                    break;
                case 3:
                    tabX[2] += 1;
                    break;
                case 4:
                    tabX[3] += 1;
                    break;
                case 5:
                    tabX[4] += 1;
                    break;
                case 6:
                    tabX[5] += 1;
                    break;
            }
        }
        if ((tabX[0] == 4) || (tabX[1] == 4) || (tabX[2] == 4)
                || (tabX[3] == 4) || (tabX[4] == 4) || (tabX[5] == 4)) {
            for (i = 0; i < tabDes.length; i++) {
                tabScore[1] += tabDes[i];
            }
        } else {
            tabScore[1] = 0;
        }
        totalCarre = tabScore[1];
        System.out.println("2 - Carre = " + totalCarre);
        return totalCarre;//On retourne le total du carré afin qu'on puisse l'utiliser et le sauvegarder par la suite.
    }

    private static int calculSuite(int[] tabDes) {//La méthode pour la vérification, le calcul et l'affichage de la Suite.
        int totalSuite = 0;
        if (((tabDes[0] == 1) && (tabDes[1] == 2) && (tabDes[2] == 3)//Utilisation d'un simple if, pour vérifier s'il y a une suite(1,2,3,4,5) ou (2,3,4,5,6).
                && (tabDes[3] == 4)
                && (tabDes[4] == 5)) || ((tabDes[0] == 2) && (tabDes[1] == 3)
                && (tabDes[2] == 4) && (tabDes[3] == 5) && (tabDes[4] == 6))) {
            totalSuite = 40;
            System.out.println("3 - Suite = " + totalSuite);
        } else {
            System.out.println("3 - Suite = 0");
        }
        return totalSuite;//On retourne le total de la Suite afin qu'on puisse l'utiliser et le sauvegarder par la suite.
    }

    private static int[] calculTotal(int[] tabDes) {//La méthode pour la vérification, le calcul et l'affichage des totals de la Section 1.
        int[] tabScore = new int[9];
        int[] tab1 = new int[5];
        int i, i2, i3 = 6;
        for (i2 = 3; i2 < tabScore.length; i2++) {
            for (i = 0; i < tabDes.length; i++) {
                if (tabDes[i] == i3) {
                    tab1[i] = tabDes[i];
                } else {
                    tab1[i] = 0;
                }
                tabScore[i2] += tab1[i];
            }
            System.out.println((i2 + 1) + " - Total des " + i3 + " = "
                    + tabScore[i2]);
            i3--;
        }
        return tabScore;//On retourne le tabScore afin qu'on puisse l'utiliser apres dans l'affichage final et pour le sauvegarder.
    }

    private static boolean[] rempli() {//Méthode qui vérifie simplement si mon tableau Résultats est rempli (boolean, vrai ou faux)
        boolean tabResultats[] = new boolean[8];
        for (int i = 0; i < tabResultats.length; i++) {
            if (tabResultats[i] = true) {//Si mon tableau est vrai, il sera vrai. Alors il sera rempli.
                tabResultats[i] = true;
            }
        }
        return tabResultats;//On retourne le tabResultats.
    }

    private static void affichageMenu() {//Affichage du début (règles) et demande a l'utilisateur s'il veut jouer.
        System.out.println("****YATZEE****");
        System.out.println("Règles du jeu\n"
                + "° Le jeu se joue a l'aide de 5 dés ordinaires a 6 faces.\n"
                + "° La présente version se jouera en solitaire.\n"
                + "° Le but du jeu est de faire le plus de points possible en"
                + " réalisant un maximum de\n"
                + "  combinaisons possibles avec les dés lancés.");
        System.out.print("\nVoulez-vous jouer a Yatzee? Répondez oui "
                + "pour commencer une partie : ");
    }
}
