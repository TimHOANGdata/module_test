import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayName("Tester les operation arithmetiques de base")
//class MathUtilsTest {
//
//    @DisplayName("Tester la somme de 2 nombres.")
//    @Test // pour considerer le methode en dessous comme un test
//    void testAdd(){
//        var mathUtils = new MathUtils();
//        assertEquals(11,mathUtils.add(5,6));
//        assertEquals(12,mathUtils.add(8,4));
//        assertEquals(-3,mathUtils.add(-5,2));
//    }
//
//    @DisplayName("Tester la soustraction de 2 nombres.")
//    @Test // pour considerer le methode en dessous comme un test
//    void testSubstract() {
//        var nb1 = 10;
//        var nb2 = 6;
//        var expectedResult = 4;
//        var mathUtils = new MathUtils();
//        assertEquals(4, mathUtils.substract(nb1, nb2), String.format("%d - %d doit etre" +
//                "egal a %d",nb1,nb2,expectedResult));
//        // le message dans string format n'affiche que dans le case test echoue
//    }
//}
// les limits de ces tests
//1. le fait de reecrire les code avec les valeurs test
//2. le fait de creer l'instance de class mathUtils a chaque fois

class MathUtilsTest {
    //@BeforeAll: configuration avant les tests (creer ou se connecter à une base de donnees)
    //@BeforeEach: configuration avant chaque test (creer par exemple l'instance de la class
    // MathUtils).
    //@AfterEach: configuration apres chaque test(nettoyage...)
    //@AfterAll: configuration apres tous les tests(supprimer la base de donnees)
    private MathUtils mathUtils;

    @BeforeAll
    static void setup(){
        System.out.println("Execution de @BeforeAll");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Execution de @BeforeEach");
        mathUtils = new MathUtils();
    }

    @AfterEach
    void afterEach(){
        System.out.println("Execution de @AfterEach");
        mathUtils = null; //liberer les memoires
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Execution de @AfterAll");
    }


    @DisplayName("Tester la somme de 2 nombres.")
    @Test // pour considerer le methode en dessous comme un test
    void testAdd(){

        assertEquals(11,mathUtils.add(5,6));
        assertEquals(12,mathUtils.add(8,4));
        assertEquals(-3,mathUtils.add(-5,2));
    }

    @DisplayName("Tester la soustraction de 2 nombres.")
    @ParameterizedTest //test avec plusieurs parametres externes qui permet d'eviter les
    //duplications
    @CsvFileSource(resources = "/soustraction.csv") //utiliser les parametre d'une fichier csv
        // importer les file csv
        // creer un package "resources" dans le fichier test
        // test_unitaire => (click right) open module setting, select resources and select test resource.
    void testSubstract(int nb1, int nb2, int expectedResult) {
        assertEquals(expectedResult, mathUtils.substract(nb1, nb2), String.format("%d - %d doit etre" +
                "egal a %d",nb1,nb2,expectedResult));
        // le message dans string.format n'affiche que dans la case test echoue
    }


    @DisplayName("Tester le produit de 2 valeurs")
    @ParameterizedTest //test avec plusieurs parametres externes qui permet d'eviter les
    //duplications
    @CsvSource({
            "4,2,8",
            "50,2,100",
            "45,2,90",
            "8,8,64"
    }) // les parametres de type dans une fichier csv
    void testMultiply(int nb1,int nb2, int expected) {
        assertEquals(expected,mathUtils.multiply(nb1,nb2));
    }

    @DisplayName("Tester le rapport de 2 valeurs")
    @Test
    void testdivide() {
        assertEquals(2,mathUtils.divide(4,2));
    }
    @DisplayName("Tester si un nombre est pair")
    @ParameterizedTest
    @CsvFileSource(resources = "/is_even.csv")
    void TestIsEven(int number, boolean expectedResult) {
        assertEquals(expectedResult,mathUtils.isEven(number));
    }

    @DisplayName("Tester si un nombre est impair")
    @ParameterizedTest
    @CsvFileSource(resources = "/is_odd.csv")
    void TestIsOdd(int number, boolean expectedResult) {
        assertEquals(expectedResult,mathUtils.isOdd(number));
    }

}

