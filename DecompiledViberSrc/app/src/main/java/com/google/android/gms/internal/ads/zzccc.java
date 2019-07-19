package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

public final class zzccc extends zzafe
{
  private final zzbys zzfmq;
  private final zzbym zzfpj;
  private final zzbzk zzfse;
  private final Context zzys;

  public zzccc(Context paramContext, zzbys paramzzbys, zzbzk paramzzbzk, zzbym paramzzbym)
  {
    this.zzys = paramContext;
    this.zzfmq = paramzzbys;
    this.zzfse = paramzzbzk;
    this.zzfpj = paramzzbym;
  }

  public final void destroy()
  {
    this.zzfpj.destroy();
  }

  public final List<String> getAvailableAssetNames()
  {
    SimpleArrayMap localSimpleArrayMap1 = this.zzfmq.zzaic();
    SimpleArrayMap localSimpleArrayMap2 = this.zzfmq.zzaid();
    String[] arrayOfString = new String[localSimpleArrayMap1.size() + localSimpleArrayMap2.size()];
    int i = 0;
    int j = 0;
    int m;
    while (true)
    {
      int k = localSimpleArrayMap1.size();
      m = 0;
      if (i >= k)
        break;
      arrayOfString[j] = ((String)localSimpleArrayMap1.keyAt(i));
      int n = i + 1;
      j++;
      i = n;
    }
    while (m < localSimpleArrayMap2.size())
    {
      arrayOfString[j] = ((String)localSimpleArrayMap2.keyAt(m));
      m++;
      j++;
    }
    return Arrays.asList(arrayOfString);
  }

  public final String getCustomTemplateId()
  {
    return this.zzfmq.getCustomTemplateId();
  }

  public final zzaap getVideoController()
  {
    return this.zzfmq.getVideoController();
  }

  public final void performClick(String paramString)
  {
    this.zzfpj.zzfi(paramString);
  }

  public final void recordImpression()
  {
    this.zzfpj.zzahk();
  }

  public final String zzcj(String paramString)
  {
    return (String)this.zzfmq.zzaid().get(paramString);
  }

  public final zzaeh zzck(String paramString)
  {
    return (zzaeh)this.zzfmq.zzaic().get(paramString);
  }

  public final boolean zzp(IObjectWrapper paramIObjectWrapper)
  {
    Object localObject = ObjectWrapper.unwrap(paramIObjectWrapper);
    if (!(localObject instanceof ViewGroup))
      return false;
    if (!this.zzfse.zza((ViewGroup)localObject))
      return false;
    this.zzfmq.zzahz().zza(new zzccd(this));
    return true;
  }

  public final IObjectWrapper zzrh()
  {
    return null;
  }

  public final IObjectWrapper zzrm()
  {
    return ObjectWrapper.wrap(this.zzys);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzccc
 * JD-Core Version:    0.6.2
 */