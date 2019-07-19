package com.appboy.ui.inappmessage.factories;

import android.app.Activity;
import android.view.LayoutInflater;
import com.appboy.e.b;
import com.appboy.e.j;
import com.appboy.ui.R.layout;
import com.appboy.ui.inappmessage.IInAppMessageViewFactory;
import com.appboy.ui.inappmessage.InAppMessageWebViewClient;
import com.appboy.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import com.appboy.ui.inappmessage.views.AppboyInAppMessageHtmlFullView;

public class AppboyHtmlFullViewFactory
  implements IInAppMessageViewFactory
{
  private IInAppMessageWebViewClientListener mInAppMessageWebViewClientListener;

  public AppboyHtmlFullViewFactory(IInAppMessageWebViewClientListener paramIInAppMessageWebViewClientListener)
  {
    this.mInAppMessageWebViewClientListener = paramIInAppMessageWebViewClientListener;
  }

  public AppboyInAppMessageHtmlFullView createInAppMessageView(Activity paramActivity, b paramb)
  {
    j localj = (j)paramb;
    AppboyInAppMessageHtmlFullView localAppboyInAppMessageHtmlFullView = (AppboyInAppMessageHtmlFullView)paramActivity.getLayoutInflater().inflate(R.layout.com_appboy_inappmessage_html_full, null);
    localAppboyInAppMessageHtmlFullView.setWebViewContent(paramb.a(), localj.B());
    localAppboyInAppMessageHtmlFullView.setInAppMessageWebViewClient(new InAppMessageWebViewClient(paramActivity.getApplicationContext(), paramb, this.mInAppMessageWebViewClientListener));
    return localAppboyInAppMessageHtmlFullView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.inappmessage.factories.AppboyHtmlFullViewFactory
 * JD-Core Version:    0.6.2
 */