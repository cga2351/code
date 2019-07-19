package com.google.android.gms.internal.ads;

import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

final class zzog
{
  public int height = -1;
  public int number;
  public int type;
  public int width = -1;
  public int zzafu = 1;
  public int zzafv = 8000;
  public int zzamf;
  public String zzaor;
  public boolean zzaos;
  public byte[] zzaov;
  public long zzaow = 0L;
  public long zzaox = 0L;
  public zzne zzatr;
  public int zzatu = -1;
  public byte[] zzatv = null;
  private String zzauc = "eng";
  public int zzbbh;
  public byte[] zzbbi;
  public zznx zzbbj;
  public int zzbbk = -1;
  public int zzbbl = -1;
  public int zzbbm = 0;
  public boolean zzbbn = false;
  public int zzbbo = -1;
  public int zzbbp = -1;
  public int zzbbq = -1;
  public int zzbbr = 1000;
  public int zzbbs = 200;
  public float zzbbt = -1.0F;
  public float zzbbu = -1.0F;
  public float zzbbv = -1.0F;
  public float zzbbw = -1.0F;
  public float zzbbx = -1.0F;
  public float zzbby = -1.0F;
  public float zzbbz = -1.0F;
  public float zzbca = -1.0F;
  public float zzbcb = -1.0F;
  public float zzbcc = -1.0F;
  public int zzbcd = -1;
  public boolean zzbce;
  public boolean zzbcf = true;
  public zznw zzbcg;

  private static List<byte[]> zza(zzst paramzzst)
    throws zzlm
  {
    while (true)
    {
      int i;
      try
      {
        paramzzst.zzac(16);
        if (paramzzst.zzkb() != 826496599L)
          return null;
        i = 20 + paramzzst.getPosition();
        byte[] arrayOfByte = paramzzst.data;
        if (i < -4 + arrayOfByte.length)
        {
          if ((arrayOfByte[i] == 0) && (arrayOfByte[(i + 1)] == 0) && (arrayOfByte[(i + 2)] == 1) && (arrayOfByte[(i + 3)] == 15))
            return Collections.singletonList(Arrays.copyOfRange(arrayOfByte, i, arrayOfByte.length));
        }
        else
          throw new zzlm("Failed to find FourCC VC1 initialization data");
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        throw new zzlm("Error parsing FourCC VC1 codec private");
      }
      i++;
    }
  }

