/*
 * Copyright (c) 2014 Andrew O'Malley
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package sigbla.app.pds.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * {@code LinkedLists} is the preferred method of constructing instances of {@code LinkedList}.
 * <p/>
 * <p>{@link sigbla.app.pds.collection.ConsList} is currently constructed in
 * all cases, however this may change in the future.
 * <p/>
 * <p>{@code LinkedLists} is preferred for construction as:
 * <ul>
 * <li>It works better in languages that support type inference
 * <li>It allows future optimisations (e.g. small lists might start as arrays and get upgraded to {@code ConsLists})
 * </ul>
 */
public class LinkedLists {
    private LinkedLists() {
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <E> LinkedList<E> of() {
        return construct();
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <E> LinkedList<E> of(E t) {
        return construct(t);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <E> LinkedList<E> of(E e1, E e2) {
        return construct(e1, e2);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <E> LinkedList<E> of(E e1, E e2, E e3) {
        return construct(e1, e2, e3);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <E> LinkedList<E> of(E e1, E e2, E e3, E e4) {
        return construct(e1, e2, e3, e4);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <E> LinkedList<E> of(E e1, E e2, E e3, E e4, E e5) {
        return construct(e1, e2, e3, e4, e5);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <E> LinkedList<E> of(E e1, E e2, E e3, E e4, E e5, E e6) {
        return construct(e1, e2, e3, e4, e5, e6);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <E> LinkedList<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7) {
        return construct(e1, e2, e3, e4, e5, e6, e7);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <E> LinkedList<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return construct(e1, e2, e3, e4, e5, e6, e7, e8);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <E> LinkedList<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return construct(e1, e2, e3, e4, e5, e6, e7, e8, e9);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <E> LinkedList<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return construct(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <E> LinkedList<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E... others) {
        Builder<E, ConsList<E>> builder = ConsList.<E>factory().newBuilder();
        builder.addAll(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
        for (E other : others) {
            builder.add(other);
        }

        return builder.build();
    }

    private static <E> LinkedList<E> construct(E... es) {
        Builder<E, ConsList<E>> builder = ConsList.<E>factory().newBuilder();
        for (E e : es) {
            builder.add(e);
        }
        return builder.build();
    }

    @NotNull
    public static <E> LinkedList<E> copyOf(java.lang.Iterable<E> iterable) {
        Builder<E, ConsList<E>> builder = ConsList.<E>factory().newBuilder();
        for (E e : iterable) {
            builder.add(e);
        }
        return builder.build();
    }

    @NotNull
    public static <E> LinkedList<E> copyOf(Iterator<E> iterator) {
        Builder<E, ConsList<E>> builder = ConsList.<E>factory().newBuilder();
        while (iterator.hasNext()) {
            builder.add(iterator.next());
        }
        return builder.build();
    }

    @NotNull
    public static <E> LinkedList<E> copyOf(E[] es) {
        Builder<E, ConsList<E>> builder = ConsList.<E>factory().newBuilder();
        for (E e : es) {
            builder.add(e);
        }
        return builder.build();
    }

    @NotNull
    public static <E> LinkedList<E> copyOfTraversable(Traversable<E> traversable) {
        @SuppressWarnings("unchecked") final
        Builder<E, ConsList<E>> builder = ConsList.<E>factory().newBuilder();
        traversable.forEach(new Function<E, Object>() {
            @Override
            public Object invoke(E e) {
                builder.add(e);
                return null;
            }
        });

        return builder.build();
    }

    @NotNull
    @SuppressWarnings("unchecked")
    public static <E> BuilderFactory<E, LinkedList<E>> factory() {
        return (BuilderFactory) ConsList.<E>factory();
    }

    @NotNull
    public static <E> Builder<E, LinkedList<E>> builder() {
        return LinkedLists.<E>factory().newBuilder();
    }
}
