package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View;
import com.viber.common.ui.ShapeImageView;
import com.viber.voip.R.id;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.flatbuffers.model.msginfo.MediaInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.h;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b.b;
import com.viber.voip.messages.conversation.adapter.viewbinders.helpers.media.MediaMessageConstraintHelper.a;
import com.viber.voip.ui.g.e;
import com.viber.voip.widget.al.a;

public class y extends e<a, i>
  implements al.a
{
  private final ShapeImageView a;
  private final b b;

  public y(ShapeImageView paramShapeImageView, b paramb)
  {
    this.a = paramShapeImageView;
    this.b = paramb;
  }

  private void a(a parama, i parami, int paramInt, MediaInfo paramMediaInfo)
  {
    h localh = parami.ag();
    int i;
    if (paramMediaInfo != null)
    {
      i = paramMediaInfo.getWidth();
      j = paramMediaInfo.getHeight();
      if (parama.r())
        i = Math.min(i, j);
    }
    for (int j = Math.min(i, j); ; j = 0)
    {
      if ((parama.c().ap()) && (-1 == parama.c().f()) && (!parama.q()) && (!parama.p()));
      for (boolean bool = true; ; bool = false)
      {
        this.a.setForegroundDrawable(localh.a(localh.a(this.a.getCornerRadius()), paramInt, bool, i, j));
        return;
      }
      i = 0;
    }
  }

  public void a()
  {
    super.a();
    this.b.a();
  }

  public void a(View paramView)
  {
    i locali = (i)e();
    if (locali == null)
      return;
    if (paramView.isPressed())
    {
      this.a.setColorFilter(locali.ag().d());
      return;
    }
    this.a.clearColorFilter();
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    h localh = parami.ag();
    if (localaa.ay());
    for (MediaInfo localMediaInfo = localh.e(); ; localMediaInfo = localaa.bx().getFileInfo().getMediaInfo())
    {
      MediaMessageConstraintHelper.a locala = null;
      if (localMediaInfo != null)
        locala = new MediaMessageConstraintHelper.a(localMediaInfo.getWidth(), localMediaInfo.getHeight());
      this.a.setTag(R.id.media_info, locala);
      int i = localh.a(parama);
      this.a.setRoundedCornerMask(i);
      this.a.setBackgroundResource(0);
      a(parama, parami, i, localMediaInfo);
      this.b.a(this.a, parama, parami);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.y
 * JD-Core Version:    0.6.2
 */