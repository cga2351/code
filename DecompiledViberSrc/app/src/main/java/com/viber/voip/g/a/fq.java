package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.SoundFactory;
import com.viber.voip.sound.tones.IRingtonePlayer;

public abstract class fq
{
  static ISoundService a(Context paramContext)
  {
    return SoundFactory.getSoundService(paramContext);
  }

  static IRingtonePlayer b(Context paramContext)
  {
    return SoundFactory.getRingtonePlayer(paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fq
 * JD-Core Version:    0.6.2
 */