package com.viber.voip.publicaccount.ui.holders.name;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.g;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.publicaccount.d.e;
import com.viber.voip.publicaccount.d.f;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.da;
import com.viber.voip.validation.FormValidator;
import com.viber.voip.validation.FormValidator.a;
import com.viber.voip.validation.FormValidator.b;
import com.viber.voip.validation.a.h;
import com.viber.voip.widget.TextViewWithDescription.a;
import com.viber.voip.widget.ViewWithDescription.a;
import com.viber.voip.widget.ad;
import java.util.ArrayList;

public class b extends PublicAccountEditUIHolder<NameAndCategoryData, c>
  implements m.g
{
  private static final Logger g = ViberEnv.getLogger();
  FormValidator c;
  final InputFilter d = new InputFilter()
  {
    public CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      StringBuilder localStringBuilder = new StringBuilder(paramAnonymousCharSequence.length());
      if (paramAnonymousCharSequence.length() > 0)
        for (int i = 0; i < paramAnonymousCharSequence.length(); i++)
          if (f.a(paramAnonymousCharSequence.charAt(i)))
            localStringBuilder.append(paramAnonymousCharSequence.charAt(i));
      if (localStringBuilder.length() == paramAnonymousCharSequence.length())
      {
        if (paramAnonymousCharSequence.length() > 0)
          return paramAnonymousCharSequence;
        return null;
      }
      return localStringBuilder.subSequence(0, localStringBuilder.length());
    }
  };
  final TextViewWithDescription.a e = new TextViewWithDescription.a()
  {
    public void a()
    {
      c localc = (c)b.q(b.this);
      if (!da.a(((NameAndCategoryData)b.p(b.this)).mCategoryId));
      for (boolean bool = true; ; bool = false)
      {
        localc.a(bool);
        b.a(b.this);
        return;
      }
    }
  };
  final TextViewWithDescription.a f = new TextViewWithDescription.a()
  {
    public void a()
    {
      b.a(b.this);
    }
  };
  private final Context h;
  private final Handler i;
  private final Handler j;
  private final Handler k;
  private final com.viber.voip.publicaccount.ui.holders.d l;
  private final a m;
  private final boolean n;
  private ArrayList<com.viber.voip.publicaccount.entity.b> o;
  private final View.OnClickListener p = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (((NameAndCategoryData)b.b(b.this)).mSubCategoryState == ViewWithDescription.a.e)
        b.c(b.this);
      while (b.d(b.this) == null)
        return;
      ((c)b.e(b.this)).b();
      b.g(b.this).a(((NameAndCategoryData)b.f(b.this)).mCategoryIndex, b.d(b.this));
    }
  };
  private final View.OnClickListener q = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if ((b.d(b.this) == null) || (((NameAndCategoryData)b.h(b.this)).mCategoryIndex >= b.d(b.this).size()))
        return;
      ((c)b.i(b.this)).b();
      b.g(b.this).b(((NameAndCategoryData)b.j(b.this)).mSubCategoryIndex, ((com.viber.voip.publicaccount.entity.b)b.d(b.this).get(((NameAndCategoryData)b.k(b.this)).mCategoryIndex)).c());
    }
  };

  public b(Context paramContext, com.viber.voip.publicaccount.ui.holders.d paramd, a parama, boolean paramBoolean)
  {
    this.h = paramContext;
    this.l = paramd;
    this.m = parama;
    this.n = paramBoolean;
    this.i = av.e.g.a();
    this.j = av.e.a.a();
    this.k = av.e.f.a();
    h();
  }

  private void a(int paramInt)
  {
    if ((this.o == null) || (paramInt >= this.o.size()));
    com.viber.voip.publicaccount.entity.b localb;
    do
    {
      return;
      localb = (com.viber.voip.publicaccount.entity.b)this.o.get(paramInt);
      ((NameAndCategoryData)this.a).mCategoryId = localb.b();
      ((NameAndCategoryData)this.a).mCategoryName = localb.a();
      ((c)this.b).a(((NameAndCategoryData)this.a).mCategoryName);
    }
    while (((NameAndCategoryData)this.a).mCategoryIndex == paramInt);
    ((NameAndCategoryData)this.a).mCategoryIndex = paramInt;
    ((NameAndCategoryData)this.a).mSubCategoryIndex = -1;
    ArrayList localArrayList = localb.c();
    if ((localArrayList == null) || (localArrayList.size() == 0))
    {
      ((NameAndCategoryData)this.a).mSubCategoryId = "-2";
      ((NameAndCategoryData)this.a).mSubCategoryName = this.h.getString(R.string.create_public_account_subcategory_other);
      ((c)this.b).b(this.h.getString(R.string.create_public_account_subcategory_other));
      return;
    }
    ((NameAndCategoryData)this.a).mSubCategoryId = "-1";
    ((NameAndCategoryData)this.a).mSubCategoryName = null;
    ((c)this.b).b(null);
  }

  private void b(int paramInt)
  {
    if ((this.o == null) || (((NameAndCategoryData)this.a).mCategoryIndex >= this.o.size()));
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = ((com.viber.voip.publicaccount.entity.b)this.o.get(((NameAndCategoryData)this.a).mCategoryIndex)).c();
    }
    while ((localArrayList == null) || (paramInt >= localArrayList.size()));
    ((NameAndCategoryData)this.a).mSubCategoryIndex = paramInt;
    ((NameAndCategoryData)this.a).mSubCategoryId = ((com.viber.voip.publicaccount.entity.d)localArrayList.get(paramInt)).a();
    ((NameAndCategoryData)this.a).mSubCategoryName = ((com.viber.voip.publicaccount.entity.d)localArrayList.get(paramInt)).b();
    ((c)this.b).b(((NameAndCategoryData)this.a).mSubCategoryName);
  }

  private void g()
  {
    boolean bool1 = true;
    boolean bool2;
    if (this.c != null)
      if ((this.c.d()) && (this.c.e()))
      {
        bool2 = bool1;
        if ((!bool2) || (da.a(((NameAndCategoryData)this.a).mCategoryId)) || (da.a(((NameAndCategoryData)this.a).mSubCategoryId)) || (((NameAndCategoryData)this.a).mSubCategoryId.equals("-1")))
          break label132;
      }
    while (true)
    {
      if (bool1 != ((NameAndCategoryData)this.a).mAllFieldsValid)
        ((NameAndCategoryData)this.a).mAllFieldsValid = bool1;
      this.l.a(this, bool1);
      return;
      bool2 = false;
      break;
      bool2 = false;
      break;
      label132: bool1 = false;
    }
  }

  private void h()
  {
    if (this.o != null)
    {
      ((NameAndCategoryData)this.a).mCategoryState = ViewWithDescription.a.a;
      ((c)this.b).a(((NameAndCategoryData)this.a).mCategoryState);
      return;
    }
    ((NameAndCategoryData)this.a).mCategoryState = ViewWithDescription.a.d;
    ((c)this.b).a(((NameAndCategoryData)this.a).mCategoryState);
    this.i.post(new Runnable()
    {
      public void run()
      {
        b.this.f();
      }
    });
  }

  private void i()
  {
    ((NameAndCategoryData)this.a).mCategoryIndex = -1;
    ((NameAndCategoryData)this.a).mSubCategoryIndex = -1;
    if (this.o == null)
      return;
    if (!da.a(((NameAndCategoryData)this.a).mCategoryId))
    {
      int i3 = this.o.size();
      for (int i4 = 0; i4 < i3; i4++)
      {
        com.viber.voip.publicaccount.entity.b localb = (com.viber.voip.publicaccount.entity.b)this.o.get(i4);
        if (((NameAndCategoryData)this.a).mCategoryId.equals(localb.b()))
          ((NameAndCategoryData)this.a).mCategoryIndex = i4;
      }
    }
    if ((((NameAndCategoryData)this.a).mCategoryIndex != -1) && (!da.a(((NameAndCategoryData)this.a).mSubCategoryId)))
    {
      ArrayList localArrayList = ((com.viber.voip.publicaccount.entity.b)this.o.get(((NameAndCategoryData)this.a).mCategoryIndex)).c();
      int i1 = localArrayList.size();
      for (int i2 = 0; i2 < i1; i2++)
      {
        com.viber.voip.publicaccount.entity.d locald = (com.viber.voip.publicaccount.entity.d)localArrayList.get(i2);
        if (((NameAndCategoryData)this.a).mSubCategoryId.equals(locald.a()))
          ((NameAndCategoryData)this.a).mSubCategoryIndex = i2;
      }
    }
    if ((((NameAndCategoryData)this.a).mCategoryIndex == -1) && (((NameAndCategoryData)this.a).mSubCategoryIndex == -1))
    {
      ((NameAndCategoryData)this.a).mCategoryId = null;
      ((NameAndCategoryData)this.a).mCategoryName = null;
      ((c)this.b).a(null);
      ((NameAndCategoryData)this.a).mSubCategoryId = null;
      ((NameAndCategoryData)this.a).mSubCategoryName = null;
      ((c)this.b).b(null);
    }
    c localc = (c)this.b;
    if (((NameAndCategoryData)this.a).mCategoryIndex != -1);
    for (boolean bool = true; ; bool = false)
    {
      localc.a(bool);
      return;
    }
  }

  public void a()
  {
    super.a();
    if (this.c != null)
      this.c.b();
  }

  public void a(PublicAccount paramPublicAccount)
  {
    super.a(paramPublicAccount);
    i();
  }

  protected void a(NameAndCategoryData paramNameAndCategoryData, c paramc)
  {
    paramc.a(paramNameAndCategoryData);
    paramNameAndCategoryData.mValidatorState = this.c.a();
  }

  protected void a(c paramc, NameAndCategoryData paramNameAndCategoryData)
  {
    paramc.a(paramNameAndCategoryData.mCategoryName);
    paramc.a(false);
    paramc.b(paramNameAndCategoryData.mSubCategoryName);
    h();
    h localh = new h();
    localh.a(this.k);
    localh.a(400L);
    paramc.a(localh);
    if (this.n);
    for (FormValidator.b localb = FormValidator.b.b; ; localb = FormValidator.b.a)
    {
      this.c = new FormValidator.a().a(new com.viber.voip.validation.d()
      {
        public void a(boolean paramAnonymousBoolean)
        {
          b.a(b.this);
        }
      }).a(localh, localb).a();
      paramc.a(paramNameAndCategoryData.mName, paramNameAndCategoryData.mNameViewState);
      if (paramNameAndCategoryData.mValidatorState != null)
        this.c.a(paramNameAndCategoryData.mValidatorState);
      this.j.post(new Runnable()
      {
        public void run()
        {
          b.this.c.c();
        }
      });
      return;
    }
  }

  protected Class<c> b()
  {
    return c.class;
  }

  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    g();
  }

  protected c c(View paramView)
  {
    d locald = new d(paramView);
    locald.a(this.d, new ad());
    locald.a(this.e, this.p);
    locald.b(this.f, this.q);
    return locald;
  }

  protected NameAndCategoryData e()
  {
    return new NameAndCategoryData();
  }

  void f()
  {
    final ArrayList localArrayList = e.a();
    this.j.post(new Runnable()
    {
      public void run()
      {
        NameAndCategoryData localNameAndCategoryData = (NameAndCategoryData)b.l(b.this);
        if (localArrayList != null);
        for (ViewWithDescription.a locala = ViewWithDescription.a.a; ; locala = ViewWithDescription.a.e)
        {
          localNameAndCategoryData.mCategoryState = locala;
          ((c)b.n(b.this)).a(((NameAndCategoryData)b.m(b.this)).mCategoryState);
          b.a(b.this, localArrayList);
          b.o(b.this);
          return;
        }
      }
    });
  }

  public void onDialogListAction(m paramm, int paramInt)
  {
    int i1 = 1;
    if (paramm.a(DialogCode.DC36))
      a(paramInt);
    while (true)
    {
      if (i1 != 0)
        paramm.dismiss();
      return;
      if (paramm.a(DialogCode.DC37))
        b(paramInt);
      else
        i1 = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.name.b
 * JD-Core Version:    0.6.2
 */