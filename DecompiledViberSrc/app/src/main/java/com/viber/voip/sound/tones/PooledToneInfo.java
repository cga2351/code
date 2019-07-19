package com.viber.voip.sound.tones;

public class PooledToneInfo
{
  private static final float DEFAULT_VOLUME = 1.0F;
  private final int mResourceId;
  private int mSoundId;
  private int mStreamId;
  final Enum<?> mTone;
  private float mVolume;

  PooledToneInfo(int paramInt, Enum<?> paramEnum)
  {
    this.mResourceId = paramInt;
    this.mTone = paramEnum;
    this.mVolume = 1.0F;
  }

  public PooledToneInfo(int paramInt, Enum<?> paramEnum, float paramFloat)
  {
    this.mResourceId = paramInt;
    this.mTone = paramEnum;
    this.mVolume = paramFloat;
  }

  public int getResourceId()
  {
    return this.mResourceId;
  }

  public int getSoundId()
  {
    return this.mSoundId;
  }

  public int getStreamId()
  {
    return this.mStreamId;
  }

  public float getVolume()
  {
    return this.mVolume;
  }

  void setSoundId(int paramInt)
  {
    this.mSoundId = paramInt;
  }

  void setStreamId(int paramInt)
  {
    this.mStreamId = paramInt;
  }

  public String toString()
  {
    return "PooledToneInfo{tone=" + this.mTone + ",resourceId=" + this.mResourceId + ",soundId=" + this.mSoundId + ", streamId=" + this.mStreamId + ", vol=" + this.mVolume + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.tones.PooledToneInfo
 * JD-Core Version:    0.6.2
 */