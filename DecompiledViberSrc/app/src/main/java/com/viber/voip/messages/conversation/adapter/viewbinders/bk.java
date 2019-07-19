package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.widget.TextView;
import com.viber.voip.flatbuffers.model.msginfo.FileInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.h;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.ui.g.e;
import com.viber.voip.util.ae;
import com.viber.voip.util.dj;

public class bk extends e<a, i>
{
  private final TextView a;

  public bk(TextView paramTextView)
  {
    this.a = paramTextView;
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    h localh = parami.ag();
    FileInfo localFileInfo = localaa.bz();
    long l1 = localFileInfo.getFileSize();
    long l2 = Math.max(()localFileInfo.getDuration(), localaa.s());
    int i;
    int j;
    if ((l2 > localh.c()) && (localaa.o() != null) && (localaa.aq()))
    {
      i = 1;
      if (l1 <= 0L)
        break label128;
      j = 1;
      label86: if ((i == 0) && (j == 0))
        break label151;
      if (i == 0)
        break label134;
      this.a.setText(ae.h(l2));
    }
    while (true)
    {
      dj.c(this.a, true);
      return;
      i = 0;
      break;
      label128: j = 0;
      break label86;
      label134: this.a.setText(localh.b(l1));
    }
    label151: dj.c(this.a, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.bk
 * JD-Core Version:    0.6.2
 */