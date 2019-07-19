package com.viber.provider;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.util.af;

public abstract class d<T>
  implements c<T>
{
  protected static final Logger a = ViberEnv.getLogger();
  protected final a b;
  protected final LoaderManager c;
  protected final Context d;
  protected Uri e;
  protected Cursor f;
  protected int g;
  protected int h;
  protected Handler i = av.a(av.e.a);
  protected boolean j;
  protected boolean k;
  private CursorLoader l;
  private String[] m;
  private String n;
  private String[] o;
  private String p;
  private String q;
  private String r;
  private String s;
  private boolean t;
  private Boolean u;
  private boolean v;
  private final LoaderManager.LoaderCallbacks<Cursor> w = new LoaderManager.LoaderCallbacks()
  {
    public void a(Loader<Cursor> paramAnonymousLoader, Cursor paramAnonymousCursor)
    {
      synchronized (d.this)
      {
        if (d.e(d.this))
        {
          d.a(d.this, false);
          d.this.i.post(d.f(d.this));
          return;
        }
        d.a(d.this, paramAnonymousCursor);
      }
    }

    public Loader<Cursor> onCreateLoader(int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      synchronized (d.this)
      {
        Context localContext = d.this.d;
        Uri localUri = d.this.e;
        String[] arrayOfString1 = d.a(d.this);
        String str1 = d.b(d.this);
        String[] arrayOfString2 = d.c(d.this);
        if (!TextUtils.isEmpty(d.d(d.this)))
        {
          str2 = d.this.o() + " LIMIT " + d.d(d.this);
          CursorLoader localCursorLoader = new CursorLoader(localContext, localUri, arrayOfString1, str1, arrayOfString2, str2);
          return localCursorLoader;
        }
        String str2 = d.this.o();
      }
    }

    public void onLoaderReset(Loader<Cursor> paramAnonymousLoader)
    {
      d.g(d.this);
    }
  };
  private Runnable x = new Runnable()
  {
    public void run()
    {
      try
      {
        CursorLoader localCursorLoader;
        if (d.h(d.this) != null)
        {
          d.h(d.this).setUri(d.this.e);
          d.h(d.this).setSelection(d.b(d.this));
          d.h(d.this).setSelectionArgs(d.c(d.this));
          localCursorLoader = d.h(d.this);
          if (TextUtils.isEmpty(d.d(d.this)))
            break label140;
        }
        label140: for (String str = d.this.o() + " LIMIT " + d.d(d.this); ; str = d.this.o())
        {
          localCursorLoader.setSortOrder(str);
          d.h(d.this).forceLoad();
          return;
        }
      }
      finally
      {
      }
    }
  };

  static
  {
    LoaderManager.enableDebugLogging(false);
  }

  public d(int paramInt1, Uri paramUri, Context paramContext, LoaderManager paramLoaderManager, a parama, int paramInt2)
  {
    this.e = paramUri;
    this.h = paramInt1;
    this.d = paramContext;
    this.b = parama;
    this.c = paramLoaderManager;
    this.g = paramInt2;
  }

  private void a(Cursor paramCursor)
  {
    try
    {
      if (this.u == null)
        this.u = Boolean.valueOf(false);
      this.f = paramCursor;
      m();
      h();
      this.u = Boolean.valueOf(true);
      return;
    }
    finally
    {
    }
  }

  private void r()
  {
    try
    {
      this.f = null;
      g();
      this.u = Boolean.valueOf(false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private String s()
  {
    if (this.q != null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(this.n).append(" GROUP BY ").append(this.q);
      if (TextUtils.isEmpty(this.r));
      for (String str = ""; ; str = " HAVING " + this.r)
        return str;
    }
    return this.n;
  }

  public long a(int paramInt)
  {
    if (b_(paramInt))
      return this.f.getLong(this.g);
    return 0L;
  }

  public void a(Uri paramUri)
  {
    try
    {
      this.e = paramUri;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(String paramString)
  {
    try
    {
      this.n = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(String[] paramArrayOfString)
  {
    try
    {
      this.m = paramArrayOfString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public abstract T b(int paramInt);

  public void b(String paramString)
  {
    try
    {
      this.q = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(String[] paramArrayOfString)
  {
    try
    {
      this.o = paramArrayOfString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean b()
  {
    return this.j;
  }

  protected boolean b_(int paramInt)
  {
    return (paramInt >= 0) && (!af.b(this.f)) && (this.f.moveToPosition(paramInt));
  }

  public void c()
  {
    try
    {
      this.j = false;
      if ((this.k) || (f()))
      {
        this.u = Boolean.valueOf(true);
        if (this.k)
          l();
        this.k = false;
      }
      return;
    }
    finally
    {
    }
  }

  public void c(String paramString)
  {
    try
    {
      this.r = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void d(int paramInt)
  {
    try
    {
      e(String.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void d(String paramString)
  {
    try
    {
      this.p = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean d()
  {
    try
    {
      boolean bool = this.t;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void e(String paramString)
  {
    try
    {
      this.s = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean e()
  {
    try
    {
      if (this.u != null)
      {
        boolean bool2 = this.u.booleanValue();
        if (!bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  public boolean f()
  {
    try
    {
      if (this.u != null)
      {
        boolean bool2 = this.u.booleanValue();
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  protected void g()
  {
    try
    {
      if (this.b != null)
        this.b.onLoaderReset(this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getCount()
  {
    if (!af.b(this.f))
      return this.f.getCount();
    return 0;
  }

  protected void h()
  {
    try
    {
      if (this.b != null)
        this.b.onLoadFinished(this, e());
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void i()
  {
    try
    {
      if (this.t)
        j();
      this.t = true;
      this.u = null;
      this.l = ((CursorLoader)this.c.initLoader(this.h, null, this.w));
      return;
    }
    finally
    {
    }
  }

  public void j()
  {
    try
    {
      this.c.destroyLoader(this.h);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void k()
  {
    try
    {
      this.i.removeCallbacks(this.x);
      this.i.post(this.x);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void l()
  {
    while (true)
    {
      try
      {
        if (this.j)
        {
          this.k = true;
          return;
        }
        if (f())
        {
          this.i.removeCallbacks(this.x);
          this.i.postDelayed(this.x, 70L);
          continue;
        }
      }
      finally
      {
      }
      this.v = true;
    }
  }

  protected void m()
  {
  }

  public String n()
  {
    return this.n;
  }

  public String o()
  {
    return this.p;
  }

  public void p()
  {
  }

  public void q()
  {
    this.i.removeCallbacks(this.x);
  }

  public void y_()
  {
    try
    {
      this.j = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static abstract interface a
  {
    public abstract void onLoadFinished(d paramd, boolean paramBoolean);

    public abstract void onLoaderReset(d paramd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.d
 * JD-Core Version:    0.6.2
 */