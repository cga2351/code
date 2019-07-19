package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzare
@ParametersAreNonnullByDefault
@VisibleForTesting
public final class zzbip extends zzbja
  implements zzbij
{
  private final Object lock = new Object();
  private volatile boolean zzbsz;
  private zzxp zzcgj;
  private zzagu zzczo;
  private zzagw zzczp;
  private zzb zzdaj;
  private zzaps zzdak;
  protected zzbha zzdjo;
  private zzo zzdko;
  private zzu zzdks;
  private boolean zzdom;
  private zzbik zzejh;
  private zzbil zzeji;
  private zzbim zzejj;
  private boolean zzejk = false;

  @GuardedBy("lock")
  private boolean zzejl;

  @GuardedBy("lock")
  private boolean zzejm;
  private zzaqb zzejn;
  private zzavc zzejo;
  private boolean zzejp;
  private boolean zzejq;
  private int zzejr;
  private View.OnAttachStateChangeListener zzejs;
  private final zzajv<zzbha> zzemm = new zzajv();

  private final void zza(View paramView, zzavc paramzzavc, int paramInt)
  {
    if ((paramzzavc.zzud()) && (paramInt > 0))
    {
      paramzzavc.zzj(paramView);
      if (paramzzavc.zzud())
        zzaxj.zzdvx.postDelayed(new zzbir(this, paramView, paramzzavc, paramInt), 100L);
    }
  }

  private final void zza(AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    if (this.zzdak != null);
    for (boolean bool1 = this.zzdak.zztb(); ; bool1 = false)
    {
      zzk.zzlf();
      Context localContext = this.zzdjo.getContext();
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      zzm.zza(localContext, paramAdOverlayInfoParcel, bool2);
      if (this.zzejo != null)
      {
        String str = paramAdOverlayInfoParcel.url;
        if ((str == null) && (paramAdOverlayInfoParcel.zzdkn != null))
          str = paramAdOverlayInfoParcel.zzdkn.url;
        this.zzejo.zzdk(str);
      }
      return;
    }
  }

  private final void zzabc()
  {
    if (this.zzejs == null)
      return;
    this.zzdjo.getView().removeOnAttachStateChangeListener(this.zzejs);
  }

  private final void zzabh()
  {
    zzbik localzzbik;
    if ((this.zzejh != null) && (((this.zzejp) && (this.zzejr <= 0)) || (this.zzejq)))
    {
      localzzbik = this.zzejh;
      if (this.zzejq)
        break label64;
    }
    label64: for (boolean bool = true; ; bool = false)
    {
      localzzbik.zzae(bool);
      this.zzejh = null;
      this.zzdjo.zzaas();
      return;
    }
  }

  private static WebResourceResponse zzabi()
  {
    zzaci localzzaci = zzact.zzcon;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
    return null;
  }

  private final WebResourceResponse zze(zzbjb paramzzbjb)
    throws IOException
  {
    Object localObject = new URL(paramzzbjb.url);
    int i = 0;
    int j = i + 1;
    if (j <= 20)
    {
      URLConnection localURLConnection = ((URL)localObject).openConnection();
      localURLConnection.setConnectTimeout(10000);
      localURLConnection.setReadTimeout(10000);
      Iterator localIterator = paramzzbjb.zzab.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localURLConnection.addRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      if (!(localURLConnection instanceof HttpURLConnection))
        throw new IOException("Invalid protocol.");
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURLConnection;
      zzk.zzlg().zza(this.zzdjo.getContext(), this.zzdjo.zzyh().zzbsy, false, localHttpURLConnection);
      zzazy localzzazy = new zzazy();
      localzzazy.zza(localHttpURLConnection, null);
      int k = localHttpURLConnection.getResponseCode();
      localzzazy.zza(localHttpURLConnection, k);
      if ((k >= 300) && (k < 400))
      {
        String str1 = localHttpURLConnection.getHeaderField("Location");
        if (str1 == null)
          throw new IOException("Missing Location header in redirect");
        URL localURL = new URL((URL)localObject, str1);
        String str2 = localURL.getProtocol();
        if (str2 == null)
        {
          zzaxa.zzep("Protocol is null");
          return zzabi();
        }
        if ((!str2.equals("http")) && (!str2.equals("https")))
        {
          String str5 = String.valueOf(str2);
          if (str5.length() != 0);
          for (String str6 = "Unsupported scheme: ".concat(str5); ; str6 = new String("Unsupported scheme: "))
          {
            zzaxa.zzep(str6);
            return zzabi();
          }
        }
        String str3 = String.valueOf(str1);
        if (str3.length() != 0);
        for (String str4 = "Redirecting to ".concat(str3); ; str4 = new String("Redirecting to "))
        {
          zzaxa.zzdp(str4);
          localHttpURLConnection.disconnect();
          i = j;
          localObject = localURL;
          break;
        }
      }
      zzk.zzlg();
      return zzaxj.zzd(localHttpURLConnection);
    }
    throw new IOException(32 + "Too many redirects (20)");
  }

  public final void destroy()
  {
    if (this.zzejo != null)
    {
      this.zzejo.zzuf();
      this.zzejo = null;
    }
    zzabc();
    this.zzemm.reset();
    this.zzemm.zzg(null);
    synchronized (this.lock)
    {
      this.zzcgj = null;
      this.zzdko = null;
      this.zzejh = null;
      this.zzeji = null;
      this.zzczo = null;
      this.zzczp = null;
      this.zzdks = null;
      this.zzejj = null;
      if (this.zzdak != null)
      {
        this.zzdak.zzw(true);
        this.zzdak = null;
      }
      return;
    }
  }

  @TargetApi(26)
  public final boolean onRenderProcessGone(WebView paramWebView, RenderProcessGoneDetail paramRenderProcessGoneDetail)
  {
    return this.zzdjo.zzb(paramRenderProcessGoneDetail.didCrash(), paramRenderProcessGoneDetail.rendererPriorityAtExit());
  }

  public final void zza(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.zzejn.zzj(paramInt1, paramInt2);
    if (this.zzdak != null)
      this.zzdak.zza(paramInt1, paramInt2, false);
  }

  public final void zza(zzc paramzzc)
  {
    boolean bool = this.zzdjo.zzaan();
    zzxp localzzxp;
    zzo localzzo;
    if ((bool) && (!this.zzdjo.zzaag().zzabx()))
    {
      localzzxp = null;
      localzzo = null;
      if (!bool)
        break label75;
    }
    while (true)
    {
      zza(new AdOverlayInfoParcel(paramzzc, localzzxp, localzzo, this.zzdks, this.zzdjo.zzyh()));
      return;
      localzzxp = this.zzcgj;
      break;
      label75: localzzo = this.zzdko;
    }
  }

  final void zza(zzbha paramzzbha, boolean paramBoolean)
  {
    zzaqb localzzaqb = new zzaqb(paramzzbha, paramzzbha.zzaad(), new zzace(paramzzbha.getContext()));
    this.zzdjo = paramzzbha;
    this.zzbsz = paramBoolean;
    this.zzejn = localzzaqb;
    this.zzdak = null;
    this.zzemm.zzg(paramzzbha);
  }

  public final void zza(zzbik paramzzbik)
  {
    this.zzejh = paramzzbik;
  }

  public final void zza(zzbil paramzzbil)
  {
    this.zzeji = paramzzbil;
  }

  public final void zza(zzbjb paramzzbjb)
  {
    this.zzejp = true;
    if (this.zzeji != null)
    {
      this.zzeji.zzrw();
      this.zzeji = null;
    }
    zzabh();
  }

  public final void zza(zzxp paramzzxp, zzagu paramzzagu, zzo paramzzo, zzagw paramzzagw, zzu paramzzu, boolean paramBoolean, zzaho paramzzaho, zzb paramzzb, zzaqd paramzzaqd, zzavc paramzzavc)
  {
    if (paramzzb == null)
      paramzzb = new zzb(this.zzdjo.getContext(), paramzzavc, null);
    this.zzdak = new zzaps(this.zzdjo, paramzzaqd);
    this.zzejo = paramzzavc;
    zzaci localzzaci = zzact.zzcow;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      zza("/adMetadata", new zzagt(paramzzagu));
    zza("/appEvent", new zzagv(paramzzagw));
    zza("/backButton", zzagy.zzczz);
    zza("/refresh", zzagy.zzdaa);
    zza("/canOpenURLs", zzagy.zzczq);
    zza("/canOpenIntents", zzagy.zzczr);
    zza("/click", zzagy.zzczs);
    zza("/close", zzagy.zzczt);
    zza("/customClose", zzagy.zzczu);
    zza("/instrument", zzagy.zzdad);
    zza("/delayPageLoaded", zzagy.zzdaf);
    zza("/delayPageClosed", zzagy.zzdag);
    zza("/getLocationInfo", zzagy.zzdah);
    zza("/httpTrack", zzagy.zzczv);
    zza("/log", zzagy.zzczw);
    zza("/mraid", new zzahq(paramzzb, this.zzdak, paramzzaqd));
    zza("/mraidLoaded", this.zzejn);
    zza("/open", new zzahr(paramzzb, this.zzdak));
    zza("/precache", new zzbgd());
    zza("/touch", zzagy.zzczy);
    zza("/video", zzagy.zzdab);
    zza("/videoMeta", zzagy.zzdac);
    if (zzk.zzme().zzx(this.zzdjo.getContext()))
      zza("/logScionEvent", new zzahp(this.zzdjo.getContext()));
    this.zzcgj = paramzzxp;
    this.zzdko = paramzzo;
    this.zzczo = paramzzagu;
    this.zzczp = paramzzagw;
    this.zzdks = paramzzu;
    this.zzdaj = paramzzb;
    this.zzejk = paramBoolean;
  }

  public final void zza(String paramString, Predicate<zzahn<? super zzbha>> paramPredicate)
  {
    this.zzemm.zza(paramString, paramPredicate);
  }

  public final void zza(String paramString, zzahn<? super zzbha> paramzzahn)
  {
    this.zzemm.zza(paramString, paramzzahn);
  }

  public final void zza(boolean paramBoolean, int paramInt, String paramString)
  {
    boolean bool = this.zzdjo.zzaan();
    zzxp localzzxp;
    Object localObject;
    if ((bool) && (!this.zzdjo.zzaag().zzabx()))
    {
      localzzxp = null;
      localObject = null;
      if (!bool)
        break label95;
    }
    while (true)
    {
      zza(new AdOverlayInfoParcel(localzzxp, (zzo)localObject, this.zzczo, this.zzczp, this.zzdks, this.zzdjo, paramBoolean, paramInt, paramString, this.zzdjo.zzyh()));
      return;
      localzzxp = this.zzcgj;
      break;
      label95: localObject = new zzbit(this.zzdjo, this.zzdko);
    }
  }

  public final void zza(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = this.zzdjo.zzaan();
    zzxp localzzxp;
    if ((bool) && (!this.zzdjo.zzaag().zzabx()))
    {
      localzzxp = null;
      if (!bool)
        break label97;
    }
    label97: for (Object localObject = null; ; localObject = new zzbit(this.zzdjo, this.zzdko))
    {
      zza(new AdOverlayInfoParcel(localzzxp, (zzo)localObject, this.zzczo, this.zzczp, this.zzdks, this.zzdjo, paramBoolean, paramInt, paramString1, paramString2, this.zzdjo.zzyh()));
      return;
      localzzxp = this.zzcgj;
      break;
    }
  }

  public final zzb zzaax()
  {
    return this.zzdaj;
  }

  public final boolean zzaay()
  {
    return this.zzbsz;
  }

  public final boolean zzaaz()
  {
    synchronized (this.lock)
    {
      boolean bool = this.zzejl;
      return bool;
    }
  }

  public final ViewTreeObserver.OnGlobalLayoutListener zzaba()
  {
    synchronized (this.lock)
    {
      return null;
    }
  }

  public final ViewTreeObserver.OnScrollChangedListener zzabb()
  {
    synchronized (this.lock)
    {
      return null;
    }
  }

  public final void zzabd()
  {
    zzavc localzzavc = this.zzejo;
    if (localzzavc != null)
    {
      WebView localWebView = this.zzdjo.getWebView();
      if (ViewCompat.isAttachedToWindow(localWebView))
        zza(localWebView, localzzavc, 10);
    }
    else
    {
      return;
    }
    zzabc();
    this.zzejs = new zzbis(this, localzzavc);
    this.zzdjo.getView().addOnAttachStateChangeListener(this.zzejs);
  }

  public final void zzabe()
  {
    synchronized (this.lock)
    {
      this.zzejm = true;
      this.zzejr = (1 + this.zzejr);
      zzabh();
      return;
    }
  }

  public final void zzabf()
  {
    this.zzejr = (-1 + this.zzejr);
    zzabh();
  }

  public final void zzabg()
  {
    this.zzejq = true;
    zzabh();
  }

  public final zzavc zzabj()
  {
    return this.zzejo;
  }

  public final void zzao(boolean paramBoolean)
  {
    this.zzejk = paramBoolean;
  }

  public final void zzat(boolean paramBoolean)
  {
    this.zzdom = paramBoolean;
  }

  public final void zzau(boolean paramBoolean)
  {
    synchronized (this.lock)
    {
      this.zzejl = true;
      return;
    }
  }

  public final void zzb(zzbjb paramzzbjb)
  {
    this.zzemm.zzg(paramzzbjb.uri);
  }

  public final void zzb(String paramString, zzahn<? super zzbha> paramzzahn)
  {
    this.zzemm.zzb(paramString, paramzzahn);
  }

  public final void zzc(boolean paramBoolean, int paramInt)
  {
    if ((this.zzdjo.zzaan()) && (!this.zzdjo.zzaag().zzabx()));
    for (zzxp localzzxp = null; ; localzzxp = this.zzcgj)
    {
      zza(new AdOverlayInfoParcel(localzzxp, this.zzdko, this.zzdks, this.zzdjo, paramBoolean, paramInt, this.zzdjo.zzyh()));
      return;
    }
  }

  public final boolean zzc(zzbjb paramzzbjb)
  {
    String str1 = String.valueOf(paramzzbjb.url);
    if (str1.length() != 0);
    Object localObject1;
    for (String str2 = "AdWebView shouldOverrideUrlLoading: ".concat(str1); ; str2 = new String("AdWebView shouldOverrideUrlLoading: "))
    {
      zzaxa.zzds(str2);
      localObject1 = paramzzbjb.uri;
      if (!this.zzemm.zzg((Uri)localObject1))
        break;
      return true;
    }
    if (this.zzejk)
    {
      String str7 = ((Uri)localObject1).getScheme();
      if (("http".equalsIgnoreCase(str7)) || ("https".equalsIgnoreCase(str7)));
      for (int i = 1; i != 0; i = 0)
      {
        if (this.zzcgj != null)
        {
          this.zzcgj.onAdClicked();
          if (this.zzejo != null)
            this.zzejo.zzdk(paramzzbjb.url);
          this.zzcgj = null;
        }
        return false;
      }
    }
    if (!this.zzdjo.getWebView().willNotDraw())
      try
      {
        zzdh localzzdh = this.zzdjo.zzaal();
        if ((localzzdh != null) && (localzzdh.zzc((Uri)localObject1)))
        {
          Uri localUri = localzzdh.zza((Uri)localObject1, this.zzdjo.getContext(), this.zzdjo.getView(), this.zzdjo.zzyd());
          localObject1 = localUri;
        }
        localObject2 = localObject1;
        if ((this.zzdaj == null) || (this.zzdaj.zzkx()))
        {
          zza(new zzc("android.intent.action.VIEW", localObject2.toString(), null, null, null, null, null));
          return true;
        }
      }
      catch (zzdi localzzdi)
      {
        while (true)
        {
          Object localObject2;
          String str5 = String.valueOf(paramzzbjb.url);
          if (str5.length() != 0);
          for (String str6 = "Unable to append parameter to URL: ".concat(str5); ; str6 = new String("Unable to append parameter to URL: "))
          {
            zzaxa.zzep(str6);
            localObject2 = localObject1;
            break;
          }
          this.zzdaj.zzbk(paramzzbjb.url);
        }
      }
    String str3 = String.valueOf(paramzzbjb.url);
    if (str3.length() != 0);
    for (String str4 = "AdWebView unable to handle URL: ".concat(str3); ; str4 = new String("AdWebView unable to handle URL: "))
    {
      zzaxa.zzep(str4);
      break;
    }
  }

  public final WebResourceResponse zzd(zzbjb paramzzbjb)
  {
    if (this.zzejo != null)
      this.zzejo.zza(paramzzbjb.url, paramzzbjb.zzab, 1);
    WebResourceResponse localWebResourceResponse1;
    if (!"mraid.js".equalsIgnoreCase(new File(paramzzbjb.url).getName()))
    {
      localWebResourceResponse1 = null;
      if (localWebResourceResponse1 != null)
        return localWebResourceResponse1;
    }
    else
    {
      zzth();
      String str;
      if (this.zzdjo.zzaag().zzabx())
      {
        zzaci localzzaci4 = zzact.zzcmv;
        str = (String)zzyr.zzpe().zzd(localzzaci4);
      }
      while (true)
      {
        zzk.zzlg();
        localWebResourceResponse1 = zzaxj.zzd(this.zzdjo.getContext(), this.zzdjo.zzyh().zzbsy, str);
        break;
        if (this.zzdjo.zzaan())
        {
          zzaci localzzaci3 = zzact.zzcmu;
          str = (String)zzyr.zzpe().zzd(localzzaci3);
        }
        else
        {
          zzaci localzzaci1 = zzact.zzcmt;
          str = (String)zzyr.zzpe().zzd(localzzaci1);
        }
      }
    }
    try
    {
      if (!zzavy.zzd(paramzzbjb.url, this.zzdjo.getContext(), this.zzdom).equals(paramzzbjb.url))
        return zze(paramzzbjb);
      zzvt localzzvt = zzvt.zzbo(paramzzbjb.url);
      if (localzzvt != null)
      {
        zzvq localzzvq = zzk.zzlm().zza(localzzvt);
        if ((localzzvq != null) && (localzzvq.zznh()))
        {
          WebResourceResponse localWebResourceResponse2 = new WebResourceResponse("", "", localzzvq.zzni());
          return localWebResourceResponse2;
        }
      }
    }
    catch (Exception localException)
    {
      zzk.zzlk().zza(localException, "AdWebViewClient.interceptRequest");
      return zzabi();
      if (zzazy.isEnabled())
      {
        zzaci localzzaci2 = zzact.zzcqd;
        if (((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue())
        {
          WebResourceResponse localWebResourceResponse3 = zze(paramzzbjb);
          return localWebResourceResponse3;
        }
      }
      return null;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      label275: break label275;
    }
  }

  public final void zzh(Uri paramUri)
  {
    this.zzemm.zzh(paramUri);
  }

  public final void zzi(int paramInt1, int paramInt2)
  {
    if (this.zzdak != null)
      this.zzdak.zzi(paramInt1, paramInt2);
  }

  public final void zzth()
  {
    synchronized (this.lock)
    {
      this.zzejk = false;
      this.zzbsz = true;
      zzbbn.zzeag.execute(new zzbiq(this));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbip
 * JD-Core Version:    0.6.2
 */