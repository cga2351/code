package com.viber.voip.sound.ptt;

public abstract interface AudioRecorder
{
  public abstract void interruptRecord(int paramInt);

  public abstract boolean isRecording();

  public abstract void startRecord();

  public abstract void stopRecord();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.ptt.AudioRecorder
 * JD-Core Version:    0.6.2
 */