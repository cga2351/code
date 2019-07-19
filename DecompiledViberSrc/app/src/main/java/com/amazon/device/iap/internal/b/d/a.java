package com.amazon.device.iap.internal.b.d;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.h;
import com.amazon.device.iap.internal.b.i;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class a extends e
{
  public a(RequestId paramRequestId, boolean paramBoolean)
  {
    super(paramRequestId);
    com.amazon.device.iap.internal.b.e.c localc = new com.amazon.device.iap.internal.b.e.c(this);
    localc.a(new c(this, paramBoolean));
    com.amazon.device.iap.internal.b.e.d locald = new com.amazon.device.iap.internal.b.e.d(this);
    locald.a(new d(this));
    localc.b(locald);
    a(localc);
  }

  public void a()
  {
    PurchaseUpdatesResponse localPurchaseUpdatesResponse = (PurchaseUpdatesResponse)d().a();
    List localList = localPurchaseUpdatesResponse.getReceipts();
    com.amazon.device.iap.internal.b.g.a locala = null;
    if (localList != null)
    {
      int i = localPurchaseUpdatesResponse.getReceipts().size();
      locala = null;
      if (i > 0)
      {
        HashSet localHashSet = new HashSet();
        Iterator localIterator = localPurchaseUpdatesResponse.getReceipts().iterator();
        while (localIterator.hasNext())
        {
          Receipt localReceipt = (Receipt)localIterator.next();
          if (!com.amazon.device.iap.internal.util.d.a(localReceipt.getReceiptId()))
            localHashSet.add(localReceipt.getReceiptId());
        }
        locala = new com.amazon.device.iap.internal.b.g.a(this, localHashSet, com.amazon.device.iap.internal.model.a.a.toString());
      }
    }
    a(localPurchaseUpdatesResponse, locala);
  }

  public void b()
  {
    Object localObject = d().a();
    if ((localObject == null) || (!(localObject instanceof PurchaseUpdatesResponse)));
    for (PurchaseUpdatesResponse localPurchaseUpdatesResponse = new PurchaseUpdatesResponseBuilder().setRequestId(c()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.FAILED).build(); ; localPurchaseUpdatesResponse = (PurchaseUpdatesResponse)localObject)
    {
      a(localPurchaseUpdatesResponse);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.d.a
 * JD-Core Version:    0.6.2
 */