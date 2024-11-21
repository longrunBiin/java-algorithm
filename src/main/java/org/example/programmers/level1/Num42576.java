package org.example.programmers.level1;

import java.util.HashMap;

public class Num42576 {
    public static void main(String[] args) {
        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};
        solution(participant, completion);
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> runner = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            runner.put(participant[i], runner.getOrDefault(participant[i], 0) + 1);
        }
        for (int i = 0; i < completion.length; i++) {
            Integer value = runner.get(completion[i]);
            runner.put(completion[i], value-1);
        }
        for (String key : runner.keySet()) {
            if (runner.get(key) > 0) {
                answer = key;
            }
        }

        return answer;
    }
}
