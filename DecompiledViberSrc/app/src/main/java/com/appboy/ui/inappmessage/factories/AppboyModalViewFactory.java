package com.appboy.ui.inappmessage.factories;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.appboy.b.a.d;
import com.appboy.e.b;
import com.appboy.e.l;
import com.appboy.f.i;
import com.appboy.g;
import com.appboy.ui.R.layout;
import com.appboy.ui.inappmessage.AppboyInAppMessageImageView;
import com.appboy.ui.inappmessage.IInAppMessageViewFactory;
import com.appboy.ui.inappmessage.views.AppboyInAppMessageModalView;

public class AppboyModalViewFactory
  implements IInAppMessageViewFactory
{
  @SuppressLint({"InflateParams"})
  private AppboyInAppMessageModalView getAppropriateModalView(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
      return (AppboyInAppMessageModalView)paramActivity.getLayoutInflater().inflate(R.layout.com_appboy_inappmessage_modal_graphic, null);
    return (AppboyInAppMessageModalView)paramActivity.getLayoutInflater().inflate(R.layout.com_appboy_inappmessage_modal, null);
  }

  public AppboyInAppMessageModalView createInAppMessageView(Activity paramActivity, b paramb)
  {
    Context localContext = paramActivity.getApplicationContext();
    l locall = (l)paramb;
    boolean bool = locall.C().equals(d.a);
    AppboyInAppMessageModalView localAppboyInAppMessageModalView = getAppropriateModalView(paramActivity, bool);
    localAppboyInAppMessageModalView.applyInAppMessageParameters(localContext, locall);
    String str = localAppboyInAppMessageModalView.getAppropriateImageUrl(paramb);
    if (!i.b(str))
      com.appboy.a.a(localContext).h().a(localContext, str, localAppboyInAppMessageModalView.getMessageImageView(), com.appboy.b.a.e);
    localAppboyInAppMessageModalView.getFrameView().setOnClickListener(null);
    localAppboyInAppMessageModalView.setMessageBackgroundColor(paramb.d());
    localAppboyInAppMessageModalView.setFrameColor(locall.I());
    localAppboyInAppMessageModalView.setMessageButtons(locall.B());
    localAppboyInAppMessageModalView.setMessageCloseButtonColor(locall.H());
    if (!bool)
    {
      localAppboyInAppMessageModalView.setMessage(paramb.a());
      localAppboyInAppMessageModalView.setMessageTextColor(paramb.g());
      localAppboyInAppMessageModalView.setMessageHeaderText(locall.F());
      localAppboyInAppMessageModalView.setMessageHeaderTextColor(locall.G());
      localAppboyInAppMessageModalView.setMessageIcon(paramb.i(), paramb.e(), paramb.f());
      localAppboyInAppMessageModalView.setMessageHeaderTextAlignment(locall.J());
      localAppboyInAppMessageModalView.setMessageTextAlign(locall.D());
      localAppboyInAppMessageModalView.resetMessageMargins(paramb.r());
      ((AppboyInAppMessageImageView)localAppboyInAppMessageModalView.getMessageImageView()).setAspectRatio(2.9F);
    }
    return localAppboyInAppMessageModalView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.factories.AppboyModalViewFactory
 * JD-Core Version:    0.6.2
 */