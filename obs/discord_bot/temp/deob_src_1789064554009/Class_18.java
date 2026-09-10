import java.io.IOException;

final class Class_18 {
   // $VF: renamed from: pgz float[]
   private float[] field_1431;
   // $VF: renamed from: rxd float[]
   private float[] field_1432;
   // $VF: renamed from: fix float[]
   private float[] field_1433;
   // $VF: renamed from: uyu int
   private int field_1434;
   // $VF: renamed from: dh float[]
   private float[] field_1435;
   // $VF: renamed from: xhq int
   private int field_1436;
   // $VF: renamed from: vsi float
   private float field_1437;
   // $VF: renamed from: lod float[]
   private float[] field_1438;
   // $VF: renamed from: fpr float[]
   private float[] field_1439 = new float[32];
   // $VF: renamed from: ok double
   private static final double field_1440 = Math.PI;
   // $VF: renamed from: qdf float
   private static final float field_1441 = (float)(1.0 / (2.0 * Math.cos(0.04908738521234052)));
   // $VF: renamed from: fuc float
   private static final float field_1442 = (float)(1.0 / (2.0 * Math.cos(0.14726215563702155)));
   // $VF: renamed from: szb float
   private static final float field_1443 = (float)(1.0 / (2.0 * Math.cos(0.2454369260617026)));
   // $VF: renamed from: xpf float
   private static final float field_1444 = (float)(1.0 / (2.0 * Math.cos(0.3436116964863836)));
   // $VF: renamed from: uec float
   private static final float field_1445 = (float)(1.0 / (2.0 * Math.cos(0.44178646691106466)));
   // $VF: renamed from: hsx float
   private static final float field_1446 = (float)(1.0 / (2.0 * Math.cos(0.5399612373357456)));
   // $VF: renamed from: laa float
   private static final float field_1447 = (float)(1.0 / (2.0 * Math.cos(0.6381360077604268)));
   // $VF: renamed from: pog float
   private static final float field_1448 = (float)(1.0 / (2.0 * Math.cos(0.7363107781851077)));
   // $VF: renamed from: qcd float
   private static final float field_1449 = (float)(1.0 / (2.0 * Math.cos(0.8344855486097889)));
   // $VF: renamed from: iql float
   private static final float field_1450 = (float)(1.0 / (2.0 * Math.cos(0.9326603190344698)));
   // $VF: renamed from: qvf float
   private static final float field_1451 = (float)(1.0 / (2.0 * Math.cos(1.030835089459151)));
   // $VF: renamed from: rrm float
   private static final float field_1452 = (float)(1.0 / (2.0 * Math.cos(1.1290098598838318)));
   // $VF: renamed from: hxb float
   private static final float field_1453 = (float)(1.0 / (2.0 * Math.cos(1.227184630308513)));
   // $VF: renamed from: nus float
   private static final float field_1454 = (float)(1.0 / (2.0 * Math.cos(1.325359400733194)));
   // $VF: renamed from: ye float
   private static final float field_1455 = (float)(1.0 / (2.0 * Math.cos(1.423534171157875)));
   // $VF: renamed from: lwl float
   private static final float field_1456 = (float)(1.0 / (2.0 * Math.cos(1.521708941582556)));
   // $VF: renamed from: khv float
   private static final float field_1457 = (float)(1.0 / (2.0 * Math.cos(0.09817477042468103)));
   // $VF: renamed from: ab float
   private static final float field_1458 = (float)(1.0 / (2.0 * Math.cos(0.2945243112740431)));
   // $VF: renamed from: bxd float
   private static final float field_1459 = (float)(1.0 / (2.0 * Math.cos(0.4908738521234052)));
   // $VF: renamed from: erf float
   private static final float field_1460 = (float)(1.0 / (2.0 * Math.cos(0.6872233929727672)));
   // $VF: renamed from: rjw float
   private static final float field_1461 = (float)(1.0 / (2.0 * Math.cos(0.8835729338221293)));
   // $VF: renamed from: tju float
   private static final float field_1462 = (float)(1.0 / (2.0 * Math.cos(1.0799224746714913)));
   // $VF: renamed from: zgq float
   private static final float field_1463 = (float)(1.0 / (2.0 * Math.cos(1.2762720155208536)));
   // $VF: renamed from: tfl float
   private static final float field_1464 = (float)(1.0 / (2.0 * Math.cos(1.4726215563702154)));
   // $VF: renamed from: lrq float
   private static final float field_1465 = (float)(1.0 / (2.0 * Math.cos(Math.PI / 16)));
   // $VF: renamed from: tbd float
   private static final float field_1466 = (float)(1.0 / (2.0 * Math.cos(0.5890486225480862)));
   // $VF: renamed from: wzg float
   private static final float field_1467 = (float)(1.0 / (2.0 * Math.cos(0.9817477042468103)));
   // $VF: renamed from: vey float
   private static final float field_1468 = (float)(1.0 / (2.0 * Math.cos(1.3744467859455345)));
   private static final float ntvh = (float)(1.0 / (2.0 * Math.cos(Math.PI / 8)));
   // $VF: renamed from: ecf float
   private static final float field_1469 = (float)(1.0 / (2.0 * Math.cos(Math.PI * 3.0 / 8.0)));
   // $VF: renamed from: mwu float
   private static final float field_1470 = (float)(1.0 / (2.0 * Math.cos(Math.PI / 4)));
   // $VF: renamed from: paf float[]
   private static float[] field_1471 = null;
   // $VF: renamed from: atq float[][]
   private static float[][] field_1472 = (float[][])null;

   public Class_18(int channelnumber, float factor, float[] eq0) {
      if (field_1471 == null) {
         field_1471 = method_1362();
         field_1472 = method_1363(field_1471, 16);
      }

      this.field_1431 = new float[512];
      this.field_1432 = new float[512];
      this.field_1435 = new float[32];
      this.field_1436 = channelnumber;
      this.field_1437 = factor;
      this.method_1340(this.field_1438);
      this.method_1341();
   }

