package programmers.leveltwo;

import java.util.ArrayList;
import java.util.List;

public class SkillTree {

    public static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int solution = solution(skill, skill_trees);
        System.out.println(solution);
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String val : skill_trees) { // BACDE, CBADF, ...
            list.clear();
            for (String val2 : skill.split("")) {
                list.add(val2);
            }

            int count = 0;
            boolean bool = false;

            String[] strArr = val.split(""); // "B, A, C, D, E" , ...
            for (String s : strArr) {
                if (!list.contains(s)) continue;
                else { // 포함하고 있다면
                    String skillName = list.get(0);
                    if (skillName.equals(s)) {
                        list.remove(0);
                        count++;
                    } else {
                        bool = true;
                        break;
                    }
                }
            }
            if (!bool) answer++;
        }
        return answer;
    }
}
