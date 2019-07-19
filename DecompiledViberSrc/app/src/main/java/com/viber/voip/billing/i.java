package com.viber.voip.billing;

import com.viber.jni.Engine;
import com.viber.jni.im2.CBillingTokenByMidMsg;
import com.viber.jni.im2.CBillingTokenByMidReplyMsg;
import com.viber.jni.im2.CBillingTokenByMidReplyMsg.Receiver;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.im2.Im2ReceiverBase;
import com.viber.voip.util.da;
import java.util.concurrent.CountDownLatch;

public class i extends af
{
  CBillingTokenByMidReplyMsg.Receiver a;

  @Deprecated
  public static af a()
  {
    return a.a();
  }

  protected void a(Engine paramEngine)
  {
    paramEngine.getExchanger().removeDelegate(this.a);
  }

  protected void a(final Engine paramEngine, final ac[] paramArrayOfac, final CountDownLatch paramCountDownLatch)
  {
    this.a = new CBillingTokenByMidReplyMsg.Receiver()
    {
      public void onCBillingTokenByMidReplyMsg(CBillingTokenByMidReplyMsg paramAnonymousCBillingTokenByMidReplyMsg)
      {
        paramEngine.getExchanger().removeDelegate(this);
        String str = paramAnonymousCBillingTokenByMidReplyMsg.token;
        long l = paramAnonymousCBillingTokenByMidReplyMsg.timestamp;
        if ((l > 0L) && (!da.a(str)))
          paramArrayOfac[0] = new ac(l, str);
        paramCountDownLatch.countDown();
      }
    };
    Im2Exchanger localIm2Exchanger = paramEngine.getExchanger();
    Im2ReceiverBase[] arrayOfIm2ReceiverBase = new Im2ReceiverBase[1];
    arrayOfIm2ReceiverBase[0] = this.a;
    localIm2Exchanger.registerDelegate(arrayOfIm2ReceiverBase);
    paramEngine.getExchanger().handleCBillingTokenByMidMsg(new CBillingTokenByMidMsg());
  }

  private static final class a
  {
    private static final af a = new i(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.i
 * JD-Core Version:    0.6.2
 */