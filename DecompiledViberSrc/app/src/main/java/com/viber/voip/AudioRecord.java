package com.viber.voip;

import com.viber.dexshared.Logger;
import java.nio.ByteBuffer;

public class AudioRecord
{
  private static final int AUDIOHANDLER_MAGIC = 2;
  private static final Logger L;
  private static final boolean USE_NATIVE_CALLBACKS = true;
  public static byte[] buffer;
  static int minBufferSize;
  android.media.AudioRecord mPlatformAudioRecord;
  int oActiveObject = 0;
  int[] sampleRate = { 44100, 22050, 11025, 8000 };

  static
  {
    if (!AudioRecord.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      L = ViberEnv.getLogger("AudioRecorder-JAVA");
      minBufferSize = android.media.AudioRecord.getMinBufferSize(44100, 2, 2);
      buffer = null;
      return;
    }
  }

  public AudioRecord(int paramInt)
  {
    setActiveObjectCallback(paramInt);
  }

  private void setActiveObjectCallback(int paramInt)
  {
    this.oActiveObject = paramInt;
  }

  public static native int staticinit();

  public native int nativeSet(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);

  public native void nativeStart(int paramInt);

  public native void nativeStop(int paramInt);

  public int read(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (this.mPlatformAudioRecord == null)
      return -1;
    assert (this.mPlatformAudioRecord != null);
    return this.mPlatformAudioRecord.read(paramByteBuffer, paramInt);
  }

  public void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mPlatformAudioRecord = new android.media.AudioRecord(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    if (this.mPlatformAudioRecord.getState() != 1)
    {
      this.mPlatformAudioRecord.release();
      this.mPlatformAudioRecord = null;
    }
    if (this.mPlatformAudioRecord != null)
      nativeSet(this.oActiveObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }

  public void startRecording()
  {
    assert (this.mPlatformAudioRecord != null);
    nativeStart(this.oActiveObject);
    this.mPlatformAudioRecord.startRecording();
  }

  public void stop()
  {
    if (this.mPlatformAudioRecord == null)
      return;
    assert (this.mPlatformAudioRecord != null);
    nativeStop(this.oActiveObject);
    this.mPlatformAudioRecord.stop();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.AudioRecord
 * JD-Core Version:    0.6.2
 */