package com.viber.voip.util.c;

import com.viber.voip.util.da;
import java.io.IOException;
import org.json.JSONObject;

public class a extends IOException
{
  private String a = null;

  public a(String paramString)
  {
    super(paramString);
  }

  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("response code ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" {");
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (localJSONObject1 != null)
      {
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("Trace");
        if (localJSONObject2 != null)
        {
          String str1 = localJSONObject2.optString("Call-Result");
          String str2 = localJSONObject2.optString("Call-Details");
          if (!da.a(str1))
          {
            localStringBuilder.append(str1);
            localStringBuilder.append(" ");
          }
          if (!da.a(str2))
            localStringBuilder.append(str2);
        }
      }
      label112: localStringBuilder.append("}");
      this.a = localStringBuilder.toString();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label112;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.c.a
 * JD-Core Version:    0.6.2
 */