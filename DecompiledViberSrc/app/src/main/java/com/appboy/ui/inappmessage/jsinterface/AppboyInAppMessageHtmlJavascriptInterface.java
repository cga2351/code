package com.appboy.ui.inappmessage.jsinterface;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.appboy.f.c;
import java.math.BigDecimal;
import org.json.JSONObject;

public class AppboyInAppMessageHtmlJavascriptInterface
{
  private static final String TAG = c.a(AppboyInAppMessageHtmlJavascriptInterface.class);
  private Context mContext;
  private AppboyInAppMessageHtmlUserJavascriptInterface mUserInterface;

  public AppboyInAppMessageHtmlJavascriptInterface(Context paramContext)
  {
    this.mContext = paramContext;
    this.mUserInterface = new AppboyInAppMessageHtmlUserJavascriptInterface(paramContext);
  }

  @JavascriptInterface
  public AppboyInAppMessageHtmlUserJavascriptInterface getUser()
  {
    return this.mUserInterface;
  }

  @JavascriptInterface
  public void logCustomEventWithJSON(String paramString1, String paramString2)
  {
    com.appboy.e.b.a locala = parseProperties(paramString2);
    com.appboy.a.a(this.mContext).a(paramString1, locala);
  }

  @JavascriptInterface
  public void logPurchaseWithJSON(String paramString1, double paramDouble, String paramString2, int paramInt, String paramString3)
  {
    com.appboy.e.b.a locala = parseProperties(paramString3);
    com.appboy.a.a(this.mContext).a(paramString1, paramString2, new BigDecimal(Double.toString(paramDouble)), paramInt, locala);
  }

  com.appboy.e.b.a parseProperties(String paramString)
  {
    if (paramString != null)
      try
      {
        if ((!paramString.equals("undefined")) && (!paramString.equals("null")))
        {
          com.appboy.e.b.a locala = new com.appboy.e.b.a(new JSONObject(paramString));
          return locala;
        }
      }
      catch (Exception localException)
      {
        c.d(TAG, "Failed to parse properties JSON String: " + paramString, localException);
      }
    return null;
  }

  @JavascriptInterface
  public void requestImmediateDataFlush()
  {
    com.appboy.a.a(this.mContext).f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.jsinterface.AppboyInAppMessageHtmlJavascriptInterface
 * JD-Core Version:    0.6.2
 */