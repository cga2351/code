package com.viber.voip.phone;

import android.net.Uri;
import android.os.Handler;
import com.viber.voip.phone.vptt.VideoPttPlayer;
import com.viber.voip.phone.vptt.v2.ExoVideoPttPlayer;
import com.viber.voip.sound.ptt.PttFactory;

public class VpttPlayerBuilder
{
  Handler handler;
  Uri uri;

  public VideoPttPlayer build()
  {
    if (PttFactory.isNewPtt(this.uri.getPath()))
      return ExoVideoPttPlayer.create();
    return ViberVideoPttPlay.create(this.handler);
  }

  public VpttPlayerBuilder forUri(Uri paramUri)
  {
    this.uri = paramUri;
    return this;
  }

  public VpttPlayerBuilder withUiHandler(Handler paramHandler)
  {
    this.handler = paramHandler;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.VpttPlayerBuilder
 * JD-Core Version:    0.6.2
 */