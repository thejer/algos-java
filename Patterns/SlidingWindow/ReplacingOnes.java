package javaSolutions.Patterns.SlidingWindow;

class ReplacingOnes {

    // { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 } k = 2
    public static int findLength(int[] arr, int k) {
        int left = 0;
        int zeroLength = 0, maxLength = 0;
        for (int right = 0; right < arr.length; right++) { // 10
            int num = arr[right]; // 1
            if (num == 0) { // false
                if (zeroLength >= k) { // true
                    maxLength = Math.max(maxLength, right - left + 1); // 4
                    while (zeroLength >= k) {
                        if (arr[left] == 0) { // true
                            zeroLength--; // 1
                        }
                        left++; // 5
                    }
                }
                zeroLength++; // 2
            }
            maxLength = Math.max(maxLength, right - left + 1); // 4
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0,0,0,0, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
