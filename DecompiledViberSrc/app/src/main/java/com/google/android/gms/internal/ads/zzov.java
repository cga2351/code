package com.google.android.gms.internal.ads;

import android.util.Log;

final class zzov
{
  private static final int zzbev = zzsy.zzay("nam");
  private static final int zzbew = zzsy.zzay("trk");
  private static final int zzbex = zzsy.zzay("cmt");
  private static final int zzbey = zzsy.zzay("day");
  private static final int zzbez = zzsy.zzay("ART");
  private static final int zzbfa = zzsy.zzay("too");
  private static final int zzbfb = zzsy.zzay("alb");
  private static final int zzbfc = zzsy.zzay("com");
  private static final int zzbfd = zzsy.zzay("wrt");
  private static final int zzbfe = zzsy.zzay("lyr");
  private static final int zzbff = zzsy.zzay("gen");
  private static final int zzbfg = zzsy.zzay("covr");
  private static final int zzbfh = zzsy.zzay("gnre");
  private static final int zzbfi = zzsy.zzay("grp");
  private static final int zzbfj = zzsy.zzay("disk");
  private static final int zzbfk = zzsy.zzay("trkn");
  private static final int zzbfl = zzsy.zzay("tmpo");
  private static final int zzbfm = zzsy.zzay("cpil");
  private static final int zzbfn = zzsy.zzay("aART");
  private static final int zzbfo = zzsy.zzay("sonm");
  private static final int zzbfp = zzsy.zzay("soal");
  private static final int zzbfq = zzsy.zzay("soar");
  private static final int zzbfr = zzsy.zzay("soaa");
  private static final int zzbfs = zzsy.zzay("soco");
  private static final int zzbft = zzsy.zzay("rtng");
  private static final int zzbfu = zzsy.zzay("pgap");
  private static final int zzbfv = zzsy.zzay("sosn");
  private static final int zzbfw = zzsy.zzay("tvsh");
  private static final int zzbfx = zzsy.zzay("----");
  private static final String[] zzbfy = { "Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop" };

  private static zzpv zza(int paramInt, String paramString, zzst paramzzst, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = zze(paramzzst);
    if (paramBoolean2);
    for (int j = Math.min(1, i); ; j = i)
    {
      if (j >= 0)
      {
        if (paramBoolean1)
          return new zzpw(paramString, null, Integer.toString(j));
        return new zzps("und", paramString, Integer.toString(j));
      }
      String str1 = String.valueOf(zzoj.zzu(paramInt));
      if (str1.length() != 0);
      for (String str2 = "Failed to parse uint8 attribute: ".concat(str1); ; str2 = new String("Failed to parse uint8 attribute: "))
      {
        Log.w("MetadataUtil", str2);
        return null;
      }
    }
  }

  private static zzpw zza(int paramInt, String paramString, zzst paramzzst)
  {
    int i = paramzzst.readInt();
    if (paramzzst.readInt() == zzoj.zzbdp)
    {
      paramzzst.zzac(8);
      return new zzpw(paramString, null, paramzzst.zzbp(i - 16));
    }
    String str1 = String.valueOf(zzoj.zzu(paramInt));
    if (str1.length() != 0);
    for (String str2 = "Failed to parse text attribute: ".concat(str1); ; str2 = new String("Failed to parse text attribute: "))
    {
      Log.w("MetadataUtil", str2);
      return null;
    }
  }

  private static zzpw zzb(int paramInt, String paramString, zzst paramzzst)
  {
    int i = paramzzst.readInt();
    if ((paramzzst.readInt() == zzoj.zzbdp) && (i >= 22))
    {
      paramzzst.zzac(10);
      int j = paramzzst.readUnsignedShort();
      if (j > 0)
      {
        String str3 = 11 + j;
        int k = paramzzst.readUnsignedShort();
        if (k > 0)
        {
          String str4 = String.valueOf(str3);
          str3 = 12 + String.valueOf(str4).length() + str4 + "/" + k;
        }
        return new zzpw(paramString, null, str3);
      }
    }
    String str1 = String.valueOf(zzoj.zzu(paramInt));
    if (str1.length() != 0);
    for (String str2 = "Failed to parse index/count attribute: ".concat(str1); ; str2 = new String("Failed to parse index/count attribute: "))
    {
      Log.w("MetadataUtil", str2);
      return null;
    }
  }

