package kfactor;

import leetcode.kfactor.FactorFinder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorFinderTest {

    @ParameterizedTest
    @CsvSource({"12, 3, 3", "7, 2, 7", "4, 4, -1"})
    public void shouldFindKthFactorForN(Integer n, Integer k, Integer expected) {
        FactorFinder factorFinder = new FactorFinder();

        assertEquals(expected, factorFinder.kthFactor(n,k));
    }

}
