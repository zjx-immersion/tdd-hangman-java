
/*
 * Copyright 2008 Google Inc.
 *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by jxzhong on 1/23/16.
 */
public class HangmanTest {

    private Hangman hangman;


    @Before
    public void setUp() throws Exception {
        hangman = new Hangman();

    }

    @Test
    public void testHangmanStartWithApple() throws Exception {

        hangman.start("apple");

        assertThat(hangman.getPractiseWordTemplate(), is("a___e"));
        assertThat(hangman.getTries(), is(6));
        assertThat(hangman.getWordLenth(), is(5));
    }

    @Test
    public void testHangmanStartWithBenfit() throws Exception {

        hangman.start("benfit");

        assertThat(hangman.getPractiseWordTemplate(), is("_e__i_"));
        assertThat(hangman.getWordLenth(), is(6));
        assertThat(hangman.getTries(), is(7));
    }

    @Test
    public void testCaculateWithInputCorrectTheWordType() throws Exception {

        hangman.start("benfit");

        assertThat(hangman.caculate("b"), is(true));
        assertThat(hangman.caculate("f"), is(true));
        assertThat(hangman.caculate("t"), is(true));
        assertThat(hangman.getTries(), is(7));
        assertThat(hangman.getCaculatedWord(), is("be_fit"));

    }

    @Test
    public void testIsWinTheHangManGame() throws Exception {
        hangman.start(("application"));

        assertThat(hangman.caculate("p"), is(true));
        assertThat(hangman.caculate("l"), is(true));
        assertThat(hangman.caculate("c"), is(true));
        assertThat(hangman.caculate("t"), is(true));
        assertThat(hangman.caculate("n"), is(true));
        assertThat(hangman.getCaculatedWord(), is("application"));
        assertThat(hangman.getTries(), is(12));
        assertThat(hangman.isWinTheGame(), is(true));

    }

    @Test
    public void testIsLoseTheGame() throws Exception {

        hangman.start(("application"));

        for (int i = 0; i < 12; i++) {
            assertThat(hangman.caculate("a"), is(false));
        }
        assertThat(hangman.getTries(), is(0));
        assertThat(hangman.isLoseTheGame(), is(true));

    }
}
