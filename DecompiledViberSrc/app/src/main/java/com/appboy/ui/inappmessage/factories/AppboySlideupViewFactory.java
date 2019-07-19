package com.appboy.ui.inappmessage.factories;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import com.appboy.e.b;
import com.appboy.e.m;
import com.appboy.f.i;
import com.appboy.g;
import com.appboy.ui.R.layout;
import com.appboy.ui.inappmessage.IInAppMessageViewFactory;
import com.appboy.ui.inappmessage.views.AppboyInAppMessageSlideupView;

public class AppboySlideupViewFactory
  implements IInAppMessageViewFactory
{
  public AppboyInAppMessageSlideupView createInAppMessageView(Activity paramActivity, b paramb)
  {
    Context localContext = paramActivity.getApplicationContext();
    m localm = (m)paramb;
    AppboyInAppMessageSlideupView localAppboyInAppMessageSlideupView = (AppboyInAppMessageSlideupView)paramActivity.getLayoutInflater().inflate(R.layout.com_appboy_inappmessage_slideup, null);
    localAppboyInAppMessageSlideupView.applyInAppMessageParameters(paramb);
    String str = localAppboyInAppMessageSlideupView.getAppropriateImageUrl(paramb);
    if (!i.b(str))
      com.appboy.a.a(localContext).h().a(localContext, str, localAppboyInAppMessageSlideupView.getMessageImageView(), com.appboy.b.a.f);
    localAppboyInAppMessageSlideupView.setMessageBackgroundColor(localm.d());
    localAppboyInAppMessageSlideupView.setMessage(localm.a());
    localAppboyInAppMessageSlideupView.setMessageTextColor(localm.g());
    localAppboyInAppMessageSlideupView.setMessageTextAlign(localm.D());
    localAppboyInAppMessageSlideupView.setMessageIcon(localm.i(), localm.e(), localm.f());
    localAppboyInAppMessageSlideupView.setMessageChevron(localm.C(), localm.n());
    localAppboyInAppMessageSlideupView.resetMessageMargins(paramb.r());
    return localAppboyInAppMessageSlideupView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.factories.AppboySlideupViewFactory
 * JD-Core Version:    0.6.2
 */