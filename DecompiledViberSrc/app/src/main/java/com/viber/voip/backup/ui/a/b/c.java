package com.viber.voip.backup.ui.a.b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.voip.analytics.story.g.a;
import com.viber.voip.backup.c.f;
import com.viber.voip.backup.c.h;
import com.viber.voip.backup.c.i;
import com.viber.voip.backup.j;
import com.viber.voip.backup.k;
import com.viber.voip.backup.t;
import java.io.IOException;

public class c
{
  final Engine a;
  protected final com.viber.voip.backup.c b;
  private final Context c;
  private final Handler d;
  private final com.viber.voip.backup.g e;
  private final com.viber.voip.backup.f.c f;
  private final com.viber.voip.backup.g.b g;
  private final com.viber.voip.backup.d.a.b h;
  private final com.viber.voip.analytics.g i;
  private final a j;
  private b k;
  private final k l;
  private a m;

  public c(Context paramContext, Engine paramEngine, Handler paramHandler, com.viber.voip.backup.g paramg, com.viber.voip.backup.f.c paramc, com.viber.voip.backup.g.b paramb, com.viber.voip.backup.d.a.b paramb1, com.viber.voip.analytics.g paramg1, a parama, com.viber.voip.backup.c paramc1)
  {
    this.c = paramContext;
    this.a = paramEngine;
    this.d = paramHandler;
    this.e = paramg;
    this.f = paramc;
    this.g = paramb;
    this.h = paramb1;
    this.i = paramg1;
    this.j = parama;
    this.b = paramc1;
    this.l = new k(new j()
    {
      public void a(Uri paramAnonymousUri, int paramAnonymousInt)
      {
        if ((t.c(paramAnonymousUri)) && (c.a(c.this) != null))
          c.a(c.this).a(paramAnonymousUri, paramAnonymousInt);
      }

      public void a(Uri paramAnonymousUri, com.viber.voip.backup.c.d paramAnonymousd)
      {
        if ((t.c(paramAnonymousUri)) && (c.a(c.this) != null))
          c.b(c.this).b(paramAnonymousd);
      }

      public boolean a(Uri paramAnonymousUri)
      {
        return t.c(paramAnonymousUri);
      }

      public void b(Uri paramAnonymousUri)
      {
        if ((t.c(paramAnonymousUri)) && (c.a(c.this) != null))
          c.a(c.this).a();
      }

      public void c(Uri paramAnonymousUri)
      {
        if ((t.c(paramAnonymousUri)) && (c.a(c.this) != null))
          c.a(c.this).b();
      }
    }
    , this.d);
    this.k = new b(null);
  }

  public boolean a()
  {
    return this.e.b();
  }

  public boolean a(a parama)
  {
    this.m = parama;
    boolean bool = this.l.a(this.e, 1);
    this.b.a(false);
    return bool;
  }

  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    return this.e.a(this.a, paramString1, paramString2, this.f, this.g.a(this.c, 1), paramInt, this.h, this.i, this.j);
  }

  public boolean b()
  {
    return this.e.c() == 1;
  }

  public void c()
  {
    this.b.a(true);
    this.m = null;
    this.l.c(this.e);
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(int paramInt);

    public abstract void a(Uri paramUri, int paramInt);

    public abstract void a(com.google.a.a.b.a.a.b.a.d paramd);

    public abstract void b();
  }

  private class b extends h
  {
    private b()
    {
    }

    protected void a(com.google.a.a.b.a.a.b.a.c paramc)
    {
      c.a(c.this).a(2);
    }

    protected void a(com.google.a.a.b.a.a.b.a.d paramd)
    {
      c.a(c.this).a(paramd);
    }

    protected void a(com.viber.voip.backup.c.d paramd)
    {
      c.a(c.this).a(0);
    }

    protected void a(f paramf)
    {
      c.a(c.this).a(4);
    }

    protected void a(i parami)
    {
      c.a(c.this).a(1);
    }

    protected void a(IOException paramIOException)
    {
      c.a(c.this).a(3);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.b.c
 * JD-Core Version:    0.6.2
 */