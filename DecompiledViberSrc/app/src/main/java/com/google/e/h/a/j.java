package com.google.e.h.a;

import com.google.e.c.b;

public final class j
{
  private static final int[] a = { 31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017 };
  private static final j[] b = f();
  private final int c;
  private final int[] d;
  private final b[] e;
  private final int f;

  private j(int paramInt, int[] paramArrayOfInt, b[] paramArrayOfb)
  {
    this.c = paramInt;
    this.d = paramArrayOfInt;
    this.e = paramArrayOfb;
    int j = paramArrayOfb[0].a();
    a[] arrayOfa = paramArrayOfb[0].d();
    int k = arrayOfa.length;
    int m = 0;
    while (i < k)
    {
      a locala = arrayOfa[i];
      m += locala.a() * (j + locala.b());
      i++;
    }
    this.f = m;
  }

  public static j a(int paramInt)
    throws com.google.e.g
  {
    if (paramInt % 4 != 1)
      throw com.google.e.g.a();
    int i = paramInt - 17;
    try
    {
      j localj = b(i / 4);
      return localj;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
    throw com.google.e.g.a();
  }

  public static j b(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 40))
      throw new IllegalArgumentException();
    return b[(paramInt - 1)];
  }

  static j c(int paramInt)
  {
    int i = 0;
    int j = 2147483647;
    int k = 0;
    while (i < a.length)
    {
      int m = a[i];
      if (m == paramInt)
        return b(i + 7);
      int n = g.a(paramInt, m);
      if (n < j)
      {
        k = i + 7;
        j = n;
      }
      i++;
    }
    if (j <= 3)
      return b(k);
    return null;
  }

  private static j[] f()
  {
    j[] arrayOfj = new j[40];
    int[] arrayOfInt1 = new int[0];
    b[] arrayOfb1 = new b[4];
    a[] arrayOfa1 = new a[1];
    arrayOfa1[0] = new a(1, 19);
    arrayOfb1[0] = new b(7, arrayOfa1);
    a[] arrayOfa2 = new a[1];
    arrayOfa2[0] = new a(1, 16);
    arrayOfb1[1] = new b(10, arrayOfa2);
    a[] arrayOfa3 = new a[1];
    arrayOfa3[0] = new a(1, 13);
    arrayOfb1[2] = new b(13, arrayOfa3);
    a[] arrayOfa4 = new a[1];
    arrayOfa4[0] = new a(1, 9);
    arrayOfb1[3] = new b(17, arrayOfa4);
    arrayOfj[0] = new j(1, arrayOfInt1, arrayOfb1);
    int[] arrayOfInt2 = { 6, 18 };
    b[] arrayOfb2 = new b[4];
    a[] arrayOfa5 = new a[1];
    arrayOfa5[0] = new a(1, 34);
    arrayOfb2[0] = new b(10, arrayOfa5);
    a[] arrayOfa6 = new a[1];
    arrayOfa6[0] = new a(1, 28);
    arrayOfb2[1] = new b(16, arrayOfa6);
    a[] arrayOfa7 = new a[1];
    arrayOfa7[0] = new a(1, 22);
    arrayOfb2[2] = new b(22, arrayOfa7);
    a[] arrayOfa8 = new a[1];
    arrayOfa8[0] = new a(1, 16);
    arrayOfb2[3] = new b(28, arrayOfa8);
    arrayOfj[1] = new j(2, arrayOfInt2, arrayOfb2);
    int[] arrayOfInt3 = { 6, 22 };
    b[] arrayOfb3 = new b[4];
    a[] arrayOfa9 = new a[1];
    arrayOfa9[0] = new a(1, 55);
    arrayOfb3[0] = new b(15, arrayOfa9);
    a[] arrayOfa10 = new a[1];
    arrayOfa10[0] = new a(1, 44);
    arrayOfb3[1] = new b(26, arrayOfa10);
    a[] arrayOfa11 = new a[1];
    arrayOfa11[0] = new a(2, 17);
    arrayOfb3[2] = new b(18, arrayOfa11);
    a[] arrayOfa12 = new a[1];
    arrayOfa12[0] = new a(2, 13);
    arrayOfb3[3] = new b(22, arrayOfa12);
    arrayOfj[2] = new j(3, arrayOfInt3, arrayOfb3);
    int[] arrayOfInt4 = { 6, 26 };
    b[] arrayOfb4 = new b[4];
    a[] arrayOfa13 = new a[1];
    arrayOfa13[0] = new a(1, 80);
    arrayOfb4[0] = new b(20, arrayOfa13);
    a[] arrayOfa14 = new a[1];
    arrayOfa14[0] = new a(2, 32);
    arrayOfb4[1] = new b(18, arrayOfa14);
    a[] arrayOfa15 = new a[1];
    arrayOfa15[0] = new a(2, 24);
    arrayOfb4[2] = new b(26, arrayOfa15);
    a[] arrayOfa16 = new a[1];
    arrayOfa16[0] = new a(4, 9);
    arrayOfb4[3] = new b(16, arrayOfa16);
    arrayOfj[3] = new j(4, arrayOfInt4, arrayOfb4);
    int[] arrayOfInt5 = { 6, 30 };
    b[] arrayOfb5 = new b[4];
    a[] arrayOfa17 = new a[1];
    arrayOfa17[0] = new a(1, 108);
    arrayOfb5[0] = new b(26, arrayOfa17);
    a[] arrayOfa18 = new a[1];
    arrayOfa18[0] = new a(2, 43);
    arrayOfb5[1] = new b(24, arrayOfa18);
    a[] arrayOfa19 = new a[2];
    arrayOfa19[0] = new a(2, 15);
    arrayOfa19[1] = new a(2, 16);
    arrayOfb5[2] = new b(18, arrayOfa19);
    a[] arrayOfa20 = new a[2];
    arrayOfa20[0] = new a(2, 11);
    arrayOfa20[1] = new a(2, 12);
    arrayOfb5[3] = new b(22, arrayOfa20);
    arrayOfj[4] = new j(5, arrayOfInt5, arrayOfb5);
    int[] arrayOfInt6 = { 6, 34 };
    b[] arrayOfb6 = new b[4];
    a[] arrayOfa21 = new a[1];
    arrayOfa21[0] = new a(2, 68);
    arrayOfb6[0] = new b(18, arrayOfa21);
    a[] arrayOfa22 = new a[1];
    arrayOfa22[0] = new a(4, 27);
    arrayOfb6[1] = new b(16, arrayOfa22);
    a[] arrayOfa23 = new a[1];
    arrayOfa23[0] = new a(4, 19);
    arrayOfb6[2] = new b(24, arrayOfa23);
    a[] arrayOfa24 = new a[1];
    arrayOfa24[0] = new a(4, 15);
    arrayOfb6[3] = new b(28, arrayOfa24);
    arrayOfj[5] = new j(6, arrayOfInt6, arrayOfb6);
    int[] arrayOfInt7 = { 6, 22, 38 };
    b[] arrayOfb7 = new b[4];
    a[] arrayOfa25 = new a[1];
    arrayOfa25[0] = new a(2, 78);
    arrayOfb7[0] = new b(20, arrayOfa25);
    a[] arrayOfa26 = new a[1];
    arrayOfa26[0] = new a(4, 31);
    arrayOfb7[1] = new b(18, arrayOfa26);
    a[] arrayOfa27 = new a[2];
    arrayOfa27[0] = new a(2, 14);
    arrayOfa27[1] = new a(4, 15);
    arrayOfb7[2] = new b(18, arrayOfa27);
    a[] arrayOfa28 = new a[2];
    arrayOfa28[0] = new a(4, 13);
    arrayOfa28[1] = new a(1, 14);
    arrayOfb7[3] = new b(26, arrayOfa28);
    arrayOfj[6] = new j(7, arrayOfInt7, arrayOfb7);
    int[] arrayOfInt8 = { 6, 24, 42 };
    b[] arrayOfb8 = new b[4];
    a[] arrayOfa29 = new a[1];
    arrayOfa29[0] = new a(2, 97);
    arrayOfb8[0] = new b(24, arrayOfa29);
    a[] arrayOfa30 = new a[2];
    arrayOfa30[0] = new a(2, 38);
    arrayOfa30[1] = new a(2, 39);
    arrayOfb8[1] = new b(22, arrayOfa30);
    a[] arrayOfa31 = new a[2];
    arrayOfa31[0] = new a(4, 18);
    arrayOfa31[1] = new a(2, 19);
    arrayOfb8[2] = new b(22, arrayOfa31);
    a[] arrayOfa32 = new a[2];
    arrayOfa32[0] = new a(4, 14);
    arrayOfa32[1] = new a(2, 15);
    arrayOfb8[3] = new b(26, arrayOfa32);
    arrayOfj[7] = new j(8, arrayOfInt8, arrayOfb8);
    int[] arrayOfInt9 = { 6, 26, 46 };
    b[] arrayOfb9 = new b[4];
    a[] arrayOfa33 = new a[1];
    arrayOfa33[0] = new a(2, 116);
    arrayOfb9[0] = new b(30, arrayOfa33);
    a[] arrayOfa34 = new a[2];
    arrayOfa34[0] = new a(3, 36);
    arrayOfa34[1] = new a(2, 37);
    arrayOfb9[1] = new b(22, arrayOfa34);
    a[] arrayOfa35 = new a[2];
    arrayOfa35[0] = new a(4, 16);
    arrayOfa35[1] = new a(4, 17);
    arrayOfb9[2] = new b(20, arrayOfa35);
    a[] arrayOfa36 = new a[2];
    arrayOfa36[0] = new a(4, 12);
    arrayOfa36[1] = new a(4, 13);
    arrayOfb9[3] = new b(24, arrayOfa36);
    arrayOfj[8] = new j(9, arrayOfInt9, arrayOfb9);
    int[] arrayOfInt10 = { 6, 28, 50 };
    b[] arrayOfb10 = new b[4];
    a[] arrayOfa37 = new a[2];
    arrayOfa37[0] = new a(2, 68);
    arrayOfa37[1] = new a(2, 69);
    arrayOfb10[0] = new b(18, arrayOfa37);
    a[] arrayOfa38 = new a[2];
    arrayOfa38[0] = new a(4, 43);
    arrayOfa38[1] = new a(1, 44);
    arrayOfb10[1] = new b(26, arrayOfa38);
    a[] arrayOfa39 = new a[2];
    arrayOfa39[0] = new a(6, 19);
    arrayOfa39[1] = new a(2, 20);
    arrayOfb10[2] = new b(24, arrayOfa39);
    a[] arrayOfa40 = new a[2];
    arrayOfa40[0] = new a(6, 15);
    arrayOfa40[1] = new a(2, 16);
    arrayOfb10[3] = new b(28, arrayOfa40);
    arrayOfj[9] = new j(10, arrayOfInt10, arrayOfb10);
    int[] arrayOfInt11 = { 6, 30, 54 };
    b[] arrayOfb11 = new b[4];
    a[] arrayOfa41 = new a[1];
    arrayOfa41[0] = new a(4, 81);
    arrayOfb11[0] = new b(20, arrayOfa41);
    a[] arrayOfa42 = new a[2];
    arrayOfa42[0] = new a(1, 50);
    arrayOfa42[1] = new a(4, 51);
    arrayOfb11[1] = new b(30, arrayOfa42);
    a[] arrayOfa43 = new a[2];
    arrayOfa43[0] = new a(4, 22);
    arrayOfa43[1] = new a(4, 23);
    arrayOfb11[2] = new b(28, arrayOfa43);
    a[] arrayOfa44 = new a[2];
    arrayOfa44[0] = new a(3, 12);
    arrayOfa44[1] = new a(8, 13);
    arrayOfb11[3] = new b(24, arrayOfa44);
    arrayOfj[10] = new j(11, arrayOfInt11, arrayOfb11);
    int[] arrayOfInt12 = { 6, 32, 58 };
    b[] arrayOfb12 = new b[4];
    a[] arrayOfa45 = new a[2];
    arrayOfa45[0] = new a(2, 92);
    arrayOfa45[1] = new a(2, 93);
    arrayOfb12[0] = new b(24, arrayOfa45);
    a[] arrayOfa46 = new a[2];
    arrayOfa46[0] = new a(6, 36);
    arrayOfa46[1] = new a(2, 37);
    arrayOfb12[1] = new b(22, arrayOfa46);
    a[] arrayOfa47 = new a[2];
    arrayOfa47[0] = new a(4, 20);
    arrayOfa47[1] = new a(6, 21);
    arrayOfb12[2] = new b(26, arrayOfa47);
    a[] arrayOfa48 = new a[2];
    arrayOfa48[0] = new a(7, 14);
    arrayOfa48[1] = new a(4, 15);
    arrayOfb12[3] = new b(28, arrayOfa48);
    arrayOfj[11] = new j(12, arrayOfInt12, arrayOfb12);
    int[] arrayOfInt13 = { 6, 34, 62 };
    b[] arrayOfb13 = new b[4];
    a[] arrayOfa49 = new a[1];
    arrayOfa49[0] = new a(4, 107);
    arrayOfb13[0] = new b(26, arrayOfa49);
    a[] arrayOfa50 = new a[2];
    arrayOfa50[0] = new a(8, 37);
    arrayOfa50[1] = new a(1, 38);
    arrayOfb13[1] = new b(22, arrayOfa50);
    a[] arrayOfa51 = new a[2];
    arrayOfa51[0] = new a(8, 20);
    arrayOfa51[1] = new a(4, 21);
    arrayOfb13[2] = new b(24, arrayOfa51);
    a[] arrayOfa52 = new a[2];
    arrayOfa52[0] = new a(12, 11);
    arrayOfa52[1] = new a(4, 12);
    arrayOfb13[3] = new b(22, arrayOfa52);
    arrayOfj[12] = new j(13, arrayOfInt13, arrayOfb13);
    int[] arrayOfInt14 = { 6, 26, 46, 66 };
    b[] arrayOfb14 = new b[4];
    a[] arrayOfa53 = new a[2];
    arrayOfa53[0] = new a(3, 115);
    arrayOfa53[1] = new a(1, 116);
    arrayOfb14[0] = new b(30, arrayOfa53);
    a[] arrayOfa54 = new a[2];
    arrayOfa54[0] = new a(4, 40);
    arrayOfa54[1] = new a(5, 41);
    arrayOfb14[1] = new b(24, arrayOfa54);
    a[] arrayOfa55 = new a[2];
    arrayOfa55[0] = new a(11, 16);
    arrayOfa55[1] = new a(5, 17);
    arrayOfb14[2] = new b(20, arrayOfa55);
    a[] arrayOfa56 = new a[2];
    arrayOfa56[0] = new a(11, 12);
    arrayOfa56[1] = new a(5, 13);
    arrayOfb14[3] = new b(24, arrayOfa56);
    arrayOfj[13] = new j(14, arrayOfInt14, arrayOfb14);
    int[] arrayOfInt15 = { 6, 26, 48, 70 };
    b[] arrayOfb15 = new b[4];
    a[] arrayOfa57 = new a[2];
    arrayOfa57[0] = new a(5, 87);
    arrayOfa57[1] = new a(1, 88);
    arrayOfb15[0] = new b(22, arrayOfa57);
    a[] arrayOfa58 = new a[2];
    arrayOfa58[0] = new a(5, 41);
    arrayOfa58[1] = new a(5, 42);
    arrayOfb15[1] = new b(24, arrayOfa58);
    a[] arrayOfa59 = new a[2];
    arrayOfa59[0] = new a(5, 24);
    arrayOfa59[1] = new a(7, 25);
    arrayOfb15[2] = new b(30, arrayOfa59);
    a[] arrayOfa60 = new a[2];
    arrayOfa60[0] = new a(11, 12);
    arrayOfa60[1] = new a(7, 13);
    arrayOfb15[3] = new b(24, arrayOfa60);
    arrayOfj[14] = new j(15, arrayOfInt15, arrayOfb15);
    int[] arrayOfInt16 = { 6, 26, 50, 74 };
    b[] arrayOfb16 = new b[4];
    a[] arrayOfa61 = new a[2];
    arrayOfa61[0] = new a(5, 98);
    arrayOfa61[1] = new a(1, 99);
    arrayOfb16[0] = new b(24, arrayOfa61);
    a[] arrayOfa62 = new a[2];
    arrayOfa62[0] = new a(7, 45);
    arrayOfa62[1] = new a(3, 46);
    arrayOfb16[1] = new b(28, arrayOfa62);
    a[] arrayOfa63 = new a[2];
    arrayOfa63[0] = new a(15, 19);
    arrayOfa63[1] = new a(2, 20);
    arrayOfb16[2] = new b(24, arrayOfa63);
    a[] arrayOfa64 = new a[2];
    arrayOfa64[0] = new a(3, 15);
    arrayOfa64[1] = new a(13, 16);
    arrayOfb16[3] = new b(30, arrayOfa64);
    arrayOfj[15] = new j(16, arrayOfInt16, arrayOfb16);
    int[] arrayOfInt17 = { 6, 30, 54, 78 };
    b[] arrayOfb17 = new b[4];
    a[] arrayOfa65 = new a[2];
    arrayOfa65[0] = new a(1, 107);
    arrayOfa65[1] = new a(5, 108);
    arrayOfb17[0] = new b(28, arrayOfa65);
    a[] arrayOfa66 = new a[2];
    arrayOfa66[0] = new a(10, 46);
    arrayOfa66[1] = new a(1, 47);
    arrayOfb17[1] = new b(28, arrayOfa66);
    a[] arrayOfa67 = new a[2];
    arrayOfa67[0] = new a(1, 22);
    arrayOfa67[1] = new a(15, 23);
    arrayOfb17[2] = new b(28, arrayOfa67);
    a[] arrayOfa68 = new a[2];
    arrayOfa68[0] = new a(2, 14);
    arrayOfa68[1] = new a(17, 15);
    arrayOfb17[3] = new b(28, arrayOfa68);
    arrayOfj[16] = new j(17, arrayOfInt17, arrayOfb17);
    int[] arrayOfInt18 = { 6, 30, 56, 82 };
    b[] arrayOfb18 = new b[4];
    a[] arrayOfa69 = new a[2];
    arrayOfa69[0] = new a(5, 120);
    arrayOfa69[1] = new a(1, 121);
    arrayOfb18[0] = new b(30, arrayOfa69);
    a[] arrayOfa70 = new a[2];
    arrayOfa70[0] = new a(9, 43);
    arrayOfa70[1] = new a(4, 44);
    arrayOfb18[1] = new b(26, arrayOfa70);
    a[] arrayOfa71 = new a[2];
    arrayOfa71[0] = new a(17, 22);
    arrayOfa71[1] = new a(1, 23);
    arrayOfb18[2] = new b(28, arrayOfa71);
    a[] arrayOfa72 = new a[2];
    arrayOfa72[0] = new a(2, 14);
    arrayOfa72[1] = new a(19, 15);
    arrayOfb18[3] = new b(28, arrayOfa72);
    arrayOfj[17] = new j(18, arrayOfInt18, arrayOfb18);
    int[] arrayOfInt19 = { 6, 30, 58, 86 };
    b[] arrayOfb19 = new b[4];
    a[] arrayOfa73 = new a[2];
    arrayOfa73[0] = new a(3, 113);
    arrayOfa73[1] = new a(4, 114);
    arrayOfb19[0] = new b(28, arrayOfa73);
    a[] arrayOfa74 = new a[2];
    arrayOfa74[0] = new a(3, 44);
    arrayOfa74[1] = new a(11, 45);
    arrayOfb19[1] = new b(26, arrayOfa74);
    a[] arrayOfa75 = new a[2];
    arrayOfa75[0] = new a(17, 21);
    arrayOfa75[1] = new a(4, 22);
    arrayOfb19[2] = new b(26, arrayOfa75);
    a[] arrayOfa76 = new a[2];
    arrayOfa76[0] = new a(9, 13);
    arrayOfa76[1] = new a(16, 14);
    arrayOfb19[3] = new b(26, arrayOfa76);
    arrayOfj[18] = new j(19, arrayOfInt19, arrayOfb19);
    int[] arrayOfInt20 = { 6, 34, 62, 90 };
    b[] arrayOfb20 = new b[4];
    a[] arrayOfa77 = new a[2];
    arrayOfa77[0] = new a(3, 107);
    arrayOfa77[1] = new a(5, 108);
    arrayOfb20[0] = new b(28, arrayOfa77);
    a[] arrayOfa78 = new a[2];
    arrayOfa78[0] = new a(3, 41);
    arrayOfa78[1] = new a(13, 42);
    arrayOfb20[1] = new b(26, arrayOfa78);
    a[] arrayOfa79 = new a[2];
    arrayOfa79[0] = new a(15, 24);
    arrayOfa79[1] = new a(5, 25);
    arrayOfb20[2] = new b(30, arrayOfa79);
    a[] arrayOfa80 = new a[2];
    arrayOfa80[0] = new a(15, 15);
    arrayOfa80[1] = new a(10, 16);
    arrayOfb20[3] = new b(28, arrayOfa80);
    arrayOfj[19] = new j(20, arrayOfInt20, arrayOfb20);
    int[] arrayOfInt21 = { 6, 28, 50, 72, 94 };
    b[] arrayOfb21 = new b[4];
    a[] arrayOfa81 = new a[2];
    arrayOfa81[0] = new a(4, 116);
    arrayOfa81[1] = new a(4, 117);
    arrayOfb21[0] = new b(28, arrayOfa81);
    a[] arrayOfa82 = new a[1];
    arrayOfa82[0] = new a(17, 42);
    arrayOfb21[1] = new b(26, arrayOfa82);
    a[] arrayOfa83 = new a[2];
    arrayOfa83[0] = new a(17, 22);
    arrayOfa83[1] = new a(6, 23);
    arrayOfb21[2] = new b(28, arrayOfa83);
    a[] arrayOfa84 = new a[2];
    arrayOfa84[0] = new a(19, 16);
    arrayOfa84[1] = new a(6, 17);
    arrayOfb21[3] = new b(30, arrayOfa84);
    arrayOfj[20] = new j(21, arrayOfInt21, arrayOfb21);
    int[] arrayOfInt22 = { 6, 26, 50, 74, 98 };
    b[] arrayOfb22 = new b[4];
    a[] arrayOfa85 = new a[2];
    arrayOfa85[0] = new a(2, 111);
    arrayOfa85[1] = new a(7, 112);
    arrayOfb22[0] = new b(28, arrayOfa85);
    a[] arrayOfa86 = new a[1];
    arrayOfa86[0] = new a(17, 46);
    arrayOfb22[1] = new b(28, arrayOfa86);
    a[] arrayOfa87 = new a[2];
    arrayOfa87[0] = new a(7, 24);
    arrayOfa87[1] = new a(16, 25);
    arrayOfb22[2] = new b(30, arrayOfa87);
    a[] arrayOfa88 = new a[1];
    arrayOfa88[0] = new a(34, 13);
    arrayOfb22[3] = new b(24, arrayOfa88);
    arrayOfj[21] = new j(22, arrayOfInt22, arrayOfb22);
    int[] arrayOfInt23 = { 6, 30, 54, 78, 102 };
    b[] arrayOfb23 = new b[4];
    a[] arrayOfa89 = new a[2];
    arrayOfa89[0] = new a(4, 121);
    arrayOfa89[1] = new a(5, 122);
    arrayOfb23[0] = new b(30, arrayOfa89);
    a[] arrayOfa90 = new a[2];
    arrayOfa90[0] = new a(4, 47);
    arrayOfa90[1] = new a(14, 48);
    arrayOfb23[1] = new b(28, arrayOfa90);
    a[] arrayOfa91 = new a[2];
    arrayOfa91[0] = new a(11, 24);
    arrayOfa91[1] = new a(14, 25);
    arrayOfb23[2] = new b(30, arrayOfa91);
    a[] arrayOfa92 = new a[2];
    arrayOfa92[0] = new a(16, 15);
    arrayOfa92[1] = new a(14, 16);
    arrayOfb23[3] = new b(30, arrayOfa92);
    arrayOfj[22] = new j(23, arrayOfInt23, arrayOfb23);
    int[] arrayOfInt24 = { 6, 28, 54, 80, 106 };
    b[] arrayOfb24 = new b[4];
    a[] arrayOfa93 = new a[2];
    arrayOfa93[0] = new a(6, 117);
    arrayOfa93[1] = new a(4, 118);
    arrayOfb24[0] = new b(30, arrayOfa93);
    a[] arrayOfa94 = new a[2];
    arrayOfa94[0] = new a(6, 45);
    arrayOfa94[1] = new a(14, 46);
    arrayOfb24[1] = new b(28, arrayOfa94);
    a[] arrayOfa95 = new a[2];
    arrayOfa95[0] = new a(11, 24);
    arrayOfa95[1] = new a(16, 25);
    arrayOfb24[2] = new b(30, arrayOfa95);
    a[] arrayOfa96 = new a[2];
    arrayOfa96[0] = new a(30, 16);
    arrayOfa96[1] = new a(2, 17);
    arrayOfb24[3] = new b(30, arrayOfa96);
    arrayOfj[23] = new j(24, arrayOfInt24, arrayOfb24);
    int[] arrayOfInt25 = { 6, 32, 58, 84, 110 };
    b[] arrayOfb25 = new b[4];
    a[] arrayOfa97 = new a[2];
    arrayOfa97[0] = new a(8, 106);
    arrayOfa97[1] = new a(4, 107);
    arrayOfb25[0] = new b(26, arrayOfa97);
    a[] arrayOfa98 = new a[2];
    arrayOfa98[0] = new a(8, 47);
    arrayOfa98[1] = new a(13, 48);
    arrayOfb25[1] = new b(28, arrayOfa98);
    a[] arrayOfa99 = new a[2];
    arrayOfa99[0] = new a(7, 24);
    arrayOfa99[1] = new a(22, 25);
    arrayOfb25[2] = new b(30, arrayOfa99);
    a[] arrayOfa100 = new a[2];
    arrayOfa100[0] = new a(22, 15);
    arrayOfa100[1] = new a(13, 16);
    arrayOfb25[3] = new b(30, arrayOfa100);
    arrayOfj[24] = new j(25, arrayOfInt25, arrayOfb25);
    int[] arrayOfInt26 = { 6, 30, 58, 86, 114 };
    b[] arrayOfb26 = new b[4];
    a[] arrayOfa101 = new a[2];
    arrayOfa101[0] = new a(10, 114);
    arrayOfa101[1] = new a(2, 115);
    arrayOfb26[0] = new b(28, arrayOfa101);
    a[] arrayOfa102 = new a[2];
    arrayOfa102[0] = new a(19, 46);
    arrayOfa102[1] = new a(4, 47);
    arrayOfb26[1] = new b(28, arrayOfa102);
    a[] arrayOfa103 = new a[2];
    arrayOfa103[0] = new a(28, 22);
    arrayOfa103[1] = new a(6, 23);
    arrayOfb26[2] = new b(28, arrayOfa103);
    a[] arrayOfa104 = new a[2];
    arrayOfa104[0] = new a(33, 16);
    arrayOfa104[1] = new a(4, 17);
    arrayOfb26[3] = new b(30, arrayOfa104);
    arrayOfj[25] = new j(26, arrayOfInt26, arrayOfb26);
    int[] arrayOfInt27 = { 6, 34, 62, 90, 118 };
    b[] arrayOfb27 = new b[4];
    a[] arrayOfa105 = new a[2];
    arrayOfa105[0] = new a(8, 122);
    arrayOfa105[1] = new a(4, 123);
    arrayOfb27[0] = new b(30, arrayOfa105);
    a[] arrayOfa106 = new a[2];
    arrayOfa106[0] = new a(22, 45);
    arrayOfa106[1] = new a(3, 46);
    arrayOfb27[1] = new b(28, arrayOfa106);
    a[] arrayOfa107 = new a[2];
    arrayOfa107[0] = new a(8, 23);
    arrayOfa107[1] = new a(26, 24);
    arrayOfb27[2] = new b(30, arrayOfa107);
    a[] arrayOfa108 = new a[2];
    arrayOfa108[0] = new a(12, 15);
    arrayOfa108[1] = new a(28, 16);
    arrayOfb27[3] = new b(30, arrayOfa108);
    arrayOfj[26] = new j(27, arrayOfInt27, arrayOfb27);
    int[] arrayOfInt28 = { 6, 26, 50, 74, 98, 122 };
    b[] arrayOfb28 = new b[4];
    a[] arrayOfa109 = new a[2];
    arrayOfa109[0] = new a(3, 117);
    arrayOfa109[1] = new a(10, 118);
    arrayOfb28[0] = new b(30, arrayOfa109);
    a[] arrayOfa110 = new a[2];
    arrayOfa110[0] = new a(3, 45);
    arrayOfa110[1] = new a(23, 46);
    arrayOfb28[1] = new b(28, arrayOfa110);
    a[] arrayOfa111 = new a[2];
    arrayOfa111[0] = new a(4, 24);
    arrayOfa111[1] = new a(31, 25);
    arrayOfb28[2] = new b(30, arrayOfa111);
    a[] arrayOfa112 = new a[2];
    arrayOfa112[0] = new a(11, 15);
    arrayOfa112[1] = new a(31, 16);
    arrayOfb28[3] = new b(30, arrayOfa112);
    arrayOfj[27] = new j(28, arrayOfInt28, arrayOfb28);
    int[] arrayOfInt29 = { 6, 30, 54, 78, 102, 126 };
    b[] arrayOfb29 = new b[4];
    a[] arrayOfa113 = new a[2];
    arrayOfa113[0] = new a(7, 116);
    arrayOfa113[1] = new a(7, 117);
    arrayOfb29[0] = new b(30, arrayOfa113);
    a[] arrayOfa114 = new a[2];
    arrayOfa114[0] = new a(21, 45);
    arrayOfa114[1] = new a(7, 46);
    arrayOfb29[1] = new b(28, arrayOfa114);
    a[] arrayOfa115 = new a[2];
    arrayOfa115[0] = new a(1, 23);
    arrayOfa115[1] = new a(37, 24);
    arrayOfb29[2] = new b(30, arrayOfa115);
    a[] arrayOfa116 = new a[2];
    arrayOfa116[0] = new a(19, 15);
    arrayOfa116[1] = new a(26, 16);
    arrayOfb29[3] = new b(30, arrayOfa116);
    arrayOfj[28] = new j(29, arrayOfInt29, arrayOfb29);
    int[] arrayOfInt30 = { 6, 26, 52, 78, 104, 130 };
    b[] arrayOfb30 = new b[4];
    a[] arrayOfa117 = new a[2];
    arrayOfa117[0] = new a(5, 115);
    arrayOfa117[1] = new a(10, 116);
    arrayOfb30[0] = new b(30, arrayOfa117);
    a[] arrayOfa118 = new a[2];
    arrayOfa118[0] = new a(19, 47);
    arrayOfa118[1] = new a(10, 48);
    arrayOfb30[1] = new b(28, arrayOfa118);
    a[] arrayOfa119 = new a[2];
    arrayOfa119[0] = new a(15, 24);
    arrayOfa119[1] = new a(25, 25);
    arrayOfb30[2] = new b(30, arrayOfa119);
    a[] arrayOfa120 = new a[2];
    arrayOfa120[0] = new a(23, 15);
    arrayOfa120[1] = new a(25, 16);
    arrayOfb30[3] = new b(30, arrayOfa120);
    arrayOfj[29] = new j(30, arrayOfInt30, arrayOfb30);
    int[] arrayOfInt31 = { 6, 30, 56, 82, 108, 134 };
    b[] arrayOfb31 = new b[4];
    a[] arrayOfa121 = new a[2];
    arrayOfa121[0] = new a(13, 115);
    arrayOfa121[1] = new a(3, 116);
    arrayOfb31[0] = new b(30, arrayOfa121);
    a[] arrayOfa122 = new a[2];
    arrayOfa122[0] = new a(2, 46);
    arrayOfa122[1] = new a(29, 47);
    arrayOfb31[1] = new b(28, arrayOfa122);
    a[] arrayOfa123 = new a[2];
    arrayOfa123[0] = new a(42, 24);
    arrayOfa123[1] = new a(1, 25);
    arrayOfb31[2] = new b(30, arrayOfa123);
    a[] arrayOfa124 = new a[2];
    arrayOfa124[0] = new a(23, 15);
    arrayOfa124[1] = new a(28, 16);
    arrayOfb31[3] = new b(30, arrayOfa124);
    arrayOfj[30] = new j(31, arrayOfInt31, arrayOfb31);
    int[] arrayOfInt32 = { 6, 34, 60, 86, 112, 138 };
    b[] arrayOfb32 = new b[4];
    a[] arrayOfa125 = new a[1];
    arrayOfa125[0] = new a(17, 115);
    arrayOfb32[0] = new b(30, arrayOfa125);
    a[] arrayOfa126 = new a[2];
    arrayOfa126[0] = new a(10, 46);
    arrayOfa126[1] = new a(23, 47);
    arrayOfb32[1] = new b(28, arrayOfa126);
    a[] arrayOfa127 = new a[2];
    arrayOfa127[0] = new a(10, 24);
    arrayOfa127[1] = new a(35, 25);
    arrayOfb32[2] = new b(30, arrayOfa127);
    a[] arrayOfa128 = new a[2];
    arrayOfa128[0] = new a(19, 15);
    arrayOfa128[1] = new a(35, 16);
    arrayOfb32[3] = new b(30, arrayOfa128);
    arrayOfj[31] = new j(32, arrayOfInt32, arrayOfb32);
    int[] arrayOfInt33 = { 6, 30, 58, 86, 114, 142 };
    b[] arrayOfb33 = new b[4];
    a[] arrayOfa129 = new a[2];
    arrayOfa129[0] = new a(17, 115);
    arrayOfa129[1] = new a(1, 116);
    arrayOfb33[0] = new b(30, arrayOfa129);
    a[] arrayOfa130 = new a[2];
    arrayOfa130[0] = new a(14, 46);
    arrayOfa130[1] = new a(21, 47);
    arrayOfb33[1] = new b(28, arrayOfa130);
    a[] arrayOfa131 = new a[2];
    arrayOfa131[0] = new a(29, 24);
    arrayOfa131[1] = new a(19, 25);
    arrayOfb33[2] = new b(30, arrayOfa131);
    a[] arrayOfa132 = new a[2];
    arrayOfa132[0] = new a(11, 15);
    arrayOfa132[1] = new a(46, 16);
    arrayOfb33[3] = new b(30, arrayOfa132);
    arrayOfj[32] = new j(33, arrayOfInt33, arrayOfb33);
    int[] arrayOfInt34 = { 6, 34, 62, 90, 118, 146 };
    b[] arrayOfb34 = new b[4];
    a[] arrayOfa133 = new a[2];
    arrayOfa133[0] = new a(13, 115);
    arrayOfa133[1] = new a(6, 116);
    arrayOfb34[0] = new b(30, arrayOfa133);
    a[] arrayOfa134 = new a[2];
    arrayOfa134[0] = new a(14, 46);
    arrayOfa134[1] = new a(23, 47);
    arrayOfb34[1] = new b(28, arrayOfa134);
    a[] arrayOfa135 = new a[2];
    arrayOfa135[0] = new a(44, 24);
    arrayOfa135[1] = new a(7, 25);
    arrayOfb34[2] = new b(30, arrayOfa135);
    a[] arrayOfa136 = new a[2];
    arrayOfa136[0] = new a(59, 16);
    arrayOfa136[1] = new a(1, 17);
    arrayOfb34[3] = new b(30, arrayOfa136);
    arrayOfj[33] = new j(34, arrayOfInt34, arrayOfb34);
    int[] arrayOfInt35 = { 6, 30, 54, 78, 102, 126, 150 };
    b[] arrayOfb35 = new b[4];
    a[] arrayOfa137 = new a[2];
    arrayOfa137[0] = new a(12, 121);
    arrayOfa137[1] = new a(7, 122);
    arrayOfb35[0] = new b(30, arrayOfa137);
    a[] arrayOfa138 = new a[2];
    arrayOfa138[0] = new a(12, 47);
    arrayOfa138[1] = new a(26, 48);
    arrayOfb35[1] = new b(28, arrayOfa138);
    a[] arrayOfa139 = new a[2];
    arrayOfa139[0] = new a(39, 24);
    arrayOfa139[1] = new a(14, 25);
    arrayOfb35[2] = new b(30, arrayOfa139);
    a[] arrayOfa140 = new a[2];
    arrayOfa140[0] = new a(22, 15);
    arrayOfa140[1] = new a(41, 16);
    arrayOfb35[3] = new b(30, arrayOfa140);
    arrayOfj[34] = new j(35, arrayOfInt35, arrayOfb35);
    int[] arrayOfInt36 = { 6, 24, 50, 76, 102, 128, 154 };
    b[] arrayOfb36 = new b[4];
    a[] arrayOfa141 = new a[2];
    arrayOfa141[0] = new a(6, 121);
    arrayOfa141[1] = new a(14, 122);
    arrayOfb36[0] = new b(30, arrayOfa141);
    a[] arrayOfa142 = new a[2];
    arrayOfa142[0] = new a(6, 47);
    arrayOfa142[1] = new a(34, 48);
    arrayOfb36[1] = new b(28, arrayOfa142);
    a[] arrayOfa143 = new a[2];
    arrayOfa143[0] = new a(46, 24);
    arrayOfa143[1] = new a(10, 25);
    arrayOfb36[2] = new b(30, arrayOfa143);
    a[] arrayOfa144 = new a[2];
    arrayOfa144[0] = new a(2, 15);
    arrayOfa144[1] = new a(64, 16);
    arrayOfb36[3] = new b(30, arrayOfa144);
    arrayOfj[35] = new j(36, arrayOfInt36, arrayOfb36);
    int[] arrayOfInt37 = { 6, 28, 54, 80, 106, 132, 158 };
    b[] arrayOfb37 = new b[4];
    a[] arrayOfa145 = new a[2];
    arrayOfa145[0] = new a(17, 122);
    arrayOfa145[1] = new a(4, 123);
    arrayOfb37[0] = new b(30, arrayOfa145);
    a[] arrayOfa146 = new a[2];
    arrayOfa146[0] = new a(29, 46);
    arrayOfa146[1] = new a(14, 47);
    arrayOfb37[1] = new b(28, arrayOfa146);
    a[] arrayOfa147 = new a[2];
    arrayOfa147[0] = new a(49, 24);
    arrayOfa147[1] = new a(10, 25);
    arrayOfb37[2] = new b(30, arrayOfa147);
    a[] arrayOfa148 = new a[2];
    arrayOfa148[0] = new a(24, 15);
    arrayOfa148[1] = new a(46, 16);
    arrayOfb37[3] = new b(30, arrayOfa148);
    arrayOfj[36] = new j(37, arrayOfInt37, arrayOfb37);
    int[] arrayOfInt38 = { 6, 32, 58, 84, 110, 136, 162 };
    b[] arrayOfb38 = new b[4];
    a[] arrayOfa149 = new a[2];
    arrayOfa149[0] = new a(4, 122);
    arrayOfa149[1] = new a(18, 123);
    arrayOfb38[0] = new b(30, arrayOfa149);
    a[] arrayOfa150 = new a[2];
    arrayOfa150[0] = new a(13, 46);
    arrayOfa150[1] = new a(32, 47);
    arrayOfb38[1] = new b(28, arrayOfa150);
    a[] arrayOfa151 = new a[2];
    arrayOfa151[0] = new a(48, 24);
    arrayOfa151[1] = new a(14, 25);
    arrayOfb38[2] = new b(30, arrayOfa151);
    a[] arrayOfa152 = new a[2];
    arrayOfa152[0] = new a(42, 15);
    arrayOfa152[1] = new a(32, 16);
    arrayOfb38[3] = new b(30, arrayOfa152);
    arrayOfj[37] = new j(38, arrayOfInt38, arrayOfb38);
    int[] arrayOfInt39 = { 6, 26, 54, 82, 110, 138, 166 };
    b[] arrayOfb39 = new b[4];
    a[] arrayOfa153 = new a[2];
    arrayOfa153[0] = new a(20, 117);
    arrayOfa153[1] = new a(4, 118);
    arrayOfb39[0] = new b(30, arrayOfa153);
    a[] arrayOfa154 = new a[2];
    arrayOfa154[0] = new a(40, 47);
    arrayOfa154[1] = new a(7, 48);
    arrayOfb39[1] = new b(28, arrayOfa154);
    a[] arrayOfa155 = new a[2];
    arrayOfa155[0] = new a(43, 24);
    arrayOfa155[1] = new a(22, 25);
    arrayOfb39[2] = new b(30, arrayOfa155);
    a[] arrayOfa156 = new a[2];
    arrayOfa156[0] = new a(10, 15);
    arrayOfa156[1] = new a(67, 16);
    arrayOfb39[3] = new b(30, arrayOfa156);
    arrayOfj[38] = new j(39, arrayOfInt39, arrayOfb39);
    int[] arrayOfInt40 = { 6, 30, 58, 86, 114, 142, 170 };
    b[] arrayOfb40 = new b[4];
    a[] arrayOfa157 = new a[2];
    arrayOfa157[0] = new a(19, 118);
    arrayOfa157[1] = new a(6, 119);
    arrayOfb40[0] = new b(30, arrayOfa157);
    a[] arrayOfa158 = new a[2];
    arrayOfa158[0] = new a(18, 47);
    arrayOfa158[1] = new a(31, 48);
    arrayOfb40[1] = new b(28, arrayOfa158);
    a[] arrayOfa159 = new a[2];
    arrayOfa159[0] = new a(34, 24);
    arrayOfa159[1] = new a(34, 25);
    arrayOfb40[2] = new b(30, arrayOfa159);
    a[] arrayOfa160 = new a[2];
    arrayOfa160[0] = new a(20, 15);
    arrayOfa160[1] = new a(61, 16);
    arrayOfb40[3] = new b(30, arrayOfa160);
    arrayOfj[39] = new j(40, arrayOfInt40, arrayOfb40);
    return arrayOfj;
  }

  public int a()
  {
    return this.c;
  }

  public b a(f paramf)
  {
    return this.e[paramf.ordinal()];
  }

  public int[] b()
  {
    return this.d;
  }

  public int c()
  {
    return this.f;
  }

  public int d()
  {
    return 17 + 4 * this.c;
  }

  b e()
  {
    int i = d();
    b localb = new b(i);
    localb.a(0, 0, 9, 9);
    localb.a(i - 8, 0, 8, 9);
    localb.a(0, i - 8, 9, 8);
    int j = this.d.length;
    for (int k = 0; k < j; k++)
    {
      int m = -2 + this.d[k];
      int n = 0;
      if (n < j)
      {
        if (((k == 0) && ((n == 0) || (n == j - 1))) || ((k == j - 1) && (n == 0)));
        while (true)
        {
          n++;
          break;
          localb.a(-2 + this.d[n], m, 5, 5);
        }
      }
    }
    localb.a(6, 9, 1, i - 17);
    localb.a(9, 6, i - 17, 1);
    if (this.c > 6)
    {
      localb.a(i - 11, 0, 3, 6);
      localb.a(0, i - 11, 6, 3);
    }
    return localb;
  }

  public String toString()
  {
    return String.valueOf(this.c);
  }

  public static final class a
  {
    private final int a;
    private final int b;

    a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }

    public int a()
    {
      return this.a;
    }

    public int b()
    {
      return this.b;
    }
  }

  public static final class b
  {
    private final int a;
    private final j.a[] b;

    b(int paramInt, j.a[] paramArrayOfa)
    {
      this.a = paramInt;
      this.b = paramArrayOfa;
    }

    public int a()
    {
      return this.a;
    }

    public int b()
    {
      int i = 0;
      j.a[] arrayOfa = this.b;
      int j = arrayOfa.length;
      int k = 0;
      while (i < j)
      {
        k += arrayOfa[i].a();
        i++;
      }
      return k;
    }

    public int c()
    {
      return this.a * b();
    }

    public j.a[] d()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.h.a.j
 * JD-Core Version:    0.6.2
 */