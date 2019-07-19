package com.google.android.exoplayer2.g;

import android.text.TextUtils;
import java.util.ArrayList;

public final class o
{
  private static final ArrayList<a> a = new ArrayList();

  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 32:
      return "video/mp4v-es";
    case 33:
      return "video/avc";
    case 35:
      return "video/hevc";
    case 96:
    case 97:
    case 98:
    case 99:
    case 100:
    case 101:
      return "video/mpeg2";
    case 106:
      return "video/mpeg";
    case 105:
    case 107:
      return "audio/mpeg";
    case 163:
      return "video/wvc1";
    case 177:
      return "video/x-vnd.on2.vp9";
    case 64:
    case 102:
    case 103:
    case 104:
      return "audio/mp4a-latm";
    case 165:
      return "audio/ac3";
    case 166:
      return "audio/eac3";
    case 169:
    case 172:
      return "audio/vnd.dts";
    case 170:
    case 171:
      return "audio/vnd.dts.hd";
    case 173:
    }
    return "audio/opus";
  }

  public static boolean a(String paramString)
  {
    return "audio".equals(j(paramString));
  }

  public static boolean b(String paramString)
  {
    return "video".equals(j(paramString));
  }

  public static boolean c(String paramString)
  {
    return "text".equals(j(paramString));
  }

  public static String d(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return null;
      String[] arrayOfString = ag.i(paramString);
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = f(arrayOfString[j]);
        if ((str != null) && (b(str)))
          return str;
      }
    }
  }

  public static String e(String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return null;
      String[] arrayOfString = ag.i(paramString);
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = f(arrayOfString[j]);
        if ((str != null) && (a(str)))
          return str;
      }
    }
  }

  public static String f(String paramString)
  {
    Object localObject = null;
    if (paramString == null);
    while (true)
    {
      return localObject;
      String str1 = ag.d(paramString.trim());
      if ((str1.startsWith("avc1")) || (str1.startsWith("avc3")))
        return "video/avc";
      if ((str1.startsWith("hev1")) || (str1.startsWith("hvc1")))
        return "video/hevc";
      if ((str1.startsWith("vp9")) || (str1.startsWith("vp09")))
        return "video/x-vnd.on2.vp9";
      if ((str1.startsWith("vp8")) || (str1.startsWith("vp08")))
        return "video/x-vnd.on2.vp8";
      String str2;
      if (str1.startsWith("mp4a"))
      {
        boolean bool = str1.startsWith("mp4a.");
        localObject = null;
        if (bool)
        {
          str2 = str1.substring(5);
          int i = str2.length();
          localObject = null;
          if (i < 2);
        }
      }
      try
      {
        String str3 = a(Integer.parseInt(ag.e(str2.substring(0, 2)), 16));
        localObject = str3;
        if (localObject != null)
          continue;
        return "audio/mp4a-latm";
        if ((str1.startsWith("ac-3")) || (str1.startsWith("dac3")))
          return "audio/ac3";
        if ((str1.startsWith("ec-3")) || (str1.startsWith("dec3")))
          return "audio/eac3";
        if (str1.startsWith("ec+3"))
          return "audio/eac3-joc";
        if ((str1.startsWith("dtsc")) || (str1.startsWith("dtse")))
          return "audio/vnd.dts";
        if ((str1.startsWith("dtsh")) || (str1.startsWith("dtsl")))
          return "audio/vnd.dts.hd";
        if (str1.startsWith("opus"))
          return "audio/opus";
        if (str1.startsWith("vorbis"))
          return "audio/vorbis";
        if (str1.startsWith("flac"))
          return "audio/flac";
        return k(str1);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
          localObject = null;
      }
    }
  }

  public static int g(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return -1;
    if (a(paramString))
      return 1;
    if (b(paramString))
      return 2;
    if ((c(paramString)) || ("application/cea-608".equals(paramString)) || ("application/cea-708".equals(paramString)) || ("application/x-mp4-cea-608".equals(paramString)) || ("application/x-subrip".equals(paramString)) || ("application/ttml+xml".equals(paramString)) || ("application/x-quicktime-tx3g".equals(paramString)) || ("application/x-mp4-vtt".equals(paramString)) || ("application/x-rawcc".equals(paramString)) || ("application/vobsub".equals(paramString)) || ("application/pgs".equals(paramString)) || ("application/dvbsubs".equals(paramString)))
      return 3;
    if (("application/id3".equals(paramString)) || ("application/x-emsg".equals(paramString)) || ("application/x-scte35".equals(paramString)))
      return 4;
    if ("application/x-camera-motion".equals(paramString))
      return 5;
    return l(paramString);
  }

  public static int h(String paramString)
  {
    int i = 5;
    int j = -1;
    switch (paramString.hashCode())
    {
    default:
    case 187078296:
    case 1504578661:
    case -2123537834:
    case -1095064472:
    case 1505942594:
    case 1556697186:
    }
    while (true)
      switch (j)
      {
      default:
        i = 0;
      case 0:
        return i;
        if (paramString.equals("audio/ac3"))
        {
          j = 0;
          continue;
          if (paramString.equals("audio/eac3"))
          {
            j = 1;
            continue;
            if (paramString.equals("audio/eac3-joc"))
            {
              j = 2;
              continue;
              if (paramString.equals("audio/vnd.dts"))
              {
                j = 3;
                continue;
                if (paramString.equals("audio/vnd.dts.hd"))
                {
                  j = 4;
                  continue;
                  if (paramString.equals("audio/true-hd"))
                    j = i;
                }
              }
            }
          }
        }
        break;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    return 6;
    return 7;
    return 8;
    return 14;
  }

  public static int i(String paramString)
  {
    return g(f(paramString));
  }

  private static String j(String paramString)
  {
    if (paramString == null)
      return null;
    int i = paramString.indexOf('/');
    if (i == -1)
      throw new IllegalArgumentException("Invalid mime type: " + paramString);
    return paramString.substring(0, i);
  }

  private static String k(String paramString)
  {
    int i = a.size();
    for (int j = 0; j < i; j++)
    {
      a locala = (a)a.get(j);
      if (paramString.startsWith(locala.b))
        return locala.a;
    }
    return null;
  }

  private static int l(String paramString)
  {
    int i = a.size();
    for (int j = 0; j < i; j++)
    {
      a locala = (a)a.get(j);
      if (paramString.equals(locala.a))
        return locala.c;
    }
    return -1;
  }

  private static final class a
  {
    public final String a;
    public final String b;
    public final int c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.o
 * JD-Core Version:    0.6.2
 */