package com.my.target;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.my.target.b.c.a.b;
import java.util.ArrayList;
import java.util.List;

public final class ca extends RecyclerView.Adapter<b>
{
  private final Context a;
  private final List<b> b;
  private View.OnClickListener c;

  ca(Context paramContext)
  {
    this.a = paramContext;
    this.b = new ArrayList();
  }

  public final void a()
  {
    this.b.clear();
    notifyDataSetChanged();
    this.c = null;
  }

  final void a(View.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
  }

  public final void a(List<b> paramList)
  {
    this.b.addAll(paramList);
  }

  public final int getItemCount()
  {
    return this.b.size();
  }

  public final int getItemViewType(int paramInt)
  {
    if (paramInt == 0)
      return 1;
    if (paramInt == -1 + this.b.size())
      return 2;
    return 0;
  }

  public static final class a extends FrameLayout
  {
    public int a;
    public int b;

    public a(Context paramContext)
    {
      super();
    }

    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      int i = View.MeasureSpec.getSize(paramInt1);
      int j = View.MeasureSpec.getSize(paramInt2);
      int k = View.MeasureSpec.getMode(paramInt1);
      int m = View.MeasureSpec.getMode(paramInt2);
      if (i == 0)
        i = this.a;
      if (j == 0)
        j = this.b;
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(i, k), View.MeasureSpec.makeMeasureSpec(j, m));
    }
  }

  static final class b extends RecyclerView.ViewHolder
  {
    private final ax a;
    private final FrameLayout b;

    b(FrameLayout paramFrameLayout1, ax paramax, FrameLayout paramFrameLayout2)
    {
      super();
      this.a = paramax;
      this.b = paramFrameLayout2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ca
 * JD-Core Version:    0.6.2
 */