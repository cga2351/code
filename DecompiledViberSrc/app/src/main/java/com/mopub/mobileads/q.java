package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.util.DeviceUtils.ForceOrientation;
import com.mopub.mobileads.util.XmlUtils;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

class q
{
  private Document a;

  List<f> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.a == null)
      return localArrayList;
    NodeList localNodeList = this.a.getElementsByTagName("Ad");
    for (int i = 0; i < localNodeList.getLength(); i++)
      localArrayList.add(new f(localNodeList.item(i)));
    return localArrayList;
  }

  void a(String paramString)
    throws ParserConfigurationException, IOException, SAXException
  {
    Preconditions.checkNotNull(paramString, "xmlString cannot be null");
    String str1 = paramString.replaceFirst("<\\?.*\\?>", "");
    String str2 = "<MPMoVideoXMLDocRoot>" + str1 + "</MPMoVideoXMLDocRoot>";
    DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
    localDocumentBuilderFactory.setCoalescing(true);
    this.a = localDocumentBuilderFactory.newDocumentBuilder().parse(new InputSource(new StringReader(str2)));
  }

  VastTracker b()
  {
    if (this.a == null);
    String str;
    do
    {
      return null;
      str = XmlUtils.getFirstMatchingStringData(this.a, "Error");
    }
    while (TextUtils.isEmpty(str));
    return new VastTracker(str);
  }

  List<VastTracker> c()
  {
    List localList = XmlUtils.getStringDataAsList(this.a, "MP_TRACKING_URL");
    ArrayList localArrayList = new ArrayList(localList.size());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(new VastTracker((String)localIterator.next()));
    return localArrayList;
  }

  String d()
  {
    String str = XmlUtils.getFirstMatchingStringData(this.a, "MoPubCtaText");
    if ((str != null) && (str.length() <= 15))
      return str;
    return null;
  }

  String e()
  {
    String str = XmlUtils.getFirstMatchingStringData(this.a, "MoPubSkipText");
    if ((str != null) && (str.length() <= 8))
      return str;
    return null;
  }

  String f()
  {
    return XmlUtils.getFirstMatchingStringData(this.a, "MoPubCloseIcon");
  }

  DeviceUtils.ForceOrientation g()
  {
    return DeviceUtils.ForceOrientation.getForceOrientation(XmlUtils.getFirstMatchingStringData(this.a, "MoPubForceOrientation"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.q
 * JD-Core Version:    0.6.2
 */