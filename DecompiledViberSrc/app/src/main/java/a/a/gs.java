package a.a;

import com.appboy.e.e;
import java.util.HashMap;
import java.util.Map;

public enum gs
  implements e<String>
{
  private static final Map<String, gs> G = new HashMap(localHashMap);
  private final String F;

  static
  {
    int i1 = 0;
    a = new gs("LOCATION_RECORDED", 0, "lr");
    b = new gs("CUSTOM_EVENT", 1, "ce");
    c = new gs("PURCHASE", 2, "p");
    d = new gs("PUSH_STORY_PAGE_CLICK", 3, "cic");
    e = new gs("PUSH_NOTIFICATION_TRACKING", 4, "pc");
    f = new gs("PUSH_NOTIFICATION_ACTION_TRACKING", 5, "ca");
    g = new gs("INTERNAL", 6, "i");
    h = new gs("INTERNAL_ERROR", 7, "ie");
    i = new gs("NEWS_FEED_CARD_IMPRESSION", 8, "ci");
    j = new gs("NEWS_FEED_CARD_CLICK", 9, "cc");
    k = new gs("GEOFENCE", 10, "g");
    l = new gs("CONTENT_CARDS_CLICK", 11, "ccc");
    m = new gs("CONTENT_CARDS_IMPRESSION", 12, "cci");
    n = new gs("CONTENT_CARDS_CONTROL_IMPRESSION", 13, "ccic");
    o = new gs("CONTENT_CARDS_DISMISS", 14, "ccd");
    p = new gs("INCREMENT", 15, "inc");
    q = new gs("ADD_TO_CUSTOM_ATTRIBUTE_ARRAY", 16, "add");
    r = new gs("REMOVE_FROM_CUSTOM_ATTRIBUTE_ARRAY", 17, "rem");
    s = new gs("SET_CUSTOM_ATTRIBUTE_ARRAY", 18, "set");
    t = new gs("INAPP_MESSAGE_IMPRESSION", 19, "si");
    u = new gs("INAPP_MESSAGE_CONTROL_IMPRESSION", 20, "iec");
    v = new gs("INAPP_MESSAGE_CLICK", 21, "sc");
    w = new gs("INAPP_MESSAGE_BUTTON_CLICK", 22, "sbc");
    x = new gs("INAPP_MESSAGE_DISPLAY_FAILURE", 23, "sfe");
    y = new gs("USER_ALIAS", 24, "uae");
    z = new gs("SESSION_START", 25, "ss");
    A = new gs("SESSION_END", 26, "se");
    B = new gs("TEST_TYPE", 27, "tt");
    C = new gs("PUSH_DELIVERY", 28, "pd");
    D = new gs("LOCATION_CUSTOM_ATTRIBUTE_ADD", 29, "lcaa");
    E = new gs("LOCATION_CUSTOM_ATTRIBUTE_REMOVE", 30, "lcar");
    gs[] arrayOfgs1 = new gs[31];
    arrayOfgs1[0] = a;
    arrayOfgs1[1] = b;
    arrayOfgs1[2] = c;
    arrayOfgs1[3] = d;
    arrayOfgs1[4] = e;
    arrayOfgs1[5] = f;
    arrayOfgs1[6] = g;
    arrayOfgs1[7] = h;
    arrayOfgs1[8] = i;
    arrayOfgs1[9] = j;
    arrayOfgs1[10] = k;
    arrayOfgs1[11] = l;
    arrayOfgs1[12] = m;
    arrayOfgs1[13] = n;
    arrayOfgs1[14] = o;
    arrayOfgs1[15] = p;
    arrayOfgs1[16] = q;
    arrayOfgs1[17] = r;
    arrayOfgs1[18] = s;
    arrayOfgs1[19] = t;
    arrayOfgs1[20] = u;
    arrayOfgs1[21] = v;
    arrayOfgs1[22] = w;
    arrayOfgs1[23] = x;
    arrayOfgs1[24] = y;
    arrayOfgs1[25] = z;
    arrayOfgs1[26] = A;
    arrayOfgs1[27] = B;
    arrayOfgs1[28] = C;
    arrayOfgs1[29] = D;
    arrayOfgs1[30] = E;
    H = arrayOfgs1;
    HashMap localHashMap = new HashMap();
    gs[] arrayOfgs2 = values();
    int i2 = arrayOfgs2.length;
    while (i1 < i2)
    {
      gs localgs = arrayOfgs2[i1];
      localHashMap.put(localgs.F, localgs);
      i1++;
    }
  }

  private gs(String paramString)
  {
    this.F = paramString;
  }

  public static gs a(String paramString)
  {
    if (!G.containsKey(paramString))
      throw new IllegalArgumentException("Unknown String Value: " + paramString);
    return (gs)G.get(paramString);
  }

  public String a()
  {
    return this.F;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.gs
 * JD-Core Version:    0.6.2
 */