package com.viber.voip.messages.ui.media.player.d;

import android.content.Context;
import com.viber.voip.messages.ui.media.player.MediaPlayer;
import com.viber.voip.messages.ui.media.player.MediaPlayer.b;
import com.viber.voip.util.ViberActionRunner.bq;

class a
  implements MediaPlayer.b
{
  private final Context b;
  private final MediaPlayer c;
  private boolean d;

  public a(Context paramContext, MediaPlayer paramMediaPlayer)
  {
    this.b = paramContext;
    this.c = paramMediaPlayer;
  }

  public void a()
  {
    if (this.d)
      ViberActionRunner.bq.a(this.b);
  }

  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if (this.d)
      this.c.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.d.a
 * JD-Core Version:    0.6.2
 */