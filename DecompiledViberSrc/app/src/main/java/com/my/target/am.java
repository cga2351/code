package com.my.target;

import android.content.Context;
import android.os.Looper;
import java.util.Map;

public final class am extends al
{
  private static final am a = new am();
  private final aj b = new aj();
  private final ak c = new ak();
  private final an d = new an();
  private final ao e = new ao();

  public static am c()
  {
    return a;
  }

  public void a(Context paramContext)
  {
    try
    {
      if (Looper.myLooper() == Looper.getMainLooper())
        dp.a("FingerprintDataProvider: You must not call collectData method from main thread");
      while (true)
      {
        return;
        b();
        this.b.a(paramContext);
        this.c.a(paramContext);
        this.d.a(paramContext);
        this.e.a(paramContext);
        Map localMap = a();
        this.b.a(localMap);
        this.c.a(localMap);
        this.d.a(localMap);
        this.e.a(localMap);
      }
    }
    finally
    {
    }
  }

  public ak d()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.am
 * JD-Core Version:    0.6.2
 */