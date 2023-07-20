package programmers.Lv1.신규_아이디_추천;

public class Solution2 {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        new_id = new_id.replaceAll("[^0-9a-z\\-_.]", "");

        // 3단계
        new_id = new_id.replaceAll("\\.+",".");

        // 4단계
        new_id = new_id.replaceAll("^\\.+|\\.+$", "");

        // 5단계
        if(new_id.isEmpty()) new_id = "a";

        // 6단계
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);

            new_id = new_id.replaceAll("\\.+$", "");
        }

        // 7단계
        while(new_id.length() <= 2){
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}
