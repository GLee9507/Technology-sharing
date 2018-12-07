package com.glee.technology_sharing;

/**
 * @author liji
 * @date 2018/12/5 14:47
 * description
 */


public class Test {
    private static Test test;
    public static Test getInstance() {
        if (test == null) {
            test = new Test();
        }
        return test;
    }

    private static class TestHolder {
        private static Test test ;
    }
}
