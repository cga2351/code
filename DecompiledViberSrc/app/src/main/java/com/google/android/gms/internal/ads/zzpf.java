package com.google.android.gms.internal.ads;

import android.media.MediaCodec.CodecException;

public final class zzpf extends Exception
{
  private final String mimeType;
  private final String zzaeo;
  private final String zzaep;
  private final boolean zzbhm;

  public zzpf(zzlh paramzzlh, Throwable paramThrowable, boolean paramBoolean, int paramInt)
  {
    super(36 + String.valueOf(str1).length() + "Decoder init failed: [" + paramInt + "], " + str1, paramThrowable);
    this.mimeType = paramzzlh.zzatq;
    this.zzbhm = false;
    this.zzaeo = null;
    if (paramInt < 0);
    for (String str2 = "neg_"; ; str2 = "")
    {
      int i = Math.abs(paramInt);
      this.zzaep = (64 + String.valueOf(str2).length() + "com.google.android.exoplayer.MediaCodecTrackRenderer_" + str2 + i);
      return;
    }
  }

  public zzpf(zzlh paramzzlh, Throwable paramThrowable, boolean paramBoolean, String paramString)
  {
    super(23 + String.valueOf(paramString).length() + String.valueOf(str1).length() + "Decoder init failed: " + paramString + ", " + str1, paramThrowable);
    this.mimeType = paramzzlh.zzatq;
    this.zzbhm = false;
    this.zzaeo = paramString;
    int i = zzsy.SDK_INT;
    String str2 = null;
    if (i >= 21)
    {
      boolean bool = paramThrowable instanceof MediaCodec.CodecException;
      str2 = null;
      if (bool)
        str2 = ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
    }
    this.zzaep = str2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzpf
 * JD-Core Version:    0.6.2
 */