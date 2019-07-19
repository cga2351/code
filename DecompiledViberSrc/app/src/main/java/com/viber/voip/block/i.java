package com.viber.voip.block;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.contacts.a.a;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.contacts.c.c.c.a;
import com.viber.voip.memberid.Member;
import java.util.Set;

public class i extends d
{
  private com.viber.voip.contacts.c.c.c l;
  private c.a m = new c.a()
  {
    public void a(Set<Member> paramAnonymousSet, boolean paramAnonymousBoolean)
    {
      i.this.l();
    }

    public void b(Set<Member> paramAnonymousSet, boolean paramAnonymousBoolean)
    {
      i.this.l();
    }
  };

  public i(Context paramContext, LoaderManager paramLoaderManager, d.a parama)
  {
    super(11, a.a.b, paramContext, paramLoaderManager, parama, 0);
    a(j.a);
    d("blockednumbers.blocked_date DESC");
    this.l = new com.viber.voip.contacts.c.c.a.c();
  }

  public j e(int paramInt)
  {
    if (b_(paramInt))
      return new j(this.f);
    return null;
  }

  public void p()
  {
    super.p();
    this.l.a(this.m);
  }

  public void q()
  {
    super.q();
    this.l.b(this.m);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.i
 * JD-Core Version:    0.6.2
 */