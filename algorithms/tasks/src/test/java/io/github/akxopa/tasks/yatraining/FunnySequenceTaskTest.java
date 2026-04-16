package io.github.akxopa.tasks.yatraining;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FunnySequenceTaskTest {
   private FunnySequenceTask task = new FunnySequenceTask();

    @Test
    void testSingleValidChar() {
        assertEquals(1, task.maxLaugh("a"));
        assertEquals(1, task.maxLaugh("h"));
    }

    @Test
    void testSingleInvalidChar() {
        assertEquals(0, task.maxLaugh("b"));
    }

    @Test
    void testSimpleAlternating() {
        assertEquals(5, task.maxLaugh("ahaha"));
        assertEquals(3, task.maxLaugh("hah"));
    }

    @Test
    void testNoAlternation() {
        assertEquals(1, task.maxLaugh("aaaa"));
        assertEquals(1, task.maxLaugh("hhhh"));
    }

    @Test
    void testMixedCharacters() {
        assertEquals(4, task.maxLaugh("ahahxyz"));
        assertEquals(4, task.maxLaugh("xyzahah"));
    }

    @Test
    void testBreakBySameChar() {
        assertEquals(3, task.maxLaugh("ahaah")); // сброс на "aa"
    }

    @Test
    void testGivenExample() {
        assertEquals(4, task.maxLaugh("ahahrunawayahahsofasthah"));
    }

    @Test
    void testOnlyInvalidChars() {
        assertEquals(0, task.maxLaugh("xyz"));
    }

    @Test
    void testLongAlternation() {
        assertEquals(10, task.maxLaugh("ahahahahah"));
    }

    @Test
    void testAlternationWithBreaks() {
        assertEquals(3, task.maxLaugh("hahxxhahh"));
    }
}
