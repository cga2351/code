package android.support.v4.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(21)
class AudioAttributesImplApi21
  implements AudioAttributesImpl
{
  private static final String TAG = "AudioAttributesCompat21";
  static Method sAudioAttributesToLegacyStreamType;
  AudioAttributes mAudioAttributes;
  int mLegacyStreamType = -1;

  AudioAttributesImplApi21()
  {
  }

  AudioAttributesImplApi21(AudioAttributes paramAudioAttributes)
  {
    this(paramAudioAttributes, -1);
  }

  AudioAttributesImplApi21(AudioAttributes paramAudioAttributes, int paramInt)
  {
    this.mAudioAttributes = paramAudioAttributes;
    this.mLegacyStreamType = paramInt;
  }

  public static AudioAttributesImpl fromBundle(Bundle paramBundle)
  {
    if (paramBundle == null)
      return null;
    AudioAttributes localAudioAttributes = (AudioAttributes)paramBundle.getParcelable("android.support.v4.media.audio_attrs.FRAMEWORKS");
    if (localAudioAttributes == null)
      return null;
    return new AudioAttributesImplApi21(localAudioAttributes, paramBundle.getInt("android.support.v4.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
  }

  static Method getAudioAttributesToLegacyStreamTypeMethod()
  {
    try
    {
      if (sAudioAttributesToLegacyStreamType == null)
        sAudioAttributesToLegacyStreamType = AudioAttributes.class.getMethod("toLegacyStreamType", new Class[] { AudioAttributes.class });
      return sAudioAttributesToLegacyStreamType;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    return null;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AudioAttributesImplApi21))
      return false;
    AudioAttributesImplApi21 localAudioAttributesImplApi21 = (AudioAttributesImplApi21)paramObject;
    return this.mAudioAttributes.equals(localAudioAttributesImplApi21.mAudioAttributes);
  }

  public Object getAudioAttributes()
  {
    return this.mAudioAttributes;
  }

  public int getContentType()
  {
    return this.mAudioAttributes.getContentType();
  }

  public int getFlags()
  {
    return this.mAudioAttributes.getFlags();
  }

  public int getLegacyStreamType()
  {
    if (this.mLegacyStreamType != -1)
      return this.mLegacyStreamType;
    Method localMethod = getAudioAttributesToLegacyStreamTypeMethod();
    if (localMethod == null)
    {
      Log.w("AudioAttributesCompat21", "No AudioAttributes#toLegacyStreamType() on API: " + Build.VERSION.SDK_INT);
      return -1;
    }
    try
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.mAudioAttributes;
      int i = ((Integer)localMethod.invoke(null, arrayOfObject)).intValue();
      return i;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.w("AudioAttributesCompat21", "getLegacyStreamType() failed on API: " + Build.VERSION.SDK_INT, localIllegalAccessException);
      return -1;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label83: break label83;
    }
  }

  public int getRawLegacyStreamType()
  {
    return this.mLegacyStreamType;
  }

  public int getUsage()
  {
    return this.mAudioAttributes.getUsage();
  }

  public int getVolumeControlStream()
  {
    if (Build.VERSION.SDK_INT >= 26)
      return this.mAudioAttributes.getVolumeControlStream();
    return AudioAttributesCompat.toVolumeStreamType(true, getFlags(), getUsage());
  }

  public int hashCode()
  {
    return this.mAudioAttributes.hashCode();
  }

  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("android.support.v4.media.audio_attrs.FRAMEWORKS", this.mAudioAttributes);
    if (this.mLegacyStreamType != -1)
      localBundle.putInt("android.support.v4.media.audio_attrs.LEGACY_STREAM_TYPE", this.mLegacyStreamType);
    return localBundle;
  }

  public String toString()
  {
    return "AudioAttributesCompat: audioattributes=" + this.mAudioAttributes;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.media.AudioAttributesImplApi21
 * JD-Core Version:    0.6.2
 */