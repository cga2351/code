package com.viber.voip.messages.conversation.ui.banner;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;

public class g extends q
  implements View.OnClickListener
{
  private TextView a = (TextView)this.layout.findViewById(R.id.alert_action_button);
  private TextView b = (TextView)this.layout.findViewById(R.id.alert_message);
  private a c;

  public g(ViewGroup paramViewGroup, Bundle paramBundle, a parama, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.alertbaner_simple_layout, paramViewGroup, paramBundle, paramLayoutInflater);
    this.a.setText(R.string.unblock);
    this.a.setOnClickListener(this);
    this.c = parama;
  }

  public ConversationAlertView.a a()
  {
    return ConversationAlertView.a.k;
  }

  public void onClick(View paramView)
  {
    this.c.e();
  }

  public void setBundle(Bundle paramBundle)
  {
    super.setBundle(paramBundle);
    TextView localTextView = this.b;
    Context localContext = this.layout.getContext();
    int i = R.string.dialog_424_title;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramBundle.get("display_name");
    localTextView.setText(localContext.getString(i, arrayOfObject));
  }

  public static abstract interface a
  {
    public abstract void e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.g
 * JD-Core Version:    0.6.2
 */