package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.yandex.mobile.ads.b;
import java.util.ArrayList;
import java.util.List;

public final class v<T>
  implements Parcelable
{
  public static final Parcelable.Creator<v> CREATOR = new Parcelable.Creator()
  {
  };
  public static final Integer a = Integer.valueOf(100);
  private final b b;
  private final String c;
  private final aj d;
  private final int e;
  private final int f;
  private final List<String> g;
  private final List<String> h;
  private cn i;
  private final List<Long> j;
  private final List<Integer> k;
  private final int l;
  private final int m;
  private final int n;
  private final int o;
  private final String p;
  private final bb q;
  private final bf r;
  private final T s;
  private final boolean t;

  protected v(Parcel paramParcel)
  {
    int i1 = paramParcel.readInt();
    b localb;
    if (i1 == -1)
    {
      localb = null;
      this.b = localb;
      this.c = paramParcel.readString();
      this.d = ((aj)paramParcel.readParcelable(aj.class.getClassLoader()));
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.g = paramParcel.createStringArrayList();
      this.h = paramParcel.createStringArrayList();
      this.j = new ArrayList();
      paramParcel.readList(this.j, Long.class.getClassLoader());
      this.k = new ArrayList();
      paramParcel.readList(this.k, Integer.class.getClassLoader());
      this.l = paramParcel.readInt();
      this.m = paramParcel.readInt();
      this.n = paramParcel.readInt();
      this.o = paramParcel.readInt();
      this.p = paramParcel.readString();
      this.q = ((bb)paramParcel.readParcelable(bb.class.getClassLoader()));
      this.r = ((bf)paramParcel.readParcelable(bf.class.getClassLoader()));
      Class localClass = (Class)paramParcel.readSerializable();
      Object localObject = null;
      if (localClass != null)
        localObject = paramParcel.readValue(localClass.getClassLoader());
      this.s = localObject;
      if (paramParcel.readByte() == 0)
        break label257;
    }
    label257: for (boolean bool = true; ; bool = false)
    {
      this.t = bool;
      return;
      localb = b.values()[i1];
      break;
    }
  }

  private v(a<T> parama)
  {
    this.b = a.a(parama);
    this.c = a.b(parama);
    this.e = a.c(parama);
    this.f = a.d(parama);
    if (a.e(parama) != null);
    for (aj.a locala = a.e(parama); ; locala = aj.a.a)
    {
      this.d = new aj(this.e, this.f, locala);
      this.g = a.f(parama);
      this.h = a.g(parama);
      this.j = a.h(parama);
      this.k = a.i(parama);
      this.i = a.j(parama);
      this.l = a.k(parama);
      this.m = a.l(parama);
      this.n = a.m(parama);
      this.o = a.n(parama);
      this.p = a.o(parama);
      this.s = a.p(parama);
      this.q = a.q(parama);
      this.r = a.r(parama);
      this.t = a.s(parama);
      return;
    }
  }

  public final b a()
  {
    return this.b;
  }

  public final String b()
  {
    return this.c;
  }

  public final aj c()
  {
    return this.d;
  }

  public final int d()
  {
    return this.e;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final int e()
  {
    return this.f;
  }

  public final List<String> f()
  {
    return this.g;
  }

  public final List<String> g()
  {
    return this.h;
  }

  public final cn h()
  {
    return this.i;
  }

  public final List<Long> i()
  {
    return this.j;
  }

  public final List<Integer> j()
  {
    return this.k;
  }

  public final int k()
  {
    return this.m;
  }

  public final int l()
  {
    return this.l;
  }

  public final int m()
  {
    return 1000 * this.m;
  }

  public final int n()
  {
    return 1000 * this.n;
  }

  public final String o()
  {
    return this.p;
  }

  public final bf p()
  {
    return this.r;
  }

  public final bb q()
  {
    return this.q;
  }

  public final T r()
  {
    return this.s;
  }

  public final boolean s()
  {
    return this.f == 0;
  }

  public final boolean t()
  {
    return this.m > 0;
  }

  public final boolean u()
  {
    return this.t;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i1;
    if (this.b == null)
    {
      i1 = -1;
      paramParcel.writeInt(i1);
      paramParcel.writeString(this.c);
      paramParcel.writeParcelable(this.d, paramInt);
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
      paramParcel.writeStringList(this.g);
      paramParcel.writeStringList(this.h);
      paramParcel.writeList(this.j);
      paramParcel.writeList(this.k);
      paramParcel.writeInt(this.l);
      paramParcel.writeInt(this.m);
      paramParcel.writeInt(this.n);
      paramParcel.writeInt(this.o);
      paramParcel.writeString(this.p);
      paramParcel.writeParcelable(this.q, paramInt);
      paramParcel.writeParcelable(this.r, paramInt);
      paramParcel.writeSerializable(this.s.getClass());
      paramParcel.writeValue(this.s);
      if (!this.t)
        break label185;
    }
    label185: for (int i2 = 1; ; i2 = 0)
    {
      paramParcel.writeByte((byte)i2);
      return;
      i1 = this.b.ordinal();
      break;
    }
  }

  public static final class a<T>
  {
    private b a;
    private String b;
    private int c;
    private int d;
    private aj.a e;
    private List<String> f;
    private List<String> g;
    private cn h;
    private List<Long> i;
    private List<Integer> j;
    private int k;
    private int l;
    private int m;
    private int n;
    private String o;
    private bb p;
    private bf q;
    private T r;
    private boolean s;

    public final a<T> a(int paramInt)
    {
      this.c = paramInt;
      return this;
    }

    public final a<T> a(b paramb)
    {
      this.a = paramb;
      return this;
    }

    public final a<T> a(aj.a parama)
    {
      this.e = parama;
      return this;
    }

    public final a<T> a(bb parambb)
    {
      this.p = parambb;
      return this;
    }

    public final a<T> a(bf parambf)
    {
      this.q = parambf;
      return this;
    }

    public final a<T> a(cn paramcn)
    {
      this.h = paramcn;
      return this;
    }

    public final a<T> a(T paramT)
    {
      this.r = paramT;
      return this;
    }

    public final a<T> a(String paramString)
    {
      this.b = paramString;
      return this;
    }

    public final a<T> a(List<String> paramList)
    {
      this.f = paramList;
      return this;
    }

    public final a<T> a(boolean paramBoolean)
    {
      this.s = paramBoolean;
      return this;
    }

    public final v<T> a()
    {
      return new v(this, (byte)0);
    }

    public final a<T> b(int paramInt)
    {
      this.d = paramInt;
      return this;
    }

    public final a<T> b(String paramString)
    {
      this.o = paramString;
      return this;
    }

    public final a<T> b(List<String> paramList)
    {
      this.g = paramList;
      return this;
    }

    public final a<T> c(int paramInt)
    {
      this.l = paramInt;
      return this;
    }

    public final a<T> c(List<Long> paramList)
    {
      this.i = paramList;
      return this;
    }

    public final a<T> d(int paramInt)
    {
      this.m = paramInt;
      return this;
    }

    public final a<T> d(List<Integer> paramList)
    {
      this.j = paramList;
      return this;
    }

    public final a<T> e(int paramInt)
    {
      this.n = paramInt;
      return this;
    }

    public final a<T> f(int paramInt)
    {
      this.k = paramInt;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.v
 * JD-Core Version:    0.6.2
 */