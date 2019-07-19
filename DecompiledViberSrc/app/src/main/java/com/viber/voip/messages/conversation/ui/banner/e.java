package com.viber.voip.messages.conversation.ui.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.i.c.d;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.banner.a.a;
import com.viber.voip.registration.ao;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.j;

public class e extends q
  implements View.OnClickListener
{
  private TextView a;
  private TextView b;
  private View c;
  private View d;
  private a e;
  private ConversationItemLoaderEntity f;

  public e(ViewGroup paramViewGroup, a parama, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.msg_block_app, paramViewGroup, paramLayoutInflater);
    this.e = parama;
    this.a = ((TextView)this.layout.findViewById(R.id.msg_from_text));
    this.d = this.layout.findViewById(R.id.subscribe_btn);
    this.b = ((TextView)this.layout.findViewById(R.id.why_im_seeing_txt));
    this.c = this.layout.findViewById(R.id.why_im_seeing_icon);
    this.b.setPaintFlags(0x8 | this.b.getPaintFlags());
    if (!ao.f())
    {
      dj.a(this.b, j.a(15.0F));
      this.d.setOnClickListener(this);
      this.b.setOnClickListener(this);
      this.c.setOnClickListener(this);
    }
  }

  public ConversationAlertView.a a()
  {
    return ConversationAlertView.a.i;
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.f = paramConversationItemLoaderEntity;
    if (ao.f())
      dj.b(this.b, false);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = true;
    String str = this.f.getViberName();
    if (paramBoolean1)
    {
      this.a.setText(R.string.messages_stopped);
      dj.b(this.b, false);
      dj.b(this.c, false);
      View localView2 = this.d;
      if (!paramBoolean2);
      while (true)
      {
        dj.b(localView2, bool1);
        return;
        bool1 = false;
      }
    }
    TextView localTextView1 = this.a;
    Context localContext = this.a.getContext();
    int i = R.string.msg_from_external_sender;
    Object[] arrayOfObject = new Object[bool1];
    arrayOfObject[0] = str;
    localTextView1.setText(localContext.getString(i, arrayOfObject));
    TextView localTextView2 = this.b;
    boolean bool2;
    View localView1;
    if (!paramBoolean2)
    {
      bool2 = bool1;
      dj.b(localTextView2, bool2);
      localView1 = this.c;
      if (paramBoolean2)
        break label160;
    }
    while (true)
    {
      dj.b(localView1, bool1);
      dj.b(this.d, false);
      return;
      bool2 = false;
      break;
      label160: bool1 = false;
    }
  }

  protected a createAlertViewUiCustomizer()
  {
    if (c.d.a.e())
      return new f(this);
    return super.createAlertViewUiCustomizer();
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i == R.id.why_im_seeing_icon) || (i == R.id.why_im_seeing_txt))
      this.e.b();
    while (i != R.id.subscribe_btn)
      return;
    this.e.a();
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.e
 * JD-Core Version:    0.6.2
 */