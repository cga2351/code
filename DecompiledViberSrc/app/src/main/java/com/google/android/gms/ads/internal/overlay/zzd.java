package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaci;
import com.google.android.gms.internal.ads.zzacq;
import com.google.android.gms.internal.ads.zzact;
import com.google.android.gms.internal.ads.zzagu;
import com.google.android.gms.internal.ads.zzagw;
import com.google.android.gms.internal.ads.zzaqc;
import com.google.android.gms.internal.ads.zzaqe;
import com.google.android.gms.internal.ads.zzaqi;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzawn;
import com.google.android.gms.internal.ads.zzaww;
import com.google.android.gms.internal.ads.zzaxa;
import com.google.android.gms.internal.ads.zzaxj;
import com.google.android.gms.internal.ads.zzaxp;
import com.google.android.gms.internal.ads.zzbaj;
import com.google.android.gms.internal.ads.zzbha;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzbij;
import com.google.android.gms.internal.ads.zzbio;
import com.google.android.gms.internal.ads.zzwh;
import com.google.android.gms.internal.ads.zzxp;
import com.google.android.gms.internal.ads.zzyr;
import java.util.Collections;

@zzare
public class zzd extends zzaqi
  implements zzx
{

  @VisibleForTesting
  private static final int zzdjm = Color.argb(0, 0, 0, 0);
  protected final Activity mActivity;

  @VisibleForTesting
  AdOverlayInfoParcel zzdjn;

  @VisibleForTesting
  zzbha zzdjo;

  @VisibleForTesting
  private zzj zzdjp;

  @VisibleForTesting
  private zzp zzdjq;

  @VisibleForTesting
  private boolean zzdjr = false;

  @VisibleForTesting
  private FrameLayout zzdjs;

  @VisibleForTesting
  private WebChromeClient.CustomViewCallback zzdjt;

  @VisibleForTesting
  private boolean zzdju = false;

  @VisibleForTesting
  private boolean zzdjv = false;

  @VisibleForTesting
  private zzi zzdjw;

  @VisibleForTesting
  private boolean zzdjx = false;

  @VisibleForTesting
  int zzdjy = 0;
  private final Object zzdjz = new Object();
  private Runnable zzdka;
  private boolean zzdkb;
  private boolean zzdkc;
  private boolean zzdkd = false;
  private boolean zzdke = false;
  private boolean zzdkf = true;

  public zzd(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }

  private final void zza(Configuration paramConfiguration)
  {
    int i = 1;
    int j;
    if ((this.zzdjn.zzdkv != null) && (this.zzdjn.zzdkv.zzbrg))
    {
      j = i;
      boolean bool1 = com.google.android.gms.ads.internal.zzk.zzli().zza(this.mActivity, paramConfiguration);
      if (((this.zzdjv) && (j == 0)) || (bool1))
        break label256;
      int n = Build.VERSION.SDK_INT;
      k = 0;
      if (n >= 19)
      {
        com.google.android.gms.ads.internal.zzh localzzh = this.zzdjn.zzdkv;
        k = 0;
        if (localzzh != null)
        {
          boolean bool2 = this.zzdjn.zzdkv.zzbrl;
          k = 0;
          if (!bool2);
        }
      }
    }
    for (int k = i; ; k = 0)
    {
      Window localWindow = this.mActivity.getWindow();
      zzaci localzzaci = zzact.zzcph;
      if ((((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) && (Build.VERSION.SDK_INT >= 19))
      {
        View localView = localWindow.getDecorView();
        int m = 256;
        if (i != 0)
        {
          m = 5380;
          if (k != 0)
            m = 5894;
        }
        localView.setSystemUiVisibility(m);
      }
      do
      {
        return;
        j = 0;
        break;
        if (i == 0)
          break label239;
        localWindow.addFlags(1024);
        localWindow.clearFlags(2048);
      }
      while ((Build.VERSION.SDK_INT < 19) || (k == 0));
      localWindow.getDecorView().setSystemUiVisibility(4098);
      return;
      label239: localWindow.addFlags(2048);
      localWindow.clearFlags(1024);
      return;
      label256: i = 0;
    }
  }

  private final void zzac(boolean paramBoolean)
  {
    zzaci localzzaci = zzact.zzcul;
    int i = ((Integer)zzyr.zzpe().zzd(localzzaci)).intValue();
    zzq localzzq = new zzq();
    localzzq.size = 50;
    int j;
    int k;
    label55: RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      j = i;
      localzzq.paddingLeft = j;
      if (!paramBoolean)
        break label159;
      k = 0;
      localzzq.paddingRight = k;
      localzzq.paddingTop = 0;
      localzzq.paddingBottom = i;
      this.zzdjq = new zzp(this.mActivity, localzzq, this);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10);
      if (!paramBoolean)
        break label165;
    }
    label159: label165: for (int m = 11; ; m = 9)
    {
      localLayoutParams.addRule(m);
      zza(paramBoolean, this.zzdjn.zzdkq);
      this.zzdjw.addView(this.zzdjq, localLayoutParams);
      return;
      j = 0;
      break;
      k = i;
      break label55;
    }
  }

  private final void zzad(boolean paramBoolean)
    throws zzh
  {
    if (!this.zzdkc)
      this.mActivity.requestWindowFeature(1);
    Window localWindow = this.mActivity.getWindow();
    if (localWindow == null)
      throw new zzh("Invalid activity, no window available.");
    zzbij localzzbij1;
    boolean bool1;
    label77: boolean bool4;
    if (this.zzdjn.zzdbu != null)
    {
      localzzbij1 = this.zzdjn.zzdbu.zzaai();
      if ((localzzbij1 == null) || (!localzzbij1.zzaay()))
        break label669;
      bool1 = true;
      this.zzdjx = false;
      if (bool1)
      {
        int i = this.zzdjn.orientation;
        com.google.android.gms.ads.internal.zzk.zzli();
        if (i != 6)
          break label681;
        if (this.mActivity.getResources().getConfiguration().orientation != 1)
          break label675;
        bool4 = true;
        label127: this.zzdjx = bool4;
      }
      label133: boolean bool2 = this.zzdjx;
      zzaxa.zzdp(46 + "Delay onShow to next orientation change: " + bool2);
      setRequestedOrientation(this.zzdjn.orientation);
      com.google.android.gms.ads.internal.zzk.zzli();
      localWindow.setFlags(16777216, 16777216);
      zzaxa.zzdp("Hardware acceleration on the AdActivity window enabled.");
      if (this.zzdjv)
        break label736;
      this.zzdjw.setBackgroundColor(-16777216);
      label213: this.mActivity.setContentView(this.zzdjw);
      this.zzdkc = true;
      if (!paramBoolean)
        break label848;
    }
    while (true)
    {
      try
      {
        com.google.android.gms.ads.internal.zzk.zzlh();
        Activity localActivity = this.mActivity;
        if (this.zzdjn.zzdbu != null)
        {
          localzzbio = this.zzdjn.zzdbu.zzaag();
          if (this.zzdjn.zzdbu == null)
            continue;
          str = this.zzdjn.zzdbu.zzaah();
          zzbaj localzzbaj = this.zzdjn.zzbtd;
          if (this.zzdjn.zzdbu == null)
            continue;
          localzza = this.zzdjn.zzdbu.zzye();
          this.zzdjo = zzbhg.zza(localActivity, localzzbio, str, true, bool1, null, localzzbaj, null, null, localzza, zzwh.zznl());
          zzbij localzzbij2 = this.zzdjo.zzaai();
          zzagu localzzagu = this.zzdjn.zzczo;
          zzagw localzzagw = this.zzdjn.zzczp;
          zzu localzzu = this.zzdjn.zzdks;
          if (this.zzdjn.zzdbu == null)
            break label788;
          localzzb = this.zzdjn.zzdbu.zzaai().zzaax();
          localzzbij2.zza(null, localzzagu, null, localzzagw, localzzu, true, null, localzzb, null, null);
          this.zzdjo.zzaai().zza(new zze(this));
          if (this.zzdjn.url == null)
            break label794;
          this.zzdjo.loadUrl(this.zzdjn.url);
          if (this.zzdjn.zzdbu != null)
            this.zzdjn.zzdbu.zzb(this);
          this.zzdjo.zza(this);
          if (this.zzdjn.zzdbu != null)
            zzb(this.zzdjn.zzdbu.zzaam(), this.zzdjw);
          ViewParent localViewParent = this.zzdjo.getParent();
          if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
            ((ViewGroup)localViewParent).removeView(this.zzdjo.getView());
          if (this.zzdjv)
            this.zzdjo.zzaau();
          this.zzdjw.addView(this.zzdjo.getView(), -1, -1);
          if ((!paramBoolean) && (!this.zzdjx))
            zztl();
          zzac(bool1);
          if (this.zzdjo.zzaak())
            zza(bool1, true);
          return;
          localzzbij1 = null;
          break;
          label669: bool1 = false;
          break label77;
          label675: bool4 = false;
          break label127;
          label681: int j = this.zzdjn.orientation;
          com.google.android.gms.ads.internal.zzk.zzli();
          if (j != 7)
            break label133;
          if (this.mActivity.getResources().getConfiguration().orientation == 2)
          {
            bool3 = true;
            this.zzdjx = bool3;
            break label133;
          }
          boolean bool3 = false;
          continue;
          label736: this.zzdjw.setBackgroundColor(zzdjm);
          break label213;
        }
        zzbio localzzbio = null;
        continue;
        String str = null;
        continue;
        zza localzza = null;
        continue;
      }
      catch (Exception localException)
      {
        zzaxa.zzc("Error obtaining webview.", localException);
        throw new zzh("Could not obtain webview for the overlay.");
      }
      label788: zzb localzzb = null;
      continue;
      label794: if (this.zzdjn.zzdkr != null)
      {
        this.zzdjo.loadDataWithBaseURL(this.zzdjn.zzdkp, this.zzdjn.zzdkr, "text/html", "UTF-8", null);
      }
      else
      {
        throw new zzh("No URL or HTML to display in ad overlay.");
        label848: this.zzdjo = this.zzdjn.zzdbu;
        this.zzdjo.zzbn(this.mActivity);
      }
    }
  }

  private static void zzb(IObjectWrapper paramIObjectWrapper, View paramView)
  {
    if ((paramIObjectWrapper != null) && (paramView != null))
      com.google.android.gms.ads.internal.zzk.zzlv().zza(paramIObjectWrapper, paramView);
  }

  private final void zzti()
  {
    if ((!this.mActivity.isFinishing()) || (this.zzdkd))
      return;
    this.zzdkd = true;
    if (this.zzdjo != null)
    {
      int i = this.zzdjy;
      this.zzdjo.zzdi(i);
      synchronized (this.zzdjz)
      {
        if ((!this.zzdkb) && (this.zzdjo.zzaaq()))
        {
          this.zzdka = new zzf(this);
          Handler localHandler = zzaxj.zzdvx;
          Runnable localRunnable = this.zzdka;
          zzaci localzzaci = zzact.zzcpe;
          localHandler.postDelayed(localRunnable, ((Long)zzyr.zzpe().zzd(localzzaci)).longValue());
          return;
        }
      }
    }
    zztj();
  }

  private final void zztl()
  {
    this.zzdjo.zztl();
  }

  public final void close()
  {
    this.zzdjy = 2;
    this.mActivity.finish();
  }

  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
  }

  public final void onBackPressed()
  {
    this.zzdjy = 0;
  }

  public void onCreate(Bundle paramBundle)
  {
    this.mActivity.requestWindowFeature(1);
    boolean bool1 = false;
    if (paramBundle != null)
    {
      boolean bool2 = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    this.zzdju = bool1;
    try
    {
      this.zzdjn = AdOverlayInfoParcel.zzc(this.mActivity.getIntent());
      if (this.zzdjn == null)
        throw new zzh("Could not get info for ad overlay.");
    }
    catch (zzh localzzh)
    {
      zzaxa.zzep(localzzh.getMessage());
      this.zzdjy = 3;
      this.mActivity.finish();
      return;
    }
    if (this.zzdjn.zzbtd.zzdzf > 7500000)
      this.zzdjy = 3;
    if (this.mActivity.getIntent() != null)
      this.zzdkf = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
    if (this.zzdjn.zzdkv != null);
    for (this.zzdjv = this.zzdjn.zzdkv.zzbrf; ; this.zzdjv = false)
    {
      if ((this.zzdjv) && (this.zzdjn.zzdkv.zzbrk != -1))
        new zzk(this, null).zzvi();
      if (paramBundle == null)
      {
        if ((this.zzdjn.zzdko != null) && (this.zzdkf))
          this.zzdjn.zzdko.zzta();
        if ((this.zzdjn.zzdkt != 1) && (this.zzdjn.zzcgj != null))
          this.zzdjn.zzcgj.onAdClicked();
      }
      this.zzdjw = new zzi(this.mActivity, this.zzdjn.zzdku, this.zzdjn.zzbtd.zzbsy);
      this.zzdjw.setId(1000);
      com.google.android.gms.ads.internal.zzk.zzli().zzg(this.mActivity);
      switch (this.zzdjn.zzdkt)
      {
      default:
        throw new zzh("Could not determine ad overlay type.");
      case 1:
      case 2:
      case 3:
      }
    }
    zzad(false);
    return;
    this.zzdjp = new zzj(this.zzdjn.zzdbu);
    zzad(false);
    return;
    zzad(true);
  }

  public final void onDestroy()
  {
    if (this.zzdjo != null)
      this.zzdjw.removeView(this.zzdjo.getView());
    zzti();
  }

  public final void onPause()
  {
    zzte();
    if (this.zzdjn.zzdko != null)
      this.zzdjn.zzdko.onPause();
    zzaci localzzaci = zzact.zzcuj;
    if ((!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) && (this.zzdjo != null) && ((!this.mActivity.isFinishing()) || (this.zzdjp == null)))
    {
      com.google.android.gms.ads.internal.zzk.zzli();
      zzaxp.zza(this.zzdjo);
    }
    zzti();
  }

  public final void onRestart()
  {
  }

  public final void onResume()
  {
    if (this.zzdjn.zzdko != null)
      this.zzdjn.zzdko.onResume();
    zza(this.mActivity.getResources().getConfiguration());
    zzaci localzzaci = zzact.zzcuj;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
    {
      if ((this.zzdjo != null) && (!this.zzdjo.isDestroyed()))
      {
        com.google.android.gms.ads.internal.zzk.zzli();
        zzaxp.zzb(this.zzdjo);
      }
    }
    else
      return;
    zzaxa.zzep("The webview does not exist. Ignoring action.");
  }

  public final void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdju);
  }

  public final void onStart()
  {
    zzaci localzzaci = zzact.zzcuj;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
    {
      if ((this.zzdjo != null) && (!this.zzdjo.isDestroyed()))
      {
        com.google.android.gms.ads.internal.zzk.zzli();
        zzaxp.zzb(this.zzdjo);
      }
    }
    else
      return;
    zzaxa.zzep("The webview does not exist. Ignoring action.");
  }

  public final void onStop()
  {
    zzaci localzzaci = zzact.zzcuj;
    if ((((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) && (this.zzdjo != null) && ((!this.mActivity.isFinishing()) || (this.zzdjp == null)))
    {
      com.google.android.gms.ads.internal.zzk.zzli();
      zzaxp.zza(this.zzdjo);
    }
    zzti();
  }

  public final void setRequestedOrientation(int paramInt)
  {
    int i = this.mActivity.getApplicationInfo().targetSdkVersion;
    zzaci localzzaci1 = zzact.zzcwg;
    if (i >= ((Integer)zzyr.zzpe().zzd(localzzaci1)).intValue())
    {
      int j = this.mActivity.getApplicationInfo().targetSdkVersion;
      zzaci localzzaci2 = zzact.zzcwh;
      if (j <= ((Integer)zzyr.zzpe().zzd(localzzaci2)).intValue())
      {
        int k = Build.VERSION.SDK_INT;
        zzaci localzzaci3 = zzact.zzcwi;
        if (k >= ((Integer)zzyr.zzpe().zzd(localzzaci3)).intValue())
        {
          int m = Build.VERSION.SDK_INT;
          zzaci localzzaci4 = zzact.zzcwj;
          if (m <= ((Integer)zzyr.zzpe().zzd(localzzaci4)).intValue())
            return;
        }
      }
    }
    try
    {
      this.mActivity.setRequestedOrientation(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.zzk.zzlk().zzb(localThrowable, "AdOverlay.setRequestedOrientation");
    }
  }

  public final void zza(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.zzdjs = new FrameLayout(this.mActivity);
    this.zzdjs.setBackgroundColor(-16777216);
    this.zzdjs.addView(paramView, -1, -1);
    this.mActivity.setContentView(this.zzdjs);
    this.zzdkc = true;
    this.zzdjt = paramCustomViewCallback;
    this.zzdjr = true;
  }

  public final void zza(boolean paramBoolean1, boolean paramBoolean2)
  {
    zzaci localzzaci1 = zzact.zzcpf;
    int i;
    if ((((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue()) && (this.zzdjn != null) && (this.zzdjn.zzdkv != null) && (this.zzdjn.zzdkv.zzbrm))
    {
      i = 1;
      zzaci localzzaci2 = zzact.zzcpg;
      if ((!((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue()) || (this.zzdjn == null) || (this.zzdjn.zzdkv == null) || (!this.zzdjn.zzdkv.zzbrn))
        break label196;
    }
    label196: for (int j = 1; ; j = 0)
    {
      if ((paramBoolean1) && (paramBoolean2) && (i != 0) && (j == 0))
        new zzaqc(this.zzdjo, "useCustomClose").zzdh("Custom close has been disabled for interstitial ads in this ad slot.");
      if (this.zzdjq != null)
      {
        zzp localzzp = this.zzdjq;
        boolean bool;
        if (j == 0)
        {
          bool = false;
          if (paramBoolean2)
          {
            bool = false;
            if (i != 0);
          }
        }
        else
        {
          bool = true;
        }
        localzzp.zzaf(bool);
      }
      return;
      i = 0;
      break;
    }
  }

  public final void zzac(IObjectWrapper paramIObjectWrapper)
  {
    zza((Configuration)ObjectWrapper.unwrap(paramIObjectWrapper));
  }

  public final void zzdd()
  {
    this.zzdkc = true;
  }

  public final void zzte()
  {
    if ((this.zzdjn != null) && (this.zzdjr))
      setRequestedOrientation(this.zzdjn.orientation);
    if (this.zzdjs != null)
    {
      this.mActivity.setContentView(this.zzdjw);
      this.zzdkc = true;
      this.zzdjs.removeAllViews();
      this.zzdjs = null;
    }
    if (this.zzdjt != null)
    {
      this.zzdjt.onCustomViewHidden();
      this.zzdjt = null;
    }
    this.zzdjr = false;
  }

  public final void zztf()
  {
    this.zzdjy = 1;
    this.mActivity.finish();
  }

  public final boolean zztg()
  {
    this.zzdjy = 0;
    boolean bool;
    if (this.zzdjo == null)
      bool = true;
    do
    {
      return bool;
      bool = this.zzdjo.zzaap();
    }
    while (bool);
    this.zzdjo.zza("onbackblocked", Collections.emptyMap());
    return bool;
  }

  public final void zzth()
  {
    this.zzdjw.removeView(this.zzdjq);
    zzac(true);
  }

  @VisibleForTesting
  final void zztj()
  {
    if (this.zzdke)
      return;
    this.zzdke = true;
    if (this.zzdjo != null)
    {
      this.zzdjw.removeView(this.zzdjo.getView());
      if (this.zzdjp == null)
        break label186;
      this.zzdjo.zzbn(this.zzdjp.zzlj);
      this.zzdjo.zzaq(false);
      this.zzdjp.parent.addView(this.zzdjo.getView(), this.zzdjp.index, this.zzdjp.zzdkj);
      this.zzdjp = null;
    }
    while (true)
    {
      this.zzdjo = null;
      if ((this.zzdjn != null) && (this.zzdjn.zzdko != null))
        this.zzdjn.zzdko.zzsz();
      if ((this.zzdjn == null) || (this.zzdjn.zzdbu == null))
        break;
      zzb(this.zzdjn.zzdbu.zzaam(), this.zzdjn.zzdbu.getView());
      return;
      label186: if (this.mActivity.getApplicationContext() != null)
        this.zzdjo.zzbn(this.mActivity.getApplicationContext());
    }
  }

  public final void zztk()
  {
    if (this.zzdjx)
    {
      this.zzdjx = false;
      zztl();
    }
  }

  public final void zztm()
  {
    this.zzdjw.zzdki = true;
  }

  public final void zztn()
  {
    synchronized (this.zzdjz)
    {
      this.zzdkb = true;
      if (this.zzdka != null)
      {
        zzaxj.zzdvx.removeCallbacks(this.zzdka);
        zzaxj.zzdvx.post(this.zzdka);
      }
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzd
 * JD-Core Version:    0.6.2
 */