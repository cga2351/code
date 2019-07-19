package com.viber.voip.notif.b.f.b;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.h.m;
import org.json.JSONException;

class x
{
  String a(Context paramContext, m paramm, a parama)
  {
    try
    {
      String str = parama.a(new FormattedMessage(paramm.c().getBody()).getPushText());
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return parama.b(paramContext.getString(R.string.message_notification_wink_text_content));
  }

  static abstract interface a
  {
    public abstract String a(String paramString);

    public abstract String b(String paramString);
  }

  static class b
    implements x.a
  {
    public String a(String paramString)
    {
      return paramString;
    }

    public String b(String paramString)
    {
      return paramString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.x
 * JD-Core Version:    0.6.2
 */