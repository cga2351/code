package com.viber.voip.backup.ui.a.c;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Paint.FontMetrics;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.BackupInfo;
import com.viber.voip.backup.p;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.ViberActionRunner.h;
import com.viber.voip.util.links.e;
import com.viber.voip.widget.ProgressBar;

public class c extends d<com.viber.voip.backup.ui.a.a.c>
{
  private static final Logger h = ViberEnv.getLogger();
  private ViberTextView i;
  private boolean j;

  public c(Activity paramActivity, Fragment paramFragment, View paramView, Resources paramResources, p paramp, boolean paramBoolean)
  {
    super(paramActivity, paramFragment, paramView, paramResources, paramp);
    this.j = paramBoolean;
  }

  protected b a()
  {
    View localView = this.e.findViewById(R.id.backup_action_auto_backup);
    return new b(a.b, this, localView, (ViberTextView)localView.findViewById(R.id.backup_action_auto_backup_title), (ViberTextView)localView.findViewById(R.id.backup_action_auto_backup_state));
  }

  public void a(BackupInfo paramBackupInfo)
  {
    if (!this.a.isFinishing())
      ViberActionRunner.h.a(paramBackupInfo);
  }

  protected b b()
  {
    View localView = this.e.findViewById(R.id.backup_action_backup);
    return new b(a.c, this, localView, (ViberTextView)localView.findViewById(R.id.backup_action_backup_title));
  }

  protected b c()
  {
    this.i = ((ViberTextView)this.e.findViewById(R.id.backup_action_change_account));
    e locale = e.a();
    locale.a(true, hashCode());
    this.i.setMovementMethod(locale);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.d.getString(R.string.backup_change_account_description_part1));
    int k = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append(this.d.getString(R.string.backup_change_account_description_part2));
    localSpannableStringBuilder.setSpan(new ClickableSpan()
    {
      public void onClick(View paramAnonymousView)
      {
        ((com.viber.voip.backup.ui.a.a.c)c.this.g).a(a.f);
      }

      public void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        super.updateDrawState(paramAnonymousTextPaint);
        paramAnonymousTextPaint.setUnderlineText(false);
      }
    }
    , k, localSpannableStringBuilder.length(), 33);
    localSpannableStringBuilder.append(this.d.getString(R.string.backup_change_account_description_part3));
    b.a local2 = new b.a()
    {
      public void a(a paramAnonymousa)
      {
        if ((c.a(c.this).getSelectionStart() == -1) && (c.a(c.this).getSelectionEnd() == -1))
          jdField_this.a(paramAnonymousa);
      }
    };
    b localb = new b(a.f, local2, this.i, this.i);
    localb.a(localSpannableStringBuilder);
    return localb;
  }

  protected b d()
  {
    View localView = this.e.findViewById(R.id.backup_action_restore);
    return new b(a.e, this, localView, (ViberTextView)localView.findViewById(R.id.backup_action_restore_title));
  }

  protected b e()
  {
    View localView = this.e.findViewById(R.id.backup_backing_up_panel);
    return new b(a.d, this, localView, (ViberTextView)localView.findViewById(R.id.backup_backing_up_panel_title), (ViberTextView)localView.findViewById(R.id.backup_backing_up_state), (ProgressBar)this.e.findViewById(R.id.backup_backing_up_progress));
  }

  protected b f()
  {
    View localView = this.e.findViewById(R.id.backup_select_account_container);
    return new b(a.g, this, localView, (ViberTextView)localView.findViewById(R.id.backup_action_connect_to_drive_title), (ViberTextView)localView.findViewById(R.id.backup_action_connect_to_drive_subtitle));
  }

  protected b g()
  {
    TextView localTextView = (TextView)this.e.findViewById(R.id.backup_encryption_note);
    Paint.FontMetrics localFontMetrics = localTextView.getPaint().getFontMetrics();
    int k = Math.round(localFontMetrics.bottom - localFontMetrics.descent);
    localTextView.setPadding(localTextView.getPaddingLeft(), k + localTextView.getPaddingTop(), localTextView.getPaddingRight(), localTextView.getPaddingBottom());
    View localView = this.e.findViewById(R.id.backup_info_container);
    return new b(a.h, this, localView, (ViberTextView)localView.findViewById(R.id.backup_last_time), (ViberTextView)localView.findViewById(R.id.backup_last_size));
  }

  protected i h()
  {
    return new i(this)
    {
      public void a()
      {
        c.this.m();
        c localc = c.this;
        a[] arrayOfa = new a[2];
        arrayOfa[0] = a.g;
        arrayOfa[1] = a.h;
        localc.c(true, arrayOfa);
      }

      public void b()
      {
        c localc1 = c.this;
        a[] arrayOfa1 = new a[2];
        arrayOfa1[0] = a.g;
        arrayOfa1[1] = a.h;
        localc1.a(true, arrayOfa1);
        c localc2 = c.this;
        a[] arrayOfa2 = new a[1];
        arrayOfa2[0] = a.g;
        localc2.b(false, arrayOfa2);
      }

      public void c()
      {
        c.this.m();
        c localc = c.this;
        a[] arrayOfa = new a[4];
        arrayOfa[0] = a.f;
        arrayOfa[1] = a.h;
        arrayOfa[2] = a.c;
        arrayOfa[3] = a.b;
        localc.c(true, arrayOfa);
      }

      public void d()
      {
        c localc1 = c.this;
        a[] arrayOfa1 = new a[4];
        arrayOfa1[0] = a.f;
        arrayOfa1[1] = a.h;
        arrayOfa1[2] = a.c;
        arrayOfa1[3] = a.b;
        localc1.c(true, arrayOfa1);
        c localc2 = c.this;
        boolean bool = c.b(c.this);
        a[] arrayOfa2 = new a[1];
        arrayOfa2[0] = a.e;
        localc2.c(bool, arrayOfa2);
      }

      public void e()
      {
        c localc = c.this;
        a[] arrayOfa = new a[5];
        arrayOfa[0] = a.f;
        arrayOfa[1] = a.h;
        arrayOfa[2] = a.c;
        arrayOfa[3] = a.e;
        arrayOfa[4] = a.b;
        localc.c(true, arrayOfa);
      }

      public void f()
      {
        c localc1 = c.this;
        a[] arrayOfa1 = new a[4];
        arrayOfa1[0] = a.d;
        arrayOfa1[1] = a.h;
        arrayOfa1[2] = a.b;
        arrayOfa1[3] = a.f;
        localc1.c(true, arrayOfa1);
        c localc2 = c.this;
        a[] arrayOfa2 = new a[1];
        arrayOfa2[0] = a.f;
        localc2.b(false, arrayOfa2);
      }

      public void g()
      {
        c localc1 = c.this;
        a[] arrayOfa1 = new a[5];
        arrayOfa1[0] = a.d;
        arrayOfa1[1] = a.h;
        arrayOfa1[2] = a.b;
        arrayOfa1[3] = a.f;
        arrayOfa1[4] = a.e;
        localc1.c(true, arrayOfa1);
        c localc2 = c.this;
        a[] arrayOfa2 = new a[2];
        arrayOfa2[0] = a.f;
        arrayOfa2[1] = a.e;
        localc2.b(false, arrayOfa2);
      }
    };
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.c.c
 * JD-Core Version:    0.6.2
 */