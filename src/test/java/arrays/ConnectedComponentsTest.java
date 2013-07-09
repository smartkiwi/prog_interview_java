package arrays;

import arrays.ConnectedComponents;

public class ConnectedComponentsTest extends junit.framework.TestCase {


    public void testCountComponents0() throws Exception {
        int[][] testCase0 = new int[][]{{1}};
        ConnectedComponents cc = new ConnectedComponents(testCase0);
        assertEquals(cc.countComponents(), 1);
    }


    public void testCountComponents1() throws Exception {
        int[][] testCase1 = new int[][]{{0}};
        ConnectedComponents cc = new ConnectedComponents(testCase1);
        assertEquals(cc.countComponents(), 0);
    }

    public void testCountComponents2() throws Exception {
        int[][] testCase2 = new int[][]{
                {0, 1}
        };
        ConnectedComponents cc = new ConnectedComponents(testCase2);
        assertEquals(cc.countComponents(), 1);
    }

    public void testCountComponents3() throws Exception {
        int[][] testCase3 = new int[][]{
                {0, 0},
                {0, 0}
        };
        ConnectedComponents cc = new ConnectedComponents(testCase3);
        assertEquals(cc.countComponents(), 0);
    }

    public void testCountComponents4() throws Exception {
        int[][] testCase3 = new int[][]{
                {1, 1},
                {1, 1}
        };
        ConnectedComponents cc = new ConnectedComponents(testCase3);
        assertEquals(cc.countComponents(), 1);
    }

    public void testCountComponents_case1() throws Exception {
        int[][] testCase3 = new int[][]{
                {1, 0, 1, 0},
                {1, 0, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
        };
        ConnectedComponents cc = new ConnectedComponents(testCase3);
        assertEquals(cc.countComponents(), 2);
    }

    public void testCountComponents_case2_1() throws Exception {
        int[][] testCase3 = new int[][]{
                {1, 0, 1},
                {1, 0, 1},
                {1, 1, 1},
        };
        ConnectedComponents cc = new ConnectedComponents(testCase3);
        assertEquals(cc.countComponents(), 1);
    }


    public void testCountComponents_case2_2() throws Exception {
        int[][] testCase3 = new int[][]{
                {1, 0, 1, 0},
                {1, 0, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0},
        };
        ConnectedComponents cc = new ConnectedComponents(testCase3);
        assertEquals(cc.countComponents(), 1);
    }

    public void testCountComponents_case3() throws Exception {
        int[][] testCase3 = new int[][]{
                {1, 1, 1, 0},
                {1, 0, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0},
        };
        ConnectedComponents cc = new ConnectedComponents(testCase3);
        assertEquals(cc.countComponents(), 1);
    }



    public void testCountComponents_case4() throws Exception {
        int[][] testCase3 = new int[][]{
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0},

        };
        ConnectedComponents cc = new ConnectedComponents(testCase3);
        assertEquals(cc.countComponents(), 8);
    }
}


