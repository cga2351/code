package com.google.android.gms.wearable;

import java.io.IOException;

public class ChannelIOException extends IOException
{
  private final int zzg;
  private final int zzh;

  public ChannelIOException(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString);
    this.zzg = paramInt1;
    this.zzh = paramInt2;
  }

  public int getAppSpecificErrorCode()
  {
    return this.zzh;
  }

  public int getCloseReason()
  {
    return this.zzg;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.ChannelIOException
 * JD-Core Version:    0.6.2
 */