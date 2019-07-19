package com.google.android.exoplayer2;

import java.io.IOException;

public final class i extends Exception
{
  public final int a;
  public final int b;
  private final Throwable c;

  private i(int paramInt1, Throwable paramThrowable, int paramInt2)
  {
    super(paramThrowable);
    this.a = paramInt1;
    this.c = paramThrowable;
    this.b = paramInt2;
  }

  public static i a(IOException paramIOException)
  {
    return new i(0, paramIOException, -1);
  }

  public static i a(Exception paramException, int paramInt)
  {
    return new i(1, paramException, paramInt);
  }

  static i a(RuntimeException paramRuntimeException)
  {
    return new i(2, paramRuntimeException, -1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.i
 * JD-Core Version:    0.6.2
 */