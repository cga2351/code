package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;

public final class HandlerCompat
{
  public static boolean postDelayed(Handler paramHandler, Runnable paramRunnable, Object paramObject, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return paramHandler.postDelayed(paramRunnable, paramObject, paramLong);
    Message localMessage = Message.obtain(paramHandler, paramRunnable);
    localMessage.obj = paramObject;
    return paramHandler.sendMessageDelayed(localMessage, paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.os.HandlerCompat
 * JD-Core Version:    0.6.2
 */