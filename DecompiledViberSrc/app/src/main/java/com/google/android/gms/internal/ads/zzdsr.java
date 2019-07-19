package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

public class zzdsr extends zzdst
  implements zzbd
{
  private String type;
  private long zzajx;
  private zzbe zzhth;
  private boolean zzhtp;

  public zzdsr(String paramString)
  {
    this.type = paramString;
  }

  public final String getType()
  {
    return this.type;
  }

  public final void zza(zzbe paramzzbe)
  {
    this.zzhth = paramzzbe;
  }

  public final void zza(zzdsv paramzzdsv, long paramLong, zzba paramzzba)
    throws IOException
  {
    this.zzhtn = paramzzdsv;
    this.zzhtt = paramzzdsv.position();
    long l = this.zzhtt;
    if ((this.zzhtp) || (8L + paramLong >= 4294967296L));
    for (int i = 16; ; i = 8)
    {
      this.zzbkn = (l - i);
      paramzzdsv.zzff(paramLong + paramzzdsv.position());
      this.zzbdz = paramzzdsv.position();
      this.zzhtr = paramzzba;
      return;
    }
  }

  public final void zza(zzdsv paramzzdsv, ByteBuffer paramByteBuffer, long paramLong, zzba paramzzba)
    throws IOException
  {
    this.zzajx = (paramzzdsv.position() - paramByteBuffer.remaining());
    if (paramByteBuffer.remaining() == 16);
    for (boolean bool = true; ; bool = false)
    {
      this.zzhtp = bool;
      zza(paramzzdsv, paramLong, paramzzba);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdsr
 * JD-Core Version:    0.6.2
 */