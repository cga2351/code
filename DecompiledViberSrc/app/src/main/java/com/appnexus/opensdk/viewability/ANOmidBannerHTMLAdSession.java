package com.appnexus.opensdk.viewability;

import android.webkit.WebView;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.StringUtil;
import com.iab.omid.library.appnexus.ScriptInjector;
import com.iab.omid.library.appnexus.adsession.AdEvents;
import com.iab.omid.library.appnexus.adsession.AdSession;
import com.iab.omid.library.appnexus.adsession.AdSessionConfiguration;
import com.iab.omid.library.appnexus.adsession.AdSessionContext;
import com.iab.omid.library.appnexus.adsession.Owner;

public class ANOmidBannerHTMLAdSession
{
  private AdSession a;

  public void fireImpression()
  {
    if (this.a != null);
    try
    {
      AdEvents.createAdEvents(this.a).impressionOccurred();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label19: break label19;
    }
  }

  public void initAdSession(WebView paramWebView)
  {
    try
    {
      AdSessionContext localAdSessionContext = AdSessionContext.createHtmlAdSessionContext(ANOmidViewabilty.getInstance().getAppnexusPartner(), paramWebView, "");
      this.a = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(Owner.NATIVE, null, false), localAdSessionContext);
      this.a.registerAdView(paramWebView);
      this.a.start();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      Clog.e(Clog.baseLogTag, "OMID Ad Session - Exception", localNullPointerException);
    }
  }

  public String prependOMIDJSToHTML(String paramString)
  {
    try
    {
      if (!StringUtil.isEmpty(ANOmidViewabilty.getInstance().getOmidJsServiceContent()))
      {
        String str = ScriptInjector.injectScriptContentIntoHtml(ANOmidViewabilty.getInstance().getOmidJsServiceContent(), paramString);
        paramString = str;
      }
      return paramString;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }

  public void stopAdSession()
  {
    if (this.a != null)
    {
      this.a.finish();
      this.a = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.viewability.ANOmidBannerHTMLAdSession
 * JD-Core Version:    0.6.2
 */