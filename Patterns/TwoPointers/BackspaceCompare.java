package javaSolutions.Patterns.TwoPointers;

class BackspaceCompare {

    public static boolean compare(String str1, String str2) {
        int i = str1.length() - 1, j = str2.length() - 1, b1 = 0, b2 = 0;
        while (i >= 0 && j >= 0) {
            int [] p1 = getValidChar(i, b1, str1);
            int [] p2 = getValidChar(j, b2, str2);
            i = p1[0]- 1;
            b1 = p1[1];
            if (p1[0] < 0) return false;
            j = p2[0] - 1;
            b2 = p2[1];
            if (p2[0] < 0) return false;
            if (str1.charAt(p1[0]) != str2.charAt(p2[0])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompare.compare("xp#", "xyz##"));
        System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));
    }

    public static int[] getValidChar(int i, int b, String str) {
        while (true) {
            char c = str.charAt(i);
            if (c == '#') {
                i--;
                b++;
            } else {
                if (b > 0) {
                    if (i == 0) {
                        return new int[]{-1, -1};
                    } else {
                        i--;
                        b--;
                    }
                } else {
                    return new int[]{i, b};
                }
            }
        }
    }
}