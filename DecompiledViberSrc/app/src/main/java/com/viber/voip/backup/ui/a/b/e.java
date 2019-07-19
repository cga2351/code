package com.viber.voip.backup.ui.a.b;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.a.a.b.a.a.b.a.a;
import com.viber.voip.ViberApplication;
import com.viber.voip.backup.c.d;
import com.viber.voip.backup.g;
import com.viber.voip.backup.j;
import com.viber.voip.backup.k;
import com.viber.voip.backup.t;
import com.viber.voip.messages.controller.b.ac;
import com.viber.voip.settings.d.j;

public class e
{
  private final Context a;
  private final ViberApplication b;
  private final Handler c;
  private final g d;
  private final com.viber.voip.backup.g.b e;
  private final ac f;
  private final k g;
  private a h;

  public e(Context paramContext, ViberApplication paramViberApplication, Handler paramHandler, g paramg, ac paramac, com.viber.voip.backup.g.b paramb)
  {
    this.a = paramContext;
    this.b = paramViberApplication;
    this.c = paramHandler;
    this.d = paramg;
    this.e = paramb;
    this.f = paramac;
    this.g = new k(new j()
    {
      public void a(Uri paramAnonymousUri, int paramAnonymousInt)
      {
        if ((t.d(paramAnonymousUri)) && (e.a(e.this) != null))
          e.a(e.this).a(paramAnonymousUri, paramAnonymousInt);
      }

      public void a(Uri paramAnonymousUri, d paramAnonymousd)
      {
        if ((t.d(paramAnonymousUri)) && (e.a(e.this) != null))
          e.a(e.this).b();
      }

      public boolean a(Uri paramAnonymousUri)
      {
        return t.d(paramAnonymousUri);
      }

      public void b(Uri paramAnonymousUri)
      {
        if ((t.d(paramAnonymousUri)) && (e.a(e.this) != null))
          e.a(e.this).a();
      }

      public void c(Uri paramAnonymousUri)
      {
        if ((t.d(paramAnonymousUri)) && (e.a(e.this) != null))
          e.a(e.this).c();
      }
    }
    , this.c);
  }

  public void a(String paramString1, String paramString2, String paramString3, a parama, boolean paramBoolean)
  {
    d.j.n.a(false);
    com.viber.voip.backup.f.e locale = new com.viber.voip.backup.f.e(paramString3, paramString2, paramString1, parama);
    this.d.a(paramString1, locale, this.e.a(this.a, 2), this.f, this.b.getEngine(false));
  }

  public boolean a()
  {
    return d.j.n.d();
  }

  public boolean a(a parama)
  {
    this.h = parama;
    return this.g.a(this.d, 2);
  }

  public boolean b()
  {
    return this.d.c() == 2;
  }

  public void c()
  {
    this.h = null;
    this.g.c(this.d);
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(Uri paramUri, int paramInt);

    public abstract void b();

    public abstract void c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.b.e
 * JD-Core Version:    0.6.2
 */