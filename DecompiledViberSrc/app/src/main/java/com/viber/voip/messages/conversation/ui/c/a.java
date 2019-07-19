package com.viber.voip.messages.conversation.ui.c;

import android.content.Context;
import android.util.Base64;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.voip.ViberApplication;
import com.viber.voip.i.c.h;
import com.viber.voip.i.f;
import com.viber.voip.messages.orm.entity.json.Language;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.bd;
import com.viber.voip.user.UserManager;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private final Context a;
  private af b;
  private List<Language> c;

  public a(Context paramContext, af paramaf)
  {
    this.a = paramContext;
    this.b = paramaf;
  }

  public String a()
  {
    return "+" + ViberApplication.getInstance().getUserManager().getRegistrationValues().b();
  }

  public List<Language> a(com.viber.voip.messages.translation.a parama)
  {
    if (this.c == null)
      this.c = parama.a(this.a);
    return this.c;
  }

  public JSONObject a(long paramLong, byte[] paramArrayOfByte, MessageEntity paramMessageEntity)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("udid", this.b.a().a());
    localJSONObject.put("phone", this.b.g());
    localJSONObject.put("authToken", Base64.encodeToString(paramArrayOfByte, 2));
    localJSONObject.put("tokenTS", paramLong);
    localJSONObject.put("query", paramMessageEntity.getBody());
    localJSONObject.put("targetLang", f());
    return localJSONObject;
  }

  public void a(String paramString)
  {
    d.bd.d.a(paramString);
  }

  public Language b(String paramString)
  {
    List localList = a(com.viber.voip.messages.translation.a.a);
    int i = localList.size();
    for (int j = 0; j < i; j++)
    {
      Language localLanguage = (Language)localList.get(j);
      if (paramString.equals(localLanguage.getCode()))
        return localLanguage;
    }
    return null;
  }

  public boolean b()
  {
    return c.h.e.e();
  }

  public void c()
  {
    d.bd.c.a(false);
  }

  public void d()
  {
    d.bd.a.a(false);
  }

  public boolean e()
  {
    return d.bd.c.d();
  }

  public String f()
  {
    return d.bd.d.d();
  }

  public boolean g()
  {
    return d.bd.a.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.c.a
 * JD-Core Version:    0.6.2
 */