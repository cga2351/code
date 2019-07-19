package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.fm;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.a.a.d;
import android.support.v4.util.LongSparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.adapter.e.f;
import com.viber.voip.messages.conversation.adapter.e.j;
import com.viber.voip.messages.orm.entity.json.FormattedMessage;
import com.viber.voip.messages.orm.entity.json.MediaMessage;
import com.viber.voip.messages.orm.entity.json.MessageType;
import com.viber.voip.widget.FormattedMessageLayout;

class c extends com.viber.voip.messages.conversation.adapter.viewbinders.helpers.b
{
  private static final Logger a = ViberEnv.getLogger();
  private final int b;
  private float c;
  private final int d;
  private final j e;
  private final f f;
  private final Resources g;

  c(int paramInt1, Context paramContext, int paramInt2)
  {
    this.b = paramInt1;
    this.g = paramContext.getResources();
    b();
    this.d = this.g.getDimensionPixelOffset(R.dimen.formatted_message_huge_text_without_name_padding_top);
    this.e = new j(new com.viber.voip.app.b(paramContext, com.viber.voip.h.a.c()), this.g);
    this.f = new f(paramInt2, this.g);
  }

  private void a(FormattedMessageConstraintHelper.a parama, FormattedMessageLayout paramFormattedMessageLayout)
  {
    LongSparseArray localLongSparseArray = parama.a.getTextMessages();
    int i = paramFormattedMessageLayout.getChildCount();
    int j = localLongSparseArray.size();
    int k = 0;
    if (k < j)
    {
      int m = (int)localLongSparseArray.keyAt(k);
      if (k >= i);
      while (true)
      {
        k++;
        break;
        View localView = paramFormattedMessageLayout.getChildAt(m);
        if (m == 0)
        {
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
          if ((!parama.c) && (!parama.d))
            localMarginLayoutParams.topMargin = this.d;
          else if (parama.d)
            localMarginLayoutParams.topMargin = 0;
        }
      }
    }
  }

  private boolean a(MediaMessage paramMediaMessage)
  {
    return (paramMediaMessage.getType() == MessageType.VIDEO) || (paramMediaMessage.getType() == MessageType.GIF);
  }

  private void b()
  {
    TypedValue localTypedValue = new TypedValue();
    this.g.getValue(R.dimen.balloon_text_content_max_width, localTypedValue, true);
    this.c = localTypedValue.getFloat();
  }

  protected void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    b();
  }

  protected void a(ConstraintLayout paramConstraintLayout, android.support.constraint.a parama)
  {
    FormattedMessageLayout localFormattedMessageLayout = (FormattedMessageLayout)paramConstraintLayout.a(this.b);
    int i = localFormattedMessageLayout.getChildCount();
    FormattedMessageConstraintHelper.a locala = (FormattedMessageConstraintHelper.a)parama.getTag();
    if ((locala != null) && (locala.a.hasText()))
      a(locala, localFormattedMessageLayout);
    int i1;
    Object localObject1;
    Object localObject2;
    int i2;
    MediaMessage localMediaMessage2;
    if ((locala != null) && (locala.a.hasMedia()))
    {
      this.e.a(paramConstraintLayout.a(paramConstraintLayout).o(), this.f.a(), this.f.b(), this.f.c(), this.f.d());
      LongSparseArray localLongSparseArray = locala.a.getMediaMessages();
      MediaMessage localMediaMessage1 = (MediaMessage)localLongSparseArray.get(0L);
      int n = localLongSparseArray.size();
      i1 = 0;
      localObject1 = null;
      localObject2 = localMediaMessage1;
      if (i1 < n)
      {
        i2 = (int)localLongSparseArray.keyAt(i1);
        localMediaMessage2 = (MediaMessage)localLongSparseArray.valueAt(i1);
        if ((localObject2 != null) && (((MediaMessage)localObject2).getWidthPx() >= localMediaMessage2.getWidthPx()))
          break label511;
      }
    }
    label358: label511: for (Object localObject3 = localMediaMessage2; ; localObject3 = localObject2)
    {
      if (i1 >= i);
      while (true)
      {
        i1++;
        localObject2 = localObject3;
        break;
        View localView1 = localFormattedMessageLayout.getChildAt(i2);
        if (a(localMediaMessage2));
        for (View localView2 = localView1.findViewById(R.id.preview); ; localView2 = localView1)
        {
          if (localView2 == null)
            break label358;
          int[] arrayOfInt = this.e.a(localMediaMessage2.getThumbnailWidth(), localMediaMessage2.getThumbnailHeight(), true);
          if ((localObject1 == null) || (localObject1[0] < arrayOfInt[0]))
            localObject1 = arrayOfInt;
          ViewGroup.LayoutParams localLayoutParams = localView2.getLayoutParams();
          localLayoutParams.width = arrayOfInt[0];
          localLayoutParams.height = arrayOfInt[1];
          if (i2 == 0)
            ((ViewGroup.MarginLayoutParams)localView1.getLayoutParams()).topMargin = 0;
          if (i2 != i - 1)
            break;
          ((ViewGroup.MarginLayoutParams)localView1.getLayoutParams()).bottomMargin = 0;
          break;
        }
      }
      if (localObject1 == null)
        localObject1 = this.e.a(((MediaMessage)localObject2).getThumbnailWidth(), ((MediaMessage)localObject2).getThumbnailHeight(), true);
      int k = localObject1[0];
      int m = 0;
      while (true)
      {
        localFormattedMessageLayout.setMaximumWidth(k);
        localFormattedMessageLayout.setMinimumWidth(m);
        return;
        if ((locala != null) && (locala.b))
        {
          this.e.a(paramConstraintLayout.a(paramConstraintLayout).o(), this.f.a(), this.f.b(), this.f.c(), this.f.d());
          k = this.e.a();
          m = this.e.a();
        }
        else
        {
          int j = paramConstraintLayout.a(paramConstraintLayout).o();
          k = (int)(this.c * j);
          m = 0;
        }
      }
    }
  }

  protected boolean a()
  {
    return this.b != -1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.fm.c
 * JD-Core Version:    0.6.2
 */