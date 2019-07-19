package com.viber.voip.ui.style;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.viber.voip.flatbuffers.model.TextMetaInfo;

public class UserMentionSpan extends URLSpan
  implements c
{
  private static final int LINK_COLOR = -13920784;
  private static a sClickListener;
  private final TextMetaInfo mMetaInfo;

  public UserMentionSpan(TextMetaInfo paramTextMetaInfo)
  {
    super("");
    this.mMetaInfo = paramTextMetaInfo;
  }

  public static void addClickListener(a parama)
  {
    if (sClickListener != parama)
      sClickListener = parama;
  }

  public static void removeClickListener(a parama)
  {
    if (sClickListener == parama)
      sClickListener = null;
  }

  public TextMetaInfo getMetaInfo()
  {
    return this.mMetaInfo;
  }

  public void onClick(View paramView)
  {
    if (sClickListener != null)
      sClickListener.a(this.mMetaInfo);
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-13920784);
    paramTextPaint.setUnderlineText(false);
  }

  public static abstract interface a
  {
    public abstract void a(TextMetaInfo paramTextMetaInfo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.style.UserMentionSpan
 * JD-Core Version:    0.6.2
 */