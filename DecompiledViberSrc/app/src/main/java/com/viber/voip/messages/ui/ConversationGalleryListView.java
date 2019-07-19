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
import com.viber.voip.util.da;

public class ConversationGalleryListView extends af
{
  private TextView a;

  public ConversationGalleryListView(Context paramContext)
  {
    super(paramContext);
  }

  public ConversationGalleryListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ConversationGalleryListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(int paramInt, View paramView)
  {
  }

  public void a(af.c paramc)
  {
    if ((!da.a(paramc.b())) && (!this.a.getText().equals(paramc.b())))
      this.a.setText(paramc.b());
  }

  protected af.a c()
  {
    af.a locala = new af.a();
    locala.c = inflate(getContext(), R.layout.conversation_gallery_date_item_layout, null);
    this.a = ((TextView)locala.c.findViewById(R.id.data));
    return locala;
  }

  protected int getHeaderTag()
  {
    return R.id.header;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.ConversationGalleryListView
 * JD-Core Version:    0.6.2
 */