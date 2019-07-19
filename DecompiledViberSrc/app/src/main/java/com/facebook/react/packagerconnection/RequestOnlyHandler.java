package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;

public abstract class RequestOnlyHandler
  implements RequestHandler
{
  private static final String TAG = JSPackagerClient.class.getSimpleName();

  public final void onNotification(@Nullable Object paramObject)
  {
    FLog.e(TAG, "Notification is not supported");
  }

  public abstract void onRequest(@Nullable Object paramObject, Responder paramResponder);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.packagerconnection.RequestOnlyHandler
 * JD-Core Version:    0.6.2
 */