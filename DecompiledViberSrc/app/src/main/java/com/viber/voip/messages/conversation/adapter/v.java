package com.viber.voip.messages.conversation.adapter;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.util.ca;

public class v<T extends Enum<T>> extends z<T>
{
  public v(Class<T> paramClass)
  {
    super(paramClass);
  }

  public void a(T paramT, View paramView)
  {
    if (a(paramView))
    {
      paramView.setTag(R.id.tag_orientation, Integer.valueOf(paramView.getResources().getConfiguration().orientation));
      super.a(paramT, paramView);
    }
  }

  protected boolean a(View paramView)
  {
    if (!super.a(paramView))
      return false;
    int i = paramView.getResources().getConfiguration().orientation;
    if (i == ((Integer)ca.a((Integer)paramView.getTag(R.id.tag_orientation), Integer.valueOf(i))).intValue());
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.v
 * JD-Core Version:    0.6.2
 */