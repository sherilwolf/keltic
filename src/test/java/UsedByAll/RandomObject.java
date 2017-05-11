package UsedByAll;

import java.util.Random;

// * Created for w-qwippy by Fill on 10.12.2015.
public class RandomObject {
    static final String ab = "\"C:\\keltic_auto\\keltic\\testfile.jpg\"" +
            "abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщьъыюяєї";
    static final String abLatin = "0123456789abcdefghijklmnopqrstuvwxyz";
    static final String abSpaced = " 0123456789abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщьъыюяєї";
    static final String oneTwo = "0123456789";

    static Random rnd = new Random();

    public static String generateString(int len){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( ab.charAt( rnd.nextInt(ab.length()) ) );
        return sb.toString();
    }

    public static String generateLatinString(int len){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( abLatin.charAt( rnd.nextInt(abLatin.length()) ) );
        return sb.toString();
    }

    public static String generateSpacedString(int len){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( abSpaced.charAt( rnd.nextInt(abSpaced.length()) ) );
        return sb.toString();
    }

    public static int generateInt(int len){
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( oneTwo.charAt( rnd.nextInt(oneTwo.length()) ) );
        return Integer.parseInt(sb.toString());
    }
}
