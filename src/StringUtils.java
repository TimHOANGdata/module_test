import java.util.Locale;

public class StringUtils {
    public static boolean isPalindrome(String str){
        String strLowerCased = str.toLowerCase();
        //2.add lowerCased to  correct test2 with majuscule
        String strRemoveEspace = strLowerCased.replace(" ","");
        //3. add RemoveEspace (replace espace by null) to correct test 3 with espace
        String strFormatted = strRemoveEspace.replaceAll("[^A-Za-z]","");
        //4. add Formatted to correct test with 4 with special characters
        // [^A-aa-z] means , tous les elements qui n'est pas lettre comme A-Z,a-z
        String reversed = "";
        for(String character:strFormatted.split("")){
            reversed=character + reversed;
        }
        return strFormatted.equals(reversed);
    }
}
