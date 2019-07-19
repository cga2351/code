package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

public final class zzbys
{
  private Bundle extras;
  private zzadz zzcyo;
  private List<zzabi> zzczc = Collections.emptyList();
  private List<zzadv> zzenf;
  private double zzeni;
  private IObjectWrapper zzfig;
  private int zzfog;
  private zzaap zzfoh;
  private View zzfoi;
  private zzabi zzfoj;
  private zzbha zzfok;
  private zzbha zzfol;
  private View zzfom;
  private IObjectWrapper zzfon;
  private zzaeh zzfoo;
  private zzaeh zzfop;
  private String zzfoq;
  private SimpleArrayMap<String, zzadv> zzfor = new SimpleArrayMap();
  private SimpleArrayMap<String, String> zzfos = new SimpleArrayMap();
  private float zzfot;

  private static zzbys zza(zzaap paramzzaap, zzadz paramzzadz, View paramView1, String paramString1, List paramList, String paramString2, Bundle paramBundle, String paramString3, View paramView2, IObjectWrapper paramIObjectWrapper, String paramString4, String paramString5, double paramDouble, zzaeh paramzzaeh, String paramString6, float paramFloat)
  {
    zzbys localzzbys = new zzbys();
    localzzbys.zzfog = 6;
    localzzbys.zzfoh = paramzzaap;
    localzzbys.zzcyo = paramzzadz;
    localzzbys.zzfoi = paramView1;
    localzzbys.zzp("headline", paramString1);
    localzzbys.zzenf = paramList;
    localzzbys.zzp("body", paramString2);
    localzzbys.extras = paramBundle;
    localzzbys.zzp("call_to_action", paramString3);
    localzzbys.zzfom = paramView2;
    localzzbys.zzfon = paramIObjectWrapper;
    localzzbys.zzp("store", paramString4);
    localzzbys.zzp("price", paramString5);
    localzzbys.zzeni = paramDouble;
    localzzbys.zzfoo = paramzzaeh;
    localzzbys.zzp("advertiser", paramString6);
    localzzbys.zzf(paramFloat);
    return localzzbys;
  }

  public static zzbys zza(zzanb paramzzanb)
  {
    try
    {
      zzaap localzzaap = paramzzanb.getVideoController();
      zzadz localzzadz = paramzzanb.zzrj();
      View localView1 = (View)zzao(paramzzanb.zzso());
      String str1 = paramzzanb.getHeadline();
      List localList = paramzzanb.getImages();
      String str2 = paramzzanb.getBody();
      Bundle localBundle = paramzzanb.getExtras();
      String str3 = paramzzanb.getCallToAction();
      View localView2 = (View)zzao(paramzzanb.zzsp());
      IObjectWrapper localIObjectWrapper = paramzzanb.zzrk();
      String str4 = paramzzanb.getStore();
      String str5 = paramzzanb.getPrice();
      double d = paramzzanb.getStarRating();
      zzaeh localzzaeh = paramzzanb.zzri();
      zzbys localzzbys = new zzbys();
      localzzbys.zzfog = 2;
      localzzbys.zzfoh = localzzaap;
      localzzbys.zzcyo = localzzadz;
      localzzbys.zzfoi = localView1;
      localzzbys.zzp("headline", str1);
      localzzbys.zzenf = localList;
      localzzbys.zzp("body", str2);
      localzzbys.extras = localBundle;
      localzzbys.zzp("call_to_action", str3);
      localzzbys.zzfom = localView2;
      localzzbys.zzfon = localIObjectWrapper;
      localzzbys.zzp("store", str4);
      localzzbys.zzp("price", str5);
      localzzbys.zzeni = d;
      localzzbys.zzfoo = localzzaeh;
      return localzzbys;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Failed to get native ad from app install ad mapper", localRemoteException);
    }
    return null;
  }

