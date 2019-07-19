package com.amazon.device.iap.internal.b.b;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.amazon.android.framework.context.ContextManager;
import com.amazon.android.framework.exception.KiwiException;
import com.amazon.android.framework.resource.Resource;
import com.amazon.android.framework.task.Task;
import com.amazon.android.framework.task.TaskManager;
import com.amazon.android.framework.task.pipeline.TaskPipelineId;
import com.amazon.device.iap.internal.b.i;
import com.amazon.device.iap.internal.util.MetricsHelper;
import com.amazon.venezia.command.SuccessResult;
import java.util.Map;

abstract class a extends i
{
  private static final String d = a.class.getSimpleName();

  @Resource
  protected TaskManager a;

  @Resource
  protected ContextManager b;
  protected final String c;

  a(com.amazon.device.iap.internal.b.e parame, String paramString1, String paramString2)
  {
    super(parame, "purchase_item", paramString1);
    this.c = paramString2;
    a("sku", this.c);
  }

  protected boolean a(SuccessResult paramSuccessResult)
    throws RemoteException, KiwiException
  {
    Map localMap = paramSuccessResult.getData();
    com.amazon.device.iap.internal.util.e.a(d, "data: " + localMap);
    if (!localMap.containsKey("purchaseItemIntent"))
    {
      com.amazon.device.iap.internal.util.e.b(d, "did not find intent");
      return false;
    }
    com.amazon.device.iap.internal.util.e.a(d, "found intent");
    final Intent localIntent = (Intent)localMap.remove("purchaseItemIntent");
    this.a.enqueueAtFront(TaskPipelineId.FOREGROUND, new Task()
    {
      public void execute()
      {
        try
        {
          Activity localActivity = a.this.b.getVisible();
          if (localActivity == null)
            localActivity = a.this.b.getRoot();
          com.amazon.device.iap.internal.util.e.a(a.a(), "About to fire intent with activity " + localActivity);
          localActivity.startActivity(localIntent);
          return;
        }
        catch (Exception localException)
        {
          MetricsHelper.submitExceptionMetrics(a.a(a.this), a.a() + ".onResult().execute()", localException);
          com.amazon.device.iap.internal.util.e.b(a.a(), "Exception when attempting to fire intent: " + localException);
        }
      }
    });
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.b.b.a
 * JD-Core Version:    0.6.2
 */