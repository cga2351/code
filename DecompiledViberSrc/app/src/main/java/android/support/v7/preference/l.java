package android.support.v7.preference;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.View;

public class l extends RecyclerView.ViewHolder
{
  private final SparseArray<View> a = new SparseArray(4);
  private boolean b;
  private boolean c;

  l(View paramView)
  {
    super(paramView);
    this.a.put(16908310, paramView.findViewById(16908310));
    this.a.put(16908304, paramView.findViewById(16908304));
    this.a.put(16908294, paramView.findViewById(16908294));
    this.a.put(R.id.icon_frame, paramView.findViewById(R.id.icon_frame));
    this.a.put(16908350, paramView.findViewById(16908350));
  }

  public View a(int paramInt)
  {
    View localView = (View)this.a.get(paramInt);
    if (localView != null);
    do
    {
      return localView;
      localView = this.itemView.findViewById(paramInt);
    }
    while (localView == null);
    this.a.put(paramInt, localView);
    return localView;
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public boolean a()
  {
    return this.b;
  }

  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public boolean b()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.l
 * JD-Core Version:    0.6.2
 */