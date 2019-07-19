package com.viber.voip.backup.ui.promotion;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;

class a extends RecyclerView.Adapter<b>
{
  private LayoutInflater a;
  private final a b;
  private int[] c = new int[0];
  private int d = -1;

  public a(a parama, LayoutInflater paramLayoutInflater)
  {
    this.b = parama;
    this.a = paramLayoutInflater;
  }

  private void a(int paramInt)
  {
    int i = this.d;
    this.d = paramInt;
    notifyItemChanged(this.d);
    if (i != -1)
      notifyItemChanged(i);
    this.b.a(paramInt);
  }

  public b a(ViewGroup paramViewGroup, int paramInt)
  {
    return new b(this.a.inflate(R.layout.list_item_auto_backup_period_promotion, paramViewGroup, false));
  }

  public void a(int paramInt, int[] paramArrayOfInt)
  {
    this.c = paramArrayOfInt;
    this.d = paramInt;
    notifyDataSetChanged();
  }

  public void a(b paramb, int paramInt)
  {
    if (paramInt == this.d);
    for (boolean bool = true; ; bool = false)
    {
      paramb.a(bool, this.c[paramInt]);
      return;
    }
  }

  public int getItemCount()
  {
    return this.c.length;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }

  class b extends RecyclerView.ViewHolder
    implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
  {
    private final TextView b;
    private final CheckBox c;
    private boolean d;

    public b(View arg2)
    {
      super();
      this.b = ((TextView)localView.findViewById(R.id.item_auto_backup_promotion_text));
      this.c = ((CheckBox)localView.findViewById(R.id.item_auto_backup_promotion_check));
      localView.setOnClickListener(this);
      this.c.setOnCheckedChangeListener(this);
      this.c.setOnClickListener(this);
    }

    private void a()
    {
      a.a(a.this, getAdapterPosition());
    }

    public void a(boolean paramBoolean, int paramInt)
    {
      this.d = paramBoolean;
      this.b.setText(paramInt);
      this.c.setChecked(paramBoolean);
    }

    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if ((this.d) && (!paramBoolean))
        paramCompoundButton.toggle();
    }

    public void onClick(View paramView)
    {
      if (!this.d)
        a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.promotion.a
 * JD-Core Version:    0.6.2
 */