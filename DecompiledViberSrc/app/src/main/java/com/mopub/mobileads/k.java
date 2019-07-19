package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Strings;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

class k
{
  public static final String ICON = "Icon";
  public static final String ICONS = "Icons";
  private final Node a;

  k(Node paramNode)
  {
    Preconditions.checkNotNull(paramNode);
    this.a = paramNode;
  }

  private List<VastTracker> a(String paramString)
  {
    List localList = b(paramString);
    ArrayList localArrayList = new ArrayList(localList.size());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(new VastTracker((String)localIterator.next()));
    return localArrayList;
  }

  private void a(List<VastFractionalProgressTracker> paramList, List<String> paramList1, float paramFloat)
  {
    Preconditions.checkNotNull(paramList, "trackers cannot be null");
    Preconditions.checkNotNull(paramList1, "urls cannot be null");
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
      paramList.add(new VastFractionalProgressTracker((String)localIterator.next(), paramFloat));
  }

  private List<String> b(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    ArrayList localArrayList = new ArrayList();
    Node localNode = XmlUtils.getFirstMatchingChildNode(this.a, "TrackingEvents");
    if (localNode == null)
      return localArrayList;
    Iterator localIterator = XmlUtils.getMatchingChildNodes(localNode, "Tracking", "event", Collections.singletonList(paramString)).iterator();
    while (localIterator.hasNext())
    {
      String str = XmlUtils.getNodeValue((Node)localIterator.next());
      if (str != null)
        localArrayList.add(str);
    }
    return localArrayList;
  }

  List<VastFractionalProgressTracker> a()
  {
    ArrayList localArrayList = new ArrayList();
    a(localArrayList, b("firstQuartile"), 0.25F);
    a(localArrayList, b("midpoint"), 0.5F);
    a(localArrayList, b("thirdQuartile"), 0.75F);
    Node localNode1 = XmlUtils.getFirstMatchingChildNode(this.a, "TrackingEvents");
    if (localNode1 != null)
    {
      Iterator localIterator = XmlUtils.getMatchingChildNodes(localNode1, "Tracking", "event", Collections.singletonList("progress")).iterator();
      while (localIterator.hasNext())
      {
        Node localNode2 = (Node)localIterator.next();
        String str1 = XmlUtils.getAttributeValue(localNode2, "offset");
        if (str1 != null)
        {
          String str2 = str1.trim();
          if (Strings.isPercentageTracker(str2))
          {
            String str3 = XmlUtils.getNodeValue(localNode2);
            try
            {
              float f = Float.parseFloat(str2.replace("%", "")) / 100.0F;
              if (f >= 0.0F)
                localArrayList.add(new VastFractionalProgressTracker(str3, f));
            }
            catch (NumberFormatException localNumberFormatException)
            {
              MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = String.format("Failed to parse VAST progress tracker %s", new Object[] { str2 });
              MoPubLog.log(localSdkLogEvent, arrayOfObject);
            }
          }
        }
      }
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }

  List<VastAbsoluteProgressTracker> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = b("start").iterator();
    while (localIterator1.hasNext())
      localArrayList.add(new VastAbsoluteProgressTracker((String)localIterator1.next(), 0));
    Node localNode1 = XmlUtils.getFirstMatchingChildNode(this.a, "TrackingEvents");
    if (localNode1 != null)
    {
      Iterator localIterator2 = XmlUtils.getMatchingChildNodes(localNode1, "Tracking", "event", Collections.singletonList("progress")).iterator();
      while (localIterator2.hasNext())
      {
        Node localNode2 = (Node)localIterator2.next();
        String str2 = XmlUtils.getAttributeValue(localNode2, "offset");
        if (str2 != null)
        {
          String str3 = str2.trim();
          if (Strings.isAbsoluteTracker(str3))
          {
            String str4 = XmlUtils.getNodeValue(localNode2);
            try
            {
              Integer localInteger = Strings.parseAbsoluteOffset(str3);
              if ((localInteger != null) && (localInteger.intValue() >= 0))
                localArrayList.add(new VastAbsoluteProgressTracker(str4, localInteger.intValue()));
            }
            catch (NumberFormatException localNumberFormatException)
            {
              MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = String.format("Failed to parse VAST progress tracker %s", new Object[] { str3 });
              MoPubLog.log(localSdkLogEvent, arrayOfObject);
            }
          }
        }
      }
      Iterator localIterator3 = XmlUtils.getMatchingChildNodes(localNode1, "Tracking", "event", Collections.singletonList("creativeView")).iterator();
      while (localIterator3.hasNext())
      {
        String str1 = XmlUtils.getNodeValue((Node)localIterator3.next());
        if (str1 != null)
          localArrayList.add(new VastAbsoluteProgressTracker(str1, 0));
      }
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }

  List<VastTracker> c()
  {
    return a("complete");
  }

  List<VastTracker> d()
  {
    List localList = b("pause");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(new VastTracker((String)localIterator.next(), true));
    return localArrayList;
  }

  List<VastTracker> e()
  {
    List localList = b("resume");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(new VastTracker((String)localIterator.next(), true));
    return localArrayList;
  }

  List<VastTracker> f()
  {
    List localList = a("close");
    localList.addAll(a("closeLinear"));
    return localList;
  }

  List<VastTracker> g()
  {
    return a("skip");
  }

  String h()
  {
    Node localNode = XmlUtils.getFirstMatchingChildNode(this.a, "VideoClicks");
    if (localNode == null)
      return null;
    return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(localNode, "ClickThrough"));
  }

  List<VastTracker> i()
  {
    ArrayList localArrayList = new ArrayList();
    Node localNode = XmlUtils.getFirstMatchingChildNode(this.a, "VideoClicks");
    if (localNode == null)
      return localArrayList;
    Iterator localIterator = XmlUtils.getMatchingChildNodes(localNode, "ClickTracking").iterator();
    while (localIterator.hasNext())
    {
      String str = XmlUtils.getNodeValue((Node)localIterator.next());
      if (str != null)
        localArrayList.add(new VastTracker(str));
    }
    return localArrayList;
  }

  String j()
  {
    String str = XmlUtils.getAttributeValue(this.a, "skipoffset");
    if (str == null);
    while (str.trim().isEmpty())
      return null;
    return str.trim();
  }

  List<m> k()
  {
    ArrayList localArrayList = new ArrayList();
    Node localNode = XmlUtils.getFirstMatchingChildNode(this.a, "MediaFiles");
    if (localNode == null)
      return localArrayList;
    Iterator localIterator = XmlUtils.getMatchingChildNodes(localNode, "MediaFile").iterator();
    while (localIterator.hasNext())
      localArrayList.add(new m((Node)localIterator.next()));
    return localArrayList;
  }

  List<VastIconXmlManager> l()
  {
    ArrayList localArrayList = new ArrayList();
    Node localNode = XmlUtils.getFirstMatchingChildNode(this.a, "Icons");
    if (localNode == null)
      return localArrayList;
    Iterator localIterator = XmlUtils.getMatchingChildNodes(localNode, "Icon").iterator();
    while (localIterator.hasNext())
      localArrayList.add(new VastIconXmlManager((Node)localIterator.next()));
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.k
 * JD-Core Version:    0.6.2
 */