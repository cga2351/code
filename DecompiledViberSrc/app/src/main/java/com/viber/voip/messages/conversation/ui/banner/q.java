package com.viber.voip.messages.conversation.ui.banner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class q extends b
{
  public q(int paramInt, ViewGroup paramViewGroup, Bundle paramBundle, LayoutInflater paramLayoutInflater)
  {
    super(paramInt, paramViewGroup, paramBundle, paramLayoutInflater);
  }

  public q(int paramInt, ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater)
  {
    super(paramInt, paramViewGroup, paramLayoutInflater);
  }

  public q(int paramInt, ViewGroup paramViewGroup, b.a parama, LayoutInflater paramLayoutInflater)
  {
    super(paramInt, paramViewGroup, parama, paramLayoutInflater);
  }

  public q(int paramInt, ViewGroup paramViewGroup, b.a parama, b.b paramb, LayoutInflater paramLayoutInflater)
  {
    super(paramInt, paramViewGroup, parama, paramb, paramLayoutInflater);
  }

  public int getEmptyViewHeight()
  {
    return this.layout.getHeight();
  }

  public int getMeasuredHeight()
  {
    if (this.layout.getHeight() > 0)
      return this.layout.getHeight();
    if (this.layout.getMeasuredHeight() > 0)
      return this.layout.getMeasuredHeight();
    this.layout.measure(-1, -2);
    return this.layout.getMeasuredHeight();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.q
 * JD-Core Version:    0.6.2
 */