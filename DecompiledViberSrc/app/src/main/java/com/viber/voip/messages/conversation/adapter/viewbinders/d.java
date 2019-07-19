package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.net.Uri;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ImageView;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.util.e.f;

public class d extends com.viber.voip.ui.g.e<a, i>
{
  private final ImageView a;

  public d(ImageView paramImageView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.a = paramImageView;
    this.a.setOnCreateContextMenuListener(paramOnCreateContextMenuListener);
  }

  private void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.a.setColorFilter(paramInt);
      return;
    }
    this.a.clearColorFilter();
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    Uri localUri = localaa.bJ();
    if (localUri != null)
    {
      f localf = parami.d(localaa.bI());
      parami.T().a(localUri, this.a, localf);
    }
    a(parami.c(localaa.y()), parami.C());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.d
 * JD-Core Version:    0.6.2
 */