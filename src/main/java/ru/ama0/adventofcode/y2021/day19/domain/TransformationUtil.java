package ru.ama0.adventofcode.y2021.day19.domain;

import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class TransformationUtil {

    public static final Map<String, Rotor> ROTORS = Stream.of(
                    // X is forward
                    new Rotor("XYZ", voxel -> voxel),
                    new Rotor("XZNy", voxel -> new Voxel(voxel.getX(), voxel.getZ(), -voxel.getY())),
                    new Rotor("XNyNz", voxel -> new Voxel(voxel.getX(), -voxel.getY(), -voxel.getZ())),
                    new Rotor("XNzY", voxel -> new Voxel(voxel.getX(), -voxel.getZ(), voxel.getY())),
                    // X is towards right
                    new Rotor("NyXZ", voxel -> new Voxel(-voxel.getY(), voxel.getX(), voxel.getZ())),
                    new Rotor("NzXNy", voxel -> new Voxel(-voxel.getZ(), voxel.getX(), -voxel.getY())),
                    new Rotor("YXNz", voxel -> new Voxel(voxel.getY(), voxel.getX(), -voxel.getZ())),
                    new Rotor("ZXY", voxel -> new Voxel(voxel.getZ(), voxel.getX(), voxel.getY())),
                    // X is backward
                    new Rotor("NxNyZ", voxel -> new Voxel(-voxel.getX(), -voxel.getY(), voxel.getZ())),
                    new Rotor("NxNzNy", voxel -> new Voxel(-voxel.getX(), -voxel.getZ(), -voxel.getY())),
                    new Rotor("NxYNz", voxel -> new Voxel(-voxel.getX(), voxel.getY(), -voxel.getZ())),
                    new Rotor("NxZY", voxel -> new Voxel(-voxel.getX(), voxel.getZ(), voxel.getY())),
                    // X is towards left
                    new Rotor("YNxZ", voxel -> new Voxel(voxel.getY(), -voxel.getX(), voxel.getZ())),
                    new Rotor("ZNxNy", voxel -> new Voxel(voxel.getZ(), -voxel.getX(), -voxel.getY())),
                    new Rotor("NyNxNz", voxel -> new Voxel(-voxel.getY(), -voxel.getX(), -voxel.getZ())),
                    new Rotor("NzNxY", voxel -> new Voxel(-voxel.getZ(), -voxel.getX(), voxel.getY())),
                    // X is up
                    new Rotor("NzYX", voxel -> new Voxel(-voxel.getZ(), voxel.getY(), voxel.getX())),
                    new Rotor("NyNzX", voxel -> new Voxel(-voxel.getY(), -voxel.getZ(), voxel.getX())),
                    new Rotor("ZNyX", voxel -> new Voxel(voxel.getZ(), -voxel.getY(), voxel.getX())),
                    new Rotor("YZX", voxel -> new Voxel(voxel.getY(), voxel.getZ(), voxel.getX())),
                    // X is down
                    new Rotor("ZYNx", voxel -> new Voxel(voxel.getZ(), voxel.getY(), -voxel.getX())),
                    new Rotor("NyZNx", voxel -> new Voxel(-voxel.getY(), voxel.getZ(), -voxel.getX())),
                    new Rotor("NzNyNx", voxel -> new Voxel(-voxel.getZ(), -voxel.getY(), -voxel.getX())),
                    new Rotor("YNzNx", voxel -> new Voxel(voxel.getY(), -voxel.getZ(), -voxel.getX())))
            .collect(Collectors.toMap(Rotor::getName, Function.identity()));

    public static final Map<String, Rotor> REVERSE_ROTORS;

    static {
        var voxel = new Voxel(1, 2, 3);
        var reverseRotors = new HashMap<String, Rotor>();
        for (var rotor : ROTORS.entrySet()) {
            for (var reverseRotorCandidate : ROTORS.entrySet()) {
                if (voxel.equals(reverseRotorCandidate.getValue().getOperator().apply(rotor.getValue().getOperator().apply(voxel)))) {
                    reverseRotors.put(rotor.getKey(), reverseRotorCandidate.getValue());
                    break;
                }
            }
        }
        REVERSE_ROTORS = Collections.unmodifiableMap(reverseRotors);
    }

}
