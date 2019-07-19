package com.viber.voip.contacts.c.d;

import android.os.Handler;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.settings.d.al;
import com.viber.voip.util.cd;
import java.util.Collection;
import java.util.Set;

public class p extends a<com.viber.voip.model.entity.m>
{
  private final ak h;
  private final com.viber.common.b.d i;
  private d.al j;

  public p(Im2Exchanger paramIm2Exchanger, com.viber.common.b.d paramd1, com.viber.common.b.d paramd2, ak paramak, PhoneController paramPhoneController, Handler paramHandler)
  {
    super(paramIm2Exchanger, paramd1, paramPhoneController, paramHandler);
    this.i = paramd2;
    this.h = paramak;
  }

  private void g()
  {
    if (this.j == null)
    {
      Handler localHandler = this.d;
      com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[1];
      arrayOfa[0] = this.i;
      this.j = new d.al(localHandler, arrayOfa)
      {
        public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
        {
          switch (p.a(p.this).d())
          {
          default:
          case 3:
          case 4:
          }
          do
            return;
          while (p.this.b.d() != 5);
          p.this.b.a(0);
          if (p.this.c.isConnected())
            p.this.c();
          com.viber.voip.settings.d.b(p.b(p.this));
          p.this.a();
        }
      };
    }
    com.viber.voip.settings.d.a(this.j);
  }

  protected void a(Set<com.viber.voip.model.entity.m> paramSet)
  {
    this.h.a(new q(this, paramSet));
  }

  protected boolean a(com.viber.voip.model.entity.m paramm)
  {
    String str = paramm.a();
    return (super.a(paramm)) || (cd.c(str)) || (com.viber.voip.messages.m.a(str)) || (com.viber.voip.messages.m.b(str)) || ("Viber".equals(str));
  }

  protected boolean b()
  {
    switch (this.i.d())
    {
    default:
      g();
      return false;
    case 3:
    case 4:
    }
    if (this.b.d() == 5)
      this.b.a(0);
    return true;
  }

  protected Collection<com.viber.voip.model.entity.m> d()
  {
    return this.h.d();
  }

  protected void e()
  {
    super.e();
    if (this.j != null)
      com.viber.voip.settings.d.b(this.j);
  }

  protected void f()
  {
    super.f();
    if (this.j != null)
      com.viber.voip.settings.d.b(this.j);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.d.p
 * JD-Core Version:    0.6.2
 */