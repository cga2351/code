package com.viber.voip.b.a.a.a;

import com.viber.voip.b.a;
import com.viber.voip.b.c;
import com.viber.voip.util.da;

public class e
  implements c<String, b>
{
  c<String, b> a;
  private final String b;

  public e(a parama)
  {
    this(parama.toString(), parama.m, parama.n);
  }

  public e(String paramString, float paramFloat1, float paramFloat2)
  {
    this.a = new com.viber.voip.b.e(paramString, paramFloat1, paramFloat2)
    {
      protected int a(String paramAnonymousString, b paramAnonymousb)
      {
        return paramAnonymousb.c();
      }

      protected void a(boolean paramAnonymousBoolean, String paramAnonymousString, b paramAnonymousb1, b paramAnonymousb2)
      {
        paramAnonymousb1.d();
      }
    };
    this.b = paramString;
  }

  public b a(String paramString)
  {
    while (true)
    {
      try
      {
        if (!da.a(paramString))
        {
          localb = (b)this.a.get(paramString);
          if ((localb != null) && (localb.a() == null))
          {
            this.a.remove(paramString);
            localb = null;
          }
          return localb;
        }
      }
      finally
      {
      }
      b localb = null;
    }
  }

  public b a(String paramString, b paramb)
  {
    if ((paramb == null) || (paramb.a() == null) || (paramString == null))
      return null;
    try
    {
      if (a(paramString) == null)
      {
        paramb.b();
        this.a.put(paramString, paramb);
      }
      return paramb;
    }
    finally
    {
    }
  }

  public b b(String paramString)
  {
    return (b)this.a.remove(paramString);
  }

  public void evictAll()
  {
    this.a.evictAll();
  }

  public int size()
  {
    return this.a.size();
  }

  public void trimToSize(int paramInt)
  {
    this.a.trimToSize(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.a.a.a.e
 * JD-Core Version:    0.6.2
 */