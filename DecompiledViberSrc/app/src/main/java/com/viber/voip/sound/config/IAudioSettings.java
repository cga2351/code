package com.viber.voip.sound.config;

public abstract interface IAudioSettings
{
  public abstract void addListener(IAudioSettingsListener paramIAudioSettingsListener);

  public abstract int getAECMode();

  public abstract int getAGCMode();

  public abstract int getNSMode();

  public abstract int getRxAGCMode();

  public abstract int getRxNSMode();

  public abstract int getVADMode();

  public abstract void removeListener(IAudioSettingsListener paramIAudioSettingsListener);

  public abstract int setAECMode(int paramInt);

  public abstract int setAGCMode(int paramInt);

  public abstract int setNSMode(int paramInt);

  public abstract int setRxAGCMode(int paramInt);

  public abstract int setRxNSMode(int paramInt);

  public abstract int setVADMode(int paramInt);

  public static enum AudioCtl
  {
    static
    {
      AUCTL_AEC_MODE = new AudioCtl("AUCTL_AEC_MODE", 1);
      AUCTL_AGC_MODE = new AudioCtl("AUCTL_AGC_MODE", 2);
      AUCTL_RX_AGC_MODE = new AudioCtl("AUCTL_RX_AGC_MODE", 3);
      AUCTL_NS_MODE = new AudioCtl("AUCTL_NS_MODE", 4);
      AUCTL_RX_NS_MODE = new AudioCtl("AUCTL_RX_NS_MODE", 5);
      AUCTL_VAD_MODE = new AudioCtl("AUCTL_VAD_MODE", 6);
      AudioCtl[] arrayOfAudioCtl = new AudioCtl[7];
      arrayOfAudioCtl[0] = AUCTL_UNKNOWN;
      arrayOfAudioCtl[1] = AUCTL_AEC_MODE;
      arrayOfAudioCtl[2] = AUCTL_AGC_MODE;
      arrayOfAudioCtl[3] = AUCTL_RX_AGC_MODE;
      arrayOfAudioCtl[4] = AUCTL_NS_MODE;
      arrayOfAudioCtl[5] = AUCTL_RX_NS_MODE;
      arrayOfAudioCtl[6] = AUCTL_VAD_MODE;
    }
  }

  public static enum AudioModeCtl
  {
    static
    {
      AudioModeCtl[] arrayOfAudioModeCtl = new AudioModeCtl[2];
      arrayOfAudioModeCtl[0] = MODE_EARPIECE;
      arrayOfAudioModeCtl[1] = MODE_LOUDSPEAKER;
    }
  }

  public static abstract interface IAudioSettingsListener
  {
    public abstract void onAECChange(int paramInt1, int paramInt2);

    public abstract void onAGCChange(int paramInt1, int paramInt2);

    public abstract void onNSChange(int paramInt1, int paramInt2);

    public abstract void onRxAGCChange(int paramInt1, int paramInt2);

    public abstract void onRxNSChange(int paramInt1, int paramInt2);

    public abstract void onVADChange(int paramInt1, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.config.IAudioSettings
 * JD-Core Version:    0.6.2
 */