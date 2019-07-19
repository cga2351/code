package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;

@zzare
@TargetApi(11)
public final class zzbgs extends WebChromeClient
{
  private final zzbha zzdbu;

  public zzbgs(zzbha paramzzbha)
  {
    this.zzdbu = paramzzbha;
  }

  private static Context zza(WebView paramWebView)
  {
    Object localObject;
    if (!(paramWebView instanceof zzbha))
      localObject = paramWebView.getContext();
    zzbha localzzbha;
    do
    {
      return localObject;
      localzzbha = (zzbha)paramWebView;
      localObject = localzzbha.zzyd();
    }
    while (localObject != null);
    return localzzbha.getContext();
  }

  private final boolean zza(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, JsResult paramJsResult, JsPromptResult paramJsPromptResult, boolean paramBoolean)
  {
    AlertDialog.Builder localBuilder;
    try
    {
      if ((this.zzdbu != null) && (this.zzdbu.zzaai() != null) && (this.zzdbu.zzaai().zzaax() != null))
      {
        zzb localzzb = this.zzdbu.zzaai().zzaax();
        if ((localzzb != null) && (!localzzb.zzkx()))
        {
          localzzb.zzbk(11 + String.valueOf(paramString1).length() + String.valueOf(paramString3).length() + "window." + paramString1 + "('" + paramString3 + "')");
          return false;
        }
      }
      localBuilder = new AlertDialog.Builder(paramContext);
      localBuilder.setTitle(paramString2);
      if (paramBoolean)
      {
        LinearLayout localLinearLayout = new LinearLayout(paramContext);
        localLinearLayout.setOrientation(1);
        TextView localTextView = new TextView(paramContext);
        localTextView.setText(paramString3);
        EditText localEditText = new EditText(paramContext);
        localEditText.setText(paramString4);
        localLinearLayout.addView(localTextView);
        localLinearLayout.addView(localEditText);
        localBuilder.setView(localLinearLayout).setPositiveButton(17039370, new zzbgy(paramJsPromptResult, localEditText)).setNegativeButton(17039360, new zzbgx(paramJsPromptResult)).setOnCancelListener(new zzbgw(paramJsPromptResult)).create().show();
        return true;
      }
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      zzaxa.zzd("Fail to display Dialog.", localBadTokenException);
      return true;
    }
    localBuilder.setMessage(paramString3).setPositiveButton(17039370, new zzbgv(paramJsResult)).setNegativeButton(17039360, new zzbgu(paramJsResult)).setOnCancelListener(new zzbgt(paramJsResult)).create().show();
    return true;
  }

