package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import java.net.URLDecoder;

public class bk
{
  private static final String[] a = { "http://play.google.com", "https://play.google.com", "http://market.android.com", "https://market.android.com", "market://", "samsungapps://" };
  private final String b;
  private a c;

  private bk(String paramString)
  {
    this.b = paramString;
  }

  public static String a(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString, "UTF-8");
      return str;
    }
    catch (Throwable localThrowable)
    {
      dp.a("Unable to decode url " + localThrowable.getMessage());
    }
    return paramString;
  }

  public static boolean b(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    String[] arrayOfString;
    int i;
    if (!bool1)
    {
      arrayOfString = a;
      i = arrayOfString.length;
    }
    for (int j = 0; ; j++)
    {
      bool2 = false;
      if (j < i)
      {
        if (paramString.startsWith(arrayOfString[j]))
          bool2 = true;
      }
      else
        return bool2;
    }
  }

  public static boolean c(String paramString)
  {
    return paramString.startsWith("samsungapps://");
  }

  public static boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https"));
  }

  public static bk e(String paramString)
  {
    return new bk(paramString);
  }

  public bk a(a parama)
  {
    this.c = parama;
    return this;
  }

  public void a(Context paramContext)
  {
    dq.b(new Runnable()
    {
      public void run()
      {
        final String str = (String)w.a().c(bk.a(bk.this), this.a);
        if (bk.b(bk.this) == null)
          return;
        dq.c(new Runnable()
        {
          public void run()
          {
            if (bk.b(bk.this) != null)
            {
              bk.b(bk.this).a(str);
              bk.a(bk.this, null);
            }
          }
        });
      }
    });
  }

  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bk
 * JD-Core Version:    0.6.2
 */