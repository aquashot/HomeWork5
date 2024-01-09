public class Main {
    private static final String ALLOWED_CHARS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM123456789_";

    public static void main(String[] args) {
        try {
            check("admin", "231312", "231312 ");
            System.out.println("Прошёл проверку");
        }catch (WrongLoginException | WrongPasswordException e){
            System.out.println(e.getMessage());
        }
    }

    public static void check(String login, String password, String confirmPassword) {
        if (!login.matches(ALLOWED_CHARS)) {
            throw new WrongLoginException("В логине запрещенный символ");
        }
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

    public static boolean isStringCorrect(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!ALLOWED_CHARS.contains("" + ch)) {
                return false;
            }
        }
        return true;
    }
}
