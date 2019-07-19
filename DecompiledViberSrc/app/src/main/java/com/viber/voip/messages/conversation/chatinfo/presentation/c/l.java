package com.viber.voip.messages.conversation.chatinfo.presentation.c;

import android.content.res.ColorStateList;
import android.support.v4.widget.ImageViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.chatinfo.d.i;
import com.viber.voip.messages.conversation.chatinfo.e.e;
import com.viber.voip.messages.conversation.chatinfo.presentation.b.f;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;

public class l extends g<i>
{
  private final ImageView a;
  private final TextView b;
  private final TextView c;
  private i d;

  public l(View paramView, f paramf)
  {
    super(paramView);
    this.itemView.setOnClickListener(new m(this, paramf));
    this.a = ((ImageView)paramView.findViewById(R.id.icon));
    this.b = ((TextView)paramView.findViewById(R.id.title));
    this.c = ((TextView)paramView.findViewById(R.id.subtitle));
  }

  public void a(i parami, e parame)
  {
    this.d = parami;
    this.a.setImageResource(parami.b());
    int i = dc.d(this.itemView.getContext(), parami.a());
    ImageView localImageView = this.a;
    ColorStateList localColorStateList;
    if (i == 0)
    {
      localColorStateList = null;
      ImageViewCompat.setImageTintList(localImageView, localColorStateList);
      this.b.setText(parami.c());
      if (TextUtils.isEmpty(parami.f()))
        break label110;
    }
    label110: for (boolean bool = true; ; bool = false)
    {
      dj.b(this.c, bool);
      if (bool)
        this.c.setText(parami.f());
      return;
      localColorStateList = ColorStateList.valueOf(i);
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.c.l
 * JD-Core Version:    0.6.2
 */