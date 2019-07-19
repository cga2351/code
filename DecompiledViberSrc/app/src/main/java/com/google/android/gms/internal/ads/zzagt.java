package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
public final class zzagt
  implements zzahn<Object>
{
  private final zzagu zzczo;

  public zzagt(zzagu paramzzagu)
  {
    this.zzczo = paramzzagu;
  }

  private static Bundle zzb(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject == null)
      return null;
    Iterator localIterator = paramJSONObject.keys();
    Bundle localBundle1 = new Bundle();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      Object localObject1 = paramJSONObject.get(str1);
      if (localObject1 != null)
        if ((localObject1 instanceof Boolean))
        {
          localBundle1.putBoolean(str1, ((Boolean)localObject1).booleanValue());
        }
        else if ((localObject1 instanceof Double))
        {
          localBundle1.putDouble(str1, ((Double)localObject1).doubleValue());
        }
        else if ((localObject1 instanceof Integer))
        {
          localBundle1.putInt(str1, ((Integer)localObject1).intValue());
        }
        else if ((localObject1 instanceof Long))
        {
          localBundle1.putLong(str1, ((Long)localObject1).longValue());
        }
        else if ((localObject1 instanceof String))
        {
          localBundle1.putString(str1, (String)localObject1);
        }
        else if ((localObject1 instanceof JSONArray))
        {
          JSONArray localJSONArray = (JSONArray)localObject1;
          if ((localJSONArray != null) && (localJSONArray.length() != 0))
          {
            int i = localJSONArray.length();
            int j = 0;
            Object localObject2 = null;
            if ((localObject2 == null) && (j < i))
            {
              if (!localJSONArray.isNull(j));
              for (localObject2 = localJSONArray.get(j); ; localObject2 = null)
              {
                j++;
                break;
              }
            }
            if (localObject2 == null)
            {
              String str5 = String.valueOf(str1);
              if (str5.length() != 0);
              for (String str6 = "Expected JSONArray with at least 1 non-null element for key:".concat(str5); ; str6 = new String("Expected JSONArray with at least 1 non-null element for key:"))
              {
                zzaxa.zzep(str6);
                break;
              }
            }
            if ((localObject2 instanceof JSONObject))
            {
              Bundle[] arrayOfBundle = new Bundle[i];
              int i1 = 0;
              if (i1 < i)
              {
                if (!localJSONArray.isNull(i1));
                for (Bundle localBundle2 = zzb(localJSONArray.optJSONObject(i1)); ; localBundle2 = null)
                {
                  arrayOfBundle[i1] = localBundle2;
                  i1++;
                  break;
                }
              }
              localBundle1.putParcelableArray(str1, arrayOfBundle);
            }
            else if ((localObject2 instanceof Number))
            {
              double[] arrayOfDouble = new double[localJSONArray.length()];
              for (int n = 0; n < i; n++)
                arrayOfDouble[n] = localJSONArray.optDouble(n);
              localBundle1.putDoubleArray(str1, arrayOfDouble);
            }
            else if ((localObject2 instanceof CharSequence))
            {
              String[] arrayOfString = new String[i];
              int m = 0;
              if (m < i)
              {
                if (!localJSONArray.isNull(m));
                for (String str4 = localJSONArray.optString(m); ; str4 = null)
                {
                  arrayOfString[m] = str4;
                  m++;
                  break;
                }
              }
              localBundle1.putStringArray(str1, arrayOfString);
            }
            else if ((localObject2 instanceof Boolean))
            {
              boolean[] arrayOfBoolean = new boolean[i];
              for (int k = 0; k < i; k++)
                arrayOfBoolean[k] = localJSONArray.optBoolean(k);
              localBundle1.putBooleanArray(str1, arrayOfBoolean);
            }
            else
            {
              Object[] arrayOfObject = new Object[2];
              arrayOfObject[0] = localObject2.getClass().getCanonicalName();
              arrayOfObject[1] = str1;
              zzaxa.zzep(String.format("JSONArray with unsupported type %s for key:%s", arrayOfObject));
            }
          }
        }
        else if ((localObject1 instanceof JSONObject))
        {
          localBundle1.putBundle(str1, zzb((JSONObject)localObject1));
        }
        else
        {
          String str2 = String.valueOf(str1);
          if (str2.length() != 0);
          for (String str3 = "Unsupported type for key:".concat(str2); ; str3 = new String("Unsupported type for key:"))
          {
            zzaxa.zzep(str3);
            break;
          }
        }
    }
    return localBundle1;
  }

  public final void zza(Object paramObject, Map<String, String> paramMap)
  {
    if (this.zzczo == null)
      return;
    String str1 = (String)paramMap.get("name");
    if (str1 == null)
      zzaxa.zzeo("Ad metadata with no name parameter.");
    for (String str2 = ""; ; str2 = str1)
    {
      if (paramMap.containsKey("info"));
      while (true)
      {
        try
        {
          Bundle localBundle2 = zzb(new JSONObject((String)paramMap.get("info")));
          localBundle1 = localBundle2;
          if (localBundle1 == null)
          {
            zzaxa.zzen("Failed to convert ad metadata to Bundle.");
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          zzaxa.zzc("Failed to convert ad metadata to JSON.", localJSONException);
          localBundle1 = null;
          continue;
          this.zzczo.zza(str2, localBundle1);
          return;
        }
        Bundle localBundle1 = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagt
 * JD-Core Version:    0.6.2
 */