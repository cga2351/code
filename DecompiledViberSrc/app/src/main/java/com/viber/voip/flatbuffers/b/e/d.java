package com.viber.voip.flatbuffers.b.e;

import android.text.TextUtils;
import android.util.Log;
import com.google.d.f;
import com.google.d.g;
import com.google.d.p;
import com.viber.voip.flatbuffers.b.a;
import com.viber.voip.flatbuffers.b.b;
import com.viber.voip.flatbuffers.c.w;
import com.viber.voip.flatbuffers.c.x;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.flatbuffers.model.util.UnsignedInt;
import com.viber.voip.flatbuffers.model.util.UnsignedLong;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  implements a<QuotedMessageData>, b<QuotedMessageData>
{
  private static f a()
  {
    g localg = new g();
    localg.a(UnsignedInt.class, new w());
    localg.a(UnsignedLong.class, new x());
    return localg.a();
  }

  public String a(QuotedMessageData paramQuotedMessageData)
  {
    if (paramQuotedMessageData == null)
      return "{}";
    try
    {
      String str = a().b(paramQuotedMessageData);
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

  public QuotedMessageData c(String paramString)
  {
    QuotedMessageData localQuotedMessageData;
    if ((TextUtils.isEmpty(paramString)) || ("{}".equals(paramString)))
      localQuotedMessageData = new QuotedMessageData();
    while (true)
    {
      return localQuotedMessageData;
      try
      {
        localQuotedMessageData = (QuotedMessageData)a().a(paramString, QuotedMessageData.class);
        if (localQuotedMessageData != null)
          continue;
        Log.w("MsgInfoGsonParser", "Unable to parse MessageInfo from json: " + paramString);
        return new QuotedMessageData();
      }
      catch (p localp)
      {
        while (true)
          localQuotedMessageData = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.flatbuffers.b.e.d
 * JD-Core Version:    0.6.2
 */