  public final void onCloseWindow(WebView paramWebView)
  {
    if (!(paramWebView instanceof zzbha))
    {
      zzaxa.zzep("Tried to close a WebView that wasn't an AdWebView.");
      return;
    }
    zzd localzzd = ((zzbha)paramWebView).zzaae();
    if (localzzd == null)
    {
      zzaxa.zzep("Tried to close an AdWebView not associated with an overlay.");
      return;
    }
    localzzd.close();
  }

  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    String str1 = paramConsoleMessage.message();
    String str2 = paramConsoleMessage.sourceId();
    int i = paramConsoleMessage.lineNumber();
    String str3 = 19 + String.valueOf(str1).length() + String.valueOf(str2).length() + "JS: " + str1 + " (" + str2 + ":" + i + ")";
    if (str3.contains("Application Cache"))
      return super.onConsoleMessage(paramConsoleMessage);
    switch (zzbgz.zzejc[paramConsoleMessage.messageLevel().ordinal()])
    {
    default:
      zzaxa.zzeo(str3);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      zzaxa.zzen(str3);
      continue;
      zzaxa.zzep(str3);
      continue;
      zzaxa.zzeo(str3);
      continue;
      zzaxa.zzdp(str3);
    }
  }

  public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    WebView.WebViewTransport localWebViewTransport = (WebView.WebViewTransport)paramMessage.obj;
    WebView localWebView = new WebView(paramWebView.getContext());
    if (this.zzdbu.zzaaj() != null)
      localWebView.setWebViewClient(this.zzdbu.zzaaj());
    localWebViewTransport.setWebView(localWebView);
    paramMessage.sendToTarget();
    return true;
  }

  public final void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    long l = 5242880L - paramLong3;
    if (l <= 0L)
    {
      paramQuotaUpdater.updateQuota(paramLong1);
      return;
    }
    if (paramLong1 == 0L)
    {
      if ((paramLong2 <= l) && (paramLong2 <= 1048576L));
      while (true)
      {
        paramQuotaUpdater.updateQuota(paramLong2);
        return;
        paramLong2 = 0L;
      }
    }
    if (paramLong2 == 0L)
      paramLong1 = Math.min(paramLong1 + Math.min(131072L, l), 1048576L);
    while (true)
    {
      paramLong2 = paramLong1;
      break;
      if (paramLong2 <= Math.min(1048576L - paramLong1, l))
        paramLong1 += paramLong2;
    }
  }

  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    if (paramCallback != null)
    {
      zzk.zzlg();
      if (!zzaxj.zzp(this.zzdbu.getContext(), "android.permission.ACCESS_FINE_LOCATION"))
      {
        zzk.zzlg();
        if (!zzaxj.zzp(this.zzdbu.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))
          break label62;
      }
    }
    label62: for (boolean bool = true; ; bool = false)
    {
      paramCallback.invoke(paramString, bool, true);
      return;
    }
  }

  public final void onHideCustomView()
  {
    zzd localzzd = this.zzdbu.zzaae();
    if (localzzd == null)
    {
      zzaxa.zzep("Could not get ad overlay when hiding custom view.");
      return;
    }
    localzzd.zzte();
  }

  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return zza(zza(paramWebView), "alert", paramString1, paramString2, null, paramJsResult, null, false);
  }

  public final boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return zza(zza(paramWebView), "onBeforeUnload", paramString1, paramString2, null, paramJsResult, null, false);
  }

  public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return zza(zza(paramWebView), "confirm", paramString1, paramString2, null, paramJsResult, null, false);
  }

  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return zza(zza(paramWebView), "prompt", paramString1, paramString2, paramString3, null, paramJsPromptResult, true);
  }

  @TargetApi(21)
  public final void onPermissionRequest(PermissionRequest paramPermissionRequest)
  {
    if (PlatformVersion.isAtLeastLollipop())
    {
      zzaci localzzaci = zzact.zzcom;
      if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue());
    }
    else
    {
      super.onPermissionRequest(paramPermissionRequest);
      return;
    }
    if ((this.zzdbu == null) || (this.zzdbu.zzaai() == null) || (this.zzdbu.zzaai().zzabj() == null))
    {
      super.onPermissionRequest(paramPermissionRequest);
      return;
    }
    String[] arrayOfString = this.zzdbu.zzaai().zzabj().zza(paramPermissionRequest.getResources());
    if (arrayOfString.length > 0)
    {
      paramPermissionRequest.grant(arrayOfString);
      return;
    }
    paramPermissionRequest.deny();
  }

  public final void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    long l1 = 5242880L - paramLong2;
    long l2 = 131072L + paramLong1;
    if (l1 < l2)
    {
      paramQuotaUpdater.updateQuota(0L);
      return;
    }
    paramQuotaUpdater.updateQuota(l2);
  }

  @Deprecated
  public final void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    zzd localzzd = this.zzdbu.zzaae();
    if (localzzd == null)
    {
      zzaxa.zzep("Could not get ad overlay when showing custom view.");
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    localzzd.zza(paramView, paramCustomViewCallback);
    localzzd.setRequestedOrientation(paramInt);
  }

  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    onShowCustomView(paramView, -1, paramCustomViewCallback);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbgs
 * JD-Core Version:    0.6.2
 */