package com.viber.voip.market;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s
{
  private static final Logger b = ViberEnv.getLogger();
  protected final a a;
  private final String c;
  private long d;

  public s(String paramString, a parama)
  {
    this.c = paramString;
    this.a = parama;
  }

  public void a()
  {
  }

  public void a(long paramLong)
  {
    this.d = paramLong;
  }

  protected void a(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      for (int i = 0; ; i++)
        if (i < paramArrayOfObject.length)
        {
          Object localObject = paramArrayOfObject[i];
          if (localObject == null)
            localJSONArray.put(i, null);
          else if ((localObject instanceof Integer))
            localJSONArray.put(i, (Integer)localObject);
          else if ((localObject instanceof Long))
            localJSONArray.put(i, (Long)localObject);
          else if ((localObject instanceof Double))
            localJSONArray.put(i, (Double)localObject);
          else if ((localObject instanceof String))
            localJSONArray.put(i, (String)localObject);
          else if ((localObject instanceof JSONObject))
            localJSONArray.put(i, localObject);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.c).append('.').append(paramString).append('(');
          if (localJSONArray.length() > 0)
          {
            String str2 = localJSONArray.toString();
            localStringBuilder.append(str2.substring(1, -1 + str2.length()));
          }
          localStringBuilder.append(')');
          String str1 = localStringBuilder.toString();
          this.a.g(str1);
          return;
        }
    }
    catch (JSONException localJSONException)
    {
    }
  }

  public void b()
  {
  }

  public void c()
  {
  }

  public long d()
  {
    return this.d;
  }

  public static abstract interface a
  {
    public abstract void g(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.s
 * JD-Core Version:    0.6.2
 */