package com.viber.voip.messages.conversation.adapter;

import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.b;
import com.viber.voip.messages.conversation.adapter.a.c;
import com.viber.voip.messages.d.l;
import com.viber.voip.user.UserData;

public class i
  implements a
{
  private final aa a;
  private final l b;
  private final boolean c;
  private final boolean d;
  private final boolean e;
  private final boolean f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  private final boolean k;
  private final boolean l;
  private final boolean m;
  private final c n;

  public i(aa paramaa, UserData paramUserData, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11)
  {
    this.a = paramaa;
    this.b = new l(paramaa);
    this.c = paramBoolean1;
    this.d = paramBoolean2;
    this.e = paramBoolean3;
    this.f = paramBoolean4;
    this.g = paramBoolean5;
    this.h = paramBoolean6;
    this.i = paramBoolean7;
    this.j = paramBoolean8;
    this.k = paramBoolean9;
    this.l = paramBoolean10;
    this.m = paramBoolean11;
    this.n = new c(paramaa, paramUserData);
  }

  public boolean a()
  {
    return false;
  }

  public boolean a(com.viber.voip.messages.conversation.adapter.a.c.a.i parami)
  {
    return b.a(this, parami);
  }

  public boolean b()
  {
    return false;
  }

  public aa c()
  {
    return this.a;
  }

  public l d()
  {
    return this.b;
  }

  public c e()
  {
    return this.n;
  }

  public boolean f()
  {
    return this.c;
  }

  public boolean g()
  {
    return this.d;
  }

  public boolean h()
  {
    return this.e;
  }

  public long i()
  {
    return this.a.a();
  }

  public boolean j()
  {
    return this.f;
  }

  public boolean k()
  {
    return this.i;
  }

  public boolean l()
  {
    return this.j;
  }

  public boolean m()
  {
    return b.a(this);
  }

  public boolean n()
  {
    return b.b(this);
  }

  public boolean o()
  {
    return b.c(this);
  }

  public boolean p()
  {
    return b.d(this);
  }

  public boolean q()
  {
    return b.e(this);
  }

  public boolean r()
  {
    return b.f(this);
  }

  public String toString()
  {
    return "ConversationAdapterItem{message=" + this.a + ", showUnreadHeader=" + this.c + ", showDateHeader=" + this.d + ", aggregated=" + this.e + ", isNewMessage=" + this.g + ", first=" + this.h + ", last=" + this.i + ", selected=" + this.j + ", prevCall=" + this.k + ", prevNotification=" + this.l + ", prevSticker=" + this.m + ", description=" + this.a.i() + ", groupId=" + this.a.c() + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.i
 * JD-Core Version:    0.6.2
 */