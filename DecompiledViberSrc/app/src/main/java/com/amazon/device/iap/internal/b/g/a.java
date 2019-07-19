package com.amazon.device.iap.internal.b.g;

import android.os.RemoteException;
import com.amazon.android.framework.exception.KiwiException;
import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.h;
import com.amazon.device.iap.internal.b.i;
import com.amazon.venezia.command.SuccessResult;
import java.util.Set;

public final class a extends i
{
  protected final Set<String> a;
  protected final String b;

  public a(e parame, Set<String> paramSet, String paramString)
  {
    super(parame, "purchase_fulfilled", "2.0");
    this.a = paramSet;
    this.b = paramString;
    b(false);
    a("receiptIds", this.a);
    a("fulfillmentStatus", this.b);
  }

  protected boolean a(SuccessResult paramSuccessResult)
    throws RemoteException, KiwiException
  {
    return true;
  }

  public void a_()
  {
    Object localObject = b().d().a("notifyListenerResult");
    if ((localObject != null) && (Boolean.FALSE.equals(localObject)))
      a("fulfillmentStatus", com.amazon.device.iap.internal.model.a.b.toString());
    super.a_();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.g.a
 * JD-Core Version:    0.6.2
 */