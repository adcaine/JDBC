import java.util.HashMap;

/**
 * Created by allancaine on 2015-11-08.
 */
public class ChapterOn {

    public static boolean uniqueChars(String s){

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == null){
                map.put(s.charAt(i), 1);
            }else{
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args){
        String array = "Mr John Smith    ";
        char[] a = array.toCharArray();
        new ChapterOn().URLify2(a);
        System.out.print(a);
    }

    public class Pair{
        private int mString1Freq;
        private int mString2Freq;

        public Pair(){
            mString1Freq = 0;
            mString2Freq = 0;
        }

        public void incString1(){
            mString1Freq++;
        }

        public void incString2(){
            mString2Freq++;
        }

        public boolean isEqual(){
            return mString1Freq == mString2Freq;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Pair{");
            sb.append("mString1Freq=").append(mString1Freq);
            sb.append(", mString2Freq=").append(mString2Freq);
            sb.append('}');
            return sb.toString();
        }
    }

    public boolean isPermute(String s1, String s2){

        if(s1 == null || s2 == null || s1.length() != s2.length()){
            return false;
        }

        HashMap<Character, Pair> map = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if(map.get(c1) == null){
                Pair pair = new Pair();
                pair.incString1();
                map.put(c1, pair);
            }else{
                map.get(c1).incString1();
            }

            if(map.get(c2) == null){
                Pair pair= new Pair();
                pair.incString2();
                map.put(c2, pair);
            }else{
                map.get(c2).incString2();
            }
        }

        for(Pair p : map.values()){
            if(!p.isEqual()){
                return false;
            }
        }

        return true;
    }

    private void shiftOver(int stopIndex, char[] array){
        for(int i = array.length - 1; i > stopIndex; i--){
            array[i] = array[i-2];
        }
        array[stopIndex] = '%';
        array[stopIndex+1] = '2';
        array[stopIndex+2] = '0';
    }

    public void URLify(char[] array){
        for(int i = 0; i < array.length; i++){
            if(array[i] == ' '){
                shiftOver(i, array);
            }
        }
    }

    public void URLify2(char[] array){
        for(int i = array.length - 1; i >= 0; i--){
            if(array[i] == ' '){
                i = shiftAt(i, array);
            }
        }
    }

    private int shiftAt(int start, char[] array){
        int end = 0;
        int value = 0;

        for(int i = start; i >= 0; i--){
            if(array[i] != ' '){
                end =i;
                break;
            }
        }

        int diff = start - end;

        for(int i = start; i>= 0; i--){
            if(array[i-diff] == ' '){
                value = i;
                break;
            }
            array[i] = array[i-diff];
        }

        array[value] = '0';
        array[value-1] = '2';
        array[value-2] = '%';
        if(value-3 >= 0) {
            array[value - 3] = ' ';
        }
        return value-2;
    }



}
