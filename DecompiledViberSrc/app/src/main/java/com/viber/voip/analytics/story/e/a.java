package com.viber.voip.analytics.story.e;

import android.support.v4.util.ArrayMap;
import com.viber.voip.analytics.e.g;
import com.viber.voip.analytics.story.f;
import com.viber.voip.analytics.story.n;

class a
{
  static ArrayMap<f, g> a(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Community Messages Sent", 1.0D);
  }

  static ArrayMap<f, g> a(ArrayMap<f, g> paramArrayMap, String paramString)
  {
    return n.a(paramArrayMap, "First Message Sent", "Last Message Sent", "# of Messages Sent", paramString);
  }

  static ArrayMap<f, g> a(String paramString)
  {
    return n.a("First Clicked Link", "Last Clicked Link", "# of Clicked Links", paramString);
  }

  static ArrayMap<f, g> a(String paramString1, String paramString2)
  {
    ArrayMap localArrayMap = new ArrayMap(4);
    n.a(localArrayMap, "First Chat Viewed", "Last Chat Viewed", "# of Chats Viewed", paramString2);
    n.a(localArrayMap, "Chat Types Viewed", new String[] { paramString1 });
    return localArrayMap;
  }

  static ArrayMap<f, g> b(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Public Chat Messages Sent", 1.0D);
  }

  static ArrayMap<f, g> b(ArrayMap<f, g> paramArrayMap, String paramString)
  {
    return n.a(paramArrayMap, "First Time Bomb Included", "Last Time Bomb Included", "# of Time Bomb Included", paramString);
  }

  static ArrayMap<f, g> b(String paramString)
  {
    return n.a("First Viewed Say Hi Banner", "Last Viewed Say Hi Banner", "# of Times Viewed Say Hi Banner", paramString);
  }

  static ArrayMap<f, g> c(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Group Messages Sent", 1.0D);
  }

  static ArrayMap<f, g> c(ArrayMap<f, g> paramArrayMap, String paramString)
  {
    return n.a(paramArrayMap, "Message Chat Types Sent", new String[] { paramString });
  }

  static ArrayMap<f, g> c(String paramString)
  {
    return n.a("First Message Translated", "Last Message Translated", "# of Messages Translated", paramString);
  }

  static ArrayMap<f, g> d(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Secret Messages Sent", 1.0D);
  }

  static ArrayMap<f, g> d(ArrayMap<f, g> paramArrayMap, String paramString)
  {
    return n.a(paramArrayMap, "Message Types Sent", new String[] { paramString });
  }

  static ArrayMap<f, g> d(String paramString)
  {
    return n.a("First Enabled Smart Notification", "Last Enabled Smart Notification", "# of Enabled Smart Notification", paramString);
  }

  static ArrayMap<f, g> e(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of 1-on-1 Secret Messages Sent", 1.0D);
  }

  static ArrayMap<f, g> e(ArrayMap<f, g> paramArrayMap, String paramString)
  {
    return n.a(paramArrayMap, "First Message Received", "Last Message Received", "# of Messages Received", paramString);
  }

  static ArrayMap<f, g> e(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap(2);
    localArrayMap.put(n.a("First Chat Background Change", paramString), g.b);
    localArrayMap.put(n.a("Last Chat Background Change", paramString), g.c);
    return localArrayMap;
  }

  static ArrayMap<f, g> f(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Services Messages Sent", 1.0D);
  }

  static ArrayMap<f, g> f(ArrayMap<f, g> paramArrayMap, String paramString)
  {
    return n.a(paramArrayMap, "Chat Types Received", new String[] { paramString });
  }

  static ArrayMap<f, g> f(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap(4);
    n.a(localArrayMap, "First Muted Chat", "Last Muted Chat", "# of Muted Chats", paramString);
    n.a(localArrayMap, "# of Current Muted Chats", 1.0D);
    return localArrayMap;
  }

  static ArrayMap<f, g> g(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of 1-on-1 Messages Sent", 1.0D);
  }

  static ArrayMap<f, g> g(ArrayMap<f, g> paramArrayMap, String paramString)
  {
    return n.a(paramArrayMap, "Message Types Received", new String[] { paramString });
  }

  static ArrayMap<f, g> g(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap(4);
    n.a(localArrayMap, "First Unmuted Chat", "Last Unmuted Chat", "# of Unmuted Chats", paramString);
    n.a(localArrayMap, "# of Current Muted Chats", -1.0D);
    return localArrayMap;
  }

  static ArrayMap<f, g> h(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Captions Included in Messages", 1.0D);
  }

  static ArrayMap<f, g> h(ArrayMap<f, g> paramArrayMap, String paramString)
  {
    return n.a(paramArrayMap, "Keyboard Languages Used", new String[] { paramString });
  }

  static ArrayMap<f, g> h(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap(4);
    n.a(localArrayMap, "First Snoozed Chat", "Last Snoozed Chat", "# of Times Snoozed Chat", paramString);
    n.a(localArrayMap, "# of Current Snoozed Chats", 1.0D);
    return localArrayMap;
  }

  static ArrayMap<f, g> i(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Forward Messages Sent", 1.0D);
  }

  static ArrayMap<f, g> i(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap(4);
    n.a(localArrayMap, "First Unsnoozed Chat", "Last Unsnoozed Chat", "# of Times Unsnoozed Chat", paramString);
    n.a(localArrayMap, "# of Current Snoozed Chats", -1.0D);
    return localArrayMap;
  }

  static void i(ArrayMap<f, g> paramArrayMap, String paramString)
  {
    n.a(paramArrayMap, "First Poll Sent", "Last Poll Sent", "# of Polls Sent", paramString);
  }

  static ArrayMap<f, g> j(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Reply Messages Sent", 1.0D);
  }

  static ArrayMap<f, g> j(String paramString)
  {
    return n.a("First Created Chat", "Last Created Chat", "# of Created Chats", paramString);
  }

  static ArrayMap<f, g> k(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Media Messages Sent", 1.0D);
  }

  static ArrayMap<f, g> k(String paramString)
  {
    return n.a("First Saved Link to Favorites", "Last Saved Link to Favorites", "# of Saved Link to Favorites", paramString);
  }

  static ArrayMap<f, g> l(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Sticker Messages Sent", 1.0D);
  }

  static ArrayMap<f, g> l(String paramString)
  {
    return n.a("First Clicked on Show Message", "Last Clicked on Show Message", "# of Clicks on Show Message", paramString);
  }

  static ArrayMap<f, g> m(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Chat Extensions Messages Sent", 1.0D);
  }

  static ArrayMap<f, g> m(String paramString)
  {
    return n.a("First Converted M2M Chat to 1-on-1", "Last Converted M2M Chat to 1-on-1", "# of Converted M2M Chats", paramString);
  }

  static ArrayMap<f, g> n(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Photo Messages Sent", 1.0D);
  }

  static ArrayMap<f, g> n(String paramString)
  {
    return n.a("First Voted on Poll", "Last Voted on Poll", "# of times Voted on Poll", paramString);
  }

  static ArrayMap<f, g> o(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of Video Messages Sent", 1.0D);
  }

  static ArrayMap<f, g> p(ArrayMap<f, g> paramArrayMap)
  {
    return n.a(paramArrayMap, "# of System Messages Received", 1.0D);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.e.a
 * JD-Core Version:    0.6.2
 */