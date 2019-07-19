package com.viber.voip.flatbuffers.a.b;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class t extends com.google.c.a
{
  public static t a(ByteBuffer paramByteBuffer)
  {
    return a(paramByteBuffer, new t());
  }

  public static t a(ByteBuffer paramByteBuffer, t paramt)
  {
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    return paramt.a(paramByteBuffer.getInt(paramByteBuffer.position()) + paramByteBuffer.position(), paramByteBuffer);
  }

  public n A()
  {
    return a(new n());
  }

  public int B()
  {
    int i = a(56);
    if (i != 0)
      return d(i);
    return 0;
  }

  public af C()
  {
    return a(new af());
  }

  public e D()
  {
    return a(new e());
  }

  public r E()
  {
    return a(new r());
  }

  public g F()
  {
    return a(new g());
  }

  public w G()
  {
    return a(new w());
  }

  public m H()
  {
    return a(new m());
  }

  public k I()
  {
    return a(new k());
  }

  public a a(a parama)
  {
    int i = a(52);
    if (i != 0)
      return parama.a(b(i + this.a), this.b);
    return null;
  }

  public aa a(aa paramaa)
  {
    int i = a(42);
    if (i != 0)
      return paramaa.a(b(i + this.a), this.b);
    return null;
  }

  public ab a(ab paramab)
  {
    int i = a(48);
    if (i != 0)
      return paramab.a(b(i + this.a), this.b);
    return null;
  }

  public ae a(ae paramae)
  {
    int i = a(38);
    if (i != 0)
      return paramae.a(b(i + this.a), this.b);
    return null;
  }

  public af a(af paramaf)
  {
    int i = a(58);
    if (i != 0)
      return paramaf.a(b(i + this.a), this.b);
    return null;
  }

  public ag a(ag paramag, int paramInt)
  {
    int i = a(56);
    if (i != 0)
      return paramag.a(b(e(i) + paramInt * 4), this.b);
    return null;
  }

  public ah a(ah paramah)
  {
    int i = a(24);
    if (i != 0)
      return paramah.a(b(i + this.a), this.b);
    return null;
  }

  public b a(b paramb)
  {
    int i = a(46);
    if (i != 0)
      return paramb.a(b(i + this.a), this.b);
    return null;
  }

  public e a(e parame)
  {
    int i = a(60);
    if (i != 0)
      return parame.a(b(i + this.a), this.b);
    return null;
  }

  public g a(g paramg)
  {
    int i = a(64);
    if (i != 0)
      return paramg.a(b(i + this.a), this.b);
    return null;
  }

  public i a(i parami)
  {
    int i = a(36);
    if (i != 0)
      return parami.a(b(i + this.a), this.b);
    return null;
  }

  public k a(k paramk)
  {
    int i = a(70);
    if (i != 0)
      return paramk.a(b(i + this.a), this.b);
    return null;
  }

  public m a(m paramm)
  {
    int i = a(68);
    if (i != 0)
      return paramm.a(b(i + this.a), this.b);
    return null;
  }

  public n a(n paramn)
  {
    int i = a(54);
    if (i != 0)
      return paramn.a(b(i + this.a), this.b);
    return null;
  }

  public r a(r paramr)
  {
    int i = a(62);
    if (i != 0)
      return paramr.a(b(i + this.a), this.b);
    return null;
  }

  public t a(int paramInt, ByteBuffer paramByteBuffer)
  {
    this.a = paramInt;
    this.b = paramByteBuffer;
    return this;
  }

  public v a(v paramv)
  {
    int i = a(44);
    if (i != 0)
      return paramv.a(b(i + this.a), this.b);
    return null;
  }

  public w a(w paramw)
  {
    int i = a(66);
    if (i != 0)
      return paramw.a(b(i + this.a), this.b);
    return null;
  }

  public z a(z paramz)
  {
    int i = a(40);
    if (i != 0)
      return paramz.a(b(i + this.a), this.b);
    return null;
  }

  public String b()
  {
    int i = a(4);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public String c()
  {
    int i = a(6);
    if (i != 0)
      return c(i + this.a);
    return null;
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

  public ag f(int paramInt)
  {
    return a(new ag(), paramInt);
  }

  public String f()
  {
    int i = a(12);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public long g()
  {
    int i = a(14);
    if (i != 0)
      return this.b.getLong(i + this.a);
    return 0L;
  }

  public String h()
  {
    int i = a(16);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public int i()
  {
    int i = a(18);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return 0;
  }

  public int j()
  {
    int i = a(20);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return 0;
  }

  public String k()
  {
    int i = a(22);
    if (i != 0)
      return c(i + this.a);
    return null;
  }

  public ah l()
  {
    return a(new ah());
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

  public i r()
  {
    return a(new i());
  }

  public ae s()
  {
    return a(new ae());
  }

  public z t()
  {
    return a(new z());
  }

  public aa u()
  {
    return a(new aa());
  }

  public v v()
  {
    return a(new v());
  }

  public b w()
  {
    return a(new b());
  }

  public ab x()
  {
    return a(new ab());
  }

  public int y()
  {
    int i = a(50);
    if (i != 0)
      return this.b.getInt(i + this.a);
    return 0;
  }

  public a z()
  {
    return a(new a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.a.b.t
 * JD-Core Version:    0.6.2
 */