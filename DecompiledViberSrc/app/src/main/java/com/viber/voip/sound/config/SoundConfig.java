package com.viber.voip.sound.config;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.sound.NativeMediaDelegate;

public class SoundConfig
{
  private AudioSettings[] _audioSettings;
  private VocoderSettings _vocoderSettings;

  public SoundConfig()
  {
    AudioSettings[] arrayOfAudioSettings = new AudioSettings[2];
    arrayOfAudioSettings[0] = new AudioSettings(null);
    arrayOfAudioSettings[1] = new AudioSettings(null);
    this._audioSettings = arrayOfAudioSettings;
    this._vocoderSettings = new VocoderSettings();
  }

  public int getAudioCtl(int paramInt1, int paramInt2, int paramInt3)
  {
    IAudioSettings localIAudioSettings = getAudioSettings(paramInt2);
    if (localIAudioSettings == null);
    do
    {
      return paramInt3;
      if (IAudioSettings.AudioCtl.AUCTL_AEC_MODE.ordinal() == paramInt1)
        return localIAudioSettings.getAECMode();
      if (IAudioSettings.AudioCtl.AUCTL_AGC_MODE.ordinal() == paramInt1)
        return localIAudioSettings.getAGCMode();
      if (IAudioSettings.AudioCtl.AUCTL_NS_MODE.ordinal() == paramInt1)
        return localIAudioSettings.getNSMode();
      if (IAudioSettings.AudioCtl.AUCTL_RX_AGC_MODE.ordinal() == paramInt1)
        return localIAudioSettings.getRxAGCMode();
      if (IAudioSettings.AudioCtl.AUCTL_RX_NS_MODE.ordinal() == paramInt1)
        return localIAudioSettings.getRxNSMode();
    }
    while (IAudioSettings.AudioCtl.AUCTL_VAD_MODE.ordinal() != paramInt1);
    return localIAudioSettings.getVADMode();
  }

  public IAudioSettings getAudioSettings(int paramInt)
  {
    if (paramInt < this._audioSettings.length)
      return this._audioSettings[paramInt];
    return null;
  }

  public int getMediaThreadPriority()
  {
    return -19;
  }

  public int getUiThreadPriority()
  {
    return -4;
  }

  public int getVocoderCtl(IVocoderSettings.VocoderCtl paramVocoderCtl, int paramInt1, int paramInt2)
  {
    int i = NativeMediaDelegate.getCodecCtl(paramVocoderCtl.ordinal(), paramInt1);
    if (-1 == i)
      return paramInt2;
    return i;
  }

  public IVocoderSettings getVocoderSettings()
  {
    return this._vocoderSettings;
  }

  public int setAudioCtl(int paramInt1, int paramInt2, int paramInt3)
  {
    IAudioSettings localIAudioSettings = getAudioSettings(paramInt2);
    if (localIAudioSettings == null);
    do
    {
      return -1;
      if (IAudioSettings.AudioCtl.AUCTL_AEC_MODE.ordinal() == paramInt1)
        return localIAudioSettings.setAECMode(paramInt3);
      if (IAudioSettings.AudioCtl.AUCTL_AGC_MODE.ordinal() == paramInt1)
        return localIAudioSettings.setAGCMode(paramInt3);
      if (IAudioSettings.AudioCtl.AUCTL_NS_MODE.ordinal() == paramInt1)
        return localIAudioSettings.setNSMode(paramInt3);
      if (IAudioSettings.AudioCtl.AUCTL_RX_AGC_MODE.ordinal() == paramInt1)
        return localIAudioSettings.setRxAGCMode(paramInt3);
      if (IAudioSettings.AudioCtl.AUCTL_RX_NS_MODE.ordinal() == paramInt1)
        return localIAudioSettings.setRxNSMode(paramInt3);
    }
    while (IAudioSettings.AudioCtl.AUCTL_VAD_MODE.ordinal() != paramInt1);
    return localIAudioSettings.setVADMode(paramInt3);
  }

  public int setVocoderCtl(IVocoderSettings.VocoderCtl paramVocoderCtl, int paramInt1, int paramInt2)
  {
    return NativeMediaDelegate.setCodecCtl(paramVocoderCtl.ordinal(), paramInt1, paramInt2);
  }

  public boolean useThreadPriorityBoost()
  {
    return true;
  }

  private class DbgAudioSettingsTracer
    implements IAudioSettings.IAudioSettingsListener
  {
    private final Logger L;

    DbgAudioSettingsTracer()
    {
      this(null);
    }

    DbgAudioSettingsTracer(String arg2)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("DbgAudioSettingsTracer");
      String str1;
      if (str1 != null);
      for (String str2 = "[" + str1 + "]"; ; str2 = "")
      {
        this.L = ViberEnv.getLogger(str2);
        return;
      }
    }

    public void onAECChange(int paramInt1, int paramInt2)
    {
    }

    public void onAGCChange(int paramInt1, int paramInt2)
    {
    }

    public void onNSChange(int paramInt1, int paramInt2)
    {
    }

    public void onRxAGCChange(int paramInt1, int paramInt2)
    {
    }

    public void onRxNSChange(int paramInt1, int paramInt2)
    {
    }

    public void onVADChange(int paramInt1, int paramInt2)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.config.SoundConfig
 * JD-Core Version:    0.6.2
 */