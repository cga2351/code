package com.viber.voip;

import com.viber.dexshared.Logger;
import com.viber.jni.ClientEnvConfig;
import java.util.Locale;

public class ap
{
  private static final Logger a = ViberEnv.getLogger();
  private static volatile ap b;
  private a c;

  public static String a(String paramString)
  {
    if ("FDD".equals(paramString))
      return "https://account.integration.viber.com";
    if ("int".equals(paramString))
      return "https://account.integration.viber.com";
    if ("staging".equals(paramString))
      return "https://account.integration.viber.com";
    if ("prod".equals(paramString))
      return "https://account.viber.com";
    return null;
  }

  public static ap b()
  {
    if (b == null)
      b = new ap();
    return b;
  }

  public static String b(String paramString)
  {
    if ("FDD".equals(paramString))
      return "https://wuwallet.integration.viber.com";
    if ("int".equals(paramString))
      return "https://wuwallet.integration.viber.com";
    if ("staging".equals(paramString))
      return "https://wuwallet.integration.viber.com";
    if ("prod".equals(paramString))
      return "https://wuwallet.viber.com";
    return null;
  }

  @Deprecated
  public static a c()
  {
    try
    {
      if (b().c == null)
        throw new NullPointerException("ServerConfig is not initialized. Possibly you should inspect Application.onCreate()");
    }
    finally
    {
    }
    a locala = b().c;
    return locala;
  }

  public static String c(String paramString)
  {
    if ("FDD".equals(paramString))
      return "https://wallet.integration.viber.com";
    if ("int".equals(paramString))
      return "https://wallet.integration.viber.com";
    if ("staging".equals(paramString))
      return "https://wallet.integration.viber.com";
    if ("prod".equals(paramString))
      return "https://wallet.viber.com";
    return null;
  }

  public static String d()
  {
    return "prod";
  }

  public static String d(String paramString)
  {
    if ("FDD".equals(paramString))
      return "https://content.cdn.integration.viber.com/wallets/wallets_all.json";
    if ("int".equals(paramString))
      return "https://content.cdn.integration.viber.com/wallets/wallets_all.json";
    if ("staging".equals(paramString))
      return "https://content.cdn.integration.viber.com/wallets/wallets_all.json";
    if ("prod".equals(paramString))
      return "https://content.cdn.viber.com/wallets/wallets_all.json";
    return null;
  }

  public static String e(String paramString)
  {
    if ("FDD".equals(paramString))
      return "https://content.cdn.integration.viber.com/backgrounds_v2/Android/bg_config.json";
    if ("int".equals(paramString))
      return "https://content.cdn.integration.viber.com/backgrounds_v2/Android/bg_config.json";
    if ("staging".equals(paramString))
      return "https://content.cdn.integration.viber.com/backgrounds_v2/Android/bg_config.json";
    if ("prod".equals(paramString))
      return "https://content.cdn.viber.com/backgrounds_v2/Android/bg_config.json";
    return null;
  }

  public static String f(String paramString)
  {
    if ("FDD".equals(paramString))
      return "https://vibes.integration.viber.com/";
    if ("int".equals(paramString))
      return "https://vibes.integration.viber.com/";
    if ("staging".equals(paramString))
      return "https://vibes.integration.viber.com/";
    if ("prod".equals(paramString))
      return "https://vibes.viber.com/";
    return null;
  }

