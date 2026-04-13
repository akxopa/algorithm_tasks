package io.github.akxopa.launcher;

import io.github.akxopa.binarysearch.Task01BinarySearch;
import io.github.akxopa.common.Runner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SplashScreen greeting = new SplashScreen();
        greeting.startApp();

        Runner.run(new Task01BinarySearch());
    }
}
