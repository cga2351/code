package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class HybridData
{

  @DoNotStrip
  private Destructor mDestructor = new Destructor(this);

  static
  {
    SoLoader.loadLibrary("fb");
  }

  public boolean isValid()
  {
    return this.mDestructor.mNativePointer != 0L;
  }

  public void resetNative()
  {
    try
    {
      this.mDestructor.destruct();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static class Destructor extends DestructorThread.Destructor
  {

    @DoNotStrip
    private long mNativePointer;

    Destructor(Object paramObject)
    {
      super();
    }

    static native void deleteNative(long paramLong);

    void destruct()
    {
      deleteNative(this.mNativePointer);
      this.mNativePointer = 0L;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.jni.HybridData
 * JD-Core Version:    0.6.2
 */