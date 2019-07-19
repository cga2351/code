package com.facebook.soloader;

import android.util.Log;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public abstract class NativeLibrary
{
  private static final String TAG = NativeLibrary.class.getName();
  private boolean mLibrariesLoaded = false;

  @Nullable
  private List<String> mLibraryNames;

  @Nullable
  private volatile UnsatisfiedLinkError mLinkError = null;
  private Boolean mLoadLibraries = Boolean.valueOf(true);
  private final Object mLock = new Object();

  protected NativeLibrary(List<String> paramList)
  {
    this.mLibraryNames = paramList;
  }

  public void ensureLoaded()
    throws UnsatisfiedLinkError
  {
    if (!loadLibraries())
      throw this.mLinkError;
  }

  @Nullable
  public UnsatisfiedLinkError getError()
  {
    return this.mLinkError;
  }

  protected void initialNativeCheck()
    throws UnsatisfiedLinkError
  {
  }

  @Nullable
  public boolean loadLibraries()
  {
    synchronized (this.mLock)
    {
      if (!this.mLoadLibraries.booleanValue())
      {
        boolean bool2 = this.mLibrariesLoaded;
        return bool2;
      }
    }
    try
    {
      if (this.mLibraryNames != null)
      {
        Iterator localIterator = this.mLibraryNames.iterator();
        while (localIterator.hasNext())
          SoLoader.loadLibrary((String)localIterator.next());
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Log.e(TAG, "Failed to load native lib (initial check): ", localUnsatisfiedLinkError);
      this.mLinkError = localUnsatisfiedLinkError;
      this.mLibrariesLoaded = false;
      while (true)
      {
        this.mLoadLibraries = Boolean.valueOf(false);
        boolean bool1 = this.mLibrariesLoaded;
        return bool1;
        localObject2 = finally;
        throw localObject2;
        initialNativeCheck();
        this.mLibrariesLoaded = true;
        this.mLibraryNames = null;
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        Log.e(TAG, "Failed to load native lib (other error): ", localThrowable);
        this.mLinkError = new UnsatisfiedLinkError("Failed loading libraries");
        this.mLinkError.initCause(localThrowable);
        this.mLibrariesLoaded = false;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.soloader.NativeLibrary
 * JD-Core Version:    0.6.2
 */