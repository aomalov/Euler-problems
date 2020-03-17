public class Username {
    public static boolean validate(String username) {
        boolean res=username.length()>4;
        if(res)
            res=Character.isLetter(username.charAt(0)) && username.charAt(username.length()-1)!='_';
        if(res) {
            int underScoreCnt=0;
            for(int cnt=0;cnt<username.length();cnt++) {
                char ch=username.charAt(cnt);
                if(ch=='_') underScoreCnt++;
                if(!(Character.isLetterOrDigit(ch)||(ch=='_'&&underScoreCnt<2)))
                    return false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(validate("Mike_Standish")); // Valid username
        System.out.println(validate("Mike1Stand_ish")); // Invalid username

        System.out.println(Character.isLetter('1'));
    }
}
