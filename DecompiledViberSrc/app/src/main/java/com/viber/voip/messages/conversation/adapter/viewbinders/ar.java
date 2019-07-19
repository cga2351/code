package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.a.a.d;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.viber.voip.R.drawable;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.util.dj;
import com.viber.voip.util.dx;

public class ar extends com.viber.voip.ui.g.e<a, i>
{
  private final com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<? extends View> a;
  private final com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<ImageView> b;
  private final com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<View> c;

  public ar(com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<? extends View> parame, com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<ImageView> parame1, com.viber.voip.messages.conversation.adapter.viewbinders.helpers.e<View> parame2)
  {
    this.a = parame;
    this.b = parame1;
    this.c = parame2;
  }

  private void a(View paramView)
  {
    if (!(this.a.c() instanceof ConstraintLayout));
    d locald;
    do
    {
      return;
      locald = ((ConstraintLayout)this.a.c()).a(paramView);
    }
    while (locald.k() == paramView.getVisibility());
    locald.e(paramView.getVisibility());
  }

  private void a(ImageView paramImageView, View paramView, Uri paramUri, int paramInt, boolean paramBoolean, i parami)
  {
    if ((paramInt == 3) && (paramUri != null) && (!TextUtils.isEmpty(paramUri.getPath())));
    for (boolean bool = true; ; bool = false)
    {
      dj.b(paramImageView, true);
      dj.b(paramView, bool);
      parami.T().b(paramUri, paramImageView, parami.a(paramInt, paramBoolean), null);
      return;
    }
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    if (!localaa.bD())
      return;
    boolean bool = localaa.ao();
    QuotedMessageData localQuotedMessageData = localaa.bC();
    int i = localQuotedMessageData.getType();
    ImageView localImageView = (ImageView)this.b.b();
    View localView = this.c.b();
    dj.b(localView, false);
    switch (i)
    {
    case 2:
    case 4:
    case 6:
    case 7:
    case 8:
    default:
      dj.b(localImageView, false);
    case 1:
    case 3:
    case 5:
    case 9:
    case 10:
    }
    while (true)
    {
      a(localImageView);
      return;
      if ((localQuotedMessageData.isOriginalMessageExists()) && (localQuotedMessageData.getBody() != null));
      for (Uri localUri = Uri.parse(localQuotedMessageData.getBody()); ; localUri = null)
      {
        a(localImageView, localView, localUri, i, bool, parami);
        break;
      }
      a(localImageView, localView, dx.a(localQuotedMessageData.getDownloadId()), i, bool, parami);
      continue;
      localImageView.setImageResource(R.drawable.reply_file_thumb);
      dj.b(localImageView, true);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.ar
 * JD-Core Version:    0.6.2
 */