1. An object can always be reused if it is immutable.
2. `String.matches( )` is easiest way to check if a string matches a regular expression, it is not suitable for repeated use in performance-critical situations. Consider using examples.      
   E.g.1:
   
       // Performance can be greatly improved!
       static boolean isRomanNumeral(String s) {
           return s.matches("^(?=.)M*(([MD|D?C{0,3}X[CL]|L?X{0,3})(I[XV]|V?I{0,3}(I[XV]|v?I{0,3})$");
       } 
       
       // String.matcher calls and creates Pattern instance internally 
   
   E.g.2:           
   
       // Reusing expensive object for improved performance!
       public class RomanNumerals {
           private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(([MD|D?C{0,3}X[CL]|L?X{0,3})(I[XV]|V?I{0,3}(I[XV]|v?I{0,3})$");
           
           static boolean isRomanNumeral(String s) {
               return ROMAN.matcher(s).matches();
           }
       }  
      
3. Autoboxing blurs but doesn't erase the distinction between primitive and boxed primitive types.          
   E.g.:
   
       // Hideously slow!
       private static long sum( ) {
           Long sum = 0L;   // slowing line.
           for(long i = 0; i <= Integer.MAX_VALUE; i++) {
               sum += i;
           }
           
           return sum;
       }

4. Prefer primitives over boxed primitives, and watch our for unintentional autoboxing.
