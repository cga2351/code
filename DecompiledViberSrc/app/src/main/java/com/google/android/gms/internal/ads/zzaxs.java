package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings.Global;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.SharedPreferencesUtils;

@TargetApi(17)
public class zzaxs extends zzaxu
{
  public final String getDefaultUserAgent(Context paramContext)
  {
    zzazn localzzazn = zzazn.zzws();
    if (TextUtils.isEmpty(localzzazn.zzdyd))
      if (!ClientLibraryUtils.isPackageSide())
        break label47;
    label47: for (String str = (String)zzazm.zza(paramContext, new zzazo(localzzazn, paramContext)); ; str = (String)zzazm.zza(paramContext, new zzazp(localzzazn, GooglePlayServicesUtilLight.getRemoteContext(paramContext), paramContext)))
    {
      localzzazn.zzdyd = str;
      return localzzazn.zzdyd;
    }
  }

  public final int zza(ContentResolver paramContentResolver)
  {
    return Settings.Global.getInt(paramContentResolver, "wifi_on", 0);
  }

  public final Drawable zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean, float paramFloat)
  {
    if ((!paramBoolean) || (paramFloat <= 0.0F) || (paramFloat > 25.0F))
      return new BitmapDrawable(paramContext.getResources(), paramBitmap);
    try
    {
      Bitmap localBitmap1 = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight(), false);
      Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1);
      RenderScript localRenderScript = RenderScript.create(paramContext);
      ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create(localRenderScript, Element.U8_4(localRenderScript));
      Allocation localAllocation1 = Allocation.createFromBitmap(localRenderScript, localBitmap1);
      Allocation localAllocation2 = Allocation.createFromBitmap(localRenderScript, localBitmap2);
      localScriptIntrinsicBlur.setRadius(paramFloat);
      localScriptIntrinsicBlur.setInput(localAllocation1);
      localScriptIntrinsicBlur.forEach(localAllocation2);
      localAllocation2.copyTo(localBitmap2);
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), localBitmap2);
      return localBitmapDrawable;
    }
    catch (RuntimeException localRuntimeException)
    {
    }
    return new BitmapDrawable(paramContext.getResources(), paramBitmap);
  }

  public final boolean zza(Context paramContext, WebSettings paramWebSettings)
  {
    super.zza(paramContext, paramWebSettings);
    paramWebSettings.setMediaPlaybackRequiresUserGesture(false);
    return true;
  }

  public final void zzay(Context paramContext)
  {
    zzazn localzzazn = zzazn.zzws();
    zzaxa.zzds("Updating user agent.");
    String str1 = WebSettings.getDefaultUserAgent(paramContext);
    SharedPreferences.Editor localEditor;
    if (!str1.equals(localzzazn.zzdyd))
    {
      Context localContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if ((ClientLibraryUtils.isPackageSide()) || (localContext == null))
      {
        String str2 = WebSettings.getDefaultUserAgent(paramContext);
        localEditor = paramContext.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", str2);
        if (localContext != null)
          break label94;
        localEditor.apply();
      }
    }
    while (true)
    {
      localzzazn.zzdyd = str1;
      zzaxa.zzds("User agent is updated.");
      return;
      label94: SharedPreferencesUtils.publishWorldReadableSharedPreferences(paramContext, localEditor, "admob_user_agent");
    }
  }

  public final int zzb(ContentResolver paramContentResolver)
  {
    return Settings.Global.getInt(paramContentResolver, "airplane_mode_on", 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaxs
 * JD-Core Version:    0.6.2
 */