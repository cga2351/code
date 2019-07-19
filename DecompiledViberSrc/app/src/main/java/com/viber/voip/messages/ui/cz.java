package com.viber.voip.messages.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class cz extends FrameLayout
{
  private CopyOnWriteArraySet<cy.a> a;

  public cz(Context paramContext)
  {
    super(paramContext);
  }

  public cz(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public cz(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(int paramInt)
  {
    CopyOnWriteArraySet localCopyOnWriteArraySet = this.a;
    if ((localCopyOnWriteArraySet != null) && (!localCopyOnWriteArraySet.isEmpty()))
    {
      Iterator localIterator = localCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        cy.a locala = (cy.a)localIterator.next();
        if (locala != null)
          locala.onVisibilityChanged(paramInt);
      }
    }
  }

  public void a(cy.a parama)
  {
    if (this.a == null)
      this.a = new CopyOnWriteArraySet();
    this.a.add(parama);
  }

  public void b(cy.a parama)
  {
    if (this.a != null)
      this.a.remove(parama);
  }

  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this == paramView)
      a(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.cz
 * JD-Core Version:    0.6.2
 */