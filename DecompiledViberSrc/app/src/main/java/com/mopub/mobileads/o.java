package com.mopub.mobileads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Utils;
import com.mopub.network.Networking;

class o extends BaseWebView
{
  a b;

  o(Context paramContext)
  {
    super(paramContext);
    a();
    getSettings().setJavaScriptEnabled(true);
    enablePlugins(true);
    setBackgroundColor(0);
    setOnTouchListener(new b());
    setId((int)Utils.generateUniqueId());
  }

  static o a(Context paramContext, n paramn)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramn);
    o localo = new o(paramContext);
    paramn.initializeWebView(localo);
    return localo;
  }

  private void a()
  {
    setHorizontalScrollBarEnabled(false);
    setHorizontalScrollbarOverlay(false);
    setVerticalScrollBarEnabled(false);
    setVerticalScrollbarOverlay(false);
    getSettings().setSupportZoom(false);
    setScrollBarStyle(0);
  }

  void a(a parama)
  {
    this.b = parama;
  }

  void a(String paramString)
  {
    loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://" + Constants.HOST + "/", paramString, "text/html", "utf-8", null);
  }

  static abstract interface a
  {
    public abstract void onVastWebViewClick();
  }

  class b
    implements View.OnTouchListener
  {
    private boolean b;

    b()
    {
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      default:
      case 0:
      case 1:
      }
      do
      {
        do
        {
          return false;
          this.b = true;
          return false;
        }
        while (!this.b);
        this.b = false;
      }
      while (o.this.b == null);
      o.this.b.onVastWebViewClick();
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.o
 * JD-Core Version:    0.6.2
 */