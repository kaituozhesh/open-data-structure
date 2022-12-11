package com.open.ityizhan.tree.segmentTree;

/**
 * @ClassName : Main
 * @Description :
 * @Author : 林俊豪
 * @Date: 2022-12-07 20:39
 * @Version: 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Integer::sum);

        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(2, 5));
        System.out.println(segmentTree.query(0, 5));
    }
}
