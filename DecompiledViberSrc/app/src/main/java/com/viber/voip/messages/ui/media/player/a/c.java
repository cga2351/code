package com.viber.voip.messages.ui.media.player.a;

import com.viber.voip.messages.ui.media.player.MediaPlayerControls.VisualSpec;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls.VisualSpec.a;

public class c
{
  private final String a;
  private final String b;

  private c(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public static c a(String paramString1, String paramString2)
  {
    return new c(paramString1, paramString2);
  }

  public MediaPlayerControls.VisualSpec a(int paramInt)
  {
    return a(paramInt, false);
  }

  public MediaPlayerControls.VisualSpec a(int paramInt, boolean paramBoolean)
  {
    return MediaPlayerControls.VisualSpec.builder().a(this.a).b(this.b).a(paramInt).a(paramBoolean).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.a.c
 * JD-Core Version:    0.6.2
 */