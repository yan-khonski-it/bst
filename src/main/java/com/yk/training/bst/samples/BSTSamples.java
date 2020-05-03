package com.yk.training.bst.samples;

import com.yk.training.bst.Tree;

import java.util.List;

/**
 * Generates Binary Search Tree samples for tests.
 */
public class BSTSamples {

    /**
     * <pre>
     *                                       30
     *
     *                              15                        40
     *                         10        20               35       45
     *                      8     11   17  21          32   36   44  47
     *                    6   9      16 18
     *
     * </pre>
     */
    public static Tree treeH5() {
        return Tree.ofValues(List.of(30, 15, 40, 10, 20, 35, 45, 8, 11, 17, 21, 32, 36, 44, 47, 6, 9, 16, 18));
    }
}
