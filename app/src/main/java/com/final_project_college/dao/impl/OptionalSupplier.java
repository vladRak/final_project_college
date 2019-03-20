package com.final_project_college.dao.impl;

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalSupplier<T> {

    private Optional<T> optional;

    private OptionalSupplier(Optional<T> optional) {
        this.optional = optional;
    }

    public static <T> OptionalSupplier<T> of(Optional<T> optional) {
        return new OptionalSupplier<>(optional);
    }

    public Consumer<T> ifPresent(Consumer<T> c) {
        optional.ifPresent(c);
        return c;
    }

    public OptionalSupplier<T> ifNotPresent(Runnable r) {
        if (!optional.isPresent())
            r.run();
        return this;
    }
}
