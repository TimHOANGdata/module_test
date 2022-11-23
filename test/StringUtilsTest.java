import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @DisplayName("Tester si une chaine est un palindrome")
    @ParameterizedTest
    @CsvFileSource(resources = "/palindrome.csv")
    void testIfStringIsPalindrome(String value, boolean expectedResult){
        assertEquals(expectedResult,StringUtils.isPalindrome(value));
        // 1. Tester une chaine simple (ana,true)
        // 2. Tester une chaine avec les lettres en majuscules (add Ana,True to the palindrome.csv)
        // 3. Tester une chaine avec l'espace (add an "a,True" and "a n a,true"to palindrom.csv)
        // 4. Tester une chaine avec des charateres speciaux (add " a-n?a,true)
        // Test driven development , tous les tests ont une modification dans le fichier StringUtils
    }
}
