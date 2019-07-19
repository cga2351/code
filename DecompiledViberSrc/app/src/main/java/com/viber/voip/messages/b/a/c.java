package com.viber.voip.messages.b.a;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.SuggestionSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.EditText;
import com.viber.dexshared.Logger;
import com.viber.provider.d.a;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.flatbuffers.model.TextMetaInfo;
import com.viber.voip.flatbuffers.model.TextMetaInfo.a;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.k;
import com.viber.voip.messages.m;
import com.viber.voip.ui.style.UserMentionSpan;
import com.viber.voip.ui.style.e;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.n;
import com.viber.voip.widget.ac.a;
import com.viber.voip.widget.f;
import org.greenrobot.eventbus.EventBus;

public final class c
  implements d.a, b.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final ac.a A = new ac.a()
  {
    public void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (c.c(c.this));
      while ((c.a(c.this, paramAnonymousInt1, paramAnonymousInt2)) || (paramAnonymousInt1 != paramAnonymousInt2))
        return;
      c.g(c.this);
    }
  };
  private final Context b;
  private final View c;
  private final EditText d;
  private View e;
  private RecyclerView f;
  private b g;
  private final Handler h;
  private long i = -1L;
  private int j = -1;
  private int k = -1;
  private int l = 0;
  private boolean m = true;
  private final com.viber.voip.messages.conversation.ac n;
  private final com.viber.voip.messages.d.b o;
  private final b p = new b(null);
  private final com.viber.voip.ui.style.d q;
  private final a r;
  private final g s;
  private final int t;
  private com.viber.common.ui.c u;
  private final ViewTreeObserver.OnPreDrawListener v = new ViewTreeObserver.OnPreDrawListener()
  {
    public boolean onPreDraw()
    {
      if (c.a(c.this) != null)
        c.a(c.this).c();
      return true;
    }
  };
  private LayoutInflater w;
  private final Runnable x = new Runnable()
  {
    public void run()
    {
      dj.b(c.b(c.this), false);
    }
  };
  private final TextWatcher y = new TextWatcher()
  {
    private UserMentionSpan b;
    private String c;
    private int d = -1;
    private int e = -1;

    private void a(Editable paramAnonymousEditable)
    {
      c.a(c.this, true);
      int i = 0;
      while (i < paramAnonymousEditable.length())
        if ((da.a(paramAnonymousEditable.charAt(i))) && (!c.a(c.this, paramAnonymousEditable, i)))
          paramAnonymousEditable.delete(i, i + 1);
        else
          i++;
      c.a(c.this, false);
    }

    private void a(Editable paramAnonymousEditable, boolean paramAnonymousBoolean)
    {
      c.a(c.this, true);
      if (paramAnonymousBoolean)
      {
        int i = paramAnonymousEditable.getSpanStart(this.b);
        int j = paramAnonymousEditable.getSpanEnd(this.b);
        if ((i >= 0) && (j >= i))
          paramAnonymousEditable.replace(i, j, "");
      }
      paramAnonymousEditable.removeSpan(this.b);
      c.a(c.this, false);
    }

    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (c.c(c.this));
      Editable localEditable;
      do
      {
        return;
        localEditable = c.d(c.this).getText();
      }
      while ((this.b == null) || (this.c == null));
      int i = localEditable.getSpanStart(this.b);
      int j = localEditable.getSpanEnd(this.b);
      if ((i == -1) || (j == -1))
        a(localEditable, false);
      while (true)
      {
        a(localEditable);
        this.b = null;
        this.c = null;
        this.d = -1;
        this.e = -1;
        return;
        String str1 = localEditable.toString();
        String str2 = str1.substring(i, j);
        if (!this.c.equals(str2))
          if (this.c.equals(str1.substring(i, this.e)))
          {
            c.a(c.this, true);
            TextMetaInfo localTextMetaInfo = this.b.getMetaInfo();
            localEditable.removeSpan(this.b);
            c.e(c.this).a(localEditable, i, i + this.c.length(), localTextMetaInfo);
            c.a(c.this, false);
          }
          else if ((this.c.startsWith(str2)) && (this.c.length() == 1 + str2.length()))
          {
            a(localEditable, true);
          }
          else
          {
            a(localEditable, false);
          }
      }
    }

    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      if (c.c(c.this));
      Editable localEditable;
      UserMentionSpan[] arrayOfUserMentionSpan;
      do
      {
        return;
        this.b = null;
        this.c = null;
        this.d = -1;
        this.e = -1;
        localEditable = c.d(c.this).getText();
        arrayOfUserMentionSpan = (UserMentionSpan[])localEditable.getSpans(paramAnonymousInt1, paramAnonymousInt1, UserMentionSpan.class);
      }
      while (arrayOfUserMentionSpan.length <= 0);
      this.b = arrayOfUserMentionSpan[0];
      this.c = localEditable.subSequence(localEditable.getSpanStart(this.b), localEditable.getSpanEnd(this.b)).toString();
      this.d = paramAnonymousInt1;
      this.e = (paramAnonymousInt3 + this.d);
    }

    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }
  };
  private final View.OnFocusChangeListener z = new View.OnFocusChangeListener()
  {
    public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
    {
      if (c.c(c.this))
        return;
      c.f(c.this);
    }
  };

  public c(Context paramContext, EditText paramEditText, int paramInt, View paramView, LoaderManager paramLoaderManager, dagger.a<k> parama, com.viber.voip.messages.d.b paramb, g paramg, Handler paramHandler, EventBus paramEventBus, LayoutInflater paramLayoutInflater)
  {
    this.c = paramView;
    this.b = paramContext;
    this.d = paramEditText;
    this.t = paramInt;
    this.o = paramb;
    this.s = paramg;
    this.h = paramHandler;
    this.w = paramLayoutInflater;
    this.n = new com.viber.voip.messages.conversation.ac(28, this.b, false, false, null, 2, paramLoaderManager, parama, this, paramEventBus);
    this.q = new e();
    this.r = new a(null);
  }

  private int a(int paramInt, Editable paramEditable)
  {
    UserMentionSpan[] arrayOfUserMentionSpan = (UserMentionSpan[])paramEditable.getSpans(paramInt, paramInt, UserMentionSpan.class);
    int i1;
    if (arrayOfUserMentionSpan.length > 0)
    {
      i1 = paramEditable.getSpanStart(arrayOfUserMentionSpan[0]);
      int i2 = paramEditable.getSpanEnd(arrayOfUserMentionSpan[0]);
      if (paramInt - i1 > i2 - paramInt)
        paramInt = i2;
    }
    else
    {
      return paramInt;
    }
    return i1;
  }

  private void a(boolean paramBoolean)
  {
    int i1 = this.l;
    if (paramBoolean);
    for (int i2 = 1; ; i2 = -1)
    {
      this.l = (i2 + i1);
      return;
    }
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    Editable localEditable = this.d.getText();
    int i1 = a(paramInt1, localEditable);
    int i2 = a(paramInt2, localEditable);
    if ((i1 != paramInt1) || (i2 != paramInt2))
    {
      this.d.setSelection(i1, i2);
      return true;
    }
    return false;
  }

  private boolean a(Editable paramEditable, int paramInt)
  {
    UserMentionSpan[] arrayOfUserMentionSpan = (UserMentionSpan[])paramEditable.getSpans(paramInt, paramInt, UserMentionSpan.class);
    if (arrayOfUserMentionSpan.length > 0)
    {
      int i1 = arrayOfUserMentionSpan.length;
      for (int i2 = 0; i2 < i1; i2++)
        if (a(paramEditable, arrayOfUserMentionSpan[i2], paramInt, paramInt + 1))
          return true;
    }
    return false;
  }

  private boolean a(Editable paramEditable, Object paramObject, int paramInt1, int paramInt2)
  {
    int i1 = paramEditable.getSpanStart(paramObject);
    int i2 = paramEditable.getSpanEnd(paramObject);
    return (i1 <= paramInt1) && (i2 >= paramInt2);
  }

  private TextMetaInfo b(ae paramae)
  {
    TextMetaInfo localTextMetaInfo = new TextMetaInfo();
    localTextMetaInfo.setMemberId(c(paramae));
    localTextMetaInfo.setType(TextMetaInfo.a.MENTION);
    return localTextMetaInfo;
  }

  private void b(long paramLong, int paramInt1, int paramInt2)
  {
    this.n.a(paramLong, paramInt1, paramInt2);
    if (!this.n.d())
    {
      this.n.p();
      this.n.i();
    }
  }

  private String c(ae paramae)
  {
    if (m.a(this.j))
      return paramae.o();
    if (m.b(this.j))
      return paramae.p();
    return paramae.h();
  }

  private boolean d(ae paramae)
  {
    String str1 = this.p.c();
    if (str1 == null)
      return false;
    int i1 = this.p.b();
    int i2 = this.d.getInputType();
    Editable localEditable = this.d.getText();
    String str2 = da.a(paramae.a(this.k, this.j), true);
    int i3 = i1 + 1;
    int i4 = i3 + str1.length();
    int i5 = localEditable.length() + str2.length() - str1.length();
    if (i5 > this.t)
      return false;
    a(true);
    String str3;
    int i6;
    EditText localEditText;
    if ((i5 == this.t) || ((i4 < localEditable.length()) && (Character.isWhitespace(localEditable.charAt(i4)))))
    {
      str3 = str2;
      this.d.setInputType(0xFFFF7FFF & i2);
      localEditable.replace(i3, i4, str3);
      i6 = 1 + (i1 + str2.length());
      this.q.a(localEditable, i1, i6, b(paramae));
      localEditText = this.d;
      if (i6 != this.t)
        break label269;
    }
    while (true)
    {
      localEditText.setSelection(i6);
      this.d.setInputType(i2);
      a(false);
      return true;
      str3 = str2 + " ";
      break;
      label269: i6++;
    }
  }

  private void f()
  {
    if (!e())
      return;
    Editable localEditable = this.d.getText();
    int i1 = localEditable.length();
    if (n.a(localEditable.getSpans(0, i1, a.class)))
      localEditable.setSpan(this.r, 0, i1, 18);
    this.d.removeTextChangedListener(this.y);
    this.d.addTextChangedListener(this.y);
    if ((this.d instanceof f))
    {
      ((f)this.d).b(this.z);
      ((f)this.d).a(this.z);
    }
    if ((this.d instanceof com.viber.voip.widget.ac))
    {
      ((com.viber.voip.widget.ac)this.d).b(this.A);
      ((com.viber.voip.widget.ac)this.d).a(this.A);
    }
    t();
  }

  private boolean g()
  {
    if (!j());
    String str;
    do
    {
      return false;
      h();
      str = this.p.c();
    }
    while (str == null);
    this.n.a(str, str);
    return true;
  }

  private void h()
  {
    int i1 = this.d.getSelectionStart();
    if (i1 != this.d.getSelectionEnd())
    {
      this.p.d();
      return;
    }
    Editable localEditable = this.d.getText();
    String str1 = localEditable.toString();
    int i2 = str1.lastIndexOf('@', i1 - 1);
    if ((i2 == 0) || ((i2 > 0) && ((Character.isWhitespace(str1.charAt(i2 - 1))) || (a(localEditable, i2 - 1)))))
    {
      if (a(localEditable, i2))
      {
        this.p.d();
        return;
      }
      if (i2 == -1 + str1.length())
      {
        this.p.a("", i2);
        return;
      }
      String str2 = str1.substring(i2 + 1, i1);
      if ((str2.length() > 0) && (i2 != i1 - 1) && (da.a(str2.charAt(0))))
      {
        this.p.d();
        return;
      }
      this.p.a(str2, i2);
      return;
    }
    this.p.d();
  }

  private ae i()
  {
    int i1 = 1;
    Editable localEditable = this.d.getText();
    String str = this.p.c();
    ae localae;
    if ((str == null) || (this.n.getCount() != i1))
      localae = null;
    while (true)
    {
      return localae;
      localae = this.n.e(0);
      int i2 = this.p.b();
      int i3 = i2 + str.length();
      if ((localae != null) && (localae.a(this.k, this.j).equalsIgnoreCase(str)) && (i3 <= localEditable.length()) && (localEditable.charAt(i2) == '@') && (!a(localEditable, i2)));
      while (i1 == 0)
      {
        return null;
        i1 = 0;
      }
    }
  }

  private boolean j()
  {
    return (e()) && (this.m);
  }

  private boolean k()
  {
    return (this.d.isFocused()) && (e());
  }

  private boolean l()
  {
    return (k()) && (this.p.a()) && (this.m);
  }

  private void m()
  {
    this.d.getText().removeSpan(this.r);
    this.d.removeTextChangedListener(this.y);
    if ((this.d instanceof f))
      ((f)this.d).b(this.z);
    if ((this.d instanceof com.viber.voip.widget.ac))
      ((com.viber.voip.widget.ac)this.d).b(this.A);
    q();
  }

  private View n()
  {
    if (this.e == null)
      this.e = ((ViewStub)this.c.findViewById(R.id.mentions_filter_items_stub)).inflate();
    return this.e;
  }

  private RecyclerView o()
  {
    if (this.f == null)
    {
      this.f = ((RecyclerView)n().findViewById(R.id.mentions_contacts_list));
      this.f.setAdapter(p());
    }
    return this.f;
  }

  private b p()
  {
    if (this.g == null)
    {
      this.g = new b(this.b, this, this.w);
      this.g.a(this.n);
    }
    return this.g;
  }

  private void q()
  {
    this.h.removeCallbacks(this.x);
    if (!k())
    {
      this.h.postDelayed(this.x, 500L);
      return;
    }
    this.x.run();
  }

  private void r()
  {
    this.h.removeCallbacks(this.x);
    dj.b(this.e, true);
  }

  private void s()
  {
    this.n.q();
    this.n.j();
  }

  private void t()
  {
    if (!g())
      q();
  }

  private void u()
  {
    if (!k())
    {
      q();
      return;
    }
    f();
  }

  private boolean v()
  {
    return this.l != 0;
  }

  public void a()
  {
    d();
    s();
  }

  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (((this.i != paramLong) || (this.j != paramInt1) || (this.k != paramInt2)) && (paramLong > 0L))
    {
      this.i = paramLong;
      this.j = paramInt1;
      this.k = paramInt2;
      b(paramLong, paramInt1, paramInt2);
      f();
    }
  }

  public void a(ae paramae)
  {
    d(paramae);
    t();
  }

  public void b()
  {
    q();
    this.m = false;
  }

  public void c()
  {
    this.m = true;
    t();
  }

  public void d()
  {
    this.i = -1L;
    this.n.b(this.i);
    m();
  }

  public boolean e()
  {
    return (this.i > 0L) && (this.j >= 0) && (this.k >= 0);
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    if (l())
    {
      RecyclerView localRecyclerView = o();
      b localb = p();
      localb.a(this.j, this.k);
      localb.notifyDataSetChanged();
      com.viber.voip.util.j.a.a.a(localRecyclerView, 0);
      ae localae = i();
      if ((localae != null) && (d(localae)))
        t();
    }
    else
    {
      return;
    }
    if (paramd.getCount() > 0)
    {
      r();
      return;
    }
    q();
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  private static class a
    implements SpanWatcher
  {
    private boolean a(Object paramObject)
    {
      return (SuggestionSpan.class.isInstance(paramObject)) || (UnderlineSpan.class.isInstance(paramObject));
    }

    public void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
    {
      if ((a(paramObject)) && (!n.a(paramSpannable.getSpans(paramInt1, paramInt2, UserMentionSpan.class))))
        paramSpannable.removeSpan(paramObject);
    }

    public void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
    }

    public void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
    {
    }
  }

  private static class b
  {
    private int a = -1;
    private String b;

    public void a(String paramString, int paramInt)
    {
      this.b = paramString;
      this.a = paramInt;
    }

    public boolean a()
    {
      return (this.a > -1) && (this.b != null);
    }

    public int b()
    {
      return this.a;
    }

    public String c()
    {
      return this.b;
    }

    public void d()
    {
      this.b = null;
      this.a = -1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.b.a.c
 * JD-Core Version:    0.6.2
 */