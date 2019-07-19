package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdbq
  implements zzdbu
{
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private final InputStream zzapv;
  private final JSONObject zzgpb;
  private boolean zzgpc = false;

  private zzdbq(InputStream paramInputStream)
  {
    this.zzapv = paramInputStream;
    this.zzgpb = null;
  }

  public static zzdbu zzf(InputStream paramInputStream)
    throws IOException
  {
    return new zzdbq(paramInputStream);
  }

  public final zzdgz zzanq()
    throws IOException
  {
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject(new String(zzdcg.zzg(this.zzapv), UTF_8));
      if ((!localJSONObject1.has("key")) || (localJSONObject1.getJSONArray("key").length() == 0))
        throw new JSONException("invalid keyset");
    }
    catch (JSONException localJSONException)
    {
      throw new IOException(localJSONException);
    }
    zzdgz.zza localzza = zzdgz.zzask();
    if (localJSONObject1.has("primaryKeyId"))
      localzza.zzes(localJSONObject1.getInt("primaryKeyId"));
    JSONArray localJSONArray = localJSONObject1.getJSONArray("key");
    int i = 0;
    if (i < localJSONArray.length())
    {
      JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
      if ((!localJSONObject2.has("keyData")) || (!localJSONObject2.has("status")) || (!localJSONObject2.has("keyId")) || (!localJSONObject2.has("outputPrefixType")))
        throw new JSONException("invalid key");
      zzdgz.zzb.zza localzza1 = zzdgz.zzb.zzasq();
      String str1 = localJSONObject2.getString("status");
      zzdgt localzzdgt;
      zzdgz.zzb.zza localzza2;
      String str4;
      zzdhl localzzdhl;
      if (str1.equals("ENABLED"))
      {
        localzzdgt = zzdgt.zzgul;
        localzza2 = localzza1.zzb(localzzdgt).zzeu(localJSONObject2.getInt("keyId"));
        str4 = localJSONObject2.getString("outputPrefixType");
        if (!str4.equals("TINK"))
          break label366;
        localzzdhl = zzdhl.zzgvr;
      }
      zzdgz.zzb.zza localzza3;
      JSONObject localJSONObject3;
      while (true)
      {
        localzza3 = localzza2.zzb(localzzdhl);
        localJSONObject3 = localJSONObject2.getJSONObject("keyData");
        if ((localJSONObject3.has("typeUrl")) && (localJSONObject3.has("value")) && (localJSONObject3.has("keyMaterialType")))
          break label468;
        throw new JSONException("invalid keyData");
        if (str1.equals("DISABLED"))
        {
          localzzdgt = zzdgt.zzgum;
          break;
        }
        String str2 = String.valueOf(str1);
        if (str2.length() != 0);
        for (String str3 = "unknown status: ".concat(str2); ; str3 = new String("unknown status: "))
          throw new JSONException(str3);
        label366: if (str4.equals("RAW"))
        {
          localzzdhl = zzdhl.zzgvt;
        }
        else if (str4.equals("LEGACY"))
        {
          localzzdhl = zzdhl.zzgvs;
        }
        else
        {
          if (!str4.equals("CRUNCHY"))
            break label420;
          localzzdhl = zzdhl.zzgvu;
        }
      }
      label420: String str5 = String.valueOf(str4);
      if (str5.length() != 0);
      for (String str6 = "unknown output prefix type: ".concat(str5); ; str6 = new String("unknown output prefix type: "))
        throw new JSONException(str6);
      label468: byte[] arrayOfByte = zzdjo.decode(localJSONObject3.getString("value"));
      zzdgq.zza localzza4 = zzdgq.zzarw().zzgk(localJSONObject3.getString("typeUrl")).zzbo(zzdmq.zzz(arrayOfByte));
      String str7 = localJSONObject3.getString("keyMaterialType");
      zzdgq.zzb localzzb;
      if (str7.equals("SYMMETRIC"))
        localzzb = zzdgq.zzb.zzgue;
      while (true)
      {
        localzza.zzb((zzdgz.zzb)localzza3.zzb((zzdgq)localzza4.zzb(localzzb).zzaya()).zzaya());
        i++;
        break;
        if (str7.equals("ASYMMETRIC_PRIVATE"))
        {
          localzzb = zzdgq.zzb.zzguf;
        }
        else if (str7.equals("ASYMMETRIC_PUBLIC"))
        {
          localzzb = zzdgq.zzb.zzgug;
        }
        else
        {
          if (!str7.equals("REMOTE"))
            break label625;
          localzzb = zzdgq.zzb.zzguh;
        }
      }
      label625: String str8 = String.valueOf(str7);
      if (str8.length() != 0);
      for (String str9 = "unknown key material type: ".concat(str8); ; str9 = new String("unknown key material type: "))
        throw new JSONException(str9);
    }
    zzdgz localzzdgz = (zzdgz)localzza.zzaya();
    return localzzdgz;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdbq
 * JD-Core Version:    0.6.2
 */