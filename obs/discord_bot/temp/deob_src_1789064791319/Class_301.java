public class Class_301 extends Class_278 {
   // $VF: renamed from: el short[]
   private short[] field_537;
   // $VF: renamed from: ld short[]
   private short[] field_538;
   // $VF: renamed from: ij int
   private int field_539;
   // $VF: renamed from: nnc Class_120
   private Class_120 field_540;
   // $VF: renamed from: lae short[]
   short[] field_541 = new short[2];

   public Class_301(int number_of_channels, int freq, String FileName) {
      if (FileName == null) {
         throw new NullPointerException("FileName");
      } else {
         this.field_537 = new short[2304];
         this.field_538 = new short[2];
         this.field_539 = number_of_channels;

         for (int i = 0; i < number_of_channels; i++) {
            this.field_538[i] = (short)i;
         }

         this.field_540 = new Class_120();
         int rc = this.field_540.method_724(FileName, freq, (short)16, (short)this.field_539);
      }
   }

   @Override
   public void append(int channel, short value) {
      this.field_537[this.field_538[channel]] = value;
      this.field_538[channel] = (short)(this.field_538[channel] + this.field_539);
   }

   @Override
   public void write_buffer(int val) {
      int k = 0;
      int rc = 0;
      rc = this.field_540.method_725(this.field_537, this.field_538[0]);

      for (int i = 0; i < this.field_539; i++) {
         this.field_538[i] = (short)i;
      }
   }

   @Override
   public void close() {
      this.field_540.method_717();
   }

   @Override
   public void clear_buffer() {
   }

   @Override
   public void set_stop_flag() {
   }
}
