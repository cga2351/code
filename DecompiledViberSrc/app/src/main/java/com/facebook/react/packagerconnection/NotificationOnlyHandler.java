package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;

public abstract class NotificationOnlyHandler
  implements RequestHandler
{
  private static final String TAG = JSPackagerClient.class.getSimpleName();

  public abstract void onNotification(@Nullable Object paramObject);

  public final void onRequest(@Nullable Object paramObject, Responder paramResponder)
  {
    paramResponder.error("Request is not supported");
    FLog.e(TAG, "Request is not supported");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.packagerconnection.NotificationOnlyHandler
 * JD-Core Version:    0.6.2
 */