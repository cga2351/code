package com.google.android.exoplayer2.g;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ai
{
  public static boolean a(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException
  {
    return paramXmlPullParser.getEventType() == 3;
  }

  public static boolean a(XmlPullParser paramXmlPullParser, String paramString)
    throws XmlPullParserException
  {
    return (a(paramXmlPullParser)) && (paramXmlPullParser.getName().equals(paramString));
  }

  public static boolean b(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException
  {
    return paramXmlPullParser.getEventType() == 2;
  }

  public static boolean b(XmlPullParser paramXmlPullParser, String paramString)
    throws XmlPullParserException
  {
    return (b(paramXmlPullParser)) && (paramXmlPullParser.getName().equals(paramString));
  }

  public static String c(XmlPullParser paramXmlPullParser, String paramString)
  {
    int i = paramXmlPullParser.getAttributeCount();
    for (int j = 0; j < i; j++)
      if (paramXmlPullParser.getAttributeName(j).equals(paramString))
        return paramXmlPullParser.getAttributeValue(j);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.ai
 * JD-Core Version:    0.6.2
 */