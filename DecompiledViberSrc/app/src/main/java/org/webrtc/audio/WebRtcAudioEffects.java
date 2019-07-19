package org.webrtc.audio;

import android.annotation.TargetApi;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.AudioEffect.Descriptor;
import android.media.audiofx.NoiseSuppressor;
import java.util.UUID;
import javax.annotation.Nullable;
import org.webrtc.Logging;

class WebRtcAudioEffects
{
  private static final UUID AOSP_ACOUSTIC_ECHO_CANCELER = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
  private static final UUID AOSP_NOISE_SUPPRESSOR = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");
  private static final boolean DEBUG = false;
  private static final String TAG = "WebRtcAudioEffectsExternal";

  @Nullable
  private static AudioEffect.Descriptor[] cachedEffects = null;

  @Nullable
  private AcousticEchoCanceler aec = null;

  @Nullable
  private NoiseSuppressor ns = null;
  private boolean shouldEnableAec = false;
  private boolean shouldEnableNs = false;

  public WebRtcAudioEffects()
  {
    Logging.d("WebRtcAudioEffectsExternal", "ctor" + WebRtcAudioUtils.getThreadInfo());
  }

  private static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new AssertionError("Expected condition to be true");
  }

  @TargetApi(18)
  private boolean effectTypeIsVoIP(UUID paramUUID)
  {
    if (!WebRtcAudioUtils.runningOnJellyBeanMR2OrHigher());
    while (((!AudioEffect.EFFECT_TYPE_AEC.equals(paramUUID)) || (!isAcousticEchoCancelerSupported())) && ((!AudioEffect.EFFECT_TYPE_NS.equals(paramUUID)) || (!isNoiseSuppressorSupported())))
      return false;
    return true;
  }

  @Nullable
  private static AudioEffect.Descriptor[] getAvailableEffects()
  {
    if (cachedEffects != null)
      return cachedEffects;
    cachedEffects = AudioEffect.queryEffects();
    return cachedEffects;
  }

  @TargetApi(18)
  public static boolean isAcousticEchoCancelerSupported()
  {
    return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AEC, AOSP_ACOUSTIC_ECHO_CANCELER);
  }

  @TargetApi(18)
  private static boolean isEffectTypeAvailable(UUID paramUUID1, UUID paramUUID2)
  {
    AudioEffect.Descriptor[] arrayOfDescriptor = getAvailableEffects();
    if (arrayOfDescriptor == null);
    label58: 
    while (true)
    {
      return false;
      int i = arrayOfDescriptor.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label58;
        AudioEffect.Descriptor localDescriptor = arrayOfDescriptor[j];
        if (localDescriptor.type.equals(paramUUID1))
        {
          if (localDescriptor.uuid.equals(paramUUID2))
            break;
          return true;
        }
      }
    }
  }

  @TargetApi(18)
  public static boolean isNoiseSuppressorSupported()
  {
    return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS, AOSP_NOISE_SUPPRESSOR);
  }

  public void enable(int paramInt)
  {
    boolean bool1 = true;
    Logging.d("WebRtcAudioEffectsExternal", "enable(audioSession=" + paramInt + ")");
    boolean bool2;
    boolean bool3;
    label54: boolean bool6;
    label105: String str3;
    label147: String str4;
    label185: label200: label243: String str1;
    label284: StringBuilder localStringBuilder2;
    if (this.aec == null)
    {
      bool2 = bool1;
      assertTrue(bool2);
      if (this.ns != null)
        break label342;
      bool3 = bool1;
      assertTrue(bool3);
      if (isAcousticEchoCancelerSupported())
      {
        this.aec = AcousticEchoCanceler.create(paramInt);
        if (this.aec == null)
          break label368;
        boolean bool5 = this.aec.getEnabled();
        if ((!this.shouldEnableAec) || (!isAcousticEchoCancelerSupported()))
          break label348;
        bool6 = bool1;
        if (this.aec.setEnabled(bool6) != 0)
          Logging.e("WebRtcAudioEffectsExternal", "Failed to set the AcousticEchoCanceler state");
        StringBuilder localStringBuilder3 = new StringBuilder().append("AcousticEchoCanceler: was ");
        if (!bool5)
          break label354;
        str3 = "enabled";
        StringBuilder localStringBuilder4 = localStringBuilder3.append(str3).append(", enable: ").append(bool6).append(", is now: ");
        if (!this.aec.getEnabled())
          break label361;
        str4 = "enabled";
        Logging.d("WebRtcAudioEffectsExternal", str4);
      }
      if (isNoiseSuppressorSupported())
      {
        this.ns = NoiseSuppressor.create(paramInt);
        if (this.ns == null)
          break label397;
        boolean bool4 = this.ns.getEnabled();
        if ((!this.shouldEnableNs) || (!isNoiseSuppressorSupported()))
          break label378;
        if (this.ns.setEnabled(bool1) != 0)
          Logging.e("WebRtcAudioEffectsExternal", "Failed to set the NoiseSuppressor state");
        StringBuilder localStringBuilder1 = new StringBuilder().append("NoiseSuppressor: was ");
        if (!bool4)
          break label383;
        str1 = "enabled";
        localStringBuilder2 = localStringBuilder1.append(str1).append(", enable: ").append(bool1).append(", is now: ");
        if (!this.ns.getEnabled())
          break label390;
      }
    }
    label390: for (String str2 = "enabled"; ; str2 = "disabled")
    {
      Logging.d("WebRtcAudioEffectsExternal", str2);
      return;
      bool2 = false;
      break;
      label342: bool3 = false;
      break label54;
      label348: bool6 = false;
      break label105;
      label354: str3 = "disabled";
      break label147;
      label361: str4 = "disabled";
      break label185;
      label368: Logging.e("WebRtcAudioEffectsExternal", "Failed to create the AcousticEchoCanceler instance");
      break label200;
      label378: bool1 = false;
      break label243;
      label383: str1 = "disabled";
      break label284;
    }
    label397: Logging.e("WebRtcAudioEffectsExternal", "Failed to create the NoiseSuppressor instance");
  }

  public void release()
  {
    Logging.d("WebRtcAudioEffectsExternal", "release");
    if (this.aec != null)
    {
      this.aec.release();
      this.aec = null;
    }
    if (this.ns != null)
    {
      this.ns.release();
      this.ns = null;
    }
  }

  public boolean setAEC(boolean paramBoolean)
  {
    Logging.d("WebRtcAudioEffectsExternal", "setAEC(" + paramBoolean + ")");
    if (!isAcousticEchoCancelerSupported())
    {
      Logging.w("WebRtcAudioEffectsExternal", "Platform AEC is not supported");
      this.shouldEnableAec = false;
      return false;
    }
    if ((this.aec != null) && (paramBoolean != this.shouldEnableAec))
    {
      Logging.e("WebRtcAudioEffectsExternal", "Platform AEC state can't be modified while recording");
      return false;
    }
    this.shouldEnableAec = paramBoolean;
    return true;
  }

  public boolean setNS(boolean paramBoolean)
  {
    Logging.d("WebRtcAudioEffectsExternal", "setNS(" + paramBoolean + ")");
    if (!isNoiseSuppressorSupported())
    {
      Logging.w("WebRtcAudioEffectsExternal", "Platform NS is not supported");
      this.shouldEnableNs = false;
      return false;
    }
    if ((this.ns != null) && (paramBoolean != this.shouldEnableNs))
    {
      Logging.e("WebRtcAudioEffectsExternal", "Platform NS state can't be modified while recording");
      return false;
    }
    this.shouldEnableNs = paramBoolean;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.audio.WebRtcAudioEffects
 * JD-Core Version:    0.6.2
 */