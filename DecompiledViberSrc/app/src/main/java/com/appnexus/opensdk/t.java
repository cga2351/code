package com.appnexus.opensdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.ViewUtil;

class t extends g
{
  private f a;
  WebChromeClient.CustomViewCallback c;
  FrameLayout d;
  Activity e;
  AdView f;

  public t(Activity paramActivity)
  {
    this.e = paramActivity;
  }

  public t(f paramf)
  {
    this.e = ((Activity)paramf.v());
    this.a = paramf;
    this.f = this.a.a;
  }

  private void a(FrameLayout paramFrameLayout)
  {
    if ((this.f != null) && (this.f.getAdType() == AdType.VIDEO))
      return;
    ImageButton localImageButton = new ImageButton(this.e);
    localImageButton.setImageDrawable(this.e.getResources().getDrawable(17301560));
    localImageButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
    localImageButton.setBackgroundColor(0);
    localImageButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        t.this.onHideCustomView();
      }
    });
    paramFrameLayout.addView(localImageButton);
  }

  public void onGeolocationPermissionsHidePrompt()
  {
    if ((this.f != null) && (!this.f.e()) && (!this.f.a()))
      this.f.getAdDispatcher().b();
  }

  public void onGeolocationPermissionsShowPrompt(final String paramString, final GeolocationPermissions.Callback paramCallback)
  {
    if (SDKSettings.isLocationEnabledForCreative())
    {
      if (this.a != null);
      for (Object localObject = ViewUtil.getTopContext(this.a); ; localObject = this.e)
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder((Context)localObject);
        localBuilder.setTitle(String.format(this.e.getResources().getString(R.string.html5_geo_permission_prompt_title), new Object[] { paramString }));
        localBuilder.setMessage(R.string.html5_geo_permission_prompt);
        localBuilder.setPositiveButton(R.string.allow, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramCallback.invoke(paramString, true, true);
          }
        });
        localBuilder.setNegativeButton(R.string.deny, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramCallback.invoke(paramString, false, false);
          }
        });
        localBuilder.create().show();
        if ((this.f != null) && (!this.f.e()) && (!this.f.a()))
          this.f.getAdDispatcher().a();
        return;
      }
    }
    paramCallback.invoke(paramString, false, false);
  }

  public void onHideCustomView()
  {
    super.onHideCustomView();
    if ((this.e == null) || (this.d == null))
      Clog.w(Clog.baseLogTag, Clog.getString(R.string.fullscreen_video_hide_error));
    do
    {
      return;
      if (this.a != null);
      for (ViewGroup localViewGroup = (ViewGroup)this.a.getRootView().findViewById(16908290); localViewGroup == null; localViewGroup = (ViewGroup)this.e.findViewById(16908290))
      {
        Clog.w(Clog.baseLogTag, Clog.getString(R.string.fullscreen_video_hide_error));
        return;
      }
      localViewGroup.removeView(this.d);
    }
    while (this.c == null);
    try
    {
      this.c.onCustomViewHidden();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      Clog.e(Clog.baseLogTag, "Exception calling customViewCallback  onCustomViewHidden: " + localNullPointerException.getMessage());
    }
  }

  public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    onShowCustomView(paramView, paramCustomViewCallback);
  }

  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    super.onShowCustomView(paramView, paramCustomViewCallback);
    if (this.e == null)
    {
      Clog.w(Clog.baseLogTag, Clog.getString(R.string.fullscreen_video_show_error));
      return;
    }
    if (this.a != null);
    for (ViewGroup localViewGroup = (ViewGroup)this.a.getRootView().findViewById(16908290); localViewGroup == null; localViewGroup = (ViewGroup)this.e.findViewById(16908290))
    {
      Clog.w(Clog.baseLogTag, Clog.getString(R.string.fullscreen_video_show_error));
      return;
    }
    this.c = paramCustomViewCallback;
    if ((paramView instanceof FrameLayout))
    {
      this.d = ((FrameLayout)paramView);
      this.d.setClickable(true);
      this.d.setBackgroundColor(-16777216);
      try
      {
        a(this.d);
        localViewGroup.addView(this.d, new ViewGroup.LayoutParams(-1, -1));
        return;
      }
      catch (Exception localException)
      {
        Clog.d(Clog.baseLogTag, localException.toString());
        return;
      }
    }
    this.d = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.t
 * JD-Core Version:    0.6.2
 */