  public static zzbys zza(zzane paramzzane)
  {
    try
    {
      zzaap localzzaap = paramzzane.getVideoController();
      zzadz localzzadz = paramzzane.zzrj();
      View localView1 = (View)zzao(paramzzane.zzso());
      String str1 = paramzzane.getHeadline();
      List localList = paramzzane.getImages();
      String str2 = paramzzane.getBody();
      Bundle localBundle = paramzzane.getExtras();
      String str3 = paramzzane.getCallToAction();
      View localView2 = (View)zzao(paramzzane.zzsp());
      IObjectWrapper localIObjectWrapper = paramzzane.zzrk();
      String str4 = paramzzane.getAdvertiser();
      zzaeh localzzaeh = paramzzane.zzrl();
      zzbys localzzbys = new zzbys();
      localzzbys.zzfog = 1;
      localzzbys.zzfoh = localzzaap;
      localzzbys.zzcyo = localzzadz;
      localzzbys.zzfoi = localView1;
      localzzbys.zzp("headline", str1);
      localzzbys.zzenf = localList;
      localzzbys.zzp("body", str2);
      localzzbys.extras = localBundle;
      localzzbys.zzp("call_to_action", str3);
      localzzbys.zzfom = localView2;
      localzzbys.zzfon = localIObjectWrapper;
      localzzbys.zzp("advertiser", str4);
      localzzbys.zzfop = localzzaeh;
      return localzzbys;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Failed to get native ad from content ad mapper", localRemoteException);
    }
    return null;
  }

  private static <T> T zzao(IObjectWrapper paramIObjectWrapper)
  {
    if (paramIObjectWrapper == null)
      return null;
    return ObjectWrapper.unwrap(paramIObjectWrapper);
  }

  public static zzbys zzb(zzanb paramzzanb)
  {
    try
    {
      zzbys localzzbys = zza(paramzzanb.getVideoController(), paramzzanb.zzrj(), (View)zzao(paramzzanb.zzso()), paramzzanb.getHeadline(), paramzzanb.getImages(), paramzzanb.getBody(), paramzzanb.getExtras(), paramzzanb.getCallToAction(), (View)zzao(paramzzanb.zzsp()), paramzzanb.zzrk(), paramzzanb.getStore(), paramzzanb.getPrice(), paramzzanb.getStarRating(), paramzzanb.zzri(), null, 0.0F);
      return localzzbys;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Failed to get native ad assets from app install ad mapper", localRemoteException);
    }
    return null;
  }

  public static zzbys zzb(zzane paramzzane)
  {
    try
    {
      zzbys localzzbys = zza(paramzzane.getVideoController(), paramzzane.zzrj(), (View)zzao(paramzzane.zzso()), paramzzane.getHeadline(), paramzzane.getImages(), paramzzane.getBody(), paramzzane.getExtras(), paramzzane.getCallToAction(), (View)zzao(paramzzane.zzsp()), paramzzane.zzrk(), null, null, -1.0D, paramzzane.zzrl(), paramzzane.getAdvertiser(), 0.0F);
      return localzzbys;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Failed to get native ad assets from content ad mapper", localRemoteException);
    }
    return null;
  }

  public static zzbys zzb(zzanh paramzzanh)
  {
    try
    {
      zzbys localzzbys = zza(paramzzanh.getVideoController(), paramzzanh.zzrj(), (View)zzao(paramzzanh.zzso()), paramzzanh.getHeadline(), paramzzanh.getImages(), paramzzanh.getBody(), paramzzanh.getExtras(), paramzzanh.getCallToAction(), (View)zzao(paramzzanh.zzsp()), paramzzanh.zzrk(), paramzzanh.getStore(), paramzzanh.getPrice(), paramzzanh.getStarRating(), paramzzanh.zzri(), paramzzanh.getAdvertiser(), paramzzanh.zzsq());
      return localzzbys;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Failed to get native ad assets from unified ad mapper", localRemoteException);
    }
    return null;
  }

