public class Main {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";
    private static final String ALLOW_CHARS="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM123456789_";

     public static void main(String[] args) {
        try {
            check("admin", "123", "123");
            System.out.println("Прошёл проверку");
        }catch (WrongLoginException | WrongPasswordException e){
            System.out.println(e.getMessage());
        }
    }

    public static void check(String login, String password, String confirmPassword) {
        if (login.matches(REGEX)) {
            if (login.length() > 20) {
                throw new WrongLoginException("Длина логина больше 20 симовлов");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("пароли не совпадают");
            }
            if (password.length() > 20) {
                throw new WrongPasswordException("Длина пароля больше 20 симолов");
            }
            if (!isStringCorrect(password)) {
                throw new WrongPasswordException("пароль содержит некорректные символы");
            }
        }
    }
    public static boolean isStringCorrect(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (('a' <= ch && ch <= 'z')
                    || ('A' <= ch && ch <= 'Z')
            ||('0' <= ch && ch <= '9')
            ||   ch == '_'){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    public static boolean isStringCorrect2(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!ALLOW_CHARS.contains("" + ch)) {
                return false;
            }
        }
        return true;
    }
}
