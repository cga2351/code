package com.appboy.ui.inappmessage.factories;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.appboy.b.a.d;
import com.appboy.e.b;
import com.appboy.e.h;
import com.appboy.f.i;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;
import com.appboy.ui.inappmessage.AppboyInAppMessageImageView;
import com.appboy.ui.inappmessage.IInAppMessageViewFactory;
import com.appboy.ui.inappmessage.views.AppboyInAppMessageFullView;
import com.appboy.ui.support.ViewUtils;
import java.util.List;

public class AppboyFullViewFactory
  implements IInAppMessageViewFactory
{
  public AppboyInAppMessageFullView createInAppMessageView(Activity paramActivity, b paramb)
  {
    final Context localContext = paramActivity.getApplicationContext();
    final h localh = (h)paramb;
    boolean bool = localh.C().equals(d.a);
    final AppboyInAppMessageFullView localAppboyInAppMessageFullView = getAppropriateFullView(paramActivity, bool);
    localAppboyInAppMessageFullView.createAppropriateViews(paramActivity, localh);
    String str = localAppboyInAppMessageFullView.getAppropriateImageUrl(paramb);
    if (!i.b(str))
      com.appboy.a.a(localContext).h().a(localContext, str, localAppboyInAppMessageFullView.getMessageImageView(), com.appboy.b.a.g);
    localAppboyInAppMessageFullView.getFrameView().setOnClickListener(null);
    localAppboyInAppMessageFullView.setMessageBackgroundColor(localh.d());
    localAppboyInAppMessageFullView.setFrameColor(localh.I());
    localAppboyInAppMessageFullView.setMessageButtons(localh.B());
    localAppboyInAppMessageFullView.setMessageCloseButtonColor(localh.H());
    if (!bool)
    {
      localAppboyInAppMessageFullView.setMessage(localh.a());
      localAppboyInAppMessageFullView.setMessageTextColor(localh.g());
      localAppboyInAppMessageFullView.setMessageHeaderText(localh.F());
      localAppboyInAppMessageFullView.setMessageHeaderTextColor(localh.G());
      localAppboyInAppMessageFullView.setMessageHeaderTextAlignment(localh.J());
      localAppboyInAppMessageFullView.setMessageTextAlign(localh.D());
      localAppboyInAppMessageFullView.resetMessageMargins(localh.r());
      ((AppboyInAppMessageImageView)localAppboyInAppMessageFullView.getMessageImageView()).setToHalfParentHeight(true);
    }
    resetLayoutParamsIfAppropriate(paramActivity, localh, localAppboyInAppMessageFullView);
    final View localView = localAppboyInAppMessageFullView.findViewById(R.id.com_appboy_inappmessage_full_scrollview);
    if (localView != null)
      localView.post(new Runnable()
      {
        public void run()
        {
          int i = this.val$scrollViewParent.getHeight() / 2;
          if ((localh.B() == null) || (localh.B().isEmpty()));
          for (int j = (int)ViewUtils.convertDpToPixels(localContext, 60.0D); ; j = (int)ViewUtils.convertDpToPixels(localContext, 124.0D))
          {
            int k = Math.min(localView.getHeight(), i - j);
            ViewUtils.setHeightOnViewLayoutParams(localView, k);
            localView.requestLayout();
            localAppboyInAppMessageFullView.getMessageImageView().requestLayout();
            return;
          }
        }
      });
    return localAppboyInAppMessageFullView;
  }

  @SuppressLint({"InflateParams"})
  AppboyInAppMessageFullView getAppropriateFullView(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
      return (AppboyInAppMessageFullView)paramActivity.getLayoutInflater().inflate(R.layout.com_appboy_inappmessage_full_graphic, null);
    return (AppboyInAppMessageFullView)paramActivity.getLayoutInflater().inflate(R.layout.com_appboy_inappmessage_full, null);
  }

  boolean resetLayoutParamsIfAppropriate(Activity paramActivity, b paramb, AppboyInAppMessageFullView paramAppboyInAppMessageFullView)
  {
    if (!ViewUtils.isRunningOnTablet(paramActivity));
    int i;
    int j;
    do
    {
      do
        return false;
      while ((paramb.t() == null) || (paramb.t() == com.appboy.b.a.g.c));
      i = paramAppboyInAppMessageFullView.getLongEdge();
      j = paramAppboyInAppMessageFullView.getShortEdge();
    }
    while ((i <= 0) || (j <= 0));
    if (paramb.t() == com.appboy.b.a.g.b);
    for (RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j); ; localLayoutParams = new RelativeLayout.LayoutParams(j, i))
    {
      localLayoutParams.addRule(13, -1);
      paramAppboyInAppMessageFullView.getMessageBackgroundObject().setLayoutParams(localLayoutParams);
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.factories.AppboyFullViewFactory
 * JD-Core Version:    0.6.2
 */