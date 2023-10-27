package javaSolutions.src.old.interview;
//634
//public class Interview {
//    /*
//                       1 1 1 1 1 1 1 1 1 1
//   0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9
//0 |.|.|.|.|.|.|.|x|x|x|.|.|.|.|.|.|.|.|.|.|
//1 |.|.|.|.|.|.|.|x|x|x|.|.|.|.|.|.|.|.|.|.|
//2 |.|.|x|x|x|.|.|x|x|x|.|.|.|.|x|x|x|.|.|.|
//3 |.|.|.|.|.|.|.|.|.|.|.|x|x|x|.|.|x|.|.|.|
//4 |.|x|.|.|.|x|x|x|.|.|.|x|.|x|.|.|x|.|.|.|
//5 |x|.|x|.|.|x|.|x|.|.|.|x|x|x|x|x|x|.|.|.|
//6 |.|x|.|.|.|x|x|x|.|.|.|.|.|.|.|.|.|.|.|.|
//7 |.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|.|
//
//count_lakes(image, (2,2)) → 0
//count_lakes(image, (6,6)) → 1
//count_lakes(image, (12,5)) → 2
//
//*/
//// Search lands till water is seen. Then check if the water is bounded by land.
//
//    public static Set<Pair<Integer>> searchLand(int[][] image, int i, int j) {
//        Set<Pair<Integer>> water = new HashSet<>();
//        if (image[i][j] == 0) {
//            water.add(new Pair<Integer>(i, j));
//        }
//        if (image [i][j] == 2) return water;
//        image[i][j] = 2;
//        // up
//        if(i > 0) {
//            searchLand(image, i - 1, j);
//        }
//        // down
//        if (i < image.length) {
//            searchLand(image, i + 1, j);
//        }
//
//        // forward
//        if (j < image[i].length) {
//            searchLand(image, i, j + 1);
//        }
//
//        // backward
//        if (j > 0) {
//            searchLand(image, i, j - 1);
//        }
//    }
//
//    public static Set<Pair<Integer>> searchWater(int[][] image, int i, int j) {
//        Set<Pair<Integer>> water = new HashSet<>();
//        if (image[i][j] == 0) {
//            water.add(new Pair<Integer>(i, j));
//        }
//        if (image [i][j] == 2) return water;
//        image[i][j] = 2;
//        // up
//        if(i > 0) {
//            searchLand(image, i - 1, j);
//        }
//        // down
//        if (i < image.length) {
//            searchLand(image, i + 1, j);
//        }
//
//        // forward
//        if (j < image[i].length) {
//            searchLand(image, i, j + 1);
//        }
//
//        // backward
//        if (j > 0) {
//            searchLand(image, i, j - 1);
//        }
//    }
//
//}
