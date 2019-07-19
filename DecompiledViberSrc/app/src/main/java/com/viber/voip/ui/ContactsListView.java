package com.viber.voip.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.viber.voip.messages.ui.b;
import com.viber.voip.util.dj;

public class ContactsListView extends b
{
  public ContactsListView(Context paramContext)
  {
    super(a(paramContext));
  }

  public ContactsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(a(paramContext), paramAttributeSet);
  }

  public ContactsListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(a(paramContext), paramAttributeSet, paramInt);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (paramBoolean2))
      dj.a(this, 1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ContactsListView
 * JD-Core Version:    0.6.2
 */