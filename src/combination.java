import java.util.*;
class Main {
    public static void generateList(List<List<Integer>> inputs) {
        backtrack(new ArrayList<>(), inputs, 0, 0);
    }
    private static void backtrack(List<Integer> curr, List<List<Integer>> inputs, int group, int comp) {
        if (curr.size() == 5) {
            for (int i = 0; i < curr.size() - 1; i++) {
                System.out.print(curr.get(i) + ",");
            }
            System.out.print(curr.get(curr.size() - 1) + "\n");
        } else {
            if (group < 5) {
                List<Integer> in = inputs.get(group);
                for (int j = 0; j < in.size(); j++) {
                    int n = in.get(j);
                    if (n > comp){
                        curr.add(n);
                        backtrack(curr, inputs, group + 1, n);
                        curr.remove(curr.size() - 1);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList();
        while (in.hasNext()) {
            String line = in.nextLine();
            List<Integer> input = new ArrayList();
            for (String s : line.split(",")) {
                input.add(Integer.parseInt(s));
            }
            list.add(input);
        }
        generateList(list);
    }
}
// Time Complexity
// O(N)
