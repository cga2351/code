package androidx.media;

import android.support.v4.media.AudioAttributesCompat;
import android.support.v4.media.AudioAttributesImpl;
import androidx.versionedparcelable.a;

public final class AudioAttributesCompatParcelizer
{
  public static AudioAttributesCompat read(a parama)
  {
    AudioAttributesCompat localAudioAttributesCompat = new AudioAttributesCompat();
    localAudioAttributesCompat.mImpl = ((AudioAttributesImpl)parama.b(localAudioAttributesCompat.mImpl, 1));
    return localAudioAttributesCompat;
  }

  public static void write(AudioAttributesCompat paramAudioAttributesCompat, a parama)
  {
    parama.a(false, false);
    parama.a(paramAudioAttributesCompat.mImpl, 1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.media.AudioAttributesCompatParcelizer
 * JD-Core Version:    0.6.2
 */