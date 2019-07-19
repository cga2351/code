package com.viber.voip.market.b;

import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;

public class o
{
  public void a(final String paramString1, final String paramString2, final long paramLong)
  {
    av.a(av.e.g).post(new Runnable()
    {
      public void run()
      {
        ViberApplication.getInstance().getEngine(true).getCdrController().handleReportWeb(paramString1, paramString2, paramLong);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.b.o
 * JD-Core Version:    0.6.2
 */