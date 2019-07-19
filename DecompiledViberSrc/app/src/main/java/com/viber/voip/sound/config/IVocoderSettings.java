package com.viber.voip.sound.config;

import java.util.Set;

public abstract interface IVocoderSettings
{
  public abstract Set<IVocoderDescriptor> getSupportedCodecs();

  public static abstract interface IVocoderDescriptor
  {
    public abstract int getVocoderBitrate();

    public abstract int getVocoderId();

    public abstract String getVocoderName();

    public abstract int getVocoderPayloadType();
  }

  public static enum VocoderCtl
  {
    static
    {
      VOECTL_CODEC_TYPE = new VocoderCtl("VOECTL_CODEC_TYPE", 1);
      VOECTL_CODEC_BITRATE = new VocoderCtl("VOECTL_CODEC_BITRATE", 2);
      VOECTL_CODEC_PAYLOAD = new VocoderCtl("VOECTL_CODEC_PAYLOAD", 3);
      VOECTL_FORCE_CODEC = new VocoderCtl("VOECTL_FORCE_CODEC", 4);
      VocoderCtl[] arrayOfVocoderCtl = new VocoderCtl[5];
      arrayOfVocoderCtl[0] = VOECTL_UNKNOWN;
      arrayOfVocoderCtl[1] = VOECTL_CODEC_TYPE;
      arrayOfVocoderCtl[2] = VOECTL_CODEC_BITRATE;
      arrayOfVocoderCtl[3] = VOECTL_CODEC_PAYLOAD;
      arrayOfVocoderCtl[4] = VOECTL_FORCE_CODEC;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.config.IVocoderSettings
 * JD-Core Version:    0.6.2
 */