package com.viber.voip.engagement.c;

import com.google.d.f;
import com.google.d.g;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.engagement.data.c;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.PublicAccountMsgInfo;
import com.viber.voip.registration.af;
import com.viber.voip.util.bj;
import com.viber.voip.util.bk;
import com.viber.voip.util.da;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements a
{
  private static final Logger a = ViberEnv.getLogger();
  private final af b;
  private final Locale c;
  private final String d;
  private final f e;
  private final com.viber.voip.flatbuffers.b.a<MsgInfo> f;

  public b(af paramaf, Locale paramLocale, String paramString, com.viber.voip.flatbuffers.b.a<MsgInfo> parama)
  {
    this.b = paramaf;
    this.c = paramLocale;
    this.d = a(paramString);
    this.e = new g().a();
    this.f = parama;
  }

  private String a(String paramString)
  {
    String str = ap.c().Q;
    return str + paramString;
  }

  private String b(String paramString)
  {
    try
    {
      String str = bj.a(bj.a(paramString));
      return str;
    }
    catch (Exception localException)
    {
      a.a(localException, "[checkJson]");
      return null;
    }
    finally
    {
      bj.a(null);
    }
  }

  private com.viber.voip.engagement.data.a c(String paramString)
  {
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = bk.a(this.b, paramString, "media", "");
      if (localJSONObject1 == null)
        throw new JSONException("Engagement media data isn't found in json=" + paramString);
    }
    catch (JSONException localJSONException)
    {
      Logger localLogger = a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.d;
      arrayOfObject[1] = paramString;
      localLogger.a(localJSONException, String.format("parse can't parse json for marketing '%s' : '%s'", arrayOfObject));
      return null;
    }
    com.viber.voip.util.b.a locala = (com.viber.voip.util.b.a)this.e.a(localJSONObject1.toString(), com.viber.voip.util.b.a.class);
    if (locala == null)
      throw new JSONException("Engagement media data isn't parsed correctly from json=" + localJSONObject1.toString());
    JSONObject localJSONObject2 = bk.a(this.c, paramString, "strings", "");
    if (localJSONObject2 != null);
    for (com.viber.voip.engagement.data.b localb = (com.viber.voip.engagement.data.b)this.e.a(localJSONObject2.toString(), c.class); ; localb = null)
    {
      if (localJSONObject2 != null)
        locala.a(localJSONObject2.optString("rich_msg", null));
      com.viber.voip.engagement.data.a locala1 = new com.viber.voip.engagement.data.a(locala, localb);
      return locala1;
    }
  }

  private boolean d(String paramString)
  {
    return (da.a(paramString)) || (((MsgInfo)this.f.a(paramString)).getPublicAccountMsgInfo().getRichMedia() != null);
  }

  public com.viber.voip.engagement.data.a a()
  {
    String str = b(this.d);
    if (!da.a(str))
    {
      com.viber.voip.engagement.data.a locala = c(str);
      if ((locala != null) && (d(locala.a().g())))
        return locala;
      return null;
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.c.b
 * JD-Core Version:    0.6.2
 */