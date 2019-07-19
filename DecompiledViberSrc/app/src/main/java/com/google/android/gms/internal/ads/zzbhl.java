package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.impl.R.string;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@zzare
public final class zzbhl extends FrameLayout
  implements zzbha
{
  private final zzbha zzekl;
  private final zzbcx zzekm;
  private final AtomicBoolean zzekn = new AtomicBoolean();

  public zzbhl(zzbha paramzzbha)
  {
    super(paramzzbha.getContext());
    this.zzekl = paramzzbha;
    this.zzekm = new zzbcx(paramzzbha.zzaad(), this, this);
    addView(this.zzekl.getView());
  }

  public final void destroy()
  {
    IObjectWrapper localIObjectWrapper = zzaam();
    if (localIObjectWrapper != null)
    {
      zzk.zzlv().zzab(localIObjectWrapper);
      Handler localHandler = zzaxj.zzdvx;
      zzbhm localzzbhm = new zzbhm(this);
      zzaci localzzaci = zzact.zzcuw;
      localHandler.postDelayed(localzzbhm, ((Integer)zzyr.zzpe().zzd(localzzaci)).intValue());
      return;
    }
    this.zzekl.destroy();
  }

  public final View getView()
  {
    return this;
  }

  public final WebView getWebView()
  {
    return this.zzekl.getWebView();
  }

  public final boolean isDestroyed()
  {
    return this.zzekl.isDestroyed();
  }

  public final void loadData(String paramString1, String paramString2, String paramString3)
  {
    this.zzekl.loadData(paramString1, paramString2, paramString3);
  }

  public final void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.zzekl.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }

  public final void loadUrl(String paramString)
  {
    this.zzekl.loadUrl(paramString);
  }

  public final void onPause()
  {
    this.zzekm.onPause();
    this.zzekl.onPause();
  }

  public final void onResume()
  {
    this.zzekl.onResume();
  }

  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.zzekl.setOnClickListener(paramOnClickListener);
  }

  public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.zzekl.setOnTouchListener(paramOnTouchListener);
  }

  public final void setRequestedOrientation(int paramInt)
  {
    this.zzekl.setRequestedOrientation(paramInt);
  }

  public final void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    this.zzekl.setWebChromeClient(paramWebChromeClient);
  }

  public final void setWebViewClient(WebViewClient paramWebViewClient)
  {
    this.zzekl.setWebViewClient(paramWebViewClient);
  }

  public final void zza(zzc paramzzc)
  {
    this.zzekl.zza(paramzzc);
  }

  public final void zza(zzd paramzzd)
  {
    this.zzekl.zza(paramzzd);
  }

  public final void zza(zzadu paramzzadu)
  {
    this.zzekl.zza(paramzzadu);
  }

  public final void zza(zzadw paramzzadw)
  {
    this.zzekl.zza(paramzzadw);
  }

  public final void zza(zzbhr paramzzbhr)
  {
    this.zzekl.zza(paramzzbhr);
  }

  public final void zza(zzbio paramzzbio)
  {
    this.zzekl.zza(paramzzbio);
  }

  public final void zza(zzub paramzzub)
  {
    this.zzekl.zza(paramzzub);
  }

  public final void zza(String paramString, Predicate<zzahn<? super zzbha>> paramPredicate)
  {
    this.zzekl.zza(paramString, paramPredicate);
  }

  public final void zza(String paramString, zzahn<? super zzbha> paramzzahn)
  {
    this.zzekl.zza(paramString, paramzzahn);
  }

  public final void zza(String paramString, zzbfu paramzzbfu)
  {
    this.zzekl.zza(paramString, paramzzbfu);
  }

  public final void zza(String paramString, Map<String, ?> paramMap)
  {
    this.zzekl.zza(paramString, paramMap);
  }

  public final void zza(String paramString, JSONObject paramJSONObject)
  {
    this.zzekl.zza(paramString, paramJSONObject);
  }

  public final void zza(boolean paramBoolean, int paramInt, String paramString)
  {
    this.zzekl.zza(paramBoolean, paramInt, paramString);
  }

  public final void zza(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this.zzekl.zza(paramBoolean, paramInt, paramString1, paramString2);
  }

  public final void zza(boolean paramBoolean, long paramLong)
  {
    this.zzekl.zza(paramBoolean, paramLong);
  }

  public final void zzaab()
  {
    this.zzekl.zzaab();
  }

  public final void zzaac()
  {
    this.zzekl.zzaac();
  }

  public final Context zzaad()
  {
    return this.zzekl.zzaad();
  }

  public final zzd zzaae()
  {
    return this.zzekl.zzaae();
  }

  public final zzd zzaaf()
  {
    return this.zzekl.zzaaf();
  }

  public final zzbio zzaag()
  {
    return this.zzekl.zzaag();
  }

  public final String zzaah()
  {
    return this.zzekl.zzaah();
  }

  public final zzbij zzaai()
  {
    return this.zzekl.zzaai();
  }

  public final WebViewClient zzaaj()
  {
    return this.zzekl.zzaaj();
  }

  public final boolean zzaak()
  {
    return this.zzekl.zzaak();
  }

  public final zzdh zzaal()
  {
    return this.zzekl.zzaal();
  }

  public final IObjectWrapper zzaam()
  {
    return this.zzekl.zzaam();
  }

  public final boolean zzaan()
  {
    return this.zzekl.zzaan();
  }

  public final void zzaao()
  {
    this.zzekm.onDestroy();
    this.zzekl.zzaao();
  }

  public final boolean zzaap()
  {
    return this.zzekl.zzaap();
  }

  public final boolean zzaaq()
  {
    return this.zzekl.zzaaq();
  }

  public final void zzaar()
  {
    this.zzekl.zzaar();
  }

  public final void zzaas()
  {
    this.zzekl.zzaas();
  }

  public final zzadw zzaat()
  {
    return this.zzekl.zzaat();
  }

  public final void zzaau()
  {
    setBackgroundColor(0);
    this.zzekl.setBackgroundColor(0);
  }

  public final void zzaav()
  {
    TextView localTextView = new TextView(getContext());
    Resources localResources = zzk.zzlk().getResources();
    String str;
    GradientDrawable localGradientDrawable;
    if (localResources != null)
    {
      str = localResources.getString(R.string.s7);
      localTextView.setText(str);
      localTextView.setTextSize(15.0F);
      localTextView.setTextColor(-1);
      localTextView.setPadding(5, 0, 5, 0);
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      localGradientDrawable.setColor(-12303292);
      localGradientDrawable.setCornerRadius(8.0F);
      if (Build.VERSION.SDK_INT < 16)
        break label132;
      localTextView.setBackground(localGradientDrawable);
    }
    while (true)
    {
      addView(localTextView, new FrameLayout.LayoutParams(-2, -2, 49));
      bringChildToFront(localTextView);
      return;
      str = "Test Ad";
      break;
      label132: localTextView.setBackgroundDrawable(localGradientDrawable);
    }
  }

  public final boolean zzaaw()
  {
    return this.zzekn.get();
  }

  public final void zzaf(boolean paramBoolean)
  {
    this.zzekl.zzaf(paramBoolean);
  }

  public final void zzam(IObjectWrapper paramIObjectWrapper)
  {
    this.zzekl.zzam(paramIObjectWrapper);
  }

  public final void zzao(boolean paramBoolean)
  {
    this.zzekl.zzao(paramBoolean);
  }

  public final void zzaq(boolean paramBoolean)
  {
    this.zzekl.zzaq(paramBoolean);
  }

  public final void zzar(boolean paramBoolean)
  {
    this.zzekl.zzar(paramBoolean);
  }

  public final void zzas(boolean paramBoolean)
  {
    this.zzekl.zzas(paramBoolean);
  }

  public final void zzat(boolean paramBoolean)
  {
    this.zzekl.zzat(paramBoolean);
  }

  public final void zzb(zzd paramzzd)
  {
    this.zzekl.zzb(paramzzd);
  }

  public final void zzb(String paramString, zzahn<? super zzbha> paramzzahn)
  {
    this.zzekl.zzb(paramString, paramzzahn);
  }

  public final void zzb(String paramString1, String paramString2, String paramString3)
  {
    this.zzekl.zzb(paramString1, paramString2, paramString3);
  }

  public final void zzb(String paramString, JSONObject paramJSONObject)
  {
    this.zzekl.zzb(paramString, paramJSONObject);
  }

  public final boolean zzb(boolean paramBoolean, int paramInt)
  {
    if (!this.zzekn.compareAndSet(false, true))
      return true;
    zzaci localzzaci = zzact.zzcop;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      return false;
    removeView(this.zzekl.getView());
    return this.zzekl.zzb(paramBoolean, paramInt);
  }

  public final void zzbn(Context paramContext)
  {
    this.zzekl.zzbn(paramContext);
  }

  public final void zzc(boolean paramBoolean, int paramInt)
  {
    this.zzekl.zzc(paramBoolean, paramInt);
  }

  public final void zzco(String paramString)
  {
    this.zzekl.zzco(paramString);
  }

  public final void zzdi(int paramInt)
  {
    this.zzekl.zzdi(paramInt);
  }

  public final zzbfu zzet(String paramString)
  {
    return this.zzekl.zzet(paramString);
  }

  public final void zzlc()
  {
    this.zzekl.zzlc();
  }

  public final void zzld()
  {
    this.zzekl.zzld();
  }

  public final void zztl()
  {
    this.zzekl.zztl();
  }

  public final void zztm()
  {
    this.zzekl.zztm();
  }

  public final zzbcx zzya()
  {
    return this.zzekm;
  }

  public final zzbhr zzyb()
  {
    return this.zzekl.zzyb();
  }

  public final zzadf zzyc()
  {
    return this.zzekl.zzyc();
  }

  public final Activity zzyd()
  {
    return this.zzekl.zzyd();
  }

  public final zza zzye()
  {
    return this.zzekl.zzye();
  }

  public final String zzyf()
  {
    return this.zzekl.zzyf();
  }

  public final zzadg zzyg()
  {
    return this.zzekl.zzyg();
  }

  public final zzbaj zzyh()
  {
    return this.zzekl.zzyh();
  }

  public final int zzyi()
  {
    return getMeasuredHeight();
  }

  public final int zzyj()
  {
    return getMeasuredWidth();
  }

  public final void zzyk()
  {
    this.zzekl.zzyk();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbhl
 * JD-Core Version:    0.6.2
 */