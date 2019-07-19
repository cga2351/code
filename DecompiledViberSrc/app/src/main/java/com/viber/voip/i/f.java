package com.viber.voip.i;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class f
  implements d.a
{
  protected static final Logger a = ViberEnv.getLogger();
  protected int[] b;
  protected String[] c;
  protected int d;
  protected String e;
  protected String f;
  protected volatile int g;
  private d[] h;
  private final Set<a> i = Collections.newSetFromMap(new WeakHashMap());

  f(String paramString1, String paramString2, int[] paramArrayOfInt, String[] paramArrayOfString, int paramInt, d[] paramArrayOfd)
  {
    if (paramArrayOfd == null)
      paramArrayOfd = new d[0];
    this.h = paramArrayOfd;
    this.b = a(paramArrayOfInt);
    this.c = a(paramArrayOfString);
    this.d = paramArrayOfInt[paramInt];
    this.e = paramString1;
    this.f = paramString2;
    k();
    this.g = g();
  }

  f(String paramString1, String paramString2, d[] paramArrayOfd)
  {
    this(paramString1, paramString2, b.a(), b.b(), 0, paramArrayOfd);
  }

  private void a()
  {
    int j = 0;
    synchronized (this.i)
    {
      a[] arrayOfa = (a[])this.i.toArray(new a[0]);
      int k = arrayOfa.length;
      if (j < k)
      {
        a locala = arrayOfa[j];
        if ((locala != null) && (c(locala)))
          locala.onFeatureStateChanged(this);
        j++;
      }
    }
  }

  private boolean c(a parama)
  {
    synchronized (this.i)
    {
      boolean bool = this.i.contains(parama);
      return bool;
    }
  }

  public void a(int paramInt)
  {
  }

  public final void a(a parama)
  {
    synchronized (this.i)
    {
      this.i.add(parama);
      return;
    }
  }

  public final void a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int j = 1; ; j = 0)
    {
      a(j);
      return;
    }
  }

  protected int[] a(int[] paramArrayOfInt)
  {
    return paramArrayOfInt;
  }

  protected String[] a(String[] paramArrayOfString)
  {
    return paramArrayOfString;
  }

  public void b()
  {
    m();
  }

  public final void b(a parama)
  {
    synchronized (this.i)
    {
      this.i.remove(parama);
      return;
    }
  }

  public final String c()
  {
    return this.e;
  }

  public final String d()
  {
    return this.f;
  }

  public final boolean e()
  {
    return this.d != f();
  }

  public final int f()
  {
    int j = g();
    if (this.g != j)
    {
      this.g = j;
      a();
    }
    return this.g;
  }

  protected int g()
  {
    return this.d;
  }

  public int h()
  {
    return this.d;
  }

  public final int[] i()
  {
    return this.b;
  }

  public final String[] j()
  {
    return this.c;
  }

  protected void k()
  {
    d[] arrayOfd = this.h;
    int j = arrayOfd.length;
    for (int k = 0; k < j; k++)
      arrayOfd[k].a(this);
  }

  protected final boolean l()
  {
    for (d locald : this.h)
      if ((locald != null) && (!locald.a()))
        return false;
    return true;
  }

  protected final void m()
  {
    int j = g();
    if (this.g != j)
    {
      this.g = j;
      a();
    }
  }

  public String toString()
  {
    return "FeatureSwitcher{mKey='" + this.e + '\'' + ", mTitle='" + this.f + '\'' + ", mStates=" + Arrays.toString(this.b) + ", mStatesNames=" + Arrays.toString(this.c) + ", mDisabledState=" + this.d + ", mConditions=" + Arrays.toString(this.h) + ", isEnabled()=" + e() + ", displayState()=" + h() + ", state()=" + f() + '}';
  }

  public static abstract interface a
  {
    public abstract void onFeatureStateChanged(f paramf);
  }

  public static final class b
  {
    private static int[] c()
    {
      return new int[] { 0, 1 };
    }

    private static String[] d()
    {
      return new String[] { "Disabled", "Enabled" };
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.i.f
 * JD-Core Version:    0.6.2
 */