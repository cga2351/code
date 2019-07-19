package com.google.android.exoplayer2.f;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class p
  implements h
{
  private final Context a;
  private final List<ad> b;
  private final h c;
  private h d;
  private h e;
  private h f;
  private h g;
  private h h;
  private h i;
  private h j;

  public p(Context paramContext, h paramh)
  {
    this.a = paramContext.getApplicationContext();
    this.c = ((h)a.a(paramh));
    this.b = new ArrayList();
  }

  private void a(h paramh)
  {
    for (int k = 0; k < this.b.size(); k++)
      paramh.a((ad)this.b.get(k));
  }

  private void a(h paramh, ad paramad)
  {
    if (paramh != null)
      paramh.a(paramad);
  }

  private h d()
  {
    if (this.d == null)
    {
      this.d = new u();
      a(this.d);
    }
    return this.d;
  }

  private h e()
  {
    if (this.e == null)
    {
      this.e = new c(this.a);
      a(this.e);
    }
    return this.e;
  }

  private h f()
  {
    if (this.f == null)
    {
      this.f = new f(this.a);
      a(this.f);
    }
    return this.f;
  }

  private h g()
  {
    if (this.g == null);
    try
    {
      this.g = ((h)Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]));
      a(this.g);
      if (this.g == null)
        this.g = this.c;
      return this.g;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        com.google.android.exoplayer2.g.l.c("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Error instantiating RTMP extension", localException);
    }
  }

  private h h()
  {
    if (this.h == null)
    {
      this.h = new g();
      a(this.h);
    }
    return this.h;
  }

  private h i()
  {
    if (this.i == null)
    {
      this.i = new ab(this.a);
      a(this.i);
    }
    return this.i;
  }

  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return ((h)a.a(this.j)).a(paramArrayOfByte, paramInt1, paramInt2);
  }

  public long a(l paraml)
    throws IOException
  {
    boolean bool;
    String str;
    if (this.j == null)
    {
      bool = true;
      a.b(bool);
      str = paraml.a.getScheme();
      if (!ag.a(paraml.a))
        break label81;
      if (!paraml.a.getPath().startsWith("/android_asset/"))
        break label70;
      this.j = e();
    }
    while (true)
    {
      return this.j.a(paraml);
      bool = false;
      break;
      label70: this.j = d();
      continue;
      label81: if ("asset".equals(str))
        this.j = e();
      else if ("content".equals(str))
        this.j = f();
      else if ("rtmp".equals(str))
        this.j = g();
      else if ("data".equals(str))
        this.j = h();
      else if ("rawresource".equals(str))
        this.j = i();
      else
        this.j = this.c;
    }
  }

  public Uri a()
  {
    if (this.j == null)
      return null;
    return this.j.a();
  }

  public void a(ad paramad)
  {
    this.c.a(paramad);
    this.b.add(paramad);
    a(this.d, paramad);
    a(this.e, paramad);
    a(this.f, paramad);
    a(this.g, paramad);
    a(this.h, paramad);
    a(this.i, paramad);
  }

  public Map<String, List<String>> b()
  {
    if (this.j == null)
      return Collections.emptyMap();
    return this.j.b();
  }

  public void c()
    throws IOException
  {
    if (this.j != null);
    try
    {
      this.j.c();
      return;
    }
    finally
    {
      this.j = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.p
 * JD-Core Version:    0.6.2
 */