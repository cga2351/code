package com.viber.voip.sound;

public class NativeMediaDelegate
{
  public static final int ENGINE_STATUS_INCAPABLE = 0;
  public static final int ENGINE_STATUS_VIDEO_AVAILABLE = 2;
  public static final int ENGINE_STATUS_VOICE_AVAILABLE = 1;

  public static int addLocalVideoRenderer(long paramLong, Object paramObject)
  {
    return 0;
  }

  public static int addRemoteVideoRenderer(long paramLong, Object paramObject, int paramInt)
  {
    return 0;
  }

  public static int getCodecBitrate()
  {
    return NativeMediaDelegateExtra.getCodecBitrate();
  }

  public static int getCodecCtl(int paramInt1, int paramInt2)
  {
    return 0;
  }

  public static String getCodecName(int paramInt)
  {
    return "lol";
  }

  public static int getEngineStatus()
  {
    return 2;
  }

  public static int getSupportedCodecsCount()
  {
    return 0;
  }

  public static boolean havingValidVoiceChannel()
  {
    return NativeMediaDelegateExtra.havingValidVoiceChannel();
  }

  public static boolean isVP9Builtin()
  {
    return NativeMediaDelegateExtra.isVP9Builtin();
  }

  public static boolean isVideoSupportBuiltin()
  {
    return NativeMediaDelegateExtra.isVideoSupportBuiltin();
  }

  public static int removeLocalVideoRenderer(long paramLong, Object paramObject, int paramInt)
  {
    return 0;
  }

  public static int removeRemoteVideoRenderer(long paramLong, Object paramObject, int paramInt)
  {
    return 0;
  }

  public static void renewRemoteVideoRenderer(Object paramObject)
  {
  }

  public static int resumeSound(boolean paramBoolean)
  {
    return NativeMediaDelegateExtra.resumeSound(paramBoolean);
  }

  public static int setAECMode(int paramInt)
  {
    return NativeMediaDelegateExtra.setAECMode(paramInt);
  }

  public static void setCodecBitrate(int paramInt)
  {
    NativeMediaDelegateExtra.setCodecBitrate(paramInt);
  }

  public static int setCodecCtl(int paramInt1, int paramInt2, int paramInt3)
  {
    return 0;
  }

  public static void setDeviceFlags(int paramInt)
  {
  }

  public static int setSpeechEnhancementsModes(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return 0;
  }

  public static boolean shouldUseSpeakers(boolean paramBoolean)
  {
    return NativeMediaDelegateExtra.shouldUseSpeakers(paramBoolean);
  }

  public static int suspendSound(boolean paramBoolean)
  {
    return NativeMediaDelegateExtra.suspendSound(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.NativeMediaDelegate
 * JD-Core Version:    0.6.2
 */