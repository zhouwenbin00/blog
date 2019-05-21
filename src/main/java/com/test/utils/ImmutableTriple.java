package com.test.utils;


/** 不可变的三个 @Auther: zhouwenbin @Date: 2019/5/20 10:39 */
public class ImmutableTriple<A, B, C> implements Triple<A, B, C> {
  private final A a;
  private final B b;
  private final C c;

  public ImmutableTriple( A a,  B b,  C c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  @Override
  public  A getA() {
    return a;
  }

  @Override
  public  B getB() {
    return b;
  }

  @Override
  public  C getC() {
    return c;
  }
}
