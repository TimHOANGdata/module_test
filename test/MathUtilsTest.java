import org.junit.jupiter.api.*;

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
    @Test // pour considerer le methode en dessous comme un test
    void testSubstract() {
        var nb1 = 10;
        var nb2 = 6;
        var expectedResult = 4;
        assertEquals(4, mathUtils.substract(nb1, nb2), String.format("%d - %d doit etre" +
                "egal a %d",nb1,nb2,expectedResult));
        // le message dans string format n'affiche que dans le case test echoue
    }
}