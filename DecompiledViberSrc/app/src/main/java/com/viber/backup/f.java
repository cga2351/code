package com.viber.backup;

import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.b;
import com.viber.voip.util.da;
import org.json.JSONException;
import org.json.JSONObject;

class f extends a
{
  private static final Logger a = ViberEnv.getLogger();

  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      return;
    String str1 = new String(paramArrayOfByte);
    try
    {
      JSONObject localJSONObject = new JSONObject(str1);
      String str2 = localJSONObject.getString("code");
      String str3 = localJSONObject.getString("number");
      d.b.a.a(str2);
      d.b.b.a(str3);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  public byte[] a()
  {
    af localaf = new af();
    String str1 = localaf.b();
    String str2 = localaf.f();
    if ((da.a(str1)) || ("0".equals(str1)) || (da.a(str2)) || ("0".equals(str2)))
      return null;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", str1);
      localJSONObject.put("number", str2);
      byte[] arrayOfByte = localJSONObject.toString().getBytes();
      return arrayOfByte;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public String b()
  {
    return "last_registered_code_number";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.f
 * JD-Core Version:    0.6.2
 */