  public static String g(String paramString)
  {
    if ("FDD".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/notifications.json";
    if ("int".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/notifications.json";
    if ("staging".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/notifications.json";
    if ("prod".equals(paramString))
      return "https://content.cdn.viber.com/stickers/notifications.json";
    return null;
  }

  public static String h(String paramString)
  {
    if ("FDD".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/hiPromo/onboarding.json";
    if ("int".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/hiPromo/onboarding.json";
    if ("staging".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/hiPromo/onboarding.json";
    if ("prod".equals(paramString))
      return "https://content.cdn.viber.com/stickers/hiPromo/onboarding.json";
    return null;
  }

  public static String i(String paramString)
  {
    if ("FDD".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/viberid/viberid.json";
    if ("int".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/viberid/viberid.json";
    if ("staging".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/viberid/viberid.json";
    if ("prod".equals(paramString))
      return "https://content.cdn.viber.com/stickers/viberid/viberid.json";
    return null;
  }

  public static String j(String paramString)
  {
    if ("FDD".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/hiPromo/onboarding2.json";
    if ("int".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/hiPromo/onboarding2.json";
    if ("staging".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/hiPromo/onboarding2.json";
    if ("prod".equals(paramString))
      return "https://content.cdn.viber.com/stickers/hiPromo/onboarding2.json";
    return null;
  }

  public static String k(String paramString)
  {
    if ("FDD".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/hiPromo/";
    if ("int".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/hiPromo/";
    if ("staging".equals(paramString))
      return "https://content.cdn.integration.viber.com/stickers/hiPromo/";
    if ("prod".equals(paramString))
      return "https://content.cdn.viber.com/stickers/hiPromo/";
    return null;
  }

  public static String l(String paramString)
  {
    if ("FDD".equals(paramString))
      return "https://market.integration.viber.com";
    if ("int".equals(paramString))
      return "https://market.integration.viber.com";
    if ("staging".equals(paramString))
      return "https://market.integration.viber.com";
    if ("prod".equals(paramString))
      return "https://market.viber.com";
    return null;
  }

  public static String m(String paramString)
  {
    if ("FDD".equals(paramString))
      return "https://market.api.integration.viber.com/2/users/";
    if ("int".equals(paramString))
      return "https://market.api.integration.viber.com/2/users/";
    if ("staging".equals(paramString))
      return "https://market.api.integration.viber.com/2/users/";
    if ("prod".equals(paramString))
      return "https://market.api.viber.com/2/users/";
    return null;
  }

  public static String n(String paramString)
  {
    if ("FDD".equals(paramString))
      return c.bc;
    if ("int".equals(paramString))
      return "https://media.api.integration.viber.com/api/v2";
    if ("staging".equals(paramString))
      return c.bc;
    if ("prod".equals(paramString))
      return "https://media.api.viber.com/api/v2";
    return null;
  }

  public static String o(String paramString)
  {
    if ("FDD".equals(paramString))
      return c.bd;
    if ("int".equals(paramString))
      return "https://media.cdn.integration.viber.com";
    if ("staging".equals(paramString))
      return c.bd;
    if ("prod".equals(paramString))
      return "https://media.cdn.viber.com";
    return null;
  }

  public static String p(String paramString)
  {
    if ("prod".equals(paramString))
      return "https://abtest.api.viber.com";
    return "http://wasabi.aws.integration.viber.com:8080";
  }

  public static String q(String paramString)
  {
    if ("prod".equals(paramString))
      return "https://s3.amazonaws.com/viber-pg/ChatExtSuggestions/suggestions.json";
    if ("FDD".equals(paramString))
      return "https://s3.amazonaws.com/viber-pg-int/ChatExtSuggestions/suggestions.json";
    return "https://s3.amazonaws.com/viber-pg-int/ChatExtSuggestions/suggestions.json";
  }

  public static String r(String paramString)
  {
    if ("prod".equals(paramString))
      return "ptt.viber.com";
    return "ptt.integration.viber.com";
  }

  public void a()
  {
    this.c = new d();
  }

  public static abstract class a
  {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I = "";
    public String J;
    public String K = "https://support.viber.com/api/v2/";
    public String L = "sup-reports@viber.com";
    public String M = "2JEIxaVhA0et";
    public String N;
    public String O = "https://support.viber.com/customer/portal/articles/2853940";
    public String P;
    public String Q;
    public int R;
    public ap.b S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;
    public ClientEnvConfig a;
    public String aA;
    public String aB;
    public int aC;
    public String aD;
    public String aE;
    public String aF;
    public String aG;
    public String aH;
    public String aI;
    public String aJ = "https://www.viber.com/%s/eula?utm_source=Public_chats&utm_medium=App&utm_campaign=Public_Chats_R18";
    public String aK = "https://www.viber.com/%s/eula?utm_source=Public_chats&utm_medium=App&utm_campaign=Public_Chats_R18";
    public String aL;
    public String aM = "https://bevo.adsnative.com/seg.gif";
    public String aN = "http://bevo.adsnative.com/conversions";
    public String aO;
    public String aP = "https://language.viber.com/v1/translate";
    public String aQ = "https://www.viber.com/privacypolicy.html";
    public String aR = "https://support.viber.com/customer/portal/emails/new?phone=%s";
    public String aS = "https://support.viber.com/customer/portal/articles/2880188-transfer-your-viber-history-from-one-device-to-another";
    public String aT;
    public String aU;
    public String aV;
    public String aW;
    public String aX;
    public String aY;
    public String aZ;
    public String aa;
    public String ab;
    public String ac;
    public String ad;
    public String ae;
    public String af;
    public String ag;
    public String ah;
    public String ai;
    public String aj = "https://www.viber.com/security";
    public String ak;
    public String al = "https://www.viber.com/messages/reports";
    public String am = "https://support.viber.com/customer/%s/portal/articles/2733412";
    public String an = "https://helpme.viber.com/create-public-account/";
    public String ao;
    public String ap;
    public String aq;
    public String ar;
    public String as = "https://support.viber.com/customer/en/portal/articles/2492981";
    public String at;
    public String au;
    public String av;
    public String aw = "send-money";
    public String ax = "send-money";
    public String ay = "send-money-recent";
    public String az = "transactions";
    public String b;
    public String ba;
    public int bb;
    private String bc = "https://www.viber.com/%s/terms";
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l = "https://r.viber.com/rid/start?r=";
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public void a()
    {
    }

    protected void b()
    {
      this.aq = (this.ap + "/stickers/");
      this.au = (this.ap + "/games/");
      this.C = (this.aq + "static/data/product/stickers.%PKG%.json");
    }

    protected void c()
    {
      this.U = (this.ah + "/api/");
      this.V = (this.ah + "/mobile/");
      this.W = (this.ah + "/mobile/checkout/");
      this.X = (this.ah + "/mobile/welcome/");
      this.Y = (this.ah + "/mobile/account/");
      this.aa = (this.ah + "/mobile/calling-plan/");
      this.ae = (this.ah + "/what-is-viber-out/");
      this.Z = (this.ah + "/1/users/");
      this.ab = (this.ah + "/4/users/");
      this.ad = (this.ah + "/?module=android&controller=express&action=ratespage&");
      this.af = (this.ah + "/mobile/isbillingavailable/phone/");
      this.ag = (this.ah + "/2/users/");
    }

    protected void d()
    {
      this.aH = (this.aG + "/icons/");
    }

    public boolean e()
    {
      return true;
    }

    public String f()
    {
      Locale localLocale = Locale.US;
      String str = this.bc;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Locale.getDefault().getLanguage();
      return String.format(localLocale, str, arrayOfObject);
    }

    public String g()
    {
      return f() + "/viber-privacy-policy/#disclosure";
    }

    public String h()
    {
      return f() + "/chat-public-accounts-terms-guidelines";
    }
  }

  public static class b
  {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramString4;
      this.e = paramString5;
    }
  }

  private static class c extends ap.a
  {
    public static String bc;
    public static String bd;

    public void a()
    {
    }

    public boolean e()
    {
      return false;
    }
  }

  private class d extends ap.a
  {
    public d()
    {
      this.a = new ClientEnvConfig("aloha.viber.com", "pg.cdn.viber.com", "ptt.viber.com", "https", "https", "https://stickers-search.viber.com/stickersearch/v1.0/search.jsp", 5242);
      this.b = "https://secure.viber.com/viber/viber.php?function=ActivateUser";
      this.c = "https://secure.viber.com/viber/viber.php?function=RegisterUser";
      this.d = "https://secure.viber.com/viber/viber.php?function=GetDefaultCountry";
      this.e = "https://secure.viber.com/viber/viber.php?function=DeActivate";
      this.f = "https://secure.viber.com/viber/viber.php?function=DeactivateUser";
      this.m = "https://secure.viber.com/viber/viber.php?function=GenerateDeviceKey";
      this.n = "https://secure.viber.com/viber/viber.php?function=GenerateDeviceKeyDone";
      this.o = "https://secure.viber.com/viber/viber.php?function=ResendActivationCode";
      this.p = "https://secure.viber.com/viber/viber.php?function=ResendSMS";
      this.q = "https://secure.viber.com/viber/viber.php?function=AuthorizeChangePhoneNumber";
      this.r = "https://secure.viber.com/viber/viber.php?function=ActivateChangePhoneNumber";
      this.g = "https://secure.viber.com/viber/viber.php?function=GetRID";
      this.h = "https://secure.viber.com/viber/viber.php?function=SetRToken";
      this.i = "https://secure.viber.com/viber/viber.php?function=SetRReferral";
      this.j = "https://viber.co.jp/webview/account";
      this.k = "https://viber.co.jp/app/linkage";
      this.ai = "https://www.viber.com/howto/security";
      this.ao = "https://www.viber.com/promotion/desktop";
      this.aD = "https://vibes.viber.com/";
      this.aE = "https://business.viber.com/community_insights/";
      this.ak = "https://support.viber.com/customer/portal/emails/new?type=PC&appid=902&chaturi=%s&reporter=%s";
      this.aF = "https://media.viber.com/";
      this.s = "https://share.cdn.viber.com/pg_download";
      this.t = "https://share.cdn.viber.com/group_download";
      this.u = "https://secure.viber.com/viber/viber.php?function=DeviceFlags";
      this.v = "https://activate.viber.com/viber/activate.php?phn=%s&udid=%s";
      this.w = "https://www.viber.com/activate_secondary/?u=%s&k=%s&r=%s";
      this.x = "https://config.viber.com/config/android/config.2.2.xml";
      this.y = "https://content.cdn.viber.com/stickers/%RES%/%PKG%.zip";
      this.z = "https://content.cdn.viber.com/stickers/icons/%RES%_white/Icon_%PKG%.png";
      this.A = "https://content.cdn.viber.com/stickers/icons/%RES%_colored/Icon_%PKG%.png";
      this.B = "https://content.cdn.viber.com/stickers/icons/600_colored/Icon_%PKG%.png";
      this.D = "https://content.cdn.viber.com/stickers/%RES%/%PKG%/%ID%.%EXT%";
      this.ah = "https://account.viber.com";
      c();
      this.ac = "https://rates.viber.com/get-rates-by-dest?";
      this.E = "https://content.cdn.viber.com/backgrounds_v2/Android/bg_thumb.zip";
      this.F = "https://content.cdn.viber.com/backgrounds_v2/Android/bg_config.json";
      this.G = "https://content.cdn.viber.com/backgrounds_v2/Android/%RES%/%ID%.jpg";
      this.R = R.raw.production;
      this.aB = "";
      this.ap = "https://market.viber.com";
      this.ar = "https://market.api.viber.com/2/users/";
      b();
      this.at = "https://content.cdn.viber.com/stickers/notifications.json";
      this.aG = "https://content.cdn.viber.com/apps";
      d();
      this.av = "https://wuwallet.viber.com";
      this.aA = "https://wallet.viber.com";
      this.aC = 0;
      this.aI = "https://helpme.viber.com/hidden_chat";
      this.aO = "https://pg.cdn.viber.com/pgws/get_pg_info_by_uris?group_uris=%s&translationLang=%s";
      this.aL = "https://ads.viber.com/v2/ads/fetch";
      this.H = "https://content.cdn.viber.com/";
      this.J = "https://content.cdn.viber.com/stickers/hiPromo/onboarding.json";
      this.N = "https://content.cdn.viber.com/stickers/viberid/viberid.json";
      this.P = "https://content.cdn.viber.com/stickers/hiPromo/onboarding2.json";
      this.Q = "https://content.cdn.viber.com/stickers/hiPromo/";
      this.aU = "https://s3.amazonaws.com/viber-content/emoALL/v%1$d/%2$s/%3$s.png";
      this.S = new ap.b("giphy", "tenorgif", "spotify", "stickers", "pa:5037638080227827567");
      this.T = "https://s3.amazonaws.com/viber-pg/ChatExtSuggestions/suggestions.json";
      this.aT = "http://pg.cdn.viber.com/pgws/search_g2_by_text?limit=%s&search=%s&sindex=%s";
      a();
      this.aV = "aloha.viber.com";
      this.aW = "pg.cdn.viber.com";
      this.aX = "ptt.viber.com";
      this.aY = "https://stickers-search.viber.com/stickersearch/v1.0/search.jsp";
      this.aZ = "https";
      this.ba = "https";
      this.bb = 5242;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ap
 * JD-Core Version:    0.6.2
 */