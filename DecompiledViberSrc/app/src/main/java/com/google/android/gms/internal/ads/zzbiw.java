package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@zzare
@ParametersAreNonnullByDefault
@VisibleForTesting
final class zzbiw extends zzbjc
  implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzajr, zzbha
{
  private int maxHeight = -1;
  private int maxWidth = -1;

  @GuardedBy("this")
  private String zzaap;
  private final zzbaj zzbtd;
  private final WindowManager zzbtg;

  @GuardedBy("this")
  private boolean zzdkq;
  private int zzdlv = -1;
  private int zzdlw = -1;

  @GuardedBy("this")
  private String zzdlz = "";
  private zzadf zzeeo;
  private final zzwh zzejf;
  private final zzbin zzekp;
  private final zzdh zzekq;
  private final zzj zzekr;
  private final zza zzeks;

  @GuardedBy("this")
  private zzd zzekx;

  @GuardedBy("this")
  private zzbio zzekz;

  @GuardedBy("this")
  private boolean zzelb;

  @GuardedBy("this")
  private boolean zzelc;

  @GuardedBy("this")
  private int zzeld;

  @GuardedBy("this")
  private boolean zzele = true;

  @GuardedBy("this")
  private boolean zzelf = false;

  @GuardedBy("this")
  private zzbhr zzelg;

  @GuardedBy("this")
  private boolean zzelh;

  @GuardedBy("this")
  private boolean zzeli;

  @GuardedBy("this")
  private zzadw zzelj;

  @GuardedBy("this")
  private zzadu zzelk;

  @GuardedBy("this")
  private int zzell;

  @GuardedBy("this")
  private int zzelm;
  private zzadf zzeln;
  private zzadf zzelo;
  private zzadg zzelp;
  private WeakReference<View.OnClickListener> zzelq;

  @GuardedBy("this")
  private zzd zzelr;
  private zzazt zzelt;
  private Map<String, zzbfu> zzelu;
  private final zzbip zzemp;
  private final AtomicReference<IObjectWrapper> zzemq = new AtomicReference();
  private final DisplayMetrics zzwb;

  @VisibleForTesting
  protected zzbiw(zzbin paramzzbin, zzbip paramzzbip, zzbio paramzzbio, String paramString, boolean paramBoolean1, boolean paramBoolean2, zzdh paramzzdh, zzbaj paramzzbaj, zzadh paramzzadh, zzj paramzzj, zza paramzza, zzwh paramzzwh)
  {
    super(paramzzbin, paramzzbip);
    this.zzekp = paramzzbin;
    this.zzemp = paramzzbip;
    this.zzekz = paramzzbio;
    this.zzaap = paramString;
    this.zzelb = paramBoolean1;
    this.zzeld = -1;
    this.zzekq = paramzzdh;
    this.zzbtd = paramzzbaj;
    this.zzekr = paramzzj;
    this.zzeks = paramzza;
    this.zzbtg = ((WindowManager)getContext().getSystemService("window"));
    zzk.zzlg();
    this.zzwb = zzaxj.zza(this.zzbtg);
    this.zzejf = paramzzwh;
    this.zzelt = new zzazt(this.zzekp.zzyd(), this, this, null);
    zzk.zzlg().zza(paramzzbin, paramzzbaj.zzbsy, getSettings());
    setDownloadListener(this);
    zzabn();
    if (PlatformVersion.isAtLeastJellyBeanMR1())
      addJavascriptInterface(zzbhu.zzc(this), "googleAdsJsInterface");
    zzabr();
    this.zzelp = new zzadg(new zzadh(true, "make_wv", this.zzaap));
    this.zzelp.zzqw().zzc(paramzzadh);
    this.zzeeo = zzada.zzb(this.zzelp.zzqw());
    this.zzelp.zza("native:view_create", this.zzeeo);
    this.zzelo = null;
    this.zzeln = null;
    zzk.zzli().zzay(paramzzbin);
  }

