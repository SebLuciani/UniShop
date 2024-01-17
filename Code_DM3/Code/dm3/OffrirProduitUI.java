package dm3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OffrirProduitUI {
    private Scanner scanner;
    private ChoiceMaker choiceMaker;
    private AccountController accountController;
    private InputVerifier inputVerifier;
    private AccountVerifier accountVerifier;
    private ProduitController produitController;
    private VendeurControler vendeurControler;

    public OffrirProduitUI(ChoiceMaker choiceMaker, AccountController accountController, InputVerifier inputVerifier, AccountVerifier accountVerifier, VendeurControler vendeurControler, ProduitController produitController){
        this.choiceMaker = choiceMaker;
        this.accountController = accountController;
        this.inputVerifier = inputVerifier;
        this.accountVerifier = accountVerifier;
        this.vendeurControler = vendeurControler;
        this.produitController = produitController;
        this.scanner = new Scanner(System.in);
    }

    public void choisirCategorieProduit(Vendeur vendeur) {
        //C'est ici qu'on va demander toutes les informations puis qu'on mettra le produit
        //dans la bonne liste ou hashmap de la data base.
        int choice = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println("Indiquer la catégorie du produit désirée : \n" +
                        "1. Equipement de Bureau\n" +
                        "2. Article de Papeterie\n" +
                        "3. Materiel Informatique\n" +
                        "4. Livre ou Manuel\n" +
                        "5. Ressources d'apprentissage\n" +
                        "6. Type non spécifié / Autre\n");

                choice = scanner.nextInt();
                choice = this.inputVerifier.validateInput(choice, 1, 6);
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, vous devez entrer un entier.");
                scanner.next(); // pour clear l'input invalide et faire un autre essai
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                //loop continue pour un autre essai.
            }

            this.choiceMaker.ecranChoixCategorie(choice, vendeur);
        }
    }
    public void offrirProduits(String cat, Vendeur vendeur) {
        String categorie = cat;

        String titre = demanderString("Quel est le titre / nom de votre produit?");
        String description = demanderString("Donner s'il vous plaît la description de votre produit:");
        int quantiteInit = demanderInt("Quel est le stock / quantité initiale de votre produit?");
        double prix = demanderDouble("Quel est le prix de votre produit? Donnez un nombre décimal.");
        int numPointsBonus = demanderInt("Combien de points bonus ? Insérez un entier.");
        System.out.println("On va générer l'identifiant unique pour vous.");
        int idUnique = this.produitController.generateIDUnique();
        System.out.println("Identifiant unique généré : " + idUnique);

        if (categorie.equals("autre")) {
            categorie = demanderString("Quelle est la catégorie de votre produit?");
            vendeurControler.vendreProduit(new Produit(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique));
        } else if (categorie.equals("Equipement Bureau")){
            Produit produit = demanderInfosEquipementBureau(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique);
            vendeurControler.vendreProduit(produit);
        } else if (categorie.equals("Article de papeterie")){
            Produit produit = demanderInfosArticlePapeterie(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique);
            vendeurControler.vendreProduit(produit);
        } else if (categorie.equals("Materiel Informatique")){
            Produit produit = demanderInfosMaterielInformatique(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique);
            vendeurControler.vendreProduit(produit);
        } else if (categorie.equals("Livre ou Manuel")){
            Produit produit = demanderInfosLivresEtManuels(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique);
            vendeurControler.vendreProduit(produit);
        } else if (categorie.equals("Ressources d'apprentissage")){
            Produit produit = demanderInfosRessourcesApprentissage(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique);
            vendeurControler.vendreProduit(produit);
        }

        System.out.println("Le produit a été mis en vente avec succès.");
        // Retourner à l'accueil vendeur :
        EcranAccueilUI accueil = new EcranAccueilUI(choiceMaker, inputVerifier, accountVerifier, accountController);
        accueil.displayAccueilVend(vendeur);

    }

    public Produit demanderInfosEquipementBureau(String titre, String categorie, String description,
                                                 int quantiteInit, double prix, int numPointsBonus, int idUnique) {
        String marque = demanderString("Quelle est la marque de votre équipement de bureau?");
        String modele = demanderString("Quel est le modèle de votre équipement de bureau?");
        String sousCat = demanderString("Quelle est la sous-catégorie de votre équipement de bureau?");

        return new EquipementBureau(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique, marque, modele, sousCat);
    }

    public Produit demanderInfosArticlePapeterie(String titre, String categorie, String description,
                                                 int quantiteInit, double prix, int numPointsBonus, int idUnique) {
        String marque = demanderString("Quelle est la marque de l'article de papeterie?");
        String modele = demanderString("Quel est le modèle de l'article de papeterie?");
        String sousCat = demanderString("Quelle est la sous-catégorie de l'article de papeterie?");

        return new ArticlePapeterie(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique, marque, modele, sousCat);
    }

    public Produit demanderInfosMaterielInformatique(String titre, String categorie, String description,
                                                     int quantiteInit, double prix, int numPointsBonus, int idUnique) {
        String marque = demanderString("Quelle est la marque du matériel informatique?");
        String modele = demanderString("Quel est le modèle du matériel informatique?");
        String dateLancement = demanderString("Quelle est la date de lancement du matériel informatique?");
        String sousCat = demanderString("Quelle est la sous-catégorie du matériel informatique?");

        return new MaterielInformatique(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique, marque, modele, dateLancement, sousCat);
    }

    public Produit demanderInfosLivresEtManuels(String titre, String categorie, String description,
                                                int quantiteInit, double prix, int numPointsBonus, int idUnique) {
        int isbn = demanderInt("Quel est l'ISBN du livre ou manuel?");
        String auteur = demanderString("Qui est l'auteur du livre ou manuel?");
        String maisonEdition = demanderString("Quelle est la maison d'édition?");
        String organisation = demanderString("Quelle est l'organisation associée?");
        String genre = demanderString("Quel est le genre du livre ou manuel?");
        String dateParution = demanderString("Quelle est la date de parution?");
        int numeroEdition = demanderInt("Quel est le numéro d'édition?");
        int numeroVolume = demanderInt("Quel est le numéro de volume?");

        return new LivresEtManuels(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique, isbn, auteur, maisonEdition, organisation, genre, dateParution, numeroEdition, numeroVolume);
    }

    public Produit demanderInfosRessourcesApprentissage(String titre, String categorie, String description,
                                                        int quantiteInit, double prix, int numPointsBonus, int idUnique) {
        int isbn = demanderInt("Quel est l'ISBN de la ressource d'apprentissage?");
        String auteur = demanderString("Qui est l'auteur de la ressource d'apprentissage?");
        String organisation = demanderString("Quelle est l'organisation associée?");
        String dateParution = demanderString("Quelle est la date de parution?");
        boolean electronique = demanderBoolean("La ressource est-elle électronique (oui/non)?");
        int numeroEdition = demanderInt("Quel est le numéro d'édition?");

        return new RessourcesApprentissage(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique, isbn, auteur, organisation, dateParution, electronique, numeroEdition);
    }

    protected String demanderString(String text){
        String input = "";
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println(text);
                input = scanner.nextLine();
                if (input.isEmpty()){
                    System.out.println("S'il vous plaît écrivez quelque chose.");
                } else {
                    valid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, vous devez entrer un texte / String.");
                scanner.next(); // pour clear l'input invalide et faire un autre essai
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                //loop continue pour un autre essai.
            }
        }
        return input;
    }

    protected int demanderInt(String text){
        int input = -1;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println(text);
                input = scanner.nextInt();
                if (input < 0){
                    System.out.println("S'il vous plaît écrivez un entier positif.");
                } else {
                    valid = true;
                }
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, vous devez entrer un entier.");
                scanner.next(); // pour clear l'input invalide et faire un autre essai
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                //loop continue pour un autre essai.
            }
        }
        return input;
    }

    protected double demanderDouble(String text){
        double input = -1;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println(text);
                input = scanner.nextDouble();
                if (input < 0){
                    System.out.println("S'il vous plaît écrivez un nombre décimal positif.");
                } else {
                    valid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, vous devez entrer un double.");
                scanner.next(); // pour clear l'input invalide et faire un autre essai
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                //loop continue pour un autre essai.
            }
        }
        return input;
    }

    protected boolean demanderBoolean(String text){
        String input = "";
        boolean valid = false;
        boolean result = true;

        while (!valid) {
            try {
                System.out.println(text);
                input = scanner.nextLine();
                input = input.toLowerCase();

                if (input.equals("oui")){
                    valid = true;
                    result = true;
                } else if (input.equals("non")) {
                    valid = true;
                    result = false;
                } else {
                    System.out.println("Entrée invalide. Veuillez entrer 'oui' ou 'non'.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, vous devez entrer un texte / String.");
                scanner.next(); // pour clear l'input invalide et faire un autre essai
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                //loop continue pour un autre essai.
            }
        }
        return result;
    }
}
