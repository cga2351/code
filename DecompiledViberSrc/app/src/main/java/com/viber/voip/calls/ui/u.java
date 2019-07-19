package com.viber.voip.calls.ui;

import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.model.AggregatedCall;

public class u<I extends View> extends ac<AggregatedCall, I>
{
  public final TextView a;
  public final TextView b;
  public final TextView c;
  private long i;
  private CharSequence j;
  private String k;
  private boolean l = true;

  public u(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(R.id.dateView));
    this.b = ((TextView)paramView.findViewById(R.id.callTypeView));
    this.c = ((TextView)paramView.findViewById(R.id.groupSizeView));
  }

  void a(t.a parama, long paramLong)
  {
    if ((this.j == null) || (this.i != paramLong))
      this.j = parama.a(paramLong);
    this.i = paramLong;
    this.a.setText(this.j);
  }

  public void a(String paramString)
  {
    this.k = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public boolean a()
  {
    return this.l;
  }

  public String b()
  {
    return this.k;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.u
 * JD-Core Version:    0.6.2
 */