package com.viber.voip.flatbuffers.a.b;

import com.google.c.a;
import java.nio.ByteBuffer;

public final class ac extends a
{
  public j A()
  {
    return a(new j());
  }

  public p B()
  {
    return a(new p());
  }

  public ac a(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.a = paramInt;
    this.b = paramByteBuffer;
    return this;
  }

  public j a(j paramj)
  {
    int i = a(54);
    if (i != 0)
      return paramj.a(b(i + this.a), this.b);
    return null;
  }

  public l a(l paraml)
  {
    int i = a(48);
    if (i != 0)
      return paraml.a(b(i + this.a), this.b);
    return null;
  }

  public p a(p paramp)
  {
    int i = a(56);
    if (i != 0)
      return paramp.a(b(i + this.a), this.b);
    return null;
  }

  public s a(s params)
  {
    int i = a(50);
    if (i != 0)
      return params.a(b(i + this.a), this.b);
    return null;
  }

  public int b()
  {
    int i = a(4);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return -1;
  }

  public int c()
  {
    int i = a(6);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return -1;
  }

  public String d()
  {
    int i = a(8);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String e()
  {
    int i = a(10);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public int f(int paramInt)
  {
    int i = a(52);
    if (i != 0)
      return this.b.getInt(e(i) + paramInt * 4);
    return 0;
  }

  public String f()
  {
    int i = a(12);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String g()
  {
    int i = a(14);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public boolean h()
  {
    int i = a(16);
    return (i == 0) || (this.b.get(i + this.a) != 0);
  }

  public String i()
  {
    int i = a(18);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String j()
  {
    int i = a(20);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String k()
  {
    int i = a(22);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String l()
  {
    int i = a(24);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String m()
  {
    int i = a(26);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String n()
  {
    int i = a(28);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String o()
  {
    int i = a(30);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String p()
  {
    int i = a(32);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String q()
  {
    int i = a(34);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String r()
  {
    int i = a(36);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public boolean s()
  {
    int i = a(38);
    boolean bool = false;
    if (i != 0)
    {
      int j = this.b.get(i + this.a);
      bool = false;
      if (j != 0)
        bool = true;
    }
    return bool;
  }

  public int t()
  {
    int i = a(40);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return -1;
  }

  public int u()
  {
    int i = a(42);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return -1;
  }

  public String v()
  {
    int i = a(44);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String w()
  {
    int i = a(46);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public l x()
  {
    return a(new l());
  }

  public s y()
  {
    return a(new s());
  }

  public int z()
  {
    int i = a(52);
    if (i != 0)
      return d(i);
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.b.ac
 * JD-Core Version:    0.6.2
 */