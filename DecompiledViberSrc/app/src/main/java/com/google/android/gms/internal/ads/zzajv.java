package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public class zzajv<ReferenceT>
  implements zzaju
{
  private final Map<String, CopyOnWriteArrayList<zzahn<? super ReferenceT>>> zzdbp = new HashMap();
  private ReferenceT zzdbq;

  private final void zzb(String paramString, Map<String, String> paramMap)
  {
    while (true)
    {
      try
      {
        if (!zzaxa.isLoggable(2))
          break;
        String str1 = String.valueOf(paramString);
        if (str1.length() != 0)
        {
          str2 = "Received GMSG: ".concat(str1);
          zzaxa.zzds(str2);
          Iterator localIterator2 = paramMap.keySet().iterator();
          if (!localIterator2.hasNext())
            break;
          String str3 = (String)localIterator2.next();
          String str4 = (String)paramMap.get(str3);
          zzaxa.zzds(4 + String.valueOf(str3).length() + String.valueOf(str4).length() + "  " + str3 + ": " + str4);
          continue;
        }
      }
      finally
      {
      }
      String str2 = new String("Received GMSG: ");
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.zzdbp.get(paramString);
    if (localCopyOnWriteArrayList != null)
    {
      Iterator localIterator1 = localCopyOnWriteArrayList.iterator();
      while (localIterator1.hasNext())
      {
        zzahn localzzahn = (zzahn)localIterator1.next();
        zzbbn.zzeag.execute(new zzajw(this, localzzahn, paramMap));
      }
    }
  }

  public final void reset()
  {
    try
    {
      this.zzdbp.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zza(String paramString, Predicate<zzahn<? super ReferenceT>> paramPredicate)
  {
    while (true)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList;
      ArrayList localArrayList;
      try
      {
        localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.zzdbp.get(paramString);
        if (localCopyOnWriteArrayList == null)
          return;
        localArrayList = new ArrayList();
        Iterator localIterator = localCopyOnWriteArrayList.iterator();
        if (localIterator.hasNext())
        {
          zzahn localzzahn = (zzahn)localIterator.next();
          if (!paramPredicate.apply(localzzahn))
            continue;
          localArrayList.add(localzzahn);
          continue;
        }
      }
      finally
      {
      }
      localCopyOnWriteArrayList.removeAll(localArrayList);
    }
  }

  public final void zza(String paramString, zzahn<? super ReferenceT> paramzzahn)
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.zzdbp.get(paramString);
      if (localCopyOnWriteArrayList == null)
      {
        localCopyOnWriteArrayList = new CopyOnWriteArrayList();
        this.zzdbp.put(paramString, localCopyOnWriteArrayList);
      }
      localCopyOnWriteArrayList.add(paramzzahn);
      return;
    }
    finally
    {
    }
  }

  public final void zzb(String paramString, zzahn<? super ReferenceT> paramzzahn)
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.zzdbp.get(paramString);
      if (localCopyOnWriteArrayList == null);
      while (true)
      {
        return;
        localCopyOnWriteArrayList.remove(paramzzahn);
      }
    }
    finally
    {
    }
  }

  public final boolean zzcs(String paramString)
  {
    return (paramString != null) && (zzg(Uri.parse(paramString)));
  }

  public final void zzg(ReferenceT paramReferenceT)
  {
    this.zzdbq = paramReferenceT;
  }

  public final boolean zzg(Uri paramUri)
  {
    if (("gmsg".equalsIgnoreCase(paramUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(paramUri.getHost())))
    {
      zzh(paramUri);
      return true;
    }
    return false;
  }

  public final void zzh(Uri paramUri)
  {
    String str = paramUri.getPath();
    zzk.zzlg();
    zzb(str, zzaxj.zzi(paramUri));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzajv
 * JD-Core Version:    0.6.2
 */