package com.viber.jni.slashkey;

import com.google.d.f;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class SlashKeyAdapter
{
  private static final Logger L = ViberEnv.getLogger();
  private SlashKeyAdapterDelegate mDelegate;
  private long mNativePtr;

  SlashKeyAdapter(long paramLong, SlashKeyAdapterDelegate paramSlashKeyAdapterDelegate)
  {
    this.mNativePtr = paramLong;
    this.mDelegate = paramSlashKeyAdapterDelegate;
  }

  private static native void nativeDestroy(long paramLong);

  private static native boolean nativeRequestInitialServiceSettings(long paramLong, int paramInt);

  private static native boolean nativeRequestSlashItems(long paramLong, int paramInt, String paramString);

  private static native boolean nativeSetupLoginServiceSettings(long paramLong, int paramInt, String paramString);

  public void destroy()
  {
    if (this.mNativePtr != 0L)
    {
      nativeDestroy(this.mNativePtr);
      this.mNativePtr = 0L;
    }
  }

  public void finalize()
  {
    destroy();
  }

  public void requestInitialServiceSettings(int paramInt)
  {
    if (!nativeRequestInitialServiceSettings(this.mNativePtr, paramInt))
      this.mDelegate.onInitialServiceSettingsError(paramInt);
  }

  public void requestSlashItems(int paramInt, SlashKeyRequest paramSlashKeyRequest)
  {
    String str = new f().b(paramSlashKeyRequest);
    if (!nativeRequestSlashItems(this.mNativePtr, paramInt, str))
      this.mDelegate.onSlashItemsError(paramInt, "OTHER");
  }

  public void setupLoginServiceSettings(int paramInt, ServiceSettings paramServiceSettings)
  {
    String str = new f().b(paramServiceSettings);
    if (!nativeSetupLoginServiceSettings(this.mNativePtr, paramInt, str))
      this.mDelegate.onLoginServiceSettingsError(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.slashkey.SlashKeyAdapter
 * JD-Core Version:    0.6.2
 */