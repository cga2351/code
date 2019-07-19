package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

final class g
{
  private static final int A = ag.g("sosn");
  private static final int B = ag.g("tvsh");
  private static final int C = ag.g("----");
  private static final String[] D = { "Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop" };
  private static final int a = ag.g("nam");
  private static final int b = ag.g("trk");
  private static final int c = ag.g("cmt");
  private static final int d = ag.g("day");
  private static final int e = ag.g("ART");
  private static final int f = ag.g("too");
  private static final int g = ag.g("alb");
  private static final int h = ag.g("com");
  private static final int i = ag.g("wrt");
  private static final int j = ag.g("lyr");
  private static final int k = ag.g("gen");
  private static final int l = ag.g("covr");
  private static final int m = ag.g("gnre");
  private static final int n = ag.g("grp");
  private static final int o = ag.g("disk");
  private static final int p = ag.g("trkn");
  private static final int q = ag.g("tmpo");
  private static final int r = ag.g("cpil");
  private static final int s = ag.g("aART");
  private static final int t = ag.g("sonm");
  private static final int u = ag.g("soal");
  private static final int v = ag.g("soar");
  private static final int w = ag.g("soaa");
  private static final int x = ag.g("soco");
  private static final int y = ag.g("rtng");
  private static final int z = ag.g("pgap");

  public static Format a(int paramInt, Format paramFormat, Metadata paramMetadata1, Metadata paramMetadata2, k paramk)
  {
    if (paramInt == 1)
    {
      if (paramk.a())
        paramFormat = paramFormat.copyWithGaplessInfo(paramk.a, paramk.b);
      if (paramMetadata1 != null)
        paramFormat = paramFormat.copyWithMetadata(paramMetadata1);
    }
    while ((paramInt != 2) || (paramMetadata2 == null))
      return paramFormat;
    int i1 = 0;
    while (i1 < paramMetadata2.length())
    {
      Metadata.Entry localEntry = paramMetadata2.get(i1);
      MdtaMetadataEntry localMdtaMetadataEntry;
      if ((localEntry instanceof MdtaMetadataEntry))
      {
        localMdtaMetadataEntry = (MdtaMetadataEntry)localEntry;
        if ((!"com.android.capture.fps".equals(localMdtaMetadataEntry.key)) || (localMdtaMetadataEntry.typeIndicator != 23));
      }
      try
      {
        paramFormat = paramFormat.copyWithFrameRate(ByteBuffer.wrap(localMdtaMetadataEntry.value).asFloatBuffer().get());
        Format localFormat = paramFormat.copyWithMetadata(new Metadata(new Metadata.Entry[] { localMdtaMetadataEntry }));
        paramFormat = localFormat;
        i1++;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
          l.c("MetadataUtil", "Ignoring invalid framerate");
      }
    }
  }

  public static MdtaMetadataEntry a(r paramr, int paramInt, String paramString)
  {
    while (true)
    {
      int i1 = paramr.d();
      if (i1 >= paramInt)
        break;
      int i2 = paramr.p();
      if (paramr.p() == a.aG)
      {
        int i3 = paramr.p();
        int i4 = paramr.p();
        int i5 = i2 - 16;
        byte[] arrayOfByte = new byte[i5];
        paramr.a(arrayOfByte, 0, i5);
        return new MdtaMetadataEntry(paramString, arrayOfByte, i4, i3);
      }
      paramr.c(i1 + i2);
    }
    return null;
  }

