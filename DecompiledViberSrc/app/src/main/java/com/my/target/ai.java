package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.my.target.common.a.a;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ai<T extends h>
{
  private static final String[] a = { "video/mp4", "application/vnd.apple.mpegurl", "application/x-mpegurl" };
  private static final String[] b = { "linkTxt" };
  private final z c;
  private final f d;
  private final Context e;
  private final ArrayList<p> f = new ArrayList();
  private final ArrayList<o> g = new ArrayList();
  private final ArrayList<j> h = new ArrayList();
  private final ArrayList<p> i = new ArrayList();
  private final ArrayList<k<T>> j = new ArrayList();
  private boolean k;
  private String l;
  private f m;

  private ai(z paramz, f paramf, Context paramContext)
  {
    this.c = paramz;
    this.d = paramf;
    this.e = paramContext;
  }

  public static <T extends h> ai<T> a(z paramz, f paramf, Context paramContext)
  {
    return new ai(paramz, paramf, paramContext);
  }

  private static String a(String paramString, XmlPullParser paramXmlPullParser)
  {
    return paramXmlPullParser.getAttributeValue(null, paramString);
  }

  private void a(float paramFloat, String paramString, i parami)
  {
    o localo = o.a(paramString);
    if ((parami != null) && (parami.A() > 0.0F))
    {
      localo.a(parami.A() * (paramFloat / 100.0F));
      parami.y().a(localo);
      return;
    }
    localo.b(paramFloat);
    this.g.add(localo);
  }

  private void a(String paramString1, String paramString2, i parami)
  {
    if (parami != null)
    {
      p localp = p.a(paramString1, paramString2);
      parami.y().a(localp);
      return;
    }
    this.i.add(p.a(paramString1, paramString2));
  }

  private void a(String paramString1, String paramString2, String paramString3)
  {
    y.a(paramString2).b(paramString3).a(this.c.c()).d(paramString1).c(this.d.f()).a(this.e);
  }

  private static void a(XmlPullParser paramXmlPullParser)
  {
    if (e(paramXmlPullParser) != 2);
    while (true)
    {
      return;
      int n = 1;
      while (n != 0)
        switch (b(paramXmlPullParser))
        {
        default:
          break;
        case 2:
          n++;
          break;
        case 3:
          n--;
        }
    }
  }

  private void a(XmlPullParser paramXmlPullParser, int paramInt)
  {
    String str1 = null;
    while (d(paramXmlPullParser) == 2)
      if (e(paramXmlPullParser) == 2)
      {
        String str3 = paramXmlPullParser.getName();
        if ("Impression".equals(str3))
          j(paramXmlPullParser);
        else if ("Creatives".equals(str3))
          k(paramXmlPullParser);
        else if ("Extensions".equals(str3))
          i(paramXmlPullParser);
        else if ("VASTAdTagURI".equals(str3))
          str1 = c(paramXmlPullParser);
        else
          a(paramXmlPullParser);
      }
    if (str1 != null)
    {
      this.m = f.a(str1);
      this.m.b(paramInt + 1);
      this.m.b(this.f);
      f localf = this.m;
      if (this.l != null);
      for (String str2 = this.l; ; str2 = this.d.m())
      {
        localf.c(str2);
        this.m.a(this.h);
        q localq = this.m.q();
        localq.a(this.i);
        localq.b(this.g);
        localq.a(this.d.q(), -1.0F);
        this.d.a(this.m);
        return;
      }
    }
    dp.a("got VAST wrapper, but no vastAdTagUri");
  }

  private void a(XmlPullParser paramXmlPullParser, i parami)
  {
    while (d(paramXmlPullParser) == 2)
      if (e(paramXmlPullParser) == 2)
      {
        if ("Tracking".equals(paramXmlPullParser.getName()))
        {
          String str1 = a("event", paramXmlPullParser);
          String str2 = a("offset", paramXmlPullParser);
          if (str1 != null)
          {
            if ((!"progress".equals(str1)) || (TextUtils.isEmpty(str2)))
              break label173;
            if (!str2.endsWith("%"))
              break label159;
          }
          while (true)
          {
            try
            {
              a(Integer.parseInt(str2.replace("%", "")), c(paramXmlPullParser), parami);
              dp.a("Added VAST tracking \"" + str1 + "\"");
            }
            catch (Exception localException)
            {
              dp.a("Unable to parse progress stat with value " + str2);
              continue;
            }
            label159: b(str2, c(paramXmlPullParser), parami);
            continue;
            label173: c(str1, c(paramXmlPullParser), parami);
          }
        }
        a(paramXmlPullParser);
      }
  }

  private void a(XmlPullParser paramXmlPullParser, k paramk)
  {
    while (d(paramXmlPullParser) == 2)
      if (e(paramXmlPullParser) == 2)
      {
        String str1 = paramXmlPullParser.getName();
        if ("Linear".equals(str1))
        {
          a(paramXmlPullParser, paramk, a("skipoffset", paramXmlPullParser));
        }
        else
        {
          if ((str1 != null) && (str1.equals("CompanionAds")))
          {
            String str2 = a("required", paramXmlPullParser);
            String str4;
            if ((str2 != null) && (!"all".equals(str2)) && (!"any".equals(str2)) && (!"none".equals(str2)))
            {
              if (paramk != null)
              {
                str4 = paramk.k();
                label120: a(str4, "Bad value", "Wrong companion required attribute:" + str2);
                str2 = null;
              }
            }
            else
              if (paramk == null)
                break label181;
            label181: for (String str3 = paramk.k(); ; str3 = null)
            {
              a(paramXmlPullParser, str3, str2);
              break;
              str4 = null;
              break label120;
            }
          }
          a(paramXmlPullParser);
        }
      }
  }

  private void a(XmlPullParser paramXmlPullParser, k paramk, String paramString)
  {
    while (true)
    {
      String str;
      if (d(paramXmlPullParser) == 2)
      {
        str = paramXmlPullParser.getName();
        if (e(paramXmlPullParser) == 2)
          if ("Duration".equals(str))
          {
            if (paramk == null)
              continue;
            if (b(paramXmlPullParser, paramk));
          }
      }
      else
      {
        return;
        a(paramk, paramString);
        continue;
        if ("TrackingEvents".equals(str))
          a(paramXmlPullParser, paramk);
        else if ("MediaFiles".equals(str))
        {
          if (paramk != null)
          {
            d(paramXmlPullParser, paramk);
            if (paramk.F() == null)
              dp.a("Unable to find valid mediafile!");
          }
        }
        else if ("VideoClicks".equals(str))
          c(paramXmlPullParser, paramk);
        else
          a(paramXmlPullParser);
      }
    }
  }

  private void a(XmlPullParser paramXmlPullParser, String paramString)
  {
    if ("linkTxt".equals(paramString))
    {
      String str = c(paramXmlPullParser);
      this.l = bk.a(str);
      dp.a("VAST linkTxt raw text: " + str);
    }
  }

  private void a(XmlPullParser paramXmlPullParser, String paramString1, String paramString2)
  {
    while (d(paramXmlPullParser) == 2)
      b(paramXmlPullParser, paramString1, paramString2);
  }

  private static int b(XmlPullParser paramXmlPullParser)
  {
    try
    {
      int n = paramXmlPullParser.next();
      return n;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      dp.a(localXmlPullParserException.getMessage());
      return -2147483648;
    }
    catch (IOException localIOException)
    {
      while (true)
        dp.a(localIOException.getMessage());
    }
  }

  private void b(String paramString1, String paramString2, i parami)
  {
    float f1 = -1.0F;
    try
    {
      float f2 = b(paramString1);
      f1 = f2;
      label15: if (f1 >= 0.0F)
      {
        o localo = o.a(paramString2);
        localo.a(f1);
        if (parami != null)
        {
          parami.y().a(localo);
          return;
        }
        this.i.add(localo);
        return;
      }
      dp.a("Unable to parse progress stat with value " + paramString1);
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }

  private void b(XmlPullParser paramXmlPullParser, String paramString1, String paramString2)
  {
    if (e(paramXmlPullParser) != 2);
    while (true)
    {
      return;
      String str1 = paramXmlPullParser.getName();
      if ((str1 != null) && (str1.equals("Companion")))
      {
        String str2 = a("width", paramXmlPullParser);
        String str3 = a("height", paramXmlPullParser);
        String str4 = a("id", paramXmlPullParser);
        j localj = j.D();
        if (str4 != null)
          label70: localj.j(str4);
        try
        {
          localj.c(Integer.parseInt(str2));
          localj.a(Integer.parseInt(str3));
          localj.v(paramString2);
          str5 = a("assetWidth", paramXmlPullParser);
          str6 = a("assetHeight", paramXmlPullParser);
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          try
          {
            String str5;
            String str6;
            if (!TextUtils.isEmpty(str5))
              localj.d(Integer.parseInt(str5));
            if (!TextUtils.isEmpty(str6))
              localj.e(Integer.parseInt(str6));
            str7 = a("expandedWidth", paramXmlPullParser);
            str8 = a("expandedHeight", paramXmlPullParser);
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            try
            {
              while (true)
              {
                String str7;
                String str8;
                if (!TextUtils.isEmpty(str7))
                  localj.f(Integer.parseInt(str7));
                if (!TextUtils.isEmpty(str8))
                  localj.g(Integer.parseInt(str8));
                localj.u(a("adSlotID", paramXmlPullParser));
                localj.t(a("apiFramework", paramXmlPullParser));
                this.h.add(localj);
                while (d(paramXmlPullParser) == 2)
                {
                  str9 = paramXmlPullParser.getName();
                  if (!"StaticResource".equals(str9))
                    break label403;
                  localj.q(bk.a(c(paramXmlPullParser)));
                }
                str4 = "";
                break label70;
                localNumberFormatException1 = localNumberFormatException1;
                a(paramString1, "Bad value", "Unable  to convert required companion attributes, width = " + str2 + " height = " + str3);
              }
              localNumberFormatException2 = localNumberFormatException2;
              dp.a("wrong VAST asset dimensions: " + localNumberFormatException2.getMessage());
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              while (true)
              {
                String str9;
                dp.a("wrong VAST expanded dimensions " + localNumberFormatException3.getMessage());
                continue;
                label403: if ("HTMLResource".equals(str9))
                {
                  localj.s(bk.a(c(paramXmlPullParser)));
                }
                else if ("IFrameResource".equals(str9))
                {
                  localj.r(bk.a(c(paramXmlPullParser)));
                }
                else if ("CompanionClickThrough".equals(str9))
                {
                  String str11 = c(paramXmlPullParser);
                  if (!TextUtils.isEmpty(str11))
                    localj.n(c(str11));
                }
                else if ("CompanionClickTracking".equals(str9))
                {
                  String str10 = c(paramXmlPullParser);
                  if (!TextUtils.isEmpty(str10))
                  {
                    p localp = p.a("click", str10);
                    localj.y().a(localp);
                  }
                }
                else if ("TrackingEvents".equals(str9))
                {
                  a(paramXmlPullParser, localj);
                }
                else
                {
                  a(paramXmlPullParser);
                }
              }
            }
          }
        }
      }
    }
    a(paramXmlPullParser);
  }

  private boolean b(XmlPullParser paramXmlPullParser, k paramk)
  {
    String str = c(paramXmlPullParser);
    try
    {
      float f2 = b(str);
      f1 = f2;
      if (f1 <= 0.0F)
        return false;
    }
    catch (Exception localException)
    {
      float f1;
      while (true)
        f1 = 0.0F;
      paramk.b(f1);
    }
    return true;
  }

  private static String c(String paramString)
  {
    return paramString.replaceAll("&amp;", "&").replaceAll("&lt;", "<").replaceAll("&gt;", ">").trim();
  }

  private static String c(XmlPullParser paramXmlPullParser)
  {
    String str = "";
    if (b(paramXmlPullParser) == 4)
    {
      str = paramXmlPullParser.getText();
      d(paramXmlPullParser);
    }
    while (true)
    {
      return str.trim();
      dp.a("No text: " + paramXmlPullParser.getName());
    }
  }

  private void c()
  {
    ArrayList localArrayList1 = this.d.h();
    if (localArrayList1 != null)
      this.f.addAll(localArrayList1);
    ArrayList localArrayList2 = this.d.i();
    if (localArrayList2 != null)
      this.h.addAll(localArrayList2);
  }

  private void c(String paramString1, String paramString2, i parami)
  {
    if ("start".equalsIgnoreCase(paramString1))
      a("playbackStarted", paramString2, parami);
    do
    {
      return;
      if ("firstQuartile".equalsIgnoreCase(paramString1))
      {
        a(25.0F, paramString2, parami);
        return;
      }
      if ("midpoint".equalsIgnoreCase(paramString1))
      {
        a(50.0F, paramString2, parami);
        return;
      }
      if ("thirdQuartile".equalsIgnoreCase(paramString1))
      {
        a(75.0F, paramString2, parami);
        return;
      }
      if ("complete".equalsIgnoreCase(paramString1))
      {
        a(100.0F, paramString2, parami);
        return;
      }
      if ("creativeView".equalsIgnoreCase(paramString1))
      {
        a("playbackStarted", paramString2, parami);
        return;
      }
      if ("mute".equalsIgnoreCase(paramString1))
      {
        a("volumeOff", paramString2, parami);
        return;
      }
      if ("unmute".equalsIgnoreCase(paramString1))
      {
        a("volumeOn", paramString2, parami);
        return;
      }
      if ("pause".equalsIgnoreCase(paramString1))
      {
        a("playbackPaused", paramString2, parami);
        return;
      }
      if ("resume".equalsIgnoreCase(paramString1))
      {
        a("playbackResumed", paramString2, parami);
        return;
      }
      if ("fullscreen".equalsIgnoreCase(paramString1))
      {
        a("fullscreenOn", paramString2, parami);
        return;
      }
      if ("exitFullscreen".equalsIgnoreCase(paramString1))
      {
        a("fullscreenOff", paramString2, parami);
        return;
      }
      if ("skip".equalsIgnoreCase(paramString1))
      {
        a("closedByUser", paramString2, parami);
        return;
      }
      if ("error".equalsIgnoreCase(paramString1))
      {
        a("error", paramString2, parami);
        return;
      }
      if ("ClickTracking".equalsIgnoreCase(paramString1))
      {
        a("click", paramString2, parami);
        return;
      }
    }
    while (!"close".equalsIgnoreCase(paramString1));
    a("closedByUser", paramString2, parami);
  }

  private void c(XmlPullParser paramXmlPullParser, k paramk)
  {
    while (d(paramXmlPullParser) == 2)
      if (e(paramXmlPullParser) == 2)
      {
        String str1 = paramXmlPullParser.getName();
        if ("ClickThrough".equals(str1))
        {
          if (paramk != null)
          {
            String str3 = c(paramXmlPullParser);
            if (!TextUtils.isEmpty(str3))
              paramk.n(c(str3));
          }
        }
        else if ("ClickTracking".equals(str1))
        {
          String str2 = c(paramXmlPullParser);
          if (!TextUtils.isEmpty(str2))
            this.i.add(p.a("click", str2));
        }
        else
        {
          a(paramXmlPullParser);
        }
      }
  }

  private static int d(XmlPullParser paramXmlPullParser)
  {
    try
    {
      int n = paramXmlPullParser.nextTag();
      return n;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      dp.a(localXmlPullParserException.getMessage());
      return -2147483648;
    }
    catch (IOException localIOException)
    {
      while (true)
        dp.a(localIOException.getMessage());
    }
  }

  private void d()
  {
    Iterator localIterator1 = this.j.iterator();
    while (localIterator1.hasNext())
    {
      k localk = (k)localIterator1.next();
      q localq = localk.y();
      localq.a(this.d.q(), localk.A());
      if (!TextUtils.isEmpty(this.l))
        localk.e(this.l);
      while (true)
      {
        Iterator localIterator2 = this.g.iterator();
        while (localIterator2.hasNext())
        {
          o localo = (o)localIterator2.next();
          a(localo.b(), localo.d(), localk);
        }
        if (!TextUtils.isEmpty(this.d.m()))
          localk.e(this.d.m());
      }
      Iterator localIterator3 = this.i.iterator();
      while (localIterator3.hasNext())
        localq.a((p)localIterator3.next());
      Iterator localIterator4 = this.h.iterator();
      while (localIterator4.hasNext())
        localk.a((j)localIterator4.next());
    }
  }

  private void d(XmlPullParser paramXmlPullParser, k paramk)
  {
    if (("instreamads".equals(this.c.b())) || ("fullscreen".equals(this.c.b())))
      f(paramXmlPullParser, paramk);
    while (!"instreamaudioads".equals(this.c.b()))
      return;
    e(paramXmlPullParser, paramk);
  }

  private static int e(XmlPullParser paramXmlPullParser)
  {
    try
    {
      int n = paramXmlPullParser.getEventType();
      return n;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      dp.a(localXmlPullParserException.getMessage());
    }
    return -2147483648;
  }

  private void e(XmlPullParser paramXmlPullParser, k<a> paramk)
  {
    while (true)
      if (d(paramXmlPullParser) == 2)
        if (e(paramXmlPullParser) == 2)
        {
          String str1;
          String str2;
          String str3;
          Object localObject;
          int n;
          if ("MediaFile".equals(paramXmlPullParser.getName()))
          {
            str1 = a("type", paramXmlPullParser);
            str2 = a("bitrate", paramXmlPullParser);
            str3 = c(c(paramXmlPullParser));
            boolean bool1 = TextUtils.isEmpty(str1);
            localObject = null;
            if (!bool1)
            {
              boolean bool2 = TextUtils.isEmpty(str3);
              localObject = null;
              if (!bool2)
              {
                boolean bool3 = str1.toLowerCase(Locale.ROOT).trim().startsWith("audio");
                localObject = null;
                if (bool3)
                {
                  n = 0;
                  if (str2 == null);
                }
              }
            }
          }
          try
          {
            int i1 = Integer.parseInt(str2);
            n = i1;
            a locala = a.a(str3);
            locala.c(n);
            localObject = locala;
            if (localObject == null)
            {
              dp.a("Skipping unsupported VAST file (mimetype=" + str1 + ",url=" + str3);
            }
            else
            {
              paramk.a(localObject);
              continue;
              a(paramXmlPullParser);
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            while (true)
              n = 0;
          }
        }
  }

  private void f(XmlPullParser paramXmlPullParser)
  {
    while (d(paramXmlPullParser) == 2)
      if ((e(paramXmlPullParser) == 2) && ("Ad".equals(paramXmlPullParser.getName())))
        g(paramXmlPullParser);
  }

  // ERROR //
  private void f(XmlPullParser paramXmlPullParser, k<com.my.target.common.a.c> paramk)
  {
    // Byte code:
    //   0: new 51	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 52	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_1
    //   9: invokestatic 152	com/my/target/ai:d	(Lorg/xmlpull/v1/XmlPullParser;)I
    //   12: iconst_2
    //   13: if_icmpne +332 -> 345
    //   16: aload_1
    //   17: invokestatic 147	com/my/target/ai:e	(Lorg/xmlpull/v1/XmlPullParser;)I
    //   20: iconst_2
    //   21: if_icmpne -13 -> 8
    //   24: ldc_w 576
    //   27: aload_1
    //   28: invokeinterface 155 1 0
    //   33: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +302 -> 338
    //   39: ldc_w 578
    //   42: aload_1
    //   43: invokestatic 224	com/my/target/ai:a	(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   46: astore 4
    //   48: ldc_w 580
    //   51: aload_1
    //   52: invokestatic 224	com/my/target/ai:a	(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   55: astore 5
    //   57: ldc_w 362
    //   60: aload_1
    //   61: invokestatic 224	com/my/target/ai:a	(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   64: astore 6
    //   66: ldc_w 364
    //   69: aload_1
    //   70: invokestatic 224	com/my/target/ai:a	(Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   73: astore 7
    //   75: aload_1
    //   76: invokestatic 175	com/my/target/ai:c	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   79: invokestatic 434	com/my/target/ai:c	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore 8
    //   84: aload 4
    //   86: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   89: ifne +297 -> 386
    //   92: aload 8
    //   94: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +289 -> 386
    //   100: getstatic 41	com/my/target/ai:a	[Ljava/lang/String;
    //   103: astore 11
    //   105: aload 11
    //   107: arraylength
    //   108: istore 12
    //   110: iconst_0
    //   111: istore 13
    //   113: iload 13
    //   115: iload 12
    //   117: if_icmpge +269 -> 386
    //   120: aload 11
    //   122: iload 13
    //   124: aaload
    //   125: aload 4
    //   127: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: ifeq +192 -> 322
    //   133: iconst_0
    //   134: istore 14
    //   136: iconst_0
    //   137: istore 15
    //   139: aload 6
    //   141: ifnull +151 -> 292
    //   144: aload 6
    //   146: invokestatic 252	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   149: istore 26
    //   151: iload 26
    //   153: istore 16
    //   155: aload 7
    //   157: ifnull +141 -> 298
    //   160: aload 7
    //   162: invokestatic 252	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   165: istore 24
    //   167: iload 24
    //   169: istore 17
    //   171: aload 5
    //   173: ifnull +131 -> 304
    //   176: aload 5
    //   178: invokestatic 252	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   181: istore 22
    //   183: iload 22
    //   185: istore 18
    //   187: iload 18
    //   189: istore 19
    //   191: iload 17
    //   193: istore 15
    //   195: iload 19
    //   197: istore 20
    //   199: iload 16
    //   201: ifle +185 -> 386
    //   204: iload 15
    //   206: ifle +180 -> 386
    //   209: aload 8
    //   211: iload 16
    //   213: iload 15
    //   215: invokestatic 617	com/my/target/common/a/c:a	(Ljava/lang/String;II)Lcom/my/target/common/a/c;
    //   218: astore 9
    //   220: aload 9
    //   222: iload 20
    //   224: invokevirtual 618	com/my/target/common/a/c:c	(I)V
    //   227: aload 9
    //   229: ifnonnull +99 -> 328
    //   232: new 256	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   239: ldc_w 620
    //   242: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 4
    //   247: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 622
    //   253: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload 6
    //   258: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: ldc_w 624
    //   264: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 7
    //   269: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 605
    //   275: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 8
    //   280: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 215	com/my/target/dp:a	(Ljava/lang/String;)V
    //   289: goto -281 -> 8
    //   292: iconst_0
    //   293: istore 16
    //   295: goto -140 -> 155
    //   298: iconst_0
    //   299: istore 17
    //   301: goto -130 -> 171
    //   304: iconst_0
    //   305: istore 18
    //   307: goto -120 -> 187
    //   310: astore 25
    //   312: iload 14
    //   314: istore 16
    //   316: iconst_0
    //   317: istore 20
    //   319: goto -120 -> 199
    //   322: iinc 13 1
    //   325: goto -212 -> 113
    //   328: aload_3
    //   329: aload 9
    //   331: invokevirtual 109	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   334: pop
    //   335: goto -327 -> 8
    //   338: aload_1
    //   339: invokestatic 177	com/my/target/ai:a	(Lorg/xmlpull/v1/XmlPullParser;)V
    //   342: goto -334 -> 8
    //   345: aload_2
    //   346: aload_3
    //   347: aload_0
    //   348: getfield 64	com/my/target/ai:c	Lcom/my/target/z;
    //   351: invokevirtual 626	com/my/target/z:h	()I
    //   354: invokestatic 629	com/my/target/common/a/c:a	(Ljava/util/List;I)Lcom/my/target/common/a/c;
    //   357: invokevirtual 608	com/my/target/k:a	(Lcom/my/target/h;)V
    //   360: return
    //   361: astore 23
    //   363: iload 16
    //   365: istore 14
    //   367: iconst_0
    //   368: istore 15
    //   370: goto -58 -> 312
    //   373: astore 21
    //   375: iload 17
    //   377: istore 15
    //   379: iload 16
    //   381: istore 14
    //   383: goto -71 -> 312
    //   386: aconst_null
    //   387: astore 9
    //   389: goto -162 -> 227
    //
    // Exception table:
    //   from	to	target	type
    //   144	151	310	java/lang/NumberFormatException
    //   160	167	361	java/lang/NumberFormatException
    //   176	183	373	java/lang/NumberFormatException
  }

  private void g(XmlPullParser paramXmlPullParser)
  {
    while (d(paramXmlPullParser) == 2)
      if (e(paramXmlPullParser) == 2)
      {
        String str = paramXmlPullParser.getName();
        if ("Wrapper".equals(str))
        {
          this.k = true;
          dp.a("VAST file contains wrapped ad information.");
          int n = this.d.j();
          if (n < 5)
          {
            a(paramXmlPullParser, n);
          }
          else
          {
            dp.a("got VAST wrapper, but max redirects limit exceeded");
            a(paramXmlPullParser);
          }
        }
        else if ("InLine".equals(str))
        {
          this.k = false;
          dp.a("VAST file contains inline ad information.");
          h(paramXmlPullParser);
        }
        else
        {
          a(paramXmlPullParser);
        }
      }
  }

  private void h(XmlPullParser paramXmlPullParser)
  {
    while (d(paramXmlPullParser) == 2)
      if (e(paramXmlPullParser) == 2)
      {
        String str = paramXmlPullParser.getName();
        if ("Impression".equals(str))
          j(paramXmlPullParser);
        else if ((str != null) && (str.equals("Creatives")))
          k(paramXmlPullParser);
        else if ((str != null) && (str.equals("Extensions")))
          i(paramXmlPullParser);
        else
          a(paramXmlPullParser);
      }
    d();
  }

  private void i(XmlPullParser paramXmlPullParser)
  {
    while (d(paramXmlPullParser) == 2)
      if (e(paramXmlPullParser) == 2)
        if ("Extension".equals(paramXmlPullParser.getName()))
        {
          String str = a("type", paramXmlPullParser);
          String[] arrayOfString = b;
          int n = arrayOfString.length;
          int i1 = 0;
          if (i1 < n)
          {
            if (arrayOfString[i1].equals(str))
              a(paramXmlPullParser, str);
            while (true)
            {
              i1++;
              break;
              a(paramXmlPullParser);
            }
          }
        }
        else
        {
          a(paramXmlPullParser);
        }
  }

  private void j(XmlPullParser paramXmlPullParser)
  {
    String str = c(paramXmlPullParser);
    if (!TextUtils.isEmpty(str))
    {
      this.f.add(p.a("impression", str));
      dp.a("Impression tracker url for wrapper: " + str);
    }
  }

  private void k(XmlPullParser paramXmlPullParser)
  {
    String str;
    k localk2;
    while (true)
      if (d(paramXmlPullParser) == 2)
        if (e(paramXmlPullParser) == 2)
          if ("Creative".equals(paramXmlPullParser.getName()))
          {
            str = a("id", paramXmlPullParser);
            if (this.k)
              break label150;
            localk2 = k.E();
            if (str != null)
              label55: localk2.j(str);
          }
    label150: for (k localk1 = localk2; ; localk1 = null)
    {
      a(paramXmlPullParser, localk1);
      if (localk1 == null)
        break;
      if (localk1.A() > 0.0F)
      {
        if (localk1.F() != null)
        {
          this.j.add(localk1);
          break;
          str = "";
          break label55;
        }
        a(localk1.k(), "Required field", "VAST has no valid mediaData");
        break;
      }
      a(localk1.k(), "Required field", "VAST has no valid Duration");
      break;
      a(paramXmlPullParser);
      break;
      return;
    }
  }

  public ArrayList<k<T>> a()
  {
    return this.j;
  }

  void a(k paramk, String paramString)
  {
    float f1 = -1.0F;
    if (paramString != null)
    {
      if (!paramString.contains("%"))
        break label85;
      int n = Integer.parseInt(paramString.substring(0, -1 + paramString.length()));
      dp.a("Linear skipoffset is " + paramString + " [%]");
      f1 = paramk.A() / 100.0F * n;
    }
    while (true)
    {
      if (f1 > 0.0F)
        paramk.c(f1);
      return;
      label85: if (paramString.contains(":"))
        try
        {
          float f2 = b(paramString);
          f1 = f2;
        }
        catch (Exception localException)
        {
          a(paramk.k(), "Bad value", "Failed to convert ISO time skipoffset string " + paramString);
        }
    }
  }

  public void a(String paramString)
  {
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    while (true)
    {
      try
      {
        localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        localXmlPullParser.setInput(new StringReader(paramString));
        c();
        n = e(localXmlPullParser);
        if ((n == 1) || (n == -2147483648))
          return;
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        dp.a("Unable to parse VAST: " + localXmlPullParserException.getMessage());
        return;
      }
      if ((n == 2) && ("VAST".equalsIgnoreCase(localXmlPullParser.getName())))
        f(localXmlPullParser);
      int n = b(localXmlPullParser);
    }
  }

  float b(String paramString)
  {
    long l1 = 0L;
    try
    {
      if (paramString.contains("."))
      {
        int i1 = paramString.indexOf(".");
        l1 = Long.parseLong(paramString.substring(i1 + 1));
        if (l1 > 1000L)
          return -1.0F;
        paramString = paramString.substring(0, i1);
      }
      String[] arrayOfString = paramString.split(":", 3);
      long l2 = Integer.parseInt(arrayOfString[0]);
      long l3 = Integer.parseInt(arrayOfString[1]);
      int n = Integer.parseInt(arrayOfString[2]);
      long l4 = n;
      if ((l2 < 24L) && (l3 < 60L) && (l4 < 60L))
        return (float)(l1 + 1000L * l4 + 60000L * l3 + 3600000L * l2) / 1000.0F;
    }
    catch (Exception localException)
    {
    }
    return -1.0F;
  }

  public ArrayList<p> b()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ai
 * JD-Core Version:    0.6.2
 */