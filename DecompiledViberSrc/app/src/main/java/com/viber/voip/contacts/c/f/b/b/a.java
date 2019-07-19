package com.viber.voip.contacts.c.f.b.b;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.j;
import com.viber.voip.contacts.c.f.b.a.b;
import com.viber.voip.contacts.c.f.b.c.a;
import com.viber.voip.contacts.c.f.b.d;
import com.viber.voip.contacts.c.f.b.g.b;
import com.viber.voip.messages.d.b;
import java.util.HashSet;
import java.util.Set;

public class a extends d
{
  private final Logger n = ViberEnv.getLogger(getClass());

  public a(Context paramContext, ViberApplication paramViberApplication, c.a parama, j paramj)
  {
    super(paramContext, paramViberApplication, parama, paramj);
  }

  private void a(a.b paramb, g.b paramb1, int paramInt)
  {
    a(paramInt);
    if (paramb1.a())
      com.viber.service.contacts.sync.a.a().b();
    a(paramb);
    HashSet localHashSet = new HashSet(paramb1.d.size() + paramb1.e.size());
    localHashSet.addAll(paramb1.d);
    localHashSet.addAll(paramb1.e);
    this.b.getParticipantManager().a(localHashSet);
    this.b.getContactManager().j();
    this.h.o();
  }

  public void a(a.b paramb, int paramInt)
  {
    a(paramb, this.j.a(paramb), paramInt);
  }

  public void a(a.b paramb, String[] paramArrayOfString, int paramInt)
  {
    a(paramb, this.j.a(paramb, paramArrayOfString), paramInt);
  }

  public void a(com.viber.voip.model.a parama)
  {
  }

  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }

  protected void h()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.f.b.b.a
 * JD-Core Version:    0.6.2
 */