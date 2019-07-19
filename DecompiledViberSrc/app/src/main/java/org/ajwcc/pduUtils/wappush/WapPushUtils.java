package org.ajwcc.pduUtils.wappush;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WapPushUtils
{
  public static final int PUSH_CLASS = 18;
  public static final int PUSH_CREATED = 10;
  public static final int PUSH_EXPIRES = 16;
  public static final int PUSH_SIGNAL_DELETE = 9;
  public static final int PUSH_SIGNAL_HIGH = 8;
  public static final int PUSH_SIGNAL_LOW = 6;
  public static final int PUSH_SIGNAL_MEDIUM = 7;
  public static final int PUSH_SIGNAL_NONE = 5;
  public static final int PUSH_SI_ID = 17;
  public static final int WBXML_CHARSET_UTF8 = 106;
  public static final int WBXML_CLOSE_TAG = 1;
  private static final List<String> WBXML_DOMAINS;
  private static final HashMap<String, Integer> WBXML_DOMAIN_BYTES;
  public static final int WBXML_DOMAIN_COM = 133;
  public static final int WBXML_DOMAIN_EDU = 134;
  public static final int WBXML_DOMAIN_NET = 135;
  public static final int WBXML_DOMAIN_ORG = 136;
  public static final int WBXML_HREF_HTTP = 12;
  public static final int WBXML_HREF_HTTPS = 14;
  public static final int WBXML_HREF_HTTPS_WWW = 15;
  public static final int WBXML_HREF_HTTP_WWW = 13;
  public static final int WBXML_HREF_UNKNOWN = 11;
  public static final int WBXML_INDICATION_TAG_CONTENT_AND_ATTRIBUTES = 198;
  public static final int WBXML_OPAQUE_DATA = 195;
  private static final List<String> WBXML_PROTOCOLS = new ArrayList();
  private static final HashMap<String, Integer> WBXML_PROTOCOL_BYTES = new HashMap();
  public static final int WBXML_SI_1_0_PUBLIC_IDENTIFIER = 5;
  public static final int WBXML_SI_TAG_CONTENT_NO_ATTRIBUTES = 69;
  public static final int WBXML_SL_1_0_PUBLIC_IDENTIFIER = 6;
  public static final int WBXML_SL_TAG_CONTENT_NO_ATTRIBUTES = 133;
  public static final int WBXML_STRING_END = 0;
  public static final int WBXML_STRING_START = 3;
  public static final int WBXML_VERSION_1_2 = 2;

  static
  {
    WBXML_DOMAINS = new ArrayList();
    WBXML_DOMAIN_BYTES = new HashMap();
    WBXML_PROTOCOLS.add("http://www.");
    WBXML_PROTOCOLS.add("http://");
    WBXML_PROTOCOLS.add("https://www.");
    WBXML_PROTOCOLS.add("https://");
    WBXML_PROTOCOL_BYTES.put("http://www.", Integer.valueOf(13));
    WBXML_PROTOCOL_BYTES.put("http://", Integer.valueOf(12));
    WBXML_PROTOCOL_BYTES.put("https://www.", Integer.valueOf(15));
    WBXML_PROTOCOL_BYTES.put("https://", Integer.valueOf(14));
    WBXML_DOMAINS.add(".com/");
    WBXML_DOMAINS.add(".edu/");
    WBXML_DOMAINS.add(".net/");
    WBXML_DOMAINS.add(".org/");
    WBXML_DOMAIN_BYTES.put(".com/", Integer.valueOf(133));
    WBXML_DOMAIN_BYTES.put(".edu/", Integer.valueOf(134));
    WBXML_DOMAIN_BYTES.put(".net/", Integer.valueOf(135));
    WBXML_DOMAIN_BYTES.put(".org/", Integer.valueOf(136));
  }

  public static int getDomainByteFor(String paramString)
  {
    return ((Integer)WBXML_DOMAIN_BYTES.get(paramString)).intValue();
  }

  public static List<String> getDomains()
  {
    return WBXML_DOMAINS;
  }

  public static int getProtocolByteFor(String paramString)
  {
    return ((Integer)WBXML_PROTOCOL_BYTES.get(paramString)).intValue();
  }

  public static List<String> getProtocols()
  {
    return WBXML_PROTOCOLS;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.ajwcc.pduUtils.wappush.WapPushUtils
 * JD-Core Version:    0.6.2
 */