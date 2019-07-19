package com.viber.voip.messages.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.ui.j;

public class bf extends bc
{
  private String g;

  public bf(Activity paramActivity, ContextMenu paramContextMenu, int paramInt, j paramj)
  {
    super(paramActivity, paramContextMenu, paramInt, paramj);
    a();
    a(R.id.menu_paste, new a(null));
  }

  protected View a()
  {
    View localView = super.a();
    TextView localTextView = (TextView)localView.findViewById(R.id.text);
    this.g = ((ClipboardManager)this.a.getSystemService("clipboard")).getPrimaryClip().getItemAt(0).getText().toString();
    localTextView.setText(this.g);
    this.d.a(localTextView, (int)localTextView.getTextSize());
    ((ImageView)localView.findViewById(R.id.icon)).setImageResource(R.drawable.ic_message_context_header);
    this.b.clear();
    return localView;
  }

  private class a
    implements bc.b
  {
    private a()
    {
    }

    public void a()
    {
      bf.this.b.add(0, R.id.menu_paste, 0, 17039371);
    }

    public void a(j paramj)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.bf
 * JD-Core Version:    0.6.2
 */