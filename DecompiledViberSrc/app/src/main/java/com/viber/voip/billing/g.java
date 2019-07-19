package com.viber.voip.billing;

import com.viber.jni.Engine;
import com.viber.jni.PhoneControllerDelegateAdapter;
import java.util.concurrent.CountDownLatch;

@Deprecated
public class g extends af
{
  PhoneControllerDelegateAdapter a;

  @Deprecated
  public static af a()
  {
    return a.a();
  }

  protected void a(Engine paramEngine)
  {
    paramEngine.removeDelegate(this.a);
  }

  protected void a(final Engine paramEngine, final ac[] paramArrayOfac, final CountDownLatch paramCountDownLatch)
  {
    this.a = new PhoneControllerDelegateAdapter()
    {
      public void onGetBillingToken(long paramAnonymousLong, String paramAnonymousString)
      {
        paramEngine.removeDelegate(this);
        if ((paramAnonymousLong > 0L) && (paramAnonymousString != null) && (paramAnonymousString.length() > 0))
          paramArrayOfac[0] = new ac(paramAnonymousLong, paramAnonymousString);
        paramCountDownLatch.countDown();
      }
    };
    paramEngine.registerDelegate(this.a);
  }

  private static final class a
  {
    private static final af a = new g(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.g
 * JD-Core Version:    0.6.2
 */