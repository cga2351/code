package android.support.v4.media;

import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.versionedparcelable.c;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AudioAttributesCompat
  implements c
{
  static final String AUDIO_ATTRIBUTES_CONTENT_TYPE = "android.support.v4.media.audio_attrs.CONTENT_TYPE";
  static final String AUDIO_ATTRIBUTES_FLAGS = "android.support.v4.media.audio_attrs.FLAGS";
  static final String AUDIO_ATTRIBUTES_FRAMEWORKS = "android.support.v4.media.audio_attrs.FRAMEWORKS";
  static final String AUDIO_ATTRIBUTES_LEGACY_STREAM_TYPE = "android.support.v4.media.audio_attrs.LEGACY_STREAM_TYPE";
  static final String AUDIO_ATTRIBUTES_USAGE = "android.support.v4.media.audio_attrs.USAGE";
  public static final int CONTENT_TYPE_MOVIE = 3;
  public static final int CONTENT_TYPE_MUSIC = 2;
  public static final int CONTENT_TYPE_SONIFICATION = 4;
  public static final int CONTENT_TYPE_SPEECH = 1;
  public static final int CONTENT_TYPE_UNKNOWN = 0;
  static final int FLAG_ALL = 1023;
  static final int FLAG_ALL_PUBLIC = 273;
  public static final int FLAG_AUDIBILITY_ENFORCED = 1;
  static final int FLAG_BEACON = 8;
  static final int FLAG_BYPASS_INTERRUPTION_POLICY = 64;
  static final int FLAG_BYPASS_MUTE = 128;
  static final int FLAG_DEEP_BUFFER = 512;
  public static final int FLAG_HW_AV_SYNC = 16;
  static final int FLAG_HW_HOTWORD = 32;
  static final int FLAG_LOW_LATENCY = 256;
  static final int FLAG_SCO = 4;
  static final int FLAG_SECURE = 2;
  static final int INVALID_STREAM_TYPE = -1;
  private static final int[] SDK_USAGES = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16 };
  private static final int SUPPRESSIBLE_CALL = 2;
  private static final int SUPPRESSIBLE_NOTIFICATION = 1;
  private static final SparseIntArray SUPPRESSIBLE_USAGES = new SparseIntArray();
  private static final String TAG = "AudioAttributesCompat";
  public static final int USAGE_ALARM = 4;
  public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
  public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
  public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
  public static final int USAGE_ASSISTANT = 16;
  public static final int USAGE_GAME = 14;
  public static final int USAGE_MEDIA = 1;
  public static final int USAGE_NOTIFICATION = 5;
  public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
  public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
  public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
  public static final int USAGE_NOTIFICATION_EVENT = 10;
  public static final int USAGE_NOTIFICATION_RINGTONE = 6;
  public static final int USAGE_UNKNOWN = 0;
  private static final int USAGE_VIRTUAL_SOURCE = 15;
  public static final int USAGE_VOICE_COMMUNICATION = 2;
  public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;
  static boolean sForceLegacyBehavior;
  AudioAttributesImpl mImpl;

  static
  {
    SUPPRESSIBLE_USAGES.put(5, 1);
    SUPPRESSIBLE_USAGES.put(6, 2);
    SUPPRESSIBLE_USAGES.put(7, 2);
    SUPPRESSIBLE_USAGES.put(8, 1);
    SUPPRESSIBLE_USAGES.put(9, 1);
    SUPPRESSIBLE_USAGES.put(10, 1);
  }

  AudioAttributesCompat()
  {
  }

  AudioAttributesCompat(AudioAttributesImpl paramAudioAttributesImpl)
  {
    this.mImpl = paramAudioAttributesImpl;
  }

  public static AudioAttributesCompat fromBundle(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 21);
    for (AudioAttributesImpl localAudioAttributesImpl = AudioAttributesImplApi21.fromBundle(paramBundle); localAudioAttributesImpl == null; localAudioAttributesImpl = AudioAttributesImplBase.fromBundle(paramBundle))
      return null;
    return new AudioAttributesCompat(localAudioAttributesImpl);
  }

  public static void setForceLegacyBehavior(boolean paramBoolean)
  {
    sForceLegacyBehavior = paramBoolean;
  }

  static int toVolumeStreamType(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0x1) == 1)
    {
      if (paramBoolean)
        return 1;
      return 7;
    }
    if ((paramInt1 & 0x4) == 4)
    {
      if (paramBoolean)
        return 0;
      return 6;
    }
    switch (paramInt2)
    {
    case 13:
    case 15:
    default:
      if (paramBoolean)
        throw new IllegalArgumentException("Unknown usage value " + paramInt2 + " in audio attributes");
      break;
    case 1:
    case 12:
    case 14:
    case 16:
      return 3;
    case 2:
      return 0;
    case 3:
      int i = 0;
      if (paramBoolean);
      while (true)
      {
        return i;
        i = 8;
      }
    case 4:
      return 4;
    case 6:
      return 2;
    case 5:
    case 7:
    case 8:
    case 9:
    case 10:
      return 5;
    case 11:
      return 10;
    case 0:
      if (paramBoolean)
        return -2147483648;
      return 3;
    }
    return 3;
  }

  static int toVolumeStreamType(boolean paramBoolean, AudioAttributesCompat paramAudioAttributesCompat)
  {
    return toVolumeStreamType(paramBoolean, paramAudioAttributesCompat.getFlags(), paramAudioAttributesCompat.getUsage());
  }

  static int usageForStreamType(int paramInt)
  {
    int i = 2;
    switch (paramInt)
    {
    case 9:
    default:
      i = 0;
    case 0:
    case 6:
      return i;
    case 1:
    case 7:
      return 13;
    case 2:
      return 6;
    case 3:
      return 1;
    case 4:
      return 4;
    case 5:
      return 5;
    case 8:
      return 3;
    case 10:
    }
    return 11;
  }

  static String usageToString(int paramInt)
  {
    switch (paramInt)
    {
    case 15:
    default:
      return "unknown usage " + paramInt;
    case 0:
      return "USAGE_UNKNOWN";
    case 1:
      return "USAGE_MEDIA";
    case 2:
      return "USAGE_VOICE_COMMUNICATION";
    case 3:
      return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
    case 4:
      return "USAGE_ALARM";
    case 5:
      return "USAGE_NOTIFICATION";
    case 6:
      return "USAGE_NOTIFICATION_RINGTONE";
    case 7:
      return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
    case 8:
      return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
    case 9:
      return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
    case 10:
      return "USAGE_NOTIFICATION_EVENT";
    case 11:
      return "USAGE_ASSISTANCE_ACCESSIBILITY";
    case 12:
      return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
    case 13:
      return "USAGE_ASSISTANCE_SONIFICATION";
    case 14:
      return "USAGE_GAME";
    case 16:
    }
    return "USAGE_ASSISTANT";
  }

  public static AudioAttributesCompat wrap(Object paramObject)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (!sForceLegacyBehavior))
    {
      AudioAttributesImplApi21 localAudioAttributesImplApi21 = new AudioAttributesImplApi21((AudioAttributes)paramObject);
      AudioAttributesCompat localAudioAttributesCompat = new AudioAttributesCompat();
      localAudioAttributesCompat.mImpl = localAudioAttributesImplApi21;
      return localAudioAttributesCompat;
    }
    return null;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudioAttributesCompat));
    AudioAttributesCompat localAudioAttributesCompat;
    do
    {
      return false;
      localAudioAttributesCompat = (AudioAttributesCompat)paramObject;
      if (this.mImpl != null)
        break;
    }
    while (localAudioAttributesCompat.mImpl != null);
    return true;
    return this.mImpl.equals(localAudioAttributesCompat.mImpl);
  }

  public int getContentType()
  {
    return this.mImpl.getContentType();
  }

  public int getFlags()
  {
    return this.mImpl.getFlags();
  }

  public int getLegacyStreamType()
  {
    return this.mImpl.getLegacyStreamType();
  }

  int getRawLegacyStreamType()
  {
    return this.mImpl.getRawLegacyStreamType();
  }

  public int getUsage()
  {
    return this.mImpl.getUsage();
  }

  public int getVolumeControlStream()
  {
    return this.mImpl.getVolumeControlStream();
  }

  public int hashCode()
  {
    return this.mImpl.hashCode();
  }

  public Bundle toBundle()
  {
    return this.mImpl.toBundle();
  }

  public String toString()
  {
    return this.mImpl.toString();
  }

  public Object unwrap()
  {
    return this.mImpl.getAudioAttributes();
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface AttributeContentType
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface AttributeUsage
  {
  }

  static abstract class AudioManagerHidden
  {
    public static final int STREAM_ACCESSIBILITY = 10;
    public static final int STREAM_BLUETOOTH_SCO = 6;
    public static final int STREAM_SYSTEM_ENFORCED = 7;
    public static final int STREAM_TTS = 9;
  }

  public static class Builder
  {
    private int mContentType = 0;
    private int mFlags = 0;
    private int mLegacyStream = -1;
    private int mUsage = 0;

    public Builder()
    {
    }

    public Builder(AudioAttributesCompat paramAudioAttributesCompat)
    {
      this.mUsage = paramAudioAttributesCompat.getUsage();
      this.mContentType = paramAudioAttributesCompat.getContentType();
      this.mFlags = paramAudioAttributesCompat.getFlags();
      this.mLegacyStream = paramAudioAttributesCompat.getRawLegacyStreamType();
    }

    public AudioAttributesCompat build()
    {
      AudioAttributes.Builder localBuilder;
      if ((!AudioAttributesCompat.sForceLegacyBehavior) && (Build.VERSION.SDK_INT >= 21))
      {
        localBuilder = new AudioAttributes.Builder().setContentType(this.mContentType).setFlags(this.mFlags).setUsage(this.mUsage);
        if (this.mLegacyStream != -1)
          localBuilder.setLegacyStreamType(this.mLegacyStream);
      }
      for (Object localObject = new AudioAttributesImplApi21(localBuilder.build(), this.mLegacyStream); ; localObject = new AudioAttributesImplBase(this.mContentType, this.mFlags, this.mUsage, this.mLegacyStream))
        return new AudioAttributesCompat((AudioAttributesImpl)localObject);
    }

    public Builder setContentType(int paramInt)
    {
      switch (paramInt)
      {
      default:
        this.mUsage = 0;
        return this;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
      this.mContentType = paramInt;
      return this;
    }

    public Builder setFlags(int paramInt)
    {
      this.mFlags = (paramInt & 0x3FF | this.mFlags);
      return this;
    }

    Builder setInternalLegacyStreamType(int paramInt)
    {
      switch (paramInt)
      {
      default:
        Log.e("AudioAttributesCompat", "Invalid stream type " + paramInt + " for AudioAttributesCompat");
      case 0:
      case 7:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 8:
      case 9:
      case 10:
      }
      while (true)
      {
        this.mUsage = AudioAttributesCompat.usageForStreamType(paramInt);
        return this;
        this.mContentType = 1;
        continue;
        this.mFlags = (0x1 | this.mFlags);
        this.mContentType = 4;
        continue;
        this.mContentType = 4;
        continue;
        this.mContentType = 2;
        continue;
        this.mContentType = 4;
        continue;
        this.mContentType = 4;
        continue;
        this.mContentType = 1;
        this.mFlags = (0x4 | this.mFlags);
        continue;
        this.mContentType = 4;
        continue;
        this.mContentType = 4;
        continue;
        this.mContentType = 1;
      }
    }

    public Builder setLegacyStreamType(int paramInt)
    {
      if (paramInt == 10)
        throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
      this.mLegacyStream = paramInt;
      if (Build.VERSION.SDK_INT >= 21)
        this = setInternalLegacyStreamType(paramInt);
      return this;
    }

    public Builder setUsage(int paramInt)
    {
      switch (paramInt)
      {
      default:
        this.mUsage = 0;
        return this;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
        this.mUsage = paramInt;
        return this;
      case 16:
      }
      if ((!AudioAttributesCompat.sForceLegacyBehavior) && (Build.VERSION.SDK_INT > 25))
      {
        this.mUsage = paramInt;
        return this;
      }
      this.mUsage = 12;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.media.AudioAttributesCompat
 * JD-Core Version:    0.6.2
 */