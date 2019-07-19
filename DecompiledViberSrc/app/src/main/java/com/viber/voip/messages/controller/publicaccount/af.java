package com.viber.voip.messages.controller.publicaccount;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.a;
import com.viber.voip.messages.extensions.c;
import com.viber.voip.publicaccount.d.e;
import com.viber.voip.util.ar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class af
  implements bv.a
{
  private static final Logger a = ViberEnv.getLogger();
  private BotReplyConfig b;
  private Map<String, BotReplyConfig> c;
  private bv d;
  private final c e;
  private long f;

  public af(bv parambv, c paramc)
  {
    this.d = parambv;
    this.e = paramc;
    this.d.a(this);
    this.c = Collections.synchronizedMap(new ar(e.a));
  }

  private void c()
  {
    Iterator localIterator = this.e.n().iterator();
    while (localIterator.hasNext())
      c((String)localIterator.next());
  }

  private String d(String paramString)
  {
    if (this.f == -1L)
      return paramString;
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(this.f);
    arrayOfObject[1] = paramString;
    return String.format(localLocale, "%d_%s", arrayOfObject);
  }

  public void a()
  {
    c();
    this.f = -1L;
  }

  public void a(long paramLong)
  {
    this.f = paramLong;
  }

  public void a(String paramString)
  {
  }

  public void a(String paramString, BotReplyConfig paramBotReplyConfig)
  {
    if (e.b(paramString))
    {
      this.b = paramBotReplyConfig;
      return;
    }
    this.c.put(d(paramString), paramBotReplyConfig);
  }

  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
  }

  public BotReplyConfig b(String paramString)
  {
    if (e.b(paramString))
      return this.b;
    return (BotReplyConfig)this.c.get(d(paramString));
  }

  public void b()
  {
    if (!this.c.isEmpty())
      this.c.clear();
  }

  public void c(String paramString)
  {
    this.c.remove(d(paramString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.publicaccount.af
 * JD-Core Version:    0.6.2
 */