  public static Metadata.Entry a(r paramr)
  {
    int i1 = paramr.d() + paramr.p();
    int i2 = paramr.p();
    int i3 = 0xFF & i2 >> 24;
    int i4;
    if ((i3 == 169) || (i3 == 253))
      i4 = 0xFFFFFF & i2;
    try
    {
      if (i4 == c)
      {
        CommentFrame localCommentFrame = a(i2, paramr);
        return localCommentFrame;
      }
      if ((i4 == a) || (i4 == b))
      {
        TextInformationFrame localTextInformationFrame1 = a(i2, "TIT2", paramr);
        return localTextInformationFrame1;
      }
      if ((i4 == h) || (i4 == i))
      {
        TextInformationFrame localTextInformationFrame2 = a(i2, "TCOM", paramr);
        return localTextInformationFrame2;
      }
      if (i4 == d)
      {
        TextInformationFrame localTextInformationFrame9 = a(i2, "TDRC", paramr);
        return localTextInformationFrame9;
      }
      if (i4 == e)
      {
        TextInformationFrame localTextInformationFrame8 = a(i2, "TPE1", paramr);
        return localTextInformationFrame8;
      }
      if (i4 == f)
      {
        TextInformationFrame localTextInformationFrame7 = a(i2, "TSSE", paramr);
        return localTextInformationFrame7;
      }
      if (i4 == g)
      {
        TextInformationFrame localTextInformationFrame6 = a(i2, "TALB", paramr);
        return localTextInformationFrame6;
      }
      if (i4 == j)
      {
        TextInformationFrame localTextInformationFrame5 = a(i2, "USLT", paramr);
        return localTextInformationFrame5;
      }
      if (i4 == k)
      {
        TextInformationFrame localTextInformationFrame4 = a(i2, "TCON", paramr);
        return localTextInformationFrame4;
      }
      if (i4 == n)
      {
        TextInformationFrame localTextInformationFrame3 = a(i2, "TIT1", paramr);
        return localTextInformationFrame3;
        if (i2 == m)
        {
          TextInformationFrame localTextInformationFrame20 = b(paramr);
          return localTextInformationFrame20;
        }
        if (i2 == o)
        {
          TextInformationFrame localTextInformationFrame19 = b(i2, "TPOS", paramr);
          return localTextInformationFrame19;
        }
        if (i2 == p)
        {
          TextInformationFrame localTextInformationFrame18 = b(i2, "TRCK", paramr);
          return localTextInformationFrame18;
        }
        if (i2 == q)
        {
          Id3Frame localId3Frame5 = a(i2, "TBPM", paramr, true, false);
          return localId3Frame5;
        }
        if (i2 == r)
        {
          Id3Frame localId3Frame4 = a(i2, "TCMP", paramr, true, true);
          return localId3Frame4;
        }
        if (i2 == l)
        {
          ApicFrame localApicFrame = c(paramr);
          return localApicFrame;
        }
        if (i2 == s)
        {
          TextInformationFrame localTextInformationFrame17 = a(i2, "TPE2", paramr);
          return localTextInformationFrame17;
        }
        if (i2 == t)
        {
          TextInformationFrame localTextInformationFrame16 = a(i2, "TSOT", paramr);
          return localTextInformationFrame16;
        }
        if (i2 == u)
        {
          TextInformationFrame localTextInformationFrame15 = a(i2, "TSO2", paramr);
          return localTextInformationFrame15;
        }
        if (i2 == v)
        {
          TextInformationFrame localTextInformationFrame14 = a(i2, "TSOA", paramr);
          return localTextInformationFrame14;
        }
        if (i2 == w)
        {
          TextInformationFrame localTextInformationFrame13 = a(i2, "TSOP", paramr);
          return localTextInformationFrame13;
        }
        if (i2 == x)
        {
          TextInformationFrame localTextInformationFrame12 = a(i2, "TSOC", paramr);
          return localTextInformationFrame12;
        }
        if (i2 == y)
        {
          Id3Frame localId3Frame3 = a(i2, "ITUNESADVISORY", paramr, false, false);
          return localId3Frame3;
        }
        if (i2 == z)
        {
          Id3Frame localId3Frame2 = a(i2, "ITUNESGAPLESS", paramr, false, true);
          return localId3Frame2;
        }
        if (i2 == A)
        {
          TextInformationFrame localTextInformationFrame11 = a(i2, "TVSHOWSORT", paramr);
          return localTextInformationFrame11;
        }
        if (i2 == B)
        {
          TextInformationFrame localTextInformationFrame10 = a(i2, "TVSHOW", paramr);
          return localTextInformationFrame10;
        }
        if (i2 == C)
        {
          Id3Frame localId3Frame1 = a(paramr, i1);
          return localId3Frame1;
        }
      }
      l.a("MetadataUtil", "Skipped unknown metadata entry: " + a.c(i2));
      return null;
    }
    finally
    {
      paramr.c(i1);
    }
  }

