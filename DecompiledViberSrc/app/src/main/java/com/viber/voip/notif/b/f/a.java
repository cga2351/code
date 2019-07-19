package com.viber.voip.notif.b.f;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.c.t;
import com.viber.voip.notif.f.b;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.ViberActionRunner.am;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.ViberActionRunner.bm;
import com.viber.voip.util.cd;
import com.viber.voip.util.dg;

public abstract class a extends com.viber.voip.notif.d.c
{
  protected final com.viber.voip.notif.h.m a;
  protected final com.viber.voip.notif.b.f.b.e b;
  protected final String c;

  public a(com.viber.voip.notif.h.m paramm, com.viber.voip.notif.b.f.b.e parame)
  {
    this.a = paramm;
    this.b = parame;
    this.c = dg.a(paramm.d(), paramm.e().j(), paramm.e().p());
  }

  private Intent h(Context paramContext)
  {
    MessageEntity localMessageEntity = this.a.c();
    h localh = this.a.e();
    com.viber.voip.model.entity.m localm = this.a.d();
    com.viber.voip.notif.h.n localn = this.a.f();
    boolean bool;
    String str;
    if ((localn == null) || (!localn.e()))
    {
      bool = true;
      str = dg.b(localh.o());
      if (!localh.b())
        break label123;
    }
    while (true)
    {
      Intent localIntent = ViberActionRunner.bm.a(paramContext, localMessageEntity.getConversationId(), localMessageEntity.getConversationType(), localMessageEntity.getId(), str, localh.p(), localMessageEntity.isSecretMessage(), bool, false);
      localIntent.putExtra("navigated_to_conversation_on_back", true);
      return localIntent;
      bool = false;
      break;
      label123: str = localm.a(localh);
    }
  }

  private String h()
  {
    com.viber.voip.model.entity.m localm = this.a.d();
    if (localm.i() > 0L);
    for (String str1 = localm.getNumber(); ; str1 = null)
    {
      String str2 = null;
      if (str1 != null)
        str2 = "tel:" + str1;
      return str2;
    }
  }

  public String R_()
  {
    return "message";
  }

  public int a()
  {
    return -100;
  }

  protected void a(Context paramContext, o paramo)
  {
    com.viber.voip.notif.c.n[] arrayOfn = new com.viber.voip.notif.c.n[5];
    arrayOfn[0] = paramo.a(this.a.c().getDate());
    arrayOfn[1] = b(paramContext, paramo);
    arrayOfn[2] = paramo.b(paramContext, e(), c(paramContext), 134217728);
    arrayOfn[3] = paramo.a(paramContext, this.a.hashCode(), ViberActionRunner.am.b(paramContext, this.a.g()), 134217728);
    arrayOfn[4] = paramo.b("msg");
    a(arrayOfn);
    String str = h();
    if (str != null)
      a(paramo.c(str));
  }

  protected void a(Context paramContext, o paramo, com.viber.voip.notif.f.e parame)
  {
    a(b(paramContext, paramo, parame));
  }

  public int b()
  {
    return R.drawable.status_unread_message;
  }

  protected com.viber.voip.notif.c.n b(Context paramContext, o paramo, com.viber.voip.notif.f.e parame)
  {
    return paramo.a(((b)parame.a(3)).a(this.a.e(), this.a.d()));
  }

  protected t b(Context paramContext, o paramo)
  {
    if (this.b != null)
      return paramo.b(this.b.c());
    return paramo.a(b_(paramContext), b(paramContext));
  }

  public CharSequence b(Context paramContext)
  {
    if (this.b != null)
      return this.b.b();
    return "";
  }

  public CharSequence b_(Context paramContext)
  {
    if (this.b != null)
      return this.b.a();
    return "";
  }

  protected Intent c(Context paramContext)
  {
    if (this.a.k() > 1)
      return ViberActionRunner.ab.a(paramContext);
    if (this.a.j() > 1)
      return e(paramContext);
    switch (this.a.c().getMimeType())
    {
    case 2:
    default:
      return e(paramContext);
    case 1:
    case 3:
    }
    return h(paramContext);
  }

  public com.viber.voip.notif.c d()
  {
    return com.viber.voip.notif.c.a;
  }

  protected int e()
  {
    return (int)this.a.c().getConversationId();
  }

  protected final Intent e(Context paramContext)
  {
    if ((this.a.e().d()) && (this.a.f() != null) && (!this.a.f().d()))
    {
      Intent localIntent = ViberActionRunner.aq.c(paramContext, this.a.f().b());
      localIntent.putExtra("notif_extra_token", this.a.c().getMessageToken());
      return localIntent;
    }
    int i;
    long l1;
    long l2;
    String str1;
    label161: String str2;
    label179: int j;
    String str3;
    if ((!this.a.e().b()) && (!this.a.d().isOwner()))
    {
      i = 1;
      l1 = this.a.c().getConversationId();
      l2 = this.a.c().getGroupId();
      if (i == 0)
        break label312;
      str1 = this.a.d().a();
      if (i == 0)
        break label318;
      str2 = this.a.d().getNumber();
      j = this.a.e().j();
      if (i == 0)
        break label324;
      str3 = this.a.d().getViberName();
      label211: if (i == 0)
        break label330;
    }
    label312: label318: label324: label330: for (String str4 = this.a.d().getContactName(); ; str4 = null)
    {
      return com.viber.voip.messages.m.a(l1, 0L, 0L, l2, str1, str2, j, str3, str4, this.a.e().o(), this.a.j(), false, false, this.a.e().R(), this.a.e().aj(), this.a.e().ao());
      i = 0;
      break;
      str1 = null;
      break label161;
      str2 = null;
      break label179;
      str3 = null;
      break label211;
    }
  }

  protected boolean f()
  {
    h localh = this.a.e();
    return ((!localh.E()) || (localh.F())) && (!localh.ao()) && (cd.g(localh.p()));
  }

  protected boolean g()
  {
    MessageEntity localMessageEntity = this.a.c();
    return (this.a.e().b()) && (!localMessageEntity.isPoll()) && ((!localMessageEntity.isPinMessage()) || (localMessageEntity.isPinMessageWithToken()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.a
 * JD-Core Version:    0.6.2
 */