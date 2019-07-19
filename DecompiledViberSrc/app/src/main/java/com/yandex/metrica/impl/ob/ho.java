package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.io.UnsupportedEncodingException;

class ho
{
  private Context a;

  public ho(Context paramContext)
  {
    this.a = paramContext;
  }

  public ic a(long paramLong, String paramString)
  {
    String str = b(paramString);
    if (str == null)
      return null;
    return ik.a(paramLong, str);
  }

  public String a(hv paramhv)
  {
    String str = ik.a(paramhv);
    if (str == null)
      return null;
    return a(str);
  }

  public String a(ic paramic)
  {
    String str1 = ik.a(paramic);
    String str2 = null;
    if (str1 != null)
      str2 = a(str1);
    return str2;
  }

  public String a(String paramString)
  {
    try
    {
      String str = oj.a(this.a, paramString);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return null;
  }

  hv b(long paramLong, String paramString)
  {
    String str = b(paramString);
    if (str == null)
      return null;
    return ik.b(paramLong, str);
  }

  public String b(String paramString)
  {
    try
    {
      String str = oj.a(this.a, paramString.getBytes("UTF-8"));
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ho
 * JD-Core Version:    0.6.2
 */