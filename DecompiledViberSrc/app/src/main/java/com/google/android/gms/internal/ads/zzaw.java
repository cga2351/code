package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class zzaw extends ByteArrayOutputStream
{
  private final zzal zzbr;

  public zzaw(zzal paramzzal, int paramInt)
  {
    this.zzbr = paramzzal;
    this.buf = this.zzbr.zzc(Math.max(paramInt, 256));
  }

  private final void zzd(int paramInt)
  {
    if (paramInt + this.count <= this.buf.length)
      return;
    byte[] arrayOfByte = this.zzbr.zzc(paramInt + this.count << 1);
    System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
    this.zzbr.zza(this.buf);
    this.buf = arrayOfByte;
  }

  public final void close()
    throws IOException
  {
    this.zzbr.zza(this.buf);
    this.buf = null;
    super.close();
  }

  public final void finalize()
  {
    this.zzbr.zza(this.buf);
  }

  public final void write(int paramInt)
  {
    try
    {
      zzd(1);
      super.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      zzd(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaw
 * JD-Core Version:    0.6.2
 */