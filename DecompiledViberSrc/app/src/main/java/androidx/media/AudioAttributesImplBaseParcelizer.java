package androidx.media;

import android.support.v4.media.AudioAttributesImplBase;
import androidx.versionedparcelable.a;

public final class AudioAttributesImplBaseParcelizer
{
  public static AudioAttributesImplBase read(a parama)
  {
    AudioAttributesImplBase localAudioAttributesImplBase = new AudioAttributesImplBase();
    localAudioAttributesImplBase.mUsage = parama.b(localAudioAttributesImplBase.mUsage, 1);
    localAudioAttributesImplBase.mContentType = parama.b(localAudioAttributesImplBase.mContentType, 2);
    localAudioAttributesImplBase.mFlags = parama.b(localAudioAttributesImplBase.mFlags, 3);
    localAudioAttributesImplBase.mLegacyStream = parama.b(localAudioAttributesImplBase.mLegacyStream, 4);
    return localAudioAttributesImplBase;
  }

  public static void write(AudioAttributesImplBase paramAudioAttributesImplBase, a parama)
  {
    parama.a(false, false);
    parama.a(paramAudioAttributesImplBase.mUsage, 1);
    parama.a(paramAudioAttributesImplBase.mContentType, 2);
    parama.a(paramAudioAttributesImplBase.mFlags, 3);
    parama.a(paramAudioAttributesImplBase.mLegacyStream, 4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.media.AudioAttributesImplBaseParcelizer
 * JD-Core Version:    0.6.2
 */