  private static boolean zzb(zzst paramzzst)
    throws zzlm
  {
    try
    {
      int i = paramzzst.zzka();
      if (i == 1)
        return true;
      if (i == 65534)
      {
        paramzzst.setPosition(24);
        if (paramzzst.readLong() == zzod.zzik().getMostSignificantBits())
        {
          long l1 = paramzzst.readLong();
          long l2 = zzod.zzik().getLeastSignificantBits();
          if (l1 == l2);
        }
        else
        {
          return false;
        }
      }
      else
      {
        return false;
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new zzlm("Error parsing MS/ACM codec private");
    }
    return true;
  }

  private static List<byte[]> zze(byte[] paramArrayOfByte)
    throws zzlm
  {
    int i = 0;
    try
    {
      if (paramArrayOfByte[0] != 2)
        throw new zzlm("Error parsing vorbis codec private");
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new zzlm("Error parsing vorbis codec private");
    }
    int j = 0;
    int k = 1;
    while (paramArrayOfByte[k] == -1)
    {
      int m = j + 255;
      k++;
      j = m;
    }
    int n = k + 1;
    int i1 = j + paramArrayOfByte[k];
    while (paramArrayOfByte[n] == -1)
    {
      i += 255;
      n++;
    }
    int i2 = n + 1;
    int i3 = i + paramArrayOfByte[n];
    if (paramArrayOfByte[i2] != 1)
      throw new zzlm("Error parsing vorbis codec private");
    byte[] arrayOfByte1 = new byte[i1];
    System.arraycopy(paramArrayOfByte, i2, arrayOfByte1, 0, i1);
    int i4 = i1 + i2;
    if (paramArrayOfByte[i4] != 3)
      throw new zzlm("Error parsing vorbis codec private");
    int i5 = i3 + i4;
    if (paramArrayOfByte[i5] != 5)
      throw new zzlm("Error parsing vorbis codec private");
    byte[] arrayOfByte2 = new byte[paramArrayOfByte.length - i5];
    System.arraycopy(paramArrayOfByte, i5, arrayOfByte2, 0, paramArrayOfByte.length - i5);
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(arrayOfByte1);
    localArrayList.add(arrayOfByte2);
    return localArrayList;
  }

  public final void zza(zznp paramzznp, int paramInt)
    throws zzlm
  {
    int i = -1;
    int j = -1;
    Object localObject = null;
    String str1 = this.zzaor;
    int k = -1;
    switch (str1.hashCode())
    {
    default:
    case 82338133:
    case 82338134:
    case 1809237540:
    case -2095575984:
    case -538363189:
    case -2095576542:
    case -538363109:
    case 855502857:
    case -1373388978:
    case 444813526:
    case -1730367663:
    case 1951062397:
    case 62923557:
    case -1482641358:
    case -1482641357:
    case 62923603:
    case 1950749482:
    case -1784763192:
    case 62927045:
    case 542569478:
    case -356037306:
    case 1950789798:
    case -1985379776:
    case 725957860:
    case 1422270023:
    case -425012669:
    case 99146302:
    case -933872740:
    }
    while (true)
      switch (k)
      {
      default:
        throw new zzlm("Unrecognized codec identifier.");
        if (str1.equals("V_VP8"))
        {
          k = 0;
          continue;
          if (str1.equals("V_VP9"))
          {
            k = 1;
            continue;
            if (str1.equals("V_MPEG2"))
            {
              k = 2;
              continue;
              if (str1.equals("V_MPEG4/ISO/SP"))
              {
                k = 3;
                continue;
                if (str1.equals("V_MPEG4/ISO/ASP"))
                {
                  k = 4;
                  continue;
                  if (str1.equals("V_MPEG4/ISO/AP"))
                  {
                    k = 5;
                    continue;
                    if (str1.equals("V_MPEG4/ISO/AVC"))
                    {
                      k = 6;
                      continue;
                      if (str1.equals("V_MPEGH/ISO/HEVC"))
                      {
                        k = 7;
                        continue;
                        if (str1.equals("V_MS/VFW/FOURCC"))
                        {
                          k = 8;
                          continue;
                          if (str1.equals("V_THEORA"))
                          {
                            k = 9;
                            continue;
                            if (str1.equals("A_VORBIS"))
                            {
                              k = 10;
                              continue;
                              if (str1.equals("A_OPUS"))
                              {
                                k = 11;
                                continue;
                                if (str1.equals("A_AAC"))
                                {
                                  k = 12;
                                  continue;
                                  if (str1.equals("A_MPEG/L2"))
                                  {
                                    k = 13;
                                    continue;
                                    if (str1.equals("A_MPEG/L3"))
                                    {
                                      k = 14;
                                      continue;
                                      if (str1.equals("A_AC3"))
                                      {
                                        k = 15;
                                        continue;
                                        if (str1.equals("A_EAC3"))
                                        {
                                          k = 16;
                                          continue;
                                          if (str1.equals("A_TRUEHD"))
                                          {
                                            k = 17;
                                            continue;
                                            if (str1.equals("A_DTS"))
                                            {
                                              k = 18;
                                              continue;
                                              if (str1.equals("A_DTS/EXPRESS"))
                                              {
                                                k = 19;
                                                continue;
                                                if (str1.equals("A_DTS/LOSSLESS"))
                                                {
                                                  k = 20;
                                                  continue;
                                                  if (str1.equals("A_FLAC"))
                                                  {
                                                    k = 21;
                                                    continue;
                                                    if (str1.equals("A_MS/ACM"))
                                                    {
                                                      k = 22;
                                                      continue;
                                                      if (str1.equals("A_PCM/INT/LIT"))
                                                      {
                                                        k = 23;
                                                        continue;
                                                        if (str1.equals("S_TEXT/UTF8"))
                                                        {
                                                          k = 24;
                                                          continue;
                                                          if (str1.equals("S_VOBSUB"))
                                                          {
                                                            k = 25;
                                                            continue;
                                                            if (str1.equals("S_HDMV/PGS"))
                                                            {
                                                              k = 26;
                                                              continue;
                                                              if (str1.equals("S_DVBSUB"))
                                                                k = 27;
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      }
    String str2 = "video/x-vnd.on2.vp8";
    int m;
    label895: int i1;
    label911: int i2;
    zzlh localzzlh;
    int i3;
    if (this.zzbcf)
    {
      m = 1;
      int n = m | 0x0;
      if (!this.zzbce)
        break label1785;
      i1 = 2;
      i2 = n | i1;
      if (!zzsp.zzav(str2))
        break label1791;
      localzzlh = zzlh.zza(Integer.toString(paramInt), str2, null, -1, i, this.zzafu, this.zzafv, j, (List)localObject, this.zzatr, i2, this.zzauc);
      i3 = 1;
    }
    label1820: label2087: label2096: 
    while (true)
    {
      this.zzbcg = paramzznp.zzd(this.number, i3);
      this.zzbcg.zze(localzzlh);
      return;
      str2 = "video/x-vnd.on2.vp9";
      localObject = null;
      break;
      str2 = "video/mpeg2";
      localObject = null;
      break;
      str2 = "video/mp4v-es";
      if (this.zzaov == null);
      for (List localList = null; ; localList = Collections.singletonList(this.zzaov))
      {
        localObject = localList;
        break;
      }
      str2 = "video/avc";
      zzta localzzta = zzta.zzf(new zzst(this.zzaov));
      localObject = localzzta.zzafw;
      this.zzamf = localzzta.zzamf;
      break;
      str2 = "video/hevc";
      zztg localzztg = zztg.zzh(new zzst(this.zzaov));
      localObject = localzztg.zzafw;
      this.zzamf = localzztg.zzamf;
      break;
      localObject = zza(new zzst(this.zzaov));
      if (localObject != null)
      {
        str2 = "video/wvc1";
        break;
      }
      Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
      str2 = "video/x-unknown";
      break;
      str2 = "video/x-unknown";
      localObject = null;
      break;
      str2 = "audio/vorbis";
      i = 8192;
      localObject = zze(this.zzaov);
      break;
      str2 = "audio/opus";
      i = 5760;
      localObject = new ArrayList(3);
      ((List)localObject).add(this.zzaov);
      ((List)localObject).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.zzaow).array());
      ((List)localObject).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.zzaox).array());
      break;
      str2 = "audio/mp4a-latm";
      localObject = Collections.singletonList(this.zzaov);
      break;
      str2 = "audio/mpeg-L2";
      i = 4096;
      localObject = null;
      break;
      str2 = "audio/mpeg";
      i = 4096;
      localObject = null;
      break;
      str2 = "audio/ac3";
      localObject = null;
      break;
      str2 = "audio/eac3";
      localObject = null;
      break;
      str2 = "audio/true-hd";
      localObject = null;
      break;
      str2 = "audio/vnd.dts";
      localObject = null;
      break;
      str2 = "audio/vnd.dts.hd";
      localObject = null;
      break;
      str2 = "audio/x-flac";
      localObject = Collections.singletonList(this.zzaov);
      break;
      str2 = "audio/raw";
      if (zzb(new zzst(this.zzaov)))
      {
        j = zzsy.zzbs(this.zzbcd);
        localObject = null;
        if (j != 0)
          break;
        j = -1;
        str2 = "audio/x-unknown";
        int i7 = this.zzbcd;
        Log.w("MatroskaExtractor", 60 + String.valueOf(str2).length() + "Unsupported PCM bit depth: " + i7 + ". Setting mimeType to " + str2);
        localObject = null;
        break;
      }
      str2 = "audio/x-unknown";
      String str5 = String.valueOf(str2);
      if (str5.length() != 0);
      for (String str6 = "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat(str5); ; str6 = new String("Non-PCM MS/ACM is unsupported. Setting mimeType to "))
      {
        Log.w("MatroskaExtractor", str6);
        localObject = null;
        break;
      }
      str2 = "audio/raw";
      j = zzsy.zzbs(this.zzbcd);
      localObject = null;
      if (j != 0)
        break;
      j = -1;
      str2 = "audio/x-unknown";
      int i6 = this.zzbcd;
      Log.w("MatroskaExtractor", 60 + String.valueOf(str2).length() + "Unsupported PCM bit depth: " + i6 + ". Setting mimeType to " + str2);
      localObject = null;
      break;
      str2 = "application/x-subrip";
      localObject = null;
      break;
      str2 = "application/vobsub";
      localObject = Collections.singletonList(this.zzaov);
      break;
      str2 = "application/pgs";
      localObject = null;
      break;
      str2 = "application/dvbsubs";
      byte[] arrayOfByte1 = new byte[4];
      arrayOfByte1[0] = this.zzaov[0];
      arrayOfByte1[1] = this.zzaov[1];
      arrayOfByte1[2] = this.zzaov[2];
      arrayOfByte1[3] = this.zzaov[3];
      localObject = Collections.singletonList(arrayOfByte1);
      break;
      m = 0;
      break label895;
      label1785: i1 = 0;
      break label911;
      label1791: if (zzsp.zzbf(str2))
      {
        int i4;
        int i5;
        float f;
        zztb localzztb;
        byte[] arrayOfByte2;
        if (this.zzbbm == 0)
        {
          if (this.zzbbk == -1)
          {
            i4 = this.width;
            this.zzbbk = i4;
            if (this.zzbbl != -1)
              break label2087;
            i5 = this.height;
            this.zzbbl = i5;
          }
        }
        else
        {
          f = -1.0F;
          if ((this.zzbbk != -1) && (this.zzbbl != -1))
            f = this.height * this.zzbbk / (this.width * this.zzbbl);
          boolean bool = this.zzbbn;
          localzztb = null;
          if (bool)
          {
            if ((this.zzbbt != -1.0F) && (this.zzbbu != -1.0F) && (this.zzbbv != -1.0F) && (this.zzbbw != -1.0F) && (this.zzbbx != -1.0F) && (this.zzbby != -1.0F) && (this.zzbbz != -1.0F) && (this.zzbca != -1.0F) && (this.zzbcb != -1.0F) && (this.zzbcc != -1.0F))
              break label2096;
            arrayOfByte2 = null;
          }
        }
        while (true)
        {
          localzztb = new zztb(this.zzbbo, this.zzbbq, this.zzbbp, arrayOfByte2);
          localzzlh = zzlh.zza(Integer.toString(paramInt), str2, null, -1, i, this.width, this.height, -1.0F, (List)localObject, -1, f, this.zzatv, this.zzatu, localzztb, this.zzatr);
          i3 = 2;
          break;
          i4 = this.zzbbk;
          break label1820;
          i5 = this.zzbbl;
          break label1840;
          arrayOfByte2 = new byte[25];
          ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte2);
          localByteBuffer.put((byte)0);
          localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.zzbbt));
          localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.zzbbu));
          localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.zzbbv));
          localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.zzbbw));
          localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.zzbbx));
          localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.zzbby));
          localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.zzbbz));
          localByteBuffer.putShort((short)(int)(0.5F + 50000.0F * this.zzbca));
          localByteBuffer.putShort((short)(int)(0.5F + this.zzbcb));
          localByteBuffer.putShort((short)(int)(0.5F + this.zzbcc));
          localByteBuffer.putShort((short)this.zzbbr);
          localByteBuffer.putShort((short)this.zzbbs);
        }
      }
      label1840: if ("application/x-subrip".equals(str2))
      {
        localzzlh = zzlh.zza(Integer.toString(paramInt), str2, null, -1, i2, this.zzauc, this.zzatr);
        i3 = 3;
      }
      else
      {
        if ((!"application/vobsub".equals(str2)) && (!"application/pgs".equals(str2)) && (!"application/dvbsubs".equals(str2)))
          break label2447;
        String str3 = Integer.toString(paramInt);
        String str4 = this.zzauc;
        zzne localzzne = this.zzatr;
        localzzlh = zzlh.zza(str3, str2, null, -1, (List)localObject, str4, localzzne);
        i3 = 3;
      }
    }
    label2447: throw new zzlm("Unexpected MIME type.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzog
 * JD-Core Version:    0.6.2
 */