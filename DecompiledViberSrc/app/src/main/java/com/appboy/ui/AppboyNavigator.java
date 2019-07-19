package com.appboy.ui;

import android.content.Context;
import com.appboy.f.c;
import com.appboy.h;
import com.appboy.ui.actions.NewsfeedAction;
import com.appboy.ui.actions.UriAction;

public class AppboyNavigator
  implements h
{
  private static final String TAG = c.a(AppboyNavigator.class);
  private static volatile h sCustomAppboyNavigator;
  private static volatile h sDefaultAppboyNavigator = new AppboyNavigator();

  public static void executeNewsFeedAction(Context paramContext, NewsfeedAction paramNewsfeedAction)
  {
    if (paramNewsfeedAction == null)
    {
      c.e(TAG, "IAppboyNavigator cannot open News feed because the news feed action object was null.");
      return;
    }
    paramNewsfeedAction.execute(paramContext);
  }

  public static void executeUriAction(Context paramContext, UriAction paramUriAction)
  {
    if (paramUriAction == null)
    {
      c.e(TAG, "IAppboyNavigator cannot open Uri because the Uri action object was null.");
      return;
    }
    paramUriAction.execute(paramContext);
  }

  public static h getAppboyNavigator()
  {
    if (sCustomAppboyNavigator != null)
      return sCustomAppboyNavigator;
    return sDefaultAppboyNavigator;
  }

  public void gotoNewsFeed(Context paramContext, NewsfeedAction paramNewsfeedAction)
  {
    executeNewsFeedAction(paramContext, paramNewsfeedAction);
  }

  public void gotoUri(Context paramContext, UriAction paramUriAction)
  {
    executeUriAction(paramContext, paramUriAction);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.AppboyNavigator
 * JD-Core Version:    0.6.2
 */