package dm3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        AccountController accountController = new AccountController(database);
        AccountVerifier accountVerifier = new AccountVerifier(database);
        InputVerifier inputVerifier = new InputVerifier();
        ProduitController produitController = new ProduitController(database);
        VendeurControler vendeurControler = new VendeurControler(database);

        ChoiceMaker choiceMaker = new ChoiceMaker(inputVerifier, accountController, accountVerifier, produitController, vendeurControler);
        MainEntranceUI mainEntrance = new MainEntranceUI(choiceMaker, inputVerifier);
        //OffrirProduitUI offrirProduit = new OffrirProduitUI();


        //Initialisation des 5 acheteurs:
        Acheteur acheteur1 = new Acheteur("ach", "teur1", "acheteur1", "a1@gmail.com", "124 pacifique", "123-123-1234", "123");
        Acheteur acheteur2 = new Acheteur("ach", "teur2", "acheteur2", "a2@gmail.com", "125 pacifique", "123-123-1234", "123");
        Acheteur acheteur3 = new Acheteur("ach", "teur3", "acheteur3", "a3@gmail.com", "126 pacifique", "123-123-1234", "123");
        Acheteur acheteur4 = new Acheteur("ach", "teur4", "acheteur4", "a4@gmail.com", "127 pacifique", "123-123-1234", "123");
        Acheteur acheteur5 = new Acheteur("ach", "teur5", "acheteur5", "a5@gmail.com", "128 pacifique", "123-123-1234", "123");
        Acheteur acheteur6 = new Acheteur("ach", "teur6", "acheteur6", "a6@gmail.com", "129 pacifique", "123-123-1235", "124");
        Acheteur acheteur7 = new Acheteur("ach", "teur7", "acheteur7", "a7@gmail.com", "130 pacifique", "123-123-1236", "125");
        Acheteur acheteur8 = new Acheteur("ach", "teur8", "acheteur8", "a8@gmail.com", "131 pacifique", "123-123-1237", "126");
        Acheteur acheteur9 = new Acheteur("ach", "teur9", "acheteur9", "a9@gmail.com", "132 pacifique", "123-123-1238", "127");
        Acheteur acheteur10 = new Acheteur("ach", "teur10", "acheteur10", "a10@gmail.com", "133 pacifique", "123-123-1239", "128");

        database.addAcheteur(acheteur1);
        database.addAcheteur(acheteur2);
        database.addAcheteur(acheteur3);
        database.addAcheteur(acheteur4);
        database.addAcheteur(acheteur5);
        database.addAcheteur(acheteur6);
        database.addAcheteur(acheteur7);
        database.addAcheteur(acheteur8);
        database.addAcheteur(acheteur9);
        database.addAcheteur(acheteur10);

        //Ajouter un suiveur à acheteur 1:
        acheteur1.addFollower(acheteur5);

        //Initialisation des 5 vendeurs:
        Vendeur vendeur1 = new Vendeur("Vendeur1", "v1@gmail.com", "123-123-1234", "120 pacifique", "321");
        Vendeur vendeur2 = new Vendeur("Vendeur2", "v2@gmail.com", "123-123-1234", "121 pacifique", "321");
        Vendeur vendeur3 = new Vendeur("Vendeur3", "v3@gmail.com", "123-123-1234", "122 pacifique", "321");
        Vendeur vendeur4 = new Vendeur("Vendeur4", "v4@gmail.com", "123-123-1234", "123 pacifique", "321");
        Vendeur vendeur5 = new Vendeur("Vendeur6", "v5@gmail.com", "123-123-1234", "124 pacifique", "321");

        database.addVendeur(vendeur1);
        database.addVendeur(vendeur2);
        database.addVendeur(vendeur3);
        database.addVendeur(vendeur4);
        database.addVendeur(vendeur5);

        //initialisation des 20 produits:
        EquipementBureau produit1 = new EquipementBureau("chaise", "bureau", "chaise de bureau", 2, 150, 0, 0, "herman miller", "3", "chaise de bureau");
        EquipementBureau produit2 = new EquipementBureau("lampe", "bureau", "lampe de bureau", 2, 15, 0, 1, "GOVEE", "3", "lampe de bureau");
        EquipementBureau produit3 = new EquipementBureau("laptop stand", "bureau", "stand pour laptop", 2, 13, 0, 2, "GSCOO", "1", "laptop stand");
        EquipementBureau produit6 = new EquipementBureau("table", "bureau", "table de bureau", 3, 250, 0, 5, "IKEA", "Linnmon", "table de bureau");
        EquipementBureau produit7 = new EquipementBureau("etagere", "bureau", "etagere de bureau", 3, 75, 0, 6, "IKEA", "Kallax", "etagere");
        EquipementBureau produit14 = new EquipementBureau("fauteuil", "bureau", "fauteuil de bureau confortable", 5, 200, 0, 13, "Steelcase", "Leap", "fauteuil");
        EquipementBureau produit15 = new EquipementBureau("organisateur de bureau", "bureau", "organisateur de bureau en bois", 10, 20, 0, 14, "IKEA", "Fjalla", "organisateur");

        MaterielInformatique produit4 = new MaterielInformatique("souris", "informatique", "souris sans fil", 2, 37, 0, 3, "Logitech", "MXMaster3", "2017", "souris");
        MaterielInformatique produit5 = new MaterielInformatique("clavier", "informatique", "clavier sans fil", 2, 67, 0, 4, "Logitech", "MechKeyb", "2019", "keyboard");
        MaterielInformatique produit16 = new MaterielInformatique("casque audio", "informatique", "casque audio sans fil", 15, 89, 0, 15, "Sony", "WH-1000XM4", "2020", "casque");

        ArticlePapeterie produit8 = new ArticlePapeterie("carnet", "papeterie", "carnet de notes", 50, 5, 0, 7, "Moleskine", "Classic", "carnet");
        ArticlePapeterie produit9 = new ArticlePapeterie("crayon", "papeterie", "crayon HB", 100, 0.5, 0, 8, "Faber-Castell", "HB", "crayon");
        ArticlePapeterie produit17 = new ArticlePapeterie("marqueur", "papeterie", "marqueurs colorés", 30, 1.2, 0, 16, "Stabilo", "Pen 68", "marqueurs");

        LivresEtManuels produit10 = new LivresEtManuels("Python Programming", "Livres", "Guide to learn Python", 50, 30, 0, 9, 978456789, "Jane Smith", "TechBooks", "Éducation", "Informatique", "2023-05-10", 1, 1);
        LivresEtManuels produit11 = new LivresEtManuels("Learn JavaScript", "Livres", "Beginners guide to JavaScript", 50, 25, 0, 10, 78023456, "John Doe", "CodeBooks", "Éducation", "Programmation", "2023-06-15", 1, 1);
        LivresEtManuels produit18 = new LivresEtManuels("Data Structures and Algorithms", "Livres", "In-depth guide to data structures and algorithms", 40, 45, 0, 17, 978321456, "Sarah Connor", "LearnBooks", "Éducation", "Informatique", "2023-01-20", 1, 1);

        RessourcesApprentissage produit12 = new RessourcesApprentissage("Mathematics for Engineers", "Ressources éducatives", "Comprehensive guide for engineering mathematics", 100, 20, 0, 11, 7236789, "Alice Martin", "Université", "2023-04-20", true, 3);
        RessourcesApprentissage produit13 = new RessourcesApprentissage("Physics Basics", "Ressources éducatives", "Basic concepts of physics", 100, 15, 0, 12, 814892, "Bob Johnson", "École", "2023-03-25", false, 2);
        RessourcesApprentissage produit19 = new RessourcesApprentissage("Introduction to Economics", "Ressources éducatives", "Basics of economics for beginners", 80, 18, 0, 18, 987654321, "Mark Spencer", "Économie Université", "2023-02-11", true, 1);
        RessourcesApprentissage produit20 = new RessourcesApprentissage("Chemistry Essentials", "Ressources éducatives", "Fundamentals of chemistry", 60, 22, 0, 19, 123987456, "Laura Beth", "Science École", "2023-04-05", false, 1);

        // Ajouter les produits à la base des données
        database.addProduit(produit1);
        database.addProduit(produit2);
        database.addProduit(produit3);
        database.addProduit(produit4);
        database.addProduit(produit5);
        database.addProduit(produit6);
        database.addProduit(produit7);
        database.addProduit(produit8);
        database.addProduit(produit9);
        database.addProduit(produit10);
        database.addProduit(produit11);
        database.addProduit(produit12);
        database.addProduit(produit13);
        database.addProduit(produit14);
        database.addProduit(produit15);
        database.addProduit(produit16);
        database.addProduit(produit17);
        database.addProduit(produit18);
        database.addProduit(produit19);
        database.addProduit(produit20);

        //Initialisation des 10 commandes:
        ArrayList<Produit> com1 = new ArrayList<>();
        ArrayList<Produit> com2 = new ArrayList<>();
        ArrayList<Produit> com3 = new ArrayList<>();
        ArrayList<Produit> com4 = new ArrayList<>();
        ArrayList<Produit> com5 = new ArrayList<>();
        ArrayList<Produit> com6 = new ArrayList<>();
        ArrayList<Produit> com7 = new ArrayList<>();
        ArrayList<Produit> com8 = new ArrayList<>();
        ArrayList<Produit> com9 = new ArrayList<>();
        ArrayList<Produit> com10 = new ArrayList<>();

        // Ajout de produits aux commandes
                // Pas tous les produits disponibles ont étés commandés
        com1.add(produit1);
        com1.add(produit10);
        com2.add(produit2);
        com3.add(produit3);
        com4.add(produit4);
        com5.add(produit5);
        com6.add(produit6);
        com7.add(produit7);
        com8.add(produit8);
        com9.add(produit9);
        com10.add(produit11);
        com10.add(produit12);
        com10.add(produit13);

        // Initialiser comme des instances de "Commande"
        Commande commande1 = new Commande(com1);
        Commande commande2 = new Commande(com2);
        Commande commande3 = new Commande(com3);
        Commande commande4 = new Commande(com4);
        Commande commande5 = new Commande(com5);
        Commande commande6 = new Commande(com6);
        Commande commande7 = new Commande(com7);
        Commande commande8 = new Commande(com8);
        Commande commande9 = new Commande(com9);
        Commande commande10 = new Commande(com10);

        // Attribuer les commandes aux acheteurs
        acheteur1.addCommande(commande1);
        acheteur2.addCommande(commande2);
        acheteur3.addCommande(commande3);
        acheteur4.addCommande(commande4);
        acheteur5.addCommande(commande5);
        acheteur6.addCommande(commande6);
        acheteur7.addCommande(commande7);
        acheteur8.addCommande(commande8);
        acheteur9.addCommande(commande9);
        acheteur10.addCommande(commande10);

        //Modification de l'etat des commandes
        commande2.enLivraison();
        commande3.livre();

        while (true){
            mainEntrance.displayMainEntrance();
        }
    }
}
