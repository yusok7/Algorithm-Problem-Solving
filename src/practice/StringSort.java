package practice;

public class StringSort {

    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "456";
        str2 = str2.replace("45", "12");
        System.out.println(str2.compareTo(str1));

        StringBuilder sb = new StringBuilder();

        System.out.println("str2 = " + str2);
    }
}
