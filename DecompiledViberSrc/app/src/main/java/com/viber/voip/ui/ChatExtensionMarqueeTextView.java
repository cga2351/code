package com.viber.voip.ui;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;

public class ChatExtensionMarqueeTextView extends ViberTextView
{
  private Runnable a = new Runnable()
  {
    public void run()
    {
      if (ChatExtensionMarqueeTextView.this.isSelected())
        ChatExtensionMarqueeTextView.a(ChatExtensionMarqueeTextView.this, true);
    }
  };

  public ChatExtensionMarqueeTextView(Context paramContext)
  {
    super(paramContext);
  }

  public ChatExtensionMarqueeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ChatExtensionMarqueeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a()
  {
    super.setHorizontalFadingEdgeEnabled(false);
    super.setHorizontallyScrolling(true);
    super.setFocusable(true);
    super.setFocusableInTouchMode(true);
    super.setSingleLine(true);
    a(false);
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.setEllipsize(TextUtils.TruncateAt.MARQUEE);
      super.setMarqueeRepeatLimit(-1);
      return;
    }
    super.setEllipsize(TextUtils.TruncateAt.END);
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    a();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.a);
  }

  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (!isSelected())
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (!isSelected())
      super.onWindowFocusChanged(paramBoolean);
  }

  public void setHorizontalFadingEdgeEnabled(boolean paramBoolean)
  {
  }

  public void setSelected(boolean paramBoolean)
  {
    boolean bool = isSelected();
    super.setSelected(paramBoolean);
    if (paramBoolean != bool)
    {
      removeCallbacks(this.a);
      if (paramBoolean)
        postDelayed(this.a, 500L);
    }
    else
    {
      return;
    }
    a(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ChatExtensionMarqueeTextView
 * JD-Core Version:    0.6.2
 */