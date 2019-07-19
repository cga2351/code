package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zaan extends zaau
{
  private final Map<Api.Client, zaam> zagk;

  public zaan(Map<Api.Client, zaam> paramMap)
  {
    super(paramMap, null);
    Object localObject;
    this.zagk = localObject;
  }

  public final void zaan()
  {
    int i = 0;
    GoogleApiAvailabilityCache localGoogleApiAvailabilityCache = new GoogleApiAvailabilityCache(zaak.zab(this.zagi));
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator1 = this.zagk.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Api.Client localClient4 = (Api.Client)localIterator1.next();
      if ((localClient4.requiresGooglePlayServices()) && (!zaam.zaa((zaam)this.zagk.get(localClient4))))
        localArrayList1.add(localClient4);
      else
        localArrayList2.add(localClient4);
    }
    int j = -1;
    if (localArrayList1.isEmpty())
    {
      ArrayList localArrayList4 = (ArrayList)localArrayList2;
      int i1 = localArrayList4.size();
      while (i < i1)
      {
        Object localObject2 = localArrayList4.get(i);
        i++;
        Api.Client localClient3 = (Api.Client)localObject2;
        j = localGoogleApiAvailabilityCache.getClientAvailability(zaak.zaa(this.zagi), localClient3);
        if (j == 0)
          break label259;
      }
      label197: int n = j;
      if (n == 0)
        break label308;
      ConnectionResult localConnectionResult = new ConnectionResult(n, null);
      zaak.zad(this.zagi).zaa(new zaao(this, this.zagi, localConnectionResult));
    }
    while (true)
    {
      return;
      ArrayList localArrayList3 = (ArrayList)localArrayList1;
      int k = localArrayList3.size();
      int m = 0;
      label259: if (m >= k)
        break label197;
      Object localObject1 = localArrayList3.get(m);
      m++;
      Api.Client localClient1 = (Api.Client)localObject1;
      j = localGoogleApiAvailabilityCache.getClientAvailability(zaak.zaa(this.zagi), localClient1);
      if (j == 0)
        break;
      break label197;
      label308: if (zaak.zae(this.zagi))
        zaak.zaf(this.zagi).connect();
      Iterator localIterator2 = this.zagk.keySet().iterator();
      while (localIterator2.hasNext())
      {
        Api.Client localClient2 = (Api.Client)localIterator2.next();
        BaseGmsClient.ConnectionProgressReportCallbacks localConnectionProgressReportCallbacks = (BaseGmsClient.ConnectionProgressReportCallbacks)this.zagk.get(localClient2);
        if ((localClient2.requiresGooglePlayServices()) && (localGoogleApiAvailabilityCache.getClientAvailability(zaak.zaa(this.zagi), localClient2) != 0))
          zaak.zad(this.zagi).zaa(new zaap(this, this.zagi, localConnectionProgressReportCallbacks));
        else
          localClient2.connect(localConnectionProgressReportCallbacks);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaan
 * JD-Core Version:    0.6.2
 */