package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

public class VastIconXmlManager
{
  public static final String DURATION = "duration";
  public static final String HEIGHT = "height";
  public static final String ICON_CLICKS = "IconClicks";
  public static final String ICON_CLICK_THROUGH = "IconClickThrough";
  public static final String ICON_CLICK_TRACKING = "IconClickTracking";
  public static final String ICON_VIEW_TRACKING = "IconViewTracking";
  public static final String OFFSET = "offset";
  public static final String WIDTH = "width";
  private final Node a;
  private final VastResourceXmlManager b;

  VastIconXmlManager(Node paramNode)
  {
    Preconditions.checkNotNull(paramNode);
    this.a = paramNode;
    this.b = new VastResourceXmlManager(paramNode);
  }

  Integer a()
  {
    return XmlUtils.getAttributeValueAsInt(this.a, "width");
  }

  Integer b()
  {
    return XmlUtils.getAttributeValueAsInt(this.a, "height");
  }

  Integer c()
  {
    String str = XmlUtils.getAttributeValue(this.a, "offset");
    try
    {
      Integer localInteger = Strings.parseAbsoluteOffset(str);
      return localInteger;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = String.format("Invalid VAST icon offset format: %s:", new Object[] { str });
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return null;
  }

  Integer d()
  {
    String str = XmlUtils.getAttributeValue(this.a, "duration");
    try
    {
      Integer localInteger = Strings.parseAbsoluteOffset(str);
      return localInteger;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = String.format("Invalid VAST icon duration format: %s:", new Object[] { str });
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
    }
    return null;
  }

  VastResourceXmlManager e()
  {
    return this.b;
  }

  List<VastTracker> f()
  {
    Node localNode = XmlUtils.getFirstMatchingChildNode(this.a, "IconClicks");
    ArrayList localArrayList = new ArrayList();
    if (localNode == null)
      return localArrayList;
    Iterator localIterator = XmlUtils.getMatchingChildNodes(localNode, "IconClickTracking").iterator();
    while (localIterator.hasNext())
    {
      String str = XmlUtils.getNodeValue((Node)localIterator.next());
      if (str != null)
        localArrayList.add(new VastTracker(str));
    }
    return localArrayList;
  }

  String g()
  {
    Node localNode = XmlUtils.getFirstMatchingChildNode(this.a, "IconClicks");
    if (localNode == null)
      return null;
    return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(localNode, "IconClickThrough"));
  }

  List<VastTracker> h()
  {
    List localList = XmlUtils.getMatchingChildNodes(this.a, "IconViewTracking");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      String str = XmlUtils.getNodeValue((Node)localIterator.next());
      if (str != null)
        localArrayList.add(new VastTracker(str));
    }
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastIconXmlManager
 * JD-Core Version:    0.6.2
 */