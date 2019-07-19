package com.viber.voip.permissions;

import android.content.res.Resources;
import android.text.Html;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ui.dialogs.q;

public class m
{
  private static final SparseArray<c> a = new SparseArray();
  private final c b;

  static
  {
    d locald1 = new d(R.string.dialog_permission_camera, R.string.dialog_permission_action_scan_qr_code, R.string.dialog_permission_camera, R.string.dialog_permission_switch_camera);
    a.put(4, locald1);
    a.put(5, locald1);
    a.put(2, locald1);
    a.put(3, locald1);
    a.put(1, locald1);
    d locald2 = new d(R.string.dialog_permission_camera, R.string.dialog_permission_action_take_photos, R.string.dialog_permission_camera, R.string.dialog_permission_switch_camera);
    a.put(7, locald2);
    a.put(11, locald2);
    a.put(6, locald2);
    a.put(9, locald2);
    a.put(13, locald2);
    a.put(8, locald2);
    a.put(19, locald2);
    a.put(20, locald2);
    a.put(18, locald2);
    a.put(17, locald2);
    a.put(16, locald2);
    a.put(21, locald2);
    a.put(22, locald2);
    d locald3 = new d(R.string.dialog_permission_camera, R.string.dialog_permission_action_take_photos, R.string.dialog_permission_camera_storage, R.string.dialog_permission_switch_camera_storage);
    a.put(14, locald3);
    a.put(15, locald3);
    a.put(10, locald3);
    a.put(12, locald3);
    d locald4 = new d(R.string.dialog_permission_mic, R.string.dialog_permission_action_take_video, R.string.dialog_permission_mic, R.string.dialog_permission_switch_mic);
    a.put(25, locald4);
    d locald5 = new d(R.string.dialog_permission_mic, R.string.dialog_permission_action_ptt, R.string.dialog_permission_mic, R.string.dialog_permission_switch_mic);
    a.put(26, locald5);
    a.put(27, new d(R.string.dialog_permission_camera_mic, R.string.dialog_permission_action_vptt, R.string.dialog_permission_camera_mic, R.string.dialog_permission_switch_camera_mic));
    b localb1 = new b(R.string.dialog_explain_video_call_permission_title, R.string.dialog_permission_action_video_call, R.string.dialog_permission_camera_mic, R.string.dialog_permission_switch_camera_mic);
    a.put(28, localb1);
    a.put(29, localb1);
    a.put(35, localb1);
    a.put(32, localb1);
    a.put(33, localb1);
    a.put(34, localb1);
    a.put(36, localb1);
    a.put(37, localb1);
    a.put(31, localb1);
    a.put(30, localb1);
    b localb2 = new b(R.string.dialog_explain_voice_call_permission_title, R.string.dialog_permission_action_voice_call, R.string.dialog_permission_mic, R.string.dialog_permission_switch_mic);
    a.put(49, localb2);
    a.put(50, localb2);
    a.put(60, localb2);
    a.put(61, localb2);
    a.put(52, localb2);
    a.put(53, localb2);
    a.put(54, localb2);
    a.put(57, localb2);
    a.put(56, localb2);
    a.put(51, localb2);
    a.put(58, localb2);
    a.put(59, localb2);
    a.put(62, localb2);
    a.put(63, localb2);
    a.put(144, localb2);
    a.put(145, localb2);
    a.put(146, localb2);
    a.put(55, new d(R.string.dialog_permission_phone, R.string.dialog_permission_action_voice_call, R.string.dialog_permission_phone, R.string.dialog_permission_switch_phone));
    b localb3 = new b(R.string.dialog_explain_vo_call_permission_title, R.string.dialog_permission_action_voice_call, R.string.dialog_permission_mic, R.string.dialog_permission_switch_mic);
    a.put(40, localb3);
    a.put(41, localb3);
    a.put(46, localb3);
    a.put(47, localb3);
    a.put(42, localb3);
    a.put(43, localb3);
    a.put(44, localb3);
    a.put(45, localb3);
    a.put(38, localb3);
    a.put(39, localb3);
    a.put(48, localb3);
    d locald6 = new d(R.string.dialog_permission_contacts, R.string.dialog_permission_action_contacts, R.string.dialog_permission_contacts, R.string.dialog_permission_switch_contacts);
    a.put(75, locald6);
    a.put(72, locald6);
    a.put(71, locald6);
    a.put(84, locald6);
    a.put(85, locald6);
    a.put(76, locald6);
    a.put(77, locald6);
    a.put(73, locald6);
    a.put(82, locald6);
    a.put(83, locald6);
    a.put(74, locald6);
    a.put(80, locald6);
    a.put(81, locald6);
    a.put(70, locald6);
    a.put(86, locald6);
    a.put(87, locald6);
    a.put(88, locald6);
    a.put(89, locald6);
    a.put(90, locald6);
    a.put(91, locald6);
    a.put(92, locald6);
    a.put(93, locald6);
    a.put(94, locald6);
    a.put(78, locald6);
    a.put(79, locald6);
    a.put(95, locald6);
    a.put(96, locald6);
    a.put(64, new d(R.string.dialog_permission_location, R.string.dialog_permission_action_send_location, R.string.dialog_permission_location, R.string.dialog_permission_switch_location));
    a.put(66, new d(R.string.dialog_permission_location, R.string.dialog_permission_action_attach_location, R.string.dialog_permission_location, R.string.dialog_permission_switch_location));
    a.put(67, new d(R.string.dialog_permission_location, R.string.dialog_permission_action_web_location, R.string.dialog_permission_location, R.string.dialog_permission_switch_location));
    a.put(65, new d(R.string.dialog_permission_location, R.string.dialog_permission_action_select_location, R.string.dialog_permission_location, R.string.dialog_permission_switch_location));
    d locald7 = new d(R.string.dialog_permission_location, R.string.dialog_permission_action_web_location, R.string.dialog_permission_location, R.string.dialog_permission_switch_location);
    a.put(68, locald7);
    a locala = new a(R.string.dialog_permission_storage, R.string.dialog_explain_storage_permission_message, R.string.dialog_permission_switch_storage);
    a.put(100, locala);
    a.put(101, locala);
    a.put(102, locala);
    a.put(103, locala);
    a.put(99, locala);
    a.put(104, locala);
    a.put(109, locala);
    a.put(138, locala);
    a.put(110, locala);
    a.put(111, locala);
    a.put(112, locala);
    a.put(113, locala);
    a.put(114, locala);
    a.put(116, locala);
    a.put(117, locala);
    a.put(118, locala);
    a.put(122, locala);
    a.put(123, locala);
    a.put(120, locala);
    a.put(119, locala);
    a.put(121, locala);
    a.put(142, locala);
    a.put(137, locala);
    a.put(124, locala);
    a.put(125, locala);
    a.put(126, locala);
    a.put(127, locala);
    a.put(128, locala);
    a.put(129, locala);
    a.put(130, locala);
    a.put(131, locala);
    a.put(132, locala);
    a.put(133, locala);
    a.put(134, locala);
    a.put(135, locala);
    a.put(136, locala);
    a.put(139, locala);
    a.put(140, locala);
    a.put(143, locala);
    a.put(115, new d(R.string.dialog_permission_contacts, R.string.dialog_permission_action_contacts, R.string.dialog_permission_contacts_storage, R.string.dialog_permission_switch_contacts_storage));
    a.put(141, new d(R.string.dialog_permission_camera, R.string.dialog_permission_action_generic, R.string.dialog_permission_camera, R.string.dialog_permission_switch_camera));
    d locald8 = new d(R.string.dialog_permission_storage, R.string.debug_dialog_explain_backup_restore_db_message, R.string.dialog_permission_storage, R.string.dialog_permission_switch_storage);
    a.put(107, locald8);
    a.put(108, locald8);
    a.put(105, locald8);
    a.put(106, locald8);
  }

