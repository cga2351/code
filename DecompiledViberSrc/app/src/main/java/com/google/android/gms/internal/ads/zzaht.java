package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
@ParametersAreNonnullByDefault
public final class zzaht
  implements zzahn<Object>
{
  private final Object lock = new Object();

  @GuardedBy("lock")
  private final Map<String, zzahv> zzdaq = new HashMap();

  public final <EngineT extends zzakh> zzbbi<JSONObject> zza(EngineT paramEngineT, String paramString, JSONObject paramJSONObject)
  {
    zzbbs localzzbbs = new zzbbs();
    zzk.zzlg();
    String str = zzaxj.zzwb();
    zza(str, new zzahu(this, localzzbbs));
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", str);
      localJSONObject.put("args", paramJSONObject);
      paramEngineT.zzb(paramString, localJSONObject);
      return localzzbbs;
    }
    catch (Exception localException)
    {
      localzzbbs.setException(localException);
    }
    return localzzbbs;
  }

  public final void zza(Object paramObject, Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("id");
    String str2 = (String)paramMap.get("fail");
    String str3 = (String)paramMap.get("fail_reason");
    String str4 = (String)paramMap.get("fail_stack");
    String str5 = (String)paramMap.get("result");
    if (TextUtils.isEmpty(str4));
    for (String str6 = "Unknown Fail Reason."; ; str6 = str3)
    {
      String str8;
      if (TextUtils.isEmpty(str4))
        str8 = "";
      zzahv localzzahv;
      synchronized (this.lock)
      {
        while (true)
        {
          localzzahv = (zzahv)this.zzdaq.remove(str1);
          if (localzzahv != null)
            break label212;
          String str9 = String.valueOf(str1);
          if (str9.length() == 0)
            break;
          str10 = "Received result for unexpected method invocation: ".concat(str9);
          zzaxa.zzep(str10);
          return;
          String str7 = String.valueOf(str4);
          if (str7.length() != 0)
            str8 = "\n".concat(str7);
          else
            str8 = new String("\n");
        }
        String str10 = new String("Received result for unexpected method invocation: ");
      }
      label212: if (!TextUtils.isEmpty(str2))
      {
        String str13 = String.valueOf(str6);
        String str14 = String.valueOf(str8);
        if (str14.length() != 0);
        for (String str15 = str13.concat(str14); ; str15 = new String(str13))
        {
          localzzahv.onFailure(str15);
          return;
        }
      }
      if (str5 == null)
      {
        localzzahv.zzc(null);
        return;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject(str5);
        String str11;
        if (zzaxa.zzvj())
        {
          str11 = String.valueOf(localJSONObject.toString(2));
          if (str11.length() == 0)
            break label358;
        }
        label358: for (String str12 = "Result GMSG: ".concat(str11); ; str12 = new String("Result GMSG: "))
        {
          zzaxa.zzds(str12);
          localzzahv.zzc(localJSONObject);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        while (true)
          localzzahv.onFailure(localJSONException.getMessage());
      }
    }
  }

  public final void zza(String paramString, zzahv paramzzahv)
  {
    synchronized (this.lock)
    {
      this.zzdaq.put(paramString, paramzzahv);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaht
 * JD-Core Version:    0.6.2
 */