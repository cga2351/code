package com.google.android.exoplayer2.extractor.c;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.w;
import java.io.IOException;

abstract interface c
{
  public abstract int a(int paramInt);

  public abstract void a(int paramInt, double paramDouble)
    throws w;

  public abstract void a(int paramInt1, int paramInt2, h paramh)
    throws IOException, InterruptedException;

  public abstract void a(int paramInt, long paramLong)
    throws w;

  public abstract void a(int paramInt, long paramLong1, long paramLong2)
    throws w;

  public abstract void a(int paramInt, String paramString)
    throws w;

  public abstract boolean b(int paramInt);

  public abstract void c(int paramInt)
    throws w;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.c.c
 * JD-Core Version:    0.6.2
 */