  private final void zzf(float paramFloat)
  {
    try
    {
      this.zzfot = paramFloat;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private final String zzfm(String paramString)
  {
    try
    {
      String str = (String)this.zzfos.get(paramString);
      return str;
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
      if (this.zzfok != null)
      {
        this.zzfok.destroy();
        this.zzfok = null;
      }
      if (this.zzfol != null)
      {
        this.zzfol.destroy();
        this.zzfol = null;
      }
      this.zzfig = null;
      this.zzfor.clear();
      this.zzfos.clear();
      this.zzfoh = null;
      this.zzcyo = null;
      this.zzfoi = null;
      this.zzenf = null;
      this.extras = null;
      this.zzfom = null;
      this.zzfon = null;
      this.zzfoo = null;
      this.zzfop = null;
      this.zzfoq = null;
      return;
    }
    finally
    {
    }
  }

  public final String getAdvertiser()
  {
    try
    {
      String str = zzfm("advertiser");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String getBody()
  {
    try
    {
      String str = zzfm("body");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String getCallToAction()
  {
    try
    {
      String str = zzfm("call_to_action");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String getCustomTemplateId()
  {
    try
    {
      String str = this.zzfoq;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final Bundle getExtras()
  {
    try
    {
      if (this.extras == null)
        this.extras = new Bundle();
      Bundle localBundle = this.extras;
      return localBundle;
    }
    finally
    {
    }
  }

  public final String getHeadline()
  {
    try
    {
      String str = zzfm("headline");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final List<zzadv> getImages()
  {
    try
    {
      List localList = this.zzenf;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final List<zzabi> getMuteThisAdReasons()
  {
    try
    {
      List localList = this.zzczc;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String getPrice()
  {
    try
    {
      String str = zzfm("price");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final double getStarRating()
  {
    try
    {
      double d = this.zzeni;
      return d;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final String getStore()
  {
    try
    {
      String str = zzfm("store");
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final zzaap getVideoController()
  {
    try
    {
      zzaap localzzaap = this.zzfoh;
      return localzzaap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void setImages(List<zzadv> paramList)
  {
    try
    {
      this.zzenf = paramList;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void setStarRating(double paramDouble)
  {
    try
    {
      this.zzeni = paramDouble;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzabi paramzzabi)
  {
    try
    {
      this.zzfoj = paramzzabi;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzadz paramzzadz)
  {
    try
    {
      this.zzcyo = paramzzadz;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(zzaeh paramzzaeh)
  {
    try
    {
      this.zzfoo = paramzzaeh;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(String paramString, zzadv paramzzadv)
  {
    if (paramzzadv == null);
    try
    {
      this.zzfor.remove(paramString);
      while (true)
      {
        return;
        this.zzfor.put(paramString, paramzzadv);
      }
    }
    finally
    {
    }
  }

  public final int zzahv()
  {
    try
    {
      int i = this.zzfog;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final View zzahw()
  {
    try
    {
      View localView = this.zzfoi;
      return localView;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final zzabi zzahx()
  {
    try
    {
      zzabi localzzabi = this.zzfoj;
      return localzzabi;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final View zzahy()
  {
    try
    {
      View localView = this.zzfom;
      return localView;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final zzbha zzahz()
  {
    try
    {
      zzbha localzzbha = this.zzfok;
      return localzzbha;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final zzbha zzaia()
  {
    try
    {
      zzbha localzzbha = this.zzfol;
      return localzzbha;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final IObjectWrapper zzaib()
  {
    try
    {
      IObjectWrapper localIObjectWrapper = this.zzfig;
      return localIObjectWrapper;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final SimpleArrayMap<String, zzadv> zzaic()
  {
    try
    {
      SimpleArrayMap localSimpleArrayMap = this.zzfor;
      return localSimpleArrayMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final SimpleArrayMap<String, String> zzaid()
  {
    try
    {
      SimpleArrayMap localSimpleArrayMap = this.zzfos;
      return localSimpleArrayMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzan(IObjectWrapper paramIObjectWrapper)
  {
    try
    {
      this.zzfig = paramIObjectWrapper;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzb(zzaap paramzzaap)
  {
    try
    {
      this.zzfoh = paramzzaap;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzb(zzaeh paramzzaeh)
  {
    try
    {
      this.zzfop = paramzzaeh;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzdn(int paramInt)
  {
    try
    {
      this.zzfog = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zze(List<zzabi> paramList)
  {
    try
    {
      this.zzczc = paramList;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzfl(String paramString)
  {
    try
    {
      this.zzfoq = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzh(zzbha paramzzbha)
  {
    try
    {
      this.zzfok = paramzzbha;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzi(zzbha paramzzbha)
  {
    try
    {
      this.zzfol = paramzzbha;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzp(String paramString1, String paramString2)
  {
    if (paramString2 == null);
    try
    {
      this.zzfos.remove(paramString1);
      while (true)
      {
        return;
        this.zzfos.put(paramString1, paramString2);
      }
    }
    finally
    {
    }
  }

  public final zzaeh zzri()
  {
    try
    {
      zzaeh localzzaeh = this.zzfoo;
      return localzzaeh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final zzadz zzrj()
  {
    try
    {
      zzadz localzzadz = this.zzcyo;
      return localzzadz;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final IObjectWrapper zzrk()
  {
    try
    {
      IObjectWrapper localIObjectWrapper = this.zzfon;
      return localIObjectWrapper;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final zzaeh zzrl()
  {
    try
    {
      zzaeh localzzaeh = this.zzfop;
      return localzzaeh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final float zzsq()
  {
    try
    {
      float f = this.zzfot;
      return f;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzz(View paramView)
  {
    try
    {
      this.zzfom = paramView;
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzbys
 * JD-Core Version:    0.6.2
 */