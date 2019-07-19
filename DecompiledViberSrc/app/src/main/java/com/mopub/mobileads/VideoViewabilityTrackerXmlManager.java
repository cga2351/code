package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

public class VideoViewabilityTrackerXmlManager
{
  public static final String PERCENT_VIEWABLE = "percentViewable";
  public static final String VIEWABLE_PLAYTIME = "viewablePlaytime";
  private final Node a;

  VideoViewabilityTrackerXmlManager(Node paramNode)
  {
    Preconditions.checkNotNull(paramNode);
    this.a = paramNode;
  }

  Integer a()
  {
    String str = XmlUtils.getAttributeValue(this.a, "viewablePlaytime");
    if (str == null)
      return null;
    if (Strings.isAbsoluteTracker(str));
    while (true)
    {
      Object localObject;
      try
      {
        Integer localInteger2 = Strings.parseAbsoluteOffset(str);
        localObject = localInteger2;
        if ((localObject == null) || (((Integer)localObject).intValue() < 0))
          break;
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = String.format("Invalid VAST viewablePlaytime format for \"HH:MM:SS[.mmm]\": %s:", new Object[] { str });
        MoPubLog.log(localSdkLogEvent2, arrayOfObject2);
        localObject = null;
        continue;
      }
      try
      {
        Integer localInteger1 = Integer.valueOf((int)(1000.0F * Float.parseFloat(str)));
        localObject = localInteger1;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = String.format("Invalid VAST viewablePlaytime format for \"SS[.mmm]\": %s:", new Object[] { str });
        MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
        localObject = null;
      }
    }
  }

  Integer b()
  {
    String str = XmlUtils.getAttributeValue(this.a, "percentViewable");
    if (str == null);
    while (true)
    {
      return null;
      try
      {
        Integer localInteger2 = Integer.valueOf((int)Float.parseFloat(str.replace("%", "")));
        localInteger1 = localInteger2;
        if ((localInteger1 == null) || (localInteger1.intValue() < 0) || (localInteger1.intValue() > 100))
          continue;
        return localInteger1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
        {
          MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = String.format("Invalid VAST percentViewable format for \"d{1,3}%%\": %s:", new Object[] { str });
          MoPubLog.log(localSdkLogEvent, arrayOfObject);
          Integer localInteger1 = null;
        }
      }
    }
  }

  String c()
  {
    return XmlUtils.getNodeValue(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VideoViewabilityTrackerXmlManager
 * JD-Core Version:    0.6.2
 */