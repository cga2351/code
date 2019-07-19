package com.vk.sdk.dialogs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.vk.sdk.R.id;
import com.vk.sdk.R.layout;
import com.vk.sdk.R.string;
import com.vk.sdk.R.style;
import com.vk.sdk.VKServiceActivity;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.util.VKUtil;
import java.util.Locale;
import java.util.Map;

public class VKOpenAuthDialog
  implements DialogInterface.OnDismissListener
{
  private static final String CANCEL = "cancel";
  private static final String ERROR = "error";
  private static final String REDIRECT_URL = "https://oauth.vk.com/blank.html";
  public static final String VK_EXTRA_API_VERSION = "version";
  public static final String VK_EXTRA_CLIENT_ID = "client_id";
  public static final String VK_EXTRA_REVOKE = "revoke";
  public static final String VK_EXTRA_SCOPE = "scope";
  public static final String VK_EXTRA_TOKEN_DATA = "extra-token-data";
  public static final String VK_EXTRA_VALIDATION_REQUEST = "extra-validation-request";
  public static final String VK_RESULT_INTENT_NAME = "com.vk.auth-token";
  protected Bundle mBundle;
  protected Intent mData;
  protected Dialog mDialog;
  protected View mProgress;
  protected int mReqCode;
  protected int mResCode = -1;
  protected View mView;
  protected VKError mVkError;
  protected WebView mWebView;

  private void finish()
  {
    if (this.mDialog != null)
      this.mDialog.dismiss();
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  private void loadPage()
  {
    try
    {
      VKError localVKError = this.mVkError;
      String str1 = null;
      Locale localLocale;
      Object[] arrayOfObject;
      if (localVKError == null)
        if (str1 == null)
        {
          int i = this.mBundle.getInt("client_id", 0);
          String str2 = this.mBundle.getString("scope");
          String str3 = this.mBundle.getString("version");
          boolean bool = this.mBundle.getBoolean("revoke", false);
          localLocale = Locale.US;
          arrayOfObject = new Object[5];
          arrayOfObject[0] = Integer.valueOf(i);
          arrayOfObject[1] = str2;
          arrayOfObject[2] = "https://oauth.vk.com/blank.html";
          arrayOfObject[3] = str3;
          if (!bool)
            break label229;
        }
      label229: for (int j = 1; ; j = 0)
      {
        arrayOfObject[4] = Integer.valueOf(j);
        str1 = String.format(localLocale, "https://oauth.vk.com/authorize?client_id=%s&scope=%s&redirect_uri=%s&display=mobile&v=%s&response_type=token&revoke=%d", arrayOfObject);
        this.mWebView.setWebViewClient(new OAuthWebViewClient(this));
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.loadUrl(str1);
        this.mWebView.setBackgroundColor(0);
        if (Build.VERSION.SDK_INT >= 11)
          this.mWebView.setLayerType(1, null);
        this.mWebView.setVerticalScrollBarEnabled(false);
        this.mWebView.setVisibility(4);
        this.mWebView.setOverScrollMode(2);
        this.mProgress.setVisibility(0);
        return;
        str1 = this.mVkError.redirectUri;
        break;
      }
    }
    catch (Exception localException)
    {
      setResult(0);
      finish();
    }
  }

  private void setResult(int paramInt)
  {
    this.mResCode = paramInt;
  }

  private void setResult(int paramInt, Intent paramIntent)
  {
    this.mResCode = paramInt;
    this.mData = paramIntent;
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.mView == null);
    for (Activity localActivity = null; ; localActivity = (Activity)this.mView.getContext())
    {
      if ((localActivity instanceof VKServiceActivity))
        ((VKServiceActivity)localActivity).onActivityResultPublic(this.mReqCode, this.mResCode, this.mData);
      return;
    }
  }

  public void show(Activity paramActivity, Bundle paramBundle, int paramInt, VKError paramVKError)
  {
    this.mVkError = paramVKError;
    this.mBundle = paramBundle;
    this.mReqCode = paramInt;
    this.mView = View.inflate(paramActivity, R.layout.vk_open_auth_dialog, null);
    this.mProgress = this.mView.findViewById(R.id.progress);
    this.mWebView = ((WebView)this.mView.findViewById(R.id.copyUrl));
    final Dialog localDialog = new Dialog(paramActivity, R.style.VKAlertDialog);
    localDialog.setContentView(this.mView);
    localDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        localDialog.dismiss();
      }
    });
    localDialog.setOnDismissListener(this);
    if (Build.VERSION.SDK_INT >= 21)
      localDialog.getWindow().setStatusBarColor(0);
    this.mDialog = localDialog;
    this.mDialog.show();
    loadPage();
  }

  private static class OAuthWebViewClient extends WebViewClient
  {
    boolean canShowPage = true;
    final VKOpenAuthDialog vkOpenAuthDialog;

    public OAuthWebViewClient(VKOpenAuthDialog paramVKOpenAuthDialog)
    {
      this.vkOpenAuthDialog = paramVKOpenAuthDialog;
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (this.canShowPage)
      {
        if (this.vkOpenAuthDialog.mProgress != null)
          this.vkOpenAuthDialog.mProgress.setVisibility(8);
        paramWebView.setVisibility(0);
      }
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      processUrl(paramString);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      this.canShowPage = false;
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramWebView.getContext()).setMessage(paramString1).setPositiveButton(R.string.vk_retry, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          VKOpenAuthDialog.OAuthWebViewClient.this.vkOpenAuthDialog.loadPage();
        }
      }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          VKOpenAuthDialog.OAuthWebViewClient.this.vkOpenAuthDialog.finish();
        }
      });
      try
      {
        localBuilder.show();
        return;
      }
      catch (Exception localException)
      {
      }
    }

    boolean processUrl(String paramString)
    {
      boolean bool1 = paramString.startsWith("https://oauth.vk.com/blank.html");
      boolean bool2 = false;
      Intent localIntent;
      if (bool1)
      {
        localIntent = new Intent("com.vk.auth-token");
        String str = paramString.substring(1 + paramString.indexOf('#'));
        localIntent.putExtra("extra-token-data", str);
        Map localMap = VKUtil.explodeQueryString(str);
        if (this.vkOpenAuthDialog.mVkError != null)
          localIntent.putExtra("extra-validation-request", this.vkOpenAuthDialog.mVkError.request.registerObject());
        if ((localMap == null) || ((!localMap.containsKey("error")) && (!localMap.containsKey("cancel"))))
          break label136;
        this.vkOpenAuthDialog.setResult(0, localIntent);
      }
      while (true)
      {
        this.vkOpenAuthDialog.finish();
        bool2 = true;
        return bool2;
        label136: this.vkOpenAuthDialog.setResult(-1, localIntent);
      }
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (processUrl(paramString))
        return true;
      this.canShowPage = true;
      return false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.dialogs.VKOpenAuthDialog
 * JD-Core Version:    0.6.2
 */