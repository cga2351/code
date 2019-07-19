package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class SnackbarManager
{
  private static final int LONG_DURATION_MS = 2750;
  static final int MSG_TIMEOUT = 0;
  private static final int SHORT_DURATION_MS = 1500;
  private static SnackbarManager snackbarManager;
  private SnackbarRecord currentSnackbar;
  private final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
        return false;
      case 0:
      }
      SnackbarManager.this.handleTimeout((SnackbarManager.SnackbarRecord)paramAnonymousMessage.obj);
      return true;
    }
  });
  private final Object lock = new Object();
  private SnackbarRecord nextSnackbar;

  private boolean cancelSnackbarLocked(SnackbarRecord paramSnackbarRecord, int paramInt)
  {
    Callback localCallback = (Callback)paramSnackbarRecord.callback.get();
    if (localCallback != null)
    {
      this.handler.removeCallbacksAndMessages(paramSnackbarRecord);
      localCallback.dismiss(paramInt);
      return true;
    }
    return false;
  }

  static SnackbarManager getInstance()
  {
    if (snackbarManager == null)
      snackbarManager = new SnackbarManager();
    return snackbarManager;
  }

  private boolean isCurrentSnackbarLocked(Callback paramCallback)
  {
    return (this.currentSnackbar != null) && (this.currentSnackbar.isSnackbar(paramCallback));
  }

  private boolean isNextSnackbarLocked(Callback paramCallback)
  {
    return (this.nextSnackbar != null) && (this.nextSnackbar.isSnackbar(paramCallback));
  }

  private void scheduleTimeoutLocked(SnackbarRecord paramSnackbarRecord)
  {
    if (paramSnackbarRecord.duration == -2)
      return;
    int i = 2750;
    if (paramSnackbarRecord.duration > 0)
      i = paramSnackbarRecord.duration;
    while (true)
    {
      this.handler.removeCallbacksAndMessages(paramSnackbarRecord);
      this.handler.sendMessageDelayed(Message.obtain(this.handler, 0, paramSnackbarRecord), i);
      return;
      if (paramSnackbarRecord.duration == -1)
        i = 1500;
    }
  }

  private void showNextSnackbarLocked()
  {
    if (this.nextSnackbar != null)
    {
      this.currentSnackbar = this.nextSnackbar;
      this.nextSnackbar = null;
      Callback localCallback = (Callback)this.currentSnackbar.callback.get();
      if (localCallback != null)
        localCallback.show();
    }
    else
    {
      return;
    }
    this.currentSnackbar = null;
  }

  public void dismiss(Callback paramCallback, int paramInt)
  {
    synchronized (this.lock)
    {
      if (isCurrentSnackbarLocked(paramCallback))
        cancelSnackbarLocked(this.currentSnackbar, paramInt);
      while (!isNextSnackbarLocked(paramCallback))
        return;
      cancelSnackbarLocked(this.nextSnackbar, paramInt);
    }
  }

  void handleTimeout(SnackbarRecord paramSnackbarRecord)
  {
    synchronized (this.lock)
    {
      if ((this.currentSnackbar == paramSnackbarRecord) || (this.nextSnackbar == paramSnackbarRecord))
        cancelSnackbarLocked(paramSnackbarRecord, 2);
      return;
    }
  }

  public boolean isCurrent(Callback paramCallback)
  {
    synchronized (this.lock)
    {
      boolean bool = isCurrentSnackbarLocked(paramCallback);
      return bool;
    }
  }

  public boolean isCurrentOrNext(Callback paramCallback)
  {
    while (true)
    {
      synchronized (this.lock)
      {
        if (!isCurrentSnackbarLocked(paramCallback))
        {
          if (!isNextSnackbarLocked(paramCallback))
            break label42;
          break label36;
          return bool;
        }
      }
      label36: boolean bool = true;
      continue;
      label42: bool = false;
    }
  }

  public void onDismissed(Callback paramCallback)
  {
    synchronized (this.lock)
    {
      if (isCurrentSnackbarLocked(paramCallback))
      {
        this.currentSnackbar = null;
        if (this.nextSnackbar != null)
          showNextSnackbarLocked();
      }
      return;
    }
  }

  public void onShown(Callback paramCallback)
  {
    synchronized (this.lock)
    {
      if (isCurrentSnackbarLocked(paramCallback))
        scheduleTimeoutLocked(this.currentSnackbar);
      return;
    }
  }

  public void pauseTimeout(Callback paramCallback)
  {
    synchronized (this.lock)
    {
      if ((isCurrentSnackbarLocked(paramCallback)) && (!this.currentSnackbar.paused))
      {
        this.currentSnackbar.paused = true;
        this.handler.removeCallbacksAndMessages(this.currentSnackbar);
      }
      return;
    }
  }

  public void restoreTimeoutIfPaused(Callback paramCallback)
  {
    synchronized (this.lock)
    {
      if ((isCurrentSnackbarLocked(paramCallback)) && (this.currentSnackbar.paused))
      {
        this.currentSnackbar.paused = false;
        scheduleTimeoutLocked(this.currentSnackbar);
      }
      return;
    }
  }

  public void show(int paramInt, Callback paramCallback)
  {
    while (true)
    {
      synchronized (this.lock)
      {
        if (isCurrentSnackbarLocked(paramCallback))
        {
          this.currentSnackbar.duration = paramInt;
          this.handler.removeCallbacksAndMessages(this.currentSnackbar);
          scheduleTimeoutLocked(this.currentSnackbar);
          return;
        }
        if (isNextSnackbarLocked(paramCallback))
        {
          this.nextSnackbar.duration = paramInt;
          if ((this.currentSnackbar == null) || (!cancelSnackbarLocked(this.currentSnackbar, 4)))
            break;
          return;
        }
      }
      this.nextSnackbar = new SnackbarRecord(paramInt, paramCallback);
    }
    this.currentSnackbar = null;
    showNextSnackbarLocked();
  }

  static abstract interface Callback
  {
    public abstract void dismiss(int paramInt);

    public abstract void show();
  }

  private static class SnackbarRecord
  {
    final WeakReference<SnackbarManager.Callback> callback;
    int duration;
    boolean paused;

    SnackbarRecord(int paramInt, SnackbarManager.Callback paramCallback)
    {
      this.callback = new WeakReference(paramCallback);
      this.duration = paramInt;
    }

    boolean isSnackbar(SnackbarManager.Callback paramCallback)
    {
      return (paramCallback != null) && (this.callback.get() == paramCallback);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.SnackbarManager
 * JD-Core Version:    0.6.2
 */