  private final boolean zzabk()
  {
    if ((!((zzbip)this.zzemp).zzaay()) && (!((zzbip)this.zzemp).zzaaz()))
      return false;
    zzyr.zzpa();
    int i = zzazu.zzb(this.zzwb, this.zzwb.widthPixels);
    zzyr.zzpa();
    int j = zzazu.zzb(this.zzwb, this.zzwb.heightPixels);
    Activity localActivity = this.zzekp.zzyd();
    int k;
    int m;
    if ((localActivity == null) || (localActivity.getWindow() == null))
    {
      k = j;
      m = i;
      label96: if ((this.zzdlv == i) && (this.zzdlw == j) && (this.maxWidth == m) && (this.maxHeight == k))
        break label260;
      if ((this.zzdlv == i) && (this.zzdlw == j))
        break label262;
    }
    label260: label262: for (boolean bool = true; ; bool = false)
    {
      this.zzdlv = i;
      this.zzdlw = j;
      this.maxWidth = m;
      this.maxHeight = k;
      new zzaqc(this).zza(i, j, m, k, this.zzwb.density, this.zzbtg.getDefaultDisplay().getRotation());
      return bool;
      zzk.zzlg();
      int[] arrayOfInt = zzaxj.zzd(localActivity);
      zzyr.zzpa();
      m = zzazu.zzb(this.zzwb, arrayOfInt[0]);
      zzyr.zzpa();
      k = zzazu.zzb(this.zzwb, arrayOfInt[1]);
      break label96;
      break;
    }
  }

  private final void zzabm()
  {
    zzada.zza(this.zzelp.zzqw(), this.zzeeo, new String[] { "aeh2" });
  }

  private final void zzabn()
  {
    while (true)
    {
      try
      {
        if ((this.zzelb) || (this.zzekz.zzabx()))
        {
          zzaxa.zzdp("Enabling hardware acceleration on an overlay.");
          zzabp();
          return;
        }
        if (Build.VERSION.SDK_INT < 18)
        {
          zzaxa.zzdp("Disabling hardware acceleration on an AdView.");
          zzabo();
          continue;
        }
      }
      finally
      {
      }
      zzaxa.zzdp("Enabling hardware acceleration on an AdView.");
      zzabp();
    }
  }

  private final void zzabo()
  {
    try
    {
      if (!this.zzelc)
      {
        zzk.zzli();
        setLayerType(1, null);
      }
      this.zzelc = true;
      return;
    }
    finally
    {
    }
  }

  private final void zzabp()
  {
    try
    {
      if (this.zzelc)
      {
        zzk.zzli();
        setLayerType(0, null);
      }
      this.zzelc = false;
      return;
    }
    finally
    {
    }
  }

  private final void zzabq()
  {
    try
    {
      if (this.zzelu != null)
      {
        Iterator localIterator = this.zzelu.values().iterator();
        while (localIterator.hasNext())
          ((zzbfu)localIterator.next()).release();
      }
    }
    finally
    {
    }
    this.zzelu = null;
  }

  private final void zzabr()
  {
    if (this.zzelp == null);
    zzadh localzzadh;
    do
    {
      return;
      localzzadh = this.zzelp.zzqw();
    }
    while ((localzzadh == null) || (zzk.zzlk().zzuw() == null));
    zzk.zzlk().zzuw().zza(localzzadh);
  }

