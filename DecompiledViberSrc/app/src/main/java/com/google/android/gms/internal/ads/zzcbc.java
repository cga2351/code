package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzcbc
{
  private final Executor zzfiv;
  private final zzcat zzfqx;

  public zzcbc(Executor paramExecutor, zzcat paramzzcat)
  {
    this.zzfiv = paramExecutor;
    this.zzfqx = paramzzcat;
  }

  public final zzbbi<List<zzcbf>> zzg(JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    if (localJSONArray == null)
      return zzbas.zzm(Collections.emptyList());
    ArrayList localArrayList = new ArrayList();
    int i = localJSONArray.length();
    int j = 0;
    if (j < i)
    {
      JSONObject localJSONObject = localJSONArray.optJSONObject(j);
      String str1;
      String str2;
      int k;
      if (localJSONObject != null)
      {
        str1 = localJSONObject.optString("name");
        if (str1 != null)
        {
          str2 = localJSONObject.optString("type");
          if (!"string".equals(str2))
            break label138;
          k = 1;
        }
      }
      label91: Object localObject;
      switch (k)
      {
      default:
        localObject = zzbas.zzm(null);
      case 1:
      case 2:
      }
      while (true)
      {
        localArrayList.add(localObject);
        j++;
        break;
        label138: if ("image".equals(str2))
        {
          k = 2;
          break label91;
        }
        k = 0;
        break label91;
        localObject = zzbas.zzm(new zzcbf(str1, localJSONObject.optString("string_value")));
        continue;
        localObject = zzbas.zza(this.zzfqx.zzc(localJSONObject, "image_value"), new zzcbe(str1), this.zzfiv);
      }
    }
    return zzbas.zza(zzbas.zze(localArrayList), zzcbd.zzdrp, this.zzfiv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcbc
 * JD-Core Version:    0.6.2
 */