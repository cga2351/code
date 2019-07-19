package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zal;

final class zaco extends zal
{
  public zaco(zacm paramzacm, Looper paramLooper)
  {
    super(paramLooper);
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      int i = paramMessage.what;
      Log.e("TransformedResultImpl", 70 + "TransformationResultHandler received unknown message type: " + i);
      return;
    case 0:
      PendingResult localPendingResult = (PendingResult)paramMessage.obj;
      Object localObject1 = zacm.zaf(this.zakv);
      if (localPendingResult == null);
      while (true)
      {
        try
        {
          zacm.zaa(zacm.zag(this.zakv), new Status(13, "Transform returned null"));
          return;
        }
        finally
        {
        }
        if ((localPendingResult instanceof zacd))
          zacm.zaa(zacm.zag(this.zakv), ((zacd)localPendingResult).getStatus());
        else
          zacm.zag(this.zakv).zaa(localPendingResult);
      }
    case 1:
    }
    RuntimeException localRuntimeException = (RuntimeException)paramMessage.obj;
    String str1 = String.valueOf(localRuntimeException.getMessage());
    if (str1.length() != 0);
    for (String str2 = "Runtime exception on the transformation worker thread: ".concat(str1); ; str2 = new String("Runtime exception on the transformation worker thread: "))
    {
      Log.e("TransformedResultImpl", str2);
      throw localRuntimeException;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaco
 * JD-Core Version:    0.6.2
 */