import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexJS {

    public Set<String> testJsSampleFile() {
        Pattern pattern = Pattern.compile("=\\s*require[(]\\s*['\"]([/~.]\\S+)['\"]");

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("js-sample.txt")).getFile());

        Set<String> results=new HashSet<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                Matcher matcher = pattern.matcher(scanner.nextLine());
                if(matcher.find()) results.add(matcher.group(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static void main(String[] args) {
        RegexJS jsScanner=new RegexJS();
        System.out.println(jsScanner.testJsSampleFile());
    }
}
