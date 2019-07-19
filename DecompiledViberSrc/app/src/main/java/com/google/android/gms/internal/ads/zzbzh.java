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
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzare
@ParametersAreNonnullByDefault
public final class zzbzh extends zzaer
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcaa
{
  private final WeakReference<View> zzfpf;
  private final Map<String, WeakReference<View>> zzfpg = new HashMap();
  private final Map<String, WeakReference<View>> zzfph = new HashMap();
  private final Map<String, WeakReference<View>> zzfpi = new HashMap();

  @GuardedBy("this")
  private zzbym zzfpj;
  private zzty zzfpk;

  public zzbzh(View paramView, HashMap<String, View> paramHashMap1, HashMap<String, View> paramHashMap2)
  {
    paramView.setOnTouchListener(this);
    paramView.setOnClickListener(this);
    zzk.zzmd();
    zzbca.zza(paramView, this);
    zzk.zzmd();
    zzbca.zza(paramView, this);
    this.zzfpf = new WeakReference(paramView);
    Iterator localIterator1 = paramHashMap1.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
      String str = (String)localEntry2.getKey();
      View localView2 = (View)localEntry2.getValue();
      if (localView2 != null)
      {
        this.zzfpg.put(str, new WeakReference(localView2));
        if ((!"1098".equals(str)) && (!"3011".equals(str)))
        {
          localView2.setOnTouchListener(this);
          localView2.setClickable(true);
          localView2.setOnClickListener(this);
        }
      }
    }
    this.zzfpi.putAll(this.zzfpg);
    Iterator localIterator2 = paramHashMap2.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
      View localView1 = (View)localEntry1.getValue();
      if (localView1 != null)
      {
        this.zzfph.put((String)localEntry1.getKey(), new WeakReference(localView1));
        localView1.setOnTouchListener(this);
        localView1.setClickable(false);
      }
    }
    this.zzfpi.putAll(this.zzfph);
    this.zzfpk = new zzty(paramView.getContext(), paramView);
  }

  public final void onClick(View paramView)
  {
    try
    {
      if (this.zzfpj != null)
        this.zzfpj.zza(paramView, zzafi(), zzait(), zzaiu(), true);
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
        this.zzfpj.zzb(zzafi(), zzait(), zzaiu(), zzbym.zzx(zzafi()));
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
        this.zzfpj.zzb(zzafi(), zzait(), zzaiu(), zzbym.zzx(zzafi()));
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
        this.zzfpj.zza(paramView, paramMotionEvent, zzafi());
      return false;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void unregisterNativeAd()
  {
    try
    {
      if (this.zzfpj != null)
      {
        this.zzfpj.zzb(this);
        this.zzfpj = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(String paramString, View paramView, boolean paramBoolean)
  {
    if (paramView == null);
    try
    {
      this.zzfpi.remove(paramString);
      this.zzfpg.remove(paramString);
      this.zzfph.remove(paramString);
      while (true)
      {
        return;
        this.zzfpi.put(paramString, new WeakReference(paramView));
        if ((!"1098".equals(paramString)) && (!"3011".equals(paramString)))
        {
          this.zzfpg.put(paramString, new WeakReference(paramView));
          paramView.setClickable(true);
          paramView.setOnClickListener(this);
          paramView.setOnTouchListener(this);
        }
      }
    }
    finally
    {
    }
  }

  @Nullable
  public final View zzafi()
  {
    return (View)this.zzfpf.get();
  }

  @Nullable
  public final FrameLayout zzair()
  {
    return null;
  }

  public final zzty zzais()
  {
    return this.zzfpk;
  }

  public final Map<String, WeakReference<View>> zzait()
  {
    try
    {
      Map localMap = this.zzfpi;
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
      Map localMap = this.zzfpg;
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
    try
    {
      Map localMap = this.zzfph;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String zzaiw()
  {
    return "1007";
  }

  public final void zze(IObjectWrapper paramIObjectWrapper)
  {
    while (true)
    {
      try
      {
        Object localObject2 = ObjectWrapper.unwrap(paramIObjectWrapper);
        if (!(localObject2 instanceof zzbym))
        {
          zzaxa.zzep("Not an instance of InternalNativeAd. This is most likely a transient error");
          return;
        }
        if (this.zzfpj != null)
          this.zzfpj.zzb(this);
        if (((zzbym)localObject2).zzahs())
        {
          this.zzfpj = ((zzbym)localObject2);
          this.zzfpj.zza(this);
          this.zzfpj.zzy(zzafi());
          continue;
        }
      }
      finally
      {
      }
      zzaxa.zzen("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }
  }

  public final View zzfp(String paramString)
  {
    try
    {
      WeakReference localWeakReference = (WeakReference)this.zzfpi.get(paramString);
      if (localWeakReference == null);
      for (View localView = null; ; localView = (View)localWeakReference.get())
        return localView;
    }
    finally
    {
    }
  }

  public final void zzi(IObjectWrapper paramIObjectWrapper)
  {
    try
    {
      if (this.zzfpj != null)
      {
        Object localObject2 = ObjectWrapper.unwrap(paramIObjectWrapper);
        if (!(localObject2 instanceof View))
          zzaxa.zzep("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
        this.zzfpj.setClickConfirmingView((View)localObject2);
      }
      return;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbzh
 * JD-Core Version:    0.6.2
 */