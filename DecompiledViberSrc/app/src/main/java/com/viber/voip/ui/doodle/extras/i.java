package com.viber.voip.ui.doodle.extras;

import android.text.Spanned;

public class i
{
  public static final long a = a(32);
  public static final long b = a(64);
  public static final long c = a(32);
  public static final long d = a(64);
  public static final long e = a(16);

  public static int a(int paramInt)
  {
    return paramInt / 8;
  }

  public static long a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof Spanned))
    {
      long l1 = 2L * a + a(paramCharSequence.toString());
      Object[] arrayOfObject = ((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), Object.class);
      long l2 = a;
      if (arrayOfObject == null);
      for (int i = 0; ; i = arrayOfObject.length)
        return l1 + l2 * i;
    }
    return a + a(paramCharSequence.toString());
  }

  public static long a(String paramString)
  {
    return 32L + paramString.length() * e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.extras.i
 * JD-Core Version:    0.6.2
 */