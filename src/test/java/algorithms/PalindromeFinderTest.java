package algorithms;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PalindromeFinderTest {
    @Test
    public void shouldReturnEmptyString() throws Exception {
        String result = new PalindromeFinder("").findLongest();

        assertThat(result).isEmpty();
    }

    @Test
    public void constructorShouldNotAcceptNulls() throws Exception {

        assertThatThrownBy(() -> new PalindromeFinder(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void shouldReturn_abba_from_aaabba() throws Exception {
        String originalText = "aaabba";

        String result = new PalindromeFinder(originalText).findLongest();

        assertThat(result)
                .isEqualTo("abba");
    }
}