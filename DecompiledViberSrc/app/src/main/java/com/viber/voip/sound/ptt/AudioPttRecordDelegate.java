package com.viber.voip.sound.ptt;

public abstract interface AudioPttRecordDelegate
{
  public abstract void onRecordError(int paramInt);

  public abstract void onRecordFinished(int paramInt1, int paramInt2, short[] paramArrayOfShort, int paramInt3, short paramShort);

  public abstract void onRecordStarted(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.ptt.AudioPttRecordDelegate
 * JD-Core Version:    0.6.2
 */