package com.viber.voip.sound.config;

import com.viber.voip.sound.NativeMediaDelegate;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class VocoderSettings
  implements IVocoderSettings
{
  Set<IVocoderSettings.IVocoderDescriptor> _vocoders = null;

  private Set<IVocoderSettings.IVocoderDescriptor> fillVocodersList()
  {
    int i = NativeMediaDelegate.getSupportedCodecsCount();
    TreeSet localTreeSet = new TreeSet(new Comparator()
    {
      public int compare(IVocoderSettings.IVocoderDescriptor paramAnonymousIVocoderDescriptor1, IVocoderSettings.IVocoderDescriptor paramAnonymousIVocoderDescriptor2)
      {
        return paramAnonymousIVocoderDescriptor1.getVocoderId() - paramAnonymousIVocoderDescriptor2.getVocoderId();
      }
    });
    for (int j = 0; j < i; j++)
    {
      String str = NativeMediaDelegate.getCodecName(j);
      localTreeSet.add(new VocoderDescriptor(NativeMediaDelegate.getCodecCtl(IVocoderSettings.VocoderCtl.VOECTL_CODEC_TYPE.ordinal(), j), str, NativeMediaDelegate.getCodecCtl(IVocoderSettings.VocoderCtl.VOECTL_CODEC_PAYLOAD.ordinal(), j), NativeMediaDelegate.getCodecCtl(IVocoderSettings.VocoderCtl.VOECTL_CODEC_BITRATE.ordinal(), j)));
    }
    return localTreeSet;
  }

  public Set<IVocoderSettings.IVocoderDescriptor> getSupportedCodecs()
  {
    try
    {
      if (this._vocoders == null)
        this._vocoders = fillVocodersList();
      Set localSet = this._vocoders;
      return localSet;
    }
    finally
    {
    }
  }

  private class VocoderDescriptor
    implements IVocoderSettings.IVocoderDescriptor
  {
    final int _bitrate;
    final int _ident;
    final String _name;
    final int _pltype;

    public VocoderDescriptor(int paramString, String paramInt1, int paramInt2, int arg5)
    {
      this._ident = paramString;
      this._name = paramInt1;
      this._pltype = paramInt2;
      int i;
      this._bitrate = i;
    }

    public int getVocoderBitrate()
    {
      return this._bitrate;
    }

    public int getVocoderId()
    {
      return this._ident;
    }

    public String getVocoderName()
    {
      return this._name;
    }

    public int getVocoderPayloadType()
    {
      return this._pltype;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.config.VocoderSettings
 * JD-Core Version:    0.6.2
 */