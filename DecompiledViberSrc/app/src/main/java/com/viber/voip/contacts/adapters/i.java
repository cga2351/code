package com.viber.voip.contacts.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.ui.af.c;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;

public abstract class i extends g
{
  protected dagger.a<a> j;
  private final int k;
  private com.viber.voip.contacts.a l;
  private CharSequence m;

  public i(Context paramContext, boolean paramBoolean, com.viber.voip.contacts.a parama1, com.viber.voip.contacts.a parama2, LayoutInflater paramLayoutInflater)
  {
    super(paramContext, paramBoolean, parama1, paramLayoutInflater);
    this.k = paramContext.getResources().getDimensionPixelSize(R.dimen.contacts_item_top_bottom_margin);
    this.l = parama2;
    c();
  }

  private String a(com.viber.voip.model.c paramc, int paramInt)
  {
    if ((paramc.r()) && (paramInt < this.l.getCount()))
      return b.g;
    return b.a(paramc.x());
  }

  private void c()
  {
    this.j = new com.viber.voip.g.b.b()
    {
      protected i.a a()
      {
        b localb = ViberApplication.getInstance().getContactManager().h();
        Character[] arrayOfCharacter = localb.b();
        CharSequence localCharSequence = localb.a();
        return new i.a(localCharSequence, arrayOfCharacter, new c(i.this.b(), localCharSequence, localb.c())
        {
          protected String a(com.viber.voip.model.c paramAnonymous2c, int paramAnonymous2Int)
          {
            return i.a(i.this, paramAnonymous2c, paramAnonymous2Int);
          }
        });
      }
    };
  }

  protected void a(View paramView, int paramInt)
  {
    g.a locala = (g.a)paramView.getTag();
    if (locala.i.getVisibility() == 0)
    {
      CharSequence localCharSequence = f(getSectionForPosition(paramInt));
      if (!da.a(localCharSequence))
        locala.i.setText(localCharSequence);
    }
  }

  protected void a(View paramView, g.a parama, CharSequence paramCharSequence, boolean paramBoolean)
  {
    af.c localc = (af.c)paramView.getTag(R.id.header);
    if (localc == null)
      return;
    localc.b(true);
    localc.a(paramBoolean);
    localc.a(paramCharSequence);
    localc.a(((ViewGroup.MarginLayoutParams)parama.g.getLayoutParams()).topMargin);
    localc.a("");
  }

  protected com.viber.provider.c b()
  {
    return this.a;
  }

  protected int e(int paramInt)
  {
    if (paramInt == 0)
      return this.k;
    return 0;
  }

  public boolean e_(int paramInt)
  {
    int i = getSectionForPosition(paramInt);
    if (paramInt > 0);
    for (int n = getSectionForPosition(paramInt - 1); i != n; n = -1)
      return true;
    return false;
  }

  protected CharSequence f(int paramInt)
  {
    Character[] arrayOfCharacter = ((a)this.j.get()).b;
    if (arrayOfCharacter != null)
    {
      Character localCharacter = arrayOfCharacter[paramInt];
      Object localObject = Character.toString(localCharacter.charValue());
      if (b.f == localCharacter)
      {
        if (this.m == null)
        {
          SpannableString localSpannableString = SpannableString.valueOf((CharSequence)localObject);
          Drawable localDrawable1 = this.c.getResources().getDrawable(R.drawable.ic_contacts_favorite);
          localDrawable1.setBounds(0, 0, localDrawable1.getIntrinsicWidth(), localDrawable1.getIntrinsicHeight());
          Drawable localDrawable2 = df.a(localDrawable1, dc.d(this.c, R.attr.listSectionHeaderTextColor), false);
          if (localDrawable2 != null)
            localSpannableString.setSpan(new ImageSpan(localDrawable2), 0, ((String)localObject).length(), 33);
          this.m = localSpannableString;
        }
        localObject = this.m;
      }
      return localObject;
    }
    return "";
  }

  public int getPositionForSection(int paramInt)
  {
    if (paramInt < 0)
      return 0;
    return ((a)this.j.get()).c.getPositionForSection(paramInt);
  }

  public int getSectionForPosition(int paramInt)
  {
    if (paramInt < 0)
      return 0;
    return ((a)this.j.get()).c.getSectionForPosition(paramInt);
  }

  public Object[] getSections()
  {
    return ((a)this.j.get()).c.getSections();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool1 = true;
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    g.a locala = (g.a)localView.getTag();
    int i = getSectionForPosition(paramInt);
    int n;
    int i1;
    label55: boolean bool2;
    label73: boolean bool3;
    label101: int i6;
    label232: CharSequence localCharSequence;
    if (paramInt >= 0)
    {
      n = getSectionForPosition(paramInt + 1);
      if (paramInt <= 0)
        break label321;
      i1 = getSectionForPosition(paramInt - 1);
      TextView localTextView = locala.i;
      if (i == i1)
        break label327;
      bool2 = bool1;
      dj.c(localTextView, bool2);
      if ((i == n) || (paramInt == -1 + getCount()))
        break label333;
      bool3 = bool1;
      dj.b(locala.n, false);
      int i2 = e(paramInt);
      if (locala.g != null)
        ((ViewGroup.MarginLayoutParams)locala.g.getLayoutParams()).topMargin = i2;
      ((ViewGroup.MarginLayoutParams)locala.b.getLayoutParams()).topMargin = i2;
      ViewGroup localViewGroup = (ViewGroup)locala.b.getParent();
      int i3 = localViewGroup.getPaddingLeft();
      int i4 = localViewGroup.getPaddingTop();
      int i5 = localViewGroup.getPaddingRight();
      if ((!bool3) && (paramInt != -1 + getCount()) && ((paramInt >= -1 + getCount()) || (!e_(paramInt + 1))))
        break label339;
      i6 = this.k;
      localViewGroup.setPadding(i3, i4, i5, i6);
      localCharSequence = f(i);
      if (i == i1)
        break label345;
    }
    while (true)
    {
      a(localView, locala, localCharSequence, bool1);
      a(localView, paramInt);
      if (this.a.x_())
        dg.a(locala.s, this.a.a(), 2147483647);
      return localView;
      n = -1;
      break;
      label321: i1 = -1;
      break label55;
      label327: bool2 = false;
      break label73;
      label333: bool3 = false;
      break label101;
      label339: i6 = 0;
      break label232;
      label345: bool1 = false;
    }
  }

  public void notifyDataSetChanged()
  {
    c();
    super.notifyDataSetChanged();
  }

  protected static class a
  {
    public final CharSequence a;
    public final Character[] b;
    public final c<com.viber.voip.model.c> c;

    public a(CharSequence paramCharSequence, Character[] paramArrayOfCharacter, c<com.viber.voip.model.c> paramc)
    {
      this.a = paramCharSequence;
      this.b = paramArrayOfCharacter;
      this.c = paramc;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.i
 * JD-Core Version:    0.6.2
 */