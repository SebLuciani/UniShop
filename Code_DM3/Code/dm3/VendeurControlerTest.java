package dm3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VendeurControlerTest {
    private Database database;
    private VendeurControler vendeurControler;

    @BeforeEach
    void setUp() {
        // Create a mock Database object
        database = new Database();
        // Create a VendeurControler with the mocked Database
        vendeurControler = new VendeurControler(database);
    }

    @Test
    void baseDeDonneesContientLeProduitAjoute() {
        // Créer un Produit
        Produit produit = new Produit("Example Product", "Category", "Description", 10, 100.0, 10, 1);

        // Appeler méthode vendreProduit
        vendeurControler.vendreProduit(produit);

        // Verifier que le produit ait été ajouté à la base de données
        assertTrue(database.getProduits().containsKey(produit.getTitre()));
        assertTrue(database.getProduits().containsValue(produit));
    }


    // On test pour toutes les sous classes de Produit
    @Test
    void testVendreEquipementBureau() {
        EquipementBureau equipementBureau = new EquipementBureau(
                "Chaise de bureau ergonomique", // titre
                "Mobilier de bureau", // categorie
                "Chaise ergonomique avec support lombaire", // description
                50, // quantiteInit
                149.99, // prix
                20, // numPointsBonus
                1001, // idUnique
                "ErgoChair", // marque
                "Model X", // modele
                "Chaises" // sousCat
        );
        vendeurControler.vendreProduit(equipementBureau);
        assertTrue(database.getProduits().containsKey(equipementBureau.getTitre()));
        assertTrue(database.getProduits().containsValue(equipementBureau));
    }

    @Test
    void testVendreArticlePapeterie() {
        ArticlePapeterie articlePapeterie = new ArticlePapeterie(
                "Stylo à bille bleu", // titre
                "Fournitures de bureau", // categorie
                "Stylos à bille bleue longue durée", // description
                100, // quantiteInit
                1.99, // prix
                5, // numPointsBonus
                1002, // idUnique
                "Bic", // marque
                "Cristal", // modele
                "Stylos" // sousCat
        );
        vendeurControler.vendreProduit(articlePapeterie);
        assertTrue(database.getProduits().containsKey(articlePapeterie.getTitre()));
        assertTrue(database.getProduits().containsValue(articlePapeterie));
    }

    @Test
    void testVendreMaterielInformatique() {
        MaterielInformatique materielInformatique = new MaterielInformatique(
                "Ordinateur portable ProBook", // titre
                "Électronique", // categorie
                "Ordinateur portable 15 pouces, 8GB RAM, 256GB SSD", // description
                30, // quantiteInit
                899.99, // prix
                50, // numPointsBonus
                1003, // idUnique
                "HP", // marque
                "ProBook 450 G7", // model
                "2023-01-01", // dateLancement
                "Ordinateurs portables" // sousCat
        );
        vendeurControler.vendreProduit(materielInformatique);
        assertTrue(database.getProduits().containsKey(materielInformatique.getTitre()));
        assertTrue(database.getProduits().containsValue(materielInformatique));
    }

    @Test
    void testVendreLivresEtManuels() {
        LivresEtManuels livresEtManuels = new LivresEtManuels(
                "Java Programming", // titre
                "Livres", // categorie
                "Manuel complet pour apprendre Java", // description
                200, // quantiteInit
                29.99, // prix
                15, // numPointsBonus
                1004, // idUnique
                97831614, // isbn
                "John Doe", // auteur
                "TechBooks", // maisonEdition
                "Éducation", // organisation
                "Informatique", // genre
                "2023-02-15", // dateParution
                1, // numeroEdition
                1 // numeroVolume
        );
        vendeurControler.vendreProduit(livresEtManuels);
        assertTrue(database.getProduits().containsKey(livresEtManuels.getTitre()));
        assertTrue(database.getProduits().containsValue(livresEtManuels));
    }

    @Test
    void testVendreRessourcesApprentissage() {
        RessourcesApprentissage ressourcesApprentissage = new RessourcesApprentissage(
                "Apprendre l'algèbre facilement", // titre
                "Ressources éducatives", // categorie
                "Guide interactif pour l'algèbre", // description
                150, // quantiteInit
                19.99, // prix
                10, // numPointsBonus
                1005, // idUnique
                978235, // isbn
                "Alice Smith", // auteur
                "Université", // organisation
                "2023-03-20", // dateParution
                true, // electronique
                2 // numeroEdition
        );
        vendeurControler.vendreProduit(ressourcesApprentissage);
        assertTrue(database.getProduits().containsKey(ressourcesApprentissage.getTitre()));
        assertTrue(database.getProduits().containsValue(ressourcesApprentissage));
    }

}