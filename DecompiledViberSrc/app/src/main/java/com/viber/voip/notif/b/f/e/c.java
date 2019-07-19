package com.viber.voip.notif.b.f.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.viber.voip.R.string;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.entity.MessageCallEntity;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.a.g;
import com.viber.voip.notif.d.m.a;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.p;
import java.util.List;

public class c extends b
  implements m.a
{
  private final dagger.a<ab> h;
  private Boolean i;
  private String j;

  public c(com.viber.voip.notif.h.m paramm, dagger.a<ab> parama)
  {
    super(paramm);
    this.h = parama;
  }

  private boolean i()
  {
    if (this.i == null)
    {
      List localList = ((ab)this.h.get()).x(this.a.c().getId());
      if ((localList.isEmpty()) || (!((MessageCallEntity)localList.get(-1 + localList.size())).isTypeViberGeneralVideo()))
        break label85;
    }
    label85: for (boolean bool = true; ; bool = false)
    {
      this.i = Boolean.valueOf(bool);
      return this.i.booleanValue();
    }
  }

  protected void a(Context paramContext, g paramg)
  {
    if (this.a.e().ao());
    String str;
    do
    {
      do
        return;
      while (this.a.c().hasConferenceInfo());
      com.viber.voip.model.entity.m localm = this.a.d();
      if (!this.a.e().I())
        a(paramg.a(Member.from(localm), this.a.c()));
      str = localm.getNumber();
    }
    while (TextUtils.isEmpty(str));
    com.viber.voip.notif.a.a.a[] arrayOfa = new com.viber.voip.notif.a.a.a[2];
    arrayOfa[0] = paramg.a(this.a.e().getId(), str, i());
    arrayOfa[1] = paramg.c(this.a.c(), R_(), a());
    a(arrayOfa);
  }

  public CharSequence b(Context paramContext)
  {
    return h();
  }

  protected Intent c(Context paramContext)
  {
    if (this.a.e().I())
      return ViberActionRunner.ab.a(paramContext);
    return super.c(paramContext);
  }

  public CharSequence d(Context paramContext)
  {
    return paramContext.getString(R.string.app_name);
  }

  public CharSequence f(Context paramContext)
  {
    return null;
  }

  public com.viber.voip.notif.d.m h(Context paramContext)
  {
    return com.viber.voip.notif.d.m.a(this, paramContext);
  }

  public String h()
  {
    MessageEntity localMessageEntity;
    if (this.j == null)
    {
      localMessageEntity = this.a.c();
      if (!localMessageEntity.hasConferenceInfo())
        break label41;
    }
    label41: for (this.j = p.a(localMessageEntity.getConferenceInfo(), false); ; this.j = this.c)
      return this.j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.e.c
 * JD-Core Version:    0.6.2
 */