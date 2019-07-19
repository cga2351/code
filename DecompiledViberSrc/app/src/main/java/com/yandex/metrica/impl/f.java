package com.yandex.metrica.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.yandex.metrica.impl.ob.fv;
import com.yandex.metrica.impl.ob.ji;
import com.yandex.metrica.impl.ob.jk;
import com.yandex.metrica.impl.ob.jo;

public class f extends ao
{
  private final fv a;

  public f(fv paramfv)
  {
    this.a = paramfv;
  }

  protected int a(jk paramjk)
  {
    return (int)this.a.c(-1L);
  }

  SparseArray<ao.a> a()
  {
    return new SparseArray()
    {
    };
  }

  protected void a(jk paramjk, int paramInt)
  {
    this.a.f(paramInt);
    paramjk.c().j();
  }

  static class a
    implements ao.a
  {
    private fv a;

    public a(fv paramfv)
    {
      this.a = paramfv;
    }

    private static boolean a(long paramLong1, long paramLong2, long paramLong3)
    {
      return (paramLong1 != paramLong3) && (paramLong2 == paramLong3);
    }

    private static boolean a(String paramString1, String paramString2)
    {
      return (!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2));
    }

    public void a(Context paramContext)
    {
      ji localji = new ji(paramContext);
      if ((!bw.a(localji.c())) && ((this.a.a(null) == null) || (this.a.b(null) == null)))
      {
        String str1 = localji.b(null);
        if (a(str1, this.a.b(null)))
          this.a.h(str1);
        String str2 = localji.a();
        if (a(str2, this.a.a()))
          this.a.m(str2);
        String str3 = localji.a(null);
        if (a(str3, this.a.a(null)))
          this.a.g(str3);
        String str4 = localji.c(null);
        if (a(str4, this.a.d(null)))
          this.a.j(str4);
        String str5 = localji.d(null);
        if (a(str5, this.a.e(null)))
          this.a.k(str5);
        String str6 = localji.e(null);
        if (a(str6, this.a.f(null)))
          this.a.l(str6);
        long l1 = localji.a(-1L);
        if (a(l1, this.a.a(-1L), -1L))
          this.a.d(l1);
        long l2 = localji.b(-1L);
        if (a(l2, this.a.b(-1L), -1L))
          this.a.e(l2);
        this.a.i();
        localji.b().j();
      }
    }
  }

  private class b
    implements ao.a
  {
    private final fv b;

    public b(fv arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void a(Context paramContext)
    {
      this.b.p(new jo("COOKIE_BROWSERS").b());
      this.b.p(new jo("BIND_ID_URL").b());
      w.a(paramContext, "b_meta.dat");
      w.a(paramContext, "browsers.dat");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.f
 * JD-Core Version:    0.6.2
 */