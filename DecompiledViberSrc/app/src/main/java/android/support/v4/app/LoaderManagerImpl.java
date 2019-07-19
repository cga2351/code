package android.support.v4.app;

import android.arch.lifecycle.h;
import android.arch.lifecycle.m;
import android.arch.lifecycle.n;
import android.arch.lifecycle.s;
import android.arch.lifecycle.t;
import android.arch.lifecycle.t.a;
import android.arch.lifecycle.u;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager
{
  static boolean DEBUG = false;
  static final String TAG = "LoaderManager";
  private final h mLifecycleOwner;
  private final LoaderViewModel mLoaderViewModel;

  LoaderManagerImpl(h paramh, u paramu)
  {
    this.mLifecycleOwner = paramh;
    this.mLoaderViewModel = LoaderViewModel.getInstance(paramu);
  }

  private <D> Loader<D> createAndInstallLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks, Loader<D> paramLoader)
  {
    Loader localLoader;
    try
    {
      this.mLoaderViewModel.startCreatingLoader();
      localLoader = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
      if (localLoader == null)
        throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
    }
    finally
    {
      this.mLoaderViewModel.finishCreatingLoader();
    }
    if ((localLoader.getClass().isMemberClass()) && (!Modifier.isStatic(localLoader.getClass().getModifiers())))
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + localLoader);
    LoaderInfo localLoaderInfo = new LoaderInfo(paramInt, paramBundle, localLoader, paramLoader);
    if (DEBUG)
      Log.v("LoaderManager", "  Created new loader " + localLoaderInfo);
    this.mLoaderViewModel.putLoader(paramInt, localLoaderInfo);
    this.mLoaderViewModel.finishCreatingLoader();
    return localLoaderInfo.setCallback(this.mLifecycleOwner, paramLoaderCallbacks);
  }

  public void destroyLoader(int paramInt)
  {
    if (this.mLoaderViewModel.isCreatingLoader())
      throw new IllegalStateException("Called while creating a loader");
    if (Looper.getMainLooper() != Looper.myLooper())
      throw new IllegalStateException("destroyLoader must be called on the main thread");
    if (DEBUG)
      Log.v("LoaderManager", "destroyLoader in " + this + " of " + paramInt);
    LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
    if (localLoaderInfo != null)
    {
      localLoaderInfo.destroy(true);
      this.mLoaderViewModel.removeLoader(paramInt);
    }
  }

  @Deprecated
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.mLoaderViewModel.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }

  public <D> Loader<D> getLoader(int paramInt)
  {
    if (this.mLoaderViewModel.isCreatingLoader())
      throw new IllegalStateException("Called while creating a loader");
    LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
    if (localLoaderInfo != null)
      return localLoaderInfo.getLoader();
    return null;
  }

  public boolean hasRunningLoaders()
  {
    return this.mLoaderViewModel.hasRunningLoaders();
  }

  public <D> Loader<D> initLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.mLoaderViewModel.isCreatingLoader())
      throw new IllegalStateException("Called while creating a loader");
    if (Looper.getMainLooper() != Looper.myLooper())
      throw new IllegalStateException("initLoader must be called on the main thread");
    LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
    if (DEBUG)
      Log.v("LoaderManager", "initLoader in " + this + ": args=" + paramBundle);
    if (localLoaderInfo == null)
      return createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks, null);
    if (DEBUG)
      Log.v("LoaderManager", "  Re-using existing loader " + localLoaderInfo);
    return localLoaderInfo.setCallback(this.mLifecycleOwner, paramLoaderCallbacks);
  }

  public void markForRedelivery()
  {
    this.mLoaderViewModel.markForRedelivery();
  }

  public <D> Loader<D> restartLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.mLoaderViewModel.isCreatingLoader())
      throw new IllegalStateException("Called while creating a loader");
    if (Looper.getMainLooper() != Looper.myLooper())
      throw new IllegalStateException("restartLoader must be called on the main thread");
    if (DEBUG)
      Log.v("LoaderManager", "restartLoader in " + this + ": args=" + paramBundle);
    LoaderInfo localLoaderInfo = this.mLoaderViewModel.getLoader(paramInt);
    Loader localLoader = null;
    if (localLoaderInfo != null)
      localLoader = localLoaderInfo.destroy(false);
    return createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks, localLoader);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(this.mLifecycleOwner, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }

  public static class LoaderInfo<D> extends m<D>
    implements Loader.OnLoadCompleteListener<D>
  {
    private final Bundle mArgs;
    private final int mId;
    private h mLifecycleOwner;
    private final Loader<D> mLoader;
    private LoaderManagerImpl.LoaderObserver<D> mObserver;
    private Loader<D> mPriorLoader;

    LoaderInfo(int paramInt, Bundle paramBundle, Loader<D> paramLoader1, Loader<D> paramLoader2)
    {
      this.mId = paramInt;
      this.mArgs = paramBundle;
      this.mLoader = paramLoader1;
      this.mPriorLoader = paramLoader2;
      this.mLoader.registerListener(paramInt, this);
    }

    Loader<D> destroy(boolean paramBoolean)
    {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "  Destroying: " + this);
      this.mLoader.cancelLoad();
      this.mLoader.abandon();
      LoaderManagerImpl.LoaderObserver localLoaderObserver = this.mObserver;
      if (localLoaderObserver != null)
      {
        removeObserver(localLoaderObserver);
        if (paramBoolean)
          localLoaderObserver.reset();
      }
      this.mLoader.unregisterListener(this);
      if (((localLoaderObserver != null) && (!localLoaderObserver.hasDeliveredData())) || (paramBoolean))
      {
        this.mLoader.reset();
        return this.mPriorLoader;
      }
      return this.mLoader;
    }

    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mId=");
      paramPrintWriter.print(this.mId);
      paramPrintWriter.print(" mArgs=");
      paramPrintWriter.println(this.mArgs);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mLoader=");
      paramPrintWriter.println(this.mLoader);
      this.mLoader.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      if (this.mObserver != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mCallbacks=");
        paramPrintWriter.println(this.mObserver);
        this.mObserver.dump(paramString + "  ", paramPrintWriter);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mData=");
      paramPrintWriter.println(getLoader().dataToString(getValue()));
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.println(hasActiveObservers());
    }

    Loader<D> getLoader()
    {
      return this.mLoader;
    }

    boolean isCallbackWaitingForData()
    {
      if (!hasActiveObservers());
      while ((this.mObserver == null) || (this.mObserver.hasDeliveredData()))
        return false;
      return true;
    }

    void markForRedelivery()
    {
      h localh = this.mLifecycleOwner;
      LoaderManagerImpl.LoaderObserver localLoaderObserver = this.mObserver;
      if ((localh != null) && (localLoaderObserver != null))
      {
        super.removeObserver(localLoaderObserver);
        observe(localh, localLoaderObserver);
      }
    }

    protected void onActive()
    {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "  Starting: " + this);
      this.mLoader.startLoading();
    }

    protected void onInactive()
    {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "  Stopping: " + this);
      this.mLoader.stopLoading();
    }

    public void onLoadComplete(Loader<D> paramLoader, D paramD)
    {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "onLoadComplete: " + this);
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        setValue(paramD);
        return;
      }
      if (LoaderManagerImpl.DEBUG)
        Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
      postValue(paramD);
    }

    public void removeObserver(n<? super D> paramn)
    {
      super.removeObserver(paramn);
      this.mLifecycleOwner = null;
      this.mObserver = null;
    }

    Loader<D> setCallback(h paramh, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
    {
      LoaderManagerImpl.LoaderObserver localLoaderObserver = new LoaderManagerImpl.LoaderObserver(this.mLoader, paramLoaderCallbacks);
      observe(paramh, localLoaderObserver);
      if (this.mObserver != null)
        removeObserver(this.mObserver);
      this.mLifecycleOwner = paramh;
      this.mObserver = localLoaderObserver;
      return this.mLoader;
    }

    public void setValue(D paramD)
    {
      super.setValue(paramD);
      if (this.mPriorLoader != null)
      {
        this.mPriorLoader.reset();
        this.mPriorLoader = null;
      }
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("LoaderInfo{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mId);
      localStringBuilder.append(" : ");
      DebugUtils.buildShortClassTag(this.mLoader, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }

  static class LoaderObserver<D>
    implements n<D>
  {
    private final LoaderManager.LoaderCallbacks<D> mCallback;
    private boolean mDeliveredData = false;
    private final Loader<D> mLoader;

    LoaderObserver(Loader<D> paramLoader, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
    {
      this.mLoader = paramLoader;
      this.mCallback = paramLoaderCallbacks;
    }

    public void dump(String paramString, PrintWriter paramPrintWriter)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mDeliveredData=");
      paramPrintWriter.println(this.mDeliveredData);
    }

    boolean hasDeliveredData()
    {
      return this.mDeliveredData;
    }

    public void onChanged(D paramD)
    {
      if (LoaderManagerImpl.DEBUG)
        Log.v("LoaderManager", "  onLoadFinished in " + this.mLoader + ": " + this.mLoader.dataToString(paramD));
      this.mCallback.onLoadFinished(this.mLoader, paramD);
      this.mDeliveredData = true;
    }

    void reset()
    {
      if (this.mDeliveredData)
      {
        if (LoaderManagerImpl.DEBUG)
          Log.v("LoaderManager", "  Resetting: " + this.mLoader);
        this.mCallback.onLoaderReset(this.mLoader);
      }
    }

    public String toString()
    {
      return this.mCallback.toString();
    }
  }

  static class LoaderViewModel extends s
  {
    private static final t.a FACTORY = new t.a()
    {
      public <T extends s> T create(Class<T> paramAnonymousClass)
      {
        return new LoaderManagerImpl.LoaderViewModel();
      }
    };
    private boolean mCreatingLoader = false;
    private SparseArrayCompat<LoaderManagerImpl.LoaderInfo> mLoaders = new SparseArrayCompat();

    static LoaderViewModel getInstance(u paramu)
    {
      return (LoaderViewModel)new t(paramu, FACTORY).a(LoaderViewModel.class);
    }

    public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      if (this.mLoaders.size() > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Loaders:");
        String str = paramString + "    ";
        for (int i = 0; i < this.mLoaders.size(); i++)
        {
          LoaderManagerImpl.LoaderInfo localLoaderInfo = (LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(this.mLoaders.keyAt(i));
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localLoaderInfo.toString());
          localLoaderInfo.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
      }
    }

    void finishCreatingLoader()
    {
      this.mCreatingLoader = false;
    }

    <D> LoaderManagerImpl.LoaderInfo<D> getLoader(int paramInt)
    {
      return (LoaderManagerImpl.LoaderInfo)this.mLoaders.get(paramInt);
    }

    boolean hasRunningLoaders()
    {
      int i = this.mLoaders.size();
      for (int j = 0; j < i; j++)
        if (((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(j)).isCallbackWaitingForData())
          return true;
      return false;
    }

    boolean isCreatingLoader()
    {
      return this.mCreatingLoader;
    }

    void markForRedelivery()
    {
      int i = this.mLoaders.size();
      for (int j = 0; j < i; j++)
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(j)).markForRedelivery();
    }

    protected void onCleared()
    {
      super.onCleared();
      int i = this.mLoaders.size();
      for (int j = 0; j < i; j++)
        ((LoaderManagerImpl.LoaderInfo)this.mLoaders.valueAt(j)).destroy(true);
      this.mLoaders.clear();
    }

    void putLoader(int paramInt, LoaderManagerImpl.LoaderInfo paramLoaderInfo)
    {
      this.mLoaders.put(paramInt, paramLoaderInfo);
    }

    void removeLoader(int paramInt)
    {
      this.mLoaders.remove(paramInt);
    }

    void startCreatingLoader()
    {
      this.mCreatingLoader = true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl
 * JD-Core Version:    0.6.2
 */