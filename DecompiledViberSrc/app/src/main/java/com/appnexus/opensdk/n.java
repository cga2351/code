package com.appnexus.opensdk;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.ViewUtil;

class n
  implements AdActivity.a
{
  private Activity a;
  private f b;
  private MRAIDImplementation c = null;

  public n(Activity paramActivity)
  {
    this.a = paramActivity;
  }

  public void backPressed()
  {
    if (this.c != null)
    {
      this.c.a(null);
      this.c.b();
    }
    this.c = null;
  }

  public void browserLaunched()
  {
  }

  public void create()
  {
    if ((AdView.o == null) || (AdView.p == null))
    {
      Clog.e(Clog.baseLogTag, "Launched MRAID Fullscreen activity with invalid properties");
      this.a.finish();
    }
    do
    {
      return;
      ViewUtil.removeChildFromParent(AdView.o);
      this.a.setContentView(AdView.o);
      if ((AdView.o.getChildAt(0) instanceof f))
        this.b = ((f)AdView.o.getChildAt(0));
      if ((this.b.getContext() instanceof MutableContextWrapper))
        ((MutableContextWrapper)this.b.getContext()).setBaseContext(this.a);
      this.c = AdView.p;
      this.c.a(this.a);
    }
    while (AdView.q == null);
    AdView.q.a();
  }

  public void destroy()
  {
  }

  public WebView getWebView()
  {
    return this.b;
  }

  public void interacted()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.n
 * JD-Core Version:    0.6.2
 */