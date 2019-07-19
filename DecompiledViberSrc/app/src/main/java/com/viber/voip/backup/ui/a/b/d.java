package com.viber.voip.backup.ui.a.b;

import android.net.Uri;
import android.os.Handler;
import com.google.a.a.b.a.a.b.a.c;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.BackupInfo;
import com.viber.voip.backup.c.i;
import com.viber.voip.backup.f;
import com.viber.voip.backup.f.b;
import com.viber.voip.backup.j;
import com.viber.voip.backup.k;
import com.viber.voip.backup.t;
import com.viber.voip.util.cl;
import com.viber.voip.util.i.e;
import java.io.IOException;

public class d
{
  private static final Logger a = ViberEnv.getLogger();
  private final a b = (a)cl.b(a.class);
  private final Handler c;
  private final e d;
  private final f e;
  private final com.viber.voip.backup.g f;
  private final b g;
  private final b h;
  private final k i;
  private a j = this.b;

  public d(Handler paramHandler, e parame, com.viber.voip.backup.g paramg, b paramb, f paramf)
  {
    this.c = paramHandler;
    this.d = parame;
    this.f = paramg;
    this.g = paramb;
    this.e = paramf;
    this.i = new k(new j()
    {
      public void a(Uri paramAnonymousUri, int paramAnonymousInt)
      {
      }

      public void a(Uri paramAnonymousUri, com.viber.voip.backup.c.d paramAnonymousd)
      {
        if (t.e(paramAnonymousUri))
        {
          d.c(d.this).b(paramAnonymousd);
          d.b(d.this);
        }
      }

      public boolean a(Uri paramAnonymousUri)
      {
        return t.e(paramAnonymousUri);
      }

      public void b(Uri paramAnonymousUri)
      {
        if (t.e(paramAnonymousUri))
        {
          d.a(d.this).a();
          d.b(d.this);
        }
      }

      public void c(Uri paramAnonymousUri)
      {
        if (t.e(paramAnonymousUri))
          d.b(d.this);
      }
    }
    , this.c);
    this.h = new b(1000, 1003);
  }

  private void c()
  {
    this.i.c(this.f);
  }

  public BackupInfo a()
  {
    return this.e.e();
  }

  public void a(a parama)
  {
    if (parama != null);
    while (true)
    {
      this.j = parama;
      return;
      parama = this.b;
    }
  }

  public boolean a(String paramString)
  {
    long l = this.e.d();
    if ((l == 0L) || (this.d.a() - l > 3600000L))
    {
      if (!this.i.b(this.f))
        this.f.a(paramString, this.g);
      return true;
    }
    return false;
  }

  public void b()
  {
    c();
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(int paramInt);

    public abstract void a(int paramInt1, com.google.a.a.b.a.a.b.a.d paramd, int paramInt2);

    public abstract void b();

    public abstract void b(int paramInt);
  }

  private class b extends com.viber.voip.backup.c.g
  {
    private final int b;
    private final int c;

    b(int paramInt1, int arg3)
    {
      this.b = paramInt1;
      int i;
      this.c = i;
    }

    protected void a(c paramc)
    {
      d.a(d.this).b(this.b);
    }

    protected void a(com.google.a.a.b.a.a.b.a.d paramd)
    {
      d.a(d.this).a(this.b, paramd, this.c);
    }

    protected void a(i parami)
    {
      d.a(d.this).a(this.b);
    }

    protected void a(IOException paramIOException)
    {
      d.a(d.this).b();
    }

    protected void c(com.viber.voip.backup.c.d paramd)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.b.d
 * JD-Core Version:    0.6.2
 */