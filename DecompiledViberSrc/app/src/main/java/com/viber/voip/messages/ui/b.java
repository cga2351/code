package com.viber.voip.messages.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ui.af;
import com.viber.voip.ui.af.a;
import com.viber.voip.ui.af.c;

public abstract class b extends af
{
  protected TextView a;
  private boolean b;

  public b(Context paramContext)
  {
    super(paramContext);
  }

  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a()
  {
    super.a();
    if (this.a.getVisibility() == 8)
      this.a.setVisibility(0);
  }

  protected void a(int paramInt, View paramView)
  {
  }

  public void a(af.c paramc)
  {
    if ((this.b) || (this.k.c.isLayoutRequested()) || (!this.a.getText().equals(paramc.b())))
    {
      this.a.setText(paramc.b());
      this.b = false;
    }
  }

  protected af.a c()
  {
    af.a locala = new af.a();
    locala.c = inflate(getContext(), R.layout.sticky_header_item, null);
    locala.d = locala.c.findViewById(R.id.header);
    locala.c.setVisibility(0);
    this.a = ((TextView)locala.c.findViewById(R.id.letter));
    this.a.setVisibility(8);
    return locala;
  }

  protected int getHeaderTag()
  {
    return R.id.header;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.b
 * JD-Core Version:    0.6.2
 */