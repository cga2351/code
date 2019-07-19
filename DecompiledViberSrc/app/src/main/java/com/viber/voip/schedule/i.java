package com.viber.voip.schedule;

import com.google.d.f;
import com.google.d.u;
import com.viber.voip.ViberApplication;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.messages.extensions.d.a.d;
import com.viber.voip.messages.extensions.d.b;
import com.viber.voip.settings.d.n;
import dagger.a;
import org.json.JSONException;

public class i extends h
{
  protected String a()
  {
    return ap.c().T;
  }

  protected void a(String paramString)
    throws JSONException
  {
    f localf = new f();
    try
    {
      d[] arrayOfd = (d[])localf.a(paramString, [Lcom.viber.voip.messages.extensions.d.a.d.class);
      ((b)ViberApplication.getInstance().getChatExSuggestionsManager().get()).a(arrayOfd);
      return;
    }
    catch (u localu)
    {
      throw new JSONException(localu.getMessage());
    }
  }

  protected com.viber.common.b.h b()
  {
    return d.n.n;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.i
 * JD-Core Version:    0.6.2
 */