package com.viber.voip.messages.conversation.ui.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.banner.a.a;
import com.viber.voip.messages.conversation.ui.banner.a.c;

public class n extends q
  implements View.OnTouchListener
{
  private TextView a;
  private a b;

  public n(ViewGroup paramViewGroup, a parama, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.engagement_banner_layout, paramViewGroup, paramLayoutInflater);
    this.b = parama;
    this.a = ((TextView)this.layout.findViewById(R.id.description));
  }

  public ConversationAlertView.a a()
  {
    return ConversationAlertView.a.f;
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    Context localContext = this.a.getContext();
    int i;
    Object[] arrayOfObject;
    if (paramConversationItemLoaderEntity.isEngagementConversation())
    {
      i = R.string.user_engagement_banner_text;
      arrayOfObject = new Object[1];
      arrayOfObject[0] = paramConversationItemLoaderEntity.getParticipantName();
    }
    for (String str = localContext.getString(i, arrayOfObject); ; str = localContext.getString(R.string.tap_sticker_to_say_hi))
    {
      this.a.setText(str);
      this.layout.setOnTouchListener(this);
      return;
    }
  }

  protected a createAlertViewUiCustomizer()
  {
    return new c();
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
      this.b.a();
    return false;
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.n
 * JD-Core Version:    0.6.2
 */