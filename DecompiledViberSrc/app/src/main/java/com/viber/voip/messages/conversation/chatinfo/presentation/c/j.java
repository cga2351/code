package com.viber.voip.messages.conversation.chatinfo.presentation.c;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.chatinfo.d.h;
import com.viber.voip.messages.conversation.chatinfo.e.a;
import com.viber.voip.messages.conversation.chatinfo.presentation.b.d;
import com.viber.voip.messages.m;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.h.a;
import com.viber.voip.widget.AvatarWithCaptionView;

public class j extends g<h>
  implements h.a
{
  private final View a;
  private final TextView b;
  private final AvatarWithCaptionView c;

  public j(View paramView, d paramd)
  {
    super(paramView);
    k localk = new k(paramd);
    this.a = this.itemView.findViewById(R.id.edit_btn);
    this.a.setOnClickListener(localk);
    this.b = ((TextView)this.itemView.findViewById(R.id.group_name));
    this.b.setOnClickListener(localk);
    this.c = ((AvatarWithCaptionView)this.itemView.findViewById(R.id.group_icon));
    this.c.setOnClickListener(localk);
  }

  private void a(Uri paramUri, h.a parama, com.viber.voip.util.e.e parame, f paramf)
  {
    parame.a(paramUri, this.c, paramf, parama);
  }

  public void a(h paramh, com.viber.voip.messages.conversation.chatinfo.e.e parame)
  {
    a locala = parame.b();
    this.b.setText(paramh.a());
    Object localObject = null;
    if (paramh.b())
    {
      this.b.setClickable(paramh.c());
      this.c.setClickable(false);
      this.c.setCaptionVisibility(false);
      dj.b(this.a, false);
    }
    while (true)
    {
      a(m.a(this.itemView.getContext(), paramh.h()), (h.a)localObject, locala.a(), locala.c());
      this.b.setClickable(paramh.f());
      this.c.setClickable(paramh.g());
      return;
      this.b.setClickable(true);
      this.c.setClickable(true);
      dj.b(this.a, true);
      localObject = this;
    }
  }

  public void onLoadComplete(Uri paramUri, Bitmap paramBitmap, boolean paramBoolean)
  {
    this.c.setCaptionVisibility(paramBoolean);
    View localView = this.a;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      dj.b(localView, bool);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.c.j
 * JD-Core Version:    0.6.2
 */