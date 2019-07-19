package com.viber.voip.sound;

public class NativeMediaDelegateExtra
{
  public static native int getCodecBitrate();

  public static native boolean havingValidVoiceChannel();

  public static native boolean isVP9Builtin();

  public static native boolean isVideoSupportBuiltin();

  public static native int resumeSound(boolean paramBoolean);

  public static native int setAECMode(int paramInt);

  public static native void setCodecBitrate(int paramInt);

  public static native boolean shouldUseSpeakers(boolean paramBoolean);

  public static native int suspendSound(boolean paramBoolean);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.NativeMediaDelegateExtra
 * JD-Core Version:    0.6.2
 */