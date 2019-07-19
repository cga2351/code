package com.my.target;

import java.util.ArrayList;
import java.util.Iterator;

public class f
{
  private final String a;
  private final ArrayList<f> b = new ArrayList();
  private final ArrayList<p> c = new ArrayList();
  private final q d = q.a();
  private ArrayList<p> e;
  private ArrayList<j> f;
  private f g;
  private String h;
  private int i;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private float m = -1.0F;
  private float n = -1.0F;
  private boolean o;
  private boolean p;
  private float q = -1.0F;
  private Boolean r;
  private Boolean s;
  private Boolean t;
  private Boolean u;
  private Boolean v;

  private f(String paramString)
  {
    this.a = paramString;
  }

  public static f a(String paramString)
  {
    return new f(paramString);
  }

  public void a(float paramFloat)
  {
    this.m = paramFloat;
  }

  public void a(int paramInt)
  {
    this.j = paramInt;
  }

  public void a(f paramf)
  {
    this.b.add(paramf);
  }

  public void a(p paramp)
  {
    this.c.add(paramp);
  }

  public void a(Boolean paramBoolean)
  {
    this.r = paramBoolean;
  }

  public void a(ArrayList<j> paramArrayList)
  {
    this.f = paramArrayList;
  }

  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }

  public boolean a()
  {
    return this.o;
  }

  public int b()
  {
    return this.l;
  }

  public ArrayList<p> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if (paramString.equals(localp.c()))
        localArrayList.add(localp);
    }
    return localArrayList;
  }

  public void b(float paramFloat)
  {
    this.n = paramFloat;
  }

  public void b(int paramInt)
  {
    this.i = paramInt;
  }

  public void b(Boolean paramBoolean)
  {
    this.s = paramBoolean;
  }

  public void b(ArrayList<p> paramArrayList)
  {
    this.e = paramArrayList;
  }

  public void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public void c(float paramFloat)
  {
    this.q = paramFloat;
  }

  public void c(int paramInt)
  {
    this.l = paramInt;
  }

  public void c(Boolean paramBoolean)
  {
    this.t = paramBoolean;
  }

  public void c(String paramString)
  {
    this.h = paramString;
  }

  public void c(ArrayList<p> paramArrayList)
  {
    if (this.e == null)
      this.e = paramArrayList;
    while (paramArrayList == null)
      return;
    this.e.addAll(paramArrayList);
  }

  public boolean c()
  {
    return this.p;
  }

  public int d()
  {
    return this.j;
  }

  public void d(Boolean paramBoolean)
  {
    this.u = paramBoolean;
  }

  public f e()
  {
    return this.g;
  }

  public void e(Boolean paramBoolean)
  {
    this.v = paramBoolean;
  }

  public String f()
  {
    return this.a;
  }

  public ArrayList<f> g()
  {
    return this.b;
  }

  public ArrayList<p> h()
  {
    if (this.e != null)
      return new ArrayList(this.e);
    return null;
  }

  public ArrayList<j> i()
  {
    return this.f;
  }

  public int j()
  {
    return this.i;
  }

  public float k()
  {
    return this.m;
  }

  public float l()
  {
    return this.n;
  }

  public String m()
  {
    return this.h;
  }

  public float n()
  {
    return this.q;
  }

  public Boolean o()
  {
    return this.r;
  }

  public Boolean p()
  {
    return this.s;
  }

  public q q()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.f
 * JD-Core Version:    0.6.2
 */