package com.yandex.metrica.impl.ob;

import android.location.Location;
import android.text.TextUtils;
import com.yandex.metrica.impl.bu;
import org.json.JSONException;
import org.json.JSONObject;

class ik
{
  public static ic a(long paramLong, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        long l = localJSONObject.optLong("receive_timestamp", 0L);
        hp.a locala = hp.a.a(localJSONObject.optString("collection_mode"));
        Location localLocation = new Location(localJSONObject.optString("provider", null));
        localLocation.setLongitude(localJSONObject.optDouble("lon", 0.0D));
        localLocation.setLatitude(localJSONObject.optDouble("lat", 0.0D));
        localLocation.setTime(localJSONObject.optLong("timestamp", 0L));
        localLocation.setAccuracy((float)localJSONObject.optDouble("precision", 0.0D));
        localLocation.setBearing((float)localJSONObject.optDouble("direction", 0.0D));
        localLocation.setSpeed((float)localJSONObject.optDouble("speed", 0.0D));
        localLocation.setAltitude(localJSONObject.optDouble("altitude", 0.0D));
        ic localic = new ic(locala, l, localLocation, Long.valueOf(paramLong));
        return localic;
      }
      catch (JSONException localJSONException)
      {
      }
    return null;
  }

  public static String a(hv paramhv)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("timestamp", paramhv.b());
      localJSONObject.putOpt("wifi_info", paramhv.c());
      localJSONObject.putOpt("cell_info", paramhv.d());
      String str = localJSONObject.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public static String a(ic paramic)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.putOpt("collection_mode", paramic.a.toString());
      localJSONObject.put("lat", paramic.c().getLatitude());
      localJSONObject.put("lon", paramic.c().getLongitude());
      localJSONObject.putOpt("timestamp", Long.valueOf(paramic.c().getTime()));
      localJSONObject.putOpt("receive_timestamp", Long.valueOf(paramic.b()));
      Float localFloat1;
      Float localFloat2;
      label134: Float localFloat3;
      if (paramic.c().hasAccuracy())
      {
        localFloat1 = Float.valueOf(paramic.c().getAccuracy());
        localJSONObject.putOpt("precision", localFloat1);
        if (!paramic.c().hasBearing())
          break label238;
        localFloat2 = Float.valueOf(paramic.c().getBearing());
        localJSONObject.putOpt("direction", localFloat2);
        if (!paramic.c().hasSpeed())
          break label244;
        localFloat3 = Float.valueOf(paramic.c().getSpeed());
        label165: localJSONObject.putOpt("speed", localFloat3);
        if (!paramic.c().hasAltitude())
          break label250;
      }
      label238: label244: label250: for (Double localDouble = Double.valueOf(paramic.c().getAltitude()); ; localDouble = null)
      {
        localJSONObject.putOpt("altitude", localDouble);
        localJSONObject.putOpt("provider", bu.c(paramic.c().getProvider(), null));
        String str = localJSONObject.toString();
        return str;
        localFloat1 = null;
        break;
        localFloat2 = null;
        break label134;
        localFloat3 = null;
        break label165;
      }
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  // ERROR //
  public static hv b(long paramLong, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 14	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +73 -> 77
    //   7: new 104	com/yandex/metrica/impl/ob/hv
    //   10: dup
    //   11: invokespecial 198	com/yandex/metrica/impl/ob/hv:<init>	()V
    //   14: astore_3
    //   15: aload_3
    //   16: lload_0
    //   17: invokestatic 95	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: invokevirtual 201	com/yandex/metrica/impl/ob/hv:a	(Ljava/lang/Long;)V
    //   23: new 16	org/json/JSONObject
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 20	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore 5
    //   33: aload_3
    //   34: aload 5
    //   36: ldc 62
    //   38: lconst_0
    //   39: invokevirtual 26	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   42: invokevirtual 203	com/yandex/metrica/impl/ob/hv:a	(J)V
    //   45: aload_3
    //   46: aload 5
    //   48: ldc 124
    //   50: invokevirtual 207	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   53: invokevirtual 210	com/yandex/metrica/impl/ob/hv:b	(Lorg/json/JSONArray;)V
    //   56: aload_3
    //   57: aload 5
    //   59: ldc 114
    //   61: invokevirtual 207	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   64: invokevirtual 212	com/yandex/metrica/impl/ob/hv:a	(Lorg/json/JSONArray;)V
    //   67: aload_3
    //   68: areturn
    //   69: astore 6
    //   71: aconst_null
    //   72: areturn
    //   73: astore 4
    //   75: aload_3
    //   76: areturn
    //   77: aconst_null
    //   78: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   7	15	69	org/json/JSONException
    //   15	67	73	org/json/JSONException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ik
 * JD-Core Version:    0.6.2
 */