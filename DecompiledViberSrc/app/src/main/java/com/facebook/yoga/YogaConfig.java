package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class YogaConfig
{
  public static int SPACING_TYPE = 1;
  private YogaLogger mLogger;
  long mNativePointer = jni_YGConfigNew();
  private YogaNodeCloneFunction mYogaNodeCloneFunction;

  static
  {
    SoLoader.loadLibrary("yoga");
  }

  public YogaConfig()
  {
    if (this.mNativePointer == 0L)
      throw new IllegalStateException("Failed to allocate native memory");
  }

  @DoNotStrip
  private final YogaNode cloneNode(YogaNode paramYogaNode1, YogaNode paramYogaNode2, int paramInt)
  {
    return this.mYogaNodeCloneFunction.cloneNode(paramYogaNode1, paramYogaNode2, paramInt);
  }

  private native void jni_YGConfigFree(long paramLong);

  private native long jni_YGConfigNew();

  private native void jni_YGConfigSetExperimentalFeatureEnabled(long paramLong, int paramInt, boolean paramBoolean);

  private native void jni_YGConfigSetHasCloneNodeFunc(long paramLong, boolean paramBoolean);

  private native void jni_YGConfigSetLogger(long paramLong, Object paramObject);

  private native void jni_YGConfigSetPointScaleFactor(long paramLong, float paramFloat);

  private native void jni_YGConfigSetPrintTreeFlag(long paramLong, boolean paramBoolean);

  private native void jni_YGConfigSetShouldDiffLayoutWithoutLegacyStretchBehaviour(long paramLong, boolean paramBoolean);

  private native void jni_YGConfigSetUseLegacyStretchBehaviour(long paramLong, boolean paramBoolean);

  private native void jni_YGConfigSetUseWebDefaults(long paramLong, boolean paramBoolean);

  protected void finalize()
    throws Throwable
  {
    try
    {
      jni_YGConfigFree(this.mNativePointer);
      return;
    }
    finally
    {
      super.finalize();
    }
  }

  public YogaLogger getLogger()
  {
    return this.mLogger;
  }

  public void setExperimentalFeatureEnabled(YogaExperimentalFeature paramYogaExperimentalFeature, boolean paramBoolean)
  {
    jni_YGConfigSetExperimentalFeatureEnabled(this.mNativePointer, paramYogaExperimentalFeature.intValue(), paramBoolean);
  }

  public void setLogger(YogaLogger paramYogaLogger)
  {
    this.mLogger = paramYogaLogger;
    jni_YGConfigSetLogger(this.mNativePointer, paramYogaLogger);
  }

  public void setOnCloneNode(YogaNodeCloneFunction paramYogaNodeCloneFunction)
  {
    this.mYogaNodeCloneFunction = paramYogaNodeCloneFunction;
    long l = this.mNativePointer;
    if (paramYogaNodeCloneFunction != null);
    for (boolean bool = true; ; bool = false)
    {
      jni_YGConfigSetHasCloneNodeFunc(l, bool);
      return;
    }
  }

  public void setPointScaleFactor(float paramFloat)
  {
    jni_YGConfigSetPointScaleFactor(this.mNativePointer, paramFloat);
  }

  public void setPrintTreeFlag(boolean paramBoolean)
  {
    jni_YGConfigSetPrintTreeFlag(this.mNativePointer, paramBoolean);
  }

  public void setShouldDiffLayoutWithoutLegacyStretchBehaviour(boolean paramBoolean)
  {
    jni_YGConfigSetShouldDiffLayoutWithoutLegacyStretchBehaviour(this.mNativePointer, paramBoolean);
  }

  public void setUseLegacyStretchBehaviour(boolean paramBoolean)
  {
    jni_YGConfigSetUseLegacyStretchBehaviour(this.mNativePointer, paramBoolean);
  }

  public void setUseWebDefaults(boolean paramBoolean)
  {
    jni_YGConfigSetUseWebDefaults(this.mNativePointer, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaConfig
 * JD-Core Version:    0.6.2
 */