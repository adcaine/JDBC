import java.util.ArrayList;
import java.util.List;

/**
 * Created by allancaine on 2015-11-08.
 */
public class Compression {

    class CompressedChar{

        private char mChar;
        private int mFreq;

        public CompressedChar(char aChar, int freq) {
            mChar = aChar;
            mFreq = freq;
        }

        public char getChar() {
            return mChar;
        }

        public int getFreq() {
            return mFreq;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(mChar);
            builder.append(mFreq);
            return builder.toString();
        }
    }

    class CompressedString{

        List<CompressedChar> mCompressedChars;

        public CompressedString(){
            mCompressedChars = new ArrayList<>();
        }

        public void appendLetter(CompressedChar letter){
            mCompressedChars.add(letter);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for(CompressedChar c : mCompressedChars)
                builder.append(c.toString());
            return builder.toString();
        }
    }

    public CompressedString fromString(String s){
        if(s == null || s.length() == 0){
            return new CompressedString();
        }

        CompressedString compressedString = new CompressedString();

        char candidate = s.charAt(0);
        int count = 1;

        for(int i = 1; i <= s.length(); i++){
            if(i == s.length()){
                compressedString.appendLetter(new CompressedChar(candidate, count));
                break;
            }
            if(s.charAt(i) != candidate ){
                compressedString.appendLetter(new CompressedChar(candidate, count));
                count = 1;
                candidate = s.charAt(i);
            }else{
                count++;
            }
        }

        return compressedString;
    }

    public static void main(String[] args){
        System.out.print(new Compression().fromString("aaabbccd").toString());
    }
}