  private final void zzav(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean);
    for (String str = "1"; ; str = "0")
    {
      localHashMap.put("isVisible", str);
      zzajs.zza(this, "onAdVisibilityChanged", localHashMap);
      return;
    }
  }

  public final View getView()
  {
    return this;
  }

  public final WebView getWebView()
  {
    return this;
  }

  protected final void onAttachedToWindow()
  {
    while (true)
    {
      boolean bool1;
      try
      {
        super.onAttachedToWindow();
        if (!isDestroyed())
          this.zzelt.onAttachedToWindow();
        bool1 = this.zzelh;
        if (((zzbip)this.zzemp != null) && (((zzbip)this.zzemp).zzaaz()))
        {
          if (!this.zzeli)
          {
            ((zzbip)this.zzemp).zzaba();
            ((zzbip)this.zzemp).zzabb();
            this.zzeli = true;
          }
          zzabk();
          bool2 = true;
          zzav(bool2);
          return;
        }
      }
      finally
      {
      }
      boolean bool2 = bool1;
    }
  }

  protected final void onDetachedFromWindow()
  {
    try
    {
      if (!isDestroyed())
        this.zzelt.onDetachedFromWindow();
      super.onDetachedFromWindow();
      if ((this.zzeli) && ((zzbip)this.zzemp != null) && (((zzbip)this.zzemp).zzaaz()) && (getViewTreeObserver() != null) && (getViewTreeObserver().isAlive()))
      {
        ((zzbip)this.zzemp).zzaba();
        ((zzbip)this.zzemp).zzabb();
        this.zzeli = false;
      }
      zzav(false);
      return;
    }
    finally
    {
    }
  }

  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.parse(paramString1), paramString4);
      zzk.zzlg();
      zzaxj.zza(getContext(), localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      zzaxa.zzdp(51 + String.valueOf(paramString1).length() + String.valueOf(paramString4).length() + "Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
    }
  }

  @TargetApi(21)
  protected final void onDraw(Canvas paramCanvas)
  {
    if ((Build.VERSION.SDK_INT == 21) && (paramCanvas.isHardwareAccelerated()) && (!isAttachedToWindow()))
      return;
    super.onDraw(paramCanvas);
  }

  public final boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getAxisValue(9);
    float f2 = paramMotionEvent.getAxisValue(10);
    if ((paramMotionEvent.getActionMasked() == 8) && (((f1 > 0.0F) && (!canScrollVertically(-1))) || ((f1 < 0.0F) && (!canScrollVertically(1))) || ((f2 > 0.0F) && (!canScrollHorizontally(-1))) || ((f2 < 0.0F) && (!canScrollHorizontally(1)))))
      return false;
    return super.onGenericMotionEvent(paramMotionEvent);
  }

  public final void onGlobalLayout()
  {
    boolean bool = zzabk();
    zzd localzzd = zzaae();
    if ((localzzd != null) && (bool))
      localzzd.zztk();
  }

  @SuppressLint({"DrawAllocation"})
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    float f;
    while (true)
    {
      try
      {
        if (isDestroyed())
        {
          setMeasuredDimension(0, 0);
          return;
        }
        if ((isInEditMode()) || (this.zzelb) || (this.zzekz.zzaby()))
        {
          super.onMeasure(paramInt1, paramInt2);
          continue;
        }
      }
      finally
      {
      }
      if (this.zzekz.zzaca())
      {
        super.onMeasure(paramInt1, paramInt2);
      }
      else if (this.zzekz.zzabz())
      {
        zzaci localzzaci3 = zzact.zzcsl;
        if (((Boolean)zzyr.zzpe().zzd(localzzaci3)).booleanValue())
        {
          super.onMeasure(paramInt1, paramInt2);
        }
        else
        {
          zzbhr localzzbhr = zzyb();
          if (localzzbhr == null)
            break label785;
          f = localzzbhr.getAspectRatio();
          if (f == 0.0F)
          {
            super.onMeasure(paramInt1, paramInt2);
          }
          else
          {
            int i10 = View.MeasureSpec.getSize(paramInt1);
            int i11 = View.MeasureSpec.getSize(paramInt2);
            int i12 = (int)(f * i11);
            int i13 = (int)(i10 / f);
            if ((i11 == 0) && (i13 != 0))
            {
              i12 = (int)(f * i13);
              i11 = i13;
            }
            while (true)
            {
              setMeasuredDimension(Math.min(i12, i10), Math.min(i13, i11));
              break;
              if ((i10 == 0) && (i12 != 0))
              {
                i13 = (int)(i12 / f);
                i10 = i12;
              }
            }
          }
        }
      }
      else if (this.zzekz.isFluid())
      {
        zzaci localzzaci2 = zzact.zzcso;
        if ((((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue()) || (!PlatformVersion.isAtLeastJellyBeanMR1()))
        {
          super.onMeasure(paramInt1, paramInt2);
        }
        else
        {
          zza("/contentHeight", new zzbiy(this));
          zzco("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
          int i8 = View.MeasureSpec.getSize(paramInt1);
          switch (this.zzelm)
          {
          default:
          case -1:
          }
          for (int i9 = (int)(this.zzelm * this.zzwb.density); ; i9 = View.MeasureSpec.getSize(paramInt2))
          {
            setMeasuredDimension(i8, i9);
            break;
          }
        }
      }
      else
      {
        if (!this.zzekz.zzabx())
          break;
        setMeasuredDimension(this.zzwb.widthPixels, this.zzwb.heightPixels);
      }
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    label458: int n;
    int i1;
    label485: int i3;
    if (i != -2147483648)
      if (i == 1073741824)
      {
        break label791;
        if (this.zzekz.widthPixels > n)
          break label818;
        if (this.zzekz.heightPixels <= i1)
          break label832;
        break label818;
        zzaci localzzaci1 = zzact.zzcvh;
        if (!((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
          break label851;
        if ((this.zzekz.widthPixels / this.zzwb.density > n / this.zzwb.density) || (this.zzekz.heightPixels / this.zzwb.density > i1 / this.zzwb.density))
          break label838;
        i3 = 1;
        break label824;
      }
    while (true)
    {
      label575: if (i3 != 0)
      {
        int i4 = (int)(this.zzekz.widthPixels / this.zzwb.density);
        int i5 = (int)(this.zzekz.heightPixels / this.zzwb.density);
        int i6 = (int)(j / this.zzwb.density);
        int i7 = (int)(m / this.zzwb.density);
        zzaxa.zzep(103 + "Not enough space to show ad. Needs " + i4 + "x" + i5 + " dp, but only has " + i6 + "x" + i7 + " dp.");
        if (getVisibility() != 8)
          setVisibility(4);
        setMeasuredDimension(0, 0);
        break;
      }
      if (getVisibility() != 8)
        setVisibility(0);
      setMeasuredDimension(this.zzekz.widthPixels, this.zzekz.heightPixels);
      break;
      label785: label791: 
      do
      {
        i1 = 2147483647;
        break label458;
        n = 2147483647;
        continue;
        f = 0.0F;
        break;
        n = j;
      }
      while ((k != -2147483648) && (k != 1073741824));
      i1 = m;
      break label458;
      label818: int i2 = 1;
      break label485;
      while (true)
      {
        label824: if (i2 == 0)
          break label844;
        break label575;
        label832: i2 = 0;
        break;
        label838: i3 = 0;
      }
      label844: i3 = i2;
      continue;
      label851: i3 = i2;
    }
  }

  public final void onPause()
  {
    try
    {
      super.onPause();
      return;
    }
    catch (Exception localException)
    {
      zzaxa.zzc("Could not pause webview.", localException);
    }
  }

  public final void onResume()
  {
    try
    {
      super.onResume();
      return;
    }
    catch (Exception localException)
    {
      zzaxa.zzc("Could not resume webview.", localException);
    }
  }

  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((zzbip)this.zzemp).zzaaz());
    while (true)
    {
      try
      {
        if (this.zzelj != null)
          this.zzelj.zzc(paramMotionEvent);
        return super.onTouchEvent(paramMotionEvent);
      }
      finally
      {
      }
      if (this.zzekq != null)
        this.zzekq.zza(paramMotionEvent);
    }
  }

  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.zzelq = new WeakReference(paramOnClickListener);
    super.setOnClickListener(paramOnClickListener);
  }

  public final void setRequestedOrientation(int paramInt)
  {
    try
    {
      this.zzeld = paramInt;
      if (this.zzekx != null)
        this.zzekx.setRequestedOrientation(this.zzeld);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void stopLoading()
  {
    try
    {
      super.stopLoading();
      return;
    }
    catch (Exception localException)
    {
      zzaxa.zzc("Could not stop loading webview.", localException);
    }
  }

  public final void zza(zzc paramzzc)
  {
    this.zzemp.zza(paramzzc);
  }

  public final void zza(zzd paramzzd)
  {
    try
    {
      this.zzekx = paramzzd;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzadu paramzzadu)
  {
    try
    {
      this.zzelk = paramzzadu;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzadw paramzzadw)
  {
    try
    {
      this.zzelj = paramzzadw;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzbhr paramzzbhr)
  {
    try
    {
      if (this.zzelg != null)
        zzaxa.zzen("Attempt to create multiple AdWebViewVideoControllers.");
      while (true)
      {
        return;
        this.zzelg = paramzzbhr;
      }
    }
    finally
    {
    }
  }

  public final void zza(zzbio paramzzbio)
  {
    try
    {
      this.zzekz = paramzzbio;
      requestLayout();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzub paramzzub)
  {
    try
    {
      this.zzelh = paramzzub.zzbtl;
      zzav(paramzzub.zzbtl);
      return;
    }
    finally
    {
    }
  }

  public final void zza(String paramString, Predicate<zzahn<? super zzbha>> paramPredicate)
  {
    if (this.zzemp != null)
      this.zzemp.zza(paramString, paramPredicate);
  }

  public final void zza(String paramString, zzahn<? super zzbha> paramzzahn)
  {
    if (this.zzemp != null)
      this.zzemp.zza(paramString, paramzzahn);
  }

  public final void zza(String paramString, zzbfu paramzzbfu)
  {
    try
    {
      if (this.zzelu == null)
        this.zzelu = new HashMap();
      this.zzelu.put(paramString, paramzzbfu);
      return;
    }
    finally
    {
    }
  }

  public final void zza(String paramString, Map paramMap)
  {
    zzajs.zza(this, paramString, paramMap);
  }

  public final void zza(String paramString, JSONObject paramJSONObject)
  {
    zzajs.zzb(this, paramString, paramJSONObject);
  }

  public final void zza(boolean paramBoolean, int paramInt, String paramString)
  {
    this.zzemp.zza(paramBoolean, paramInt, paramString);
  }

  public final void zza(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this.zzemp.zza(paramBoolean, paramInt, paramString1, paramString2);
  }

  public final void zza(boolean paramBoolean, long paramLong)
  {
    HashMap localHashMap = new HashMap(2);
    if (paramBoolean);
    for (String str = "1"; ; str = "0")
    {
      localHashMap.put("success", str);
      localHashMap.put("duration", Long.toString(paramLong));
      zzajs.zza(this, "onCacheAccessComplete", localHashMap);
      return;
    }
  }

  public final void zzaab()
  {
    zzabm();
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.zzbtd.zzbsy);
    zzajs.zza(this, "onhide", localHashMap);
  }

  public final void zzaac()
  {
    HashMap localHashMap = new HashMap(3);
    localHashMap.put("app_muted", String.valueOf(zzk.zzll().zzpr()));
    localHashMap.put("app_volume", String.valueOf(zzk.zzll().zzpq()));
    localHashMap.put("device_volume", String.valueOf(zzayb.zzba(getContext())));
    zzajs.zza(this, "volume", localHashMap);
  }

  public final Context zzaad()
  {
    return this.zzekp.zzaad();
  }

  public final zzd zzaae()
  {
    try
    {
      zzd localzzd = this.zzekx;
      return localzzd;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final zzd zzaaf()
  {
    try
    {
      zzd localzzd = this.zzelr;
      return localzzd;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final zzbio zzaag()
  {
    try
    {
      zzbio localzzbio = this.zzekz;
      return localzzbio;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String zzaah()
  {
    try
    {
      String str = this.zzaap;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final WebViewClient zzaaj()
  {
    return this.zzemp;
  }

  public final boolean zzaak()
  {
    try
    {
      boolean bool = this.zzdkq;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final zzdh zzaal()
  {
    return this.zzekq;
  }

  public final IObjectWrapper zzaam()
  {
    return (IObjectWrapper)this.zzemq.get();
  }

  public final boolean zzaan()
  {
    try
    {
      boolean bool = this.zzelb;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzaao()
  {
  }

  public final boolean zzaap()
  {
    try
    {
      boolean bool = this.zzele;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final boolean zzaaq()
  {
    try
    {
      int i = this.zzell;
      if (i > 0)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public final void zzaar()
  {
    this.zzelt.zzwt();
  }

  public final void zzaas()
  {
    if (this.zzelo == null)
    {
      this.zzelo = zzada.zzb(this.zzelp.zzqw());
      this.zzelp.zza("native:view_load", this.zzelo);
    }
  }

  public final zzadw zzaat()
  {
    try
    {
      zzadw localzzadw = this.zzelj;
      return localzzadw;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzaau()
  {
    setBackgroundColor(0);
  }

  public final void zzaav()
  {
    zzaxa.zzds("Cannot add text view to inner AdWebView");
  }

  public final boolean zzaaw()
  {
    return false;
  }

  public final void zzaf(boolean paramBoolean)
  {
    try
    {
      if (this.zzekx != null)
        this.zzekx.zza(this.zzemp.zzaay(), paramBoolean);
      while (true)
      {
        return;
        this.zzdkq = paramBoolean;
      }
    }
    finally
    {
    }
  }

  public final void zzam(IObjectWrapper paramIObjectWrapper)
  {
    this.zzemq.set(paramIObjectWrapper);
  }

  public final void zzao(boolean paramBoolean)
  {
    ((zzbip)this.zzemp).zzao(paramBoolean);
  }

  public final void zzaq(boolean paramBoolean)
  {
    try
    {
      int i;
      zzaqc localzzaqc;
      if (paramBoolean != this.zzelb)
      {
        i = 1;
        this.zzelb = paramBoolean;
        zzabn();
        if (i != 0)
        {
          localzzaqc = new zzaqc(this);
          if (!paramBoolean)
            break label59;
        }
      }
      label59: for (String str = "expanded"; ; str = "default")
      {
        localzzaqc.zzdj(str);
        return;
        i = 0;
        break;
      }
    }
    finally
    {
    }
  }

  public final void zzar(boolean paramBoolean)
  {
    try
    {
      this.zzele = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzas(boolean paramBoolean)
  {
    try
    {
      int i = this.zzell;
      if (paramBoolean);
      for (int j = 1; ; j = -1)
      {
        this.zzell = (j + i);
        if ((this.zzell <= 0) && (this.zzekx != null))
          this.zzekx.zztn();
        return;
      }
    }
    finally
    {
    }
  }

  public final void zzat(boolean paramBoolean)
  {
    ((zzbip)this.zzemp).zzat(paramBoolean);
  }

  protected final void zzaw(boolean paramBoolean)
  {
    if (!paramBoolean);
    try
    {
      zzabr();
      this.zzelt.zzwu();
      if (this.zzekx != null)
      {
        this.zzekx.close();
        this.zzekx.onDestroy();
        this.zzekx = null;
      }
      this.zzemq.set(null);
      this.zzemp.destroy();
      zzk.zzmc();
      zzbft.zzc(this);
      zzabq();
      return;
    }
    finally
    {
    }
  }

  public final void zzb(zzd paramzzd)
  {
    try
    {
      this.zzelr = paramzzd;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzb(String paramString, zzahn<? super zzbha> paramzzahn)
  {
    if (this.zzemp != null)
      this.zzemp.zzb(paramString, paramzzahn);
  }

  public final void zzb(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      zzaci localzzaci = zzact.zzcol;
      String[] arrayOfString;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      {
        arrayOfString = new String[1];
        arrayOfString[0] = zzbie.zzabt();
      }
      for (String str = zzbie.zzf(paramString2, arrayOfString); ; str = paramString2)
      {
        super.loadDataWithBaseURL(paramString1, str, "text/html", "UTF-8", paramString3);
        return;
      }
    }
    finally
    {
    }
  }

  public final void zzb(String paramString, JSONObject paramJSONObject)
  {
    zzajs.zza(this, paramString, paramJSONObject);
  }

  public final boolean zzb(boolean paramBoolean, int paramInt)
  {
    destroy();
    this.zzejf.zza(new zzbix(paramBoolean, paramInt));
    this.zzejf.zza(zzwj.zza.zzb.zzbyz);
    return true;
  }

  public final void zzbn(Context paramContext)
  {
    this.zzekp.setBaseContext(paramContext);
    this.zzelt.zzh(this.zzekp.zzyd());
  }

  public final void zzc(boolean paramBoolean, int paramInt)
  {
    this.zzemp.zzc(paramBoolean, paramInt);
  }

  public final void zzco(String paramString)
  {
    try
    {
      if (!isDestroyed())
        super.zzco(paramString);
      while (true)
      {
        return;
        zzaxa.zzep("The webview is destroyed. Ignoring action.");
      }
    }
    finally
    {
    }
  }

  public final void zzdi(int paramInt)
  {
    if (paramInt == 0)
      zzada.zza(this.zzelp.zzqw(), this.zzeeo, new String[] { "aebb2" });
    zzabm();
    if (this.zzelp.zzqw() != null)
      this.zzelp.zzqw().zzh("close_type", String.valueOf(paramInt));
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("closetype", String.valueOf(paramInt));
    localHashMap.put("version", this.zzbtd.zzbsy);
    zzajs.zza(this, "onhide", localHashMap);
  }

  public final zzbfu zzet(String paramString)
  {
    try
    {
      Map localMap = this.zzelu;
      if (localMap == null);
      for (zzbfu localzzbfu = null; ; localzzbfu = (zzbfu)this.zzelu.get(paramString))
        return localzzbfu;
    }
    finally
    {
    }
  }

  public final void zzi(String paramString1, String paramString2)
  {
    zzajs.zza(this, paramString1, paramString2);
  }

  public final void zzlc()
  {
    try
    {
      this.zzelf = true;
      if (this.zzekr != null)
        this.zzekr.zzlc();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzld()
  {
    try
    {
      this.zzelf = false;
      if (this.zzekr != null)
        this.zzekr.zzld();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zztl()
  {
    if (this.zzeln == null)
    {
      zzada.zza(this.zzelp.zzqw(), this.zzeeo, new String[] { "aes2" });
      this.zzeln = zzada.zzb(this.zzelp.zzqw());
      this.zzelp.zza("native:view_show", this.zzeln);
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.zzbtd.zzbsy);
    zzajs.zza(this, "onshow", localHashMap);
  }

  public final void zztm()
  {
    zzd localzzd = zzaae();
    if (localzzd != null)
      localzzd.zztm();
  }

  public final zzbcx zzya()
  {
    return null;
  }

  public final zzbhr zzyb()
  {
    try
    {
      zzbhr localzzbhr = this.zzelg;
      return localzzbhr;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final zzadf zzyc()
  {
    return this.zzeeo;
  }

  public final Activity zzyd()
  {
    return this.zzekp.zzyd();
  }

  public final zza zzye()
  {
    return this.zzeks;
  }

  public final String zzyf()
  {
    try
    {
      String str = this.zzdlz;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final zzadg zzyg()
  {
    return this.zzelp;
  }

  public final zzbaj zzyh()
  {
    return this.zzbtd;
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
    try
    {
      if (this.zzelk != null)
        this.zzelk.zzre();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbiw
 * JD-Core Version:    0.6.2
 */