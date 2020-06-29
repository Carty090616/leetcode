import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author lifeifei
 * @create 2020-06-29
 * @since 1.0.0
 */
public class Question3 {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<Character>();
        int len = s.length();

        // 结果
        int res = 0;
        // 右侧指针
        int rk = -1;
        // i 为 左侧指针
        for (int i = 0; i < len; i++) {
            // i != 0 意味着左指针还是移动
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < len && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                rk++;
            }
            res = Math.max(res, rk - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abcdabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}