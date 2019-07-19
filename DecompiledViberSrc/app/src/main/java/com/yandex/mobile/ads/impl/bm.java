package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.yandex.mobile.ads.b;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public abstract class bm<T> extends pm<eo, v<T>>
{
  private final String a;
  private final Context b;
  private final eo c;
  private final br d;
  private final bt e;
  private final bq f;

  public bm(Context paramContext, eo parameo, String paramString1, String paramString2, pl.a<v<T>> parama, fe<eo, v<T>> paramfe)
  {
    super(paramContext, parameo.j(), paramString1, parama, parameo, paramfe);
    new Object[] { paramString1, paramString2 };
    a(new od(parameo.k(), 0, 1.0F));
    this.a = paramString2;
    this.c = parameo;
    this.b = paramContext.getApplicationContext();
    this.d = new br();
    this.e = new bt();
    this.f = new bq();
  }

  protected static boolean b(int paramInt)
  {
    return 204 == paramInt;
  }

  protected final ok<v<T>> a(oh paramoh, int paramInt)
  {
    if (a(paramInt))
    {
      Map localMap1 = paramoh.c;
      b localb = b.a(bi.a(localMap1, oa.c));
      int i;
      v.a locala;
      aj.a locala1;
      label130: String str2;
      label315: be localbe;
      label344: bg localbg;
      if (localb == this.c.a())
      {
        i = 1;
        if (i == 0)
          break label625;
        locala = new v.a();
        locala.a(this.c.e());
        locala.a(localb);
        int j = bi.c(localMap1, oa.a);
        int k = bi.c(localMap1, oa.b);
        locala.a(j);
        locala.b(k);
        aj localaj = this.c.b();
        if (localaj == null)
          break label587;
        locala1 = localaj.c();
        locala.a(locala1);
        locala.a(bi.e(localMap1, oa.e));
        locala.c(bi.a(localMap1, oa.h, new bi.a()
        {
        }));
        locala.d(bi.a(localMap1, oa.w, new bi.a()
        {
        }));
        locala.b(bi.e(localMap1, oa.f));
        locala.f(bi.c(localMap1, oa.l));
        locala.c(bi.c(localMap1, oa.m));
        locala.d(bi.c(localMap1, oa.n));
        locala.e(bi.c(localMap1, oa.r));
        locala.b(bi.a(localMap1, oa.s));
        Map localMap2 = paramoh.c;
        Integer localInteger = cw.c(bi.a(localMap2, oa.o));
        String str1 = bi.a(localMap2, oa.p);
        if (str1 == null)
          break label593;
        str2 = bp.a(str1.getBytes());
        if ((localInteger == null) || (TextUtils.isEmpty(str2)))
          break label599;
        localbe = new be(localInteger.intValue(), str2);
        String str3 = bi.d(localMap2, oa.q);
        if (TextUtils.isEmpty(str3))
          break label605;
        localbg = new bg(str3);
        label373: boolean bool = bi.b(localMap2, oa.u);
        locala.a(new bf.a().a(localbe).a(localbg).a(bool).a());
        Map localMap3 = paramoh.c;
        String str4 = bi.d(localMap3, oa.j);
        Long localLong = cw.a(bi.a(localMap3, oa.k), null);
        cn localcn = null;
        if (str4 != null)
        {
          localcn = null;
          if (localLong != null)
            localcn = new cn(str4, localLong.longValue());
        }
        locala.a(localcn);
        String str5 = bi.a(localMap1, oa.v);
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = oa.v.a();
        arrayOfObject[1] = str5;
        cw.a(this.b, str5);
        locala.a(bi.b(localMap1, oa.t));
        if (!bi.b(localMap1, oa.g))
          break label611;
        locala.a(br.a(paramoh));
      }
      while (true)
      {
        v localv = locala.a();
        if (b(paramInt))
          break label625;
        return ok.a(localv, oz.a(paramoh));
        i = 0;
        break;
        label587: locala1 = null;
        break label130;
        label593: str2 = null;
        break label315;
        label599: localbe = null;
        break label344;
        label605: localbg = null;
        break label373;
        label611: locala.a(a_(paramoh));
      }
    }
    label625: return ok.a(q.a(paramoh));
  }

  protected final ov a(ov paramov)
  {
    return super.a(q.a(paramov.a));
  }

  public final Map<String, String> a()
    throws oo
  {
    HashMap localHashMap = new HashMap();
    String str = cw.a(this.b);
    if (str != null)
    {
      new Object[] { str };
      localHashMap.put(oa.v.a(), str);
    }
    return localHashMap;
  }

  protected boolean a(int paramInt)
  {
    return 200 == paramInt;
  }

  protected abstract T a_(oh paramoh);

  public final String b()
  {
    String str = super.b();
    if (d() == 0)
      str = Uri.parse(str).buildUpon().encodedQuery(this.a).build().toString();
    return df.e(str);
  }

  public final byte[] c()
    throws oo
  {
    Object localObject = super.c();
    if (1 == d());
    try
    {
      if (this.a != null)
      {
        byte[] arrayOfByte = this.a.getBytes("UTF-8");
        localObject = arrayOfByte;
      }
      return localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.a;
      arrayOfObject[1] = "UTF-8";
    }
    return localObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.bm
 * JD-Core Version:    0.6.2
 */