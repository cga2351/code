package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zzom
{
  private static final int zzbdl = zzsy.zzay("meta");
  private static final int zzbeb = zzsy.zzay("vide");
  private static final int zzbec = zzsy.zzay("soun");
  private static final int zzbed = zzsy.zzay("text");
  private static final int zzbee = zzsy.zzay("sbtl");
  private static final int zzbef = zzsy.zzay("subt");
  private static final int zzbeg = zzsy.zzay("clcp");
  private static final int zzbeh = zzsy.zzay("cenc");

  private static int zza(zzst paramzzst, int paramInt1, int paramInt2, zzop paramzzop, int paramInt3)
  {
    int i = paramzzst.getPosition();
    while (i - paramInt1 < paramInt2)
    {
      paramzzst.setPosition(i);
      int j = paramzzst.readInt();
      boolean bool1;
      int m;
      zzpb localzzpb;
      Integer localInteger;
      int n;
      label71: int i1;
      int i2;
      if (j > 0)
      {
        bool1 = true;
        zzsk.checkArgument(bool1, "childAtomSize should be positive");
        if (paramzzst.readInt() != zzoj.zzald)
          break label386;
        int k = i + 8;
        m = 0;
        localzzpb = null;
        localInteger = null;
        n = k;
        if (n - i >= j)
          break label292;
        paramzzst.setPosition(n);
        i1 = paramzzst.readInt();
        i2 = paramzzst.readInt();
        if (i2 != zzoj.zzalj)
          break label132;
        localInteger = Integer.valueOf(paramzzst.readInt());
      }
      while (true)
      {
        n += i1;
        break label71;
        bool1 = false;
        break;
        label132: if (i2 == zzoj.zzale)
        {
          paramzzst.zzac(4);
          if (paramzzst.readInt() == zzbeh)
            m = 1;
          else
            m = 0;
        }
        else if (i2 == zzoj.zzalf)
        {
          int i3 = n + 8;
          while (true)
          {
            if (i3 - n >= i1)
              break label286;
            paramzzst.setPosition(i3);
            int i4 = paramzzst.readInt();
            if (paramzzst.readInt() == zzoj.zzalg)
            {
              paramzzst.zzac(6);
              if (paramzzst.readUnsignedByte() == 1);
              for (boolean bool4 = true; ; bool4 = false)
              {
                int i5 = paramzzst.readUnsignedByte();
                byte[] arrayOfByte = new byte[16];
                paramzzst.zzb(arrayOfByte, 0, 16);
                localzzpb = new zzpb(bool4, i5, arrayOfByte);
                break;
              }
            }
            i3 += i4;
          }
          label286: localzzpb = null;
        }
      }
      label292: boolean bool2;
      boolean bool3;
      if (m != 0)
        if (localInteger != null)
        {
          bool2 = true;
          zzsk.checkArgument(bool2, "frma atom is mandatory");
          if (localzzpb == null)
            break label374;
          bool3 = true;
          label320: zzsk.checkArgument(bool3, "schi->tenc atom is mandatory");
        }
      for (Pair localPair = Pair.create(localInteger, localzzpb); ; localPair = null)
      {
        if (localPair == null)
          break label386;
        paramzzop.zzbeo[paramInt3] = ((zzpb)localPair.second);
        return ((Integer)localPair.first).intValue();
        bool2 = false;
        break;
        label374: bool3 = false;
        break label320;
      }
      label386: i += j;
    }
    return 0;
  }

  public static zzpa zza(zzok paramzzok, zzol paramzzol, long paramLong, zzne paramzzne, boolean paramBoolean)
    throws zzlm
  {
    zzok localzzok1 = paramzzok.zzaz(zzoj.zzakr);
    zzst localzzst1 = localzzok1.zzay(zzoj.zzala).zzbea;
    localzzst1.setPosition(16);
    int i = localzzst1.readInt();
    int j;
    if (i == zzbec)
      j = 1;
    while (j == -1)
    {
      return null;
      if (i == zzbeb)
        j = 2;
      else if ((i == zzbed) || (i == zzbee) || (i == zzbef) || (i == zzbeg))
        j = 3;
      else if (i == zzbdl)
        j = 4;
      else
        j = -1;
    }
    zzst localzzst2 = paramzzok.zzay(zzoj.zzaky).zzbea;
    localzzst2.setPosition(8);
    int k = zzoj.zzt(localzzst2.readInt());
    int m;
    int i3;
    label203: int i4;
    label206: long l1;
    label248: int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    label317: zzos localzzos;
    if (k == 0)
    {
      m = 8;
      localzzst2.zzac(m);
      int n = localzzst2.readInt();
      localzzst2.zzac(4);
      int i1 = 1;
      int i2 = localzzst2.getPosition();
      if (k != 0)
        break label1026;
      i3 = 4;
      i4 = 0;
      if (i4 < i3)
      {
        if (localzzst2.data[(i2 + i4)] == -1)
          break label1033;
        i1 = 0;
      }
      if (i1 == 0)
        break label1039;
      localzzst2.zzac(i3);
      l1 = -9223372036854775807L;
      localzzst2.zzac(16);
      i5 = localzzst2.readInt();
      i6 = localzzst2.readInt();
      localzzst2.zzac(4);
      i7 = localzzst2.readInt();
      i8 = localzzst2.readInt();
      if ((i5 != 0) || (i6 != 65536) || (i7 != -65536) || (i8 != 0))
        break label1076;
      i9 = 90;
      localzzos = new zzos(n, l1, i9);
      if (-9223372036854775807L != -9223372036854775807L)
        break label3293;
    }
    label405: label460: label858: label1499: label3293: for (long l2 = zzos.zza(localzzos); ; l2 = paramLong)
    {
      zzst localzzst3 = paramzzol.zzbea;
      localzzst3.setPosition(8);
      int i10;
      label377: long l3;
      long l4;
      int i12;
      int i13;
      label482: Pair localPair1;
      zzst localzzst5;
      int i15;
      int i16;
      String str2;
      int i17;
      zzop localzzop;
      int i18;
      if (zzoj.zzt(localzzst3.readInt()) == 0)
      {
        i10 = 8;
        localzzst3.zzac(i10);
        l3 = localzzst3.zzge();
        if (l2 != -9223372036854775807L)
          break label1153;
        l4 = -9223372036854775807L;
        zzok localzzok2 = localzzok1.zzaz(zzoj.zzaks).zzaz(zzoj.zzakt);
        zzst localzzst4 = localzzok1.zzay(zzoj.zzakz).zzbea;
        localzzst4.setPosition(8);
        int i11 = zzoj.zzt(localzzst4.readInt());
        if (i11 != 0)
          break label1168;
        i12 = 8;
        localzzst4.zzac(i12);
        long l5 = localzzst4.zzge();
        if (i11 != 0)
          break label1175;
        i13 = 4;
        localzzst4.zzac(i13);
        int i14 = localzzst4.readUnsignedShort();
        char c1 = (char)(96 + (0x1F & i14 >> 10));
        char c2 = (char)(96 + (0x1F & i14 >> 5));
        char c3 = (char)(96 + (i14 & 0x1F));
        String str1 = 3 + c1 + c2 + c3;
        localPair1 = Pair.create(Long.valueOf(l5), str1);
        localzzst5 = localzzok2.zzay(zzoj.zzalb).zzbea;
        i15 = zzos.zzb(localzzos);
        i16 = zzos.zzc(localzzos);
        str2 = (String)localPair1.second;
        localzzst5.setPosition(12);
        i17 = localzzst5.readInt();
        localzzop = new zzop(i17);
        i18 = 0;
      }
      int i25;
      int i26;
      int i27;
      int i44;
      label1889: int i45;
      int i46;
      int i47;
      String str4;
      while (true)
        if (i18 < i17)
        {
          i25 = localzzst5.getPosition();
          i26 = localzzst5.readInt();
          boolean bool1;
          int i28;
          int i29;
          int i30;
          float f;
          int i32;
          List localList1;
          Object localObject1;
          byte[] arrayOfByte1;
          int i33;
          int i34;
          int i35;
          int i36;
          boolean bool2;
          int i37;
          boolean bool7;
          int i38;
          if (i26 > 0)
          {
            bool1 = true;
            zzsk.checkArgument(bool1, "childAtomSize should be positive");
            i27 = localzzst5.readInt();
            if ((i27 != zzoj.zzaka) && (i27 != zzoj.zzakb) && (i27 != zzoj.zzalh) && (i27 != zzoj.zzalr) && (i27 != zzoj.zzbcj) && (i27 != zzoj.zzbck) && (i27 != zzoj.zzbcl) && (i27 != zzoj.zzbdu) && (i27 != zzoj.zzbdv))
              break label1741;
            localzzst5.setPosition(8 + (i25 + 8));
            localzzst5.zzac(16);
            i28 = localzzst5.readUnsignedShort();
            i29 = localzzst5.readUnsignedShort();
            i30 = 0;
            f = 1.0F;
            localzzst5.zzac(50);
            int i31 = localzzst5.getPosition();
            if (i27 == zzoj.zzalh)
            {
              i27 = zza(localzzst5, i25, i26, localzzop, i18);
              localzzst5.setPosition(i31);
            }
            i32 = i27;
            localList1 = null;
            localObject1 = null;
            arrayOfByte1 = null;
            i33 = -1;
            i34 = i31;
            if (i34 - i25 >= i26)
              break label1683;
            localzzst5.setPosition(i34);
            i35 = localzzst5.getPosition();
            i36 = localzzst5.readInt();
            if ((i36 == 0) && (localzzst5.getPosition() - i25 == i26))
              break label1683;
            if (i36 <= 0)
              break label1188;
            bool2 = true;
            zzsk.checkArgument(bool2, "childAtomSize should be positive");
            i37 = localzzst5.readInt();
            if (i37 != zzoj.zzaku)
              break label1200;
            if (localObject1 != null)
              break label1194;
            bool7 = true;
            zzsk.checkState(bool7);
            localObject1 = "video/avc";
            localzzst5.setPosition(i35 + 8);
            zzta localzzta = zzta.zzf(localzzst5);
            localList1 = localzzta.zzafw;
            localzzop.zzamf = localzzta.zzamf;
            if (i30 == 0)
              f = localzzta.zzbne;
            i38 = i30;
          }
          while (true)
          {
            i34 += i36;
            i30 = i38;
            break label858;
            m = 16;
            break;
            i3 = 8;
            break label203;
            i4++;
            break label206;
            if (k == 0);
            for (l1 = localzzst2.zzge(); ; l1 = localzzst2.zzgh())
            {
              if (l1 != 0L)
                break label1074;
              l1 = -9223372036854775807L;
              break;
            }
            break label248;
            if ((i5 == 0) && (i6 == -65536) && (i7 == 65536) && (i8 == 0))
            {
              i9 = 270;
              break label317;
            }
            if ((i5 == -65536) && (i6 == 0) && (i7 == 0) && (i8 == -65536))
            {
              i9 = 180;
              break label317;
            }
            i9 = 0;
            break label317;
            i10 = 16;
            break label377;
            l4 = zzsy.zza(l2, 1000000L, l3);
            break label405;
            i12 = 16;
            break label460;
            i13 = 8;
            break label482;
            bool1 = false;
            break label668;
            bool2 = false;
            break label915;
            bool7 = false;
            break label945;
            if (i37 == zzoj.zzbcw)
            {
              if (localObject1 == null);
              for (boolean bool6 = true; ; bool6 = false)
              {
                zzsk.checkState(bool6);
                localObject1 = "video/hevc";
                localzzst5.setPosition(i35 + 8);
                zztg localzztg = zztg.zzh(localzzst5);
                localList1 = localzztg.zzafw;
                localzzop.zzamf = localzztg.zzamf;
                i38 = i30;
                break;
              }
            }
            if (i37 == zzoj.zzbdw)
            {
              boolean bool5;
              if (localObject1 == null)
              {
                bool5 = true;
                zzsk.checkState(bool5);
                if (i32 != zzoj.zzbdu)
                  break label1320;
              }
              for (localObject1 = "video/x-vnd.on2.vp8"; ; localObject1 = "video/x-vnd.on2.vp9")
              {
                i38 = i30;
                break;
                bool5 = false;
                break label1289;
              }
            }
            if (i37 == zzoj.zzbcm)
            {
              if (localObject1 == null);
              for (boolean bool4 = true; ; bool4 = false)
              {
                zzsk.checkState(bool4);
                localObject1 = "video/3gpp";
                i38 = i30;
                break;
              }
            }
            if (i37 == zzoj.zzakc)
            {
              if (localObject1 == null);
              for (boolean bool3 = true; ; bool3 = false)
              {
                zzsk.checkState(bool3);
                Pair localPair3 = zzb(localzzst5, i35);
                String str3 = (String)localPair3.first;
                localList1 = Collections.singletonList((byte[])localPair3.second);
                localObject1 = str3;
                i38 = i30;
                break;
              }
            }
            if (i37 == zzoj.zzaln)
            {
              localzzst5.setPosition(i35 + 8);
              int i42 = localzzst5.zzgg();
              int i43 = localzzst5.zzgg();
              f = i42 / i43;
              i38 = 1;
            }
            else
            {
              if (i37 == zzoj.zzbds)
              {
                int i40 = i35 + 8;
                int i41;
                if (i40 - i35 < i36)
                {
                  localzzst5.setPosition(i40);
                  i41 = localzzst5.readInt();
                  if (localzzst5.readInt() != zzoj.zzbdt);
                }
                for (arrayOfByte1 = Arrays.copyOfRange(localzzst5.data, i40, i41 + i40); ; arrayOfByte1 = null)
                {
                  i38 = i30;
                  break;
                  i40 += i41;
                  break label1499;
                }
              }
              if (i37 == zzoj.zzbdr)
              {
                int i39 = localzzst5.readUnsignedByte();
                localzzst5.zzac(3);
                if (i39 != 0);
              }
              switch (localzzst5.readUnsignedByte())
              {
              default:
                i38 = i30;
                break;
              case 0:
                i38 = i30;
                i33 = 0;
                break;
              case 1:
                i33 = 1;
                i38 = i30;
                break;
              case 2:
                i33 = 2;
                i38 = i30;
                break;
              case 3:
                i33 = 3;
                i38 = i30;
              }
            }
          }
          if (localObject1 != null)
            localzzop.zzaue = zzlh.zza(Integer.toString(i15), (String)localObject1, null, -1, -1, i28, i29, -1.0F, localList1, i16, f, arrayOfByte1, i33, null, null);
          localzzst5.setPosition(i25 + i26);
          i18++;
          continue;
          if ((i27 == zzoj.zzake) || (i27 == zzoj.zzali) || (i27 == zzoj.zzakf) || (i27 == zzoj.zzakh) || (i27 == zzoj.zzbcr) || (i27 == zzoj.zzbcu) || (i27 == zzoj.zzbcs) || (i27 == zzoj.zzbct) || (i27 == zzoj.zzbdi) || (i27 == zzoj.zzbdj) || (i27 == zzoj.zzbcp) || (i27 == zzoj.zzbcq) || (i27 == zzoj.zzbcn) || (i27 == zzoj.zzbdy))
          {
            localzzst5.setPosition(8 + (i25 + 8));
            if (paramBoolean)
            {
              int i57 = localzzst5.readUnsignedShort();
              localzzst5.zzac(6);
              i44 = i57;
              if ((i44 != 0) && (i44 != 1))
                break label2188;
              i45 = localzzst5.readUnsignedShort();
              localzzst5.zzac(6);
              i46 = localzzst5.zzgf();
              if (i44 == 1)
                localzzst5.zzac(16);
              i47 = localzzst5.getPosition();
              if (i27 == zzoj.zzali)
              {
                i27 = zza(localzzst5, i25, i26, localzzop, i18);
                localzzst5.setPosition(i47);
              }
              if (i27 != zzoj.zzakf)
                break label2232;
              str4 = "audio/ac3";
            }
          }
        }
      while (true)
      {
        Object localObject2 = str4;
        int i48 = i46;
        int i49 = i45;
        byte[] arrayOfByte2 = null;
        int i50 = i47;
        int i52;
        boolean bool8;
        label2035: int i53;
        int i55;
        Object localObject3;
        if (i50 - i25 < i26)
        {
          localzzst5.setPosition(i50);
          i52 = localzzst5.readInt();
          if (i52 > 0)
          {
            bool8 = true;
            zzsk.checkArgument(bool8, "childAtomSize should be positive");
            i53 = localzzst5.readInt();
            if ((i53 != zzoj.zzakc) && ((!paramBoolean) || (i53 != zzoj.zzbco)))
              break label2484;
            if (i53 != zzoj.zzakc)
              break label2398;
            i55 = i50;
            if (i55 == -1)
              break label3280;
            Pair localPair4 = zzb(localzzst5, i55);
            localObject3 = (String)localPair4.first;
            arrayOfByte2 = (byte[])localPair4.second;
            if ("audio/mp4a-latm".equals(localObject3))
            {
              Pair localPair5 = zzsl.zzf(arrayOfByte2);
              i48 = ((Integer)localPair5.first).intValue();
              i49 = ((Integer)localPair5.second).intValue();
            }
          }
        }
        while (true)
        {
          localObject2 = localObject3;
          while (true)
          {
            i50 += i52;
            break label2003;
            localzzst5.zzac(8);
            i44 = 0;
            break label1889;
            if (i44 != 2)
              break;
            localzzst5.zzac(16);
            i46 = (int)Math.round(Double.longBitsToDouble(localzzst5.readLong()));
            i45 = localzzst5.zzgg();
            localzzst5.zzac(20);
            break label1934;
            if (i27 == zzoj.zzakh)
            {
              str4 = "audio/eac3";
              break label1984;
            }
            if (i27 == zzoj.zzbcr)
            {
              str4 = "audio/vnd.dts";
              break label1984;
            }
            if ((i27 == zzoj.zzbcs) || (i27 == zzoj.zzbct))
            {
              str4 = "audio/vnd.dts.hd";
              break label1984;
            }
            if (i27 == zzoj.zzbcu)
            {
              str4 = "audio/vnd.dts.hd;profile=lbr";
              break label1984;
            }
            if (i27 == zzoj.zzbdi)
            {
              str4 = "audio/3gpp";
              break label1984;
            }
            if (i27 == zzoj.zzbdj)
            {
              str4 = "audio/amr-wb";
              break label1984;
            }
            if ((i27 == zzoj.zzbcp) || (i27 == zzoj.zzbcq))
            {
              str4 = "audio/raw";
              break label1984;
            }
            if (i27 == zzoj.zzbcn)
            {
              str4 = "audio/mpeg";
              break label1984;
            }
            if (i27 != zzoj.zzbdy)
              break label3287;
            str4 = "audio/alac";
            break label1984;
            bool8 = false;
            break label2035;
            label2398: int i54 = localzzst5.getPosition();
            while (true)
            {
              if (i54 - i50 >= i52)
                break label2478;
              localzzst5.setPosition(i54);
              int i56 = localzzst5.readInt();
              if (i56 > 0);
              for (boolean bool9 = true; ; bool9 = false)
              {
                zzsk.checkArgument(bool9, "childAtomSize should be positive");
                if (localzzst5.readInt() != zzoj.zzakc)
                  break label2468;
                i55 = i54;
                break;
              }
              i54 += i56;
            }
            i55 = -1;
            break label2082;
            if (i53 == zzoj.zzakg)
            {
              localzzst5.setPosition(i50 + 8);
              localzzop.zzaue = zzlv.zza(localzzst5, Integer.toString(i15), str2, null);
            }
            else if (i53 == zzoj.zzaki)
            {
              localzzst5.setPosition(i50 + 8);
              localzzop.zzaue = zzlv.zzb(localzzst5, Integer.toString(i15), str2, null);
            }
            else if (i53 == zzoj.zzbcv)
            {
              localzzop.zzaue = zzlh.zza(Integer.toString(i15), (String)localObject2, null, -1, -1, i49, i48, null, null, 0, str2);
            }
            else if (i53 == zzoj.zzbdy)
            {
              arrayOfByte2 = new byte[i52];
              localzzst5.setPosition(i50);
              localzzst5.zzb(arrayOfByte2, 0, i52);
            }
          }
          if ((localzzop.zzaue != null) || (localObject2 == null))
            break;
          int i51;
          label2661: String str5;
          if ("audio/raw".equals(localObject2))
          {
            i51 = 2;
            str5 = Integer.toString(i15);
            if (arrayOfByte2 != null)
              break label2712;
          }
          for (List localList2 = null; ; localList2 = Collections.singletonList(arrayOfByte2))
          {
            localzzop.zzaue = zzlh.zza(str5, (String)localObject2, null, -1, -1, i49, i48, i51, localList2, null, 0, str2);
            break;
            i51 = -1;
            break label2661;
          }
          if ((i27 == zzoj.zzalo) || (i27 == zzoj.zzbde) || (i27 == zzoj.zzbdf) || (i27 == zzoj.zzbdg) || (i27 == zzoj.zzbdh))
          {
            localzzst5.setPosition(8 + (i25 + 8));
            List localList3 = null;
            long l9 = 9223372036854775807L;
            String str6;
            if (i27 == zzoj.zzalo)
              str6 = "application/ttml+xml";
            while (true)
            {
              localzzop.zzaue = zzlh.zza(Integer.toString(i15), str6, null, -1, 0, str2, -1, null, l9, localList3);
              break;
              if (i27 == zzoj.zzbde)
              {
                str6 = "application/x-quicktime-tx3g";
                int i58 = -8 + (i26 - 8);
                byte[] arrayOfByte3 = new byte[i58];
                localzzst5.zzb(arrayOfByte3, 0, i58);
                localList3 = Collections.singletonList(arrayOfByte3);
              }
              else if (i27 == zzoj.zzbdf)
              {
                str6 = "application/x-mp4-vtt";
                localList3 = null;
              }
              else if (i27 == zzoj.zzbdg)
              {
                str6 = "application/ttml+xml";
                l9 = 0L;
                localList3 = null;
              }
              else
              {
                if (i27 != zzoj.zzbdh)
                  break label2940;
                str6 = "application/x-mp4-cea-608";
                localzzop.zzbep = 1;
                localList3 = null;
              }
            }
            label2940: throw new IllegalStateException();
          }
          if (i27 != zzoj.zzbdx)
            break;
          localzzop.zzaue = zzlh.zza(Integer.toString(i15), "application/x-camera-motion", null, -1, null);
          break;
          zzok localzzok3 = paramzzok.zzaz(zzoj.zzbcy);
          zzol localzzol;
          if (localzzok3 != null)
          {
            localzzol = localzzok3.zzay(zzoj.zzbcz);
            if (localzzol != null)
              break label3024;
          }
          long[] arrayOfLong3;
          long[] arrayOfLong4;
          for (Pair localPair2 = Pair.create(null, null); localzzop.zzaue == null; localPair2 = Pair.create(arrayOfLong3, arrayOfLong4))
          {
            return null;
            zzst localzzst6 = localzzol.zzbea;
            localzzst6.setPosition(8);
            int i22 = zzoj.zzt(localzzst6.readInt());
            int i23 = localzzst6.zzgg();
            arrayOfLong3 = new long[i23];
            arrayOfLong4 = new long[i23];
            for (int i24 = 0; i24 < i23; i24++)
            {
              long l7;
              if (i22 == 1)
              {
                l7 = localzzst6.zzgh();
                arrayOfLong3[i24] = l7;
                if (i22 != 1)
                  break label3147;
              }
              for (long l8 = localzzst6.readLong(); ; l8 = localzzst6.readInt())
              {
                arrayOfLong4[i24] = l8;
                if (localzzst6.readShort() == 1)
                  break label3158;
                throw new IllegalArgumentException("Unsupported media rate.");
                l7 = localzzst6.zzge();
                break;
              }
              localzzst6.zzac(2);
            }
          }
          int i19 = zzos.zzb(localzzos);
          long l6 = ((Long)localPair1.first).longValue();
          zzlh localzzlh = localzzop.zzaue;
          int i20 = localzzop.zzbep;
          zzpb[] arrayOfzzpb = localzzop.zzbeo;
          int i21 = localzzop.zzamf;
          long[] arrayOfLong1 = (long[])localPair2.first;
          long[] arrayOfLong2 = (long[])localPair2.second;
          return new zzpa(i19, j, l6, l3, l4, localzzlh, i20, arrayOfzzpb, i21, arrayOfLong1, arrayOfLong2);
          localObject3 = localObject2;
        }
        str4 = null;
      }
    }
  }

  public static zzpc zza(zzpa paramzzpa, zzok paramzzok, zznr paramzznr)
    throws zzlm
  {
    zzol localzzol1 = paramzzok.zzay(zzoj.zzalw);
    if (localzzol1 != null);
    int i;
    zzol localzzol5;
    for (Object localObject = new zzoq(localzzol1); ; localObject = new zzor(localzzol5))
    {
      i = ((zzoo)localObject).zzim();
      if (i != 0)
        break;
      return new zzpc(new long[0], new int[0], 0, new long[0], new int[0]);
      localzzol5 = paramzzok.zzay(zzoj.zzbdd);
      if (localzzol5 == null)
        throw new zzlm("Track has no sample table size information");
    }
    zzol localzzol2 = paramzzok.zzay(zzoj.zzalx);
    boolean bool1 = false;
    if (localzzol2 == null)
    {
      bool1 = true;
      localzzol2 = paramzzok.zzay(zzoj.zzaly);
    }
    zzst localzzst1 = localzzol2.zzbea;
    zzst localzzst2 = paramzzok.zzay(zzoj.zzalv).zzbea;
    zzst localzzst3 = paramzzok.zzay(zzoj.zzals).zzbea;
    zzol localzzol3 = paramzzok.zzay(zzoj.zzalt);
    zzst localzzst4;
    zzst localzzst5;
    label198: zzon localzzon;
    int j;
    int k;
    int m;
    int n;
    int i74;
    int i1;
    zzst localzzst6;
    int i2;
    if (localzzol3 != null)
    {
      localzzst4 = localzzol3.zzbea;
      zzol localzzol4 = paramzzok.zzay(zzoj.zzalu);
      if (localzzol4 == null)
        break label487;
      localzzst5 = localzzol4.zzbea;
      localzzon = new zzon(localzzst2, localzzst1, bool1);
      localzzst3.setPosition(12);
      j = -1 + localzzst3.zzgg();
      k = localzzst3.zzgg();
      m = localzzst3.zzgg();
      n = 0;
      if (localzzst5 != null)
      {
        localzzst5.setPosition(12);
        n = localzzst5.zzgg();
      }
      if (localzzst4 == null)
        break label2300;
      localzzst4.setPosition(12);
      i74 = localzzst4.zzgg();
      if (i74 <= 0)
        break label493;
      i1 = -1 + localzzst4.zzgg();
      localzzst6 = localzzst4;
      i2 = i74;
    }
    while (true)
    {
      label306: if ((((zzoo)localObject).zzio()) && ("audio/raw".equals(paramzzpa.zzaue.zzatq)) && (j == 0) && (n == 0) && (i2 == 0));
      int i4;
      long[] arrayOfLong8;
      int[] arrayOfInt8;
      long[] arrayOfLong9;
      int[] arrayOfInt9;
      long l17;
      int i53;
      int i54;
      int i55;
      int i56;
      int i58;
      long l18;
      int i60;
      int i61;
      int i62;
      int i63;
      long l19;
      int i65;
      for (int i3 = 1; ; i3 = 0)
      {
        i4 = 0;
        if (i3 != 0)
          break label966;
        arrayOfLong8 = new long[i];
        arrayOfInt8 = new int[i];
        arrayOfLong9 = new long[i];
        arrayOfInt9 = new int[i];
        l17 = 0L;
        i53 = 0;
        i54 = 0;
        i55 = k;
        i56 = 0;
        i57 = i2;
        i58 = 0;
        int i59 = n;
        l18 = 0L;
        i60 = m;
        i61 = j;
        i62 = i1;
        i63 = i59;
        if (i54 >= i)
          break label739;
        l19 = l17;
        int i73;
        for (i65 = i53; i65 == 0; i65 = i73)
        {
          zzsk.checkState(localzzon.zzil());
          long l22 = localzzon.zzajx;
          i73 = localzzon.zzbei;
          l19 = l22;
        }
        localzzst4 = null;
        break;
        label487: localzzst5 = null;
        break label198;
        label493: i1 = -1;
        i2 = i74;
        localzzst6 = null;
        break label306;
      }
      if (localzzst5 != null)
      {
        while ((i56 == 0) && (i63 > 0))
        {
          i56 = localzzst5.zzgg();
          i58 = localzzst5.readInt();
          i63--;
        }
        i56--;
      }
      arrayOfLong8[i54] = l19;
      arrayOfInt8[i54] = ((zzoo)localObject).zzin();
      if (arrayOfInt8[i54] > i4)
        i4 = arrayOfInt8[i54];
      arrayOfLong9[i54] = (l18 + i58);
      int i66;
      label605: int i72;
      if (localzzst6 == null)
      {
        i66 = 1;
        arrayOfInt9[i54] = i66;
        if (i54 == i62)
        {
          arrayOfInt9[i54] = 1;
          i72 = i57 - 1;
          if (i72 <= 0)
            break label2293;
          i62 = -1 + localzzst6.zzgg();
        }
      }
      label739: label752: label2293: for (int i57 = i72; ; i57 = i72)
      {
        long l20 = l18 + i60;
        int i67 = i55 - 1;
        int i69;
        int i70;
        if ((i67 == 0) && (i61 > 0))
        {
          i69 = localzzst3.zzgg();
          i70 = localzzst3.zzgg();
          i61--;
        }
        while (true)
        {
          long l21 = l19 + arrayOfInt8[i54];
          int i71 = i65 - 1;
          i54++;
          l17 = l21;
          i55 = i69;
          i60 = i70;
          i53 = i71;
          l18 = l20;
          break;
          i66 = 0;
          break label605;
          boolean bool3;
          if (i56 == 0)
          {
            bool3 = true;
            zzsk.checkArgument(bool3);
            if (i63 <= 0)
              break label797;
            if (localzzst5.zzgg() != 0)
              break label791;
          }
          for (boolean bool4 = true; ; bool4 = false)
          {
            zzsk.checkArgument(bool4);
            localzzst5.readInt();
            i63--;
            break label752;
            bool3 = false;
            break;
          }
          if ((i57 != 0) || (i55 != 0) || (i53 != 0) || (i61 != 0))
          {
            int i64 = paramzzpa.id;
            Log.w("AtomParsers", 215 + "Inconsistent stbl box for track " + i64 + ": remainingSynchronizationSamples " + i57 + ", remainingSamplesAtTimestampDelta " + i55 + ", remainingSamplesInChunk " + i53 + ", remainingTimestampDeltaChanges " + i61);
          }
          int[] arrayOfInt5 = arrayOfInt9;
          long[] arrayOfLong5 = arrayOfLong9;
          int i14 = i4;
          int[] arrayOfInt4 = arrayOfInt8;
          long[] arrayOfLong4 = arrayOfLong8;
          for (long l2 = l18; (paramzzpa.zzbgm == null) || (paramzznr.zzii()); l2 = 0L)
          {
            zzsy.zza(arrayOfLong5, 1000000L, paramzzpa.zzcs);
            return new zzpc(arrayOfLong4, arrayOfInt4, i14, arrayOfLong5, arrayOfInt5);
            long[] arrayOfLong1 = new long[localzzon.length];
            int[] arrayOfInt1 = new int[localzzon.length];
            while (localzzon.zzil())
            {
              arrayOfLong1[localzzon.index] = localzzon.zzajx;
              arrayOfInt1[localzzon.index] = localzzon.zzbei;
            }
            int i5 = ((zzoo)localObject).zzin();
            long l1 = m;
            int i6 = 8192 / i5;
            int i7 = arrayOfInt1.length;
            int i8 = 0;
            int i52;
            for (int i9 = 0; i8 < i7; i9 = i52)
            {
              i52 = i9 + zzsy.zzb(arrayOfInt1[i8], i6);
              i8++;
            }
            long[] arrayOfLong2 = new long[i9];
            int[] arrayOfInt2 = new int[i9];
            long[] arrayOfLong3 = new long[i9];
            int[] arrayOfInt3 = new int[i9];
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i47;
            for (int i13 = 0; i10 < arrayOfInt1.length; i13 = i47)
            {
              int i42 = arrayOfInt1[i10];
              long l16 = arrayOfLong1[i10];
              int i43 = i13;
              int i44 = i12;
              int i45 = i11;
              int i46 = i43;
              while (i42 > 0)
              {
                int i48 = Math.min(i6, i42);
                arrayOfLong2[i46] = l16;
                arrayOfInt2[i46] = (i5 * i48);
                int i49 = Math.max(i45, arrayOfInt2[i46]);
                arrayOfLong3[i46] = (l1 * i44);
                arrayOfInt3[i46] = 1;
                l16 += arrayOfInt2[i46];
                int i50 = i44 + i48;
                int i51 = i42 - i48;
                i46++;
                i42 = i51;
                i44 = i50;
                i45 = i49;
              }
              i10++;
              i47 = i46;
              i11 = i45;
              i12 = i44;
            }
            zzou localzzou = new zzou(arrayOfLong2, arrayOfInt2, i11, arrayOfLong3, arrayOfInt3, null);
            arrayOfLong4 = localzzou.zzahq;
            arrayOfInt4 = localzzou.zzahp;
            i14 = localzzou.zzbet;
            arrayOfLong5 = localzzou.zzbeu;
            arrayOfInt5 = localzzou.zzajr;
          }
          if ((paramzzpa.zzbgm.length == 1) && (paramzzpa.type == 1) && (arrayOfLong5.length >= 2))
          {
            long l11 = paramzzpa.zzbgn[0];
            long l12 = l11 + zzsy.zza(paramzzpa.zzbgm[0], paramzzpa.zzcs, paramzzpa.zzbgj);
            if ((arrayOfLong5[0] <= l11) && (l11 < arrayOfLong5[1]) && (arrayOfLong5[(-1 + arrayOfLong5.length)] < l12) && (l12 <= l2))
            {
              long l13 = l2 - l12;
              long l14 = zzsy.zza(l11 - arrayOfLong5[0], paramzzpa.zzaue.zzafv, paramzzpa.zzcs);
              long l15 = zzsy.zza(l13, paramzzpa.zzaue.zzafv, paramzzpa.zzcs);
              if (((l14 != 0L) || (l15 != 0L)) && (l14 <= 2147483647L) && (l15 <= 2147483647L))
              {
                paramzznr.zzaty = ((int)l14);
                paramzznr.zzatz = ((int)l15);
                zzsy.zza(arrayOfLong5, 1000000L, paramzzpa.zzcs);
                return new zzpc(arrayOfLong4, arrayOfInt4, i14, arrayOfLong5, arrayOfInt5);
              }
            }
          }
          if ((paramzzpa.zzbgm.length == 1) && (paramzzpa.zzbgm[0] == 0L))
          {
            for (int i41 = 0; i41 < arrayOfLong5.length; i41++)
              arrayOfLong5[i41] = zzsy.zza(arrayOfLong5[i41] - paramzzpa.zzbgn[0], 1000000L, paramzzpa.zzcs);
            return new zzpc(arrayOfLong4, arrayOfInt4, i14, arrayOfLong5, arrayOfInt5);
          }
          boolean bool2;
          int i15;
          int i16;
          int i17;
          int i18;
          int i37;
          int i38;
          int i40;
          int i36;
          if (paramzzpa.type == 1)
          {
            bool2 = true;
            i15 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
            if (i15 >= paramzzpa.zzbgm.length)
              break label1804;
            long l9 = paramzzpa.zzbgn[i15];
            if (l9 == -1L)
              break label2263;
            long l10 = zzsy.zza(paramzzpa.zzbgm[i15], paramzzpa.zzcs, paramzzpa.zzbgj);
            int i39 = zzsy.zzb(arrayOfLong5, l9, true, true);
            i37 = zzsy.zzb(arrayOfLong5, l10 + l9, bool2, false);
            i38 = i18 + (i37 - i39);
            if (i17 == i39)
              break label1798;
            i40 = 1;
            i36 = i16 | i40;
          }
          while (true)
          {
            i15++;
            i16 = i36;
            i17 = i37;
            i18 = i38;
            break label1673;
            bool2 = false;
            break;
            i40 = 0;
            break label1767;
            int i19;
            int i20;
            long[] arrayOfLong6;
            int[] arrayOfInt6;
            int i21;
            if (i18 != i)
            {
              i19 = 1;
              i20 = i16 | i19;
              if (i20 == 0)
                break label2106;
              arrayOfLong6 = new long[i18];
              if (i20 == 0)
                break label2113;
              arrayOfInt6 = new int[i18];
              if (i20 == 0)
                break label2120;
              i21 = 0;
              if (i20 == 0)
                break label2127;
            }
            long[] arrayOfLong7;
            int i22;
            int i23;
            long l3;
            int i24;
            long l5;
            int i34;
            for (int[] arrayOfInt7 = new int[i18]; ; arrayOfInt7 = arrayOfInt5)
            {
              arrayOfLong7 = new long[i18];
              i22 = 0;
              i23 = 0;
              l3 = 0L;
              i24 = i21;
              int i25 = paramzzpa.zzbgm.length;
              if (i22 >= i25)
                break label2167;
              long l4 = paramzzpa.zzbgn[i22];
              l5 = paramzzpa.zzbgm[i22];
              if (l4 == -1L)
                break label2252;
              long l7 = l4 + zzsy.zza(l5, paramzzpa.zzcs, paramzzpa.zzbgj);
              int i31 = zzsy.zzb(arrayOfLong5, l4, true, true);
              int i32 = zzsy.zzb(arrayOfLong5, l7, bool2, false);
              if (i20 != 0)
              {
                int i35 = i32 - i31;
                System.arraycopy(arrayOfLong4, i31, arrayOfLong6, i23, i35);
                System.arraycopy(arrayOfInt4, i31, arrayOfInt6, i23, i35);
                System.arraycopy(arrayOfInt5, i31, arrayOfInt7, i23, i35);
              }
              int i33 = i31;
              i34 = i23;
              while (i33 < i32)
              {
                long l8 = paramzzpa.zzbgj;
                arrayOfLong7[i34] = (zzsy.zza(l3, 1000000L, l8) + zzsy.zza(arrayOfLong5[i33] - l4, 1000000L, paramzzpa.zzcs));
                if ((i20 != 0) && (arrayOfInt6[i34] > i24))
                  i24 = arrayOfInt4[i33];
                i34++;
                i33++;
              }
              i19 = 0;
              break;
              arrayOfLong6 = arrayOfLong4;
              break label1832;
              arrayOfInt6 = arrayOfInt4;
              break label1843;
              i21 = i14;
              break label1851;
            }
            int i29 = i34;
            for (int i30 = i24; ; i30 = i24)
            {
              long l6 = l5 + l3;
              i22++;
              i23 = i29;
              l3 = l6;
              i24 = i30;
              break;
              label2167: int i26 = 0;
              int i27 = 0;
              if ((i27 < arrayOfInt7.length) && (i26 == 0))
              {
                if ((0x1 & arrayOfInt7[i27]) != 0);
                for (int i28 = 1; ; i28 = 0)
                {
                  i26 |= i28;
                  i27++;
                  break;
                }
              }
              if (i26 == 0)
                throw new zzlm("The edited sample sequence does not contain a sync sample.");
              return new zzpc(arrayOfLong6, arrayOfInt6, i24, arrayOfLong7, arrayOfInt7);
              i29 = i23;
            }
            i36 = i16;
            i37 = i17;
            i38 = i18;
          }
          int i68 = i60;
          i69 = i67;
          i70 = i68;
        }
      }
      label791: label797: label966: label1767: label2300: i1 = -1;
      label1673: label1804: label1832: label1843: label1851: label2113: label2120: label2127: label2263: localzzst6 = localzzst4;
      label1798: label2106: label2252: i2 = 0;
    }
  }

  public static zzpo zza(zzol paramzzol, boolean paramBoolean)
  {
    if (paramBoolean);
    label182: label194: 
    while (true)
    {
      return null;
      zzst localzzst = paramzzol.zzbea;
      localzzst.setPosition(8);
      while (true)
      {
        if (localzzst.zzjz() < 8)
          break label194;
        int i = localzzst.getPosition();
        int j = localzzst.readInt();
        if (localzzst.readInt() == zzoj.zzbdl)
        {
          localzzst.setPosition(i);
          int k = i + j;
          localzzst.zzac(12);
          while (true)
          {
            if (localzzst.getPosition() >= k)
              break label182;
            int m = localzzst.getPosition();
            int n = localzzst.readInt();
            if (localzzst.readInt() == zzoj.zzbdm)
            {
              localzzst.setPosition(m);
              int i1 = m + n;
              localzzst.zzac(8);
              ArrayList localArrayList = new ArrayList();
              while (localzzst.getPosition() < i1)
              {
                zzpo.zza localzza = zzov.zzd(localzzst);
                if (localzza != null)
                  localArrayList.add(localzza);
              }
              if (localArrayList.isEmpty())
                break;
              return new zzpo(localArrayList);
            }
            localzzst.zzac(n - 8);
          }
          break;
        }
        localzzst.zzac(j - 8);
      }
    }
  }

  private static Pair<String, byte[]> zzb(zzst paramzzst, int paramInt)
  {
    paramzzst.setPosition(4 + (paramInt + 8));
    paramzzst.zzac(1);
    zzc(paramzzst);
    paramzzst.zzac(2);
    int i = paramzzst.readUnsignedByte();
    if ((i & 0x80) != 0)
      paramzzst.zzac(2);
    if ((i & 0x40) != 0)
      paramzzst.zzac(paramzzst.readUnsignedShort());
    if ((i & 0x20) != 0)
      paramzzst.zzac(2);
    paramzzst.zzac(1);
    zzc(paramzzst);
    int j = paramzzst.readUnsignedByte();
    Object localObject = null;
    switch (j)
    {
    default:
    case 107:
    case 32:
    case 33:
    case 35:
    case 64:
    case 102:
    case 103:
    case 104:
    case 165:
    case 166:
      while (true)
      {
        paramzzst.zzac(12);
        paramzzst.zzac(1);
        int k = zzc(paramzzst);
        byte[] arrayOfByte = new byte[k];
        paramzzst.zzb(arrayOfByte, 0, k);
        return Pair.create(localObject, arrayOfByte);
        return Pair.create("audio/mpeg", null);
        localObject = "video/mp4v-es";
        continue;
        localObject = "video/avc";
        continue;
        localObject = "video/hevc";
        continue;
        localObject = "audio/mp4a-latm";
        continue;
        localObject = "audio/ac3";
        continue;
        localObject = "audio/eac3";
      }
    case 169:
    case 172:
      return Pair.create("audio/vnd.dts", null);
    case 170:
    case 171:
    }
    return Pair.create("audio/vnd.dts.hd", null);
  }

  private static int zzc(zzst paramzzst)
  {
    int i = paramzzst.readUnsignedByte();
    for (int j = i & 0x7F; (i & 0x80) == 128; j = j << 7 | i & 0x7F)
      i = paramzzst.readUnsignedByte();
    return j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzom
 * JD-Core Version:    0.6.2
 */