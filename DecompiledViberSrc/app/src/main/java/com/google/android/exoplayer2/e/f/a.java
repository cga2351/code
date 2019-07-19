package com.google.android.exoplayer2.e.f;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.ai;
import com.google.android.exoplayer2.g.d;
import com.google.android.exoplayer2.g.l;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class a extends com.google.android.exoplayer2.e.c
{
  private static final Pattern a = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
  private static final Pattern b = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
  private static final Pattern c = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
  private static final Pattern d = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
  private static final Pattern e = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
  private static final Pattern f = Pattern.compile("^(\\d+) (\\d+)$");
  private static final b g = new b(30.0F, 1, 1);
  private static final a h = new a(32, 15);
  private final XmlPullParserFactory i;

  public a()
  {
    super("TtmlDecoder");
    try
    {
      this.i = XmlPullParserFactory.newInstance();
      this.i.setNamespaceAware(true);
      return;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      throw new RuntimeException("Couldn't create XmlPullParserFactory instance", localXmlPullParserException);
    }
  }

  private static long a(String paramString, b paramb)
    throws g
  {
    double d1 = 0.0D;
    Matcher localMatcher1 = a.matcher(paramString);
    if (localMatcher1.matches())
    {
      double d3 = 3600L * Long.parseLong(localMatcher1.group(1)) + 60L * Long.parseLong(localMatcher1.group(2)) + Long.parseLong(localMatcher1.group(3));
      String str2 = localMatcher1.group(4);
      double d4;
      double d5;
      String str3;
      if (str2 != null)
      {
        d4 = Double.parseDouble(str2);
        d5 = d3 + d4;
        str3 = localMatcher1.group(5);
        if (str3 == null)
          break label171;
      }
      label171: for (double d6 = (float)Long.parseLong(str3) / paramb.a; ; d6 = d1)
      {
        double d7 = d6 + d5;
        String str4 = localMatcher1.group(6);
        if (str4 != null)
          d1 = Long.parseLong(str4) / paramb.b / paramb.a;
        return ()(1000000.0D * (d7 + d1));
        d4 = d1;
        break;
      }
    }
    Matcher localMatcher2 = b.matcher(paramString);
    if (localMatcher2.matches())
    {
      double d2 = Double.parseDouble(localMatcher2.group(1));
      String str1 = localMatcher2.group(2);
      int j = -1;
      switch (str1.hashCode())
      {
      default:
        switch (j)
        {
        case 2:
        default:
        case 0:
        case 1:
        case 3:
        case 4:
        case 5:
        }
        break;
      case 104:
      case 109:
      case 115:
      case 3494:
      case 102:
      case 116:
      }
      while (true)
      {
        return ()(d2 * 1000000.0D);
        if (!str1.equals("h"))
          break;
        j = 0;
        break;
        if (!str1.equals("m"))
          break;
        j = 1;
        break;
        if (!str1.equals("s"))
          break;
        j = 2;
        break;
        if (!str1.equals("ms"))
          break;
        j = 3;
        break;
        if (!str1.equals("f"))
          break;
        j = 4;
        break;
        if (!str1.equals("t"))
          break;
        j = 5;
        break;
        d2 *= 3600.0D;
        continue;
        d2 *= 60.0D;
        continue;
        d2 /= 1000.0D;
        continue;
        d2 /= paramb.a;
        continue;
        d2 /= paramb.c;
      }
    }
    throw new g("Malformed time expression: " + paramString);
  }

  private a a(XmlPullParser paramXmlPullParser, a parama)
    throws g
  {
    String str = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
    if (str == null)
      return parama;
    Matcher localMatcher = f.matcher(str);
    if (!localMatcher.matches())
    {
      l.c("TtmlDecoder", "Ignoring malformed cell resolution: " + str);
      return parama;
    }
    int j;
    int k;
    try
    {
      j = Integer.parseInt(localMatcher.group(1));
      k = Integer.parseInt(localMatcher.group(2));
      if ((j == 0) || (k == 0))
        throw new g("Invalid cell resolution " + j + " " + k);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      l.c("TtmlDecoder", "Ignoring malformed cell resolution: " + str);
      return parama;
    }
    a locala = new a(j, k);
    return locala;
  }

  private b a(XmlPullParser paramXmlPullParser)
    throws g
  {
    int j = 30;
    String str1 = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
    if (str1 != null)
      j = Integer.parseInt(str1);
    float f1 = 1.0F;
    String str2 = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
    if (str2 != null)
    {
      String[] arrayOfString = ag.a(str2, " ");
      if (arrayOfString.length != 2)
        throw new g("frameRateMultiplier doesn't have 2 parts");
      f1 = Integer.parseInt(arrayOfString[0]) / Integer.parseInt(arrayOfString[1]);
    }
    int k = g.b;
    String str3 = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
    if (str3 != null)
      k = Integer.parseInt(str3);
    int m = g.c;
    String str4 = paramXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
    if (str4 != null)
      m = Integer.parseInt(str4);
    return new b(f1 * j, k, m);
  }

  private b a(XmlPullParser paramXmlPullParser, b paramb, Map<String, c> paramMap, b paramb1)
    throws g
  {
    long l1 = -9223372036854775807L;
    long l2 = -9223372036854775807L;
    long l3 = -9223372036854775807L;
    Object localObject1 = "";
    String str1 = null;
    Object localObject2 = null;
    int j = paramXmlPullParser.getAttributeCount();
    e locale = a(paramXmlPullParser, null);
    int k = 0;
    if (k < j)
    {
      String str2 = paramXmlPullParser.getAttributeName(k);
      String str3 = paramXmlPullParser.getAttributeValue(k);
      int m = -1;
      label136: label176: long l8;
      long l9;
      long l10;
      switch (str2.hashCode())
      {
      default:
        switch (m)
        {
        default:
          l8 = l3;
          l9 = l2;
          l10 = l1;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        }
        break;
      case 93616297:
      case 100571:
      case 99841:
      case 109780401:
      case -934795532:
      case 1292595405:
      }
      while (true)
      {
        k++;
        l1 = l10;
        l2 = l9;
        l3 = l8;
        break;
        if (!str2.equals("begin"))
          break label136;
        m = 0;
        break label136;
        if (!str2.equals("end"))
          break label136;
        m = 1;
        break label136;
        if (!str2.equals("dur"))
          break label136;
        m = 2;
        break label136;
        if (!str2.equals("style"))
          break label136;
        m = 3;
        break label136;
        if (!str2.equals("region"))
          break label136;
        m = 4;
        break label136;
        if (!str2.equals("backgroundImage"))
          break label136;
        m = 5;
        break label136;
        long l13 = a(str3, paramb1);
        l10 = l1;
        l8 = l3;
        l9 = l13;
        continue;
        l8 = a(str3, paramb1);
        l9 = l2;
        l10 = l1;
        continue;
        long l11 = a(str3, paramb1);
        long l12 = l3;
        l9 = l2;
        l10 = l11;
        l8 = l12;
        continue;
        String[] arrayOfString = a(str3);
        if (arrayOfString.length <= 0)
          break label176;
        localObject2 = arrayOfString;
        l8 = l3;
        l9 = l2;
        l10 = l1;
        continue;
        if (!paramMap.containsKey(str3))
          break label176;
        localObject1 = str3;
        l8 = l3;
        l9 = l2;
        l10 = l1;
        continue;
        if (!str3.startsWith("#"))
          break label176;
        str1 = str3.substring(1);
        l8 = l3;
        l9 = l2;
        l10 = l1;
      }
    }
    long l7;
    long l5;
    if ((paramb != null) && (paramb.d != -9223372036854775807L))
    {
      if (l2 != -9223372036854775807L)
        l2 += paramb.d;
      if (l3 != -9223372036854775807L)
      {
        l7 = l3 + paramb.d;
        l5 = l2;
      }
    }
    label577: long l4;
    for (long l6 = l7; ; l6 = l4)
    {
      if (l6 == -9223372036854775807L)
        if (l1 == -9223372036854775807L)
          break label577;
      for (l6 = l5 + l1; ; l6 = paramb.e)
        do
          return b.a(paramXmlPullParser.getName(), l5, l6, locale, localObject2, (String)localObject1, str1);
        while ((paramb == null) || (paramb.e == -9223372036854775807L));
      l4 = l3;
      l5 = l2;
    }
  }

  // ERROR //
  private c a(XmlPullParser paramXmlPullParser, a parama, c paramc)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore 4
    //   3: aload_1
    //   4: ldc_w 287
    //   7: invokestatic 292	com/google/android/exoplayer2/g/ai:c	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 5
    //   12: aload 5
    //   14: ifnonnull +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: aload_1
    //   20: ldc_w 294
    //   23: invokestatic 292	com/google/android/exoplayer2/g/ai:c	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 6
    //   28: aload 6
    //   30: ifnull +439 -> 469
    //   33: getstatic 41	com/google/android/exoplayer2/e/f/a:d	Ljava/util/regex/Pattern;
    //   36: aload 6
    //   38: invokevirtual 98	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   41: astore 7
    //   43: getstatic 45	com/google/android/exoplayer2/e/f/a:e	Ljava/util/regex/Pattern;
    //   46: aload 6
    //   48: invokevirtual 98	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   51: astore 8
    //   53: aload 7
    //   55: invokevirtual 104	java/util/regex/Matcher:matches	()Z
    //   58: ifeq +258 -> 316
    //   61: aload 7
    //   63: iconst_1
    //   64: invokevirtual 110	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   67: invokestatic 300	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   70: ldc_w 301
    //   73: fdiv
    //   74: fstore 12
    //   76: aload 7
    //   78: iconst_2
    //   79: invokevirtual 110	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   82: invokestatic 300	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   85: fstore 34
    //   87: fload 34
    //   89: ldc_w 301
    //   92: fdiv
    //   93: fstore 15
    //   95: aload_1
    //   96: ldc_w 303
    //   99: invokestatic 292	com/google/android/exoplayer2/g/ai:c	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 16
    //   104: aload 16
    //   106: ifnull +556 -> 662
    //   109: getstatic 41	com/google/android/exoplayer2/e/f/a:d	Ljava/util/regex/Pattern;
    //   112: aload 16
    //   114: invokevirtual 98	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   117: astore 17
    //   119: getstatic 45	com/google/android/exoplayer2/e/f/a:e	Ljava/util/regex/Pattern;
    //   122: aload 16
    //   124: invokevirtual 98	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   127: astore 18
    //   129: aload 17
    //   131: invokevirtual 104	java/util/regex/Matcher:matches	()Z
    //   134: ifeq +375 -> 509
    //   137: aload 17
    //   139: iconst_1
    //   140: invokevirtual 110	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   143: invokestatic 300	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   146: ldc_w 301
    //   149: fdiv
    //   150: fstore 22
    //   152: aload 17
    //   154: iconst_2
    //   155: invokevirtual 110	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   158: invokestatic 300	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   161: fstore 32
    //   163: fload 32
    //   165: ldc_w 301
    //   168: fdiv
    //   169: fstore 25
    //   171: aload_1
    //   172: ldc_w 305
    //   175: invokestatic 292	com/google/android/exoplayer2/g/ai:c	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;
    //   178: astore 26
    //   180: aload 26
    //   182: ifnull +70 -> 252
    //   185: aload 26
    //   187: invokestatic 308	com/google/android/exoplayer2/g/ag:d	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 28
    //   192: iconst_m1
    //   193: istore 29
    //   195: aload 28
    //   197: invokevirtual 138	java/lang/String:hashCode	()I
    //   200: lookupswitch	default:+28->228, -1364013995:+472->672, 92734940:+489->689
    //   229: iload_3
    //   230: tableswitch	default:+22 -> 252, 0:+476->706, 1:+495->725
    //   253: istore 4
    //   255: fload 15
    //   257: fstore 27
    //   259: new 310	com/google/android/exoplayer2/e/f/c
    //   262: dup
    //   263: aload 5
    //   265: fload 12
    //   267: fload 27
    //   269: iconst_0
    //   270: iload 4
    //   272: fload 22
    //   274: iconst_1
    //   275: fconst_1
    //   276: aload_2
    //   277: getfield 311	com/google/android/exoplayer2/e/f/a$a:b	I
    //   280: i2f
    //   281: fdiv
    //   282: invokespecial 314	com/google/android/exoplayer2/e/f/c:<init>	(Ljava/lang/String;FFIIFIF)V
    //   285: areturn
    //   286: astore 33
    //   288: ldc 69
    //   290: new 162	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   297: ldc_w 316
    //   300: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 6
    //   305: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 195	com/google/android/exoplayer2/g/l:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aconst_null
    //   315: areturn
    //   316: aload 8
    //   318: invokevirtual 104	java/util/regex/Matcher:matches	()Z
    //   321: ifeq +120 -> 441
    //   324: aload_3
    //   325: ifnonnull +31 -> 356
    //   328: ldc 69
    //   330: new 162	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 318
    //   340: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 6
    //   345: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 195	com/google/android/exoplayer2/g/l:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   354: aconst_null
    //   355: areturn
    //   356: aload 8
    //   358: iconst_1
    //   359: invokevirtual 110	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   362: invokestatic 201	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   365: istore 10
    //   367: aload 8
    //   369: iconst_2
    //   370: invokevirtual 110	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   373: invokestatic 201	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   376: istore 11
    //   378: iload 10
    //   380: i2f
    //   381: aload_3
    //   382: getfield 322	com/google/android/exoplayer2/e/f/a$c:a	I
    //   385: i2f
    //   386: fdiv
    //   387: fstore 12
    //   389: iload 11
    //   391: i2f
    //   392: fstore 13
    //   394: aload_3
    //   395: getfield 323	com/google/android/exoplayer2/e/f/a$c:b	I
    //   398: istore 14
    //   400: fload 13
    //   402: iload 14
    //   404: i2f
    //   405: fdiv
    //   406: fstore 15
    //   408: goto -313 -> 95
    //   411: astore 9
    //   413: ldc 69
    //   415: new 162	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   422: ldc_w 316
    //   425: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload 6
    //   430: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 195	com/google/android/exoplayer2/g/l:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: aconst_null
    //   440: areturn
    //   441: ldc 69
    //   443: new 162	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   450: ldc_w 325
    //   453: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload 6
    //   458: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 195	com/google/android/exoplayer2/g/l:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: aconst_null
    //   468: areturn
    //   469: ldc 69
    //   471: ldc_w 327
    //   474: invokestatic 195	com/google/android/exoplayer2/g/l:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: aconst_null
    //   478: areturn
    //   479: astore 31
    //   481: ldc 69
    //   483: new 162	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   490: ldc_w 329
    //   493: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload 6
    //   498: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 195	com/google/android/exoplayer2/g/l:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: aconst_null
    //   508: areturn
    //   509: aload 18
    //   511: invokevirtual 104	java/util/regex/Matcher:matches	()Z
    //   514: ifeq +120 -> 634
    //   517: aload_3
    //   518: ifnonnull +31 -> 549
    //   521: ldc 69
    //   523: new 162	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   530: ldc_w 318
    //   533: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: aload 6
    //   538: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 195	com/google/android/exoplayer2/g/l:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   547: aconst_null
    //   548: areturn
    //   549: aload 18
    //   551: iconst_1
    //   552: invokevirtual 110	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   555: invokestatic 201	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   558: istore 20
    //   560: aload 18
    //   562: iconst_2
    //   563: invokevirtual 110	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   566: invokestatic 201	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   569: istore 21
    //   571: iload 20
    //   573: i2f
    //   574: aload_3
    //   575: getfield 322	com/google/android/exoplayer2/e/f/a$c:a	I
    //   578: i2f
    //   579: fdiv
    //   580: fstore 22
    //   582: iload 21
    //   584: i2f
    //   585: fstore 23
    //   587: aload_3
    //   588: getfield 323	com/google/android/exoplayer2/e/f/a$c:b	I
    //   591: istore 24
    //   593: fload 23
    //   595: iload 24
    //   597: i2f
    //   598: fdiv
    //   599: fstore 25
    //   601: goto -430 -> 171
    //   604: astore 19
    //   606: ldc 69
    //   608: new 162	java/lang/StringBuilder
    //   611: dup
    //   612: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   615: ldc_w 329
    //   618: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload 6
    //   623: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 195	com/google/android/exoplayer2/g/l:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   632: aconst_null
    //   633: areturn
    //   634: ldc 69
    //   636: new 162	java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   643: ldc_w 331
    //   646: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: aload 6
    //   651: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: invokestatic 195	com/google/android/exoplayer2/g/l:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   660: aconst_null
    //   661: areturn
    //   662: ldc 69
    //   664: ldc_w 333
    //   667: invokestatic 195	com/google/android/exoplayer2/g/l:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   670: aconst_null
    //   671: areturn
    //   672: aload 28
    //   674: ldc_w 335
    //   677: invokevirtual 143	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   680: ifeq -452 -> 228
    //   683: iconst_0
    //   684: istore 29
    //   686: goto -458 -> 228
    //   689: aload 28
    //   691: ldc_w 337
    //   694: invokevirtual 143	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   697: ifeq -469 -> 228
    //   700: iconst_1
    //   701: istore 29
    //   703: goto -475 -> 228
    //   706: fload 15
    //   708: fload 25
    //   710: fconst_2
    //   711: fdiv
    //   712: fadd
    //   713: fstore 30
    //   715: iconst_1
    //   716: istore 4
    //   718: fload 30
    //   720: fstore 27
    //   722: goto -463 -> 259
    //   725: fload 15
    //   727: fload 25
    //   729: fadd
    //   730: fstore 27
    //   732: goto -473 -> 259
    //
    // Exception table:
    //   from	to	target	type
    //   61	87	286	java/lang/NumberFormatException
    //   356	389	411	java/lang/NumberFormatException
    //   394	400	411	java/lang/NumberFormatException
    //   137	163	479	java/lang/NumberFormatException
    //   549	582	604	java/lang/NumberFormatException
    //   587	593	604	java/lang/NumberFormatException
  }

  private e a(e parame)
  {
    if (parame == null)
      parame = new e();
    return parame;
  }

  private e a(XmlPullParser paramXmlPullParser, e parame)
  {
    int j = paramXmlPullParser.getAttributeCount();
    int k = 0;
    e locale = parame;
    if (k < j)
    {
      String str1 = paramXmlPullParser.getAttributeValue(k);
      String str2 = paramXmlPullParser.getAttributeName(k);
      label128: int m;
      switch (str2.hashCode())
      {
      default:
        m = -1;
        label131: switch (m)
        {
        default:
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        }
        break;
      case 3355:
      case 1287124693:
      case 94842723:
      case -1224696685:
      case 365601008:
      case -734428249:
      case -1550943582:
      case -1065511464:
      case -879295043:
      }
      while (true)
      {
        k++;
        break;
        if (!str2.equals("id"))
          break label128;
        m = 0;
        break label131;
        if (!str2.equals("backgroundColor"))
          break label128;
        m = 1;
        break label131;
        if (!str2.equals("color"))
          break label128;
        m = 2;
        break label131;
        if (!str2.equals("fontFamily"))
          break label128;
        m = 3;
        break label131;
        if (!str2.equals("fontSize"))
          break label128;
        m = 4;
        break label131;
        if (!str2.equals("fontWeight"))
          break label128;
        m = 5;
        break label131;
        if (!str2.equals("fontStyle"))
          break label128;
        m = 6;
        break label131;
        if (!str2.equals("textAlign"))
          break label128;
        m = 7;
        break label131;
        if (!str2.equals("textDecoration"))
          break label128;
        m = 8;
        break label131;
        if ("style".equals(paramXmlPullParser.getName()))
        {
          locale = a(locale).b(str1);
          continue;
          locale = a(locale);
          try
          {
            locale.b(d.a(str1));
          }
          catch (IllegalArgumentException localIllegalArgumentException2)
          {
            l.c("TtmlDecoder", "Failed parsing background value: " + str1);
          }
          continue;
          locale = a(locale);
          try
          {
            locale.a(d.a(str1));
          }
          catch (IllegalArgumentException localIllegalArgumentException1)
          {
            l.c("TtmlDecoder", "Failed parsing color value: " + str1);
          }
          continue;
          locale = a(locale).a(str1);
          continue;
          try
          {
            locale = a(locale);
            a(str1, locale);
          }
          catch (g localg)
          {
            l.c("TtmlDecoder", "Failed parsing fontSize value: " + str1);
          }
          continue;
          locale = a(locale).c("bold".equalsIgnoreCase(str1));
          continue;
          locale = a(locale).d("italic".equalsIgnoreCase(str1));
          continue;
          String str4 = ag.d(str1);
          label652: int i1;
          switch (str4.hashCode())
          {
          default:
            i1 = -1;
          case 3317767:
          case 109757538:
          case 108511772:
          case 100571:
          case -1364013995:
          }
          while (true)
            switch (i1)
            {
            default:
              break;
            case 0:
              locale = a(locale).a(Layout.Alignment.ALIGN_NORMAL);
              break;
              if (!str4.equals("left"))
                break label652;
              i1 = 0;
              continue;
              if (!str4.equals("start"))
                break label652;
              i1 = 1;
              continue;
              if (!str4.equals("right"))
                break label652;
              i1 = 2;
              continue;
              if (!str4.equals("end"))
                break label652;
              i1 = 3;
              continue;
              if (!str4.equals("center"))
                break label652;
              i1 = 4;
            case 1:
            case 2:
            case 3:
            case 4:
            }
          locale = a(locale).a(Layout.Alignment.ALIGN_NORMAL);
          continue;
          locale = a(locale).a(Layout.Alignment.ALIGN_OPPOSITE);
          continue;
          locale = a(locale).a(Layout.Alignment.ALIGN_OPPOSITE);
          continue;
          locale = a(locale).a(Layout.Alignment.ALIGN_CENTER);
          continue;
          String str3 = ag.d(str1);
          label920: int n;
          switch (str3.hashCode())
          {
          default:
            n = -1;
          case 1679736913:
          case 913457136:
          case -1026963764:
          case -1461280213:
          }
          while (true)
            switch (n)
            {
            default:
              break;
            case 0:
              locale = a(locale).a(true);
              break;
              if (!str3.equals("linethrough"))
                break label920;
              n = 0;
              continue;
              if (!str3.equals("nolinethrough"))
                break label920;
              n = 1;
              continue;
              if (!str3.equals("underline"))
                break label920;
              n = 2;
              continue;
              if (!str3.equals("nounderline"))
                break label920;
              n = 3;
            case 1:
            case 2:
            case 3:
            }
          locale = a(locale).a(false);
          continue;
          locale = a(locale).b(true);
          continue;
          locale = a(locale).b(false);
        }
      }
    }
    return locale;
  }

  private Map<String, e> a(XmlPullParser paramXmlPullParser, Map<String, e> paramMap, a parama, c paramc, Map<String, c> paramMap1, Map<String, String> paramMap2)
    throws IOException, XmlPullParserException
  {
    paramXmlPullParser.next();
    if (ai.b(paramXmlPullParser, "style"))
    {
      String str = ai.c(paramXmlPullParser, "style");
      e locale = a(paramXmlPullParser, new e());
      if (str != null)
      {
        String[] arrayOfString = a(str);
        int j = arrayOfString.length;
        for (int k = 0; k < j; k++)
          locale.a((e)paramMap.get(arrayOfString[k]));
      }
      if (locale.i() != null)
        paramMap.put(locale.i(), locale);
    }
    while (ai.a(paramXmlPullParser, "head"))
    {
      return paramMap;
      if (ai.b(paramXmlPullParser, "region"))
      {
        c localc = a(paramXmlPullParser, parama, paramc);
        if (localc != null)
          paramMap1.put(localc.a, localc);
      }
      else if (ai.b(paramXmlPullParser, "metadata"))
      {
        a(paramXmlPullParser, paramMap2);
      }
    }
  }

  private static void a(String paramString, e parame)
    throws g
  {
    String[] arrayOfString = ag.a(paramString, "\\s+");
    Matcher localMatcher;
    label22: String str;
    int j;
    if (arrayOfString.length == 1)
    {
      localMatcher = c.matcher(paramString);
      if (!localMatcher.matches())
        break label297;
      str = localMatcher.group(3);
      j = -1;
      switch (str.hashCode())
      {
      default:
      case 3592:
      case 3240:
      case 37:
      }
    }
    while (true)
      switch (j)
      {
      default:
        throw new g("Invalid unit for fontSize: '" + str + "'.");
        if (arrayOfString.length == 2)
        {
          localMatcher = c.matcher(arrayOfString[1]);
          l.c("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
          break label22;
        }
        throw new g("Invalid number of entries for fontSize: " + arrayOfString.length + ".");
        if (str.equals("px"))
        {
          j = 0;
          continue;
          if (str.equals("em"))
          {
            j = 1;
            continue;
            if (str.equals("%"))
              j = 2;
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    parame.c(1);
    while (true)
    {
      parame.a(Float.valueOf(localMatcher.group(1)).floatValue());
      return;
      parame.c(2);
      continue;
      parame.c(3);
    }
    label297: throw new g("Invalid expression for fontSize: '" + paramString + "'.");
  }

  private void a(XmlPullParser paramXmlPullParser, Map<String, String> paramMap)
    throws IOException, XmlPullParserException
  {
    do
    {
      paramXmlPullParser.next();
      if (ai.b(paramXmlPullParser, "image"))
      {
        String str = ai.c(paramXmlPullParser, "id");
        if (str != null)
          paramMap.put(str, paramXmlPullParser.nextText());
      }
    }
    while (!ai.a(paramXmlPullParser, "metadata"));
  }

  private String[] a(String paramString)
  {
    String str = paramString.trim();
    if (str.isEmpty())
      return new String[0];
    return ag.a(str, "\\s+");
  }

  private c b(XmlPullParser paramXmlPullParser)
  {
    String str = ai.c(paramXmlPullParser, "extent");
    if (str == null)
      return null;
    Matcher localMatcher = e.matcher(str);
    if (!localMatcher.matches())
    {
      l.c("TtmlDecoder", "Ignoring non-pixel tts extent: " + str);
      return null;
    }
    try
    {
      c localc = new c(Integer.parseInt(localMatcher.group(1)), Integer.parseInt(localMatcher.group(2)));
      return localc;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      l.c("TtmlDecoder", "Ignoring malformed tts extent: " + str);
    }
    return null;
  }

  private static boolean b(String paramString)
  {
    return (paramString.equals("tt")) || (paramString.equals("head")) || (paramString.equals("body")) || (paramString.equals("div")) || (paramString.equals("p")) || (paramString.equals("span")) || (paramString.equals("br")) || (paramString.equals("style")) || (paramString.equals("styling")) || (paramString.equals("layout")) || (paramString.equals("region")) || (paramString.equals("metadata")) || (paramString.equals("image")) || (paramString.equals("data")) || (paramString.equals("information"));
  }

  protected f b(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws g
  {
    while (true)
    {
      try
      {
        XmlPullParser localXmlPullParser = this.i.newPullParser();
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        HashMap localHashMap3 = new HashMap();
        localHashMap2.put("", new c(null));
        localXmlPullParser.setInput(new ByteArrayInputStream(paramArrayOfByte, 0, paramInt), null);
        localObject1 = null;
        ArrayDeque localArrayDeque = new ArrayDeque();
        j = 0;
        int k = localXmlPullParser.getEventType();
        localObject2 = g;
        a locala = h;
        c localc = null;
        int m = k;
        if (m != 1)
        {
          b localb1 = (b)localArrayDeque.peek();
          if (j == 0)
          {
            String str = localXmlPullParser.getName();
            if (m == 2)
            {
              if ("tt".equals(str))
              {
                localObject2 = a(localXmlPullParser);
                locala = a(localXmlPullParser, h);
                localc = b(localXmlPullParser);
              }
              if (!b(str))
              {
                l.b("TtmlDecoder", "Ignoring unsupported tag: " + localXmlPullParser.getName());
                int i2 = j + 1;
                localObject3 = localObject1;
                localObject4 = localObject2;
                i1 = i2;
                break label573;
                localXmlPullParser.next();
                m = localXmlPullParser.getEventType();
                continue;
              }
              if ("head".equals(str))
              {
                a(localXmlPullParser, localHashMap1, locala, localc, localHashMap2, localHashMap3);
                localObject4 = localObject2;
                i1 = j;
                localObject3 = localObject1;
                break label573;
              }
              try
              {
                b localb2 = a(localXmlPullParser, localb1, localHashMap2, (b)localObject2);
                localArrayDeque.push(localb2);
                if (localb1 != null)
                  localb1.a(localb2);
                localObject4 = localObject2;
                i1 = j;
                localObject3 = localObject1;
              }
              catch (g localg)
              {
                l.a("TtmlDecoder", "Suppressing parser error", localg);
                int n = j + 1;
                localObject3 = localObject1;
                localObject4 = localObject2;
                i1 = n;
              }
            }
            if (m == 4)
            {
              localb1.a(b.a(localXmlPullParser.getText()));
              localObject4 = localObject2;
              i1 = j;
              localObject3 = localObject1;
              break label573;
            }
            if (m != 3)
              break label561;
            if (!localXmlPullParser.getName().equals("tt"))
              break label554;
            localObject5 = new f((b)localArrayDeque.peek(), localHashMap1, localHashMap2, localHashMap3);
            localArrayDeque.pop();
            Object localObject6 = localObject2;
            i1 = j;
            localObject3 = localObject5;
            localObject4 = localObject6;
            break label573;
          }
          if (m == 2)
          {
            j++;
            continue;
          }
          if (m != 3)
            continue;
          j--;
          continue;
        }
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        throw new g("Unable to decode source", localXmlPullParserException);
      }
      catch (IOException localIOException)
      {
        throw new IllegalStateException("Unexpected error when reading input.", localIOException);
      }
      return localObject1;
      label554: Object localObject5 = localObject1;
      continue;
      label561: Object localObject4 = localObject2;
      int i1 = j;
      Object localObject3 = localObject1;
      label573: Object localObject1 = localObject3;
      int j = i1;
      Object localObject2 = localObject4;
    }
  }

  private static final class a
  {
    final int a;
    final int b;

    a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }

  private static final class b
  {
    final float a;
    final int b;
    final int c;

    b(float paramFloat, int paramInt1, int paramInt2)
    {
      this.a = paramFloat;
      this.b = paramInt1;
      this.c = paramInt2;
    }
  }

  private static final class c
  {
    final int a;
    final int b;

    c(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.e.f.a
 * JD-Core Version:    0.6.2
 */