package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

public final class zzbg extends zzdss
{
  private Date zzcq;
  private Date zzcr;
  private long zzcs;
  private long zzct;
  private double zzcu = 1.0D;
  private float zzcv = 1.0F;
  private zzdtc zzcw = zzdtc.zzhuc;
  private long zzcx;
  private int zzcy;
  private int zzcz;
  private int zzda;
  private int zzdb;
  private int zzdc;
  private int zzdd;

  public zzbg()
  {
    super("mvhd");
  }

  public final long getDuration()
  {
    return this.zzct;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MovieHeaderBox[");
    localStringBuilder.append("creationTime=").append(this.zzcq);
    localStringBuilder.append(";");
    localStringBuilder.append("modificationTime=").append(this.zzcr);
    localStringBuilder.append(";");
    localStringBuilder.append("timescale=").append(this.zzcs);
    localStringBuilder.append(";");
    localStringBuilder.append("duration=").append(this.zzct);
    localStringBuilder.append(";");
    localStringBuilder.append("rate=").append(this.zzcu);
    localStringBuilder.append(";");
    localStringBuilder.append("volume=").append(this.zzcv);
    localStringBuilder.append(";");
    localStringBuilder.append("matrix=").append(this.zzcw);
    localStringBuilder.append(";");
    localStringBuilder.append("nextTrackId=").append(this.zzcx);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }

  public final void zzg(ByteBuffer paramByteBuffer)
  {
    zzo(paramByteBuffer);
    if (getVersion() == 1)
    {
      this.zzcq = zzdsx.zzfx(zzbc.zzc(paramByteBuffer));
      this.zzcr = zzdsx.zzfx(zzbc.zzc(paramByteBuffer));
      this.zzcs = zzbc.zza(paramByteBuffer);
    }
    for (this.zzct = zzbc.zzc(paramByteBuffer); ; this.zzct = zzbc.zza(paramByteBuffer))
    {
      this.zzcu = zzbc.zzd(paramByteBuffer);
      byte[] arrayOfByte = new byte[2];
      paramByteBuffer.get(arrayOfByte);
      this.zzcv = ((short)((short)(0x0 | 0xFF00 & arrayOfByte[0] << 8) | 0xFF & arrayOfByte[1]) / 256.0F);
      zzbc.zzb(paramByteBuffer);
      zzbc.zza(paramByteBuffer);
      zzbc.zza(paramByteBuffer);
      this.zzcw = zzdtc.zzp(paramByteBuffer);
      this.zzcy = paramByteBuffer.getInt();
      this.zzcz = paramByteBuffer.getInt();
      this.zzda = paramByteBuffer.getInt();
      this.zzdb = paramByteBuffer.getInt();
      this.zzdc = paramByteBuffer.getInt();
      this.zzdd = paramByteBuffer.getInt();
      this.zzcx = zzbc.zza(paramByteBuffer);
      return;
      this.zzcq = zzdsx.zzfx(zzbc.zza(paramByteBuffer));
      this.zzcr = zzdsx.zzfx(zzbc.zza(paramByteBuffer));
      this.zzcs = zzbc.zza(paramByteBuffer);
    }
  }

  public final long zzr()
  {
    return this.zzcs;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbg
 * JD-Core Version:    0.6.2
 */