package com.viber.voip.messages.conversation.adapter.viewbinders;

import android.view.View.OnCreateContextMenuListener;
import android.widget.TextView;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.a.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.i;
import com.viber.voip.ui.g.e;

public class n extends e<a, i>
{
  private TextView a;

  public n(TextView paramTextView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.a = paramTextView;
    this.a.setOnCreateContextMenuListener(paramOnCreateContextMenuListener);
  }

  public void a(a parama, i parami)
  {
    super.a(parama, parami);
    aa localaa = parama.c();
    if (localaa.ba());
    Object[] arrayOfObject;
    for (String str = localaa.bx().getPin().toString() + "\npin time: " + localaa.G() + " at " + localaa.H(); ; str = String.format("Invisible: Token=%s, MessageGlobalId=%s, Number=%s, Count=%s", arrayOfObject))
    {
      this.a.setText(str);
      return;
      arrayOfObject = new Object[4];
      arrayOfObject[0] = Long.valueOf(localaa.y());
      arrayOfObject[1] = Integer.valueOf(localaa.F());
      arrayOfObject[2] = localaa.d();
      arrayOfObject[3] = Integer.valueOf(localaa.m());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.n
 * JD-Core Version:    0.6.2
 */