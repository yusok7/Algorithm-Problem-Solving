package programmers.kakao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class OpenChat {

    static class Node {
        String type;
        String uid;

        public Node(String type, String uid) {
            this.type = type;
            this.uid = uid;
        }
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution(record);
        for (String val : record) {
            System.out.println(val);
        }
    }

    public static String[] solution(String[] record) {
        Queue<Node> queue = new LinkedList<>();
        Map<String, String> map = new HashMap<>();

        for (String str : record) {
            String[] strArr = str.split(" ");
            String type = strArr[0];
            String uid = strArr[1];
            if (type.equals("Enter") || type.equals("Leave")) {
                Node node = new Node(type, uid);
                queue.add(node);
                if (type.equals("Enter")) {
                    String name = strArr[2];
                    map.put(uid, name);
                }
            } else {
                String name = strArr[2];
                map.put(uid, name);
            }
        }

        String[] answer = new String[queue.size()];
        for (int i = 0; i < queue.size(); i++) {
            Node poll = queue.poll();
            if (poll.type.equals("Enter")) {
                String name = map.get(poll.uid);
                String str = name + "님이 " + "들어왔습니다.";
                answer[i] = str;
            } else {
                String name = map.get(poll.uid);
                String str = name + "님이 " + "나갔습니다.";
                answer[i] = str;
            }
        }

        return answer;
    }
}
