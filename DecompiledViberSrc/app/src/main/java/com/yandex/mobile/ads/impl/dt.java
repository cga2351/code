package com.yandex.mobile.ads.impl;

import java.util.Locale;

public final class dt
{
  public static final String a = a("onCollapse", "config", "AdPerformActionsJSI");
  public static final String b = a("onExpand", "config", "AdPerformActionsJSI");
  public static final String c = String.format(Locale.US, "<script type='text/javascript'> \nfunction wrapJsFunction_%1$s() { \n  window['%1$s'] = function(%3$s) { \n      return %4$s.%1$s(%2$s, %3$s); \n  } \n} \n \nwrapJsFunction_%1$s('%1$s'); \n</script> \n", new Object[] { "onAdRender", "document.querySelector('#rtb').offsetHeight", "testTag", "AdPerformActionsJSI" });
  static final String d = String.format(Locale.US, "<script type='text/javascript'> \nfunction wrapJsFunction_%1$s() { \n  window['%1$s'] = function() { \n      return %2$s.%1$s(); \n  } \n} \n \nwrapJsFunction_%1$s('%1$s'); \n</script> \n", new Object[] { "getBannerInfo", "AdPerformActionsJSI" });

  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<body style='width:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("px;'>");
    return localStringBuilder.toString();
  }

  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n<style>ytag.container { width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("px; height:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("px; }</style>\n");
    return localStringBuilder.toString();
  }

  private static String a(String paramString1, String paramString2, String paramString3)
  {
    return String.format(Locale.US, "<script type='text/javascript'> \nfunction wrapJsFunction_%1$s() { \n  window['%1$s'] = function(%2$s) { \n      %3$s.%1$s(JSON.stringify(%2$s)); \n  } \n} \n \nwrapJsFunction_%1$s('%1$s'); \n</script> \n", new Object[] { paramString1, paramString2, paramString3 }).replace("JSON.stringify()", "");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.dt
 * JD-Core Version:    0.6.2
 */