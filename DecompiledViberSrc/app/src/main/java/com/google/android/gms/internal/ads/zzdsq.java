package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class zzdsq
  implements zzbd
{
  private static zzdtb zzcp = zzdtb.zzm(zzdsq.class);
  private String type;
  private long zzajx;
  private zzbe zzhth;
  boolean zzhti;
  private boolean zzhtj;
  private ByteBuffer zzhtk;
  private long zzhtl;
  private long zzhtm = -1L;
  private zzdsv zzhtn;
  private ByteBuffer zzhto = null;

  protected zzdsq(String paramString)
  {
    this.type = paramString;
    this.zzhtj = true;
    this.zzhti = true;
  }

  private final void zzbbb()
  {
    try
    {
      boolean bool = this.zzhtj;
      if (!bool);
      try
      {
        zzdtb localzzdtb = zzcp;
        String str1 = String.valueOf(this.type);
        if (str1.length() != 0);
        for (String str2 = "mem mapping ".concat(str1); ; str2 = new String("mem mapping "))
        {
          localzzdtb.zzhc(str2);
          this.zzhtk = this.zzhtn.zzi(this.zzhtl, this.zzhtm);
          this.zzhtj = true;
          return;
        }
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException(localIOException);
      }
    }
    finally
    {
    }
  }

  public final String getType()
  {
    return this.type;
  }

  public final void zza(zzbe paramzzbe)
  {
    this.zzhth = paramzzbe;
  }

  public final void zza(zzdsv paramzzdsv, ByteBuffer paramByteBuffer, long paramLong, zzba paramzzba)
    throws IOException
  {
    this.zzhtl = paramzzdsv.position();
    this.zzajx = (this.zzhtl - paramByteBuffer.remaining());
    this.zzhtm = paramLong;
    this.zzhtn = paramzzdsv;
    paramzzdsv.zzff(paramLong + paramzzdsv.position());
    this.zzhtj = false;
    this.zzhti = false;
    zzbbc();
  }

  public final void zzbbc()
  {
    try
    {
      zzbbb();
      zzdtb localzzdtb = zzcp;
      String str1 = String.valueOf(this.type);
      if (str1.length() != 0);
      for (String str2 = "parsing details of ".concat(str1); ; str2 = new String("parsing details of "))
      {
        localzzdtb.zzhc(str2);
        if (this.zzhtk != null)
        {
          ByteBuffer localByteBuffer = this.zzhtk;
          this.zzhti = true;
          localByteBuffer.rewind();
          zzg(localByteBuffer);
          if (localByteBuffer.remaining() > 0)
            this.zzhto = localByteBuffer.slice();
          this.zzhtk = null;
        }
        return;
      }
    }
    finally
    {
    }
  }

  protected abstract void zzg(ByteBuffer paramByteBuffer);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdsq
 * JD-Core Version:    0.6.2
 */