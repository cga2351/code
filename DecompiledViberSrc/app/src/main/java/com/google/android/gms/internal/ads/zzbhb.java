package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzare
@ParametersAreNonnullByDefault
@VisibleForTesting
public class zzbhb extends WebViewClient
  implements zzbij
{
  private static final String[] zzejd = { "UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS" };
  private static final String[] zzeje = { "NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID" };
  private final Object lock = new Object();

  @GuardedBy("lock")
  private boolean zzbsz;
  private zzxp zzcgj;
  private zzagu zzczo;
  private zzagw zzczp;
  private zzb zzdaj;
  private zzaps zzdak;
  protected zzbha zzdjo;
  private zzo zzdko;
  private zzu zzdks;
  private boolean zzdom;
  private final zzwh zzejf;
  private final HashMap<String, List<zzahn<? super zzbha>>> zzejg = new HashMap();
  private zzbik zzejh;
  private zzbil zzeji;
  private zzbim zzejj;
  private boolean zzejk = false;

  @GuardedBy("lock")
  private boolean zzejl;

  @GuardedBy("lock")
  private boolean zzejm;
  private final zzaqb zzejn;
  protected zzavc zzejo;
  private boolean zzejp;
  private boolean zzejq;
  private int zzejr;
  private View.OnAttachStateChangeListener zzejs;

  public zzbhb(zzbha paramzzbha, zzwh paramzzwh, boolean paramBoolean)
  {
    this(paramzzbha, paramzzwh, paramBoolean, new zzaqb(paramzzbha, paramzzbha.zzaad(), new zzace(paramzzbha.getContext())), null);
  }

  @VisibleForTesting
  private zzbhb(zzbha paramzzbha, zzwh paramzzwh, boolean paramBoolean, zzaqb paramzzaqb, zzaps paramzzaps)
  {
    this.zzejf = paramzzwh;
    this.zzdjo = paramzzbha;
    this.zzbsz = paramBoolean;
    this.zzejn = paramzzaqb;
    this.zzdak = null;
  }

  private final void zza(View paramView, zzavc paramzzavc, int paramInt)
  {
    if ((paramzzavc.zzud()) && (paramInt > 0))
    {
      paramzzavc.zzj(paramView);
      if (paramzzavc.zzud())
        zzaxj.zzdvx.postDelayed(new zzbhd(this, paramView, paramzzavc, paramInt), 100L);
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

  private final WebResourceResponse zze(String paramString, Map<String, String> paramMap)
    throws IOException
  {
    Object localObject = new URL(paramString);
    int i = 0;
    int j = i + 1;
    if (j <= 20)
    {
      URLConnection localURLConnection = ((URL)localObject).openConnection();
      localURLConnection.setConnectTimeout(10000);
      localURLConnection.setReadTimeout(10000);
      Iterator localIterator = paramMap.entrySet().iterator();
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

  private final void zze(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    zzaci localzzaci = zzact.zzcqp;
    if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      return;
    Bundle localBundle = new Bundle();
    localBundle.putString("err", paramString1);
    localBundle.putString("code", paramString2);
    Uri localUri;
    if (!TextUtils.isEmpty(paramString3))
    {
      localUri = Uri.parse(paramString3);
      if (localUri.getHost() == null);
    }
    for (String str = localUri.getHost(); ; str = "")
    {
      localBundle.putString("host", str);
      zzk.zzlg().zza(paramContext, this.zzdjo.zzyh().zzbsy, "gmob-apps", localBundle, true);
      return;
    }
  }

  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    String str1 = String.valueOf(paramString);
    if (str1.length() != 0);
    for (String str2 = "Loading resource: ".concat(str1); ; str2 = new String("Loading resource: "))
    {
      zzaxa.zzds(str2);
      Uri localUri = Uri.parse(paramString);
      if (("gmsg".equalsIgnoreCase(localUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(localUri.getHost())))
        zzh(localUri);
      return;
    }
  }

  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    synchronized (this.lock)
    {
      if (this.zzdjo.isDestroyed())
      {
        zzaxa.zzds("Blank page loaded, 1...");
        this.zzdjo.zzaao();
        return;
      }
      this.zzejp = true;
      if (this.zzeji != null)
      {
        this.zzeji.zzrw();
        this.zzeji = null;
      }
      zzabh();
      return;
    }
  }

  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt < 0) && (-1 + -paramInt < zzejd.length));
    for (String str = zzejd[(-1 + -paramInt)]; ; str = String.valueOf(paramInt))
    {
      zze(this.zzdjo.getContext(), "http_err", str, paramString2);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      return;
    }
  }

  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    int i;
    if (paramSslError != null)
    {
      i = paramSslError.getPrimaryError();
      if ((i < 0) || (i >= zzeje.length))
        break label70;
    }
    label70: for (String str = zzeje[i]; ; str = String.valueOf(i))
    {
      Context localContext = this.zzdjo.getContext();
      zzk.zzli();
      zze(localContext, "ssl_err", str, paramSslError.getUrl());
      super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      return;
    }
  }

  @TargetApi(26)
  public boolean onRenderProcessGone(WebView paramWebView, RenderProcessGoneDetail paramRenderProcessGoneDetail)
  {
    return this.zzdjo.zzb(paramRenderProcessGoneDetail.didCrash(), paramRenderProcessGoneDetail.rendererPriorityAtExit());
  }

  public final void reset()
  {
    if (this.zzejo != null)
    {
      this.zzejo.zzuf();
      this.zzejo = null;
    }
    zzabc();
    synchronized (this.lock)
    {
      this.zzejg.clear();
      this.zzcgj = null;
      this.zzdko = null;
      this.zzejh = null;
      this.zzeji = null;
      this.zzczo = null;
      this.zzczp = null;
      this.zzejk = false;
      this.zzbsz = false;
      this.zzejl = false;
      this.zzejm = false;
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

  @TargetApi(11)
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return zzd(paramString, Collections.emptyMap());
  }

  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getKeyCode())
    {
    default:
      return false;
    case 79:
    case 85:
    case 86:
    case 87:
    case 88:
    case 89:
    case 90:
    case 91:
    case 126:
    case 127:
    case 128:
    case 129:
    case 130:
    case 222:
    }
    return true;
  }

  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    String str1 = String.valueOf(paramString);
    String str2;
    Object localObject1;
    if (str1.length() != 0)
    {
      str2 = "AdWebView shouldOverrideUrlLoading: ".concat(str1);
      zzaxa.zzds(str2);
      localObject1 = Uri.parse(paramString);
      if ((!"gmsg".equalsIgnoreCase(((Uri)localObject1).getScheme())) || (!"mobileads.google.com".equalsIgnoreCase(((Uri)localObject1).getHost())))
        break label83;
      zzh((Uri)localObject1);
    }
    while (true)
    {
      return true;
      str2 = new String("AdWebView shouldOverrideUrlLoading: ");
      break;
      label83: if ((this.zzejk) && (paramWebView == this.zzdjo.getWebView()))
      {
        String str7 = ((Uri)localObject1).getScheme();
        if (("http".equalsIgnoreCase(str7)) || ("https".equalsIgnoreCase(str7)));
        for (int i = 1; i != 0; i = 0)
        {
          if (this.zzcgj != null)
          {
            this.zzcgj.onAdClicked();
            if (this.zzejo != null)
              this.zzejo.zzdk(paramString);
            this.zzcgj = null;
          }
          return super.shouldOverrideUrlLoading(paramWebView, paramString);
        }
      }
      if (this.zzdjo.getWebView().willNotDraw())
        break label384;
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
          zza(new zzc("android.intent.action.VIEW", localObject2.toString(), null, null, null, null, null));
      }
      catch (zzdi localzzdi)
      {
        Object localObject2;
        String str5 = String.valueOf(paramString);
        if (str5.length() != 0);
        for (String str6 = "Unable to append parameter to URL: ".concat(str5); ; str6 = new String("Unable to append parameter to URL: "))
        {
          zzaxa.zzep(str6);
          localObject2 = localObject1;
          break;
        }
        this.zzdaj.zzbk(paramString);
      }
    }
    label384: String str3 = String.valueOf(paramString);
    if (str3.length() != 0);
    for (String str4 = "AdWebView unable to handle URL: ".concat(str3); ; str4 = new String("AdWebView unable to handle URL: "))
    {
      zzaxa.zzep(str4);
      break;
    }
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

  public final void zza(zzbik paramzzbik)
  {
    this.zzejh = paramzzbik;
  }

  public final void zza(zzbil paramzzbil)
  {
    this.zzeji = paramzzbil;
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
    List localList;
    ArrayList localArrayList;
    synchronized (this.lock)
    {
      localList = (List)this.zzejg.get(paramString);
      if (localList == null)
        return;
      localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        zzahn localzzahn = (zzahn)localIterator.next();
        if (paramPredicate.apply(localzzahn))
          localArrayList.add(localzzahn);
      }
    }
    localList.removeAll(localArrayList);
  }

  public final void zza(String paramString, zzahn<? super zzbha> paramzzahn)
  {
    synchronized (this.lock)
    {
      Object localObject3 = (List)this.zzejg.get(paramString);
      if (localObject3 == null)
      {
        localObject3 = new CopyOnWriteArrayList();
        this.zzejg.put(paramString, localObject3);
      }
      ((List)localObject3).add(paramzzahn);
      return;
    }
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
      label95: localObject = new zzbhf(this.zzdjo, this.zzdko);
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
    label97: for (Object localObject = null; ; localObject = new zzbhf(this.zzdjo, this.zzdko))
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
    synchronized (this.lock)
    {
      boolean bool = this.zzbsz;
      return bool;
    }
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
    this.zzejs = new zzbhe(this, localzzavc);
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

  public final void zzb(String paramString, zzahn<? super zzbha> paramzzahn)
  {
    synchronized (this.lock)
    {
      List localList = (List)this.zzejg.get(paramString);
      if (localList == null)
        return;
      localList.remove(paramzzahn);
      return;
    }
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

  protected final WebResourceResponse zzd(String paramString, Map<String, String> paramMap)
  {
    try
    {
      String str = zzavy.zzd(paramString, this.zzdjo.getContext(), this.zzdom);
      if (!str.equals(paramString))
        return zze(str, paramMap);
      zzvt localzzvt = zzvt.zzbo(paramString);
      if (localzzvt != null)
      {
        zzvq localzzvq = zzk.zzlm().zza(localzzvt);
        if ((localzzvq != null) && (localzzvq.zznh()))
        {
          WebResourceResponse localWebResourceResponse1 = new WebResourceResponse("", "", localzzvq.zzni());
          return localWebResourceResponse1;
        }
      }
    }
    catch (Exception localException)
    {
      zzk.zzlk().zza(localException, "AdWebViewClient.interceptRequest");
      return zzabi();
      if (zzazy.isEnabled())
      {
        zzaci localzzaci = zzact.zzcqd;
        if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
        {
          WebResourceResponse localWebResourceResponse2 = zze(paramString, paramMap);
          return localWebResourceResponse2;
        }
      }
      return null;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      label94: break label94;
    }
  }

  public final void zzh(Uri paramUri)
  {
    String str1 = paramUri.getPath();
    List localList = (List)this.zzejg.get(str1);
    if (localList != null)
    {
      zzk.zzlg();
      Map localMap = zzaxj.zzi(paramUri);
      if (zzaxa.isLoggable(2))
      {
        String str3 = String.valueOf(str1);
        if (str3.length() != 0);
        for (String str4 = "Received GMSG: ".concat(str3); ; str4 = new String("Received GMSG: "))
        {
          zzaxa.zzds(str4);
          Iterator localIterator2 = localMap.keySet().iterator();
          while (localIterator2.hasNext())
          {
            String str5 = (String)localIterator2.next();
            String str6 = (String)localMap.get(str5);
            zzaxa.zzds(4 + String.valueOf(str5).length() + String.valueOf(str6).length() + "  " + str5 + ": " + str6);
          }
        }
      }
      Iterator localIterator1 = localList.iterator();
      while (localIterator1.hasNext())
        ((zzahn)localIterator1.next()).zza(this.zzdjo, localMap);
    }
    String str2 = String.valueOf(paramUri);
    zzaxa.zzds(32 + String.valueOf(str2).length() + "No GMSG handler found for GMSG: " + str2);
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
      zzbbn.zzeag.execute(new zzbhc(this));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbhb
 * JD-Core Version:    0.6.2
 */