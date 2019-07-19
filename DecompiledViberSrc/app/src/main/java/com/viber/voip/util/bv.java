package com.viber.voip.util;

import java.util.HashMap;
import java.util.Locale;

public class bv
{
  private static final HashMap<String, a> a = new HashMap();
  private static final HashMap<String, Integer> b = new HashMap();

  static
  {
    a("MP3", 1, "audio/mpeg");
    a("MPGA", 1, "audio/mpeg");
    a("M4A", 2, "audio/mp4");
    a("WAV", 3, "audio/x-wav");
    a("AMR", 4, "audio/amr");
    a("AWB", 5, "audio/amr-wb");
    a("WMA", 6, "audio/x-ms-wma");
    a("OGG", 7, "audio/ogg");
    a("OGG", 7, "application/ogg");
    a("OGA", 7, "application/ogg");
    a("AAC", 8, "audio/aac");
    a("AAC", 8, "audio/aac-adts");
    a("MKA", 9, "audio/x-matroska");
    a("MID", 11, "audio/midi");
    a("MIDI", 11, "audio/midi");
    a("XMF", 11, "audio/midi");
    a("RTTTL", 11, "audio/midi");
    a("SMF", 12, "audio/sp-midi");
    a("IMY", 13, "audio/imelody");
    a("RTX", 11, "audio/midi");
    a("OTA", 11, "audio/midi");
    a("MXMF", 11, "audio/midi");
    a("MPEG", 21, "video/mpeg");
    a("MPG", 21, "video/mpeg");
    a("MP4", 21, "video/mp4");
    a("M4V", 22, "video/mp4");
    a("3GP", 23, "video/3gpp");
    a("3GPP", 23, "video/3gpp");
    a("3G2", 24, "video/3gpp2");
    a("3GPP2", 24, "video/3gpp2");
    a("MKV", 27, "video/x-matroska");
    a("WEBM", 30, "video/webm");
    a("TS", 28, "video/mp2ts");
    a("AVI", 29, "video/avi");
    a("WMV", 25, "video/x-ms-wmv");
    a("ASF", 26, "video/x-ms-asf");
    a("JPG", 31, "image/jpeg");
    a("JPEG", 31, "image/jpeg");
    a("GIF", 32, "image/gif");
    a("PNG", 33, "image/png");
    a("BMP", 34, "image/x-ms-bmp");
    a("WBMP", 35, "image/vnd.wap.wbmp");
    a("WEBP", 36, "image/webp");
    a("M3U", 41, "audio/x-mpegurl");
    a("M3U", 41, "application/x-mpegurl");
    a("PLS", 42, "audio/x-scpls");
    a("WPL", 43, "application/vnd.ms-wpl");
    a("M3U8", 44, "application/vnd.apple.mpegurl");
    a("M3U8", 44, "audio/mpegurl");
    a("M3U8", 44, "audio/x-mpegurl");
    a("FL", 51, "application/x-android-drm-fl");
    a("TXT", 100, "text/plain");
    a("HTM", 101, "text/html");
    a("HTML", 101, "text/html");
    a("PDF", 102, "application/pdf");
    a("DOC", 104, "application/msword");
    a("XLS", 105, "application/vnd.ms-excel");
    a("PPT", 106, "application/mspowerpoint");
    a("FLAC", 10, "audio/flac");
    a("ZIP", 107, "application/zip");
    a("MPG", 200, "video/mp2p");
    a("MPEG", 200, "video/mp2p");
  }

  static void a(String paramString1, int paramInt, String paramString2)
  {
    a.put(paramString1, new a(paramString1, paramInt, paramString2));
    b.put(paramString2, Integer.valueOf(paramInt));
  }

  public static boolean a(int paramInt)
  {
    return (paramInt >= 31) && (paramInt <= 36);
  }

  public static boolean a(String paramString)
  {
    return (b.get(paramString) != null) && (a(((Integer)b.get(paramString)).intValue()));
  }

  public static boolean b(String paramString)
  {
    String str = c(paramString);
    return (str != null) && (str.startsWith("GIF"));
  }

  public static String c(String paramString)
  {
    if (paramString == null);
    String str;
    do
    {
      int i;
      do
      {
        return null;
        i = paramString.lastIndexOf('.');
      }
      while (i < 0);
      str = paramString.substring(i + 1).toUpperCase(Locale.ROOT);
    }
    while (da.a(str));
    return str;
  }

  public static boolean d(String paramString)
  {
    return 107 == e(paramString);
  }

  public static int e(String paramString)
  {
    Integer localInteger = (Integer)b.get(paramString);
    if (localInteger == null)
      return 0;
    return localInteger.intValue();
  }

  public static class a
  {
    public final String a;
    public final int b;
    public final String c;

    a(String paramString1, int paramInt, String paramString2)
    {
      this.a = paramString1;
      this.b = paramInt;
      this.c = paramString2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bv
 * JD-Core Version:    0.6.2
 */