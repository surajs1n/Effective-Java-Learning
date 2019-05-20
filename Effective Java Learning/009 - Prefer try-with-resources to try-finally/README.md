1. Prefer using `try-with-resources` to `try-with-finally` in case of classes utilizing resources which are supposed to be closed manually, e.g.:- `InputStream`, `OutputStream` and `java.sql.Connection`.
 
    Following are two example explaining few of points one by one.
   
    E.g. :- 1
    Try-finally approach:
        
        static String firstLineOfFile(String path) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader(path));
            try {
                return br.readLine();
            } finally {
                br.close();
            }
        } 
        
    Try-with-resources:
    
        static String firstLineOfFile(String path) throws IOException {
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                br.readLine();
            }
        }   
        
    E.g. :- 2 Try-finally approach:
    
        static void copy(String src, String dst) throws IOException {
            InputStream in = new FileInputStream(src);
            try {
                OutputStream out = new FileOutputStream(dst);
                try {
                    byte [] buf = new byte[BUFFER_SIZE];
                    int n;
                    while((n = in.read(buf)) >= 0) {
                        out.write(buf, 0, n);
                    }
                } finally {
                    out.close();
                }
            } finally {
                in.close();
            }
        }
    
    Try-with-resources approach:
    
        static void copy(String src, String dst) throws IOException {
            try (InputStream in   = new FileInputStream(src); 
                 OutputStream out = new FileOutStream(dst);  ) {
                byte [] buf = new byte[BUFFER_SIZE];
                int n;
                while((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            }
        }
        
2. Code written with `try-with-resources` are catchy compare to `try-with-finally`.
3. `try-with-resources` gets the first failed exception in the series of contagious similar exceptions, rest remaining will also be shown with suppressed tag in them. Consider the case of E.g. :- 1 try-with-finally block, where `br.readLine()` fails to execute due to some physical connection problem, in the end the control flow will end up in its corresponding finally block `br.close`, which will again fail due to the same issue. During, debugging only the last exception stack will be printed which will give mis-leading message to individual who is debugging.      
4. To be able to use `try-with-resources` clause, interface/class has to extend/implement `AutoCloseable` interface.