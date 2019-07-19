package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public final class zzjg
  implements zzid
{
  private long zzack = -1L;
  private int zzamq;
  private zzif zzamt;
  private final zzjf zzanh;
  private final zzjd zzano;
  private final zzkm zzanp;
  private final zzkm zzanq;
  private final zzkm zzanr;
  private long zzans = -1L;
  private long zzant = -1L;
  private long zzanu = 1000000L;
  private zzjj zzanv;
  private zzjj zzanw;
  private zzjj zzanx;
  private boolean zzany;
  private int zzanz;
  private long zzaoa;
  private boolean zzaob;
  private long zzaoc = -1L;
  private long zzaod = -1L;
  private int zzaoe = 0;
  private long zzaof = -1L;
  private zzkk zzaog;
  private zzkk zzaoh;
  private boolean zzaoi;
  private int zzaoj;
  private int zzaok;
  private int zzaol;
  private int zzaom;
  private long zzaon;
  private boolean zzaoo;
  private boolean zzaop;

  public zzjg()
  {
    this(new zzja());
  }

  private zzjg(zzjd paramzzjd)
  {
    this.zzano = paramzzjd;
    this.zzano.zza(new zzji(this, null));
    this.zzanh = new zzjf();
    this.zzanp = new zzkm(4);
    this.zzanq = new zzkm(ByteBuffer.allocate(4).putInt(-1).array());
    this.zzanr = new zzkm(4);
  }

  private final void zza(zzip paramzzip)
  {
    paramzzip.zza(this.zzaon, this.zzaom, this.zzamq, 0, null);
    this.zzaok = 0;
    this.zzaoo = true;
  }

  private static boolean zzat(String paramString)
  {
    return ("V_VP8".equals(paramString)) || ("V_VP9".equals(paramString)) || ("A_OPUS".equals(paramString)) || ("A_VORBIS".equals(paramString));
  }

  private final long zzdw(long paramLong)
  {
    return TimeUnit.NANOSECONDS.toMicros(paramLong * this.zzanu);
  }

  private final ArrayList<byte[]> zzfx()
    throws zzhl
  {
    int i = 0;
    byte[] arrayOfByte1;
    try
    {
      arrayOfByte1 = this.zzanw.zzaov;
      if (arrayOfByte1[0] != 2)
        throw new zzhl("Error parsing vorbis codec private");
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new zzhl("Error parsing vorbis codec private");
    }
    int j = 0;
    int k = 1;
    while (arrayOfByte1[k] == -1)
    {
      int m = j + 255;
      k++;
      j = m;
    }
    int n = k + 1;
    int i1 = j + arrayOfByte1[k];
    while (arrayOfByte1[n] == -1)
    {
      i += 255;
      n++;
    }
    int i2 = n + 1;
    int i3 = i + arrayOfByte1[n];
    if (arrayOfByte1[i2] != 1)
      throw new zzhl("Error parsing vorbis codec private");
    byte[] arrayOfByte2 = new byte[i1];
    System.arraycopy(arrayOfByte1, i2, arrayOfByte2, 0, i1);
    int i4 = i1 + i2;
    if (arrayOfByte1[i4] != 3)
      throw new zzhl("Error parsing vorbis codec private");
    int i5 = i3 + i4;
    if (arrayOfByte1[i5] != 5)
      throw new zzhl("Error parsing vorbis codec private");
    byte[] arrayOfByte3 = new byte[arrayOfByte1.length - i5];
    System.arraycopy(arrayOfByte1, i5, arrayOfByte3, 0, arrayOfByte1.length - i5);
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(arrayOfByte2);
    localArrayList.add(arrayOfByte3);
    return localArrayList;
  }

  public final int zza(zzie paramzzie, zzij paramzzij)
    throws IOException, InterruptedException
  {
    this.zzaoo = false;
    boolean bool;
    for (int i = 1; ; i = bool)
    {
      int j;
      if ((i != 0) && (!this.zzaoo))
      {
        bool = this.zzano.zza(paramzzie);
        if (!bool)
          continue;
        long l = paramzzie.getPosition();
        if (this.zzaob)
        {
          this.zzaod = l;
          paramzzij.zzahv = this.zzaoc;
          this.zzaoe = 1;
          this.zzaob = false;
          j = 1;
        }
      }
      while (j != 0)
      {
        return 1;
        if ((this.zzaoe == 2) && (this.zzaod != -1L))
        {
          paramzzij.zzahv = this.zzaod;
          this.zzaod = -1L;
          j = 1;
        }
        else
        {
          j = 0;
          continue;
          if (i != 0)
            return 0;
          return -1;
        }
      }
    }
  }

  final void zza(int paramInt, double paramDouble)
  {
    switch (paramInt)
    {
    default:
      return;
    case 17545:
      this.zzack = zzdw(()paramDouble);
      return;
    case 181:
    }
    this.zzanv.zzafv = ((int)paramDouble);
  }

  final void zza(int paramInt1, int paramInt2, zzie paramzzie)
    throws IOException, InterruptedException
  {
    switch (paramInt1)
    {
    default:
      throw new IllegalStateException(26 + "Unexpected id: " + paramInt1);
    case 21419:
      Arrays.fill(this.zzanr.data, (byte)0);
      paramzzie.readFully(this.zzanr.data, 4 - paramInt2, paramInt2);
      this.zzanr.setPosition(0);
      this.zzanz = ((int)this.zzanr.zzge());
      return;
    case 25506:
      this.zzanv.zzaov = new byte[paramInt2];
      paramzzie.readFully(this.zzanv.zzaov, 0, paramInt2);
      return;
    case 18402:
      this.zzanv.zzajy = new byte[paramInt2];
      paramzzie.readFully(this.zzanv.zzajy, 0, paramInt2);
      return;
    case 161:
    case 163:
    }
    if (this.zzaok == 0)
    {
      this.zzaol = ((int)this.zzanh.zza(paramzzie, false, true));
      this.zzaoj = this.zzanh.zzfw();
      this.zzaok = 1;
    }
    if (((this.zzanw != null) && (this.zzanx != null) && (this.zzanw.number != this.zzaol) && (this.zzanx.number != this.zzaol)) || ((this.zzanw != null) && (this.zzanx == null) && (this.zzanw.number != this.zzaol)) || ((this.zzanw == null) && (this.zzanx != null) && (this.zzanx.number != this.zzaol)))
    {
      paramzzie.zzr(paramInt2 - this.zzaoj);
      this.zzaok = 0;
      return;
    }
    zzjj localzzjj;
    zzip localzzip;
    byte[] arrayOfByte;
    if ((this.zzanw != null) && (this.zzaol == this.zzanw.number))
    {
      localzzjj = this.zzanw;
      localzzip = localzzjj.zzamx;
      if (this.zzaok != 1)
        break label720;
      arrayOfByte = this.zzanp.data;
      if (!localzzjj.zzaos)
        break label510;
    }
    label510: for (int i = 4; ; i = 3)
    {
      paramzzie.readFully(arrayOfByte, 0, i);
      this.zzaoj = (i + this.zzaoj);
      int j = arrayOfByte[0] << 8 | 0xFF & arrayOfByte[1];
      this.zzaon = (this.zzaof + zzdw(j));
      int k = (0x6 & arrayOfByte[2]) >> 1;
      if (k == 0)
        break label516;
      throw new zzhl(38 + "Lacing mode not supported: " + k);
      localzzjj = this.zzanx;
      break;
    }
    label516: int m;
    int n;
    if ((0x8 & arrayOfByte[2]) == 8)
    {
      m = 1;
      if ((paramInt1 != 163) || ((0x80 & arrayOfByte[2]) != 128))
        break label594;
      n = 1;
    }
    label594: int i6;
    while (true)
      if (localzzjj.zzaos)
      {
        if ((0x80 & arrayOfByte[3]) == 128)
        {
          throw new zzhl("Extension bit is set in signal byte");
          m = 0;
          break;
          n = 0;
          continue;
        }
        if ((0x1 & arrayOfByte[3]) == 1)
          i6 = 1;
      }
    for (int i1 = i6; ; i1 = 0)
    {
      int i2;
      label625: int i3;
      label635: int i4;
      if (n != 0)
      {
        i2 = 1;
        if (m == 0)
          break label766;
        i3 = 134217728;
        i4 = i2 | i3;
        if (i1 == 0)
          break label772;
      }
      label772: for (int i5 = 2; ; i5 = 0)
      {
        this.zzaom = (i5 | i4);
        this.zzamq = (paramInt2 - this.zzaoj);
        if (i1 != 0)
        {
          this.zzanp.data[0] = 8;
          this.zzanp.setPosition(0);
          localzzip.zza(this.zzanp, 1);
          this.zzamq = (1 + this.zzamq);
        }
        this.zzaok = 2;
        label720: 
        while (this.zzaoj < paramInt2)
          this.zzaoj += localzzip.zza(paramzzie, paramInt2 - this.zzaoj);
        i6 = 0;
        break;
        i2 = 0;
        break label625;
        label766: i3 = 0;
        break label635;
      }
      if ("A_VORBIS".equals(localzzjj.zzaor))
      {
        this.zzanq.setPosition(0);
        localzzip.zza(this.zzanq, 4);
        this.zzamq = (4 + this.zzamq);
      }
      if (paramInt1 != 163)
        break;
      zza(localzzip);
      return;
    }
  }

  final void zza(int paramInt, String paramString)
    throws zzhl
  {
    switch (paramInt)
    {
    default:
    case 17026:
      do
        return;
      while ("webm".equals(paramString));
      throw new zzhl(22 + String.valueOf(paramString).length() + "DocType " + paramString + " not supported");
    case 134:
    }
    this.zzanv.zzaor = paramString;
  }

  public final void zza(zzif paramzzif)
  {
    this.zzamt = paramzzif;
  }

  final void zzb(int paramInt, long paramLong1, long paramLong2)
    throws zzhl
  {
    switch (paramInt)
    {
    case 25152:
    default:
    case 408125543:
    case 19899:
    case 475249515:
    case 187:
    case 524531317:
      do
      {
        return;
        if (this.zzans != -1L)
          throw new zzhl("Multiple Segment elements not supported");
        this.zzans = paramLong1;
        this.zzant = paramLong2;
        return;
        this.zzanz = -1;
        this.zzaoa = -1L;
        return;
        this.zzaog = new zzkk();
        this.zzaoh = new zzkk();
        return;
        this.zzaoi = false;
        return;
      }
      while ((this.zzaoe != 0) || (this.zzaoc == -1L));
      this.zzaob = true;
      return;
    case 160:
      this.zzaop = false;
      return;
    case 20533:
      this.zzanv.zzaos = true;
      return;
    case 174:
    }
    this.zzanv = new zzjj(null);
  }

  final void zzc(int paramInt, long paramLong)
    throws zzhl
  {
    switch (paramInt)
    {
    default:
    case 17143:
    case 17029:
    case 21420:
    case 2807729:
    case 176:
    case 186:
    case 215:
    case 131:
    case 22186:
    case 22203:
    case 159:
    case 251:
    case 20529:
    case 20530:
    case 20531:
    case 18401:
    case 18408:
    case 179:
    case 241:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                      return;
                    while (paramLong == 1L);
                    throw new zzhl(50 + "EBMLReadVersion " + paramLong + " not supported");
                  }
                  while ((paramLong >= 1L) && (paramLong <= 2L));
                  throw new zzhl(53 + "DocTypeReadVersion " + paramLong + " not supported");
                  this.zzaoa = (paramLong + this.zzans);
                  return;
                  this.zzanu = paramLong;
                  return;
                  this.zzanv.zzaot = ((int)paramLong);
                  return;
                  this.zzanv.zzaou = ((int)paramLong);
                  return;
                  this.zzanv.number = ((int)paramLong);
                  return;
                  this.zzanv.type = ((int)paramLong);
                  return;
                  this.zzanv.zzaow = paramLong;
                  return;
                  this.zzanv.zzaox = paramLong;
                  return;
                  this.zzanv.zzafu = ((int)paramLong);
                  return;
                  this.zzaop = true;
                  return;
                }
                while (paramLong == 0L);
                throw new zzhl(55 + "ContentEncodingOrder " + paramLong + " not supported");
              }
              while (paramLong == 1L);
              throw new zzhl(55 + "ContentEncodingScope " + paramLong + " not supported");
            }
            while (paramLong == 1L);
            throw new zzhl(54 + "ContentEncodingType " + paramLong + " not supported");
          }
          while (paramLong == 5L);
          throw new zzhl(49 + "ContentEncAlgo " + paramLong + " not supported");
        }
        while (paramLong == 1L);
        throw new zzhl(56 + "AESSettingsCipherMode " + paramLong + " not supported");
        this.zzaog.add(zzdw(paramLong));
        return;
      }
      while (this.zzaoi);
      this.zzaoh.add(paramLong);
      this.zzaoi = true;
      return;
    case 231:
    }
    this.zzaof = zzdw(paramLong);
  }

  public final void zzfh()
  {
    this.zzaof = -1L;
    this.zzaok = 0;
    this.zzano.reset();
    this.zzanh.reset();
  }

  final void zzy(int paramInt)
    throws zzhl
  {
    switch (paramInt)
    {
    default:
    case 19899:
    case 475249515:
    case 160:
    case 25152:
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if ((this.zzanz == -1) || (this.zzaoa == -1L))
                throw new zzhl("Mandatory element SeekID or SeekPosition not found");
            }
            while (this.zzanz != 475249515);
            this.zzaoc = this.zzaoa;
            return;
          }
          while (this.zzaoe == 2);
          zzif localzzif = this.zzamt;
          if (this.zzans == -1L)
            throw new zzhl("Segment start/end offsets unknown");
          if (this.zzack == -1L)
            throw new zzhl("Duration unknown");
          if ((this.zzaog == null) || (this.zzaoh == null) || (this.zzaog.size() == 0) || (this.zzaog.size() != this.zzaoh.size()))
            throw new zzhl("Invalid/missing cue points");
          int i = this.zzaog.size();
          int[] arrayOfInt = new int[i];
          long[] arrayOfLong1 = new long[i];
          long[] arrayOfLong2 = new long[i];
          long[] arrayOfLong3 = new long[i];
          for (int j = 0; j < i; j++)
          {
            arrayOfLong3[j] = this.zzaog.get(j);
            arrayOfLong1[j] = (this.zzans + this.zzaoh.get(j));
          }
          for (int k = 0; k < i - 1; k++)
          {
            arrayOfInt[k] = ((int)(arrayOfLong1[(k + 1)] - arrayOfLong1[k]));
            arrayOfLong2[k] = (arrayOfLong3[(k + 1)] - arrayOfLong3[k]);
          }
          arrayOfInt[(i - 1)] = ((int)(this.zzans + this.zzant - arrayOfLong1[(i - 1)]));
          arrayOfLong2[(i - 1)] = (this.zzack - arrayOfLong3[(i - 1)]);
          this.zzaog = null;
          this.zzaoh = null;
          localzzif.zza(new zzia(arrayOfInt, arrayOfLong1, arrayOfLong2, arrayOfLong3));
          this.zzaoe = 2;
          return;
        }
        while (this.zzaok != 2);
        if (!this.zzaop)
          this.zzaom = (0x1 | this.zzaom);
        if ((this.zzanw != null) && (this.zzaol == this.zzanw.number));
        for (zzip localzzip3 = this.zzanw.zzamx; ; localzzip3 = this.zzanx.zzamx)
        {
          zza(localzzip3);
          return;
        }
        if (!this.zzanv.zzaos)
          throw new zzhl("Found an unsupported ContentEncoding");
        if (this.zzanv.zzajy == null)
          throw new zzhl("Encrypted Track found but ContentEncKeyID was not found");
      }
      while (this.zzany);
      this.zzamt.zzb(new zzhy("video/webm", this.zzanv.zzajy));
      this.zzany = true;
      return;
    case 174:
      if ((this.zzanv.number == -1) || (this.zzanv.type == -1))
        throw new zzhl("Mandatory element TrackNumber or TrackType not found");
      if (((this.zzanv.type == 2) && (this.zzanw != null)) || ((this.zzanv.type == 1) && (this.zzanx != null)))
      {
        this.zzanv = null;
        return;
      }
      if ((this.zzanv.type == 2) && (zzat(this.zzanv.zzaor)))
      {
        this.zzanw = this.zzanv;
        this.zzanw.zzamx = this.zzamt.zzs(this.zzanw.number);
        localzzip2 = this.zzanw.zzamx;
        if ((this.zzanw != null) && ("A_VORBIS".equals(this.zzanw.zzaor)))
        {
          localzzhj2 = zzhj.zzb("audio/vorbis", 8192, this.zzack, this.zzanw.zzafu, this.zzanw.zzafv, zzfx());
          localzzip2.zza(localzzhj2);
        }
      }
      while ((this.zzanv.type != 1) || (!zzat(this.zzanv.zzaor)))
      {
        while (true)
        {
          zzip localzzip2;
          this.zzanv = null;
          return;
          if ((this.zzanw == null) || (!"A_OPUS".equals(this.zzanw.zzaor)))
            break;
          ArrayList localArrayList = new ArrayList(3);
          localArrayList.add(this.zzanw.zzaov);
          localArrayList.add(ByteBuffer.allocate(64).putLong(this.zzanw.zzaow).array());
          localArrayList.add(ByteBuffer.allocate(64).putLong(this.zzanw.zzaox).array());
          zzhj localzzhj2 = zzhj.zzb("audio/opus", 5760, this.zzack, this.zzanw.zzafu, this.zzanw.zzafv, localArrayList);
        }
        throw new zzhl("Unable to build format");
      }
      this.zzanx = this.zzanv;
      this.zzanx.zzamx = this.zzamt.zzs(this.zzanx.number);
      zzip localzzip1 = this.zzanx.zzamx;
      if ((this.zzanx != null) && ("V_VP8".equals(this.zzanx.zzaor)));
      for (zzhj localzzhj1 = zzhj.zza("video/x-vnd.on2.vp8", -1, this.zzack, this.zzanx.zzaot, this.zzanx.zzaou, null); ; localzzhj1 = zzhj.zza("video/x-vnd.on2.vp9", -1, this.zzack, this.zzanx.zzaot, this.zzanx.zzaou, null))
      {
        localzzip1.zza(localzzhj1);
        break;
        if ((this.zzanx == null) || (!"V_VP9".equals(this.zzanx.zzaor)))
          break label1115;
      }
      label1115: throw new zzhl("Unable to build format");
    case 374648427:
    }
    if ((this.zzanx == null) && (this.zzanw == null))
      throw new zzhl("No valid tracks were found");
    this.zzamt.zzfi();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzjg
 * JD-Core Version:    0.6.2
 */