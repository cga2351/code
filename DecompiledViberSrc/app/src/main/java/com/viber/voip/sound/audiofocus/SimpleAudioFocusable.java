package com.viber.voip.sound.audiofocus;

public abstract class SimpleAudioFocusable
  implements AudioFocusable
{
  public void onGainAudioFocusMayDuck()
  {
    onGainAudioFocus();
  }

  public void onGainAudioFocusTransient()
  {
    onGainAudioFocus();
  }

  public void onLossAudioFocusCanDuck()
  {
    onLossAudioFocus();
  }

  public void onLossAudioFocusTransient()
  {
    onLossAudioFocus();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.audiofocus.SimpleAudioFocusable
 * JD-Core Version:    0.6.2
 */