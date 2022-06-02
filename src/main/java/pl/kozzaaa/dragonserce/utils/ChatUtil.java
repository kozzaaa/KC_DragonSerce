package pl.kozzaaa.dragonserce.utils;

public class ChatUtil {

    public static String fixColor(String text) {
        if(text == null) {
            return "";
        }
        return text.replace("&", "§").replace(">>", "»").replace("<<", "«").replace("xx", "✖");
    }
}
