package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
@VisibleForTesting
public abstract interface zzbha extends zzj, zzajj, zzakh, zzbdg, zzbhy, zzbhz, zzbid, zzbig, zzbih, zzbii, zzuc
{
  public abstract void destroy();

  public abstract Context getContext();

  public abstract int getHeight();

  public abstract ViewGroup.LayoutParams getLayoutParams();

  public abstract void getLocationOnScreen(int[] paramArrayOfInt);

  public abstract ViewParent getParent();

  public abstract View getView();

  public abstract WebView getWebView();

  public abstract int getWidth();

  public abstract boolean isDestroyed();

  public abstract void loadData(String paramString1, String paramString2, String paramString3);

  public abstract void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);

  public abstract void loadUrl(String paramString);

  public abstract void measure(int paramInt1, int paramInt2);

  public abstract void onPause();

  public abstract void onResume();

  public abstract void setBackgroundColor(int paramInt);

  public abstract void setOnClickListener(View.OnClickListener paramOnClickListener);

  public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);

  public abstract void setRequestedOrientation(int paramInt);

  public abstract void setWebChromeClient(WebChromeClient paramWebChromeClient);

  public abstract void setWebViewClient(WebViewClient paramWebViewClient);

  public abstract void zza(zzd paramzzd);

  public abstract void zza(zzadu paramzzadu);

  public abstract void zza(zzadw paramzzadw);

  public abstract void zza(zzbhr paramzzbhr);

  public abstract void zza(zzbio paramzzbio);

  public abstract void zza(String paramString, Predicate<zzahn<? super zzbha>> paramPredicate);

  public abstract void zza(String paramString, zzahn<? super zzbha> paramzzahn);

  public abstract void zza(String paramString, zzbfu paramzzbfu);

  public abstract void zzaab();

  public abstract void zzaac();

  public abstract Context zzaad();

  public abstract zzd zzaae();

  public abstract zzd zzaaf();

  public abstract zzbio zzaag();

  public abstract String zzaah();

  public abstract zzbij zzaai();

  public abstract WebViewClient zzaaj();

  public abstract boolean zzaak();

  public abstract zzdh zzaal();

  public abstract IObjectWrapper zzaam();

  public abstract boolean zzaan();

  public abstract void zzaao();

  public abstract boolean zzaap();

  public abstract boolean zzaaq();

  public abstract void zzaar();

  public abstract void zzaas();

  public abstract zzadw zzaat();

  public abstract void zzaau();

  public abstract void zzaav();

  public abstract boolean zzaaw();

  public abstract void zzaf(boolean paramBoolean);

  public abstract void zzam(IObjectWrapper paramIObjectWrapper);

  public abstract void zzaq(boolean paramBoolean);

  public abstract void zzar(boolean paramBoolean);

  public abstract void zzas(boolean paramBoolean);

  public abstract void zzat(boolean paramBoolean);

  public abstract void zzb(zzd paramzzd);

  public abstract void zzb(String paramString, zzahn<? super zzbha> paramzzahn);

  public abstract void zzb(String paramString1, String paramString2, String paramString3);

  public abstract boolean zzb(boolean paramBoolean, int paramInt);

  public abstract void zzbn(Context paramContext);

  public abstract void zzdi(int paramInt);

  public abstract void zztl();

  public abstract zzbhr zzyb();

  public abstract Activity zzyd();

  public abstract zza zzye();

  public abstract zzadg zzyg();

  public abstract zzbaj zzyh();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbha
 * JD-Core Version:    0.6.2
 */