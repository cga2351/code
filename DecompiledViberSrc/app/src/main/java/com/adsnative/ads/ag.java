package com.adsnative.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ag extends WebChromeClient
{
  FrameLayout.LayoutParams a = new FrameLayout.LayoutParams(-1, -1);
  private View b;
  private FrameLayout c;
  private WebChromeClient.CustomViewCallback d;
  private Context e;

  public ag(Context paramContext)
  {
    this.e = paramContext;
  }

  public void onHideCustomView()
  {
    if (this.b == null)
      return;
    this.b.setVisibility(8);
    this.c.removeView(this.b);
    this.b = null;
    this.c.setVisibility(8);
    this.c = null;
    this.d.onCustomViewHidden();
  }

  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (this.b != null)
    {
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    this.c = new FrameLayout(this.e);
    this.c.setLayoutParams(this.a);
    this.c.setBackgroundResource(17170444);
    paramView.setLayoutParams(this.a);
    this.c.addView(paramView);
    this.b = paramView;
    this.d = paramCustomViewCallback;
    this.c.setVisibility(0);
    ((Activity)this.e).addContentView(this.c, this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.ag
 * JD-Core Version:    0.6.2
 */