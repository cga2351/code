package com.facebook.react.bridge;

public final class CallbackImpl
  implements Callback
{
  private final int mCallbackId;
  private boolean mInvoked;
  private final JSInstance mJSInstance;

  public CallbackImpl(JSInstance paramJSInstance, int paramInt)
  {
    this.mJSInstance = paramJSInstance;
    this.mCallbackId = paramInt;
    this.mInvoked = false;
  }

  public void invoke(Object[] paramArrayOfObject)
  {
    if (this.mInvoked)
      throw new RuntimeException("Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");
    this.mJSInstance.invokeCallback(this.mCallbackId, Arguments.fromJavaArgs(paramArrayOfObject));
    this.mInvoked = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.CallbackImpl
 * JD-Core Version:    0.6.2
 */