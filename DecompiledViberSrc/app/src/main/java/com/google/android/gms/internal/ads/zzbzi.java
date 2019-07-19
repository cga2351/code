package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzbzi extends zzaem
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcaa
{
  public static final String[] zzfpm = { "2011", "1009", "3010" };
  private FrameLayout zzbqi;
  private boolean zzela = false;

  @GuardedBy("this")
  private zzbym zzfpj;
  private zzty zzfpk;
  private final String zzfpl;

  @GuardedBy("this")
  private Map<String, WeakReference<View>> zzfpn = new HashMap();
  private FrameLayout zzfpo;
  private zzbbm zzfpp;
  private View zzfpq;

  public zzbzi(FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    this.zzfpo = paramFrameLayout1;
    this.zzbqi = paramFrameLayout2;
    String str1 = paramFrameLayout1.getClass().getCanonicalName();
    String str2;
    if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(str1))
      str2 = "1007";
    while (true)
    {
      this.zzfpl = str2;
      zzk.zzmd();
      zzbca.zza(paramFrameLayout1, this);
      zzk.zzmd();
      zzbca.zza(paramFrameLayout1, this);
      this.zzfpp = zzbbn.zzeai;
      this.zzfpk = new zzty(this.zzfpo.getContext(), this.zzfpo);
      paramFrameLayout1.setOnTouchListener(this);
      paramFrameLayout1.setOnClickListener(this);
      return;
      if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(str1))
      {
        str2 = "2009";
      }
      else
      {
        "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(str1);
        str2 = "3012";
      }
    }
  }

  private final void zzaix()
  {
    try
    {
      this.zzfpp.execute(new zzbzj(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void destroy()
  {
    try
    {
      boolean bool = this.zzela;
      if (bool);
      while (true)
      {
        return;
        if (this.zzfpj != null)
        {
          this.zzfpj.zzb(this);
          this.zzfpj = null;
        }
        this.zzfpn.clear();
        this.zzfpo.removeAllViews();
        this.zzbqi.removeAllViews();
        this.zzfpn = null;
        this.zzfpo = null;
        this.zzbqi = null;
        this.zzfpq = null;
        this.zzfpk = null;
        this.zzela = true;
      }
    }
    finally
    {
    }
  }

  public final void onClick(View paramView)
  {
    try
    {
      if (this.zzfpj != null)
      {
        this.zzfpj.cancelUnconfirmedClick();
        this.zzfpj.zza(paramView, (FrameLayout)this.zzfpo, zzait(), zzaiu(), false);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onGlobalLayout()
  {
    try
    {
      if (this.zzfpj != null)
        this.zzfpj.zzb((FrameLayout)this.zzfpo, zzait(), zzaiu(), zzbym.zzx((FrameLayout)this.zzfpo));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onScrollChanged()
  {
    try
    {
      if (this.zzfpj != null)
        this.zzfpj.zzb((FrameLayout)this.zzfpo, zzait(), zzaiu(), zzbym.zzx((FrameLayout)this.zzfpo));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    try
    {
      if (this.zzfpj != null)
        this.zzfpj.zza(paramView, paramMotionEvent, (FrameLayout)this.zzfpo);
      return false;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(String paramString, View paramView, boolean paramBoolean)
  {
    while (true)
    {
      try
      {
        boolean bool = this.zzela;
        if (bool)
          return;
        if (paramView == null)
        {
          this.zzfpn.remove(paramString);
          continue;
        }
      }
      finally
      {
      }
      this.zzfpn.put(paramString, new WeakReference(paramView));
      if ((!"1098".equals(paramString)) && (!"3011".equals(paramString)))
      {
        paramView.setOnTouchListener(this);
        paramView.setClickable(true);
        paramView.setOnClickListener(this);
      }
    }
  }

  public final FrameLayout zzair()
  {
    return this.zzbqi;
  }

  public final zzty zzais()
  {
    return this.zzfpk;
  }

  public final Map<String, WeakReference<View>> zzait()
  {
    try
    {
      Map localMap = this.zzfpn;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final Map<String, WeakReference<View>> zzaiu()
  {
    try
    {
      Map localMap = this.zzfpn;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Nullable
  public final Map<String, WeakReference<View>> zzaiv()
  {
    return null;
  }

  public final String zzaiw()
  {
    try
    {
      String str = this.zzfpl;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzc(IObjectWrapper paramIObjectWrapper, int paramInt)
  {
  }

  public final void zzc(String paramString, IObjectWrapper paramIObjectWrapper)
  {
    try
    {
      zza(paramString, (View)ObjectWrapper.unwrap(paramIObjectWrapper), true);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final IObjectWrapper zzcf(String paramString)
  {
    try
    {
      IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(zzfp(paramString));
      return localIObjectWrapper;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zze(IObjectWrapper paramIObjectWrapper)
  {
    while (true)
    {
      Object localObject2;
      try
      {
        boolean bool = this.zzela;
        if (bool)
          return;
        localObject2 = ObjectWrapper.unwrap(paramIObjectWrapper);
        if (!(localObject2 instanceof zzbym))
        {
          zzaxa.zzep("Not an instance of native engine. This is most likely a transient error");
          continue;
        }
      }
      finally
      {
      }
      if (this.zzfpj != null)
        this.zzfpj.zzb(this);
      zzaix();
      this.zzfpj = ((zzbym)localObject2);
      this.zzfpj.zza(this);
      this.zzfpj.zzy(this.zzfpo);
    }
  }

  public final View zzfp(String paramString)
  {
    try
    {
      boolean bool = this.zzela;
      View localView;
      if (bool)
        localView = null;
      while (true)
      {
        return localView;
        WeakReference localWeakReference = (WeakReference)this.zzfpn.get(paramString);
        if (localWeakReference == null)
          localView = null;
        else
          localView = (View)localWeakReference.get();
      }
    }
    finally
    {
    }
  }

  public final void zzi(IObjectWrapper paramIObjectWrapper)
  {
    try
    {
      this.zzfpj.setClickConfirmingView((View)ObjectWrapper.unwrap(paramIObjectWrapper));
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzbzi
 * JD-Core Version:    0.6.2
 */