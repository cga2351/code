package com.google.android.gms.internal.ads;

public final class zzcjh
{
  private int responseCode = 0;
  private long zzfyl = 0L;
  private long zzfym = 0L;
  private long zzfyn = 0L;
  private final Object zzfyo = new Object();
  private final Object zzfyp = new Object();
  private final Object zzfyq = new Object();
  private final Object zzfyr = new Object();

  public final int getResponseCode()
  {
    synchronized (this.zzfyo)
    {
      int i = this.responseCode;
      return i;
    }
  }

  public final long zzakl()
  {
    synchronized (this.zzfyp)
    {
      long l = this.zzfyl;
      return l;
    }
  }

  public final long zzakm()
  {
    try
    {
      synchronized (this.zzfyq)
      {
        long l = this.zzfym;
        return l;
      }
    }
    finally
    {
    }
  }

  public final long zzakn()
  {
    try
    {
      synchronized (this.zzfyr)
      {
        long l = this.zzfyn;
        return l;
      }
    }
    finally
    {
    }
  }

  public final void zzdo(int paramInt)
  {
    synchronized (this.zzfyo)
    {
      this.responseCode = paramInt;
      return;
    }
  }

  public final void zzeu(long paramLong)
  {
    synchronized (this.zzfyp)
    {
      this.zzfyl = paramLong;
      return;
    }
  }

  public final void zzev(long paramLong)
  {
    try
    {
      synchronized (this.zzfyr)
      {
        this.zzfyn = paramLong;
        return;
      }
    }
    finally
    {
    }
  }

  public final void zzfh(long paramLong)
  {
    try
    {
      synchronized (this.zzfyq)
      {
        this.zzfym = paramLong;
        return;
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcjh
 * JD-Core Version:    0.6.2
 */