   // $VF: renamed from: mri (float[]) void
   public void method_1340(float[] eq0) {
      this.field_1438 = eq0;
      if (this.field_1438 == null) {
         this.field_1438 = new float[32];

         for (int i = 0; i < 32; i++) {
            this.field_1438[i] = 1.0F;
         }
      }

      if (this.field_1438.length < 32) {
         throw new IllegalArgumentException("eq0");
      }
   }

   // $VF: renamed from: ui () void
   public void method_1341() {
      for (int p = 0; p < 512; p++) {
         this.field_1431[p] = this.field_1432[p] = 0.0F;
      }

      for (int p2 = 0; p2 < 32; p2++) {
         this.field_1435[p2] = 0.0F;
      }

      this.field_1433 = this.field_1431;
      this.field_1434 = 15;
   }

   // $VF: renamed from: yu (float, int) void
   public void method_1342(float sample, int subbandnumber) {
      this.field_1435[subbandnumber] = this.field_1438[subbandnumber] * sample;
   }

   public void cfgj(float[] s) {
      for (int i = 31; i >= 0; i--) {
         this.field_1435[i] = s[i] * this.field_1438[i];
      }
   }

   // $VF: renamed from: vye () void
   private void method_1343() {
      float new_v31 = 0.0F;
      float new_v30 = 0.0F;
      float new_v29 = 0.0F;
      float new_v28 = 0.0F;
      float new_v27 = 0.0F;
      float new_v26 = 0.0F;
      float new_v25 = 0.0F;
      float new_v24 = 0.0F;
      float new_v23 = 0.0F;
      float new_v22 = 0.0F;
      float new_v21 = 0.0F;
      float new_v20 = 0.0F;
      float new_v19 = 0.0F;
      float new_v18 = 0.0F;
      float new_v17 = 0.0F;
      float new_v16 = 0.0F;
      float new_v15 = 0.0F;
      float new_v14 = 0.0F;
      float new_v13 = 0.0F;
      float new_v12 = 0.0F;
      float new_v11 = 0.0F;
      float new_v10 = 0.0F;
      float new_v9 = 0.0F;
      float new_v8 = 0.0F;
      float new_v7 = 0.0F;
      float new_v6 = 0.0F;
      float new_v5 = 0.0F;
      float new_v4 = 0.0F;
      float new_v3 = 0.0F;
      float new_v2 = 0.0F;
      float new_v1 = 0.0F;
      float new_v0 = 0.0F;
      float[] s = this.field_1435;
      float s0 = s[0];
      float s1 = s[1];
      float s2 = s[2];
      float s3 = s[3];
      float s4 = s[4];
      float s5 = s[5];
      float s6 = s[6];
      float s7 = s[7];
      float s8 = s[8];
      float s9 = s[9];
      float s10 = s[10];
      float s11 = s[11];
      float s12 = s[12];
      float s13 = s[13];
      float s14 = s[14];
      float s15 = s[15];
      float s16 = s[16];
      float s17 = s[17];
      float s18 = s[18];
      float s19 = s[19];
      float s20 = s[20];
      float s21 = s[21];
      float s22 = s[22];
      float s23 = s[23];
      float s24 = s[24];
      float s25 = s[25];
      float s26 = s[26];
      float s27 = s[27];
      float s28 = s[28];
      float s29 = s[29];
      float s30 = s[30];
      float s31 = s[31];
      float p0 = s0 + s31;
      float p1 = s1 + s30;
      float p2 = s2 + s29;
      float p3 = s3 + s28;
      float p4 = s4 + s27;
      float p5 = s5 + s26;
      float p6 = s6 + s25;
      float p7 = s7 + s24;
      float p8 = s8 + s23;
      float p9 = s9 + s22;
      float p10 = s10 + s21;
      float p11 = s11 + s20;
      float p12 = s12 + s19;
      float p13 = s13 + s18;
      float p14 = s14 + s17;
      float p15 = s15 + s16;
      float pp0 = p0 + p15;
      float pp1 = p1 + p14;
      float pp2 = p2 + p13;
      float pp3 = p3 + p12;
      float pp4 = p4 + p11;
      float pp5 = p5 + p10;
      float pp6 = p6 + p9;
      float pp7 = p7 + p8;
      float pp8 = (p0 - p15) * field_1457;
      float pp9 = (p1 - p14) * field_1458;
      float pp10 = (p2 - p13) * field_1459;
      float pp11 = (p3 - p12) * field_1460;
      float pp12 = (p4 - p11) * field_1461;
      float pp13 = (p5 - p10) * field_1462;
      float pp14 = (p6 - p9) * field_1463;
      float pp15 = (p7 - p8) * field_1464;
      p0 = pp0 + pp7;
      p1 = pp1 + pp6;
      p2 = pp2 + pp5;
      p3 = pp3 + pp4;
      p4 = (pp0 - pp7) * field_1465;
      p5 = (pp1 - pp6) * field_1466;
      p6 = (pp2 - pp5) * field_1467;
      p7 = (pp3 - pp4) * field_1468;
      p8 = pp8 + pp15;
      p9 = pp9 + pp14;
      p10 = pp10 + pp13;
      p11 = pp11 + pp12;
      p12 = (pp8 - pp15) * field_1465;
      p13 = (pp9 - pp14) * field_1466;
      p14 = (pp10 - pp13) * field_1467;
      p15 = (pp11 - pp12) * field_1468;
      pp0 = p0 + p3;
      pp1 = p1 + p2;
      pp2 = (p0 - p3) * ntvh;
      pp3 = (p1 - p2) * field_1469;
      pp4 = p4 + p7;
      pp5 = p5 + p6;
      pp6 = (p4 - p7) * ntvh;
      pp7 = (p5 - p6) * field_1469;
      pp8 = p8 + p11;
      pp9 = p9 + p10;
      pp10 = (p8 - p11) * ntvh;
      pp11 = (p9 - p10) * field_1469;
      pp12 = p12 + p15;
      pp13 = p13 + p14;
      pp14 = (p12 - p15) * ntvh;
      pp15 = (p13 - p14) * field_1469;
      p0 = pp0 + pp1;
      p1 = (pp0 - pp1) * field_1470;
      p2 = pp2 + pp3;
      p3 = (pp2 - pp3) * field_1470;
      p4 = pp4 + pp5;
      p5 = (pp4 - pp5) * field_1470;
      p6 = pp6 + pp7;
      p7 = (pp6 - pp7) * field_1470;
      p8 = pp8 + pp9;
      p9 = (pp8 - pp9) * field_1470;
      p10 = pp10 + pp11;
      p11 = (pp10 - pp11) * field_1470;
      p12 = pp12 + pp13;
      p13 = (pp12 - pp13) * field_1470;
      p14 = pp14 + pp15;
      p15 = (pp14 - pp15) * field_1470;
      new_v19 = -(new_v4 = p7 + p5) - p6;
      new_v27 = -p6 - p7 - p4;
      new_v6 = (new_v10 = p15 + p11) + p13;
      new_v17 = -(new_v2 = p15 + p13 + p9) - p14;
      float tmp1;
      new_v21 = (tmp1 = -p14 - p15 - p10 - p11) - p13;
      new_v29 = -p14 - p15 - p12 - p8;
      new_v25 = tmp1 - p12;
      new_v31 = -p0;
      new_v23 = -p3 - p2;
      p0 = (s0 - s31) * field_1441;
      float var140 = (s1 - s30) * field_1442;
      p2 = (s2 - s29) * field_1443;
      float var150 = (s3 - s28) * field_1444;
      p4 = (s4 - s27) * field_1445;
      p5 = (s5 - s26) * field_1446;
      p6 = (s6 - s25) * field_1447;
      float var170 = (s7 - s24) * field_1448;
      p8 = (s8 - s23) * field_1449;
      p9 = (s9 - s22) * field_1450;
      p10 = (s10 - s21) * field_1451;
      p11 = (s11 - s20) * field_1452;
      p12 = (s12 - s19) * field_1453;
      p13 = (s13 - s18) * field_1454;
      p14 = (s14 - s17) * field_1455;
      float var210 = (s15 - s16) * field_1456;
      pp0 = p0 + var210;
      pp1 = var140 + p14;
      pp2 = p2 + p13;
      pp3 = var150 + p12;
      pp4 = p4 + p11;
      pp5 = p5 + p10;
      pp6 = p6 + p9;
      pp7 = var170 + p8;
      pp8 = (p0 - var210) * field_1457;
      pp9 = (var140 - p14) * field_1458;
      pp10 = (p2 - p13) * field_1459;
      pp11 = (var150 - p12) * field_1460;
      pp12 = (p4 - p11) * field_1461;
      pp13 = (p5 - p10) * field_1462;
      pp14 = (p6 - p9) * field_1463;
      pp15 = (var170 - p8) * field_1464;
      p0 = pp0 + pp7;
      float var141 = pp1 + pp6;
      p2 = pp2 + pp5;
      float var151 = pp3 + pp4;
      p4 = (pp0 - pp7) * field_1465;
      p5 = (pp1 - pp6) * field_1466;
      p6 = (pp2 - pp5) * field_1467;
      float var171 = (pp3 - pp4) * field_1468;
      p8 = pp8 + pp15;
      p9 = pp9 + pp14;
      p10 = pp10 + pp13;
      p11 = pp11 + pp12;
      p12 = (pp8 - pp15) * field_1465;
      p13 = (pp9 - pp14) * field_1466;
      p14 = (pp10 - pp13) * field_1467;
      float var211 = (pp11 - pp12) * field_1468;
      pp0 = p0 + var151;
      pp1 = var141 + p2;
      pp2 = (p0 - var151) * ntvh;
      pp3 = (var141 - p2) * field_1469;
      pp4 = p4 + var171;
      pp5 = p5 + p6;
      pp6 = (p4 - var171) * ntvh;
      pp7 = (p5 - p6) * field_1469;
      pp8 = p8 + p11;
      pp9 = p9 + p10;
      pp10 = (p8 - p11) * ntvh;
      pp11 = (p9 - p10) * field_1469;
      pp12 = p12 + var211;
      pp13 = p13 + p14;
      pp14 = (p12 - var211) * ntvh;
      pp15 = (p13 - p14) * field_1469;
      p0 = pp0 + pp1;
      float var142 = (pp0 - pp1) * field_1470;
      p2 = pp2 + pp3;
      float var152 = (pp2 - pp3) * field_1470;
      p4 = pp4 + pp5;
      p5 = (pp4 - pp5) * field_1470;
      p6 = pp6 + pp7;
      float var172 = (pp6 - pp7) * field_1470;
      p8 = pp8 + pp9;
      p9 = (pp8 - pp9) * field_1470;
      p10 = pp10 + pp11;
      p11 = (pp10 - pp11) * field_1470;
      p12 = pp12 + pp13;
      p13 = (pp12 - pp13) * field_1470;
      p14 = pp14 + pp15;
      float var212 = (pp14 - pp15) * field_1470;
      new_v5 = (new_v11 = (new_v13 = var212 + var172) + p11) + p5 + p13;
      new_v7 = (new_v9 = var212 + p11 + var152) + p13;
      new_v16 = -(new_v1 = (tmp1 = p13 + var212 + p9) + var142) - p14;
      new_v18 = -(new_v3 = tmp1 + p5 + var172) - p6 - p14;
      new_v22 = (tmp1 = -p10 - p11 - p14 - var212) - p13 - p2 - var152;
      new_v20 = tmp1 - p13 - p5 - p6 - var172;
      new_v24 = tmp1 - p12 - p2 - var152;
      float tmp2;
      new_v26 = tmp1 - p12 - (tmp2 = p4 + p6 + var172);
      new_v30 = (tmp1 = -p8 - p12 - p14 - var212) - p0;
      new_v28 = tmp1 - tmp2;
      float[] dest = this.field_1433;
      int pos = this.field_1434;
      dest[0 + pos] = p1;
      dest[16 + pos] = new_v1;
      dest[32 + pos] = new_v2;
      dest[48 + pos] = new_v3;
      dest[64 + pos] = new_v4;
      dest[80 + pos] = new_v5;
      dest[96 + pos] = new_v6;
      dest[112 + pos] = new_v7;
      dest[128 + pos] = p3;
      dest[144 + pos] = new_v9;
      dest[160 + pos] = new_v10;
      dest[176 + pos] = new_v11;
      dest[192 + pos] = p7;
      dest[208 + pos] = new_v13;
      dest[224 + pos] = p15;
      dest[240 + pos] = var212;
      dest[256 + pos] = 0.0F;
      dest[272 + pos] = -var212;
      dest[288 + pos] = -p15;
      dest[304 + pos] = -new_v13;
      dest[320 + pos] = -p7;
      dest[336 + pos] = -new_v11;
      dest[352 + pos] = -new_v10;
      dest[368 + pos] = -new_v9;
      dest[384 + pos] = -p3;
      dest[400 + pos] = -new_v7;
      dest[416 + pos] = -new_v6;
      dest[432 + pos] = -new_v5;
      dest[448 + pos] = -new_v4;
      dest[464 + pos] = -new_v3;
      dest[480 + pos] = -new_v2;
      dest[496 + pos] = -new_v1;
      dest = this.field_1433 == this.field_1431 ? this.field_1432 : this.field_1431;
      dest[0 + pos] = -p1;
      dest[16 + pos] = new_v16;
      dest[32 + pos] = new_v17;
      dest[48 + pos] = new_v18;
      dest[64 + pos] = new_v19;
      dest[80 + pos] = new_v20;
      dest[96 + pos] = new_v21;
      dest[112 + pos] = new_v22;
      dest[128 + pos] = new_v23;
      dest[144 + pos] = new_v24;
      dest[160 + pos] = new_v25;
      dest[176 + pos] = new_v26;
      dest[192 + pos] = new_v27;
      dest[208 + pos] = new_v28;
      dest[224 + pos] = new_v29;
      dest[240 + pos] = new_v30;
      dest[256 + pos] = new_v31;
      dest[272 + pos] = new_v30;
      dest[288 + pos] = new_v29;
      dest[304 + pos] = new_v28;
      dest[320 + pos] = new_v27;
      dest[336 + pos] = new_v26;
      dest[352 + pos] = new_v25;
      dest[368 + pos] = new_v24;
      dest[384 + pos] = new_v23;
      dest[400 + pos] = new_v22;
      dest[416 + pos] = new_v21;
      dest[432 + pos] = new_v20;
      dest[448 + pos] = new_v19;
      dest[464 + pos] = new_v18;
      dest[480 + pos] = new_v17;
      dest[496 + pos] = new_v16;
   }

