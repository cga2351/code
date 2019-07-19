package com.appboy.ui.contentcards.handlers;

import android.content.Context;
import android.view.ViewGroup;
import com.appboy.e.a.c;
import com.appboy.ui.contentcards.view.ContentCardViewHolder;
import java.util.List;

public abstract interface IContentCardsViewBindingHandler
{
  public abstract int getItemViewType(Context paramContext, List<c> paramList, int paramInt);

  public abstract void onBindViewHolder(Context paramContext, List<c> paramList, ContentCardViewHolder paramContentCardViewHolder, int paramInt);

  public abstract ContentCardViewHolder onCreateViewHolder(Context paramContext, List<c> paramList, ViewGroup paramViewGroup, int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.handlers.IContentCardsViewBindingHandler
 * JD-Core Version:    0.6.2
 */