package com.google.android.exoplayer2.g;

import android.text.TextUtils;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class a
{
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < paramInt2) || (paramInt1 >= paramInt3))
      throw new IndexOutOfBoundsException();
    return paramInt1;
  }

  @EnsuresNonNull({"#1"})
  public static <T> T a(T paramT)
  {
    if (paramT == null)
      throw new NullPointerException();
    return paramT;
  }

  @EnsuresNonNull({"#1"})
  public static <T> T a(T paramT, Object paramObject)
  {
    if (paramT == null)
      throw new NullPointerException(String.valueOf(paramObject));
    return paramT;
  }

  @EnsuresNonNull({"#1"})
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException();
    return paramString;
  }

  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException();
  }

  public static void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(String.valueOf(paramObject));
  }

  public static void b(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalStateException();
  }

  public static void b(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.valueOf(paramObject));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.a
 * JD-Core Version:    0.6.2
 */