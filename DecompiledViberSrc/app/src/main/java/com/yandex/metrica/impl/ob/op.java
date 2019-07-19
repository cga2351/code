package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.f;
import org.json.JSONException;
import org.json.JSONObject;

public class op
{
  public static f a(String paramString)
  {
    f localf = new f();
    if (!TextUtils.isEmpty(paramString));
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localf.a(localJSONObject.optString("UserInfo.UserId", null));
      localf.b(localJSONObject.optString("UserInfo.Type", null));
      localf.a(nz.a(localJSONObject.optJSONObject("UserInfo.Options")));
      return localf;
    }
    catch (JSONException localJSONException)
    {
    }
    return localf;
  }

  public static String a(a parama)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.putOpt("action", parama.toString());
      String str = localJSONObject.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public static enum a
  {
    private String e;

    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }

    private a(String paramString)
    {
      this.e = paramString;
    }

    public String toString()
    {
      return this.e;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.op
 * JD-Core Version:    0.6.2
 */