/**
 * Class:    InvMDCT<br/>
 * <br/>
 * Created:  04.12.2019<br/>
 * Filename: InvMDCT.java<br/>
 * Version:  $Revision$<br/>
 * <br/>
 * last modified on $Date$<br/>
 *               by $Author$<br/>
 * <br/>
 * @author <a href="mailto:sebastian.weiss@nacamar.de">Sebastian A. Weiss, nacamar GmbH</a>
 * @version $Author$ -- $Revision$ -- $Date$
 * <br/>
 * (c) Sebastian A. Weiss, nacamar GmbH 2019 - All rights reserved.
 */
package net.addradio.decoder.math;

/**
 * InvMDCT.
 */
public final class InvMDCT {

    /** {@code float[][]} win. */
    public static final float win[][] = { //
            { //
                    -1.6141214951E-02f, -5.3603178919E-02f, -1.0070713296E-01f, -1.6280817573E-01f, //
                    -4.9999999679E-01f, -3.8388735032E-01f, -6.2061144372E-01f, -1.1659756083E+00f, //
                    -3.8720752656E+00f, -4.2256286556E+00f, -1.5195289984E+00f, -9.7416483388E-01f, //
                    -7.3744074053E-01f, -1.2071067773E+00f, -5.1636156596E-01f, -4.5426052317E-01f, //
                    -4.0715656898E-01f, -3.6969460527E-01f, -3.3876269197E-01f, -3.1242222492E-01f, //
                    -2.8939587111E-01f, -2.6880081906E-01f, -5.0000000266E-01f, -2.3251417468E-01f, //
                    -2.1596714708E-01f, -2.0004979098E-01f, -1.8449493497E-01f, -1.6905846094E-01f, //
                    -1.5350360518E-01f, -1.3758624925E-01f, -1.2103922149E-01f, -2.0710679058E-01f, //
                    -8.4752577594E-02f, -6.4157525656E-02f, -4.1131172614E-02f, -1.4790705759E-02f },

            { //
                    -1.6141214951E-02f, -5.3603178919E-02f, -1.0070713296E-01f, -1.6280817573E-01f, //
                    -4.9999999679E-01f, -3.8388735032E-01f, -6.2061144372E-01f, -1.1659756083E+00f, //
                    -3.8720752656E+00f, -4.2256286556E+00f, -1.5195289984E+00f, -9.7416483388E-01f, //
                    -7.3744074053E-01f, -1.2071067773E+00f, -5.1636156596E-01f, -4.5426052317E-01f, //
                    -4.0715656898E-01f, -3.6969460527E-01f, -3.3908542600E-01f, -3.1511810350E-01f, //
                    -2.9642226150E-01f, -2.8184548650E-01f, -5.4119610000E-01f, -2.6213228100E-01f, //
                    -2.5387916537E-01f, -2.3296291359E-01f, -1.9852728987E-01f, -1.5233534808E-01f, //
                    -9.6496400054E-02f, -3.3423828516E-02f, 0.0000000000E+00f, 0.0000000000E+00f, //
                    0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f },

            { //
                    -4.8300800645E-02f, -1.5715656932E-01f, -2.8325045177E-01f, -4.2953747763E-01f, //
                    -1.2071067795E+00f, -8.2426483178E-01f, -1.1451749106E+00f, -1.7695290101E+00f, //
                    -4.5470225061E+00f, -3.4890531002E+00f, -7.3296292804E-01f, -1.5076514758E-01f, //
                    0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f, //
                    0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f, //
                    0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f, //
                    0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f, //
                    0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f, //
                    0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f },

            { //
                    0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f, 0.0000000000E+00f, //
                    0.0000000000E+00f, 0.0000000000E+00f, -1.5076513660E-01f, -7.3296291107E-01f, //
                    -3.4890530566E+00f, -4.5470224727E+00f, -1.7695290031E+00f, -1.1451749092E+00f, //
                    -8.3137738100E-01f, -1.3065629650E+00f, -5.4142014250E-01f, -4.6528974900E-01f, //
                    -4.1066990750E-01f, -3.7004680800E-01f, -3.3876269197E-01f, -3.1242222492E-01f, //
                    -2.8939587111E-01f, -2.6880081906E-01f, -5.0000000266E-01f, -2.3251417468E-01f, //
                    -2.1596714708E-01f, -2.0004979098E-01f, -1.8449493497E-01f, -1.6905846094E-01f, //
                    -1.5350360518E-01f, -1.3758624925E-01f, -1.2103922149E-01f, -2.0710679058E-01f, //
                    -8.4752577594E-02f, -6.4157525656E-02f, -4.1131172614E-02f, -1.4790705759E-02f } };

