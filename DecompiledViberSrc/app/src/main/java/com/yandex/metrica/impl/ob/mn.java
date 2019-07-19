package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mn
{
  public final long a;
  public final String b;
  public final List<Integer> c;

  public mn(long paramLong, String paramString, List<Integer> paramList)
  {
    this.a = paramLong;
    this.b = paramString;
    this.c = Collections.unmodifiableList(paramList);
  }

  public static mn a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
        return null;
      JSONObject localJSONObject = new JSONObject(paramString);
      mn localmn = new mn(localJSONObject.getLong("seconds_to_live"), localJSONObject.getString("token"), a(localJSONObject.getJSONArray("ports")));
      return localmn;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  private static ArrayList<Integer> a(JSONArray paramJSONArray)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList(paramJSONArray.length());
    for (int i = 0; i < paramJSONArray.length(); i++)
      localArrayList.add(Integer.valueOf(paramJSONArray.getInt(i)));
    return localArrayList;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    mn localmn;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localmn = (mn)paramObject;
      if (this.a != localmn.a)
        return false;
      if (this.b != null)
      {
        if (this.b.equals(localmn.b));
      }
      else
        while (localmn.b != null)
          return false;
      if (this.c != null)
        return this.c.equals(localmn.c);
    }
    while (localmn.c == null);
    return false;
  }

  public int hashCode()
  {
    int i = 31 * (int)(this.a ^ this.a >>> 32);
    if (this.b != null);
    for (int j = this.b.hashCode(); ; j = 0)
    {
      int k = 31 * (j + i);
      List localList = this.c;
      int m = 0;
      if (localList != null)
        m = this.c.hashCode();
      return k + m;
    }
  }

  public String toString()
  {
    return "SocketConfig{secondsToLive=" + this.a + ", token='" + this.b + '\'' + ", ports=" + this.c + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.mn
 * JD-Core Version:    0.6.2
 */