package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

@Deprecated
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver
{
  private static final String EXTRA_WAKE_LOCK_ID = "android.support.content.wakelockid";
  private static int mNextId = 1;
  private static final SparseArray<PowerManager.WakeLock> sActiveWakeLocks = new SparseArray();

  public static boolean completeWakefulIntent(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("android.support.content.wakelockid", 0);
    if (i == 0)
      return false;
    synchronized (sActiveWakeLocks)
    {
      PowerManager.WakeLock localWakeLock = (PowerManager.WakeLock)sActiveWakeLocks.get(i);
      if (localWakeLock != null)
      {
        localWakeLock.release();
        sActiveWakeLocks.remove(i);
        return true;
      }
      Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + i);
      return true;
    }
  }

  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent)
  {
    synchronized (sActiveWakeLocks)
    {
      int i = mNextId;
      mNextId = 1 + mNextId;
      if (mNextId <= 0)
        mNextId = 1;
      paramIntent.putExtra("android.support.content.wakelockid", i);
      ComponentName localComponentName = paramContext.startService(paramIntent);
      if (localComponentName == null)
        return null;
      PowerManager.WakeLock localWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + localComponentName.flattenToShortString());
      localWakeLock.setReferenceCounted(false);
      localWakeLock.acquire(60000L);
      sActiveWakeLocks.put(i, localWakeLock);
      return localComponentName;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.WakefulBroadcastReceiver
 * JD-Core Version:    0.6.2
 */