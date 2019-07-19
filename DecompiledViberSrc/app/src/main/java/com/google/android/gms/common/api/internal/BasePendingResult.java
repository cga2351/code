package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zal;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepForSdk
@KeepName
public abstract class BasePendingResult<R extends Result> extends PendingResult<R>
{
  static final ThreadLocal<Boolean> zadm = new zap();

  @KeepName
  private zaa mResultGuardian;
  private Status mStatus;
  private R zaci;
  private final Object zadn = new Object();
  private final CallbackHandler<R> zado;
  private final WeakReference<GoogleApiClient> zadp;
  private final CountDownLatch zadq = new CountDownLatch(1);
  private final ArrayList<PendingResult.StatusListener> zadr = new ArrayList();
  private ResultCallback<? super R> zads;
  private final AtomicReference<zacs> zadt = new AtomicReference();
  private volatile boolean zadu;
  private boolean zadv;
  private boolean zadw;
  private ICancelToken zadx;
  private volatile zacm<R> zady;
  private boolean zadz = false;

  @Deprecated
  BasePendingResult()
  {
    this.zado = new CallbackHandler(Looper.getMainLooper());
    this.zadp = new WeakReference(null);
  }

  @Deprecated
  @KeepForSdk
  protected BasePendingResult(Looper paramLooper)
  {
    this.zado = new CallbackHandler(paramLooper);
    this.zadp = new WeakReference(null);
  }

  @KeepForSdk
  protected BasePendingResult(GoogleApiClient paramGoogleApiClient)
  {
    if (paramGoogleApiClient != null);
    for (Looper localLooper = paramGoogleApiClient.getLooper(); ; localLooper = Looper.getMainLooper())
    {
      this.zado = new CallbackHandler(localLooper);
      this.zadp = new WeakReference(paramGoogleApiClient);
      return;
    }
  }

  @KeepForSdk
  @VisibleForTesting
  protected BasePendingResult(CallbackHandler<R> paramCallbackHandler)
  {
    this.zado = ((CallbackHandler)Preconditions.checkNotNull(paramCallbackHandler, "CallbackHandler must not be null"));
    this.zadp = new WeakReference(null);
  }

  private final R get()
  {
    boolean bool = true;
    synchronized (this.zadn)
    {
      if (!this.zadu)
      {
        Preconditions.checkState(bool, "Result has already been consumed.");
        Preconditions.checkState(isReady(), "Result is not ready.");
        Result localResult = this.zaci;
        this.zaci = null;
        this.zads = null;
        this.zadu = true;
        zacs localzacs = (zacs)this.zadt.getAndSet(null);
        if (localzacs != null)
          localzacs.zac(this);
        return localResult;
      }
      bool = false;
    }
  }

  private final void zaa(R paramR)
  {
    this.zaci = paramR;
    this.zadx = null;
    this.zadq.countDown();
    this.mStatus = this.zaci.getStatus();
    if (this.zadv)
      this.zads = null;
    while (true)
    {
      ArrayList localArrayList = (ArrayList)this.zadr;
      int i = localArrayList.size();
      int j = 0;
      while (j < i)
      {
        Object localObject = localArrayList.get(j);
        j++;
        ((PendingResult.StatusListener)localObject).onComplete(this.mStatus);
      }
      if (this.zads == null)
      {
        if ((this.zaci instanceof Releasable))
          this.mResultGuardian = new zaa(null);
      }
      else
      {
        this.zado.removeMessages(2);
        this.zado.zaa(this.zads, get());
      }
    }
    this.zadr.clear();
  }

  public static void zab(Result paramResult)
  {
    if ((paramResult instanceof Releasable));
    try
    {
      ((Releasable)paramResult).release();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      String str = String.valueOf(paramResult);
      Log.w("BasePendingResult", 18 + String.valueOf(str).length() + "Unable to release " + str, localRuntimeException);
    }
  }

