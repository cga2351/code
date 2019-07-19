package com.viber.voip.messages.ui.media.player.c;

import android.widget.ImageView.ScaleType;
import com.viber.voip.R.drawable;
import com.viber.voip.R.layout;
import com.viber.voip.messages.ui.media.player.MediaPlayer.VisualSpec;
import com.viber.voip.messages.ui.media.player.MediaPlayer.VisualSpec.a;
import com.viber.voip.util.da;

public class e
{
  private final String a;
  private final String b;

  private e(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public static e a(String paramString1, String paramString2)
  {
    return new e(paramString1, paramString2);
  }

  public MediaPlayer.VisualSpec a(int paramInt)
  {
    return a(paramInt, true, false);
  }

  public MediaPlayer.VisualSpec a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramInt, paramBoolean1, paramBoolean2, null);
  }

  public MediaPlayer.VisualSpec a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    MediaPlayer.VisualSpec.a locala = MediaPlayer.VisualSpec.builder().b(paramInt).a(this.a).b(this.b).a(paramBoolean1).b(paramBoolean2).c(paramString);
    if (!da.a(this.b))
      locala.a(ImageView.ScaleType.FIT_CENTER);
    while (true)
    {
      if (1 == paramInt)
        locala.c(R.layout.youtube_media_player_logo_overlay);
      return locala.a();
      if (paramInt == 0)
      {
        locala.a(R.drawable.bg_collapsed_media_player_image);
        locala.a(ImageView.ScaleType.CENTER_CROP);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.c.e
 * JD-Core Version:    0.6.2
 */