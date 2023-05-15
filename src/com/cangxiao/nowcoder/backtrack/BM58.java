package com.cangxiao.nowcoder.backtrack;

import java.util.*;

/**
 * @Author cangxiao
 * @Date 2023/5/13
 * @Desc BM58 字符串的排列 递归回溯
 */
public class BM58 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        List<String> result = new ArrayList<>();
        String str = scanner.nextLine();

        while (!str.equals("exit")) {

            ArrayList<String> result = permutation(str);
            System.out.println(result);

            result.clear();
            str = scanner.nextLine();
        }
    }

    public static ArrayList<String>  permutation(String str){
        char[] chars = str.toCharArray();
        Set<String> result = new HashSet<>();
        List<Integer> visited = new ArrayList<>(chars.length);
//        backtrack(chars, list, visited,0);
        backtrack(chars, new char[chars.length], visited,0,  result);
        return new ArrayList<>(result);
    }

//    private static void backtrack(char[] chars, List<Character> list, List<Integer> visited, int k) {
//        if (k==chars.length){
//
//            result.add(String.valueOf(list.toArray(new Character[list.size()])));
//            return;
//        }
//        for (int i = 0; i < chars.length; i++) {
//            if (visited.contains(i)){
//                continue;
//            }
//            list.add(chars[i]);
//            visited.add(i);
//            backtrack(chars,list,visited,k+1);
//            list.remove(list.size() - 1);
//            visited.remove(visited.size() - 1);
//        }
//
//    }

    private static void backtrack(char[] chars, char[] list, List<Integer> visited, int k, Set<String> result) {
        if (k==chars.length){
            result.add(String.valueOf(list));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited.contains(i)){
                continue;
            }
            list[k] = chars[i];
            visited.add(i);
            backtrack(chars,list,visited,k+1, result);
//            list.remove(list.size() - 1);
            visited.remove(visited.size() - 1);
        }

    }
}
