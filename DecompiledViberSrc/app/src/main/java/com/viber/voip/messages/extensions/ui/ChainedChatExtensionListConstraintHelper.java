package com.viber.voip.messages.extensions.ui;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.a;
import android.util.AttributeSet;
import android.view.View;

public class ChainedChatExtensionListConstraintHelper extends ChatExtensionListConstraintHelper
{
  public ChainedChatExtensionListConstraintHelper(Context paramContext)
  {
    super(paramContext);
  }

  public ChainedChatExtensionListConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ChainedChatExtensionListConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(ConstraintLayout paramConstraintLayout)
  {
    super.a(paramConstraintLayout);
    if (!d())
      return;
    ConstraintLayout.a locala = (ConstraintLayout.a)paramConstraintLayout.a(this.f).getLayoutParams();
    if ((!c()) || (!b()))
    {
      locala.A = 0.0F;
      locala.H = 2;
      return;
    }
    locala.H = 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.ChainedChatExtensionListConstraintHelper
 * JD-Core Version:    0.6.2
 */