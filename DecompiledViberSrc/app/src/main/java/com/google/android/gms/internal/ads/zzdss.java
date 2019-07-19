package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public abstract class zzdss extends zzdsq
  implements zzbd
{
  private int flags;
  private int version;

  protected zzdss(String paramString)
  {
    super(paramString);
  }

  public final int getVersion()
  {
    if (!this.zzhti)
      zzbbc();
    return this.version;
  }

  protected final long zzo(ByteBuffer paramByteBuffer)
  {
    this.version = zzbc.zza(paramByteBuffer.get());
    this.flags = (0 + (zzbc.zzb(paramByteBuffer) << 8) + zzbc.zza(paramByteBuffer.get()));
    return 4L;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdss
 * JD-Core Version:    0.6.2
 */