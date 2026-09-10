class Class_323 extends Class_153 implements Class_186 {
   public Class_323() {
   }

   @Override
   protected void createSubbands() {
      if (this.mode == 3) {
         for (int i = 0; i < this.num_subbands; i++) {
            this.subbands[i] = new Class_257(i);
         }
      } else if (this.mode == 1) {
         int i;
         for (i = 0; i < this.header.method_75(); i++) {
            this.subbands[i] = new Class_22(i);
         }

         while (i < this.num_subbands) {
            this.subbands[i] = new Class_406(i);
            i++;
         }
      } else {
         for (int i = 0; i < this.num_subbands; i++) {
            this.subbands[i] = new Class_22(i);
         }
      }
   }

   @Override
   protected void readScaleFactorSelection() {
      for (int i = 0; i < this.num_subbands; i++) {
         ((Class_257)this.subbands[i]).method_1315(this.stream, this.crc);
      }
   }
}
