package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzit
{
  public static zzix zza(zzir paramzzir, zzis paramzzis)
  {
    zzir localzzir1 = paramzzir.zzw(zziq.zzakr);
    zzkm localzzkm1 = localzzir1.zzv(zziq.zzala).zzamc;
    localzzkm1.setPosition(16);
    int i = localzzkm1.readInt();
    if ((i != 1936684398) && (i != 1986618469) && (i != 1952807028) && (i != 1953325924))
      return null;
    zzkm localzzkm2 = paramzzir.zzv(zziq.zzaky).zzamc;
    localzzkm2.setPosition(8);
    int j = zziq.zzt(localzzkm2.readInt());
    int k;
    int i2;
    label137: int i3;
    label140: long l1;
    label182: int i4;
    long l2;
    int i5;
    label251: long l3;
    long l4;
    label279: int i6;
    label328: long l5;
    zzkm localzzkm5;
    int i7;
    zziu localzziu;
    int i8;
    if (j == 0)
    {
      k = 8;
      localzzkm2.zzac(k);
      int m = localzzkm2.readInt();
      localzzkm2.zzac(4);
      int n = 1;
      int i1 = localzzkm2.getPosition();
      if (j != 0)
        break label624;
      i2 = 4;
      i3 = 0;
      if (i3 < i2)
      {
        if (localzzkm2.data[(i1 + i3)] == -1)
          break label631;
        n = 0;
      }
      if (n == 0)
        break label637;
      localzzkm2.zzac(i2);
      l1 = -1L;
      Pair localPair1 = Pair.create(Integer.valueOf(m), Long.valueOf(l1));
      i4 = ((Integer)localPair1.first).intValue();
      l2 = ((Long)localPair1.second).longValue();
      zzkm localzzkm3 = paramzzis.zzamc;
      localzzkm3.setPosition(8);
      if (zziq.zzt(localzzkm3.readInt()) != 0)
        break label662;
      i5 = 8;
      localzzkm3.zzac(i5);
      l3 = localzzkm3.zzge();
      if (l2 != -1L)
        break label669;
      l4 = -1L;
      zzir localzzir2 = localzzir1.zzw(zziq.zzaks).zzw(zziq.zzakt);
      zzkm localzzkm4 = localzzir1.zzv(zziq.zzakz).zzamc;
      localzzkm4.setPosition(8);
      if (zziq.zzt(localzzkm4.readInt()) != 0)
        break label684;
      i6 = 8;
      localzzkm4.zzac(i6);
      l5 = localzzkm4.zzge();
      localzzkm5 = localzzir2.zzv(zziq.zzalb).zzamc;
      localzzkm5.setPosition(12);
      i7 = localzzkm5.readInt();
      localzziu = new zziu(i7);
      i8 = 0;
    }
    int i10;
    int i11;
    label412: int i12;
    label624: label631: label637: int i26;
    label662: label669: label684: label697: label703: label839: int i27;
    label911: label948: int i28;
    Object localObject2;
    int i29;
    label1026: int i30;
    int i31;
    boolean bool3;
    label1065: int i32;
    Object localObject3;
    while (true)
      if (i8 < i7)
      {
        i10 = localzzkm5.getPosition();
        i11 = localzzkm5.readInt();
        boolean bool1;
        int i13;
        int i14;
        float f;
        int i15;
        int i16;
        int i17;
        if (i11 > 0)
        {
          bool1 = true;
          zzkh.checkArgument(bool1, "childAtomSize should be positive");
          i12 = localzzkm5.readInt();
          if ((i12 != zziq.zzaka) && (i12 != zziq.zzakb) && (i12 != zziq.zzalh))
            break label948;
          localzzkm5.setPosition(i10 + 8);
          localzzkm5.zzac(24);
          i13 = localzzkm5.readUnsignedShort();
          i14 = localzzkm5.readUnsignedShort();
          f = 1.0F;
          localzzkm5.zzac(50);
          localObject1 = null;
          i15 = localzzkm5.getPosition();
          if (i15 - i10 >= i11)
            break label911;
          localzzkm5.setPosition(i15);
          i16 = localzzkm5.getPosition();
          i17 = localzzkm5.readInt();
          if ((i17 == 0) && (localzzkm5.getPosition() - i10 == i11))
            break label911;
          if (i17 <= 0)
            break label697;
        }
        int i18;
        int i21;
        for (boolean bool2 = true; ; bool2 = false)
        {
          zzkh.checkArgument(bool2, "childAtomSize should be positive");
          i18 = localzzkm5.readInt();
          if (i18 != zziq.zzaku)
            break label839;
          localzzkm5.setPosition(4 + (i16 + 8));
          i21 = 1 + (0x3 & localzzkm5.readUnsignedByte());
          if (i21 != 3)
            break label703;
          throw new IllegalStateException();
          k = 16;
          break;
          i2 = 8;
          break label137;
          i3++;
          break label140;
          if (j == 0)
          {
            l1 = localzzkm2.zzge();
            break label182;
          }
          l1 = localzzkm2.zzgh();
          break label182;
          i5 = 16;
          break label251;
          l4 = zzkq.zza(l2, 1000000L, l3);
          break label279;
          i6 = 16;
          break label328;
          bool1 = false;
          break label412;
        }
        ArrayList localArrayList1 = new ArrayList();
        int i22 = 0x1F & localzzkm5.readUnsignedByte();
        for (int i23 = 0; i23 < i22; i23++)
          localArrayList1.add(zzkj.zzc(localzzkm5));
        int i24 = localzzkm5.readUnsignedByte();
        for (int i25 = 0; i25 < i24; i25++)
          localArrayList1.add(zzkj.zzc(localzzkm5));
        Pair localPair2 = Pair.create(localArrayList1, Integer.valueOf(i21));
        List localList1 = (List)localPair2.first;
        localzziu.zzamf = ((Integer)localPair2.second).intValue();
        Object localObject1 = localList1;
        while (true)
        {
          i15 += i17;
          break;
          if (i18 == zziq.zzald)
          {
            localzziu.zzamd[i8] = zza(localzzkm5, i16, i17);
          }
          else if (i18 == zziq.zzaln)
          {
            localzzkm5.setPosition(i16 + 8);
            int i19 = localzzkm5.zzgg();
            int i20 = localzzkm5.zzgg();
            f = i19 / i20;
          }
        }
        localzziu.zzame = zzhj.zza("video/avc", -1, l4, i13, i14, f, localObject1);
        localzzkm5.setPosition(i10 + i11);
        i8++;
        continue;
        if ((i12 == zziq.zzake) || (i12 == zziq.zzali) || (i12 == zziq.zzakf))
        {
          localzzkm5.setPosition(i10 + 8);
          localzzkm5.zzac(16);
          i26 = localzzkm5.readUnsignedShort();
          i27 = localzzkm5.readUnsignedShort();
          localzzkm5.zzac(4);
          i28 = localzzkm5.zzgf();
          localObject2 = null;
          i29 = localzzkm5.getPosition();
          if (i29 - i10 < i11)
          {
            localzzkm5.setPosition(i29);
            i30 = localzzkm5.getPosition();
            i31 = localzzkm5.readInt();
            if (i31 > 0)
            {
              bool3 = true;
              zzkh.checkArgument(bool3, "childAtomSize should be positive");
              i32 = localzzkm5.readInt();
              if ((i12 != zziq.zzake) && (i12 != zziq.zzali))
                break label1201;
              if (i32 != zziq.zzakc)
                break label1169;
              byte[] arrayOfByte = zzc(localzzkm5, i30);
              Pair localPair3 = zzki.zzd(arrayOfByte);
              i28 = ((Integer)localPair3.first).intValue();
              i26 = ((Integer)localPair3.second).intValue();
              localObject3 = arrayOfByte;
            }
          }
        }
      }
    while (true)
    {
      i29 += i31;
      localObject2 = localObject3;
      break label1026;
      bool3 = false;
      break label1065;
      label1169: if (i32 == zziq.zzald)
      {
        localzziu.zzamd[i8] = zza(localzzkm5, i30, i31);
        localObject3 = localObject2;
        continue;
        label1201: if ((i12 == zziq.zzakf) && (i32 == zziq.zzakg))
        {
          localzzkm5.setPosition(i30 + 8);
          localzziu.zzame = zzkg.zza(localzzkm5);
          break;
        }
        if ((i12 == zziq.zzakh) && (i32 == zziq.zzaki))
        {
          localzzkm5.setPosition(i30 + 8);
          localzziu.zzame = zzkg.zzb(localzzkm5);
          break;
          String str;
          if (i12 == zziq.zzakf)
          {
            str = "audio/ac3";
            if (localObject2 != null)
              break label1344;
          }
          label1344: for (List localList2 = null; ; localList2 = Collections.singletonList(localObject2))
          {
            localzziu.zzame = zzhj.zzb(str, i27, l4, i26, i28, localList2);
            break;
            if (i12 == zziq.zzakh)
            {
              str = "audio/eac3";
              break label1291;
            }
            str = "audio/mp4a-latm";
            break label1291;
          }
          if (i12 == zziq.zzalo)
          {
            localzziu.zzame = zzhj.zzem();
            break;
          }
          if (i12 != zziq.zzalr)
            break;
          localzzkm5.setPosition(i10 + 8);
          localzzkm5.zzac(24);
          int i33 = localzzkm5.readUnsignedShort();
          int i34 = localzzkm5.readUnsignedShort();
          localzzkm5.zzac(50);
          ArrayList localArrayList2 = new ArrayList(1);
          int i35 = localzzkm5.getPosition();
          if (i35 - i10 < i11)
          {
            localzzkm5.setPosition(i35);
            int i36 = localzzkm5.getPosition();
            int i37 = localzzkm5.readInt();
            if (i37 > 0);
            for (boolean bool4 = true; ; bool4 = false)
            {
              zzkh.checkArgument(bool4, "childAtomSize should be positive");
              if (localzzkm5.readInt() == zziq.zzakc)
                localArrayList2.add(zzc(localzzkm5, i36));
              i35 += i37;
              break;
            }
          }
          localzziu.zzame = zzhj.zza("video/mp4v-es", -1, l4, i33, i34, localArrayList2);
          break;
          zzhj localzzhj = localzziu.zzame;
          zziy[] arrayOfzziy = localzziu.zzamd;
          int i9 = localzziu.zzamf;
          return new zzix(i4, i, l5, l4, localzzhj, arrayOfzziy, i9);
        }
      }
      label1291: localObject3 = localObject2;
    }
  }

  private static zziy zza(zzkm paramzzkm, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + 8;
    zziy localzziy = null;
    if (i - paramInt1 < paramInt2)
    {
      paramzzkm.setPosition(i);
      int j = paramzzkm.readInt();
      int k = paramzzkm.readInt();
      if (k == zziq.zzalj)
        paramzzkm.readInt();
      while (true)
      {
        i += j;
        break;
        if (k == zziq.zzale)
        {
          paramzzkm.zzac(4);
          paramzzkm.readInt();
          paramzzkm.readInt();
        }
        else if (k == zziq.zzalf)
        {
          int m = i + 8;
          while (true)
          {
            if (m - i >= j)
              break label204;
            paramzzkm.setPosition(m);
            int n = paramzzkm.readInt();
            if (paramzzkm.readInt() == zziq.zzalg)
            {
              paramzzkm.zzac(4);
              int i1 = paramzzkm.readInt();
              if (i1 >> 8 == 1);
              for (boolean bool = true; ; bool = false)
              {
                int i2 = i1 & 0xFF;
                byte[] arrayOfByte = new byte[16];
                paramzzkm.zzb(arrayOfByte, 0, 16);
                localzziy = new zziy(bool, i2, arrayOfByte);
                break;
              }
            }
            m += n;
          }
          label204: localzziy = null;
        }
      }
    }
    return localzziy;
  }

  private static byte[] zzc(zzkm paramzzkm, int paramInt)
  {
    paramzzkm.setPosition(4 + (paramInt + 8));
    paramzzkm.zzac(1);
    for (int i = paramzzkm.readUnsignedByte(); i > 127; i = paramzzkm.readUnsignedByte());
    paramzzkm.zzac(2);
    int j = paramzzkm.readUnsignedByte();
    if ((j & 0x80) != 0)
      paramzzkm.zzac(2);
    if ((j & 0x40) != 0)
      paramzzkm.zzac(paramzzkm.readUnsignedShort());
    if ((j & 0x20) != 0)
      paramzzkm.zzac(2);
    paramzzkm.zzac(1);
    for (int k = paramzzkm.readUnsignedByte(); k > 127; k = paramzzkm.readUnsignedByte());
    paramzzkm.zzac(13);
    paramzzkm.zzac(1);
    int m = paramzzkm.readUnsignedByte();
    for (int n = m & 0x7F; m > 127; n = n << 8 | m & 0x7F)
      m = paramzzkm.readUnsignedByte();
    byte[] arrayOfByte = new byte[n];
    paramzzkm.zzb(arrayOfByte, 0, n);
    return arrayOfByte;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzit
 * JD-Core Version:    0.6.2
 */