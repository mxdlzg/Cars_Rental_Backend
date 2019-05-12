package com.mxdlzg.rental.utils;

import org.springframework.lang.NonNull;

import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Pair<S,T> {
    private final S first;
    private final T second;


    public S getFirst() {
        return this.first;
    }

    public T getSecond() {
        return this.second;
    }

    public String toString() {
        return "Pair(first=" + this.getFirst() + ", second=" + this.getSecond() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Pair)) {
            return false;
        } else {
            Pair<?, ?> other = (Pair)o;
            Object this$first = this.getFirst();
            Object other$first = other.getFirst();
            if (this$first == null) {
                if (other$first != null) {
                    return false;
                }
            } else if (!this$first.equals(other$first)) {
                return false;
            }

            Object this$second = this.getSecond();
            Object other$second = other.getSecond();
            if (this$second == null) {
                if (other$second != null) {
                    return false;
                }
            } else if (!this$second.equals(other$second)) {
                return false;
            }

            return true;
        }
    }


    public Pair(S first, T second) {
        if (first == null) {
            throw new IllegalArgumentException("first is marked @NonNull but is null");
        } else if (second == null) {
            throw new IllegalArgumentException("second is marked @NonNull but is null");
        } else {
            this.first = first;
            this.second = second;
        }
    }
}
