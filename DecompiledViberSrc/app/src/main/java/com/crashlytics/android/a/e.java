package com.crashlytics.android.a;

import c.a.a.a.c;
import c.a.a.a.l;
import java.util.Locale;
import java.util.Map;

class e
{
  final int a;
  final int b;
  boolean c;

  public e(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBoolean;
  }

  private void a(RuntimeException paramRuntimeException)
  {
    if (this.c)
      throw paramRuntimeException;
    c.g().e("Answers", "Invalid user input detected", paramRuntimeException);
  }

  public String a(String paramString)
  {
    if (paramString.length() > this.b)
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.b);
      a(new IllegalArgumentException(String.format(localLocale, "String is too long, truncating to %d characters", arrayOfObject)));
      paramString = paramString.substring(0, this.b);
    }
    return paramString;
  }

  public boolean a(Object paramObject, String paramString)
  {
    if (paramObject == null)
    {
      a(new NullPointerException(paramString + " must not be null"));
      return true;
    }
    return false;
  }

  public boolean a(Map<String, Object> paramMap, String paramString)
  {
    if ((paramMap.size() >= this.a) && (!paramMap.containsKey(paramString)))
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.a);
      a(new IllegalArgumentException(String.format(localLocale, "Limit of %d attributes reached, skipping attribute", arrayOfObject)));
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.e
 * JD-Core Version:    0.6.2
 */