package com.iab.omid.library.appnexus.publisher;

import android.content.Context;
import android.webkit.WebView;
import com.iab.omid.library.appnexus.adsession.AdEvents;
import com.iab.omid.library.appnexus.adsession.AdSessionConfiguration;
import com.iab.omid.library.appnexus.adsession.AdSessionContext;
import com.iab.omid.library.appnexus.adsession.ErrorType;
import com.iab.omid.library.appnexus.adsession.Partner;
import com.iab.omid.library.appnexus.adsession.VerificationScriptResource;
import com.iab.omid.library.appnexus.adsession.video.VideoEvents;
import com.iab.omid.library.appnexus.b.c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher
{
  private com.iab.omid.library.appnexus.e.b a;
  private AdEvents b;
  private VideoEvents c;
  private a d;
  private double e;

  public AdSessionStatePublisher()
  {
    h();
    this.a = new com.iab.omid.library.appnexus.e.b(null);
  }

  public void a()
  {
  }

  public void a(float paramFloat)
  {
    com.iab.omid.library.appnexus.b.d.a().a(getWebView(), paramFloat);
  }

  void a(WebView paramWebView)
  {
    this.a = new com.iab.omid.library.appnexus.e.b(paramWebView);
  }

  public void a(AdEvents paramAdEvents)
  {
    this.b = paramAdEvents;
  }

  public void a(AdSessionConfiguration paramAdSessionConfiguration)
  {
    com.iab.omid.library.appnexus.b.d.a().a(getWebView(), paramAdSessionConfiguration.toJsonObject());
  }

  public void a(ErrorType paramErrorType, String paramString)
  {
    com.iab.omid.library.appnexus.b.d.a().a(getWebView(), paramErrorType, paramString);
  }

  public void a(com.iab.omid.library.appnexus.adsession.a parama, AdSessionContext paramAdSessionContext)
  {
    String str = parama.getAdSessionId();
    JSONObject localJSONObject1 = new JSONObject();
    com.iab.omid.library.appnexus.d.b.a(localJSONObject1, "environment", "app");
    com.iab.omid.library.appnexus.d.b.a(localJSONObject1, "adSessionType", paramAdSessionContext.getAdSessionContextType());
    com.iab.omid.library.appnexus.d.b.a(localJSONObject1, "deviceInfo", com.iab.omid.library.appnexus.d.a.d());
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put("clid");
    localJSONArray.put("vlid");
    com.iab.omid.library.appnexus.d.b.a(localJSONObject1, "supports", localJSONArray);
    JSONObject localJSONObject2 = new JSONObject();
    com.iab.omid.library.appnexus.d.b.a(localJSONObject2, "partnerName", paramAdSessionContext.getPartner().getName());
    com.iab.omid.library.appnexus.d.b.a(localJSONObject2, "partnerVersion", paramAdSessionContext.getPartner().getVersion());
    com.iab.omid.library.appnexus.d.b.a(localJSONObject1, "omidNativeInfo", localJSONObject2);
    JSONObject localJSONObject3 = new JSONObject();
    com.iab.omid.library.appnexus.d.b.a(localJSONObject3, "libraryVersion", "1.1.3-Appnexus");
    com.iab.omid.library.appnexus.d.b.a(localJSONObject3, "appId", c.a().b().getApplicationContext().getPackageName());
    com.iab.omid.library.appnexus.d.b.a(localJSONObject1, "app", localJSONObject3);
    if (paramAdSessionContext.getCustomReferenceData() != null)
      com.iab.omid.library.appnexus.d.b.a(localJSONObject1, "customReferenceData", paramAdSessionContext.getCustomReferenceData());
    JSONObject localJSONObject4 = new JSONObject();
    Iterator localIterator = paramAdSessionContext.getVerificationScriptResources().iterator();
    while (localIterator.hasNext())
    {
      VerificationScriptResource localVerificationScriptResource = (VerificationScriptResource)localIterator.next();
      com.iab.omid.library.appnexus.d.b.a(localJSONObject4, localVerificationScriptResource.getVendorKey(), localVerificationScriptResource.getVerificationParameters());
    }
    com.iab.omid.library.appnexus.b.d.a().a(getWebView(), str, localJSONObject1, localJSONObject4);
  }

  public void a(VideoEvents paramVideoEvents)
  {
    this.c = paramVideoEvents;
  }

  public void a(String paramString)
  {
    com.iab.omid.library.appnexus.b.d.a().a(getWebView(), paramString, null);
  }

  public void a(String paramString, double paramDouble)
  {
    if (paramDouble > this.e)
    {
      this.d = a.b;
      com.iab.omid.library.appnexus.b.d.a().c(getWebView(), paramString);
    }
  }

  public void a(String paramString, JSONObject paramJSONObject)
  {
    com.iab.omid.library.appnexus.b.d.a().a(getWebView(), paramString, paramJSONObject);
  }

  public void a(boolean paramBoolean)
  {
    if (e())
      if (!paramBoolean)
        break label26;
    label26: for (String str = "foregrounded"; ; str = "backgrounded")
    {
      com.iab.omid.library.appnexus.b.d.a().d(getWebView(), str);
      return;
    }
  }

  public void b()
  {
    this.a.clear();
  }

  public void b(String paramString, double paramDouble)
  {
    if ((paramDouble > this.e) && (this.d != a.c))
    {
      this.d = a.c;
      com.iab.omid.library.appnexus.b.d.a().c(getWebView(), paramString);
    }
  }

  public AdEvents c()
  {
    return this.b;
  }

  public VideoEvents d()
  {
    return this.c;
  }

  public boolean e()
  {
    return this.a.get() != null;
  }

  public void f()
  {
    com.iab.omid.library.appnexus.b.d.a().a(getWebView());
  }

  public void g()
  {
    com.iab.omid.library.appnexus.b.d.a().b(getWebView());
  }

  public WebView getWebView()
  {
    return (WebView)this.a.get();
  }

  public void h()
  {
    this.e = com.iab.omid.library.appnexus.d.d.a();
    this.d = a.a;
  }

  static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.publisher.AdSessionStatePublisher
 * JD-Core Version:    0.6.2
 */