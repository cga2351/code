package com.facebook.react.devsupport;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.facebook.react.R.layout;
import com.facebook.react.R.string;
import com.facebook.react.bridge.UiThreadUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import javax.annotation.Nullable;

public class DevLoadingViewController
{
  private static boolean sEnabled = true;

  @Nullable
  private PopupWindow mDevLoadingPopup;

  @Nullable
  private TextView mDevLoadingView;
  private final ReactInstanceManagerDevHelper mReactInstanceManagerHelper;

  public DevLoadingViewController(Context paramContext, ReactInstanceManagerDevHelper paramReactInstanceManagerDevHelper)
  {
    this.mReactInstanceManagerHelper = paramReactInstanceManagerDevHelper;
  }

  @Nullable
  private Context getContext()
  {
    return this.mReactInstanceManagerHelper.getCurrentActivity();
  }

  private void hideInternal()
  {
    if ((this.mDevLoadingPopup != null) && (this.mDevLoadingPopup.isShowing()))
    {
      this.mDevLoadingPopup.dismiss();
      this.mDevLoadingPopup = null;
      this.mDevLoadingView = null;
    }
  }

  public static void setDevLoadingEnabled(boolean paramBoolean)
  {
    sEnabled = paramBoolean;
  }

  private void showInternal(String paramString)
  {
    if ((this.mDevLoadingPopup != null) && (this.mDevLoadingPopup.isShowing()))
      return;
    Activity localActivity = this.mReactInstanceManagerHelper.getCurrentActivity();
    if (localActivity == null)
    {
      FLog.e("ReactNative", "Unable to display loading message because react activity isn't available");
      return;
    }
    Rect localRect = new Rect();
    localActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    this.mDevLoadingView = ((TextView)((LayoutInflater)localActivity.getSystemService("layout_inflater")).inflate(R.layout.dev_loading_view, null));
    this.mDevLoadingView.setText(paramString);
    this.mDevLoadingPopup = new PopupWindow(this.mDevLoadingView, -1, -2);
    this.mDevLoadingPopup.setTouchable(false);
    this.mDevLoadingPopup.showAtLocation(localActivity.getWindow().getDecorView(), 0, 0, i);
  }

  public void hide()
  {
    if (!sEnabled)
      return;
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        DevLoadingViewController.this.hideInternal();
      }
    });
  }

  public void showForRemoteJSEnabled()
  {
    Context localContext = getContext();
    if (localContext == null)
      return;
    showMessage(localContext.getString(R.string.catalyst_remotedbg_message));
  }

  public void showForUrl(String paramString)
  {
    Context localContext = getContext();
    if (localContext == null)
      return;
    try
    {
      URL localURL = new URL(paramString);
      int i = R.string.catalyst_loading_from_url;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = (localURL.getHost() + ":" + localURL.getPort());
      showMessage(localContext.getString(i, arrayOfObject));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      FLog.e("ReactNative", "Bundle url format is invalid. \n\n" + localMalformedURLException.toString());
    }
  }

  public void showMessage(final String paramString)
  {
    if (!sEnabled)
      return;
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        DevLoadingViewController.this.showInternal(paramString);
      }
    });
  }

  public void updateProgress(@Nullable final String paramString, @Nullable final Integer paramInteger1, @Nullable final Integer paramInteger2)
  {
    if (!sEnabled)
      return;
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramString != null);
        for (String str = paramString; ; str = "Loading")
        {
          localStringBuilder.append(str);
          if ((paramInteger1 != null) && (paramInteger2 != null) && (paramInteger2.intValue() > 0))
          {
            Locale localLocale = Locale.getDefault();
            Object[] arrayOfObject = new Object[3];
            arrayOfObject[0] = Float.valueOf(100.0F * (paramInteger1.intValue() / paramInteger2.intValue()));
            arrayOfObject[1] = paramInteger1;
            arrayOfObject[2] = paramInteger2;
            localStringBuilder.append(String.format(localLocale, " %.1f%% (%d/%d)", arrayOfObject));
          }
          localStringBuilder.append("…");
          if (DevLoadingViewController.this.mDevLoadingView != null)
            DevLoadingViewController.this.mDevLoadingView.setText(localStringBuilder);
          return;
        }
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DevLoadingViewController
 * JD-Core Version:    0.6.2
 */