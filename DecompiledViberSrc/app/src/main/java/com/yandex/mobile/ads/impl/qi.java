package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import com.yandex.mobile.ads.video.models.ad.Creative;
import com.yandex.mobile.ads.video.models.ad.Icon;
import com.yandex.mobile.ads.video.models.ad.Icon.IconResourceType;
import com.yandex.mobile.ads.video.models.ad.MediaFile;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import com.yandex.mobile.ads.video.models.blocksinfo.Block;
import com.yandex.mobile.ads.video.models.blocksinfo.BlocksInfo;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class qi
{
  private static List<String> a(XmlPullParser paramXmlPullParser, Creative paramCreative)
    throws IOException, XmlPullParserException
  {
    ArrayList localArrayList = new ArrayList();
    b(paramXmlPullParser, "VideoClicks");
    while (m(paramXmlPullParser))
      if (l(paramXmlPullParser))
      {
        String str1 = paramXmlPullParser.getName();
        if (TextUtils.equals(str1, "ClickThrough"))
        {
          b(paramXmlPullParser, "ClickThrough");
          localArrayList.add(k(paramXmlPullParser));
        }
        else if (TextUtils.equals(str1, "ClickTracking"))
        {
          b(paramXmlPullParser, "ClickTracking");
          String str2 = k(paramXmlPullParser);
          if (!TextUtils.isEmpty(str2))
            fn.a(paramCreative, "addTrackingEvent", new Object[] { "clickTracking", str2 });
        }
        else
        {
          j(paramXmlPullParser);
        }
      }
    return localArrayList;
  }

  private static void a(Object paramObject, XmlPullParser paramXmlPullParser, String paramString1, String paramString2)
    throws IOException, XmlPullParserException
  {
    fn.a(paramObject, paramString2, new Object[] { paramXmlPullParser.getAttributeValue(null, paramString1) });
  }

  private static void a(XmlPullParser paramXmlPullParser, VideoAd paramVideoAd)
    throws IOException, XmlPullParserException
  {
    a locala = new a(paramVideoAd, paramXmlPullParser, (byte)0);
    String str = paramXmlPullParser.getName();
    if (TextUtils.equals(str, "Impression"))
    {
      a.a(locala, "Impression", "addImpression");
      return;
    }
    if (TextUtils.equals(str, "Error"))
    {
      a.a(locala, "Error", "addError");
      return;
    }
    if (TextUtils.equals(str, "Survey"))
    {
      a.a(locala, "Survey", "setSurvey");
      return;
    }
    if (TextUtils.equals(str, "Description"))
    {
      a.a(locala, "Description", "setDescription");
      return;
    }
    if (TextUtils.equals(str, "AdTitle"))
    {
      a.a(locala, "AdTitle", "setAdTitle");
      return;
    }
    if (TextUtils.equals(str, "AdSystem"))
    {
      a.a(locala, "AdSystem", "setAdSystem");
      return;
    }
    if (TextUtils.equals(str, "Creatives"))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = c(paramXmlPullParser);
      fn.a(paramVideoAd, "addCreatives", arrayOfObject);
      return;
    }
    j(paramXmlPullParser);
  }

  private VideoAd b(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Boolean.FALSE;
    VideoAd localVideoAd = (VideoAd)fn.a(VideoAd.class, arrayOfObject1);
    b(paramXmlPullParser, "Ad");
    while (m(paramXmlPullParser))
      if (l(paramXmlPullParser))
      {
        String str = paramXmlPullParser.getName();
        if (str.equals("InLine"))
        {
          Object[] arrayOfObject3 = new Object[1];
          arrayOfObject3[0] = Boolean.FALSE;
          localVideoAd = (VideoAd)fn.a(VideoAd.class, arrayOfObject3);
          b(paramXmlPullParser, "InLine");
          while (m(paramXmlPullParser))
            if (l(paramXmlPullParser))
              a(paramXmlPullParser, localVideoAd);
        }
        else if (str.equals("Wrapper"))
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Boolean.TRUE;
          localVideoAd = (VideoAd)fn.a(VideoAd.class, arrayOfObject2);
          b(paramXmlPullParser, "Wrapper");
          while (m(paramXmlPullParser))
            if (l(paramXmlPullParser))
              if (TextUtils.equals(paramXmlPullParser.getName(), "VASTAdTagURI"))
              {
                b(paramXmlPullParser, "VASTAdTagURI");
                fn.a(localVideoAd, "setVastAdTagUri", new Object[] { k(paramXmlPullParser) });
              }
              else
              {
                a(paramXmlPullParser, localVideoAd);
              }
        }
      }
    return localVideoAd;
  }

  public static BlocksInfo b(String paramString)
    throws XmlPullParserException, IOException
  {
    BlocksInfo localBlocksInfo = (BlocksInfo)fn.a(BlocksInfo.class, new Object[0]);
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
    localXmlPullParser.setInput(new StringReader(paramString));
    localXmlPullParser.nextTag();
    b(localXmlPullParser, "Blocksinfo");
    b localb = new b(localBlocksInfo, localXmlPullParser, (byte)0);
    while (m(localXmlPullParser))
    {
      String str = localXmlPullParser.getName();
      if (l(localXmlPullParser))
        if (TextUtils.equals(str, "Version"))
          b.a(localb, "Version", "setVersion");
        else if (TextUtils.equals(str, "PartnerID"))
          b.a(localb, "PartnerID", "setPartnerId");
        else if (TextUtils.equals(str, "SessionID"))
          b.a(localb, "SessionID", "setSessionId");
        else if (TextUtils.equals(str, "CategoryID"))
          b.a(localb, "CategoryID", "setCategoryId");
        else if (TextUtils.equals(str, "CategoryName"))
          b.a(localb, "CategoryName", "setCategoryName");
        else if (TextUtils.equals(str, "Skin"))
          b.a(localb, "Skin", "setSkin");
        else if (TextUtils.equals(str, "VPAIDEnabled"))
          b.a(localb, "VPAIDEnabled", "setVPaidEnabled");
        else if (TextUtils.equals(str, "BufferEmptyLimit"))
          b.a(localb, "BufferEmptyLimit", "setBufferEmptyLimit");
        else if (TextUtils.equals(str, "Title"))
          b.a(localb, "Title", "setTitle");
        else if (TextUtils.equals(str, "SkipDelay"))
          b.a(localb, "SkipDelay", "setSkipDelay");
        else if (TextUtils.equals(str, "SkinTimeout"))
          b.a(localb, "SkinTimeout", "setSkinTimeout");
        else if (TextUtils.equals(str, "VPAIDTimeout"))
          b.a(localb, "VPAIDTimeout", "setVpaidTimeout");
        else if (TextUtils.equals(str, "WrapperTimeout"))
          b.a(localb, "WrapperTimeout", "setWrapperTimeout");
        else if (TextUtils.equals(str, "VideoTimeout"))
          b.a(localb, "VideoTimeout", "setVideoTimeout");
        else if (TextUtils.equals(str, "VASTTimeout"))
          b.a(localb, "VASTTimeout", "setVastTimeout");
        else if (TextUtils.equals(str, "TimeLeftShow"))
          b.a(localb, "TimeLeftShow", "setShowTimeLeft");
        else if (TextUtils.equals(str, "SkipTimeLeftShow"))
          b.a(localb, "SkipTimeLeftShow", "setShowSkipTimeLeft");
        else if (TextUtils.equals(str, "BufferFullTimeout"))
          b.a(localb, "BufferFullTimeout", "setBufferFullTimeout");
        else if (TextUtils.equals(str, "WrapperMaxCount"))
          b.a(localb, "WrapperMaxCount", "setWrapperMaxCount");
        else if (TextUtils.equals(str, "FirstBuffTimeout"))
          b.a(localb, "FirstBuffTimeout", "setFirstBuffTimeout");
        else if (TextUtils.equals(str, "Blocks"))
          fn.a(localBlocksInfo, "addBlocks", new Object[] { h(localXmlPullParser) });
        else
          j(localXmlPullParser);
    }
    return localBlocksInfo;
  }

  private static void b(XmlPullParser paramXmlPullParser, String paramString)
    throws IOException, XmlPullParserException
  {
    paramXmlPullParser.require(2, null, paramString);
  }

  private static List<Creative> c(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    ArrayList localArrayList = new ArrayList();
    b(paramXmlPullParser, "Creatives");
    while (m(paramXmlPullParser))
      if (l(paramXmlPullParser))
        if (TextUtils.equals(paramXmlPullParser.getName(), "Creative"))
        {
          Creative localCreative = d(paramXmlPullParser);
          if (localCreative != null)
            localArrayList.add(localCreative);
        }
        else
        {
          j(paramXmlPullParser);
        }
    return localArrayList;
  }

  private static Creative d(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    b(paramXmlPullParser, "Creative");
    String str1 = paramXmlPullParser.getAttributeValue(null, "id");
    Creative localCreative = null;
    while (m(paramXmlPullParser))
      if (l(paramXmlPullParser))
        if (TextUtils.equals(paramXmlPullParser.getName(), "Linear"))
        {
          localCreative = (Creative)fn.a(Creative.class, new Object[0]);
          if (localCreative != null)
          {
            b(paramXmlPullParser, "Linear");
            fn.a(localCreative, "setId", new Object[] { str1 });
            while (m(paramXmlPullParser))
            {
              String str2 = paramXmlPullParser.getName();
              if (l(paramXmlPullParser))
                if (TextUtils.equals(str2, "Duration"))
                {
                  b(paramXmlPullParser, "Duration");
                  Object[] arrayOfObject5 = new Object[1];
                  arrayOfObject5[0] = k(paramXmlPullParser);
                  fn.a(localCreative, "setDurationHHMMSS", arrayOfObject5);
                }
                else if (TextUtils.equals(str2, "TrackingEvents"))
                {
                  Object[] arrayOfObject4 = new Object[1];
                  ArrayList localArrayList = new ArrayList();
                  b(paramXmlPullParser, "TrackingEvents");
                  while (m(paramXmlPullParser))
                    if (l(paramXmlPullParser))
                      if (TextUtils.equals(paramXmlPullParser.getName(), "Tracking"))
                      {
                        b(paramXmlPullParser, "Tracking");
                        String str3 = paramXmlPullParser.getAttributeValue(null, "event");
                        String str4 = k(paramXmlPullParser);
                        if (!TextUtils.isEmpty(str4))
                          localArrayList.add(new Pair(str3, str4));
                      }
                      else
                      {
                        j(paramXmlPullParser);
                      }
                  arrayOfObject4[0] = localArrayList;
                  fn.a(localCreative, "addTrackingEvents", arrayOfObject4);
                }
                else if (TextUtils.equals(str2, "MediaFiles"))
                {
                  Object[] arrayOfObject3 = new Object[1];
                  arrayOfObject3[0] = g(paramXmlPullParser);
                  fn.a(localCreative, "addMediaFiles", arrayOfObject3);
                }
                else if (TextUtils.equals(str2, "VideoClicks"))
                {
                  Object[] arrayOfObject2 = new Object[1];
                  arrayOfObject2[0] = a(paramXmlPullParser, localCreative);
                  fn.a(localCreative, "addClickThroughUrls", arrayOfObject2);
                }
                else if (TextUtils.equals(str2, "Icons"))
                {
                  Object[] arrayOfObject1 = new Object[1];
                  arrayOfObject1[0] = e(paramXmlPullParser);
                  fn.a(localCreative, "addIcons", arrayOfObject1);
                }
                else
                {
                  j(paramXmlPullParser);
                }
            }
          }
        }
        else
        {
          j(paramXmlPullParser);
        }
    return localCreative;
  }

  private static List<Icon> e(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    ArrayList localArrayList = new ArrayList();
    b(paramXmlPullParser, "Icons");
    while (m(paramXmlPullParser))
      if (l(paramXmlPullParser))
        if (TextUtils.equals(paramXmlPullParser.getName(), "Icon"))
          localArrayList.add(f(paramXmlPullParser));
        else
          j(paramXmlPullParser);
    return localArrayList;
  }

  private static Icon f(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    Icon localIcon = (Icon)fn.a(Icon.class, new Object[0]);
    b(paramXmlPullParser, "Icon");
    a(localIcon, paramXmlPullParser, "program", "setProgram");
    a(localIcon, paramXmlPullParser, "height", "setHeight");
    a(localIcon, paramXmlPullParser, "width", "setWidth");
    a(localIcon, paramXmlPullParser, "xPosition", "setHorizontalPosition");
    a(localIcon, paramXmlPullParser, "yPosition", "setVerticalPosition");
    a(localIcon, paramXmlPullParser, "apiFramework", "setApiFramework");
    a(localIcon, paramXmlPullParser, "offset", "setOffset");
    a(localIcon, paramXmlPullParser, "duration", "setDuration");
    while (m(paramXmlPullParser))
      if (l(paramXmlPullParser))
      {
        String str1 = paramXmlPullParser.getName();
        if (Icon.IconResourceType.contains(str1))
        {
          b(paramXmlPullParser, str1);
          String str2 = k(paramXmlPullParser);
          fn.a(localIcon, "setResourceType", new Object[] { str1 });
          fn.a(localIcon, "setResourceUrl", new Object[] { str2 });
        }
      }
    return localIcon;
  }

  private static List<MediaFile> g(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    ArrayList localArrayList = new ArrayList();
    b(paramXmlPullParser, "MediaFiles");
    while (m(paramXmlPullParser))
      if (l(paramXmlPullParser))
        if (TextUtils.equals(paramXmlPullParser.getName(), "MediaFile"))
        {
          MediaFile localMediaFile = (MediaFile)fn.a(MediaFile.class, new Object[0]);
          b(paramXmlPullParser, "MediaFile");
          a(localMediaFile, paramXmlPullParser, "id", "setId");
          a(localMediaFile, paramXmlPullParser, "delivery", "setDeliveryMethod");
          a(localMediaFile, paramXmlPullParser, "height", "setHeight");
          a(localMediaFile, paramXmlPullParser, "width", "setWidth");
          a(localMediaFile, paramXmlPullParser, "bitrate", "setBitrate");
          a(localMediaFile, paramXmlPullParser, "type", "setMimeType");
          fn.a(localMediaFile, "setUri", new Object[] { k(paramXmlPullParser) });
          localArrayList.add(localMediaFile);
        }
        else
        {
          j(paramXmlPullParser);
        }
    return localArrayList;
  }

  private static List<Block> h(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    ArrayList localArrayList = new ArrayList();
    b(paramXmlPullParser, "Blocks");
    while (m(paramXmlPullParser))
      if (l(paramXmlPullParser))
        if (TextUtils.equals(paramXmlPullParser.getName(), "Block"))
          localArrayList.add(i(paramXmlPullParser));
        else
          j(paramXmlPullParser);
    return localArrayList;
  }

  private static Block i(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    Block localBlock = (Block)fn.a(Block.class, new Object[0]);
    b(paramXmlPullParser, "Block");
    fn.a(localBlock, "setType", new Object[] { paramXmlPullParser.getAttributeValue(null, "type") });
    fn.a(localBlock, "setId", new Object[] { paramXmlPullParser.getAttributeValue(null, "BlockID") });
    while (m(paramXmlPullParser))
      if (l(paramXmlPullParser))
      {
        String str = paramXmlPullParser.getName();
        if (TextUtils.equals(str, "StartTime"))
        {
          Object[] arrayOfObject3 = new Object[1];
          arrayOfObject3[0] = k(paramXmlPullParser);
          fn.a(localBlock, "setStartTime", arrayOfObject3);
        }
        else if (TextUtils.equals(str, "Duration"))
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = k(paramXmlPullParser);
          fn.a(localBlock, "setDuration", arrayOfObject2);
        }
        else if (TextUtils.equals(str, "PositionsCount"))
        {
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = k(paramXmlPullParser);
          fn.a(localBlock, "setPositionsCount", arrayOfObject1);
        }
        else
        {
          j(paramXmlPullParser);
        }
      }
    return localBlock;
  }

  private static void j(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    if (paramXmlPullParser.getEventType() != 2)
      throw new IllegalStateException();
    int i = 1;
    while (i != 0)
      switch (paramXmlPullParser.next())
      {
      default:
        break;
      case 2:
        i++;
        break;
      case 3:
        i--;
      }
  }

  private static String k(XmlPullParser paramXmlPullParser)
    throws IOException, XmlPullParserException
  {
    String str = "";
    if (paramXmlPullParser.next() == 4)
    {
      str = paramXmlPullParser.getText();
      paramXmlPullParser.nextTag();
    }
    return str.trim();
  }

  private static boolean l(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException
  {
    return paramXmlPullParser.getEventType() == 2;
  }

  private static boolean m(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    return paramXmlPullParser.next() != 3;
  }

  public final List<VideoAd> a(String paramString)
    throws XmlPullParserException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
    localXmlPullParser.setInput(new StringReader(paramString));
    localXmlPullParser.nextTag();
    b(localXmlPullParser, "VAST");
    while (m(localXmlPullParser))
      if ((l(localXmlPullParser)) && (localXmlPullParser.getName().equals("Ad")))
        localArrayList.add(b(localXmlPullParser));
    return localArrayList;
  }

  private static final class a
  {
    private VideoAd a;
    private XmlPullParser b;

    private a(VideoAd paramVideoAd, XmlPullParser paramXmlPullParser)
    {
      this.a = paramVideoAd;
      this.b = paramXmlPullParser;
    }
  }

  private static final class b
  {
    private BlocksInfo a;
    private XmlPullParser b;

    private b(BlocksInfo paramBlocksInfo, XmlPullParser paramXmlPullParser)
    {
      this.a = paramBlocksInfo;
      this.b = paramXmlPullParser;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.qi
 * JD-Core Version:    0.6.2
 */