class Class_175 {
   // $VF: renamed from: nob int
   public int field_566;
   // $VF: renamed from: tdh int
   public int field_567;
   // $VF: renamed from: xca boolean
   public boolean field_568;
   // $VF: renamed from: vsi float
   public float field_569;
   // $VF: renamed from: vw java.lang.String
   public String field_570;
   // $VF: renamed from: uwe java.lang.String
   public String field_571;
   // $VF: renamed from: hew boolean
   public boolean field_572;
   // $VF: renamed from: hri int
   public int field_573 = 3;

   public Class_175() {
      this.field_566 = 0;
      this.field_568 = false;
      this.field_569 = 32768.0F;
      this.field_572 = false;
   }

   // $VF: renamed from: zdd (java.lang.String[]) boolean
   public boolean method_617(String[] argv) {
      this.field_571 = null;
      Class_273[] crc = new Class_273[1];
      int argc = argv.length;
      this.field_572 = false;
      this.field_567 = 0;
      this.field_570 = "";
      if (argc >= 2 && !argv[1].equals("-h")) {
         for (int i = 1; i < argc; i++) {
            if (argv[i].charAt(0) == '-') {
               if (argv[i].startsWith("-v")) {
                  this.field_572 = true;
                  if (argv[i].length() > 2) {
                     try {
                        String level = argv[i].substring(2);
                        this.field_573 = Integer.parseInt(level);
                     } catch (NumberFormatException var6) {
                        System.err.println("Invalid verbose level. Using default.");
                     }
                  }

                  System.out.println("Verbose Activated (level " + this.field_573 + ")");
               } else {
                  if (!argv[i].equals("-p")) {
                     return this.method_618();
                  }

                  if (++i == argc) {
                     System.out.println("Please specify an output filename after the -p option!");
                     System.exit(1);
                  }

                  this.field_570 = argv[i];
               }
            } else {
               this.field_571 = argv[i];
               System.out.println("FileName = " + argv[i]);
               if (this.field_571 == null) {
                  return this.method_618();
               }
            }
         }

         return this.field_571 == null ? this.method_618() : true;
      } else {
         return this.method_618();
      }
   }

   // $VF: renamed from: uhv () boolean
   public boolean method_618() {
      System.out.println("JavaLayer Converter :");
      System.out.println("  -v[x]         verbose mode. ");
      System.out.println("                default = 2");
      System.out.println("  -p name    output as a PCM wave file");
      System.out.println("");
      System.out.println("  More info on http://www.javazoom.net");
      return false;
   }
}
