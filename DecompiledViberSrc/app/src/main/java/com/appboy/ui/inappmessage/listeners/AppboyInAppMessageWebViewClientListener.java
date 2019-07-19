package com.appboy.ui.inappmessage.listeners;

import android.net.Uri;
import android.os.Bundle;
import com.appboy.b.e;
import com.appboy.e.b;
import com.appboy.f.d;
import com.appboy.f.i;
import com.appboy.h;
import com.appboy.ui.AppboyNavigator;
import com.appboy.ui.actions.ActionFactory;
import com.appboy.ui.actions.NewsfeedAction;
import com.appboy.ui.actions.UriAction;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;
import java.util.Iterator;
import java.util.Set;

public class AppboyInAppMessageWebViewClientListener
  implements IInAppMessageWebViewClientListener
{
  private static final String TAG = com.appboy.f.c.a(AppboyInAppMessageWebViewClientListener.class);

  private AppboyInAppMessageManager getInAppMessageManager()
  {
    return AppboyInAppMessageManager.getInstance();
  }

  private void logHtmlInAppMessageClick(b paramb, Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("abButtonId")))
    {
      ((com.appboy.e.c)paramb).b(paramBundle.getString("abButtonId"));
      return;
    }
    paramb.y();
  }

  static String parseCustomEventNameFromQueryBundle(Bundle paramBundle)
  {
    return paramBundle.getString("name");
  }

  static com.appboy.e.b.a parsePropertiesFromQueryBundle(Bundle paramBundle)
  {
    com.appboy.e.b.a locala = new com.appboy.e.b.a();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!str1.equals("name"))
      {
        String str2 = paramBundle.getString(str1, null);
        if (!i.c(str2))
          locala.a(str1, str2);
      }
    }
    return locala;
  }

  static boolean parseUseWebViewFromQueryBundle(b paramb, Bundle paramBundle)
  {
    boolean bool1;
    if (paramBundle.containsKey("abDeepLink"))
      bool1 = Boolean.parseBoolean(paramBundle.getString("abDeepLink"));
    for (int i = 1; ; i = 0)
    {
      boolean bool2;
      int j;
      if (paramBundle.containsKey("abExternalOpen"))
      {
        bool2 = Boolean.parseBoolean(paramBundle.getString("abExternalOpen"));
        j = 1;
      }
      while (true)
      {
        boolean bool3 = paramb.w();
        if (j != 0)
          return (!bool1) && (!bool2);
        return bool3;
        j = i;
        bool2 = false;
      }
      bool1 = false;
    }
  }

  public void onCloseAction(b paramb, String paramString, Bundle paramBundle)
  {
    com.appboy.f.c.b(TAG, "IInAppMessageWebViewClientListener.onCloseAction called.");
    logHtmlInAppMessageClick(paramb, paramBundle);
    getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(true);
    getInAppMessageManager().getHtmlInAppMessageActionListener().onCloseClicked(paramb, paramString, paramBundle);
  }

  public void onCustomEventAction(b paramb, String paramString, Bundle paramBundle)
  {
    com.appboy.f.c.b(TAG, "IInAppMessageWebViewClientListener.onCustomEventAction called.");
    if (getInAppMessageManager().getActivity() == null);
    String str;
    do
    {
      com.appboy.f.c.d(TAG, "Can't perform custom event action because the activity is null.");
      do
        return;
      while (getInAppMessageManager().getHtmlInAppMessageActionListener().onCustomEventFired(paramb, paramString, paramBundle));
      str = parseCustomEventNameFromQueryBundle(paramBundle);
    }
    while (i.c(str));
    com.appboy.e.b.a locala = parsePropertiesFromQueryBundle(paramBundle);
    com.appboy.a.a(getInAppMessageManager().getActivity()).a(str, locala);
  }

  public void onNewsfeedAction(b paramb, String paramString, Bundle paramBundle)
  {
    com.appboy.f.c.b(TAG, "IInAppMessageWebViewClientListener.onNewsfeedAction called.");
    if (getInAppMessageManager().getActivity() == null)
      com.appboy.f.c.d(TAG, "Can't perform news feed action because the cached activity is null.");
    do
    {
      return;
      logHtmlInAppMessageClick(paramb, paramBundle);
    }
    while (getInAppMessageManager().getHtmlInAppMessageActionListener().onNewsfeedClicked(paramb, paramString, paramBundle));
    paramb.b(false);
    getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(false);
    NewsfeedAction localNewsfeedAction = new NewsfeedAction(d.a(paramb.b()), e.b);
    AppboyNavigator.getAppboyNavigator().gotoNewsFeed(getInAppMessageManager().getActivity(), localNewsfeedAction);
  }

  public void onOtherUrlAction(b paramb, String paramString, Bundle paramBundle)
  {
    com.appboy.f.c.b(TAG, "IInAppMessageWebViewClientListener.onOtherUrlAction called.");
    if (getInAppMessageManager().getActivity() == null)
      com.appboy.f.c.d(TAG, "Can't perform other url action because the cached activity is null.");
    UriAction localUriAction;
    do
    {
      do
      {
        return;
        logHtmlInAppMessageClick(paramb, paramBundle);
      }
      while (getInAppMessageManager().getHtmlInAppMessageActionListener().onOtherUrlAction(paramb, paramString, paramBundle));
      boolean bool = parseUseWebViewFromQueryBundle(paramb, paramBundle);
      Bundle localBundle = d.a(paramb.b());
      localBundle.putAll(paramBundle);
      localUriAction = ActionFactory.createUriActionFromUrlString(paramString, localBundle, bool, e.b);
      Uri localUri = localUriAction.getUri();
      if ((localUri != null) && (com.appboy.f.a.b(localUri)))
      {
        com.appboy.f.c.d(TAG, "Not passing local URI to AppboyNavigator. Got local uri: " + localUri);
        return;
      }
      paramb.b(false);
      getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(false);
    }
    while (localUriAction == null);
    AppboyNavigator.getAppboyNavigator().gotoUri(getInAppMessageManager().getApplicationContext(), localUriAction);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.listeners.AppboyInAppMessageWebViewClientListener
 * JD-Core Version:    0.6.2
 */