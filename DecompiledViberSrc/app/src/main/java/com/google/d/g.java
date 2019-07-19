package com.google.d;

import com.google.d.b.a.l;
import com.google.d.b.a.n;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g
{
  private com.google.d.b.d a = com.google.d.b.d.a;
  private v b = v.a;
  private e c = d.a;
  private final Map<Type, h<?>> d = new HashMap();
  private final List<x> e = new ArrayList();
  private final List<x> f = new ArrayList();
  private boolean g = false;
  private String h;
  private int i = 2;
  private int j = 2;
  private boolean k = false;
  private boolean l = false;
  private boolean m = true;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;

  private void a(String paramString, int paramInt1, int paramInt2, List<x> paramList)
  {
    if ((paramString != null) && (!"".equals(paramString.trim())));
    for (a locala = new a(paramString); ; locala = new a(paramInt1, paramInt2))
    {
      paramList.add(l.a(com.google.d.c.a.get(java.util.Date.class), locala));
      paramList.add(l.a(com.google.d.c.a.get(Timestamp.class), locala));
      paramList.add(l.a(com.google.d.c.a.get(java.sql.Date.class), locala));
      do
        return;
      while ((paramInt1 == 2) || (paramInt2 == 2));
    }
  }

  public f a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.e);
    Collections.reverse(localArrayList);
    localArrayList.addAll(this.f);
    a(this.h, this.i, this.j, localArrayList);
    return new f(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.b, localArrayList);
  }

  public g a(Type paramType, Object paramObject)
  {
    if (((paramObject instanceof t)) || ((paramObject instanceof k)) || ((paramObject instanceof h)) || ((paramObject instanceof w)));
    for (boolean bool = true; ; bool = false)
    {
      com.google.d.b.a.a(bool);
      if ((paramObject instanceof h))
        this.d.put(paramType, (h)paramObject);
      if (((paramObject instanceof t)) || ((paramObject instanceof k)))
      {
        com.google.d.c.a locala = com.google.d.c.a.get(paramType);
        this.e.add(l.b(locala, paramObject));
      }
      if ((paramObject instanceof w))
        this.e.add(n.a(com.google.d.c.a.get(paramType), (w)paramObject));
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.g
 * JD-Core Version:    0.6.2
 */