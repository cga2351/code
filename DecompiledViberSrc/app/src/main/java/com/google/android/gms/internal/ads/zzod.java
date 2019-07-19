package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

public final class zzod
  implements zznn
{
  private static final zznq zzazt = new zzoe();
  private static final byte[] zzazu = { 49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10 };
  private static final byte[] zzazv = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
  private static final UUID zzazw = new UUID(72057594037932032L, -9223371306706625679L);
  private long zzack = -9223372036854775807L;
  private int zzamr;
  private int zzams;
  private long zzans = -1L;
  private long zzant;
  private long zzanu = -9223372036854775807L;
  private int zzanz;
  private long zzaoa;
  private boolean zzaob;
  private long zzaoc = -1L;
  private long zzaod = -1L;
  private long zzaof = -9223372036854775807L;
  private boolean zzaoi;
  private boolean zzaoo;
  private boolean zzaop;
  private final zzoi zzazr;
  private final zzob zzazx;
  private final SparseArray<zzog> zzazy;
  private final boolean zzazz;
  private final zzst zzbaa;
  private final zzst zzbab;
  private final zzst zzbac;
  private final zzst zzbad;
  private final zzst zzbae;
  private final zzst zzbaf;
  private final zzst zzbag;
  private final zzst zzbah;
  private final zzst zzbai;
  private ByteBuffer zzbaj;
  private long zzbak = -9223372036854775807L;
  private zzog zzbal;
  private boolean zzbam;
  private zzsn zzban;
  private zzsn zzbao;
  private int zzbap;
  private long zzbaq;
  private long zzbar;
  private int zzbas;
  private int zzbat;
  private int[] zzbau;
  private int zzbav;
  private int zzbaw;
  private int zzbax;
  private int zzbay;
  private boolean zzbaz;
  private boolean zzbba;
  private boolean zzbbb;
  private boolean zzbbc;
  private byte zzbbd;
  private int zzbbe;
  private zznp zzbbf;

  public zzod()
  {
    this(0);
  }

  private zzod(int paramInt)
  {
    this(new zzny(), 0);
  }

  private zzod(zzob paramzzob, int paramInt)
  {
    this.zzazx = paramzzob;
    this.zzazx.zza(new zzof(this, null));
    this.zzazz = true;
    this.zzazr = new zzoi();
    this.zzazy = new SparseArray();
    this.zzbac = new zzst(4);
    this.zzbad = new zzst(ByteBuffer.allocate(4).putInt(-1).array());
    this.zzbae = new zzst(4);
    this.zzbaa = new zzst(zzsq.zzaqt);
    this.zzbab = new zzst(4);
    this.zzbaf = new zzst();
    this.zzbag = new zzst();
    this.zzbah = new zzst(8);
    this.zzbai = new zzst();
  }

  private final int zza(zzno paramzzno, zznw paramzznw, int paramInt)
    throws IOException, InterruptedException
  {
    int i = this.zzbaf.zzjz();
    int j;
    if (i > 0)
    {
      j = Math.min(paramInt, i);
      paramzznw.zza(this.zzbaf, j);
    }
    while (true)
    {
      this.zzbay = (j + this.zzbay);
      this.zzamr = (j + this.zzamr);
      return j;
      j = paramzznw.zza(paramzzno, paramInt, false);
    }
  }

  private final void zza(zzno paramzzno, zzog paramzzog, int paramInt)
    throws IOException, InterruptedException
  {
    if ("S_TEXT/UTF8".equals(paramzzog.zzaor))
    {
      int i8 = paramInt + zzazu.length;
      if (this.zzbag.capacity() < i8)
        this.zzbag.data = Arrays.copyOf(zzazu, i8 + paramInt);
      paramzzno.readFully(this.zzbag.data, zzazu.length, paramInt);
      this.zzbag.setPosition(0);
      this.zzbag.zzbo(i8);
    }
    zznw localzznw;
    label290: label595: label601: label617: 
    do
    {
      return;
      localzznw = paramzzog.zzbcg;
      int i5;
      int i;
      byte[] arrayOfByte1;
      int j;
      int k;
      if (!this.zzbaz)
      {
        if (!paramzzog.zzaos)
          break label920;
        this.zzbax = (0xBFFFFFFF & this.zzbax);
        if (!this.zzbba)
        {
          paramzzno.readFully(this.zzbac.data, 0, 1);
          this.zzbay = (1 + this.zzbay);
          if ((0x80 & this.zzbac.data[0]) == 128)
            throw new zzlm("Extension bit is set in signal byte");
          this.zzbbd = this.zzbac.data[0];
          this.zzbba = true;
        }
        if ((0x1 & this.zzbbd) == 1)
        {
          int n;
          int i7;
          int i2;
          int i3;
          int i4;
          int i6;
          if ((0x2 & this.zzbbd) == 2)
          {
            n = 1;
            this.zzbax = (0x40000000 | this.zzbax);
            if (!this.zzbbb)
            {
              paramzzno.readFully(this.zzbah.data, 0, 8);
              this.zzbay = (8 + this.zzbay);
              this.zzbbb = true;
              byte[] arrayOfByte2 = this.zzbac.data;
              if (n == 0)
                break label595;
              i7 = 128;
              arrayOfByte2[0] = ((byte)(i7 | 0x8));
              this.zzbac.setPosition(0);
              localzznw.zza(this.zzbac, 1);
              this.zzamr = (1 + this.zzamr);
              this.zzbah.setPosition(0);
              localzznw.zza(this.zzbah, 8);
              this.zzamr = (8 + this.zzamr);
            }
            if (n == 0)
              break label688;
            if (!this.zzbbc)
            {
              paramzzno.readFully(this.zzbac.data, 0, 1);
              this.zzbay = (1 + this.zzbay);
              this.zzbac.setPosition(0);
              this.zzbbe = this.zzbac.readUnsignedByte();
              this.zzbbc = true;
            }
            int i1 = this.zzbbe << 2;
            this.zzbac.reset(i1);
            paramzzno.readFully(this.zzbac.data, 0, i1);
            this.zzbay = (i1 + this.zzbay);
            short s = (short)(1 + this.zzbbe / 2);
            i2 = 2 + s * 6;
            if ((this.zzbaj == null) || (this.zzbaj.capacity() < i2))
              this.zzbaj = ByteBuffer.allocate(i2);
            this.zzbaj.position(0);
            this.zzbaj.putShort(s);
            i3 = 0;
            i4 = 0;
            if (i3 >= this.zzbbe)
              break label617;
            i6 = this.zzbac.zzgg();
            if (i3 % 2 != 0)
              break label601;
            this.zzbaj.putShort((short)(i6 - i4));
          }
          while (true)
          {
            i3++;
            i4 = i6;
            break label540;
            n = 0;
            break;
            i7 = 0;
            break label290;
            this.zzbaj.putInt(i6 - i4);
          }
          i5 = paramInt - this.zzbay - i4;
          if (this.zzbbe % 2 != 1)
            break label897;
          this.zzbaj.putInt(i5);
          this.zzbai.zzb(this.zzbaj.array(), i2);
          localzznw.zza(this.zzbai, i2);
          this.zzamr = (i2 + this.zzamr);
        }
        this.zzbaz = true;
      }
      else
      {
        i = paramInt + this.zzbaf.limit();
        if ((!"V_MPEG4/ISO/AVC".equals(paramzzog.zzaor)) && (!"V_MPEGH/ISO/HEVC".equals(paramzzog.zzaor)))
          break label969;
        arrayOfByte1 = this.zzbab.data;
        arrayOfByte1[0] = 0;
        arrayOfByte1[1] = 0;
        arrayOfByte1[2] = 0;
        j = paramzzog.zzamf;
        k = 4 - paramzzog.zzamf;
      }
      while (true)
        if (this.zzbay < i)
        {
          if (this.zzams == 0)
          {
            int m = Math.min(j, this.zzbaf.zzjz());
            paramzzno.readFully(arrayOfByte1, k + m, j - m);
            if (m > 0)
              this.zzbaf.zzb(arrayOfByte1, k, m);
            this.zzbay = (j + this.zzbay);
            this.zzbab.setPosition(0);
            this.zzams = this.zzbab.zzgg();
            this.zzbaa.setPosition(0);
            localzznw.zza(this.zzbaa, 4);
            this.zzamr = (4 + this.zzamr);
            continue;
            this.zzbaj.putShort((short)i5);
            this.zzbaj.putInt(0);
            break;
            if (paramzzog.zzbbi == null)
              break label688;
            this.zzbaf.zzb(paramzzog.zzbbi, paramzzog.zzbbi.length);
            break label688;
          }
          this.zzams -= zza(paramzzno, localzznw, this.zzams);
          continue;
          while (this.zzbay < i)
            zza(paramzzno, localzznw, i - this.zzbay);
        }
    }
    while (!"A_VORBIS".equals(paramzzog.zzaor));
    label540: label688: label969: this.zzbad.setPosition(0);
    label897: label920: localzznw.zza(this.zzbad, 4);
    this.zzamr = (4 + this.zzamr);
  }

  private final void zza(zzog paramzzog, long paramLong)
  {
    byte[] arrayOfByte1;
    long l1;
    if ("S_TEXT/UTF8".equals(paramzzog.zzaor))
    {
      arrayOfByte1 = this.zzbag.data;
      l1 = this.zzbar;
      if (l1 != -9223372036854775807L)
        break label122;
    }
    label122: Locale localLocale;
    Object[] arrayOfObject;
    for (byte[] arrayOfByte2 = zzazv; ; arrayOfByte2 = zzsy.zzbh(String.format(localLocale, "%02d:%02d:%02d,%03d", arrayOfObject)))
    {
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 19, 12);
      paramzzog.zzbcg.zza(this.zzbag, this.zzbag.limit());
      this.zzamr += this.zzbag.limit();
      paramzzog.zzbcg.zza(paramLong, this.zzbax, this.zzamr, 0, paramzzog.zzbbj);
      this.zzaoo = true;
      zzij();
      return;
      int i = (int)(l1 / 3600000000L);
      long l2 = l1 - 3600000000L * i;
      int j = (int)(l2 / 60000000L);
      long l3 = l2 - 60000000 * j;
      int k = (int)(l3 / 1000000L);
      int m = (int)((l3 - 1000000 * k) / 1000L);
      localLocale = Locale.US;
      arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(i);
      arrayOfObject[1] = Integer.valueOf(j);
      arrayOfObject[2] = Integer.valueOf(k);
      arrayOfObject[3] = Integer.valueOf(m);
    }
  }

  private static int[] zza(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null)
      paramArrayOfInt = new int[paramInt];
    while (paramArrayOfInt.length >= paramInt)
      return paramArrayOfInt;
    return new int[Math.max(paramArrayOfInt.length << 1, paramInt)];
  }

  static boolean zzav(int paramInt)
  {
    return (paramInt == 357149030) || (paramInt == 524531317) || (paramInt == 475249515) || (paramInt == 374648427);
  }

  private final void zzb(zzno paramzzno, int paramInt)
    throws IOException, InterruptedException
  {
    if (this.zzbac.limit() >= paramInt)
      return;
    if (this.zzbac.capacity() < paramInt)
      this.zzbac.zzb(Arrays.copyOf(this.zzbac.data, Math.max(this.zzbac.data.length << 1, paramInt)), this.zzbac.limit());
    paramzzno.readFully(this.zzbac.data, this.zzbac.limit(), paramInt - this.zzbac.limit());
    this.zzbac.zzbo(paramInt);
  }

  private final long zzdw(long paramLong)
    throws zzlm
  {
    if (this.zzanu == -9223372036854775807L)
      throw new zzlm("Can't scale timecode prior to timecodeScale being set.");
    return zzsy.zza(paramLong, this.zzanu, 1000L);
  }

  private final void zzij()
  {
    this.zzbay = 0;
    this.zzamr = 0;
    this.zzams = 0;
    this.zzbaz = false;
    this.zzbba = false;
    this.zzbbc = false;
    this.zzbbe = 0;
    this.zzbbd = 0;
    this.zzbbb = false;
    this.zzbaf.reset();
  }

  static int zzx(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 0;
    case 160:
    case 174:
    case 183:
    case 187:
    case 224:
    case 225:
    case 18407:
    case 19899:
    case 20532:
    case 20533:
    case 21936:
    case 21968:
    case 25152:
    case 28032:
    case 30320:
    case 290298740:
    case 357149030:
    case 374648427:
    case 408125543:
    case 440786851:
    case 475249515:
    case 524531317:
      return 1;
    case 131:
    case 136:
    case 155:
    case 159:
    case 176:
    case 179:
    case 186:
    case 215:
    case 231:
    case 241:
    case 251:
    case 16980:
    case 17029:
    case 17143:
    case 18401:
    case 18408:
    case 20529:
    case 20530:
    case 21420:
    case 21432:
    case 21680:
    case 21682:
    case 21690:
    case 21930:
    case 21945:
    case 21946:
    case 21947:
    case 21948:
    case 21949:
    case 22186:
    case 22203:
    case 25188:
    case 2352003:
    case 2807729:
      return 2;
    case 134:
    case 17026:
    case 2274716:
      return 3;
    case 161:
    case 163:
    case 16981:
    case 18402:
    case 21419:
    case 25506:
    case 30322:
      return 4;
    case 181:
    case 17545:
    case 21969:
    case 21970:
    case 21971:
    case 21972:
    case 21973:
    case 21974:
    case 21975:
    case 21976:
    case 21977:
    case 21978:
    }
    return 5;
  }

  public final void release()
  {
  }

  public final int zza(zzno paramzzno, zznt paramzznt)
    throws IOException, InterruptedException
  {
    this.zzaoo = false;
    boolean bool;
    for (int i = 1; ; i = bool)
    {
      int j;
      if ((i != 0) && (!this.zzaoo))
      {
        bool = this.zzazx.zzb(paramzzno);
        if (!bool)
          continue;
        long l = paramzzno.getPosition();
        if (this.zzaob)
        {
          this.zzaod = l;
          paramzznt.zzahv = this.zzaoc;
          this.zzaob = false;
          j = 1;
        }
      }
      while (j != 0)
      {
        return 1;
        if ((this.zzbam) && (this.zzaod != -1L))
        {
          paramzznt.zzahv = this.zzaod;
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
      this.zzbak = (()paramDouble);
      return;
    case 181:
      this.zzbal.zzafv = ((int)paramDouble);
      return;
    case 21969:
      this.zzbal.zzbbt = ((float)paramDouble);
      return;
    case 21970:
      this.zzbal.zzbbu = ((float)paramDouble);
      return;
    case 21971:
      this.zzbal.zzbbv = ((float)paramDouble);
      return;
    case 21972:
      this.zzbal.zzbbw = ((float)paramDouble);
      return;
    case 21973:
      this.zzbal.zzbbx = ((float)paramDouble);
      return;
    case 21974:
      this.zzbal.zzbby = ((float)paramDouble);
      return;
    case 21975:
      this.zzbal.zzbbz = ((float)paramDouble);
      return;
    case 21976:
      this.zzbal.zzbca = ((float)paramDouble);
      return;
    case 21977:
      this.zzbal.zzbcb = ((float)paramDouble);
      return;
    case 21978:
    }
    this.zzbal.zzbcc = ((float)paramDouble);
  }

  final void zza(int paramInt1, int paramInt2, zzno paramzzno)
    throws IOException, InterruptedException
  {
    switch (paramInt1)
    {
    default:
      throw new zzlm(26 + "Unexpected id: " + paramInt1);
    case 21419:
      Arrays.fill(this.zzbae.data, (byte)0);
      paramzzno.readFully(this.zzbae.data, 4 - paramInt2, paramInt2);
      this.zzbae.setPosition(0);
      this.zzanz = ((int)this.zzbae.zzge());
      return;
    case 25506:
      this.zzbal.zzaov = new byte[paramInt2];
      paramzzno.readFully(this.zzbal.zzaov, 0, paramInt2);
      return;
    case 30322:
      this.zzbal.zzatv = new byte[paramInt2];
      paramzzno.readFully(this.zzbal.zzatv, 0, paramInt2);
      return;
    case 16981:
      this.zzbal.zzbbi = new byte[paramInt2];
      paramzzno.readFully(this.zzbal.zzbbi, 0, paramInt2);
      return;
    case 18402:
      byte[] arrayOfByte3 = new byte[paramInt2];
      paramzzno.readFully(arrayOfByte3, 0, paramInt2);
      this.zzbal.zzbbj = new zznx(1, arrayOfByte3);
      return;
    case 161:
    case 163:
    }
    if (this.zzbap == 0)
    {
      this.zzbav = ((int)this.zzazr.zza(paramzzno, false, true, 8));
      this.zzbaw = this.zzazr.zzfw();
      this.zzbar = -9223372036854775807L;
      this.zzbap = 1;
      this.zzbac.reset();
    }
    zzog localzzog = (zzog)this.zzazy.get(this.zzbav);
    if (localzzog == null)
    {
      paramzzno.zzr(paramInt2 - this.zzbaw);
      this.zzbap = 0;
      return;
    }
    int i;
    int i1;
    label482: int i2;
    label520: int i3;
    if (this.zzbap == 1)
    {
      zzb(paramzzno, 3);
      i = (0x6 & this.zzbac.data[2]) >> 1;
      if (i != 0)
        break label630;
      this.zzbat = 1;
      this.zzbau = zza(this.zzbau, 1);
      this.zzbau[0] = (-3 + (paramInt2 - this.zzbaw));
      int n = this.zzbac.data[0] << 8 | 0xFF & this.zzbac.data[1];
      this.zzbaq = (this.zzaof + zzdw(n));
      if ((0x8 & this.zzbac.data[2]) != 8)
        break label1249;
      i1 = 1;
      if ((localzzog.type != 2) && ((paramInt1 != 163) || ((0x80 & this.zzbac.data[2]) != 128)))
        break label1255;
      i2 = 1;
      if (i2 == 0)
        break label1261;
      i3 = 1;
      label528: if (i1 == 0)
        break label1267;
    }
    label1249: label1255: label1261: label1267: for (int i4 = -2147483648; ; i4 = 0)
    {
      this.zzbax = (i4 | i3);
      this.zzbap = 2;
      this.zzbas = 0;
      if (paramInt1 != 163)
        break label1279;
      while (this.zzbas < this.zzbat)
      {
        zza(paramzzno, localzzog, this.zzbau[this.zzbas]);
        zza(localzzog, this.zzbaq + this.zzbas * localzzog.zzbbh / 1000);
        this.zzbas = (1 + this.zzbas);
      }
      label630: if (paramInt1 != 163)
        throw new zzlm("Lacing only supported in SimpleBlocks.");
      zzb(paramzzno, 4);
      this.zzbat = (1 + (0xFF & this.zzbac.data[3]));
      this.zzbau = zza(this.zzbau, this.zzbat);
      if (i == 2)
      {
        int i16 = (-4 + (paramInt2 - this.zzbaw)) / this.zzbat;
        Arrays.fill(this.zzbau, 0, this.zzbat, i16);
        break;
      }
      if (i == 1)
      {
        int i12 = 0;
        int i13 = 4;
        for (int i14 = 0; i14 < -1 + this.zzbat; i14++)
        {
          this.zzbau[i14] = 0;
          int i15;
          do
          {
            i13++;
            zzb(paramzzno, i13);
            i15 = 0xFF & this.zzbac.data[(i13 - 1)];
            int[] arrayOfInt2 = this.zzbau;
            arrayOfInt2[i14] = (i15 + arrayOfInt2[i14]);
          }
          while (i15 == 255);
          i12 += this.zzbau[i14];
        }
        this.zzbau[(-1 + this.zzbat)] = (paramInt2 - this.zzbaw - i13 - i12);
        break;
      }
      if (i == 3)
      {
        int j = 0;
        int k = 4;
        int m = 0;
        if (m < -1 + this.zzbat)
        {
          this.zzbau[m] = 0;
          k++;
          zzb(paramzzno, k);
          if (this.zzbac.data[(k - 1)] == 0)
            throw new zzlm("No valid varint length mask found");
          long l1 = 0L;
          for (int i5 = 0; ; i5++)
          {
            if (i5 < 8)
            {
              int i7 = 1 << 7 - i5;
              if ((i7 & this.zzbac.data[(k - 1)]) == 0)
                continue;
              int i8 = k - 1;
              k += i5;
              zzb(paramzzno, k);
              byte[] arrayOfByte1 = this.zzbac.data;
              int i9 = i8 + 1;
              l1 = 0xFF & arrayOfByte1[i8] & (i7 ^ 0xFFFFFFFF);
              int i11;
              for (int i10 = i9; i10 < k; i10 = i11)
              {
                long l2 = l1 << 8;
                byte[] arrayOfByte2 = this.zzbac.data;
                i11 = i10 + 1;
                l1 = l2 | 0xFF & arrayOfByte2[i10];
              }
              if (m > 0)
                l1 -= (1L << 6 + i5 * 7) - 1L;
            }
            if ((l1 >= -2147483648L) && (l1 <= 2147483647L))
              break;
            throw new zzlm("EBML lacing sample size out of range.");
          }
          int i6 = (int)l1;
          int[] arrayOfInt1 = this.zzbau;
          if (m == 0);
          while (true)
          {
            arrayOfInt1[m] = i6;
            j += this.zzbau[m];
            m++;
            break;
            i6 += this.zzbau[(m - 1)];
          }
        }
        this.zzbau[(-1 + this.zzbat)] = (paramInt2 - this.zzbaw - k - j);
        break;
      }
      throw new zzlm(36 + "Unexpected lacing value: " + i);
      i1 = 0;
      break label482;
      i2 = 0;
      break label520;
      i3 = 0;
      break label528;
    }
    this.zzbap = 0;
    return;
    label1279: zza(paramzzno, localzzog, this.zzbau[0]);
  }

  final void zza(int paramInt, String paramString)
    throws zzlm
  {
    switch (paramInt)
    {
    default:
    case 17026:
      do
        return;
      while (("webm".equals(paramString)) || ("matroska".equals(paramString)));
      throw new zzlm(22 + String.valueOf(paramString).length() + "DocType " + paramString + " not supported");
    case 134:
      this.zzbal.zzaor = paramString;
      return;
    case 2274716:
    }
    zzog.zza(this.zzbal, paramString);
  }

  public final void zza(zznp paramzznp)
  {
    this.zzbbf = paramzznp;
  }

  public final boolean zza(zzno paramzzno)
    throws IOException, InterruptedException
  {
    return new zzoh().zza(paramzzno);
  }

  final void zzb(int paramInt, long paramLong1, long paramLong2)
    throws zzlm
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
        if ((this.zzans != -1L) && (this.zzans != paramLong1))
          throw new zzlm("Multiple Segment elements not supported");
        this.zzans = paramLong1;
        this.zzant = paramLong2;
        return;
        this.zzanz = -1;
        this.zzaoa = -1L;
        return;
        this.zzban = new zzsn();
        this.zzbao = new zzsn();
        return;
        this.zzaoi = false;
        return;
      }
      while (this.zzbam);
      if ((this.zzazz) && (this.zzaoc != -1L))
      {
        this.zzaob = true;
        return;
      }
      this.zzbbf.zza(new zznv(this.zzack));
      this.zzbam = true;
      return;
    case 160:
      this.zzaop = false;
      return;
    case 20533:
      this.zzbal.zzaos = true;
      return;
    case 174:
      this.zzbal = new zzog(null);
      return;
    case 21968:
    }
    this.zzbal.zzbbn = true;
  }

  final void zzc(int paramInt, long paramLong)
    throws zzlm
  {
    int i = 1;
    switch (paramInt)
    {
    default:
    case 17143:
    case 17029:
    case 21420:
    case 2807729:
    case 176:
    case 186:
    case 21680:
    case 21690:
    case 21682:
    case 215:
    case 136:
    case 21930:
    case 131:
    case 2352003:
    case 22186:
    case 22203:
    case 159:
    case 25188:
    case 251:
    case 20529:
    case 20530:
    case 16980:
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
                    throw new zzlm(50 + "EBMLReadVersion " + paramLong + " not supported");
                  }
                  while ((paramLong >= 1L) && (paramLong <= 2L));
                  throw new zzlm(53 + "DocTypeReadVersion " + paramLong + " not supported");
                  this.zzaoa = (paramLong + this.zzans);
                  return;
                  this.zzanu = paramLong;
                  return;
                  this.zzbal.width = ((int)paramLong);
                  return;
                  this.zzbal.height = ((int)paramLong);
                  return;
                  this.zzbal.zzbbk = ((int)paramLong);
                  return;
                  this.zzbal.zzbbl = ((int)paramLong);
                  return;
                  this.zzbal.zzbbm = ((int)paramLong);
                  return;
                  this.zzbal.number = ((int)paramLong);
                  return;
                  zzog localzzog2 = this.zzbal;
                  if (paramLong == 1L);
                  while (true)
                  {
                    localzzog2.zzbce = i;
                    return;
                    i = 0;
                  }
                  zzog localzzog1 = this.zzbal;
                  if (paramLong == 1L);
                  while (true)
                  {
                    localzzog1.zzbcf = i;
                    return;
                    i = 0;
                  }
                  this.zzbal.type = ((int)paramLong);
                  return;
                  this.zzbal.zzbbh = ((int)paramLong);
                  return;
                  this.zzbal.zzaow = paramLong;
                  return;
                  this.zzbal.zzaox = paramLong;
                  return;
                  this.zzbal.zzafu = ((int)paramLong);
                  return;
                  this.zzbal.zzbcd = ((int)paramLong);
                  return;
                  this.zzaop = i;
                  return;
                }
                while (paramLong == 0L);
                throw new zzlm(55 + "ContentEncodingOrder " + paramLong + " not supported");
              }
              while (paramLong == 1L);
              throw new zzlm(55 + "ContentEncodingScope " + paramLong + " not supported");
            }
            while (paramLong == 3L);
            throw new zzlm(50 + "ContentCompAlgo " + paramLong + " not supported");
          }
          while (paramLong == 5L);
          throw new zzlm(49 + "ContentEncAlgo " + paramLong + " not supported");
        }
        while (paramLong == 1L);
        throw new zzlm(56 + "AESSettingsCipherMode " + paramLong + " not supported");
        this.zzban.add(zzdw(paramLong));
        return;
      }
      while (this.zzaoi);
      this.zzbao.add(paramLong);
      this.zzaoi = i;
      return;
    case 231:
      this.zzaof = zzdw(paramLong);
      return;
    case 155:
      this.zzbar = zzdw(paramLong);
      return;
    case 21432:
      switch ((int)paramLong)
      {
      default:
        return;
      case 0:
        this.zzbal.zzatu = 0;
        return;
      case 1:
        this.zzbal.zzatu = 2;
        return;
      case 3:
        this.zzbal.zzatu = i;
        return;
      case 15:
      }
      this.zzbal.zzatu = 3;
      return;
    case 21947:
      this.zzbal.zzbbn = i;
      switch ((int)paramLong)
      {
      case 2:
      case 3:
      case 8:
      default:
        return;
      case 1:
        this.zzbal.zzbbo = i;
        return;
      case 4:
      case 5:
      case 6:
      case 7:
        this.zzbal.zzbbo = 2;
        return;
      case 9:
      }
      this.zzbal.zzbbo = 6;
      return;
    case 21946:
      switch ((int)paramLong)
      {
      default:
        return;
      case 1:
      case 6:
      case 7:
        this.zzbal.zzbbp = 3;
        return;
      case 16:
        this.zzbal.zzbbp = 6;
        return;
      case 18:
      }
      this.zzbal.zzbbp = 7;
      return;
    case 21945:
      switch ((int)paramLong)
      {
      default:
        return;
      case 1:
        this.zzbal.zzbbq = 2;
        return;
      case 2:
      }
      this.zzbal.zzbbq = i;
      return;
    case 21948:
      this.zzbal.zzbbr = ((int)paramLong);
      return;
    case 21949:
    }
    this.zzbal.zzbbs = ((int)paramLong);
  }

  public final void zzd(long paramLong1, long paramLong2)
  {
    this.zzaof = -9223372036854775807L;
    this.zzbap = 0;
    this.zzazx.reset();
    this.zzazr.reset();
    zzij();
  }

  final void zzy(int paramInt)
    throws zzlm
  {
    switch (paramInt)
    {
    default:
    case 357149030:
    case 19899:
    case 475249515:
    case 160:
    case 25152:
    case 28032:
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
                  return;
                  if (this.zzanu == -9223372036854775807L)
                    this.zzanu = 1000000L;
                }
                while (this.zzbak == -9223372036854775807L);
                this.zzack = zzdw(this.zzbak);
                return;
                if ((this.zzanz == -1) || (this.zzaoa == -1L))
                  throw new zzlm("Mandatory element SeekID or SeekPosition not found");
              }
              while (this.zzanz != 475249515);
              this.zzaoc = this.zzaoa;
              return;
            }
            while (this.zzbam);
            zznp localzznp = this.zzbbf;
            if ((this.zzans == -1L) || (this.zzack == -9223372036854775807L) || (this.zzban == null) || (this.zzban.size() == 0) || (this.zzbao == null) || (this.zzbao.size() != this.zzban.size()))
            {
              this.zzban = null;
              this.zzbao = null;
            }
            int[] arrayOfInt;
            long[] arrayOfLong1;
            long[] arrayOfLong2;
            long[] arrayOfLong3;
            for (Object localObject = new zznv(this.zzack); ; localObject = new zznl(arrayOfInt, arrayOfLong1, arrayOfLong2, arrayOfLong3))
            {
              localzznp.zza((zznu)localObject);
              this.zzbam = true;
              return;
              int j = this.zzban.size();
              arrayOfInt = new int[j];
              arrayOfLong1 = new long[j];
              arrayOfLong2 = new long[j];
              arrayOfLong3 = new long[j];
              for (int k = 0; k < j; k++)
              {
                arrayOfLong3[k] = this.zzban.get(k);
                arrayOfLong1[k] = (this.zzans + this.zzbao.get(k));
              }
              for (int m = 0; m < j - 1; m++)
              {
                arrayOfInt[m] = ((int)(arrayOfLong1[(m + 1)] - arrayOfLong1[m]));
                arrayOfLong2[m] = (arrayOfLong3[(m + 1)] - arrayOfLong3[m]);
              }
              arrayOfInt[(j - 1)] = ((int)(this.zzans + this.zzant - arrayOfLong1[(j - 1)]));
              arrayOfLong2[(j - 1)] = (this.zzack - arrayOfLong3[(j - 1)]);
              this.zzban = null;
              this.zzbao = null;
            }
          }
          while (this.zzbap != 2);
          if (!this.zzaop)
            this.zzbax = (0x1 | this.zzbax);
          zza((zzog)this.zzazy.get(this.zzbav), this.zzbaq);
          this.zzbap = 0;
          return;
        }
        while (!this.zzbal.zzaos);
        if (this.zzbal.zzbbj == null)
          throw new zzlm("Encrypted Track found but ContentEncKeyID was not found");
        zzog localzzog = this.zzbal;
        zzne.zza[] arrayOfzza = new zzne.zza[1];
        arrayOfzza[0] = new zzne.zza(zzkt.zzarg, "video/webm", this.zzbal.zzbbj.zzazq);
        localzzog.zzatr = new zzne(arrayOfzza);
        return;
      }
      while ((!this.zzbal.zzaos) || (this.zzbal.zzbbi == null));
      throw new zzlm("Combining encryption and compression is not supported");
    case 174:
      String str = this.zzbal.zzaor;
      if (("V_VP8".equals(str)) || ("V_VP9".equals(str)) || ("V_MPEG2".equals(str)) || ("V_MPEG4/ISO/SP".equals(str)) || ("V_MPEG4/ISO/ASP".equals(str)) || ("V_MPEG4/ISO/AP".equals(str)) || ("V_MPEG4/ISO/AVC".equals(str)) || ("V_MPEGH/ISO/HEVC".equals(str)) || ("V_MS/VFW/FOURCC".equals(str)) || ("V_THEORA".equals(str)) || ("A_OPUS".equals(str)) || ("A_VORBIS".equals(str)) || ("A_AAC".equals(str)) || ("A_MPEG/L2".equals(str)) || ("A_MPEG/L3".equals(str)) || ("A_AC3".equals(str)) || ("A_EAC3".equals(str)) || ("A_TRUEHD".equals(str)) || ("A_DTS".equals(str)) || ("A_DTS/EXPRESS".equals(str)) || ("A_DTS/LOSSLESS".equals(str)) || ("A_FLAC".equals(str)) || ("A_MS/ACM".equals(str)) || ("A_PCM/INT/LIT".equals(str)) || ("S_TEXT/UTF8".equals(str)) || ("S_VOBSUB".equals(str)) || ("S_HDMV/PGS".equals(str)) || ("S_DVBSUB".equals(str)));
      for (int i = 1; ; i = 0)
      {
        if (i != 0)
        {
          this.zzbal.zza(this.zzbbf, this.zzbal.number);
          this.zzazy.put(this.zzbal.number, this.zzbal);
        }
        this.zzbal = null;
        return;
      }
    case 374648427:
    }
    if (this.zzazy.size() == 0)
      throw new zzlm("No valid tracks were found");
    this.zzbbf.zzfi();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzod
 * JD-Core Version:    0.6.2
 */