package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.io.UnsupportedEncodingException;

abstract class qg<R, T> extends pm<R, T>
{
  private qg(String paramString, pl.a<T> parama, Context paramContext, R paramR, fe<R, T> paramfe)
  {
    super(paramContext, 0, paramString, parama, paramR, paramfe);
  }

  qg(String paramString, pl.a<T> parama, Context paramContext, R paramR, fe<R, T> paramfe, byte paramByte)
  {
    this(paramString, parama, paramContext, paramR, paramfe);
  }

  protected final ok<T> a(oh paramoh, int paramInt)
  {
    try
    {
      String str1 = new String(paramoh.b, oz.a(paramoh.c));
      str2 = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      try
      {
        while (true)
        {
          ok localok = a(a(str2), str2);
          return localok;
          localUnsupportedEncodingException = localUnsupportedEncodingException;
          str2 = new String(paramoh.b);
        }
      }
      catch (Exception localException)
      {
        String str2;
        return a(str2, localException);
      }
    }
  }

  protected ok<T> a(T paramT, String paramString)
  {
    return ok.a(paramT, null);
  }

  protected ok<T> a(String paramString, Exception paramException)
  {
    return ok.a(new pz(paramException, paramString));
  }

  protected abstract T a(String paramString)
    throws Exception;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.qg
 * JD-Core Version:    0.6.2
 */