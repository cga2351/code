package com.viber.voip.messages.ui.popup.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.z;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.d.c;
import java.util.List;
import java.util.Map;

public class f extends d
{
  private SparseBooleanArray a = new SparseBooleanArray();
  private SparseBooleanArray b = new SparseBooleanArray();
  private SparseArray<String> c = new SparseArray();
  private Context d;

  public f(Activity paramActivity, z paramz, ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    super(paramActivity, paramz);
    this.d = paramActivity.getApplicationContext();
    a();
  }

  public String a(int paramInt, aa paramaa)
  {
    boolean bool = true;
    this.c.append(paramInt, paramaa.d());
    this.a.append(paramInt, bool);
    SparseBooleanArray localSparseBooleanArray = this.b;
    if (!paramaa.aR());
    while (true)
    {
      localSparseBooleanArray.append(paramInt, bool);
      if (!paramaa.O())
        break;
      return this.d.getResources().getString(R.string.system_contact_name);
      bool = false;
    }
    if ((paramaa.aZ()) && (paramaa.V()))
      return paramaa.bp();
    return c.c().a(paramaa.d(), paramaa.A(), 2);
  }

  public void b(View paramView, int paramInt)
  {
    boolean bool = this.a.get(d(paramInt), false);
    TextView localTextView1 = (TextView)paramView.findViewById(R.id.title);
    TextView localTextView2 = (TextView)paramView.findViewById(R.id.description);
    TextView localTextView3 = (TextView)paramView.findViewById(R.id.online_date);
    localTextView2.setVisibility(8);
    if (bool)
    {
      localTextView1.setVisibility(0);
      localTextView3.setVisibility(8);
      localTextView1.setText((CharSequence)d().get(paramInt));
    }
    while (true)
    {
      e().put(Integer.valueOf(paramInt), localTextView1);
      return;
      localTextView1.setVisibility(0);
      localTextView3.setVisibility(8);
      localTextView1.setText((CharSequence)d().get(paramInt));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.popup.a.f
 * JD-Core Version:    0.6.2
 */