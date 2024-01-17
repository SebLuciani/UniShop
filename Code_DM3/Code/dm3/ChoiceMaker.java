package dm3;

public class ChoiceMaker {

    public InputVerifier inputVerifier;
    public AccountVerifier accountVerifier;
    public AccountController accountController;
    public ProduitController produitController;
    public VendeurControler vendeurControler;

    public ChoiceMaker(InputVerifier inputVerifier, AccountController accountController, AccountVerifier accountVerifier, ProduitController produitController, VendeurControler vendeurControler){
        this.inputVerifier = inputVerifier;
        this.accountController = accountController;
        this.accountVerifier = accountVerifier;
        this.produitController = produitController;
        this.vendeurControler = vendeurControler;
    }
    public void mainEntranceChoice(int choix){
        if (choix == 1){
            CreateAnAccountUI createUI = new CreateAnAccountUI(this, this.inputVerifier, this.accountVerifier, this.accountController);
            createUI.displayCreateAccountScreen();
        }
        else {
            LoginUI loginUI = new LoginUI(this, this.inputVerifier, this.accountVerifier, this.accountController);
            loginUI.displayLoginScreen();
        }
    }

    public boolean createAccountAchOuVend(int choice){
        if (choice == 1){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean loginAccountAchOuVend(int choice){
        if (choice == 1){       // Acheteur
            return true;
        }
        else {
            return false;       // Vendeur
        }
    }

    public void ecranAccueilAchDecision(int choice, Acheteur acheteur){
        if (choice == 1){
            //consulterProfil ------------------------- done
            ProfilUI profil = new ProfilUI(this, this.accountController, this.inputVerifier, this.accountVerifier);
            profil.displayProfilAch(acheteur);
        }
        else if (choice == 2) {
            //consulterDerniersAchats ----------------- done
            DernierAchatsUI dernierAchats = new DernierAchatsUI(this, this.accountController, this.inputVerifier, this.accountVerifier);
            dernierAchats.displayDerniersAchatsUI(acheteur);
        }
        else if (choice == 3) {
            //Effectuer une recherche ------------------ done
            RechercheUI recherche = new RechercheUI(acheteur, this, this.accountController, this.inputVerifier);
            recherche.displayRecherche();
        }
        else if (choice == 4) {
            //ConsulterTimeline  ----------------------- done
            TimelineUI timeline = new TimelineUI(acheteur, this, this.accountController, this.inputVerifier, this.accountVerifier);
            timeline.displayTimeline();
        }
        else if (choice == 5) {
            //logout
            MainEntranceUI mainEntance = new MainEntranceUI(this, this.inputVerifier);
            mainEntance.displayMainEntrance();
        }
    }
    public void ecranAccueilVendDecision(int choice, Vendeur vendeur){
        if (choice == 1){
            ProfilUI profil = new ProfilUI(this, this.accountController, this.inputVerifier, this.accountVerifier);
            profil.displayProfilVend(vendeur);
        }
        else if (choice == 2){
            VentesUI ventes = new VentesUI(this, accountController, inputVerifier, accountVerifier);
            ventes.displayVentes(vendeur);
        }
        else if (choice == 3){
            OffrirProduitUI offrirProduit = new OffrirProduitUI(this, accountController, inputVerifier, accountVerifier, vendeurControler, produitController);
            offrirProduit.choisirCategorieProduit(vendeur);
        }
    }

    public void ecranChoixCategorie(int choice, Vendeur vendeur){
        OffrirProduitUI offrirProduitUI = new OffrirProduitUI(this, accountController, inputVerifier, accountVerifier, vendeurControler, produitController);
        if (choice == 1){           // Equipement Bureau
            offrirProduitUI.offrirProduits("Equipement Bureau", vendeur);
        }
        else if (choice == 2){      // Article de papeterie
            offrirProduitUI.offrirProduits("Article de papeterie", vendeur);
        }
        else if (choice == 3){      // Materiel Informatique
            offrirProduitUI.offrirProduits("Materiel Informatique", vendeur);
        }
        else if (choice == 4) {     // Live ou Manuel
            offrirProduitUI.offrirProduits("Livre ou Manuel", vendeur);
        }
        else if (choice == 5){      //Ressources d'apprentissage
            offrirProduitUI.offrirProduits("Ressources d'apprentissage", vendeur);
        } else {
            offrirProduitUI.offrirProduits("autre", vendeur);
        }
    }

    public void modifProfilAch(int choice, Acheteur acheteur, String newModif){
        if (choice == 1){
            acheteur.setPrenom(newModif);
        }
        else if (choice == 2){
            acheteur.setNom(newModif);
        }
        else if (choice == 3){
            acheteur.setPseudo(newModif);//Faudrait valider dans les prochaines iterations
        }
        else if (choice == 4){
            acheteur.setEmail(newModif);//Faudrait valider dans les prochaines iterations
        }
        else if (choice == 5){
            acheteur.setAdresse(newModif);
        }
        else {
            acheteur.setTelephone(newModif);
        }

    }

    public void modifProfilVend(int choice, Vendeur vendeur, String newModif){
        if (choice == 1){
            vendeur.setNom(newModif); //Faudrait valider dans les prochaines iterations
        }
        else if (choice == 2){
            vendeur.setEmail(newModif);//Faudrait valider dans les prochaines iterations
        }
        else if (choice == 3){
            vendeur.setAdresseEntrepot(newModif);
        }
        else {
            vendeur.setTelephone(newModif);
        }

    }

    public void derniersAchatsDecision(int choice, Acheteur acheteur){
        if (choice == 1){
            //Accuser reception d'une commande
            System.out.println("Fonctionnalite pas encore disponible, retour au profil");
            //on va aller chercher la liste des commandes dans l'objet Acheteur et l'afficher
            //pour demander quelle commande l'acheteur veut choisir.
            ProfilUI profil = new ProfilUI(this, this.accountController, this.inputVerifier, this.accountVerifier);
            profil.displayProfilAch(acheteur);
        }
        else if (choice == 2){
            //Consulter l'etat d'une commande
            System.out.println("Fonctionnalite pas encore disponible, retour au profil");
            //on va aller chercher la liste des commandes dans l'objet Acheteur et l'afficher
            //pour demander quelle commande l'acheteur veut choisir.
            ProfilUI profil = new ProfilUI(this, this.accountController, this.inputVerifier, this.accountVerifier);
            profil.displayProfilAch(acheteur);
        }
        else if (choice == 3){
            //Evaluer une commande
            System.out.println("Fonctionnalite pas encore disponible, retour au profil");
            //on va aller chercher la liste des commandes dans l'objet Acheteur et l'afficher
            //pour demander quelle commande l'acheteur veut choisir.
            ProfilUI profil = new ProfilUI(this, this.accountController, this.inputVerifier, this.accountVerifier);
            profil.displayProfilAch(acheteur);
        }
        else if (choice == 4){
            //Signaler un probleme
            System.out.println("Fonctionnalite pas encore disponible, retour au profil");
            //on va aller chercher la liste des commandes dans l'objet Acheteur et l'afficher
            //pour demander quelle commande l'acheteur veut choisir.
            ProfilUI profil = new ProfilUI(this, this.accountController, this.inputVerifier, this.accountVerifier);
            profil.displayProfilAch(acheteur);
        }
        else if (choice == 5){
            //Demander un retour/echange
            System.out.println("Fonctionnalite pas encore disponible, retour au profil");
            //on va aller chercher la liste des commandes dans l'objet Acheteur et l'afficher
            //pour demander quelle commande l'acheteur veut choisir.
            ProfilUI profil = new ProfilUI(this, this.accountController, this.inputVerifier, this.accountVerifier);
            profil.displayProfilAch(acheteur);
        }
        else {
            EcranAccueilUI accueil = new EcranAccueilUI(this, this.inputVerifier, this.accountVerifier, this.accountController);
            accueil.displayAccueilAch(acheteur);
        }
    }

    public void rechercheDecision(int choice, Acheteur acheteur){
        if (choice == 1){
            //Demander la categorie voulue, demander les critères de filtres, donner ces 
            //informations a database searcher qui va se charger de sortir tous les
            //produits qui respectent ces criteres et les trier selon les filtres
            System.out.println("fonctionnalite non disponible, retour au profil");
            ProfilUI profil = new ProfilUI(this, this.accountController, this.inputVerifier, this.accountVerifier);
            profil.displayProfilAch(acheteur);
        }
        else if (choice==2){
            //Recevoir le mot cle et les filtres, faire la recherche demandee
            //database searcher va sortir les bons produits et les trier selon les
            //filtres choisis.
            System.out.println("fonctionnalite non disponible, retour au profil");
            ProfilUI profil = new ProfilUI(this, this.accountController, this.inputVerifier, this.accountVerifier);
            profil.displayProfilAch(acheteur);
        }
        else if (choice==3){
            //Recevoir le mot cle et les filtres, faire la recherche demandee
            //accountController va sortir les bons vendeurs et les trier selon les
            //filtres choisis.
            System.out.println("fonctionnalite non disponible, retour au profil");
            ProfilUI profil = new ProfilUI(this, this.accountController, this.inputVerifier, this.accountVerifier);
            profil.displayProfilAch(acheteur);
        }
        else if (choice == 4) {
            //Aller chercher la liste des acheteurs et l'afficher.
            this.accountController.showAllAcheteurs();
            //Revient ensuite au profil
            ProfilUI profil = new ProfilUI(this, this.accountController, this.inputVerifier, this.accountVerifier);
            profil.displayProfilAch(acheteur);
        }
        else if (choice == 5){
            RechercheUI recherche = new RechercheUI(acheteur, this, this.accountController, this.inputVerifier);
            recherche.rechercheAcheteur();
        }
        else {
            EcranAccueilUI accueil = new EcranAccueilUI(this, this.inputVerifier, this.accountVerifier, this.accountController);
            accueil.displayAccueilAch(acheteur);
        }

    }

    
    
}
