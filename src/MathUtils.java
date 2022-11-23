// creer un fichier test avec new/directory on test_unitaire
// test => mark directory as => test source root - pour definir la fichier test comme fichier  pour stocker les test
public class MathUtils {
    public int add(int a,int b){
        return a+b;
    }

    public int substract(int a, int b){
        return a-b;
    }
    public int multiply(int a, int b){
        return a*b;
    }
    public int divide(int a, int b){
        return a/b;
    }
    public boolean isEven(int number){
        return number%2==0;
    }

    public boolean isOdd(int number){
        return number%2!=0;
    }

    public  int power(int number,int exp){
        return number*number;
    }
}

