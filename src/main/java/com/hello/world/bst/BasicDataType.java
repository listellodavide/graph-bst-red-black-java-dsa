package com.hello.world.bst;

import java.math.BigInteger;
import java.util.UUID;

/**
 * A BasicDataType used for comparison between nodes
 *
 * @author <a href="davide.listello@gmail.com">Davide Listello</a>
 */
public sealed class BasicDataType implements Comparable<BasicDataType>
        permits Author, Spaceship, Student {

    private UUID uuid;

    private BigInteger weight = BigInteger.ZERO;

    private static final AtomicBigInteger abi = new AtomicBigInteger(BigInteger.ZERO);

    private static boolean UUID_MODE = false;

    public static void changeMode(boolean mode) {
        UUID_MODE = mode;
    }

    public BasicDataType(UUID uuid) {
        this.uuid = uuid;
    }

    public BasicDataType(int weight) {
        this.weight = BigInteger.valueOf(weight);
    }

    public BasicDataType(BigInteger weight) {
        this.weight = weight;
    }

    public BasicDataType() {
        this.uuid = UUID.randomUUID();
        this.weight = abi.getAndIncrement();
    }

    /**
     *
     * @param other the object to be compared.
     * @return Depending on value of UUID_MODE An int value: 0 if the UUID is equal to the other UUID or the comparison based on BigInteger weight.
     * < 0 if the UUID is lexicographically less than the other UUID
     * > 0 if the UUID is lexicographically greater than the other UUID (or more characters)
     * Compares this BigInteger with the specified BigInteger. This method is provided in preference to individual methods for each of
     * the six boolean comparison operators (<, ==, >, >=, !=, <=). The suggested idiom for performing these comparisons is:
     * (x.compareTo(y) <op> 0), where <op> is one of the six comparison operators.
     */
    @Override
    public int compareTo(BasicDataType other) {
        if(UUID_MODE) {
            return this.uuid.compareTo(other.uuid);
        }
        return this.weight.compareTo(other.weight);
    }

    public boolean isBigger(BasicDataType other) {
        if(UUID_MODE) {
            return this.uuid.compareTo(other.uuid) > 0;
        }
        return this.weight.compareTo(other.weight) > 0;
    }

    public boolean isBigger(BigInteger value) {
        return this.weight.compareTo(value) > 0;
    }

    public boolean isBigger(UUID value) {
       return this.uuid.compareTo(value) > 0;
    }

    public boolean isSmaller(BasicDataType other) {
        if(UUID_MODE) {
            return this.uuid.compareTo(other.uuid) < 0;
        }
        return this.weight.compareTo(other.weight) < 0;
    }

    public boolean isSmaller(BigInteger value) {
        return this.weight.compareTo(value) < 0;
    }

    public boolean isSmaller(UUID value) {
        return this.uuid.compareTo(value) < 0;
    }

    public UUID getUuid() {
        return uuid;
    }

    public BigInteger getWeight() {
        return weight;
    }
}
