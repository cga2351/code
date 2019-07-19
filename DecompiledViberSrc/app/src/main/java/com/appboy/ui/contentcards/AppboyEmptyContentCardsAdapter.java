package com.appboy.ui.contentcards;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.appboy.ui.R.layout;

public class AppboyEmptyContentCardsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public int getItemCount()
  {
    return 1;
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new NetworkUnavailableViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.layout.com_appboy_content_cards_empty, paramViewGroup, false));
  }

  class NetworkUnavailableViewHolder extends RecyclerView.ViewHolder
  {
    NetworkUnavailableViewHolder(View arg2)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.AppboyEmptyContentCardsAdapter
 * JD-Core Version:    0.6.2
 */