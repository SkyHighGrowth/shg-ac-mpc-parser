package com.shg.bmapi.models.planner;

import java.util.Objects;

public class Sort {
    boolean sorted;
    boolean unsorted;

    public Sort() {

    }

    public Sort(boolean sorted, boolean unsorted) {
        this.sorted = sorted;
        this.unsorted = unsorted;
    }

    public boolean isSorted() {
        return sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }

    public boolean isUnsorted() {
        return unsorted;
    }

    public void setUnsorted(boolean unsorted) {
        this.unsorted = unsorted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sort sort = (Sort) o;
        return sorted == sort.sorted && unsorted == sort.unsorted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sorted, unsorted);
    }

    @Override
    public String toString() {
        return "Sort{" +
                "sorted=" + sorted +
                ", unsorted=" + unsorted +
                '}';
    }
}
