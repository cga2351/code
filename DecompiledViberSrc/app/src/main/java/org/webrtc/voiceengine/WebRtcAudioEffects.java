package org.webrtc.voiceengine;

import android.annotation.TargetApi;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.AudioEffect.Descriptor;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import org.webrtc.Logging;

public class WebRtcAudioEffects
{
  private static final UUID AOSP_ACOUSTIC_ECHO_CANCELER = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
  private static final UUID AOSP_NOISE_SUPPRESSOR = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");
  private static final boolean DEBUG = false;
  private static final String TAG = "WebRtcAudioEffects";

  @Nullable
  private static AudioEffect.Descriptor[] cachedEffects = null;

  @Nullable
  private AcousticEchoCanceler aec = null;

  @Nullable
  private NoiseSuppressor ns = null;
  private boolean shouldEnableAec = false;
  private boolean shouldEnableNs = false;

  private WebRtcAudioEffects()
  {
    Logging.d("WebRtcAudioEffects", "ctor" + WebRtcAudioUtils.getThreadInfo());
  }

  private static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new AssertionError("Expected condition to be true");
  }

  public static boolean canUseAcousticEchoCanceler()
  {
    if ((isAcousticEchoCancelerSupported()) && (!WebRtcAudioUtils.useWebRtcBasedAcousticEchoCanceler()) && (!isAcousticEchoCancelerBlacklisted()) && (!isAcousticEchoCancelerExcludedByUUID()));
    for (boolean bool = true; ; bool = false)
    {
      Logging.d("WebRtcAudioEffects", "canUseAcousticEchoCanceler: " + bool);
      return bool;
    }
  }

  public static boolean canUseNoiseSuppressor()
  {
    if ((isNoiseSuppressorSupported()) && (!WebRtcAudioUtils.useWebRtcBasedNoiseSuppressor()) && (!isNoiseSuppressorBlacklisted()) && (!isNoiseSuppressorExcludedByUUID()));
    for (boolean bool = true; ; bool = false)
    {
      Logging.d("WebRtcAudioEffects", "canUseNoiseSuppressor: " + bool);
      return bool;
    }
  }

  public static WebRtcAudioEffects create()
  {
    return new WebRtcAudioEffects();
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

  public static boolean isAcousticEchoCancelerBlacklisted()
  {
    boolean bool = WebRtcAudioUtils.getBlackListedModelsForAecUsage().contains(Build.MODEL);
    if (bool)
      Logging.w("WebRtcAudioEffects", Build.MODEL + " is blacklisted for HW AEC usage!");
    return bool;
  }

  @TargetApi(18)
  private static boolean isAcousticEchoCancelerEffectAvailable()
  {
    return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AEC);
  }

  @TargetApi(18)
  private static boolean isAcousticEchoCancelerExcludedByUUID()
  {
    AudioEffect.Descriptor[] arrayOfDescriptor = getAvailableEffects();
    int i = arrayOfDescriptor.length;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        AudioEffect.Descriptor localDescriptor = arrayOfDescriptor[j];
        if ((localDescriptor.type.equals(AudioEffect.EFFECT_TYPE_AEC)) && (localDescriptor.uuid.equals(AOSP_ACOUSTIC_ECHO_CANCELER)))
          bool = true;
      }
      else
      {
        return bool;
      }
    }
  }

  public static boolean isAcousticEchoCancelerSupported()
  {
    return isAcousticEchoCancelerEffectAvailable();
  }

  private static boolean isEffectTypeAvailable(UUID paramUUID)
  {
    AudioEffect.Descriptor[] arrayOfDescriptor = getAvailableEffects();
    if (arrayOfDescriptor == null);
    while (true)
    {
      return false;
      int i = arrayOfDescriptor.length;
      for (int j = 0; j < i; j++)
        if (arrayOfDescriptor[j].type.equals(paramUUID))
          return true;
    }
  }

  public static boolean isNoiseSuppressorBlacklisted()
  {
    boolean bool = WebRtcAudioUtils.getBlackListedModelsForNsUsage().contains(Build.MODEL);
    if (bool)
      Logging.w("WebRtcAudioEffects", Build.MODEL + " is blacklisted for HW NS usage!");
    return bool;
  }

  @TargetApi(18)
  private static boolean isNoiseSuppressorEffectAvailable()
  {
    return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS);
  }

  @TargetApi(18)
  private static boolean isNoiseSuppressorExcludedByUUID()
  {
    AudioEffect.Descriptor[] arrayOfDescriptor = getAvailableEffects();
    int i = arrayOfDescriptor.length;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        AudioEffect.Descriptor localDescriptor = arrayOfDescriptor[j];
        if ((localDescriptor.type.equals(AudioEffect.EFFECT_TYPE_NS)) && (localDescriptor.uuid.equals(AOSP_NOISE_SUPPRESSOR)))
          bool = true;
      }
      else
      {
        return bool;
      }
    }
  }

  public static boolean isNoiseSuppressorSupported()
  {
    return isNoiseSuppressorEffectAvailable();
  }

  public void enable(int paramInt)
  {
    boolean bool1 = true;
    Logging.d("WebRtcAudioEffects", "enable(audioSession=" + paramInt + ")");
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
        if ((!this.shouldEnableAec) || (!canUseAcousticEchoCanceler()))
          break label348;
        bool6 = bool1;
        if (this.aec.setEnabled(bool6) != 0)
          Logging.e("WebRtcAudioEffects", "Failed to set the AcousticEchoCanceler state");
        StringBuilder localStringBuilder3 = new StringBuilder().append("AcousticEchoCanceler: was ");
        if (!bool5)
          break label354;
        str3 = "enabled";
        StringBuilder localStringBuilder4 = localStringBuilder3.append(str3).append(", enable: ").append(bool6).append(", is now: ");
        if (!this.aec.getEnabled())
          break label361;
        str4 = "enabled";
        Logging.d("WebRtcAudioEffects", str4);
      }
      if (isNoiseSuppressorSupported())
      {
        this.ns = NoiseSuppressor.create(paramInt);
        if (this.ns == null)
          break label397;
        boolean bool4 = this.ns.getEnabled();
        if ((!this.shouldEnableNs) || (!canUseNoiseSuppressor()))
          break label378;
        if (this.ns.setEnabled(bool1) != 0)
          Logging.e("WebRtcAudioEffects", "Failed to set the NoiseSuppressor state");
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
      Logging.d("WebRtcAudioEffects", str2);
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
      label368: Logging.e("WebRtcAudioEffects", "Failed to create the AcousticEchoCanceler instance");
      break label200;
      label378: bool1 = false;
      break label243;
      label383: str1 = "disabled";
      break label284;
    }
    label397: Logging.e("WebRtcAudioEffects", "Failed to create the NoiseSuppressor instance");
  }

  public void release()
  {
    Logging.d("WebRtcAudioEffects", "release");
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
    Logging.d("WebRtcAudioEffects", "setAEC(" + paramBoolean + ")");
    if (!canUseAcousticEchoCanceler())
    {
      Logging.w("WebRtcAudioEffects", "Platform AEC is not supported");
      this.shouldEnableAec = false;
      return false;
    }
    if ((this.aec != null) && (paramBoolean != this.shouldEnableAec))
    {
      Logging.e("WebRtcAudioEffects", "Platform AEC state can't be modified while recording");
      return false;
    }
    this.shouldEnableAec = paramBoolean;
    return true;
  }

  public boolean setNS(boolean paramBoolean)
  {
    Logging.d("WebRtcAudioEffects", "setNS(" + paramBoolean + ")");
    if (!canUseNoiseSuppressor())
    {
      Logging.w("WebRtcAudioEffects", "Platform NS is not supported");
      this.shouldEnableNs = false;
      return false;
    }
    if ((this.ns != null) && (paramBoolean != this.shouldEnableNs))
    {
      Logging.e("WebRtcAudioEffects", "Platform NS state can't be modified while recording");
      return false;
    }
    this.shouldEnableNs = paramBoolean;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.voiceengine.WebRtcAudioEffects
 * JD-Core Version:    0.6.2
 */