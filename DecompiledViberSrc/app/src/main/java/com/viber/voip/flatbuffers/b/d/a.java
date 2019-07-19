package com.viber.voip.flatbuffers.b.d;

import com.google.d.f;
import com.google.d.g;
import com.google.d.p;
import com.viber.voip.flatbuffers.b.b;
import com.viber.voip.flatbuffers.model.publicaccount.MyCommunitySettings;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements com.viber.voip.flatbuffers.b.a<MyCommunitySettings>, b<MyCommunitySettings>
{
  private volatile f a;

  private f a()
  {
    if (this.a == null);
    try
    {
      if (this.a == null)
        this.a = new g().a();
      return this.a;
    }
    finally
    {
    }
  }

  public String a(MyCommunitySettings paramMyCommunitySettings)
  {
    if (paramMyCommunitySettings == null)
      return "{}";
    try
    {
      String str = a().b(paramMyCommunitySettings);
      return str;
    }
    catch (p localp)
    {
    }
    return "{}";
  }

  public JSONObject b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public MyCommunitySettings c(String paramString)
  {
    try
    {
      MyCommunitySettings localMyCommunitySettings = (MyCommunitySettings)a().a(paramString, MyCommunitySettings.class);
      return localMyCommunitySettings;
    }
    catch (p localp)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.b.d.a
 * JD-Core Version:    0.6.2
 */