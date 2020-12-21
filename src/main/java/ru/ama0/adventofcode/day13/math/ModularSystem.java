package ru.ama0.adventofcode.day13.math;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
@ToString
public class ModularSystem {
    private final Collection<Modular> modulars;
    private final BigInteger x;

    public static ModularSystem of(Modular... modulars) {
        return of(Arrays.asList(modulars));
    }

    public static ModularSystem of(Collection<Modular> modulars) {
        Set<Pair<Integer>> pairs = new HashSet<>();
        for (Modular modular : modulars) {
            for (Integer multiplier : Multipliers.get((int)modular.getM())) {
                for (long x : modular.getX()) {
                    pairs.add(new Pair<>((int) x % multiplier, multiplier));
                }
            }
        }

        long m = pairs.stream()
                .mapToLong(Pair::getRight)
                .reduce(1, (m1, m2) -> m1 * m2);
        BigInteger bigIntegerM = BigInteger.valueOf(m);
        BigInteger sum = BigInteger.ZERO;
        for(Pair<Integer> pair : pairs) {
            long mi = pair.getRight();
            long bi = pair.getLeft();
            long eMi = m / mi;
            Modular modular = Modular.of(eMi, 1, mi);
            long eMiDash = modular.getX()[0];
            sum = sum.add(BigInteger.valueOf(eMiDash * eMi * bi));
            sum = sum.remainder(bigIntegerM);
        }

        return new ModularSystem(modulars, sum);
    }
}
