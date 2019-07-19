package com.viber.jni.publicaccount;

import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.ConnectedCaller;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.ar;
import com.viber.voip.util.da;
import java.util.concurrent.TimeUnit;

public class PublicAccountSubscriptionCountControllerCaller extends ConnectedCaller
  implements PublicAccountSubscribersCountController
{
  private static final Logger L = ViberEnv.getLogger();
  private final PublicAccountSubscribersCountController mPublicAccountSubscribersCountController;
  private final ar<String, Integer> mRequests = new ar(TimeUnit.MINUTES.toMillis(5L));

  public PublicAccountSubscriptionCountControllerCaller(Engine paramEngine, PublicAccountSubscribersCountController paramPublicAccountSubscribersCountController)
  {
    super(paramEngine);
    this.mPublicAccountSubscribersCountController = paramPublicAccountSubscribersCountController;
  }

  public boolean handleGetPublicAccountSubscribersCount(int paramInt, String paramString)
  {
    if (da.a(paramString));
    while (this.mRequests.get(paramString) != null)
      return false;
    this.mRequests.put(paramString, Integer.valueOf(paramInt));
    runOnConnect(paramString.hashCode(), new PublicAccountSubscriptionCountControllerCaller..Lambda.0(this, paramInt, paramString));
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.publicaccount.PublicAccountSubscriptionCountControllerCaller
 * JD-Core Version:    0.6.2
 */