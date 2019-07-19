package com.appboy.ui.contentcards.listeners;

import android.content.Context;
import com.appboy.e.a.c;
import com.appboy.ui.actions.IAction;

public abstract interface IContentCardsActionListener
{
  public abstract boolean onContentCardClicked(Context paramContext, c paramc, IAction paramIAction);

  public abstract void onContentCardDismissed(Context paramContext, c paramc);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.listeners.IContentCardsActionListener
 * JD-Core Version:    0.6.2
 */