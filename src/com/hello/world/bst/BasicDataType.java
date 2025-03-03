package com.hello.world.bst;

import java.util.UUID;

/**
 * A BasicDataType used for comparison between nodes
 *
 * @author <a href="davide.listello@gmail.com">Davide Listello</a>
 */
public class BasicDataType implements Comparable<BasicDataType> {

    UUID id;

    /**
     *
     * @param other the object to be compared.
     * @return An int value: 0 if the UUID is equal to the other UUID.
     * < 0 if the UUID is lexicographically less than the other UUID
     * > 0 if the UUID is lexicographically greater than the other UUID (or more characters)
     */
    @Override
    public int compareTo(BasicDataType other) {
        return this.id.compareTo(other.id);
    }

    public boolean isBigger(BasicDataType other) {
        return this.id.compareTo(other.id) > 0;
    }

    public boolean isSmaller(BasicDataType other) {
        return this.id.compareTo(other.id) < 0;
    }

}