  public final void addStatusListener(PendingResult.StatusListener paramStatusListener)
  {
    if (paramStatusListener != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "Callback cannot be null.");
      synchronized (this.zadn)
      {
        if (isReady())
        {
          paramStatusListener.onComplete(this.mStatus);
          return;
        }
        this.zadr.add(paramStatusListener);
      }
    }
  }

  public final R await()
  {
    boolean bool1 = true;
    Preconditions.checkNotMainThread("await must not be called on the UI thread");
    boolean bool2;
    if (!this.zadu)
      bool2 = bool1;
    while (true)
    {
      Preconditions.checkState(bool2, "Result has already been consumed");
      if (this.zady == null)
        Preconditions.checkState(bool1, "Cannot await if then() has been called.");
      try
      {
        this.zadq.await();
        Preconditions.checkState(isReady(), "Result is not ready.");
        return get();
        bool2 = false;
        continue;
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          zab(Status.RESULT_INTERRUPTED);
      }
    }
  }

  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool1 = true;
    if (paramLong > 0L)
      Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
    boolean bool2;
    if (!this.zadu)
      bool2 = bool1;
    while (true)
    {
      Preconditions.checkState(bool2, "Result has already been consumed.");
      if (this.zady == null)
        Preconditions.checkState(bool1, "Cannot await if then() has been called.");
      try
      {
        if (!this.zadq.await(paramLong, paramTimeUnit))
          zab(Status.RESULT_TIMEOUT);
        Preconditions.checkState(isReady(), "Result is not ready.");
        return get();
        bool2 = false;
        continue;
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          zab(Status.RESULT_INTERRUPTED);
      }
    }
  }

  @KeepForSdk
  public void cancel()
  {
    synchronized (this.zadn)
    {
      if ((this.zadv) || (this.zadu))
        return;
      ICancelToken localICancelToken = this.zadx;
      if (localICancelToken == null);
    }
    try
    {
      this.zadx.cancel();
      label42: zab(this.zaci);
      this.zadv = true;
      zaa(createFailedResult(Status.RESULT_CANCELED));
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      break label42;
    }
  }

  @KeepForSdk
  protected abstract R createFailedResult(Status paramStatus);

  public boolean isCanceled()
  {
    synchronized (this.zadn)
    {
      boolean bool = this.zadv;
      return bool;
    }
  }

  @KeepForSdk
  public final boolean isReady()
  {
    return this.zadq.getCount() == 0L;
  }

  @KeepForSdk
  protected final void setCancelToken(ICancelToken paramICancelToken)
  {
    synchronized (this.zadn)
    {
      this.zadx = paramICancelToken;
      return;
    }
  }

  @KeepForSdk
  public final void setResult(R paramR)
  {
    boolean bool1 = true;
    while (true)
    {
      synchronized (this.zadn)
      {
        if ((!this.zadw) && (!this.zadv))
        {
          if ((!isReady()) || (!isReady()))
          {
            bool2 = bool1;
            Preconditions.checkState(bool2, "Results have already been set");
            if (this.zadu)
              break label90;
            Preconditions.checkState(bool1, "Result has already been consumed");
            zaa(paramR);
          }
        }
        else
        {
          zab(paramR);
          return;
        }
      }
      boolean bool2 = false;
      continue;
      label90: bool1 = false;
    }
  }

  @KeepForSdk
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    boolean bool1 = true;
    Object localObject1 = this.zadn;
    if (paramResultCallback == null);
    while (true)
    {
      try
      {
        this.zads = null;
        return;
        if (!this.zadu)
        {
          bool2 = bool1;
          Preconditions.checkState(bool2, "Result has already been consumed.");
          if (this.zady != null)
            break label75;
          Preconditions.checkState(bool1, "Cannot set callbacks if then() has been called.");
          if (!isCanceled())
            break;
          return;
        }
      }
      finally
      {
      }
      boolean bool2 = false;
      continue;
      label75: bool1 = false;
    }
    if (isReady())
      this.zado.zaa(paramResultCallback, get());
    while (true)
    {
      return;
      this.zads = paramResultCallback;
    }
  }

  @KeepForSdk
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool1 = true;
    Object localObject1 = this.zadn;
    if (paramResultCallback == null);
    while (true)
    {
      try
      {
        this.zads = null;
        return;
        if (!this.zadu)
        {
          bool2 = bool1;
          Preconditions.checkState(bool2, "Result has already been consumed.");
          if (this.zady != null)
            break label83;
          Preconditions.checkState(bool1, "Cannot set callbacks if then() has been called.");
          if (!isCanceled())
            break;
          return;
        }
      }
      finally
      {
      }
      boolean bool2 = false;
      continue;
      label83: bool1 = false;
    }
    if (isReady())
      this.zado.zaa(paramResultCallback, get());
    while (true)
    {
      return;
      this.zads = paramResultCallback;
      CallbackHandler localCallbackHandler = this.zado;
      long l = paramTimeUnit.toMillis(paramLong);
      localCallbackHandler.sendMessageDelayed(localCallbackHandler.obtainMessage(2, this), l);
    }
  }

  public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    boolean bool1 = true;
    boolean bool2;
    if (!this.zadu)
    {
      bool2 = bool1;
      Preconditions.checkState(bool2, "Result has already been consumed.");
    }
    while (true)
    {
      synchronized (this.zadn)
      {
        if (this.zady != null)
          break label158;
        bool3 = bool1;
        Preconditions.checkState(bool3, "Cannot call then() twice.");
        if (this.zads != null)
          break label164;
        bool4 = bool1;
        Preconditions.checkState(bool4, "Cannot call then() if callbacks are set.");
        if (this.zadv)
          break label170;
        Preconditions.checkState(bool1, "Cannot call then() if result was canceled.");
        this.zadz = true;
        this.zady = new zacm(this.zadp);
        TransformedResult localTransformedResult = this.zady.then(paramResultTransform);
        if (isReady())
        {
          this.zado.zaa(this.zady, get());
          return localTransformedResult;
        }
        this.zads = this.zady;
      }
      bool2 = false;
      break;
      label158: boolean bool3 = false;
      continue;
      label164: boolean bool4 = false;
      continue;
      label170: bool1 = false;
    }
  }

  public final void zaa(zacs paramzacs)
  {
    this.zadt.set(paramzacs);
  }

  public final void zab(Status paramStatus)
  {
    synchronized (this.zadn)
    {
      if (!isReady())
      {
        setResult(createFailedResult(paramStatus));
        this.zadw = true;
      }
      return;
    }
  }

  public final Integer zam()
  {
    return null;
  }

  public final boolean zat()
  {
    synchronized (this.zadn)
    {
      if (((GoogleApiClient)this.zadp.get() == null) || (!this.zadz))
        cancel();
      boolean bool = isCanceled();
      return bool;
    }
  }

  public final void zau()
  {
    if ((this.zadz) || (((Boolean)zadm.get()).booleanValue()));
    for (boolean bool = true; ; bool = false)
    {
      this.zadz = bool;
      return;
    }
  }

  @VisibleForTesting
  public static class CallbackHandler<R extends Result> extends zal
  {
    public CallbackHandler()
    {
      this(Looper.getMainLooper());
    }

    public CallbackHandler(Looper paramLooper)
    {
      super();
    }

    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        int i = paramMessage.what;
        Log.wtf("BasePendingResult", 45 + "Don't know how to handle message: " + i, new Exception());
        return;
      case 1:
        Pair localPair = (Pair)paramMessage.obj;
        ResultCallback localResultCallback = (ResultCallback)localPair.first;
        Result localResult = (Result)localPair.second;
        try
        {
          localResultCallback.onResult(localResult);
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          BasePendingResult.zab(localResult);
          throw localRuntimeException;
        }
      case 2:
      }
      ((BasePendingResult)paramMessage.obj).zab(Status.RESULT_TIMEOUT);
    }

    public final void zaa(ResultCallback<? super R> paramResultCallback, R paramR)
    {
      sendMessage(obtainMessage(1, new Pair(paramResultCallback, paramR)));
    }
  }

  private final class zaa
  {
    private zaa()
    {
    }

    protected final void finalize()
      throws Throwable
    {
      BasePendingResult.zab(BasePendingResult.zaa(BasePendingResult.this));
      super.finalize();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.BasePendingResult
 * JD-Core Version:    0.6.2
 */