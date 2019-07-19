package com.google.android.gms.internal.ads;

import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzare
public final class zzaco
{
  private final Collection<zzaci<?>> zzckj = new ArrayList();
  private final Collection<zzaci<String>> zzckk = new ArrayList();
  private final Collection<zzaci<String>> zzckl = new ArrayList();

  public final void zza(SharedPreferences.Editor paramEditor, int paramInt, JSONObject paramJSONObject)
  {
    Iterator localIterator = this.zzckj.iterator();
    while (localIterator.hasNext())
    {
      zzaci localzzaci = (zzaci)localIterator.next();
      if (localzzaci.getSource() == 1)
        localzzaci.zza(paramEditor, localzzaci.zza(paramJSONObject));
    }
    if (paramJSONObject != null)
    {
      paramEditor.putString("flag_configuration", paramJSONObject.toString());
      return;
    }
    zzbae.zzen("Flag Json is null.");
  }

  public final void zza(zzaci paramzzaci)
  {
    this.zzckj.add(paramzzaci);
  }

  public final void zzb(zzaci<String> paramzzaci)
  {
    this.zzckk.add(paramzzaci);
  }

  public final void zzc(zzaci<String> paramzzaci)
  {
    this.zzckl.add(paramzzaci);
  }

  public final List<String> zzqn()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzckk.iterator();
    while (localIterator.hasNext())
    {
      zzaci localzzaci = (zzaci)localIterator.next();
      String str = (String)zzyr.zzpe().zzd(localzzaci);
      if (str != null)
        localArrayList.add(str);
    }
    return localArrayList;
  }

  public final List<String> zzqo()
  {
    List localList = zzqn();
    Iterator localIterator = this.zzckl.iterator();
    while (localIterator.hasNext())
    {
      zzaci localzzaci = (zzaci)localIterator.next();
      String str = (String)zzyr.zzpe().zzd(localzzaci);
      if (str != null)
        localList.add(str);
    }
    return localList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaco
 * JD-Core Version:    0.6.2
 */