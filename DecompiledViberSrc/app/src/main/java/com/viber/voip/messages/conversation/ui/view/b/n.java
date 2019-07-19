package com.viber.voip.messages.conversation.ui.view.b;

import android.app.Activity;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.viber.common.b.d;
import com.viber.common.d.c;
import com.viber.common.dialogs.m;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.quote.QuotedMessageData;
import com.viber.voip.messages.MessageEditText;
import com.viber.voip.messages.MessageEditText.a;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.presenter.input.InputFieldPresenter;
import com.viber.voip.messages.conversation.ui.view.i;
import com.viber.voip.messages.shopchat.OpenShopChatPanelData;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.messages.ui.MessageComposerView.a;
import com.viber.voip.messages.ui.SendButton;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout;
import com.viber.voip.settings.d.ba;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.ViberActionRunner.bb;
import com.viber.voip.util.bp;
import com.viber.voip.util.br;
import com.viber.voip.util.ca;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;

public class n<P extends InputFieldPresenter> extends a<P>
  implements View.OnClickListener, i
{
  private static final Logger a = ViberEnv.getLogger();
  private final MessageComposerView b;
  private final MessageComposerView.a g;
  private final ai h;
  private ExpandablePanelLayout i;
  private MessageEditText j;
  private SendButton k;
  private TextView l;
  private View m;
  private View n;
  private TextWatcher o = new TextWatcher()
  {
    private boolean b;

    public void afterTextChanged(Editable paramAnonymousEditable)
    {
    }

    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }

    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      boolean bool = true;
      int i;
      if (!this.b)
      {
        this.b = bool;
        i = paramAnonymousInt1 + paramAnonymousInt3;
      }
      try
      {
        n.b(n.this).a(n.a(n.this), aj.b, paramAnonymousInt1, i);
        Editable localEditable = n.a(n.this).getText();
        ImageSpan[] arrayOfImageSpan = (ImageSpan[])localEditable.getSpans(i, i, ImageSpan.class);
        if ((arrayOfImageSpan != null) && (arrayOfImageSpan.length > 0))
        {
          ImageSpan localImageSpan = arrayOfImageSpan[0];
          if (localEditable.getSpanStart(localImageSpan) < i)
            n.a(n.this).setSelection(localEditable.getSpanEnd(localImageSpan));
        }
        InputFieldPresenter localInputFieldPresenter = (InputFieldPresenter)n.d(n.this);
        if ((n.c(n.this).hasFocus()) && (paramAnonymousInt3 > 0))
        {
          localInputFieldPresenter.b(bool, false);
          n.a(n.this, paramAnonymousCharSequence);
          this.b = false;
          ((InputFieldPresenter)n.f(n.this)).a(paramAnonymousCharSequence, n.e(n.this).getState());
          return;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        while (true)
        {
          n.a(n.this).setText(n.a(n.this).getText().toString());
          continue;
          bool = false;
        }
      }
    }
  };

  public n(P paramP, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean, MessageComposerView paramMessageComposerView, ai paramai)
  {
    super(paramP, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.b = paramMessageComposerView;
    this.g = paramMessageComposerView.getActionViewsHelper();
    this.h = paramai;
    m();
    n();
  }

  private boolean a(String paramString)
  {
    return (paramString == null) || (da.a(paramString.trim()));
  }

  private void b(CharSequence paramCharSequence)
  {
    MessageEditText localMessageEditText;
    if ((br.e.a()) && (c.a()))
    {
      localMessageEditText = this.j;
      if ((!da.a(paramCharSequence)) && (!bp.a(paramCharSequence.toString())))
        break label50;
    }
    label50: for (int i1 = 5; ; i1 = 3)
    {
      localMessageEditText.setGravity(i1 | 0x10);
      return;
    }
  }

  private void m()
  {
    this.i = ((ExpandablePanelLayout)this.mRootView.findViewById(R.id.conversation_menu));
    this.l = ((TextView)this.mRootView.findViewById(R.id.is_typing_text));
    this.j = this.b.getMessageEdit();
    this.k = this.b.getSendButton();
    this.k.a((ImageView)this.mRootView.findViewById(R.id.record_toggle));
  }

  private void n()
  {
    MessageComposerView localMessageComposerView = this.b;
    InputFieldPresenter localInputFieldPresenter = (InputFieldPresenter)this.mPresenter;
    localInputFieldPresenter.getClass();
    localMessageComposerView.setOnMessageEditClickListener(o.a(localInputFieldPresenter));
  }

  public void a()
  {
    dg.a(this.b.getMessageEdit(), R.string.send_text_hint);
  }

  public void a(int paramInt1, int paramInt2, View paramView)
  {
    this.b.a(paramInt1, paramInt2, paramView);
  }

  public void a(int paramInt, aa paramaa)
  {
    if (paramInt == R.id.menu_reply)
    {
      locald = d.ba.a;
      if (locald.d() == 1)
        locald.a(2);
      ((InputFieldPresenter)this.mPresenter).a(paramaa, 0);
    }
    while (paramInt != R.id.menu_edit)
    {
      d locald;
      return;
    }
    ((InputFieldPresenter)this.mPresenter).b(paramaa);
  }

  public void a(QuotedMessageData paramQuotedMessageData)
  {
    this.b.a(paramQuotedMessageData);
  }

  public void a(MessageEditText.a parama, boolean paramBoolean)
  {
    this.j.a(parama, this.f);
    switch (2.a[parama.ordinal()])
    {
    default:
      return;
    case 1:
    case 2:
    case 3:
      this.j.setOnEditorActionListener(this.g.L);
      return;
    case 4:
    }
    MessageEditText localMessageEditText = this.j;
    if ((paramBoolean) && (!this.f));
    for (TextView.OnEditorActionListener localOnEditorActionListener = this.g.L; ; localOnEditorActionListener = null)
    {
      localMessageEditText.setOnEditorActionListener(localOnEditorActionListener);
      return;
    }
  }

  public void a(OpenShopChatPanelData paramOpenShopChatPanelData)
  {
    ViberActionRunner.bb.a(this.d, paramOpenShopChatPanelData, this.f);
  }

  public void a(CharSequence paramCharSequence)
  {
    CharSequence localCharSequence = (CharSequence)ca.a(paramCharSequence, "");
    this.j.getText().replace(0, this.j.length(), localCharSequence);
  }

  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramCharSequence);
    String str = this.j.getText().toString();
    int i1 = str.length();
    if (i1 > 0)
      this.j.setSelection(i1);
    if (paramBoolean)
    {
      this.g.b(3);
      return;
    }
    if (a(str))
    {
      this.g.b(this.b.getRecordOrSendTextButtonState());
      return;
    }
    this.g.b(0);
  }

  public void a(boolean paramBoolean)
  {
    this.g.b(paramBoolean);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b.a(paramBoolean1, paramBoolean2);
  }

  public void b()
  {
    this.i.c();
  }

  public void b(boolean paramBoolean)
  {
    int i1 = 1;
    label47: MessageEditText localMessageEditText;
    if (paramBoolean)
    {
      this.k.a(5);
      SendButton localSendButton = this.k;
      if (!this.g.g())
      {
        int i3 = i1;
        localSendButton.setEnabled(i3);
        this.g.d();
        this.j.setSingleLine(paramBoolean);
        localMessageEditText = this.j;
        if (!paramBoolean)
          break label102;
      }
    }
    while (true)
    {
      localMessageEditText.setMaxLines(i1);
      this.g.a(paramBoolean);
      return;
      int i4 = 0;
      break;
      this.k.setEnabled(i1);
      this.b.q();
      break label47;
      label102: int i2 = 5;
    }
  }

  public void c()
  {
    this.b.u();
  }

  public void c(boolean paramBoolean)
  {
    dj.a(this.b, paramBoolean);
  }

  public void d()
  {
    this.b.d();
  }

  public void d(boolean paramBoolean)
  {
    this.b.c(paramBoolean);
  }

  public void d_(boolean paramBoolean)
  {
    super.d_(paramBoolean);
    ((InputFieldPresenter)this.mPresenter).e(paramBoolean);
  }

  public void e()
  {
    this.b.p();
  }

  public void e(boolean paramBoolean)
  {
    if (this.b.getViewState() != 1)
      return;
    dj.b(this.b, paramBoolean);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.addRule(2, R.id.message_composer);
      return;
    }
    localLayoutParams.addRule(2, R.id.edit_options);
  }

  public void f()
  {
    Editable localEditable = this.j.getText();
    if ((localEditable != null) && (localEditable.length() > 0))
      a("");
  }

  public void f(boolean paramBoolean)
  {
    if ((this.m == null) && (paramBoolean))
      this.m = this.b.findViewById(R.id.edit_text);
    if ((this.n == null) && (paramBoolean))
      this.n = this.b.findViewById(R.id.edit_hide);
    dj.b(this.m, paramBoolean);
    dj.b(this.n, paramBoolean);
    if (paramBoolean)
    {
      this.k.a(6);
      this.n.setOnClickListener(this);
      return;
    }
    this.k.a(0);
  }

  public void g()
  {
    this.j.removeTextChangedListener(this.o);
    this.j.addTextChangedListener(this.o);
  }

  public void g(boolean paramBoolean)
  {
    if (!this.g.a(2))
      this.g.d(paramBoolean);
  }

  public void h()
  {
    this.g.k();
  }

  public void i()
  {
    this.b.i();
  }

  public void j()
  {
    this.g.l();
  }

  public void k()
  {
    this.j.requestFocus();
    dj.b(this.j);
  }

  public void l()
  {
    dj.d(this.j);
  }

  public boolean onBackPressed()
  {
    return ((InputFieldPresenter)this.mPresenter).a(this.b.getViewState(), this.i.d(), this.b.e());
  }

  public void onClick(View paramView)
  {
    if (paramView == this.n)
      ((InputFieldPresenter)this.mPresenter).l();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    InputFieldPresenter localInputFieldPresenter = (InputFieldPresenter)this.mPresenter;
    if (paramConfiguration.orientation == 2);
    for (boolean bool = true; ; bool = false)
    {
      localInputFieldPresenter.d(bool);
      return;
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.j.removeTextChangedListener(this.o);
  }

  public boolean onDialogAction(m paramm, int paramInt)
  {
    if (((paramm.a(DialogCode.D1012a)) || (paramm.a(DialogCode.D1012c))) && (-1 != paramInt) && (this.f))
      ((InputFieldPresenter)this.mPresenter).f();
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.n
 * JD-Core Version:    0.6.2
 */