  public static zzpo.zza zzd(zzst paramzzst)
  {
    Object localObject1 = null;
    int i = paramzzst.getPosition() + paramzzst.readInt();
    int j = paramzzst.readInt();
    int k = j >>> 24;
    label499: int i6;
    int i7;
    String str8;
    if ((k == 169) || (k == 65533))
    {
      int m = 0xFFFFFF & j;
      while (true)
      {
        try
        {
          if (m != zzbex)
            break;
          int n = paramzzst.readInt();
          zzps localzzps;
          if (paramzzst.readInt() == zzoj.zzbdp)
          {
            paramzzst.zzac(8);
            String str5 = paramzzst.zzbp(n - 16);
            localzzps = new zzps("und", str5, str5);
            return localzzps;
          }
          String str3 = String.valueOf(zzoj.zzu(j));
          if (str3.length() != 0)
          {
            str4 = "Failed to parse comment attribute: ".concat(str3);
            Log.w("MetadataUtil", str4);
            localzzps = null;
            continue;
          }
        }
        finally
        {
          paramzzst.setPosition(i);
        }
        String str4 = new String("Failed to parse comment attribute: ");
      }
      if ((m == zzbev) || (m == zzbew))
      {
        zzpw localzzpw1 = zza(j, "TIT2", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw1;
      }
      if ((m == zzbfc) || (m == zzbfd))
      {
        zzpw localzzpw2 = zza(j, "TCOM", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw2;
      }
      if (m == zzbey)
      {
        zzpw localzzpw9 = zza(j, "TDRC", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw9;
      }
      if (m == zzbez)
      {
        zzpw localzzpw8 = zza(j, "TPE1", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw8;
      }
      if (m == zzbfa)
      {
        zzpw localzzpw7 = zza(j, "TSSE", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw7;
      }
      if (m == zzbfb)
      {
        zzpw localzzpw6 = zza(j, "TALB", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw6;
      }
      if (m == zzbfe)
      {
        zzpw localzzpw5 = zza(j, "USLT", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw5;
      }
      if (m == zzbff)
      {
        zzpw localzzpw4 = zza(j, "TCON", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw4;
      }
      if (m == zzbfi)
      {
        zzpw localzzpw3 = zza(j, "TIT1", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw3;
      }
    }
    else
    {
      if (j == zzbfh)
      {
        int i8 = zze(paramzzst);
        String str9;
        if ((i8 > 0) && (i8 <= zzbfy.length))
        {
          str9 = zzbfy[(i8 - 1)];
          if (str9 == null)
            break label499;
        }
        for (zzpw localzzpw20 = new zzpw("TCON", null, str9); ; localzzpw20 = null)
        {
          paramzzst.setPosition(i);
          return localzzpw20;
          str9 = null;
          break;
          Log.w("MetadataUtil", "Failed to parse standard genre code");
        }
      }
      if (j == zzbfj)
      {
        zzpw localzzpw19 = zzb(j, "TPOS", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw19;
      }
      if (j == zzbfk)
      {
        zzpw localzzpw18 = zzb(j, "TRCK", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw18;
      }
      if (j == zzbfl)
      {
        zzpv localzzpv4 = zza(j, "TBPM", paramzzst, true, false);
        paramzzst.setPosition(i);
        return localzzpv4;
      }
      if (j == zzbfm)
      {
        zzpv localzzpv3 = zza(j, "TCMP", paramzzst, true, true);
        paramzzst.setPosition(i);
        return localzzpv3;
      }
      if (j == zzbfg)
      {
        i6 = paramzzst.readInt();
        if (paramzzst.readInt() == zzoj.zzbdp)
        {
          i7 = zzoj.zzax(paramzzst.readInt());
          if (i7 == 13)
            str8 = "image/jpeg";
        }
      }
    }
    while (true)
    {
      if (str8 == null)
        Log.w("MetadataUtil", 41 + "Unrecognized cover art flags: " + i7);
      while (true)
      {
        paramzzst.setPosition(i);
        return localObject1;
        if (i7 != 14)
          break label1308;
        str8 = "image/png";
        break;
        paramzzst.zzac(4);
        byte[] arrayOfByte = new byte[i6 - 16];
        paramzzst.zzb(arrayOfByte, 0, arrayOfByte.length);
        localObject1 = new zzpq(str8, null, 3, arrayOfByte);
        continue;
        Log.w("MetadataUtil", "Failed to parse cover art attribute");
        localObject1 = null;
      }
      if (j == zzbfn)
      {
        zzpw localzzpw17 = zza(j, "TPE2", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw17;
      }
      if (j == zzbfo)
      {
        zzpw localzzpw16 = zza(j, "TSOT", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw16;
      }
      if (j == zzbfp)
      {
        zzpw localzzpw15 = zza(j, "TSO2", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw15;
      }
      if (j == zzbfq)
      {
        zzpw localzzpw14 = zza(j, "TSOA", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw14;
      }
      if (j == zzbfr)
      {
        zzpw localzzpw13 = zza(j, "TSOP", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw13;
      }
      if (j == zzbfs)
      {
        zzpw localzzpw12 = zza(j, "TSOC", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw12;
      }
      if (j == zzbft)
      {
        zzpv localzzpv2 = zza(j, "ITUNESADVISORY", paramzzst, false, false);
        paramzzst.setPosition(i);
        return localzzpv2;
      }
      if (j == zzbfu)
      {
        zzpv localzzpv1 = zza(j, "ITUNESGAPLESS", paramzzst, false, true);
        paramzzst.setPosition(i);
        return localzzpv1;
      }
      if (j == zzbfv)
      {
        zzpw localzzpw11 = zza(j, "TVSHOWSORT", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw11;
      }
      if (j == zzbfw)
      {
        zzpw localzzpw10 = zza(j, "TVSHOW", paramzzst);
        paramzzst.setPosition(i);
        return localzzpw10;
      }
      int i1;
      int i2;
      String str6;
      String str7;
      int i3;
      int i4;
      if (j == zzbfx)
      {
        i1 = -1;
        i2 = -1;
        str6 = null;
        str7 = null;
        while (paramzzst.getPosition() < i)
        {
          i3 = paramzzst.getPosition();
          i4 = paramzzst.readInt();
          int i5 = paramzzst.readInt();
          paramzzst.zzac(4);
          if (i5 == zzoj.zzbdn)
          {
            str7 = paramzzst.zzbp(i4 - 12);
          }
          else if (i5 == zzoj.zzbdo)
          {
            str6 = paramzzst.zzbp(i4 - 12);
          }
          else
          {
            if (i5 != zzoj.zzbdp)
              break label1301;
            i1 = i4;
          }
        }
      }
      while (true)
      {
        paramzzst.zzac(i4 - 12);
        i2 = i3;
        break;
        boolean bool1 = "com.apple.iTunes".equals(str7);
        Object localObject3 = null;
        if (bool1)
        {
          boolean bool2 = "iTunSMPB".equals(str6);
          localObject3 = null;
          if (bool2)
          {
            localObject3 = null;
            if (i2 != -1)
              break label1205;
          }
        }
        while (true)
        {
          paramzzst.setPosition(i);
          return localObject3;
          label1205: paramzzst.setPosition(i2);
          paramzzst.zzac(16);
          localObject3 = new zzps("und", str6, paramzzst.zzbp(i1 - 16));
        }
        String str1 = String.valueOf(zzoj.zzu(j));
        if (str1.length() != 0);
        for (String str2 = "Skipped unknown metadata entry: ".concat(str1); ; str2 = new String("Skipped unknown metadata entry: "))
        {
          Log.d("MetadataUtil", str2);
          paramzzst.setPosition(i);
          return null;
        }
        label1301: i3 = i2;
      }
      label1308: str8 = null;
    }
  }

  private static int zze(zzst paramzzst)
  {
    paramzzst.zzac(4);
    if (paramzzst.readInt() == zzoj.zzbdp)
    {
      paramzzst.zzac(8);
      return paramzzst.readUnsignedByte();
    }
    Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
    return -1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzov
 * JD-Core Version:    0.6.2
 */