    /**
     * inv_mdct.
     * @param in {@code float[]}
     * @param out {@code float[]}
     * @param block_type {@code int}
     */
    public static final void inv_mdct(final float[] in, final float[] out, final int block_type) {
        float[] win_bt;
        int i;

        float tmpf_0, tmpf_1, tmpf_2, tmpf_3, tmpf_4, tmpf_5, tmpf_6, tmpf_7, tmpf_8, tmpf_9;
        float tmpf_10, tmpf_11, tmpf_12, tmpf_13, tmpf_14, tmpf_15, tmpf_16, tmpf_17;

        tmpf_0 = tmpf_1 = tmpf_2 = tmpf_3 = tmpf_4 = tmpf_5 = tmpf_6 = tmpf_7 = tmpf_8 = tmpf_9 = tmpf_10 = tmpf_11 = tmpf_12 = tmpf_13 = tmpf_14 = tmpf_15 = tmpf_16 = tmpf_17 = 0.0f;

        if (block_type == 2) {

            /*
             *
             *      Under MicrosoftVM 2922, This causes a GPF, or
             *      At best, an ArrayIndexOutOfBoundsExceptin.
            for(int p=0;p<36;p+=9)
                   {
              out[p]   = out[p+1] = out[p+2] = out[p+3] =
              out[p+4] = out[p+5] = out[p+6] = out[p+7] =
              out[p+8] = 0.0f;
                   }
            */

            for (int j = 0; j < out.length; j++) {
                out[j] = 0.0f;
            }

            int six_i = 0;

            for (i = 0; i < 3; i++) {
                // 12 point IMDCT
                // Begin 12 point IDCT
                // Input aliasing for 12 pt IDCT
                in[15 + i] += in[12 + i];
                in[12 + i] += in[9 + i];
                in[9 + i] += in[6 + i];
                in[6 + i] += in[3 + i];
                in[3 + i] += in[0 + i];

                // Input aliasing on odd indices (for 6 point IDCT)
                in[15 + i] += in[9 + i];
                in[9 + i] += in[3 + i];

                // 3 point IDCT on even indices
                float pp1, pp2, sum;
                pp2 = in[12 + i] * 0.500000000f;
                pp1 = in[6 + i] * 0.866025403f;
                sum = in[0 + i] + pp2;
                tmpf_1 = in[0 + i] - in[12 + i];
                tmpf_0 = sum + pp1;
                tmpf_2 = sum - pp1;

                // End 3 point IDCT on even indices
                // 3 point IDCT on odd indices (for 6 point IDCT)
                pp2 = in[15 + i] * 0.500000000f;
                pp1 = in[9 + i] * 0.866025403f;
                sum = in[3 + i] + pp2;
                tmpf_4 = in[3 + i] - in[15 + i];
                tmpf_5 = sum + pp1;
                tmpf_3 = sum - pp1;
                // End 3 point IDCT on odd indices
                // Twiddle factors on odd indices (for 6 point IDCT)

                tmpf_3 *= 1.931851653f;
                tmpf_4 *= 0.707106781f;
                tmpf_5 *= 0.517638090f;

                // Output butterflies on 2 3 point IDCT's (for 6 point IDCT)
                float save = tmpf_0;
                tmpf_0 += tmpf_5;
                tmpf_5 = save - tmpf_5;
                save = tmpf_1;
                tmpf_1 += tmpf_4;
                tmpf_4 = save - tmpf_4;
                save = tmpf_2;
                tmpf_2 += tmpf_3;
                tmpf_3 = save - tmpf_3;

                // End 6 point IDCT
                // Twiddle factors on indices (for 12 point IDCT)

                tmpf_0 *= 0.504314480f;
                tmpf_1 *= 0.541196100f;
                tmpf_2 *= 0.630236207f;
                tmpf_3 *= 0.821339815f;
                tmpf_4 *= 1.306562965f;
                tmpf_5 *= 3.830648788f;

                // End 12 point IDCT

                // Shift to 12 point modified IDCT, multiply by window type 2
                tmpf_8 = -tmpf_0 * 0.793353340f;
                tmpf_9 = -tmpf_0 * 0.608761429f;
                tmpf_7 = -tmpf_1 * 0.923879532f;
                tmpf_10 = -tmpf_1 * 0.382683432f;
                tmpf_6 = -tmpf_2 * 0.991444861f;
                tmpf_11 = -tmpf_2 * 0.130526192f;

                tmpf_0 = tmpf_3;
                tmpf_1 = tmpf_4 * 0.382683432f;
                tmpf_2 = tmpf_5 * 0.608761429f;

                tmpf_3 = -tmpf_5 * 0.793353340f;
                tmpf_4 = -tmpf_4 * 0.923879532f;
                tmpf_5 = -tmpf_0 * 0.991444861f;

                tmpf_0 *= 0.130526192f;

                out[six_i + 6] += tmpf_0;
                out[six_i + 7] += tmpf_1;
                out[six_i + 8] += tmpf_2;
                out[six_i + 9] += tmpf_3;
                out[six_i + 10] += tmpf_4;
                out[six_i + 11] += tmpf_5;
                out[six_i + 12] += tmpf_6;
                out[six_i + 13] += tmpf_7;
                out[six_i + 14] += tmpf_8;
                out[six_i + 15] += tmpf_9;
                out[six_i + 16] += tmpf_10;
                out[six_i + 17] += tmpf_11;

                six_i += 6;
            }
        } else {
            // 36 point IDCT
            // input aliasing for 36 point IDCT
            in[17] += in[16];
            in[16] += in[15];
            in[15] += in[14];
            in[14] += in[13];
            in[13] += in[12];
            in[12] += in[11];
            in[11] += in[10];
            in[10] += in[9];
            in[9] += in[8];
            in[8] += in[7];
            in[7] += in[6];
            in[6] += in[5];
            in[5] += in[4];
            in[4] += in[3];
            in[3] += in[2];
            in[2] += in[1];
            in[1] += in[0];

            // 18 point IDCT for odd indices
            // input aliasing for 18 point IDCT
            in[17] += in[15];
            in[15] += in[13];
            in[13] += in[11];
            in[11] += in[9];
            in[9] += in[7];
            in[7] += in[5];
            in[5] += in[3];
            in[3] += in[1];

            float tmp0, tmp1, tmp2, tmp3, tmp4, tmp0_, tmp1_, tmp2_, tmp3_;
            float tmp0o, tmp1o, tmp2o, tmp3o, tmp4o, tmp0_o, tmp1_o, tmp2_o, tmp3_o;

            // Fast 9 Point Inverse Discrete Cosine Transform
            //
            // By  Francois-Raymond Boyer
            //         mailto:boyerf@iro.umontreal.ca
            //         http://www.iro.umontreal.ca/~boyerf
            //
            // The code has been optimized for Intel processors
            //  (takes a lot of time to convert float to and from iternal FPU representation)
            //
            // It is a simple "factorization" of the IDCT matrix.

            // 9 point IDCT on even indices

            // 5 points on odd indices (not realy an IDCT)
            final float i00 = in[0] + in[0];
            final float iip12 = i00 + in[12];

            tmp0 = iip12 + (in[4] * 1.8793852415718f) + (in[8] * 1.532088886238f) + (in[16] * 0.34729635533386f);
            tmp1 = (i00 + in[4]) - in[8] - in[12] - in[12] - in[16];
            tmp2 = (iip12 - (in[4] * 0.34729635533386f) - (in[8] * 1.8793852415718f)) + (in[16] * 1.532088886238f);
            tmp3 = ((iip12 - (in[4] * 1.532088886238f)) + (in[8] * 0.34729635533386f)) - (in[16] * 1.8793852415718f);
            tmp4 = (((in[0] - in[4]) + in[8]) - in[12]) + in[16];

            // 4 points on even indices
            final float i66_ = in[6] * 1.732050808f; // Sqrt[3]

            tmp0_ = (in[2] * 1.9696155060244f) + i66_ + (in[10] * 1.2855752193731f) + (in[14] * 0.68404028665134f);
            tmp1_ = (in[2] - in[10] - in[14]) * 1.732050808f;
            tmp2_ = ((in[2] * 1.2855752193731f) - i66_ - (in[10] * 0.68404028665134f)) + (in[14] * 1.9696155060244f);
            tmp3_ = (((in[2] * 0.68404028665134f) - i66_) + (in[10] * 1.9696155060244f)) - (in[14] * 1.2855752193731f);

            // 9 point IDCT on odd indices
            // 5 points on odd indices (not realy an IDCT)
            final float i0 = in[0 + 1] + in[0 + 1];
            final float i0p12 = i0 + in[12 + 1];

            tmp0o = i0p12 + (in[4 + 1] * 1.8793852415718f) + (in[8 + 1] * 1.532088886238f)
                    + (in[16 + 1] * 0.34729635533386f);
            tmp1o = (i0 + in[4 + 1]) - in[8 + 1] - in[12 + 1] - in[12 + 1] - in[16 + 1];
            tmp2o = (i0p12 - (in[4 + 1] * 0.34729635533386f) - (in[8 + 1] * 1.8793852415718f))
                    + (in[16 + 1] * 1.532088886238f);
            tmp3o = ((i0p12 - (in[4 + 1] * 1.532088886238f)) + (in[8 + 1] * 0.34729635533386f))
                    - (in[16 + 1] * 1.8793852415718f);
            tmp4o = ((((in[0 + 1] - in[4 + 1]) + in[8 + 1]) - in[12 + 1]) + in[16 + 1]) * 0.707106781f; // Twiddled

            // 4 points on even indices
            final float i6_ = in[6 + 1] * 1.732050808f; // Sqrt[3]

            tmp0_o = (in[2 + 1] * 1.9696155060244f) + i6_ + (in[10 + 1] * 1.2855752193731f)
                    + (in[14 + 1] * 0.68404028665134f);
            tmp1_o = (in[2 + 1] - in[10 + 1] - in[14 + 1]) * 1.732050808f;
            tmp2_o = ((in[2 + 1] * 1.2855752193731f) - i6_ - (in[10 + 1] * 0.68404028665134f))
                    + (in[14 + 1] * 1.9696155060244f);
            tmp3_o = (((in[2 + 1] * 0.68404028665134f) - i6_) + (in[10 + 1] * 1.9696155060244f))
                    - (in[14 + 1] * 1.2855752193731f);

            // Twiddle factors on odd indices
            // and
            // Butterflies on 9 point IDCT's
            // and
            // twiddle factors for 36 point IDCT

            float e, o;
            e = tmp0 + tmp0_;
            o = (tmp0o + tmp0_o) * 0.501909918f;
            tmpf_0 = e + o;
            tmpf_17 = e - o;
            e = tmp1 + tmp1_;
            o = (tmp1o + tmp1_o) * 0.517638090f;
            tmpf_1 = e + o;
            tmpf_16 = e - o;
            e = tmp2 + tmp2_;
            o = (tmp2o + tmp2_o) * 0.551688959f;
            tmpf_2 = e + o;
            tmpf_15 = e - o;
            e = tmp3 + tmp3_;
            o = (tmp3o + tmp3_o) * 0.610387294f;
            tmpf_3 = e + o;
            tmpf_14 = e - o;
            tmpf_4 = tmp4 + tmp4o;
            tmpf_13 = tmp4 - tmp4o;
            e = tmp3 - tmp3_;
            o = (tmp3o - tmp3_o) * 0.871723397f;
            tmpf_5 = e + o;
            tmpf_12 = e - o;
            e = tmp2 - tmp2_;
            o = (tmp2o - tmp2_o) * 1.183100792f;
            tmpf_6 = e + o;
            tmpf_11 = e - o;
            e = tmp1 - tmp1_;
            o = (tmp1o - tmp1_o) * 1.931851653f;
            tmpf_7 = e + o;
            tmpf_10 = e - o;
            e = tmp0 - tmp0_;
            o = (tmp0o - tmp0_o) * 5.736856623f;
            tmpf_8 = e + o;
            tmpf_9 = e - o;

            // end 36 point IDCT */
            // shift to modified IDCT
            win_bt = win[block_type];

            out[0] = -tmpf_9 * win_bt[0];
            out[1] = -tmpf_10 * win_bt[1];
            out[2] = -tmpf_11 * win_bt[2];
            out[3] = -tmpf_12 * win_bt[3];
            out[4] = -tmpf_13 * win_bt[4];
            out[5] = -tmpf_14 * win_bt[5];
            out[6] = -tmpf_15 * win_bt[6];
            out[7] = -tmpf_16 * win_bt[7];
            out[8] = -tmpf_17 * win_bt[8];
            out[9] = tmpf_17 * win_bt[9];
            out[10] = tmpf_16 * win_bt[10];
            out[11] = tmpf_15 * win_bt[11];
            out[12] = tmpf_14 * win_bt[12];
            out[13] = tmpf_13 * win_bt[13];
            out[14] = tmpf_12 * win_bt[14];
            out[15] = tmpf_11 * win_bt[15];
            out[16] = tmpf_10 * win_bt[16];
            out[17] = tmpf_9 * win_bt[17];
            out[18] = tmpf_8 * win_bt[18];
            out[19] = tmpf_7 * win_bt[19];
            out[20] = tmpf_6 * win_bt[20];
            out[21] = tmpf_5 * win_bt[21];
            out[22] = tmpf_4 * win_bt[22];
            out[23] = tmpf_3 * win_bt[23];
            out[24] = tmpf_2 * win_bt[24];
            out[25] = tmpf_1 * win_bt[25];
            out[26] = tmpf_0 * win_bt[26];
            out[27] = tmpf_0 * win_bt[27];
            out[28] = tmpf_1 * win_bt[28];
            out[29] = tmpf_2 * win_bt[29];
            out[30] = tmpf_3 * win_bt[30];
            out[31] = tmpf_4 * win_bt[31];
            out[32] = tmpf_5 * win_bt[32];
            out[33] = tmpf_6 * win_bt[33];
            out[34] = tmpf_7 * win_bt[34];
            out[35] = tmpf_8 * win_bt[35];
        }
    }

    /**
     * InvMDCT constructor.
     */
    private InvMDCT() {
    }

}