  private static CommentFrame a(int paramInt, r paramr)
  {
    int i1 = paramr.p();
    if (paramr.p() == a.aG)
    {
      paramr.d(8);
      String str = paramr.f(i1 - 16);
      return new CommentFrame("und", str, str);
    }
    l.c("MetadataUtil", "Failed to parse comment attribute: " + a.c(paramInt));
    return null;
  }

  private static Id3Frame a(int paramInt, String paramString, r paramr, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = d(paramr);
    if (paramBoolean2);
    for (int i2 = Math.min(1, i1); ; i2 = i1)
    {
      if (i2 >= 0)
      {
        if (paramBoolean1)
          return new TextInformationFrame(paramString, null, Integer.toString(i2));
        return new CommentFrame("und", paramString, Integer.toString(i2));
      }
      l.c("MetadataUtil", "Failed to parse uint8 attribute: " + a.c(paramInt));
      return null;
    }
  }

  private static Id3Frame a(r paramr, int paramInt)
  {
    int i1 = -1;
    int i2 = -1;
    String str1 = null;
    String str2 = null;
    while (paramr.d() < paramInt)
    {
      int i3 = paramr.d();
      int i4 = paramr.p();
      int i5 = paramr.p();
      paramr.d(4);
      if (i5 == a.aE)
      {
        str2 = paramr.f(i4 - 12);
      }
      else if (i5 == a.aF)
      {
        str1 = paramr.f(i4 - 12);
      }
      else
      {
        if (i5 == a.aG)
        {
          i1 = i4;
          i2 = i3;
        }
        paramr.d(i4 - 12);
      }
    }
    if ((str2 == null) || (str1 == null) || (i2 == -1))
      return null;
    paramr.c(i2);
    paramr.d(16);
    return new InternalFrame(str2, str1, paramr.f(i1 - 16));
  }

  private static TextInformationFrame a(int paramInt, String paramString, r paramr)
  {
    int i1 = paramr.p();
    if (paramr.p() == a.aG)
    {
      paramr.d(8);
      return new TextInformationFrame(paramString, null, paramr.f(i1 - 16));
    }
    l.c("MetadataUtil", "Failed to parse text attribute: " + a.c(paramInt));
    return null;
  }

  private static TextInformationFrame b(int paramInt, String paramString, r paramr)
  {
    int i1 = paramr.p();
    if ((paramr.p() == a.aG) && (i1 >= 22))
    {
      paramr.d(10);
      int i2 = paramr.i();
      if (i2 > 0)
      {
        String str = "" + i2;
        int i3 = paramr.i();
        if (i3 > 0)
          str = str + "/" + i3;
        return new TextInformationFrame(paramString, null, str);
      }
    }
    l.c("MetadataUtil", "Failed to parse index/count attribute: " + a.c(paramInt));
    return null;
  }

  private static TextInformationFrame b(r paramr)
  {
    int i1 = d(paramr);
    if ((i1 > 0) && (i1 <= D.length));
    for (String str = D[(i1 - 1)]; str != null; str = null)
      return new TextInformationFrame("TCON", null, str);
    l.c("MetadataUtil", "Failed to parse standard genre code");
    return null;
  }

  private static ApicFrame c(r paramr)
  {
    int i1 = paramr.p();
    if (paramr.p() == a.aG)
    {
      int i2 = a.b(paramr.p());
      String str;
      if (i2 == 13)
        str = "image/jpeg";
      while (str == null)
      {
        l.c("MetadataUtil", "Unrecognized cover art flags: " + i2);
        return null;
        if (i2 == 14)
          str = "image/png";
        else
          str = null;
      }
      paramr.d(4);
      byte[] arrayOfByte = new byte[i1 - 16];
      paramr.a(arrayOfByte, 0, arrayOfByte.length);
      return new ApicFrame(str, null, 3, arrayOfByte);
    }
    l.c("MetadataUtil", "Failed to parse cover art attribute");
    return null;
  }

  private static int d(r paramr)
  {
    paramr.d(4);
    if (paramr.p() == a.aG)
    {
      paramr.d(8);
      return paramr.h();
    }
    l.c("MetadataUtil", "Failed to parse uint8 attribute value");
    return -1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.g
 * JD-Core Version:    0.6.2
 */