public class Class_197 extends Class_278 {
   // $VF: renamed from: el short[]
   private short[] field_542 = new short[2304];
   // $VF: renamed from: lkv int[]
   private int[] field_543 = new int[2];
   // $VF: renamed from: ij int
   private int field_544;
   // $VF: renamed from: cv int
   private int field_545;

   public Class_197(int sample_frequency, int number_of_channels) {
      this.field_544 = number_of_channels;
      this.field_545 = sample_frequency;

      for (int i = 0; i < number_of_channels; i++) {
         this.field_543[i] = (short)i;
      }
   }

   // $VF: renamed from: iko () int
   public int method_589() {
      return this.field_544;
   }

   // $VF: renamed from: ig () int
   public int method_590() {
      return this.field_545;
   }

   // $VF: renamed from: shu () short[]
   public short[] method_591() {
      return this.field_542;
   }

   // $VF: renamed from: pxu () int
   public int method_592() {
      return this.field_543[0];
   }

   @Override
   public void append(int channel, short value) {
      this.field_542[this.field_543[channel]] = value;
      this.field_543[channel] = this.field_543[channel] + this.field_544;
   }

   @Override
   public void appendSamples(int channel, float[] f) {
      int pos = this.field_543[channel];

      for (int i = 0; i < 32; pos += this.field_544) {
         float fs = f[i++];
         fs = fs > 32767.0F ? 32767.0F : (fs < -32767.0F ? -32767.0F : fs);
         short s = (short)((int)fs);
         this.field_542[pos] = s;
      }

      this.field_543[channel] = pos;
   }

   @Override
   public void write_buffer(int val) {
   }

   @Override
   public void close() {
   }

   @Override
   public void clear_buffer() {
      for (int i = 0; i < this.field_544; i++) {
         this.field_543[i] = (short)i;
      }
   }

   @Override
   public void set_stop_flag() {
   }
}
