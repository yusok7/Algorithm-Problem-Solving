import java.util.*;

public class StringTest {
    public static void main(String[] args) throws Exception {
        String str = "abcd";
        System.out.println(str.contains("abc"));
        Set<Integer> set = new HashSet<>();
        System.out.println(str.substring(1));
        System.out.println(str.substring(0,2));

        String str2 = "31";
        System.out.println(str2.toUpperCase());

        String str3 = "011";
        System.out.println(Integer.parseInt(str3));
        try {
            System.out.println(str3.substring(0,100));
        } catch (Exception e) {
        }

        HashMap<String,String> map = new HashMap<>();
        int size = map.keySet().size();
        String s = map.get("1");
        if (s == null) {
            System.out.println("hi");
        }
        System.out.println(s);

        String str4 = "123";
        String replace = str4.replace("1", "3");
        char c = str4.charAt(0);
        System.out.println(c);

        String str5 = "BAB";

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("A");
        list.remove((String) "A");
        System.out.println("list.size() = " + list.size());
        List<Integer> list2 = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("gg");
        System.out.println(sb.toString());
        sb.append("hh");
        System.out.println(sb.toString());


    }

//    public int solution(String s) {
//        String[] strArr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
//        for (int i = 0; i < strArr.length; i++) {
//            if (s.contains(strArr[i])) {
//                s = s.replace(strArr[i],"i");
//            }
//        }
//        int answer = 0;
//        return answer;
//    }

//    public String solution(String s) {
//        String answer = "";
//        String[] strArr = s.split(" ");
//        StringBuilder sb = new StringBuilder();
//
//        for (String str : strArr) {
//            str.substring()tring(0,1);
//            str1 = str.toUpperCase();
//            String str2 = str.subString(1);
//            str2 = str.toLowerCase();
//            sb.append(str1+str2+" ");
//        }
//        return sb.toString();
//    }
}
