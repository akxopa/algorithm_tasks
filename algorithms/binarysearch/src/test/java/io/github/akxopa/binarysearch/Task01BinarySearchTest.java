package io.github.akxopa.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task01BinarySearchTest {
    private final Task01BinarySearch task = new Task01BinarySearch();
    private final int[] arr = {1, 3, 5, 7, 9};

    @Test
    void shouldReturnMiddleIndexWhenTargetExists() {
        assertEquals(2, task.binarySearch(arr, 5));
    }

    @Test
    void shouldReturnMinusOneWhenTargetDoesNotExist() {
        assertEquals(-1, task.binarySearch(arr, 4));
    }

    @Test
    void shouldFindFirstElement() {
        assertEquals(0, task.binarySearch(arr, 1));
    }

    @Test
    void shouldFindLastElement() {
        assertEquals(4, task.binarySearch(arr, 9));
    }
}
