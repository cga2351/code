package com.viber.voip.sound.audiofocus;

public abstract interface AudioFocusable
{
  public abstract void onGainAudioFocus();

  public abstract void onGainAudioFocusMayDuck();

  public abstract void onGainAudioFocusTransient();

  public abstract void onLossAudioFocus();

  public abstract void onLossAudioFocusCanDuck();

  public abstract void onLossAudioFocusTransient();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.audiofocus.AudioFocusable
 * JD-Core Version:    0.6.2
 */