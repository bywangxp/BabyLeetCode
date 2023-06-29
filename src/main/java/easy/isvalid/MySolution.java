package easy.isvalid;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * --YY  为什么你能知道正确的顺序是这个，每个人对正确的理解并不一样呀？
 * 花了很多时间去理解这个正确的顺序闭合，实际就是数学运算里符号的顺序
 * 这里的 "正确的顺序" 是根据编程语言和数学中括号使用的通用规则来定义的，也是这个问题背景的前提条件。
 * <p>
 * from chatgpt:在大多数情况下，括号用于对表达式进行分组和优先级排序。例如，在数学和编程中，我们经常看到的表达式如 "3 * (4 + 5)"，括号里的部分需要首先计算。如果括号没有正确地配对，例如 "3 * (4 + 5))" 或者 "3 * 4 + 5)"，那么这个表达式就不完整，无法正确解析。
 * --YY
 * <p>
 * <p>
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * 执行用时：
 * 2 ms
 * , 在所有 Java 提交中击败了
 * 49.61%
 * 的用户
 * 内存消耗：
 * 39.5 MB
 * , 在所有 Java 提交中击败了
 * 77.37%
 * 的用户
 */

public class MySolution {
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false; // 如果s的长度为奇数，一定不符合要求
        }
        ArrayList<Character> leftChar = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        leftChar.add('(');
        leftChar.add('{');
        leftChar.add('[');
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (int i = 0; i < s.length(); ++i) {
            char data = s.charAt(i);
            if (leftChar.contains(data)) {
                stack.add(data);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (map.get(stack.pop()) != data) {
                return false;
            }

        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;

    }


    public static void main(String[] args) {


        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
    }
}
