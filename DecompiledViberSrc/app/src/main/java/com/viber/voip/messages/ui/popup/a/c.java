package com.viber.voip.messages.ui.popup.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.z;
import java.util.List;
import java.util.Map;

public class c extends d
{
  private ConversationItemLoaderEntity a;

  public c(Activity paramActivity, z paramz, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    super(paramActivity, paramz);
    this.a = paramConversationItemLoaderEntity;
    a();
  }

  public String a(int paramInt, aa paramaa)
  {
    if (f() != null)
    {
      if ((this.a == null) || (!this.a.isGroupBehavior()))
        return "";
      if (this.a != null);
      for (String str1 = this.a.getGroupName(); TextUtils.isEmpty(str1); str1 = "")
      {
        String str2 = g().getString(R.string.popup_in_group_text);
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = g().getString(R.string.default_group_name);
        return String.format(str2, arrayOfObject);
      }
      return String.format(g().getString(R.string.popup_in_group_text), new Object[] { str1 });
    }
    return null;
  }

  public void b(View paramView, int paramInt)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(R.id.title);
    TextView localTextView2 = (TextView)paramView.findViewById(R.id.description);
    TextView localTextView3 = (TextView)paramView.findViewById(R.id.online_date);
    localTextView1.setVisibility(8);
    localTextView3.setVisibility(8);
    localTextView2.setVisibility(0);
    localTextView2.setText((CharSequence)d().get(paramInt));
    e().put(Integer.valueOf(paramInt), localTextView2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.popup.a.c
 * JD-Core Version:    0.6.2
 */