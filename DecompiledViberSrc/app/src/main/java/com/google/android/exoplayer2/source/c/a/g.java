package com.google.android.exoplayer2.source.c.a;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.extractor.mp4.j;
import com.google.android.exoplayer2.f.aa.a;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.o;
import com.google.android.exoplayer2.source.ac;
import com.google.android.exoplayer2.w;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g
  implements aa.a<f>
{
  private static final Pattern A = b("DEFAULT");
  private static final Pattern B = b("FORCED");
  private static final Pattern C = Pattern.compile("VALUE=\"(.+?)\"");
  private static final Pattern D = Pattern.compile("IMPORT=\"(.+?)\"");
  private static final Pattern E = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
  private static final Pattern a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
  private static final Pattern b = Pattern.compile("AUDIO=\"(.+?)\"");
  private static final Pattern c = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
  private static final Pattern d = Pattern.compile("CODECS=\"(.+?)\"");
  private static final Pattern e = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
  private static final Pattern f = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
  private static final Pattern g = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
  private static final Pattern h = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
  private static final Pattern i = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
  private static final Pattern j = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
  private static final Pattern k = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
  private static final Pattern l = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
  private static final Pattern m = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
  private static final Pattern n = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
  private static final Pattern o = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
  private static final Pattern p = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
  private static final Pattern q = Pattern.compile("KEYFORMAT=\"(.+?)\"");
  private static final Pattern r = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
  private static final Pattern s = Pattern.compile("URI=\"(.+?)\"");
  private static final Pattern t = Pattern.compile("IV=([^,.*]+)");
  private static final Pattern u = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
  private static final Pattern v = Pattern.compile("LANGUAGE=\"(.+?)\"");
  private static final Pattern w = Pattern.compile("NAME=\"(.+?)\"");
  private static final Pattern x = Pattern.compile("GROUP-ID=\"(.+?)\"");
  private static final Pattern y = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
  private static final Pattern z = b("AUTOSELECT");
  private final d F;

  public g()
  {
    this(d.a);
  }

  public g(d paramd)
  {
    this.F = paramd;
  }

  private static int a(BufferedReader paramBufferedReader, boolean paramBoolean, int paramInt)
    throws IOException
  {
    while ((paramInt != -1) && (Character.isWhitespace(paramInt)) && ((paramBoolean) || (!ag.a(paramInt))))
      paramInt = paramBufferedReader.read();
    return paramInt;
  }

  private static int a(String paramString)
  {
    if (a(paramString, A, false));
    for (int i1 = 1; ; i1 = 0)
    {
      if (a(paramString, B, false))
        i1 |= 2;
      if (a(paramString, z, false))
        i1 |= 4;
      return i1;
    }
  }

  private static int a(String paramString, Pattern paramPattern)
    throws w
  {
    return Integer.parseInt(a(paramString, paramPattern, Collections.emptyMap()));
  }

  private static DrmInitData.SchemeData a(String paramString1, String paramString2, Map<String, String> paramMap)
    throws w
  {
    if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(paramString2))
    {
      String str = a(paramString1, s, paramMap);
      return new DrmInitData.SchemeData(c.d, "video/mp4", Base64.decode(str.substring(str.indexOf(',')), 0));
    }
    if ("com.widevine".equals(paramString2))
      try
      {
        DrmInitData.SchemeData localSchemeData = new DrmInitData.SchemeData(c.d, "hls", paramString1.getBytes("UTF-8"));
        return localSchemeData;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new w(localUnsupportedEncodingException);
      }
    return null;
  }

  private static DrmInitData.SchemeData a(String paramString, Map<String, String> paramMap)
    throws w
  {
    if (!"1".equals(a(paramString, r, "1", paramMap)))
      return null;
    String str = a(paramString, s, paramMap);
    byte[] arrayOfByte1 = Base64.decode(str.substring(str.indexOf(',')), 0);
    byte[] arrayOfByte2 = j.a(c.e, arrayOfByte1);
    return new DrmInitData.SchemeData(c.e, "video/mp4", arrayOfByte2);
  }

  private static d a(a parama, String paramString)
    throws IOException
  {
    HashSet localHashSet = new HashSet();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    while (parama.a())
    {
      String str12 = parama.b();
      if (str12.startsWith("#EXT"))
        localArrayList5.add(str12);
      if (str12.startsWith("#EXT-X-DEFINE"))
      {
        localHashMap2.put(a(str12, w, localHashMap2), a(str12, C, localHashMap2));
      }
      else if (str12.equals("#EXT-X-INDEPENDENT-SEGMENTS"))
      {
        bool1 = true;
      }
      else if (str12.startsWith("#EXT-X-MEDIA"))
      {
        localArrayList4.add(str12);
      }
      else if (str12.startsWith("#EXT-X-STREAM-INF"))
      {
        bool2 |= str12.contains("CLOSED-CAPTIONS=NONE");
        int i6 = a(str12, c);
        String str13 = b(str12, a, localHashMap2);
        if (str13 != null)
          i6 = Integer.parseInt(str13);
        String str14 = b(str12, d, localHashMap2);
        String str15 = b(str12, e, localHashMap2);
        int i8;
        int i7;
        if (str15 != null)
        {
          String[] arrayOfString = str15.split("x");
          int i9 = Integer.parseInt(arrayOfString[0]);
          int i10 = Integer.parseInt(arrayOfString[1]);
          if ((i9 <= 0) || (i10 <= 0))
          {
            i9 = -1;
            i10 = -1;
          }
          i8 = i10;
          i7 = i9;
        }
        while (true)
        {
          float f1 = -1.0F;
          String str16 = b(str12, f, localHashMap2);
          if (str16 != null)
            f1 = Float.parseFloat(str16);
          String str17 = b(str12, b, localHashMap2);
          if ((str17 != null) && (str14 != null))
            localHashMap1.put(str17, ag.a(str14, 1));
          String str18 = b(parama.b(), localHashMap2);
          if (!localHashSet.add(str18))
            break;
          localArrayList1.add(new d.a(str18, Format.createVideoContainerFormat(Integer.toString(localArrayList1.size()), null, "application/x-mpegURL", null, str14, i6, i7, i8, f1, null, 0)));
          break;
          i7 = -1;
          i8 = -1;
        }
      }
    }
    int i1 = 0;
    int i2 = localArrayList4.size();
    if (i1 < i2)
    {
      String str1 = (String)localArrayList4.get(i1);
      int i3 = a(str1);
      String str2 = b(str1, s, localHashMap2);
      String str3 = a(str1, w, localHashMap2);
      String str4 = b(str1, v, localHashMap2);
      String str5 = b(str1, x, localHashMap2);
      String str6 = str5 + ":" + str3;
      String str7 = a(str1, u, localHashMap2);
      int i4 = -1;
      label636: Object localObject4;
      Object localObject5;
      switch (str7.hashCode())
      {
      default:
        switch (i4)
        {
        default:
          localObject4 = localObject2;
          localObject5 = localObject1;
        case 0:
        case 1:
        case 2:
        }
        break;
      case 62628790:
      case -959297733:
      case -333210994:
      }
      while (true)
      {
        i1++;
        localObject2 = localObject4;
        localObject1 = localObject5;
        break;
        if (!str7.equals("AUDIO"))
          break label636;
        i4 = 0;
        break label636;
        if (!str7.equals("SUBTITLES"))
          break label636;
        i4 = 1;
        break label636;
        if (!str7.equals("CLOSED-CAPTIONS"))
          break label636;
        i4 = 2;
        break label636;
        String str10 = (String)localHashMap1.get(str5);
        if (str10 != null);
        Format localFormat;
        for (String str11 = o.f(str10); ; str11 = null)
        {
          localFormat = Format.createAudioContainerFormat(str6, str3, "application/x-mpegURL", str11, str10, -1, -1, -1, null, i3, str4);
          if (!a(localArrayList1, str2))
            break label811;
          localObject5 = localFormat;
          localObject4 = localObject2;
          break;
        }
        label811: localArrayList2.add(new d.a(str2, localFormat));
        localObject4 = localObject2;
        localObject5 = localObject1;
        continue;
        localArrayList3.add(new d.a(str2, Format.createTextContainerFormat(str6, str3, "application/x-mpegURL", "text/vtt", null, -1, i3, str4)));
        localObject4 = localObject2;
        localObject5 = localObject1;
      }
      String str8 = a(str1, y, localHashMap2);
      String str9;
      if (str8.startsWith("CC"))
        str9 = "application/cea-608";
      for (int i5 = Integer.parseInt(str8.substring(2)); ; i5 = Integer.parseInt(str8.substring(7)))
      {
        if (localObject2 == null)
          localObject2 = new ArrayList();
        ((List)localObject2).add(Format.createTextContainerFormat(str6, str3, null, str9, null, -1, i3, str4, i5));
        localObject4 = localObject2;
        localObject5 = localObject1;
        break;
        str9 = "application/cea-708";
      }
    }
    if (bool2);
    for (Object localObject3 = Collections.emptyList(); ; localObject3 = localObject2)
      return new d(paramString, localArrayList5, localArrayList1, localArrayList2, localArrayList3, localObject1, (List)localObject3, bool1, localHashMap2);
  }

  private static e a(d paramd, a parama, String paramString)
    throws IOException
  {
    boolean bool1 = paramd.p;
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i1 = 0;
    long l1 = 0L;
    long l2 = -1L;
    boolean bool2 = false;
    Object localObject1 = null;
    String str1 = null;
    TreeMap localTreeMap = new TreeMap();
    DrmInitData localDrmInitData = null;
    long l3 = -9223372036854775807L;
    int i2 = 1;
    long l4 = 0L;
    long l5 = -9223372036854775807L;
    int i3 = 0;
    int i4 = 0;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = bool1;
    Object localObject2 = null;
    Object localObject3 = null;
    long l6 = 0L;
    long l7 = 0L;
    long l8 = 0L;
    long l9 = 0L;
    String str2 = "";
    Object localObject4 = null;
    String str3;
    String str11;
    int i6;
    if (parama.a())
    {
      str3 = parama.b();
      if (str3.startsWith("#EXT"))
        localArrayList2.add(str3);
      if (str3.startsWith("#EXT-X-PLAYLIST-TYPE"))
      {
        str11 = a(str3, i, localHashMap);
        if ("VOD".equals(str11))
          i6 = 1;
      }
    }
    while (true)
    {
      i3 = i6;
      break;
      if ("EVENT".equals(str11))
      {
        i6 = 2;
        continue;
        if (str3.startsWith("#EXT-X-START"))
        {
          l5 = ()(1000000.0D * c(str3, m));
          break;
        }
        String str9;
        long l14;
        if (str3.startsWith("#EXT-X-MAP"))
        {
          str9 = a(str3, s, localHashMap);
          String str10 = b(str3, o, localHashMap);
          if (str10 == null)
            break label1363;
          String[] arrayOfString2 = str10.split("@");
          l14 = Long.parseLong(arrayOfString2[0]);
          if (arrayOfString2.length > 1)
            l8 = Long.parseLong(arrayOfString2[1]);
        }
        while (true)
        {
          e.a locala = new e.a(str9, l8, l14);
          l2 = -1L;
          l8 = 0L;
          localObject4 = locala;
          break;
          if (str3.startsWith("#EXT-X-TARGETDURATION"))
          {
            l3 = 1000000L * a(str3, g);
            break;
          }
          if (str3.startsWith("#EXT-X-MEDIA-SEQUENCE"))
          {
            long l13 = b(str3, j);
            l9 = l13;
            l4 = l13;
            break;
          }
          if (str3.startsWith("#EXT-X-VERSION"))
          {
            i2 = a(str3, h);
            break;
          }
          if (str3.startsWith("#EXT-X-DEFINE"))
          {
            String str7 = b(str3, D, localHashMap);
            if (str7 != null)
            {
              String str8 = (String)paramd.g.get(str7);
              if (str8 == null)
                break;
              localHashMap.put(str7, str8);
              break;
            }
            localHashMap.put(a(str3, w, localHashMap), a(str3, C, localHashMap));
            break;
          }
          if (str3.startsWith("#EXTINF"))
          {
            l7 = ()(1000000.0D * c(str3, k));
            str2 = a(str3, l, "", localHashMap);
            break;
          }
          String str4;
          String str5;
          String str6;
          Object localObject7;
          if (str3.startsWith("#EXT-X-KEY"))
          {
            str4 = a(str3, p, localHashMap);
            str5 = a(str3, q, "identity", localHashMap);
            str1 = null;
            str6 = null;
            if ("NONE".equals(str4))
            {
              localTreeMap.clear();
              localDrmInitData = null;
              localObject7 = localObject2;
            }
          }
          while (true)
          {
            localObject2 = localObject7;
            localObject3 = str6;
            break;
            str6 = b(str3, t, localHashMap);
            if ("identity".equals(str5))
            {
              if ("AES-128".equals(str4))
              {
                str1 = a(str3, s, localHashMap);
                localObject7 = localObject2;
              }
            }
            else
            {
              if (localObject2 == null)
                if (("SAMPLE-AES-CENC".equals(str4)) || ("SAMPLE-AES-CTR".equals(str4)))
                  localObject7 = "cenc";
              while (true)
              {
                label733: if ("com.microsoft.playready".equals(str5));
                for (DrmInitData.SchemeData localSchemeData = a(str3, localHashMap); ; localSchemeData = a(str3, str5, localHashMap))
                {
                  str1 = null;
                  if (localSchemeData == null)
                    break;
                  localTreeMap.put(str5, localSchemeData);
                  localDrmInitData = null;
                  str1 = null;
                  break;
                  localObject7 = "cbcs";
                  break label733;
                }
                String[] arrayOfString1;
                if (str3.startsWith("#EXT-X-BYTERANGE"))
                {
                  arrayOfString1 = a(str3, n, localHashMap).split("@");
                  l2 = Long.parseLong(arrayOfString1[0]);
                  if (arrayOfString1.length <= 1)
                    break label1339;
                }
                label1332: label1339: for (long l12 = Long.parseLong(arrayOfString1[1]); ; l12 = l8)
                {
                  l8 = l12;
                  break;
                  if (str3.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE"))
                  {
                    i4 = Integer.parseInt(str3.substring(1 + str3.indexOf(':')));
                    bool3 = true;
                    break;
                  }
                  if (str3.equals("#EXT-X-DISCONTINUITY"))
                  {
                    i1++;
                    break;
                  }
                  if (str3.startsWith("#EXT-X-PROGRAM-DATE-TIME"))
                  {
                    if (l6 != 0L)
                      break;
                    l6 = c.b(ag.f(str3.substring(1 + str3.indexOf(':')))) - l1;
                    break;
                  }
                  if (str3.equals("#EXT-X-GAP"))
                  {
                    bool2 = true;
                    break;
                  }
                  if (str3.equals("#EXT-X-INDEPENDENT-SEGMENTS"))
                  {
                    bool5 = true;
                    break;
                  }
                  if (str3.equals("#EXT-X-ENDLIST"))
                  {
                    bool4 = true;
                    break;
                  }
                  if (str3.startsWith("#"))
                    break;
                  Object localObject5;
                  long l10;
                  if (str1 == null)
                  {
                    localObject5 = null;
                    l10 = l9 + 1L;
                    if (l2 != -1L)
                      break label1332;
                  }
                  for (long l11 = 0L; ; l11 = l8)
                  {
                    DrmInitData.SchemeData[] arrayOfSchemeData2;
                    if ((localDrmInitData == null) && (!localTreeMap.isEmpty()))
                    {
                      DrmInitData.SchemeData[] arrayOfSchemeData1 = (DrmInitData.SchemeData[])localTreeMap.values().toArray(new DrmInitData.SchemeData[0]);
                      localDrmInitData = new DrmInitData(localObject2, arrayOfSchemeData1);
                      if (localObject1 == null)
                      {
                        arrayOfSchemeData2 = new DrmInitData.SchemeData[arrayOfSchemeData1.length];
                        int i5 = 0;
                        while (true)
                          if (i5 < arrayOfSchemeData1.length)
                          {
                            arrayOfSchemeData2[i5] = arrayOfSchemeData1[i5].copyWithData(null);
                            i5++;
                            continue;
                            if (localObject3 != null)
                            {
                              localObject5 = localObject3;
                              break;
                            }
                            localObject5 = Long.toHexString(l9);
                            break;
                          }
                      }
                    }
                    for (Object localObject6 = new DrmInitData(localObject2, arrayOfSchemeData2); ; localObject6 = localObject1)
                    {
                      localArrayList1.add(new e.a(b(str3, localHashMap), localObject4, str2, l7, i1, l1, localDrmInitData, str1, (String)localObject5, l11, l2, bool2));
                      l1 += l7;
                      l7 = 0L;
                      str2 = "";
                      if (l2 != -1L)
                        l11 += l2;
                      l2 = -1L;
                      localObject1 = localObject6;
                      l8 = l11;
                      l9 = l10;
                      bool2 = false;
                      break;
                      if (l6 != 0L);
                      for (boolean bool6 = true; ; bool6 = false)
                        return new e(i3, paramString, localArrayList2, l5, l6, bool3, i4, l4, i2, l3, bool5, bool4, bool6, localObject1, localArrayList1);
                    }
                  }
                }
                localObject7 = localObject2;
              }
              localObject7 = localObject2;
              str1 = null;
            }
          }
          label1363: l14 = l2;
        }
      }
      i6 = i3;
    }
  }

  private static String a(String paramString1, Pattern paramPattern, String paramString2, Map<String, String> paramMap)
  {
    Matcher localMatcher = paramPattern.matcher(paramString1);
    if (localMatcher.find())
      paramString2 = localMatcher.group(1);
    if ((paramMap.isEmpty()) || (paramString2 == null))
      return paramString2;
    return b(paramString2, paramMap);
  }

  private static String a(String paramString, Pattern paramPattern, Map<String, String> paramMap)
    throws w
  {
    String str = b(paramString, paramPattern, paramMap);
    if (str != null)
      return str;
    throw new w("Couldn't match " + paramPattern.pattern() + " in " + paramString);
  }

  private static boolean a(BufferedReader paramBufferedReader)
    throws IOException
  {
    int i1 = paramBufferedReader.read();
    if (i1 == 239)
    {
      if ((paramBufferedReader.read() != 187) || (paramBufferedReader.read() != 191))
        return false;
      i1 = paramBufferedReader.read();
    }
    int i2 = a(paramBufferedReader, true, i1);
    int i3 = "#EXTM3U".length();
    int i4 = i2;
    for (int i5 = 0; i5 < i3; i5++)
    {
      if (i4 != "#EXTM3U".charAt(i5))
        return false;
      i4 = paramBufferedReader.read();
    }
    return ag.a(a(paramBufferedReader, false, i4));
  }

  private static boolean a(String paramString, Pattern paramPattern, boolean paramBoolean)
  {
    Matcher localMatcher = paramPattern.matcher(paramString);
    if (localMatcher.find())
      paramBoolean = localMatcher.group(1).equals("YES");
    return paramBoolean;
  }

  private static boolean a(List<d.a> paramList, String paramString)
  {
    boolean bool;
    if (paramString == null)
    {
      bool = true;
      return bool;
    }
    for (int i1 = 0; ; i1++)
    {
      int i2 = paramList.size();
      bool = false;
      if (i1 >= i2)
        break;
      if (paramString.equals(((d.a)paramList.get(i1)).a))
        return true;
    }
  }

  private static long b(String paramString, Pattern paramPattern)
    throws w
  {
    return Long.parseLong(a(paramString, paramPattern, Collections.emptyMap()));
  }

  private static String b(String paramString, Map<String, String> paramMap)
  {
    Matcher localMatcher = E.matcher(paramString);
    StringBuffer localStringBuffer = new StringBuffer();
    while (localMatcher.find())
    {
      String str = localMatcher.group(1);
      if (paramMap.containsKey(str))
        localMatcher.appendReplacement(localStringBuffer, Matcher.quoteReplacement((String)paramMap.get(str)));
    }
    localMatcher.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }

  private static String b(String paramString, Pattern paramPattern, Map<String, String> paramMap)
  {
    return a(paramString, paramPattern, null, paramMap);
  }

  private static Pattern b(String paramString)
  {
    return Pattern.compile(paramString + "=(" + "NO" + "|" + "YES" + ")");
  }

  private static double c(String paramString, Pattern paramPattern)
    throws w
  {
    return Double.parseDouble(a(paramString, paramPattern, Collections.emptyMap()));
  }

  public f a(Uri paramUri, InputStream paramInputStream)
    throws IOException
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    ArrayDeque localArrayDeque = new ArrayDeque();
    try
    {
      if (!a(localBufferedReader))
        throw new ac("Input does not start with the #EXTM3U header.", paramUri);
    }
    finally
    {
      ag.a(localBufferedReader);
    }
    while (true)
    {
      String str1 = localBufferedReader.readLine();
      if (str1 == null)
        break;
      String str2 = str1.trim();
      if (!str2.isEmpty())
      {
        if (str2.startsWith("#EXT-X-STREAM-INF"))
        {
          localArrayDeque.add(str2);
          d locald = a(new a(localArrayDeque, localBufferedReader), paramUri.toString());
          ag.a(localBufferedReader);
          return locald;
        }
        if ((str2.startsWith("#EXT-X-TARGETDURATION")) || (str2.startsWith("#EXT-X-MEDIA-SEQUENCE")) || (str2.startsWith("#EXTINF")) || (str2.startsWith("#EXT-X-KEY")) || (str2.startsWith("#EXT-X-BYTERANGE")) || (str2.equals("#EXT-X-DISCONTINUITY")) || (str2.equals("#EXT-X-DISCONTINUITY-SEQUENCE")) || (str2.equals("#EXT-X-ENDLIST")))
        {
          localArrayDeque.add(str2);
          e locale = a(this.F, new a(localArrayDeque, localBufferedReader), paramUri.toString());
          ag.a(localBufferedReader);
          return locale;
        }
        localArrayDeque.add(str2);
      }
    }
    ag.a(localBufferedReader);
    throw new w("Failed to parse the playlist, could not identify any tags.");
  }

  private static class a
  {
    private final BufferedReader a;
    private final Queue<String> b;
    private String c;

    public a(Queue<String> paramQueue, BufferedReader paramBufferedReader)
    {
      this.b = paramQueue;
      this.a = paramBufferedReader;
    }

    public boolean a()
      throws IOException
    {
      if (this.c != null)
        return true;
      if (!this.b.isEmpty())
      {
        this.c = ((String)this.b.poll());
        return true;
      }
      do
      {
        String str = this.a.readLine();
        this.c = str;
        if (str == null)
          break;
        this.c = this.c.trim();
      }
      while (this.c.isEmpty());
      return true;
      return false;
    }

    public String b()
      throws IOException
    {
      if (a())
      {
        String str = this.c;
        this.c = null;
        return str;
      }
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a.g
 * JD-Core Version:    0.6.2
 */