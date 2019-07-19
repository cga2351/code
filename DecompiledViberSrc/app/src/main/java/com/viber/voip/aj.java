package com.viber.voip;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.viber.dexshared.Logger;

public class aj extends Handler
{
  protected final Logger a = a(parame);

  public aj(av.e parame, Looper paramLooper)
  {
    super(paramLooper);
  }

  protected Logger a(av.e parame)
  {
    return ViberEnv.getLogger("release-tag");
  }

  public void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.aj
 * JD-Core Version:    0.6.2
 */