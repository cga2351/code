package com.google.android.gms.internal.ads;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@zzare
public final class zzali
  implements zzajr, zzalh
{
  private final zzalg zzdde;
  private final HashSet<AbstractMap.SimpleEntry<String, zzahn<? super zzalg>>> zzddf;

  public zzali(zzalg paramzzalg)
  {
    this.zzdde = paramzzalg;
    this.zzddf = new HashSet();
  }

  public final void zza(String paramString, zzahn<? super zzalg> paramzzahn)
  {
    this.zzdde.zza(paramString, paramzzahn);
    this.zzddf.add(new AbstractMap.SimpleEntry(paramString, paramzzahn));
  }

  public final void zza(String paramString, Map paramMap)
  {
    zzajs.zza(this, paramString, paramMap);
  }

  public final void zza(String paramString, JSONObject paramJSONObject)
  {
    zzajs.zzb(this, paramString, paramJSONObject);
  }

  public final void zzb(String paramString, zzahn<? super zzalg> paramzzahn)
  {
    this.zzdde.zzb(paramString, paramzzahn);
    this.zzddf.remove(new AbstractMap.SimpleEntry(paramString, paramzzahn));
  }

  public final void zzb(String paramString, JSONObject paramJSONObject)
  {
    zzajs.zza(this, paramString, paramJSONObject);
  }

  public final void zzco(String paramString)
  {
    this.zzdde.zzco(paramString);
  }

  public final void zzi(String paramString1, String paramString2)
  {
    zzajs.zza(this, paramString1, paramString2);
  }

  public final void zzsb()
  {
    Iterator localIterator = this.zzddf.iterator();
    if (localIterator.hasNext())
    {
      AbstractMap.SimpleEntry localSimpleEntry = (AbstractMap.SimpleEntry)localIterator.next();
      String str1 = String.valueOf(((zzahn)localSimpleEntry.getValue()).toString());
      if (str1.length() != 0);
      for (String str2 = "Unregistering eventhandler: ".concat(str1); ; str2 = new String("Unregistering eventhandler: "))
      {
        zzaxa.zzds(str2);
        this.zzdde.zzb((String)localSimpleEntry.getKey(), (zzahn)localSimpleEntry.getValue());
        break;
      }
    }
    this.zzddf.clear();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzali
 * JD-Core Version:    0.6.2
 */