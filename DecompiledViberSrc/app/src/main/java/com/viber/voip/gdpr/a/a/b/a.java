package com.viber.voip.gdpr.a.a.b;

import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CGdprCommandMsg;
import com.viber.jni.im2.CGdprCommandMsg.Sender;
import com.viber.jni.im2.CGdprCommandReplyMsg;
import com.viber.voip.gdpr.a.a.b;
import com.viber.voip.gdpr.a.f;
import com.viber.voip.util.az;
import com.viber.voip.util.d;

public class a extends com.viber.voip.gdpr.a.a.a<com.viber.voip.gdpr.ui.a.b.a>
{
  public a(az paramaz, PhoneController paramPhoneController, d paramd, com.viber.voip.gdpr.ui.a.b.a parama, CGdprCommandMsg.Sender paramSender, b paramb)
  {
    super(paramaz, paramPhoneController, paramd, parama, paramSender, paramb);
  }

  protected CGdprCommandMsg a(int paramInt)
  {
    return new CGdprCommandMsg(paramInt, 0);
  }

  protected void a(CGdprCommandReplyMsg paramCGdprCommandReplyMsg)
  {
    this.b.b(new a(this.c, paramCGdprCommandReplyMsg.seq, paramCGdprCommandReplyMsg.processDays, null));
  }

  public void b()
  {
    a(f.a);
  }

  private class a extends com.viber.voip.gdpr.a
  {
    private final int b;
    private final int c;

    private a(d paramInt1, int paramInt2, int arg4)
    {
      super();
      this.b = paramInt2;
      int i;
      this.c = i;
    }

    public void a()
    {
      ((com.viber.voip.gdpr.ui.a.b.a)a.a(a.this)).c(this.c);
    }

    public void b()
    {
      ((com.viber.voip.gdpr.ui.a.b.a)a.b(a.this)).a(this.b, this.c);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.a.a.b.a
 * JD-Core Version:    0.6.2
 */