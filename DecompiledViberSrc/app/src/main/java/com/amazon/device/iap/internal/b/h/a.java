package com.amazon.device.iap.internal.b.h;

import android.os.RemoteException;
import com.amazon.android.framework.exception.KiwiException;
import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.i;
import com.amazon.venezia.command.SuccessResult;

public class a extends i
{
  public a(e parame, String paramString1, String paramString2)
  {
    super(parame, "submit_metric", "1.0");
    a("metricName", paramString1);
    a("metricAttributes", paramString2);
    b(false);
  }

  protected boolean a(SuccessResult paramSuccessResult)
    throws RemoteException, KiwiException
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.h.a
 * JD-Core Version:    0.6.2
 */