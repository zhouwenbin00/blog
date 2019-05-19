package com.test.utils;

/**
 * @Auther: zhouwenbin
 * @Date: 2019/5/20 10:38
 */
public interface Triple<A,B,C> {
    static <A,B,C> Triple<A,B,C> ofImmutable(A a,B b,C c){
        return new ImmutableTriple<>(a,b,c);
    }


    A getA();

    B getB();

    C getC();

}