   // $VF: renamed from: wv () void
   private void method_1344() {
      float[] new_v = new float[32];
      float[] p = new float[16];
      float[] pp = new float[16];

      for (int i = 31; i >= 0; i--) {
         new_v[i] = 0.0F;
      }

      float[] x1 = this.field_1435;
      p[0] = x1[0] + x1[31];
      p[1] = x1[1] + x1[30];
      p[2] = x1[2] + x1[29];
      p[3] = x1[3] + x1[28];
      p[4] = x1[4] + x1[27];
      p[5] = x1[5] + x1[26];
      p[6] = x1[6] + x1[25];
      p[7] = x1[7] + x1[24];
      p[8] = x1[8] + x1[23];
      p[9] = x1[9] + x1[22];
      p[10] = x1[10] + x1[21];
      p[11] = x1[11] + x1[20];
      p[12] = x1[12] + x1[19];
      p[13] = x1[13] + x1[18];
      p[14] = x1[14] + x1[17];
      p[15] = x1[15] + x1[16];
      pp[0] = p[0] + p[15];
      pp[1] = p[1] + p[14];
      pp[2] = p[2] + p[13];
      pp[3] = p[3] + p[12];
      pp[4] = p[4] + p[11];
      pp[5] = p[5] + p[10];
      pp[6] = p[6] + p[9];
      pp[7] = p[7] + p[8];
      pp[8] = (p[0] - p[15]) * field_1457;
      pp[9] = (p[1] - p[14]) * field_1458;
      pp[10] = (p[2] - p[13]) * field_1459;
      pp[11] = (p[3] - p[12]) * field_1460;
      pp[12] = (p[4] - p[11]) * field_1461;
      pp[13] = (p[5] - p[10]) * field_1462;
      pp[14] = (p[6] - p[9]) * field_1463;
      pp[15] = (p[7] - p[8]) * field_1464;
      p[0] = pp[0] + pp[7];
      p[1] = pp[1] + pp[6];
      p[2] = pp[2] + pp[5];
      p[3] = pp[3] + pp[4];
      p[4] = (pp[0] - pp[7]) * field_1465;
      p[5] = (pp[1] - pp[6]) * field_1466;
      p[6] = (pp[2] - pp[5]) * field_1467;
      p[7] = (pp[3] - pp[4]) * field_1468;
      p[8] = pp[8] + pp[15];
      p[9] = pp[9] + pp[14];
      p[10] = pp[10] + pp[13];
      p[11] = pp[11] + pp[12];
      p[12] = (pp[8] - pp[15]) * field_1465;
      p[13] = (pp[9] - pp[14]) * field_1466;
      p[14] = (pp[10] - pp[13]) * field_1467;
      p[15] = (pp[11] - pp[12]) * field_1468;
      pp[0] = p[0] + p[3];
      pp[1] = p[1] + p[2];
      pp[2] = (p[0] - p[3]) * ntvh;
      pp[3] = (p[1] - p[2]) * field_1469;
      pp[4] = p[4] + p[7];
      pp[5] = p[5] + p[6];
      pp[6] = (p[4] - p[7]) * ntvh;
      pp[7] = (p[5] - p[6]) * field_1469;
      pp[8] = p[8] + p[11];
      pp[9] = p[9] + p[10];
      pp[10] = (p[8] - p[11]) * ntvh;
      pp[11] = (p[9] - p[10]) * field_1469;
      pp[12] = p[12] + p[15];
      pp[13] = p[13] + p[14];
      pp[14] = (p[12] - p[15]) * ntvh;
      pp[15] = (p[13] - p[14]) * field_1469;
      p[0] = pp[0] + pp[1];
      p[1] = (pp[0] - pp[1]) * field_1470;
      p[2] = pp[2] + pp[3];
      p[3] = (pp[2] - pp[3]) * field_1470;
      p[4] = pp[4] + pp[5];
      p[5] = (pp[4] - pp[5]) * field_1470;
      p[6] = pp[6] + pp[7];
      p[7] = (pp[6] - pp[7]) * field_1470;
      p[8] = pp[8] + pp[9];
      p[9] = (pp[8] - pp[9]) * field_1470;
      p[10] = pp[10] + pp[11];
      p[11] = (pp[10] - pp[11]) * field_1470;
      p[12] = pp[12] + pp[13];
      p[13] = (pp[12] - pp[13]) * field_1470;
      p[14] = pp[14] + pp[15];
      p[15] = (pp[14] - pp[15]) * field_1470;
      new_v[19] = -(new_v[4] = (new_v[12] = p[7]) + p[5]) - p[6];
      new_v[27] = -p[6] - p[7] - p[4];
      new_v[6] = (new_v[10] = (new_v[14] = p[15]) + p[11]) + p[13];
      new_v[17] = -(new_v[2] = p[15] + p[13] + p[9]) - p[14];
      float tmp1;
      new_v[21] = (tmp1 = -p[14] - p[15] - p[10] - p[11]) - p[13];
      new_v[29] = -p[14] - p[15] - p[12] - p[8];
      new_v[25] = tmp1 - p[12];
      new_v[31] = -p[0];
      new_v[0] = p[1];
      new_v[23] = -(new_v[8] = p[3]) - p[2];
      p[0] = (x1[0] - x1[31]) * field_1441;
      p[1] = (x1[1] - x1[30]) * field_1442;
      p[2] = (x1[2] - x1[29]) * field_1443;
      p[3] = (x1[3] - x1[28]) * field_1444;
      p[4] = (x1[4] - x1[27]) * field_1445;
      p[5] = (x1[5] - x1[26]) * field_1446;
      p[6] = (x1[6] - x1[25]) * field_1447;
      p[7] = (x1[7] - x1[24]) * field_1448;
      p[8] = (x1[8] - x1[23]) * field_1449;
      p[9] = (x1[9] - x1[22]) * field_1450;
      p[10] = (x1[10] - x1[21]) * field_1451;
      p[11] = (x1[11] - x1[20]) * field_1452;
      p[12] = (x1[12] - x1[19]) * field_1453;
      p[13] = (x1[13] - x1[18]) * field_1454;
      p[14] = (x1[14] - x1[17]) * field_1455;
      p[15] = (x1[15] - x1[16]) * field_1456;
      pp[0] = p[0] + p[15];
      pp[1] = p[1] + p[14];
      pp[2] = p[2] + p[13];
      pp[3] = p[3] + p[12];
      pp[4] = p[4] + p[11];
      pp[5] = p[5] + p[10];
      pp[6] = p[6] + p[9];
      pp[7] = p[7] + p[8];
      pp[8] = (p[0] - p[15]) * field_1457;
      pp[9] = (p[1] - p[14]) * field_1458;
      pp[10] = (p[2] - p[13]) * field_1459;
      pp[11] = (p[3] - p[12]) * field_1460;
      pp[12] = (p[4] - p[11]) * field_1461;
      pp[13] = (p[5] - p[10]) * field_1462;
      pp[14] = (p[6] - p[9]) * field_1463;
      pp[15] = (p[7] - p[8]) * field_1464;
      p[0] = pp[0] + pp[7];
      p[1] = pp[1] + pp[6];
      p[2] = pp[2] + pp[5];
      p[3] = pp[3] + pp[4];
      p[4] = (pp[0] - pp[7]) * field_1465;
      p[5] = (pp[1] - pp[6]) * field_1466;
      p[6] = (pp[2] - pp[5]) * field_1467;
      p[7] = (pp[3] - pp[4]) * field_1468;
      p[8] = pp[8] + pp[15];
      p[9] = pp[9] + pp[14];
      p[10] = pp[10] + pp[13];
      p[11] = pp[11] + pp[12];
      p[12] = (pp[8] - pp[15]) * field_1465;
      p[13] = (pp[9] - pp[14]) * field_1466;
      p[14] = (pp[10] - pp[13]) * field_1467;
      p[15] = (pp[11] - pp[12]) * field_1468;
      pp[0] = p[0] + p[3];
      pp[1] = p[1] + p[2];
      pp[2] = (p[0] - p[3]) * ntvh;
      pp[3] = (p[1] - p[2]) * field_1469;
      pp[4] = p[4] + p[7];
      pp[5] = p[5] + p[6];
      pp[6] = (p[4] - p[7]) * ntvh;
      pp[7] = (p[5] - p[6]) * field_1469;
      pp[8] = p[8] + p[11];
      pp[9] = p[9] + p[10];
      pp[10] = (p[8] - p[11]) * ntvh;
      pp[11] = (p[9] - p[10]) * field_1469;
      pp[12] = p[12] + p[15];
      pp[13] = p[13] + p[14];
      pp[14] = (p[12] - p[15]) * ntvh;
      pp[15] = (p[13] - p[14]) * field_1469;
      p[0] = pp[0] + pp[1];
      p[1] = (pp[0] - pp[1]) * field_1470;
      p[2] = pp[2] + pp[3];
      p[3] = (pp[2] - pp[3]) * field_1470;
      p[4] = pp[4] + pp[5];
      p[5] = (pp[4] - pp[5]) * field_1470;
      p[6] = pp[6] + pp[7];
      p[7] = (pp[6] - pp[7]) * field_1470;
      p[8] = pp[8] + pp[9];
      p[9] = (pp[8] - pp[9]) * field_1470;
      p[10] = pp[10] + pp[11];
      p[11] = (pp[10] - pp[11]) * field_1470;
      p[12] = pp[12] + pp[13];
      p[13] = (pp[12] - pp[13]) * field_1470;
      p[14] = pp[14] + pp[15];
      p[15] = (pp[14] - pp[15]) * field_1470;
      new_v[5] = (new_v[11] = (new_v[13] = (new_v[15] = p[15]) + p[7]) + p[11]) + p[5] + p[13];
      new_v[7] = (new_v[9] = p[15] + p[11] + p[3]) + p[13];
      new_v[16] = -(new_v[1] = (tmp1 = p[13] + p[15] + p[9]) + p[1]) - p[14];
      new_v[18] = -(new_v[3] = tmp1 + p[5] + p[7]) - p[6] - p[14];
      new_v[22] = (tmp1 = -p[10] - p[11] - p[14] - p[15]) - p[13] - p[2] - p[3];
      new_v[20] = tmp1 - p[13] - p[5] - p[6] - p[7];
      new_v[24] = tmp1 - p[12] - p[2] - p[3];
      float tmp2;
      new_v[26] = tmp1 - p[12] - (tmp2 = p[4] + p[6] + p[7]);
      new_v[30] = (tmp1 = -p[8] - p[12] - p[14] - p[15]) - p[0];
      new_v[28] = tmp1 - tmp2;
      float[] dest = this.field_1433;
      dest[0 + this.field_1434] = new_v[0];
      dest[16 + this.field_1434] = new_v[1];
      dest[32 + this.field_1434] = new_v[2];
      dest[48 + this.field_1434] = new_v[3];
      dest[64 + this.field_1434] = new_v[4];
      dest[80 + this.field_1434] = new_v[5];
      dest[96 + this.field_1434] = new_v[6];
      dest[112 + this.field_1434] = new_v[7];
      dest[128 + this.field_1434] = new_v[8];
      dest[144 + this.field_1434] = new_v[9];
      dest[160 + this.field_1434] = new_v[10];
      dest[176 + this.field_1434] = new_v[11];
      dest[192 + this.field_1434] = new_v[12];
      dest[208 + this.field_1434] = new_v[13];
      dest[224 + this.field_1434] = new_v[14];
      dest[240 + this.field_1434] = new_v[15];
      dest[256 + this.field_1434] = 0.0F;
      dest[272 + this.field_1434] = -new_v[15];
      dest[288 + this.field_1434] = -new_v[14];
      dest[304 + this.field_1434] = -new_v[13];
      dest[320 + this.field_1434] = -new_v[12];
      dest[336 + this.field_1434] = -new_v[11];
      dest[352 + this.field_1434] = -new_v[10];
      dest[368 + this.field_1434] = -new_v[9];
      dest[384 + this.field_1434] = -new_v[8];
      dest[400 + this.field_1434] = -new_v[7];
      dest[416 + this.field_1434] = -new_v[6];
      dest[432 + this.field_1434] = -new_v[5];
      dest[448 + this.field_1434] = -new_v[4];
      dest[464 + this.field_1434] = -new_v[3];
      dest[480 + this.field_1434] = -new_v[2];
      dest[496 + this.field_1434] = -new_v[1];
   }

