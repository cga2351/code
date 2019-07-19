package com.viber.voip.sound.ptt;

public abstract interface AudioPlayer
{
  public abstract long getPlayingPositionInMillis();

  public abstract void interruptPlay(int paramInt);

  public abstract boolean isPaused();

  public abstract boolean isPlaying();

  public abstract boolean isStopped();

  public abstract void pause();

  public abstract void resume(long paramLong);

  public abstract void seek(long paramLong);

  public abstract void startPlay();

  public abstract void startPlay(long paramLong);

  public abstract void stopPlay();

  public abstract void switchStreams(boolean paramBoolean);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.ptt.AudioPlayer
 * JD-Core Version:    0.6.2
 */