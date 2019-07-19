package com.viber.voip.messages.conversation.ui.spam.b;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.anim;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.banner.AlertView.a;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.a;
import com.viber.voip.messages.conversation.ui.banner.a.a;
import com.viber.voip.messages.conversation.ui.banner.q;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.dj;

public class b extends q
  implements View.OnClickListener
{
  private final b a;
  private final TextView b;
  private final ImageView c;
  private final ViberTextView d;

  public b(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, b paramb)
  {
    super(R.layout.business_inbox_overlay, paramViewGroup, new a(null), paramLayoutInflater);
    this.a = paramb;
    this.b = ((TextView)this.layout.findViewById(R.id.alert_message));
    this.c = ((ImageView)this.layout.findViewById(R.id.block_icon));
    this.c.setOnClickListener(this);
    this.d = ((ViberTextView)this.layout.findViewById(R.id.block_btn));
    this.d.setOnClickListener(this);
    this.layout.findViewById(R.id.close_btn).setOnClickListener(this);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    TextView localTextView = this.b;
    Resources localResources = this.resources;
    int i = R.string.business_inbox_overlay_title;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramConversationItemLoaderEntity.getParticipantName();
    localTextView.setText(localResources.getString(i, arrayOfObject));
  }

  public void a(boolean paramBoolean)
  {
    boolean bool1 = true;
    ImageView localImageView = this.c;
    boolean bool2;
    ViberTextView localViberTextView;
    if (!paramBoolean)
    {
      bool2 = bool1;
      dj.b(localImageView, bool2);
      localViberTextView = this.d;
      if (paramBoolean)
        break label43;
    }
    while (true)
    {
      dj.b(localViberTextView, bool1);
      return;
      bool2 = false;
      break;
      label43: bool1 = false;
    }
  }

  protected a createAlertViewUiCustomizer()
  {
    return new c(this);
  }

  protected int getAppearanceOrder()
  {
    return 1;
  }

  public AlertView.a getMode()
  {
    return ConversationAlertView.a.r;
  }

  public void onClick(View paramView)
  {
    if ((paramView.getId() == R.id.block_btn) || (paramView.getId() == R.id.block_icon))
      this.a.a();
    while (paramView.getId() != R.id.close_btn)
      return;
    this.a.b();
  }

  private static class a
    implements com.viber.voip.messages.conversation.ui.banner.b.a
  {
    public int a()
    {
      return R.anim.alert_slide_in;
    }

    public int b()
    {
      return R.anim.business_inbox_overlay_slide_out;
    }
  }

  public static abstract interface b
  {
    public abstract void a();

    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.spam.b.b
 * JD-Core Version:    0.6.2
 */