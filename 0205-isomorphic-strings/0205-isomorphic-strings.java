class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sm = new HashMap<>();
        HashSet<Character> tm = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (!sm.containsKey(s.charAt(i))) {
                if (tm.contains(t.charAt(i))) {
                    return false;
                }

                sm.put(s.charAt(i), t.charAt(i));
                tm.add(t.charAt(i));
            } else {
                if (sm.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
