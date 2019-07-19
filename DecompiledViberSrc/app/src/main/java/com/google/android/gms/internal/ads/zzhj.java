package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzhj
{
  public final int height;
  private int maxHeight;
  private int maxWidth;
  public final String mimeType;
  public final int width;
  public final long zzack;
  private final int zzafs;
  public final float zzaft;
  private final int zzafu;
  private final int zzafv;
  public final List<byte[]> zzafw;
  private int zzafx;
  private MediaFormat zzafy;

  @TargetApi(16)
  private zzhj(MediaFormat paramMediaFormat)
  {
    this.zzafy = paramMediaFormat;
    this.mimeType = paramMediaFormat.getString("mime");
    this.zzafs = zza(paramMediaFormat, "max-input-size");
    this.width = zza(paramMediaFormat, "width");
    this.height = zza(paramMediaFormat, "height");
    this.zzafu = zza(paramMediaFormat, "channel-count");
    this.zzafv = zza(paramMediaFormat, "sample-rate");
    if (paramMediaFormat.containsKey("com.google.android.videos.pixelWidthHeightRatio"));
    for (float f = paramMediaFormat.getFloat("com.google.android.videos.pixelWidthHeightRatio"); ; f = -1.0F)
    {
      this.zzaft = f;
      this.zzafw = new ArrayList();
      for (int i = 0; paramMediaFormat.containsKey(15 + "csd-" + i); i++)
      {
        ByteBuffer localByteBuffer = paramMediaFormat.getByteBuffer(15 + "csd-" + i);
        byte[] arrayOfByte = new byte[localByteBuffer.limit()];
        localByteBuffer.get(arrayOfByte);
        this.zzafw.add(arrayOfByte);
        localByteBuffer.flip();
      }
    }
    if (paramMediaFormat.containsKey("durationUs"));
    for (long l = paramMediaFormat.getLong("durationUs"); ; l = -1L)
    {
      this.zzack = l;
      this.maxWidth = -1;
      this.maxHeight = -1;
      return;
    }
  }

  private zzhj(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3, float paramFloat, int paramInt4, int paramInt5, List<byte[]> paramList)
  {
    this.mimeType = paramString;
    this.zzafs = paramInt1;
    this.zzack = paramLong;
    this.width = paramInt2;
    this.height = paramInt3;
    this.zzaft = paramFloat;
    this.zzafu = paramInt4;
    this.zzafv = paramInt5;
    if (paramList == null)
      paramList = Collections.emptyList();
    this.zzafw = paramList;
    this.maxWidth = -1;
    this.maxHeight = -1;
  }

  @TargetApi(16)
  private static final int zza(MediaFormat paramMediaFormat, String paramString)
  {
    if (paramMediaFormat.containsKey(paramString))
      return paramMediaFormat.getInteger(paramString);
    return -1;
  }

  @TargetApi(16)
  public static zzhj zza(MediaFormat paramMediaFormat)
  {
    return new zzhj(paramMediaFormat);
  }

  public static zzhj zza(String paramString, int paramInt1, int paramInt2, int paramInt3, List<byte[]> paramList)
  {
    return zzb(paramString, -1, -1L, paramInt2, paramInt3, paramList);
  }

  public static zzhj zza(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3, float paramFloat, List<byte[]> paramList)
  {
    return new zzhj(paramString, -1, paramLong, paramInt2, paramInt3, paramFloat, -1, -1, paramList);
  }

  public static zzhj zza(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3, List<byte[]> paramList)
  {
    return zza(paramString, -1, paramLong, paramInt2, paramInt3, 1.0F, paramList);
  }

  @TargetApi(16)
  private static final void zza(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    if (paramInt != -1)
      paramMediaFormat.setInteger(paramString, paramInt);
  }

  public static zzhj zzb(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3, List<byte[]> paramList)
  {
    return new zzhj(paramString, paramInt1, paramLong, -1, -1, -1.0F, paramInt2, paramInt3, paramList);
  }

  public static zzhj zzem()
  {
    return new zzhj("application/ttml+xml", -1, -1L, -1, -1, -1.0F, -1, -1, null);
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    zzhj localzzhj;
    int i10;
    int i11;
    do
    {
      boolean bool3;
      do
      {
        int i8;
        int i9;
        do
        {
          int i6;
          int i7;
          do
          {
            int i4;
            int i5;
            do
            {
              int i2;
              int i3;
              do
              {
                boolean bool2;
                do
                {
                  int n;
                  int i1;
                  do
                  {
                    int k;
                    int m;
                    do
                    {
                      int i;
                      int j;
                      do
                      {
                        Class localClass1;
                        Class localClass2;
                        do
                        {
                          do
                          {
                            return bool1;
                            bool1 = false;
                          }
                          while (paramObject == null);
                          localClass1 = getClass();
                          localClass2 = paramObject.getClass();
                          bool1 = false;
                        }
                        while (localClass1 != localClass2);
                        localzzhj = (zzhj)paramObject;
                        i = this.zzafs;
                        j = localzzhj.zzafs;
                        bool1 = false;
                      }
                      while (i != j);
                      k = this.width;
                      m = localzzhj.width;
                      bool1 = false;
                    }
                    while (k != m);
                    n = this.height;
                    i1 = localzzhj.height;
                    bool1 = false;
                  }
                  while (n != i1);
                  bool2 = this.zzaft < localzzhj.zzaft;
                  bool1 = false;
                }
                while (bool2);
                i2 = this.maxWidth;
                i3 = localzzhj.maxWidth;
                bool1 = false;
              }
              while (i2 != i3);
              i4 = this.maxHeight;
              i5 = localzzhj.maxHeight;
              bool1 = false;
            }
            while (i4 != i5);
            i6 = this.zzafu;
            i7 = localzzhj.zzafu;
            bool1 = false;
          }
          while (i6 != i7);
          i8 = this.zzafv;
          i9 = localzzhj.zzafv;
          bool1 = false;
        }
        while (i8 != i9);
        bool3 = zzkq.zza(this.mimeType, localzzhj.mimeType);
        bool1 = false;
      }
      while (!bool3);
      i10 = this.zzafw.size();
      i11 = localzzhj.zzafw.size();
      bool1 = false;
    }
    while (i10 != i11);
    for (int i12 = 0; ; i12++)
    {
      if (i12 >= this.zzafw.size())
        break label330;
      boolean bool4 = Arrays.equals((byte[])this.zzafw.get(i12), (byte[])localzzhj.zzafw.get(i12));
      bool1 = false;
      if (!bool4)
        break;
    }
    label330: return true;
  }

  public final int hashCode()
  {
    int i = 0;
    if (this.zzafx == 0)
    {
      if (this.mimeType == null);
      int k;
      for (int j = 0; ; j = this.mimeType.hashCode())
      {
        k = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (j + 527) + this.zzafs) + this.width) + this.height) + Float.floatToRawIntBits(this.zzaft)) + (int)this.zzack) + this.maxWidth) + this.maxHeight) + this.zzafu) + this.zzafv;
        while (i < this.zzafw.size())
        {
          k = k * 31 + Arrays.hashCode((byte[])this.zzafw.get(i));
          i++;
        }
      }
      this.zzafx = k;
    }
    return this.zzafx;
  }

  public final String toString()
  {
    String str = this.mimeType;
    int i = this.zzafs;
    int j = this.width;
    int k = this.height;
    float f = this.zzaft;
    int m = this.zzafu;
    int n = this.zzafv;
    long l = this.zzack;
    int i1 = this.maxWidth;
    int i2 = this.maxHeight;
    return 143 + String.valueOf(str).length() + "MediaFormat(" + str + ", " + i + ", " + j + ", " + k + ", " + f + ", " + m + ", " + n + ", " + l + ", " + i1 + ", " + i2 + ")";
  }

  @TargetApi(16)
  public final MediaFormat zzen()
  {
    if (this.zzafy == null)
    {
      MediaFormat localMediaFormat = new MediaFormat();
      localMediaFormat.setString("mime", this.mimeType);
      zza(localMediaFormat, "max-input-size", this.zzafs);
      zza(localMediaFormat, "width", this.width);
      zza(localMediaFormat, "height", this.height);
      zza(localMediaFormat, "channel-count", this.zzafu);
      zza(localMediaFormat, "sample-rate", this.zzafv);
      float f = this.zzaft;
      if (f != -1.0F)
        localMediaFormat.setFloat("com.google.android.videos.pixelWidthHeightRatio", f);
      for (int i = 0; i < this.zzafw.size(); i++)
        localMediaFormat.setByteBuffer(15 + "csd-" + i, ByteBuffer.wrap((byte[])this.zzafw.get(i)));
      if (this.zzack != -1L)
        localMediaFormat.setLong("durationUs", this.zzack);
      zza(localMediaFormat, "max-width", this.maxWidth);
      zza(localMediaFormat, "max-height", this.maxHeight);
      this.zzafy = localMediaFormat;
    }
    return this.zzafy;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzhj
 * JD-Core Version:    0.6.2
 */