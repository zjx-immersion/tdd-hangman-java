
/*
 * Copyright 2008 Google Inc.
 *
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Exector;


import java.util.Optional;

/**
 *Created by jxzhong on 1/25/16.
 * @param <T> is a optional input
 */
public interface Executor<T> {

    /**
     * excute
     * @param t for optional
     */
    void apply(Optional<T> t);
}
