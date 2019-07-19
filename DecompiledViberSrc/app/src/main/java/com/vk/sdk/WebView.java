package com.vk.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class WebView extends android.webkit.WebView
{
  public WebView(Context paramContext)
  {
    super(paramContext);
  }

  public WebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    while ((getParent() instanceof View))
    {
      View localView = (View)getParent();
      localView.setBackgroundColor(0);
      this = localView;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.WebView
 * JD-Core Version:    0.6.2
 */