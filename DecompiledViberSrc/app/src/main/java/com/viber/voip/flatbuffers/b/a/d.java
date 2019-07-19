package com.viber.voip.flatbuffers.b.a;

import android.text.TextUtils;
import android.util.Log;
import com.google.d.f;
import com.google.d.g;
import com.google.d.p;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.b.b;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  implements a<ConferenceInfo>, b<ConferenceInfo>
{
  private static f a()
  {
    return new g().a();
  }

  public String a(ConferenceInfo paramConferenceInfo)
  {
    if (paramConferenceInfo == null)
      return "{}";
    try
    {
      String str = a().b(paramConferenceInfo);
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

  public ConferenceInfo c(String paramString)
  {
    ConferenceInfo localConferenceInfo;
    if ((TextUtils.isEmpty(paramString)) || ("{}".equals(paramString)))
      localConferenceInfo = new ConferenceInfo();
    while (true)
    {
      return localConferenceInfo;
      try
      {
        localConferenceInfo = (ConferenceInfo)a().a(paramString, ConferenceInfo.class);
        if (localConferenceInfo != null)
          continue;
        Log.w("ConferenceInfoGsonParse", "Unable to parse ConferenceInfo from json: " + paramString);
        return new ConferenceInfo();
      }
      catch (p localp)
      {
        while (true)
          localConferenceInfo = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.b.a.d
 * JD-Core Version:    0.6.2
 */