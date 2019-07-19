package com.yandex.metrica.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.yandex.metrica.b;
import com.yandex.metrica.impl.ob.k;
import com.yandex.metrica.impl.ob.l;
import com.yandex.metrica.impl.ob.l.a;
import com.yandex.metrica.impl.ob.ml;
import com.yandex.metrica.impl.ob.mw;
import com.yandex.metrica.impl.ob.n;
import com.yandex.metrica.impl.ob.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class h
{
  private static final Object j = new Object();

  @SuppressLint({"StaticFieldLeak"})
  private static volatile h k;
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final int e;
  public final b f;
  public final String g;
  public final String h;
  public final List<String> i;
  private final a l;

  private h(Context paramContext)
  {
    this.l = new a(paramContext);
    this.a = "android";
    this.b = Build.MANUFACTURER;
    this.c = Build.MODEL;
    this.d = Build.VERSION.RELEASE;
    this.e = Build.VERSION.SDK_INT;
    this.f = new b(aw.b(paramContext), paramContext.getResources().getDisplayMetrics().densityDpi, paramContext.getResources().getDisplayMetrics().density);
    this.g = aw.a(paramContext).name().toLowerCase(Locale.US);
    this.h = String.valueOf(aw.b.c());
    this.i = Collections.unmodifiableList(new ArrayList()
    {
    });
  }

  public static h a(Context paramContext)
  {
    if (k == null);
    synchronized (j)
    {
      if (k == null)
        k = new h(paramContext.getApplicationContext());
      return k;
    }
  }

  public String a()
  {
    return this.l.a(null);
  }

  public String a(mw parammw)
  {
    return this.l.a(parammw);
  }

  public static class a
  {
    private String a;
    private Context b;
    private mw c;

    a(Context paramContext)
    {
      this.b = paramContext;
      com.yandex.metrica.impl.ob.h.a().b(new n(this.a));
      com.yandex.metrica.impl.ob.h.a().a(this, r.class, l.a(new k()
      {
        public void a(r paramAnonymousr)
        {
          synchronized (h.a.this)
          {
            h.a.a(h.a.this, paramAnonymousr.b);
            return;
          }
        }
      }).a());
      if (b(this.c));
      for (String str = a(paramContext); ; str = null)
      {
        this.a = str;
        return;
      }
    }

    @SuppressLint({"HardwareIds"})
    private static String a(Context paramContext)
    {
      return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    }

    private boolean b(mw parammw)
    {
      if (parammw == null);
      try
      {
        boolean bool3 = c(this.c);
        boolean bool1;
        for (boolean bool2 = bool3; ; bool2 = bool1)
        {
          return bool2;
          bool1 = c(parammw);
        }
      }
      finally
      {
      }
    }

    private static boolean c(mw parammw)
    {
      return (parammw != null) && (parammw.n.f);
    }

    public String a(mw parammw)
    {
      if ((TextUtils.isEmpty(this.a)) && (b(parammw)))
        this.a = a(this.b);
      return this.a;
    }
  }

  public static final class b
  {
    public final int a;
    public final int b;
    public final int c;
    public final float d;

    b(Point paramPoint, int paramInt, float paramFloat)
    {
      this.a = Math.max(paramPoint.x, paramPoint.y);
      this.b = Math.min(paramPoint.x, paramPoint.y);
      this.c = paramInt;
      this.d = paramFloat;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.h
 * JD-Core Version:    0.6.2
 */