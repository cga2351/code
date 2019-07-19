package com.viber.voip.analytics.a;

import com.viber.voip.analytics.s;

public class i
{
  public static final s a = new h("activate", "vjpaei");
  public static final s b = new h("deeplinklaunch", "ol27k8");
  public static final s c = new h("place a v2v call (voice)", "r0cvj5").a(true);
  public static final s d = new h("place a v2v call (voice) ec", "nhy61b").a(true);
  public static final s e = new h("place a v2v call (video)", "4p1bm2").a(true);
  public static final s f = new h("place a vo call", "dem40r").a(true);
  public static final s g = new h("deactivate", "sr541r");
  public static final s h = new h("view public chat", "blk943").a(true);
  public static final s i = new h("games market open uu", "ige91h").a(true);

  public static s a()
  {
    return new h("activate new user UU", "kxawo5");
  }

  public static s a(int paramInt)
  {
    return new h("create a group", "447qw7").a("participants", Integer.toString(paramInt)).a(true);
  }

  public static s a(long paramLong)
  {
    return new h("communities create success ec", "d44fd0").a("communityid", Long.toString(paramLong));
  }

  public static s a(f.a parama)
  {
    return new h("sent 1 to 1 message", "plukxo").a("type", parama.toString()).a(true);
  }

  public static s a(String paramString1, String paramString2, String paramString3)
  {
    return new h("vo purchase", "5lgz43").b(paramString1, paramString2).a("name", paramString3);
  }

  public static s a(boolean paramBoolean)
  {
    h localh = new h("sent photo", "8xf7m1");
    if (paramBoolean);
    for (String str = "group"; ; str = "1on1")
      return localh.a("type", str).a(true);
  }

  static String a(String paramString)
  {
    if (paramString == null)
      return null;
    return paramString.toLowerCase();
  }

  public static s b()
  {
    return new h("active user", "4d4b2h").a(true);
  }

  public static s b(long paramLong)
  {
    return new h("communities follower EC", "fyj9q2").a("communityid", Long.toString(paramLong));
  }

  public static s b(f.a parama)
  {
    return new h("sent message 1 on 1 ec", "lpc69e").a("type", parama.toString()).a(true);
  }

  public static s b(String paramString)
  {
    return new h("download sticker (free)", "eybc1p").a("name", paramString).a(true);
  }

  public static s b(String paramString1, String paramString2, String paramString3)
  {
    return new h("download sticker (paid)", "w9wcd1").b(paramString1, paramString2).a("name", paramString3);
  }

  public static s b(boolean paramBoolean)
  {
    h localh = new h("sent video", "ij8o2m");
    if (paramBoolean);
    for (String str = "group"; ; str = "1on1")
      return localh.a("type", str).a(true);
  }

  public static s c(f.a parama)
  {
    return new h("sent message group", "hqr2s2").a("type", parama.toString()).a(true);
  }

  public static s c(String paramString)
  {
    return new h("sent sticker 1 on 1", "ioi4so").a("type", paramString).a(true);
  }

  public static s c(boolean paramBoolean)
  {
    h localh = new h("sent voice", "zgnf5v");
    if (paramBoolean);
    for (String str = "group"; ; str = "1on1")
      return localh.a("type", str).a(true);
  }

  public static s d(String paramString)
  {
    return new h("sent sticker 1 on 1 ec", "cmbugb").a("type", paramString).a(true);
  }

  public static s d(boolean paramBoolean)
  {
    h localh = new h("delete message", "gg87z0");
    if (paramBoolean);
    for (String str = "Group"; ; str = "1on1")
      return localh.a("type", str).a(true);
  }

  public static s e(String paramString)
  {
    return new h("sent sticker group", "jqjrp1").a("type", paramString).a(true);
  }

  public static s f(String paramString)
  {
    return new h("follow a public chat", "n4cz8r").a("uri", paramString).a(true);
  }

  public static s g(String paramString)
  {
    return new h("follow a public chat ec", "238jum").a("uri", paramString).a(true);
  }

  public static s h(String paramString)
  {
    return new h("invite", "mcgkvh").a("type", paramString).a(true);
  }

  public static s i(String paramString)
  {
    return new h("invite ec", "s7betj").a("type", paramString).a(true);
  }

  public static s j(String paramString)
  {
    return new h("get a game ec", "pn5j5s").a("content", a(paramString));
  }

  public static s k(String paramString)
  {
    return new h("Bot Subscriber EC", "dzwdc3").a("ContentID", paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.a.i
 * JD-Core Version:    0.6.2
 */