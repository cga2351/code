package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.notification;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.styleable;
import com.viber.voip.messages.ui.a.c;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;

public class NotificationBackgroundConstraintHelper extends android.support.constraint.a
{
  private int f;
  private TextView g;
  private c h;

  public NotificationBackgroundConstraintHelper(Context paramContext)
  {
    super(paramContext);
    setup(null);
  }

  public NotificationBackgroundConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setup(paramAttributeSet);
  }

  public NotificationBackgroundConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setup(paramAttributeSet);
  }

  private TextView d(ConstraintLayout paramConstraintLayout)
  {
    if (this.g == null)
    {
      this.g = ((TextView)paramConstraintLayout.a(this.f));
      this.g.setBackground(this.h);
    }
    return this.g;
  }

  private void setup(AttributeSet paramAttributeSet)
  {
    Context localContext = getContext();
    TypedArray localTypedArray = localContext.obtainStyledAttributes(paramAttributeSet, R.styleable.NotificationBackgroundConstraintHelper);
    try
    {
      this.f = localTypedArray.getResourceId(R.styleable.NotificationBackgroundConstraintHelper_notificationTextViewId, -1);
      localTypedArray.recycle();
      Drawable localDrawable = dc.g(localContext, R.attr.conversationNotificationBackground);
      Drawable[] arrayOfDrawable = new Drawable[2];
      arrayOfDrawable[0] = dj.a(dc.d(localContext, R.attr.conversationNotificationBackgroundColor));
      arrayOfDrawable[1] = localDrawable;
      this.h = new com.viber.voip.messages.ui.a.a(arrayOfDrawable);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public void a(ConstraintLayout paramConstraintLayout)
  {
    super.a(paramConstraintLayout);
    d(paramConstraintLayout);
  }

  public void c(ConstraintLayout paramConstraintLayout)
  {
    super.c(paramConstraintLayout);
    a locala = (a)getTag();
    TextView localTextView = d(paramConstraintLayout);
    c localc;
    if (!locala.a)
    {
      int i = localTextView.getLineCount();
      localc = this.h;
      if (i <= 2)
        break label56;
    }
    label56: for (int j = 1; ; j = 0)
    {
      localc.a(j, false);
      return;
    }
  }

  public static class a
  {
    final boolean a;

    public a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.notification.NotificationBackgroundConstraintHelper
 * JD-Core Version:    0.6.2
 */