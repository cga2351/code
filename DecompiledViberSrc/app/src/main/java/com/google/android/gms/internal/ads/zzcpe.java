package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcpe
{
  private final Executor zzfiv;
  private final zzclb zzfvd;
  private final Map<String, zzcpj> zzgdg = new ConcurrentHashMap();
  private final Map<String, List<zzcpj>> zzgdh = new ConcurrentHashMap();
  private final Context zzlj;

  public zzcpe(zzclb paramzzclb, Executor paramExecutor, Context paramContext)
  {
    this.zzfvd = paramzzclb;
    this.zzfiv = paramExecutor;
    this.zzlj = paramContext;
  }

  private final void zzaky()
  {
    while (true)
    {
      int k;
      int i1;
      try
      {
        JSONObject localJSONObject1 = zzk.zzlk().zzvc().zzvr().zzuv();
        int i;
        String str1;
        String str2;
        ArrayList localArrayList1;
        int j;
        JSONObject localJSONObject4;
        ArrayList localArrayList2;
        Bundle localBundle;
        if (localJSONObject1 != null)
          try
          {
            JSONArray localJSONArray1 = localJSONObject1.optJSONArray("ad_unit_id_settings");
            if (localJSONArray1 != null)
            {
              i = 0;
              if (i < localJSONArray1.length())
              {
                JSONObject localJSONObject2 = localJSONArray1.getJSONObject(i);
                str1 = localJSONObject2.optString("ad_unit_id", "");
                str2 = localJSONObject2.optString("format", "");
                localArrayList1 = new ArrayList();
                JSONObject localJSONObject3 = localJSONObject2.optJSONObject("mediation_config");
                if (localJSONObject3 == null)
                  continue;
                JSONArray localJSONArray2 = localJSONObject3.optJSONArray("ad_networks");
                if (localJSONArray2 == null)
                  continue;
                j = 0;
                if (j >= localJSONArray2.length())
                  continue;
                localJSONObject4 = localJSONArray2.getJSONObject(j);
                localArrayList2 = new ArrayList();
                if (localJSONObject4 == null)
                  continue;
                JSONObject localJSONObject5 = localJSONObject4.optJSONObject("data");
                localBundle = new Bundle();
                if (localJSONObject5 == null)
                  continue;
                Iterator localIterator = localJSONObject5.keys();
                if (!localIterator.hasNext())
                  continue;
                String str5 = (String)localIterator.next();
                localBundle.putString(str5, localJSONObject5.optString(str5, ""));
                continue;
              }
            }
          }
          catch (JSONException localJSONException)
          {
            zzaxa.zza("Malformed config loading JSON.", localJSONException);
          }
        else
          return;
        JSONArray localJSONArray3 = localJSONObject4.optJSONArray("rtb_adapters");
        if (localJSONArray3 != null)
        {
          ArrayList localArrayList3 = new ArrayList();
          k = 0;
          if (k < localJSONArray3.length())
          {
            String str4 = localJSONArray3.optString(k, "");
            if (TextUtils.isEmpty(str4))
              break label451;
            localArrayList3.add(str4);
            break label451;
          }
          ArrayList localArrayList4 = (ArrayList)localArrayList3;
          int m = localArrayList4.size();
          n = 0;
          if (n < m)
          {
            Object localObject2 = localArrayList4.get(n);
            i1 = n + 1;
            String str3 = (String)localObject2;
            zzfr(str3);
            zzcpj localzzcpj = (zzcpj)this.zzgdg.get(str3);
            if (localzzcpj == null)
              break label457;
            localArrayList2.add(new zzcpj(str3, str2, localBundle, localzzcpj.zzgdj));
            break label457;
          }
        }
        localArrayList1.addAll(localArrayList2);
        j++;
        continue;
        if (!TextUtils.isEmpty(str1))
          this.zzgdh.put(str1, localArrayList1);
        i++;
        continue;
      }
      finally
      {
      }
      label451: k++;
      continue;
      label457: int n = i1;
    }
  }

  public final void zzakw()
  {
    zzk.zzlk().zzvc().zzb(new zzcpf(this));
    this.zzfiv.execute(new zzcpg(this));
  }

  public final Map<String, List<zzcpj>> zzakx()
  {
    return this.zzgdh;
  }

  public final void zzfr(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    while (this.zzgdg.containsKey(paramString))
      return;
    try
    {
      zzaow localzzaow = this.zzfvd.zzcy(paramString);
      this.zzgdg.put(paramString, new zzcpj(paramString, "", new Bundle(), localzzaow));
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcpe
 * JD-Core Version:    0.6.2
 */