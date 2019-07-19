package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.Map;

@zzare
@TargetApi(14)
public class zzaxp
{
  public static boolean zza(zzbha paramzzbha)
  {
    if (paramzzbha == null)
      return false;
    paramzzbha.onPause();
    return true;
  }

  public static boolean zzb(zzbha paramzzbha)
  {
    if (paramzzbha == null)
      return false;
    paramzzbha.onResume();
    return true;
  }

  public static zzaxp zzcv(int paramInt)
  {
    if (paramInt >= 28)
      return new zzaxz();
    if (paramInt >= 26)
      return new zzaxy();
    if (paramInt >= 24)
      return new zzaxx();
    if (paramInt >= 21)
      return new zzaxw();
    if (paramInt >= 19)
      return new zzaxv();
    if (paramInt >= 18)
      return new zzaxt();
    if (paramInt >= 17)
      return new zzaxs();
    if (paramInt >= 16)
      return new zzaxu();
    return new zzaxp();
  }

  public static boolean zzwh()
  {
    int i = Process.myUid();
    return (i == 0) || (i == 1000);
  }

  public String getDefaultUserAgent(Context paramContext)
  {
    return "";
  }

  public boolean isAttachedToWindow(View paramView)
  {
    return (paramView.getWindowToken() != null) || (paramView.getWindowVisibility() != 8);
  }

  public void setBackground(View paramView, Drawable paramDrawable)
  {
    paramView.setBackgroundDrawable(paramDrawable);
  }

  public int zza(ContentResolver paramContentResolver)
  {
    return Settings.System.getInt(paramContentResolver, "wifi_on", 0);
  }

  public Drawable zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    return new BitmapDrawable(paramContext.getResources(), paramBitmap);
  }

  public WebResourceResponse zza(String paramString1, String paramString2, int paramInt, String paramString3, Map<String, String> paramMap, InputStream paramInputStream)
  {
    return new WebResourceResponse(paramString1, paramString2, paramInputStream);
  }

  public zzbhb zza(zzbha paramzzbha, zzwh paramzzwh, boolean paramBoolean)
  {
    return new zzbia(paramzzbha, paramzzwh, paramBoolean);
  }

  public zzwv zza(Context paramContext, TelephonyManager paramTelephonyManager)
  {
    return zzwv.zzcal;
  }

  public void zza(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    paramViewTreeObserver.removeGlobalOnLayoutListener(paramOnGlobalLayoutListener);
  }

  public boolean zza(Activity paramActivity, Configuration paramConfiguration)
  {
    return false;
  }

  public boolean zza(Context paramContext, WebSettings paramWebSettings)
  {
    return ((Boolean)zzazm.zza(paramContext, new zzaxq(paramContext, paramWebSettings))).booleanValue();
  }

  public void zzay(Context paramContext)
  {
  }

  public CookieManager zzaz(Context paramContext)
  {
    if (zzwh())
      return null;
    try
    {
      CookieSyncManager.createInstance(paramContext);
      CookieManager localCookieManager = CookieManager.getInstance();
      return localCookieManager;
    }
    catch (Throwable localThrowable)
    {
      zzaxa.zzc("Failed to obtain CookieManager.", localThrowable);
      zzk.zzlk().zza(localThrowable, "ApiLevelUtil.getCookieManager");
    }
    return null;
  }

  public int zzb(ContentResolver paramContentResolver)
  {
    return Settings.System.getInt(paramContentResolver, "airplane_mode_on", 0);
  }

  public void zzg(Activity paramActivity)
  {
  }

  public int zzwf()
  {
    return 5;
  }

  public ViewGroup.LayoutParams zzwg()
  {
    return new ViewGroup.LayoutParams(-2, -2);
  }

  public int zzwi()
  {
    return 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxp
 * JD-Core Version:    0.6.2
 */