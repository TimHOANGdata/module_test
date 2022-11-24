import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @DisplayName("Tester si une chaine est un palindrome")
    @ParameterizedTest
    @CsvFileSource(resources = "/palindrome.csv")
    void testIfStringIsPalindrome(String value, boolean expectedResult) {
        assertEquals(expectedResult, StringUtils.isPalindrome(value));
        // 1. Tester une chaine simple (ana,true)
        // 2. Tester une chaine avec les lettres en majuscules (add Ana,True to the palindrome.csv)
        // 3. Tester une chaine avec l'espace (add an "a,True" and "a n a,true"to palindrom.csv)
        // 4. Tester une chaine avec des charateres speciaux (add " a-n?a,true)
        // Test driven development , tous les tests ont une modification dans le fichier StringUtils
    }

    @DisplayName("Tester si un mot est prefix d'un autre mot")
    @ParameterizedTest
    @CsvFileSource(resources = "/is_prefix.csv")
    void testIfStringIsPrefix(String value1, String value2, boolean expectedResult) {
        assertEquals(expectedResult, StringUtils.isPrefix(value1, value2));

        //1. test minimal - add abccbc,abc,true to is_prefix.csv
        //2. test with space, special characters and majuscule - add (ABccbc,abc,true) (ABc cbc,a bc,True)
        //  ( Abc@ cbc,a!bc,true) to is_prefix.csv
        //
    }

    @DisplayName("Tester si 2 mots sont anagram")
    @ParameterizedTest
    @CsvFileSource(resources = "/is_anagram.csv")
    void testAnagram(String value1, String value2, boolean expectedResult) {
        assertEquals(expectedResult, StringUtils.isAnagram(value1, value2));
        //1. test minimal - add rage,gare,true to is_anagram.csv
        //2. test avec espace, special characters and majuscule - add (rag e, ga re,true) add (Rage,gare,true)
        // and(ra#ge,gare!,true)
    }

    @DisplayName("Tester reverse un string")
    @Test
    void testReverse() {
        assertEquals("fedcba", StringUtils.reverseString("abcdef"));
        //1.test minimal with abcdef,fedcba
        assertEquals("fedcba", StringUtils.reverseString("ABcdef"));
        //2. test with majuscule
        assertEquals("fedcba", StringUtils.reverseString("A!B-c def"));
        //3. test with space and special characters
    }

    @DisplayName("Tester reverse un entier")
    @ParameterizedTest
    @CsvFileSource(resources = "/reverse_int.csv")
    void testReverseInt(int value, int expectedResult) {
        assertEquals(expectedResult, StringUtils.reverseInt(value));
        //1.test minimal add 123,321 and -123,-321 to reverse_int.csv
        //2. test avec 20,2 -30,3

    }

    @DisplayName("Tester mettre toutes les premieres lettre des mots en majuscules")
    @ParameterizedTest
    @CsvSource({
            "je suis dans la joie,Je Suis Dans La Joie"
    })
    void testCapitalize(String value, String expectedResult) {
        assertEquals(expectedResult, StringUtils.capitalze(value));
        //1. test minimal, add je suis dans la joie, Je Suis Dans La Joie to capitalize.csv
    }

    @DisplayName("Tester capitalizer les lettrer Alternativement")
    @Test
    void testAlternate() {
        assertArrayEquals(new char[]{'a', 'B', 'c', 'D', 'e'},StringUtils.alternate(new char[]{'a', 'b', 'c', 'd', 'e'}));
    }
    @DisplayName("Tester la direction")
    @Test
    void testDirection() {
        assertArrayEquals(new int[]{-1,2},StringUtils.direction(new String[]{"haut", "haut", "bas", "gauche", "gauche", "droite", "haut"}));
    }

}
