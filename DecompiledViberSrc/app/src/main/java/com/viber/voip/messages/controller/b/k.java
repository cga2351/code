package com.viber.voip.messages.controller.b;

import android.content.Context;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.e.a.e;
import com.viber.voip.messages.controller.bk;
import com.viber.voip.messages.controller.bk.c;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.dv;
import java.io.File;

public class k extends a
{
  private static final Logger d = ViberEnv.getLogger();
  private final ab e;
  private final o f;
  private final bk g;
  private final bk.c h;
  private final Engine i;
  private final x j;
  private final MessageEntity k;
  private final Uri l;

  public k(com.viber.voip.messages.extras.image.c paramc, Context paramContext, ab paramab, o paramo, bk parambk, bk.c paramc1, Engine paramEngine, x paramx, MessageEntity paramMessageEntity)
  {
    super(paramc, paramContext);
    this.e = paramab;
    this.f = paramo;
    this.g = parambk;
    this.h = paramc1;
    this.i = paramEngine;
    this.j = paramx;
    this.k = paramMessageEntity;
    this.l = Uri.parse(this.k.getMediaUri());
  }

  private dv l()
  {
    if (this.k.isWink())
      return dv.f;
    return dv.q;
  }

  private void m()
  {
    this.e.a("messages", this.k.getId(), "body", this.k.getBody());
    this.f.a(this.k.getConversationId(), this.k.getMessageToken(), false);
  }

  protected File a()
  {
    return dv.h.b(this.b, this.k.getMediaUri(), false);
  }

  protected void a(Uri paramUri)
  {
    String str = paramUri.toString();
    this.k.setBody(str);
    if (this.k.isBroadcastList())
      this.e.j(this.k.getId(), str);
  }

  protected Uri b()
  {
    return this.l;
  }

  protected void b(Uri paramUri)
  {
    super.b(paramUri);
    m();
    e.b().a("SEND_MESSAGE", "MesSendDelegate uploadMedia uploadMedia");
    this.g.a(this.k, paramUri, this.i.getPhoneController().isConnected(), this.h);
    e.b().b("SEND_MESSAGE", "MesSendDelegate uploadMedia uploadMedia");
  }

  protected String c()
  {
    return this.k.getMediaUri();
  }

  protected dv d()
  {
    if (this.k.isWink())
      return dv.e;
    return dv.h;
  }

  protected File e()
  {
    return l().b(this.b, this.l.toString(), true);
  }

  protected Uri f()
  {
    return l().a(this.b, this.l.toString(), true);
  }

  protected boolean g()
  {
    return (this.k.getMediaUri() != null) && (this.k.isMediaWithThumbnail()) && (this.k.getThumbnailUri() == null);
  }

  protected void h()
  {
    this.j.a(this.k);
  }

  protected void k()
  {
    this.j.b(this.k);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.k
 * JD-Core Version:    0.6.2
 */