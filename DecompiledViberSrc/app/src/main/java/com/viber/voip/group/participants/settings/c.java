package com.viber.voip.group.participants.settings;

import android.content.Context;
import com.viber.voip.messages.conversation.adapter.a.c.a.e;
import java.util.Map;

public class c extends e
{
  private Map<String, ? extends b> a;
  private b b;

  public c(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1, paramInt2);
  }

  public b a()
  {
    return this.b;
  }

  public b a(String paramString)
  {
    return (b)this.a.get(paramString);
  }

  public void a(b paramb)
  {
    this.b = paramb;
  }

  public void a(Map<String, ? extends b> paramMap)
  {
    this.a = paramMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.settings.c
 * JD-Core Version:    0.6.2
 */