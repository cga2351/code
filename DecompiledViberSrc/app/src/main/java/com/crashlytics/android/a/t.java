package com.crashlytics.android.a;

import android.os.Bundle;
import c.a.a.a.c;
import c.a.a.a.l;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class t
{
  private static final Set<String> a = new HashSet(Arrays.asList(new String[] { "app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "screen_view", "firebase_extra_parameter" }));

  private Double a(Object paramObject)
  {
    String str = String.valueOf(paramObject);
    if (str == null)
      return null;
    return Double.valueOf(str);
  }

  private String a(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() == 0))
      str = "fabric_unnamed_event";
    do
    {
      return str;
      if (a.contains(paramString))
        return "fabric_" + paramString;
      str = paramString.replaceAll("[^\\p{Alnum}_]+", "_");
      if ((str.startsWith("ga_")) || (str.startsWith("google_")) || (str.startsWith("firebase_")) || (!Character.isLetter(str.charAt(0))))
        str = "fabric_" + str;
    }
    while (str.length() <= 40);
    return str.substring(0, 40);
  }

  private String a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean);
    label44: int j;
    label47: label188: int i;
    switch (paramString.hashCode())
    {
    default:
      j = -1;
      switch (j)
      {
      default:
        switch (paramString.hashCode())
        {
        default:
          i = -1;
        case 1743324417:
        case 23457852:
        case 1664021448:
        case -389087554:
        case -906336856:
        case 109400031:
        case -938102371:
        case -902468296:
        case 103149417:
        case -1183699191:
        case 196004670:
        case -2131650889:
        }
        break;
      case 0:
      case 1:
      case 2:
      }
      break;
    case 1743324417:
    case -902468296:
    case 103149417:
    }
    while (true)
      switch (i)
      {
      default:
        return a(paramString);
        if (!paramString.equals("purchase"))
          break label44;
        j = 0;
        break label47;
        if (!paramString.equals("signUp"))
          break label44;
        j = 1;
        break label47;
        if (!paramString.equals("login"))
          break label44;
        j = 2;
        break label47;
        return "failed_ecommerce_purchase";
        return "failed_sign_up";
        return "failed_login";
        if (!paramString.equals("purchase"))
          break label188;
        i = 0;
        continue;
        if (!paramString.equals("addToCart"))
          break label188;
        i = 1;
        continue;
        if (!paramString.equals("startCheckout"))
          break label188;
        i = 2;
        continue;
        if (!paramString.equals("contentView"))
          break label188;
        i = 3;
        continue;
        if (!paramString.equals("search"))
          break label188;
        i = 4;
        continue;
        if (!paramString.equals("share"))
          break label188;
        i = 5;
        continue;
        if (!paramString.equals("rating"))
          break label188;
        i = 6;
        continue;
        if (!paramString.equals("signUp"))
          break label188;
        i = 7;
        continue;
        if (!paramString.equals("login"))
          break label188;
        i = 8;
        continue;
        if (!paramString.equals("invite"))
          break label188;
        i = 9;
        continue;
        if (!paramString.equals("levelStart"))
          break label188;
        i = 10;
        continue;
        if (!paramString.equals("levelEnd"))
          break label188;
        i = 11;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      }
    return "ecommerce_purchase";
    return "add_to_cart";
    return "begin_checkout";
    return "select_content";
    return "search";
    return "share";
    return "rate_content";
    return "sign_up";
    return "login";
    return "invite";
    return "level_start";
    return "level_end";
  }

  private void a(Bundle paramBundle, String paramString, Double paramDouble)
  {
    Double localDouble = a(paramDouble);
    if (localDouble == null)
      return;
    paramBundle.putDouble(paramString, localDouble.doubleValue());
  }

  private void a(Bundle paramBundle, String paramString, Integer paramInteger)
  {
    if (paramInteger == null)
      return;
    paramBundle.putInt(paramString, paramInteger.intValue());
  }

  private void a(Bundle paramBundle, String paramString, Long paramLong)
  {
    if (paramLong == null)
      return;
    paramBundle.putLong(paramString, paramLong.longValue());
  }

  private void a(Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramString2 == null)
      return;
    paramBundle.putString(paramString1, paramString2);
  }

  private void a(Bundle paramBundle, Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = localEntry.getValue();
      String str = b((String)localEntry.getKey());
      if ((localObject instanceof String))
        paramBundle.putString(str, localEntry.getValue().toString());
      else if ((localObject instanceof Double))
        paramBundle.putDouble(str, ((Double)localEntry.getValue()).doubleValue());
      else if ((localObject instanceof Long))
        paramBundle.putLong(str, ((Long)localEntry.getValue()).longValue());
      else if ((localObject instanceof Integer))
        paramBundle.putInt(str, ((Integer)localEntry.getValue()).intValue());
    }
  }

  private Bundle b(ad paramad)
  {
    Bundle localBundle = new Bundle();
    if ("purchase".equals(paramad.g))
    {
      a(localBundle, "item_id", (String)paramad.h.get("itemId"));
      a(localBundle, "item_name", (String)paramad.h.get("itemName"));
      a(localBundle, "item_category", (String)paramad.h.get("itemType"));
      a(localBundle, "value", b(paramad.h.get("itemPrice")));
      a(localBundle, "currency", (String)paramad.h.get("currency"));
    }
    while (true)
    {
      a(localBundle, paramad.f);
      return localBundle;
      if ("addToCart".equals(paramad.g))
      {
        a(localBundle, "item_id", (String)paramad.h.get("itemId"));
        a(localBundle, "item_name", (String)paramad.h.get("itemName"));
        a(localBundle, "item_category", (String)paramad.h.get("itemType"));
        a(localBundle, "price", b(paramad.h.get("itemPrice")));
        a(localBundle, "value", b(paramad.h.get("itemPrice")));
        a(localBundle, "currency", (String)paramad.h.get("currency"));
        localBundle.putLong("quantity", 1L);
      }
      else if ("startCheckout".equals(paramad.g))
      {
        a(localBundle, "quantity", Long.valueOf(((Integer)paramad.h.get("itemCount")).intValue()));
        a(localBundle, "value", b(paramad.h.get("totalPrice")));
        a(localBundle, "currency", (String)paramad.h.get("currency"));
      }
      else if ("contentView".equals(paramad.g))
      {
        a(localBundle, "content_type", (String)paramad.h.get("contentType"));
        a(localBundle, "item_id", (String)paramad.h.get("contentId"));
        a(localBundle, "item_name", (String)paramad.h.get("contentName"));
      }
      else if ("search".equals(paramad.g))
      {
        a(localBundle, "search_term", (String)paramad.h.get("query"));
      }
      else if ("share".equals(paramad.g))
      {
        a(localBundle, "method", (String)paramad.h.get("method"));
        a(localBundle, "content_type", (String)paramad.h.get("contentType"));
        a(localBundle, "item_id", (String)paramad.h.get("contentId"));
        a(localBundle, "item_name", (String)paramad.h.get("contentName"));
      }
      else if ("rating".equals(paramad.g))
      {
        a(localBundle, "rating", String.valueOf(paramad.h.get("rating")));
        a(localBundle, "content_type", (String)paramad.h.get("contentType"));
        a(localBundle, "item_id", (String)paramad.h.get("contentId"));
        a(localBundle, "item_name", (String)paramad.h.get("contentName"));
      }
      else if ("signUp".equals(paramad.g))
      {
        a(localBundle, "method", (String)paramad.h.get("method"));
      }
      else if ("login".equals(paramad.g))
      {
        a(localBundle, "method", (String)paramad.h.get("method"));
      }
      else if ("invite".equals(paramad.g))
      {
        a(localBundle, "method", (String)paramad.h.get("method"));
      }
      else if ("levelStart".equals(paramad.g))
      {
        a(localBundle, "level_name", (String)paramad.h.get("levelName"));
      }
      else if ("levelEnd".equals(paramad.g))
      {
        a(localBundle, "score", a(paramad.h.get("score")));
        a(localBundle, "level_name", (String)paramad.h.get("levelName"));
        a(localBundle, "success", c((String)paramad.h.get("success")));
      }
    }
  }

  private Double b(Object paramObject)
  {
    if ((Long)paramObject == null)
      return null;
    return Double.valueOf(new BigDecimal(((Long)paramObject).longValue()).divide(a.a).doubleValue());
  }

  private String b(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() == 0))
      str = "fabric_unnamed_parameter";
    do
    {
      return str;
      str = paramString.replaceAll("[^\\p{Alnum}_]+", "_");
      if ((str.startsWith("ga_")) || (str.startsWith("google_")) || (str.startsWith("firebase_")) || (!Character.isLetter(str.charAt(0))))
        str = "fabric_" + str;
    }
    while (str.length() <= 40);
    return str.substring(0, 40);
  }

  private Integer c(String paramString)
  {
    if (paramString == null)
      return null;
    if (paramString.equals("true"));
    for (int i = 1; ; i = 0)
      return Integer.valueOf(i);
  }

  public s a(ad paramad)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((ad.b.g.equals(paramad.c)) && (paramad.e != null))
    {
      bool2 = bool1;
      if ((!ad.b.h.equals(paramad.c)) || (paramad.g == null))
        break label63;
    }
    label63: for (boolean bool3 = bool1; ; bool3 = false)
    {
      if ((bool2) || (bool3))
        break label69;
      return null;
      bool2 = false;
      break;
    }
    label69: Object localObject;
    if (bool3)
    {
      localObject = b(paramad);
      if (!bool3)
        break label191;
      String str2 = (String)paramad.h.get("success");
      if ((str2 == null) || (Boolean.parseBoolean(str2)))
        break label186;
    }
    label116: for (String str1 = a(paramad.g, bool1); ; str1 = a(paramad.e))
    {
      c.g().a("Answers", "Logging event into firebase...");
      return new s(str1, (Bundle)localObject);
      Bundle localBundle = new Bundle();
      if (paramad.f != null)
        a(localBundle, paramad.f);
      localObject = localBundle;
      break;
      bool1 = false;
      break label116;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.t
 * JD-Core Version:    0.6.2
 */