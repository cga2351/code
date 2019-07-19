package com.viber.voip.messages.conversation.ui.vote;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.messages.conversation.ui.vote.a.b;
import com.viber.voip.messages.conversation.ui.vote.a.d;
import com.viber.voip.ui.ad;
import com.viber.voip.util.da;
import java.util.ArrayList;
import java.util.List;

public class s extends android.support.v7.recyclerview.a.c<b, RecyclerView.ViewHolder>
{
  private final LayoutInflater a;
  private final d b;
  private final com.viber.voip.messages.conversation.ui.vote.a.a c;
  private final com.viber.voip.messages.conversation.ui.vote.a.c d;
  private final int e;
  private String f;

  s(Context paramContext, com.viber.voip.messages.conversation.ui.vote.a.a parama, d paramd, com.viber.voip.messages.conversation.ui.vote.a.c paramc, android.support.v7.recyclerview.a.a<b> parama1, int paramInt, String paramString)
  {
    super(parama1);
    this.c = parama;
    this.d = paramc;
    this.a = LayoutInflater.from(paramContext);
    this.b = paramd;
    this.e = paramInt;
    this.f = paramString;
  }

  void a(List<Vote> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(1 + (paramList.size() + this.e));
    localArrayList.add(new b(Vote.STUB, s.b.a.a));
    int i = paramList.size();
    for (int j = 0; j < i; j++)
      localArrayList.add(new b((Vote)paramList.get(j), s.b.a.b));
    if (paramBoolean)
      localArrayList.add(new b(Vote.STUB, s.b.a.c));
    super.a(localArrayList);
  }

  public int getItemViewType(int paramInt)
  {
    return s.b.a.a(((b)a(paramInt)).b);
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    default:
      return;
    case 0:
      ((c)paramViewHolder).a(((b)a(paramInt)).a);
      return;
    case 1:
    }
    ((a)paramViewHolder).a();
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return new d(new View(paramViewGroup.getContext()));
    case 0:
      return new c(this.a.inflate(R.layout.list_item_vote_option, paramViewGroup, false), this.c, this.b);
    case 2:
      String str = this.f;
      this.f = null;
      return new e(this.a.inflate(R.layout.list_item_vote_title, paramViewGroup, false), this.d, str, null);
    case 1:
    }
    return new a(this.a.inflate(R.layout.list_item_vote_add_option, paramViewGroup, false), this.b);
  }

  private static class a extends RecyclerView.ViewHolder
  {
    private final d a;
    private final View b;

    a(View paramView, d paramd)
    {
      super();
      this.a = paramd;
      this.b = paramView.findViewById(R.id.add_option);
      b();
    }

    @SuppressLint({"RtlHardcoded"})
    private void b()
    {
      if (!com.viber.common.d.c.a());
      ViewGroup.LayoutParams localLayoutParams;
      do
      {
        return;
        localLayoutParams = this.b.getLayoutParams();
      }
      while (!(localLayoutParams instanceof FrameLayout.LayoutParams));
      ((FrameLayout.LayoutParams)localLayoutParams).gravity = 5;
    }

    void a()
    {
      this.b.setOnClickListener(new t(this));
    }
  }

  static class b
  {
    final Vote a;
    final a b;

    b(Vote paramVote, a parama)
    {
      this.a = paramVote;
      this.b = parama;
    }

    public String toString()
    {
      return "Item{mValue=" + this.a + ", mType=" + this.b + '}';
    }

    static enum a
    {
      private final int d;

      static
      {
        a[] arrayOfa = new a[3];
        arrayOfa[0] = a;
        arrayOfa[1] = b;
        arrayOfa[2] = c;
      }

      private a(int paramInt)
      {
        this.d = paramInt;
      }
    }
  }

  static class c extends RecyclerView.ViewHolder
    implements b
  {
    private final EditText a;
    private final View b;
    private final d c;
    private ad d;
    private Vote e;

    @SuppressLint({"ClickableViewAccessibility"})
    c(View paramView, com.viber.voip.messages.conversation.ui.vote.a.a parama, d paramd)
    {
      super();
      this.a = ((EditText)paramView.findViewById(R.id.option_title));
      this.b = paramView.findViewById(R.id.remove_option);
      this.c = paramd;
      paramView.findViewById(R.id.drag_and_drop_icon).setOnTouchListener(new u(this, parama));
      this.a.setRawInputType(131072);
      this.a.setOnKeyListener(new v(this));
      this.a.setOnEditorActionListener(new w(this));
      this.d = new ad()
      {
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (s.c.a(s.c.this) != null)
          {
            s.c.a(s.c.this).setOption(paramAnonymousCharSequence.toString().trim());
            s.c.b(s.c.this).a(s.c.a(s.c.this));
          }
        }
      };
    }

    private void a(String paramString)
    {
      this.a.removeTextChangedListener(this.d);
      this.a.setText(paramString);
      this.a.addTextChangedListener(this.d);
    }

    public void a()
    {
      this.a.requestFocus();
    }

    void a(Vote paramVote)
    {
      this.e = paramVote;
      a(this.e.getOption());
      this.b.setOnClickListener(new x(this, paramVote));
      EditText localEditText = this.a;
      if ((this.c.c(this.e)) && (!this.c.f()));
      for (int i = 6; ; i = 5)
      {
        localEditText.setImeOptions(i);
        return;
      }
    }
  }

  private static class d extends RecyclerView.ViewHolder
  {
    d(View paramView)
    {
      super();
    }
  }

  private static final class e extends RecyclerView.ViewHolder
  {
    private final EditText a;

    private e(View paramView, final com.viber.voip.messages.conversation.ui.vote.a.c paramc, String paramString)
    {
      super();
      this.a = ((EditText)paramView.findViewById(R.id.vote_title));
      this.a.setRawInputType(147456);
      if (!da.a(paramString))
        this.a.setText(paramString);
      this.a.addTextChangedListener(new ad()
      {
        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          paramc.a(paramAnonymousCharSequence.toString().trim());
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.vote.s
 * JD-Core Version:    0.6.2
 */