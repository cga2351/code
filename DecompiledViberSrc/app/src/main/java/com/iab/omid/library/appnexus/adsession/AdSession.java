package com.iab.omid.library.appnexus.adsession;

import android.view.View;
import com.iab.omid.library.appnexus.d.e;
import com.iab.omid.library.appnexus.publisher.AdSessionStatePublisher;

public abstract class AdSession
{
  public static AdSession createAdSession(AdSessionConfiguration paramAdSessionConfiguration, AdSessionContext paramAdSessionContext)
  {
    e.a();
    e.a(paramAdSessionConfiguration, "AdSessionConfiguration is null");
    e.a(paramAdSessionContext, "AdSessionContext is null");
    return new a(paramAdSessionConfiguration, paramAdSessionContext);
  }

  public abstract void addFriendlyObstruction(View paramView);

  public abstract void error(ErrorType paramErrorType, String paramString);

  public abstract void finish();

  public abstract String getAdSessionId();

  public abstract AdSessionStatePublisher getAdSessionStatePublisher();

  public abstract void registerAdView(View paramView);

  public abstract void removeAllFriendlyObstructions();

  public abstract void removeFriendlyObstruction(View paramView);

  public abstract void start();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.AdSession
 * JD-Core Version:    0.6.2
 */