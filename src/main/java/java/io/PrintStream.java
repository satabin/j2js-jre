/*
 * Copyright (c) 2005 j2js.com,
 *
 * All Rights Reserved. This work is distributed under the j2js Software License [1]
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.
 *
 * [1] http://www.j2js.com/license.txt
 */

package java.io;

/**
 * A PrintStream adds functionality to another output stream, namely the ability to print representations
 * of various data values conveniently.
 * 
 * @author j2js.com
 */
public class PrintStream extends OutputStream {

    private boolean errorState = false;
    private OutputStream out;
    
    public PrintStream(OutputStream theOut) {
        out = theOut;
    }

    public void flush() {
        try {
            out.flush();
        } catch (IOException e) {
            setError();
        }
    }

    public void close() {
        out.close();
    }

    public boolean checkError() {
        flush();
        return errorState;
    }

    /**
     * Indicate that an error has occurred.
     */
    protected void setError() {
        errorState = true;   
    }

    public void write(int b) {
        try {
            out.write(b);
        } catch (IOException e) {
            setError();
        }   
    }

    public void write(byte[] buf, int off, int len) {
        try {
            out.write(buf, off, len);
        } catch (IOException e) {
            setError();
        }
    }
    
    public void write(String str) {
        try {
            out.write(str);
        } catch (IOException e) {
            setError();
        }
    }

    public void print(boolean b) {
        print(String.valueOf(b));
    }

    public void print(char c) {
        print(String.valueOf(c));
    }

    public void print(int i) {
        print(String.valueOf(i));   
    }

    public void print(long l) {
        print(String.valueOf(l));   
    }

    public void print(float f) {
        print(String.valueOf(f));   
    }

    public void print(double d) {
        print(String.valueOf(d));   
    }

    public void print(char[] buf) {
        String s = new String(buf);
        print(s); 
    }

    public void print(String s) {
        try {
            out.write(s);
        } catch (IOException e) {
            setError();
        }
    }

    public void print(Object obj) {
        if (obj == null) print("null");
        else print(obj.toString());
    }

    public void println() {
        print("\n");
    }

    public void println(boolean x) {
        print(x);
        println();
    }

    public void println(char x) {
        print(x);
        println();
    }

    public void println(int x) {
        print(x);
        println();
    }

    public void println(long x) {
        print(x);
        println();
    }

    public void println(float x) {
        print(x);
        println();
    }

    public void println(double x) {
        print(x);
        println();
    }

    public void println(char[] x) {
        print(x);
        println();
    }

    public void println(java.lang.String x) {
        print(x);
        println();
    }

    public void println(java.lang.Object x) {
        print(x);
        println();
    }
}
