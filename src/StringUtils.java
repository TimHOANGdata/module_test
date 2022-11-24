import java.util.Arrays;
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

        static boolean isPrefix(String str1,String str2){
            String str1Formatted = str1.replaceAll("[^A-Za-z]", "").toLowerCase();
            String str2Formatted = str1.replaceAll("[^A-Za-z]", "").toLowerCase();
            // 2. add formatted and replace str1 and str2 by str1Formatted and str2Formatted to solve test 2
            if(str1Formatted.length()>str2Formatted.length()){
                return str1Formatted.substring(0,str2Formatted.length()).equals(str2Formatted);
            }else{
                return str2Formatted.substring(0,str1Formatted.length()).equals(str1Formatted);
            }
        }


        public static boolean isAnagram(String str1,String str2) {
            String[] str1Format = (str1.replaceAll("[^A-Za-z]", "").toLowerCase().split(""));
            String[] str2Format = (str2.replaceAll("[^A-Za-z]", "").toLowerCase().split(""));

            Arrays.sort(str1Format);
            Arrays.sort(str2Format);

            if (str1.length() != str2.length()) {
                return false;
            }

//        String building
            StringBuilder  arrStr1=new StringBuilder();
            for(String letter:str1Format){
                arrStr1.append(letter);
            }

            StringBuilder  arrStr2=new StringBuilder();
            for(String letter:str2Format){
                arrStr2.append(letter);
            }
//            return (!arrStr1.toString().equals(arrStr2.toString()));
            return (arrStr1.toString().equals(arrStr2.toString()));
            // test minimal return false => remove "!"

        }


        //    Renverser une chaine : papa => apap
        public static String reverseString(String str){
            String reversed="";
            String strFormatted = str.replaceAll("[^A-Za-z]","").toLowerCase();
            //add formatted to solve test 2 and test 3
            for(String letter:strFormatted.split("")){
                reversed = letter+reversed;
            }
            return reversed;
        }


        //    Test si une chaine passé en paramètre est un palindrome
//        public static boolean isPalindrom(String str) {
//            String formattedStr=str.replaceAll("[^A-Za-z]","");
//            String reversedStr=reverseString(formattedStr);
//
//            return  formattedStr.equals(reversedStr);
//        }

        //    Renverser un entier :  10 => 1 , -89 => -98
        public static int reverseInt(int number){
            String numberToStr=Integer.toString(number).replaceAll("[^0-9]","");//retirer le "-"

            String reversedStr="";
            for(String letter:numberToStr.split("")){
                reversedStr=letter+reversedStr;
            }

            int reversedToInt=(int) (Integer.parseInt(reversedStr)*Math.signum(number));
            return reversedToInt;
        }


        //    Mettre toutes les premieres lettre des mots en majuscules
//    je suis dans la joie => Je Suis Dans La Joie
        public static String capitalze(String str) {
            String capitalized=String.valueOf(str.charAt(0)).toUpperCase();
            String[] strToArr=str.split("");
            System.out.println(Arrays.toString(strToArr));
            for(int i=1;i<strToArr.length;i++){
                if(strToArr[i-1].equals(" ")){
                    capitalized +=strToArr[i].toUpperCase();
                }else{
                    capitalized +=strToArr[i];
                }
            }
            return capitalized;
        }

        //   [a, b, c, d, e] => [a, B, c, D, e]
        static char[] alternate(char[] chars){
            char[] alternateChar=new char[chars.length];
            alternateChar[0]=chars[0];
            for (int i = 1; i < chars.length; i ++) {
                if(chars[i]%2==0){
                    alternateChar[i]=String.valueOf(chars[i]).toUpperCase().charAt(0);
                }else{
                    alternateChar[i]=chars[i];
                }
            }
            return alternateChar;
        }


        // On comment au point [x=0,y=0]
        // haut : y++
        // bas : y--
        // gauche : x--
        // droite : x++
        // Exemple : {"haut", "haut", "bas", "gauche", "gauche", "droite", "haut"} => [-1,2]
        static int[] direction(String[] directionStr){
            int[] result={0,0};
            for(int i=0;i<directionStr.length;i++){
                switch (directionStr[i]){
                    case "haut":
                        result[1] +=1;
                        break;
                    case "bas":
                        result[1] -=1;
                        break;
                    case "gauche":
                        result[0] -=1;
                        break;
                    case "droite":
                        result[0] +=1;
                        break;
                }
            }
            return result;
        }

    }