  public m(c paramc)
  {
    this.b = paramc;
  }

  public static Pair<Integer, m> a(int paramInt)
  {
    c localc = (c)a.get(paramInt);
    if (localc != null)
      return new Pair(Integer.valueOf(paramInt), new m(localc));
    throw new IllegalArgumentException();
  }

  public a.a a(Resources paramResources)
  {
    return q.a().a(R.id.title, this.b.b(paramResources).toString()).a(R.id.message, this.b.a(paramResources));
  }

  public a.a b(Resources paramResources)
  {
    return q.b().a(R.id.title, this.b.b(paramResources).toString()).a(R.id.message, this.b.c(paramResources));
  }

  private static class a extends m.d
  {
    final int a;

    a(int paramInt1, int paramInt2, int paramInt3)
    {
      super(0, 0, paramInt3);
      this.a = paramInt2;
    }

    public CharSequence a(Resources paramResources)
    {
      return Html.fromHtml(paramResources.getString(this.a));
    }
  }

  private static class b extends m.d
  {
    final int a;

    b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super(paramInt2, paramInt3, paramInt4);
      this.a = paramInt1;
    }

    public CharSequence b(Resources paramResources)
    {
      return Html.fromHtml(paramResources.getString(this.a));
    }
  }

  static abstract interface c
  {
    public abstract CharSequence a(Resources paramResources);

    public abstract CharSequence b(Resources paramResources);

    public abstract CharSequence c(Resources paramResources);
  }

  private static class d
    implements m.c
  {
    final int b;
    final int c;
    final int d;
    final int e;

    d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
    }

    public CharSequence a(Resources paramResources)
    {
      int i = R.string.dialog_explain_permission_message;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramResources.getString(this.c);
      arrayOfObject[1] = paramResources.getString(this.d);
      return Html.fromHtml(paramResources.getString(i, arrayOfObject));
    }

    public CharSequence b(Resources paramResources)
    {
      int i = R.string.dialog_explain_permission_title;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramResources.getString(this.b);
      return Html.fromHtml(paramResources.getString(i, arrayOfObject));
    }

    public CharSequence c(Resources paramResources)
    {
      CharSequence[] arrayOfCharSequence = new CharSequence[2];
      arrayOfCharSequence[0] = a(paramResources);
      StringBuilder localStringBuilder = new StringBuilder().append("&nbsp;");
      int i = R.string.dialog_ask_permission_message;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramResources.getString(this.e);
      arrayOfCharSequence[1] = Html.fromHtml(paramResources.getString(i, arrayOfObject));
      return TextUtils.concat(arrayOfCharSequence);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.permissions.m
 * JD-Core Version:    0.6.2
 */