   // $VF: renamed from: bkf (Class_278) void
   private void method_1345(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[0 + dvp] * dp[0]
                  + vp[15 + dvp] * dp[1]
                  + vp[14 + dvp] * dp[2]
                  + vp[13 + dvp] * dp[3]
                  + vp[12 + dvp] * dp[4]
                  + vp[11 + dvp] * dp[5]
                  + vp[10 + dvp] * dp[6]
                  + vp[9 + dvp] * dp[7]
                  + vp[8 + dvp] * dp[8]
                  + vp[7 + dvp] * dp[9]
                  + vp[6 + dvp] * dp[10]
                  + vp[5 + dvp] * dp[11]
                  + vp[4 + dvp] * dp[12]
                  + vp[3 + dvp] * dp[13]
                  + vp[2 + dvp] * dp[14]
                  + vp[1 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: zdo (Class_278) void
   private void method_1346(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[1 + dvp] * dp[0]
                  + vp[0 + dvp] * dp[1]
                  + vp[15 + dvp] * dp[2]
                  + vp[14 + dvp] * dp[3]
                  + vp[13 + dvp] * dp[4]
                  + vp[12 + dvp] * dp[5]
                  + vp[11 + dvp] * dp[6]
                  + vp[10 + dvp] * dp[7]
                  + vp[9 + dvp] * dp[8]
                  + vp[8 + dvp] * dp[9]
                  + vp[7 + dvp] * dp[10]
                  + vp[6 + dvp] * dp[11]
                  + vp[5 + dvp] * dp[12]
                  + vp[4 + dvp] * dp[13]
                  + vp[3 + dvp] * dp[14]
                  + vp[2 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: uzz (Class_278) void
   private void method_1347(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[2 + dvp] * dp[0]
                  + vp[1 + dvp] * dp[1]
                  + vp[0 + dvp] * dp[2]
                  + vp[15 + dvp] * dp[3]
                  + vp[14 + dvp] * dp[4]
                  + vp[13 + dvp] * dp[5]
                  + vp[12 + dvp] * dp[6]
                  + vp[11 + dvp] * dp[7]
                  + vp[10 + dvp] * dp[8]
                  + vp[9 + dvp] * dp[9]
                  + vp[8 + dvp] * dp[10]
                  + vp[7 + dvp] * dp[11]
                  + vp[6 + dvp] * dp[12]
                  + vp[5 + dvp] * dp[13]
                  + vp[4 + dvp] * dp[14]
                  + vp[3 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: yqs (Class_278) void
   private void method_1348(Class_278 buffer) {
      float[] vp = this.field_1433;
      int idx = 0;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[3 + dvp] * dp[0]
                  + vp[2 + dvp] * dp[1]
                  + vp[1 + dvp] * dp[2]
                  + vp[0 + dvp] * dp[3]
                  + vp[15 + dvp] * dp[4]
                  + vp[14 + dvp] * dp[5]
                  + vp[13 + dvp] * dp[6]
                  + vp[12 + dvp] * dp[7]
                  + vp[11 + dvp] * dp[8]
                  + vp[10 + dvp] * dp[9]
                  + vp[9 + dvp] * dp[10]
                  + vp[8 + dvp] * dp[11]
                  + vp[7 + dvp] * dp[12]
                  + vp[6 + dvp] * dp[13]
                  + vp[5 + dvp] * dp[14]
                  + vp[4 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   private void bwkp(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[4 + dvp] * dp[0]
                  + vp[3 + dvp] * dp[1]
                  + vp[2 + dvp] * dp[2]
                  + vp[1 + dvp] * dp[3]
                  + vp[0 + dvp] * dp[4]
                  + vp[15 + dvp] * dp[5]
                  + vp[14 + dvp] * dp[6]
                  + vp[13 + dvp] * dp[7]
                  + vp[12 + dvp] * dp[8]
                  + vp[11 + dvp] * dp[9]
                  + vp[10 + dvp] * dp[10]
                  + vp[9 + dvp] * dp[11]
                  + vp[8 + dvp] * dp[12]
                  + vp[7 + dvp] * dp[13]
                  + vp[6 + dvp] * dp[14]
                  + vp[5 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: mdr (Class_278) void
   private void method_1349(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[5 + dvp] * dp[0]
                  + vp[4 + dvp] * dp[1]
                  + vp[3 + dvp] * dp[2]
                  + vp[2 + dvp] * dp[3]
                  + vp[1 + dvp] * dp[4]
                  + vp[0 + dvp] * dp[5]
                  + vp[15 + dvp] * dp[6]
                  + vp[14 + dvp] * dp[7]
                  + vp[13 + dvp] * dp[8]
                  + vp[12 + dvp] * dp[9]
                  + vp[11 + dvp] * dp[10]
                  + vp[10 + dvp] * dp[11]
                  + vp[9 + dvp] * dp[12]
                  + vp[8 + dvp] * dp[13]
                  + vp[7 + dvp] * dp[14]
                  + vp[6 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: ufa (Class_278) void
   private void method_1350(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[6 + dvp] * dp[0]
                  + vp[5 + dvp] * dp[1]
                  + vp[4 + dvp] * dp[2]
                  + vp[3 + dvp] * dp[3]
                  + vp[2 + dvp] * dp[4]
                  + vp[1 + dvp] * dp[5]
                  + vp[0 + dvp] * dp[6]
                  + vp[15 + dvp] * dp[7]
                  + vp[14 + dvp] * dp[8]
                  + vp[13 + dvp] * dp[9]
                  + vp[12 + dvp] * dp[10]
                  + vp[11 + dvp] * dp[11]
                  + vp[10 + dvp] * dp[12]
                  + vp[9 + dvp] * dp[13]
                  + vp[8 + dvp] * dp[14]
                  + vp[7 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: auh (Class_278) void
   private void method_1351(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[7 + dvp] * dp[0]
                  + vp[6 + dvp] * dp[1]
                  + vp[5 + dvp] * dp[2]
                  + vp[4 + dvp] * dp[3]
                  + vp[3 + dvp] * dp[4]
                  + vp[2 + dvp] * dp[5]
                  + vp[1 + dvp] * dp[6]
                  + vp[0 + dvp] * dp[7]
                  + vp[15 + dvp] * dp[8]
                  + vp[14 + dvp] * dp[9]
                  + vp[13 + dvp] * dp[10]
                  + vp[12 + dvp] * dp[11]
                  + vp[11 + dvp] * dp[12]
                  + vp[10 + dvp] * dp[13]
                  + vp[9 + dvp] * dp[14]
                  + vp[8 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: tim (Class_278) void
   private void method_1352(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[8 + dvp] * dp[0]
                  + vp[7 + dvp] * dp[1]
                  + vp[6 + dvp] * dp[2]
                  + vp[5 + dvp] * dp[3]
                  + vp[4 + dvp] * dp[4]
                  + vp[3 + dvp] * dp[5]
                  + vp[2 + dvp] * dp[6]
                  + vp[1 + dvp] * dp[7]
                  + vp[0 + dvp] * dp[8]
                  + vp[15 + dvp] * dp[9]
                  + vp[14 + dvp] * dp[10]
                  + vp[13 + dvp] * dp[11]
                  + vp[12 + dvp] * dp[12]
                  + vp[11 + dvp] * dp[13]
                  + vp[10 + dvp] * dp[14]
                  + vp[9 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: sqq (Class_278) void
   private void method_1353(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[9 + dvp] * dp[0]
                  + vp[8 + dvp] * dp[1]
                  + vp[7 + dvp] * dp[2]
                  + vp[6 + dvp] * dp[3]
                  + vp[5 + dvp] * dp[4]
                  + vp[4 + dvp] * dp[5]
                  + vp[3 + dvp] * dp[6]
                  + vp[2 + dvp] * dp[7]
                  + vp[1 + dvp] * dp[8]
                  + vp[0 + dvp] * dp[9]
                  + vp[15 + dvp] * dp[10]
                  + vp[14 + dvp] * dp[11]
                  + vp[13 + dvp] * dp[12]
                  + vp[12 + dvp] * dp[13]
                  + vp[11 + dvp] * dp[14]
                  + vp[10 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: zlf (Class_278) void
   private void method_1354(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[10 + dvp] * dp[0]
                  + vp[9 + dvp] * dp[1]
                  + vp[8 + dvp] * dp[2]
                  + vp[7 + dvp] * dp[3]
                  + vp[6 + dvp] * dp[4]
                  + vp[5 + dvp] * dp[5]
                  + vp[4 + dvp] * dp[6]
                  + vp[3 + dvp] * dp[7]
                  + vp[2 + dvp] * dp[8]
                  + vp[1 + dvp] * dp[9]
                  + vp[0 + dvp] * dp[10]
                  + vp[15 + dvp] * dp[11]
                  + vp[14 + dvp] * dp[12]
                  + vp[13 + dvp] * dp[13]
                  + vp[12 + dvp] * dp[14]
                  + vp[11 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: eby (Class_278) void
   private void method_1355(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[11 + dvp] * dp[0]
                  + vp[10 + dvp] * dp[1]
                  + vp[9 + dvp] * dp[2]
                  + vp[8 + dvp] * dp[3]
                  + vp[7 + dvp] * dp[4]
                  + vp[6 + dvp] * dp[5]
                  + vp[5 + dvp] * dp[6]
                  + vp[4 + dvp] * dp[7]
                  + vp[3 + dvp] * dp[8]
                  + vp[2 + dvp] * dp[9]
                  + vp[1 + dvp] * dp[10]
                  + vp[0 + dvp] * dp[11]
                  + vp[15 + dvp] * dp[12]
                  + vp[14 + dvp] * dp[13]
                  + vp[13 + dvp] * dp[14]
                  + vp[12 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: dhq (Class_278) void
   private void method_1356(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[12 + dvp] * dp[0]
                  + vp[11 + dvp] * dp[1]
                  + vp[10 + dvp] * dp[2]
                  + vp[9 + dvp] * dp[3]
                  + vp[8 + dvp] * dp[4]
                  + vp[7 + dvp] * dp[5]
                  + vp[6 + dvp] * dp[6]
                  + vp[5 + dvp] * dp[7]
                  + vp[4 + dvp] * dp[8]
                  + vp[3 + dvp] * dp[9]
                  + vp[2 + dvp] * dp[10]
                  + vp[1 + dvp] * dp[11]
                  + vp[0 + dvp] * dp[12]
                  + vp[15 + dvp] * dp[13]
                  + vp[14 + dvp] * dp[14]
                  + vp[13 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: poi (Class_278) void
   private void method_1357(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[13 + dvp] * dp[0]
                  + vp[12 + dvp] * dp[1]
                  + vp[11 + dvp] * dp[2]
                  + vp[10 + dvp] * dp[3]
                  + vp[9 + dvp] * dp[4]
                  + vp[8 + dvp] * dp[5]
                  + vp[7 + dvp] * dp[6]
                  + vp[6 + dvp] * dp[7]
                  + vp[5 + dvp] * dp[8]
                  + vp[4 + dvp] * dp[9]
                  + vp[3 + dvp] * dp[10]
                  + vp[2 + dvp] * dp[11]
                  + vp[1 + dvp] * dp[12]
                  + vp[0 + dvp] * dp[13]
                  + vp[15 + dvp] * dp[14]
                  + vp[14 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: knp (Class_278) void
   private void method_1358(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[14 + dvp] * dp[0]
                  + vp[13 + dvp] * dp[1]
                  + vp[12 + dvp] * dp[2]
                  + vp[11 + dvp] * dp[3]
                  + vp[10 + dvp] * dp[4]
                  + vp[9 + dvp] * dp[5]
                  + vp[8 + dvp] * dp[6]
                  + vp[7 + dvp] * dp[7]
                  + vp[6 + dvp] * dp[8]
                  + vp[5 + dvp] * dp[9]
                  + vp[4 + dvp] * dp[10]
                  + vp[3 + dvp] * dp[11]
                  + vp[2 + dvp] * dp[12]
                  + vp[1 + dvp] * dp[13]
                  + vp[0 + dvp] * dp[14]
                  + vp[15 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: ygn (Class_278) void
   private void method_1359(Class_278 buffer) {
      float[] vp = this.field_1433;
      float[] tmpOut = this.field_1439;
      int dvp = 0;

      for (int i = 0; i < 32; i++) {
         float[] dp = field_1472[i];
         float pcm_sample = (
               vp[15 + dvp] * dp[0]
                  + vp[14 + dvp] * dp[1]
                  + vp[13 + dvp] * dp[2]
                  + vp[12 + dvp] * dp[3]
                  + vp[11 + dvp] * dp[4]
                  + vp[10 + dvp] * dp[5]
                  + vp[9 + dvp] * dp[6]
                  + vp[8 + dvp] * dp[7]
                  + vp[7 + dvp] * dp[8]
                  + vp[6 + dvp] * dp[9]
                  + vp[5 + dvp] * dp[10]
                  + vp[4 + dvp] * dp[11]
                  + vp[3 + dvp] * dp[12]
                  + vp[2 + dvp] * dp[13]
                  + vp[1 + dvp] * dp[14]
                  + vp[0 + dvp] * dp[15]
            )
            * this.field_1437;
         tmpOut[i] = pcm_sample;
         dvp += 16;
      }
   }

   // $VF: renamed from: jx (Class_278) void
   private void method_1360(Class_278 buffer) {
      switch (this.field_1434) {
         case 0:
            this.method_1345(buffer);
            break;
         case 1:
            this.method_1346(buffer);
            break;
         case 2:
            this.method_1347(buffer);
            break;
         case 3:
            this.method_1348(buffer);
            break;
         case 4:
            this.bwkp(buffer);
            break;
         case 5:
            this.method_1349(buffer);
            break;
         case 6:
            this.method_1350(buffer);
            break;
         case 7:
            this.method_1351(buffer);
            break;
         case 8:
            this.method_1352(buffer);
            break;
         case 9:
            this.method_1353(buffer);
            break;
         case 10:
            this.method_1354(buffer);
            break;
         case 11:
            this.method_1355(buffer);
            break;
         case 12:
            this.method_1356(buffer);
            break;
         case 13:
            this.method_1357(buffer);
            break;
         case 14:
            this.method_1358(buffer);
            break;
         case 15:
            this.method_1359(buffer);
      }

      if (buffer != null) {
         buffer.appendSamples(this.field_1436, this.field_1439);
      }
   }

   // $VF: renamed from: ife (Class_278) void
   public void method_1361(Class_278 buffer) {
      this.method_1343();
      this.method_1360(buffer);
      this.field_1434 = this.field_1434 + 1 & 15;
      this.field_1433 = this.field_1433 == this.field_1431 ? this.field_1432 : this.field_1431;

      for (int p = 0; p < 32; p++) {
         this.field_1435[p] = 0.0F;
      }
   }

   // $VF: renamed from: xr () float[]
   private static float[] method_1362() {
      try {
         Class elemType = float.class;
         Object o = Class_366.method_247("sfd.ser", elemType, 512);
         return (float[])o;
      } catch (IOException var2) {
         throw new ExceptionInInitializerError(var2);
      }
   }

   // $VF: renamed from: nu (float[], int) float[][]
   private static float[][] method_1363(float[] array, int blockSize) {
      int size = array.length / blockSize;
      float[][] split = new float[size][];

      for (int i = 0; i < size; i++) {
         split[i] = method_1364(array, i * blockSize, blockSize);
      }

      return split;
   }

   // $VF: renamed from: rk (float[], int, int) float[]
   private static float[] method_1364(float[] array, int offs, int len) {
      if (offs + len > array.length) {
         len = array.length - offs;
      }

      if (len < 0) {
         len = 0;
      }

      float[] subarray = new float[len];

      for (int i = 0; i < len; i++) {
         subarray[i] = array[offs + i];
      }

      return subarray;
   }
}
