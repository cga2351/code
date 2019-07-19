package com.viber.voip.gdpr.a.a.a;

import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CGdprCommandMsg;
import com.viber.jni.im2.CGdprCommandMsg.Sender;
import com.viber.jni.im2.CGdprCommandReplyMsg;
import com.viber.voip.gdpr.a.a.b;
import com.viber.voip.gdpr.a.f;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.user.UserData;
import com.viber.voip.util.az;

public class a extends com.viber.voip.gdpr.a.a.a<com.viber.voip.gdpr.ui.a.a.a>
{
  private final com.viber.common.b.d e;
  private final ci f;
  private final com.viber.voip.messages.extras.a.e g;
  private final com.viber.voip.messages.extras.c.a h;
  private final UserData i;
  private final com.viber.voip.util.e.e j;
  private final com.viber.common.b.e k;

  public a(az paramaz, PhoneController paramPhoneController, com.viber.voip.util.d paramd, com.viber.voip.gdpr.ui.a.a.a parama, CGdprCommandMsg.Sender paramSender, b paramb, com.viber.common.b.d paramd1, ci paramci, com.viber.voip.messages.extras.a.e parame, com.viber.voip.messages.extras.c.a parama1, UserData paramUserData, com.viber.voip.util.e.e parame1, com.viber.common.b.e parame2)
  {
    super(paramaz, paramPhoneController, paramd, parama, paramSender, paramb);
    this.e = paramd1;
    this.f = paramci;
    this.g = parame;
    this.h = parama1;
    this.i = paramUserData;
    this.j = parame1;
    this.k = parame2;
  }

  private void e()
  {
    this.g.a();
    this.h.a();
  }

  protected CGdprCommandMsg a(int paramInt)
  {
    return new CGdprCommandMsg(paramInt, 1);
  }

  protected void a(CGdprCommandReplyMsg paramCGdprCommandReplyMsg)
  {
    this.f.a("");
    this.f.a(null);
    this.k.e();
    e();
  }

  public void b()
  {
    a(f.a);
  }

  public void c()
  {
    this.j.b(this.i.getImage());
    this.i.clear();
    this.k.e();
    e();
  }

  public int d()
  {
    return this.e.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.a.a.a.a
 * JD-Core Version:    0.6.2
 */