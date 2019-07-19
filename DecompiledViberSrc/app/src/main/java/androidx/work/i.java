package androidx.work;

import android.util.Log;

public abstract class i
{
  private static i a;
  private static final int b = 23 - "WM-".length();

  public i(int paramInt)
  {
  }

  public static i a()
  {
    try
    {
      if (a == null)
        a = new a(3);
      i locali = a;
      return locali;
    }
    finally
    {
    }
  }

  public static String a(String paramString)
  {
    int i = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(23);
    localStringBuilder.append("WM-");
    if (i >= b)
      localStringBuilder.append(paramString.substring(0, b));
    while (true)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(paramString);
    }
  }

  public static void a(i parami)
  {
    try
    {
      a = parami;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public abstract void a(String paramString1, String paramString2, Throwable[] paramArrayOfThrowable);

  public abstract void b(String paramString1, String paramString2, Throwable[] paramArrayOfThrowable);

  public abstract void c(String paramString1, String paramString2, Throwable[] paramArrayOfThrowable);

  public abstract void d(String paramString1, String paramString2, Throwable[] paramArrayOfThrowable);

  public abstract void e(String paramString1, String paramString2, Throwable[] paramArrayOfThrowable);

  public static class a extends i
  {
    private int a;

    public a(int paramInt)
    {
      super();
      this.a = paramInt;
    }

    public void a(String paramString1, String paramString2, Throwable[] paramArrayOfThrowable)
    {
      if (this.a <= 2)
      {
        if ((paramArrayOfThrowable != null) && (paramArrayOfThrowable.length >= 1))
          Log.v(paramString1, paramString2, paramArrayOfThrowable[0]);
      }
      else
        return;
      Log.v(paramString1, paramString2);
    }

    public void b(String paramString1, String paramString2, Throwable[] paramArrayOfThrowable)
    {
      if (this.a <= 3)
      {
        if ((paramArrayOfThrowable != null) && (paramArrayOfThrowable.length >= 1))
          Log.d(paramString1, paramString2, paramArrayOfThrowable[0]);
      }
      else
        return;
      Log.d(paramString1, paramString2);
    }

    public void c(String paramString1, String paramString2, Throwable[] paramArrayOfThrowable)
    {
      if (this.a <= 4)
      {
        if ((paramArrayOfThrowable != null) && (paramArrayOfThrowable.length >= 1))
          Log.i(paramString1, paramString2, paramArrayOfThrowable[0]);
      }
      else
        return;
      Log.i(paramString1, paramString2);
    }

    public void d(String paramString1, String paramString2, Throwable[] paramArrayOfThrowable)
    {
      if (this.a <= 5)
      {
        if ((paramArrayOfThrowable != null) && (paramArrayOfThrowable.length >= 1))
          Log.w(paramString1, paramString2, paramArrayOfThrowable[0]);
      }
      else
        return;
      Log.w(paramString1, paramString2);
    }

    public void e(String paramString1, String paramString2, Throwable[] paramArrayOfThrowable)
    {
      if (this.a <= 6)
      {
        if ((paramArrayOfThrowable != null) && (paramArrayOfThrowable.length >= 1))
          Log.e(paramString1, paramString2, paramArrayOfThrowable[0]);
      }
      else
        return;
      Log.e(paramString1, paramString2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.i
 * JD-Core Version:    0.6.2
 */