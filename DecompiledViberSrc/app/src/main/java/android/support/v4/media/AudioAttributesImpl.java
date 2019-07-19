package android.support.v4.media;

import android.os.Bundle;
import androidx.versionedparcelable.c;

abstract interface AudioAttributesImpl extends c
{
  public abstract Object getAudioAttributes();

  public abstract int getContentType();

  public abstract int getFlags();

  public abstract int getLegacyStreamType();

  public abstract int getRawLegacyStreamType();

  public abstract int getUsage();

  public abstract int getVolumeControlStream();

  public abstract Bundle toBundle();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.media.AudioAttributesImpl
 * JD-Core Version:    0.6.2
 */